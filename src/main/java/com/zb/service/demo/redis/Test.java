package com.zb.service.demo.redis;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLOutput;

/**
 * Created by bzheng on 2019/1/19.
 */
public class Test {

    public static void main(String[] args) throws Exception {
        // 监控6379端口
        ServerSocket serverSocket = new ServerSocket(63799);
        Socket socket = serverSocket.accept();

        byte[] request = new byte[1024];
        InputStream inputStream = socket.getInputStream();
        inputStream.read(request);
        System.out.println(new String(request));
        socket.close();
        serverSocket.close();
    }
}
