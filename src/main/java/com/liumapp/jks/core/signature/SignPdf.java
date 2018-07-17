package com.liumapp.jks.core.signature;

import com.alibaba.fastjson.JSONObject;
import com.itextpdf.text.pdf.PdfReader;
import com.liumapp.jks.core.filter.RequestFilter;
import com.liumapp.jks.core.signature.require.SignPdfRequire;

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
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
