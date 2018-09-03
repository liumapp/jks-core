package com.liumapp.jks.core.signature;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.text.pdf.codec.Base64;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLConnection;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;

import com.itextpdf.text.pdf.security.BouncyCastleDigest;
import com.itextpdf.text.pdf.security.DigestAlgorithms;
import com.itextpdf.text.pdf.security.TSAClient;
import com.itextpdf.text.pdf.security.TSAInfoBouncyCastle;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.cmp.PKIFailureInfo;
import org.bouncycastle.tsp.TSPException;
import org.bouncycastle.tsp.TimeStampRequest;
import org.bouncycastle.tsp.TimeStampRequestGenerator;
import org.bouncycastle.tsp.TimeStampResponse;
import org.bouncycastle.tsp.TimeStampToken;
import org.bouncycastle.tsp.TimeStampTokenInfo;

public class TSAClientBouncyCastle2 implements TSAClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(com.itextpdf.text.pdf.security.TSAClientBouncyCastle.class);
    protected String tsaURL;
    protected String tsaUsername;
    protected String tsaPassword;
    protected TSAInfoBouncyCastle tsaInfo;
    public static final int DEFAULTTOKENSIZE = 4096;
    protected int tokenSizeEstimate;
    public static final String DEFAULTHASHALGORITHM = "SHA-256";
    protected String digestAlgorithm;

    public TSAClientBouncyCastle2(String url) {
        this(url, (String)null, (String)null, 4096, "SHA-256");
    }

    public TSAClientBouncyCastle2(String url, String username, String password) {
        this(url, username, password, 4096, "SHA-256");
    }

    public TSAClientBouncyCastle2(String url, String username, String password, int tokSzEstimate, String digestAlgorithm) {
        this.tsaURL = url;
        this.tsaUsername = username;
        this.tsaPassword = password;
        this.tokenSizeEstimate = tokSzEstimate;
        this.digestAlgorithm = digestAlgorithm;
    }

    public void setTSAInfo(TSAInfoBouncyCastle tsaInfo) {
        this.tsaInfo = tsaInfo;
    }

    public int getTokenSizeEstimate() {
        return this.tokenSizeEstimate;
    }

    public MessageDigest getMessageDigest() throws GeneralSecurityException {
        return (new BouncyCastleDigest()).getMessageDigest(this.digestAlgorithm);
    }

    public byte[] getTimeStampToken(byte[] imprint) throws IOException, TSPException {
        byte[] respBytes = null;
        TimeStampRequestGenerator tsqGenerator = new TimeStampRequestGenerator();
        tsqGenerator.setCertReq(true);
        BigInteger nonce = BigInteger.valueOf(System.currentTimeMillis());
        TimeStampRequest request = tsqGenerator.generate(new ASN1ObjectIdentifier(DigestAlgorithms.getAllowedDigests(this.digestAlgorithm)), imprint, nonce);
        byte[] requestBytes = request.getEncoded();
        respBytes = this.getTSAResponse(requestBytes);
        TimeStampResponse response = new TimeStampResponse(respBytes);
        response.validate(request);
        PKIFailureInfo failure = response.getFailInfo();
        int value = failure == null ? 0 : failure.intValue();
        if (value != 0) {
            throw new IOException(MessageLocalization.getComposedMessage("invalid.tsa.1.response.code.2", new Object[]{this.tsaURL, String.valueOf(value)}));
        } else {
            TimeStampToken tsToken = response.getTimeStampToken();
            if (tsToken == null) {
                throw new IOException(MessageLocalization.getComposedMessage("tsa.1.failed.to.return.time.stamp.token.2", new Object[]{this.tsaURL, response.getStatusString()}));
            } else {
                TimeStampTokenInfo tsTokenInfo = tsToken.getTimeStampInfo();
                byte[] encoded = tsToken.getEncoded();
                LOGGER.info("Timestamp generated: " + tsTokenInfo.getGenTime());
                if (this.tsaInfo != null) {
                    this.tsaInfo.inspectTimeStampTokenInfo(tsTokenInfo);
                }

                this.tokenSizeEstimate = encoded.length + 32;
                return encoded;
            }
        }
    }

    protected byte[] getTSAResponse(byte[] requestBytes) throws IOException {
        URL url = new URL(this.tsaURL);

        URLConnection tsaConnection;
        try {
            tsaConnection = url.openConnection();
        } catch (IOException var11) {
            throw new IOException(MessageLocalization.getComposedMessage("failed.to.get.tsa.response.from.1", new Object[]{this.tsaURL}));
        }

        tsaConnection.setDoInput(true);
        tsaConnection.setDoOutput(true);
        tsaConnection.setUseCaches(false);
        tsaConnection.setRequestProperty("Content-Type", "application/timestamp-query");
        tsaConnection.setRequestProperty("Content-Transfer-Encoding", "binary");
        if (this.tsaUsername != null && !this.tsaUsername.equals("")) {
            String userPassword = this.tsaUsername + ":" + this.tsaPassword;
            tsaConnection.setRequestProperty("Authorization", "Basic " + Base64.encodeBytes(userPassword.getBytes(), 8));
        }

        OutputStream out = tsaConnection.getOutputStream();
        out.write(requestBytes);
        out.close();
        InputStream inp = tsaConnection.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        boolean var8 = false;

        int bytesRead;
        while((bytesRead = inp.read(buffer, 0, buffer.length)) >= 0) {
            baos.write(buffer, 0, bytesRead);
        }

        byte[] respBytes = baos.toByteArray();
        String encoding = tsaConnection.getContentEncoding();
        if (encoding != null && encoding.equalsIgnoreCase("base64")) {
            respBytes = Base64.decode(new String(respBytes));
        }

        return respBytes;
    }
}
