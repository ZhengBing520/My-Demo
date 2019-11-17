package com.zb.service.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by bzheng on 2019/10/25.
 * 模拟查找数据库求和，一次找5000个数据计算大小
 */
public class MyForkJoin {

    private static int poolSize = Runtime.getRuntime().availableProcessors() * 10;
    private static final ExecutorService executors = Executors.newFixedThreadPool(poolSize);

    private static Long threshold = 5000L;

    private static class FjTask extends RecursiveTask<Long> {

        private long max;

        private long min;


        public FjTask(long max, long min) {
            this.max = max;
            this.min = min;
        }

        @Override
        protected Long compute() {
            if (max - min <= threshold) {
                return result((int) (max - min));

            } else {
                long mid = (max - min) / 2 + min;
                FjTask task1 = new FjTask(mid,min);
                FjTask task2 = new FjTask(max, mid + 1);
                invokeAll(task1, task2);
                long l = task1.join() + task2.join();
                return l;
            }

        }
    }

    /**
     * 单线程
     */
    private static class Normal {

        private long max;

        private long min;

        public Normal(long max, long min) {
            this.max = max;
            this.min = min;
        }

        public Long sum() {
            long sum = 0;
            // 一次获取5000
            long pageNumber = (max - min) / threshold + 1;
            for (int i = 0; i < pageNumber; i++) {
                long result;
                if (i == pageNumber - 1) {
                    result = result((int)(max - (threshold * i)));
                } else {
                    result = result(threshold.intValue());
                }

                sum += result;
            }

            return sum;
        }
    }


    private static class MyFutureTask {



        private long max;

        private long min;

        public MyFutureTask(long max, long min) {
            this.max = max;
            this.min = min;
        }

        public Long sum() {
            long sum = 0;
            // 一次获取5000
            long pageNumber = (max - min) / threshold + 1;
            List<FutureTask<Long>> list = new ArrayList<>((int)pageNumber);

            for (int i = 0; i < pageNumber; i++) {
                FutureTask<Long> futureTask;
                if (i == pageNumber - 1) {
                    int size = (int)(max - (threshold * i));
                    futureTask = new FutureTask<>(() -> result(size));
                } else {
                    futureTask = new FutureTask<>(() -> result(threshold.intValue()));
                }

                executors.execute(futureTask);
                list.add(futureTask);
            }

            // 处理结果
            for (FutureTask<Long> futureTask : list) {
                try {
                    Long aLong = futureTask.get();
                    sum += aLong;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Long max = getMax();
        Long min = getMin();
        System.out.println("最大：" + max + " , 最小：" + min);
        Normal normal = new Normal(max, min);
        Long sum = normal.sum();
        long normalEnd = System.currentTimeMillis();
        System.out.println("normal 方法执行求和 = " + sum + "，耗时：" + (normalEnd - start) + "ms");
        ForkJoinPool pool = new ForkJoinPool(poolSize);
        FjTask fjTask = new FjTask(max, min);
        Long invoke = pool.invoke(fjTask);
        long fjEnd = System.currentTimeMillis();
        System.out.println("FjTask 方法执行求和 = " + invoke + "耗时：" + (fjEnd - normalEnd) + "ms");
        MyFutureTask futureTask = new MyFutureTask(max, min);
        Long ftSum = futureTask.sum();
        System.out.println("MyFutureTask 方法执行求和 = " + ftSum + "耗时：" + (System.currentTimeMillis() - fjEnd) + "ms");

        /**
         * 最大：398667 , 最小：12
         * normal 方法执行求和 = 398667，耗时：16230ms
         * FjTask 方法执行求和 = 398528耗时：817ms
         * MyFutureTask 方法执行求和 = 398667耗时：419ms
         */
    }

    static ThreadLocalRandom random = ThreadLocalRandom.current();

    public static Long getMax() {

        return random.nextLong(10000000);
    }

    public static Long getMin() {

        return random.nextLong(10) + 10;
    }

    /**
     * 模拟数据库
     *
     * @return
     */
    public static long result(int size) {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int[] ints = new int[size];
        for (int i = 0; i < size; i++) {
            ints[i] = 1;
        }
        int sum = Arrays.stream(ints).sum();
        return sum;
    }
}
