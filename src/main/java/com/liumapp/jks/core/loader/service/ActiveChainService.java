package com.liumapp.jks.core.loader.service;

import com.liumapp.jks.core.loader.ChainLoader;
import com.liumapp.jks.core.loader.require.ChainLoadingRequire;

/**
 * @author liumapp
 * @file ActiveChainService.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 7/11/18
 */
public interface ActiveChainService {

    public ChainLoader.ActiveCertificate[] buildActiveChain (ChainLoadingRequire require);

}
