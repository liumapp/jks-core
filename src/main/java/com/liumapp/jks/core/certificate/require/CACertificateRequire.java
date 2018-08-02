package com.liumapp.jks.core.certificate.require;

import com.liumapp.jks.core.job.JobData;
import com.liumapp.jks.core.util.EncryptUtil;

import java.security.Security;

/**
 * @author liumapp
 * @file CACertificateRequire.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 2018/8/1
 */
public class CACertificateRequire extends JobData {

    private static final String encryKey = "9ba76bfd500642328ec03ad8ef1b6e75";

    private String host;

    private String path;

    private String appId;

    private String appSecret;

    private String name;

    private String identityCode;

    private String certAlias;

    private String certPassword;

    private String keystorePath;

    private String keystoreName;

    private String storepass;

    private String country;

    private String province;

    private String city;

    public CACertificateRequire () {
    }

    public CACertificateRequire(String host, String path, String appId, String appSecret, String name, String identityCode, String certPassword, String keystorePath, String keystoreName, String storepass, String country, String province, String city) {
        this.host = host;
        this.path = path;
        this.appId = appId;
        this.appSecret = appSecret;
        this.name = name;
        this.identityCode = identityCode;
        this.certPassword = certPassword;
        this.keystorePath = keystorePath;
        this.keystoreName = keystoreName;
        this.storepass = storepass;
        this.country = country;
        this.province = province;
        this.city = city;
    }

    public String getCertAlias() {
        return certAlias;
    }

    public CACertificateRequire setCertAlias(String certAlias) {
        this.certAlias = certAlias;
        return this;
    }

    public String getKeystorePath() {
        return keystorePath;
    }

    public CACertificateRequire setKeystorePath(String keystorePath) {
        this.keystorePath = keystorePath;
        return this;
    }

    public String getKeystoreName() {
        return keystoreName;
    }

    public CACertificateRequire setKeystoreName(String keystoreName) {
        this.keystoreName = keystoreName;
        return this;
    }

    public String getStorepass() {
        return storepass;
    }

    public CACertificateRequire setStorepass(String storepass) {
        this.storepass = storepass;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public CACertificateRequire setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getProvince() {
        return province;
    }

    public CACertificateRequire setProvince(String province) {
        this.province = province;
        return this;
    }

    public String getCity() {
        return city;
    }

    public CACertificateRequire setCity(String city) {
        this.city = city;
        return this;
    }

    public String getAppCode () throws Exception {
        EncryptUtil encryptUtil = new EncryptUtil(CACertificateRequire.encryKey, "utf-8");
        String result = "";
        result += "id_";
        result += encryptUtil.encode(this.appId);
        result += "secret_";
        result += encryptUtil.encode(this.appSecret);
        return result;
    }

    public String getHost() {
        return host;
    }

    public CACertificateRequire setHost(String host) {
        this.host = host;
        return this;
    }

    public String getPath() {
        return path;
    }

    public CACertificateRequire setPath(String path) {
        this.path = path;
        return this;
    }

    public String getAppId() {
        return appId;
    }

    public CACertificateRequire setAppId(String appId) {
        this.appId = appId;
        return this;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public CACertificateRequire setAppSecret(String appSecret) {
        this.appSecret = appSecret;
        return this;
    }

    public String getName() {
        return name;
    }

    public CACertificateRequire setName(String name) {
        this.name = name;
        return this;
    }

    public String getIdentityCode() {
        return identityCode;
    }

    public CACertificateRequire setIdentityCode(String identityCode) {
        this.identityCode = identityCode;
        return this;
    }

    public String getCertPassword() {
        return certPassword;
    }

    public CACertificateRequire setCertPassword(String certPassword) {
        this.certPassword = certPassword;
        return this;
    }
}

