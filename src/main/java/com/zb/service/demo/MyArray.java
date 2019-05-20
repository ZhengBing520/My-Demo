package com.zb.service.demo;

/**
 * Created by bzheng on 2018/9/3.
 * 数据结构和算法--数组
 */
public class MyArray {
    // 数组
    private int[] intArray;

    //有效长度
    private int elems;

    //总长度
    private int length;

    public MyArray() {
        elems = 0;
        length = 50;
        intArray = new int[length];
    }

    public MyArray(int length) {
        elems = 0;
        this.length = length;
        intArray = new int[length];
    }

    /**
     * 获取有效长度
     *
     * @return
     */
    public int getSize() {
        return elems;
    }

    /**
     * 添加元素
     *
     * @param value,假设操作人是不会添加重复元素的，如果有重复元素对于后面的操作都会有影响。
     * @return添加成功返回true,添加的元素超过范围了返回false
     */
    public boolean add(int value) {
        if (elems == length) {
            return false;
        }
        intArray[elems] = value;
        elems++;
        return true;
    }

    /**
     * 通过角标获取值
     *
     * @param i
     * @return
     */
    public int get(int i) {
        if (i < 0 || i >= elems) {
            System.out.println("角标越界");
        }
        return intArray[i];
    }

    /**
     * 查找元素
     *
     * @param searchValue
     * @return
     * @return查找的元素如果存在则返回下标值，如果不存在，返回 -1
     */
    public int find(int searchValue) {
        for (int i = 0; i < elems; i++) {
            if (intArray[i] == searchValue) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 删除数据
     *
     * @param searchValue
     * @return
     */
    public boolean delete(int searchValue) {
        // 查找位置
        int index = find(searchValue);
        if (-1 == index) {
            System.out.println("没有此数据");
            return false;
        }
        if (index == elems - 1) {
            // 删掉最后一个即可
            elems--;
        } else {
            for (int i = index; i < elems - 1; i++) {
                // 左移
                intArray[i] = intArray[i + 1];
            }
            elems--;
        }

        return true;
    }

    /**
     * 修改数据
     * @param oldValue 原值
     * @param newValue 新值
     * @return
     */
    public boolean update(int oldValue, int newValue) {
        int i = find(oldValue);
        if (-1 == i) {
            System.out.println("没有此数据");
            return false;
        }
        intArray[i] = newValue;
        return true;
    }
}
