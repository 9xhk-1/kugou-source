package e.c.c.o;

import androidx.exifinterface.media.ExifInterface;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes2.dex */
public class i {
    public static final String[] c = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
    public long[] a = new long[4];
    public long[] b = new long[2];

    public i() {
        i();
    }

    public static String a(byte b) {
        int i2 = b;
        if (b < 0) {
            i2 = b + 256;
        }
        StringBuilder sb = new StringBuilder();
        String[] strArr = c;
        sb.append(strArr[i2 / 16]);
        sb.append(strArr[i2 % 16]);
        return sb.toString();
    }

    public static String b(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            stringBuffer.append(a(b));
        }
        return stringBuffer.toString();
    }

    public static String c(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & ExifInterface.MARKER);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static synchronized String g(String str) {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
        return c(messageDigest.digest());
    }

    public static String h(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            return c(messageDigest.digest());
        } catch (Exception unused) {
            return "";
        }
    }

    public static String j(String str) {
        String str2;
        String str3 = "";
        try {
            str2 = new String(str);
        } catch (NoSuchAlgorithmException e2) {
            e = e2;
        }
        try {
            return b(MessageDigest.getInstance("MD5").digest(str.getBytes()));
        } catch (NoSuchAlgorithmException e3) {
            e = e3;
            str3 = str2;
            e.printStackTrace();
            return str3;
        }
    }

    public String d(byte[] bArr) {
        try {
            return b(MessageDigest.getInstance("MD5").digest(bArr));
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public String e(String str) {
        String str2;
        String str3 = "";
        try {
            str2 = new String(str);
        } catch (NoSuchAlgorithmException e2) {
            e = e2;
        }
        try {
            return b(MessageDigest.getInstance("MD5").digest(str.getBytes()));
        } catch (NoSuchAlgorithmException e3) {
            e = e3;
            str3 = str2;
            e.printStackTrace();
            return str3;
        }
    }

    public String f(String str, String str2) {
        String str3 = "";
        try {
            String str4 = new String(str);
            try {
                return b(MessageDigest.getInstance("MD5").digest(str.getBytes(str2)));
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

    public final void i() {
        long[] jArr = this.b;
        jArr[0] = 0;
        jArr[1] = 0;
        long[] jArr2 = this.a;
        jArr2[0] = 1732584193;
        jArr2[1] = 4023233417L;
        jArr2[2] = 2562383102L;
        jArr2[3] = 271733878;
    }
}
