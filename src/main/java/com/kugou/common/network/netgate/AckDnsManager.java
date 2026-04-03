package com.kugou.common.network.netgate;

import android.text.TextUtils;
import com.kugou.common.network.netgate.AckManager;
import com.kugou.common.network.netgate.AckServiceConfigEntity;
import com.kugou.common.network.netgate.AckUpdateStatEntity;
import com.kugou.common.network.networkutils.NetLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class AckDnsManager {
    private static final String TAG = "AckDnsManager";
    private static volatile AckDnsManager mAckDnsManager;
    private static AckManager mAckManager;
    private Map<String, List<List<String>>> mAddressMap = new HashMap();
    private Map<String, String> mLastAvailableAddressMap = new HashMap();
    private final Object mLock = new Object();
    private volatile int version;

    private AckDnsManager() {
        AckManager ackManager = AckManager.getInstance();
        mAckManager = ackManager;
        ackManager.registerAckDnsCallback(new AckManager.AckUpdateCallback() { // from class: com.kugou.common.network.netgate.AckDnsManager.1
            @Override // com.kugou.common.network.netgate.AckManager.AckUpdateCallback
            public void onUpdate(AckServiceConfigEntity ackServiceConfigEntity) {
                synchronized (AckDnsManager.this.mLock) {
                    if (ackServiceConfigEntity != null) {
                        if (ackServiceConfigEntity.list != null) {
                            AckDnsManager.this.mAddressMap.clear();
                            for (AckServiceConfigEntity.AckListItem ackListItem : ackServiceConfigEntity.list) {
                                if (ackListItem != null && !TextUtils.isEmpty(ackListItem.domain)) {
                                    ArrayList arrayList = new ArrayList();
                                    if (ackListItem.address != null) {
                                        ArrayList arrayList2 = new ArrayList();
                                        for (AckServiceConfigEntity.AckAddressItem ackAddressItem : ackListItem.address) {
                                            if (ackAddressItem != null && !TextUtils.isEmpty(ackAddressItem.host)) {
                                                String str = ackAddressItem.host;
                                                int i2 = ackAddressItem.httpPort;
                                                if (i2 != 80 && i2 > 0) {
                                                    str = str + ":" + ackAddressItem.httpPort;
                                                }
                                                arrayList2.add(str);
                                            }
                                        }
                                        if (arrayList2.size() > 0) {
                                            arrayList.add(arrayList2);
                                        }
                                    }
                                    if (ackListItem.backupAddress != null) {
                                        for (int i3 = 0; i3 < ackListItem.backupAddress.size(); i3++) {
                                            List<AckServiceConfigEntity.AckAddressItem> list = ackListItem.backupAddress.get(i3);
                                            ArrayList arrayList3 = new ArrayList();
                                            for (int i4 = 0; i4 < list.size(); i4++) {
                                                AckServiceConfigEntity.AckAddressItem ackAddressItem2 = list.get(i4);
                                                if (ackAddressItem2 != null) {
                                                    String str2 = ackAddressItem2.host;
                                                    int i5 = ackAddressItem2.httpPort;
                                                    if (i5 != 80 && i5 > 0) {
                                                        str2 = str2 + ":" + ackAddressItem2.httpPort;
                                                    }
                                                    arrayList3.add(str2);
                                                }
                                            }
                                            if (arrayList3.size() > 0) {
                                                arrayList.add(arrayList3);
                                            }
                                        }
                                    }
                                    if (arrayList.size() > 0) {
                                        AckDnsManager.this.mAddressMap.put(ackListItem.domain, arrayList);
                                    }
                                    AckDnsManager.this.version = ackServiceConfigEntity.version;
                                }
                            }
                        }
                    }
                }
                AckDnsManager.this.reset();
            }

            @Override // com.kugou.common.network.netgate.AckManager.AckUpdateCallback
            public void onUpdateHost(List<AckHostConfigEntity> list) {
            }
        });
    }

    public static AckDnsManager getInstance() {
        if (mAckDnsManager == null) {
            synchronized (AckDnsManager.class) {
                if (mAckDnsManager == null) {
                    mAckDnsManager = new AckDnsManager();
                }
            }
        }
        return mAckDnsManager;
    }

    public AckUpdateStatEntity.AckDnsUpdateStatEntity getAckStat() {
        AckUpdateStatEntity.AckDnsUpdateStatEntity ackDnsUpdateStatEntity;
        HashMap map = new HashMap();
        synchronized (this.mLock) {
            for (String str : this.mAddressMap.keySet()) {
                map.put(str, this.mAddressMap.get(str).get(0).get(0));
            }
            ackDnsUpdateStatEntity = new AckUpdateStatEntity.AckDnsUpdateStatEntity(this.version, 0, map);
        }
        return ackDnsUpdateStatEntity;
    }

    public List<String> getAddress(String str) {
        ArrayList arrayList;
        if (TextUtils.isEmpty(str)) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            synchronized (this.mLock) {
                if (this.mLastAvailableAddressMap.get(str) != null) {
                    arrayList.add(this.mLastAvailableAddressMap.get(str));
                }
                List<List<String>> list = this.mAddressMap.get(str);
                if (list != null) {
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        List<String> list2 = list.get(i2);
                        if (list2 != null && list2.size() > 0) {
                            String str2 = list2.get(0);
                            if (!TextUtils.isEmpty(str2) && !str2.equals(this.mLastAvailableAddressMap.get(str))) {
                                arrayList.add(str2);
                            }
                        }
                    }
                }
            }
        }
        if (NetLog.isDebug()) {
            StringBuilder sb = new StringBuilder();
            sb.append("get dns address(");
            sb.append(arrayList != null ? Integer.valueOf(arrayList.size()) : null);
            sb.append(")");
            NetLog.d(TAG, sb.toString());
        }
        return arrayList;
    }

    public void reset() {
        if (NetLog.isDebug()) {
            NetLog.d(TAG, " start reset");
        }
        synchronized (this.mLock) {
            this.mLastAvailableAddressMap.clear();
            for (String str : this.mAddressMap.keySet()) {
                List<List<String>> list = this.mAddressMap.get(str);
                for (int i2 = 0; i2 < list.size(); i2++) {
                    List<String> list2 = list.get(i2);
                    Collections.shuffle(list2);
                    if (NetLog.isDebug()) {
                        String str2 = "[" + list2.get(0);
                        for (int i3 = 1; i3 < list2.size(); i3++) {
                            str2 = str2 + "," + list2.get(i3);
                        }
                        NetLog.d(TAG, "after reset(" + str + ") : " + str2 + "]");
                    }
                }
            }
        }
    }

    public boolean setAddressAvailable(String str, String str2, boolean z) {
        if (NetLog.isDebug()) {
            NetLog.d(TAG, "Save ACK DNS : domain(" + str + ") , address(" + str2 + "), " + z);
        }
        boolean z2 = false;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        synchronized (this.mLock) {
            List<List<String>> list = this.mAddressMap.get(str);
            if (!z) {
                String str3 = this.mLastAvailableAddressMap.get(str);
                if (str3 != null) {
                    if (!str2.equals(str3)) {
                        return false;
                    }
                    this.mLastAvailableAddressMap.remove(str);
                }
                if (list != null) {
                    boolean z3 = false;
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        List<String> list2 = list.get(i2);
                        if (list2 != null) {
                            for (int i3 = 0; i3 < list2.size(); i3++) {
                                if (str2.equals(list2.get(i3))) {
                                    list2.remove(i3);
                                    list2.add(str2);
                                    z3 = true;
                                }
                            }
                        }
                    }
                    z2 = z3;
                }
            } else if (list != null) {
                boolean z4 = false;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    List<String> list3 = list.get(i4);
                    if (list3 != null) {
                        for (int i5 = 0; i5 < list3.size(); i5++) {
                            if (str2.equals(list3.get(i5))) {
                                this.mLastAvailableAddressMap.put(str, str2);
                                z4 = true;
                            }
                        }
                    }
                }
                z2 = z4;
            }
            return z2;
        }
    }
}
