package com.liumapp.jks.core.certificate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.liumapp.jks.core.certificate.require.CACertificateRequire;
import com.liumapp.jks.core.filter.RequestFilter;
import com.liumapp.jks.core.status.Status;
import com.liumapp.jks.core.util.FileManager;
import com.liumapp.jks.core.util.HttpUtil;
import com.liumapp.jks.core.util.PfxUtil;
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

    private HttpUtil httpUtil;

    private PfxUtil pfxUtil;

    private FileManager fileManager;

    public RequireCACertificate() {
        this.httpUtil = new HttpUtil();
        this.pfxUtil = new PfxUtil();
        this.fileManager = new FileManager();
    }

    private static Logger LOGGER = LoggerFactory.getLogger(RequireCACertificate.class);

    @Override
    public JSONObject handle(CACertificateRequire data) {
        Map<String, String> headers = new HashMap<String, String>();
        Map<String, String> querys = new HashMap<String, String>();
        JSONObject object = new JSONObject();
        String pfxFileName = fileManager.generateRandomFileName() + ".pfx";
        try {
            object.put("name", data.getName());
            object.put("code", data.getAppCode());
            object.put("password", data.getCertPassword());
            object.put("country", data.getCountry());
            object.put("province", data.getProvince());
            object.put("city", data.getCity());
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
            if (res_obj.get("status").toString().equals(Status.SUCCESS.getValue())) {
                pfxUtil.makePfxFileByBase64(res_obj.getString("pfx"), data.getKeystorePath(), pfxFileName);
                pfxUtil.Pfx2OldJKS(data.getKeystorePath() + "/" + pfxFileName,
                        data.getCertPassword(),
                        data.getKeystorePath() + "/" + data.getKeystoreName(),
                        data.getStorepass(), null, data.getCertAlias());
                fileManager.rmFile(data.getKeystorePath() + "/" + pfxFileName);
                this.jobResult.put("msg", "success");
                this.jobResult.put("res", res_obj.toJSONString());
            } else {
                this.jobResult.put("msg", "error");
            }

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            this.jobResult.put("msg", "error");
        }
        return this.jobResult;
    }

}
