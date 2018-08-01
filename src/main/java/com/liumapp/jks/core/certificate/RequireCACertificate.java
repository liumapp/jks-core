package com.liumapp.jks.core.certificate;

import com.alibaba.fastjson.JSONObject;
import com.liumapp.jks.core.certificate.require.CACertificateRequire;
import com.liumapp.jks.core.filter.RequestFilter;
import com.liumapp.jks.core.util.HttpUtil;
import org.apache.http.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liumapp
 * @file RequireCACertificate.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 2018/8/1
 */
public class RequireCACertificate extends RequestFilter <CACertificateRequire> {

    private static Logger LOGGER = LoggerFactory.getLogger(RequireCACertificate.class);

    @Override
    public JSONObject handle(CACertificateRequire data) {
        HttpUtil httpUtil = new HttpUtil();
        Map<String, String> headers = new HashMap<String, String>();
        Map<String, String> querys = new HashMap<String, String>();
        JSONObject object = new JSONObject();

        String bodys = object.toJSONString();
        try {
            headers.put("Authorization", data.getAppCode());
            HttpResponse response = httpUtil.doPost(data.getHost(),
                    data.getPath(),
                    "POST",
                    headers,
                    querys,
                    bodys);
            this.jobResult.put("msg", "success");
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            this.jobResult.put("msg", "error");
        }
        return this.jobResult;
    }

}
