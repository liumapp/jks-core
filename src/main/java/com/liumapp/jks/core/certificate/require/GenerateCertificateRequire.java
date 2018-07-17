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

    public String getName() {
        return name;
    }

    public GenerateCertificateRequire setName(String name) {
        this.name = name;
        return this;
    }

    public String getProvince() {
        return province;
    }

    public GenerateCertificateRequire setProvince(String province) {
        this.province = province;
        return this;
    }

    public String getCity() {
        return city;
    }

    public GenerateCertificateRequire setCity(String city) {
        this.city = city;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public GenerateCertificateRequire setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getKeystorePath() {
        return keystorePath;
    }

    public GenerateCertificateRequire setKeystorePath(String keystorePath) {
        this.keystorePath = keystorePath;
        return this;
    }

    public String getKeystoreName() {
        return keystoreName;
    }

    public GenerateCertificateRequire setKeystoreName(String keystoreName) {
        this.keystoreName = keystoreName;
        return this;
    }

    public String getStorepass() {
        return storepass;
    }

    public GenerateCertificateRequire setStorepass(String storepass) {
        this.storepass = storepass;
        return this;
    }

    public String getAlias() {
        return alias;
    }

    public GenerateCertificateRequire setAlias(String alias) {
        this.alias = alias;
        return this;
    }

    public String getCertPassword() {
        return certPassword;
    }

    public GenerateCertificateRequire setCertPassword(String certPassword) {
        this.certPassword = certPassword;
        return this;
    }

    public Integer getValidity() {
        return validity;
    }

    public GenerateCertificateRequire setValidity(Integer validity) {
        this.validity = validity;
        return this;
    }

    public Integer getKeysize() {
        return keysize;
    }
}
