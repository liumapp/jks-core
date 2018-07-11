package com.liumapp.jks.core.loader;

import com.liumapp.jks.core.loader.require.ChainLoadingRequire;

/**
 * @author liumapp
 * @file ChainLoader.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 7/11/18
 */
public class ChainLoader {

    private ChainLoadingRequire require;

    public static ChainLoader getInstance (ChainLoadingRequire require) {
        ChainLoader chainLoader = new ChainLoader();
        chainLoader.require = require;
        return chainLoader;
    }



}
