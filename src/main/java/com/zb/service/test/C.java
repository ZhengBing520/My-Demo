package com.zb.service.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by bzheng on 2018/9/19.
 */
public class C {

    private static int i = 0;

    private static AtomicInteger integer = new AtomicInteger(0);

    public static void add() {
        i++;
    }

    public static void add2() {
//        int i = integer.getAndIncrement();
//        int i = integer.getAndAdd(1);
        int i1 = integer.incrementAndGet();
        boolean b = integer.compareAndSet(10, 20);
        System.out.println("add2 : " + i1);
        System.out.println(b);
    }

    static class Task extends Thread {
        public String name;
        private int time;

        public Task(String s, int t) {
            name = s;
            time = t;
        }

        public void run() {
            try {
                for (int i = 0; i < time; ++i) {

                    Thread.sleep(1000);

                    System.out.println("task " + name + " " + (i + 1) + " round");
                }
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " is interrupted when calculating, will stop...");
                //return;  //注意这里如果不return的话，线程还会继续执行，所以任务超时后在这里处理结果然后返回
            }
            System.out.println("task " + Thread.currentThread().getName() + " finished successfully");
        }
    }

    public static void main(String[] args) throws Exception {
       /* String[] a = new String[]{"A","B","C"};
        List<String> strings = Arrays.asList(a);

        ArrayList<String> strings1 = new ArrayList<>(strings);
        strings1.set(2, "d");
        strings1.add("3");
        System.out.println(strings1.toString());*/
       /* String[] a = new String[]{"A","B","C","A","B","C","A","B","C","A","B","C","A","B","C"};
        List<String> strings = Arrays.asList(a);
        strings.add("G");
        strings.forEach(s -> System.out.println(s));

//        ArrayList<String> strings1 = new ArrayList<>(strings);

//        strings.addAll(new ArrayList<String>(){{add("F");}});
//        strings.add("1");
        System.out.println(strings.toString());*/
       /* ExecutorService executorService = Executors.newCachedThreadPool();
        for (int j = 0; j < 20; j++) {
            Thread thread = new Thread(() -> C.add());
            executorService.execute(thread);
        }
        for (int j = 0; j < 20; j++) {
            Thread thread = new Thread(() -> C.add2());
            executorService.execute(thread);
        }
        executorService.shutdown();
        System.out.println(i);
        System.out.println("atomic ： " + integer);*/
        /*Integer[] a = new Integer[]{6, 5, 3, 8, 1};
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(a));
        Collections.sort(integers);
        System.out.println(integers.toString());*/
        ListNode listNode1 = new ListNode(2);
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(3);
        ListNode listNode2 = new ListNode(5);
        listNode2.next = new ListNode(6);
        listNode2.next.next = new ListNode(4);
        ListNode listNode = addTwoNumbers(listNode1, listNode2);
        while (null != listNode) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = null;
        int i = 0;
        int j = 0;
        int count = 0;
        while (null != l1) {
            int a = l1.val;
            count += a * Math.pow(10, i);
            i++;
            l1 = l1.next;
        }

        while (null != l2) {
            int a = l2.val;
            count += a * Math.pow(10, j);
            j++;
            l2 = l2.next;
        }
        int x = i >= j ? i : j;
        while (x >= 0) {
            if (count < Math.pow(10, x)) {
                x--;
                continue;
            }
            int i1 = (int) (count / Math.pow(10, x) % 10);
            ListNode l = new ListNode(i1);
            if (null == listNode) {
                listNode = l;
            } else {
                ListNode listNode1 = listNode;
                while (null != listNode1.next) {
                    listNode1 = listNode1.next;
                }
                listNode1 = l;

            }

            x--;
        }
        return listNode;
    }
}
