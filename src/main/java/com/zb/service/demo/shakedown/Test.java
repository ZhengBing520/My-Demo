/*
package com.zb.service.demo.shakedown;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

*/
/**
 * Created by bzheng on 2018/12/29.
 *//*

public class Test {

    private final static Logger logger = LoggerFactory.getLogger(Test.class);
    static int a = 500;

    public static void main(String[] args) {
        Runnable runnable = () -> {
            DistributedLock distributedLock = null;
            try {
                distributedLock = new DistributedLock("127.0.0.1:2181", "test");
                distributedLock.lock();
                System.out.println(a);
                a--;
                System.out.println(Thread.currentThread().getName() + "正在运行");
            } catch (Exception e) {
                logger.error("出错了：" + e.getMessage(), e);
            } finally {
                if (!Objects.isNull(distributedLock)) {
                    distributedLock.unlock();
                }
            }

        };
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(runnable);
            thread.start();
        }
    }

}
*/
