package com.liumapp.jks.core.loader.service;

import com.liumapp.jks.core.loader.PrivateKeyLoader;
import com.liumapp.jks.core.loader.require.PrivateKeyLoadingRequire;

/**
 * @author liumapp
 * @file ActivePrivateKeyService.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 7/11/18
 */
public interface ActivePrivateKeyService {

    public PrivateKeyLoader.ActivePrivateKey buildActivePrivateKey (PrivateKeyLoadingRequire require);

}
