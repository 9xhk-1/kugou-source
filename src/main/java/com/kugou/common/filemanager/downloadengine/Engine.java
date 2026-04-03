package com.kugou.common.filemanager.downloadengine;

import android.support.annotation.IntRange;
import android.text.TextUtils;
import com.kugou.common.filemanager.downloadengine.entity.CustomProxy;
import com.kugou.common.filemanager.downloadengine.entity.ID3Data;
import com.kugou.common.filemanager.downloadengine.entity.ResourceInfo;
import com.kugou.common.filemanager.downloadengine.entity.SeedResponseInfo;
import com.kugou.common.filemanager.downloadengine.share.ShareResourceCallback;
import com.kugou.common.filemanager.downloadengine.stat.IP2PStatEvent;
import com.kugou.common.filemanager.downloadengine.stat.NatProxyClientStat;
import com.kugou.common.filemanager.downloadengine.stat.NatProxyServeStat;
import com.kugou.common.filemanager.downloadengine.stat.OnlineStat;
import com.kugou.common.filemanager.downloadengine.stat.RefreshStat;
import com.kugou.common.filemanager.downloadengine.stat.UploaderStat;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes2.dex */
public class Engine {
    private CallbackFormatID3 callbackFormatID3;
    private IFileTransform fileTransformCallback;
    public IKggKeyQueryCallback kggKeyQueryCallback;
    public ID3Fetcher mID3Fetcher;
    private INetFlowCallback netFlowCallback;
    private ISeedCallback seedCallback;
    private ThreadPoolExecutor threadPool;
    public ID3Setter mID3Setter = new ID3Setter() { // from class: com.kugou.common.filemanager.downloadengine.Engine.1
        @Override // com.kugou.common.filemanager.downloadengine.ID3Setter
        public void returnID3Data(String str, int i2, ID3Data iD3Data) {
            try {
                Engine.this.returnFetchID3Data(str, i2, iD3Data);
            } catch (UnsatisfiedLinkError unused) {
            }
        }
    };
    public IWriteMediaStoreCallback writeMediaStoreCallback = null;
    private IPlayBufferQuery playBufferQuery = null;
    private IUnicomProxy unicomProxy = null;
    private IDownloadCallback downloadCallback = null;
    private ICheckNatCallback checkNatCallback = null;
    private ShareResourceCallback reportCallback = null;
    private IP2PStatEvent p2pStatCallback = null;
    private IAckCallback ackCallback = null;

    public interface CallbackFormatID3 {
        void fetchID3(String str, int i2, String str2, long j, ID3Setter iD3Setter);

        int formatID3(String[] strArr, String str, String str2, String str3, byte[] bArr);
    }

    public interface CardInfo {
        long getAvailableSize();

        long getMVMaxCacheSize();

        String getRoot();

        long getTotalSize();
    }

    public interface ICheckNatCallback {
        void onCheckNatFailed(boolean z);

        void onCheckNatResult(boolean z, String str, int i2, int i3);
    }

    public interface IDownloadCallback {
        void OnSaveLastFlowInfo(String str);

        CardInfo getCardInfo();

        String getTaskQuality(String str);

        boolean isEncryptedFile(String str);

        boolean isRealEncryptedFile(String str);

        boolean loadDownloadLibrary();

        void onCachedEncryptKeyChanged(String str);

        void onDownloadStateChanged(String str, DownloadStateInfo downloadStateInfo);

        void onDownloadStatus(String str, DownloadStatusInfo downloadStatusInfo);

        void onLogEvents(String str, String str2, boolean z);

        void onPeerID6Changed(long j);

        void onPeerIDChanged(long j);
    }

    public interface IKggKeyQueryCallback {
        String query(long j, String str, String str2);
    }

    public interface INetFlowCallback {
        void onReportNetFlow(long j, long j2, String str, String[] strArr);
    }

    public interface IUnicomProxy {
        void getCustomProxy(String str, CustomProxy customProxy);

        void getCustomProxyWithSocks(String str, CustomProxy customProxy);

        void invalidUnicomProxy(int i2);
    }

    public interface IWriteMediaStoreCallback {
        Object createFile(String str);

        void deleteFile(Object obj);

        void releaseOutputStream(Object obj);

        void writeBuffer(Object obj, byte[] bArr);
    }

    public Engine(ThreadPoolExecutor threadPoolExecutor) {
        this.threadPool = null;
        this.threadPool = threadPoolExecutor;
    }

