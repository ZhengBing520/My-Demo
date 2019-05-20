package com.zb.service.demo;

/**
 * Created by bzheng on 2018/9/17.
 */
public class QueueLinkedList {

    private DoublePointLinkedList doublePointLinkedList;

    public QueueLinkedList() {
        this.doublePointLinkedList = new DoublePointLinkedList();
    }

    public void push(Object value) {
        doublePointLinkedList.addTail(value);
    }

    public void display(){
        doublePointLinkedList.disPlay();
    }

    public int getSize() {
        return doublePointLinkedList.getMaxSize();
    }

    public static void main(String[] args) {
        QueueLinkedList queueLinkedList = new QueueLinkedList();
        queueLinkedList.push("A");
        queueLinkedList.push("B");
        queueLinkedList.push("C");
        queueLinkedList.push("D");
        queueLinkedList.display();
    }
}
