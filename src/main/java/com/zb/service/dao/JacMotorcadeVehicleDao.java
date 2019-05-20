package com.zb.service.dao;

import com.zb.service.dto.JacDealerAndMotorcadeDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by bzheng on 2018/10/16.
 */
public interface JacMotorcadeVehicleDao {

    @Select("select vin from jac_motorcade_vehicle WHERE motorcade_id = #{motorcadeId} ORDER BY id limit 10")
    List<String> select(@Param("motorcadeId") Long motorcadeId);

    @Update("update jac_motorcade_vehicle set default_driver_id = #{id} where vin = #{vin}")
    int update(@Param("id")Long id,@Param("vin") String vin);

    @Select("select t.vin, t.plate_no AS plateNo, t.model_id as modelId, i.id AS customerId, i.motorcade_name AS" +
            "        customerName, s.id AS dealerId," +
            "        s.dealer_name AS dealerName, IFNULL(s.parent_id,m.parent_id) AS regionId" +
            "        from jac_motorcade_vehicle t" +
            "        LEFT JOIN jac_motorcade_information i ON i.id = t.motorcade_id" +
            "        LEFT JOIN sys_org_dealer s ON s.id = i.parent_id" +
            "        left join jac_large_logistics_motorcade m on m.id = i.logistics_id" +
            "        WHERE t.vin = #{vin}")
    JacDealerAndMotorcadeDTO getDealerAndMotorcadeByVin(@Param("vin") String vin);

    int updateVehicle(@Param("motorcardId") Long motorcardId, @Param("ids") List<Integer> ids);
}
