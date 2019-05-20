package com.zb.service.message.queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.CountDownLatch;

/**
 * Created by bzheng on 2019/2/21.
 */
public class Receiver {

    private static final Logger logger = LoggerFactory.getLogger(Receiver.class);

    CountDownLatch countDownLatch;

    @Autowired
    public Receiver(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    public void receiveMessage(String message) {
        logger.info("Receive < " + message + ">");
        countDownLatch.countDown();
    }
}
