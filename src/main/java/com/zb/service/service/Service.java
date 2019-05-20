package com.zb.service.service;

/**
 * Created by bzheng on 2018/7/20.
 */
public interface Service {

    default void defaultService() {
        System.out.println("default service function");
    }
    static void staticSevice() {
        System.out.println("static service functiono");
    }

    void service1();
}
