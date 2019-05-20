package com.zb.service.demo.tree;

import java.util.Objects;

/**
 * Created by bzheng on 2019/1/2.
 */
public class BinaryTree implements Tree {

    // 根节点
    private Node root;

    @Override
    public Node find(Object key) {

        return null;
    }

    @Override
    public boolean insert(Object data) {
        if (Objects.isNull(data)) {
            throw new RuntimeException("插入数据不能为null");
        }
        Node node = new Node(data);
        if (Objects.isNull(root)) {
            root = node;
        } else {
            Node curent = root;
//            if (curent)
        }

        return false;
    }

    @Override
    public boolean delete(Object key) {
        return false;
    }
}
