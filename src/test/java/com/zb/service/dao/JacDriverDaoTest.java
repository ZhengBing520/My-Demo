package com.zb.service.dao;

import com.zb.service.entity.JacDriver;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by bzheng on 2018/10/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Ignore
public class JacDriverDaoTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    JacDriverDao jacDriverDao;

    @Autowired
    JacMotorcadeVehicleDao jacMotorcadeVehicleDao;

    @Test
    @Ignore
    public void insertList() {
        int size = 200000;
        List<JacDriver> list = new ArrayList<>(size);
        Date date = new Date();
        String by = "root";
        String password = "C9574F1E5B49E11030943A62EE6C6B72";

        String headPicture = "";
        String realName = "";


        String sex = "MALE";

        String orgType = "CUSTOMER";
        Long motorcadeId = 0L;
        String status = "APPLIED";
        String qq = "";
        String email = "";
        String address = "";
        String function = "";
        String nickName = "";
        String salt = "1Ip7";
        for (int i = 1; i <= size; i++) {
            Long orgId = 0L;
            String orgName = "";

            if (i <= 100) {
                orgId = 1526709759946L;
                orgName = "性能车队零";
            } else if (100 < i && i <= 20) {
                orgId = 1526709931299L;
                orgName = "性能车队一";
            } else if (200 < i && i <= 300) {
                orgId = 1527565966938L;
                orgName = "性能车队二";
            } else if (300 < i && i <= 400) {
                orgId = 1527574148627L;
                orgName = "性能车队三";
            } else if (400 < i && i <= 500) {
                orgId = 1527577061112L;
                orgName = "性能车队四";
            } else if (500 < i && i <= 600) {
                orgId = 1531383017118L;
                orgName = "性能车队五";
            } else if (600 < i && i <= 700) {
                orgId = 1530071069487L;
                orgName = "性能车队六";
            } else if (700 < i && i <= 800) {
                orgId = 1537166284528L;
                orgName = "性能车队七";
            } else if (800 < i && i <= 900) {
                orgId = 1540881849246L;
                orgName = "性能车队八";
            } else if (900 < i && i <= 1000) {
                orgId = 1538979561584L;
                orgName = "性能车队九";
            }
            String format = MessageFormat.format("{0,number,000000}", i);
            String username = "1551234" + format;
            long id = System.currentTimeMillis();
            String mobile = "18000" + format;
            String identityCard = "581033199804" + format;
            String driverLicense = "581033199804" + format;
            // String mobile, String password, String identityCard, String sex, Date birthday, String qq, String email, String address, String driverLicense, Date licenseValidDate, String licensePicture, Date qualityValidDate, String qualityPicture, String applyStatus, String defaultVin, String openStolen, String salt
            JacDriver jacDriver = new JacDriver(
                    id, date, date, by, by, null, orgId, headPicture, "司南", "司南", mobile, password, identityCard, sex, null, "", "", "", driverLicense, null, "", null, "",
                    status, "", "YES", salt);
            list.add(jacDriver);

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i % 10000 == 0) {
                Thread thread = new Thread(() ->{
                    System.out.println("list.length = " + list.size());
                    jacDriverDao.insertList(list);
                });
                thread.start();
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                list.clear();
            }
        }
        System.out.println("结束。。。。");

    }

    @Test
    @Ignore
    public void update() {
        Long fleetId = 1538979561575L;
        for (int i = 0; i < 10; i++) {
            List<Long> ids = jacDriverDao.selectIds(fleetId);
            List<String> vins = jacMotorcadeVehicleDao.select(fleetId);
            System.out.println("ids为：" + Arrays.toString(ids.toArray()));
            System.out.println("vins为：" + Arrays.toString(vins.toArray()));
            int y = 0;
            for (Long id : ids) {
                jacDriverDao.update(id, vins.get(y));
                y++;
            }
            int j = 0;
            for (String vin : vins) {
                jacMotorcadeVehicleDao.update(ids.get(j), vin);
                j++;
            }
            fleetId++;
        }


    }
}
