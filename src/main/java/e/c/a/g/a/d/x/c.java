package e.c.a.g.a.d.x;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kugou.android.watch.lite.base.player.entity.CommNetSongUrlInfo;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import com.kugou.common.filemanager.downloadengine.DownloadEngine;
import com.kugou.common.filemanager.downloadengine.DownloadFileInfo;
import com.kugou.common.filemanager.downloadengine.DownloadStateInfo;
import com.kugou.common.filemanager.downloadengine.DownloadStatusInfo;
import com.kugou.common.filemanager.downloadengine.entity.FileDownloadState;
import com.kugou.common.filemanager.downloadengine.stat.IStatInterface;
import com.kugou.common.filemanager.downloadengine.stat.NatProxyClientStat;
import com.kugou.common.filemanager.downloadengine.stat.NatProxyServeStat;
import com.kugou.common.filemanager.downloadengine.stat.OnlineStat;
import com.kugou.common.filemanager.downloadengine.stat.RefreshStat;
import com.kugou.common.filemanager.downloadengine.stat.UploaderStat;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.j0;
import e.c.d.c;
import e.c.d.d;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f546e;
    public StringBuffer a;
    public final Map<String, e.c.d.c> b;
    public final Map<String, Boolean> c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public d.g f547d;

    public class a implements IStatInterface {
        public a(c cVar) {
        }

        @Override // com.kugou.common.filemanager.downloadengine.stat.IStatInterface
        public void OnNatProxyClientStatEvent(NatProxyClientStat natProxyClientStat) {
        }

        @Override // com.kugou.common.filemanager.downloadengine.stat.IStatInterface
        public void OnNatProxyServeStatEvent(NatProxyServeStat natProxyServeStat) {
        }

        @Override // com.kugou.common.filemanager.downloadengine.stat.IStatInterface
        public void OnOnlineStatEvent(OnlineStat onlineStat) {
            if (onlineStat != null) {
                g0.b("KuGouP2P-WatchStat", "Stat{type=" + onlineStat.getType() + ", natType=" + onlineStat.getNatType() + ", succ=" + onlineStat.isSucc() + ", tryNext=" + onlineStat.isTryNext() + ", result='" + onlineStat.getResult() + "', duration=" + onlineStat.getDuration() + ", err='" + onlineStat.getErr() + "', serverIP='" + onlineStat.getServerIP() + "', clientIP='" + onlineStat.getClientIP() + "', kgRC=" + onlineStat.getKgRC() + ", kgRF='" + onlineStat.getKgRF() + "'}");
            }
        }

        @Override // com.kugou.common.filemanager.downloadengine.stat.IStatInterface
        public void OnRefreshStatEvent(RefreshStat refreshStat) {
        }

        @Override // com.kugou.common.filemanager.downloadengine.stat.IStatInterface
        public void OnUploaderStatEvent(UploaderStat uploaderStat) {
        }

        @Override // com.kugou.common.filemanager.downloadengine.stat.IStatInterface
        public void exit() {
        }

        @Override // com.kugou.common.filemanager.downloadengine.stat.IStatInterface
        public void onPeerIDInvalidWhenLogin(long j) {
        }

        @Override // com.kugou.common.filemanager.downloadengine.stat.IStatInterface
        public void onPeerIDInvalidWhenStart(long j) {
        }
    }

    public class b implements d.g {

        public class a implements Runnable {
            public final /* synthetic */ DownloadStateInfo a;
            public final /* synthetic */ String b;

            public a(DownloadStateInfo downloadStateInfo, String str) {
                this.a = downloadStateInfo;
                this.b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                DownloadStateInfo downloadStateInfo = this.a;
                if (downloadStateInfo == null) {
                    return;
                }
                int state = downloadStateInfo.getState();
                String str = "";
                FileDownloadState fileDownloadState = FileDownloadState.FILE_DOWNLOAD_STATE_SUCCEEDED;
                if (state == fileDownloadState.ordinal() || state == FileDownloadState.FILE_DOWNLOAD_STATE_FAILED.ordinal()) {
                    synchronized (c.this.b) {
                        e.c.d.c cVar = (e.c.d.c) c.this.b.remove(this.b);
                        if (cVar != null) {
                            c.this.h().deleteDownload(cVar.a);
                        }
                        if (state == FileDownloadState.FILE_DOWNLOAD_STATE_FAILED.ordinal()) {
                            str = (("(") + this.a.getError() + ", " + this.a.getErrorNo() + ", " + this.a.getErrorDetail()) + ")";
                        }
                    }
                }
                if (state == fileDownloadState.ordinal()) {
                    c.this.o(this.b);
                    if (g0.a) {
                        g0.b("PlayCacheMgr", "removeKeyFromError:key:" + this.b);
                    }
                }
                e.c.d.f.a.e().d("PlayCacheMgr", "onDownloadStateChanged(" + state + "): " + this.b + str);
            }
        }

        public b() {
        }

        @Override // e.c.d.d.g
        public void onDownloadStateChanged(String str, DownloadStateInfo downloadStateInfo) {
            try {
                if (c.f546e) {
                    synchronized (c.this.b) {
                        if (c.this.b.get(str) != null && downloadStateInfo != null) {
                            c.this.e("key:" + str + ": onDSC=" + downloadStateInfo.getState() + ":" + downloadStateInfo.getError() + ":" + downloadStateInfo.getErrorNo() + ":" + downloadStateInfo.getErrorDetail());
                            if (downloadStateInfo.getError() == 104 && !c.this.c.containsKey(str)) {
                                c.this.c.put(str, Boolean.FALSE);
                            }
                            if (g0.a) {
                                if (downloadStateInfo.getError() > 0 && !c.this.c.containsKey(str)) {
                                    c.this.c.put(str, Boolean.FALSE);
                                }
                                g0.b("PlayCacheMgr", "info.getError():" + downloadStateInfo.getError() + ":key:" + str);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (c.this.c.containsKey(str)) {
                j0.b().a(new a(downloadStateInfo, str));
            }
        }

        @Override // e.c.d.d.g
        public void onDownloadStatus(String str, DownloadStatusInfo downloadStatusInfo) {
            if (c.this.c.containsKey(str)) {
                e.c.d.f.a.e().d("PlayCacheMgr", "onDownloadStatus: " + str + "(" + downloadStatusInfo.getDownloadSize() + "/" + downloadStatusInfo.getFileSize() + ")");
            }
        }
    }

    /* JADX INFO: renamed from: e.c.a.g.a.d.x.c$c, reason: collision with other inner class name */
    public static class C0082c {
        public static final c a = new c(null);
    }

    public /* synthetic */ c(a aVar) {
        this();
    }

    public static c g() {
        return C0082c.a;
    }

    public static String k(String str) {
        return str == null ? "" : str.substring(0, Math.min(10240, str.length()));
    }

    public void e(String str) {
        if (TextUtils.isEmpty(str) || !f546e) {
            return;
        }
        try {
            this.a.append(str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void f() {
        synchronized (this.b) {
            Iterator<e.c.d.c> it = this.b.values().iterator();
            while (it.hasNext()) {
                it.next().h(-9100);
                if (g0.f()) {
                    Log.d("异常上报", "LOCAL_DOWNLAOD_CANNEL = -9100");
                }
                it.remove();
            }
        }
    }

    public final DownloadEngine h() {
        return e.c.d.d.d().e();
    }

    public String i() {
        String string = "";
        if (!f546e) {
            return "";
        }
        try {
            string = this.a.toString();
            this.a.setLength(0);
            return string;
        } catch (Throwable th) {
            th.printStackTrace();
            return string;
        }
    }

    public boolean j(String str) {
        synchronized (this.b) {
            if (!this.c.containsKey(str)) {
                return false;
            }
            Boolean bool = this.c.get(str);
            return bool == null || !bool.booleanValue();
        }
    }

    public final long l(String str) {
        return h().makeLocalStream(str);
    }

    @NonNull
    @WorkerThread
    public l m(@NonNull KGMusicWrapper kGMusicWrapper, boolean z) {
        String str;
        e.c.d.f.a.e().d("PlayCacheMgr", "makeStream-" + kGMusicWrapper);
        f();
        String strD = d.d(d.e(kGMusicWrapper.getHashValue(), kGMusicWrapper.getSongQuality(), kGMusicWrapper.getMixId(), kGMusicWrapper.isNeedListenPart()));
        if (d.b(strD)) {
            String str2 = " makeStream-done: " + strD;
            e(str2);
            e.c.d.f.a.e().d("PlayCacheMgr", str2);
            e.c.a.g.a.d.d0.a.a("Play", str2 + ", " + kGMusicWrapper.getMixId());
            return new l(l(strD), null);
        }
        String strA = e.c.a.g.a.d.i.b.a(kGMusicWrapper.getHashValue(), kGMusicWrapper.getSongQuality(), kGMusicWrapper.getMixId());
        if (d.b(strA)) {
            String str3 = " makeStream-local: " + strA;
            e.c.d.f.a.e().d("PlayCacheMgr", str3);
            e(str3);
            e.c.a.g.a.d.d0.a.a("Play", str3 + ", " + kGMusicWrapper.getMixId());
            return new l(l(strA), null);
        }
        CommNetSongUrlInfo commNetSongUrlInfoA = m.a(kGMusicWrapper);
        if (commNetSongUrlInfoA == null || commNetSongUrlInfoA.isError() || commNetSongUrlInfoA.getSpareUrls() == null || commNetSongUrlInfoA.getSpareUrls().isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append(" makeStream-tracker error:");
            if (commNetSongUrlInfoA == null) {
                str = "none";
            } else {
                str = commNetSongUrlInfoA.getErrorType() + ", " + commNetSongUrlInfoA.getErrorMessage() + ", " + commNetSongUrlInfoA.getSpareUrls();
            }
            sb.append(str);
            String string = sb.toString();
            e(string);
            e.c.d.f.a.e().d("PlayCacheMgr", string);
            e.c.a.g.a.d.d0.a.a("Play", string + ", " + kGMusicWrapper.getMixId());
            return new l(0L, commNetSongUrlInfoA);
        }
        String strE = d.e(commNetSongUrlInfoA.getHash(), kGMusicWrapper.getSongQuality(), kGMusicWrapper.getMixId(), kGMusicWrapper.isNeedListenPart());
        c.b bVar = new c.b();
        bVar.f(strE);
        bVar.b(h());
        bVar.h((String[]) commNetSongUrlInfoA.getSpareUrls().toArray(new String[0]));
        bVar.c(commNetSongUrlInfoA.getHash());
        bVar.e(commNetSongUrlInfoA.getFileSize());
        bVar.d(d.f(strE));
        e.c.d.c cVarA = bVar.a();
        DownloadFileInfo downloadFileInfoE = cVarA.e();
        boolean z2 = this.c.containsKey(cVarA.a) && z;
        downloadFileInfoE.setMemoryOnly(z2);
        String strD2 = d.d(strE);
        cVarA.f1282g.setTargetPath(strD2, 0, false);
        synchronized (this.b) {
            this.b.put(cVarA.a, cVarA);
        }
        cVarA.g();
        long jF = cVarA.f();
        String str4 = " makeStream-start" + Arrays.toString(cVarA.c) + cVarA.b + " -> " + strD2 + "size: " + cVarA.f1280e + ", ptr: " + jF + ",fromTry:" + z + ",memoryOnly:" + z2;
        e(str4);
        e.c.d.f.a.e().d("PlayCacheMgr", str4);
        e.c.a.g.a.d.d0.a.a("Play", "makeStream-start, " + kGMusicWrapper.getMixId() + ", " + strD2);
        return new l(jF, commNetSongUrlInfoA);
    }

    public void n(String str, boolean z) {
        synchronized (this.b) {
            this.c.put(str, Boolean.valueOf(z));
        }
    }

    public void o(String str) {
        synchronized (this.b) {
            this.c.remove(str);
        }
    }

    public c() {
        this.a = new StringBuffer();
        this.b = new HashMap();
        this.c = new HashMap();
        this.f547d = new b();
        e.c.d.d.d().g(this.f547d);
        f546e = e.c.a.g.a.f.e.c.c().getConfigAsBoolean(e.c.a.g.a.f.e.b.r1, true);
        if (g0.f()) {
            h().setStatCallback(new a(this));
        }
    }
}
