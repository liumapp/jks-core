package com.liumapp.jks.core.signature.require;

import com.liumapp.jks.core.job.JobData;

/**
 * file Base64StringSignerRequire.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/3/5
 */
public class Base64StringSignerRequire extends JobData {

    private String pdfBase64;

    private String content;

    private float firstX;

    private float firstY;

    private int page;

    private int fontSize;

    public Base64StringSignerRequire() {
    }

    public Base64StringSignerRequire(String pdfBase64, String content, float firstX, float firstY, int page, int fontSize) {
        this.pdfBase64 = pdfBase64;
        this.content = content;
        this.firstX = firstX;
        this.firstY = firstY;
        this.page = page;
        this.fontSize = fontSize;
    }

    public String getPdfBase64() {
        return pdfBase64;
    }

    public Base64StringSignerRequire setPdfBase64(String pdfBase64) {
        this.pdfBase64 = pdfBase64;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Base64StringSignerRequire setContent(String content) {
        this.content = content;
        return this;
    }

    public float getFirstX() {
        return firstX;
    }

    public Base64StringSignerRequire setFirstX(float firstX) {
        this.firstX = firstX;
        return this;
    }

    public float getFirstY() {
        return firstY;
    }

    public Base64StringSignerRequire setFirstY(float firstY) {
        this.firstY = firstY;
        return this;
    }

    public int getPage() {
        return page;
    }

    public Base64StringSignerRequire setPage(int page) {
        this.page = page;
        return this;
    }

    public int getFontSize() {
        return fontSize;
    }

    public Base64StringSignerRequire setFontSize(int fontSize) {
        this.fontSize = fontSize;
        return this;
    }
}
