package e.c.a.g.a.d.i;

import android.os.IBinder;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.base.player.Initiator;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import com.kugou.android.watch.lite.common.music.entity.KGSong;
import e.c.a.g.a.d.i.e;
import e.c.a.g.a.d.o.c.j;
import e.c.a.g.a.d.r.f;
import e.c.a.g.a.s.j0;
import e.c.a.g.a.s.p1;
import e.c.a.g.a.s.u0;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class d {
    public static j<e> a = new a("@1:@manual:FileManager");

    public class a extends j<e> {
        public a(String str) {
            super(str);
        }

        @Override // e.c.a.g.a.d.o.c.j
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public e b(IBinder iBinder) {
            return e.a.a(iBinder);
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ List a;
        public final /* synthetic */ Initiator b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ e.c.a.g.a.d.r.e f440d;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = b.this;
                f.a(bVar.a, bVar.b, bVar.f440d);
            }
        }

        public b(List list, Initiator initiator, e.c.a.g.a.d.r.e eVar) {
            this.a = list;
            this.b = initiator;
            this.f440d = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            j0.b().a(new a());
        }
    }

    public static void a(int i2, String str, int i3, long j) {
        c(new int[]{i2});
    }

    public static void b(int i2, String str, long j) {
        a(i2, str, 0, j);
    }

    public static void c(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            p1.h(KGApplication.getContext(), "你选择的歌曲列表为空");
            return;
        }
        try {
            f().deleteDownloadFile(iArr);
        } catch (RemoteException | e.c.a.g.a.d.o.e.b e2) {
            e2.printStackTrace();
        }
    }

    public static void d(@Nullable List<KGSong> list, Initiator initiator, e.c.a.g.a.d.r.e eVar) {
        if (list == null || list.size() == 0) {
            p1.h(KGApplication.getContext(), "你选择的歌曲列表为空");
        } else {
            u0.e(eVar.getActivity(), new b(list, initiator, eVar));
        }
    }

    public static void e(@Nullable List<KGMusicWrapper> list) {
        try {
            f().startDownload(list);
        } catch (RemoteException | e.c.a.g.a.d.o.e.b e2) {
            e2.printStackTrace();
        }
    }

    public static e f() throws e.c.a.g.a.d.o.e.b {
        return (e) a.c();
    }
}
