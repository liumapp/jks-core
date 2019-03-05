package com.liumapp.jks.core;

import com.alibaba.fastjson.JSONObject;
import com.liumapp.jks.core.signature.StringSigner;
import com.liumapp.jks.core.signature.require.StringSignerRequire;
import com.liumapp.jks.core.util.FileManager;
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
            stringSignerRequire.setContent("你好呀世界")
                    .setPdfPath(this.savepath + "/test.pdf")
                    .setFirstX(50)
                    .setFirstY(50);
            JSONObject result = jksCore.doJob(stringSigner, stringSignerRequire);
            System.out.println(result.toJSONString());
        }
    }

}
