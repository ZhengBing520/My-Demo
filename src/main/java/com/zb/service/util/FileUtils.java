package com.zb.service.util;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.io.*;
import java.util.concurrent.*;

/**
 * Created by bzheng on 2019/3/1.
 */
public class FileUtils {

    /**
     * 功能：Java读取txt文件的内容
     * 步骤：1：先获得文件句柄
     * 2：获得文件句柄当做是输入一个字节码流，需要对这个输入流进行读取
     * 3：读取到输入流后，需要读取生成字节流
     * 4：一行一行的输出。readline()。
     * 备注：需要考虑的是异常情况
     *
     * @param filePath
     */
    public static void readFile(String filePath) {
        // 1.
        BufferedReader bufferedReader = null;
        try {
            File file = new File(filePath);
            if (file.isFile() && file.exists()) {
                // 2
                InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), "utf-8");
                bufferedReader = new BufferedReader(inputStreamReader);
                String lineTxt = null;
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    System.out.println(lineTxt);
                }
            } else {
                System.out.println("没有此文件");
            }
        } catch (Exception e) {
            System.out.println("文件读取出错");
        } finally {
            if (null != bufferedReader) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    /**
     * 多线程处理文件 不能按行处理
     *
     * @param filePath 文件路径
     * @param thNum    线程数
     */
    public static void readFile(String filePath, int thNum) {

        if (0 >= thNum) {
            thNum = 10;
        }
        CountDownLatch countDownLatch = new CountDownLatch(thNum);
        // 线程池
        ThreadPoolExecutor executorService = new ThreadPoolExecutor(thNum /2, thNum,
                1L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(), new ThreadFactoryBuilder().setNameFormat("ReadFileThread").build());
        // 线程执行完，线程池销毁
        executorService.allowCoreThreadTimeOut(true);
        File file = new File(filePath);
        if (file.isFile() && file.exists()) {
            // 判断文件每次读多少字节长度
            long length = file.length();
            long eventThread = length / thNum;
            for (int i = 0; i < thNum; i++) {
                RandomAccessFile randomAccessFile = null;
                try {
                    randomAccessFile = new RandomAccessFile(file, "rw");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                if (null != randomAccessFile) {
                    if (i == thNum - 1) {
                        // 最有一次读到最后
                        executorService.execute(new ReadFileThread(eventThread * i, length, countDownLatch, randomAccessFile));
                    } else {
                        executorService.execute(new ReadFileThread(eventThread * i, eventThread * (i + 1), countDownLatch, randomAccessFile));
                    }
                }
            }
           /* try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/

        } else {
            System.out.println("没有此文件");
        }
    }

    /**
     * 执行线程
     */
    public static class ReadFileThread implements Runnable {

        // 开始点
        private long start;

        // 结束点
        private long end;

        // 缓存大小
        private final int bufLen = 256;

        private CountDownLatch countDownLatch;

        private RandomAccessFile randomAccessFile;

        public ReadFileThread(long start, long end, CountDownLatch countDownLatch, RandomAccessFile randomAccessFile) {
            this.start = start;
            this.end = end;
            this.countDownLatch = countDownLatch;
            this.randomAccessFile = randomAccessFile;
        }

        @Override
        public void run() {
            try {
                // 设置读取的偏移量
                randomAccessFile.seek(start);
                // 计算需要读取次数
                if (end < start) {
                    return;
                }
                long time = (end -start) / bufLen + 1;
//                System.out.println("读取次数：" + time);
                // 缓冲区
                byte[] bytes = new byte[bufLen];
                int readLen = 0;
                String result = null;
//                System.out.println(Thread.currentThread().getName() + "读取开始长度：" + start + ",结束长度：" + end);
                for (int i = 0; i < time; i++) {
                    if (i == time - 1) {
                        long l = end - bufLen * (time - 1) - start;
                        bytes = new byte[(int)l];
                    }
                    readLen = randomAccessFile.read(bytes);
                    if (0 > readLen) {
                        break;
                    }
                    result = new String(bytes, "utf-8");
                    System.out.println(result);
                }
//                countDownLatch.countDown();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * 多线程处理文件 不能按行处理
     *
     * @param filePath 文件路径
     * @param thNum    线程数
     * @param separator 分隔符
     */
    public static void readFile(String filePath, int thNum, char separator) throws Exception{
        if (0 >= thNum) {
            thNum = Runtime.getRuntime().availableProcessors();
        }
        // 线程池
        ThreadPoolExecutor executorService = new ThreadPoolExecutor(thNum /2, thNum,
                1L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(), new ThreadFactoryBuilder().setNameFormat("ReadFileThread").build());
        // 线程执行完，线程池销毁
        executorService.allowCoreThreadTimeOut(true);

        RandomAccessFile accessFile = new RandomAccessFile(filePath, "r");
        // 文件大小
        long length = accessFile.length();
        // 每次读取的平均数据
        long gap = length / thNum;
        long[] startIndex = new long[thNum];
        long[] endIndex = new long[thNum];
        long index = 0;
        for (int i = 0; i < thNum; i++) {
            startIndex[i] = index;
            if (i == thNum - 1) {
                endIndex[i] = length;
                executorService.execute(new ReadFileThread(startIndex[i], endIndex[i], null, accessFile));
                break;
            }
            index += gap;
            // 获取最近一个分段标记的位置(此index不一定刚好是一行的结尾，得向前读到分隔符位置)
            long gapToEof = getGapToEof(index, accessFile, separator);
            index += gapToEof;
            endIndex[i] = index;
            executorService.execute(new ReadFileThread(startIndex[i], endIndex[i], null, accessFile));
        }

    }

    /**
     * 获取最近一个分隔符的位置
     * @param index
     * @param accessFile
     * @param separator
     * @return
     */
    private static long getGapToEof(long index, RandomAccessFile accessFile, char separator) throws Exception{
        accessFile.seek(index);
        long count = 0;
        while (accessFile.read() != separator) {
            count++;
        }
        count++;
        return count;
    }

}
