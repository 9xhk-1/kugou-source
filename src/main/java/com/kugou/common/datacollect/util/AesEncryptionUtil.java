package com.kugou.common.datacollect.util;

/* JADX INFO: loaded from: classes2.dex */
public class AesEncryptionUtil {
    public static byte[] hex2byte(String str) {
        if (str == null || str.length() < 2) {
            return new byte[0];
        }
        String lowerCase = str.toLowerCase();
        int length = lowerCase.length() / 2;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            bArr[i2] = (byte) (Integer.parseInt(lowerCase.substring(i3, i3 + 2), 16) & 255);
        }
        return bArr;
    }
}
