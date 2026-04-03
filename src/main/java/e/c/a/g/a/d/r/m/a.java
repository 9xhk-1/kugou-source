package e.c.a.g.a.d.r.m;

import android.text.TextUtils;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.fav.CloudMusicModel;
import com.kugou.android.watch.lite.common.music.entity.KGMusic;
import com.kugou.android.watch.lite.common.music.entity.KGSong;
import e.c.a.g.a.d.f.c.a.j;
import e.c.a.g.a.d.r.g;
import e.c.a.g.a.d.r.n.d;
import e.c.a.g.a.d.r.n.f;
import e.c.a.g.a.r.b;
import e.c.a.g.a.s.g0;
import e.c.c.o.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a extends d<KGSong> {
    public CloudMusicModel l;
    public j m;
    public List<KGSong> n;
    public boolean r = false;
    public long s = System.currentTimeMillis();
    public List<KGSong> o = new ArrayList();
    public List<KGSong> p = new ArrayList();
    public List<KGSong> q = new ArrayList();

    public a(CloudMusicModel cloudMusicModel, j jVar, List<KGSong> list) {
        this.l = cloudMusicModel;
        this.n = list;
        this.m = jVar;
        f fVar = new f();
        fVar.f("play");
        fVar.j(0);
        fVar.k("Collection");
        int iN2 = list.get(0).n2();
        O(list.get(0).q2());
        if (y()) {
            fVar.i("collection");
        } else if (iN2 == 8) {
            fVar.i("kKuqunSong");
        } else if (X(iN2)) {
            fVar.i("kUgcMusicLib");
        } else {
            fVar.i("");
        }
        P(fVar);
        if (list != null && list.size() >= 1) {
            N(list.get(0).n2());
        }
        list.size();
    }

    @Override // e.c.a.g.a.d.r.n.d
    public boolean F(e.c.a.g.a.d.r.n.a<KGSong> aVar) {
        return W(aVar.a());
    }

    @Override // e.c.a.g.a.d.r.n.d
    public boolean G() {
        if (x() || y() || v()) {
            return true;
        }
        return super.G();
    }

    @Override // e.c.a.g.a.d.r.n.d
    public int H(int i2) {
        if (g0.a) {
            g0.b("CloudMusicTask", "onPaymentFinished");
        }
        List<KGSong> listT = T(this.f500h);
        listT.addAll(this.p);
        if (!this.r) {
            if (listT.size() == this.o.size()) {
                this.l.z(e.c.c.o.f.a().getResources().getString(R.string.fees_insert_play_failed_listen));
                this.l.o(2);
            } else if (this.o.size() > 0) {
                this.l.o(1);
                this.l.z(e.c.c.o.f.a().getResources().getString(R.string.fees_cloud_success_some_dont_fav));
            }
        }
        e.c.a.g.a.d.k.a.p().n(g(), KGMusic.fromKgSongs(listT), this.m, this.l);
        if (g0.a) {
            g0.e("zzm-log", "onPaymentFinished:" + (System.currentTimeMillis() - this.s) + "size:" + listT.size());
        }
        return 1;
    }

    @Override // e.c.a.g.a.d.r.n.d
    public void I() {
        if (g0.a) {
            g0.b("CloudMusicTask", "processNoPaymentSiduation");
        }
        if (this.n.size() <= this.p.size() || this.p.size() == 0) {
            this.n.size();
            this.q.size();
        } else {
            this.l.o(4);
        }
        e.c.a.g.a.d.k.a.p().n(g(), KGMusic.fromKgSongs(this.n), this.m, this.l);
        if (g0.a) {
            g0.e("zzm-log", "processNoPaymentSiduation:" + (System.currentTimeMillis() - this.s) + "size:" + this.n.size());
        }
    }

    @Override // e.c.a.g.a.d.r.n.d
    public boolean R() {
        if (g0.a) {
            g0.b("CloudMusicTask", "showFeesDialog");
        }
        if (this.f501i != null && this.o.size() == this.n.size()) {
            if (!TextUtils.isEmpty(this.o.size() > 1 ? e.c.c.o.f.a().getResources().getString(R.string.fees_dialog_message_copyright_forbidden_multiple_unpublished) : this.o.size() == 1 ? e.c.c.o.f.a().getResources().getString(R.string.fees_dialog_message_copyright_forbidden_unpublished) : "")) {
                return false;
            }
        }
        if (g0.a) {
            g0.e("zzm-log", "showFeesDialog:" + (System.currentTimeMillis() - this.s));
        }
        return false;
    }

    public List<KGSong> T(List<e.c.a.g.a.d.r.n.a<KGSong>> list) {
        if (list == null || list.size() == 0) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (e.c.a.g.a.d.r.n.a<KGSong> aVar : list) {
            if (aVar.b() != null && g.D(aVar.b())) {
                arrayList.add(aVar.a());
            }
        }
        return arrayList;
    }

    @Override // e.c.a.g.a.d.r.n.d
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public e.c.a.g.a.d.r.p.a.g j(KGSong kGSong) {
        return g.O(kGSong);
    }

    public final boolean V() {
        int i2;
        this.o.clear();
        List<e.c.a.g.a.d.r.n.a<T>> list = this.f500h;
        if (list == 0 || list.size() <= 0) {
            i2 = 0;
        } else {
            i2 = 0;
            for (int i3 = 0; i3 < this.f500h.size(); i3++) {
                e.c.a.g.a.d.r.n.a aVar = (e.c.a.g.a.d.r.n.a) this.f500h.get(i3);
                if (aVar != null && aVar.b() != null && !g.D(aVar.b())) {
                    this.o.add((KGSong) aVar.a());
                    i2++;
                }
            }
        }
        return i2 > 1 && i2 == this.n.size();
    }

    public boolean W(KGSong kGSong) {
        if (y() || v() || x() || X(kGSong.n2())) {
            return true;
        }
        return g.y(kGSong.q1());
    }

    public final boolean X(int i2) {
        return i2 >= 9 && i2 <= 11;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // e.c.a.g.a.d.r.n.d
    public void a() {
        if (g0.a) {
            g0.b("CloudMusicTask", "afterChecktPrivilege");
        }
        super.a();
        if (g0.a) {
            g0.e("zzm-log", "afterChecktPrivilege:" + (System.currentTimeMillis() - this.s));
        }
        this.j = new ArrayList();
        if (!V() || ((e.c.a.g.a.d.r.n.a) this.f500h.get(0)).b() == null || g.D(((e.c.a.g.a.d.r.n.a) this.f500h.get(0)).b())) {
            return;
        }
        this.j.add((e.c.a.g.a.d.r.n.a<T>) ((e.c.a.g.a.d.r.n.a) this.f500h.get(0)));
    }

    @Override // e.c.a.g.a.d.r.n.d
    public void b() {
        super.b();
        if (g0.a) {
            g0.e("zzm-log", "beforeCheckPrivilege:" + (System.currentTimeMillis() - this.s));
        }
    }

    @Override // e.c.a.g.a.d.r.n.d
    public boolean o() {
        if (g0.a) {
            g0.b("CloudMusicTask", "hasPayment");
        }
        boolean z = false;
        for (KGSong kGSong : this.n) {
            if (W(kGSong)) {
                this.q.add(kGSong);
                z = true;
            } else {
                this.p.add(kGSong);
            }
        }
        if (m.z(e.c.c.o.f.a()) && b.J()) {
            return z;
        }
        return false;
    }

    @Override // e.c.a.g.a.d.r.n.d
    public List<e.c.a.g.a.d.r.n.a<KGSong>> q() {
        ArrayList arrayList = new ArrayList();
        if (this.q == null) {
            return arrayList;
        }
        Iterator<KGSong> it = this.n.iterator();
        while (it.hasNext()) {
            arrayList.add(new e.c.a.g.a.d.r.n.a(it.next()));
        }
        return arrayList;
    }
}
