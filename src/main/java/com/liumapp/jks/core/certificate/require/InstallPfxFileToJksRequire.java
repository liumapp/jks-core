package com.liumapp.jks.core.certificate.require;

import com.liumapp.jks.core.job.JobData;

/**
 * @author liumapp
 * @file InstallPfxFileToJksRequire.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 2018/8/9
 */
public class InstallPfxFileToJksRequire extends JobData {

    private String pfxFilePath;

    private String keystorePath;

    private String keystoreName;

    private String keystorePasswd;

    private String alias;

    public InstallPfxFileToJksRequire() {
    }

    public InstallPfxFileToJksRequire(String pfxFilePath, String keystorePath, String keystoreName, String keystorePasswd, String alias) {
        this.pfxFilePath = pfxFilePath;
        this.keystorePath = keystorePath;
        this.keystoreName = keystoreName;
        this.keystorePasswd = keystorePasswd;
        this.alias = alias;
    }

    public String getPfxFilePath() {
        return pfxFilePath;
    }

    public InstallPfxFileToJksRequire setPfxFilePath(String pfxFilePath) {
        this.pfxFilePath = pfxFilePath;
        return this;
    }

    public String getKeystorePath() {
        return keystorePath;
    }

    public InstallPfxFileToJksRequire setKeystorePath(String keystorePath) {
        this.keystorePath = keystorePath;
        return this;
    }

    public String getKeystoreName() {
        return keystoreName;
    }

    public InstallPfxFileToJksRequire setKeystoreName(String keystoreName) {
        this.keystoreName = keystoreName;
        return this;
    }

    public String getKeystorePasswd() {
        return keystorePasswd;
    }

    public InstallPfxFileToJksRequire setKeystorePasswd(String keystorePasswd) {
        this.keystorePasswd = keystorePasswd;
        return this;
    }

    public String getAlias() {
        return alias;
    }

    public InstallPfxFileToJksRequire setAlias(String alias) {
        this.alias = alias;
        return this;
    }
}
