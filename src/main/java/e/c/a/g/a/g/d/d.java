package e.c.a.g.a.g.d;

import android.content.Context;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.common.music.entity.KGMusic;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import com.kugou.common.filemanager.downloadengine.entity.FileDownloadState;
import f.u.m;
import f.z.d.j;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class d {
    public static final d a = new d();
    public static final e.c.a.g.a.d.f.c.a.b b;

    static {
        e.c.a.g.a.d.f.b bVar = e.c.a.g.a.d.f.b.a;
        Context context = KGApplication.getContext();
        j.d(context, "getContext()");
        b = bVar.a(context).e();
    }

    public final void a() {
        b.a();
    }

    public final void b(int i2) {
        b.h(i2);
    }

    public final List<e.c.a.g.a.d.f.c.a.a> c() {
        List<e.c.a.g.a.d.f.c.a.a> listI = b.i();
        return listI == null ? m.d() : listI;
    }

    public final e.c.a.g.a.d.f.c.a.a d(String str) {
        j.e(str, "downloadKey");
        return b.l(str);
    }

    public final e.c.a.g.a.d.f.c.a.a e(int i2) {
        return b.k(i2);
    }

    public final List<e.c.a.g.a.d.f.c.a.a> f(int i2, int i3) {
        return b.m(i2, i3);
    }

    public final e.c.a.g.a.d.f.c.a.a g() {
        return b.n();
    }

    public final boolean h() {
        return b.j() > 0;
    }

    public final void i(String str, String str2, String str3, KGMusicWrapper kGMusicWrapper) {
        j.e(str, "key");
        j.e(str2, "filePath");
        j.e(str3, "tmpCachePath");
        if (kGMusicWrapper == null) {
            return;
        }
        e.c.a.g.a.d.f.c.a.a aVar = new e.c.a.g.a.d.f.c.a.a();
        aVar.w(str);
        aVar.x(FileDownloadState.FILE_DOWNLOAD_STATE_SUCCEEDED.ordinal());
        aVar.A(kGMusicWrapper.getMixId());
        aVar.B(kGMusicWrapper.getSongQuality());
        String hashValue = kGMusicWrapper.getHashValue();
        j.d(hashValue, "music.hashValue");
        aVar.C(hashValue);
        String feeAlbumID = kGMusicWrapper.getFeeAlbumID();
        if (feeAlbumID == null) {
            feeAlbumID = "";
        }
        aVar.y(feeAlbumID);
        aVar.z(str2);
        aVar.D(str3);
        b.d(aVar);
        e.c.a.g.a.g.k.a aVar2 = e.c.a.g.a.g.k.a.a;
        KGMusic kgmusic = kGMusicWrapper.getKgmusic();
        j.d(kgmusic, "music.kgmusic");
        aVar2.w(kgmusic);
    }

    public final void j(List<e.c.a.g.a.d.f.c.a.a> list) {
        j.e(list, "list");
        b.e(list);
    }
}
