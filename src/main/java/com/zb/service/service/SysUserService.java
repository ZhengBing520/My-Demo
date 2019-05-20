package com.zb.service.service;

import com.zb.service.entity.SysUser;

import java.util.List;

/**
 * Created by bzheng on 2018/10/8.
 */
public interface SysUserService {

    int insertList(List<SysUser> list);

    List<SysUser> selectAll();
}
