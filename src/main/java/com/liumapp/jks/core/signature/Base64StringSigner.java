package com.liumapp.jks.core.signature;

import com.alibaba.fastjson.JSONObject;
import com.itextpdf.awt.AsianFontMapper;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.*;
import com.liumapp.jks.core.filter.RequestFilter;
import com.liumapp.jks.core.signature.require.Base64StringSignerRequire;
import com.liumapp.qtools.file.base64.Base64FileTool;
import com.liumapp.qtools.file.basic.FileTool;
import com.liumapp.qtools.str.random.StrRandomTool;

import java.io.FileOutputStream;
import java.io.IOException;

public class Base64StringSigner extends RequestFilter<Base64StringSignerRequire> {

    @Override
    public JSONObject handle(Base64StringSignerRequire data) {
        try {
            String tmpFileName = "tmp_" + StrRandomTool.getRandom(12) + ".pdf";
            String tmpResultFile = "result_" + tmpFileName;
            Base64FileTool.saveBase64File(data.getPdfBase64(), "./" + tmpFileName);
            PdfReader pdfReader = new PdfReader("./" + tmpFileName);
            PdfStamper stamper = new PdfStamper(pdfReader, new FileOutputStream(tmpResultFile));
            PdfContentByte canvas = stamper.getOverContent(data.getPage());
            BaseFont baseFont = BaseFont.createFont(AsianFontMapper.ChineseSimplifiedFont,  AsianFontMapper.ChineseSimplifiedEncoding_H, BaseFont.NOT_EMBEDDED);
            Font font = new Font(baseFont, data.getFontSize());
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(data.getContent(), font),
                    data.getFirstX(), data.getFirstY(), 0);
            stamper.close();
            FileTool.deleteFile(tmpFileName);
            FileTool.deleteFile(tmpResultFile);
            this.jobResult.put("result", "success");
            this.jobResult.put("content", Base64FileTool.filePathToBase64(tmpResultFile));
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
