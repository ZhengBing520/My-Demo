/*
package com.zb.service.demo.shakedown.zk;

import org.I0Itec.zkclient.IZkDataListener;

import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

*/
/**
 * Created by bzheng on 2018/12/29.
 * 监听一个固定节点有羊群效应
 *//*

public class ZookeeperDistributedLock extends ZookeeperAbstractLock {

    private CountDownLatch countDownLatch = null;


    @Override
    public boolean tryLock() {
        try {
            zkClient.createEphemeral(PATH);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        try {
            zkClient.delete(PATH);
            System.out.println("释放锁");
        } catch (Exception e) {

        }


    }


    @Override
    public Condition newCondition() {
        return null;
    }

    @Override
    public void lock() {
        if (tryLock()) {
            // 获取锁
            System.out.println("获取锁");
        } else {
            // 等待锁
            waitLock();
            // 获取锁
            lock();
        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public void waitLock() {
        IZkDataListener iZkDataListener = new IZkDataListener() {
            @Override
            public void handleDataChange(String dataPath, Object data) throws Exception {

            }

            @Override
            public void handleDataDeleted(String dataPath) throws Exception {
                if (!Objects.isNull(countDownLatch)) {
                    countDownLatch.countDown();
                }
            }
        };

        // 注册事件
        zkClient.subscribeDataChanges(PATH, iZkDataListener);

        // 如果节点存在
        if (zkClient.exists(PATH)) {
            countDownLatch = new CountDownLatch(1);
            try {
                countDownLatch.await();
            } catch (Exception e) {

            }
        }
        // 删除监听
        zkClient.unsubscribeDataChanges(PATH, iZkDataListener);
    }

}
*/
