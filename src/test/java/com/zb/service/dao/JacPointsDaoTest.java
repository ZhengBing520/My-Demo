package com.zb.service.dao;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.zb.service.entity.JacDriver;
import com.zb.service.entity.JacPoints;
import com.zb.service.entity.JacPointsRecord;
import net.bytebuddy.asm.Advice;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.ObjectUtils;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by bzheng on 2019/1/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Ignore
public class JacPointsDaoTest extends AbstractJUnit4SpringContextTests{

    private static Date now;

    private static String username;

    static {
        now = new Date();
        username = "system";
        totalPoint = 8;
        consumePoint = 0;
    }

    static int totalPoint, consumePoint;
    /**
     * 10条线程
     */
    private static final int THREAD_NUMBER = 40;

    CountDownLatch countDownLatch = new CountDownLatch(THREAD_NUMBER + 1);

    @Autowired
    JacPointsDao jacPointsDao;

    @Autowired
    JacDriverDao jacDriverDao;

    @Autowired
    JacPointsRecordDao jacPointsRecordDao;
    @Test
    @Ignore
    public void insertList() {
        ThreadPoolExecutor exec = new ThreadPoolExecutor(THREAD_NUMBER, THREAD_NUMBER, 5L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>()
                , new ThreadFactoryBuilder().setNameFormat("JacAlarmRecordInsertList").build());
        exec.allowCoreThreadTimeOut(true);
        int pageSize = 1000;
        /*int pageNum = THREAD_NUMBER;
        int pageSize = count % pageNum == 0 ? count / pageNum : count / pageNum + 1;*/
        System.out.println("pageSize = " + pageSize);
        // 获取vin码
        for (int i = 160 + 1; i <= 161 + THREAD_NUMBER; i++) {
//            new Thread(new Executor((i - 1) * pageSize, pageSize)).start();
            exec.execute(new Executor((i - 1) * pageSize, pageSize));
        }
        try {
            countDownLatch.await(2 * 60000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private class Executor implements Runnable {

        private List<JacDriver> jacDrivers;

        public Executor(int pageStart, int pageSize) {
            this.jacDrivers = jacDriverDao.selectIdAll(pageStart, pageSize);
        }

        @Override
        public void run() {
            if (!ObjectUtils.isEmpty(jacDrivers)) {
                List<JacPoints> jacPointsList = new ArrayList<>(jacDrivers.size());
                List<JacPointsRecord> jacPointsRecordList = new ArrayList<>(jacDrivers.size() * 2);
                jacDrivers.forEach(jacDriver -> {
                    JacPoints jacPoints = createJacPoints(jacDriver);
                    JacPointsRecord jacPointsRecord = createJacPointsRecord(jacDriver);
                    JacPointsRecord jacPointsRecord2 = createJacPointsRecord2(jacDriver);
                    jacPointsList.add(jacPoints);
                    jacPointsRecordList.add(jacPointsRecord);
                    jacPointsRecordList.add(jacPointsRecord2);
                });
                // 插入数据
                jacPointsDao.insertList(jacPointsList);
                jacPointsRecordDao.insertList(jacPointsRecordList);
                countDownLatch.countDown();
            }
        }

        private JacPointsRecord createJacPointsRecord(JacDriver jacDriver) {
            JacPointsRecord jacPointsRecord = new JacPointsRecord(now, now, username, username, jacDriver.getId(), jacDriver.getMobile(), "注册", 1000, 5, "PLUS", 5, 0, "");
            return jacPointsRecord;
        }
        private JacPointsRecord createJacPointsRecord2(JacDriver jacDriver) {
            JacPointsRecord jacPointsRecord = new JacPointsRecord(now, now, username, username, jacDriver.getId(), jacDriver.getMobile(), "签到", 1001, 3, "PLUS", 8, 0, "");
            return jacPointsRecord;
        }

        private JacPoints createJacPoints(JacDriver jacDriver) {
            JacPoints jacPoint = new JacPoints(now, now, username, username, jacDriver.getId(), jacDriver.getMobile(), totalPoint, consumePoint);

            return jacPoint;
        }
    }

}
