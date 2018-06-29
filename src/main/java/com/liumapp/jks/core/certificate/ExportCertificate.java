package com.liumapp.jks.core.certificate;

import com.alibaba.fastjson.JSONObject;
import com.liumapp.jks.core.certificate.require.ExportCertificateRequire;
import com.liumapp.jks.core.filter.RequestFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
        
        return null;
    }

}
