package com.liumapp.jks.core.container;

import com.alibaba.fastjson.JSONObject;
import com.liumapp.jks.core.adapter.KeyTool;
import com.liumapp.jks.core.container.require.GenerateJksContainerRequire;
import com.liumapp.jks.core.filter.RequestFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.time.temporal.ChronoUnit;

/**
 * author liumapp
 * file GenerateJksContainer.java
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 6/28/18
 */
public class GenerateJksContainer extends RequestFilter<GenerateJksContainerRequire> {

    private static final Logger LOGGER = LoggerFactory.getLogger(GenerateJksContainer.class);

    @Override
    public JSONObject handle(GenerateJksContainerRequire data) {
        try {
            String filename = data.getSavePath() + "/" + data.getKeyStoreName();
            FileOutputStream out = new FileOutputStream(filename);
            KeyTool.newKeyStore(data.getKeyStorePd())
                    .newKeyPair()
                    .keyLength(data.getKeyLength())
                    .generateWithCertificate()
                    .withValidity(1, ChronoUnit.YEARS)
                    .withDistinguishName()
                    .commonName(data.getFcName())
                    .state(data.getFcCity())
                    .locality(data.getFcProvince())
                    .country(data.getFcCountry())
                    .build()
                    .createInKeyStore(data.getFcAlias(), data.getFcPassword())
                    .writeTo(out);
            this.jobResult.put("msg", "success");
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            this.jobResult.put("msg", "error");
        }
        return this.jobResult;
    }

}
