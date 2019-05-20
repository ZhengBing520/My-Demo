package com.zb.service.dao;

import com.zb.service.entity.JacVehicleGps;
import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
 * Created by bzheng on 2019/1/19.
 */
public interface JacVehicleGpsDao {

    int insertList(@Param("list") List<JacVehicleGps> list);
}
