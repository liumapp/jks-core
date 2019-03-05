package com.liumapp.jks.core.signature;

import com.alibaba.fastjson.JSONObject;
import com.liumapp.jks.core.filter.RequestFilter;
import com.liumapp.jks.core.signature.require.Base64StringSignerRequire;

public class Base64StringSigner extends RequestFilter<Base64StringSignerRequire> {

    @Override
    public JSONObject handle(Base64StringSignerRequire data) {
        return null;
    }
}
