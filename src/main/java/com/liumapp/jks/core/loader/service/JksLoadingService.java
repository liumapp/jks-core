package com.liumapp.jks.core.loader.service;

import com.liumapp.jks.core.loader.require.JksLoadingRequire;

import java.security.KeyStore;

/**
 * @author liumapp
 * @file JksLoadingService.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 7/11/18
 */
public interface JksLoadingService {

    public KeyStore initKeyStore (JksLoadingRequire require);

}
