package com.zb.service.test;

/**
 * Created by bzheng on 2019/2/28.
 */
public class Child extends Person {

     int age = 5;

    public static void main(String[] args) {
        Person p = new Child();
        System.out.println(((Child) p).age);;
    }

}
