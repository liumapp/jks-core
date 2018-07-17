package com.liumapp.jks.core.signature;

import com.alibaba.fastjson.JSONObject;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.liumapp.jks.core.filter.RequestFilter;
import com.liumapp.jks.core.signature.require.SignPdfRequire;
import com.liumapp.jks.core.util.FileManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

/**
 * @author liumapp
 * @file SignPdf.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 7/10/18
 */
public class SignPdf extends RequestFilter<SignPdfRequire> {

    @Override
    public JSONObject handle(SignPdfRequire data) {
        this.loggerRequest(data);
        String tmpFile = this.getTmpFile(data.getPdfSavePath(), data.getPdfFileName());
        try {
            data.initSecurityInfo();
            PdfReader pdfReader = new PdfReader(tmpFile);
            PdfStamper stamper = this.buildingStamper();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            File tmp = new File(tmpFile);
            if (tmp.exists()) {
                tmp.delete();
            }
        }
        return null;
    }

    private PdfStamper buildingStamper (PdfReader pdfReader, String handlFile) {
        FileOutputStream os = null;
        PdfStamper stamper = null;
        try {
            os = new FileOutputStream(new File(handlFile));
            stamper = PdfStamper.createSignature()
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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
