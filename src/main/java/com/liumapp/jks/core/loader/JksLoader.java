package com.liumapp.jks.core.loader;

import com.liumapp.jks.core.loader.require.JksLoadingRequire;
import com.liumapp.jks.core.loader.service.JksLoadingService;

import java.security.KeyStore;

/**
 * @author liumapp
 * @file JksLoader.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 7/11/18
 */
public class JksLoader implements JksLoadingService {

    private KeyStore ks = null;

    public JksLoader(JksLoadingRequire require) {
        this.ks = this.initKeyStore(require);
    }

    public KeyStore getKs() {
        return ks;
    }

    @Override
    public KeyStore initKeyStore(JksLoadingRequire require) {
        return null;
    }
}
