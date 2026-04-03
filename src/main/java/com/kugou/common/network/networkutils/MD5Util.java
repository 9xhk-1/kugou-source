package com.kugou.common.network.networkutils;

import androidx.exifinterface.media.ExifInterface;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes2.dex */
public class MD5Util {
    public static final int S11 = 7;
    public static final int S12 = 12;
    public static final int S13 = 17;
    public static final int S14 = 22;
    public static final int S21 = 5;
    public static final int S22 = 9;
    public static final int S23 = 14;
    public static final int S24 = 20;
    public static final int S31 = 4;
    public static final int S32 = 11;
    public static final int S33 = 16;
    public static final int S34 = 23;
    public static final int S41 = 6;
    public static final int S42 = 10;
    public static final int S43 = 15;
    public static final int S44 = 21;
    public String digestHexStr;
    public static final byte[] PADDING = {-128, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private static char[] Digit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final String[] strDigits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
    private long[] state = new long[4];
    private long[] count = new long[2];

    public MD5Util() {
        md5Init();
    }

    public static long b2iu(byte b) {
        int i2 = b;
        if (b < 0) {
            i2 = b & ExifInterface.MARKER;
        }
        return i2;
    }

    public static String byteHEX(byte b) {
        char[] cArr = Digit;
        return new String(new char[]{cArr[(b >>> 4) & 15], cArr[b & 15]});
    }

    private String byteToArrayString(byte b) {
        int i2 = b;
        if (b < 0) {
            i2 = b + 256;
        }
        StringBuilder sb = new StringBuilder();
        String[] strArr = strDigits;
        sb.append(strArr[i2 / 16]);
        sb.append(strArr[i2 % 16]);
        return sb.toString();
    }

    private String byteToString(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            stringBuffer.append(byteToArrayString(b));
        }
        return stringBuffer.toString();
    }

    private void md5Init() {
        long[] jArr = this.count;
        jArr[0] = 0;
        jArr[1] = 0;
        long[] jArr2 = this.state;
        jArr2[0] = 1732584193;
        jArr2[1] = 4023233417L;
        jArr2[2] = 2562383102L;
        jArr2[3] = 271733878;
    }

    public static String toHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i2 = 0; i2 < bArr.length; i2++) {
            sb.append(Digit[(bArr[i2] & 240) >>> 4]);
            sb.append(Digit[bArr[i2] & 15]);
        }
        return sb.toString();
    }

    public String getMD5StrOfBytes(byte[] bArr) {
        try {
            return byteToString(MessageDigest.getInstance("MD5").digest(bArr));
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public String getMD5ofStr(String str) {
        String str2;
        String str3 = "";
        try {
            str2 = new String(str);
        } catch (NoSuchAlgorithmException e2) {
            e = e2;
        }
        try {
            return byteToString(MessageDigest.getInstance("MD5").digest(str.getBytes()));
        } catch (NoSuchAlgorithmException e3) {
            e = e3;
            str3 = str2;
            e.printStackTrace();
            return str3;
        }
    }

    public String getMD5ofStr(String str, String str2) {
        String str3 = "";
        try {
            String str4 = new String(str);
            try {
                return byteToString(MessageDigest.getInstance("MD5").digest(str.getBytes(str2)));
            } catch (Exception e2) {
                e = e2;
                str3 = str4;
                e.printStackTrace();
                return str3;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }
}
