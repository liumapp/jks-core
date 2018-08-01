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

    private String host;

    private String path;

    private String appId;

    private String appSecret;

    private String name;

    private String identityCode;

    public CACertificateRequire () {
    }

    public CACertificateRequire(String host, String path, String appId, String appSecret, String name, String identityCode) {
        this.host = host;
        this.path = path;
        this.appId = appId;
        this.appSecret = appSecret;
        this.name = name;
        this.identityCode = identityCode;
    }

    public String getAppCode () throws Exception {
        EncryptUtil encryptUtil = new EncryptUtil("9ba76bfd500642328ec03ad8ef1b6e75", "utf-8");
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
}

