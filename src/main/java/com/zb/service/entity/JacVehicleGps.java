package com.zb.service.entity;

import java.util.Date;

/**
 * Created by bzheng on 2018/4/23.
 */
public class JacVehicleGps {

    /**
     * id
     */
    private Long id;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建用户
     */
    private String createBy;

    /**
     * 修改用户
     */
    private String updateBy;

    /**
     * vin
     */
    private String vin;

    /**
     * 报警ID
     */
    private Long alarmId;

    /**
     * '经度'
     */
    private Double lng;

    /**
     * '纬度'
     */
    private Double lat;

    /**
     * '速度 单位：km/h'
     */
    private Double speed;

    /**
     * '高度 单位：m'
     */
    private Integer altitude;

    /**
     * '方向 N、NE、E、SE、S、SW、W、NW'
     */
    private String direction;

    /**
     * '报警信息'
     */
    private String alarmMessage;

    /**
     * 故障类型
     */
    private Integer eventType;

    /**
     * 上报时间
     */
    private Date eventTime;

    public JacVehicleGps() {
    }

    public JacVehicleGps(Date createTime, Date updateTime, String createBy, String updateBy, String vin, Long alarmId, Double lng, Double lat, Double speed, Integer altitude, String direction, String alarmMessage, Integer eventType, Date eventTime) {
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.vin = vin;
        this.alarmId = alarmId;
        this.lng = lng;
        this.lat = lat;
        this.speed = speed;
        this.altitude = altitude;
        this.direction = direction;
        this.alarmMessage = alarmMessage;
        this.eventType = eventType;
        this.eventTime = eventTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Long getAlarmId() {
        return alarmId;
    }

    public void setAlarmId(Long alarmId) {
        this.alarmId = alarmId;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Integer getAltitude() {
        return altitude;
    }

    public void setAltitude(Integer altitude) {
        this.altitude = altitude;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getAlarmMessage() {
        return alarmMessage;
    }

    public void setAlarmMessage(String alarmMessage) {
        this.alarmMessage = alarmMessage;
    }

    public Integer getEventType() {
        return eventType;
    }

    public void setEventType(Integer eventType) {
        this.eventType = eventType;
    }

    public Date getEventTime() {
        return eventTime;
    }

    public void setEventTime(Date eventTime) {
        this.eventTime = eventTime;
    }
}
