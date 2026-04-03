package com.kugou.common.network.netgate;

import android.net.Proxy;
import android.text.TextUtils;
import com.kugou.common.network.AbsHttpClient;
import com.kugou.common.network.ackutils.StringResponsePackage;
import com.kugou.common.network.ackutils.SystemUtils;
import com.kugou.common.network.netgate.AckManager;
import com.kugou.common.network.netgate.AckServiceConfigEntity;
import com.kugou.common.network.networkutils.NetLog;
import com.kugou.common.network.protocol.RequestPackage;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class AckProbeManager {
    private static final int DATE_HOUR_ONE = 3600;
    private static final String TAG = "AckProbeManager";
    private static volatile AckProbeManager mInstance;
    private int checkPercent;
    private int checkTime;
    private ScheduledExecutorService executor;
    private AckManager mAckManager;
    private WorkRunable mRun;
    private ScheduledFuture mTask;
    private Object mLock = new Object();
    private Map<String, String> clientIpMap = new HashMap();

    public class ProbeRequestPackage implements RequestPackage {
        private String domain;
        private String ip;
        private String url;

        public ProbeRequestPackage(String str, String str2, String str3) {
            this.url = str3;
            this.ip = str2;
            this.domain = str;
        }

        public String getClientIp() {
            return (String) AckProbeManager.this.clientIpMap.get(this.ip);
        }

        @Override // com.kugou.common.network.protocol.RequestPackage
        public String getGetRequestParams() {
            return null;
        }

        @Override // com.kugou.common.network.protocol.RequestPackage
        public Header[] getHttpHeaders() {
            return new Header[]{new BasicHeader(HTTP.TARGET_HOST, this.domain)};
        }

        @Override // com.kugou.common.network.protocol.RequestPackage
        public HttpEntity getPostRequestEntity() {
            return null;
        }

        @Override // com.kugou.common.network.protocol.RequestPackage
        public String getRequestModuleName() {
            return "ack-probe";
        }

        @Override // com.kugou.common.network.protocol.RequestPackage
        public String getRequestType() {
            return "GET";
        }

        @Override // com.kugou.common.network.protocol.RequestPackage
        public String getUrl() {
            return this.url;
        }
    }

    public class ProbeResponsePackage extends StringResponsePackage {
        private String ip;

        public ProbeResponsePackage(String str) {
            this.ip = str;
        }

        @Override // com.kugou.common.network.ackutils.StringResponsePackage, com.kugou.common.network.protocol.ResponsePackage
        public void getResponseData(Object obj) {
        }

        @Override // com.kugou.common.network.ackutils.StringResponsePackage, com.kugou.common.network.protocol.ResponsePackage
        public void setContext(byte[] bArr) {
            if (bArr == null || bArr.length == 0) {
                return;
            }
            try {
                AckProbeManager.this.clientIpMap.put(this.ip, new JSONObject(new String(bArr, "UTF-8")).optString("remote_addr"));
            } catch (UnsupportedEncodingException e2) {
                NetLog.uploadException(e2);
            } catch (JSONException e3) {
                NetLog.uploadException(e3);
            }
        }
    }

    public class WorkRunable implements Runnable {
        private Map<String, List<String>> addressMap;

        public WorkRunable(Map<String, List<String>> map) {
            this.addressMap = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!SystemUtils.isPicked(AckProbeManager.this.checkPercent)) {
                if (NetLog.isDebug()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(" not pick up : percent=");
                    double d2 = AckProbeManager.this.checkPercent;
                    Double.isNaN(d2);
                    sb.append(d2 / 100.0d);
                    NetLog.d(AckProbeManager.TAG, sb.toString());
                    return;
                }
                return;
            }
            if (AckManager.getAckVars().canUseUnicomProxy() || !TextUtils.isEmpty(Proxy.getDefaultHost())) {
                if (NetLog.isDebug()) {
                    NetLog.d(AckProbeManager.TAG, " proxy is on ");
                    return;
                }
                return;
            }
            for (Map.Entry<String, List<String>> entry : this.addressMap.entrySet()) {
                if (entry != null) {
                    String key = entry.getKey();
                    List<String> value = entry.getValue();
                    if (value != null) {
                        for (String str : value) {
                            ProbeRequestPackage probeRequestPackage = AckProbeManager.this.new ProbeRequestPackage(key, str, "http://" + str);
                            ProbeResponsePackage probeResponsePackage = AckProbeManager.this.new ProbeResponsePackage(str);
                            try {
                                AbsHttpClient httpClient = AckManager.getAckVars().getHttpClient();
                                httpClient.setCanUseProxy(false);
                                httpClient.request(probeRequestPackage, probeResponsePackage);
                            } catch (Exception e2) {
                                NetLog.uploadException(e2);
                            }
                        }
                        AckProbeManager.this.clientIpMap.clear();
                    }
                }
            }
        }
    }

    private AckProbeManager() {
        if (AckManager.getAckVars().isProbePickUp()) {
            this.mAckManager = AckManager.getInstance();
            this.executor = Executors.newSingleThreadScheduledExecutor();
            this.mAckManager.registerAckProbeCallback(new AckManager.AckUpdateCallback() { // from class: com.kugou.common.network.netgate.AckProbeManager.1
                private void collectAddressItem(AckServiceConfigEntity.AckAddressItem ackAddressItem, List<String> list) {
                    if (ackAddressItem == null || TextUtils.isEmpty(ackAddressItem.host)) {
                        return;
                    }
                    String str = ackAddressItem.host;
                    int i2 = ackAddressItem.httpPort;
                    if (i2 != 80 && i2 > 0) {
                        str = str + ":" + ackAddressItem.httpPort;
                    }
                    if (list.contains(str)) {
                        return;
                    }
                    list.add(str);
                }

                @Override // com.kugou.common.network.netgate.AckManager.AckUpdateCallback
                public void onUpdate(AckServiceConfigEntity ackServiceConfigEntity) {
                    synchronized (AckProbeManager.this.mLock) {
                        if (ackServiceConfigEntity != null) {
                            if (ackServiceConfigEntity.list != null) {
                                if (AckProbeManager.this.mTask != null && !AckProbeManager.this.mTask.isDone()) {
                                    AckProbeManager.this.mTask.cancel(true);
                                    AckProbeManager.this.mRun = null;
                                }
                                AckProbeManager.this.clientIpMap.clear();
                                HashMap map = new HashMap();
                                AckProbeManager.this.checkTime = ackServiceConfigEntity.checkTime;
                                AckProbeManager.this.checkPercent = ackServiceConfigEntity.checkPercent;
                                for (AckServiceConfigEntity.AckListItem ackListItem : ackServiceConfigEntity.list) {
                                    if (ackListItem != null && !TextUtils.isEmpty(ackListItem.domain)) {
                                        ArrayList arrayList = new ArrayList();
                                        List<AckServiceConfigEntity.AckAddressItem> list = ackListItem.address;
                                        if (list != null) {
                                            Iterator<AckServiceConfigEntity.AckAddressItem> it = list.iterator();
                                            while (it.hasNext()) {
                                                collectAddressItem(it.next(), arrayList);
                                            }
                                        }
                                        if (ackListItem.backupAddress != null) {
                                            for (int i2 = 0; i2 < ackListItem.backupAddress.size(); i2++) {
                                                List<AckServiceConfigEntity.AckAddressItem> list2 = ackListItem.backupAddress.get(i2);
                                                for (int i3 = 0; i3 < list2.size(); i3++) {
                                                    collectAddressItem(list2.get(i3), arrayList);
                                                }
                                            }
                                        }
                                        if (arrayList.size() > 0) {
                                            map.put(ackListItem.domain, arrayList);
                                        }
                                    }
                                }
                                if (NetLog.isDebug()) {
                                    NetLog.d(AckProbeManager.TAG, "Probe address : " + map + ", checkTime=" + AckProbeManager.this.checkTime);
                                }
                                if (map.size() > 0 && AckProbeManager.this.checkTime > 0) {
                                    if (AckProbeManager.this.checkTime < AckProbeManager.DATE_HOUR_ONE) {
                                        AckProbeManager.this.checkTime = AckProbeManager.DATE_HOUR_ONE;
                                    }
                                    AckProbeManager ackProbeManager = AckProbeManager.this;
                                    ackProbeManager.mRun = ackProbeManager.new WorkRunable(map);
                                    AckProbeManager ackProbeManager2 = AckProbeManager.this;
                                    ackProbeManager2.mTask = ackProbeManager2.executor.scheduleAtFixedRate(AckProbeManager.this.mRun, 2L, AckProbeManager.this.checkTime, TimeUnit.SECONDS);
                                }
                            }
                        }
                    }
                }

                @Override // com.kugou.common.network.netgate.AckManager.AckUpdateCallback
                public void onUpdateHost(List<AckHostConfigEntity> list) {
                }
            });
        } else if (NetLog.isDebug()) {
            NetLog.d(TAG, " no pick up for netqualitystat");
        }
    }

    public static AckProbeManager getInstance() {
        if (mInstance == null) {
            synchronized (AckProbeManager.class) {
                if (mInstance == null) {
                    mInstance = new AckProbeManager();
                }
            }
        }
        return mInstance;
    }
}
