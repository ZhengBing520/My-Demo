package com.zb.service.entity;

import java.math.BigDecimal;
import java.util.Date;

public class SysOrgDealer {

    /**
     * 所属大区ID
     */
    private Long parentId;

    /**
     * 图片地址，相对路径
     */
    private String dealerFilePath;

    /**
     * 经销商名称
     */
    private String dealerName;

    /**
     * 供应商简称
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
     * 经销商代码
     */
    private String dealerCode;

    /**
     * 经销商详细地址
     */
    private String dealerAddr;

    /**
     * 经营品牌(1：帅铃，2:骏铃，3:康铃)
     */
    private String brandType;

    /**
     * 销售/服务电话
     */
    private String hotline;

    /**
     * 负责人姓名
     */
    private String leaderName;

    /**
     * 负责人电话
     */
    private String leaderMobile;

    /**
     * 经销商安防密码
     */
    private String securityPwd;

    /**
     * 安防密码状态（ENABLE-启用；DISABLE-禁用）
     */
    private String pwdStatus;

    /**
     * 盐值
     */
    private String salt;


    /**
     * 备注
     */
    private String remark;

    /**
     * 经销商的经度
     */
    private BigDecimal longitude;

    /**
     * 经销商的纬度
     */
    private BigDecimal latitude;

    /**
     * 占地半径（米）
     */
    private BigDecimal coverRadius;

    /**
     * 服务半径（米）
     */
    private BigDecimal serviceRadius;

    /**
     * 销售区域
     */
    private String marketRegion;

    /**
     * 状态，枚举值，RUNNING:启用，DISABLE:禁用
     */
    private String status;

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

    public SysOrgDealer() {
    }

    public SysOrgDealer(Long parentId, String dealerFilePath, String dealerName, String simpleName, String provinceCode, String provinceName, String cityCode, String cityName, String areaCode, String areaName, String dealerCode, String dealerAddr, String brandType, String hotline, String leaderName, String leaderMobile, String securityPwd, String pwdStatus, String salt, String remark, BigDecimal longitude, BigDecimal latitude, BigDecimal coverRadius, BigDecimal serviceRadius, String marketRegion, String status, Long id, Date createTime, Date updateTime, String createBy, String updateBy) {
        this.parentId = parentId;
        this.dealerFilePath = dealerFilePath;
        this.dealerName = dealerName;
        this.simpleName = simpleName;
        this.provinceCode = provinceCode;
        this.provinceName = provinceName;
        this.cityCode = cityCode;
        this.cityName = cityName;
        this.areaCode = areaCode;
        this.areaName = areaName;
        this.dealerCode = dealerCode;
        this.dealerAddr = dealerAddr;
        this.brandType = brandType;
        this.hotline = hotline;
        this.leaderName = leaderName;
        this.leaderMobile = leaderMobile;
        this.securityPwd = securityPwd;
        this.pwdStatus = pwdStatus;
        this.salt = salt;
        this.remark = remark;
        this.longitude = longitude;
        this.latitude = latitude;
        this.coverRadius = coverRadius;
        this.serviceRadius = serviceRadius;
        this.marketRegion = marketRegion;
        this.status = status;
        this.id = id;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createBy = createBy;
        this.updateBy = updateBy;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getDealerFilePath() {
        return dealerFilePath;
    }

    public void setDealerFilePath(String dealerFilePath) {
        this.dealerFilePath = dealerFilePath;
    }

    public String getDealerName() {
        return dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
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

    public String getDealerCode() {
        return dealerCode;
    }

    public void setDealerCode(String dealerCode) {
        this.dealerCode = dealerCode;
    }

    public String getDealerAddr() {
        return dealerAddr;
    }

    public void setDealerAddr(String dealerAddr) {
        this.dealerAddr = dealerAddr;
    }

    public String getBrandType() {
        return brandType;
    }

    public void setBrandType(String brandType) {
        this.brandType = brandType;
    }

    public String getHotline() {
        return hotline;
    }

    public void setHotline(String hotline) {
        this.hotline = hotline;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public String getMarketRegion() {
        return marketRegion;
    }

    public void setMarketRegion(String marketRegion) {
        this.marketRegion = marketRegion;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getCoverRadius() {
        return coverRadius;
    }

    public void setCoverRadius(BigDecimal coverRadius) {
        this.coverRadius = coverRadius;
    }

    public BigDecimal getServiceRadius() {
        return serviceRadius;
    }

    public void setServiceRadius(BigDecimal serviceRadius) {
        this.serviceRadius = serviceRadius;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }

    public String getLeaderMobile() {
        return leaderMobile;
    }

    public void setLeaderMobile(String leaderMobile) {
        this.leaderMobile = leaderMobile;
    }

    public String getSecurityPwd() {
        return securityPwd;
    }

    public void setSecurityPwd(String securityPwd) {
        this.securityPwd = securityPwd;
    }

    public String getPwdStatus() {
        return pwdStatus;
    }

    public void setPwdStatus(String pwdStatus) {
        this.pwdStatus = pwdStatus;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
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