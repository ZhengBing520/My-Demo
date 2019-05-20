package com.zb.service.test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by bzheng on 2018/9/6.
 */
public class A {

    static {
        int i = 1;
        System.out.println(i);
    }

    static int i = 2;

    public static final int B = 1;

    public static void main(String[] args) {
       String str = "湖北县";
        int index = str.indexOf("省");
        if (0 >= index) {
            index = str.indexOf("市");
        }
        if (0 >= index) {
            index = str.indexOf("区");
        }
        if (0 >= index) {
            index = str.indexOf("县");
        }
        if (0 >= index) {
            index = str.length();
        }

        String substring = str.substring(0, index);
        System.out.println(substring);
    }
}
