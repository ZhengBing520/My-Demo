package com.zb.service.controller;

import com.zb.service.entity.SysUser;
import com.zb.service.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Created by bzheng on 2019/3/14.
 */
@RestController
public class UserController {

    @Autowired
    SysUserService sysUserService;

    @GetMapping("/selectUser")
    public List<SysUser> select() {
        List<SysUser> list = sysUserService.selectAll();
        return list;
    }

    @GetMapping("/insertUser")
    public Integer insert(Integer index) {
        List<SysUser> list = null;
        if (Objects.nonNull(index)) {
            if (index > 0) {
                list = Arrays.asList(new SysUser());
            }
        }
        int i = sysUserService.insertList(list);
        return i;
    }
}
