package com.kugou.common.network.netgate;

import android.text.TextUtils;
import com.kugou.common.network.netgate.AckManager;
import com.kugou.common.network.netgate.AckServiceConfigEntity;
import com.kugou.common.network.networkutils.NetLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class AckLCManager {
    private static final String INVALID_HOST = "0.0.0.0";
    private static final String TAG = "AckLCManager";
    private static AckManager mAckManager;
    private static volatile AckLCManager mInstance;
    private String mLastAvailableAddressMap;
    private List<String> mAddressList = new ArrayList();
    private Object mLock = new Object();
    private int[] mDisasterServerIds = {AckManager.SERVICE_ID_LONG_CONNECTION_DISASTER_ONE, AckManager.SERVICE_ID_LONG_CONNECTION_DISASTER_TWO};

    private AckLCManager() {
        AckManager ackManager = AckManager.getInstance();
        mAckManager = ackManager;
        ackManager.registerLongConnectionCallback(this.mDisasterServerIds, new AckManager.AckUpdateCallback() { // from class: com.kugou.common.network.netgate.AckLCManager.1
            @Override // com.kugou.common.network.netgate.AckManager.AckUpdateCallback
            public void onUpdate(AckServiceConfigEntity ackServiceConfigEntity) {
                List<AckServiceConfigEntity.AckAddressItem> list;
                synchronized (AckLCManager.this.mLock) {
                    if (ackServiceConfigEntity != null) {
                        List<AckServiceConfigEntity.AckListItem> list2 = ackServiceConfigEntity.list;
                        if (list2 != null) {
                            for (AckServiceConfigEntity.AckListItem ackListItem : list2) {
                                if (ackListItem != null && (list = ackListItem.address) != null) {
                                    Collections.shuffle(list);
                                    for (AckServiceConfigEntity.AckAddressItem ackAddressItem : ackListItem.address) {
                                        if (ackAddressItem != null || !TextUtils.isEmpty(ackAddressItem.host)) {
                                            String str = ackAddressItem.host;
                                            int i2 = ackAddressItem.httpPort;
                                            if (i2 != 80 && i2 > 0) {
                                                str = str + ":" + String.valueOf(ackAddressItem.httpPort);
                                            }
                                            if (!AckLCManager.this.mAddressList.contains(str) && !str.contains(AckLCManager.INVALID_HOST)) {
                                                AckLCManager.this.mAddressList.add(str);
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

    public static AckLCManager getInstance() {
        if (mInstance == null) {
            synchronized (AckLCManager.class) {
                if (mInstance == null) {
                    mInstance = new AckLCManager();
                }
            }
        }
        return mInstance;
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
            NetLog.d(TAG, "get long connection address(" + Integer.valueOf(arrayList.size()) + ")");
        }
        return arrayList;
    }

    public boolean setAddressAvailable(String str, boolean z) {
        if (NetLog.isDebug()) {
            NetLog.d(TAG, "pref long connection : address(" + str + "), " + z);
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
