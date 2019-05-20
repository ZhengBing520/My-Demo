package com.zb.service.dao;

import com.zb.service.entity.SysOrgDealer;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by bzheng on 2019/2/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Ignore
public class SysOrgDealerDaoTest extends AbstractJUnit4SpringContextTests{

    @Autowired
    SysOrgDealerDao sysOrgDealerDao;

    @Test
    public void insertList() {
        int count = 95;
        List<SysOrgDealer> list = new ArrayList<>(count);
        Long defaultId = 1538978094881L;
        String defaultDealerCode = "JAC005";
        Date now = new Date();
        for (int i = 0; i < count; i++) {
            Long id = defaultId + i;
            String dealerName = "性能经销商" + (6 + i);
            String simpleName = "性能" + (6 + i);
            String dealerCode = defaultDealerCode + MessageFormat.format("{0,number,000}", i + 6);
            SysOrgDealer sysOrgDealer = create(id, dealerName, simpleName, dealerCode, now);
            list.add(sysOrgDealer);
        }
        sysOrgDealerDao.insertList(list);
    }

    public SysOrgDealer create(Long id, String dealerName, String simpleName, String dealerCode, Date now) {
        return new SysOrgDealer(1538970561087L, "static/images/noPicture.png", dealerName, simpleName,"320000", "江苏省", "320200", "无锡市", "320202", "崇安区", dealerCode, "光华大道5号", "1", "18788750005","程经理", "18688990004","AFACCB3D2D7871B0C5292B41E825EAD3", "ENABLE", null, "",null, null, null, null,null,"RUNNING",id, now, now, "root", "root");
    }
}
