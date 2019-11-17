package com.zb.service.test;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by bzheng on 2019/7/11.
 * 模拟高并发
 */
public class CompletableFuntureTest {

    // 并发数
    static int count = 1000;

    private static CountDownLatch countDownLatch = new CountDownLatch(count);

    // 阻塞队列
    private static LinkedBlockingQueue<Request> queue = new LinkedBlockingQueue();

    // 服务接口 1000并发压测
    public Map<String, Object> traditionalServer(String orderCode) throws ExecutionException, InterruptedException {
        // 传统方法：引入service类调用方法 -- server被调用一次，就同步调用select方法，并发会造成响应超时。
//        xxxService.select(orderCode);

        // 生成唯一标识 serialNo --- 线程1 -- 一对一关联
        Map<String, Object> map = new HashMap<>();
        map.put(CompletableFuntureTest.orderCode, orderCode);
        return traditionalRemoteService(map);
    }

    // 服务接口 1000并发压测
    public Map<String, Object> server(String orderCode) throws ExecutionException, InterruptedException {
        // 生成唯一标识 serialNo --- 线程1 -- 一对一关联
        String serialNo = UUID.randomUUID().toString();
        Request request = new Request();
        request.setSerialNo(serialNo);
        request.setOrderCode(orderCode);
        // jdk8 特性
        CompletableFuture<Map<String, Object>> future = new CompletableFuture<>();
        request.setFuture(future);
        // 将请求添加进队列
        queue.add(request);
        return future.get(); // 阻塞，等待future.complete(map);调用，get方法返回结果。
    }

    public static String serialNo = "serialNo";

    public static String orderCode = "orderCode";

    /**
     * 队列初始化
     */
    public void init() {

        new Thread(() ->{
            while (true) {
                int size = queue.size();
                System.out.println("size = " + size);
                if (0 == size) {
                    // 没有数据
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    // 存放所有请求，1.取出所有orderCode调用放，同时将serialNo传过去，远程调用方法需要将serialNo返回，作为找到请求的唯一标识
                    // 响应之后，通过serialNo找到request，然后通过future.complate();方法返回
                    List<Request> requests = new ArrayList<>(size);
                    // 存放orderCode
                    List<Map<String, String>> orderCodes = new ArrayList<>(size);
                    // 批量处理数据
                    for (int i = 0; i < size; i++) {
                        Request request = queue.poll();
                        Map<String, String> map = new HashMap<>(4);
                        map.put(serialNo, request.getSerialNo());
                        map.put(orderCode, request.getOrderCode());
                        orderCodes.add(map);
                    }

                    // 远程批量调用
                    System.out.println("开始调用，批量数据：" + orderCodes.size());
                    List<Map<String, Object>> responses = remoteService(orderCodes);
                    // 处理返回数据
                    if (!CollectionUtils.isEmpty(responses)) {
                        // serialNo 与 response 绑定
                        Map<String, Map<String, Object>> responseMap = new HashMap<>();
                        responses.forEach(result -> {
                            String serialNo = result.get(CompletableFuntureTest.serialNo).toString();
                            responseMap.put(serialNo, result);
                        });
                        // 返回数据
                        requests.forEach(request -> {
                            Map<String, Object> result = responseMap.get(request.getSerialNo());
                            // 调用此方法，get()将获取result。
                            request.getFuture().complete(result);
                        });
                    }
                }

            }
        }, "init queue").start();
    }

    class Request {

        // 任务编号
        private String orderCode;

        // 唯一编码
        private String serialNo;

        private CompletableFuture<Map<String, Object>> future;

        public String getOrderCode() {
            return orderCode;
        }

        public void setOrderCode(String orderCode) {
            this.orderCode = orderCode;
        }

        public String getSerialNo() {
            return serialNo;
        }

        public void setSerialNo(String serialNo) {
            this.serialNo = serialNo;
        }

        public CompletableFuture<Map<String, Object>> getFuture() {
            return future;
        }

        public void setFuture(CompletableFuture<Map<String, Object>> future) {
            this.future = future;
        }
    }

    public List<Map<String, Object>> remoteService(List<Map<String, String>> list) {
        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyList();
        }
        List<Map<String, Object>> results = new ArrayList<>(list.size());
        Random random = new Random();
        Date now = new Date();
        String orderTime = DateFormatUtils.format(now, "yyyyMMddHHmmss");
        list.forEach(map -> {
            Map<String, Object> result = new HashMap<>();
            // 将唯一标识返回。
            result.put(serialNo, map.get(serialNo));
            result.put(orderCode, map.get(orderCode));
            int i = random.nextInt(10) * 5 + 1000;
            result.put("data", i);
            result.put("orderTime", orderTime);
            results.add(result);
        });
        return results;
    }

    // 传统调用
    public Map<String, Object> traditionalRemoteService(Map<String, Object> map) {
        Random random = new Random();
        Date now = new Date();
        String orderTime = DateFormatUtils.format(now, "yyyyMMddHHmmss");
        Map<String, Object> result = new HashMap<>();
        // 将唯一标识返回。
        result.put(orderCode, map.get(orderCode));
        int i = random.nextInt(10) * 5 + 1000;
        result.put("data", i);
        result.put("orderTime", orderTime);
        return result;
    }


    public static void main(String[] args) throws InterruptedException {
        // 传统调用 没有在实际项目中测试很难测 现在是本地，也不用连接数据库，如果1000并发，数据库（连接也不够用）承受不住。
        CompletableFuntureTest funtureTest = new CompletableFuntureTest();
        funtureTest.init();
        for (int i = 0; i < count; i++) {
            new Thread(() ->{
                try {
                    countDownLatch.await();
                    // 调用
//                    Map<String, Object> map = funtureTest.traditionalServer("123456789");
                    Map<String, Object> map = funtureTest.server("123456789");
                    System.out.println(map);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }).start();
            countDownLatch.countDown();
        }

    }
}
