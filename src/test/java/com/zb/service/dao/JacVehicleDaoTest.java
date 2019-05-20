package com.zb.service.dao;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by bzheng on 2019/2/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Ignore
public class JacVehicleDaoTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    JacVehicleDao jacVehicleDao;

    @Autowired
    JacMotorcadeVehicleDao jacMotorcadeVehicleDao;

    /**
     * 10条线程
     */
    private static final int THREAD_NUMBER = 40;

    /**
     * 车队总数
     */
    private static final int count = 200;

    private static final int consult = 5;

    Long motorcardId = 1538979561574L;
    Long dealerId = 1538978094876L;
    CountDownLatch countDownLatch = new CountDownLatch(THREAD_NUMBER);
    @Test
    public void update() {

        ThreadPoolExecutor exec = new ThreadPoolExecutor(THREAD_NUMBER, THREAD_NUMBER, 5L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>()
                , new ThreadFactoryBuilder().setNameFormat("JacAlarmRecordInsertList").build());
        exec.allowCoreThreadTimeOut(true);



        for (int i = 1; i <= THREAD_NUMBER; i++) {
            exec.execute(new Executor(i));
        }
        /*for (int i = 0; i < 200; i++) {
            motorcardId = motorcardId + 1;
            dealerId = 1538978094876L + (i/2);
            String ids = getIds(i + 1, 199996, 200);

            jacVehicleDao.updateVehicle(motorcardId, dealerId, ids);
        }*/
        try {
            countDownLatch.await(2 * 60000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private class Executor implements Runnable {

        // 一条线程id
        private int id;



        int start;

        int end;

        public Executor(int id) {
            this.id = id;
            this.start = (id - 1) * consult;
            this.end = id * consult;
        }

        @Override
        public void run() {
            for (int i = start; i < end; i++) {
                List<Integer> ids = getIds(i + 1, 199996, count);
                long motorcardId2 = motorcardId + i + 1;
                long dealerId2 = dealerId + i / 2;
//                jacVehicleDao.updateVehicle(motorcardId2, dealerId2, ids);
                jacMotorcadeVehicleDao.updateVehicle(motorcardId2, ids);
            }
            countDownLatch.countDown();
        }
    }

    public List<Integer> getIds(Integer minId, Integer maxId, Integer avg) {
        List<Integer> list = new ArrayList<>(1000);
        while (minId < maxId) {
            list.add(minId);
            minId = minId + avg;
        }
        return list;
    }
}
