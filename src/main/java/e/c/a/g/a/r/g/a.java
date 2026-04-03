package e.c.a.g.a.r.g;

import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import e.c.a.g.a.s.g0;
import e.c.c.o.i;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static String a(byte[] bArr, String str, String str2, String str3) throws Exception {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            cipher.init(2, secretKeySpec, new IvParameterSpec(str3.getBytes(), 0, 16));
            return new String(cipher.doFinal(bArr), "UTF-8").trim();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String b(String str, String str2) throws Exception {
        return g(c(str, "utf-8", f(str2).substring(0, 32), f(str2).substring(16, 32)));
    }

    public static byte[] c(String str, String str2, String str3, String str4) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str3.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, secretKeySpec, new IvParameterSpec(str4.getBytes()));
        return cipher.doFinal(str.getBytes(str2));
    }

    public static String d() {
        try {
            return e(64);
        } catch (Exception unused) {
            return e(128);
        }
    }

    @Nullable
    public static String e(int i2) {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(i2);
            return g(keyGenerator.generateKey().getEncoded());
        } catch (NoSuchAlgorithmException e2) {
            g0.k(e2);
            return null;
        }
    }

    public static String f(String str) {
        return new i().e(str);
    }

    public static String g(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & ExifInterface.MARKER);
            if (hexString.length() == 1) {
                hexString = '0' + hexString;
            }
            stringBuffer.append(hexString.toUpperCase());
        }
        return stringBuffer.toString();
    }
}
