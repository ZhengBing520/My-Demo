package com.zb.service.entity;

import java.util.Date;

/**
 * Created by bzheng on 2019/1/17.
 */

public class JacPoints {

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
     * 当前总积分
     */
    private Integer totalPoint;

    /**
     * 消费积分
     */
    private Integer consumePoint;

    public JacPoints(Date createTime, Date updateTime, String createBy, String updateBy, Long driverId, String account, Integer totalPoint, Integer consumePoint) {
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.driverId = driverId;
        this.account = account;
        this.totalPoint = totalPoint;
        this.consumePoint = consumePoint;
    }

    public JacPoints() {
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
}
