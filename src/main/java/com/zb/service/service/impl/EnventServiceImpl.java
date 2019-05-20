package com.zb.service.service.impl;

import com.zb.service.service.EnventService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Objects;

/**
 * Created by bzheng on 2019/3/14.
 */
@Service
public class EnventServiceImpl implements EnventService {

    @Override
    public void eventTostring(Object obj) {
        System.out.println("数据：" + obj == null ? "" : obj.toString() );
    }

    @EventListener
    public void handlerOrderEvent(String message) {
        if (Objects.equals("success", message)) {
            eventTostring(message);
        } else {
            int a = 2 / 0;
            System.out.println(a);
        }

    }

    @EventListener
    public void handlerOrderEvent2(Integer message2) {
        System.out.println("integer-> " + message2);
    }
}
