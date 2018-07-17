package com.liumapp.jks.core.loader;

import com.liumapp.jks.core.loader.require.ChainLoadingRequire;

import java.security.KeyStoreException;
import java.security.cert.Certificate;

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

    public class ActiveCertificate {
        private Certificate certificate;

        public Certificate getCertificate() {
            return certificate;
        }

        public ActiveCertificate setCertificate(Certificate certificate) {
            this.certificate = certificate;
            return this;
        }
    }

    public ActiveCertificate[] getActiveCertificateChain () throws KeyStoreException {
        Certificate[] chain = require.getActiveKeyStore().getKeyStore().getCertificateChain(require.getAlias());
        ActiveCertificate[] results = new ActiveCertificate[chain.length];
        for (int i = 0 ; i < chain.length ; i++) {
            results[i] = new ActiveCertificate();
            results[i].setCertificate(chain[i]);
        }
        return results;
    }

}
