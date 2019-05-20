package com.zb.service.dao;

/**
 * Created by bzheng on 2018/7/20.
 */
public interface Dao {

    default void defaultFun() {
        System.out.println("default dao function");
    }

    void dao();

}
