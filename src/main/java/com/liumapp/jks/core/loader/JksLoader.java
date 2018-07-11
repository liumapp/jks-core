package com.liumapp.jks.core.loader;

import com.liumapp.jks.core.loader.require.JksLoadingRequire;
import com.liumapp.jks.core.loader.service.JksLoadingService;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.cert.CertificateException;

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
        BouncyCastleProvider bcp = new BouncyCastleProvider();
        Security.insertProviderAt(bcp, 1);
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
