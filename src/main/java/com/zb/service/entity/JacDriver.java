package com.zb.service.entity;

import java.io.Serializable;
import java.util.Date;

public class JacDriver implements Serializable {

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
     * tdId
     */
    private Long tdId;


    /**
     * 所属车队ID
     */
    private Long fleetId;

    /**
     * 司机头像
     */
    private String avatar;

    /**
     * 司机名称
     */
    private String driverName;

    /**
     * 司机昵称
     */
    private String nickName;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 密码
     */
    private String password;

    /**
     * 身份证号
     */
    private String identityCard;

    /**
     * 性别，枚举值 性别, UNKNOWN:未知，MALE:男性, FEMALE:女性
     */
    private String sex;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * QQ
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
     * 驾照号
     */
    private String driverLicense;

    /**
     * 驾照有效截止日期
     */
    private Date licenseValidDate;

    /**
     * 驾照图片
     */
    private String licensePicture;

    /**
     * 从业资格有效日期
     */
    private Date qualityValidDate;

    /**
     * 从业资格证图片
     */
    private String qualityPicture;

    /**
     * 申请加入车队的状态（NOT_APPLY:未申请，APPLYING:申请中，APPLIED：已完成）
     */
    private String applyStatus;

    /**
     * 司机的默认车辆
     */
    private String defaultVin;

    /**
     * 开启防盗，默认YES
     */
    private String openStolen;

    /**
     * 盐值
     */
    private String salt;

    public JacDriver() {
    }


    public JacDriver(Long id, Date createTime, Date updateTime, String createBy, String updateBy, Long tdId, Long fleetId, String avatar, String driverName, String nickName, String mobile, String password, String identityCard, String sex, Date birthday, String qq, String email, String address, String driverLicense, Date licenseValidDate, String licensePicture, Date qualityValidDate, String qualityPicture, String applyStatus, String defaultVin, String openStolen, String salt) {
        this.id = id;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.tdId = tdId;
        this.fleetId = fleetId;
        this.avatar = avatar;
        this.driverName = driverName;
        this.nickName = nickName;
        this.mobile = mobile;
        this.password = password;
        this.identityCard = identityCard;
        this.sex = sex;
        this.birthday = birthday;
        this.qq = qq;
        this.email = email;
        this.address = address;
        this.driverLicense = driverLicense;
        this.licenseValidDate = licenseValidDate;
        this.licensePicture = licensePicture;
        this.qualityValidDate = qualityValidDate;
        this.qualityPicture = qualityPicture;
        this.applyStatus = applyStatus;
        this.defaultVin = defaultVin;
        this.openStolen = openStolen;
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

    public Long getTdId() {
        return tdId;
    }

    public void setTdId(Long tdId) {
        this.tdId = tdId;
    }

    /**
     * 所属车队ID
     *
     * @return fleet_id 所属车队ID
     */
    public Long getFleetId() {
        return fleetId;
    }

    /**
     * 所属车队ID
     *
     * @param fleetId 所属车队ID
     */
    public void setFleetId(Long fleetId) {
        this.fleetId = fleetId;
    }

    /**
     * 司机名称
     *
     * @return driver_name 司机名称
     */
    public String getDriverName() {
        return driverName;
    }

    /**
     * 司机名称
     *
     * @param driverName 司机名称
     */
    public void setDriverName(String driverName) {
        this.driverName = driverName == null ? null : driverName.trim();
    }

    /**
     * 司机昵称
     *
     * @return nick_name 司机昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 司机昵称
     *
     * @param nickName 司机昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    /**
     * 手机号
     *
     * @return mobile 手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 手机号
     *
     * @param mobile 手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 密码
     *
     * @return password 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 身份证号
     *
     * @return identity_card 身份证号
     */
    public String getIdentityCard() {
        return identityCard;
    }

    /**
     * 身份证号
     *
     * @param identityCard 身份证号
     */
    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard == null ? null : identityCard.trim();
    }

