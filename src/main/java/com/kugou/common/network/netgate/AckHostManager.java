package com.kugou.common.network.netgate;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.kugou.common.network.RFCode;
import com.kugou.common.network.netgate.AckHostConfigEntity;
import com.kugou.common.network.netgate.AckManager;
import com.kugou.common.network.netgate.AckUpdateStatEntity;
import com.kugou.common.network.networkutils.NetLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class AckHostManager {
    private static final String GATEWAY_HOST_KEY = "gateway.kugou.com";
    private static final String TAG = "AckHostManager";
    private static volatile AckHostManager mInstance;
    private Map<String, List<AckHostConfigEntity.UrlHostEntity>> mHostMap = new HashMap();
    private Map<String, Integer> mHostVersion = new HashMap();
    private Map<String, Integer> mHostVersion2 = new HashMap();
    private final Object mLock = new Object();

    private AckHostManager() {
        injectDefault();
        AckManager.getInstance().registerDynamicHostCallback(new AckManager.AckUpdateCallback() { // from class: com.kugou.common.network.netgate.AckHostManager.1
            @Override // com.kugou.common.network.netgate.AckManager.AckUpdateCallback
            public void onUpdate(AckServiceConfigEntity ackServiceConfigEntity) {
            }

            @Override // com.kugou.common.network.netgate.AckManager.AckUpdateCallback
            public void onUpdateHost(List<AckHostConfigEntity> list) {
                synchronized (AckHostManager.this.mLock) {
                    if (list != null) {
                        if (list.size() > 0) {
                            for (int i2 = 0; i2 < list.size(); i2++) {
                                AckHostConfigEntity ackHostConfigEntity = list.get(i2);
                                if (ackHostConfigEntity != null && !TextUtils.isEmpty(ackHostConfigEntity.hostKey)) {
                                    ArrayList arrayList = null;
                                    if (ackHostConfigEntity.urlHosts != null) {
                                        arrayList = new ArrayList();
                                        for (int i3 = 0; i3 < ackHostConfigEntity.urlHosts.size(); i3++) {
                                            AckHostConfigEntity.UrlHostEntity urlHostEntity = ackHostConfigEntity.urlHosts.get(i3);
                                            if (urlHostEntity != null && urlHostEntity.protocol == 0) {
                                                arrayList.add(urlHostEntity);
                                            }
                                        }
                                    }
                                    if (!AckHostManager.GATEWAY_HOST_KEY.equals(ackHostConfigEntity.hostKey) || ackHostConfigEntity.version >= 128) {
                                        if (NetLog.isDebug()) {
                                            StringBuilder sb = new StringBuilder();
                                            sb.append("onUpdateHost : hostKey=");
                                            sb.append(ackHostConfigEntity.hostKey);
                                            sb.append(", urlHosts=");
                                            sb.append(arrayList != null ? Integer.valueOf(arrayList.size()) : "");
                                            NetLog.d(AckHostManager.TAG, sb.toString());
                                        }
                                        if (arrayList == null || arrayList.size() <= 0) {
                                            AckHostManager.this.mHostMap.remove(ackHostConfigEntity.hostKey);
                                            AckHostManager.this.mHostVersion.remove(ackHostConfigEntity.hostKey);
                                        } else {
                                            AckHostManager.this.mHostMap.put(ackHostConfigEntity.hostKey, arrayList);
                                            AckHostManager.this.mHostVersion.put(ackHostConfigEntity.hostKey, Integer.valueOf(ackHostConfigEntity.version));
                                        }
                                        AckHostManager.this.mHostVersion2.put(ackHostConfigEntity.hostKey, Integer.valueOf(ackHostConfigEntity.version));
                                    } else {
                                        if (!AckHostManager.this.mHostMap.containsKey(AckHostManager.GATEWAY_HOST_KEY)) {
                                            AckHostManager.this.injectDefault();
                                        }
                                        if (NetLog.isDebug()) {
                                            NetLog.d(AckHostManager.TAG, "gateway.kugou.com config: " + String.valueOf(AckHostManager.this.mHostMap.get(AckHostManager.GATEWAY_HOST_KEY)));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        });
    }

    public static AckHostManager getInstance() {
        if (mInstance == null) {
            synchronized (AckHostManager.class) {
                if (mInstance == null) {
                    mInstance = new AckHostManager();
                }
            }
        }
        return mInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void injectDefault() {
        if (NetLog.isDebug()) {
            NetLog.d(TAG, "inject default gateway");
        }
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(new AckHostConfigEntity.UrlHostEntity(GATEWAY_HOST_KEY, 0));
        arrayList.add(new AckHostConfigEntity.UrlHostEntity("gatewayretry.kugou.com", 0));
        arrayList.add(new AckHostConfigEntity.UrlHostEntity("gateway3.kugou.com", 0));
        this.mHostMap.put(GATEWAY_HOST_KEY, arrayList);
        this.mHostVersion.put(GATEWAY_HOST_KEY, Integer.valueOf(RFCode.GATEWAY_DEFAULT_CONFIG));
        this.mHostVersion2.put(GATEWAY_HOST_KEY, Integer.valueOf(RFCode.GATEWAY_DEFAULT_CONFIG));
    }

    public AckUpdateStatEntity.DynDomainUpdateStatEntity getAckStat() {
        AckUpdateStatEntity.DynDomainUpdateStatEntity dynDomainUpdateStatEntity;
        ArrayList arrayList = new ArrayList();
        synchronized (this.mLock) {
            for (String str : this.mHostVersion.keySet()) {
                List<AckHostConfigEntity.UrlHostEntity> list = this.mHostMap.get(str);
                if (list != null) {
                    arrayList.add(new AckUpdateStatEntity.DynDomainUpdateStatEntity.Item(str, this.mHostVersion.get(str).intValue(), 0, new ArrayList(list)));
                }
            }
            dynDomainUpdateStatEntity = new AckUpdateStatEntity.DynDomainUpdateStatEntity(arrayList);
        }
        return dynDomainUpdateStatEntity;
    }

    @NonNull
    public List<AckHostConfigEntity.UrlHostEntity> getHostList(String str) {
        ArrayList arrayList = new ArrayList();
        synchronized (this.mLock) {
            List<AckHostConfigEntity.UrlHostEntity> list = this.mHostMap.get(str);
            if (list != null) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    AckHostConfigEntity.UrlHostEntity urlHostEntity = list.get(i2);
                    if (urlHostEntity != null) {
                        arrayList.add(urlHostEntity);
                    }
                }
            }
        }
        if (NetLog.isDebug()) {
            NetLog.d(TAG, "get host list(" + arrayList.size() + ")");
        }
        return arrayList;
    }

    public int getHostVersion(String str) {
        Integer num = this.mHostVersion2.get(str);
        return num == null ? RFCode.ACK_HOST_MANAGER_NO_RECORD : num.intValue() & 32767;
    }
}
