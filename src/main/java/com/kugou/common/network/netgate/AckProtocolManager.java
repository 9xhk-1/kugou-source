package com.kugou.common.network.netgate;

import android.text.TextUtils;
import com.kugou.common.network.netgate.AckHostConfigEntity;
import com.kugou.common.network.netgate.AckManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class AckProtocolManager {
    private static final String GATEWAY_HOST_KEY = "gateway.kugou.com";
    private static volatile AckProtocolManager mInstance;
    private Map<String, HostKeyProtocolEntity> mHostProtocolMap = new HashMap();
    private Map<String, Integer> mHostVersion = new HashMap();
    private final Object mutex = new Object();

    private AckProtocolManager() {
        register();
    }

    public static AckProtocolManager getInstance() {
        if (mInstance == null) {
            synchronized (AckProtocolManager.class) {
                if (mInstance == null) {
                    mInstance = new AckProtocolManager();
                }
            }
        }
        return mInstance;
    }

    public HostKeyProtocolEntity getProtocolEntity(String str) {
        HostKeyProtocolEntity hostKeyProtocolEntity;
        synchronized (this.mutex) {
            hostKeyProtocolEntity = this.mHostProtocolMap.get(str);
        }
        return hostKeyProtocolEntity;
    }

    public void register() {
        AckManager.getInstance().registerProtocolCallback(new AckManager.AckUpdateCallback() { // from class: com.kugou.common.network.netgate.AckProtocolManager.1
            @Override // com.kugou.common.network.netgate.AckManager.AckUpdateCallback
            public void onUpdate(AckServiceConfigEntity ackServiceConfigEntity) {
            }

            @Override // com.kugou.common.network.netgate.AckManager.AckUpdateCallback
            public void onUpdateHost(List<AckHostConfigEntity> list) {
                synchronized (AckProtocolManager.this.mutex) {
                    if (list == null) {
                        return;
                    }
                    for (AckHostConfigEntity ackHostConfigEntity : list) {
                        if (ackHostConfigEntity != null && !TextUtils.isEmpty(ackHostConfigEntity.hostKey) && (!AckProtocolManager.GATEWAY_HOST_KEY.equals(ackHostConfigEntity.hostKey) || ackHostConfigEntity.version >= 128)) {
                            List<AckHostConfigEntity.UrlHostEntity> list2 = ackHostConfigEntity.urlHosts;
                            if (list2 == null || list2.size() <= 0) {
                                AckProtocolManager.this.mHostProtocolMap.remove(ackHostConfigEntity.hostKey);
                                AckProtocolManager.this.mHostVersion.remove(ackHostConfigEntity.hostKey);
                            } else {
                                AckProtocolManager.this.mHostProtocolMap.put(ackHostConfigEntity.hostKey, new HostKeyProtocolEntity(ackHostConfigEntity.headerParams, ackHostConfigEntity.urlHosts));
                                AckProtocolManager.this.mHostVersion.put(ackHostConfigEntity.hostKey, Integer.valueOf(ackHostConfigEntity.version));
                            }
                        }
                    }
                }
            }
        });
    }
}
