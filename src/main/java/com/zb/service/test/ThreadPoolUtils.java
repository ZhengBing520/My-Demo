package com.zb.service.test;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * Created by bzheng on 2019/5/17.
 */
public class ThreadPoolUtils {



    private static ScheduledExecutorService executorService;

    private ThreadPoolUtils() {
        //手动创建线程池.
        executorService = new ScheduledThreadPoolExecutor(10,
                new BasicThreadFactory.Builder().namingPattern("syncdata-schedule-pool-%d").daemon(true).build());
    }

    private static class PluginConfigHolder {
        private final static ThreadPoolUtils INSTANCE = new ThreadPoolUtils();
    }

    public static ThreadPoolUtils getInstance() {
        return PluginConfigHolder.INSTANCE;
    }

    public ScheduledExecutorService getThreadPool(){
        return executorService;
    }

}
