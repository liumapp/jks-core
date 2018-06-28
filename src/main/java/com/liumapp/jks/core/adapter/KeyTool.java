package com.liumapp.jks.core.adapter;

import com.liumapp.jks.core.loader.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author liumapp
 * @file KeyTool.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 6/28/18
 */
public class KeyTool {

    private static final Logger LOGGER = Logger.getLogger(KeyTool.class.getName());

    public static KeyStoreAdapter newKeyStore(String password) throws KeyStoreException {
        try {
            return createKeyStoreAdapter(null, password);
        } catch (IOException | NoSuchAlgorithmException | CertificateException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
            throw new KeyStoreException(e);
        }
    }

    public static KeyStoreAdapter keyStoreFrom(Resource resource, String password) throws KeyStoreException {
        try (InputStream ksStream = resource.getInputStream()) {
            return createKeyStoreAdapter(ksStream, password);
        } catch (IOException | NoSuchAlgorithmException | CertificateException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
            throw new KeyStoreException(e);
        }
    }

    private static KeyStoreAdapter createKeyStoreAdapter(InputStream ksStream, String password) throws KeyStoreException, IOException, NoSuchAlgorithmException, CertificateException {
        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        keyStore.load(ksStream, password.toCharArray());
        return new KeyStoreAdapter(keyStore, password);
    }

}
