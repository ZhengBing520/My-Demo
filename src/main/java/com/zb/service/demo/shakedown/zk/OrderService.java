/*
package com.zb.service.demo.shakedown.zk;

import java.util.concurrent.locks.Lock;

*/
/**
 * Created by bzheng on 2018/12/29.
 *//*

public class OrderService implements Runnable {


//    private Lock lock = new ZookeeperDistributedLock();


    private int n = 100;

    @Override
    public void run() {
        Lock lock = new ZookeeperDistributedLock2();
        try {
            lock.lock();
            n--;
            System.out.println("当前n = " + n);
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(orderService);
            thread.start();
        }
    }
}
*/
