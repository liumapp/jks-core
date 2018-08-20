package com.liumapp.jks.core.loader.service;

import com.liumapp.jks.core.loader.JksLoader;
import com.liumapp.jks.core.loader.require.JksLoadingRequire;

/**
 * author liumapp
 * file ActiveKeyStoreService.java
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 7/11/18
 */
public interface ActiveKeyStoreService {

    public JksLoader.ActiveKeyStore buildActiveKeyStore (JksLoadingRequire require) ;

}
