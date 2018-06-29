package com.liumapp.jks.core.certificate.require;

import com.liumapp.jks.core.job.JobData;

/**
 * @author liumapp
 * @file ExportCertificateRequire.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 6/28/18
 */
public class ExportCertificateRequire extends JobData {

    private String keystorePath;

    private String keystorePasswd;

    private String alias;

    private String certSavePath;

    public String getCertSavePath() {
        return certSavePath;
    }

    public void setCertSavePath(String certSavePath) {
        this.certSavePath = certSavePath;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getKeystorePasswd() {
        return keystorePasswd;
    }

    public void setKeystorePasswd(String keystorePasswd) {
        this.keystorePasswd = keystorePasswd;
    }

    public String getKeystorePath() {
        return keystorePath;
    }

    public void setKeystorePath(String keystorePath) {
        this.keystorePath = keystorePath;
    }
}
