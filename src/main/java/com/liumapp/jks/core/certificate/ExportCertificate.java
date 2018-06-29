package com.liumapp.jks.core.certificate;

import com.alibaba.fastjson.JSONObject;
import com.liumapp.jks.core.adapter.KeyStoreAdapter;
import com.liumapp.jks.core.adapter.KeyTool;
import com.liumapp.jks.core.certificate.require.ExportCertificateRequire;
import com.liumapp.jks.core.filter.RequestFilter;
import com.liumapp.jks.core.loader.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.security.KeyStoreException;
import java.security.cert.Certificate;

/**
 * @author liumapp
 * @file ExportCertificate.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 6/28/18
 */
public class ExportCertificate extends RequestFilter<ExportCertificateRequire> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExportCertificate.class);

    @Override
    public JSONObject handle(ExportCertificateRequire data) {
        try {
            Resource resource = Resource.from(data.getKeystorePath() + "/" + data.getKeystoreName());
            KeyStoreAdapter keyStoreAdapter = KeyTool.keyStoreFrom(resource , data.getKeystorePasswd());
            Certificate certificate = keyStoreAdapter.getCertificate(data.getAlias());
            FileOutputStream out = new FileOutputStream(data.getCertSavePath() + "/" + data.getCertName());
            out.write(certificate.getEncoded());
            out.close();
            this.jobResult.put("msg", "success");
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            this.jobResult.put("msg", "error");
        }
        return this.jobResult;
    }

}


