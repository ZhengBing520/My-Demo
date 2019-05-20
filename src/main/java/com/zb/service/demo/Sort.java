package com.zb.service.demo;

/**
 * Created by bzheng on 2018/9/3.
 * 数据结构和算法--排序
 * 冒泡、选择、插入排序
 */
public class Sort {

    /**
     * 冒泡排序--2个相邻的数据互比，将大的交换在后面
     *
     * @param array
     */
    public static int[] bubbleSort(int[] array) {
        System.out.print("未排序数组：");
        display(array);
        // 遍历次数 array.length - 1
        for (int i = 1; i < array.length; i++) {
            // 如果第一次没有发生交换，那么就是排好了序的
            boolean flag = true;
            // 循环比较   不用和最后一个比较
            for (int j = 0; j < array.length - i; j++) {
                if (array[j] > array[j + 1]) {
                    // 交换
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = array[j];
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
            System.out.print("第" + (i + 1) + "轮排序之后的结果：");
            display(array);
        }
        return array;
    }

    /**
     * 选择排序
     *
     * @param array
     * @return
     */
    public static int[] choiceSort(int[] array) {
        // 相邻的两个数比较，记录小的那一个角标，最后替换
        // 循环次数 array.length - 1
        for (int i = 0; i < array.length - 1; i++) {
            // 需要替换的数据
            int min = i;
            // 比较次数
            for (int j = i + 1; j < array.length; j++) {
                // 比较大小
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            if (min != i) {
                // 交换
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }
        return array;
    }

    /**
     * 插入排序
     *
     * @param array
     * @return
     */
    public static int[] insertSort(int[] array) {
        // 循环次数
        for (int i = 1; i < array.length; i++) {
            // 记录
            int temp = array[i];
            // 比较次数
            int j = i;
            while (j > 0 && temp > array[j - 1]) {
                array[j] = array[j - 1];
                j--;
            }
        }
        return array;
    }

    /**
     * 遍历
     *
     * @param array
     */
    public static void display(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\n");
        }
        System.out.println();
    }
}
