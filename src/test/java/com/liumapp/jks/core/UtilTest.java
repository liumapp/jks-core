package com.liumapp.jks.core;

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

    public void testCopyFile () throws IOException {
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
