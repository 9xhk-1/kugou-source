package e.c.a.g.a.d.r.k;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import com.kugou.android.watch.lite.common.music.entity.KGSong;
import com.kugou.android.watch.lite.common.music.entity.MusicTransParamEnenty;
import com.kugou.android.watch.lite.common.music.entity.SongQuality;
import com.kugou.common.startAppAPM.task.RingBiReportHelper;
import e.c.a.g.a.d.r.g;
import e.c.a.g.a.d.r.i;
import e.c.a.g.a.d.r.n.f;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.p1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b extends a {
    public static String C = "b";
    public static int D = 1001;
    public boolean A;
    public boolean B;
    public boolean r;
    public boolean s;
    public boolean t;
    public SongQuality u;
    public boolean v;
    public boolean w;
    public boolean x;
    public boolean y;
    public boolean z;

    public b() {
        this.r = false;
        this.s = false;
        this.t = false;
        this.u = SongQuality.QUALITY_LOW;
        this.v = false;
        this.w = false;
        this.x = false;
        this.y = false;
        this.z = false;
        this.A = false;
        this.B = false;
    }

    @Override // e.c.a.g.a.d.r.n.d
    public boolean E() {
        return super.E();
    }

    @Override // e.c.a.g.a.d.r.n.d
    public boolean F(e.c.a.g.a.d.r.n.a<KGSong> aVar) {
        Parcelable parcelableA = aVar.a();
        if (parcelableA instanceof KGMusicWrapper) {
            KGMusicWrapper kGMusicWrapper = (KGMusicWrapper) parcelableA;
            throw new ClassCastException(String.format("参数类型出错，source:%s dName:%s mLinkSource:%s", Integer.valueOf(this.k), kGMusicWrapper.getDisplayName(), Integer.valueOf(kGMusicWrapper.getMusicLinkSource())));
        }
        KGSong kGSongA = aVar.a();
        if (this.r) {
            return false;
        }
        return y() || w() || u() || v() || t() || A() || kGSongA == null || (kGSongA.q1() & 3276) > 0;
    }

    @Override // e.c.a.g.a.d.r.n.d
    public int H(int i2) {
        if (this.w) {
            return 0;
        }
        if (i0()) {
            t0(false);
        }
        if (i2 == D) {
            ArrayList arrayList = new ArrayList();
            Iterator it = this.f500h.iterator();
            while (it.hasNext()) {
                e.c.a.g.a.d.r.n.a<KGSong> aVar = (e.c.a.g.a.d.r.n.a) it.next();
                if (!F(aVar) || (aVar.b() != null && g.p(m(aVar.b())))) {
                    arrayList.add(aVar.a());
                }
            }
            u0(arrayList);
        } else {
            List<KGSong> list = this.l;
            if (list != null && list.size() > 0) {
                u0(this.l);
            }
        }
        return 0;
    }

    @Override // e.c.a.g.a.d.r.n.d
    public void I() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (KGSong kGSong : this.l) {
            linkedHashMap.put(kGSong.J1(), kGSong);
        }
        u0(linkedHashMap.values());
    }

    @Override // e.c.a.g.a.d.r.n.d
    public void Q() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x0138, code lost:
    
        if (r0(1) != false) goto L52;
     */
    @Override // e.c.a.g.a.d.r.n.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean R() {
        /*
            Method dump skipped, instruction units count: 660
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.a.g.a.d.r.k.b.R():boolean");
    }

    public final void U(List<e.c.a.g.a.d.r.n.a<?>> list, e.c.a.g.a.d.r.n.a<KGSong> aVar) {
        e.c.a.g.a.d.r.p.a.c cVarM;
        if (aVar == null || (cVarM = m(aVar.b())) == null || g.y(cVarM.f()) || g.t(cVarM)) {
            return;
        }
        list.add(aVar);
    }

    public final void V(KGSong kGSong) {
        if (this.v) {
            return;
        }
        this.v = !g.y(kGSong.q1());
    }

    public final boolean W(int i2) {
        try {
            e.c.a.g.a.d.r.p.a.c cVarD = e.c.a.g.a.d.r.j.b.g().d(this.f500h, this, e0());
            Log.e("mhs_watch_buged", "checkFreeDialog statusCode = " + i2);
            if (e.c.a.g.a.r.b.F()) {
                e.c.a.g.a.g.h.o.a aVar = e.c.a.g.a.g.h.o.a.a;
                if (aVar.d() && aVar.b() == 1 && i2 == 9 && !e.c.a.g.a.r.b.O()) {
                    if (cVarD != null && g.l(cVarD)) {
                        return false;
                    }
                    Log.d("mhs_watch_toast", "source = 3, 免费歌曲拦截, checkFreeDialog showToastShort:歌曲下载仅供会员使用");
                    p1.h(KGApplication.getContext(), "歌曲下载仅供会员使用");
                    aVar.c("90411");
                    return true;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            RingBiReportHelper.INSTANCE.reportHead2("下载判断异常", "checkFreeDialog onError: e=" + e2);
        }
        return false;
    }

    public final void X(int i2, String str) {
        Log.d("mhs_watch_toast", "source = " + i2 + ", showToastShort:" + str);
        if (!e.c.a.g.a.r.b.F() || e.c.a.g.a.r.b.O()) {
            return;
        }
        e.c.a.g.a.g.h.o.a aVar = e.c.a.g.a.g.h.o.a.a;
        if (aVar.b() == 1 || aVar.b() == 2) {
            aVar.c("90411");
        }
    }

    public final boolean Y(int i2) {
        return false;
    }

    public void Z() {
        this.f501i.pay(false);
    }

    @Override // e.c.a.g.a.d.r.n.d
    public void a() {
        super.a();
        List<e.c.a.g.a.d.r.n.a<T>> list = this.f500h;
        if (list != 0 && list.size() > 0) {
            Iterator it = this.f500h.iterator();
            while (it.hasNext()) {
                e.c.a.g.a.d.r.n.a aVar = (e.c.a.g.a.d.r.n.a) it.next();
                if (aVar != null && aVar.b() != null) {
                    if (p0() && g.n(aVar.b()) && ((KGSong) aVar.a()).U1() != null) {
                        ((KGSong) aVar.a()).b3(aVar.b().f());
                        if (!this.B || this.u == null || ((KGSong) aVar.a()).U1().g() > this.u.getType()) {
                            aVar.e(null);
                        }
                    }
                    if (g.r(aVar.b())) {
                        MusicTransParamEnenty musicTransParamEnenty = ((KGSong) aVar.a()).getMusicTransParamEnenty();
                        if (musicTransParamEnenty == null) {
                            musicTransParamEnenty = new MusicTransParamEnenty();
                            ((KGSong) aVar.a()).setMusicTransParamEnenty(musicTransParamEnenty);
                        }
                        musicTransParamEnenty.setDisplay(aVar.b().h());
                    }
                    if (!p0() && this.l.size() > 1 && this.A && !g.n(aVar.b()) && (((KGSong) aVar.a()).U1() == null || ((KGSong) aVar.a()).T1() > 0)) {
                        this.A = false;
                        this.x = false;
                    }
                    ((KGSong) aVar.a()).b4(aVar.b().t());
                }
            }
        }
        v0();
    }

    public void a0() {
        if ((this.c & 1) > 0) {
            int type = this.u.getType();
            SongQuality songQuality = this.u;
            if (songQuality == SongQuality.QUALITY_NONE) {
                throw new RuntimeException("mBundle MusicSelectDialog.DOWNLOAD_QUELITY_TYPE is empty");
            }
            q0(songQuality);
            this.f501i.doCalaulatePrice(type);
        }
    }

    public int b0() {
        return this.c;
    }

    public String c0() {
        if ((this.c & 1) <= 0 || this.q <= 0) {
            return null;
        }
        return "所选歌曲有" + this.q + "首无版权，不支持升级";
    }

    @Override // e.c.a.g.a.d.r.n.d
    public boolean d() {
        return true;
    }

    @Override // e.c.a.g.a.d.r.n.d
    /* JADX INFO: renamed from: d0, reason: merged with bridge method [inline-methods] */
    public e.c.a.g.a.d.r.p.a.g j(KGSong kGSong) {
        return g.I(kGSong.S4());
    }

    public SongQuality e0() {
        return this.u;
    }

    public boolean f0() {
        List<e.c.a.g.a.d.r.n.a<KGSong>> listF = f();
        if (listF != null && listF.size() != 0) {
            for (e.c.a.g.a.d.r.n.a<KGSong> aVar : listF) {
                if (aVar == null || aVar.b() == null || g.o(m(aVar.b()))) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean g0() {
        int i2 = this.p;
        return i2 > 0 && this.q == i2;
    }

    public final boolean h0() {
        int i2;
        e.c.a.g.a.d.r.p.a.c cVarM;
        List<e.c.a.g.a.d.r.n.a<T>> list = this.f500h;
        if (list == 0 || list.size() <= 0) {
            i2 = 0;
        } else {
            i2 = 0;
            for (int i3 = 0; i3 < this.f500h.size(); i3++) {
                e.c.a.g.a.d.r.n.a aVar = (e.c.a.g.a.d.r.n.a) this.f500h.get(i3);
                if (aVar != null && (cVarM = m(aVar.b())) != null && !g.D(cVarM)) {
                    i2++;
                }
            }
        }
        return i2 > 1 && i2 == this.q;
    }

    public boolean i0() {
        return this.s;
    }

    public boolean j0() {
        return this.t;
    }

    public final boolean k0(KGSong kGSong, SongQuality songQuality) {
        if (kGSong != null && songQuality != null) {
            return (kGSong.q1() & 1092) > 0;
        }
        if (g0.f()) {
            throw null;
        }
        return false;
    }

    public boolean l0() {
        if (g0()) {
            return true;
        }
        List<e.c.a.g.a.d.r.n.a<T>> list = this.f500h;
        if (list == 0 || list.size() <= 0 || this.f500h.get(0) == null) {
            return false;
        }
        for (int i2 = 0; i2 < this.f500h.size(); i2++) {
            e.c.a.g.a.d.r.n.a aVar = (e.c.a.g.a.d.r.n.a) this.f500h.get(i2);
            int iQ1 = ((KGSong) aVar.a()).q1();
            if (aVar.b() != null) {
                iQ1 = aVar.b().f();
            }
            if (!g.u(iQ1)) {
                return false;
            }
        }
        return true;
    }

    @Override // e.c.a.g.a.d.r.n.d
    public e.c.a.g.a.d.r.p.a.c m(e.c.a.g.a.d.r.p.a.c cVar) {
        return i.f(cVar, this.u);
    }

    public final boolean m0() {
        e.c.a.g.a.d.r.p.a.c cVarM;
        List<e.c.a.g.a.d.r.n.a<T>> list = this.f500h;
        if (list == 0 || list.size() <= 0 || this.f500h.get(0) == null || (cVarM = m(((e.c.a.g.a.d.r.n.a) this.f500h.get(0)).b())) == null) {
            return true;
        }
        return (g.y(cVarM.f()) || g.t(cVarM)) ? false : true;
    }

    public final boolean n0() {
        e.c.a.g.a.d.r.p.a.c cVarM;
        List<e.c.a.g.a.d.r.n.a<T>> list = this.f500h;
        if (list == 0 || list.size() <= 0 || this.f500h.get(0) == null || (cVarM = m(((e.c.a.g.a.d.r.n.a) this.f500h.get(0)).b())) == null) {
            return true;
        }
        return !g.y(cVarM.f()) && g.t(cVarM);
    }

    @Override // e.c.a.g.a.d.r.n.d
    public boolean o() {
        return true;
    }

    public boolean o0() {
        return this.A;
    }

    @Override // e.c.a.g.a.d.r.n.d
    public boolean p() {
        return this.z || this.y;
    }

    public boolean p0() {
        return this.o == 0 || this.l.size() == 1;
    }

    @Override // e.c.a.g.a.d.r.n.d
    public List<e.c.a.g.a.d.r.n.a<KGSong>> q() {
        List<KGSong> list = this.l;
        if (list == null) {
            return new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (KGSong kGSong : this.l) {
            if (!TextUtils.isEmpty(kGSong.J1()) || !TextUtils.isEmpty(kGSong.K1()) || !TextUtils.isEmpty(kGSong.t2()) || !TextUtils.isEmpty(kGSong.O1())) {
                arrayList.add(new e.c.a.g.a.d.r.n.a(kGSong));
            }
        }
        return arrayList;
    }

    public void q0(SongQuality songQuality) {
        this.m = songQuality;
        if (this.l == null) {
            return;
        }
        for (int i2 = 0; i2 < this.l.size(); i2++) {
            KGSong kGSong = this.l.get(i2);
            kGSong.t4(kGSong.c2(songQuality).getType());
        }
    }

    public final boolean r0(int i2) {
        List<e.c.a.g.a.d.r.n.a<T>> list = this.j;
        e.c.a.g.a.d.r.p.a.c cVarB = (list == 0 || list.size() <= 0) ? null : ((e.c.a.g.a.d.r.n.a) this.j.get(0)).b();
        if (e.c.a.g.a.r.b.v() < i2 && e.c.a.g.a.r.b.L()) {
            p1.h(KGApplication.getContext(), (cVarB == null || !g.a(m(cVarB))) ? "音乐包份额已用完，不能下载该VIP歌曲" : "音乐包份额不足，单曲购买后即可下载付费歌曲");
            return false;
        }
        if (e.c.a.g.a.r.b.v() < i2 && e.c.a.g.a.r.b.I()) {
            this.f499g.g(true);
            p1.h(KGApplication.getContext(), "音乐包份额已用完，升级为豪华音乐包即可下载VIP歌曲");
        }
        return false;
    }

    public final void s0() {
        List<e.c.a.g.a.d.r.n.a<T>> list = this.f500h;
        if (list == 0 || list.size() == 0) {
            return;
        }
        ArrayList<e.c.a.g.a.d.r.n.a> arrayList = new ArrayList();
        arrayList.addAll(this.f500h);
        for (e.c.a.g.a.d.r.n.a aVar : arrayList) {
            if (aVar != null && aVar.a() != null && aVar.b() != null) {
                ((KGSong) aVar.a()).W2("download");
                ((KGSong) aVar.a()).t4(((KGSong) aVar.a()).c2(this.m).getType());
                if (g.u(aVar.b().f())) {
                    this.l.remove(aVar.a());
                }
            }
        }
    }

    public void t0(boolean z) {
        this.s = z;
    }

    public void u0(Collection<KGSong> collection) {
        HashMap map = new HashMap();
        Iterator it = this.f500h.iterator();
        while (it.hasNext()) {
            e.c.a.g.a.d.r.n.a aVar = (e.c.a.g.a.d.r.n.a) it.next();
            if (aVar != null && aVar.b() != null && e.c.a.g.a.f.j.c.c.b() && e.c.a.g.a.f.j.c.c.d(m(aVar.b()))) {
                map.put(((KGSong) aVar.a()).J1(), Boolean.TRUE);
            }
        }
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<KGSong> it2 = collection.iterator();
        while (it2.hasNext()) {
            KGMusicWrapper kGMusicWrapperF = e.c.a.g.a.f.j.a.c.f(it2.next(), g());
            if (!this.y && map.containsKey(kGMusicWrapperF.getHashValue())) {
                kGMusicWrapperF.getInnerKGfile().setEncryptDownload(true);
            }
            arrayList.add(kGMusicWrapperF);
        }
        e.c.a.g.a.d.i.d.e(arrayList);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public void v0() {
        if (this.f500h.size() == 1 && ((e.c.a.g.a.d.r.n.a) this.f500h.get(0)).b() != null) {
            e.c.a.g.a.d.r.p.a.c cVarM = m(((e.c.a.g.a.d.r.n.a) this.f500h.get(0)).b());
            if (!g.j(cVarM) && g.o(cVarM)) {
                g.v(cVarM.y());
            }
        }
        List<e.c.a.g.a.d.r.n.a<T>> list = this.j;
        if (list != 0) {
            list.clear();
        } else {
            this.j = new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        List<e.c.a.g.a.d.r.n.a<T>> list2 = this.f500h;
        if (list2 == 0 || list2.size() == 0) {
            return;
        }
        if (s() && this.f500h.size() > 0 && F((e.c.a.g.a.d.r.n.a) this.f500h.get(0)) && m(((e.c.a.g.a.d.r.n.a) this.f500h.get(0)).b()) != null && !g.p(m(((e.c.a.g.a.d.r.n.a) this.f500h.get(0)).b())) && g.j(m(((e.c.a.g.a.d.r.n.a) this.f500h.get(0)).b()))) {
            this.j.add((e.c.a.g.a.d.r.n.a<T>) ((e.c.a.g.a.d.r.n.a) this.f500h.get(0)));
            return;
        }
        ArrayList<e.c.a.g.a.d.r.n.a> arrayList2 = new ArrayList();
        this.q = 0;
        Iterator it = this.f500h.iterator();
        while (it.hasNext()) {
            e.c.a.g.a.d.r.n.a aVar = (e.c.a.g.a.d.r.n.a) it.next();
            if (aVar != null && aVar.b() != null) {
                if (g.u(m(aVar.b()).f())) {
                    U(arrayList, aVar);
                    V((KGSong) aVar.a());
                }
                if (g.n(m(aVar.b()))) {
                    arrayList2.add(aVar);
                    this.q++;
                } else if (F(aVar) && !g.p(m(aVar.b()))) {
                    this.j.add((e.c.a.g.a.d.r.n.a<T>) aVar);
                }
            }
        }
        if (arrayList2.size() > 0) {
            for (e.c.a.g.a.d.r.n.a aVar2 : arrayList2) {
                if (!this.A || aVar2.a() == null || ((KGSong) aVar2.a()).U1() == null) {
                    this.l.remove(aVar2.a());
                }
                if (g0.a) {
                    g0.b("suntest", "remove forbiden song" + ((KGSong) aVar2.a()).s1());
                }
            }
        }
    }

    public b(List<KGSong> list) {
        this.r = false;
        this.s = false;
        this.t = false;
        SongQuality songQuality = SongQuality.QUALITY_LOW;
        this.u = songQuality;
        this.v = false;
        this.w = false;
        this.x = false;
        this.y = false;
        this.z = false;
        this.A = false;
        this.B = false;
        this.l = list;
        this.c = 2;
        Bundle bundle = this.n;
        if (bundle != null) {
            this.x = bundle.getBoolean("is_download_all_cloudmusic", false);
            this.n.getBoolean("is_download_all_thirdsong", false);
            this.A = this.n.getBoolean("is_download_need_cloud_tracker", false);
            if (!this.n.getBoolean("is_show_select_dlg", true)) {
                this.c |= 1;
            }
            this.r = this.n.getBoolean("is_need_skip_authentication", false);
        }
        this.u = songQuality;
        if (list.size() >= 1) {
            N(list.get(0).n2());
            T(list.get(0).s2());
            O(list.get(0).q2());
        }
        this.p = this.l.size();
        this.q = 0;
        if (list.size() > 0) {
            K(true);
        }
        for (KGSong kGSong : list) {
            kGSong.W2("download");
            kGSong.t4(kGSong.c2(this.m).getType());
            if (k0(kGSong, this.m)) {
                this.q++;
            }
            if (!g.q(kGSong.n2())) {
                K(false);
            }
        }
        f fVar = new f();
        fVar.f("download");
        fVar.j(1);
        fVar.k("Download");
        fVar.h(g.H(this.m));
        P(fVar);
        f();
    }
}
