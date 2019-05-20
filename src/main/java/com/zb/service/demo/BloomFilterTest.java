package com.zb.service.demo;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.util.*;

/**
 * Created by bzheng on 2018/12/10.
 * 布隆过滤算法测试--判断一个key是否在集合里（有误差，可设置 >0），防止别人故意查询不存在的key，主要用于数据量大的查询。例如将快递单号缓存在redis中，你要输入一个
 * 没有的key那么将找数据库，查找数据库耗时并且消耗连接资源。布隆过滤器相当于是一道白名单防火墙
 */
public class BloomFilterTest {

    // 插入数据个数 （千万）
    private Integer insertions = 10000000;

    // list集合（所有数据）
    private List<String> lists = new ArrayList<>(insertions);

    // set集合 （查找key）
    private Set<String> sets = new HashSet<>(insertions);

    public static void main(String[] args) {

        BloomFilterTest bloomFilterTest = new BloomFilterTest();
        // 默认的误差为0.03，可以自己设置误差，但是要大于0
        BloomFilter<String> bf = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8), bloomFilterTest.insertions);
        // 设置误差为千分之一
//        BloomFilter<String> bf = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8), insertions, 0.001);
        bloomFilterTest.initData(bf);
        // 一千万的key，在10000个key中找出100个正确的key，试一下布隆过滤的准确性和速度
        int rightCount = 0;
        int errorCount = 0;
        for (int i = 0; i < 10000; i++) {
            String key = "";
            if (i % 100 == 0) {
                key = bloomFilterTest.lists.get(i);
            } else {
                key = UUID.randomUUID().toString();
            }
            if (bf.mightContain(key)) {
                // 布隆过滤器放进来的key
                if (bloomFilterTest.sets.contains(key)) {
                    rightCount++;
                } else {
                    errorCount++;
                }
            }
        }
        System.out.println("布隆过滤的正确数：" + rightCount + ",错误数：" + errorCount);
        //布隆过滤的正确数：100,错误数：278
        // 10000个key里面找出了278个key是判断错误的 差不多3%
    }

    private void initData(BloomFilter<String> bf) {
        for (int i = 0; i < insertions; i++) {
            String s = UUID.randomUUID().toString();
            lists.add(s);
            sets.add(s);
            bf.put(s);
        }
    }
}
