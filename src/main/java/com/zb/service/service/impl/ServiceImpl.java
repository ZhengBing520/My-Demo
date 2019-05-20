package com.zb.service.service.impl;

import com.zb.service.service.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Created by bzheng on 2018/7/20.
 */
public class ServiceImpl implements Service {


    @Override
    public void service1() {
        //defaultService();
        System.out.println("hello");
    }

    public static void main(String[] args) {
        Service service = () -> Service.staticSevice();
//        Service service = new ServiceImpl();
        service.defaultService();
        service.service1();
        Integer[] a = {2,3,4};
        a.getClass().isArray();
        List<Integer> list = Arrays.asList(a);
        list.remove(new Integer(4));
//        Arrays.co
    }

}
