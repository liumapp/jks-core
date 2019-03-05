package com.liumapp.jks.core.signature;

import com.alibaba.fastjson.JSONObject;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.liumapp.jks.core.filter.RequestFilter;
import com.liumapp.jks.core.signature.require.StringSignerRequire;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * file StringSigner.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/3/5
 */
public class StringSigner extends RequestFilter<StringSignerRequire> {

    @Override
    public JSONObject handle(StringSignerRequire data) {
        try {
            PdfReader pdfReader = new PdfReader(data.getPdfPath());
            PdfStamper stamper = new PdfStamper(pdfReader, new FileOutputStream(data.getResultPath()));
            PdfContentByte canvas = stamper.getOverContent();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }


        return null;
    }

}
