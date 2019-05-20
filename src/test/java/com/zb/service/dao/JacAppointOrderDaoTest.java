package com.zb.service.dao;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.zb.service.common.Constant;
import com.zb.service.dto.JacVehicleDTO;
import com.zb.service.entity.JacAlarmRecord;
import com.zb.service.entity.JacAppoint;
import com.zb.service.entity.JacAppointOrder;
import com.zb.service.entity.JacDriver;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.ObjectUtils;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by bzheng on 2019/1/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Ignore
public class JacAppointOrderDaoTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    JacAppointOrderDao jacAppointOrderDao;

    @Autowired
    JacAppointDao jacAppointDao;

    private static Date now;

    private static String username;

    @Autowired
    JacVehicleDao jacVehicleDao;

    @Autowired
    JacDriverDao jacDriverDao;

    AtomicLong atomicLong = new AtomicLong(1027929);

    private Long appointServiceId = 6333345543904L;

    private String appointServiceName = "武汉汉捷汽车维修服务有限公司";

    private Long orgDealer = 7443761646230L;

    private String orgDelerName = "成都宏昌汽车贸易有限责任公司";

    // 车队map
    static Map<Long, String> map  = new HashMap<>();

    private Integer count = THREAD_NUMBER;

    // 合计费用
    private BigDecimal totalCost = new BigDecimal(100);

    // 实际费用
    private BigDecimal actualCost = new BigDecimal(100);

    CountDownLatch countDownLatch = new CountDownLatch(count - 1);

    /**
     * 10条线程
     */
    private static final int THREAD_NUMBER = 40;

    static {
        now = new Date();
        username = "system";
        map.put(1538979561575L, "性能车队零");
        map.put(1538979561576L, "性能车队一");
        map.put(1538979561577L, "性能车队二");
        map.put(1538979561578L, "性能车队三");
        map.put(1538979561579L, "性能车队四");
        map.put(1538979561580L, "性能车队五");
        map.put(1538979561581L, "性能车队六");
        map.put(1538979561582L, "性能车队七");
        map.put(1538979561583L, "性能车队八");
        map.put(1538979561584L, "性能车队九");
    }

    @Test
    @Ignore
    public void insertList() {

        // 1.获取司机id，
//        jacDriverDao.selectIdAll();
        // 2.获取Vin码和车牌号，车队 20万车，20万用户造一个数据
//        jacVehicleDao.queryVehicles();


        // 3.插入数据

        ThreadPoolExecutor exec = new ThreadPoolExecutor(THREAD_NUMBER, THREAD_NUMBER, 100L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>()
                , new ThreadFactoryBuilder().setNameFormat("JacAppointOrderDaoInsertList").build());
        exec.allowCoreThreadTimeOut(true);
//        int count = jacVehicleDao.getCount();
        int pageSize = 1000;
//        int pageNum = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;
        /*int pageNum = THREAD_NUMBER;
        int pageSize = count % pageNum == 0 ? count / pageNum : count / pageNum + 1;*/
//        System.out.println("pageSize = " + pageSize);
        int a = 0;
        // 获取vin码 200页
        for (int i = 80 + 1; i <= 80 + count; i++) {
            a++;
//            new Thread(new Executor((i - 1) * pageSize, pageSize)).start();
            exec.execute(new Executor((i - 1) * pageSize, pageSize));
        }
        try {
            countDownLatch.await(2 * 60000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(a);
    }
    private class Executor implements Runnable {

        private List<JacVehicleDTO> jacVehicleDTOS;

        private List<JacDriver> jacDrivers;

        private int pageSize;

        private int pageStart;

        public Executor(int pageStart, int pageSize) {
            this.pageSize = pageSize;
            this.pageStart = pageStart;
            this.jacVehicleDTOS = jacVehicleDao.queryVehicles(pageStart, pageSize);
            this.jacDrivers = jacDriverDao.selectIdAll(pageStart, pageSize);
        }

        @Override
        public void run() {
            System.out.println("run ...");
            if (!ObjectUtils.isEmpty(jacVehicleDTOS)) {
                List<JacAppoint> list = new ArrayList<>(jacDrivers.size() * 2);
                List<JacAppointOrder> orderList = new ArrayList<>(jacDrivers.size() * 2);
                for (int i = 0; i < jacDrivers.size(); i++) {
                    JacVehicleDTO jacVehicleDTO = null;
                    if (i < jacVehicleDTOS.size()) {
                        jacVehicleDTO = jacVehicleDTOS.get(i);
                    }

                    JacDriver jacDriver = jacDrivers.get(i);
                    for (int j = 0; j <2; j++) {
                        JacAppoint jacAppoint = createAppoint(jacVehicleDTO,jacDriver);
                        JacAppointOrder jacAppointOrder = createJacAppointOrder(jacAppoint.getId());
                        orderList.add(jacAppointOrder);
                        list.add(jacAppoint);
                    }
                }
                System.out.println("插入开始");
                jacAppointDao.insertList(list);
                jacAppointOrderDao.insertList(orderList);
               /* list = null;
                this.jacVehicleDTOS = null;
                this.jacDrivers = null;*/
            }
            countDownLatch.countDown();
        }

        private JacAppoint createAppoint(JacVehicleDTO jacVehicleDTO, JacDriver jacDriver) {
            if (null == jacVehicleDTO) {
                return createDefaultAppoint(jacDriver);
            }
/**
 * this.vin = vin;
 *         this.plateNo = plateNo;
 *         this.appointType = appointType;
 *         this.appointTime = appointTime;
 *         this.driverId = driverId;
 *         this.driverName = driverName;
 *         this.appointServiceId = appointServiceId;
 *         this.appointServiceName = appointServiceName;
 *         this.dealerId = dealerId;
 *         this.dealerName = dealerName;
 *         this.motorcadeId = motorcadeId;
 *         this.motorcadeName = motorcadeName;
 *         this.state = state;
 *         this.note = note;
 */
            JacAppoint jacAppoint = new JacAppoint(atomicLong.getAndIncrement(), now, now, username, username, jacVehicleDTO.getVin(), jacVehicleDTO.getPlateNo(),
                    "all", now, jacDriver.getId(), jacDriver.getDriverName(), appointServiceId, appointServiceName, orgDealer,
                    orgDelerName, jacVehicleDTO.getMotorcadeId(), map.get(jacVehicleDTO.getMotorcadeId()), "finished", "测试");
            return jacAppoint;
        }

        private JacAppoint createDefaultAppoint(JacDriver jacDriver) {
            JacAppoint jacAppoint = new JacAppoint(atomicLong.getAndIncrement(), now, now, username, username, "13301316231", "13301316231",
                    "all", now, jacDriver.getId(), jacDriver.getDriverName(), appointServiceId, appointServiceName, orgDealer,
                    orgDelerName, 1538979561584L, map.get(1538979561584L), "finished", "测试");
            return jacAppoint;
        }

        private JacAppointOrder createJacAppointOrder(Long appointId) {
            JacAppointOrder jacAppointOrder = new JacAppointOrder(now, now, username, username, appointId, "12121", now, now, "测试", 1110L, "测试", totalCost, actualCost, "保养检查");
            return jacAppointOrder;
        }

    }

}
