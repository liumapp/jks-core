package com.liumapp.jks.core.loader;

import com.liumapp.jks.core.loader.require.PrivateKeyLoadingRequire;

import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.UnrecoverableKeyException;

/**
 * author liumapp
 * file PrivateKeyLoader.java
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 7/11/18
 */
public class PrivateKeyLoader {

    private PrivateKeyLoadingRequire require;

    public static PrivateKeyLoader getInstance (PrivateKeyLoadingRequire require) {
        PrivateKeyLoader privateKeyLoader = new PrivateKeyLoader();
        privateKeyLoader.require = require;
        return privateKeyLoader;
    }

    public class ActivePrivateKey {

        private PrivateKey privateKey;

        public PrivateKey getPrivateKey() {
            return privateKey;
        }

        public ActivePrivateKey setPrivateKey(PrivateKey privateKey) {
            this.privateKey = privateKey;
            return this;
        }
    }

    public ActivePrivateKey getActivePrivateKey () throws UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException {
        ActivePrivateKey activePrivateKey = new ActivePrivateKey();
        PrivateKey privateKey = (PrivateKey) require.getActiveKeyStore().getKeyStore().getKey(require.getAlias(), require.getCertPassword());
        activePrivateKey.privateKey = privateKey;
        return activePrivateKey;
    }

}
