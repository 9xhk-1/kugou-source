package e.c.a.g.a.g.m;

import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import f.z.d.g;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public final KGMusicWrapper a;
    public final boolean b;

    public a(KGMusicWrapper kGMusicWrapper, boolean z) {
        this.a = kGMusicWrapper;
        this.b = z;
    }

    public final boolean a() {
        return this.b;
    }

    public final KGMusicWrapper b() {
        return this.a;
    }

    public /* synthetic */ a(KGMusicWrapper kGMusicWrapper, boolean z, int i2, g gVar) {
        this(kGMusicWrapper, (i2 & 2) != 0 ? false : z);
    }
}
