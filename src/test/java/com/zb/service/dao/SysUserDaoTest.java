package com.zb.service.dao;

import com.zb.service.entity.JacDriver;
import com.zb.service.entity.SysUser;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.MessageFormat;
import java.util.*;

/**
 * Created by bzheng on 2018/10/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
/*@Ignore*/
public class SysUserDaoTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    SysUserDao sysUserDao;

    @Autowired
    JacDriverDao jacDriverDao;


    @Test
    public void test1() {
        System.out.println("start..");
    }

    @Test
//    @Ignore
    public void insertList() {
        int size = 200;
        List<SysUser> list = new ArrayList<>(size);
        List<JacDriver> drivers = new ArrayList<>(size);
        Date date = new Date();
        String by = "root";
        String password = "C9574F1E5B49E11030943A62EE6C6B72";

        String headPicture = "";
        String realName = "";

        String orgName = "";
        String sex = "MALE";

        String orgType = "CUSTOMER";
        Long motorcadeId = 0L;
        String status = "ENABLE";

        String driverStatus = "APPLIED";
        String qq = "";
        String email = "";
        String address = "";
        String function = "";
        String nickName = "";
        String salt = "1Ip7";
        Long defaultOrgId = 1538979561574L;
        Long defaultId = 1539226381739L;


        for (int i = 1; i <= size; i++) {
            Long orgId = defaultOrgId + i;
            Long userId = defaultId + size + i;
            Long id = defaultId + i;
            String format = MessageFormat.format("{0,number,0000}", i);
            String username = "xnUsr" + format;
            String mobile = "1804051" + format;
            String identityCard = "58103319980422" + format;
            String driverLicense = "58103319980422" + format;
            SysUser sysUser = new SysUser(userId, date, date, by, by, username, password, headPicture, realName, mobile, identityCard, sex, orgId, orgName, orgType, motorcadeId, status, qq, email, address,
                    function, nickName, salt);
            JacDriver jacDriver = new JacDriver(
                    id, date, date, by, by, null, orgId, headPicture, "司南", "司南", mobile, password, identityCard, sex, null, "", "", "", driverLicense, null, "", null, "",
                    driverStatus,"", "YES", salt);
            list.add(sysUser);
            drivers.add(jacDriver);
        }

        /*sysUserDao.insertList(list);*/
        jacDriverDao.insertList(drivers);
    }


    @Test
    @Ignore
    public void insertList2() {
        int size = 200;
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
            if (i <= 10) {
                orgId = 1538979561575L;
                orgName = "性能车队零";
            } else if (10 < i && i <= 20) {
                orgId = 1538979561576L;
                orgName = "性能车队一";
            } else if (20 < i && i <= 30) {
                orgId = 1538979561577L;
                orgName = "性能车队二";
            } else if (30 < i && i <= 40) {
                orgId = 1538979561578L;
                orgName = "性能车队三";
            } else if (40 < i && i <= 50) {
                orgId = 1538979561579L;
                orgName = "性能车队四";
            } else if (50 < i && i <= 60) {
                orgId = 1538979561580L;
                orgName = "性能车队五";
            } else if (60 < i && i <= 70) {
                orgId = 1538979561581L;
                orgName = "性能车队六";
            } else if (70 < i && i <= 80) {
                orgId = 1538979561582L;
                orgName = "性能车队七";
            } else if (80 < i && i <= 90) {
                orgId = 1538979561583L;
                orgName = "性能车队八";
            } else if (90 < i && i <= 100) {
                orgId = 1538979561584L;
                orgName = "性能车队九";
            }
            String format = MessageFormat.format("{0,number,0000}", i);
            String username = "1551234" + format;
            long id = System.currentTimeMillis();
            String mobile = "1804051" + format;
            String identityCard = "58103319980422" + format;
            String driverLicense = "58103319980422" + format;
                    // String mobile, String password, String identityCard, String sex, Date birthday, String qq, String email, String address, String driverLicense, Date licenseValidDate, String licensePicture, Date qualityValidDate, String qualityPicture, String applyStatus, String defaultVin, String openStolen, String salt
            JacDriver jacDriver = new JacDriver(
                    id, date, date, by, by, null, orgId, headPicture, "司南", "司南", mobile, password, identityCard, sex, null, "", "", "", driverLicense, null, "", null, "",
                    status,"", "YES", salt);
            list.add(jacDriver);

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        jacDriverDao.insertList(list);
    }

    @Test
    public void test() {
        List<JacDriver> drivers = jacDriverDao.selectIdAll(0, 10);
        System.out.println(Arrays.toString(drivers.toArray()));
    }
}
