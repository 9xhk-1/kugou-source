package com.kugou.common.network.netgate;

import android.text.TextUtils;
import com.kugou.common.network.netgate.AckManager;
import com.kugou.common.network.netgate.AckServiceConfigEntity;
import com.kugou.common.network.networkutils.NetLog;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class AckWSManager {
    private static final String TAG = "AckWSManager";
    private static AckManager mAckManager;
    private static volatile AckWSManager mWSManager;
    private String mLastAvailableAddressMap;
    private List<String> mAddressList = new ArrayList();
    private Object mLock = new Object();

    private AckWSManager() {
        AckManager ackManager = AckManager.getInstance();
        mAckManager = ackManager;
        ackManager.registerWebsocketCallback(new AckManager.AckUpdateCallback() { // from class: com.kugou.common.network.netgate.AckWSManager.1
            @Override // com.kugou.common.network.netgate.AckManager.AckUpdateCallback
            public void onUpdate(AckServiceConfigEntity ackServiceConfigEntity) {
                synchronized (AckWSManager.this.mLock) {
                    if (ackServiceConfigEntity != null) {
                        if (ackServiceConfigEntity.list != null) {
                            AckWSManager.this.mAddressList.clear();
                            for (AckServiceConfigEntity.AckListItem ackListItem : ackServiceConfigEntity.list) {
                                if (ackListItem != null) {
                                    for (AckServiceConfigEntity.AckAddressItem ackAddressItem : ackListItem.address) {
                                        if (ackAddressItem != null || !TextUtils.isEmpty(ackAddressItem.host)) {
                                            String str = ackAddressItem.host;
                                            int i2 = ackAddressItem.httpPort;
                                            if (i2 != 80 && i2 > 0) {
                                                str = str + ":" + String.valueOf(ackAddressItem.httpPort);
                                            }
                                            if (!AckWSManager.this.mAddressList.contains(str)) {
                                                AckWSManager.this.mAddressList.add(str);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            @Override // com.kugou.common.network.netgate.AckManager.AckUpdateCallback
            public void onUpdateHost(List<AckHostConfigEntity> list) {
            }
        });
    }

    public static AckWSManager getInstance() {
        if (mWSManager == null) {
            synchronized (AckWSManager.class) {
                if (mWSManager == null) {
                    mWSManager = new AckWSManager();
                }
            }
        }
        return mWSManager;
    }

    public List<String> getAddress() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.mLock) {
            if (!TextUtils.isEmpty(this.mLastAvailableAddressMap)) {
                arrayList.add(this.mLastAvailableAddressMap);
            }
            if (this.mAddressList != null) {
                for (int i2 = 0; i2 < this.mAddressList.size(); i2++) {
                    String str = this.mAddressList.get(i2);
                    if (!TextUtils.isEmpty(str) && !str.equals(this.mLastAvailableAddressMap)) {
                        arrayList.add(str);
                    }
                }
            }
        }
        if (NetLog.isDebug()) {
            NetLog.d(TAG, "get ws address(" + Integer.valueOf(arrayList.size()) + ")");
        }
        return arrayList;
    }

    public boolean setAddressAvailable(String str, boolean z) {
        if (NetLog.isDebug()) {
            NetLog.d(TAG, "pref ws : address(" + str + "), " + z);
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        synchronized (this.mLock) {
            if (z) {
                this.mLastAvailableAddressMap = str;
                return true;
            }
            this.mLastAvailableAddressMap = null;
            if (this.mAddressList != null) {
                for (int i2 = 0; i2 < this.mAddressList.size(); i2++) {
                    if (str.equals(this.mAddressList.get(i2))) {
                        this.mAddressList.remove(i2);
                        this.mAddressList.add(str);
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
