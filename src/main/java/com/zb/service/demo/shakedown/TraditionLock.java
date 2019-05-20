/*
package com.zb.service.demo.shakedown;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.ReentrantLock;

*/
/**
 * Created by bzheng on 2018/12/25.
 * 模拟抢票系统
 *//*

public class TraditionLock {
    */
/**
     * 并发线程数
     *//*

    private int count = 10000;

    private CountDownLatch latch = new CountDownLatch(count);

    private CyclicBarrier cyclicBarrier = new CyclicBarrier(count + 1);

    // 重入锁
    private ReentrantLock lock = new ReentrantLock();


    class Ticket implements Runnable{
        */
/**
         * 票编号
         *//*

        private int number = 1;

        @Override
        public void run() {

            try {
                latch.await();
                lock.lock();// 2.效率一般，但是比synchronized高 3764ms
//                synchronized(this) { // 1.加synchronized,效率不高 4965ms
                    System.out.println("当前线程：" + Thread.currentThread().getName() + ",抢到票号为：" + number);
                    number++;
//                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                    lock.unlock();
                    System.out.println("当前线程：" + Thread.currentThread().getName() + "解锁");
                try {
                    cyclicBarrier.await();
                } catch (Exception e) {

                }

            }

        }
    }





    public void test() {
        Ticket ticket = new Ticket();
        for (int i = 1; i <= count; i++) {
            Thread thread = new Thread(ticket, i +"号线程");
            thread.start();
            latch.countDown();
        }
    }


    public static void main(String[] args) throws Exception{
        long l = System.currentTimeMillis();
        TraditionLock t = new TraditionLock();
        t.test();
        t.cyclicBarrier.await();
        System.out.println("耗时：" + (System.currentTimeMillis() - l));


    }
}
*/
