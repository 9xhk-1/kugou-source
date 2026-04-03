package e.c.a.g.a.r.g;

import com.xtc.shareapi.share.constant.OpenApiConstant;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static final byte[] a = new byte[128];
    public static final char[] b = new char[64];

    static {
        int i2;
        int i3;
        int i4 = 0;
        for (int i5 = 0; i5 < 128; i5++) {
            a[i5] = -1;
        }
        for (int i6 = 90; i6 >= 65; i6--) {
            a[i6] = (byte) (i6 - 65);
        }
        int i7 = 122;
        while (true) {
            if (i7 < 97) {
                break;
            }
            a[i7] = (byte) ((i7 - 97) + 26);
            i7--;
        }
        int i8 = 57;
        while (true) {
            if (i8 < 48) {
                break;
            }
            a[i8] = (byte) ((i8 - 48) + 52);
            i8--;
        }
        byte[] bArr = a;
        bArr[43] = 62;
        bArr[47] = 63;
        for (int i9 = 0; i9 <= 25; i9++) {
            b[i9] = (char) (i9 + 65);
        }
        int i10 = 0;
        for (i2 = 26; i2 <= 51; i2++) {
            b[i2] = (char) (i10 + 97);
            i10++;
        }
        for (i3 = 52; i3 <= 61; i3++) {
            b[i3] = (char) (i4 + 48);
            i4++;
        }
        char[] cArr = b;
        cArr[62] = '+';
        cArr[63] = '/';
    }

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length * 8;
        if (length == 0) {
            return "";
        }
        int i2 = length % 24;
        int i3 = length / 24;
        char[] cArr = new char[(i2 != 0 ? i3 + 1 : i3) * 4];
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i4 < i3) {
            int i7 = i5 + 1;
            byte b2 = bArr[i5];
            int i8 = i7 + 1;
            byte b3 = bArr[i7];
            int i9 = i8 + 1;
            byte b4 = bArr[i8];
            byte b5 = (byte) (b3 & 15);
            byte b6 = (byte) (b2 & 3);
            int i10 = b2 & (-128);
            int i11 = b2 >> 2;
            if (i10 != 0) {
                i11 ^= 192;
            }
            byte b7 = (byte) i11;
            int i12 = b3 & (-128);
            int i13 = b3 >> 4;
            if (i12 != 0) {
                i13 ^= OpenApiConstant.DialogBitmapArgsConstant.DIALOG_WIDTH_3;
            }
            byte b8 = (byte) i13;
            int i14 = (b4 & (-128)) == 0 ? b4 >> 6 : (b4 >> 6) ^ 252;
            int i15 = i6 + 1;
            char[] cArr2 = b;
            cArr[i6] = cArr2[b7];
            int i16 = i15 + 1;
            cArr[i15] = cArr2[(b6 << 4) | b8];
            int i17 = i16 + 1;
            cArr[i16] = cArr2[(b5 << 2) | ((byte) i14)];
            cArr[i17] = cArr2[b4 & 63];
            i4++;
            i6 = i17 + 1;
            i5 = i9;
        }
        if (i2 == 8) {
            byte b9 = bArr[i5];
            byte b10 = (byte) (b9 & 3);
            int i18 = b9 & (-128);
            int i19 = b9 >> 2;
            if (i18 != 0) {
                i19 ^= 192;
            }
            int i20 = i6 + 1;
            char[] cArr3 = b;
            cArr[i6] = cArr3[(byte) i19];
            int i21 = i20 + 1;
            cArr[i20] = cArr3[b10 << 4];
            cArr[i21] = '=';
            cArr[i21 + 1] = '=';
        } else if (i2 == 16) {
            byte b11 = bArr[i5];
            byte b12 = bArr[i5 + 1];
            byte b13 = (byte) (b12 & 15);
            byte b14 = (byte) (b11 & 3);
            int i22 = b11 & (-128);
            int i23 = b11 >> 2;
            if (i22 != 0) {
                i23 ^= 192;
            }
            byte b15 = (byte) i23;
            int i24 = b12 & (-128);
            int i25 = b12 >> 4;
            if (i24 != 0) {
                i25 ^= OpenApiConstant.DialogBitmapArgsConstant.DIALOG_WIDTH_3;
            }
            int i26 = i6 + 1;
            char[] cArr4 = b;
            cArr[i6] = cArr4[b15];
            int i27 = i26 + 1;
            cArr[i26] = cArr4[((byte) i25) | (b14 << 4)];
            cArr[i27] = cArr4[b13 << 2];
            cArr[i27 + 1] = '=';
        }
        return new String(cArr);
    }
}
