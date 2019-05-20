package com.zb.service.demo;

/**
 * Created by bzheng on 2018/9/17.
 */
public class StackSignLink {

    private SignLinkendList signLinkendList;

    /**
     * 插入
     * @param value
     */
    public void push(Object value) {
        signLinkendList.push(value);
    }

    public Object pop() {
        Object o = signLinkendList.deleteHead();
        return o;
    }

    public StackSignLink() {
        signLinkendList = new SignLinkendList();
    }

    public static void main(String[] args) {
        StackSignLink signLink = new StackSignLink();
        signLink.push(1);
        signLink.push(2);
        signLink.push(3);
        signLink.signLinkendList.disPlay();
        Object pop = signLink.pop();
        System.out.println(pop);
        signLink.signLinkendList.disPlay();
    }
}
