package com.liumapp.jks.core.signature.require;

import com.itextpdf.text.pdf.security.DigestAlgorithms;
import com.itextpdf.text.pdf.security.MakeSignature;
import com.liumapp.jks.core.job.JobData;
import com.liumapp.jks.core.loader.ChainLoader;
import com.liumapp.jks.core.loader.JksLoader;
import com.liumapp.jks.core.loader.PrivateKeyLoader;
import com.liumapp.jks.core.loader.require.ChainLoadingRequire;
import com.liumapp.jks.core.loader.require.JksLoadingRequire;
import com.liumapp.jks.core.loader.require.PrivateKeyLoadingRequire;
import com.liumapp.jks.core.loader.service.ActiveChainService;
import com.liumapp.jks.core.loader.service.ActiveKeyStoreService;
import com.liumapp.jks.core.loader.service.ActivePrivateKeyService;

import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;

/**
 * @author liumapp
 * @file SignPdfRequire.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 7/10/18
 */
public class SignPdfRequire extends JobData implements ActiveChainService, ActiveKeyStoreService, ActivePrivateKeyService {

    private JksLoadingRequire jksLoadingRequire;

    private ChainLoadingRequire chainLoadingRequire;

    private PrivateKeyLoadingRequire privateKeyLoadingRequire;

    private JksLoader.ActiveKeyStore activeKeyStore;

    private ChainLoader.ActiveCertificate[] activeCertificates;

    private PrivateKeyLoader.ActivePrivateKey activePrivateKey;

    private String ksPath;

    private String ksName;

    private char[] ksPassword;

    private String certAlias;

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

    private String digestAlgorithm = DigestAlgorithms.SHA256;

    private MakeSignature.CryptoStandard sigtype = MakeSignature.CryptoStandard.CMS;

    public SignPdfRequire() {
    }

    public void initSecurityInfo () throws KeyStoreException, UnrecoverableKeyException, NoSuchAlgorithmException {
        this.setJksLoadingRequire();
        this.activeKeyStore = this.buildActiveKeyStore(this.jksLoadingRequire);
        this.activeCertificates = this.buildActiveChain(this.getChainLoadingRequire(this.activeKeyStore));
        this.activePrivateKey = this.buildActivePrivateKey(this.getPrivateKeyLoadingRequire());
    }

    protected void setJksLoadingRequire() {
        this.jksLoadingRequire = new JksLoadingRequire();
        this.jksLoadingRequire.setKsPath(this.ksPath)
                .setKsName(this.ksName)
                .setKsPassword(this.ksPassword);
    }

    @Override
    public ChainLoader.ActiveCertificate[] buildActiveChain(ChainLoadingRequire require) throws KeyStoreException {
        return ChainLoader
               .getInstance(this.getChainLoadingRequire(this.activeKeyStore))
               .getActiveCertificateChain();
    }

    @Override
    public JksLoader.ActiveKeyStore buildActiveKeyStore(JksLoadingRequire require) {
        return JksLoader
               .getInstance(this.getJksLoadingRequire())
               .getActiveKeyStore();
    }

    @Override
    public PrivateKeyLoader.ActivePrivateKey buildActivePrivateKey(PrivateKeyLoadingRequire require) throws UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException {
        return PrivateKeyLoader
               .getInstance(this.getPrivateKeyLoadingRequire())
               .getActivePrivateKey();
    }

    public PrivateKeyLoadingRequire getPrivateKeyLoadingRequire() {
        return privateKeyLoadingRequire;
    }

    public void setPrivateKeyLoadingRequire(PrivateKeyLoadingRequire privateKeyLoadingRequire) {
        this.privateKeyLoadingRequire = privateKeyLoadingRequire;
    }

    public ChainLoadingRequire getChainLoadingRequire(JksLoader.ActiveKeyStore activeKeyStore) {
        chainLoadingRequire.setActiveKeyStore(activeKeyStore);
        return chainLoadingRequire;
    }

    public void setChainLoadingRequire(ChainLoadingRequire chainLoadingRequire) {
        this.chainLoadingRequire = chainLoadingRequire;
    }

    public JksLoadingRequire getJksLoadingRequire() {
        return jksLoadingRequire;
    }

    public MakeSignature.CryptoStandard getSigtype() {
        return sigtype;
    }

    public String getDigestAlgorithm() {
        return digestAlgorithm;
    }

    public String getPdfSavePath() {
        return pdfSavePath;
    }

    public SignPdfRequire setPdfSavePath(String pdfSavePath) {
        this.pdfSavePath = pdfSavePath;
        return this;
    }

    public String getPdfFileName() {
        return pdfFileName;
    }

    public SignPdfRequire setPdfFileName(String pdfFileName) {
        this.pdfFileName = pdfFileName;
        return this;
    }

    public String getResultSavePath() {
        return resultSavePath;
    }

    public SignPdfRequire setResultSavePath(String resultSavePath) {
        this.resultSavePath = resultSavePath;
        return this;
    }

    public String getResultSaveName() {
        return resultSaveName;
    }

    public SignPdfRequire setResultSaveName(String resultSaveName) {
        this.resultSaveName = resultSaveName;
        return this;
    }

    public String getReason() {
        return reason;
    }

    public SignPdfRequire setReason(String reason) {
        this.reason = reason;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public SignPdfRequire setLocation(String location) {
        this.location = location;
        return this;
    }

    public float getFirstX() {
        return firstX;
    }

    public SignPdfRequire setFirstX(float firstX) {
        this.firstX = firstX;
        return this;
    }

    public float getFirstY() {
        return firstY;
    }

    public SignPdfRequire setFirstY(float firstY) {
        this.firstY = firstY;
        return this;
    }

    public float getSecondX() {
        return secondX;
    }

    public SignPdfRequire setSecondX(float secondX) {
        this.secondX = secondX;
        return this;
    }

    public float getSecondY() {
        return secondY;
    }

    public SignPdfRequire setSecondY(float secondY) {
        this.secondY = secondY;
        return this;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public SignPdfRequire setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
        return this;
    }

    public String getSignFieldName() {
        return signFieldName;
    }

    public SignPdfRequire setSignFieldName(String signFieldName) {
        this.signFieldName = signFieldName;
        return this;
    }

    public String getKsPath() {
        return ksPath;
    }

    public SignPdfRequire setKsPath(String ksPath) {
        this.ksPath = ksPath;
        return this;
    }

    public String getKsName() {
        return ksName;
    }

    public SignPdfRequire setKsName(String ksName) {
        this.ksName = ksName;
        return this;
    }

    public char[] getKsPassword() {
        return ksPassword;
    }

    public SignPdfRequire setKsPassword(char[] ksPassword) {
        this.ksPassword = ksPassword;
        return this;
    }

    public String getCertAlias() {
        return certAlias;
    }

    public SignPdfRequire setCertAlias(String certAlias) {
        this.certAlias = certAlias;
        return this;
    }
}
