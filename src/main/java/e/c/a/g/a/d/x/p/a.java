package e.c.a.g.a.d.x.p;

import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.common.music.entity.KGMusic;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import e.c.a.g.a.d.f.d.b.d;
import e.c.a.g.a.d.x.f;
import e.c.a.g.a.s.k;
import f.z.d.j;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static final a a = new a();

    @WorkerThread
    public final void a(KGMusicWrapper kGMusicWrapper) {
        j.e(kGMusicWrapper, "song");
        if (!TextUtils.isEmpty(kGMusicWrapper.getImgUrl())) {
            c(kGMusicWrapper, kGMusicWrapper.getImgUrl());
            return;
        }
        e.c.a.g.a.d.f.d.a.b bVar = e.c.a.g.a.d.f.d.a.b.a;
        d dVarB = bVar.b(kGMusicWrapper.getMixId(), kGMusicWrapper.getHashValue(), kGMusicWrapper.getDisplayName());
        if (dVarB != null && !TextUtils.isEmpty(dVarB.f()) && k.a(dVarB.a(), System.currentTimeMillis()) < 7) {
            c(kGMusicWrapper, dVarB.f());
            return;
        }
        bVar.a(kGMusicWrapper.getMixId(), kGMusicWrapper.getHashValue(), kGMusicWrapper.getDisplayName());
        c cVar = c.a;
        String hashValue = kGMusicWrapper.getHashValue();
        j.d(hashValue, "song.hashValue");
        String displayName = kGMusicWrapper.getDisplayName();
        j.d(displayName, "song.displayName");
        e.c.a.g.a.f.k.c<String> cVarB = cVar.b(new b(hashValue, displayName, kGMusicWrapper.getMixId()));
        bVar.c(kGMusicWrapper.getMixId(), kGMusicWrapper.getHashValue(), kGMusicWrapper.getDisplayName(), cVarB.a());
        KGMusicWrapper kGMusicWrapperE = f.e();
        long mixId = kGMusicWrapper.getMixId();
        boolean z = false;
        if (kGMusicWrapperE != null && mixId == kGMusicWrapperE.getMixId()) {
            z = true;
        }
        if (z) {
            c(kGMusicWrapper, cVarB.a());
        }
    }

    public final void b(String str) {
        Intent intent = new Intent("com.kugou.young.watch.coverchanged");
        intent.putExtra("arg_song_cover", str);
        e.c.a.g.a.f.d.a.d(intent);
    }

    public final void c(KGMusicWrapper kGMusicWrapper, String str) {
        KGMusic kgmusic = kGMusicWrapper == null ? null : kGMusicWrapper.getKgmusic();
        if (kgmusic != null) {
            kgmusic.imgUrl = str;
        }
        e.c.a.g.a.f.n.a.b().i(40, str);
        b(str);
        e.c.a.g.a.d.u.d.b().showNotification(KGApplication.getContext());
    }
}
