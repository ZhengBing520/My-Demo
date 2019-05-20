package com.zb.service.demo.tree;

/**
 * Created by bzheng on 2019/1/2.
 */
public class Node {

    // 根节点数据
    private Object object;

    // 左子树引用
    private Node leftChild;

    // 右子树引用
    private Node rightChild;

    public Node(Object object) {
        this.object = object;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }
}
