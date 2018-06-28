package com.liumapp.jks.core.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

/**
 * @author liumapp
 * @file KeyStoreAdapter.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 6/28/18
 */
public class KeyStoreAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(KeyStoreAdapter.class);

    public static KeyStoreAdapter newKeyStore(String password) throws KeyStoreException {
        try {
            return createKeyStoreAdapter(null, password);
        } catch (IOException | NoSuchAlgorithmException | CertificateException e) {
            LOGGER.error(e.getMessage(), e);
            throw new KeyStoreException(e);
        }
    }

    public static KeyStoreAdapter keyStoreFrom(Resource resource, String password) throws KeyStoreException {
        try (InputStream ksStream = resource.getInputStream()) {
            return createKeyStoreAdapter(ksStream, password);
        } catch (IOException | NoSuchAlgorithmException | CertificateException e) {
            LOGGER.error(e.getMessage(), e);
            throw new KeyStoreException(e);
        }
    }

    private static KeyStoreAdapter createKeyStoreAdapter(InputStream ksStream, String password) throws KeyStoreException, IOException, NoSuchAlgorithmException, CertificateException {
        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        keyStore.load(ksStream, password.toCharArray());
        return new KeyStoreAdapter(keyStore, password);
    }

}
