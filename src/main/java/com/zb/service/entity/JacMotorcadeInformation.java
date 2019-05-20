package com.zb.service.entity;

import java.util.Date;

/**
 * Created by bzheng on 2019/2/15.
 */
public class JacMotorcadeInformation {

    /**
     * 车队性质，枚举值，logistics：物流车队，dealer：经销商
     */
    private String property;

    /**
     * 所属物流车队ID
     */
    private Long logisticsId;

    /**
     * 所属经销商ID
     */
    private Long parentId;

    /**
     * 车队名称
     */
    private String motorcadeName;

    /**
     * 车队简称
     */
    private String simpleName;

    /**
     * 省编码
     */
    private String provinceCode;

    /**
     * 省名称
     */
    private String provinceName;

    /**
     * 市编码
     */
    private String cityCode;

    /**
     * 市名称
     */
    private String cityName;

    /**
     * 区编码
     */
    private String areaCode;

    /**
     * 区名称
     */
    private String areaName;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 备注
     */
    private String remark;

    /**
     * 选择类型，枚举值，personal：个人，enterprise：物流企业
     */
    private String type;

    /**
     * '身份证号'
     */
    private String identityCard;

    /**
     * '身份证正面照路径'
     */
    private String identityBack;

    /**
     * '身份证反面照路径'
     */
    private String identityFront;

    /**
     * '营业执照号码'
     */
    private String businessLicense;

    /**
     * '营业执照图片路径'
     */
    private String businessLicensePath;

    /**
     * 组ID，TD用
     */
    private String groupId;

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

    public JacMotorcadeInformation() {
    }

    public JacMotorcadeInformation(String property, Long logisticsId, Long parentId, String motorcadeName, String simpleName, String provinceCode, String provinceName, String cityCode, String cityName, String areaCode, String areaName, String address, String remark, String type, String identityCard, String identityBack, String identityFront, String businessLicense, String businessLicensePath, String groupId, Long id, Date createTime, Date updateTime, String createBy, String updateBy) {
        this.property = property;
        this.logisticsId = logisticsId;
        this.parentId = parentId;
        this.motorcadeName = motorcadeName;
        this.simpleName = simpleName;
        this.provinceCode = provinceCode;
        this.provinceName = provinceName;
        this.cityCode = cityCode;
        this.cityName = cityName;
        this.areaCode = areaCode;
        this.areaName = areaName;
        this.address = address;
        this.remark = remark;
        this.type = type;
        this.identityCard = identityCard;
        this.identityBack = identityBack;
        this.identityFront = identityFront;
        this.businessLicense = businessLicense;
        this.businessLicensePath = businessLicensePath;
        this.groupId = groupId;
        this.id = id;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createBy = createBy;
        this.updateBy = updateBy;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public Long getLogisticsId() {
        return logisticsId;
    }

    public void setLogisticsId(Long logisticsId) {
        this.logisticsId = logisticsId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getMotorcadeName() {
        return motorcadeName;
    }

    public void setMotorcadeName(String motorcadeName) {
        this.motorcadeName = motorcadeName;
    }

    public String getSimpleName() {
        return simpleName;
    }

    public void setSimpleName(String simpleName) {
        this.simpleName = simpleName;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getIdentityBack() {
        return identityBack;
    }

    public void setIdentityBack(String identityBack) {
        this.identityBack = identityBack;
    }

    public String getIdentityFront() {
        return identityFront;
    }

    public void setIdentityFront(String identityFront) {
        this.identityFront = identityFront;
    }

    public String getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense;
    }

    public String getBusinessLicensePath() {
        return businessLicensePath;
    }

    public void setBusinessLicensePath(String businessLicensePath) {
        this.businessLicensePath = businessLicensePath;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
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
