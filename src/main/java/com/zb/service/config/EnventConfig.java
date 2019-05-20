package com.zb.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * Created by bzheng on 2019/3/14.
 */
@Configuration
public class EnventConfig {

    @Bean
    public SimpleApplicationEventMulticaster applicationEventMulticaster(ThreadPoolTaskExecutor threadPoolTaskExecutor) {
        SimpleApplicationEventMulticaster applicationEventMulticaster = new SimpleApplicationEventMulticaster();
        applicationEventMulticaster.setTaskExecutor(threadPoolTaskExecutor);
        return applicationEventMulticaster;
    }

    /**
     * 有线程池，事件驱动就是异步执行，出错也不会回滚数据（service方法添加@Transaction注解）
     * @return
     */
    @Bean
    public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(10);
        threadPoolTaskExecutor.setMaxPoolSize(20);
        threadPoolTaskExecutor.setQueueCapacity(25);
        threadPoolTaskExecutor.setThreadNamePrefix("coreTaskExecutor--");
        return threadPoolTaskExecutor;
    }
}
