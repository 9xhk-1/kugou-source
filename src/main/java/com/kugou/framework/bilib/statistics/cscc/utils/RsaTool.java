package com.kugou.framework.bilib.statistics.cscc.utils;

import android.util.Base64;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* JADX INFO: loaded from: classes2.dex */
public class RsaTool {
    public static byte[] base64Dec(String str) {
        return Base64.decode(str, 0);
    }

    public static String base64Enc(byte[] bArr) {
        return Base64.encodeToString(bArr, 0);
    }

    public static byte[] encrypt(String str, String str2) {
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            byte[] bytes = str.getBytes();
            cipher.init(1, getPublicKey(str2));
            return cipher.doFinal(bytes);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String encryptToBase64(String str, String str2) {
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            byte[] bytes = str.getBytes();
            cipher.init(1, getPublicKey(str2));
            return base64Enc(cipher.doFinal(bytes));
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static PublicKey getPublicKey(String str) throws Exception {
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(base64Dec(str)));
    }
}