    private Object callbackCreateMediaStoreFile(String str) {
        return doCreateMediaStoreFile(str);
    }

    private Object callbackFactory(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.equals("DownloadStateInfo")) {
            return new DownloadStateInfo();
        }
        if (str.equals("DownloadStatusInfo")) {
            return new DownloadStatusInfo();
        }
        if (str.equals("CustomProxy")) {
            return new CustomProxy();
        }
        if (str.equals("ResourceInfo")) {
            return new ResourceInfo();
        }
        if (str.equals("OnlineStat")) {
            return new OnlineStat();
        }
        if (str.equals("RefreshStat")) {
            return new RefreshStat();
        }
        if (str.equals("UploaderStat")) {
            return new UploaderStat();
        }
        if (str.equals("NatProxyClientStat")) {
            return new NatProxyClientStat();
        }
        if (str.equals("NatProxyServeStat")) {
            return new NatProxyServeStat();
        }
        if (str.equals("SeedResponseInfo")) {
            return new SeedResponseInfo();
        }
        return null;
    }

    private void callbackFetchID3(String str, int i2, String str2, long j) {
        doCallbackFetchID3(str, i2, str2, j);
    }

    private void callbackFlowStat(long j, long j2, String str, String[] strArr) {
        doCallbackFlowStat(j, j2, str, strArr);
    }

    private void callbackFlushMediaStoreFile(Object obj) {
        doFlushMediaStoreFile(obj);
    }

    private int callbackFormatID3(String[] strArr, String str, String str2, String str3, byte[] bArr) {
        return doFormatID3(strArr, str, str2, str3, bArr);
    }

    private void callbackGetCustomProxy(String str, Object obj) {
        getCustomProxy(str, obj);
    }

    private void callbackGetCustomProxyWithSocks(String str, Object obj) {
        getCustomProxyWithSocks(str, obj);
    }

    private void callbackLogEvents(String str, String str2, boolean z) {
        pCallbackLogEvents(str, str2, z);
    }

    private void callbackMarkUrlResult(String str, boolean z) {
        if (NetLog.isDebug()) {
            NetLog.d("Engine", "Engine got ack dns MarkUrlResult url " + str + " succ " + z);
        }
        IAckCallback iAckCallback = this.ackCallback;
        if (iAckCallback != null) {
            iAckCallback.markUrlResult(str, z);
        }
    }

    private String callbackMixKeyIDQuery(@IntRange(from = 0) long j, String str, String str2) {
        return doCallbackKggKeyQuery(j, str, str2);
    }

    private void callbackNatProxyClientStatEvent(Object obj) {
        pCallbackNatProxyClientStatEvent(obj);
    }

    private void callbackNatProxyServeStatEvent(Object obj) {
        pCallbackNatProxyServeStatEvent(obj);
    }

    private void callbackOnCheckNat6Failed() {
        if (NetLog.isDebug()) {
            NetLog.e("BLUE", "Engine got checknat fail callback");
        }
        ICheckNatCallback iCheckNatCallback = this.checkNatCallback;
        if (iCheckNatCallback != null) {
            iCheckNatCallback.onCheckNatFailed(true);
        }
    }

    private void callbackOnCheckNat6Result(String str, int i2, int i3) {
        if (NetLog.isDebug()) {
            NetLog.e("BLUE", "Engine got checknat result " + str + ", " + i2 + ", " + i3);
        }
        ICheckNatCallback iCheckNatCallback = this.checkNatCallback;
        if (iCheckNatCallback != null) {
            iCheckNatCallback.onCheckNatResult(true, str, i2, i3);
        }
    }

    private void callbackOnCheckNatFailed() {
        if (NetLog.isDebug()) {
            NetLog.e("BLUE", "Engine got checknat fail callback");
        }
        ICheckNatCallback iCheckNatCallback = this.checkNatCallback;
        if (iCheckNatCallback != null) {
            iCheckNatCallback.onCheckNatFailed(false);
        }
    }

    private void callbackOnCheckNatResult(String str, int i2, int i3) {
        if (NetLog.isDebug()) {
            NetLog.e("BLUE", "Engine got checknat result " + str + ", " + i2 + ", " + i3);
        }
        ICheckNatCallback iCheckNatCallback = this.checkNatCallback;
        if (iCheckNatCallback != null) {
            iCheckNatCallback.onCheckNatResult(false, str, i2, i3);
        }
    }

    private void callbackOnDownloadStateChanged(String str, Object obj) {
        pOnDownloadStateChanged(str, obj);
    }

    private void callbackOnDownloadStatus(String str, Object obj) {
        pOnDownloadStatus(str, obj);
    }

    private Object callbackOnLocateHash(String str) {
        return pCallbackOnLocateHash(str, false);
    }

    private Object callbackOnLocateHash6(String str) {
        return pCallbackOnLocateHash(str, true);
    }

    private void callbackOnPeerID6Changed(long j) {
        pCallbackOnPeerID6Changed(j);
    }

    private void callbackOnPeerIDChanged(long j) {
        pCallbackOnPeerIDChanged(j);
    }

    private void callbackOnSeedResponse(Object obj) {
        doSeedResponse(obj);
    }

    private boolean callbackOnStartTransform(@IntRange(from = Long.MIN_VALUE) long j, String str, String str2) {
        return doCallbackOnStartTransform(j, str, str2);
    }

    private void callbackOnStopTransform(String str, String str2) {
        doCallbackOnStopTransform(str, str2);
    }

    private void callbackOnTempCacheID(String str) {
        pSaveCachedEncryptKey(str);
    }

    private void callbackOnUploadSessionChanged(boolean z, int i2) {
        pCallbackOnUploadSessionChanged(z, i2);
    }

    private void callbackOnlineStatEvent(Object obj) {
        IP2PStatEvent iP2PStatEvent;
        if (!(obj instanceof OnlineStat) || (iP2PStatEvent = this.p2pStatCallback) == null) {
            return;
        }
        iP2PStatEvent.OnOnlineStatEvent((OnlineStat) obj);
    }

    private Object callbackQueryPlayBuffer(String str) {
        return queryPlayBuffer(str);
    }

    private void callbackRefreshStatEvent(Object obj) {
        pCallbackRefreshStatEvent(obj);
    }

    private void callbackRefreshUnicomProxy(int i2) {
        refreshUnicomProxy(i2);
    }

    private void callbackSaveLastFlowInfo(String str) {
        pCallbackSaveLastFlowInfo(str);
    }

    private void callbackSetAckDnsAddressAvailable(String str, String str2, boolean z) {
        String host;
        IAckCallback iAckCallback;
        if (TextUtils.isEmpty(str)) {
            host = null;
        } else {
            try {
                host = new URL(str).getHost();
            } catch (MalformedURLException e2) {
                NetLog.uploadException(e2);
                host = null;
            }
        }
        if (str2.endsWith(":80")) {
            str2 = str2.replace(":80", "");
        }
        if (NetLog.isDebug()) {
            NetLog.d("Engine", "Engine got ack dns SetAckDnsAddressAvailable domain " + host + " address " + str2 + " succ " + z);
        }
        if (TextUtils.isEmpty(host) || TextUtils.isEmpty(str2) || (iAckCallback = this.ackCallback) == null) {
            return;
        }
        iAckCallback.setAckDnsAddressAvailable(host, str2, z);
    }

    private void callbackSourceCount(Object[] objArr) {
        pCallbackResourceInfo(objArr, false);
    }

    private void callbackSourceCount6(Object[] objArr) {
        pCallbackResourceInfo(objArr, true);
    }

    private void callbackUnlinkMediaStoreFile(Object obj) {
        doUnlinkMediaStoreFile(obj);
    }

    private void callbackUploaderStatEvent(Object obj) {
        pCallbackUploaderStatEvent(obj);
    }

    private void callbackWriteMediaStoreBuffer(Object obj, byte[] bArr) {
        doWriteMediaStoreBuffer(obj, bArr);
    }

    private void doCallbackFetchID3(String str, int i2, String str2, long j) {
        ID3Fetcher iD3Fetcher = this.mID3Fetcher;
        if (iD3Fetcher != null) {
            iD3Fetcher.fetchID3(str, i2, str2, j, this.mID3Setter);
        }
    }

    private void doCallbackFlowStat(long j, long j2, String str, String[] strArr) {
        INetFlowCallback iNetFlowCallback = this.netFlowCallback;
        if (iNetFlowCallback != null) {
            iNetFlowCallback.onReportNetFlow(j, j2, str, strArr);
        }
    }

    private String doCallbackKggKeyQuery(@IntRange(from = 0) long j, String str, String str2) {
        IKggKeyQueryCallback iKggKeyQueryCallback = this.kggKeyQueryCallback;
        if (iKggKeyQueryCallback != null) {
            return iKggKeyQueryCallback.query(j, str, str2);
        }
        return null;
    }

    private boolean doCallbackOnStartTransform(@IntRange(from = Long.MIN_VALUE) long j, String str, String str2) {
        IFileTransform iFileTransform = this.fileTransformCallback;
        if (iFileTransform != null) {
            return iFileTransform.onStartTransform(j, str, str2);
        }
        return false;
    }

    private void doCallbackOnStopTransform(String str, String str2) {
        IFileTransform iFileTransform = this.fileTransformCallback;
        if (iFileTransform != null) {
            iFileTransform.onStopTransform(str, str2);
        }
    }

    private Object doCreateMediaStoreFile(String str) {
        IWriteMediaStoreCallback iWriteMediaStoreCallback = this.writeMediaStoreCallback;
        if (iWriteMediaStoreCallback != null) {
            return iWriteMediaStoreCallback.createFile(str);
        }
        return null;
    }

    private void doFlushMediaStoreFile(Object obj) {
        IWriteMediaStoreCallback iWriteMediaStoreCallback = this.writeMediaStoreCallback;
        if (iWriteMediaStoreCallback != null) {
            iWriteMediaStoreCallback.releaseOutputStream(obj);
        }
    }

    private int doFormatID3(String[] strArr, String str, String str2, String str3, byte[] bArr) {
        CallbackFormatID3 callbackFormatID3 = this.callbackFormatID3;
        if (callbackFormatID3 == null) {
            if (strArr != null && strArr.length > 0) {
                strArr[0] = "callback not set";
            }
            return -1;
        }
        int id3 = callbackFormatID3.formatID3(strArr, str, str2, str3, bArr);
        NetLog.d("formatID3(```" + str3 + "```) return " + id3 + "/" + ((strArr == null || TextUtils.isEmpty(strArr[0])) ? "unknown reason" : strArr[0]));
        return id3;
    }

    private void doSeedResponse(Object obj) {
        ISeedCallback iSeedCallback;
        if (obj == null || !(obj instanceof SeedResponseInfo) || (iSeedCallback = this.seedCallback) == null) {
            return;
        }
        iSeedCallback.onSeedResponse((SeedResponseInfo) obj);
    }

    private void doUnlinkMediaStoreFile(Object obj) {
        IWriteMediaStoreCallback iWriteMediaStoreCallback = this.writeMediaStoreCallback;
        if (iWriteMediaStoreCallback != null) {
            iWriteMediaStoreCallback.deleteFile(obj);
        }
    }

    private void doWriteMediaStoreBuffer(Object obj, byte[] bArr) {
        IWriteMediaStoreCallback iWriteMediaStoreCallback = this.writeMediaStoreCallback;
        if (iWriteMediaStoreCallback != null) {
            iWriteMediaStoreCallback.writeBuffer(obj, bArr);
        }
    }

    private void getCustomProxy(String str, Object obj) {
        if (obj instanceof CustomProxy) {
            this.unicomProxy.getCustomProxy(str, (CustomProxy) obj);
        }
    }

    private void getCustomProxyWithSocks(String str, Object obj) {
        if (obj instanceof CustomProxy) {
            this.unicomProxy.getCustomProxyWithSocks(str, (CustomProxy) obj);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0009 A[Catch: all -> 0x0011, TRY_LEAVE, TryCatch #0 {all -> 0x0011, blocks: (B:3:0x0002, B:6:0x0009), top: B:14:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean loadLibs(android.content.Context r0, com.kugou.common.filemanager.downloadengine.Engine.IDownloadCallback r1) {
        /*
            if (r1 == 0) goto L9
            boolean r0 = r1.loadDownloadLibrary()     // Catch: java.lang.Throwable -> L11
            if (r0 == 0) goto L9
            goto Le
        L9:
            java.lang.String r0 = "jengine"
            java.lang.System.loadLibrary(r0)     // Catch: java.lang.Throwable -> L11
        Le:
            r0 = 1
            r1 = 0
            goto L15
        L11:
            r0 = move-exception
            r1 = 0
            r1 = r0
            r0 = 0
        L15:
            if (r0 != 0) goto L1c
            if (r1 == 0) goto L1c
            com.kugou.common.filemanager.downloadengine.NetLog.sendSoLoadException(r1)
        L1c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kugou.common.filemanager.downloadengine.Engine.loadLibs(android.content.Context, com.kugou.common.filemanager.downloadengine.Engine$IDownloadCallback):boolean");
    }

    private void pCallbackLogEvents(String str, String str2, boolean z) {
        IDownloadCallback iDownloadCallback = this.downloadCallback;
        if (iDownloadCallback != null) {
            iDownloadCallback.onLogEvents(str, str2, z);
        }
    }

    private void pCallbackNatProxyClientStatEvent(final Object obj) {
        if (obj == null || !(obj instanceof NatProxyClientStat)) {
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.kugou.common.filemanager.downloadengine.Engine.4
            @Override // java.lang.Runnable
            public void run() {
                if (Engine.this.p2pStatCallback != null) {
                    Engine.this.p2pStatCallback.OnNatProxyClientStatEvent((NatProxyClientStat) obj);
                }
            }
        };
        ThreadPoolExecutor threadPoolExecutor = this.threadPool;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.execute(runnable);
        }
    }

    private void pCallbackNatProxyServeStatEvent(final Object obj) {
        if (obj == null || !(obj instanceof NatProxyServeStat)) {
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.kugou.common.filemanager.downloadengine.Engine.5
            @Override // java.lang.Runnable
            public void run() {
                if (Engine.this.p2pStatCallback != null) {
                    Engine.this.p2pStatCallback.OnNatProxyServeStatEvent((NatProxyServeStat) obj);
                }
            }
        };
        ThreadPoolExecutor threadPoolExecutor = this.threadPool;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.execute(runnable);
        }
    }

    private Object pCallbackOnLocateHash(String str, boolean z) {
        ShareResourceCallback shareResourceCallback = this.reportCallback;
        if (shareResourceCallback == null) {
            return null;
        }
        try {
            return shareResourceCallback.locateHash(str, z);
        } catch (Throwable th) {
            if (!NetLog.isDebug()) {
                return null;
            }
            NetLog.uploadException(th);
            return null;
        }
    }

    private void pCallbackOnPeerID6Changed(long j) {
        IP2PStatEvent iP2PStatEvent = this.p2pStatCallback;
        if (iP2PStatEvent != null) {
            iP2PStatEvent.OnPeerID6Changed(j);
        }
    }

    private void pCallbackOnPeerIDChanged(long j) {
        IP2PStatEvent iP2PStatEvent = this.p2pStatCallback;
        if (iP2PStatEvent != null) {
            iP2PStatEvent.OnPeerIDChanged(j);
        }
    }

    private void pCallbackOnUploadSessionChanged(boolean z, int i2) {
        ShareResourceCallback shareResourceCallback = this.reportCallback;
        if (shareResourceCallback != null) {
            shareResourceCallback.onUploadSessionChanged(z, i2);
        }
    }

    private void pCallbackRefreshStatEvent(final Object obj) {
        if (obj == null || !(obj instanceof RefreshStat)) {
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.kugou.common.filemanager.downloadengine.Engine.2
            @Override // java.lang.Runnable
            public void run() {
                RefreshStat refreshStat = (RefreshStat) obj;
                if (Engine.this.p2pStatCallback != null) {
                    Engine.this.p2pStatCallback.OnRefreshStatEvent(refreshStat);
                }
                if (Engine.this.reportCallback != null) {
                    Engine.this.reportCallback.onRefreshOver(refreshStat.isIPv6());
                }
            }
        };
        ThreadPoolExecutor threadPoolExecutor = this.threadPool;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.execute(runnable);
        }
    }

    private void pCallbackResourceInfo(Object[] objArr, boolean z) {
        if (this.reportCallback == null || objArr == null || objArr.length == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < objArr.length; i2++) {
            if (objArr[i2] != null && (objArr[i2] instanceof ResourceInfo)) {
                arrayList.add((ResourceInfo) objArr[i2]);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        String[] strArr = new String[arrayList.size()];
        int[] iArr = new int[arrayList.size()];
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            strArr[i3] = ((ResourceInfo) arrayList.get(i3)).getHash();
            iArr[i3] = ((ResourceInfo) arrayList.get(i3)).getSourceCount();
        }
        ShareResourceCallback shareResourceCallback = this.reportCallback;
        if (shareResourceCallback != null) {
            shareResourceCallback.callbackResourceInfo(strArr, iArr, z);
        }
    }

    private void pCallbackSaveLastFlowInfo(String str) {
        IP2PStatEvent iP2PStatEvent = this.p2pStatCallback;
        if (iP2PStatEvent != null) {
            iP2PStatEvent.OnSaveLastFlowInfo(str);
        }
    }

    private void pCallbackUploaderStatEvent(final Object obj) {
        if (obj == null || !(obj instanceof UploaderStat)) {
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.kugou.common.filemanager.downloadengine.Engine.3
            @Override // java.lang.Runnable
            public void run() {
                if (Engine.this.p2pStatCallback != null) {
                    Engine.this.p2pStatCallback.OnUploaderStatEvent((UploaderStat) obj);
                }
            }
        };
        ThreadPoolExecutor threadPoolExecutor = this.threadPool;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.execute(runnable);
        }
    }

    private void pOnDownloadStateChanged(String str, Object obj) {
        DownloadStateInfo downloadStateInfo = (DownloadStateInfo) obj;
        if (downloadStateInfo.getError() != 0) {
            downloadStateInfo.setError(downloadStateInfo.getError() + 100);
        }
        IDownloadCallback iDownloadCallback = this.downloadCallback;
        if (iDownloadCallback != null) {
            iDownloadCallback.onDownloadStateChanged(str, downloadStateInfo);
        }
    }

    private void pOnDownloadStatus(String str, Object obj) {
        IDownloadCallback iDownloadCallback = this.downloadCallback;
        if (iDownloadCallback != null) {
            iDownloadCallback.onDownloadStatus(str, (DownloadStatusInfo) obj);
        }
    }

    private void pSaveCachedEncryptKey(String str) {
        IDownloadCallback iDownloadCallback = this.downloadCallback;
        if (iDownloadCallback != null) {
            iDownloadCallback.onCachedEncryptKeyChanged(str);
        }
    }

    private Object queryPlayBuffer(String str) {
        IPlayBufferQuery iPlayBufferQuery = this.playBufferQuery;
        if (iPlayBufferQuery != null) {
            return iPlayBufferQuery.query(str);
        }
        return null;
    }

    private void refreshUnicomProxy(int i2) {
        IUnicomProxy iUnicomProxy = this.unicomProxy;
        if (iUnicomProxy != null) {
            iUnicomProxy.invalidUnicomProxy(i2);
        }
    }

    public native void addDownload(DownloadFileInfo downloadFileInfo);

    public native void appStateChange(Object obj);

    public native int appendFile(String str, byte[] bArr);

    public native boolean changeDownloadOption(String str, DownloadOption downloadOption);

    public native void cleanCacheDir(String str, long j);

    public native void cleanMVCache(long j);

    public native void deleteDownload(String str);

    public native String downloadMVWithProxy(String str, String str2, long j, String str3, long j2, String str4);

    public native void enableHttpsSupport(boolean z);

    public native boolean enableID3Fetcher(boolean z);

    public native int encodeFile(String str, String str2);

    public native String getDownloadRangesInfo(String str);

    public native String getMVCompletelyCachedPath(String str, String str2);

    public native long[] getMVDownloadProgress(String str, String str2);

    public native int getMVRequestedTimes(String str, String str2);

    public native long getStreamLength(long j);

    public native void httpSpeedTest(String[] strArr, String[] strArr2);

    public native boolean init(int i2, String str, long j, String str2);

    public native void initParam(Object obj);

    public native boolean isMVProxyRunning();

    public native long makeLocalStream(String str);

    public native long makeLocalStream2(String str, String str2, Object obj);

    public native String makeOfflineHugeMVProxy(String str, long j, String str2, String str3);

    public native long makeStream(String str);

    public native String mapFileAsProxy(String str);

    public native void notifyPlayerBuffering(String str, boolean z, int i2, int i3);

    public native void notifyPlayerBuffering2(String str, int i2, boolean z, int i3, int i4);

    public native void onNetworkChanged(int i2, String str, String str2);

    public native boolean preConnectUrl(String str, String str2, boolean z);

    public native void pruneCacheDir(String str, long j);

    public native int readFileProgressInfo(String str, long[] jArr);

    public native int readStream(long j, long j2, byte[] bArr);

    public native void refreshResources(Object[] objArr);

    public native void refreshResources6(Object[] objArr);

    public native void releaseStream(long j);

    public native void reportResource(Object obj);

    public native void reportResource6(Object obj);

    public native void reportSeed(Object obj);

    public native void requestSeed(Object obj);

    public native void reserveBandwidth(long j);

    public native void returnFetchID3Data(String str, int i2, Object obj);

    public native void returnTransformResult(String str, String str2, int i2, String str3);

    public void setAckCallback(IAckCallback iAckCallback) {
        this.ackCallback = iAckCallback;
    }

    public native void setAreaCode(String str);

    public void setCallbackFormatID3(CallbackFormatID3 callbackFormatID3) {
        this.callbackFormatID3 = callbackFormatID3;
    }

    public void setCheckNatCallback(ICheckNatCallback iCheckNatCallback) {
        this.checkNatCallback = iCheckNatCallback;
    }

    public native void setClientStatus(int i2);

    public void setDownloadCallback(IDownloadCallback iDownloadCallback) {
        this.downloadCallback = iDownloadCallback;
    }

    public void setFileTransformCallback(IFileTransform iFileTransform) {
        this.fileTransformCallback = iFileTransform;
    }

    public native void setHttpProxy(String str, int i2);

    public native void setHttpProxyOfNet(String str, String str2, int i2, String str3);

    public native void setID3Data(String str, Object obj);

    public void setID3Fetcher(ID3Fetcher iD3Fetcher) {
        this.mID3Fetcher = iD3Fetcher;
    }

    public void setKggKeyQueryCallback(IKggKeyQueryCallback iKggKeyQueryCallback) {
        this.kggKeyQueryCallback = iKggKeyQueryCallback;
    }

    public native void setLocalIPs(String str);

    public native void setLocalServers(String str);

    public native void setMVCache(String str, long j);

    public native void setMachine(String str);

    public native void setMaxDownloadSourceCount(int i2);

    public native void setMinDownloadSpeed(int i2);

    public native void setMobileP2PEnable(boolean z);

    public native void setMobileP2PMode(int i2);

    public native void setNatProxyEnable(boolean z);

    public void setNetFlowCallback(INetFlowCallback iNetFlowCallback) {
        this.netFlowCallback = iNetFlowCallback;
    }

    public native void setNetworkName(String str);

    public native void setNetworkParamater(int i2, int i3, int i4, String str);

    public native void setP2PParam(P2PParam p2PParam);

    public void setP2pStatCallback(IP2PStatEvent iP2PStatEvent) {
        this.p2pStatCallback = iP2PStatEvent;
    }

    public native void setPassiveCDN(String str, boolean z);

    public native void setPassiveMode(String str, boolean z);

    public void setPlayBufferQuery(IPlayBufferQuery iPlayBufferQuery) {
        this.playBufferQuery = iPlayBufferQuery;
    }

    public native void setPlayerBitrate(String str, int i2);

    public void setSeedCallback(ISeedCallback iSeedCallback) {
        this.seedCallback = iSeedCallback;
    }

    public void setShareResourceCallback(ShareResourceCallback shareResourceCallback) {
        this.reportCallback = shareResourceCallback;
    }

    public native void setShareWeights(boolean z, Object obj);

    public native void setTempCacheID(String str);

    public native void setTrackerResult(DownloadFileInfo downloadFileInfo, boolean z);

    public void setUnicomProxyHandler(IUnicomProxy iUnicomProxy) {
        this.unicomProxy = iUnicomProxy;
    }

    public native void setUnicomProxyOn(boolean z);

    public native void setUserAgent(String str);

    public native void setUserInfo(int i2, int i3, String str, boolean z);

    public native void setUserInfo64(long j, int i2, String str, boolean z, int i3, int i4);

    public void setWriteMediaStoreCallback(IWriteMediaStoreCallback iWriteMediaStoreCallback) {
        this.writeMediaStoreCallback = iWriteMediaStoreCallback;
    }

    public native void sharable(boolean z);

    public native boolean startDownload(DownloadFileInfo downloadFileInfo, DownloadOption downloadOption);

    public native void stopDownload(String str, int i2);

    public native void stopFileAsProxy(String str);

    public native void stopProxy(String str);

    public native void suspendLogin(boolean z);

    public native String tempFile(String str, String str2, String str3);

    public native boolean tryMoveFile(String str, String str2, int i2);

    public native void updateTransformProgress(String str, String str2, int i2);
}
