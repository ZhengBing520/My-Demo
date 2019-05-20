package com.zb.service.dao;

import com.zb.service.entity.JacPoints;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by bzheng on 2019/1/17.
 */
public interface JacPointsDao {

    int insertList(@Param("list") List<JacPoints> list);
}
