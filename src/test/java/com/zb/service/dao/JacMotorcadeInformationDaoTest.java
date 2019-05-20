package com.zb.service.dao;

import com.zb.service.entity.JacMotorcadeInformation;
import net.bytebuddy.asm.Advice;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by bzheng on 2019/2/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Ignore
public class JacMotorcadeInformationDaoTest extends AbstractJUnit4SpringContextTests{

    @Autowired
    JacMotorcadeInformationDao jacMotorcadeInformationDao;

    @Test
    public void insertList() {
        int count = 190;
        List<JacMotorcadeInformation> list = new ArrayList<>(count);
        Long defaultId = 1538979561585L;
        Long defaultParentId = 1538978094881L;
        Date now = new Date();
        for (int i = 0; i < count; i++) {
            Long id = defaultId + i;
            Long parentId = defaultParentId + i / 2;
            String motorcadeName = "性能车队" + (11 + i);
            JacMotorcadeInformation jacMotorcadeInformation = create(id, parentId, motorcadeName, now);
            list.add(jacMotorcadeInformation);
        }
        jacMotorcadeInformationDao.insertList(list);
    }

    @Test
    public void updateMotocadeId() {
        System.out.println("");
    }


    /**
     * INSERT INTO `jac2`.`jac_motorcade_information` (`id`, `property`, `logistics_id`, `parent_id`, `group_id`, `motorcade_name`, `simple_name`, `province_code`, `province_name`, `city_code`, `city_name`, `area_code`, `area_name`, `address`, `type`, `identity_card`, `identity_front`, `identity_back`, `business_license`, `business_license_path`, `remark`, `create_time`, `update_time`, `create_by`, `update_by`)
     *                                  VALUES ('1538979561584', 'dealer', '0', '1538978094880', '4064647', '性能车队九', '', '330000', '浙江省', '330100', '杭州市', '330108', '滨江区', '上城路32号', 'enterprise', '431013199208164530', 'static/images/noPicture.png', 'static/images/noPicture.png', NULL, 'static/images/noPicture.png', NULL, '2018-10-08 14:19:22', '2018-11-12 14:03:44', 'root', 'root');
     * @param id
     * @return
     */
    public JacMotorcadeInformation create(Long id, Long parentId, String motorcadeName, Date now) {
        return new JacMotorcadeInformation("dealer",0L, parentId, motorcadeName, "", "330000", "浙江省", "330100", "杭州市", "330108", "滨江区", "上城路32号", "", "enterprise", "431013199208164530", "static/images/noPicture.png", "static/images/noPicture.png", null, "static/images/noPicture.png", "4064646", id, now, now, "root", "root");
    }
}
