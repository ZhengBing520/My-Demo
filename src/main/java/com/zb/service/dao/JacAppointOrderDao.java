package com.zb.service.dao;

import com.zb.service.entity.JacAppointOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by bzheng on 2019/1/10.
 */
public interface JacAppointOrderDao {

    int insertList(@Param("list") List<JacAppointOrder> jacAppointOrder);
}
