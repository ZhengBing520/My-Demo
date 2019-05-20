package com.zb.service.dao;

import com.zb.service.entity.JacPointsRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by bzheng on 2019/1/17.
 */
public interface JacPointsRecordDao {

    int insertList(@Param("list") List<JacPointsRecord> list);
}
