package com.liumapp.jks.core.certificate;

import com.alibaba.fastjson.JSONObject;
import com.liumapp.jks.core.adapter.KeyStoreAdapter;
import com.liumapp.jks.core.adapter.KeyTool;
import com.liumapp.jks.core.certificate.require.GenerateCertificateRequire;
import com.liumapp.jks.core.filter.RequestFilter;
import com.liumapp.jks.core.loader.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.time.temporal.ChronoUnit;

/**
 * author liumapp
 * file GenerateCertificate.java
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 6/29/18
 */
public class GenerateCertificate extends RequestFilter<GenerateCertificateRequire> {

    private static final Logger LOGGER = LoggerFactory.getLogger(GenerateCertificate.class);

    @Override
    public JSONObject handle(GenerateCertificateRequire data) {
        try {
            String filename = data.getKeystorePath() + "/" + data.getKeystoreName();
            Resource resource = Resource.from(filename);
            KeyStoreAdapter keyStoreAdapter = KeyTool.keyStoreFrom(resource , data.getStorepass());
            keyStoreAdapter.newKeyPair()
                    .keyLength(data.getKeysize())
                    .generateWithCertificate()
                    .withValidity(data.getValidity(), ChronoUnit.YEARS)
                    .withDistinguishName()
                    .commonName(data.getName())
                    .state(data.getCity())
                    .locality(data.getProvince())
                    .country(data.getCountry())
                    .build()
                    .createInKeyStore(data.getAlias(), data.getCertPassword());
            FileOutputStream out = new FileOutputStream(filename);
            keyStoreAdapter.writeTo(out);
            out.close();
            this.jobResult.put("msg", "success");
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            this.jobResult.put("msg", "error");
        }
        return this.jobResult;

    }

}
