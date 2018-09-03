package com.liumapp.jks.core.signature.require;

import com.itextpdf.text.pdf.PdfSignatureAppearance;
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
 * file SignPdfWithTimeStampRequire.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2018/9/1
 */
public class SignPdfWithTimeStampRequire extends JobData implements ActiveChainService, ActiveKeyStoreService, ActivePrivateKeyService {

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

    private char[] certPassword;

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

    private String signPicPath;

    private String signFieldName;

    private String digestAlgorithm = DigestAlgorithms.SHA256;

    private Integer certificationLevel = 0;

    private MakeSignature.CryptoStandard sigtype = MakeSignature.CryptoStandard.CMS;

    private PdfSignatureAppearance.RenderingMode renderingMode = PdfSignatureAppearance.RenderingMode.GRAPHIC;

    private String timeStampServer;

    private String appId;

    private String appSecret;

    public SignPdfWithTimeStampRequire() {
    }

    public void initSecurityInfo () throws KeyStoreException, UnrecoverableKeyException, NoSuchAlgorithmException {
        this.setJksLoadingRequire();
        this.setChainLoadingRequire();
        this.setPrivateKeyLoadingRequire();
        this.activeKeyStore = this.buildActiveKeyStore(this.jksLoadingRequire);
        this.activeCertificates = this.buildActiveChain(this.getChainLoadingRequire(this.activeKeyStore));
        this.activePrivateKey = this.buildActivePrivateKey(this.getPrivateKeyLoadingRequire(this.activeKeyStore));
    }

    protected void setJksLoadingRequire() {
        this.jksLoadingRequire = new JksLoadingRequire();
        this.jksLoadingRequire.setKsPath(this.ksPath)
                .setKsName(this.ksName)
                .setKsPassword(this.ksPassword);
    }

    protected void setChainLoadingRequire() {
        this.chainLoadingRequire = new ChainLoadingRequire();
        this.chainLoadingRequire.setAlias(this.certAlias);
    }

    protected void setPrivateKeyLoadingRequire() {
        this.privateKeyLoadingRequire = new PrivateKeyLoadingRequire();
        this.privateKeyLoadingRequire.setAlias(this.certAlias)
                .setCertPassword(this.certPassword);
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
                .getInstance(this.privateKeyLoadingRequire)
                .getActivePrivateKey();
    }

    public PrivateKeyLoadingRequire getPrivateKeyLoadingRequire(JksLoader.ActiveKeyStore activeKeyStore) {
        privateKeyLoadingRequire.setActiveKeyStore(activeKeyStore);
        return privateKeyLoadingRequire;
    }

    /**
     * 从激活的jks中获取证书链
     * 证书、证书链是存放于jks中，所以您必须提供jks才能获取证书链
     */
    public ChainLoadingRequire getChainLoadingRequire(JksLoader.ActiveKeyStore activeKeyStore) {
        chainLoadingRequire.setActiveKeyStore(activeKeyStore);
        return chainLoadingRequire;
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

    public SignPdfWithTimeStampRequire setPdfSavePath(String pdfSavePath) {
        this.pdfSavePath = pdfSavePath;
        return this;
    }

    public String getPdfFileName() {
        return pdfFileName;
    }

    public SignPdfWithTimeStampRequire setPdfFileName(String pdfFileName) {
        this.pdfFileName = pdfFileName;
        return this;
    }

    public String getResultSavePath() {
        return resultSavePath;
    }

    public SignPdfWithTimeStampRequire setResultSavePath(String resultSavePath) {
        this.resultSavePath = resultSavePath;
        return this;
    }

    public String getResultSaveName() {
        return resultSaveName;
    }

    public SignPdfWithTimeStampRequire setResultSaveName(String resultSaveName) {
        this.resultSaveName = resultSaveName;
        return this;
    }

    public String getReason() {
        return reason;
    }

    public SignPdfWithTimeStampRequire setReason(String reason) {
        this.reason = reason;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public SignPdfWithTimeStampRequire setLocation(String location) {
        this.location = location;
        return this;
    }

    public float getFirstX() {
        return firstX;
    }

    public SignPdfWithTimeStampRequire setFirstX(float firstX) {
        this.firstX = firstX;
        return this;
    }

    public float getFirstY() {
        return firstY;
    }

    public SignPdfWithTimeStampRequire setFirstY(float firstY) {
        this.firstY = firstY;
        return this;
    }

    public float getSecondX() {
        return secondX;
    }

    public SignPdfWithTimeStampRequire setSecondX(float secondX) {
        this.secondX = secondX;
        return this;
    }

    public float getSecondY() {
        return secondY;
    }

    public SignPdfWithTimeStampRequire setSecondY(float secondY) {
        this.secondY = secondY;
        return this;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public SignPdfWithTimeStampRequire setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
        return this;
    }

    public String getSignFieldName() {
        return signFieldName;
    }

    public SignPdfWithTimeStampRequire setSignFieldName(String signFieldName) {
        this.signFieldName = signFieldName;
        return this;
    }

    public String getKsPath() {
        return ksPath;
    }

    public SignPdfWithTimeStampRequire setKsPath(String ksPath) {
        this.ksPath = ksPath;
        return this;
    }

    public String getKsName() {
        return ksName;
    }

    public SignPdfWithTimeStampRequire setKsName(String ksName) {
        this.ksName = ksName;
        return this;
    }

    public char[] getKsPassword() {
        return ksPassword;
    }

    public SignPdfWithTimeStampRequire setKsPassword(char[] ksPassword) {
        this.ksPassword = ksPassword;
        return this;
    }

    public String getCertAlias() {
        return certAlias;
    }

    public SignPdfWithTimeStampRequire setCertAlias(String certAlias) {
        this.certAlias = certAlias;
        return this;
    }

    public char[] getCertPassword() {
        return certPassword;
    }

    public SignPdfWithTimeStampRequire setCertPassword(char[] certPassword) {
        this.certPassword = certPassword;
        return this;
    }

    public String getSignPicPath() {
        return signPicPath;
    }

    public SignPdfWithTimeStampRequire setSignPicPath(String signPicPath) {
        this.signPicPath = signPicPath;
        return this;
    }

    public Integer getCertificationLevel() {
        return certificationLevel;
    }

    public PdfSignatureAppearance.RenderingMode getRenderingMode() {
        return renderingMode;
    }

    public JksLoader.ActiveKeyStore getActiveKeyStore() {
        return activeKeyStore;
    }

    public ChainLoader.ActiveCertificate[] getActiveCertificates() {
        return activeCertificates;
    }

    public PrivateKeyLoader.ActivePrivateKey getActivePrivateKey() {
        return activePrivateKey;
    }

    public String getTimeStampServer() {
        return timeStampServer;
    }

    public SignPdfWithTimeStampRequire setTimeStampServer(String timeStampServer) {
        this.timeStampServer = timeStampServer;
        return this;
    }

    public String getAppId() {
        return appId;
    }

    public SignPdfWithTimeStampRequire setAppId(String appId) {
        this.appId = appId;
        return this;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public SignPdfWithTimeStampRequire setAppSecret(String appSecret) {
        this.appSecret = appSecret;
        return this;
    }
}
