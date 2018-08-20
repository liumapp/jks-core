package com.liumapp.jks.core.signature;

import com.alibaba.fastjson.JSONObject;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfSignatureAppearance;
import com.itextpdf.text.pdf.PdfStamper;
import com.liumapp.jks.core.filter.RequestFilter;
import com.liumapp.jks.core.signature.require.AddSignatureAreaRequire;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * author liumapp
 * file AddSignatureArea.java
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 6/29/18
 */
public class AddSignatureArea extends RequestFilter<AddSignatureAreaRequire> {

    private static Logger LOGGER = LoggerFactory.getLogger(AddSignatureArea.class);

    /**
     * under coding , plz do not use right now
     * todo
     */
    @Override
    public JSONObject handle(AddSignatureAreaRequire data) {
        this.loggerRequest(data);
        InputStream pdfStream = null;
        try {
            pdfStream = new FileInputStream(data.getPdfSavePath() + "/" + data.getPdfFileName());
            PdfReader reader = new PdfReader(pdfStream);
            FileOutputStream out = new FileOutputStream(new File(data.getResultSavePath() + "/" + data.getPdfFileName()));
            File temp = new File(data.getResultSavePath() + "/" + data.getResultSaveName());
            PdfStamper stamper = PdfStamper.createSignature(reader, out, '\0', temp, true);
            PdfSignatureAppearance appearance = stamper.getSignatureAppearance();
            appearance.setReason(data.getReason());
            appearance.setLocation(data.getLocation());
            appearance.setVisibleSignature(new Rectangle(data.getFirstX(),
                    data.getFirstY(),
                    data.getSecondX(),
                    data.getSecondY()),
                    data.getPageNum(),
                    data.getSignFieldName());
            this.jobResult.put("msg", "success");
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            this.jobResult.put("msg", "error");
        } finally {
            try {
                pdfStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return this.jobResult;
    }

}
