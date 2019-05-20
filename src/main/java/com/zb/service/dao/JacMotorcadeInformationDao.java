package com.zb.service.dao;

import com.zb.service.entity.JacMotorcadeInformation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by bzheng on 2019/2/15.
 */
public interface JacMotorcadeInformationDao {

    int insertList(@Param("list") List<JacMotorcadeInformation> list);
}
