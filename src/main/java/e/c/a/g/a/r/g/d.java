package e.c.a.g.a.r.g;

import android.text.TextUtils;
import com.kugou.common.config.util.Base64Util;
import com.kugou.common.network.networkutils.MD5Util;
import e.c.a.g.a.s.g0;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    public RSAPublicKey a;

    public static String d(String str, String str2) {
        d dVar = new d();
        try {
            if (!TextUtils.isEmpty(str2)) {
                dVar.f(str2);
            }
        } catch (Exception e2) {
            g0.k(e2);
        }
        try {
            byte[] bArr = new byte[128];
            System.arraycopy(str.getBytes(), 0, bArr, 0, str.getBytes().length);
            byte[] bArrA = dVar.a(dVar.c(), bArr);
            new MD5Util();
            return MD5Util.toHexString(bArrA).replace(" ", "").trim();
        } catch (Exception e3) {
            g0.k(e3);
            return "";
        }
    }

    public static String e(String str, String str2) {
        d dVar = new d();
        try {
            dVar.f(str2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            byte[] bArrB = dVar.b(dVar.c(), str.getBytes());
            new MD5Util();
            return MD5Util.toHexString(bArrB).replace(" ", "").trim();
        } catch (Exception e3) {
            e3.printStackTrace();
            return "";
        }
    }

    public byte[] a(RSAPublicKey rSAPublicKey, byte[] bArr) throws Exception {
        if (rSAPublicKey == null) {
            throw new Exception("加密公钥为空, 请设置");
        }
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/NOPADDING");
            cipher.init(1, rSAPublicKey);
            return cipher.doFinal(bArr);
        } catch (InvalidKeyException unused) {
            throw new Exception("加密公钥非法,请检查");
        } catch (NoSuchAlgorithmException unused2) {
            throw new Exception("无此加密算法");
        } catch (BadPaddingException unused3) {
            throw new Exception("明文数据已损坏");
        } catch (IllegalBlockSizeException unused4) {
            throw new Exception("明文长度非法");
        } catch (NoSuchPaddingException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public byte[] b(RSAPublicKey rSAPublicKey, byte[] bArr) throws Exception {
        if (rSAPublicKey == null) {
            throw new Exception("加密公钥为空, 请设置");
        }
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, rSAPublicKey);
            return cipher.doFinal(bArr);
        } catch (InvalidKeyException unused) {
            throw new Exception("加密公钥非法,请检查");
        } catch (NoSuchAlgorithmException unused2) {
            throw new Exception("无此加密算法");
        } catch (BadPaddingException unused3) {
            throw new Exception("明文数据已损坏");
        } catch (IllegalBlockSizeException unused4) {
            throw new Exception("明文长度非法");
        } catch (NoSuchPaddingException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public RSAPublicKey c() {
        return this.a;
    }

    public void f(String str) throws Exception {
        try {
            this.a = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64Util.decode(str)));
        } catch (NullPointerException unused) {
            throw new Exception("公钥数据为空");
        } catch (NoSuchAlgorithmException unused2) {
            throw new Exception("无此算法");
        } catch (InvalidKeySpecException unused3) {
            throw new Exception("公钥非法");
        }
    }
}
