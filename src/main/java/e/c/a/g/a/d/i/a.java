package e.c.a.g.a.d.i;

import android.content.Intent;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.base.player.entity.CommNetSongUrlInfo;
import com.kugou.android.watch.lite.bi.YoungBITask;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import com.kugou.common.apm.task.MusicDownloadAPM;
import com.kugou.common.filemanager.downloadengine.DownloadEngine;
import com.kugou.common.filemanager.downloadengine.DownloadStateInfo;
import com.kugou.common.filemanager.downloadengine.DownloadStatusInfo;
import com.kugou.common.filemanager.downloadengine.entity.FileDownloadState;
import e.c.a.g.a.d.x.k;
import e.c.a.g.a.d.x.m;
import e.c.a.g.a.f.j.a.f;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.j0;
import e.c.a.g.a.s.p1;
import e.c.a.g.a.s.u0;
import e.c.d.c;
import e.c.d.d;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public final e.c.d.e a;
    public final Map<String, KGMusicWrapper> b;
    public final Map<String, MusicDownloadAPM> c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, String> f434d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, e.c.d.c> f435e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, String> f436f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public d.g f437g;

    /* JADX INFO: renamed from: e.c.a.g.a.d.i.a$a, reason: collision with other inner class name */
    public class RunnableC0053a implements Runnable {
        public final /* synthetic */ KGMusicWrapper a;
        public final /* synthetic */ boolean b;

        public RunnableC0053a(KGMusicWrapper kGMusicWrapper, boolean z) {
            this.a = kGMusicWrapper;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            int i2 = 2;
            int i3 = this.a.getInnerKGfile().isEncryptDownload() ? 2 : 1;
            String strJ = e.c.a.g.a.d.i.b.j(this.a.getHashValue(), this.a.getSongQuality(), this.a.getMixId(), i3);
            a.this.o(strJ);
            if (e.c.a.g.a.d.i.b.b(strJ)) {
                if (g0.f()) {
                    g0.b("mhs_download_rong", "addDownload = " + strJ);
                }
                YoungBITask source = new YoungBITask(6, "download").setSource(f.a.b(this.a));
                KGMusicWrapper kGMusicWrapper = this.a;
                e.c.a.g.a.e.b.b(source.setMixsongid(kGMusicWrapper != null ? String.valueOf(kGMusicWrapper.getMixId()) : "").setType("3"));
                if (this.b) {
                    p1.h(KGApplication.getContext(), "歌曲已下载");
                }
                a.this.p(strJ);
                return;
            }
            CommNetSongUrlInfo commNetSongUrlInfoB = m.b(this.a, "download");
            if (commNetSongUrlInfoB == null || commNetSongUrlInfoB.isError() || commNetSongUrlInfoB.getSpareUrls() == null || commNetSongUrlInfoB.getSpareUrls().isEmpty()) {
                if (commNetSongUrlInfoB != null) {
                    str = "errorType - " + commNetSongUrlInfoB.getErrorType() + ", json = " + commNetSongUrlInfoB.getErrorType();
                } else {
                    str = "";
                }
                if (this.b) {
                    String strB = k.b(commNetSongUrlInfoB, "下载失败，歌曲鉴权错误");
                    p1.h(KGApplication.getContext(), strB);
                    str = str + strB;
                }
                if (commNetSongUrlInfoB == null || !u0.n(KGApplication.getContext(), false)) {
                    a.this.l(strJ, 1, 0, "");
                    i2 = 1;
                } else {
                    a.this.l(strJ, 4, commNetSongUrlInfoB.getErrorType(), commNetSongUrlInfoB.getOriginErrIdentify());
                }
                YoungBITask source2 = new YoungBITask(6, "download").setSource(f.a.b(this.a));
                KGMusicWrapper kGMusicWrapper2 = this.a;
                e.c.a.g.a.e.b.b(source2.setMixsongid(kGMusicWrapper2 != null ? String.valueOf(kGMusicWrapper2.getMixId()) : "").setIvar1(str).setType("2"));
                u0.A(24, "DownloadService", "errorStr- " + str + ", errorType = " + i2);
                return;
            }
            String strJ2 = e.c.a.g.a.d.i.b.j(commNetSongUrlInfoB.getHash(), this.a.getSongQuality(), this.a.getMixId(), i3);
            if (e.c.a.g.a.d.i.b.b(strJ2)) {
                if (this.b) {
                    p1.h(KGApplication.getContext(), "歌曲已下载");
                }
                YoungBITask source3 = new YoungBITask(6, "download").setSource(f.a.b(this.a));
                KGMusicWrapper kGMusicWrapper3 = this.a;
                e.c.a.g.a.e.b.b(source3.setMixsongid(kGMusicWrapper3 != null ? String.valueOf(kGMusicWrapper3.getMixId()) : "").setType("3"));
                a.this.p(strJ2);
                return;
            }
            if (this.b) {
                p1.h(KGApplication.getContext(), "已添加到下载");
            }
            String strF = e.c.a.g.a.d.i.b.f(strJ2);
            c.b bVar = new c.b();
            bVar.f(strJ2);
            bVar.b(a.this.n());
            bVar.h((String[]) commNetSongUrlInfoB.getSpareUrls().toArray(new String[0]));
            bVar.c(commNetSongUrlInfoB.getHash());
            bVar.e(commNetSongUrlInfoB.getFileSize());
            bVar.d(strF);
            e.c.d.c cVarA = bVar.a();
            cVarA.f1282g.setIsDownload(true);
            String strE = e.c.a.g.a.d.i.b.e(e.c.a.g.a.d.i.b.h(commNetSongUrlInfoB.getFileName(), commNetSongUrlInfoB.getExtName(), this.a.getDisplayName(), i3));
            cVarA.f1282g.setTargetPath(strE, i3, false);
            cVarA.f1282g.setSpeedUp(e.c.a.g.a.r.b.O());
            a.this.f435e.put(strJ2, cVarA);
            a.this.b.put(strJ2, this.a);
            a.this.f434d.put(strJ2, strE);
            a.this.f436f.put(strJ2, strF);
            if (!a.this.a.a(cVarA)) {
                a.this.n().deleteDownload(cVarA.a);
                a.this.a.c(cVarA);
                a.this.a.a(cVarA);
            }
            e.c.d.f.a.e().d("DownloadService", "startDownload" + Arrays.toString(cVarA.c) + "\n" + cVarA.b + " -> " + strE + "\nsize: " + cVarA.f1280e + "decrypt: " + i3);
        }
    }

    public class b implements d.g {

        /* JADX INFO: renamed from: e.c.a.g.a.d.i.a$b$a, reason: collision with other inner class name */
        public class RunnableC0054a implements Runnable {
            public final /* synthetic */ DownloadStateInfo a;
            public final /* synthetic */ String b;

            public RunnableC0054a(DownloadStateInfo downloadStateInfo, String str) {
                this.a = downloadStateInfo;
                this.b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                String str;
                int state = this.a.getState();
                if (state == FileDownloadState.FILE_DOWNLOAD_STATE_FAILED.ordinal()) {
                    e.c.d.c cVar = (e.c.d.c) a.this.f435e.remove(this.b);
                    if (cVar != null) {
                        a.this.n().deleteDownload(cVar.a);
                        a.this.a.c(cVar);
                    }
                    int error = this.a.getError();
                    str = (("(") + error + ", " + this.a.getErrorNo() + ", " + this.a.getErrorDetail()) + ")";
                    KGMusicWrapper kGMusicWrapper = (KGMusicWrapper) a.this.b.remove(this.b);
                    a.this.f434d.remove(this.b);
                    a.this.f436f.remove(this.b);
                    a.this.l(this.b, 3, this.a.getError(), str);
                    String strK = e.c.a.g.a.d.i.b.k(this.a.getError());
                    p1.h(KGApplication.getContext(), strK);
                    e.c.a.g.a.e.b.b(new YoungBITask(6, "download").setSource(f.a.b(kGMusicWrapper)).setMixsongid(kGMusicWrapper == null ? "" : String.valueOf(kGMusicWrapper.getMixId())).setIvar1(str).setType("2"));
                    u0.A(25, "onDownloadStateChanged", "errorStr-" + strK + ", error - " + error);
                } else {
                    str = "";
                }
                if (state == FileDownloadState.FILE_DOWNLOAD_STATE_SUCCEEDED.ordinal()) {
                    e.c.d.c cVar2 = (e.c.d.c) a.this.f435e.remove(this.b);
                    if (cVar2 != null) {
                        a.this.n().deleteDownload(cVar2.a);
                        a.this.a.c(cVar2);
                    }
                    KGMusicWrapper kGMusicWrapper2 = (KGMusicWrapper) a.this.b.remove(this.b);
                    String str2 = (String) a.this.f434d.remove(this.b);
                    String str3 = (String) a.this.f436f.remove(this.b);
                    if (str2 != null && !str2.equals("") && str3 != null && !str3.equals("")) {
                        e.c.a.g.a.g.d.d.a.i(this.b, str2, str3, kGMusicWrapper2);
                    }
                    a.this.p(this.b);
                    e.c.a.g.a.f.d.a.d(new Intent("com.kugou.android.download_file_success"));
                    p1.h(KGApplication.getContext(), "下载成功");
                    e.c.a.g.a.e.b.b(new YoungBITask(6, "download").setSource(f.a.b(kGMusicWrapper2)).setMixsongid(kGMusicWrapper2 != null ? String.valueOf(kGMusicWrapper2.getMixId()) : "").setType("1"));
                }
                e.c.d.f.a.e().d("DownloadService", "onDownloadStateChanged(" + state + "): " + this.b + str);
            }
        }

        public b() {
        }

        @Override // e.c.d.d.g
        public void onDownloadStateChanged(String str, DownloadStateInfo downloadStateInfo) {
            if (a.this.b.containsKey(str)) {
                j0.b().a(new RunnableC0054a(downloadStateInfo, str));
            }
        }

        @Override // e.c.d.d.g
        public void onDownloadStatus(String str, DownloadStatusInfo downloadStatusInfo) {
            if (a.this.b.containsKey(str)) {
                e.c.d.f.a.e().d("DownloadService", "onDownloadStatus: " + str + "(" + downloadStatusInfo.getDownloadSize() + "/" + downloadStatusInfo.getFileSize() + ")");
            }
        }
    }

    public static class c {
        public static final a a = new a(null);
    }

    public /* synthetic */ a(RunnableC0053a runnableC0053a) {
        this();
    }

    public static a m() {
        return c.a;
    }

    public void j(KGMusicWrapper kGMusicWrapper, boolean z) {
        e.c.a.g.a.e.b.b(new YoungBITask(6, "download").setSource(f.a.b(kGMusicWrapper)).setMixsongid(kGMusicWrapper == null ? "" : String.valueOf(kGMusicWrapper.getMixId())).setType("0"));
        j0.b().a(new RunnableC0053a(kGMusicWrapper, z));
    }

    public void k(List<KGMusicWrapper> list) {
        if (list.size() == 1) {
            j(list.get(0), true);
            return;
        }
        p1.h(KGApplication.getContext(), "已添加到下载");
        Iterator<KGMusicWrapper> it = list.iterator();
        while (it.hasNext()) {
            j(it.next(), false);
        }
    }

    public final void l(String str, int i2, int i3, String str2) {
        MusicDownloadAPM musicDownloadAPMRemove = this.c.remove(str);
        if (musicDownloadAPMRemove != null) {
            musicDownloadAPMRemove.fail(i2, i3, str2);
        }
    }

    public final DownloadEngine n() {
        return e.c.d.d.d().e();
    }

    public final void o(String str) {
        MusicDownloadAPM musicDownloadAPMRemove = this.c.remove(str);
        if (musicDownloadAPMRemove != null) {
            musicDownloadAPMRemove.release();
        }
        MusicDownloadAPM musicDownloadAPM = new MusicDownloadAPM();
        musicDownloadAPM.start();
        this.c.put(str, musicDownloadAPM);
    }

    public final void p(String str) {
        MusicDownloadAPM musicDownloadAPMRemove = this.c.remove(str);
        if (musicDownloadAPMRemove != null) {
            musicDownloadAPMRemove.netFinish();
            musicDownloadAPMRemove.success();
        }
    }

    public a() {
        this.a = new e.c.d.e("DOWNLOAD", 1);
        this.b = new HashMap();
        this.c = new ConcurrentHashMap();
        this.f434d = new HashMap();
        this.f435e = new HashMap();
        this.f436f = new HashMap();
        this.f437g = new b();
        e.c.d.d.d().g(this.f437g);
    }
}
