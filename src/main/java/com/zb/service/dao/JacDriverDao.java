package com.zb.service.dao;

import com.zb.service.entity.JacDriver;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by bzheng on 2018/10/10.
 */
public interface JacDriverDao {

    int insertList(@Param("list") List<JacDriver> list);

    int update(@Param("id")Long id,@Param("vin") String vin);

    @Select("select id from driver WHERE fleet_id = #{fleetId}")
    List<Long> selectIds(@Param("fleetId")Long fleetId);

    @Select("select id,driver_name as driverName,mobile from jac_driver limit  #{pageStart},#{pageSize}")
    List<JacDriver> selectIdAll(@Param("pageStart") int pageStart, @Param("pageSize") int pageSize);
}
