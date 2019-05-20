package com.zb.service.test;

import java.util.Scanner;

/**
 * Created by bzheng on 2018/9/6.
 */
public class B {

    public static void main(String[] args) throws Exception{
//        Integer[] a = {1,2,3};
//        String[] b = {"22"};
//        String c = "";
//
//        int.class.isPrimitive();
//        System.out.println("class:" + a.getClass() +  a.getClass().isArray());
//        System.out.println("class:" + b.getClass() +  a.getClass().isArray());
//        System.out.println("class:" + c.getClass() +  a.getClass().isPrimitive());
//        test(d);
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入一个最大数：");
        int n = scanner.nextInt();
        printPrimeNumbers(n);
//           2、3、5、7、11、13、17、19、23、29、31、37、41、43、47、53、59、61、67、71、73、79、83、89、97
//        "2 、3、5、7、11、13、17、19、23、29、31、37、41、43、47、53、59、61、67、71、73、79、93、89、97.";
    }

    public static void printPrimeNumbers(int n) {
        boolean flag ;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("质数：");

        if (n < 2) {
            return;
        }
        stringBuilder.append(2);
        // 偶数（除了2）不用除，必然不是质数
        for (int i = 3; i < n; i+=2) {
            flag = true;
            // 如果 a * b = c; 那么必然有： a <= c^(1/2) 或 b <= c^(1/2); 两个数相乘一定会有一个数小于或等于乘积的开方
            for (int j = 3; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    // 不是质数
                    flag = false;
                    break;
                }
            }
            if (flag) {
                stringBuilder.append("、").append(i);
            }
        }
        System.out.println(stringBuilder.toString());
    }

    private static void test(Object o) {
        System.out.println("class:" + o.getClass() +  o.getClass().isPrimitive());
    }
}
