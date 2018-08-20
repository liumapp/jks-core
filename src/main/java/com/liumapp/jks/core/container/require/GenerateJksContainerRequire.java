package com.liumapp.jks.core.container.require;

import com.liumapp.jks.core.job.JobData;

/**
 * author liumapp
 * file GenerateJksContainerRequire.java
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 6/28/18
 */
public class GenerateJksContainerRequire extends JobData {

    private String savePath;

    private String keyStoreName;

    private String keyStorePd;

    private Integer keyLength = 2048;

    /**
     * fc: first certificate
     *
     * 个人证书：个人姓名
     *
     * 企业证书：企业名称
     *
     * 在生成keystore的时候，需要初始化第一个证书
     */
    private String fcName;

    private String fcProvince;

    private String fcCity;

    private String fcCountry;

    /**
     * 建议与证书名称保持一致
     */
    private String fcAlias;

    private String fcPassword;

    public GenerateJksContainerRequire() {
    }

    public GenerateJksContainerRequire(String savePath, String keyStoreName, String keyStorePd, String fcName, String fcProvince, String fcCity, String fcCountry, String fcAlias, String fcPassword) {
        this.savePath = savePath;
        this.keyStoreName = keyStoreName;
        this.keyStorePd = keyStorePd;
        this.fcName = fcName;
        this.fcProvince = fcProvince;
        this.fcCity = fcCity;
        this.fcCountry = fcCountry;
        this.fcAlias = fcAlias;
        this.fcPassword = fcPassword;
    }

    public Integer getKeyLength() {
        return keyLength;
    }

    public String getSavePath() {
        return savePath;
    }

    public GenerateJksContainerRequire setSavePath(String savePath) {
        this.savePath = savePath;
        return this;
    }

    public String getKeyStoreName() {
        return keyStoreName;
    }

    public GenerateJksContainerRequire setKeyStoreName(String keyStoreName) {
        this.keyStoreName = keyStoreName;
        return this;
    }

    public String getKeyStorePd() {
        return keyStorePd;
    }

    public GenerateJksContainerRequire setKeyStorePd(String keyStorePd) {
        this.keyStorePd = keyStorePd;
        return this;
    }

    public String getFcName() {
        return fcName;
    }

    public GenerateJksContainerRequire setFcName(String fcName) {
        this.fcName = fcName;
        return this;
    }

    public String getFcProvince() {
        return fcProvince;
    }

    public GenerateJksContainerRequire setFcProvince(String fcProvince) {
        this.fcProvince = fcProvince;
        return this;
    }

    public String getFcCity() {
        return fcCity;
    }

    public GenerateJksContainerRequire setFcCity(String fcCity) {
        this.fcCity = fcCity;
        return this;
    }

    public String getFcCountry() {
        return fcCountry;
    }

    public GenerateJksContainerRequire setFcCountry(String fcCountry) {
        this.fcCountry = fcCountry;
        return this;
    }

    public String getFcAlias() {
        return fcAlias;
    }

    public GenerateJksContainerRequire setFcAlias(String fcAlias) {
        this.fcAlias = fcAlias;
        return this;
    }

    public String getFcPassword() {
        return fcPassword;
    }

    public GenerateJksContainerRequire setFcPassword(String fcPassword) {
        this.fcPassword = fcPassword;
        return this;
    }
}
