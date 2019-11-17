package com.zb.service.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

/**
 * Created by bzheng on 2018/9/6.
 */
public class A {

    public static void main(String[] args) {
        try {

            Class.forName("org.apache.phoenix.jdbc.PhoenixDriver");

            //这里配置zookeeper的地址，可单个，多个(用","分隔)可以是域名或者ip

            String url = "jdbc:phoenix:119.3.44.112:2181";

            Connection conn = DriverManager.getConnection(url);

            Statement statement = conn.createStatement();

            long time = System.currentTimeMillis();

            ResultSet rs = statement.executeQuery("select * from GBHC_VEHICLE");

            while (rs.next()) {
                /*String myKey = rs.getString("MYKEY");
                String myColumn = rs.getString("MYCOLUMN");

                System.out.println("myKey=" + myKey + "myColumn=" + myColumn);*/
                String string = rs.getString(0);
                System.out.println(string);
            }

            long timeUsed = System.currentTimeMillis() - time;

            System.out.println("time " + timeUsed + "mm");

            // 关闭连接
            rs.close();
            statement.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
