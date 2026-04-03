package e.c.a.g.a.d.x;

import androidx.annotation.NonNull;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import e.c.e.c.a.c;

/* JADX INFO: loaded from: classes.dex */
public class b {

    public static class a {

        /* JADX INFO: renamed from: e.c.a.g.a.d.x.b$a$a, reason: collision with other inner class name */
        public static class C0081a {
            public static e.c.e.c.a.c<KGMusicWrapper> a = new o();
        }

        public static e.c.e.c.a.c<KGMusicWrapper> a() {
            return C0081a.a;
        }
    }

    @NonNull
    public static c.a a() {
        return a.a().getIControl();
    }

    @NonNull
    public static c.b<KGMusicWrapper> b() {
        return a.a().getIInfo();
    }

    @NonNull
    public static c.InterfaceC0238c<KGMusicWrapper> c() {
        return a.a().getIQueue();
    }
}
