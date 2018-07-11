package com.liumapp.jks.core.loader.require;

/**
 * @author liumapp
 * @file JksLoadingRequire.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 7/11/18
 */
public class JksLoadingRequire {

    private String ksPath;

    private String ksPassword;

    public JksLoadingRequire() {
    }

    public JksLoadingRequire(String ksPath, String ksPassword) {
        this.ksPath = ksPath;
        this.ksPassword = ksPassword;
    }

    public String getKsPath() {
        return ksPath;
    }

    public void setKsPath(String ksPath) {
        this.ksPath = ksPath;
    }

    public String getKsPassword() {
        return ksPassword;
    }

    public void setKsPassword(String ksPassword) {
        this.ksPassword = ksPassword;
    }
}
