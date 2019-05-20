package com.zb.service.demo;

/**
 * Created by bzheng on 2018/9/17.
 * 双端链表
 */
public class DoublePointLinkedList {

    private Node head;

    private Node tail;

    private int maxSize;

    public DoublePointLinkedList() {
        tail = null;
        head = null;
        maxSize = 0;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public class Node {

        private Object data;

        private Node next;

        public Node(Object data) {
            this.data = data;
        }
    }

    public void addHead(Object value) {
        Node newNode = new Node(value);
        if (0 == maxSize) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        maxSize++;
    }

    public void addTail(Object value) {
        Node newNode = new Node(value);
        if (0 == maxSize) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        maxSize++;
    }

    public Object deleteHead() {
        if (null == head) {
            return null;
        }
        Object data = head.data;
        if (null == head.next) {
            tail = null;
            head = null;
        } else {
            head = head.next;
        }

        maxSize--;
        return data;
    }

    /**
     * 遍历
     */
    public void disPlay() {
        if (0 < maxSize) {
            Node node = head;
            int index = maxSize;
            while (0 < index) {
                if (node.equals(head)) {
                    System.out.print("[" + node.data + "->");
                } else if (null == node.next) {
                    System.out.print(node.data + "]");
                } else {
                    System.out.print(node.data + "->");
                }
                index--;
                node = node.next;
            }
        } else {
            System.out.print("[]");
        }
        System.out.println();
    }

}
