package com.kugou.common.network.networkutils;

import android.content.Context;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.ItemTouchHelper;
import java.io.ByteArrayInputStream;
import java.util.Locale;
import org.apache.http.util.ByteArrayBuffer;

/* JADX INFO: loaded from: classes2.dex */
public class Convertor {
    public static String byteHashToString(byte[] bArr) {
        if (bArr == null || bArr.length != 16) {
            return null;
        }
        StringBuilder sb = new StringBuilder(32);
        for (byte b : bArr) {
            sb.append(MD5Util.byteHEX(b));
        }
        return sb.toString().toLowerCase(Locale.US);
    }

    public static boolean byteToBoolean(byte b) {
        boolean[] zArr = new boolean[4];
        zArr[0] = (b & 1) != 0;
        zArr[1] = (b & 2) != 0;
        zArr[2] = (b & 4) != 0;
        zArr[3] = (b & 8) != 0;
        return zArr[0] && zArr[1] && zArr[2] && zArr[3];
    }

    public static int byteToInt(byte[] bArr) {
        int i2 = bArr[0] & ExifInterface.MARKER;
        int i3 = bArr[1] & ExifInterface.MARKER;
        return ((bArr[3] & ExifInterface.MARKER) << 24) | i2 | (i3 << 8) | ((bArr[2] & ExifInterface.MARKER) << 16);
    }

    public static long byteToLong(byte[] bArr) {
        return (bArr[0] & ExifInterface.MARKER) | ((bArr[1] & ExifInterface.MARKER) << 8) | ((bArr[2] & ExifInterface.MARKER) << 16) | ((bArr[3] & ExifInterface.MARKER) << 24) | ((bArr[4] & ExifInterface.MARKER) << 32) | ((bArr[5] & ExifInterface.MARKER) << 40) | (((long) (bArr[6] & ExifInterface.MARKER)) << 48) | (((long) (bArr[7] & ExifInterface.MARKER)) << 56);
    }

    public static short byteToShort(byte[] bArr) {
        return (short) (((short) (((short) (bArr[1] & ExifInterface.MARKER)) << 8)) | ((short) (bArr[0] & ExifInterface.MARKER)));
    }

    public static int bytesToInt(byte[] bArr) {
        int i2;
        int i3;
        int length = bArr.length;
        if (length == 1) {
            return bArr[0] & ExifInterface.MARKER;
        }
        if (length == 2) {
            i2 = bArr[0] & ExifInterface.MARKER;
            i3 = (bArr[1] << 8) & 65280;
        } else if (length == 3) {
            i2 = (bArr[0] & ExifInterface.MARKER) | ((bArr[1] << 8) & 65280);
            i3 = (bArr[2] << 16) & ItemTouchHelper.ACTION_MODE_DRAG_MASK;
        } else {
            if (length != 4) {
                return 0;
            }
            i2 = (bArr[0] & ExifInterface.MARKER) | ((bArr[1] << 8) & 65280) | ((bArr[2] << 16) & ItemTouchHelper.ACTION_MODE_DRAG_MASK);
            i3 = (bArr[3] << 24) & (-16777216);
        }
        return i2 | i3;
    }

    public static int convertDipToPx(Context context, int i2) {
        return (int) ((i2 * context.getResources().getDisplayMetrics().density) + ((i2 >= 0 ? 1 : -1) * 0.5f));
    }

    public static int convertPxToDip(Context context, int i2) {
        return (int) ((i2 / context.getResources().getDisplayMetrics().density) + ((i2 >= 0 ? 1 : -1) * 0.5f));
    }

    public static byte[] doubleToByte(double d2) {
        byte[] bArr = new byte[8];
        long jDoubleToLongBits = Double.doubleToLongBits(d2);
        for (int i2 = 0; i2 < 8; i2++) {
            bArr[i2] = (byte) (255 & jDoubleToLongBits);
            jDoubleToLongBits >>= 8;
        }
        return bArr;
    }

    public static byte[] getBytes(float f2) {
        return getBytes(Float.floatToRawIntBits(f2));
    }

    public static byte[] getBytes(int i2) {
        return new byte[]{(byte) (i2 & 255), (byte) ((i2 >> 8) & 255), (byte) ((i2 >> 16) & 255), (byte) ((i2 >> 24) & 255)};
    }

    public static byte[] getHashCode(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int length = str.length();
        byte[] bArr = new byte[length / 2];
        int i2 = 0;
        int i3 = 0;
        int i4 = 2;
        while (i2 < length) {
            bArr[i3] = (byte) getInt(str.substring(i2, i4));
            i2 += 2;
            i4 += 2;
            i3++;
        }
        return bArr;
    }

    public static int getInt(String str) {
        try {
            String lowerCase = str.toLowerCase(Locale.US);
            return (Integer.parseInt(lowerCase.substring(0, 1), 16) * 16) + Integer.parseInt(lowerCase.substring(1, 2), 16);
        } catch (Exception unused) {
            return 0;
        }
    }

    public static byte[] intToByte(int i2) {
        byte[] bArr = new byte[4];
        for (int i3 = 0; i3 < 4; i3++) {
            bArr[i3] = (byte) (i2 & 255);
            i2 >>= 8;
        }
        return bArr;
    }

    public static byte[] longToByte(long j) {
        byte[] bArr = new byte[8];
        for (int i2 = 0; i2 < 8; i2++) {
            bArr[i2] = (byte) (255 & j);
            j >>= 8;
        }
        return bArr;
    }

    public static byte[] shortToByte(short s) {
        byte[] bArr = new byte[2];
        int i2 = 0;
        int i3 = s;
        while (i2 < 2) {
            bArr[i2] = (byte) (i3 & 255);
            i2++;
            i3 >>= 8;
        }
        return bArr;
    }

    public static byte[] toUnicode(char c) {
        return shortToByte((short) c);
    }

    public static byte[] toUnicodeArray(String str) {
        ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer(10);
        for (int i2 = 0; i2 < str.length(); i2++) {
            byte[] unicode = toUnicode(str.charAt(i2));
            byteArrayBuffer.append(unicode, 0, unicode.length);
        }
        return byteArrayBuffer.toByteArray();
    }

    public static String unicodeArrayToString(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        StringBuilder sb = new StringBuilder();
        byte[] bArr2 = new byte[2];
        while (byteArrayInputStream.read(bArr2, 0, 2) == 2) {
            sb.append(unicodeToChar(bArr2));
        }
        return sb.toString();
    }

    public static char unicodeToChar(byte[] bArr) {
        return (char) byteToShort(bArr);
    }

    public static byte[] getBytes(int i2, int i3) {
        byte[] bArr = new byte[i3];
        if (i3 == 1) {
            bArr[0] = (byte) (i2 & 255);
        } else if (i3 == 2) {
            bArr[0] = (byte) (i2 & 255);
            bArr[1] = (byte) ((i2 & 65280) >> 8);
        } else if (i3 == 3) {
            bArr[0] = (byte) (i2 & 255);
            bArr[1] = (byte) ((i2 & 65280) >> 8);
            bArr[2] = (byte) ((i2 & ItemTouchHelper.ACTION_MODE_DRAG_MASK) >> 16);
        } else {
            bArr[0] = (byte) (i2 & 255);
            bArr[1] = (byte) ((i2 & 65280) >> 8);
            bArr[2] = (byte) ((i2 & ItemTouchHelper.ACTION_MODE_DRAG_MASK) >> 16);
            bArr[3] = (byte) ((i2 & (-16777216)) >> 24);
        }
        return bArr;
    }
}
