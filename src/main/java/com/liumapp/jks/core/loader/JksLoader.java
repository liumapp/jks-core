package com.liumapp.jks.core.loader;

import com.liumapp.jks.core.loader.require.JksLoadingRequire;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.*;
import java.security.cert.CertificateException;

/**
 * @author liumapp
 * @file JksLoader.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 7/11/18
 */
class JksLoader {

    JksLoadingRequire require;

    public static JksLoader getInstance (JksLoadingRequire require) {
        JksLoader jksLoader = new JksLoader();
        jksLoader.require = require;
        return jksLoader;
    }

    private KeyStore getActiveKeyStore () {
        BouncyCastleProvider bcp = new BouncyCastleProvider();
        Security.insertProviderAt(bcp, require.getPosition());
        KeyStore ks = null;
        FileInputStream in = null;
        try {
            in = new FileInputStream(require.getKsPath() + "/" + require.getKsName());
            ks = KeyStore.getInstance(require.getKsType());
            try {
                ks.load(in, require.getKsPassword());
            } catch (CertificateException e) {
                e.printStackTrace();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ks;
    }

}
