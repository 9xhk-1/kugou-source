package com.kugou.common.config.util;

import android.util.Base64;
import java.io.File;
import java.io.FileInputStream;

/* JADX INFO: loaded from: classes2.dex */
public class Base64Util {
    public static byte[] decode(String str) {
        int i2;
        int i3 = 0;
        for (int length = str.length() - 1; str.charAt(length) == '='; length--) {
            i3++;
        }
        int length2 = ((str.length() * 6) / 8) - i3;
        byte[] bArr = new byte[length2];
        int i4 = 0;
        for (int i5 = 0; i5 < str.length(); i5 += 4) {
            int value = (getValue(str.charAt(i5)) << 18) + (getValue(str.charAt(i5 + 1)) << 12) + (getValue(str.charAt(i5 + 2)) << 6) + getValue(str.charAt(i5 + 3));
            for (int i6 = 0; i6 < 3 && (i2 = i4 + i6) < length2; i6++) {
                bArr[i2] = (byte) ((value >> ((2 - i6) * 8)) & 255);
            }
            i4 += 3;
        }
        return bArr;
    }

    public static String encode(String str) {
        return encode(str.getBytes());
    }

    public static String encodeBase64File(String str) throws Exception {
        File file = new File(str);
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[(int) file.length()];
        fileInputStream.read(bArr);
        fileInputStream.close();
        return Base64.encodeToString(bArr, 0);
    }

    public static char[] encodeBlock(byte[] bArr, int i2) {
        int length = (bArr.length - i2) - 1;
        int i3 = length >= 2 ? 2 : length;
        int i4 = 0;
        for (int i5 = 0; i5 <= i3; i5++) {
            int i6 = bArr[i2 + i5];
            if (i6 < 0) {
                i6 += 256;
            }
            i4 += i6 << ((2 - i5) * 8);
        }
        char[] cArr = new char[4];
        for (int i7 = 0; i7 < 4; i7++) {
            cArr[i7] = getChar((i4 >>> ((3 - i7) * 6)) & 63);
        }
        if (length < 1) {
            cArr[2] = '=';
        }
        if (length < 2) {
            cArr[3] = '=';
        }
        return cArr;
    }

    public static char getChar(int i2) {
        int i3;
        if (i2 >= 0 && i2 <= 25) {
            i3 = i2 + 65;
        } else if (i2 >= 26 && i2 <= 51) {
            i3 = (i2 - 26) + 97;
        } else {
            if (i2 < 52 || i2 > 61) {
                if (i2 == 62) {
                    return '+';
                }
                return i2 == 63 ? '/' : '?';
            }
            i3 = (i2 - 52) + 48;
        }
        return (char) i3;
    }

    public static int getValue(char c) {
        if (c >= 'A' && c <= 'Z') {
            return c - 'A';
        }
        if (c >= 'a' && c <= 'z') {
            return (c - 'a') + 26;
        }
        if (c >= '0' && c <= '9') {
            return (c - '0') + 52;
        }
        if (c == '+') {
            return 62;
        }
        if (c == '/') {
            return 63;
        }
        return c == '=' ? 0 : -1;
    }

    public static String encode(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < bArr.length; i2 += 3) {
            stringBuffer.append(encodeBlock(bArr, i2));
        }
        return stringBuffer.toString();
    }
}
