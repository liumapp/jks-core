package com.liumapp.jks.core.loader.service;

import com.liumapp.jks.core.loader.PrivateKeyLoader;
import com.liumapp.jks.core.loader.require.PrivateKeyLoadingRequire;

import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;

/**
 * author liumapp
 * file ActivePrivateKeyService.java
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 7/11/18
 */
public interface ActivePrivateKeyService {

    public PrivateKeyLoader.ActivePrivateKey buildActivePrivateKey (PrivateKeyLoadingRequire require) throws UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException;

}
