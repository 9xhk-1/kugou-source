package com.kugou.common.filemanager.downloadengine;

import android.content.Context;
import android.os.SystemClock;
import android.support.annotation.IntRange;
import android.text.TextUtils;
import androidx.appcompat.widget.ActivityChooserView;
import com.kugou.common.filemanager.downloadengine.Engine;
import com.kugou.common.filemanager.downloadengine.entity.AppStateChange;
import com.kugou.common.filemanager.downloadengine.entity.HashInfo;
import com.kugou.common.filemanager.downloadengine.entity.ID3Data;
import com.kugou.common.filemanager.downloadengine.entity.SeedReportInfo;
import com.kugou.common.filemanager.downloadengine.entity.SeedRequestInfo;
import com.kugou.common.filemanager.downloadengine.entity.StreamExtraInfo;
import com.kugou.common.filemanager.downloadengine.http.HttpTaskManager;
import com.kugou.common.filemanager.downloadengine.mv.MVProxyManager;
import com.kugou.common.filemanager.downloadengine.share.LocateInfo;
import com.kugou.common.filemanager.downloadengine.share.ShareResourceCallback;
import com.kugou.common.filemanager.downloadengine.stat.IP2PStatEvent;
import com.kugou.common.filemanager.downloadengine.stat.IStatInterface;
import com.kugou.common.filemanager.downloadengine.stat.NatProxyClientStat;
import com.kugou.common.filemanager.downloadengine.stat.NatProxyServeStat;
import com.kugou.common.filemanager.downloadengine.stat.RefreshStat;
import com.kugou.common.filemanager.downloadengine.stat.UploaderStat;
import com.kugou.common.filemanager.downloadengine.stream.EngineInputStream;
import com.kugou.common.filemanager.downloadengine.types.NetMode;
import com.kugou.common.filemanager.downloadengine.types.TargetCryptType;
import com.kugou.common.filemanager.downloadengine.utils.FileUtil;
import com.tme.fireeye.crash.crashmodule.jni.NativeCrashHandler;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class DownloadEngine {
    private static final String TAG = "DownloadEngine";
    private static volatile Engine downEngine;
    private Engine.CallbackFormatID3 callbackFormatID3;
    private Engine.ICheckNatCallback checkNatCallback;
    private Context context;
    private Engine.IDownloadCallback engineCallback;
    private EngineOption engineOption;
    private HttpTaskManager httpManager;
    private Engine.IKggKeyQueryCallback kggKeyQueryCallback;
    private volatile boolean loadFailed;
    private Engine.INetFlowCallback netFlowCallback;
    private boolean p2pEnabled;
    private ShareResourceCallback resourceCallback;
    private Boolean seaFileP2Enabled;
    private ISeedCallback seedCallback;
    private ThreadPoolExecutor threadPool;
    private IFileTransform transformCallback;
    private MVProxyManager mvProxyManager = new MVProxyManager();
    private IStatInterface p2pStat = null;
    private boolean onlyIPv6 = false;
    private boolean onlineIPv4 = false;

    public static class ID3FetcherImpl implements ID3Fetcher {
        private Engine.CallbackFormatID3 callbackFormatID3;
        private ThreadPoolExecutor threadPool;

        public ID3FetcherImpl(ThreadPoolExecutor threadPoolExecutor, Engine.CallbackFormatID3 callbackFormatID3) {
            this.threadPool = null;
            this.threadPool = threadPoolExecutor;
            this.callbackFormatID3 = callbackFormatID3;
        }

        @Override // com.kugou.common.filemanager.downloadengine.ID3Fetcher
        public void fetchID3(final String str, final int i2, final String str2, final long j, final ID3Setter iD3Setter) {
            if (NetLog.isDebug()) {
                NetLog.d(DownloadEngine.TAG, "fetchID3 - fileKey: " + str + ", fetchID: " + i2 + ", hash: " + str2 + ", mixSongID: " + j);
            }
            SystemClock.elapsedRealtime();
            ThreadPoolExecutor threadPoolExecutor = this.threadPool;
            if (threadPoolExecutor == null || this.callbackFormatID3 == null) {
                return;
            }
            threadPoolExecutor.execute(new Runnable() { // from class: com.kugou.common.filemanager.downloadengine.DownloadEngine.ID3FetcherImpl.1
                @Override // java.lang.Runnable
                public void run() {
                    ID3FetcherImpl.this.callbackFormatID3.fetchID3(str, i2, str2, j, iD3Setter);
                }
            });
        }
    }

    public DownloadEngine(Context context, Engine.IDownloadCallback iDownloadCallback, Engine.ICheckNatCallback iCheckNatCallback, Engine.CallbackFormatID3 callbackFormatID3, HttpTaskManager.IHttpProxyProvider iHttpProxyProvider, EngineOption engineOption, IFileTransform iFileTransform, Engine.IKggKeyQueryCallback iKggKeyQueryCallback) {
        this.context = null;
        this.threadPool = null;
        this.context = context;
        this.engineCallback = iDownloadCallback;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 60L, TimeUnit.MILLISECONDS, new SynchronousQueue());
        this.threadPool = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.httpManager = new HttpTaskManager(this.threadPool, iDownloadCallback, iHttpProxyProvider);
        this.checkNatCallback = iCheckNatCallback;
        this.callbackFormatID3 = callbackFormatID3;
        this.engineOption = engineOption;
        this.transformCallback = iFileTransform;
        this.kggKeyQueryCallback = iKggKeyQueryCallback;
    }

    private static void createDirs(String str) {
        try {
            File parentFile = new File(str).getParentFile();
            if (parentFile.exists()) {
                return;
            }
            parentFile.mkdirs();
        } catch (Exception unused) {
        }
    }

    private synchronized Engine getEngine() {
        if (downEngine != null || this.loadFailed) {
        } else {
            if (Engine.loadLibs(this.context, this.engineCallback)) {
                Engine engine = new Engine(this.threadPool);
                try {
                    init(engine);
                    downEngine = engine;
                } catch (UnsatisfiedLinkError e2) {
                    if (NetLog.isDebug()) {
                        NetLog.e("load libjengine.so failed while init: " + e2.getMessage());
                    }
                    this.loadFailed = true;
                    onlySendCrash(e2);
                }
            } else {
                if (NetLog.isDebug()) {
                    NetLog.e("load libjengine.so failed");
                }
                this.loadFailed = true;
            }
        }
        return downEngine;
    }

    private MVProxyManager getMVProxyManager() {
        return this.mvProxyManager;
    }

    private void init(Engine engine) {
        long j;
        engine.setDownloadCallback(this.engineCallback);
        engine.setCheckNatCallback(this.checkNatCallback);
        engine.setFileTransformCallback(this.transformCallback);
        engine.setKggKeyQueryCallback(this.kggKeyQueryCallback);
        engine.setShareResourceCallback(new ShareResourceCallback() { // from class: com.kugou.common.filemanager.downloadengine.DownloadEngine.1
            @Override // com.kugou.common.filemanager.downloadengine.share.ShareResourceCallback
            public void callbackOnlineStateChanged(boolean z, boolean z2) {
                if (DownloadEngine.this.resourceCallback != null) {
                    DownloadEngine.this.resourceCallback.callbackOnlineStateChanged(z, z2);
                }
            }

            @Override // com.kugou.common.filemanager.downloadengine.share.ShareResourceCallback
            public void callbackResourceInfo(String[] strArr, int[] iArr, boolean z) {
                if (DownloadEngine.this.resourceCallback != null) {
                    DownloadEngine.this.resourceCallback.callbackResourceInfo(strArr, iArr, z);
                }
            }

            @Override // com.kugou.common.filemanager.downloadengine.share.ShareResourceCallback
            public LocateInfo locateHash(String str, boolean z) {
                if (DownloadEngine.this.resourceCallback != null) {
                    return DownloadEngine.this.resourceCallback.locateHash(str, z);
                }
                return null;
            }

            @Override // com.kugou.common.filemanager.downloadengine.share.ShareResourceCallback
            public void onRefreshOver(boolean z) {
                if (DownloadEngine.this.resourceCallback != null) {
                    DownloadEngine.this.resourceCallback.onRefreshOver(z);
                }
            }

            @Override // com.kugou.common.filemanager.downloadengine.share.ShareResourceCallback
            public void onUploadSessionChanged(boolean z, int i2) {
                if (DownloadEngine.this.resourceCallback != null) {
                    DownloadEngine.this.resourceCallback.onUploadSessionChanged(z, i2);
                }
            }
        });
        engine.setP2pStatCallback(new IP2PStatEvent() { // from class: com.kugou.common.filemanager.downloadengine.DownloadEngine.2
            @Override // com.kugou.common.filemanager.downloadengine.stat.IP2PStatEvent
            public void OnNatProxyClientStatEvent(NatProxyClientStat natProxyClientStat) {
                if (DownloadEngine.this.p2pStat != null) {
                    DownloadEngine.this.p2pStat.OnNatProxyClientStatEvent(natProxyClientStat);
                }
            }

            @Override // com.kugou.common.filemanager.downloadengine.stat.IP2PStatEvent
            public void OnNatProxyServeStatEvent(NatProxyServeStat natProxyServeStat) {
                if (DownloadEngine.this.p2pStat != null) {
                    DownloadEngine.this.p2pStat.OnNatProxyServeStatEvent(natProxyServeStat);
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:17:0x003b  */
            @Override // com.kugou.common.filemanager.downloadengine.stat.IP2PStatEvent
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void OnOnlineStatEvent(com.kugou.common.filemanager.downloadengine.stat.OnlineStat r5) {
                /*
                    r4 = this;
                    com.kugou.common.filemanager.downloadengine.DownloadEngine r0 = com.kugou.common.filemanager.downloadengine.DownloadEngine.this
                    com.kugou.common.filemanager.downloadengine.stat.IStatInterface r0 = com.kugou.common.filemanager.downloadengine.DownloadEngine.access$100(r0)
                    if (r0 == 0) goto L11
                    com.kugou.common.filemanager.downloadengine.DownloadEngine r0 = com.kugou.common.filemanager.downloadengine.DownloadEngine.this
                    com.kugou.common.filemanager.downloadengine.stat.IStatInterface r0 = com.kugou.common.filemanager.downloadengine.DownloadEngine.access$100(r0)
                    r0.OnOnlineStatEvent(r5)
                L11:
                    com.kugou.common.filemanager.downloadengine.DownloadEngine r0 = com.kugou.common.filemanager.downloadengine.DownloadEngine.this
                    com.kugou.common.filemanager.downloadengine.share.ShareResourceCallback r0 = com.kugou.common.filemanager.downloadengine.DownloadEngine.access$000(r0)
                    if (r0 == 0) goto L52
                    int r0 = r5.getType()
                    r1 = 1
                    r2 = 0
                    if (r0 == r1) goto L3b
                    r3 = 2
                    if (r0 == r3) goto L2b
                    r3 = 3
                    if (r0 == r3) goto L3b
                    switch(r0) {
                        case 20: goto L45;
                        case 21: goto L31;
                        case 22: goto L45;
                        default: goto L2a;
                    }
                L2a:
                    goto L52
                L2b:
                    com.kugou.common.filemanager.downloadengine.DownloadEngine r5 = com.kugou.common.filemanager.downloadengine.DownloadEngine.this
                    com.kugou.common.filemanager.downloadengine.DownloadEngine.access$202(r5, r2)
                    r1 = 0
                L31:
                    com.kugou.common.filemanager.downloadengine.DownloadEngine r5 = com.kugou.common.filemanager.downloadengine.DownloadEngine.this
                    com.kugou.common.filemanager.downloadengine.share.ShareResourceCallback r5 = com.kugou.common.filemanager.downloadengine.DownloadEngine.access$000(r5)
                    r5.callbackOnlineStateChanged(r2, r1)
                    goto L52
                L3b:
                    com.kugou.common.filemanager.downloadengine.DownloadEngine r0 = com.kugou.common.filemanager.downloadengine.DownloadEngine.this
                    boolean r1 = r5.isSucc()
                    com.kugou.common.filemanager.downloadengine.DownloadEngine.access$202(r0, r1)
                    r1 = 0
                L45:
                    com.kugou.common.filemanager.downloadengine.DownloadEngine r0 = com.kugou.common.filemanager.downloadengine.DownloadEngine.this
                    com.kugou.common.filemanager.downloadengine.share.ShareResourceCallback r0 = com.kugou.common.filemanager.downloadengine.DownloadEngine.access$000(r0)
                    boolean r5 = r5.isSucc()
                    r0.callbackOnlineStateChanged(r5, r1)
                L52:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.kugou.common.filemanager.downloadengine.DownloadEngine.AnonymousClass2.OnOnlineStatEvent(com.kugou.common.filemanager.downloadengine.stat.OnlineStat):void");
            }

            @Override // com.kugou.common.filemanager.downloadengine.stat.IP2PStatEvent
            public void OnPeerID6Changed(long j2) {
                if (j2 > 0) {
                    if (DownloadEngine.this.engineCallback != null) {
                        DownloadEngine.this.engineCallback.onPeerID6Changed(j2);
                    }
                    if (NetLog.isDebug()) {
                        NetLog.i("Engine::CallbackOnPeerIDChanged peerID[IPv6] [" + j2 + "]");
                    }
                }
            }

            @Override // com.kugou.common.filemanager.downloadengine.stat.IP2PStatEvent
            public void OnPeerIDChanged(long j2) {
                if (j2 > 0) {
                    if (DownloadEngine.this.engineCallback != null) {
                        DownloadEngine.this.engineCallback.onPeerIDChanged(j2);
                    }
                    if (NetLog.isDebug()) {
                        NetLog.i("Engine::CallbackOnPeerIDChanged peerID [" + j2 + "]");
                    }
                }
            }

            @Override // com.kugou.common.filemanager.downloadengine.stat.IP2PStatEvent
            public void OnRefreshStatEvent(RefreshStat refreshStat) {
                if (DownloadEngine.this.p2pStat != null) {
                    DownloadEngine.this.p2pStat.OnRefreshStatEvent(refreshStat);
                }
            }

            @Override // com.kugou.common.filemanager.downloadengine.stat.IP2PStatEvent
            public void OnSaveLastFlowInfo(String str) {
                if (DownloadEngine.this.engineCallback != null) {
                    DownloadEngine.this.engineCallback.OnSaveLastFlowInfo(str);
                }
                if (NetLog.isDebug()) {
                    NetLog.i("last flow info: " + str);
                }
            }

            @Override // com.kugou.common.filemanager.downloadengine.stat.IP2PStatEvent
            public void OnUploaderStatEvent(UploaderStat uploaderStat) {
                if (DownloadEngine.this.p2pStat != null) {
                    DownloadEngine.this.p2pStat.OnUploaderStatEvent(uploaderStat);
                }
            }
        });
        ISeedCallback iSeedCallback = this.engineOption.SeedCallback;
        if (iSeedCallback != null) {
            engine.setSeedCallback(iSeedCallback);
        }
        Engine.INetFlowCallback iNetFlowCallback = this.engineOption.NetFlowCallback;
        if (iNetFlowCallback != null) {
            engine.setNetFlowCallback(iNetFlowCallback);
        }
        Engine.IWriteMediaStoreCallback iWriteMediaStoreCallback = this.engineOption.WriteMediaStoreCallback;
        if (iWriteMediaStoreCallback != null) {
            engine.setWriteMediaStoreCallback(iWriteMediaStoreCallback);
        }
        engine.setCallbackFormatID3(this.callbackFormatID3);
        EngineOption engineOption = this.engineOption;
        int i2 = engineOption.EnginePort;
        String str = engineOption.ServerList;
        long j2 = engineOption.PeerID;
        if (j2 < 0) {
            IStatInterface iStatInterface = this.p2pStat;
            if (iStatInterface != null) {
                iStatInterface.onPeerIDInvalidWhenStart(j2);
            }
            j = 0;
        } else {
            j = j2;
        }
        if (NetLog.isDebug()) {
            NetLog.i("DownloadEngine::init peerID [" + j + "]");
        }
        String str2 = this.engineOption.UUID;
        engine.init(i2, str, j, str2);
        engine.initParam(makeInitParam());
        EngineOption engineOption2 = this.engineOption;
        engine.setNetworkParamater(engineOption2.ClientVersion, engineOption2.ChannelID, engineOption2.AppID, str2);
        engine.setMachine(this.engineOption.MachineToken);
        EngineOption engineOption3 = this.engineOption;
        engine.setUserInfo64(engineOption3.UserID, engineOption3.VipType, engineOption3.UserToken, engineOption3.IsVip, engineOption3.MinPCPeerID, engineOption3.MaxPCPeerID);
        if (TextUtils.isEmpty(str) || str.equalsIgnoreCase("FF") || str.equalsIgnoreCase("FE")) {
            this.p2pEnabled = false;
        } else {
            this.p2pEnabled = true;
        }
        engine.setMaxDownloadSourceCount(this.engineOption.MaxDownloadSourceCount);
        engine.setUserAgent(this.engineOption.UserAgent);
        engine.setMobileP2PMode(this.engineOption.P2PMode);
        engine.setMobileP2PEnable(true);
        String str3 = this.engineOption.CacheID;
        if (!TextUtils.isEmpty(str3)) {
            engine.setTempCacheID(str3);
        }
        if (!TextUtils.isEmpty(this.engineOption.ChecknatIPv6)) {
            engine.setLocalServers(this.engineOption.ChecknatIPv6);
            this.engineOption.P2pParam.setEnableCheckNATv6(true);
        }
        engine.setP2PParam(this.engineOption.P2pParam);
        Engine.IUnicomProxy iUnicomProxy = this.engineOption.UnicomProxy;
        if (iUnicomProxy != null) {
            engine.setUnicomProxyHandler(iUnicomProxy);
        }
        Engine.CardInfo cardInfo = this.engineCallback.getCardInfo();
        if (cardInfo != null) {
            if ("".equals(this.engineOption.MVCacheDirectory)) {
                getMVProxyManager().init(cardInfo.getRoot() + "/kugou/mv/cache");
            } else {
                getMVProxyManager().init(this.engineOption.MVCacheDirectory);
            }
            engine.setMVCache(getMVProxyManager().getMVCacheDirectory(), cardInfo.getMVMaxCacheSize());
        }
        this.threadPool.execute(new Runnable() { // from class: com.kugou.common.filemanager.downloadengine.DownloadEngine.3
            @Override // java.lang.Runnable
            public void run() {
                DownloadEngine downloadEngine = DownloadEngine.this;
                boolean iD3Fetcher = downloadEngine.setID3Fetcher(new ID3FetcherImpl(downloadEngine.threadPool, DownloadEngine.this.callbackFormatID3));
                if (NetLog.isDebug()) {
                    NetLog.d(DownloadEngine.TAG, "setID3Fetcher: " + iD3Fetcher);
                }
            }
        });
        try {
            engine.enableHttpsSupport(this.engineOption.EnableHttpsSupport);
        } catch (UnsatisfiedLinkError e2) {
            onlySendCrash(e2);
        }
    }

    private void onlySendCrash(Throwable th) {
    }

    public void addDownload(DownloadFileInfo downloadFileInfo) {
        Engine engine = getEngine();
        if (engine != null) {
            engine.addDownload(downloadFileInfo);
        }
    }

    public int appendFileOfEncrypt(String str, byte[] bArr) {
        Engine engine = getEngine();
        if (engine != null) {
            return engine.appendFile(str, bArr);
        }
        return -1;
    }

    public boolean changeDownloadOption(DownloadOption downloadOption, String str) {
        Engine engine = getEngine();
        if (engine != null) {
            return engine.changeDownloadOption(str, downloadOption);
        }
        return false;
    }

    public void cleanCacheDir(String str, long j) {
        Engine engine = getEngine();
        if (engine != null) {
            engine.cleanCacheDir(str, j);
        }
    }

    public void cleanMVCache(long j) {
        Engine engine = getEngine();
        if (engine != null) {
            Engine.CardInfo cardInfo = this.engineCallback.getCardInfo();
            long availableSize = cardInfo != null ? cardInfo.getAvailableSize() : 0L;
            if (j == 0 || availableSize < j) {
                engine.cleanMVCache(j != 0 ? j - availableSize : 0L);
            }
        }
    }

    public void deleteDownload(String str) {
        Engine engine = getEngine();
        if (engine != null) {
            engine.deleteDownload(str);
        }
    }

    public String downloadMVWithProxy(String str, String str2, long j, String str3) {
        Engine.CardInfo cardInfo;
        Engine engine = getEngine();
        if (engine == null || (cardInfo = this.engineCallback.getCardInfo()) == null) {
            return null;
        }
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str3)) {
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            if (NetLog.isDebug()) {
                NetLog.d("MVProxy", "check exists mv for mp3Hash(" + str3 + ")");
            }
            return engine.downloadMVWithProxy(str, str2, j, str3, 0L, "");
        }
        String mVSavePath = getMVProxyManager().getMVSavePath(str, str2, str3);
        if (TextUtils.isEmpty(mVSavePath)) {
            return null;
        }
        if (NetLog.isDebug()) {
            NetLog.d("MVProxy", "create mv(" + str + ") at path(" + mVSavePath + ")");
        }
        return engine.downloadMVWithProxy(str, str2, j, str3, cardInfo.getAvailableSize(), mVSavePath);
    }

    public int encodeFile(String str, String str2) {
        Engine engine = getEngine();
        if (engine == null) {
            return 9;
        }
        try {
            return engine.encodeFile(str, str2);
        } catch (UnsatisfiedLinkError e2) {
            onlySendCrash(e2);
            return 9;
        }
    }

    public void exit() {
        IStatInterface iStatInterface = this.p2pStat;
        if (iStatInterface != null) {
            iStatInterface.exit();
        }
    }

    public String getDownloadRangesInfo(String str) {
        try {
            Engine engine = getEngine();
            if (engine != null) {
                return engine.getDownloadRangesInfo(str);
            }
            return null;
        } catch (UnsatisfiedLinkError e2) {
            onlySendCrash(e2);
            return null;
        }
    }

    public String getMVCompletelyCachedPath(String str, String str2) {
        Engine engine = getEngine();
        if (engine == null) {
            return null;
        }
        return engine.getMVCompletelyCachedPath(str, str2);
    }

    public long[] getMVDownloadProgress(String str, String str2) {
        Engine engine = getEngine();
        if (engine == null) {
            return null;
        }
        return engine.getMVDownloadProgress(str, str2);
    }

    public int getMVRequestedTimes(String str, String str2) {
        Engine engine = getEngine();
        if (engine == null) {
            return -1;
        }
        return engine.getMVRequestedTimes(str, str2);
    }

    public boolean isEngineValid() {
        return downEngine != null;
    }

    public boolean isMVProxyRunning() {
        Engine engine = getEngine();
        if (engine == null) {
            return false;
        }
        return engine.isMVProxyRunning();
    }

    public boolean isP2PEnabled() {
        return this.p2pEnabled && isEngineValid();
    }

    public ExtraInitParam makeInitParam() {
        ExtraInitParam extraInitParam = new ExtraInitParam();
        long j = this.engineOption.PeerID6;
        if (j > 0) {
            extraInitParam.setPeerID6(j);
        }
        extraInitParam.setLastFlowInfo(this.engineOption.LastFlowInfo);
        return extraInitParam;
    }

    public long makeLocalStream(String str) {
        return makeLocalStream2(str, null, null);
    }

    public long makeLocalStream2(String str, String str2, Object obj) {
        Engine engine = getEngine();
        if (engine == null) {
            return 0L;
        }
        try {
            return engine.makeLocalStream(str);
        } catch (UnsatisfiedLinkError e2) {
            onlySendCrash(e2);
            return 0L;
        }
    }

    public String makeOfflineHugeMVProxy(String str, long j, String str2, String str3) {
        Engine engine = getEngine();
        if (engine == null) {
            return null;
        }
        return engine.makeOfflineHugeMVProxy(str, j, str2, str3);
    }

    public long makeStream(String str) {
        Engine engine = getEngine();
        if (engine != null) {
            return engine.makeStream(str);
        }
        return 0L;
    }

    public String makeTempFile(String str, String str2, String str3) {
        Engine.IDownloadCallback iDownloadCallback;
        Engine engine = getEngine();
        if (engine != null) {
            return engine.tempFile(str, str2, str3);
        }
        if (TextUtils.isEmpty(str) || (iDownloadCallback = this.engineCallback) == null || iDownloadCallback.isEncryptedFile(str)) {
            return null;
        }
        return str;
    }

    public String mapFileAsProxy(String str) {
        Engine engine = getEngine();
        if (engine == null) {
            return null;
        }
        return engine.mapFileAsProxy(str);
    }

    public String mapLocalMVProxy(String str, String str2) {
        Engine engine = getEngine();
        if (engine == null) {
            return null;
        }
        return engine.downloadMVWithProxy(str, str2, 0L, "", 0L, str);
    }

    public EngineInputStream newInputStream(String str) throws IOException {
        Engine engine = getEngine();
        if (engine == null) {
            throw new IOException("can't load engine");
        }
        long jMakeLocalStream = makeLocalStream(str);
        if (jMakeLocalStream != 0) {
            return new EngineInputStream(jMakeLocalStream, engine);
        }
        throw new IOException("path " + str + " not exists or invalid");
    }

    public EngineInputStream newInputStream2(String str, String str2, StreamExtraInfo streamExtraInfo) throws IOException {
        Engine engine = getEngine();
        if (engine == null) {
            throw new IOException("can't load engine");
        }
        long jMakeLocalStream2 = makeLocalStream2(str, str2, streamExtraInfo);
        if (jMakeLocalStream2 != 0) {
            return new EngineInputStream(jMakeLocalStream2, engine);
        }
        throw new IOException("path " + str + " not exists or invalid");
    }

    public void notifyPlayerBuffering(String str, int i2, boolean z, int i3, int i4) {
        Engine engine = getEngine();
        if (engine != null) {
            try {
                engine.notifyPlayerBuffering2(str, i2, z, i3, i4);
            } catch (UnsatisfiedLinkError e2) {
                onlySendCrash(e2);
            }
        }
    }

    public void onAppStateChange(AppStateChange appStateChange) {
        Engine engine = getEngine();
        if (engine != null) {
            try {
                engine.appStateChange(appStateChange);
            } catch (UnsatisfiedLinkError e2) {
                onlySendCrash(e2);
            }
        }
    }

    public void onNetworkChanged(@NetMode int i2, String str, String str2) {
        Engine engine = getEngine();
        if (engine != null) {
            engine.onNetworkChanged(i2, str, str2);
        }
    }

    public void onUserInfoChange(long j, int i2, boolean z, String str) {
        Engine engine = getEngine();
        if (engine != null) {
            if (NetLog.isDebug()) {
                NetLog.d(TAG, "onUserInfoChange uid=" + j + ", vipType=" + i2 + ", token=" + str);
            }
            try {
                EngineOption engineOption = this.engineOption;
                engine.setUserInfo64(j, i2, str, z, engineOption.MinPCPeerID, engineOption.MaxPCPeerID);
            } catch (UnsatisfiedLinkError e2) {
                onlySendCrash(e2);
                engine.setUserInfo((int) j, i2, str, z);
            }
        }
    }

    public boolean preConnectUrl(String str, String str2, boolean z) {
        try {
            Engine engine = getEngine();
            if (engine != null) {
                return engine.preConnectUrl(str, str2, z);
            }
            return false;
        } catch (UnsatisfiedLinkError e2) {
            onlySendCrash(e2);
            return false;
        }
    }

    public void pruneCacheDir(String str, long j) {
        Engine engine = getEngine();
        if (engine != null) {
            engine.pruneCacheDir(str, j);
        }
    }

    public int readFileProgressInfo(String str, long[] jArr) {
        Engine engine = getEngine();
        if (engine == null) {
            return -1;
        }
        try {
            return engine.readFileProgressInfo(str, jArr);
        } catch (UnsatisfiedLinkError e2) {
            onlySendCrash(e2);
            return -1;
        }
    }

    public int readFileTail(String str, byte[] bArr) {
        long j;
        if (bArr == null || bArr.length == 0) {
            return 0;
        }
        Engine engine = getEngine();
        if (engine == null) {
            return -1;
        }
        long jMakeLocalStream = makeLocalStream(str);
        if (jMakeLocalStream == 0) {
            return -1;
        }
        try {
            long streamLength = engine.getStreamLength(jMakeLocalStream);
            long length = streamLength - ((long) bArr.length);
            int length2 = bArr.length;
            if (length < 0) {
                length2 = (int) streamLength;
                j = 0;
            } else {
                j = length;
            }
            byte[] bArr2 = new byte[length2];
            int stream = engine.readStream(jMakeLocalStream, j, bArr2);
            if (stream < 0) {
                return -1;
            }
            for (int i2 = 0; i2 < stream; i2++) {
                bArr[i2] = bArr2[i2];
            }
            return stream;
        } finally {
            engine.releaseStream(jMakeLocalStream);
        }
    }

    public void refreshResources(boolean z, HashInfo[] hashInfoArr) {
        Engine engine;
        if (hashInfoArr == null || hashInfoArr.length == 0 || (engine = getEngine()) == null) {
            return;
        }
        Object[] objArr = new Object[hashInfoArr.length];
        for (int i2 = 0; i2 < hashInfoArr.length; i2++) {
            NetLog.d("KuGouP2P", "refresh " + hashInfoArr[i2].getHash() + " name " + hashInfoArr[i2].getFileName());
            objArr[i2] = hashInfoArr[i2];
        }
        if (z) {
            engine.refreshResources6(objArr);
        } else {
            engine.refreshResources(objArr);
        }
    }

    public void releaseStream(long j) {
        Engine engine = getEngine();
        if (engine != null) {
            engine.releaseStream(j);
        }
    }

    public void reloadX86Lib() {
        this.httpManager.stopAll();
        synchronized (this) {
            this.loadFailed = false;
            getEngine();
        }
    }

    public void reportResource(HashInfo hashInfo) {
        if (hashInfo == null || TextUtils.isEmpty(hashInfo.getHash())) {
            return;
        }
        NetLog.d("KuGouP2P", "report  " + hashInfo.getHash() + " name " + hashInfo.getFileName());
        Engine engine = getEngine();
        if (engine != null) {
            if (!this.onlyIPv6 || this.onlineIPv4) {
                engine.reportResource(hashInfo);
            }
            engine.reportResource6(hashInfo);
        }
    }

    public void reportSeed(SeedReportInfo seedReportInfo) {
        try {
            Engine engine = getEngine();
            if (engine != null) {
                engine.reportSeed(seedReportInfo);
            }
        } catch (UnsatisfiedLinkError e2) {
            onlySendCrash(e2);
        }
    }

    public void requestSeed(SeedRequestInfo seedRequestInfo) {
        try {
            Engine engine = getEngine();
            if (engine != null) {
                engine.requestSeed(seedRequestInfo);
            }
        } catch (UnsatisfiedLinkError e2) {
            onlySendCrash(e2);
        }
    }

    public void reserveBandwidth(long j) {
        Engine engine = getEngine();
        if (engine != null) {
            engine.reserveBandwidth(j);
        }
    }

    public void returnTransformResult(String str, String str2, boolean z, String str3) {
        if (NetLog.isDebug()) {
            NetLog.d("Return Transform Result: " + str + " " + str2 + " " + z + " " + str3);
        }
        try {
            Engine engine = getEngine();
            if (engine != null) {
                engine.returnTransformResult(str, str2, z ? 1 : 0, str3);
            }
        } catch (UnsatisfiedLinkError e2) {
            onlySendCrash(e2);
        }
    }

    public void setAreaCode(String str) {
        try {
            Engine engine = getEngine();
            if (engine != null) {
                engine.setAreaCode(str);
            }
        } catch (UnsatisfiedLinkError e2) {
            onlySendCrash(e2);
        }
    }

    public void setClientStatus(int i2) {
        Engine engine = getEngine();
        if (engine != null) {
            engine.setClientStatus(i2);
        }
    }

    public void setHttpProxy(String str, int i2) {
        Engine engine = getEngine();
        if (engine != null) {
            engine.setHttpProxy(str, i2);
        }
    }

    public void setHttpProxyOfNet(String str, String str2, int i2, String str3) {
        Engine engine = getEngine();
        if (engine != null) {
            engine.setHttpProxyOfNet(str, str2, i2, str3);
        }
    }

    public void setID3Data(long j, ID3Data iD3Data) {
        try {
            Engine engine = getEngine();
            if (engine != null) {
                if (NetLog.isDebug()) {
                    NetLog.d(TAG, "setID3Data-fileID: " + j + ", " + iD3Data);
                }
                engine.setID3Data(String.valueOf(j), iD3Data);
            }
        } catch (UnsatisfiedLinkError e2) {
            onlySendCrash(e2);
        }
    }

    public boolean setID3Fetcher(ID3Fetcher iD3Fetcher) {
        try {
            Engine engine = getEngine();
            if (engine != null) {
                engine.setID3Fetcher(iD3Fetcher);
                return engine.enableID3Fetcher(iD3Fetcher != null);
            }
        } catch (UnsatisfiedLinkError e2) {
            onlySendCrash(e2);
        }
        return false;
    }

    public void setLocalIPs(String str) {
        try {
            Engine engine = getEngine();
            if (engine != null) {
                engine.setLocalIPs(str);
            }
        } catch (UnsatisfiedLinkError e2) {
            onlySendCrash(e2);
        }
    }

    public void setLocalServers(String str) {
        Engine engine = getEngine();
        if (engine != null) {
            engine.setLocalServers(str);
        }
    }

    public void setMachineToken(String str) {
        try {
            Engine engine = getEngine();
            if (engine != null) {
                engine.setMachine(str);
            }
        } catch (UnsatisfiedLinkError e2) {
            onlySendCrash(e2);
        }
    }

    public void setNatProxyEnable(Boolean bool) {
        Engine engine = getEngine();
        if (engine != null) {
            engine.setNatProxyEnable(bool.booleanValue());
        }
    }

    public void setNetFlowCallback(Engine.INetFlowCallback iNetFlowCallback) {
        this.netFlowCallback = iNetFlowCallback;
    }

    public void setNetworkName(String str) {
        Engine engine = getEngine();
        if (engine != null) {
            engine.setNetworkName(str);
        }
    }

    public void setP2PParam(P2PParam p2PParam) {
        Engine engine = getEngine();
        if (engine == null) {
            return;
        }
        engine.setP2PParam(p2PParam);
    }

    public void setPassiveCDN(String str, boolean z) {
        try {
            Engine engine = getEngine();
            if (engine != null) {
                engine.setPassiveCDN(str, z);
            }
        } catch (UnsatisfiedLinkError e2) {
            onlySendCrash(e2);
        }
    }

    public void setPassiveMode(String str, boolean z) {
        try {
            Engine engine = getEngine();
            if (engine != null) {
                engine.setPassiveMode(str, z);
            }
        } catch (UnsatisfiedLinkError e2) {
            onlySendCrash(e2);
        }
    }

    public void setPlayBufferQuery(IPlayBufferQuery iPlayBufferQuery) {
        Engine engine = getEngine();
        if (engine == null) {
            return;
        }
        engine.setPlayBufferQuery(iPlayBufferQuery);
    }

    public void setPlayerBitrate(String str, int i2) {
        try {
            Engine engine = getEngine();
            if (engine != null) {
                engine.setPlayerBitrate(str, i2);
            }
        } catch (UnsatisfiedLinkError e2) {
            onlySendCrash(e2);
        }
    }

    public void setSeedCallback(ISeedCallback iSeedCallback) {
        this.seedCallback = iSeedCallback;
    }

    public void setShareResourceCallback(ShareResourceCallback shareResourceCallback) {
        this.resourceCallback = shareResourceCallback;
    }

    public void setStatCallback(IStatInterface iStatInterface) {
        this.p2pStat = iStatInterface;
    }

    public void setTrackerResult(DownloadFileInfo downloadFileInfo, boolean z) {
        Engine engine = getEngine();
        if (engine != null) {
            engine.setTrackerResult(downloadFileInfo, z);
        }
    }

    public void setUnicomProxyHandler(Engine.IUnicomProxy iUnicomProxy) {
        Engine engine = getEngine();
        if (engine == null) {
            return;
        }
        engine.setUnicomProxyHandler(iUnicomProxy);
    }

    public void setUnicomProxyOn(boolean z) {
        Engine engine = getEngine();
        if (engine != null) {
            engine.setUnicomProxyOn(z);
        }
    }

    public void sharable(boolean z) {
        Engine engine = getEngine();
        if (engine != null) {
            engine.sharable(z);
        }
    }

    public boolean startDownload(DownloadFileInfo downloadFileInfo, DownloadOption downloadOption) {
        Engine engine = getEngine();
        if (engine == null) {
            return this.httpManager.startDownload(downloadFileInfo);
        }
        createDirs(downloadFileInfo.getFilePath());
        downloadFileInfo.setJavaTime(System.currentTimeMillis());
        return engine.startDownload(downloadFileInfo, downloadOption);
    }

    public void stopDownload(String str, int i2) {
        Engine engine = getEngine();
        if (engine != null) {
            engine.stopDownload(str, i2);
        } else {
            this.httpManager.stopDownload(str);
        }
    }

    public void stopProxy(String str) {
        Engine engine = getEngine();
        if (engine == null) {
            return;
        }
        engine.stopProxy(str);
    }

    public void suspendLogin(boolean z) {
        try {
            Engine engine = getEngine();
            if (engine != null) {
                engine.suspendLogin(z);
            }
        } catch (UnsatisfiedLinkError e2) {
            onlySendCrash(e2);
        }
    }

    public boolean tryMoveFile(String str, String str2, @TargetCryptType int i2) throws Throwable {
        if (TextUtils.isEmpty(str2) || !FileUtil.createDirectory(new File(str2).getParent())) {
            return false;
        }
        Engine engine = getEngine();
        if (engine != null) {
            try {
                return engine.tryMoveFile(str, str2, i2);
            } catch (UnsatisfiedLinkError e2) {
                onlySendCrash(e2);
            }
        }
        boolean zIsRealEncryptedFile = FileUtil.isRealEncryptedFile(str);
        if (zIsRealEncryptedFile && i2 == 1) {
            return false;
        }
        if (zIsRealEncryptedFile || i2 != 2) {
            return FileUtil.rename(str, str2) || FileUtil.moveFile(str, str2);
        }
        return false;
    }

    public void updateTransformProgress(String str, String str2, @IntRange(from = 0, to = NativeCrashHandler.NATIVE_RECORD_FILE_LOCK_EXPIRED_TIME) int i2) {
        if (NetLog.isDebug()) {
            NetLog.d("Update Transform Progress: " + str + " " + str2 + " " + i2);
        }
        try {
            Engine engine = getEngine();
            if (engine != null) {
                engine.updateTransformProgress(str, str2, i2);
            }
        } catch (UnsatisfiedLinkError e2) {
            onlySendCrash(e2);
        }
    }
}
