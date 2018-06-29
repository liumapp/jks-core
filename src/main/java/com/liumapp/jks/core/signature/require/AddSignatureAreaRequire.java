package com.liumapp.jks.core.signature.require;

import com.liumapp.jks.core.job.JobData;

/**
 * @author liumapp
 * @file AddSignatureAreaRequire.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 6/29/18
 */
public class AddSignatureAreaRequire extends JobData {

    private String pdfSavePath;

    private String pdfFileName;

    private String resultSavePath;

    private String resultSaveName;

    private String reason;

    private String location;

    private float firstX;

    private float firstY;

    private float secondX;

    private float secondY;

    private Integer pageNum;

    private String signFieldName;

    public String getSignFieldName() {
        return signFieldName;
    }

    public void setSignFieldName(String signFieldName) {
        this.signFieldName = signFieldName;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public float getFirstX() {
        return firstX;
    }

    public void setFirstX(float firstX) {
        this.firstX = firstX;
    }

    public float getFirstY() {
        return firstY;
    }

    public void setFirstY(float firstY) {
        this.firstY = firstY;
    }

    public float getSecondX() {
        return secondX;
    }

    public void setSecondX(float secondX) {
        this.secondX = secondX;
    }

    public float getSecondY() {
        return secondY;
    }

    public void setSecondY(float secondY) {
        this.secondY = secondY;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getResultSavePath() {
        return resultSavePath;
    }

    public void setResultSavePath(String resultSavePath) {
        this.resultSavePath = resultSavePath;
    }

    public String getResultSaveName() {
        return resultSaveName;
    }

    public void setResultSaveName(String resultSaveName) {
        this.resultSaveName = resultSaveName;
    }

    public String getPdfSavePath() {
        return pdfSavePath;
    }

    public void setPdfSavePath(String pdfSavePath) {
        this.pdfSavePath = pdfSavePath;
    }

    public String getPdfFileName() {
        return pdfFileName;
    }

    public void setPdfFileName(String pdfFileName) {
        this.pdfFileName = pdfFileName;
    }
}
