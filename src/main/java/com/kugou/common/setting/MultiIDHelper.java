package com.kugou.common.setting;

import android.text.TextUtils;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.common.config.util.Base64Util;
import e.c.a.g.a.f.e.b;
import e.c.a.g.a.f.e.c;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.m;
import e.c.a.g.a.s.q0;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* JADX INFO: loaded from: classes2.dex */
public class MultiIDHelper {
    private static final String TAG = "MultiIDHelper";
    private static String encryptedUUIDByMD5;
    private String encryptedMidByRSAThenBase64;
    private String encryptedUUIDByRSA;
    private String pubKey;

    public MultiIDHelper(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new NullPointerException(str);
        }
        this.pubKey = str;
    }

    private String genEncryptedMidByRSA() {
        String strN = l1.n(KGApplication.getContext());
        if (TextUtils.isEmpty(strN)) {
            strN = "-";
        }
        try {
            return encryptByRSAThenBase64(strN);
        } catch (Exception e2) {
            g0.i(e2);
            return "";
        }
    }

    private static String genEncryptedUUIDByMD5() {
        String strI = m.i(false);
        if (TextUtils.isEmpty(strI)) {
            strI = "-";
        }
        try {
            String config = c.c().getConfig(b.f642d);
            String strG = q0.g(config + strI + config);
            encryptedUUIDByMD5 = strG;
            return strG;
        } catch (Exception e2) {
            g0.i(e2);
            return "-";
        }
    }

    private String genEncryptedUUIDByRSA() {
        String strI = m.i(false);
        if (TextUtils.isEmpty(strI)) {
            strI = "-";
        }
        try {
            return encryptByRSAThenBase64(strI);
        } catch (Exception e2) {
            g0.i(e2);
            return "";
        }
    }

    private String getEncryptedMidByRSAThenBase64() {
        String strGenEncryptedMidByRSA = this.encryptedMidByRSAThenBase64;
        if (TextUtils.isEmpty(strGenEncryptedMidByRSA)) {
            strGenEncryptedMidByRSA = genEncryptedMidByRSA();
            this.encryptedMidByRSAThenBase64 = strGenEncryptedMidByRSA;
        }
        if (g0.a) {
            g0.b(TAG, "mid:" + l1.n(KGApplication.getContext()) + ", 加密编码后:" + this.encryptedMidByRSAThenBase64);
        }
        return strGenEncryptedMidByRSA;
    }

    public static String getEncryptedUUIDByMD5() {
        String strGenEncryptedUUIDByMD5 = encryptedUUIDByMD5;
        if (TextUtils.isEmpty(strGenEncryptedUUIDByMD5)) {
            strGenEncryptedUUIDByMD5 = genEncryptedUUIDByMD5();
        }
        encryptedUUIDByMD5 = strGenEncryptedUUIDByMD5;
        return strGenEncryptedUUIDByMD5;
    }

    private String getEncryptedUUIDByRSAThanBase64() {
        String strGenEncryptedUUIDByRSA = this.encryptedUUIDByRSA;
        if (TextUtils.isEmpty(strGenEncryptedUUIDByRSA)) {
            strGenEncryptedUUIDByRSA = genEncryptedUUIDByRSA();
            this.encryptedUUIDByRSA = strGenEncryptedUUIDByRSA;
        }
        if (g0.a) {
            g0.b(TAG, "uuid:" + m.i(false) + ", 加密:" + this.encryptedUUIDByRSA);
        }
        return strGenEncryptedUUIDByRSA;
    }

    public static String getMd5UUID() {
        return getEncryptedUUIDByMD5();
    }

    public byte[] encryptByRSA(String str) throws Exception {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        PublicKey publicKeyGeneratePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64Util.decode(this.pubKey)));
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(1, publicKeyGeneratePublic);
        return cipher.doFinal(str.getBytes());
    }

    public String encryptByRSAThenBase64(String str) throws Exception {
        return TextUtils.isEmpty(str) ? "" : Base64Util.encode(encryptByRSA(str));
    }

    public String getEmd() {
        return getEncryptedMidByRSAThenBase64();
    }

    public String getEud() {
        return getEncryptedUUIDByRSAThanBase64();
    }
}
