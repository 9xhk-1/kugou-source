package e.c.a.g.a.d.r.j.e;

import android.os.SystemClock;
import android.text.TextUtils;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.common.music.entity.KGSong;
import com.kugou.common.apm.task.MusicDownloadAPM;
import e.c.a.g.a.d.r.g;
import e.c.a.g.a.d.r.h;
import e.c.a.g.a.d.r.i;
import e.c.a.g.a.d.r.j.c.f;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.p1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b extends f {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public e.c.a.g.a.d.r.k.b f493i;
    public volatile e.c.a.g.a.d.r.k.c j;
    public MusicDownloadAPM k;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.b.callFinish();
        }
    }

    /* JADX INFO: renamed from: e.c.a.g.a.d.r.j.e.b$b, reason: collision with other inner class name */
    public class RunnableC0074b implements Runnable {
        public final /* synthetic */ String a;

        public RunnableC0074b(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.h(this.a);
        }
    }

    public b(e.c.a.g.a.d.r.k.b bVar) {
        super(bVar);
        this.f493i = bVar;
    }

    public final int D() {
        if (!"Download".equals(getTaskInfo().d())) {
            return 0;
        }
        return 0;
    }

    public final boolean E() {
        List<e.c.a.g.a.d.r.n.a<?>> multipleTypeResourceDatas = this.b.getMultipleTypeResourceDatas(1);
        return multipleTypeResourceDatas.size() > 0 && e.c.a.g.a.r.b.G() && e.c.a.g.a.r.b.v() >= multipleTypeResourceDatas.size();
    }

    public final void F() {
    }

    public final void G(int i2, int i3, String str) {
        MusicDownloadAPM musicDownloadAPM = this.k;
        if (musicDownloadAPM != null) {
            musicDownloadAPM.fail(i2, i3, str);
            this.k = null;
        }
    }

    public final List<e.c.a.g.a.d.r.n.a<?>> H(List<e.c.a.g.a.d.r.n.a<?>> list, Collection<KGSong> collection) {
        if (list == null || list.size() == 0 || collection == null || collection.size() == 0) {
            return null;
        }
        long jElapsedRealtime = g0.a ? SystemClock.elapsedRealtime() : 0L;
        ArrayList arrayList = new ArrayList();
        KGSong[] kGSongArr = (KGSong[]) collection.toArray(new KGSong[collection.size() - 1]);
        HashMap map = new HashMap();
        for (KGSong kGSong : kGSongArr) {
            String strX2 = KGSong.x2(kGSong);
            if (!TextUtils.isEmpty(strX2)) {
                map.put(strX2, kGSong);
            }
            String strW2 = KGSong.w2(kGSong);
            if (!TextUtils.isEmpty(strW2)) {
                map.put(strW2, kGSong);
            }
        }
        if (g0.a) {
            g0.e(this.a, "filterPayDatas:[paytime:" + (SystemClock.elapsedRealtime() - jElapsedRealtime) + ",kgSongMap.size=" + map.size() + "]");
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            KGSong kGSong2 = (KGSong) list.get(i2).a();
            if (map.containsKey(KGSong.x2(kGSong2))) {
                arrayList.add(list.get(i2));
            } else if (map.containsKey(KGSong.w2(kGSong2))) {
                arrayList.add(list.get(i2));
            }
        }
        if (g0.a) {
            g0.e(this.a, "filterPayDatas end:[paytime:" + (SystemClock.elapsedRealtime() - jElapsedRealtime) + ",payDatas.size=" + arrayList.size() + "]");
        }
        return arrayList;
    }

    public final void I() {
        if (this.j != null) {
            this.j.c();
        }
    }

    public final boolean J() {
        return !K();
    }

    public boolean K() {
        return this.f493i.p0();
    }

    public final String L(int i2) {
        switch (i2) {
            case 31301:
                return "没有找到对应版权";
            case 31302:
                return "版权不在有效期内";
            case 31303:
                return "版权禁止该行为";
            case 31304:
                return "提供的资源信息不正确 ";
            case 31305:
                return "当前包月下载数已用完";
            case 31306:
                return "资源不存在";
            case 31307:
                return "资源不发布";
            case 31308:
                return "不支持vip支付";
            case 31309:
                return "资源免费使用（不用购买）";
            case 31310:
                return "资源已经购买 ";
            case 31311:
                return "该用户未购买音乐包";
            case 31312:
                return "支付金额不足 ";
            case 31313:
                return "歌曲不允许单独购买";
            case 31314:
                return "酷币系统消费失败";
            case 31315:
                return "请求重复";
            case 31316:
                return "订单号重复";
            case 31317:
                return "系统维护中";
            default:
                switch (i2) {
                    case 31401:
                        return "酷币余额不足 ";
                    case 31402:
                        return "重复订单号";
                    case 31403:
                        return "业务消费失败 ";
                    case 31404:
                        return "appstore验证失败";
                    case 31405:
                        return "订单号不存在 ";
                    case 31406:
                        return "防止消费扣款并发";
                    case 31407:
                        return "获取用户信息失败";
                    case 31408:
                        return "用户不在本机房";
                    default:
                        return "歌曲下载失败(" + i2 + ")";
                }
        }
    }

    public final void M(int i2) {
        if ("Download".equals(getTaskInfo().d())) {
            this.f488d.f().size();
        }
    }

    public final void N(boolean z, int i2, int i3, int i4) {
        if (g0.a) {
            g0.b(this.a, "processBuyFailedForDownload: isDelayDownload=" + z + "    error_code=" + i2);
        }
        p1.h(KGApplication.getContext(), L(i2));
    }

    public final void O(boolean z, int i2, int i3, int i4) {
        if ("Download".equals(getTaskInfo().d())) {
            if (getTaskInfo().e()) {
                g();
            }
            A();
            a();
            if (K()) {
                Q("");
            } else {
                if (TextUtils.isEmpty("")) {
                    return;
                }
                String strC0 = ((e.c.a.g.a.d.r.k.b) this.f488d).c0();
                Q(strC0 != null ? strC0 : "");
            }
        }
    }

    public void P(boolean z, int i2) {
        if (isCurrentAlbumBuy()) {
            r();
            if (!"Download".equals(getTaskInfo().d())) {
                a();
                return;
            }
            this.b.getMultipleTypeResourceDatas(4).clear();
            i();
            this.b.callRefreshUserBalanceAndRemain();
            return;
        }
        if ("Download".equals(getTaskInfo().d()) && !getTaskInfo().e()) {
            a();
            A();
        } else if ("Download".equals(getTaskInfo().d()) && getTaskInfo().e()) {
            i();
            this.b.callRefreshUserBalanceAndRemain();
        }
    }

    public final void Q(String str) {
        this.b.runOnWorkerThread(new RunnableC0074b(str));
    }

    public final void R() {
        MusicDownloadAPM musicDownloadAPM = this.k;
        if (musicDownloadAPM != null) {
            musicDownloadAPM.release();
            this.k = null;
        }
        MusicDownloadAPM musicDownloadAPM2 = new MusicDownloadAPM();
        this.k = musicDownloadAPM2;
        musicDownloadAPM2.start();
    }

    @Override // e.c.a.g.a.d.r.j.c.b
    public boolean c(e.c.a.g.a.d.r.n.a<?> aVar, e.c.a.g.a.d.r.p.a.c cVar) {
        if (!cVar.E() || cVar.G() || aVar.a() == null || !g.u(((KGSong) aVar.a()).q1())) {
            return false;
        }
        aVar.e(e.c.a.g.a.d.r.p.a.c.a(((KGSong) aVar.a()).q1()));
        if (!g0.a) {
            return true;
        }
        g0.e("zzm-log", "--recovery download --" + ((KGSong) aVar.a()).s1() + "--charge:" + ((KGSong) aVar.a()).q1());
        return true;
    }

    @Override // e.c.a.g.a.d.r.j.c.b
    public void d(e.c.a.g.a.d.r.n.a<?> aVar, List<e.c.a.g.a.d.r.p.a.c> list) {
        super.d(aVar, list);
        if (aVar.b() != null) {
            if (aVar.b().C() == 2 || aVar.b().C() == 4) {
                aVar.g(1);
            }
        }
    }

    @Override // e.c.a.g.a.d.r.j.c.f, e.c.a.g.a.d.r.j.d.d, e.c.a.g.a.d.r.n.g
    public void finish() {
        I();
        super.finish();
    }

    @Override // e.c.a.g.a.d.r.j.c.e, e.c.a.g.a.d.r.j.d.b
    public int getSelSongQuality() {
        return this.f493i.e0().getType();
    }

    @Override // e.c.a.g.a.d.r.j.c.b, e.c.a.g.a.d.r.j.d.c
    public e.c.a.g.a.d.r.p.a.c getTargetGoods(e.c.a.g.a.d.r.p.a.c cVar) {
        e.c.a.g.a.d.r.p.a.c cVarB = i.b(cVar, this.f493i.e0());
        return cVarB == null ? cVar : cVarB;
    }

    @Override // e.c.a.g.a.d.r.j.c.g, e.c.a.g.a.d.r.j.d.c
    public boolean isSkipBuy() {
        return "Download".equals(getTaskInfo().d()) && J() && !E() && !isCurrentAlbumBuy();
    }

    @Override // e.c.a.g.a.d.r.j.c.f
    public boolean l() {
        if ((this.f493i.b0() & 1) <= 0 && (this.f493i.b0() & 2) <= 0) {
            return super.l();
        }
        return false;
    }

    @Override // e.c.a.g.a.d.r.j.c.f
    public void m(e.c.a.g.a.d.r.l.a aVar) {
        if (!"Download".equals(getTaskInfo().d())) {
            super.m(aVar);
        }
        if (K() && !getTaskInfo().e()) {
            g();
        }
        F();
        M(aVar.a);
        boolean zJ0 = ((e.c.a.g.a.d.r.k.b) this.f488d).j0();
        int i2 = aVar.a;
        if (i2 == 1) {
            P(zJ0, h.d(getFeeResourceDatas()));
        } else if (i2 != 0) {
            O(zJ0, D(), h.d(getFeeResourceDatas()), aVar.c);
        } else {
            N(zJ0, aVar.b, D(), aVar.c);
        }
    }

    @Override // e.c.a.g.a.d.r.j.c.f
    public void n(e.c.a.g.a.d.r.l.a aVar) {
        super.n(aVar);
    }

    @Override // e.c.a.g.a.d.r.j.c.d, e.c.a.g.a.d.r.j.c.g, e.c.a.g.a.d.r.j.c.e, e.c.a.g.a.d.r.j.d.c
    public void onCreate() {
        super.onCreate();
        R();
    }

    @Override // e.c.a.g.a.d.r.j.c.g, e.c.a.g.a.d.r.j.c.e, e.c.a.g.a.d.r.j.d.c
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // e.c.a.g.a.d.r.j.c.f, e.c.a.g.a.d.r.j.d.c
    public void onEndCheckPrivilege(e.c.a.g.a.d.r.p.a.a aVar) {
        super.onEndCheckPrivilege(aVar);
        if (aVar == null || aVar.f() == 1) {
            return;
        }
        G(2, aVar.c(), aVar.f() + ":" + aVar.c() + ":" + aVar.e());
    }

    @Override // e.c.a.g.a.d.r.j.c.f, e.c.a.g.a.d.r.j.d.c
    public void onFinishFeesDialog(int i2) {
        super.onFinishFeesDialog(i2);
    }

    @Override // e.c.a.g.a.d.r.j.c.f, e.c.a.g.a.d.r.j.d.c
    public void onFinishFeesDialogOnlyFinish() {
        this.b.runOnWorkerThread(new a());
    }

    @Override // e.c.a.g.a.d.r.j.c.b, e.c.a.g.a.d.r.j.d.c
    public List<e.c.a.g.a.d.r.n.a<?>> onProcessDataForCalaulatePrice(List<e.c.a.g.a.d.r.n.a<?>> list, int i2) {
        long jElapsedRealtime;
        if (g0.a) {
            jElapsedRealtime = SystemClock.elapsedRealtime();
            g0.e(this.a, "onProcessDataForCalaulatePrice:[resourceDatas.size=" + list.size() + ",songQuality=" + i2);
        } else {
            jElapsedRealtime = 0;
        }
        new ArrayList();
        if ("Download".equals(getTaskInfo().d()) && getFeeResourceDatas().size() > 0) {
            if (list != null && list.size() != 0) {
                ArrayList arrayList = new ArrayList();
                Iterator<e.c.a.g.a.d.r.n.a<?>> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    e.c.a.g.a.d.r.n.a<?> next = it.next();
                    if (!(next.a() instanceof KGSong)) {
                        arrayList.clear();
                        break;
                    }
                    arrayList.add((KGSong) next.a());
                }
                I();
                this.j = new e.c.a.g.a.d.r.k.c();
                e.c.a.g.a.d.r.k.b bVar = this.f493i;
                Collection<KGSong> collectionA = this.j.a(arrayList, i2, getFeeTaskImpl().f(), bVar != null && (bVar.o0() || this.f493i.x));
                if (collectionA != null && collectionA.size() != 0) {
                    list = H(list, collectionA);
                }
            }
            return null;
        }
        if (g0.a) {
            g0.e(this.a, "onProcessDataForCalaulatePrice end:[paytime:" + (SystemClock.elapsedRealtime() - jElapsedRealtime) + ",payDatas.size=" + list.size() + "]");
        }
        return list;
    }

    @Override // e.c.a.g.a.d.r.j.c.c, e.c.a.g.a.d.r.j.d.b
    public boolean showFeesDialog() {
        return super.showFeesDialog();
    }
}
