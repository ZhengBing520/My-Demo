package com.zb.service.demo;

import com.zb.service.test.B;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by bzheng on 2018/9/17.
 */
@EnableAspectJAutoProxy
public class SignLinkendList {

    // 数据个数
    private int maxSize;

    // 头节点
    private Node head;

    public class Node {

        // 数据
        private Object data;

        // 指向下个节点
        private Node next;

        public Node(Object data) {
            this.data = data;
        }
    }

    public SignLinkendList() {
        maxSize = 0;
        head = null;
    }

    /**
     * 添加数据到头部
     * @param value
     */
    public void push(Object value) {
        Node newNode = new Node(value);
        if (0 != maxSize) {
            newNode.next = head;
            head = newNode;
        } else {
            head = newNode;
        }
        maxSize++;
    }

    /**
     * 查找数据
     * @param value
     * @return
     */
    public Node find(Object value) {
        if (head.data.equals(value)) {
            return head;
        }
        int index = maxSize;
        while (index > 0) {
            Node next = head.next;
            if (next.data.equals(value)) {
                return next;
            } else {
                next = next.next;
                index--;
            }
        }
            return null;
    }

    public Object deleteHead() {
        if (null == head) {
            return null;
        }
        Object data = head.data;
        head = head.next;
        maxSize--;
        return data;
    }

    public boolean delete(Object value) {
        if (isEmply()) {
            return false;
        }
        Node current = head;
        Node previous = head;
        while (!current.data.equals(value)) {
            if (null == current.next) {
                return false;
            } else {
                previous = current;
                current = current.next;
            }
        }
        // 如果删除的节点是第一个
        if (current == head) {
            // 删除第一个，将头节点换成下一个
            head = head.next;
            maxSize--;
        } else {
            previous.next = current.next;
            maxSize--;
        }
        return true;
    }

    public boolean isEmply() {
        return 0 == maxSize;
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
    public static void main(String[] args) {
        SignLinkendList signLinkendList = new SignLinkendList();
        signLinkendList.push("A");
        signLinkendList.push("B");
        signLinkendList.push("C");
        signLinkendList.push("D");
        signLinkendList.disPlay();
        System.out.println(signLinkendList.delete("B"));
        signLinkendList.deleteHead();
        signLinkendList.disPlay();
        System.out.println(signLinkendList.find("C"));
    }
}
