package com.liumapp.jks.core.loader.require;

import com.liumapp.jks.core.loader.JksLoader;

/**
 * @author liumapp
 * @file ChainLoadingRequire.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 7/11/18
 */
public class ChainLoadingRequire {

    private String alias;

    private JksLoader.ActiveKeyStore activeKeyStore;

    public ChainLoadingRequire() {
    }

    public ChainLoadingRequire(String alias, JksLoader.ActiveKeyStore activeKeyStore) {
        this.alias = alias;
        this.activeKeyStore = activeKeyStore;
    }

    public JksLoader.ActiveKeyStore getActiveKeyStore() {
        return activeKeyStore;
    }

    public void setActiveKeyStore(JksLoader.ActiveKeyStore activeKeyStore) {
        this.activeKeyStore = activeKeyStore;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}
