package com.liumapp.jks.core.certificate;

import sun.security.pkcs.ContentInfo;
import sun.security.pkcs.PKCS7;
import sun.security.pkcs.SignerInfo;
import sun.security.x509.AlgorithmId;

import java.io.IOException;
import java.io.OutputStream;
import java.security.cert.X509Certificate;

/**
 * author liumapp
 * file P7B.java
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 6/28/18
 */
public class P7B {

    private PKCS7 pkcs7;

    public P7B(X509Certificate... chain) {
        this.pkcs7 = new PKCS7(new AlgorithmId[0], new ContentInfo(ContentInfo.DATA_OID, null),
                chain, new SignerInfo[0]);
    }

    public PKCS7 toPkcs7() {
        return pkcs7;
    }

    public X509Certificate[] getCertificates() {
        return pkcs7.getCertificates();
    }

    public void writeTo(OutputStream out) throws IOException {
        pkcs7.encodeSignedData(out);
    }

}
