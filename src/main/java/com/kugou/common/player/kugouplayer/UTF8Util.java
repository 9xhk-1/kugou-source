package com.kugou.common.player.kugouplayer;

import androidx.exifinterface.media.ExifInterface;

/* JADX INFO: loaded from: classes2.dex */
public class UTF8Util {
    private static byte[] byteMergerAll(byte[]... bArr) {
        int length = 0;
        for (int i2 = 0; i2 < bArr.length; i2++) {
            if (bArr[i2] != null) {
                length += bArr[i2].length;
            }
        }
        byte[] bArr2 = new byte[length];
        int length2 = 0;
        for (byte[] bArr3 : bArr) {
            if (bArr3 != null) {
                System.arraycopy(bArr3, 0, bArr2, length2, bArr3.length);
                length2 += bArr3.length;
            }
        }
        return bArr2;
    }

    public static boolean isAllValidUTF8(byte[]... bArr) {
        try {
            return isValidUTF8(byteMergerAll(bArr));
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private static boolean isValidUTF8(byte[] bArr) {
        int i2 = 0;
        int i3 = 0;
        while (i2 < bArr.length && i3 == 0) {
            int i4 = bArr[i2];
            if (i4 <= 0) {
                while (((i4 >> 6) & 3) == 3) {
                    i3++;
                    i4 <<= 1;
                    i2++;
                    if (i2 > bArr.length - 1) {
                        break;
                    }
                    int i5 = bArr[i2] & ExifInterface.MARKER;
                    if (i5 >= 128 && i5 < 192) {
                        i3--;
                    }
                }
            }
            i2++;
        }
        return i3 <= 0;
    }
}
