package com.kugou.common.network.retry;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.kugou.common.network.netgate.AckHostConfigEntity;
import com.kugou.common.network.netgate.AckHostManager;
import com.kugou.common.network.netgate.AckManager;
import com.kugou.common.network.networkutils.NetLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import rx.Observable;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes2.dex */
public class KingCardProxyRetryManager {
    private static final long CONNECTION_TIMEOUT = 10;
    private static final int DEFAULT_PROXY_PORT = 8000;
    private static final String LOG_TAG = "KingCardProxyRetryManager";
    private static volatile KingCardProxyRetryManager sInstance;
    private AtomicBoolean mIsCheckingHealth = new AtomicBoolean(false);
    private final ArrayList<String> mKingCardRetryList = new ArrayList<>();

    private KingCardProxyRetryManager() {
    }

    @NonNull
    private String generateUrl(String str) {
        return AckManager.getAckVars().getKingProxyCheckUrl(str);
    }

    public static KingCardProxyRetryManager getInstance() {
        if (sInstance == null) {
            synchronized (KingCardProxyRetryManager.class) {
                if (sInstance == null) {
                    sInstance = new KingCardProxyRetryManager();
                    return sInstance;
                }
            }
        }
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isProxyHealth(String str) {
        int statusCode;
        HttpEntity entity;
        if (str == null) {
            return false;
        }
        try {
            String strGenerateUrl = generateUrl(str);
            if (!TextUtils.isEmpty(strGenerateUrl)) {
                HttpGet httpGet = new HttpGet(strGenerateUrl);
                DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
                HttpParams params = defaultHttpClient.getParams();
                params.setParameter(ConnRoutePNames.DEFAULT_PROXY, new HttpHost(str, DEFAULT_PROXY_PORT));
                TimeUnit timeUnit = TimeUnit.SECONDS;
                HttpConnectionParams.setConnectionTimeout(params, (int) timeUnit.toMillis(CONNECTION_TIMEOUT));
                HttpConnectionParams.setSoTimeout(params, (int) timeUnit.toMillis(CONNECTION_TIMEOUT));
                HttpResponse httpResponseExecute = defaultHttpClient.execute(httpGet);
                StatusLine statusLine = httpResponseExecute.getStatusLine();
                if (statusLine == null || (statusCode = statusLine.getStatusCode()) < 200 || statusCode >= 300 || (entity = httpResponseExecute.getEntity()) == null) {
                    return false;
                }
                JSONObject jSONObject = new JSONObject(EntityUtils.toString(entity));
                if (jSONObject.optInt(NotificationCompat.CATEGORY_STATUS, 0) == 1) {
                    return true;
                }
                AckManager.getAckVars().reportKingProxyError(jSONObject.optInt("errcode", -1), jSONObject.optString("error", ""), null, jSONObject.optLong("timestamp", -1L));
                return false;
            }
        } catch (Exception e2) {
            AckManager.getAckVars().reportKingProxyError(-1, null, e2, -1L);
            NetLog.uploadException(e2);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void moveDomainToLast(String str) {
        Iterator<String> it = this.mKingCardRetryList.iterator();
        while (it.hasNext()) {
            if (str.equals(it.next())) {
                it.remove();
            }
        }
        this.mKingCardRetryList.add(str);
        if (NetLog.isDebug()) {
            NetLog.i(LOG_TAG, "moveDomainToLast: " + str);
            NetLog.i(LOG_TAG, "moveDomainToLast - currOrder: " + this.mKingCardRetryList.toString());
        }
    }

    public synchronized String getBestDomain(@NonNull String str) {
        if (this.mKingCardRetryList.isEmpty()) {
            for (AckHostConfigEntity.UrlHostEntity urlHostEntity : AckHostManager.getInstance().getHostList(str)) {
                if (urlHostEntity.protocol != 2 && !this.mKingCardRetryList.contains(urlHostEntity.urlHost)) {
                    this.mKingCardRetryList.add(urlHostEntity.urlHost);
                }
            }
            if (NetLog.isDebug()) {
                NetLog.i(LOG_TAG, "init proxy retry domain list: " + this.mKingCardRetryList.toString());
            }
        }
        if (!this.mKingCardRetryList.isEmpty()) {
            str = this.mKingCardRetryList.get(0);
        }
        if (NetLog.isDebug()) {
            NetLog.i(LOG_TAG, "getBestDomain: " + str);
        }
        return str;
    }

    public void updateProxyDomainOrderWhenError(String str) {
        synchronized (this) {
            if (str != null) {
                if (!str.isEmpty() && !this.mKingCardRetryList.isEmpty() && str.equals(this.mKingCardRetryList.get(0)) && !this.mIsCheckingHealth.get()) {
                    Observable.just(str).subscribeOn(Schedulers.io()).subscribe(new Action1<String>() { // from class: com.kugou.common.network.retry.KingCardProxyRetryManager.1
                        @Override // rx.functions.Action1
                        public void call(String str2) {
                            if (KingCardProxyRetryManager.this.mIsCheckingHealth.compareAndSet(false, true)) {
                                try {
                                    if (!KingCardProxyRetryManager.this.isProxyHealth(str2)) {
                                        if (NetLog.isDebug()) {
                                            NetLog.i(KingCardProxyRetryManager.LOG_TAG, "check domain health, failed. domain: " + str2);
                                        }
                                        KingCardProxyRetryManager.this.moveDomainToLast(str2);
                                    } else if (NetLog.isDebug()) {
                                        NetLog.i(KingCardProxyRetryManager.LOG_TAG, "check domain health, success. domain: " + str2);
                                    }
                                } finally {
                                    KingCardProxyRetryManager.this.mIsCheckingHealth.set(false);
                                }
                            }
                        }
                    });
                }
            }
        }
    }
}
