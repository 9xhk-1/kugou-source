package e.c.a.g.a.g.n;

import android.text.TextUtils;
import com.kugou.android.watch.lite.base.player.entity.CommNetSongUrlInfo;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import com.kugou.common.filemanager.downloadengine.DownloadStateInfo;
import com.kugou.common.filemanager.downloadengine.DownloadStatusInfo;
import com.kugou.common.filemanager.downloadengine.entity.FileDownloadState;
import com.kugou.common.filemanager.downloadengine.stat.IStatInterface;
import com.kugou.common.filemanager.downloadengine.stat.NatProxyClientStat;
import com.kugou.common.filemanager.downloadengine.stat.NatProxyServeStat;
import com.kugou.common.filemanager.downloadengine.stat.OnlineStat;
import com.kugou.common.filemanager.downloadengine.stat.RefreshStat;
import com.kugou.common.filemanager.downloadengine.stat.UploaderStat;
import com.kugou.common.startAppAPM.task.RingBiReportHelper;
import e.c.a.g.a.d.x.m;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.j0;
import e.c.d.c;
import e.c.d.d;
import f.z.d.j;
import java.util.List;
import java.util.Objects;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public final KGMusicWrapper a;
    public String b;
    public final c c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f968d;

    /* JADX INFO: renamed from: e.c.a.g.a.g.n.a$a, reason: collision with other inner class name */
    public static final class C0148a implements IStatInterface {
        @Override // com.kugou.common.filemanager.downloadengine.stat.IStatInterface
        public void OnNatProxyClientStatEvent(NatProxyClientStat natProxyClientStat) {
        }

        @Override // com.kugou.common.filemanager.downloadengine.stat.IStatInterface
        public void OnNatProxyServeStatEvent(NatProxyServeStat natProxyServeStat) {
        }

        @Override // com.kugou.common.filemanager.downloadengine.stat.IStatInterface
        public void OnOnlineStatEvent(OnlineStat onlineStat) {
            if (onlineStat != null) {
                g0.b("KuGouP2P-WatchStat", "Stat{type=" + onlineStat.getType() + ", natType=" + onlineStat.getNatType() + ", succ=" + onlineStat.isSucc() + ", tryNext=" + onlineStat.isTryNext() + ", result='" + ((Object) onlineStat.getResult()) + "', duration=" + onlineStat.getDuration() + ", err='" + ((Object) onlineStat.getErr()) + "', serverIP='" + ((Object) onlineStat.getServerIP()) + "', clientIP='" + ((Object) onlineStat.getClientIP()) + "', kgRC=" + onlineStat.getKgRC() + ", kgRF='" + ((Object) onlineStat.getKgRF()) + "'}");
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

    public interface b {
        void onLoadFail(Integer num, String str);

        void onLoadSuccess(String str);
    }

    public static final class c implements d.g {
        public c() {
        }

        @Override // e.c.d.d.g
        public void onDownloadStateChanged(String str, DownloadStateInfo downloadStateInfo) {
            b bVar;
            j.e(downloadStateInfo, "info");
            if (g0.f()) {
                g0.b("onDownloadStateChanged", "p0:" + ((Object) str) + "  info:" + downloadStateInfo.getState() + " error:" + downloadStateInfo.getError() + "  errorDetail:" + ((Object) downloadStateInfo.getErrorDetail()) + "  targetPath = " + ((Object) downloadStateInfo.getTargetPath()) + "\n, currentDownloadPath = " + a.this.e());
            }
            int state = downloadStateInfo.getState();
            if (state != FileDownloadState.FILE_DOWNLOAD_STATE_SUCCEEDED.ordinal()) {
                if (!(state == FileDownloadState.FILE_DOWNLOAD_STATE_STOP.ordinal() || state == FileDownloadState.FILE_DOWNLOAD_STATE_FAILED.ordinal()) || (bVar = a.this.f968d) == null) {
                    return;
                }
                bVar.onLoadFail(1, j.l("info.state = ", Integer.valueOf(downloadStateInfo.getState())));
                return;
            }
            if (g0.f()) {
                g0.b("mhs_download_rong", "下载成功 info.targetPath = " + ((Object) downloadStateInfo.getTargetPath()) + "\n, currentDownloadPath = " + a.this.e());
            }
            if ((TextUtils.isEmpty(a.this.e()) || !a.this.e().equals(downloadStateInfo.getTargetPath())) && !TextUtils.isEmpty(a.this.e())) {
                return;
            }
            a aVar = a.this;
            String targetPath = downloadStateInfo.getTargetPath();
            j.d(targetPath, "info.targetPath");
            aVar.g(targetPath);
            a.this.h("下载成功 info.targetPath = " + downloadStateInfo + "\n, currentDownloadPath = " + a.this.e(), "/下载器/onDownloadStateChanged");
        }

        @Override // e.c.d.d.g
        public void onDownloadStatus(String str, DownloadStatusInfo downloadStatusInfo) {
            j.e(downloadStatusInfo, "info");
            if (g0.f()) {
                g0.b("onDownloadStateChanged:onDownloadStatus", "str:" + ((Object) str) + "  info:" + downloadStatusInfo.getState() + " filesize:" + downloadStatusInfo.getFileSize() + "  downloadSize:" + downloadStatusInfo.getDownloadSize() + "  speedNow = " + downloadStatusInfo.getSpeedNow() + "\n, currentDownloadPath = " + a.this.e());
            }
        }
    }

    public static final class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            String strD = e.c.a.g.a.d.x.d.d(e.c.a.g.a.d.x.d.e(a.this.a.getHashValue(), a.this.a.getSongQuality(), a.this.a.getMixId(), a.this.a.isNeedListenPart()));
            a aVar = a.this;
            j.d(strD, ClientCookie.PATH_ATTR);
            aVar.i(strD);
            if (g0.f()) {
                g0.b("mhs_download_rong", j.l("load currentDownloadPath = ", a.this.e()));
            }
            if (e.c.a.g.a.d.x.d.b(strD) && e.c.a.g.a.d.x.d.a(strD) > 0) {
                a.this.g(strD);
                a.this.h(strD, "/下载器/检查是否已经缓存完成了");
                return;
            }
            CommNetSongUrlInfo commNetSongUrlInfoA = m.a(a.this.a);
            if (commNetSongUrlInfoA == null || commNetSongUrlInfoA.isError() || commNetSongUrlInfoA.getSpareUrls() == null || commNetSongUrlInfoA.getSpareUrls().isEmpty()) {
                if (g0.f()) {
                    g0.b("mhs_download_rong", j.l("errot info = ", commNetSongUrlInfoA));
                }
                b bVar = a.this.f968d;
                if (bVar != null) {
                    bVar.onLoadFail(2, j.l("errot info = ", commNetSongUrlInfoA));
                }
                a.this.h(j.l("errot info = ", commNetSongUrlInfoA), "/下载器/onLoadFail");
                return;
            }
            String strE = e.c.a.g.a.d.x.d.e(commNetSongUrlInfoA.getHash(), a.this.a.getSongQuality(), a.this.a.getMixId(), a.this.a.isNeedListenPart());
            e.c.d.d.d().e().deleteDownload(strE);
            c.b bVar2 = new c.b();
            bVar2.f(strE);
            bVar2.b(e.c.d.d.d().e());
            List<String> spareUrls = commNetSongUrlInfoA.getSpareUrls();
            j.d(spareUrls, "info.spareUrls");
            Object[] array = spareUrls.toArray(new String[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            bVar2.h((String[]) array);
            bVar2.c(commNetSongUrlInfoA.getHash());
            bVar2.e(commNetSongUrlInfoA.getFileSize());
            bVar2.d(e.c.a.g.a.d.x.d.f(strE));
            e.c.d.c cVarA = bVar2.a();
            String strD2 = e.c.a.g.a.d.x.d.d(strE);
            a aVar2 = a.this;
            j.d(strD2, "targetPath");
            aVar2.i(strD2);
            cVarA.f1282g.setTargetPath(strD2, 0, false);
            cVarA.g();
            String str = "download currentDownloadPath = " + a.this.e() + ", file.filePath = " + ((Object) cVarA.b) + ", file name = " + ((Object) a.this.a.getDisplayName());
            a.this.h("errot info = " + commNetSongUrlInfoA + ", otherData = " + str, "/下载器/requestStart");
            if (g0.f()) {
                g0.b("mhs_download_rong", "download currentDownloadPath = " + a.this.e() + ", file.filePath = " + ((Object) cVarA.b) + ", file name = " + ((Object) a.this.a.getDisplayName()));
            }
        }
    }

    public a(KGMusicWrapper kGMusicWrapper) {
        j.e(kGMusicWrapper, "wrapper");
        this.a = kGMusicWrapper;
        this.b = "";
        c cVar = new c();
        this.c = cVar;
        e.c.d.d.d().g(cVar);
        if (g0.f()) {
            e.c.d.d.d().e().setStatCallback(new C0148a());
        }
    }

    public final void d() {
        e.c.d.d.d().h(this.c);
        this.f968d = null;
    }

    public final String e() {
        return this.b;
    }

    public final void f() {
        this.b = "";
        j0.b().a(new d());
    }

    public final void g(String str) {
        b bVar = this.f968d;
        if (bVar == null) {
            return;
        }
        bVar.onLoadSuccess(str);
    }

    public final void h(String str, String str2) {
        RingBiReportHelper.reportHead$default(RingBiReportHelper.INSTANCE, str, str2, null, 4, null);
    }

    public final void i(String str) {
        j.e(str, "<set-?>");
        this.b = str;
    }

    public final void j(b bVar) {
        j.e(bVar, "l");
        this.f968d = bVar;
    }
}
