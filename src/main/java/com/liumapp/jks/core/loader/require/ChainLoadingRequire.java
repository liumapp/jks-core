package com.liumapp.jks.core.loader.require;

/**
 * @author liumapp
 * @file ChainLoadingRequire.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 7/11/18
 */
public class ChainLoadingRequire {

    private String alias;

    public ChainLoadingRequire() {
    }

    public ChainLoadingRequire(String alias) {
        this.alias = alias;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}
