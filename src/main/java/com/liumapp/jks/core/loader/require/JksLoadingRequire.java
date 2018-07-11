package com.liumapp.jks.core.loader.require;

import java.security.KeyStore;

/**
 * @author liumapp
 * @file JksLoadingRequire.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 7/11/18
 */
public class JksLoadingRequire {

    private String ksPath;

    private String ksName;

    private char[] ksPassword;

    private String ksType = KeyStore.getDefaultType();

    /**
     * the preference position that the caller would
     * like for provider.
     */
    private Integer position = 1;

    public JksLoadingRequire() {
    }

    public JksLoadingRequire(String ksPath, String ksName, char[] ksPassword) {
        this.ksPath = ksPath;
        this.ksName = ksName;
        this.ksPassword = ksPassword;
    }

    public String getKsName() {
        return ksName;
    }

    public Integer getPosition() {
        return position;
    }

    public void setKsName(String ksName) {
        this.ksName = ksName;
    }

    public String getKsType() {
        return ksType;
    }

    public String getKsPath() {
        return ksPath;
    }

    public void setKsPath(String ksPath) {
        this.ksPath = ksPath;
    }

    public char[] getKsPassword() {
        return ksPassword;
    }

    public void setKsPassword(char[] ksPassword) {
        this.ksPassword = ksPassword;
    }
}
