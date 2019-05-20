package com.zb.service.demo.tree;

/**
 * Created by bzheng on 2019/1/2.
 * 二叉树
 */
public interface Tree {

    /**
     * 查找数据
     * @param key
     * @return
     */
    Node find(Object key);

    /**
     * 插入数据
     * @param data
     * @return
     */
    boolean insert(Object data);

    /**
     * 删除数据
     * @param key
     * @return
     */
    boolean delete(Object key);
}
