package com.zb.service.service;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.sql.*;
import java.util.Set;

/**
 * Created by bzheng on 2018/8/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
//@Ignore
public class ServiceTest {

    @Autowired
    RedisTemplate redisTemplate;


    @Test
    public void test() {
        Long remove = redisTemplate.opsForSet().remove("vehicle:online","5");
        Long size = redisTemplate.opsForSet().size("vehicle:online");
        System.out.println(remove);
        System.out.println(size);
    }

    @Test
    public void test2() {
        SetOperations<String, String> stringStringSetOperations = redisTemplate.opsForSet();
        for (int i = 0; i< 20; i++) {
            stringStringSetOperations.add("vehicle:online",i+"");
        }
        Long size = stringStringSetOperations.size("vehicle:online");
        System.out.println(size);
    }

    @Test
    public void test3() {
        redisTemplate.opsForValue().set("zb", "zz");
        Object zb = redisTemplate.opsForValue().get("zb");
        System.out.println(zb);
    }

    @Test
    public void test4() {
        RestTemplate restTemplate = new RestTemplate();
        String forObject1 = restTemplate.getForObject("https://www.baidu.com/", String.class);

        String forObject = restTemplate.getForObject("http://demo.jac.incarcloud.com/api/plat/jac-driver/byId", String.class);
        System.out.println(forObject);
    }

    @Test
    public void testjdbc() {
        String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";//加载驱动
        String url = "jdbc:sqlserver://192.168.72.130:1433;DatabaseName=testDb";//连接SQL数据库信息及服务器IP信息
        String userName = "sa";//数据库帐户
        String userPwd = "Aa123456";//数据库密码

        //MSSQL的四大金刚


        //将驱动类全名从硬盘加载到内存
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("类全名【"+driverName+"】没有找到。");
        }

        //三大对象
        Connection conn=null;
        Statement st=null;
        ResultSet rs=null;

        //需要执行的sql语句
        String sql="Select * From test";

        //创建conn
        try {
            //使用驱动管理器DriverManager，创建一个连接对象conn
            conn= DriverManager.getConnection(url, userName, userPwd);

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
