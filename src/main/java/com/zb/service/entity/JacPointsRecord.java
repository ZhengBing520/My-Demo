package com.zb.service.entity;

import java.util.Date;

/**
 * Created by bzheng on 2019/1/17.
 */
public class JacPointsRecord {

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
     * 司机ID
     */
    private Long driverId;

    /**
     * app用户账号
     */
    private String account;

    /**
     * 积分项
     */
    private String item;

    /**
     * 积分项代码
     */
    private Integer itemCode;

    /***
     * 积分值
     */
    private Integer point;

    /**
     * 积分类型 PLUS：增加积分，MINUS:扣除积分
     */
    private String pointType;

    /**
     * 当前总积分
     */
    private Integer totalPoint;

    /**
     * 消费总积分
     */
    private Integer consumePoint;


    private String orderId;

    public JacPointsRecord(Date createTime, Date updateTime, String createBy, String updateBy, Long driverId, String account, String item, Integer itemCode, Integer point, String pointType, Integer totalPoint, Integer consumePoint, String orderId) {
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.driverId = driverId;
        this.account = account;
        this.item = item;
        this.itemCode = itemCode;
        this.point = point;
        this.pointType = pointType;
        this.totalPoint = totalPoint;
        this.consumePoint = consumePoint;
        this.orderId = orderId;
    }

    public JacPointsRecord() {
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

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Integer getItemCode() {
        return itemCode;
    }

    public void setItemCode(Integer itemCode) {
        this.itemCode = itemCode;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public String getPointType() {
        return pointType;
    }

    public void setPointType(String pointType) {
        this.pointType = pointType;
    }

    public Integer getTotalPoint() {
        return totalPoint;
    }

    public void setTotalPoint(Integer totalPoint) {
        this.totalPoint = totalPoint;
    }

    public Integer getConsumePoint() {
        return consumePoint;
    }

    public void setConsumePoint(Integer consumePoint) {
        this.consumePoint = consumePoint;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
