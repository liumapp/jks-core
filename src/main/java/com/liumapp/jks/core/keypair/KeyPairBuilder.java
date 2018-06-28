package com.liumapp.jks.core.keypair;

import com.liumapp.jks.core.adapter.KeyStoreAdapter;

import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

/**
 * @author liumapp
 * @file KeyPairBuilder.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 6/28/18
 */
public class KeyPairBuilder {

    private final KeyPairGenerator generator;

    private final KeyStoreAdapter keyStoreAdapter;

    public KeyPairBuilder(String algorithm, KeyStoreAdapter keyStoreAdapter) throws NoSuchAlgorithmException {
        this.keyStoreAdapter = keyStoreAdapter;
        this.generator = KeyPairGenerator.getInstance(algorithm);
    }

    /**
     * Generates a new keypair with default algorithm RSA
     *
     * @param keyStoreAdapter
     * @throws NoSuchAlgorithmException
     */
    public KeyPairBuilder(KeyStoreAdapter keyStoreAdapter) throws NoSuchAlgorithmException {
        this("RSA", keyStoreAdapter);
    }

    public KeyPairBuilder keyLength(int length) {
        this.generator.initialize(length);
        return this;
    }

    public CertificateBuilder generateWithCertificate() {
        return new CertificateBuilder(this.keyStoreAdapter, this.generator.generateKeyPair());
    }

}
