package com.zb.service.dao;

import com.zb.service.entity.SysOrgDealer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by bzheng on 2019/2/15.
 */
public interface SysOrgDealerDao {

    int insertList(@Param("list") List<SysOrgDealer> list);
}
