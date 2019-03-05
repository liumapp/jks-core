package com.liumapp.jks.core;

import com.alibaba.fastjson.JSONObject;
import com.liumapp.jks.core.signature.Base64StringSigner;
import com.liumapp.jks.core.signature.StringSigner;
import com.liumapp.jks.core.signature.require.Base64StringSignerRequire;
import com.liumapp.jks.core.signature.require.StringSignerRequire;
import com.liumapp.jks.core.util.FileManager;
import com.liumapp.qtools.file.base64.Base64FileTool;
import junit.framework.TestCase;
import org.junit.Assert;

import java.io.File;
import java.io.IOException;

/**
 * author liumapp
 * file UtilTest.java
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 7/17/18
 */
public class UtilTest extends TestCase {

    private String savepath = "/usr/local/tomcat/project/jks-core/data";

    private boolean debug = true;

    public void testCopyFile () throws IOException {
        if (debug) {
            FileManager fileManager = new FileManager();
            fileManager.copyFile(new File(savepath + "/" + "test.pdf"), new File(savepath + "/" + "test_copy.pdf"));
            File test = new File(savepath + "/" + "test_copy.pdf");
            if (test.exists()) {
                Assert.assertTrue(true);
                test.delete();
            } else {
                Assert.assertTrue(false);
            }
        }
    }

    public void testSignString () {
        if (debug) {
            JksCore jksCore = new JksCore();
            StringSigner stringSigner = new StringSigner();
            StringSignerRequire stringSignerRequire = new StringSignerRequire();
            stringSignerRequire.setContent("hello world, 你好呀世界")
                    .setPdfPath(this.savepath + "/test.pdf")
                    .setResultPath(this.savepath + "/test_result.pdf")
                    .setFirstX(50)
                    .setFirstY(50)
                    .setPage(1)
                    .setFontSize(12);
            JSONObject result = jksCore.doJob(stringSigner, stringSignerRequire);
            System.out.println(result.toJSONString());
        }
    }

    public void testBase64SignString () throws IOException {
        if (debug) {
            JksCore jksCore = new JksCore();
            Base64StringSigner base64StringSigner = new Base64StringSigner();
            Base64StringSignerRequire base64StringSignerRequire = new Base64StringSignerRequire();
            base64StringSignerRequire.setContent("hello world , 你好呀你好呀")
                    .setPdfBase64(Base64FileTool.filePathToBase64(savepath + "/test.pdf"))
                    .setFirstX(100)
                    .setFirstY(100)
                    .setPage(1)
                    .setFontSize(12);
            JSONObject result = jksCore.doJob(base64StringSigner, base64StringSignerRequire);
            Base64FileTool.saveBase64File(result.get("content").toString(), savepath + "/test_result_2.pdf");
        }
    }

}
