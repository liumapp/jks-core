package com.liumapp.jks.core.certificate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.liumapp.jks.core.certificate.require.CACertificateRequire;
import com.liumapp.jks.core.filter.RequestFilter;
import com.liumapp.jks.core.util.HttpUtil;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
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
        try {
            object.put("name", data.getName());
            object.put("identityCode", data.getIdentityCode());
            object.put("code", data.getAppCode());
            String bodys = object.toJSONString();
            headers.put("Content-Type", "application/json");
            HttpResponse response = httpUtil.doPost(data.getHost(),
                    data.getPath(),
                    "POST",
                    headers,
                    querys,
                    bodys);
            String res = EntityUtils.toString(response.getEntity());
            JSONObject res_obj = JSON.parseObject(res);
            this.jobResult.put("msg", "success");
            this.jobResult.put("res", res_obj.toJSONString());
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            this.jobResult.put("msg", "error");
        }
        return this.jobResult;
    }

}
