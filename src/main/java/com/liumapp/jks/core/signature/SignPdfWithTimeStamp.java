package com.liumapp.jks.core.signature;

import com.alibaba.fastjson.JSONObject;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfSignatureAppearance;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.security.*;
import com.liumapp.jks.core.filter.RequestFilter;
import com.liumapp.jks.core.loader.ChainLoader;
import com.liumapp.jks.core.signature.require.SignPdfWithTimeStampRequire;
import com.liumapp.jks.core.util.FileManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.security.cert.Certificate;

/**
 * file SignPdfWithTimeStamp.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2018/9/1
 */
public class SignPdfWithTimeStamp extends RequestFilter<SignPdfWithTimeStampRequire> {

    @Override
    public JSONObject handle(SignPdfWithTimeStampRequire data) {
        this.loggerRequest(data);
        String tmpFile = this.getTmpFile(data.getPdfSavePath(), data.getPdfFileName());
        String resultFile = data.getResultSavePath() + "/" + data.getResultSaveName();
        try {
            data.initSecurityInfo();
            PdfReader pdfReader = new PdfReader(tmpFile);
            PdfStamper stamper = this.buildingStamper(pdfReader, resultFile, data.getPdfSavePath());
            PdfSignatureAppearance appearance = buildingAppearance(stamper, data.getReason(),
                    data.getLocation(), data.getFirstX(), data.getFirstY(),
                    data.getSecondX(), data.getSecondY(),
                    data.getPageNum(), data.getSignFieldName(), data.getSignPicPath(), data.getCertificationLevel(),
                    data.getRenderingMode());
            ExternalSignature pks = new PrivateKeySignature(data.getActivePrivateKey().getPrivateKey(), data.getDigestAlgorithm(), "BC");
            //摘要算法
            ExternalDigest digest = new BouncyCastleDigest();
            // 调用itext签名方法完成pdf签章
            MakeSignature.signDetached(appearance, digest, pks, this.buildingChain(data.getActiveCertificates()),
                    null, null, new TSAClientBouncyCastle(data.getTimeStampServer() + "?code=" + data.getAppCode()), 0, data.getSigtype());
            this.jobResult.put("msg", "success");
        } catch (Exception e) {
            e.printStackTrace();
            this.jobResult.put("msg", "error, maybe your appid or appsecret was wrong");
        } finally {
            File tmp = new File(tmpFile);
            if (tmp.exists()) {
                tmp.delete();
            }
        }
        return this.jobResult;
    }

    private Certificate[] buildingChain (ChainLoader.ActiveCertificate[] activeChain) {
        Certificate[] results = new Certificate[activeChain.length];
        for (int i = 0 ; i < activeChain.length ; i++) {
            results[i] = activeChain[i].getCertificate();
        }
        return results;
    }

    private PdfSignatureAppearance buildingAppearance (PdfStamper stamper,
                                                       String reason,
                                                       String location,
                                                       float firstX, float firstY,
                                                       float secondX, float secondY,
                                                       Integer pageNum, String fieldName,
                                                       String picPath, Integer certificateLevel,
                                                       PdfSignatureAppearance.RenderingMode renderingMode) {
        PdfSignatureAppearance appearance = stamper.getSignatureAppearance();
        Image image = null;
        try {
            appearance.setReason(reason);
            appearance.setLocation(location);
            //设置签名的位置，页码，签名域名称，多次追加签名的时候，签名域名称不能一样
            //签名的位置，是图章相对于pdf页面的位置坐标，原点为pdf页面左下角
            //四个参数的分别是，图章左下角x，图章左下角y，图章右上角x，图章右上角y
            appearance.setVisibleSignature(new Rectangle(Math.round(firstX),
                            Math.round(firstY) , Math.round(secondX), Math.round(secondY)),
                    pageNum, fieldName);
            image = Image.getInstance(picPath);
            appearance.setSignatureGraphic(image);
            appearance.setCertificationLevel(certificateLevel);
            //设置图章的显示方式，如下选择的是只显示图章（还有其他的模式，可以图章和签名描述一同显示）
            appearance.setRenderingMode(renderingMode);
        } catch (BadElementException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return appearance;
    }

    private PdfStamper buildingStamper (PdfReader pdfReader, String resultFile, String savepath) {
        FileOutputStream os = null;
        PdfStamper stamper = null;
        try {
            os = new FileOutputStream(new File(resultFile));
            stamper = PdfStamper.createSignature(pdfReader, os, '\0', null , true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stamper;
    }

    private String getTmpFile (String savePath, String originalFileName) {
        FileManager fileManager = new FileManager();
        String tmpName = fileManager.generateRandomFileName() + ".pdf";
        try {
            fileManager.copyFile(new File(savePath + "/" +originalFileName), new File(savePath + "/" + tmpName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return savePath + "/" + tmpName;
    }

}
