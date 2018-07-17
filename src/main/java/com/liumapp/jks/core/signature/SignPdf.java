package com.liumapp.jks.core.signature;

import com.alibaba.fastjson.JSONObject;
import com.itextpdf.text.pdf.PdfReader;
import com.liumapp.jks.core.filter.RequestFilter;
import com.liumapp.jks.core.signature.require.SignPdfRequire;
import com.liumapp.jks.core.util.FileManager;

import java.io.File;
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
        try {
            data.initSecurityInfo();
            PdfReader pdfReader = new PdfReader(data.getPdfSavePath() + "/" + data.getPdfFileName());
            String tmpFile = this.getTmpFile(data.getPdfSavePath(), data.getPdfFileName());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getTmpFile (String savePath, String originalFileName) {
        FileManager fileManager = new FileManager();
        String tmpName = fileManager.generateRandomFileName() + ".pdf";
        try {
            fileManager.copyFile(new File(savePath + "/" +originalFileName), new File(savePath + "/" + tmpName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tmpName;
    }

}
