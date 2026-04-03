package e.c.a.g.a.g.i;

import android.text.TextUtils;
import android.util.Log;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.component.playlist.entity.KGPlaylistMusic;
import e.c.a.g.a.s.g0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class f extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<KGPlaylistMusic> f846d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public e.c.a.g.a.d.f.c.a.j f847f;

    public f(List<KGPlaylistMusic> list, e.c.a.g.a.d.f.c.a.j jVar) {
        this.f846d = list;
        this.f847f = jVar;
        e.c.a.g.a.r.b.o();
        if (list != null) {
            Iterator<KGPlaylistMusic> it = list.iterator();
            while (it.hasNext()) {
                KGPlaylistMusic next = it.next();
                if (next != null && next.e() < 0) {
                    it.remove();
                }
            }
        }
    }

    @Override // e.c.a.g.a.g.i.a
    public void a() {
        int i2 = 0;
        e.c.a.g.a.d.f.c.a.j jVarH = e.c.a.g.a.g.k.b.a.h(this.f847f.d(), false);
        if (jVarH != null) {
            k kVar = new k(e.c.a.g.a.r.b.o(), jVarH.m(), jVarH.H(), jVarH.p());
            boolean z = false;
            for (int i3 = 0; i3 < this.f846d.size(); i3++) {
                int iE = this.f846d.get(i3).e();
                if (iE > 0) {
                    kVar.d(iE);
                    z = true;
                }
            }
            if (z) {
                l lVarA = kVar.a();
                if (lVarA == null || lVarA.b() != 144) {
                    e.c.a.g.a.r.b.V(0);
                    c();
                    if (g0.a) {
                        g0.c("BLUE", "CloudDeleteMusics failed");
                        return;
                    }
                    return;
                }
                int iD = lVarA.d();
                int iA = lVarA.a();
                if (g0.a) {
                    g0.c("yabinCloudSync", "CloudDeleteMusicsThread-->log,mIsUpdate=" + this.a + "\tListFMVersion=" + lVarA.d() + "\tdata.getmBaseListFMVersion()=" + iA);
                }
                if (jVarH.H() != iA && this.a) {
                    c();
                } else if (jVarH.H() == iA || this.a) {
                    e.c.a.g.a.g.k.b bVar = e.c.a.g.a.g.k.b.a;
                    int iB = bVar.b(jVarH.d());
                    Log.d("mhs_watch_fav", "删除任务开始， localCount:" + iB + " localCount2:" + bVar.b(this.f847f.d()) + " mCount:" + lVarA.c() + ", playlist.getGlobalCollectionId() = " + this.f847f.d() + ", mPlaylist.getGlobalCollectionId() = " + jVarH.d());
                    if (x.j(lVarA.c(), iB)) {
                        c();
                    }
                    i2 = iD;
                } else {
                    i2 = iA;
                }
                jVarH.e0(i2);
                e.c.a.g.a.g.k.b.a.A(jVarH.d(), i2);
                if (e.c.a.g.a.d.k.b.a() && KGApplication.getContext().getString(R.string.kg_navigation_my_fav).equals(jVarH.y()) && jVarH.p() == 0) {
                    e.c.a.g.a.r.b.a0(i2);
                    e.c.a.g.a.f.m.b.m().X(true);
                }
            }
        }
    }

    public void d() {
        ArrayList arrayList = new ArrayList(this.f846d.size());
        ArrayList arrayList2 = new ArrayList();
        int size = this.f846d.size();
        while (true) {
            size--;
            if (size <= -1) {
                break;
            }
            KGPlaylistMusic kGPlaylistMusic = this.f846d.get(size);
            if (kGPlaylistMusic.p() > 0) {
                arrayList.add(Long.valueOf(kGPlaylistMusic.p()));
            } else if (!TextUtils.isEmpty(kGPlaylistMusic.i())) {
                arrayList2.add(kGPlaylistMusic.i());
            }
        }
        if (arrayList.size() > 0) {
            e.c.a.g.a.g.k.b.a.x(this.f847f.d(), arrayList);
        }
        if (arrayList2.size() > 0) {
            e.c.a.g.a.g.k.b.a.w(this.f847f.d(), arrayList2);
        }
    }
}
