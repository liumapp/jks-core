package com.liumapp.jks.core.certificate.require;

import com.liumapp.jks.core.job.JobData;

/**
 * @author liumapp
 * @file GenerateCertificateRequire.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 6/28/18
 */
public class GenerateCertificateRequire extends JobData {

    /**
     * 密钥库地址
     */
    private String keystorePath;

    /**
     * 密钥库密码
     */
    private String storepass;

    /**
     * 别名
     */
    private String alias;

    /**
     * 个人证书密码
     */
    private String certPassword;

    /**
     * 加密算法
     */
    private String keyalg = "RSA";

    /**
     * 证书有效期天数
     */
    private Integer validity = 365;

    /**
     * 身份证号码
     */
    private String identityCode;

    /**
     * 密钥长度
     */
    private Integer keysize = 2048;

    /**
     * 私钥密码
     */
    private String keypass;

    /**
     * 完整的名字
     */
    private String name;

    /**
     * 密钥对拥有者名字
     */
    private String firstname;

    /**
     * 密钥对拥有者姓字
     */
    private String lastname;

    /**
     * 组织或者单位名称
     */
    private String organization;

    /**
     * 省份
     */
    private String province;

    /**
     * 城市
     */
    private String city;

    /**
     * 区域
     */
    private String area;

    /**
     * 国家代码
     * 例如：中国，就填写CN
     */
    private String country;

    /**
     * 性别
     * boy or girl or androgyne
     */
    private String sex;

    public GenerateCertificateRequire() {
    }

    public GenerateCertificateRequire(String keystorePath, String storepass, String alias, String certPassword, String keyalg, Integer validity, String identityCode, Integer keysize, String keypass, String name, String firstname, String lastname, String organization, String province, String city, String area, String country, String sex) {
        this.keystorePath = keystorePath;
        this.storepass = storepass;
        this.alias = alias;
        this.certPassword = certPassword;
        this.keyalg = keyalg;
        this.validity = validity;
        this.identityCode = identityCode;
        this.keysize = keysize;
        this.keypass = keypass;
        this.name = name;
        this.firstname = firstname;
        this.lastname = lastname;
        this.organization = organization;
        this.province = province;
        this.city = city;
        this.area = area;
        this.country = country;
        this.sex = sex;
    }

    public String getKeystorePath() {
        return keystorePath;
    }

    public void setKeystorePath(String keystorePath) {
        this.keystorePath = keystorePath;
    }

    public String getStorepass() {
        return storepass;
    }

    public void setStorepass(String storepass) {
        this.storepass = storepass;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getCertPassword() {
        return certPassword;
    }

    public void setCertPassword(String certPassword) {
        this.certPassword = certPassword;
    }

    public String getKeyalg() {
        return keyalg;
    }

    public void setKeyalg(String keyalg) {
        this.keyalg = keyalg;
    }

    public Integer getValidity() {
        return validity;
    }

    public void setValidity(Integer validity) {
        this.validity = validity;
    }

    public String getIdentityCode() {
        return identityCode;
    }

    public void setIdentityCode(String identityCode) {
        this.identityCode = identityCode;
    }

    public Integer getKeysize() {
        return keysize;
    }

    public void setKeysize(Integer keysize) {
        this.keysize = keysize;
    }

    public String getKeypass() {
        return keypass;
    }

    public void setKeypass(String keypass) {
        this.keypass = keypass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
