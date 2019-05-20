package com.zb.service.service.impl;

import com.zb.service.dao.SysUserDao;
import com.zb.service.entity.JacDriver;
import com.zb.service.entity.SysUser;
import com.zb.service.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Created by bzheng on 2018/10/8.
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    SysUserDao sysUserDao;

    @Autowired
    ApplicationContext applicationContext;

    @Override
    @Transactional
    public int insertList(List<SysUser> sysUserList) {
        int size = 2;
        List<SysUser> list = new ArrayList<>(size);
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
            list.add(sysUser);
        }

        int i = sysUserDao.insertList(list);
        // 事件驱动
        String message = "";
        if (!CollectionUtils.isEmpty(sysUserList) && sysUserList.size() > 0)
            message = "success";
        else
            message = "fail";
        applicationContext.publishEvent(message);
        return i;
    }

    @Override
    public List<SysUser> selectAll() {
        List<SysUser> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            SysUser sysUser = new SysUser();
            sysUser.setId(i + 1L);
            list.add(sysUser);
        }
        // 事件驱动
        int a = 2;
        Integer b = 5;
        applicationContext.publishEvent(a);
        applicationContext.publishEvent(b);
        applicationContext.publishEvent(a + "");
        return list;
    }


}
