/*
package com.zb.service.demo.shakedown.zk;

import org.I0Itec.zkclient.IZkDataListener;
import org.springframework.util.ObjectUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

*/
/**
 * Created by bzheng on 2018/12/29.
 * 检测一个临时顺序节点
 *//*

public class ZookeeperDistributedLock2 extends ZookeeperAbstractLock {

    private CountDownLatch countDownLatch = null;

    private String beforePath;// 当前请求的节点前一个节点

    private String currentPath;// 当前请求的节点

    public ZookeeperDistributedLock2() {
        if (!this.zkClient.exists(PATH2)) {
            this.zkClient.createPersistent(PATH2);
        }
    }

    @Override
    public boolean tryLock() {
        // 判断当前没有锁，尝试加锁
        if (ObjectUtils.isEmpty(currentPath)) {
            currentPath = this.zkClient.createEphemeralSequential(PATH2 + "/", "lock" );
            //System.out.println("##currentPath = " + currentPath);
        }
       // 获取所有子节点
        List<String> children = zkClient.getChildren(PATH2);
//        System.out.println(Arrays.toString(children.toArray()));
        Collections.sort(children);
        if (currentPath.equals(PATH2 + "/" + children.get(0))) { // 如果当前节点为最小的那个，获取锁
            return true;
        } else {
            // 获取上一个节点,赋值beforeLock
//            int index = children.indexOf(currentPath.substring(currentPath.lastIndexOf("/") + 1));
            int index = Collections.binarySearch(children, currentPath.substring(currentPath.lastIndexOf("/") + 1));
            beforePath = PATH2 + "/" + children.get(index - 1);
        }
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        try {
            zkClient.delete(currentPath);
            zkClient.close();
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
        if (this.tryLock()) {
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

        // 给排在前面的节点添加监听事件
        zkClient.subscribeDataChanges(beforePath, iZkDataListener);

        // 如果节点存在
        if (zkClient.exists(beforePath)) {
            // 等待删除
            countDownLatch = new CountDownLatch(1);
            try {
                countDownLatch.await();
            } catch (Exception e) {

            }
        }
        // 删除监听
        zkClient.unsubscribeDataChanges(beforePath, iZkDataListener);
    }

}
*/
