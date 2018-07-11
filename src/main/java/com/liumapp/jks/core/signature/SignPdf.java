package com.liumapp.jks.core.signature;

import com.alibaba.fastjson.JSONObject;
import com.liumapp.jks.core.filter.RequestFilter;
import com.liumapp.jks.core.loader.ChainLoader;
import com.liumapp.jks.core.loader.JksLoader;
import com.liumapp.jks.core.loader.PrivateKeyLoader;
import com.liumapp.jks.core.signature.require.SignPdfRequire;

import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;


/**
 * @author liumapp
 * @file SignPdf.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 7/10/18
 */
public class SignPdf extends RequestFilter<SignPdfRequire> {

    @Override
    public JSONObject handle(SignPdfRequire data) {
        this.loggerRequest(data);
        try {
            data.initSecurityInfo();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
