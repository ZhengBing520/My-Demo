package com.zb.service;

import com.zb.service.message.queue.Receiver;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

import java.util.concurrent.CountDownLatch;

/**
 * Created by bzheng on 2018/8/16.
 */
@SpringBootApplication
@MapperScan("com.zb.service.dao")
public class App {

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    /*@Bean
    RedisMessageListenerContainer container(RedisConnectionFactory redisConnectionFactory, MessageListenerAdapter messageListenerAdapter) {
        RedisMessageListenerContainer redisMessageListenerContainer = new RedisMessageListenerContainer();
        redisMessageListenerContainer.setConnectionFactory(redisConnectionFactory);
        redisMessageListenerContainer.addMessageListener(messageListenerAdapter, new PatternTopic("chat"));

        return redisMessageListenerContainer;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(Receiver receiver) {
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }

    @Bean
    Receiver receiver(CountDownLatch latch) {
        return new Receiver(latch);
    }

    @Bean
    CountDownLatch latch() {
        return new CountDownLatch(1);
    }

    @Bean
    StringRedisTemplate template(RedisConnectionFactory connectionFactory) {
        return new StringRedisTemplate(connectionFactory);
    }
    public static void main(String[] args) throws Exception{
        ApplicationContext app = SpringApplication.run(App.class, args);
        StringRedisTemplate redisTemplate = app.getBean(StringRedisTemplate.class);
        CountDownLatch downLatch = app.getBean(CountDownLatch.class);
        LOGGER.info("sending messages");
        redisTemplate.convertAndSend("chat", "Hello from receive");
        downLatch.await();
        System.exit(0);
    }*/

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
