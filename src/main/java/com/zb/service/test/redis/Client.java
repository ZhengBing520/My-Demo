package com.zb.service.test.redis;

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by bzheng on 2018/10/19.
 */
public class Client {

    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(63799);
        Socket accept = serverSocket.accept();
        OutputStream outputStream = accept.getOutputStream();
        byte[] bytes = new byte[1024];
        outputStream.write(bytes);
        System.out.println(bytes);
    }
}
