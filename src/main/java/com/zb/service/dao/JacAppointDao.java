package com.zb.service.dao;

import com.zb.service.entity.JacAppoint;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by bzheng on 2019/1/10.
 */
public interface JacAppointDao {


    int insertList(@Param("list") List<JacAppoint> jacAppoint);
}
