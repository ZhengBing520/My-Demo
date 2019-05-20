package com.zb.service.controller;

import com.google.common.util.concurrent.RateLimiter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * Created by bzheng on 2018/7/20.
 */
@RestController
public class Controller {

    // QPS = 2的令牌桶
    final RateLimiter rateLimiter = RateLimiter.create(2);

    /**
     *  同步等待
     * @param count
     * @return
     */
    @GetMapping("/testRateLimiterSync")
    public String testRateLimiterSync(@RequestParam(value = "count", required = false) Integer count) {
        String msg = "";
        if (Objects.isNull(count)) {
            double acquire = rateLimiter.acquire();
            msg = ("等待时间：" + acquire);

        } else {
            double acquire = rateLimiter.acquire(count);
            msg = ("获取令牌个数：" + count + "，等待时间：" + acquire);
        }
        return msg;
    }

    /**
     * 异步处理
     * @param count
     * @return
     */
    @GetMapping("/testRateLimiterAsync")
    public String testRateLimiterAsync(@RequestParam(value = "count", required = false) Integer count) {
        String msg = "";
        if (Objects.isNull(count)) {
            if (rateLimiter.tryAcquire()) {
                msg = ("获取令牌成功");
            } else {
                msg = ("获取令牌失败");
            }
        } else {
            if (rateLimiter.tryAcquire(count)) {
                msg = ("获取令牌成功，获取令牌个数：" + count );
            } else {
                msg = ("获取令牌失败，获取令牌个数：" + count );
            }
        }
        return msg;
    }
}
