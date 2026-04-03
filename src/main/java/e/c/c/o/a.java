package e.c.c.o;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static byte[] a(byte[] bArr, byte b) {
        byte[] bArr2 = {b};
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length + 1);
        System.arraycopy(bArr2, 0, bArrCopyOf, bArr.length, 1);
        return bArrCopyOf;
    }

    public static byte[] b(byte[] bArr, int i2) {
        byte[] bArrH = h(i2);
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length + bArrH.length);
        System.arraycopy(bArrH, 0, bArrCopyOf, bArr.length, bArrH.length);
        return bArrCopyOf;
    }

    public static byte[] c(byte[] bArr, long j) {
        byte[] bArrI = i(j);
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length + bArrI.length);
        System.arraycopy(bArrI, 0, bArrCopyOf, bArr.length, bArrI.length);
        return bArrCopyOf;
    }

    public static byte[] d(byte[] bArr, String str) {
        byte[] bytes = new byte[0];
        try {
            bytes = str.getBytes("utf-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length + bytes.length);
        System.arraycopy(bytes, 0, bArrCopyOf, bArr.length, bytes.length);
        return bArrCopyOf;
    }

    public static byte[] e(byte[] bArr, short s) {
        byte[] bArrJ = j(s);
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length + bArrJ.length);
        System.arraycopy(bArrJ, 0, bArrCopyOf, bArr.length, bArrJ.length);
        return bArrCopyOf;
    }

    public static byte[] f(byte[] bArr, byte[] bArr2) {
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length + bArr2.length);
        System.arraycopy(bArr2, 0, bArrCopyOf, bArr.length, bArr2.length);
        return bArrCopyOf;
    }

    public static byte[] g(byte[] bArr, int[] iArr) {
        for (int i2 : iArr) {
            bArr = b(bArr, i2);
        }
        return bArr;
    }

    public static byte[] h(int i2) {
        byte[] bArr = new byte[4];
        int i3 = 0;
        while (i3 < 4) {
            int i4 = i3 + 1;
            bArr[i3] = (byte) ((i2 >> (32 - (i4 * 8))) & 255);
            i3 = i4;
        }
        return bArr;
    }

    public static byte[] i(long j) {
        byte[] bArr = new byte[8];
        for (int i2 = 0; i2 < 8; i2++) {
            bArr[i2] = (byte) ((j >> (64 - (r3 * 8))) & 255);
        }
        return bArr;
    }

    public static byte[] j(short s) {
        byte[] bArr = new byte[2];
        int i2 = 0;
        while (i2 < 2) {
            int i3 = i2 + 1;
            bArr[i2] = (byte) ((s >> (16 - (i3 * 8))) & 255);
            i2 = i3;
        }
        return bArr;
    }
}
