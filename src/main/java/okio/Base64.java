package okio;

import androidx.exifinterface.media.ExifInterface;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes2.dex */
public final class Base64 {
    private static final byte[] MAP = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte[] URL_MAP = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

    private Base64() {
    }

    public static byte[] decode(String str) {
        int i2;
        char cCharAt;
        int length = str.length();
        while (length > 0 && ((cCharAt = str.charAt(length - 1)) == '=' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == ' ' || cCharAt == '\t')) {
            length--;
        }
        int i3 = (int) ((((long) length) * 6) / 8);
        byte[] bArr = new byte[i3];
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < length; i7++) {
            char cCharAt2 = str.charAt(i7);
            if (cCharAt2 >= 'A' && cCharAt2 <= 'Z') {
                i2 = cCharAt2 - 'A';
            } else if (cCharAt2 >= 'a' && cCharAt2 <= 'z') {
                i2 = cCharAt2 - 'G';
            } else if (cCharAt2 >= '0' && cCharAt2 <= '9') {
                i2 = cCharAt2 + 4;
            } else if (cCharAt2 == '+' || cCharAt2 == '-') {
                i2 = 62;
            } else if (cCharAt2 == '/' || cCharAt2 == '_') {
                i2 = 63;
            } else {
                if (cCharAt2 != '\n' && cCharAt2 != '\r' && cCharAt2 != ' ' && cCharAt2 != '\t') {
                    return null;
                }
            }
            i5 = (i5 << 6) | ((byte) i2);
            i4++;
            if (i4 % 4 == 0) {
                int i8 = i6 + 1;
                bArr[i6] = (byte) (i5 >> 16);
                int i9 = i8 + 1;
                bArr[i8] = (byte) (i5 >> 8);
                bArr[i9] = (byte) i5;
                i6 = i9 + 1;
            }
        }
        int i10 = i4 % 4;
        if (i10 == 1) {
            return null;
        }
        if (i10 == 2) {
            bArr[i6] = (byte) ((i5 << 12) >> 16);
            i6++;
        } else if (i10 == 3) {
            int i11 = i5 << 6;
            int i12 = i6 + 1;
            bArr[i6] = (byte) (i11 >> 16);
            i6 = i12 + 1;
            bArr[i12] = (byte) (i11 >> 8);
        }
        if (i6 == i3) {
            return bArr;
        }
        byte[] bArr2 = new byte[i6];
        System.arraycopy(bArr, 0, bArr2, 0, i6);
        return bArr2;
    }

    public static String encode(byte[] bArr) {
        return encode(bArr, MAP);
    }

    public static String encodeUrl(byte[] bArr) {
        return encode(bArr, URL_MAP);
    }

    private static String encode(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[((bArr.length + 2) / 3) * 4];
        int length = bArr.length - (bArr.length % 3);
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3 += 3) {
            int i4 = i2 + 1;
            bArr3[i2] = bArr2[(bArr[i3] & ExifInterface.MARKER) >> 2];
            int i5 = i4 + 1;
            int i6 = i3 + 1;
            bArr3[i4] = bArr2[((bArr[i3] & 3) << 4) | ((bArr[i6] & ExifInterface.MARKER) >> 4)];
            int i7 = i5 + 1;
            int i8 = (bArr[i6] & 15) << 2;
            int i9 = i3 + 2;
            bArr3[i5] = bArr2[i8 | ((bArr[i9] & ExifInterface.MARKER) >> 6)];
            i2 = i7 + 1;
            bArr3[i7] = bArr2[bArr[i9] & 63];
        }
        int length2 = bArr.length % 3;
        if (length2 == 1) {
            int i10 = i2 + 1;
            bArr3[i2] = bArr2[(bArr[length] & ExifInterface.MARKER) >> 2];
            int i11 = i10 + 1;
            bArr3[i10] = bArr2[(bArr[length] & 3) << 4];
            bArr3[i11] = 61;
            bArr3[i11 + 1] = 61;
        } else if (length2 == 2) {
            int i12 = i2 + 1;
            bArr3[i2] = bArr2[(bArr[length] & ExifInterface.MARKER) >> 2];
            int i13 = i12 + 1;
            int i14 = (bArr[length] & 3) << 4;
            int i15 = length + 1;
            bArr3[i12] = bArr2[((bArr[i15] & ExifInterface.MARKER) >> 4) | i14];
            bArr3[i13] = bArr2[(bArr[i15] & 15) << 2];
            bArr3[i13 + 1] = 61;
        }
        try {
            return new String(bArr3, "US-ASCII");
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }
}
