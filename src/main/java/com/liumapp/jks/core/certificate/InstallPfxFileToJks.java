package com.liumapp.jks.core.certificate;

import com.alibaba.fastjson.JSONObject;
import com.liumapp.jks.core.certificate.require.InstallPfxFileToJksRequire;
import com.liumapp.jks.core.filter.RequestFilter;

/**
 * @author liumapp
 * @file InstallPfxFileToJks.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 2018/8/9
 */
public class InstallPfxFileToJks extends RequestFilter<InstallPfxFileToJksRequire> {

    @Override
    public JSONObject handle(InstallPfxFileToJksRequire data) {
        return null;
    }

}
