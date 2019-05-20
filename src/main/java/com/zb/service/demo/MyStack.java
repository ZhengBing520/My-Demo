package com.zb.service.demo;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Created by bzheng on 2018/9/5.
 * 数据结构和算法--栈
 * 先进后出
 */
public class MyStack {
    /**
     * 此栈的缺点：                           |  改变
     * 1.数据固定（int类型数据）              |  object[]
     * 2.不能扩容                             |  自动扩容
     * 3.栈需要初始化容量，而且数组实现的栈   |
     * 元素都是连续存储的，那么能不能不初始   |  改为由链表实现 (暂不实现)
     * 化容量呢？                             |
     */

    // 存储数据
    private int[] array;

    // 栈顶
    private int top;

    // 栈大小
    private int size;

    public MyStack(int size) {
        this.size = size;
        array = new int[size];
        top = -1;
    }

    public MyStack() {
        size = 10;
        top = -1;
        array = new int[size];
    }

    /**
     * 数据进栈
     *
     * @param value
     */
    public void push(int value) {
        if (top < size - 1) {
            array[++top] = value;
        }

    }

    /**
     * 数据出栈
     */
    public int pop() {
        return array[top--];
    }

    /**
     * 查看栈顶元素
     *
     * @return
     */
    public int peek() {
        return array[top];
    }

    /**
     * 查看是否空栈
     *
     * @return
     */
    public boolean isEmply() {
        return -1 == top;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        /*myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.peek());
        while (!myStack.isEmply()) {
            System.out.println(myStack.pop());
        }*/
        MyArray myArray = new MyStack.MyArray();
        myArray.main(args);
    }

    /**
     * 增强版栈
     */
    public static class MyArray {

        private Object[] elementData;

        private int top;

        private int size;

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public MyArray(int initialCapacity) {
            if (initialCapacity < 0) {
                throw new IllegalArgumentException("栈初始容量不能小于0: " + initialCapacity);
            }
            this.size = initialCapacity;
            this.elementData = new Object[initialCapacity];
            top = -1;
        }

        public MyArray() {
            size = 10;
            top = -1;
            elementData = new Object[size];
        }

        /**
         * 数据进栈
         *
         * @param value
         */
        public void push(Object value) {
            // 检查是否扩容
            grow(top + 1);
            elementData[++top] = value;
        }

        /**
         * 是否需要扩容
         *
         * @param minCapacity
         * @return true -- 是
         */
        public boolean grow(int minCapacity) {
            int oldCapacity = size;
            if (minCapacity >= oldCapacity) {
                //定义扩大之后栈的总容量
                int newCapacity = 0;
                if ((oldCapacity << 1) - Integer.MAX_VALUE > 0) {
                    newCapacity = Integer.MAX_VALUE;
                } else {
                    newCapacity = oldCapacity << 1;
                }
                this.size = newCapacity;
                elementData = Arrays.copyOf(elementData, size);
                return true;
            }
            return false;
        }

        /**
         * 数据出栈
         */
        public Object pop() {
            // 这里不能这样了，要扩容的话，数据要删掉，否者复制的时候数据还在
//            return array[top--];
            Object peek = peek();
            remove(top);
            return peek;
        }

        public void remove(int top) {
            elementData[top] = null;
            this.top--;
        }

        /**
         * 遍历栈 （从底到顶）
         */
        public void foreach() {
            for (int i = 0; i< elementData.length; i++) {
                Object elementDatum = elementData[i];
                if (null != elementDatum) {
                    System.out.print(elementDatum + " ");
                }

            }
            System.out.println();
        }

        /**
         * 查看栈顶元素
         *
         * @return
         */
        public Object peek() {
            if (top == -1) {
                throw new EmptyStackException();
            }
            return elementData[top];
        }

        /**
         * 查看是否空栈
         *
         * @return
         */
        public boolean isEmply() {
            return -1 == top;
        }

        public boolean isFull() {
            return top == size - 1;
        }

        public void main(String[] args) {
            MyArray myArray = new MyArray(3);
            myArray.push(1);
            myArray.push(2);
            myArray.push(3);
            myArray.push("22");
            System.out.println(myArray.peek());
            while (!myArray.isEmply()) {
                System.out.println(myArray.pop());
            }
            int size = myArray.getSize();
            System.out.println(size);
        }

    }
}
