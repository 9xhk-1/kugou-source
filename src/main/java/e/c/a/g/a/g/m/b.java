package e.c.a.g.a.g.m;

import android.content.Context;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.common.music.entity.KGMusic;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import e.c.a.g.a.d.f.c.a.o;
import e.c.a.g.a.d.f.c.a.q;
import f.z.d.j;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static final b a = new b();
    public static final o b;

    static {
        e.c.a.g.a.d.f.b bVar = e.c.a.g.a.d.f.b.a;
        Context context = KGApplication.getContext();
        j.d(context, "getContext()");
        b = bVar.a(context).k();
    }

    public final q a(KGMusicWrapper kGMusicWrapper) {
        j.e(kGMusicWrapper, "music");
        q qVar = new q();
        qVar.e(System.currentTimeMillis());
        qVar.f(kGMusicWrapper.getMixId());
        String hashValue = kGMusicWrapper.getHashValue();
        j.d(hashValue, "music.hashValue");
        qVar.d(hashValue);
        return qVar;
    }

    public final void b(KGMusic kGMusic) {
        j.e(kGMusic, "music");
        b.h(kGMusic.mixId);
    }

    public final int c() {
        return b.a();
    }

    public final int d() {
        return b.k();
    }

    public final List<q> e(long j, int i2) {
        return b.l(j, i2);
    }

    public final boolean f() {
        return b.k() > 0;
    }

    public final boolean g(KGMusicWrapper kGMusicWrapper) {
        j.e(kGMusicWrapper, "kgMusic");
        if (kGMusicWrapper.getMixId() <= 0) {
            o oVar = b;
            String hashValue = kGMusicWrapper.getHashValue();
            j.d(hashValue, "kgMusic.hashValue");
            if (oVar.i(hashValue) != null) {
                return true;
            }
        } else if (b.j(kGMusicWrapper.getMixId()) != null) {
            return true;
        }
        return false;
    }

    public final void h(List<q> list) {
        j.e(list, "list");
        b.e(list);
    }

    public final void i(KGMusicWrapper kGMusicWrapper) {
        j.e(kGMusicWrapper, "music");
        if (g(kGMusicWrapper)) {
            b.m(kGMusicWrapper.getMixId(), System.currentTimeMillis());
        } else {
            b.d(a(kGMusicWrapper));
        }
        e.c.a.g.a.g.k.a aVar = e.c.a.g.a.g.k.a.a;
        KGMusic kgmusic = kGMusicWrapper.getKgmusic();
        j.d(kgmusic, "music.kgmusic");
        aVar.w(kgmusic);
    }
}
