package e.c.a.g.a.d.r.o;

import android.text.TextUtils;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.base.player.Initiator;
import com.kugou.android.watch.lite.base.uistructure.PageKey;
import com.kugou.android.watch.lite.bi.YoungBITask;
import com.kugou.android.watch.lite.common.music.entity.KGFile;
import com.kugou.android.watch.lite.common.music.entity.KGMusic;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import com.kugou.common.filemanager.downloadengine.utils.FileUtil;
import e.c.a.g.a.d.r.d;
import e.c.a.g.a.d.r.g;
import e.c.a.g.a.d.r.n.h;
import e.c.a.g.a.d.s.i;
import e.c.a.g.a.d.x.f;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.l0;
import e.c.a.g.a.s.m0;
import e.c.a.g.a.s.p1;
import e.c.a.g.a.s.r0;
import e.c.a.g.a.s.u0;
import e.c.c.o.m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class c extends e.c.a.g.a.d.r.o.a {
    public int C;
    public ArrayList<KGMusicWrapper> D;
    public ArrayList<KGMusicWrapper> E;
    public boolean F;
    public int G;
    public boolean I;
    public boolean K;
    public boolean L;
    public boolean N;
    public long Q;
    public boolean r;
    public HashSet<KGMusicWrapper> s;
    public boolean t;
    public boolean u;
    public int v;
    public boolean x;
    public int q = 0;
    public boolean w = true;
    public boolean y = false;
    public boolean z = false;
    public boolean A = false;
    public KGMusicWrapper B = null;
    public int H = -1;
    public int J = 0;
    public boolean M = false;
    public boolean O = e.c.a.g.a.f.e.c.c().getConfigAsBoolean(e.c.a.g.a.f.e.b.K3, false);
    public final boolean P = e.c.a.g.a.f.e.c.c().getConfigAsBoolean(e.c.a.g.a.f.e.b.s3, true);
    public boolean R = false;
    public int S = 0;
    public boolean T = false;
    public long U = 0;
    public boolean V = true;

    public class a implements Comparator<e.c.a.g.a.d.r.p.a.c> {
        public a(c cVar) {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(e.c.a.g.a.d.r.p.a.c cVar, e.c.a.g.a.d.r.p.a.c cVar2) {
            return cVar.p() - cVar2.p();
        }
    }

    public final class b extends e.c.a.g.a.d.r.n.b {
        public List<e.c.a.g.a.d.r.n.a<KGMusicWrapper>> a;

        public /* synthetic */ b(c cVar, String str, List list, a aVar) {
            this(str, list);
        }

        public final void a() {
            ArrayList arrayList = new ArrayList();
            for (e.c.a.g.a.d.r.n.a<KGMusicWrapper> aVar : this.a) {
                KGMusicWrapper kGMusicWrapperA = aVar.a();
                e.c.a.g.a.d.r.p.a.c cVarB = aVar.b();
                if (kGMusicWrapperA != null && cVarB != null && cVarB.G()) {
                    arrayList.add(kGMusicWrapperA);
                }
            }
            if (arrayList.size() > 0) {
                f.J(arrayList);
            }
        }

        @Override // e.c.a.g.a.d.r.n.b, java.lang.Runnable
        public void run() {
            e.c.a.g.a.d.r.p.a.f fVarH;
            e.c.a.g.a.d.r.p.a.a aVarG = new d().g(c.this.w0(this.a), c.this.f499g.b(), c.this.f499g.a(), c.this.f499g.c(), m0.a(), !e.c.a.g.a.r.b.O() && e.c.a.g.a.f.e.c.c().getConfigAsBoolean(e.c.a.g.a.f.e.b.h4, true));
            boolean z = aVarG != null && aVarG.f() == 1;
            int iG = aVarG != null ? aVarG.g() : 200;
            if (g0.a) {
                StringBuilder sb = new StringBuilder();
                sb.append("statusCode:");
                sb.append(iG);
                sb.append("--result!=null :");
                sb.append(aVarG != null);
                g0.e("zzm-log", sb.toString());
            }
            if ((!z && e.c.a.g.a.d.r.a.e(iG)) && (fVarH = new d().h(c.this.w0(this.a), c.this.f499g.b(), c.this.f499g.a(), c.this.f499g.c())) != null && (fVarH.f() || fVarH.b())) {
                aVarG = fVarH.a();
                aVarG.m(1);
            }
            if (aVarG != null && aVarG.f() == 1) {
                c.this.s0(this.a, aVarG.d());
                c.this.Y(this.a);
                c.this.A0(this.a, true, false, false);
                a();
            }
            c cVar = c.this;
            cVar.k1(cVar.s.size());
        }

        public b(String str, List<e.c.a.g.a.d.r.n.a<KGMusicWrapper>> list) {
            this.a = list;
        }
    }

    public c(List<KGMusicWrapper> list) {
        if (list == null) {
            this.m = new KGMusicWrapper[0];
        } else {
            this.m = (KGMusicWrapper[]) list.toArray(new KGMusicWrapper[0]);
        }
        if (g0.a) {
            g0.c("unicornhe", "ListenFeeTask <init>");
        }
        U();
    }

    public KGMusicWrapper[] A0(List<e.c.a.g.a.d.r.n.a<KGMusicWrapper>> list, boolean z, boolean z2, boolean z3) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (list == null || list.size() == 0) {
            return new KGMusicWrapper[0];
        }
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            e.c.a.g.a.d.r.n.a<KGMusicWrapper> aVar = list.get(i2);
            if (aVar != null && aVar.a() != null && !this.s.contains(aVar.a()) && I0(aVar, z, z2)) {
                KGMusicWrapper kGMusicWrapperA = aVar.a();
                if (this.T && !TextUtils.isEmpty(kGMusicWrapperA.getCouponID())) {
                    kGMusicWrapperA.setPlayChareStatus(4);
                }
                if (!S0(kGMusicWrapperA) && !kGMusicWrapperA.haveChargOf() && !T0(kGMusicWrapperA, z2) && aVar.d() != 1 && TextUtils.isEmpty(kGMusicWrapperA.getCouponID())) {
                    if (z3) {
                        aVar.a().setNeedCheckListenPartPermission(true);
                    } else if (z && !T0(aVar.a(), z2) && aVar.b() != null) {
                        e.c.a.g.a.d.r.p.a.c cVarB = aVar.b();
                        if (!cVarB.F() && !g.p(cVarB)) {
                            if (r0.h(cVarB.r())) {
                                kGMusicWrapperA.setPlayChareStatus(1);
                            } else if (g.j(cVarB)) {
                                kGMusicWrapperA.setPlayChareStatus(3);
                            } else {
                                kGMusicWrapperA.setPlayChareStatus(2);
                            }
                        }
                    }
                }
                arrayList.add(aVar.a());
            }
        }
        if (g0.a) {
            g0.c("zzm-log", "---getAllAvailableMusic" + (System.currentTimeMillis() - jCurrentTimeMillis) + "list:" + arrayList.size());
        }
        return (KGMusicWrapper[]) arrayList.toArray(new KGMusicWrapper[0]);
    }

    public int B0() {
        return this.D.size() + this.E.size();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int C0(com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper[] r8) {
        /*
            r7 = this;
            boolean r0 = e.c.a.g.a.r.b.G()
            r1 = 0
            if (r0 != 0) goto L6b
            int r0 = r8.length
            r2 = 0
        L9:
            if (r1 >= r0) goto L6a
            r3 = r8[r1]
            java.lang.String r4 = r3.getHashValueV2()
            e.c.a.g.a.d.r.p.a.c r4 = r7.T(r4)
            int r5 = r3.getIsDownloadOrCache()
            r6 = 2
            if (r5 == r6) goto L67
            java.util.HashSet<java.lang.Integer> r5 = r7.n
            int r6 = r3.hashCode()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            boolean r5 = r5.contains(r6)
            if (r5 == 0) goto L2d
            goto L67
        L2d:
            com.kugou.android.watch.lite.common.music.entity.MusicTransParamEnenty r5 = r3.getMusicTransParamEnenty()
            boolean r5 = e.c.a.g.a.s.r0.h(r5)
            if (r5 == 0) goto L52
            if (r4 == 0) goto L3f
            boolean r5 = e.c.a.g.a.d.r.g.p(r4)
            if (r5 != 0) goto L52
        L3f:
            com.kugou.android.watch.lite.base.musicfees.mediastore.entity.TrackerInfo r4 = r3.getTrackerInfo()
            if (r4 == 0) goto L4f
            com.kugou.android.watch.lite.base.musicfees.mediastore.entity.TrackerInfo r3 = r3.getTrackerInfo()
            boolean r3 = r3.isValid()
            if (r3 != 0) goto L67
        L4f:
            int r2 = r2 + 1
            goto L67
        L52:
            if (r4 == 0) goto L67
            boolean r3 = e.c.a.g.a.d.r.g.n(r4)
            if (r3 != 0) goto L67
            boolean r3 = e.c.a.g.a.d.r.g.j(r4)
            if (r3 != 0) goto L67
            boolean r3 = e.c.a.g.a.d.r.g.p(r4)
            if (r3 != 0) goto L67
            goto L4f
        L67:
            int r1 = r1 + 1
            goto L9
        L6a:
            r1 = r2
        L6b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.a.g.a.d.r.o.c.C0(com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper[]):int");
    }

    public final int D0() {
        int size = this.E.size();
        for (KGMusicWrapper kGMusicWrapper : this.E) {
            if (this.z || this.A) {
                if (U0(kGMusicWrapper)) {
                    size--;
                }
            }
        }
        return size;
    }

    @Override // e.c.a.g.a.d.r.n.d
    /* JADX INFO: renamed from: E0, reason: merged with bridge method [inline-methods] */
    public e.c.a.g.a.d.r.p.a.g j(KGMusicWrapper kGMusicWrapper) {
        e.c.a.g.a.d.r.p.a.g gVarI = kGMusicWrapper.isConstructFromKGmusic() ? g.I(kGMusicWrapper.getKgmusic()) : (kGMusicWrapper.isConstructFromKGFile() && this.z) ? g.E(kGMusicWrapper.getInnerKGfile()) : null;
        if (gVarI != null && !r0()) {
            gVarI.n(kGMusicWrapper.isCurSelectedSong());
        }
        return gVarI;
    }

    @Override // e.c.a.g.a.d.r.n.d
    public boolean F(e.c.a.g.a.d.r.n.a<KGMusicWrapper> aVar) {
        return !T0(aVar.a(), !J0());
    }

    public final int F0(KGMusicWrapper[] kGMusicWrapperArr, int i2, boolean z) {
        if (kGMusicWrapperArr == null || kGMusicWrapperArr.length == 0 || !this.O) {
            return i2;
        }
        if (!this.r && !this.y && this.q == 0) {
            return i2;
        }
        if (i2 >= 0 && i2 < kGMusicWrapperArr.length && q0(kGMusicWrapperArr[i2], z)) {
            return i2;
        }
        int length = kGMusicWrapperArr.length;
        int iMin = Math.min(i2, length - 1);
        int i3 = iMin;
        int i4 = i3;
        while (i3 < length && !q0(kGMusicWrapperArr[i3], z)) {
            i4++;
            i3++;
        }
        if (i4 != length) {
            return i4;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < iMin && !q0(kGMusicWrapperArr[i6], z); i6++) {
            i5++;
        }
        return i5 == iMin ? i2 : i5;
    }

    @Override // e.c.a.g.a.d.r.n.d
    public boolean G() {
        return this.I || super.G();
    }

    public int G0() {
        return this.q;
    }

    @Override // e.c.a.g.a.d.r.n.d
    public int H(int i2) {
        e.c.a.g.a.d.r.n.a<KGMusicWrapper> aVar;
        if (this.N) {
            return 1;
        }
        this.T = i2 == 1000;
        V();
        KGMusicWrapper[] kGMusicWrapperArrA0 = A0(this.f500h, true, false, false);
        int i3 = this.q;
        if (i3 == 0) {
            int i4 = this.v;
            if (l0.e(this.f500h) != l0.f(kGMusicWrapperArrA0) && (aVar = (e.c.a.g.a.d.r.n.a) l0.c(this.f500h, this.v)) != null) {
                KGMusicWrapper kGMusicWrapperA = aVar.a();
                if (!I0(aVar, true, false)) {
                    p1.i(KGApplication.getContext(), "该歌曲暂无版权", "onPaymentFinished wrapper=" + kGMusicWrapperA);
                    i4++;
                }
            }
            if (this.s.size() > 0) {
                v0(kGMusicWrapperArrA0);
            } else {
                a1(kGMusicWrapperArrA0, F0(kGMusicWrapperArrA0, Z(this.m, kGMusicWrapperArrA0, i4), true), this.x, this.t);
            }
            Collections.addAll(this.s, kGMusicWrapperArrA0);
            k1(this.s.size());
        } else if (i3 == 1) {
            H0(kGMusicWrapperArrA0);
        } else if (i3 == 2 && kGMusicWrapperArrA0.length > 0) {
            v0(this.m);
        }
        return 1;
    }

    public void H0(KGMusicWrapper[] kGMusicWrapperArr) {
        if (g0.a) {
            StringBuilder sb = new StringBuilder();
            sb.append("insert songs count=");
            sb.append(kGMusicWrapperArr == null ? 0 : kGMusicWrapperArr.length);
            g0.b("ListenFeeTask", sb.toString());
        }
        if (kGMusicWrapperArr != null && kGMusicWrapperArr.length > 0) {
            a0(kGMusicWrapperArr[0]);
            ArrayList arrayList = new ArrayList();
            Collections.addAll(arrayList, kGMusicWrapperArr);
            f.m(W0(), arrayList, R0());
        }
        X(kGMusicWrapperArr);
    }

    @Override // e.c.a.g.a.d.r.n.d
    public void I() {
        if (D()) {
            return;
        }
        if (g0.a) {
            g0.b("ListenFeeTask", "processNoPaymentSiduation");
        }
        KGMusicWrapper[] kGMusicWrapperArrA0 = A0(this.f500h, true, true, true);
        int i2 = this.q;
        if (i2 != 0) {
            if (i2 == 1) {
                H0(kGMusicWrapperArrA0);
                return;
            } else {
                if (i2 != 2) {
                    return;
                }
                v0(kGMusicWrapperArrA0);
                return;
            }
        }
        String strA1 = a1(kGMusicWrapperArrA0, F0(kGMusicWrapperArrA0, Z(this.m, kGMusicWrapperArrA0, this.v), false), this.x, this.t);
        Collections.addAll(this.s, kGMusicWrapperArrA0);
        b1(true, false);
        List<e.c.a.g.a.d.r.n.a<KGMusicWrapper>> listY0 = y0(false);
        if (g0.a) {
            g0.e("listen_part_log", "processNoPaymentSiduation need check size = " + listY0);
        }
        if (listY0.size() > 0) {
            h.c().e(new b(this, strA1, listY0, null));
        } else {
            k1(this.s.size());
        }
    }

    public final boolean I0(e.c.a.g.a.d.r.n.a<KGMusicWrapper> aVar, boolean z, boolean z2) {
        KGMusicWrapper kGMusicWrapperA = aVar.a();
        if (kGMusicWrapperA == null) {
            return false;
        }
        return S0(kGMusicWrapperA) || kGMusicWrapperA.haveChargOf() || !(g.y(aVar.a().getCharge()) || (z && aVar.b() != null && g.n(aVar.b()))) || T0(aVar.a(), z2);
    }

    public final boolean J0() {
        return (G0() == 0 && this.s.size() > 0) || r0();
    }

    public final boolean K0(e.c.a.g.a.d.r.p.a.c cVar) {
        return this.H >= 0 || !cVar.F() || Z0();
    }

    public final boolean L0(KGMusicWrapper kGMusicWrapper) {
        return M0(kGMusicWrapper, true);
    }

    public final boolean M0(KGMusicWrapper kGMusicWrapper, boolean z) {
        return T0(kGMusicWrapper, z);
    }

    public final boolean N0() {
        String couponID = ((KGMusicWrapper) ((e.c.a.g.a.d.r.n.a) this.j.get(0)).a()).getCouponID();
        if (g0.a) {
            g0.e("zzm-log", "劵couponID:" + couponID);
        }
        TextUtils.isEmpty(couponID);
        return false;
    }

    public final boolean O0(KGMusicWrapper kGMusicWrapper) {
        if (kGMusicWrapper.isConstructFromKGmusic() && g.x(kGMusicWrapper.getKgmusic())) {
            return true;
        }
        return this.z && g.w(kGMusicWrapper.getCharge());
    }

    public boolean P0() {
        int i2;
        int i3 = this.C;
        if (i3 > 0 && i3 == this.E.size() && !this.R) {
            return true;
        }
        List<e.c.a.g.a.d.r.n.a<T>> list = this.f500h;
        if (list == 0 || (i2 = this.v) < 0 || i2 >= list.size()) {
            return false;
        }
        int i4 = this.q;
        if (i4 == 0) {
            e.c.a.g.a.d.r.n.a aVar = (e.c.a.g.a.d.r.n.a) this.f500h.get(this.v);
            return (aVar == null || !g.y(((KGMusicWrapper) aVar.a()).getCharge()) || X0((KGMusicWrapper) aVar.a())) ? false : true;
        }
        if (i4 == 1) {
            Iterator it = this.f500h.iterator();
            while (it.hasNext()) {
                e.c.a.g.a.d.r.n.a aVar2 = (e.c.a.g.a.d.r.n.a) it.next();
                if (aVar2 != null && (!g.y(((KGMusicWrapper) aVar2.a()).getCharge()) || X0((KGMusicWrapper) aVar2.a()))) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // e.c.a.g.a.d.r.n.d
    public void Q() {
    }

    public final boolean Q0(KGMusicWrapper kGMusicWrapper) {
        boolean z = false;
        if (kGMusicWrapper.getIsFree() != 0) {
            return kGMusicWrapper.getIsFree() == 1;
        }
        if (O0(kGMusicWrapper) || g.y(kGMusicWrapper.getCharge())) {
            boolean zU0 = U0(kGMusicWrapper);
            KGFile innerKGfile = kGMusicWrapper.getInnerKGfile();
            String filepath = innerKGfile == null ? "" : innerKGfile.getFilepath();
            innerKGfile.getSinger();
            if (!zU0 || !FileUtil.fileIsExist(filepath)) {
                z = zU0;
            }
        } else {
            z = true;
        }
        kGMusicWrapper.setIsFree(z ? 1 : 2);
        return z;
    }

    @Override // e.c.a.g.a.d.r.n.d
    public boolean R() {
        List<e.c.a.g.a.d.r.n.a<T>> list;
        List<e.c.a.g.a.d.r.n.a<T>> list2;
        int i2;
        if (g0.a) {
            g0.b("ListenFeeTask", "showFeesDialog");
        }
        if (this.f501i == null || this.y) {
            return false;
        }
        if (r0()) {
            int i3 = this.C;
            if (i3 <= 0 || i3 != this.S) {
                return false;
            }
            KGMusicWrapper kGMusicWrapper = (KGMusicWrapper) ((e.c.a.g.a.d.r.n.a) this.f500h.get(this.v)).a();
            this.B = kGMusicWrapper;
            if (g.y(kGMusicWrapper.getCharge())) {
                return x0(this.B, true);
            }
            if (this.j.size() >= 1) {
                e.c.a.g.a.d.r.p.a.c cVarB = ((e.c.a.g.a.d.r.n.a) this.j.get(0)).b();
                u0(e.c.a.g.a.d.r.j.b.g().f(cVarB, true), cVarB);
                return true;
            }
        }
        if (P0()) {
            if (this.q == 0 && (list2 = this.f500h) != 0 && (i2 = this.v) >= 0 && i2 < list2.size()) {
                KGMusicWrapper kGMusicWrapper2 = (KGMusicWrapper) ((e.c.a.g.a.d.r.n.a) this.f500h.get(this.v)).a();
                this.B = kGMusicWrapper2;
                return x0(kGMusicWrapper2, true);
            }
            if (this.q != 1 || (list = this.f500h) == 0 || list.size() != 1 || this.f500h.get(0) == null || ((e.c.a.g.a.d.r.n.a) this.f500h.get(0)).a() == null) {
                return x0(null, false);
            }
            KGMusicWrapper kGMusicWrapper3 = (KGMusicWrapper) ((e.c.a.g.a.d.r.n.a) this.f500h.get(0)).a();
            this.B = kGMusicWrapper3;
            return x0(kGMusicWrapper3, true);
        }
        List<e.c.a.g.a.d.r.n.a<T>> list3 = this.j;
        if (list3 != 0 && list3.size() > 0 && this.j.size() == 1) {
            e.c.a.g.a.d.r.p.a.c cVarB2 = ((e.c.a.g.a.d.r.n.a) this.j.get(0)).b();
            if (g.n(cVarB2)) {
                KGMusicWrapper kGMusicWrapper4 = (KGMusicWrapper) ((e.c.a.g.a.d.r.n.a) this.j.get(0)).a();
                this.B = kGMusicWrapper4;
                return x0(kGMusicWrapper4, true);
            }
            if (N0()) {
                return false;
            }
            if (g0.a) {
                g0.c("wuhq", "Fail_process:" + cVarB2.j());
            }
            if (g0.a) {
                g0.c("wuhq", "Pay_type:" + cVarB2.v());
            }
            p1.h(KGApplication.getContext(), "该歌曲需单独购买后畅享，请登录手机端购买后播放");
            KGMusicWrapper kGMusicWrapper5 = (KGMusicWrapper) ((e.c.a.g.a.d.r.n.a) this.j.get(0)).a();
            e.c.a.g.a.e.b.b(new YoungBITask(20495, "exposure").setMixsongid(kGMusicWrapper5 != null ? String.valueOf(kGMusicWrapper5.getMixId()) : ""));
            return true;
        }
        return false;
    }

    public boolean R0() {
        return this.w;
    }

    public final boolean S0(KGMusicWrapper kGMusicWrapper) {
        if (kGMusicWrapper == null) {
            return false;
        }
        return kGMusicWrapper.getKgmusic() == null ? kGMusicWrapper.getInnerKGfile().getClassid() == 20 : kGMusicWrapper.getKgmusic().getIsMusicCloud();
    }

    public final boolean T0(KGMusicWrapper kGMusicWrapper, boolean z) {
        if (!z) {
            c1();
        }
        boolean zQ0 = true;
        if (kGMusicWrapper == null) {
            return true;
        }
        if (kGMusicWrapper.isCurSelectedSong() && kGMusicWrapper.haveChargOf() && kGMusicWrapper.getPlayChareStatus() != 0) {
            return false;
        }
        KGMusic kgmusic = kGMusicWrapper.getKgmusic();
        if ((kgmusic != null && kgmusic.isFromLocalMusic() && this.P && !e.c.a.g.a.r.b.O() && u0.n(KGApplication.getContext(), false)) || this.L) {
            return false;
        }
        if (v()) {
            return U0(kGMusicWrapper);
        }
        if (X0(kGMusicWrapper)) {
            return true;
        }
        if (!z || kGMusicWrapper.isCurSelectedSong()) {
            zQ0 = Q0(kGMusicWrapper);
        } else if (!kGMusicWrapper.haveChargOf() && kGMusicWrapper.isConstructFromKGmusic()) {
            zQ0 = g.A(kgmusic);
        } else if (this.z) {
            zQ0 = g.z(kGMusicWrapper.getInnerKGfile().getPrivilege());
        }
        this.U = (this.U + System.currentTimeMillis()) - this.Q;
        return zQ0;
    }

    @Override // e.c.a.g.a.d.r.o.a
    public void U() {
        KGMusicWrapper kGMusicWrapper;
        super.U();
        e.c.a.g.a.r.b.i();
        this.Q = System.currentTimeMillis();
        this.C = this.m.length;
        this.D = new ArrayList<>();
        this.E = new ArrayList<>();
        b0(this.m[0]);
        for (int i2 = 0; i2 < this.C; i2++) {
            KGMusicWrapper kGMusicWrapper2 = this.m[i2];
            if (kGMusicWrapper2 != null && g.y(kGMusicWrapper2.getCharge())) {
                this.E.add(kGMusicWrapper2);
            } else if (kGMusicWrapper2 != null && g.w(kGMusicWrapper2.getCharge())) {
                this.D.add(kGMusicWrapper2);
            }
        }
        this.s = new HashSet<>();
        e.c.a.g.a.d.r.n.f fVar = new e.c.a.g.a.d.r.n.f();
        this.l = new ArrayList();
        fVar.k("Listen");
        fVar.f("play");
        fVar.j(0);
        KGMusicWrapper[] kGMusicWrapperArr = this.m;
        boolean z = (kGMusicWrapperArr == null || kGMusicWrapperArr.length <= 0 || kGMusicWrapperArr[0] == null || kGMusicWrapperArr[0].getKgmusic() == null || this.m[0].getKgmusic().getSongSource() != 2) ? false : true;
        KGMusicWrapper[] kGMusicWrapperArr2 = this.m;
        if (kGMusicWrapperArr2 != null && kGMusicWrapperArr2.length > 0 && kGMusicWrapperArr2[0] != null) {
            O(kGMusicWrapperArr2[0].getSource());
            c(this.m[0].getInitiator());
        }
        fVar.i(z ? "collection" : "");
        P(fVar);
        KGMusicWrapper[] kGMusicWrapperArr3 = this.m;
        if (kGMusicWrapperArr3 != null && kGMusicWrapperArr3.length >= 1 && kGMusicWrapperArr3[0] != null) {
            N(kGMusicWrapperArr3[0].getSongSource());
        }
        KGMusicWrapper[] kGMusicWrapperArr4 = this.m;
        if (kGMusicWrapperArr4 != null && kGMusicWrapperArr4.length > 0 && (kGMusicWrapper = kGMusicWrapperArr4[0]) != null && kGMusicWrapper.isConstructFromKGmusic()) {
            KGMusicWrapper[] kGMusicWrapperArr5 = this.m;
            if (kGMusicWrapperArr5.length == 1 && kGMusicWrapperArr5[0].getKgmusic().getAudition() == 1) {
                this.J = 1;
            } else if (this.m[0].getKgmusic().getAudition() == 2) {
                this.J = 2;
            }
        }
        if (g0.a) {
            g0.e("zzm-log", "init():" + (System.currentTimeMillis() - this.Q));
        }
    }

    public boolean U0(KGMusicWrapper kGMusicWrapper) {
        return e.c.a.g.a.r.b.G() && g.B(kGMusicWrapper, false);
    }

    public boolean V0(e.c.a.g.a.d.r.n.a<KGMusicWrapper> aVar, boolean z) {
        return !T0(aVar.a(), z);
    }

    public boolean W0() {
        return this.u;
    }

    public final boolean X0(KGMusicWrapper kGMusicWrapper) {
        if (kGMusicWrapper == null || kGMusicWrapper.getKgmusic() == null) {
            return false;
        }
        int songSource = kGMusicWrapper.getKgmusic().getSongSource();
        String module = kGMusicWrapper.getKgmusic().getModule();
        if (songSource < 9 || songSource > 11) {
            return false;
        }
        return TextUtils.isEmpty(module) || module.equals("kUgcUpload");
    }

    public final boolean Y0(e.c.a.g.a.d.r.n.a<?> aVar, e.c.a.g.a.d.r.p.a.c cVar) {
        if (!cVar.E() || cVar.G() || aVar.a() == null || !g.y(((KGMusicWrapper) aVar.a()).getCharge())) {
            return false;
        }
        aVar.e(e.c.a.g.a.d.r.p.a.c.a(((KGMusicWrapper) aVar.a()).getCharge()));
        if (!g0.a) {
            return true;
        }
        g0.e("zzm-log", "--recovery--" + ((KGMusicWrapper) aVar.a()).getDisplayName() + "--charge:" + ((KGMusicWrapper) aVar.a()).getCharge());
        return true;
    }

    public boolean Z0() {
        return this.J == 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // e.c.a.g.a.d.r.n.d
    public void a() {
        KGMusicWrapper kGMusicWrapper;
        KGMusicWrapper kGMusicWrapper2;
        if (g0.a) {
            g0.b("ListenFeeTask", "afterChecktPrivilege" + (System.currentTimeMillis() - this.Q));
        }
        this.S = 0;
        Y(this.f500h);
        if (this.f500h != 0 && k() == 12) {
            Iterator it = this.f500h.iterator();
            while (it.hasNext()) {
                e.c.a.g.a.d.r.n.a aVar = (e.c.a.g.a.d.r.n.a) it.next();
                if (aVar != null && (kGMusicWrapper2 = (KGMusicWrapper) aVar.a()) != null) {
                    KGMusic kgmusic = kGMusicWrapper2.getKgmusic();
                    e.c.a.g.a.d.r.p.a.c cVarB = aVar.b();
                    if (kgmusic != null && cVarB != null && cVarB.o() != null) {
                        kgmusic.setDuration(cVarB.o().b());
                    }
                }
            }
        }
        if (this.f500h != 0 && k() == 13) {
            Iterator it2 = this.f500h.iterator();
            while (it2.hasNext()) {
                e.c.a.g.a.d.r.n.a aVar2 = (e.c.a.g.a.d.r.n.a) it2.next();
                if (aVar2 != null && (kGMusicWrapper = (KGMusicWrapper) aVar2.a()) != null) {
                    t0(kGMusicWrapper.getKgmusic(), aVar2.b());
                }
            }
        }
        this.j = new ArrayList();
        if (this.q == 0) {
            int size = this.f500h.size();
            int i2 = this.v;
            if (size > i2 && i2 >= 0) {
                e.c.a.g.a.d.r.n.a aVar3 = (e.c.a.g.a.d.r.n.a) this.f500h.get(i2);
                if (aVar3.b() != null && !g.j(aVar3.b()) && g.o(aVar3.b()) && aVar3.a() != null) {
                    g.v(((KGMusicWrapper) aVar3.a()).getCharge());
                }
                if ((F(aVar3) && aVar3.b() != null && !g.p(aVar3.b()) && K0(aVar3.b())) || (aVar3.b() != null && !g.D(aVar3.b()))) {
                    this.j.add((e.c.a.g.a.d.r.n.a<T>) aVar3);
                    g.j(aVar3.b());
                }
                if (r0()) {
                    n0();
                }
            }
        } else if (this.f500h.size() == 1) {
            e.c.a.g.a.d.r.n.a aVar4 = (e.c.a.g.a.d.r.n.a) this.f500h.get(0);
            if (((aVar4 != null && aVar4.b() != null && F(aVar4) && !g.p(aVar4.b()) && K0(aVar4.b())) || (aVar4 != null && aVar4.b() != null && !g.D(aVar4.b()))) && ((aVar4 != null && aVar4.b() != null && F(aVar4) && !g.p(aVar4.b()) && K0(aVar4.b())) || (aVar4 != null && aVar4.b() != null && !g.D(aVar4.b())))) {
                this.j.add((e.c.a.g.a.d.r.n.a<T>) aVar4);
                g.j(aVar4.b());
            }
        } else if (this.q == 1) {
            boolean zR0 = r0();
            Iterator it3 = this.f500h.iterator();
            while (it3.hasNext()) {
                e.c.a.g.a.d.r.n.a aVar5 = (e.c.a.g.a.d.r.n.a) it3.next();
                if (aVar5 != null && aVar5.b() != null && ((aVar5.a() != null && aVar5.b() != null && F(aVar5) && !g.p(aVar5.b()) && K0(aVar5.b())) || (aVar5.b() != null && !g.D(aVar5.b())))) {
                    g.j(aVar5.b());
                    this.j.add((e.c.a.g.a.d.r.n.a<T>) aVar5);
                    this.G++;
                    o0(zR0);
                }
            }
        }
        d1();
    }

    public String a1(KGMusicWrapper[] kGMusicWrapperArr, int i2, boolean z, boolean z2) {
        if (g0.a) {
            StringBuilder sb = new StringBuilder();
            sb.append("openSongList songs count=");
            sb.append(kGMusicWrapperArr == null ? 0 : kGMusicWrapperArr.length);
            g0.b("ListenFeeTask", sb.toString());
        }
        if (i2 >= 0 && kGMusicWrapperArr != null && kGMusicWrapperArr.length > i2 && r0.h(kGMusicWrapperArr[i2].getMusicTransParamEnenty()) && e.c.a.g.a.r.b.G()) {
            p1.h(KGApplication.getContext(), "正在为您播放会员专属歌曲");
            KGMusicWrapper kGMusicWrapper = kGMusicWrapperArr[i2];
            e.c.a.g.a.e.b.b(new YoungBITask(20493, "exposure").setMixsongid(kGMusicWrapper != null ? String.valueOf(kGMusicWrapper.getMixId()) : "").setType("2"));
            this.K = true;
        }
        X(kGMusicWrapperArr);
        if (kGMusicWrapperArr != null && kGMusicWrapperArr.length > 0) {
            a0(kGMusicWrapperArr[0]);
            ArrayList arrayList = new ArrayList();
            Collections.addAll(arrayList, kGMusicWrapperArr);
            f.A(W0(), arrayList, i2, z2);
        }
        return "";
    }

    public final boolean b1(boolean z, boolean z2) {
        KGMusicWrapper[] kGMusicWrapperArrA0;
        int i2 = this.v;
        int i3 = 0;
        if (i2 >= 0 && i2 < this.f500h.size()) {
            if (this.s.size() > 0) {
                KGMusicWrapper[] kGMusicWrapperArrA02 = A0(this.f500h, z, z2, false);
                if (kGMusicWrapperArrA02 != null && kGMusicWrapperArrA02.length > 0) {
                    v0(kGMusicWrapperArrA02);
                    Collections.addAll(this.s, kGMusicWrapperArrA02);
                    if (g0.a) {
                        g0.b("ListenFeeTask", "playedFreeSongsFirst enqueue songs count=" + kGMusicWrapperArrA02.length);
                    }
                    return true;
                }
            } else {
                e.c.a.g.a.d.r.n.a aVar = (e.c.a.g.a.d.r.n.a) this.f500h.get(this.v);
                if ((M0((KGMusicWrapper) aVar.a(), z2) || ((z && aVar.b() != null && g.p(aVar.b())) || this.r)) && (kGMusicWrapperArrA0 = A0(this.f500h, z, z2, false)) != null && kGMusicWrapperArrA0.length > 0) {
                    int i4 = -1;
                    while (true) {
                        if (i3 >= kGMusicWrapperArrA0.length) {
                            break;
                        }
                        if (kGMusicWrapperArrA0[i3] == aVar.a()) {
                            i4 = i3;
                            break;
                        }
                        i3++;
                    }
                    a1(kGMusicWrapperArrA0, i4, this.x, this.t);
                    if (g0.a) {
                        g0.c("zzm-log", "2.第一首歌是可播放歌曲，加了歌曲进入到播放队列--" + (System.currentTimeMillis() - this.Q));
                    }
                    Collections.addAll(this.s, kGMusicWrapperArrA0);
                    if (g0.a) {
                        g0.b("ListenFeeTask", "playedFreeSongsFirst paly songs count=" + kGMusicWrapperArrA0.length);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public boolean c0() {
        return this.F;
    }

    public final void c1() {
        if (this.V) {
            this.V = false;
            ArrayList arrayList = new ArrayList();
            if (this.z || this.A) {
                arrayList.addAll(this.E);
            }
            arrayList.addAll(this.D);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                int isDownloadOrCache = ((KGMusicWrapper) it.next()).getIsDownloadOrCache();
                if (isDownloadOrCache == 2 || isDownloadOrCache == 1) {
                    it.remove();
                }
            }
        }
    }

    @Override // e.c.a.g.a.d.r.n.d
    public boolean d() {
        return true;
    }

    public final void d1() {
        ArrayList<KGMusicWrapper> arrayList = this.E;
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        Iterator<KGMusicWrapper> it = this.E.iterator();
        if (it.hasNext()) {
            KGMusicWrapper next = it.next();
            if (!g.y(next.getCharge())) {
                this.E.remove(next);
                if (g0.a) {
                    g0.e("zzm-log", "移除非禁止歌曲" + next.getDisplayName());
                }
            }
        }
        List<e.c.a.g.a.d.r.n.a<T>> list = this.f500h;
        if (list == 0 || list.size() <= 0) {
            return;
        }
        Iterator it2 = this.f500h.iterator();
        while (it2.hasNext()) {
            e.c.a.g.a.d.r.n.a aVar = (e.c.a.g.a.d.r.n.a) it2.next();
            if (aVar.b() != null && !g.y(aVar.b().f())) {
                this.R = true;
                return;
            }
        }
    }

    public void e1(boolean z) {
        this.w = z;
    }

    public void f1(int i2) {
        this.v = i2;
    }

    public void g1(boolean z) {
        this.u = z;
    }

    public void h1(boolean z) {
        this.t = z;
    }

    public void i1(int i2) {
        this.q = i2;
    }

    public final boolean j1() {
        if (this.T || this.K) {
            return true;
        }
        if (!this.L) {
            return C0(this.m) > 0 || z0(this.m) > 0;
        }
        m.m(e.c.c.o.f.a());
        return true;
    }

    public final void k1(int i2) {
        if (!j1() && this.r) {
            KGMusicWrapper[] kGMusicWrapperArr = this.m;
            if (i2 >= (kGMusicWrapperArr == null ? 0 : kGMusicWrapperArr.length) - D0()) {
            }
        }
    }

    public final void n0() {
        Iterator it = this.f500h.iterator();
        while (it.hasNext()) {
            e.c.a.g.a.d.r.n.a<KGMusicWrapper> aVar = (e.c.a.g.a.d.r.n.a) it.next();
            if (aVar != null && aVar.b() != null && ((F(aVar) && aVar.b() != null && !g.p(aVar.b()) && K0(aVar.b())) || (aVar.b() != null && !g.D(aVar.b())))) {
                this.S++;
            }
        }
    }

    @Override // e.c.a.g.a.d.r.n.d
    public boolean o() {
        System.currentTimeMillis();
        J(q());
        KGMusicWrapper[] kGMusicWrapperArr = this.m;
        boolean z = false;
        if (kGMusicWrapperArr == null || kGMusicWrapperArr.length == 0) {
            return false;
        }
        if (kGMusicWrapperArr.length == 1 && kGMusicWrapperArr[0] != null) {
            kGMusicWrapperArr[0].setCurSelectedSong(true);
        }
        int i2 = this.v;
        if (i2 < 0 || i2 >= this.m.length) {
            i2 = 0;
        }
        KGMusicWrapper kGMusicWrapper = this.m[i2];
        if (kGMusicWrapper != null) {
            this.y = !kGMusicWrapper.haveChargOf() && 1012 == kGMusicWrapper.getSongSource();
            this.z = B();
            this.A = y() || z();
            kGMusicWrapper.setCurSelectedSong(true);
        }
        if (this.r || this.y) {
            KGMusicWrapper[] kGMusicWrapperArr2 = this.m;
            int length = kGMusicWrapperArr2.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                KGMusicWrapper kGMusicWrapper2 = kGMusicWrapperArr2[i3];
                if (kGMusicWrapper2 != null && L0(kGMusicWrapper2)) {
                    z = true;
                    break;
                }
                i3++;
            }
            return !z;
        }
        if (this.q == 0) {
            if (L0(kGMusicWrapper) || S0(kGMusicWrapper)) {
                return false;
            }
            if (m.z(KGApplication.getContext()) || !(i.a(kGMusicWrapper) || r0.e(kGMusicWrapper.getMusicTransParamEnenty()))) {
                return !this.M;
            }
            if (!g0.a) {
                return false;
            }
            g0.e("listen_part_log", "hasPayment not net, exist can play cache file");
            return false;
        }
        KGMusicWrapper[] kGMusicWrapperArr3 = this.m;
        int length2 = kGMusicWrapperArr3.length;
        int i4 = 0;
        while (true) {
            if (i4 >= length2) {
                break;
            }
            if (!L0(kGMusicWrapperArr3[i4])) {
                z = true;
                break;
            }
            i4++;
        }
        if (g0.a) {
            g0.e("zzm-log", "hasPayment()" + (System.currentTimeMillis() - this.Q));
        }
        return z;
    }

    public final void o0(boolean z) {
        if (z) {
            this.S++;
        }
    }

    public void p0() {
        if (g0.a) {
            g0.b("ListenFeeTask", "afterGetFeeResource" + (System.currentTimeMillis() - this.Q));
        }
        if (J0()) {
            G0();
        }
    }

    public final boolean q0(KGMusicWrapper kGMusicWrapper, boolean z) {
        e.c.a.g.a.d.r.p.a.c cVarT;
        if (S0(kGMusicWrapper) || kGMusicWrapper.haveChargOf() || kGMusicWrapper.getIsDownloadOrCache() == 2 || ((kGMusicWrapper.getIsDownloadOrCache() == 1 && (!r0.h(kGMusicWrapper.getMusicTransParamEnenty()) || e.c.a.g.a.r.b.G())) || r0.e(kGMusicWrapper.getMusicTransParamEnenty()) || T0(kGMusicWrapper, true) || !TextUtils.isEmpty(kGMusicWrapper.getCouponID()))) {
            return true;
        }
        if (!z || (cVarT = T(kGMusicWrapper.getHashValueV2())) == null) {
            return false;
        }
        return cVarT.F() || g.p(cVarT) || (g.j(cVarT) && this.l.contains(Integer.valueOf(cVarT.m())));
    }

    public final boolean r0() {
        KGMusicWrapper[] kGMusicWrapperArr;
        if (this.y) {
            return false;
        }
        if (this.r) {
            return true;
        }
        return this.q == 1 && (kGMusicWrapperArr = this.m) != null && kGMusicWrapperArr.length >= 2;
    }

    public final List<e.c.a.g.a.d.r.n.a<KGMusicWrapper>> s0(List<e.c.a.g.a.d.r.n.a<KGMusicWrapper>> list, List<e.c.a.g.a.d.r.p.a.c> list2) {
        if (list == null || list2 == null || list.size() != list2.size()) {
            return new ArrayList();
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            e.c.a.g.a.d.r.p.a.c cVar = list2.get(i2);
            e.c.a.g.a.d.r.n.a<KGMusicWrapper> aVar = list.get(i2);
            if (!Y0(aVar, cVar)) {
                aVar.e(cVar);
            }
            List<e.c.a.g.a.d.r.p.a.c> listA = cVar.A();
            if (listA != null) {
                Collections.sort(listA, new a(this));
            }
        }
        return list;
    }

    public final void t0(KGMusic kGMusic, e.c.a.g.a.d.r.p.a.c cVar) {
        if (kGMusic == null || cVar == null) {
            return;
        }
        List<e.c.a.g.a.d.r.p.a.c> listA = cVar.A();
        kGMusic.setDisplayName(cVar.s());
        kGMusic.setArtistName(cVar.B());
        kGMusic.setDuration(cVar.o().b());
        for (e.c.a.g.a.d.r.p.a.c cVar2 : listA) {
            if (cVar2 != null) {
                int iP = cVar2.p();
                if (iP == 2) {
                    kGMusic.setHashValue(cVar2.k());
                    kGMusic.setSize(cVar2.o().d());
                } else if (iP == 4) {
                    kGMusic.setHash320(cVar2.k());
                    kGMusic.setSize320(cVar2.o().d());
                } else if (iP == 5) {
                    kGMusic.setSqHash(cVar2.k());
                    kGMusic.setSqSize(cVar2.o().d());
                }
            }
        }
    }

    public final void u0(int i2, e.c.a.g.a.d.r.p.a.c cVar) {
        this.f501i.showListenDialog(i2, cVar);
    }

    public void v0(KGMusicWrapper[] kGMusicWrapperArr) {
        if (g0.a) {
            StringBuilder sb = new StringBuilder();
            sb.append("enqueue songs count=");
            sb.append(kGMusicWrapperArr == null ? 0 : kGMusicWrapperArr.length);
            g0.b("ListenFeeTask", sb.toString());
        }
        if (kGMusicWrapperArr != null && kGMusicWrapperArr.length > 0) {
            a0(kGMusicWrapperArr[0]);
            ArrayList arrayList = new ArrayList();
            Collections.addAll(arrayList, kGMusicWrapperArr);
            f.c(W0(), arrayList);
        }
        X(kGMusicWrapperArr);
    }

    public final List<e.c.a.g.a.d.r.p.a.g> w0(List<e.c.a.g.a.d.r.n.a<KGMusicWrapper>> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        for (e.c.a.g.a.d.r.n.a<KGMusicWrapper> aVar : list) {
            if (F(aVar)) {
                e.c.a.g.a.d.r.p.a.g gVarP = aVar.b() != null ? g.P(aVar.b()) : aVar.c();
                if (gVarP != null) {
                    try {
                        if (aVar.a() != null && aVar.a().getInitiator() != null) {
                            Initiator initiator = aVar.a().getInitiator();
                            gVarP.o(PageKey.make(initiator.url, (int) initiator.pageCode, initiator.stack));
                        }
                    } catch (Exception unused) {
                    }
                    arrayList.add(gVarP);
                }
            }
        }
        return arrayList;
    }

    public final boolean x0(KGMusicWrapper kGMusicWrapper, boolean z) {
        p1.i(KGApplication.getContext(), "歌曲暂无版权，我们正在努力争取中~", "forbiddonToMv, warpper:" + kGMusicWrapper);
        e.c.a.g.a.e.b.b(new YoungBITask(20497, "exposure").setMixsongid(kGMusicWrapper != null ? String.valueOf(kGMusicWrapper.getMixId()) : ""));
        return true;
    }

    public final List<e.c.a.g.a.d.r.n.a<KGMusicWrapper>> y0(boolean z) {
        ArrayList arrayList = new ArrayList();
        List<e.c.a.g.a.d.r.n.a<T>> list = this.f500h;
        if (list == 0) {
            return arrayList;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            e.c.a.g.a.d.r.n.a<KGMusicWrapper> aVar = (e.c.a.g.a.d.r.n.a) it.next();
            if (V0(aVar, z)) {
                arrayList.add(aVar);
                if (aVar.c() == null) {
                    aVar.f(j(aVar.a()));
                }
            }
        }
        return arrayList;
    }

    public final int z0(KGMusicWrapper[] kGMusicWrapperArr) {
        int i2 = 0;
        for (KGMusicWrapper kGMusicWrapper : kGMusicWrapperArr) {
            e.c.a.g.a.d.r.p.a.c cVarT = T(kGMusicWrapper.getHashValueV2());
            if (kGMusicWrapper.getIsDownloadOrCache() != 2 && !this.n.contains(Integer.valueOf(kGMusicWrapper.hashCode())) && cVarT != null && g.j(cVarT) && !g.p(cVarT)) {
                i2++;
            }
        }
        return i2;
    }
}
