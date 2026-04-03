package com.kugou.framework.bilib.statistics.cscc.protocol;

import android.text.TextUtils;
import com.kugou.framework.bilib.common.HttpAdapter;
import com.kugou.framework.bilib.common.SecureSignUtil;
import com.kugou.framework.bilib.statistics.cscc.CryptManager;
import java.io.ByteArrayOutputStream;
import java.util.Hashtable;
import java.util.zip.Deflater;

/* JADX INFO: loaded from: classes2.dex */
public class CsccPostProtocol {

    public static class CsccPostEntity {
        public static final int ERROR_CODE_1310 = 1310;
        public static final int ERROR_CODE_1311 = 1311;
        public static final int ERROR_CODE_COOKIE_EXPIRED = 1202;
        public static final int ERROR_CODE_NONE = 0;
        public static final int ERROR_CODE_SERVER_EXCEPTION = 1299;
        public static final int ERROR_CODE_TIMESTAMP_WRONG = 1201;
        public static final int ERROR_CODE_TOO_FREQUENT = 1203;
        public String eid;
        public int errCode;
        public int status;

        public String getErrorStringForStat() {
            String strValueOf;
            if (this.status == 1) {
                strValueOf = "0";
            } else {
                int i2 = this.errCode;
                strValueOf = i2 != 0 ? String.valueOf(i2 % 1000) : this.eid;
            }
            if (strValueOf == null) {
                strValueOf = "";
            }
            while (strValueOf.length() < 3) {
                strValueOf = "9" + strValueOf;
            }
            return strValueOf;
        }

        public boolean isSuccess(boolean z) {
            int i2;
            return z ? this.status == 1 || (i2 = this.errCode) == 1310 || i2 == 1311 : this.status == 1 || this.errCode == 1311;
        }

        public boolean shouldReGen() {
            int i2 = this.errCode;
            return i2 == 1201 || i2 == 1202;
        }

        public boolean shouldRetry() {
            int i2;
            return !TextUtils.isEmpty(this.eid) || (i2 = this.errCode) == 1203 || i2 == 1299;
        }
    }

    private byte[] compress(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        Deflater deflater = new Deflater();
        deflater.setInput(bArr);
        deflater.finish();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr2 = new byte[8192];
        while (!deflater.finished()) {
            byteArrayOutputStream.write(bArr2, 0, deflater.deflate(bArr2));
        }
        deflater.end();
        return byteArrayOutputStream.toByteArray();
    }

    public CsccPostEntity postData(byte[] bArr, boolean z, long j, long j2, int i2, boolean z2, boolean z3) {
        byte[] bArrCompress = bArr;
        CsccPostEntity csccPostEntity = new CsccPostEntity();
        if (bArrCompress == null || bArrCompress.length == 0) {
            return csccPostEntity;
        }
        int length = 0;
        if (z) {
            length = bArrCompress.length;
            bArrCompress = compress(bArr);
        }
        byte[] bArrEncryptData = CryptManager.getInstance().encryptData(bArrCompress);
        Hashtable hashtable = new Hashtable();
        hashtable.put("cookie", CryptManager.getInstance().getCookie());
        hashtable.put("length", Integer.valueOf(length));
        if (j2 > 0) {
            hashtable.put("t2", Long.valueOf(j2));
        }
        Hashtable<String, Object> hashtableSign = SecureSignUtil.sign(hashtable, CryptManager.API_KEY, CryptManager.SECRETE_KEY, j, bArrEncryptData, true);
        try {
            HttpAdapter.NetService2 netService2 = HttpAdapter.getsNetService2();
            return i2 == 1 ? netService2.postDataApm(hashtableSign, bArrEncryptData) : i2 == 2 ? netService2.postDataDomain2(hashtableSign, bArrEncryptData) : netService2.postDataNOR(hashtableSign, bArrEncryptData);
        } catch (Exception e2) {
            e2.printStackTrace();
            return csccPostEntity;
        }
    }
}
