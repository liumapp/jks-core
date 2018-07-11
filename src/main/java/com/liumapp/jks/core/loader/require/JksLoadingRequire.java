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

    private char[] ksPassword;

    private String ksType = KeyStore.getDefaultType();

    public JksLoadingRequire() {
    }

    public JksLoadingRequire(String ksPath, char[] ksPassword) {
        this.ksPath = ksPath;
        this.ksPassword = ksPassword;
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
