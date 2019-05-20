package com.zb.service.entity;


import java.io.Serializable;
import java.util.Date;

/**
 * @author acemma
 * @date 2018/3/15 14:30
 * @Description
 */
public class SysUser implements Serializable {

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
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 头像路径
     */
    private String headPicture;

    /**
     * 姓名
     */
    private String realName;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 身份证号
     */
    private String identityCard;

    /**
     * 性别，枚举值
     * UNKNOWN:未知，MALE:男性, FEMALE:女性
     */
    private String sex;

    /**
     * 所属组织机构ID
     */
    private Long orgId;

    /**
     * 机构名称
     */
    private String orgName;

    /**
     * 所属组织机构类型（FACTORY:车厂，DEALER:经销商，SERVICE_STATION:服务站，CUSTOMER:客户）
     */
    private String orgType;

    /**
     * 管理的车队ID
     */
    private Long motorcadeId;

    /**
     * 用户状态，枚举值
     * ENABLE:可用，DISABLE:禁用
     */
    private String status;

    /**
     * QQ号
     */
    private String qq;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 联系地址
     */
    private String address;

    /**
     * 职能
     */
    private String function;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 盐值
     */
    private String salt;

    public SysUser() {
    }

    /**
     *
     * @param id
     * @param createTime
     * @param updateTime
     * @param createBy
     * @param updateBy
     * @param username
     * @param password
     * @param headPicture
     * @param realName
     * @param mobile
     * @param identityCard
     * @param sex
     * @param orgId
     * @param orgName
     * @param orgType
     * @param motorcadeId
     * @param status
     * @param qq
     * @param email
     * @param address
     * @param function
     * @param nickName
     * @param salt
     */
    public SysUser(Long id, Date createTime, Date updateTime, String createBy, String updateBy, String username, String password, String headPicture, String realName, String mobile, String identityCard, String sex, Long orgId, String orgName, String orgType, Long motorcadeId, String status, String qq, String email, String address, String function, String nickName, String salt) {
        this.id = id;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.username = username;
        this.password = password;
        this.headPicture = headPicture;
        this.realName = realName;
        this.mobile = mobile;
        this.identityCard = identityCard;
        this.sex = sex;
        this.orgId = orgId;
        this.orgName = orgName;
        this.orgType = orgType;
        this.motorcadeId = motorcadeId;
        this.status = status;
        this.qq = qq;
        this.email = email;
        this.address = address;
        this.function = function;
        this.nickName = nickName;
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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHeadPicture() {
        return headPicture;
    }

    public void setHeadPicture(String headPicture) {
        this.headPicture = headPicture;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Long getMotorcadeId() {
        return motorcadeId;
    }

    public void setMotorcadeId(Long motorcadeId) {
        this.motorcadeId = motorcadeId;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
