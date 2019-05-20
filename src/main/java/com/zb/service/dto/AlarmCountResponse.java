package com.zb.service.dto;

import java.io.Serializable;

/**
 * @author acemma
 * @date 2018/5/8 13:47
 * @Description
 */
public class AlarmCountResponse implements Serializable {

    private String alarmType;

    private Integer alarmCount;

    private String date;

    public String getAlarmType() {
        return alarmType;
    }

    public void setAlarmType(String alarmType) {
        this.alarmType = alarmType;
    }

    public Integer getAlarmCount() {
        return alarmCount;
    }

    public void setAlarmCount(Integer alarmCount) {
        this.alarmCount = alarmCount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
