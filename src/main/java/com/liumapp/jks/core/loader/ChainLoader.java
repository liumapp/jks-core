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

    public abstract class ActiveCertificate extends Certificate {

        /**
         * Creates a certificate of the specified type.
         *
         * @param type the standard name of the certificate type.
         *             See the CertificateFactory section in the <a href=
         *             "{@docRoot}/../technotes/guides/security/StandardNames.html#CertificateFactory">
         *             Java Cryptography Architecture Standard Algorithm Name Documentation</a>
         *             for information about standard certificate types.
         */
        protected ActiveCertificate(String type) {
            super(type);
        }
    }

    public ActiveCertificate[] getActiveCertificateChain () throws KeyStoreException {
        return (ActiveCertificate[]) require.getActiveKeyStore().getCertificateChain(require.getAlias());
    }

}
