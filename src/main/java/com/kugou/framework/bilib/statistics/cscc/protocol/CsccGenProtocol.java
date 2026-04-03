package com.kugou.framework.bilib.statistics.cscc.protocol;

import android.text.TextUtils;
import com.kugou.framework.bilib.common.HttpAdapter;
import com.kugou.framework.bilib.common.SecureSignUtil;
import com.kugou.framework.bilib.statistics.cscc.CryptManager;
import java.util.Hashtable;

/* JADX INFO: loaded from: classes2.dex */
public class CsccGenProtocol {

    public static class CsccGenEntity {
        public static final int ERROR_CODE_SERVER_EXCEPTION = 1299;
        public String data;
        public int errCode;
        public int status;

        public boolean isSuccess() {
            return this.status == 1;
        }
    }

    public CsccGenEntity getServerRandomKey(String str) {
        if (!TextUtils.isEmpty(str)) {
            Hashtable hashtable = new Hashtable();
            hashtable.put("s", str);
            try {
                return HttpAdapter.getsNetService2().getGen2(SecureSignUtil.sign(hashtable, CryptManager.API_KEY, CryptManager.SECRETE_KEY, System.currentTimeMillis() / 1000, true));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }
}
