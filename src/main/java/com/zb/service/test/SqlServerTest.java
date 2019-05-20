package com.zb.service.test;

import org.springframework.jdbc.core.metadata.SqlServerCallMetaDataProvider;

import java.sql.*;
import java.util.Objects;

/**
 * Created by bzheng on 2019/3/6.
 */
public class SqlServerTest {

    public static void main(String[] args) {

        String mysqlDriver = "com.mysql.jdbc.Driver";

        String driverName1 = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";//加载驱动
        String url = "jdbc:sqlserver://192.168.72.130:1433;DatabaseName=testDb";//连接SQL数据库信息及服务器IP信息
        String userName = "sa";//数据库帐户
        String userPwd = "Aa123456";//数据库密码

        String mysqlUrl = "jdbc:mysql://localhost:3306/jac2?useUnicode=true&characterEncoding=utf-8&autoReconnect=true&failOverReadOnly=false&serverTimezone=GMT%2B8";
        String mysqlUsername = "root";
        String mysqlPassword = "123456";

        //MSSQL的四大金刚


            //将驱动类全名从硬盘加载到内存
            try {
//                Class.forName(mysqlDriver);
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                System.out.println("类全名【"+mysqlDriver+"】没有找到。");
            }

            //三大对象
            Connection conn=null;
            Statement st=null;
            ResultSet rs=null;

            //需要执行的sql语句
            String sql="Select * From MES_Data";

            //创建conn
            try {
                //使用驱动管理器DriverManager，创建一个连接对象conn
                conn=DriverManager.getConnection(url, userName, userPwd);
//                conn=DriverManager.getConnection(mysqlUrl, mysqlUsername, mysqlPassword);
                //使用conn，创建语句对象st
                st=conn.createStatement();

                //使用st，创建结果集对象rs
                rs=st.executeQuery(sql);



                while(rs.next()) {
                    System.out.println(rs.getString(1));
                }


            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }finally {
                //如果conn不为null，则关闭它
                if(conn!=null) {
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("Finished...");
        }



}
