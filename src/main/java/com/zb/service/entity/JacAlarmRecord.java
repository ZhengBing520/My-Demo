package com.zb.service.entity;

import java.util.Date;

/**
 * Created by bzheng on 2018/4/18.
 */
public class JacAlarmRecord {

    /**
     * 'vin码'
     */
    private String vin;

    /**
     * '报警类型，枚举值, OVERSPEED:超速报警，TIMEOUT:超时停车报警，FATIGUE:疲劳驾驶报警,OFFLINE；离线报警,FUEL:异常油量报警'
     */
    private String alarmType;

    /**
     * 报警内容
     */
    private String alarmContent;

    /**
     * '车牌号'
     */
    private String plateNo;

    /**
     * ''报警开始时间''
     */
    private Date alarmStartTime;

    /**
     * 报警结束时间
     */
    private Date alarmEndTime;

    /**
     * '报警值'
     */
    private Double alarmValue;

    /**
     * '报警阈值'
     */
    private Double alarmThreshold;

    /**
     * '超出阈值 （%）'
     */
    private Double beyondThreshold;

    /**
     * 车型ID
     */
    private Long modelId;

    /**
     * '所属客户ID'
     */
    private Long customerId;

    /**
     * '所属客户'
     */
    private String customerName;

    /**
     * '所属经销商ID'
     */
    private Long dealerId;

    /**
     * '所属经销商名称'
     */
    private String dealerName;

    /**
     * 所属大区ID
     */
    private Long regionId;

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

    public JacAlarmRecord() {
    }

    public JacAlarmRecord(String vin, String alarmType, String alarmContent, String plateNo, Date alarmStartTime, Date alarmEndTime, Long modelId, Long customerId, Long dealerId, Long regionId, Date createTime, Date updateTime, String createBy, String updateBy) {
        this.vin = vin;
        this.alarmType = alarmType;
        this.alarmContent = alarmContent;
        this.plateNo = plateNo;
        this.alarmStartTime = alarmStartTime;
        this.alarmEndTime = alarmEndTime;
        this.modelId = modelId;
        this.customerId = customerId;
        this.dealerId = dealerId;
        this.regionId = regionId;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createBy = createBy;
        this.updateBy = updateBy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getAlarmType() {
        return alarmType;
    }

    public void setAlarmType(String alarmType) {
        this.alarmType = alarmType;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public Date getAlarmStartTime() {
        return alarmStartTime;
    }

    public void setAlarmStartTime(Date alarmStartTime) {
        this.alarmStartTime = alarmStartTime;
    }

    public Date getAlarmEndTime() {
        return alarmEndTime;
    }

    public void setAlarmEndTime(Date alarmEndTime) {
        this.alarmEndTime = alarmEndTime;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Long getDealerId() {
        return dealerId;
    }

    public void setDealerId(Long dealerId) {
        this.dealerId = dealerId;
    }

    public String getDealerName() {
        return dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }

    public String getAlarmContent() {
        return alarmContent;
    }

    public void setAlarmContent(String alarmContent) {
        this.alarmContent = alarmContent;
    }

    public Long getModelId() {
        return modelId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public Double getAlarmValue() {
        return alarmValue;
    }

    public void setAlarmValue(Double alarmValue) {
        this.alarmValue = alarmValue;
    }

    public Double getAlarmThreshold() {
        return alarmThreshold;
    }

    public void setAlarmThreshold(Double alarmThreshold) {
        this.alarmThreshold = alarmThreshold;
    }

    public Double getBeyondThreshold() {
        return beyondThreshold;
    }

    public void setBeyondThreshold(Double beyondThreshold) {
        this.beyondThreshold = beyondThreshold;
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
