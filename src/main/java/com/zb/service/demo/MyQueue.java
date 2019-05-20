package com.zb.service.demo;

/**
 * Created by bzheng on 2018/9/11.
 * 队列 - 1.单向队列，2.双向队列，3.优先级队列
 * 双端队列就是一个两端都是结尾或者开头的队列， 队列的每一端都可以进行插入数据项和移除数据项，这些方法可以叫做：
 * <p>
 * 　　insertRight()、insertLeft()、removeLeft()、removeRight()
 * <p>
 * 　　如果严格禁止调用insertLeft()和removeLeft()（或禁用右端操作），那么双端队列的功能就和前面讲的栈功能一样。
 * <p>
 * 　　如果严格禁止调用insertLeft()和removeRight(或相反的另一对方法)，那么双端队列的功能就和单向队列一样了。
 * <p>
 * 三种队列分别是单向队列、双向队列以及优先级队列。其实大家听名字也可以听得出来他们之间的区别，单向队列遵循先进先出的原则，而且一端只能插入，
 * 另一端只能删除。双向队列则两端都可插入和删除，如果限制双向队列的某一段的方法，则可以达到和单向队列同样的功能。
 * 最后优先级队列，则是在插入元素的时候进行了优先级别排序，
 * 在实际应用中单项队列和优先级队列使用的比较多。后面讲解了堆这种数据结构，我们会用堆来实现优先级队列，改善优先级队列插入元素的时间。
 */
public class MyQueue {

    // 数组
    private Object[] queArray;

    // 最大容量
    private int maxSize;

    // 实际数量
    private int items;

    // 队头
    private int front;

    // 队尾
    private int rear;

    public MyQueue(int maxSize) {
        this.maxSize = maxSize;
        queArray = new Object[maxSize];
        items = 0;
        front = 0;
        rear = -1;
    }

    /**
     * 往队尾添加数据
     *
     * @param value
     * @return
     */
    public boolean push(Object value) {
        if (!isFull()) {
            queArray[++rear] = value;
            // 循环队列，添加到末尾了直接从头开始添加
            if (rear == maxSize - 1) {
                rear = -1;
            }
            items++;
            return true;
        } else {
            System.out.println("队列已满");
        }
        return false;
    }

    /**
     * 取出数据
     *
     * @return
     */
    public Object pop() {
        Object remove = remove();
        if (null == remove) {
            System.out.println("没有数据");
        }
        return remove;
    }

    public boolean isEmpty() {
        return items == 0;
    }

    /**
     * 查看队头数据
     *
     * @return
     */
    public Object peek() {
        Object value = null;
        if (!isEmpty()) {
            value = queArray[front];
        }
        return value;
    }

    /**
     * 查看队列是否满了
     *
     * @return
     */
    public boolean isFull() {
        return items == maxSize;
    }

    /**
     * 查看队列大小
     *
     * @return
     */
    public int getSize() {
        return items;
    }

    /**
     * 移除数据
     *
     * @return
     */
    public Object remove() {
        Object value = null;
        if (!isEmpty()) {
            value = queArray[front];
            queArray[front] = null;
            front++;
            // 删到底部了，从头赋值
            if (front == maxSize) {
                front = 0;
            }
            items--;
        }
        return value;
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue(3);
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        myQueue.push(4);
        System.out.println("1->" + myQueue.peek());
        System.out.println("2->" + myQueue.isFull());
        Object pop = myQueue.pop();
        System.out.println("3->" + pop);
        System.out.println("4->" + myQueue.peek());
        boolean push = myQueue.push(4);
        System.out.println("5->" + push);
        System.out.println("6->" + myQueue.peek());

    }
}

/**
 * 优先级队列
 */
class PriorityQue {

    /**
     * 最大容量
     */
    private int maxSize;

    /**
     * 数组 （有排序，所以用int数组）
     */
    private int[] priQueArray;

    /**
     * 数据条数
     */
    private int nitems;

    public int getMaxSize() {
        return maxSize;
    }

    public  PriorityQue(int maxSize) {
        this.maxSize = maxSize;
        priQueArray = new int[this.maxSize];
        nitems = 0;
    }

    public boolean isEmpty() {
        return nitems == 0;
    }

    /**
     * 查看队头数据
     *
     * @return
     */
    public Object peek() {
        int value = -1;
        if (!isEmpty()) {
            value = priQueArray[nitems - 1];
        }
        return value;
    }

    /**
     * 查看队列是否满了
     *
     * @return
     */
    public boolean isFull() {
        return nitems == maxSize;
    }

    /**
     * 查看队列大小
     *
     * @return
     */
    public int getSize() {
        return nitems;
    }

    public int remove() {
        int value = -1;
        if (!isEmpty()) {
            value = priQueArray[nitems];
            // 将队头置为-1
            priQueArray[nitems] = -1;
            nitems--;
        }
        return value;
    }

    public void insert(int value) {
        if (isFull()) {
            System.out.println("队列已满");
            return;
        }
        if (isEmpty()) {
            priQueArray[nitems] = value;
        } else {
            // 排序 (从大到小)
            int j = nitems - 1;
            while (j >= 0 && value > priQueArray[j]) {
                priQueArray[j + 1] = priQueArray[j];
                j--;
            }
            priQueArray[j + 1] = value;
        }
        nitems++;
    }

    public static void main(String[] args) {
        PriorityQue priorityQue = new PriorityQue(5);
        priorityQue.insert(5);
        priorityQue.insert(4);
        priorityQue.insert(6);
        priorityQue.insert(3);
        priorityQue.insert(7);
        priorityQue.insert(2);
        System.out.println(priorityQue.peek());
    }
}


