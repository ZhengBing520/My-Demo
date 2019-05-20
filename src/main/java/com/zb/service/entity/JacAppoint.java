package com.zb.service.entity;

import java.util.Date;


/**
 * @author GuoKun
 * @version 1.0
 * @create_date 2018-4-17 11:11:06
 */
public class JacAppoint {
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

    private String vin;

    private String plateNo;

    /**
     * 预约类型，枚举类型：maintain 保养；repair 维修 all 维保
     */

    private String appointType;

    /**
     * 预约时间
     */
    private Date appointTime;

    /**
     * 司机ID
     */
    private Long driverId;

    /**
     * 司机名称
     */
    private String driverName;

    /**
     * 预约服务站ID
     */
    private Long appointServiceId;

    /**
     * 预约服务站
     */
    private String appointServiceName;

    /**
     * 经销商ID
     */
    private Long dealerId;

    /**
     * 经销商名称
     */
    private String dealerName;

    /**
     * 车队ID
     */
    private Long motorcadeId;

    /**
     * 车队名称
     */
    private String motorcadeName;

    /**
     * 状态，枚举类型：processed 处理中,  unfinished 预约中 ,  finished  完成，refuse  拒绝
     */
    private String state;

    /**
     * 备注
     */
    private String note;

    public JacAppoint() {
    }

    public JacAppoint(Long id, Date createTime, Date updateTime, String createBy, String updateBy, String vin, String plateNo, String appointType, Date appointTime, Long driverId, String driverName, Long appointServiceId, String appointServiceName, Long dealerId, String dealerName, Long motorcadeId, String motorcadeName, String state, String note) {
        this.id = id;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.vin = vin;
        this.plateNo = plateNo;
        this.appointType = appointType;
        this.appointTime = appointTime;
        this.driverId = driverId;
        this.driverName = driverName;
        this.appointServiceId = appointServiceId;
        this.appointServiceName = appointServiceName;
        this.dealerId = dealerId;
        this.dealerName = dealerName;
        this.motorcadeId = motorcadeId;
        this.motorcadeName = motorcadeName;
        this.state = state;
        this.note = note;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getVin() {
        return this.vin;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public String getPlateNo() {
        return this.plateNo;
    }

    public void setAppointType(String appointType) {
        this.appointType = appointType;
    }

    public String getAppointType() {
        return this.appointType;
    }

    public void setAppointTime(Date appointTime) {
        this.appointTime = appointTime;
    }

    public Date getAppointTime() {
        return this.appointTime;
    }

    public String getAppointServiceName() {
        return appointServiceName;
    }

    public void setAppointServiceName(String appointServiceName) {
        this.appointServiceName = appointServiceName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }

    public String getDealerName() {
        return this.dealerName;
    }

    public void setMotorcadeName(String motorcadeName) {
        this.motorcadeName = motorcadeName;
    }

    public String getMotorcadeName() {
        return this.motorcadeName;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return this.state;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public Long getAppointServiceId() {
        return appointServiceId;
    }

    public void setAppointServiceId(Long appointServiceId) {
        this.appointServiceId = appointServiceId;
    }

    public Long getDealerId() {
        return dealerId;
    }

    public void setDealerId(Long dealerId) {
        this.dealerId = dealerId;
    }

    public Long getMotorcadeId() {
        return motorcadeId;
    }

    public void setMotorcadeId(Long motorcadeId) {
        this.motorcadeId = motorcadeId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("JacAppoint[");
        sb.append("id=");
        sb.append(getId());
        sb.append(",vin=");
        sb.append(vin);
        sb.append(",plateNo=");
        sb.append(plateNo);
        sb.append(",appointType=");
        sb.append(appointType);
        sb.append(",appointTime=");
        sb.append(appointTime);
        sb.append(",driverId=");
        sb.append(driverId);
        sb.append(",driverName=");
        sb.append(driverName);
        sb.append(",appointServiceId=");
        sb.append(appointServiceId);
        sb.append(",appointService=");
        sb.append(appointServiceName);
        sb.append(",dealerId=");
        sb.append(dealerId);
        sb.append(",dealerName=");
        sb.append(dealerName);
        sb.append(",motorcadeId=");
        sb.append(motorcadeId);
        sb.append(",motorcadeName=");
        sb.append(motorcadeName);
        sb.append(",state=");
        sb.append(state);
        sb.append(",createTime=");
        sb.append(getCreateTime());
        sb.append(",updateTime=");
        sb.append(getUpdateTime());
        sb.append(",createBy=");
        sb.append(getCreateBy());
        sb.append(",updateBy=");
        sb.append(getUpdateBy());
        sb.append(",note=");
        sb.append(note);
        sb.append("]");
        return sb.toString();
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
}
