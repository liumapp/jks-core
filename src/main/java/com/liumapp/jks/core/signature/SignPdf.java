package com.liumapp.jks.core.signature;

import com.alibaba.fastjson.JSONObject;
import com.liumapp.jks.core.filter.RequestFilter;
import com.liumapp.jks.core.keypair.LoadKeyChainService;
import com.liumapp.jks.core.signature.require.SignPdfRequire;

/**
 * @author liumapp
 * @file SignPdf.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 7/10/18
 */
public class SignPdf extends RequestFilter<SignPdfRequire> implements LoadKeyChainService {

    @Override
    public JSONObject handle(SignPdfRequire data) {
        this.loggerRequest(data);

        return null;
    }

}
