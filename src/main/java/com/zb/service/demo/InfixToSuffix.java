package com.zb.service.demo;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by bzheng on 2018/9/13.
 * 前缀、中缀、后缀
 * ①、前缀表达式：操作符在操作数的前面，比如 +-543
 * 　　②、中缀表达式：操作符在操作数的中间，这也是人类最容易识别的算术表达式 3+4-5 （人识别的）
 * 　　③、后缀表达式：操作符在操作数的后面，比如 34+5-  （）
 */
public class InfixToSuffix {

    private MyStack.MyArray s1; // 操作符入栈

    private MyStack.MyArray s2; // 数据入栈

    private String input; // 输入的中缀表达式

    public InfixToSuffix(String input) {
        this.input = input;
        s1 = new MyStack.MyArray(input.length());
        s2 = new MyStack.MyArray(input.length());
    }

    //中缀表达式转换为后缀表达式，将结果存储在栈中返回，逆序显示即后缀表达式
    public MyStack.MyArray doTrans() {
        for (int j = 0; j < input.length(); j++) {
            System.out.print("s1的元素：");
            s1.foreach();
            System.out.print("s2的元素：");
            s2.foreach();
            char c = input.charAt(j);
            switch (c) {
                case '+':
                case '-':
                    process(c, 1);
                    break;
                case '*':
                case '/':
                    process(c, 2);
                    break;
                case '(':
                    s1.push(c);
                    break;
                case ')':
                    process(c);
                    break;
                default:
                    s2.push(c);


            }
        }
        // 完成之后，将s1剩余的全部弹出到s2
        while (!s1.isEmply()) {
            Object pop = s1.pop();
            s2.push(pop);
        }
        return s2;
    }

    private void process(char c, int level) {
        while (!s1.isEmply()) {
            char pop = (char) s1.pop();
            int popLevel = 0;
            if (pop == '+' || pop == '-') {
                popLevel = 1;
            } else if (pop == '(') {
                s1.push(pop);
                break;
            } else {
                popLevel = 2;
            }
            if (popLevel < level) {
                // 如果当前运算符比s1栈顶运算符优先级高，则将运算符压入s1
                s1.push(pop);
                break;
            } else {
                s2.push(pop);
            }
        }
        // 直接进s1
        s1.push(c);
    }

    /**
     * 处理 括号
     *
     * @param c
     */
    private void process(char c) {
        while (!s1.isEmply()) {
            char pop = (char) s1.pop();
            if (pop == '(') {
                break;
            } else {
                s2.push(pop);
            }
        }
    }


    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(s);
        InfixToSuffix infixToSuffix = new InfixToSuffix(s);
        MyStack.MyArray myArray = infixToSuffix.doTrans();
        myArray.foreach();
        // 计算
        int data = infixToSuffix.compute(myArray);
        System.out.println("结果为：" + data);*/
        List<Integer> list = Arrays.asList(1,3,5,2,4);
        list = list.stream().sorted().collect(Collectors.toList());
        list.forEach(integer -> System.out.println(integer));
    }

    /**
     * 模拟计算机算法
     *
     * @param myArray
     * @return
     */
    private int compute(MyStack.MyArray myArray) {
        // 先将栈逆序出来
        MyStack.MyArray data = new MyStack.MyArray(myArray.getSize());
        while (!myArray.isEmply()) {
            Object pop = myArray.pop();
            data.push(pop);
        }
        // 将数据弹栈计算
        MyStack.MyArray count = new MyStack.MyArray(myArray.getSize());
        while (!data.isEmply()) {
            char pop = (char) data.pop();
            switch (pop) {
                case '+':
                    char a = (char) count.pop();
                    char b = (char) count.pop();
                    int i = b + a;
                    count.push(i);
                    break;
                case '-':
                    char a2 = (char) count.pop();
                    char b2 = (char) count.pop();
                    int i2 = b2 - a2;
                    count.push(i2);
                    break;
                case '*':
                    char a3 = (char) count.pop();
                    char b3 = (char) count.pop();
                    int i3 = b3 * a3;
                    count.push(i3);
                    break;
                case '/':
                    char a4 = (char) count.pop();
                    char b4 = (char) count.pop();
                    int i4 = b4 * a4;
                    count.push(i4);
                    break;
                default:
                    count.push(pop);
            }

        }
        char pop = (char)count.pop();
        return pop;
    }

}
