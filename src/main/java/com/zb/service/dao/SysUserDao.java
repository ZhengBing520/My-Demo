package com.zb.service.dao;

import com.zb.service.entity.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by bzheng on 2018/10/8.
 */
public interface SysUserDao {

    int insertList(@Param("list") List<SysUser> list);
}
