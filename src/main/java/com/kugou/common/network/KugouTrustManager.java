package com.kugou.common.network;

import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes2.dex */
public class KugouTrustManager implements X509TrustManager {
    private X509TrustManager defaultTrustManager;

    public KugouTrustManager() {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            this.defaultTrustManager = chooseTrustManager(trustManagerFactory.getTrustManagers());
        } catch (KeyStoreException e2) {
            e2.printStackTrace();
        } catch (NoSuchAlgorithmException e3) {
            e3.printStackTrace();
        }
    }

    private X509TrustManager chooseTrustManager(TrustManager[] trustManagerArr) {
        for (int i2 = 0; trustManagerArr != null && i2 < trustManagerArr.length; i2++) {
            if (trustManagerArr[i2] instanceof X509TrustManager) {
                return (X509TrustManager) trustManagerArr[i2];
            }
        }
        return null;
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        X509TrustManager x509TrustManager = this.defaultTrustManager;
        if (x509TrustManager == null) {
            throw new CertificateException("no TrustManager");
        }
        x509TrustManager.checkClientTrusted(x509CertificateArr, str);
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        X509TrustManager x509TrustManager = this.defaultTrustManager;
        if (x509TrustManager == null) {
            throw new CertificateException("no TrustManager");
        }
        x509TrustManager.checkServerTrusted(x509CertificateArr, str);
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        X509TrustManager x509TrustManager = this.defaultTrustManager;
        if (x509TrustManager != null) {
            return x509TrustManager.getAcceptedIssuers();
        }
        return null;
    }
}
