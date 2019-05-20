package com.zb.service.dao;

import com.zb.service.dto.JacVehicleDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by bzheng on 2018/12/17.
 */
public interface JacVehicleDao {

    @Select("SELECT v.vin,v.plate_no as plateNo,v.model_id as modelId,v.motorcade_id AS motorcadeId,v.dealer_id AS dealerId,v.region_id AS regionId from jac_vehicle v LIMIT #{pageStart},#{pageSize}")
    List<JacVehicleDTO> queryVehicles(@Param("pageStart") int pageStart, @Param("pageSize") int pageSize);

    @Select("select count(1) from jac_vehicle")
    int getCount();

   // @Update("UPDATE jac_vehicle SET motorcade_id = #{motorcardId}, dealer_id = #{dealerId} WHERE FIND_IN_SET(id #{ids})")
    int updateVehicle(@Param("motorcardId") Long motorcardId, @Param("dealerId") Long dealerId, @Param("ids") List<Integer> ids);
}
