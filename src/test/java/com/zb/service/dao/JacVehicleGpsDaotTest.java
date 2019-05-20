package com.zb.service.dao;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.zb.service.entity.JacAlarmRecord;
import com.zb.service.entity.JacVehicleGps;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by bzheng on 2019/1/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Ignore
public class JacVehicleGpsDaotTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    JacVehicleGpsDao jacVehicleGpsDao;

    @Autowired
    JacAlarmRecordDao jacAlarmRecordDao;

    private static Date now;

    private static String username;

    static {
        now = new Date();
        username = "system";
    }
    /**
     * 40条线程
     */
    private static final int THREAD_NUMBER = 100;

    CountDownLatch countDownLatch = new CountDownLatch(THREAD_NUMBER);

    @Test
    public void insertList() {
        ThreadPoolExecutor exec = new ThreadPoolExecutor(THREAD_NUMBER, THREAD_NUMBER, 5L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>()
                , new ThreadFactoryBuilder().setNameFormat("JacVehicleGpsInsertList").build());
        exec.allowCoreThreadTimeOut(true);
        int pageSize = 2000;
        /*int pageNum = THREAD_NUMBER;
        int pageSize = count % pageNum == 0 ? count / pageNum : count / pageNum + 1;*/
        System.out.println("pageSize = " + pageSize);
        // 获取vin码
        int a = THREAD_NUMBER * 8;
        for (int i = a + 1; i <= a + THREAD_NUMBER; i++) {
//            new Thread(new Executor((i - 1) * pageSize, pageSize)).start();
            exec.execute(new Executor((i - 1) * pageSize, pageSize));
        }
        try {
            countDownLatch.await(2 * 60000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public class Executor implements Runnable{

        private List<JacAlarmRecord> list;

        public Executor(int pageStart, int pageSize) {
            this.list = jacAlarmRecordDao.selectIdAll(pageStart, pageSize);
        }

        @Override
        public void run() {
            if (Objects.nonNull(list)) {
                List<JacVehicleGps> jacVehicleGpsList = new ArrayList<>(list.size());
                list.forEach(jacAlarmRecord -> {
                    JacVehicleGps jacVehicleGps = createVehicleGps(jacAlarmRecord);
                    jacVehicleGpsList.add(jacVehicleGps);
                });
                // 插入数据
                jacVehicleGpsDao.insertList(jacVehicleGpsList);
                countDownLatch.countDown();
            }
        }

        /**
         *
         * @param jacAlarmRecord
         * @return
         */
        private JacVehicleGps createVehicleGps(JacAlarmRecord jacAlarmRecord) {
            JacVehicleGps jacVehicleGps = new JacVehicleGps(now, now, username, username, jacAlarmRecord.getVin(), jacAlarmRecord.getId(), 104.111696, 31.489359, 40.0, 500, "S", jacAlarmRecord.getAlarmContent(), 97, jacAlarmRecord.getAlarmStartTime());
            return jacVehicleGps;
        }
    }
}
