package com.liumapp.jks.core.signature.require;

import com.liumapp.jks.core.job.JobData;

/**
 * file StringSignerRequire.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/3/5
 */
public class StringSignerRequire extends JobData {

    private String pdfPath;

    private String resultPath;

    private String content;

    private float firstX;

    private float firstY;

    private int page;

    public StringSignerRequire() {
    }

    public StringSignerRequire(String pdfPath, String resultPath, String content, float firstX, float firstY, int page) {
        this.pdfPath = pdfPath;
        this.resultPath = resultPath;
        this.content = content;
        this.firstX = firstX;
        this.firstY = firstY;
        this.page = page;
    }

    public int getPage() {
        return page;
    }

    public StringSignerRequire setPage(int page) {
        this.page = page;
        return this;
    }

    public String getResultPath() {
        return resultPath;
    }

    public StringSignerRequire setResultPath(String resultPath) {
        this.resultPath = resultPath;
        return this;
    }

    public String getPdfPath() {
        return pdfPath;
    }

    public StringSignerRequire setPdfPath(String pdfPath) {
        this.pdfPath = pdfPath;
        return this;
    }

    public String getContent() {
        return content;
    }

    public StringSignerRequire setContent(String content) {
        this.content = content;
        return this;
    }

    public float getFirstX() {
        return firstX;
    }

    public StringSignerRequire setFirstX(float firstX) {
        this.firstX = firstX;
        return this;
    }

    public float getFirstY() {
        return firstY;
    }

    public StringSignerRequire setFirstY(float firstY) {
        this.firstY = firstY;
        return this;
    }
}
