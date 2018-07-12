package com.liumapp.jks.core;

import com.alibaba.fastjson.JSONObject;
import com.liumapp.jks.core.certificate.ExportCertificate;
import com.liumapp.jks.core.certificate.GenerateCertificate;
import com.liumapp.jks.core.certificate.require.ExportCertificateRequire;
import com.liumapp.jks.core.certificate.require.GenerateCertificateRequire;
import com.liumapp.jks.core.container.GenerateJksContainer;
import com.liumapp.jks.core.container.require.GenerateJksContainerRequire;
import com.liumapp.jks.core.signature.AddSignatureArea;
import com.liumapp.jks.core.signature.require.AddSignatureAreaRequire;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;

/**
 * @author liumapp
 * @file JksCoreTest.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 6/28/18
 */
public class JksCoreTest extends TestCase {

    private String jksSavePath = "/usr/local/tomcat/project/jks-core/data/";

    @Override
    protected void setUp() throws Exception {
        File file = new File(this.jksSavePath);
        Assert.assertEquals(true, file.isDirectory());
        super.setUp();
    }

    /**
     * you can use
     * keytool -list -v -keystore ./demo.ks
     * to view keystore detail
     */
    @Test
    public void testGenerateContainer () {
        JksCore jksCore = new JksCore();
        GenerateJksContainer generateJksContainer = new GenerateJksContainer();
        GenerateJksContainerRequire generateJksContainerRequire = new GenerateJksContainerRequire();
        generateJksContainerRequire.setSavePath(this.jksSavePath)
                        .setKeyStoreName("demo.ks")
                        .setKeyStorePd("123456")//container password
                        .setFcAlias("first-cert")//alias of first certificate
                        .setFcPassword("123123")//password of first certificate
                        .setFcName("liumapp")
                        .setFcCountry("CN")
                        .setFcProvince("ZJ")
                        .setFcCity("Hangzhou");
        JSONObject result = jksCore.doJob(generateJksContainer, generateJksContainerRequire);
        Assert.assertEquals("success", result.get("msg"));
    }

    @Test
    public void testGenerateCertificate () {
        JksCore jksCore = new JksCore();
        GenerateCertificate generateCertificate = new GenerateCertificate();
        GenerateCertificateRequire generateCertificateRequire = new GenerateCertificateRequire();
        generateCertificateRequire.setAlias("second-cert")
                        .setCertPassword("123123")
                        .setCountry("CN")
                        .setProvince("ZJ")
                        .setCity("Hangzhou")
                        .setKeystorePath(this.jksSavePath)
                        .setKeystoreName("demo.ks")
                        .setStorepass("123456")
                        .setValidity(1)
                        .setName("zhangsan");
        JSONObject result = jksCore.doJob(generateCertificate, generateCertificateRequire);
        Assert.assertEquals("success", result.get("msg"));
    }

    @Test
    public void testExportCertificate () {
        JksCore jksCore = new JksCore();
        ExportCertificate exportCertificate = new ExportCertificate();
        ExportCertificateRequire exportCertificateRequire = new ExportCertificateRequire();
        exportCertificateRequire.setAlias("first-cert");
        exportCertificateRequire.setCertSavePath(this.jksSavePath);
        exportCertificateRequire.setCertName("first-cert.cer");
        exportCertificateRequire.setKeystorePath(this.jksSavePath);
        exportCertificateRequire.setKeystoreName("demo.ks");
        exportCertificateRequire.setKeystorePasswd("123456");
        JSONObject result = jksCore.doJob(exportCertificate, exportCertificateRequire);
        Assert.assertEquals("success", result.get("msg"));
    }

    /**
     * todo
     */
    @Test
    @Ignore
    public void testAddSignatureArea () {
        JksCore jksCore = new JksCore();
        AddSignatureArea addSignatureArea = new AddSignatureArea();
        AddSignatureAreaRequire addSignatureAreaRequire = new AddSignatureAreaRequire();
        addSignatureAreaRequire.setFirstX(100);
        addSignatureAreaRequire.setFirstY(100);
        addSignatureAreaRequire.setSecondX(250);
        addSignatureAreaRequire.setSecondY(250);
        addSignatureAreaRequire.setLocation("this is location value");
        addSignatureAreaRequire.setReason("this is reason value");
        addSignatureAreaRequire.setPageNum(1);
        addSignatureAreaRequire.setPdfSavePath(this.jksSavePath);
        addSignatureAreaRequire.setPdfFileName("test.pdf");
        addSignatureAreaRequire.setResultSavePath(this.jksSavePath);
        addSignatureAreaRequire.setResultSaveName("test-with-signature.pdf");
        addSignatureAreaRequire.setSignFieldName("signature");
        JSONObject result = jksCore.doJob(addSignatureArea, addSignatureAreaRequire);
        Assert.assertEquals("success", result.get("msg"));
    }

    /**
     * todo
     */
    @Test
    @Ignore
    public void testAddMultySignatureArea () {
        Integer number = 3;
        JksCore jksCore = new JksCore();
        AddSignatureArea addSignatureArea = new AddSignatureArea();
        AddSignatureAreaRequire addSignatureAreaRequire = new AddSignatureAreaRequire();
        for (int i = 0 ; i < number ; i++) {
            JSONObject result = jksCore.doJob(addSignatureArea, addSignatureAreaRequire);
            Assert.assertEquals("success", result.get("msg"));
        }
    }

    @Test
    public void testSignCertificateToPdf () {
        JksCore jksCore = new JksCore();

    }

}