    /**
     * 性别，枚举值 性别, UNKNOWN:未知，MALE:男性, FEMALE:女性
     *
     * @return sex 性别，枚举值 性别, UNKNOWN:未知，MALE:男性, FEMALE:女性
     */
    public String getSex() {
        return sex;
    }

    /**
     * 性别，枚举值 性别, UNKNOWN:未知，MALE:男性, FEMALE:女性
     *
     * @param sex 性别，枚举值 性别, UNKNOWN:未知，MALE:男性, FEMALE:女性
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * 生日
     *
     * @return birthday 生日
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 生日
     *
     * @param birthday 生日
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 电子邮箱
     *
     * @return email 电子邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 电子邮箱
     *
     * @param email 电子邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 联系地址
     *
     * @return address 联系地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 联系地址
     *
     * @param address 联系地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 驾照号
     *
     * @return driver_license 驾照号
     */
    public String getDriverLicense() {
        return driverLicense;
    }

    /**
     * 驾照号
     *
     * @param driverLicense 驾照号
     */
    public void setDriverLicense(String driverLicense) {
        this.driverLicense = driverLicense == null ? null : driverLicense.trim();
    }

    /**
     * 驾照有效截止日期
     *
     * @return license_valid_date 驾照有效截止日期
     */
    public Date getLicenseValidDate() {
        return licenseValidDate;
    }

    /**
     * 驾照有效截止日期
     *
     * @param licenseValidDate 驾照有效截止日期
     */
    public void setLicenseValidDate(Date licenseValidDate) {
        this.licenseValidDate = licenseValidDate;
    }

    /**
     * 驾照图片
     *
     * @return license_picture 驾照图片
     */
    public String getLicensePicture() {
        return licensePicture;
    }

    /**
     * 驾照图片
     *
     * @param licensePicture 驾照图片
     */
    public void setLicensePicture(String licensePicture) {
        this.licensePicture = licensePicture == null ? null : licensePicture.trim();
    }

    /**
     * 从业资格有效日期
     *
     * @return quality_valid_date 从业资格有效日期
     */
    public Date getQualityValidDate() {
        return qualityValidDate;
    }

    /**
     * 从业资格有效日期
     *
     * @param qualityValidDate 从业资格有效日期
     */
    public void setQualityValidDate(Date qualityValidDate) {
        this.qualityValidDate = qualityValidDate;
    }

    /**
     * 从业资格证图片
     *
     * @return quality_picture 从业资格证图片
     */
    public String getQualityPicture() {
        return qualityPicture;
    }

    /**
     * 从业资格证图片
     *
     * @param qualityPicture 从业资格证图片
     */
    public void setQualityPicture(String qualityPicture) {
        this.qualityPicture = qualityPicture == null ? null : qualityPicture.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(String applyStatus) {
        this.applyStatus = applyStatus;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getDefaultVin() {
        return defaultVin;
    }

    public void setDefaultVin(String defaultVin) {
        this.defaultVin = defaultVin;
    }

    public String getOpenStolen() {
        return openStolen;
    }

    public void setOpenStolen(String openStolen) {
        this.openStolen = openStolen;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public String toString() {
        return  "'" + id +"'," +
                "'" + tdId +"'," +
                "'" + fleetId +"'," +
                "'" + avatar + "'," +
                "'" + driverName + "'," +
                "'" + nickName + "'," +
                "'" + mobile + "'," +
                "'" + password + "'," +
                "'" + identityCard + "'," +
                "'" + sex + "'," +
                "'" + birthday +"'," +
                "'" + qq + "'," +
                "'" + email + "'," +
                "'" + address + "'," +
                "'" + driverLicense + "'," +
                "'" +  licenseValidDate +
                "'" + licensePicture + "'," +
                "'" +  qualityValidDate +
                "'" + qualityPicture + "'," +
                "'" + applyStatus + "'," +
                "'" + defaultVin + "'," +
                "'" + openStolen + "',"
                ;
    }

}