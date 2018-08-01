package com.liumapp.jks.core;

import com.alibaba.fastjson.JSONObject;
import com.liumapp.jks.core.certificate.ExportCertificate;
import com.liumapp.jks.core.certificate.GenerateCertificate;
import com.liumapp.jks.core.certificate.RequireCACertificate;
import com.liumapp.jks.core.certificate.require.CACertificateRequire;
import com.liumapp.jks.core.certificate.require.ExportCertificateRequire;
import com.liumapp.jks.core.certificate.require.GenerateCertificateRequire;
import com.liumapp.jks.core.container.GenerateJksContainer;
import com.liumapp.jks.core.container.require.GenerateJksContainerRequire;
import com.liumapp.jks.core.signature.SignPdf;
import com.liumapp.jks.core.signature.require.SignPdfRequire;
import junit.framework.Assert;
import junit.framework.TestCase;
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
                        .setName("zhangsan")
                        .setKeystorePath(this.jksSavePath)
                        .setKeystoreName("demo.ks")
                        .setStorepass("123456")
                        .setValidity(1);
        JSONObject result = jksCore.doJob(generateCertificate, generateCertificateRequire);
        Assert.assertEquals("success", result.get("msg"));
    }

    @Test
    public void testRequireCACertificate () {
        // todo
        JksCore jksCore = new JksCore();
        RequireCACertificate requireCACertificate = new RequireCACertificate();
        CACertificateRequire caCertificateRequire = new CACertificateRequire();
        caCertificateRequire.setAppId("your_app_id")
                    .setAppSecret("your_app_secret")
                    .setHost("https://localhost:3030")
                    .setPath("/cert/generate")
                    .setIdentityCode("user_identity_code")
                    .setName("wangwu")
                    .setCertPassword("123123123")
                    .setCity("Hangzhou")
                    .setCountry("CN")
                    .setProvince("Zhejiang")
                    .setKeystoreName("demo.ks")
                    .setKeystorePath(this.jksSavePath);

        JSONObject result = jksCore.doJob(requireCACertificate, caCertificateRequire);
        Assert.assertEquals("success", result.get("msg"));
    }

    @Test
    public void testExportCertificate () {
        JksCore jksCore = new JksCore();
        ExportCertificate exportCertificate = new ExportCertificate();
        ExportCertificateRequire exportCertificateRequire = new ExportCertificateRequire();
        exportCertificateRequire.setAlias("first-cert")
                        .setCertSavePath(this.jksSavePath)
                        .setCertName("first-cert.cer")
                        .setKeystorePath(this.jksSavePath)
                        .setKeystoreName("demo.ks")
                        .setKeystorePasswd("123456");
        JSONObject result = jksCore.doJob(exportCertificate, exportCertificateRequire);
        Assert.assertEquals("success", result.get("msg"));
    }

    /**
     * todo
     */
//    @Test
//    @Ignore
//    public void testAddSignatureArea () {
//        JksCore jksCore = new JksCore();
//        AddSignatureArea addSignatureArea = new AddSignatureArea();
//        AddSignatureAreaRequire addSignatureAreaRequire = new AddSignatureAreaRequire();
//        addSignatureAreaRequire.setFirstX(100);
//        addSignatureAreaRequire.setFirstY(100);
//        addSignatureAreaRequire.setSecondX(250);
//        addSignatureAreaRequire.setSecondY(250);
//        addSignatureAreaRequire.setLocation("this is location value");
//        addSignatureAreaRequire.setReason("this is reason value");
//        addSignatureAreaRequire.setPageNum(1);
//        addSignatureAreaRequire.setPdfSavePath(this.jksSavePath);
//        addSignatureAreaRequire.setPdfFileName("test.pdf");
//        addSignatureAreaRequire.setResultSavePath(this.jksSavePath);
//        addSignatureAreaRequire.setResultSaveName("test-with-signature.pdf");
//        addSignatureAreaRequire.setSignFieldName("signature");
//        JSONObject result = jksCore.doJob(addSignatureArea, addSignatureAreaRequire);
//        Assert.assertEquals("success", result.get("msg"));
//    }

    /**
     * todo
     */
//    @Test
//    @Ignore
//    public void testAddMultySignatureArea () {
//        Integer number = 3;
//        JksCore jksCore = new JksCore();
//        AddSignatureArea addSignatureArea = new AddSignatureArea();
//        AddSignatureAreaRequire addSignatureAreaRequire = new AddSignatureAreaRequire();
//        for (int i = 0 ; i < number ; i++) {
//            JSONObject result = jksCore.doJob(addSignatureArea, addSignatureAreaRequire);
//            Assert.assertEquals("success", result.get("msg"));
//        }
//    }

    @Test
    public void testSignFirstCertificateToPdf () {
        JksCore jksCore = new JksCore();
        SignPdf signPdf = new SignPdf();
        SignPdfRequire signPdfRequire = new SignPdfRequire();
        signPdfRequire.setKsPath(this.jksSavePath)
                .setKsName("demo.ks")
                .setKsPassword("123456".toCharArray())
                .setCertAlias("first-cert")
                .setCertPassword("123123".toCharArray())
                .setPdfSavePath(this.jksSavePath)
                .setPdfFileName("test.pdf")
                .setResultSavePath(this.jksSavePath)
                .setResultSaveName("test_with_signed.pdf")
                .setReason("this is reason")
                .setLocation("this is location")
                .setFirstX(50)
                .setFirstY(50)
                .setSecondX(100)
                .setSecondY(100)
                .setPageNum(1)
                .setSignFieldName("firstSignatureArea")
                .setSignPicPath(this.jksSavePath + "/" + "me.jpg");
        JSONObject result = jksCore.doJob(signPdf, signPdfRequire);
        Assert.assertEquals("success", result.get("msg"));
    }

    @Test
    public void testSignSecondCertificateToPdf () {
        JksCore jksCore = new JksCore();
        SignPdf signPdf = new SignPdf();
        SignPdfRequire signPdfRequire = new SignPdfRequire();
        signPdfRequire.setKsPath(this.jksSavePath)
                .setKsName("demo.ks")
                .setKsPassword("123456".toCharArray())
                .setCertAlias("second-cert")
                .setCertPassword("123123".toCharArray())
                .setPdfSavePath(this.jksSavePath)
                .setPdfFileName("test_with_signed.pdf")
                .setResultSavePath(this.jksSavePath)
                .setResultSaveName("test_with_signed_2.pdf")
                .setReason("this is reason")
                .setLocation("this is location")
                .setFirstX(300)
                .setFirstY(300)
                .setSecondX(350)
                .setSecondY(350)
                .setPageNum(1)
                .setSignFieldName("secondSignatureArea")
                .setSignPicPath(this.jksSavePath + "/" + "girl.jpg");
        JSONObject result = jksCore.doJob(signPdf, signPdfRequire);
        Assert.assertEquals("success", result.get("msg"));
    }

}
