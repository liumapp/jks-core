package com.liumapp.jks.core.certificate.require;

import com.liumapp.jks.core.job.JobData;

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

    public CACertificateRequire() {
    }

    public CACertificateRequire(String host, String path, String appId, String appSecret) {
        this.host = host;
        this.path = path;
        this.appId = appId;
        this.appSecret = appSecret;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }
}

