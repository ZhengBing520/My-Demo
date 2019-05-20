package com.zb.service.demo;

/**
 * Created by bzheng on 2018/9/18.
 */
public class OrderLinkedList {

    private int maxSize;

    private Node head;

    public OrderLinkedList() {
        head = null;
        maxSize = 0;
    }

    public static class Node {

        private int data;

        private Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    //插入节点，并按照从小打到的顺序排列
     public void insert(int value){
                Node node = new Node(value);
                 Node pre = null;
                 Node current = head;
               while(current != null && value > current.data){
                     pre = current;
                    current = current.next;
               }
               if(pre == null){
                      head = node;
                    head.next = current;
                     }else{
                        pre.next = node;
                        node.next = current;
                     }
            }

             //删除头节点
            public void deleteHead(){
                 head = head.next;
            }

           public void display(){
                Node current = head;
                while(current != null){
                       System.out.print(current.data+" ");
                        current = current.next;
                    }
                System.out.println("");
            }

    public static void main(String[] args) {
        /*OrderLinkedList orderLinkedList = new OrderLinkedList();
        orderLinkedList.insert(2);
        orderLinkedList.insert(4);
        orderLinkedList.insert(3);
        orderLinkedList.display();*/

        Boolean flag = true;
        Boolean b = false;
        System.out.println(flag.toString());
        System.out.println(b.toString());
    }
}
