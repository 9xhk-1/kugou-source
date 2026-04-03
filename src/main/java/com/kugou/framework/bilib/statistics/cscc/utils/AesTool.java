package com.kugou.framework.bilib.statistics.cscc.utils;

import android.text.TextUtils;
import com.kugou.framework.bilib.LibLog;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes2.dex */
public class AesTool {
    public static String decrypt(String str, byte[] bArr, byte[] bArr2) {
        if (TextUtils.isEmpty(str)) {
            if (LibLog.DEBUG) {
                LibLog.e("BLUE", "empty aesKey is AesToll.encryptWithImeiIv");
            }
            try {
                return new String(bArr, "UTF-8");
            } catch (UnsupportedEncodingException unused) {
                return null;
            }
        }
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes("UTF-8"), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            cipher.init(2, secretKeySpec, new IvParameterSpec(bArr2, 0, 16));
            return new String(cipher.doFinal(bArr), "UTF-8");
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String decryptWithImeiIv(String str, String str2, byte[] bArr) {
        return decrypt(str, bArr, getImeiIv(str2));
    }

    public static byte[] encrypt(String str, byte[] bArr, byte[] bArr2) {
        if (TextUtils.isEmpty(str)) {
            if (LibLog.DEBUG) {
                LibLog.e("BLUE", "empty aesKey is AesToll.encryptWithImeiIv");
            }
            return bArr;
        }
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(Arrays.copyOf(str.getBytes("UTF-8"), 32), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            cipher.init(1, secretKeySpec, new IvParameterSpec(bArr2, 0, 16));
            return cipher.doFinal(bArr);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static byte[] encryptWithImeiIv(String str, String str2, byte[] bArr) {
        return encrypt(str, bArr, getImeiIv(str2));
    }

    public static byte[] getImeiIv(String str) {
        byte[] bytes;
        try {
            bytes = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            bytes = null;
        }
        if (bytes == null) {
            return new byte[16];
        }
        if (bytes.length >= 16) {
            return bytes;
        }
        byte[] bArr = new byte[16];
        System.arraycopy(bytes, 0, bArr, 0, 16);
        return bArr;
    }
}
