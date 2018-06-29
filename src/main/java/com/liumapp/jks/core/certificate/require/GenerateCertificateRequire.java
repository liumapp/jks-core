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

    private String keystoreName;

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
     * 证书有效期年数
     */
    private Integer validity = 1;

    /**
     * 密钥长度
     */
    private Integer keysize = 2048;

    /**
     * 完整的名字
     */
    private String name;

    /**
     * 省份
     */
    private String province;

    /**
     * 城市
     */
    private String city;

    /**
     * 国家代码
     * 例如：中国，就填写CN
     */
    private String country;

    public GenerateCertificateRequire() {
    }

    public GenerateCertificateRequire(String keystorePath, String keystoreName, String storepass, String alias, String certPassword, Integer validity, String name, String province, String city, String country) {
        this.keystorePath = keystorePath;
        this.keystoreName = keystoreName;
        this.storepass = storepass;
        this.alias = alias;
        this.certPassword = certPassword;
        this.validity = validity;
        this.name = name;
        this.province = province;
        this.city = city;
        this.country = country;
    }

    public String getKeystoreName() {
        return keystoreName;
    }

    public void setKeystoreName(String keystoreName) {
        this.keystoreName = keystoreName;
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

    public Integer getValidity() {
        return validity;
    }

    public void setValidity(Integer validity) {
        this.validity = validity;
    }

    public Integer getKeysize() {
        return keysize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
