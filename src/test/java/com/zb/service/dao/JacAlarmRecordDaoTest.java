package com.zb.service.dao;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.zb.service.common.Constant;
import com.zb.service.common.utils.DateUtil;
import com.zb.service.dto.AlarmCountResponse;
import com.zb.service.dto.JacVehicleDTO;
import com.zb.service.entity.JacAlarmRecord;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by bzheng on 2018/12/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Ignore
public class JacAlarmRecordDaoTest extends AbstractJUnit4SpringContextTests {


    @Autowired
    JacAlarmRecordDao jacAlarmRecordDao;

    @Autowired
    JacMotorcadeVehicleDao jacMotorcadeVehicleDao;

    @Autowired
    JacVehicleDao jacVehicleDao;

    private static Date now;

    private static String username;

    static {
        now = new Date();
        username = "system";
    }

    /**
     * 10条线程
     */
    private static final int THREAD_NUMBER = 40;

    @Test
    @Ignore
    public void insertList() {
        ThreadPoolExecutor exec = new ThreadPoolExecutor(THREAD_NUMBER, THREAD_NUMBER, 5L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>()
                , new ThreadFactoryBuilder().setNameFormat("JacAlarmRecordInsertList").build());
        exec.allowCoreThreadTimeOut(true);
        int count = jacVehicleDao.getCount();
        int pageSize = 1000;
        int pageNum = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;
        /*int pageNum = THREAD_NUMBER;
        int pageSize = count % pageNum == 0 ? count / pageNum : count / pageNum + 1;*/
        System.out.println("pageSize = " + pageSize);
        // 获取vin码
        for (int i = 150 + 1; i <= 150 + 2; i++) {
//            new Thread(new Executor((i - 1) * pageSize, pageSize)).start();
            exec.execute(new Executor((i - 1) * pageSize, pageSize));
        }
    }

    private class Executor implements Runnable {

        private List<JacVehicleDTO> jacVehicleDTOS;

        private int pageSize;

        private int pageStart;

        public Executor(int pageStart, int pageSize) {
            this.pageSize = pageSize;
            this.pageStart = pageStart;
            this.jacVehicleDTOS = jacVehicleDao.queryVehicles(pageStart, pageSize);
        }

        @Override
        public void run() {
            System.out.println("run ...");
            if (!ObjectUtils.isEmpty(jacVehicleDTOS)) {
                List<JacAlarmRecord> list = new ArrayList<>(jacVehicleDTOS.size() * 25);
                for (JacVehicleDTO jacVehicleDTO : jacVehicleDTOS) {
                    // 循环50次 （每个Vin码添加50个事件）
                    for (int i = 0; i <5; i++) {
                        JacAlarmRecord alarmRecord = createAlarmRecord(jacVehicleDTO);
                        list.add(alarmRecord);
                    }
                }
                System.out.println("inserList ... list.size = " + list.size());
                jacAlarmRecordDao.insertList(list);
                System.out.println("插入完成");
                list = null;
                jacVehicleDTOS = null;
            }
        }

        private JacAlarmRecord createAlarmRecord(JacVehicleDTO jacVehicleDTO) {
            if (null == jacVehicleDTO) {
                return null;
            }
            String alarmType = createAlarmType();

            JacAlarmRecord jacAlarmRecord = new JacAlarmRecord(jacVehicleDTO.getVin(), alarmType, createAlarmConent(alarmType), jacVehicleDTO.getPlateNo(), now, now, jacVehicleDTO.getModelId(), jacVehicleDTO.getMotorcadeId(), jacVehicleDTO.getDealerId(), jacVehicleDTO.getRegionId(), now, now, username, username);
            return jacAlarmRecord;
        }

        private String createAlarmConent(String alarmType) {
            String alarmConent = "";
            switch (alarmType) {
                case Constant.AlarmType.OVERSPEED:
                    alarmConent = "本次超速行驶里程：100米。";
                    break;
                case Constant.AlarmType.TIMEOUT:
                    alarmConent = "停车时长：15分钟。";
                    break;
                case Constant.AlarmType.FATIGUE:
                    alarmConent = "疲劳驾驶时长：19分钟。";
                    break;
                case Constant.AlarmType.OFFLINE:
                    alarmConent = "离线报警，离线时长：4分钟。";
                    break;
                case Constant.AlarmType.FUEL:
                    alarmConent = "异常油耗报警，油耗为：10.0L/km。";
                    break;
            }
            return alarmConent;
        }

        private String createAlarmType() {
            String type = "";
            // 5种报警
            int index = (int) Math.round(Math.random() * 4);
            switch (index) {
                case 0: // 超速报警

                    type = Constant.AlarmType.OVERSPEED;
                    break;
                case 1:// 超时停车报警

                    type = Constant.AlarmType.TIMEOUT;
                    break;
                case 2:// 疲劳驾驶报警

                    type = Constant.AlarmType.FATIGUE;
                    break;
                case 3:// 离线报警

                    type = Constant.AlarmType.OFFLINE;
                    break;
                default: // 异常油量报警
                    type = Constant.AlarmType.FUEL;
                    break;
            }
            return type;
        }

    }

    @Test
    public void update() {

        Date date = DateUtil.minusMonths(new Date(), 6);
//        System.out.println(DateUtil.formatDate(date, DateUtil.DEFAULT_FORMAT));
        for (int i = 1; i<= 183; i++) {
            Date nextDay = DateUtil.getNextDay(date, i);
            Long start = 27 * i * 1000L;
            Long end = 27 * (i+1) * 1000L;
            jacAlarmRecordDao.update(nextDay, start, end);
//            System.out.println(DateUtil.formatDate(nextDay, DateUtil.DEFAULT_FORMAT));

        }

//        jacAlarmRecordDao.update();
    }

    @Test
    public void groupBy() {
        Date date1 = new Date();
        Date date = DateUtil.minusMonths(date1, 5);
        Date end = DateUtil.minusMonths(date1, 4);
        Date nextDay = DateUtil.getNextDay(date, 2);
        List<AlarmCountResponse> alarmCountResponses = jacAlarmRecordDao.groupBy(date, end);
        System.out.println(Arrays.toString(alarmCountResponses.toArray()));
    }
}
