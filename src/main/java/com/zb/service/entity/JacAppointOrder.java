package com.zb.service.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author GuoKun
 * @Despriction 预约维保项目表
 * @Date 2018-6-6 14:54:50
 */
public class JacAppointOrder {

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

    // 预约ID
    private Long appointId;

    // 订单ID
    private String orderId;

    // 交车日期
    private Date overTime;

    // 维保时间
    private Date actionTime;

    // 维保人员ID
    private Integer maintenanceId;

    // 维保人员
    private String maintenanceName;

    // 保养里程数
    private Long maintenanceMil;

    // 接收人
    private String receiveName;

    // 合计费用
    private BigDecimal totalCost;

    // 实际费用
    private BigDecimal actualCost;

    // 核销券
    private String discounts;

    // 维保项
    private String items;

    // 备注
    private String remark;

    public JacAppointOrder() {
    }

    public JacAppointOrder(Date createTime, Date updateTime, String createBy, String updateBy, Long appointId, String orderId, Date overTime, Date actionTime, String maintenanceName, Long maintenanceMil, String receiveName, BigDecimal totalCost, BigDecimal actualCost, String items) {
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.appointId = appointId;
        this.orderId = orderId;
        this.overTime = overTime;
        this.actionTime = actionTime;
        this.maintenanceName = maintenanceName;
        this.maintenanceMil = maintenanceMil;
        this.receiveName = receiveName;
        this.totalCost = totalCost;
        this.actualCost = actualCost;
        this.items = items;
    }

    public void setAppointId(Long appointId) {
        this.appointId = appointId;
    }

    public Long getAppointId() {
        return this.appointId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public void setOverTime(Date overTime) {
        this.overTime = overTime;
    }

    public Date getOverTime() {
        return this.overTime;
    }

    public void setActionTime(Date actionTime) {
        this.actionTime = actionTime;
    }

    public Date getActionTime() {
        return this.actionTime;
    }

    public void setMaintenanceId(Integer maintenanceId) {
        this.maintenanceId = maintenanceId;
    }

    public Integer getMaintenanceId() {
        return this.maintenanceId;
    }

    public void setMaintenanceName(String maintenanceName) {
        this.maintenanceName = maintenanceName;
    }

    public String getMaintenanceName() {
        return this.maintenanceName;
    }

    public void setMaintenanceMil(Long maintenanceMil) {
        this.maintenanceMil = maintenanceMil;
    }

    public Long getMaintenanceMil() {
        return this.maintenanceMil;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }

    public String getReceiveName() {
        return this.receiveName;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public BigDecimal getTotalCost() {
        return this.totalCost;
    }

    public void setActualCost(BigDecimal actualCost) {
        this.actualCost = actualCost;
    }

    public BigDecimal getActualCost() {
        return this.actualCost;
    }

    public void setDiscounts(String discounts) {
        this.discounts = discounts;
    }

    public String getDiscounts() {
        return this.discounts;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public String getItems() {
        return this.items;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return this.remark;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("JacAppointOrder[");
        sb.append("id=");
        sb.append(getId());
        sb.append(",appointId=");
        sb.append(appointId);
        sb.append(",orderId=");
        sb.append(orderId);
        sb.append(",overTime=");
        sb.append(overTime);
        sb.append(",actionTime=");
        sb.append(actionTime);
        sb.append(",maintenanceId=");
        sb.append(maintenanceId);
        sb.append(",maintenanceName=");
        sb.append(maintenanceName);
        sb.append(",maintenanceMil=");
        sb.append(maintenanceMil);
        sb.append(",receiveName=");
        sb.append(receiveName);
        sb.append(",totalCost=");
        sb.append(totalCost);
        sb.append(",actualCost=");
        sb.append(actualCost);
        sb.append(",discounts=");
        sb.append(discounts);
        sb.append(",items=");
        sb.append(items);
        sb.append(",remark=");
        sb.append(remark);
        sb.append(",createTime=");
        sb.append(getCreateTime());
        sb.append(",updateTime=");
        sb.append(getUpdateTime());
        sb.append(",createBy=");
        sb.append(getCreateBy());
        sb.append(",updateBy=");
        sb.append(getUpdateBy());
        sb.append("]");
        return sb.toString();
    }
}
