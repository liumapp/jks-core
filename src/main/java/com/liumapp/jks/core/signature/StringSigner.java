package com.liumapp.jks.core.signature;

import com.alibaba.fastjson.JSONObject;
import com.liumapp.jks.core.filter.RequestFilter;
import com.liumapp.jks.core.signature.require.StringSignerRequire;

/**
 * file StringSigner.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/3/5
 */
public class StringSigner extends RequestFilter<StringSignerRequire> {
    @Override
    public JSONObject handle(StringSignerRequire data) {
        return null;
    }
}
