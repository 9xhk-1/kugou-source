package com.kugou.common.network.retry;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Pair;
import com.kugou.common.network.netgate.AckHostConfigEntity;
import com.kugou.common.network.netgate.AckHostManager;
import com.kugou.common.network.netgate.AckManager;
import com.kugou.common.network.netgate.AckProtocolTypeUtil;
import com.kugou.common.network.networkutils.NetLog;
import com.kugou.common.network.retry.RetryConfigInfo;
import java.net.URI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class HttpRetryManager {
    private static final String TAG = "HttpRetryManager";
    private static volatile HttpRetryManager sHttpRetryManager;
    private final Object mListLock = new Object();
    private HashMap<String, RetryConfigInfo.RetryRecord> mDomainRecordMap = new HashMap<>();
    private volatile boolean networkReadyed = true;
    private BroadcastReceiver mReceiver = new BroadcastReceiver() { // from class: com.kugou.common.network.retry.HttpRetryManager.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action == null || !action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                return;
            }
            if (NetLog.isDebug()) {
                NetLog.d(HttpRetryManager.TAG, "network change networkReadyed=" + HttpRetryManager.this.networkReadyed);
            }
            if (HttpRetryManager.this.networkReadyed) {
                HttpRetryManager.this.networkReadyed = false;
            }
        }
    };

    private HttpRetryManager() {
        AckManager.getAckVars().registerSysReceiver(this.mReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    public static String getHost(String str) {
        try {
            return new URI(str).getHost();
        } catch (Exception unused) {
            return null;
        }
    }

    public static HttpRetryManager getInstance() {
        if (sHttpRetryManager == null) {
            synchronized (HttpRetryManager.class) {
                if (sHttpRetryManager == null) {
                    sHttpRetryManager = new HttpRetryManager();
                }
            }
        }
        return sHttpRetryManager;
    }

    @NonNull
    private RetryConfigInfo getRetryConfigInfo(Pair<String, String> pair, @NonNull List<AckHostConfigEntity.UrlHostEntity> list, int i2) {
        RetryConfigInfo retryConfigInfo;
        synchronized (this.mListLock) {
            retryConfigInfo = new RetryConfigInfo();
            Iterator<AckHostConfigEntity.UrlHostEntity> it = list.iterator();
            while (it.hasNext()) {
                RetryConfigInfo.RetryRecord retryRecord = getRetryRecord(it.next().urlHost);
                if (retryRecord != null) {
                    retryConfigInfo.mRetryRecords.add(retryRecord);
                }
            }
            retryConfigInfo.originHostRecord = getRetryRecord((String) pair.first, (String) pair.second);
            retryConfigInfo.version = i2;
        }
        return retryConfigInfo;
    }

    private RetryConfigInfo.RetryRecord getRetryRecord(String str) {
        return getRetryRecord("http", str);
    }

    @Nullable
    public static Pair<String, String> getSchemeHostPair(String str) {
        try {
            URI uri = new URI(str);
            return new Pair<>(uri.getScheme(), uri.getHost());
        } catch (Exception unused) {
            return null;
        }
    }

    public void markRequest(String str, String str2, int i2, int i3) {
        if (NetLog.isDebug()) {
            NetLog.d(TAG, "mark Request oriUrl=" + str + ", value=" + str2 + ", type=" + i2 + ", state=" + i3);
        }
        String host = getHost(str);
        synchronized (this.mListLock) {
            RetryConfigInfo.RetryRecord retryRecord = this.mDomainRecordMap.get(host);
            if (retryRecord != null) {
                if (TextUtils.isEmpty(str2)) {
                    i3 = -2;
                }
                if (i3 == 1 && !this.networkReadyed) {
                    this.networkReadyed = true;
                    AckManager.getAckVars().networkHasReady();
                }
                switch (i2) {
                    case 111:
                        retryRecord.records[0] = i3;
                        return;
                    case 112:
                        retryRecord.records[1] = i3;
                        return;
                    case 113:
                        retryRecord.records[2] = i3;
                        return;
                }
            }
        }
    }

    public void reset() {
        if (NetLog.isDebug()) {
            NetLog.e(TAG, "start reset");
        }
        synchronized (this.mListLock) {
            this.mDomainRecordMap.clear();
        }
    }

    private RetryConfigInfo.RetryRecord getRetryRecord(String str, String str2) {
        return getRetryRecord(AckProtocolTypeUtil.parse(str), str2);
    }

    private RetryConfigInfo.RetryRecord getRetryRecord(int i2, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        RetryConfigInfo.RetryRecord retryRecord = this.mDomainRecordMap.get(str);
        if (retryRecord != null) {
            return retryRecord;
        }
        RetryConfigInfo.RetryRecord retryRecord2 = new RetryConfigInfo.RetryRecord(str);
        retryRecord2.setProtocolType(i2);
        this.mDomainRecordMap.put(str, retryRecord2);
        return retryRecord2;
    }

    @Nullable
    public RetryConfigInfo getRetryConfigInfo(@NonNull String str) {
        Pair<String, String> schemeHostPair = getSchemeHostPair(str);
        if (schemeHostPair == null) {
            return null;
        }
        RetryConfigInfo retryConfigInfo = getRetryConfigInfo(schemeHostPair, AckHostManager.getInstance().getHostList((String) schemeHostPair.second), AckHostManager.getInstance().getHostVersion((String) schemeHostPair.second));
        if (NetLog.isDebug()) {
            NetLog.d(TAG, "getRetryConfigInfo result(" + retryConfigInfo.mRetryRecords.size() + ")");
        }
        return retryConfigInfo;
    }
}
