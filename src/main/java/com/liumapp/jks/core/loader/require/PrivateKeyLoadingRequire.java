package com.liumapp.jks.core.loader.require;

import com.liumapp.jks.core.loader.JksLoader;

/**
 * @author liumapp
 * @file PrivateKeyLoadingRequire.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 7/11/18
 */
public class PrivateKeyLoadingRequire {

    private String alias;

    private char[] certPassword;

    private JksLoader.ActiveKeyStore activeKeyStore;

    public PrivateKeyLoadingRequire() {
    }

    public char[] getCertPassword() {
        return certPassword;
    }

    public void setCertPassword(char[] certPassword) {
        this.certPassword = certPassword;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public JksLoader.ActiveKeyStore getActiveKeyStore() {
        return activeKeyStore;
    }

    public void setActiveKeyStore(JksLoader.ActiveKeyStore activeKeyStore) {
        this.activeKeyStore = activeKeyStore;
    }
}
