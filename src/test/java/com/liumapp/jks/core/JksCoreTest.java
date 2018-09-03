package com.liumapp.jks.core;

import com.alibaba.fastjson.JSONObject;
import com.liumapp.jks.core.certificate.ExportCertificate;
import com.liumapp.jks.core.certificate.GenerateCertificate;
import com.liumapp.jks.core.certificate.InstallPfxFileToJks;
import com.liumapp.jks.core.certificate.RequireCACertificate;
import com.liumapp.jks.core.certificate.require.CACertificateRequire;
import com.liumapp.jks.core.certificate.require.ExportCertificateRequire;
import com.liumapp.jks.core.certificate.require.GenerateCertificateRequire;
import com.liumapp.jks.core.certificate.require.InstallPfxFileToJksRequire;
import com.liumapp.jks.core.container.GenerateJksContainer;
import com.liumapp.jks.core.container.require.GenerateJksContainerRequire;
import com.liumapp.jks.core.signature.SignPdf;
import com.liumapp.jks.core.signature.SignPdfWithTimeStamp;
import com.liumapp.jks.core.signature.require.SignPdfRequire;
import com.liumapp.jks.core.signature.require.SignPdfWithTimeStampRequire;
import com.liumapp.qtools.date.DateTool;
import com.liumapp.qtools.security.encrypt.Sha1Tool;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.Test;

import java.io.File;
import java.util.Date;

/**
 * author liumapp
 * file JksCoreTest.java
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 6/28/18
 */
public class JksCoreTest extends TestCase {

    private String jksSavePath = "/usr/local/tomcat/project/jks-core/data/";

    private boolean debug = true;

    @Override
    protected void setUp() throws Exception {
        if (debug) {
            File file = new File(this.jksSavePath);
            Assert.assertEquals(true, file.isDirectory());
            super.setUp();
        }
    }

    /**
     * 生成证书容器，运行之前，请先设置jksSavePath（容器存放目录）的值
     * you can use
     * keytool -list -v -keystore ./demo.ks
     * to view keystore detail
     */
    @Test
    public void testGenerateContainer () {
        if (debug) {
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
    }

    /**
     * 生成自签证书
     */
    @Test
    public void testGenerateCertificate () {
        if (debug) {
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
    }

    /**
     * 获取正式证书，并存入证书容器中
     * 正式证书只有一天的有效期，意味着申请后必须在一天之内完成签署，否则您需要重新申请新的证书
     * 正式证书的申请将会产生扣费操作，并且一经申请，您需要确保对其本人真实性的有效操作
     * 如额外购买了实名认证接口，请联系技术liumapp负责对接
     */
    @Test
    public void testRequireCACertificate () {
        if (debug) {
            JksCore jksCore = new JksCore();
            RequireCACertificate requireCACertificate = new RequireCACertificate();
            CACertificateRequire caCertificateRequire = new CACertificateRequire();
            caCertificateRequire.setAppId("test_app_id")
                    .setAppSecret("test_app_secret")
                    .setHost("http://localhost:3030")
                    .setPath("/cert/generate")
                    .setName("lisi")
                    .setIdentityCode("123123123123123123")
                    .setEmail("liumapp.com@gmail.com")
                    .setOrganization("这里填写贵公司名称")
                    .setOrganizationUnit("这里填写贵部门名称")
                    .setCertAlias("alias-custom")
                    .setCertPassword("123123123")
                    .setKeystoreName("demo.ks")
                    .setStorepass("123456")
                    .setKeystorePath(this.jksSavePath);
            JSONObject result = jksCore.doJob(requireCACertificate, caCertificateRequire);
            Assert.assertEquals("success", result.get("msg"));
        }
    }

    /**
     * 根据alias导出证书
     */
    @Test
    public void testExportCertificate () {
        if (debug) {
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
    }

    @Test
    public void testInstallPfx () {
        if (debug) {
            JksCore jksCore = new JksCore();
            InstallPfxFileToJks installPfxFileToJks = new InstallPfxFileToJks();
            InstallPfxFileToJksRequire installPfxFileToJksRequire = new InstallPfxFileToJksRequire();
            installPfxFileToJksRequire.setAlias("zj")
                    .setKeystoreName("demo.ks")
                    .setKeystorePath(this.jksSavePath)
                    .setKeystorePasswd("123456")
                    .setPfxFileName("zj-123456.pfx")
                    .setPfxFilePath(this.jksSavePath)
                    .setPfxPasswd("123456");
            JSONObject result = jksCore.doJob(installPfxFileToJks, installPfxFileToJksRequire);
            Assert.assertEquals("success", result.get("msg"));
        }
    }

    /**
     * 签署证书到PDF中
     */
    @Test
    public void testSignFirstCertificateToPdf () {
        if (debug) {
            JksCore jksCore = new JksCore();
            SignPdf signPdf = new SignPdf();
            SignPdfRequire signPdfRequire = new SignPdfRequire();
            signPdfRequire.setKsPath(this.jksSavePath)
                    .setKsName("demo.ks")
                    .setKsPassword("123456".toCharArray())
                    .setCertAlias("ca-cert-alias")
                    .setCertPassword("123123123".toCharArray())
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
    }

    @Test
    public void testSignFirstCertificateWithTimeStampToPdf () {
        if (debug) {
            String url = "http://localhost:3030/timestamp/require";
            JksCore jksCore = new JksCore();
            SignPdfWithTimeStamp signPdfWithTimeStamp = new SignPdfWithTimeStamp();
            SignPdfWithTimeStampRequire signPdfWithTimeStampRequire = new SignPdfWithTimeStampRequire();
            signPdfWithTimeStampRequire.setKsPath(this.jksSavePath)
                    .setAppId("test_app_id")
                    .setAppSecret("test_app_secret")
                    .setKsName("demo.ks")
                    .setKsPassword("123456".toCharArray())
                    .setCertAlias("alias-custom")
                    .setCertPassword("123123123".toCharArray())
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
                    .setSignPicPath(this.jksSavePath + "/" + "me.jpg")
                    .setTimeStampServer(url);
            JSONObject result = jksCore.doJob(signPdfWithTimeStamp, signPdfWithTimeStampRequire);
            Assert.assertEquals("success", result.get("msg"));
        }
    }

    /**
     * 继续签署第二张证书，后续的第三张、第四张证书的签署原理相同
     */
    @Test
    public void testSignSecondCertificateToPdf () {
        if (debug) {
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

}
