package com.kugou.common.network.netgate;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.kugou.common.network.AbsAckVars;
import com.kugou.common.network.netgate.AckServiceConfigEntity;
import com.kugou.common.network.networkutils.AckUtil;
import com.kugou.common.network.networkutils.NetLog;
import com.kugou.common.network.retry.HttpRetryManager;
import com.tme.fireeye.crash.crashmodule.jni.NativeCrashHandler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class AckManager {
    public static final String ACK_ADDRESS_TAG = "ACK_ADDRESS_TAG";
    private static final int MAX_FAIL_RETRY_COUNT = 3;
    private static final int MIN_RETRY_SECS = 600;
    public static final int SERVICE_ID_ACK = 10000;
    public static final int SERVICE_ID_ACK_DNS = 10001;
    public static final int SERVICE_ID_CHECKNAT = 70;
    public static final int SERVICE_ID_CHECK_NAT_STUN = 10008;
    public static final int SERVICE_ID_HASH_SERVICE = 18;
    public static final int SERVICE_ID_IDKEY = 55;
    public static final int SERVICE_ID_LONG_CONNECTION_DISASTER_ONE = 10018;
    public static final int SERVICE_ID_LONG_CONNECTION_DISASTER_TWO = 10019;
    public static final int SERVICE_ID_MOBILE_HASH_SERVICE = 10007;
    public static final int SERVICE_ID_MOBILE_ONLINE_SERVICE = 10006;
    public static final int SERVICE_ID_NETGATE = 108;
    public static final int SERVICE_ID_PROBE = 1000;
    public static final int SERVICE_ID_WEBSOCKET = 10005;
    public static final String SERVICE_TYPE_HOST = "Dynamic_Host";
    public static final String SERVICE_TYPE_PROTOCOL = "Protocol";
    private static final String TAG = "AckManager";
    private static volatile AckManager mAckManager;
    private static long mLastNetworkActiveMillies;
    private static volatile AbsAckVars sAckVars;
    private AckCacheManager mCacheManager;
    private String mCurNetworkName;
    private Handler mHandler;
    private HandlerThread mHandlerThread;
    private Map<String, Integer> mHostVersionMap;
    private int mLastArea;
    private int mLastIsp;
    private int[] mOldVersions;
    private Map<Integer, List<AckUpdateCallback>> mCallbackMap = new ConcurrentHashMap();
    private int[] mServiceIds = {108, 10000, SERVICE_ID_ACK_DNS, 18, 55, 70, SERVICE_ID_WEBSOCKET, 1000, SERVICE_ID_MOBILE_ONLINE_SERVICE, SERVICE_ID_MOBILE_HASH_SERVICE, SERVICE_ID_CHECK_NAT_STUN, SERVICE_ID_LONG_CONNECTION_DISASTER_ONE, SERVICE_ID_LONG_CONNECTION_DISASTER_TWO};
    private List<String> mServiceType = new ArrayList();
    private List<String> mAckServerList = new LinkedList();
    private int mConfigOption = 0;
    private boolean hasUpdate = false;
    private AckUpdateCallback mAckUpdateCallback = new AckUpdateCallback() { // from class: com.kugou.common.network.netgate.AckManager.1
        @Override // com.kugou.common.network.netgate.AckManager.AckUpdateCallback
        public void onUpdate(AckServiceConfigEntity ackServiceConfigEntity) {
            Message.obtain(AckManager.this.mHandler, 101, ackServiceConfigEntity).sendToTarget();
        }

        @Override // com.kugou.common.network.netgate.AckManager.AckUpdateCallback
        public void onUpdateHost(List<AckHostConfigEntity> list) {
        }
    };
    private Map<String, Long> mGetAckMilliesMap = new ConcurrentHashMap();
    private int mAckRetryFailCount = 0;
    private Integer mRetrySecsFromAck = null;
    private final BroadcastReceiver mNetworkReceiver = new BroadcastReceiver() { // from class: com.kugou.common.network.netgate.AckManager.2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                AckManager.this.mHandler.sendEmptyMessage(104);
            }
        }
    };

    public static class AckConfigEntity {
        public int area;
        public String data;
        public int errorCode;
        public int isp;
        public int status;
        public long time;
        public String urlHostMap;
    }

    public interface AckUpdateCallback {
        void onUpdate(AckServiceConfigEntity ackServiceConfigEntity);

        void onUpdateHost(List<AckHostConfigEntity> list);
    }

    public class AckUpdateExceptionStat {
        public static final int EID_REQUEST_SUCC = 1201112;
        public static final int EID_REQUEST_SUCC_UPDATE = 1201113;
        public static final int EID_REUQEST_FAIL = 1201111;
        public static final int OID = 111;

        public AckUpdateExceptionStat() {
        }
    }

    public interface BatchAckUpdateCallback {
        void onUpdate();
    }

    public static class ConfigOption {
        public static final int LOCAL = 0;
        public static final int NETWORK = 1;
    }

    public class WorkHandler extends Handler {
        private static final int MSG_CHECK_GET_ACK = 102;
        private static final int MSG_CONFIG_OPTION = 100;
        private static final int MSG_DO_GET_ACK = 103;
        private static final int MSG_NETWORK_CHANGE = 104;
        private static final int MSG_REGISTER_RECEIVER_AND_LISTENER = 105;
        private static final int MSG_UPDATE_SERVERS = 101;

        public WorkHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            List<AckServiceConfigEntity.AckAddressItem> list;
            int i2 = 0;
            switch (message.what) {
                case 100:
                    int i3 = message.arg1;
                    if (NetLog.isDebug()) {
                        NetLog.d(AckManager.TAG, "MSG_CONFIG_OPTION type=" + i3);
                    }
                    if (i3 == 0) {
                        AckManager.this.mConfigOption = i3;
                        removeMessages(102);
                        removeMessages(103);
                        break;
                    } else if (i3 == 1) {
                        AckManager.this.mConfigOption = i3;
                        AckManager.this.mAckServerList.clear();
                        AckManager.this.mAckServerList.add(AckManager.ACK_ADDRESS_TAG);
                        String backupAddress = AckManager.getAckVars().getBackupAddress();
                        String[] strArrSplit = TextUtils.isEmpty(backupAddress) ? null : backupAddress.split(",");
                        if (strArrSplit != null) {
                            Random random = new Random();
                            while (i2 < strArrSplit.length) {
                                int i4 = i2 + 1;
                                AckManager.this.mAckServerList.add(random.nextInt(i4) + 1, strArrSplit[i2]);
                                if (NetLog.isDebug()) {
                                    NetLog.e(AckManager.TAG, "add reserve addresses: " + strArrSplit[i2]);
                                }
                                i2 = i4;
                            }
                        }
                        AckManager ackManager = AckManager.this;
                        ackManager.registerCallback(10000, ackManager.mAckUpdateCallback);
                        sendEmptyMessageDelayed(102, NativeCrashHandler.NATIVE_RECORD_FILE_LOCK_EXPIRED_TIME);
                        break;
                    }
                    break;
                case 101:
                    AckServiceConfigEntity ackServiceConfigEntity = (AckServiceConfigEntity) message.obj;
                    if (ackServiceConfigEntity != null && ackServiceConfigEntity.list != null) {
                        AckManager.this.mAckServerList.clear();
                        for (AckServiceConfigEntity.AckListItem ackListItem : ackServiceConfigEntity.list) {
                            if (ackListItem != null && (list = ackListItem.address) != null) {
                                for (AckServiceConfigEntity.AckAddressItem ackAddressItem : list) {
                                    String str = ackAddressItem.host;
                                    int i5 = ackAddressItem.httpPort;
                                    if (i5 != 80 && i5 > 0) {
                                        str = str + ":" + ackAddressItem.httpPort;
                                    }
                                    AckManager.this.mAckServerList.add(str);
                                }
                            }
                        }
                    }
                    if (ackServiceConfigEntity != null) {
                        AckManager.this.mRetrySecsFromAck = Integer.valueOf(ackServiceConfigEntity.duration);
                    }
                    break;
                case 102:
                    long nextGetAckDelay = AckManager.this.getNextGetAckDelay();
                    if (nextGetAckDelay > 0) {
                        if (NetLog.isDebug()) {
                            NetLog.d(AckManager.TAG, "get ack too soon, wait for " + nextGetAckDelay);
                        }
                        removeMessages(102);
                        sendEmptyMessageDelayed(102, nextGetAckDelay);
                    } else {
                        sendEmptyMessage(103);
                    }
                    break;
                case 103:
                    AckManager ackManager2 = AckManager.this;
                    if (!ackManager2.requestAckData(ackManager2.mConfigOption == 1)) {
                        AckManager.access$608(AckManager.this);
                        if (AckManager.this.mAckRetryFailCount <= 3) {
                            sendEmptyMessageDelayed(103, 60000L);
                        }
                        if (AckManager.this.mAckServerList != null && AckManager.this.mAckServerList.size() > 0) {
                            AckManager.this.mAckServerList.remove(0);
                            break;
                        }
                    }
                    break;
                case 104:
                    String currentNetworkName = AckUtil.getCurrentNetworkName(AckManager.getAckVars().getContext());
                    if (!TextUtils.isEmpty(currentNetworkName) && !currentNetworkName.equals(AckManager.this.mCurNetworkName)) {
                        AckManager.this.mCurNetworkName = currentNetworkName;
                        int[] ispArea = AckManager.this.mCacheManager.getIspArea(AckManager.this.mCurNetworkName);
                        if (ispArea != null && ispArea.length == 2) {
                            AckManager.this.mLastIsp = ispArea[0];
                            AckManager.this.mLastArea = ispArea[1];
                        }
                        AckManager.this.mAckRetryFailCount = 0;
                        if (NetLog.isDebug()) {
                            NetLog.d(AckManager.TAG, "Network Changed , Current Network = " + AckManager.this.mCurNetworkName);
                        }
                        AckManager.this.onConfigUpdate();
                        AckEntity ackEntity = AckManager.this.mCacheManager.get(AckManager.this.mCurNetworkName, true);
                        List<AckServiceConfigEntity> list2 = ackEntity.data;
                        if (list2 != null && list2.size() > 0) {
                            AckManager ackManager3 = AckManager.this;
                            ackManager3.mOldVersions = ackManager3.mServiceIds != null ? new int[AckManager.this.mServiceIds.length] : null;
                            SparseIntArray sparseIntArray = new SparseIntArray();
                            for (AckServiceConfigEntity ackServiceConfigEntity2 : ackEntity.data) {
                                if (NetLog.isDebug()) {
                                    NetLog.d(AckManager.TAG, "Network Change to " + AckManager.this.mCurNetworkName + ", Cache service(" + ackServiceConfigEntity2.serviceId);
                                }
                                sparseIntArray.put(ackServiceConfigEntity2.serviceId, ackServiceConfigEntity2.version);
                                AckManager.this.notifyCallBack(ackServiceConfigEntity2.serviceId, ackServiceConfigEntity2);
                            }
                            while (i2 < AckManager.this.mServiceIds.length) {
                                AckManager.this.mOldVersions[i2] = sparseIntArray.get(AckManager.this.mServiceIds[i2]);
                                i2++;
                            }
                        }
                        List<AckHostConfigEntity> list3 = ackEntity.urlHostMap;
                        if (list3 != null && list3.size() > 0) {
                            AckManager.this.mHostVersionMap = ackEntity.getHostMapVersion();
                            if (NetLog.isDebug()) {
                                NetLog.d(AckManager.TAG, "Network Change to " + AckManager.this.mCurNetworkName + ", Cache service(" + AckManager.SERVICE_TYPE_HOST + ") , cache=" + ackEntity.urlHostMap.size());
                            }
                            AckManager.this.notifyCallBack(AckManager.SERVICE_TYPE_HOST, ackEntity.urlHostMap);
                            AckManager.this.notifyCallBack(AckManager.SERVICE_TYPE_PROTOCOL, ackEntity.urlHostMap);
                        }
                        if (AckManager.this.mConfigOption == 1) {
                            sendEmptyMessageDelayed(102, 2000L);
                            break;
                        }
                    }
                    break;
                case 105:
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                    AckManager.getAckVars().registerSysReceiver(AckManager.this.mNetworkReceiver, intentFilter);
                    break;
            }
        }
    }

    private AckManager() {
        this.mOldVersions = null;
        this.mLastIsp = -1;
        this.mLastArea = -1;
        AckCacheManager ackCacheManager = new AckCacheManager();
        this.mCacheManager = ackCacheManager;
        ackCacheManager.prepareCacheFile();
        HandlerThread handlerThread = new HandlerThread(TAG);
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        this.mHandler = new WorkHandler(this.mHandlerThread.getLooper());
        int[] iArr = this.mServiceIds;
        this.mOldVersions = iArr != null ? new int[iArr.length] : null;
        HashMap map = new HashMap();
        this.mHostVersionMap = map;
        this.mCacheManager.fetchServiceAndHostVersion(this.mServiceIds, this.mOldVersions, map, this.mCurNetworkName);
        int[] ispArea = this.mCacheManager.getIspArea(this.mCurNetworkName);
        if (ispArea != null && ispArea.length == 2) {
            this.mLastIsp = ispArea[0];
            this.mLastArea = ispArea[1];
        }
        if (getAckVars().isBgProcess()) {
            this.mHandler.sendEmptyMessage(105);
        }
    }

    public static /* synthetic */ int access$608(AckManager ackManager) {
        int i2 = ackManager.mAckRetryFailCount;
        ackManager.mAckRetryFailCount = i2 + 1;
        return i2;
    }

    private int getAckRetrySecsFromAck() {
        Integer num = this.mRetrySecsFromAck;
        if (num == null || num.intValue() <= 600) {
            return 600;
        }
        if (NetLog.isDebug()) {
            NetLog.d(TAG, "got retry secs from ack is 600");
        }
        return this.mRetrySecsFromAck.intValue();
    }

    private int getAckRetrySecsFromConfig() {
        int iIntValue;
        String retryTime = getAckVars().getRetryTime();
        if (TextUtils.isEmpty(retryTime)) {
            iIntValue = 3600;
        } else {
            try {
                iIntValue = Integer.valueOf(retryTime).intValue();
            } catch (Exception e2) {
                NetLog.uploadException(e2);
                iIntValue = 3600;
            }
        }
        if (NetLog.isDebug()) {
            NetLog.d(TAG, "got retry secs from config is " + iIntValue);
        }
        return iIntValue;
    }

    public static synchronized AbsAckVars getAckVars() {
        if (sAckVars == null) {
            try {
                sAckVars = (AbsAckVars) Class.forName("com.kugou.common.network.KGACKVariables").newInstance();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return sAckVars;
    }

    public static AckManager getInstance() {
        if (mAckManager == null) {
            synchronized (AckManager.class) {
                if (mAckManager == null) {
                    mAckManager = new AckManager();
                }
            }
        }
        return mAckManager;
    }

    private long getLastGetAckMillies() {
        Long l = this.mGetAckMilliesMap.get("" + this.mCurNetworkName);
        if (l != null) {
            return l.longValue();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getNextGetAckDelay() {
        long lastGetAckMillies = getLastGetAckMillies();
        if (lastGetAckMillies <= 0) {
            return 0L;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - lastGetAckMillies;
        long ackRetrySecsFromAck = getAckRetrySecsFromAck() * 1000;
        if (jCurrentTimeMillis <= 0 || ackRetrySecsFromAck <= 0 || jCurrentTimeMillis >= ackRetrySecsFromAck) {
            return 0L;
        }
        return 1000 + (ackRetrySecsFromAck - jCurrentTimeMillis);
    }

    private boolean isAckForbidden() {
        return getAckRetrySecsFromConfig() <= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyCallBack(String str, List<AckHostConfigEntity> list) {
        synchronized (this.mCallbackMap) {
            if (NetLog.isDebug()) {
                NetLog.d(TAG, "Service " + str + " Changed, on " + this.mCurNetworkName);
            }
            List<AckUpdateCallback> list2 = this.mCallbackMap.get(Integer.valueOf(str.hashCode()));
            if (list2 != null) {
                Iterator<AckUpdateCallback> it = list2.iterator();
                while (it.hasNext()) {
                    it.next().onUpdateHost(list);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onConfigUpdate() {
        HttpRetryManager.getInstance().reset();
    }

    public static synchronized void preInit(AbsAckVars absAckVars) {
        sAckVars = absAckVars;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0263 A[Catch: all -> 0x02bb, LOOP:3: B:121:0x0261->B:122:0x0263, LOOP_END, TryCatch #5 {all -> 0x02bb, blocks: (B:120:0x025c, B:122:0x0263, B:123:0x027f, B:124:0x0286, B:126:0x028b, B:128:0x0292, B:130:0x02a0, B:133:0x02ab, B:131:0x02a7, B:134:0x02b5), top: B:185:0x025c }] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x028b A[Catch: all -> 0x02bb, TryCatch #5 {all -> 0x02bb, blocks: (B:120:0x025c, B:122:0x0263, B:123:0x027f, B:124:0x0286, B:126:0x028b, B:128:0x0292, B:130:0x02a0, B:133:0x02ab, B:131:0x02a7, B:134:0x02b5), top: B:185:0x025c }] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0348  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x02ce A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean requestAckData(boolean r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 866
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kugou.common.network.netgate.AckManager.requestAckData(boolean):boolean");
    }

    private void updateGetAckMillies() {
        this.mGetAckMilliesMap.put("" + this.mCurNetworkName, Long.valueOf(System.currentTimeMillis()));
    }

    public void forceUpdate() {
        this.mHandler.sendEmptyMessage(102);
    }

    public AckUpdateStatEntity getAckStatEntity() {
        return new AckUpdateStatEntity(this.mLastIsp, this.mLastArea, 0, 0, SystemClock.elapsedRealtime() - getAckVars().getStartTime(), NetgateManager.getInstance().getAckStat(), AckDnsManager.getInstance().getAckStat(), AckHostManager.getInstance().getAckStat());
    }

    public AckServiceConfigEntity getConfig(int i2) {
        return this.mCacheManager.getCache(i2, this.mCurNetworkName, true);
    }

    public int[] getIspArea(String str) {
        return this.mCacheManager.getIspArea(str);
    }

    public void registerAckDnsCallback(AckUpdateCallback ackUpdateCallback) {
        registerCallback(SERVICE_ID_ACK_DNS, ackUpdateCallback);
    }

    public void registerAckProbeCallback(AckUpdateCallback ackUpdateCallback) {
        registerCallback(1000, ackUpdateCallback);
    }

    public void registerBatchServiceCallback(int[] iArr, AckUpdateCallback ackUpdateCallback) {
        for (int i2 : iArr) {
            registerCallback(i2, ackUpdateCallback);
        }
    }

    public void registerCallback(String str, AckUpdateCallback ackUpdateCallback) {
        if (TextUtils.isEmpty(str) || ackUpdateCallback == null) {
            return;
        }
        synchronized (this.mCallbackMap) {
            boolean z = false;
            for (int i2 = 0; i2 < this.mServiceType.size(); i2++) {
                if (str.equals(this.mServiceType.get(i2))) {
                    z = true;
                }
            }
            if (!z) {
                this.mServiceType.add(str);
            }
            List<AckUpdateCallback> arrayList = this.mCallbackMap.get(Integer.valueOf(str.hashCode()));
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.mCallbackMap.put(Integer.valueOf(str.hashCode()), arrayList);
            }
            if (!arrayList.contains(ackUpdateCallback)) {
                arrayList.add(ackUpdateCallback);
            }
            List<AckHostConfigEntity> allHostConfigCache = this.mCacheManager.getAllHostConfigCache(this.mCurNetworkName, true);
            if (allHostConfigCache.size() > 0) {
                notifyCallBack(str, allHostConfigCache);
            }
            if (!z) {
                this.mHandler.sendEmptyMessage(103);
            }
        }
    }

    public void registerDynamicHostCallback(AckUpdateCallback ackUpdateCallback) {
        registerCallback(SERVICE_TYPE_HOST, ackUpdateCallback);
    }

    public void registerLongConnectionCallback(int[] iArr, AckUpdateCallback ackUpdateCallback) {
        for (int i2 : iArr) {
            registerCallback(i2, ackUpdateCallback);
        }
    }

    public void registerNetgateCallback(AckUpdateCallback ackUpdateCallback) {
        registerCallback(108, ackUpdateCallback);
    }

    public void registerProtocolCallback(AckUpdateCallback ackUpdateCallback) {
        registerCallback(SERVICE_TYPE_PROTOCOL, ackUpdateCallback);
    }

    public void registerWebsocketCallback(AckUpdateCallback ackUpdateCallback) {
        registerCallback(SERVICE_ID_WEBSOCKET, ackUpdateCallback);
    }

    public void setLastNetworkdActiveMillies(long j) {
        mLastNetworkActiveMillies = j;
        this.mHandler.sendEmptyMessage(102);
    }

    public void startRequest() {
        Message.obtain(this.mHandler, 100, 1, 0).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyCallBack(int i2, AckServiceConfigEntity ackServiceConfigEntity) {
        synchronized (this.mCallbackMap) {
            if (NetLog.isDebug()) {
                NetLog.d(TAG, "Service " + i2 + " Changed, on " + this.mCurNetworkName);
            }
            List<AckUpdateCallback> list = this.mCallbackMap.get(Integer.valueOf(i2));
            if (list != null) {
                Iterator<AckUpdateCallback> it = list.iterator();
                while (it.hasNext()) {
                    it.next().onUpdate(ackServiceConfigEntity);
                }
            }
        }
    }

    public void registerCallback(int i2, AckUpdateCallback ackUpdateCallback) {
        int[] iArr;
        if (i2 <= 0 || ackUpdateCallback == null || this.mOldVersions == null) {
            return;
        }
        synchronized (this.mCallbackMap) {
            int i3 = 0;
            boolean z = false;
            while (true) {
                iArr = this.mServiceIds;
                if (i3 >= iArr.length) {
                    break;
                }
                if (i2 == iArr[i3]) {
                    z = true;
                }
                i3++;
            }
            if (!z) {
                int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length + 1);
                this.mServiceIds = iArrCopyOf;
                iArrCopyOf[iArrCopyOf.length - 1] = i2;
                int[] iArr2 = this.mOldVersions;
                int[] iArrCopyOf2 = Arrays.copyOf(iArr2, iArr2.length + 1);
                this.mOldVersions = iArrCopyOf2;
                iArrCopyOf2[iArrCopyOf2.length - 1] = 1;
            }
            List<AckUpdateCallback> arrayList = this.mCallbackMap.get(Integer.valueOf(i2));
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.mCallbackMap.put(Integer.valueOf(i2), arrayList);
            }
            if (!arrayList.contains(ackUpdateCallback)) {
                arrayList.add(ackUpdateCallback);
            }
            notifyCallBack(i2, this.mCacheManager.getCache(i2, this.mCurNetworkName, true));
            if (!z) {
                this.mHandler.sendEmptyMessage(103);
            }
        }
    }
}
