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

    private String keystoreName;

    private String keystorePasswd;

    private String alias;

    private String certSavePath;

    private String certName;

    public ExportCertificateRequire() {
    }

    public ExportCertificateRequire(String keystorePath, String keystoreName, String keystorePasswd, String alias, String certSavePath, String certName) {
        this.keystorePath = keystorePath;
        this.keystoreName = keystoreName;
        this.keystorePasswd = keystorePasswd;
        this.alias = alias;
        this.certSavePath = certSavePath;
        this.certName = certName;
    }

    public String getKeystorePath() {
        return keystorePath;
    }

    public ExportCertificateRequire setKeystorePath(String keystorePath) {
        this.keystorePath = keystorePath;
        return this;
    }

    public String getKeystoreName() {
        return keystoreName;
    }

    public ExportCertificateRequire setKeystoreName(String keystoreName) {
        this.keystoreName = keystoreName;
        return this;
    }

    public String getKeystorePasswd() {
        return keystorePasswd;
    }

    public ExportCertificateRequire setKeystorePasswd(String keystorePasswd) {
        this.keystorePasswd = keystorePasswd;
        return this;
    }

    public String getAlias() {
        return alias;
    }

    public ExportCertificateRequire setAlias(String alias) {
        this.alias = alias;
        return this;
    }

    public String getCertSavePath() {
        return certSavePath;
    }

    public ExportCertificateRequire setCertSavePath(String certSavePath) {
        this.certSavePath = certSavePath;
        return this;
    }

    public String getCertName() {
        return certName;
    }

    public ExportCertificateRequire setCertName(String certName) {
        this.certName = certName;
        return this;
    }
}
