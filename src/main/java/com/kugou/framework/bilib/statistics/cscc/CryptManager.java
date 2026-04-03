package com.kugou.framework.bilib.statistics.cscc;

import com.kugou.framework.bilib.LibLog;
import com.kugou.framework.bilib.common.LibConfig;
import com.kugou.framework.bilib.statistics.cscc.CsccCypher;
import com.kugou.framework.bilib.statistics.cscc.protocol.CsccGenProtocol;

/* JADX INFO: loaded from: classes2.dex */
public class CryptManager {
    public static final String API_KEY = LibConfig.getInstance().getAppId();
    public static final String SECRETE_KEY = LibConfig.getInstance().getAppKey();
    private static volatile CryptManager sCryptMgr;
    private CsccCypher mCypher = new CsccCypher();

    private CryptManager() {
    }

    private boolean fetchDynamicKey() {
        LibLog.i("burone-key", "devId = 0");
        CsccGenProtocol.CsccGenEntity serverRandomKey = new CsccGenProtocol().getServerRandomKey(this.mCypher.genClientEncodeBase64S(0L));
        if (serverRandomKey == null || !serverRandomKey.isSuccess()) {
            StringBuilder sb = new StringBuilder();
            sb.append("gen key failed, errorCode = ");
            sb.append(serverRandomKey != null ? Integer.valueOf(serverRandomKey.errCode) : null);
            LibLog.i("burone-key", sb.toString());
            serverRandomKey = new CsccGenProtocol().getServerRandomKey(this.mCypher.genClientEncodeBase64S(0L));
        }
        if (serverRandomKey != null && serverRandomKey.isSuccess()) {
            this.mCypher.setServerEncodeBase64Data(serverRandomKey.data);
            LibLog.e("burone-key", "gen key success !!!!!");
            return true;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("retry failed, errorCode = ");
        sb2.append(serverRandomKey != null ? Integer.valueOf(serverRandomKey.errCode) : null);
        LibLog.e("burone-key", sb2.toString());
        return false;
    }

    public static CryptManager getInstance() {
        if (sCryptMgr == null) {
            synchronized (CryptManager.class) {
                if (sCryptMgr == null) {
                    sCryptMgr = new CryptManager();
                    sCryptMgr.fetchDynamicKey();
                }
            }
        }
        return sCryptMgr;
    }

    public byte[] encryptData(byte[] bArr) {
        return this.mCypher.encryptWithImeiIv(bArr);
    }

    public long getAdjustedTime() {
        return getAdjustedTime(System.currentTimeMillis());
    }

    public String getCookie() {
        CsccCypher.ServerResp serverResp = this.mCypher.getServerResp();
        if (serverResp != null) {
            return serverResp.mCookie;
        }
        return null;
    }

    public String getUUID() {
        return this.mCypher.getUUID();
    }

    public boolean isGenOk() {
        return this.mCypher.isGenOk();
    }

    public boolean updateDynamicKey() {
        return fetchDynamicKey();
    }

    public long getAdjustedTime(long j) {
        long j2;
        long j3;
        CsccCypher.ServerResp serverResp = this.mCypher.getServerResp();
        if (serverResp != null) {
            j2 = serverResp.mServerTime;
            j3 = serverResp.mClientTime;
        } else {
            j2 = 0;
            j3 = 0;
        }
        return (j2 > 0 || j3 > 0) ? ((j / 1000) - j3) + j2 : j / 1000;
    }
}
