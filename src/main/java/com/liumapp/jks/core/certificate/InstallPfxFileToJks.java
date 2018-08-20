package com.liumapp.jks.core.certificate;

import com.alibaba.fastjson.JSONObject;
import com.liumapp.jks.core.certificate.require.InstallPfxFileToJksRequire;
import com.liumapp.jks.core.filter.RequestFilter;
import com.liumapp.jks.core.util.PfxUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * author liumapp
 * file InstallPfxFileToJks.java
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2018/8/9
 */
public class InstallPfxFileToJks extends RequestFilter<InstallPfxFileToJksRequire> {

    private static Logger LOGGER = LoggerFactory.getLogger(InstallPfxFileToJks.class);

    @Override
    public JSONObject handle(InstallPfxFileToJksRequire data) {
        try {
            PfxUtil pfxUtil = new PfxUtil();
            pfxUtil.Pfx2OldJKS(data.getPfxFilePath() + "/" + data.getPfxFileName(),
                    data.getPfxPasswd(),
                    data.getKeystorePath() + "/" + data.getKeystoreName(),
                    data.getKeystorePasswd(),
                    null,
                    data.getAlias());
            this.jobResult.put("msg", "success");
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            this.jobResult.put("msg", "error");
        }
        return this.jobResult;
    }

}
