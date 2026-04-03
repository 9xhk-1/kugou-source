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
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class NetgateManager {
    private static final String ALIAS_HOST = "mobileservice.k.com";
    private static final String ORI_HOST = "mobileservice.kugou.com";
    private static final String TAG = "NetgateManager";
    private static AckManager mAckManager;
    private static volatile NetgateManager mNetgateManager;
    private String mLastAvailableNetgate;
    private volatile int version;
    private List<List<String>> mNetgateList = new ArrayList();
    private Object mListLock = new Object();
    private Map<String, String> mAliasHostMap = new ConcurrentHashMap();

    private NetgateManager() {
        AckManager ackManager = AckManager.getInstance();
        mAckManager = ackManager;
        ackManager.registerNetgateCallback(new AckManager.AckUpdateCallback() { // from class: com.kugou.common.network.netgate.NetgateManager.1
            @Override // com.kugou.common.network.netgate.AckManager.AckUpdateCallback
            public void onUpdate(AckServiceConfigEntity ackServiceConfigEntity) {
                synchronized (NetgateManager.this.mListLock) {
                    if (ackServiceConfigEntity != null) {
                        if (ackServiceConfigEntity.list != null && ackServiceConfigEntity.domains != null) {
                            NetgateManager.this.mNetgateList.clear();
                            NetgateManager.this.mAliasHostMap.clear();
                            for (AckServiceConfigEntity.AckListItem ackListItem : ackServiceConfigEntity.list) {
                                if (ackListItem != null) {
                                    if (ackListItem.address != null) {
                                        ArrayList arrayList = new ArrayList();
                                        for (AckServiceConfigEntity.AckAddressItem ackAddressItem : ackListItem.address) {
                                            if (ackAddressItem != null) {
                                                String str = ackAddressItem.host;
                                                int i2 = ackAddressItem.httpPort;
                                                if (i2 != 80 && i2 > 0) {
                                                    str = str + ":" + ackAddressItem.httpPort;
                                                }
                                                arrayList.add(str);
                                            }
                                        }
                                        if (arrayList.size() > 0) {
                                            NetgateManager.this.mNetgateList.add(arrayList);
                                        }
                                    }
                                    if (ackListItem.backupAddress != null) {
                                        for (int i3 = 0; i3 < ackListItem.backupAddress.size(); i3++) {
                                            List<AckServiceConfigEntity.AckAddressItem> list = ackListItem.backupAddress.get(i3);
                                            ArrayList arrayList2 = new ArrayList();
                                            for (int i4 = 0; i4 < list.size(); i4++) {
                                                AckServiceConfigEntity.AckAddressItem ackAddressItem2 = list.get(i4);
                                                if (ackAddressItem2 != null) {
                                                    String str2 = ackAddressItem2.host;
                                                    int i5 = ackAddressItem2.httpPort;
                                                    if (i5 != 80 && i5 > 0) {
                                                        str2 = str2 + ":" + ackAddressItem2.httpPort;
                                                    }
                                                    arrayList2.add(str2);
                                                }
                                            }
                                            if (arrayList2.size() > 0) {
                                                NetgateManager.this.mNetgateList.add(arrayList2);
                                            }
                                        }
                                    }
                                }
                            }
                            for (AckServiceConfigEntity.AckDomainItem ackDomainItem : ackServiceConfigEntity.domains) {
                                String lowerCase = ackDomainItem.oriHost;
                                if (lowerCase != null) {
                                    lowerCase = lowerCase.toLowerCase();
                                }
                                String lowerCase2 = ackDomainItem.aliasHost;
                                if (lowerCase2 != null) {
                                    lowerCase2 = lowerCase2.toLowerCase();
                                }
                                NetgateManager.this.mAliasHostMap.put(lowerCase, lowerCase2);
                            }
                            NetgateManager.this.version = ackServiceConfigEntity.version;
                            if (NetLog.isDebug()) {
                                NetLog.e("BLUE", "NetgateManger got ack data: " + NetgateManager.this.mNetgateList + ", " + NetgateManager.this.mAliasHostMap);
                            }
                        }
                    }
                }
                NetgateManager.this.reset();
            }

            @Override // com.kugou.common.network.netgate.AckManager.AckUpdateCallback
            public void onUpdateHost(List<AckHostConfigEntity> list) {
            }
        });
    }

    public static NetgateManager getInstance() {
        if (mNetgateManager == null) {
            synchronized (NetgateManager.class) {
                if (mNetgateManager == null) {
                    mNetgateManager = new NetgateManager();
                }
            }
        }
        return mNetgateManager;
    }

    public AckUpdateStatEntity.NetgateUpdateStatEntity getAckStat() {
        AckUpdateStatEntity.NetgateUpdateStatEntity netgateUpdateStatEntity;
        synchronized (this.mListLock) {
            netgateUpdateStatEntity = new AckUpdateStatEntity.NetgateUpdateStatEntity(this.version, 0, Collections.unmodifiableMap(new HashMap(this.mAliasHostMap)), this.mNetgateList.size() > 0 ? this.mNetgateList.get(0).get(0) : "");
        }
        return netgateUpdateStatEntity;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<com.kugou.common.network.netgate.NetgateEntity> getNetgate(java.lang.String r10) throws java.lang.Throwable {
        /*
            r9 = this;
            r0 = 0
            java.net.URI r1 = new java.net.URI     // Catch: java.net.URISyntaxException -> L96
            r1.<init>(r10)     // Catch: java.net.URISyntaxException -> L96
            java.lang.String r2 = r1.getScheme()     // Catch: java.net.URISyntaxException -> L96
            java.lang.String r1 = r1.getHost()     // Catch: java.net.URISyntaxException -> L96
            if (r1 == 0) goto L14
            java.lang.String r1 = r1.toLowerCase()     // Catch: java.net.URISyntaxException -> L96
        L14:
            java.lang.Object r3 = r9.mListLock     // Catch: java.net.URISyntaxException -> L96
            monitor-enter(r3)     // Catch: java.net.URISyntaxException -> L96
            java.lang.String r4 = "https"
            boolean r2 = r4.equalsIgnoreCase(r2)     // Catch: java.lang.Throwable -> L8e
            if (r2 != 0) goto L8b
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L8e
            if (r2 != 0) goto L8b
            java.util.Map<java.lang.String, java.lang.String> r2 = r9.mAliasHostMap     // Catch: java.lang.Throwable -> L8e
            boolean r2 = r2.containsKey(r1)     // Catch: java.lang.Throwable -> L8e
            if (r2 == 0) goto L8b
            java.util.Map<java.lang.String, java.lang.String> r2 = r9.mAliasHostMap     // Catch: java.lang.Throwable -> L8e
            java.lang.Object r2 = r2.get(r1)     // Catch: java.lang.Throwable -> L8e
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> L8e
            boolean r4 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L8e
            if (r4 != 0) goto L8b
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L8e
            r4.<init>()     // Catch: java.lang.Throwable -> L8e
            java.lang.String r5 = r9.mLastAvailableNetgate     // Catch: java.lang.Throwable -> L94
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L94
            if (r5 != 0) goto L52
            com.kugou.common.network.netgate.NetgateEntity r5 = new com.kugou.common.network.netgate.NetgateEntity     // Catch: java.lang.Throwable -> L94
            java.lang.String r6 = r9.mLastAvailableNetgate     // Catch: java.lang.Throwable -> L94
            r5.<init>(r6, r10, r1, r2)     // Catch: java.lang.Throwable -> L94
            r4.add(r5)     // Catch: java.lang.Throwable -> L94
        L52:
            r5 = 0
            r6 = 0
        L54:
            java.util.List<java.util.List<java.lang.String>> r7 = r9.mNetgateList     // Catch: java.lang.Throwable -> L94
            int r7 = r7.size()     // Catch: java.lang.Throwable -> L94
            if (r6 >= r7) goto L8c
            java.util.List<java.util.List<java.lang.String>> r7 = r9.mNetgateList     // Catch: java.lang.Throwable -> L94
            java.lang.Object r7 = r7.get(r6)     // Catch: java.lang.Throwable -> L94
            java.util.List r7 = (java.util.List) r7     // Catch: java.lang.Throwable -> L94
            if (r7 == 0) goto L88
            int r8 = r7.size()     // Catch: java.lang.Throwable -> L94
            if (r8 <= 0) goto L88
            java.lang.Object r7 = r7.get(r5)     // Catch: java.lang.Throwable -> L94
            java.lang.String r7 = (java.lang.String) r7     // Catch: java.lang.Throwable -> L94
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Throwable -> L94
            if (r8 != 0) goto L88
            java.lang.String r8 = r9.mLastAvailableNetgate     // Catch: java.lang.Throwable -> L94
            boolean r8 = r7.equals(r8)     // Catch: java.lang.Throwable -> L94
            if (r8 != 0) goto L88
            com.kugou.common.network.netgate.NetgateEntity r8 = new com.kugou.common.network.netgate.NetgateEntity     // Catch: java.lang.Throwable -> L94
            r8.<init>(r7, r10, r1, r2)     // Catch: java.lang.Throwable -> L94
            r4.add(r8)     // Catch: java.lang.Throwable -> L94
        L88:
            int r6 = r6 + 1
            goto L54
        L8b:
            r4 = r0
        L8c:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L94
            goto L9b
        L8e:
            r10 = move-exception
            r4 = r0
        L90:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L94
            throw r10     // Catch: java.net.URISyntaxException -> L92
        L92:
            r10 = move-exception
            goto L98
        L94:
            r10 = move-exception
            goto L90
        L96:
            r10 = move-exception
            r4 = r0
        L98:
            com.kugou.common.network.networkutils.NetLog.uploadException(r10)
        L9b:
            boolean r10 = com.kugou.common.network.networkutils.NetLog.isDebug()
            if (r10 == 0) goto Lc6
            java.lang.String r10 = "NetgateManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "get Netate List("
            r1.append(r2)
            if (r4 == 0) goto Lb7
            int r0 = r4.size()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
        Lb7:
            r1.append(r0)
            java.lang.String r0 = ")"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.kugou.common.network.networkutils.NetLog.d(r10, r0)
        Lc6:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kugou.common.network.netgate.NetgateManager.getNetgate(java.lang.String):java.util.List");
    }

    public void reset() {
        if (NetLog.isDebug()) {
            NetLog.d(TAG, "start reset");
        }
        synchronized (this.mListLock) {
            this.mLastAvailableNetgate = null;
            for (int i2 = 0; i2 < this.mNetgateList.size(); i2++) {
                List<String> list = this.mNetgateList.get(i2);
                Collections.shuffle(list);
                String str = "[" + list.get(0);
                for (int i3 = 1; i3 < list.size(); i3++) {
                    str = str + "," + list.get(i3);
                }
                if (NetLog.isDebug()) {
                    NetLog.d(TAG, "after reset(Netgate) : " + str + "]");
                }
            }
        }
    }

    public boolean setNetgateAvailable(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.mListLock) {
                if (z) {
                    for (int i2 = 0; i2 < this.mNetgateList.size(); i2++) {
                        List<String> list = this.mNetgateList.get(i2);
                        if (list != null) {
                            for (int i3 = 0; i3 < list.size(); i3++) {
                                if (str.equals(list.get(i3))) {
                                    this.mLastAvailableNetgate = str;
                                    return true;
                                }
                            }
                        }
                    }
                } else {
                    String str2 = this.mLastAvailableNetgate;
                    if (str2 != null) {
                        if (!str.equals(str2)) {
                            return false;
                        }
                        this.mLastAvailableNetgate = null;
                    }
                    for (int i4 = 0; i4 < this.mNetgateList.size(); i4++) {
                        List<String> list2 = this.mNetgateList.get(i4);
                        if (list2 != null) {
                            for (int i5 = 0; i5 < list2.size(); i5++) {
                                if (str.equals(list2.get(i5))) {
                                    list2.remove(i5);
                                    list2.add(str);
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
