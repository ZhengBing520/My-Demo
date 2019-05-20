package com.zb.service.dao;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

/**
 * Created by bzheng on 2018/10/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Ignore
public class JacMotorcadeVehicleDaoTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    JacMotorcadeVehicleDao jacMotorcadeVehicleDao;

    @Test
    @Ignore
    public void Test() {
        List<String> select = jacMotorcadeVehicleDao.select(1538979561575L);
        Arrays.toString(select.toArray());

    }
}
