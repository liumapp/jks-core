package com.liumapp.jks.core.container;

import com.alibaba.fastjson.JSONObject;
import com.liumapp.jks.core.container.require.GenerateJksContainerRequire;
import com.liumapp.jks.core.filter.RequestFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.time.temporal.ChronoUnit;

/**
 * @author liumapp
 * @file GenerateJksContainer.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 6/28/18
 */
public class GenerateJksContainer extends RequestFilter<GenerateJksContainerRequire> {

    private static final Logger LOGGER = LoggerFactory.getLogger(GenerateJksContainer.class);

    @Override
    public JSONObject handle(GenerateJksContainerRequire data) {
//        try {
//            String fileName = data.getSavePath() + "/" + data.getKeyStoreName();
//            FileOutputStream out = new FileOutputStream(fileName);
//            KeyTools.newKeyStore(keyStorePattern.getKeyStorePd())
//                    .newKeyPair()
//                    .keyLength(keyStorePattern.getKeyLength())
//                    .generateWithCertificate()
//                    .withValidity(1 , ChronoUnit.YEARS)
//                    .withDistinguishName()
//                    .commonName(keyStorePattern.getFcName())
//                    .state(keyStorePattern.getFcCity())
//                    .locality(keyStorePattern.getFcProvince())
//                    .country(keyStorePattern.getFcCountry())
//                    .build()
//                    .createInKeyStore(keyStorePattern.getFcAlias() , keyStorePattern.getFcPassword())
//                    .writeTo(out);
//            out.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
    }

}
