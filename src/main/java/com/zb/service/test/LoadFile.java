package com.zb.service.test;

import com.zb.service.util.FileUtils;

/**
 * Created by bzheng on 2019/3/1.
 */
public class LoadFile {

    public static void main(String[] args) throws Exception{
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        ExecutorService executorService = new ThreadPoolExecutor(10, 100, 10L,TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(), new ThreadFactoryBuilder().setNameFormat("loadFile").build());
        String filePath = "F:\\360MoveData\\Users\\Administrator\\Desktop\\application-local.yml";
        long startTime = System.currentTimeMillis();

// FileUtils.readFile(filePath);
        FileUtils.readFile(filePath, 5, '\n');
        System.out.println("执行时间：" + (System.currentTimeMillis() - startTime) + "ms");
        int i = Runtime.getRuntime().availableProcessors();
        System.out.println(i);
    }
}
