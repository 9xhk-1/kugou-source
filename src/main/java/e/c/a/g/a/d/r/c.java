package e.c.a.g.a.d.r;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentTransaction;
import com.kugou.android.watch.lite.base.activity.AbsFrameworkActivity;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.base.player.Initiator;
import com.kugou.android.watch.lite.base.uistructure.PageKey;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.j0;
import e.c.a.g.a.s.l0;
import e.c.a.g.a.s.m0;
import e.c.a.g.a.s.p1;
import e.c.a.g.a.s.u0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes.dex */
public class c implements e.c.a.g.a.d.r.e, e.c.a.g.a.d.r.j.d.a {
    public static final String u = "c";
    public static e v;
    public static volatile c w;
    public AbsFrameworkActivity a;
    public e.c.a.g.a.d.r.j.c.e b;
    public List<e.c.a.g.a.d.r.n.a<?>> c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<e.c.a.g.a.d.r.n.a<?>> f475d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public e.c.a.g.a.d.r.n.f f476e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d f477f;
    public Timer l;
    public List<e.c.a.g.a.d.r.n.a<?>> n;
    public List<e.c.a.g.a.d.r.n.a<?>> o;
    public List<e.c.a.g.a.d.r.n.a<?>> p;
    public List<e.c.a.g.a.d.r.n.a<?>> q;
    public List<e.c.a.g.a.d.r.n.a<?>> r;
    public List<e.c.a.g.a.d.r.n.a<?>> s;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f478g = new Object();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public PageKey f479h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f480i = false;
    public boolean j = false;
    public int k = 0;
    public final Object m = new Object();
    public List<e.c.a.g.a.d.r.n.a<?>> t = new ArrayList();

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.b != null) {
                c.this.b.hideLoadingView();
            }
            c.this.onDestroy();
        }
    }

    public class b extends TimerTask {
        public b(c cVar) {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            c.v.sendEmptyMessage(10);
        }
    }

    /* JADX INFO: renamed from: e.c.a.g.a.d.r.c$c, reason: collision with other inner class name */
    public class RunnableC0071c implements Runnable {
        public RunnableC0071c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            p1.h(KGApplication.getContext(), "该歌曲需单独购买后畅享，请登录手机端购买后播放");
            c.this.p();
        }
    }

    public static class d extends Handler {
        public WeakReference<Activity> a;
        public c b;

        public d(Looper looper, Activity activity, c cVar) {
            super(looper);
            this.a = new WeakReference<>(activity);
            this.b = cVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Activity activity = this.a.get();
            if (activity == null || activity.isFinishing()) {
                return;
            }
            int i2 = message.what;
            if (i2 == 4101) {
                if (e.c.a.g.a.r.b.F()) {
                    new e.c.a.g.a.d.r.r.b.b().a(activity);
                }
                return;
            }
            if (i2 == 4113) {
                if (this.b.b != null) {
                    this.b.b.onFinishFeesDialogOnlyFinish();
                    return;
                }
                return;
            }
            switch (i2) {
                case FragmentTransaction.TRANSIT_FRAGMENT_OPEN /* 4097 */:
                    this.b.I();
                    this.b.s();
                    break;
                case InputDeviceCompat.SOURCE_TOUCHSCREEN /* 4098 */:
                    this.b.K();
                    break;
                case FragmentTransaction.TRANSIT_FRAGMENT_FADE /* 4099 */:
                    this.b.F();
                    break;
                default:
                    switch (i2) {
                        case 4108:
                            if (this.b.b != null) {
                                e.c.a.g.a.d.r.j.c.e eVar = this.b.b;
                                Object obj = message.obj;
                                eVar.onFinishFeesDialog(obj == null ? 0 : ((Integer) obj).intValue());
                            }
                            break;
                        case 4109:
                            this.b.I();
                            if (e.c.a.g.a.r.b.F()) {
                                new e.c.a.g.a.d.r.r.b.b().b(this.b.getActivity(), m0.a());
                                new e.c.a.g.a.d.r.p.b.e().e(m0.a());
                            }
                            this.b.s();
                            break;
                        case 4110:
                            if (this.b.b != null) {
                                this.b.b.onPayInBackGuound();
                            }
                            break;
                        default:
                            if (g0.a) {
                                g0.c(c.u, "FeesBackHandler handler error message");
                            }
                            break;
                    }
                    break;
            }
        }
    }

    public static class e extends Handler {
        public WeakReference<Activity> a;
        public c b;

        public e(Looper looper, Activity activity, c cVar) {
            super(looper);
            this.a = new WeakReference<>(activity);
            this.b = cVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Activity activity = this.a.get();
            if (activity == null || activity.isFinishing()) {
                return;
            }
            switch (message.what) {
                case 8:
                    this.b.C();
                    break;
                case 9:
                case 13:
                case 15:
                case 16:
                case 17:
                case 18:
                default:
                    if (g0.a) {
                        g0.c(c.u, "FeesUIHandler handler error message");
                    }
                    this.b.finish();
                    break;
                case 10:
                    this.b.B();
                    break;
                case 11:
                    this.b.y();
                    break;
                case 12:
                    Runnable runnable = (Runnable) message.obj;
                    if (runnable != null) {
                        runnable.run();
                    }
                    break;
                case 14:
                    if (this.b.b != null) {
                        this.b.b.onShowFeesDialog();
                    }
                    break;
                case 19:
                    this.b.A();
                    break;
                case 20:
                    this.b.z();
                    break;
                case 21:
                    this.b.D();
                    break;
            }
        }
    }

    public static c v() {
        if (w == null) {
            synchronized (c.class) {
                if (w == null) {
                    w = new c();
                }
            }
        }
        return w;
    }

    public final void A() {
        this.j = true;
        p1.h(this.a, "网络异常，请稍后重试");
        finish();
        u0.A(28, "onUIProcessNoNetWork", "网络异常，请稍后重试");
    }

    public final void B() {
        if (this.j) {
            return;
        }
        this.f480i = true;
        p1.h(this.a, "网络请求超时");
        finish();
        u0.A(26, "onUIProcessTimeout", "网络请求超时");
    }

    public final void C() {
        this.j = true;
        finish();
    }

    public final void D() {
        if (this.f480i) {
            return;
        }
        this.j = true;
        this.b.hideLoadingView();
        H();
    }

    public final void E() {
        synchronized (this.m) {
            Timer timer = this.l;
            if (timer != null) {
                timer.cancel();
            }
        }
    }

    public final void F() {
        List<e.c.a.g.a.d.r.n.a<?>> list = this.f475d;
        if (list == null) {
            this.f477f.sendEmptyMessage(4108);
        } else if (list.size() == 0) {
            q();
        } else {
            w(this.f475d);
        }
    }

    public final void G(int i2) {
    }

    public final void H() {
    }

    public final void I() {
        if (this.b == null) {
            finish();
            return;
        }
        b bVar = new b(this);
        int iB = m0.b(this.k);
        this.f480i = false;
        this.j = false;
        synchronized (this.m) {
            Timer timer = new Timer();
            this.l = timer;
            timer.schedule(bVar, iB);
        }
    }

    public final void J(List<e.c.a.g.a.d.r.n.a<?>> list, int i2) {
        for (e.c.a.g.a.d.r.n.a<?> aVar : this.c) {
            Iterator<e.c.a.g.a.d.r.n.a<?>> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    e.c.a.g.a.d.r.n.a<?> next = it.next();
                    if (aVar.c() != null && next.c() != null) {
                        if (!aVar.c().g().equals("audio")) {
                            if (aVar.c().d() == next.c().d()) {
                                aVar.g(i2);
                                break;
                            }
                        } else {
                            if (aVar.c().c() == next.c().c()) {
                                aVar.g(i2);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public final void K() {
        this.b.afterChecktPrivilege();
        List<e.c.a.g.a.d.r.n.a<?>> payFeeResourceDatas = this.b.getPayFeeResourceDatas();
        this.f475d = payFeeResourceDatas;
        if (payFeeResourceDatas != null && payFeeResourceDatas.size() > 0) {
            doCalaulatePrice(this.f475d, this.b.getSelSongQuality());
            return;
        }
        List<e.c.a.g.a.d.r.n.a<?>> list = this.t;
        if (list != null) {
            list.clear();
        }
    }

    @Override // e.c.a.g.a.d.r.e
    public e.c.a.g.a.d.r.e attachActivity(AbsFrameworkActivity absFrameworkActivity) {
        this.a = absFrameworkActivity;
        return this;
    }

    @Override // e.c.a.g.a.d.r.j.d.a
    public void callCheckPrivilege(long j) {
        if (g0.a) {
            g0.e(u, "callCheckPrivilege : " + j);
        }
        this.f477f.sendEmptyMessageDelayed(FragmentTransaction.TRANSIT_FRAGMENT_OPEN, j);
    }

    @Override // e.c.a.g.a.d.r.j.d.a
    public void callDestory() {
        onDestroy();
    }

    @Override // e.c.a.g.a.d.r.j.d.a
    public void callFinish() {
        finish();
    }

    @Override // e.c.a.g.a.d.r.j.d.a
    public void callFinishFeesDialog(int i2) {
        this.f477f.sendEmptyMessage(4108);
    }

    @Override // e.c.a.g.a.d.r.j.d.a
    public void callFinishFeesDialogOnlyFinish() {
        this.f477f.sendEmptyMessage(4113);
    }

    @Override // e.c.a.g.a.d.r.j.d.a
    public void callGetMusicPkgAds(String str) {
        this.f477f.obtainMessage(4112, str).sendToTarget();
    }

    @Override // e.c.a.g.a.d.r.j.d.a
    public void callPayInBackGuound() {
        this.f477f.sendEmptyMessage(4110);
    }

    @Override // e.c.a.g.a.d.r.j.d.a
    public void callRefreshUserBalanceAndRemain() {
        this.f477f.sendEmptyMessage(4109);
    }

    @Override // e.c.a.g.a.d.r.j.d.a
    public void callUpdateLocalPrivilegeResult(boolean z) {
        if (g0.a) {
            g0.e(u, "callUpdateLocalPrivilegeResult:" + z);
        }
        if (z) {
            this.f477f.sendEmptyMessage(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        } else {
            this.f477f.removeMessages(InputDeviceCompat.SOURCE_TOUCHSCREEN);
            this.f477f.sendEmptyMessage(InputDeviceCompat.SOURCE_TOUCHSCREEN);
        }
    }

    @Override // e.c.a.g.a.d.r.j.d.a
    public void callUpdateUserBalance() {
        this.f477f.sendEmptyMessage(4101);
    }

    @Override // e.c.a.g.a.d.r.j.d.a
    public List<e.c.a.g.a.d.r.n.a<?>> doCalaulatePrice(List<e.c.a.g.a.d.r.n.a<?>> list, int i2) {
        if (g0.a) {
            g0.b(u, "doCalaulatePrice/start songQuality:---------" + i2);
        }
        long jD = 0;
        int iV = e.c.a.g.a.r.b.v();
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.p = new ArrayList();
        this.q = new ArrayList();
        this.r = new ArrayList();
        this.s = new ArrayList();
        this.t = new ArrayList();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        List<e.c.a.g.a.d.r.n.a<?>> listOnProcessDataForCalaulatePrice = this.b.onProcessDataForCalaulatePrice(arrayList, i2);
        if (listOnProcessDataForCalaulatePrice == null) {
            return null;
        }
        for (e.c.a.g.a.d.r.n.a<?> aVar : listOnProcessDataForCalaulatePrice) {
            e.c.a.g.a.d.r.p.a.c targetGoods = this.b.getTargetGoods(aVar.b());
            if (targetGoods != null) {
                if (g.n(targetGoods)) {
                    this.p.add(aVar);
                } else if (!g.j(targetGoods)) {
                    int iE = e.c.a.g.a.d.r.j.b.g().e(targetGoods);
                    if (iE == 1) {
                        targetGoods.x();
                        this.o.add(aVar);
                    } else if (iE == 2) {
                        this.s.add(aVar);
                    } else if (iE == 3) {
                        targetGoods.x();
                        this.o.add(aVar);
                    } else if (iE == 4) {
                        this.s.add(aVar);
                    } else if (iE == 6) {
                        this.r.add(aVar);
                    } else if (iE == 7) {
                        targetGoods.x();
                        this.o.add(aVar);
                        this.s.add(aVar);
                    } else if (iE == 8) {
                        targetGoods.x();
                        this.o.add(aVar);
                        this.r.add(aVar);
                    } else if (iE != 10) {
                        if (iE == 15 || iE == 16) {
                            this.s.add(aVar);
                        }
                    } else if (iV > 0) {
                        this.n.add(aVar);
                        iV--;
                    } else if (g.a(targetGoods)) {
                        targetGoods.x();
                        this.o.add(aVar);
                    }
                    jD += (long) ((targetGoods.o().d() / 1024) / 1024);
                } else if (g.a(targetGoods) || g.b(targetGoods)) {
                    if (listOnProcessDataForCalaulatePrice.size() == 1) {
                        targetGoods.x();
                    }
                    jD += (long) ((targetGoods.o().d() / 1024) / 1024);
                    this.q.add(aVar);
                }
            }
        }
        this.b.setDownloadSize(jD);
        if (g0.a) {
            String str = u;
            g0.b(str, "doCalaulatePrice/payDatas:---------" + listOnProcessDataForCalaulatePrice.size());
            g0.b(str, "doCalaulatePrice/albumDatas:-------" + this.q.size());
            g0.b(str, "doCalaulatePrice/walletPayDatas:---" + this.o.size());
            g0.b(str, "doCalaulatePrice/packagePayDatas:--" + this.n.size());
            g0.b(str, "doCalaulatePrice/forbiddenDatas:---" + this.p.size());
            g0.b(str, "doCalaulatePrice/vipFreeDatas:-----" + this.r.size());
            g0.b(str, "doCalaulatePrice/packageFreeDatas:-" + this.s.size());
            g0.b(str, "doCalaulatePrice:需购买资源/非免费资源总数" + listOnProcessDataForCalaulatePrice.size() + "/" + arrayList.size());
            e.c.a.g.a.d.r.j.a.e(str, "doCalaulatePrice/专辑收费资源", this.q);
            e.c.a.g.a.d.r.j.a.e(str, "doCalaulatePrice/酷币购买资源", this.o);
            e.c.a.g.a.d.r.j.a.e(str, "doCalaulatePrice/音乐包付费资源", this.n);
            e.c.a.g.a.d.r.j.a.e(str, "doCalaulatePrice/禁用的资源", this.p);
            e.c.a.g.a.d.r.j.a.e(str, "doCalaulatePrice/VIP免费资源", this.r);
            e.c.a.g.a.d.r.j.a.e(str, "doCalaulatePrice/音乐包免费资源", this.s);
        }
        this.t = listOnProcessDataForCalaulatePrice;
        return listOnProcessDataForCalaulatePrice;
    }

    @Override // e.c.a.g.a.d.r.e, e.c.a.g.a.d.r.j.d.a
    public void finish() {
        j0.g(new a());
    }

    @Override // e.c.a.g.a.d.r.e
    public void finishInMainThread() {
        e.c.a.g.a.d.r.j.c.e eVar = this.b;
        if (eVar != null) {
            eVar.hideLoadingView();
        }
        onDestroy();
    }

    @Override // e.c.a.g.a.d.r.j.d.a
    public List<e.c.a.g.a.d.r.n.a<?>> getMultipleTypeResourceDatas(int i2) {
        if (g0.a) {
            g0.e(u, "getMultipleTypeResourceDatas/type:" + i2);
        }
        switch (i2) {
            case 1:
                return this.n;
            case 2:
                return this.o;
            case 3:
                return this.p;
            case 4:
                return this.q;
            case 5:
                return this.r;
            case 6:
                return this.s;
            case 7:
                return this.t;
            case 8:
                return this.f475d;
            case 9:
                return this.c;
            default:
                return null;
        }
    }

    @Override // e.c.a.g.a.d.r.j.d.a
    public e.c.a.g.a.d.r.e getMusicFeesDelegate() {
        return this;
    }

    public final int o() {
        List<e.c.a.g.a.d.r.n.a<?>> list = this.t;
        if (list == null || list.size() <= 0) {
            return 0;
        }
        int size = this.t.size();
        if (e.c.a.g.a.r.b.O()) {
            size -= this.r.size();
        }
        return e.c.a.g.a.r.b.G() ? size - this.s.size() : size;
    }

    @Override // e.c.a.g.a.d.r.e
    public void onCreate() {
        if (g0.a) {
            g0.e(u, "onCreate");
        }
        AbsFrameworkActivity absFrameworkActivity = this.a;
        if (absFrameworkActivity == null) {
            finish();
            return;
        }
        if (absFrameworkActivity.g() == null) {
            finish();
            return;
        }
        e.c.a.g.a.d.r.j.c.e eVar = this.b;
        if (eVar != null && eVar.getFeeTaskImpl() != null) {
            this.b.getFeeTaskImpl().g();
        }
        if (this.f479h == null && this.a.f() != null && this.a.f().V() != null && this.a.f().V().m() != null) {
            this.f479h = this.a.f().V().m();
        }
        r();
        this.f477f = new d(this.a.g(), this.a, this);
        v = new e(this.a.getMainLooper(), this.a, this);
        x();
        e.c.a.g.a.d.r.j.c.e eVar2 = this.b;
        if (eVar2 == null) {
            return;
        }
        eVar2.onCreate();
        if (this.b.isInteceptInterrupt()) {
            finish();
        } else {
            this.f477f.sendEmptyMessageDelayed(FragmentTransaction.TRANSIT_FRAGMENT_OPEN, 0L);
        }
    }

    @Override // e.c.a.g.a.d.r.e
    public void onDestroy() {
        if (g0.a) {
            g0.e(u, "onDestroy");
        }
        this.a = null;
        e.c.a.g.a.d.r.j.c.e eVar = this.b;
        if (eVar != null) {
            eVar.onDestroy();
        }
        d dVar = this.f477f;
        if (dVar != null) {
            dVar.removeCallbacksAndMessages(null);
            this.f477f.removeCallbacks(null);
        }
        e eVar2 = v;
        if (eVar2 != null) {
            eVar2.removeCallbacksAndMessages(null);
        }
        E();
    }

    public final void p() {
        callFinishFeesDialog(0);
    }

    @Override // e.c.a.g.a.d.r.j.d.a
    public e.c.a.g.a.d.r.l.a processBuyResource() {
        int i2;
        int size;
        int iO = o();
        int iC = -1;
        if (this.b.isSkipBuy()) {
            i2 = -1;
        } else {
            int iF = 0;
            if (this.b.isCurrentAlbumBuy() && !l0.g(this.q) && e.c.a.g.a.r.b.G() && (!g.a(this.b.getTargetGoods(this.q.get(0).b())) || g.b(this.b.getTargetGoods(this.q.get(0).b())))) {
                e.c.a.g.a.d.r.p.a.a aVarB = new e.c.a.g.a.d.r.d().b(this.b.feeDataToPrivilegeResource(this.q), this.f476e.d().toString(), this.f476e.b(), "", this.b.getTargetGoods(this.q.get(0).b()).w());
                if (aVarB != null) {
                    iF = aVarB.f();
                    iC = aVarB.c();
                }
                J(this.q, iF);
                if (iF == 1) {
                    size = this.q.size();
                    iO -= size;
                }
                i2 = iC;
                iC = iF;
                G(iC);
            } else if (l0.g(this.n)) {
                i2 = -1;
                G(iC);
            } else {
                e.c.a.g.a.d.r.p.a.a aVarC = new e.c.a.g.a.d.r.d().c(this.b.feeDataToPrivilegeResource(this.n), this.f476e.d().toString(), this.f476e.b(), "");
                if (aVarC != null) {
                    iF = aVarC.f();
                    iC = aVarC.c();
                }
                J(this.n, iF);
                if (iF == 1) {
                    size = this.n.size();
                    iO -= size;
                }
                i2 = iC;
                iC = iF;
                G(iC);
            }
        }
        return new e.c.a.g.a.d.r.l.a(iC, i2, iO);
    }

    public final void q() {
        v.obtainMessage(14, -3, 0).sendToTarget();
    }

    public final void r() {
        synchronized (this.f478g) {
            d dVar = this.f477f;
            if (dVar != null) {
                dVar.removeCallbacksAndMessages(null);
            }
            e eVar = v;
            if (eVar != null) {
                eVar.removeCallbacksAndMessages(null);
            }
            this.k = 0;
            this.j = false;
            this.f480i = false;
            e.c.a.g.a.d.r.j.a.a(this.c);
            e.c.a.g.a.d.r.j.a.a(this.f475d);
            e.c.a.g.a.d.r.j.a.a(this.t);
            e.c.a.g.a.d.r.j.a.a(this.s);
            e.c.a.g.a.d.r.j.a.a(this.o);
            e.c.a.g.a.d.r.j.a.a(this.p);
            e.c.a.g.a.d.r.j.a.a(this.q);
            e.c.a.g.a.d.r.j.a.a(this.r);
            e.c.a.g.a.d.r.j.a.a(this.s);
        }
    }

    @Override // e.c.a.g.a.d.r.j.d.a
    public void runOnUIThread(Runnable runnable) {
        v.obtainMessage(12, runnable).sendToTarget();
    }

    @Override // e.c.a.g.a.d.r.j.d.a
    public void runOnUIThreadDelay(Runnable runnable, long j) {
        v.postDelayed(runnable, j);
    }

    @Override // e.c.a.g.a.d.r.j.d.a
    public void runOnWorkerThread(Runnable runnable) {
        this.f477f.post(runnable);
    }

    public final void s() {
        if (g0.a) {
            g0.e(u, "start doCheckPrivilege");
        }
        e.c.a.g.a.d.r.j.c.e eVar = this.b;
        if (eVar == null) {
            finish();
            return;
        }
        boolean z = false;
        if (eVar.getFeeTaskImpl() != null && this.b.getFeeTaskImpl().g() != null) {
            if (this.b.getFeeTaskImpl().l() == null || !this.b.getFeeTaskImpl().l().contains("推荐内容")) {
                Initiator initiatorG = this.b.getFeeTaskImpl().g();
                this.f479h = PageKey.make(initiatorG.url, (int) initiatorG.pageCode, initiatorG.stack);
            } else {
                this.f479h = PageKey.make("", 0, "");
            }
            if (g0.a) {
                g0.b("siganid-pagekey2", this.f479h.toJson());
            }
        }
        if (this.b.getFeeTaskImpl() != null && this.b.getFeeTaskImpl().p()) {
            E();
            this.o = new ArrayList();
            this.n = new ArrayList();
            this.p = new ArrayList();
            this.q = new ArrayList();
            this.r = new ArrayList();
            this.s = new ArrayList();
            this.f475d = new ArrayList();
            this.c = this.b.getALlFeeResource(null);
            this.b.beforeCheckPrivilege();
            q();
            return;
        }
        this.b.beforeCheckPrivilege();
        this.o = new ArrayList();
        this.n = new ArrayList();
        this.p = new ArrayList();
        this.q = new ArrayList();
        this.r = new ArrayList();
        this.s = new ArrayList();
        this.f475d = new ArrayList();
        List<e.c.a.g.a.d.r.n.a<?>> aLlFeeResource = this.b.getALlFeeResource(null);
        this.c = aLlFeeResource;
        if (aLlFeeResource == null || aLlFeeResource.size() == 0) {
            this.j = true;
            q();
            return;
        }
        List<e.c.a.g.a.d.r.p.a.g> listFeeDataToPrivilegeResource = this.b.feeDataToPrivilegeResource(this.c);
        if (this.f479h != null && listFeeDataToPrivilegeResource != null) {
            for (e.c.a.g.a.d.r.p.a.g gVar : listFeeDataToPrivilegeResource) {
                if (gVar != null && gVar.f() == null) {
                    gVar.o(this.f479h);
                }
            }
        }
        t(listFeeDataToPrivilegeResource);
        if (listFeeDataToPrivilegeResource == null || listFeeDataToPrivilegeResource.size() == 0) {
            this.j = true;
            q();
            if (g0.a) {
                return;
            }
        }
        e.c.a.g.a.d.r.p.a.a aVarG = new e.c.a.g.a.d.r.d().g(listFeeDataToPrivilegeResource, this.f476e.b(), this.f476e.a(), this.f476e.c(), m0.a(), e.c.a.g.a.r.b.F());
        int iG = aVarG != null ? aVarG.g() : 200;
        if (g0.a) {
            g0.e("zzm-log", "statusCode:" + iG);
        }
        if (!(aVarG != null && aVarG.f() == 1) && e.c.a.g.a.d.r.a.e(iG) && (("play".equals(this.f476e.a()) || "download".equals(this.f476e.a())) && ("Download".equalsIgnoreCase(this.f476e.d()) || "Listen".equalsIgnoreCase(this.f476e.d()) || "DownloadManager".equalsIgnoreCase(this.f476e.d()) || "download_listen_tag".equalsIgnoreCase(this.f476e.d()) || "listen_download_tag".equalsIgnoreCase(this.f476e.d()) || "Album".equalsIgnoreCase(this.f476e.d())))) {
            z = true;
        }
        if (z) {
            if (g0.a) {
                g0.e("zzm-log", "start 走容灾--");
            }
            e.c.a.g.a.d.r.p.a.f fVarH = new e.c.a.g.a.d.r.d().h(listFeeDataToPrivilegeResource, this.f476e.b(), this.f476e.a(), this.f476e.c());
            if (fVarH == null || fVarH.e()) {
                v.obtainMessage(19).sendToTarget();
            } else if (fVarH.f() || fVarH.b()) {
                aVarG = fVarH.a();
                aVarG.m(1);
            }
        }
        if (aVarG != null && aVarG.f() == 1) {
            this.c = this.b.combineData(this.c, aVarG.d());
            this.b.afterChecktPrivilege();
            List<e.c.a.g.a.d.r.n.a<?>> payFeeResourceDatas = this.b.getPayFeeResourceDatas();
            this.f475d = payFeeResourceDatas;
            if (payFeeResourceDatas == null || payFeeResourceDatas.size() <= 0) {
                List<e.c.a.g.a.d.r.n.a<?>> list = this.t;
                if (list != null) {
                    list.clear();
                }
            } else {
                doCalaulatePrice(this.f475d, this.b.getSelSongQuality());
                long jO = e.c.a.g.a.r.b.o();
                String strN = e.c.a.g.a.r.b.n();
                if (jO > 0 && TextUtils.isEmpty(strN)) {
                    v.obtainMessage(21).sendToTarget();
                    return;
                }
                if (z) {
                    e.c.a.g.a.d.r.j.a.f(this.a);
                }
                if (e.c.a.g.a.r.b.F()) {
                    new e.c.a.g.a.d.r.r.b.c().a(getActivity(), 4000);
                }
            }
        }
        this.j = true;
        if (this.f480i) {
            return;
        }
        if (aVarG == null) {
            v.obtainMessage(19).sendToTarget();
        } else if (aVarG.f() == e.c.a.g.a.d.r.p.b.e.f532d) {
            v.obtainMessage(20).sendToTarget();
        } else if (aVarG.f() == 0 && aVarG.c() == 20018) {
            v.obtainMessage(8).sendToTarget();
        } else if (aVarG.f() == 0) {
            v.obtainMessage(11).sendToTarget();
        } else if (aVarG.f() == 1) {
            List<e.c.a.g.a.d.r.n.a<?>> list2 = this.f475d;
            if (list2 == null) {
                this.f477f.sendEmptyMessage(4108);
                return;
            }
            if (list2.size() == 0) {
                q();
                if (g0.a) {
                    return;
                }
            }
            w(this.f475d);
        }
        this.b.onEndCheckPrivilege(aVarG);
    }

    public final void t(List<e.c.a.g.a.d.r.p.a.g> list) {
        if (list == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(null);
        list.removeAll(arrayList);
    }

    @Override // e.c.a.g.a.d.r.e
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public AbsFrameworkActivity getActivity() {
        return this.a;
    }

    public final void w(List<e.c.a.g.a.d.r.n.a<?>> list) {
        synchronized (this.f478g) {
            if (list != null) {
                if (list.size() != 0) {
                    e.c.a.g.a.d.r.p.a.c targetGoods = this.b.getTargetGoods(list.get(0).b());
                    if (targetGoods == null || !e.c.a.g.a.d.r.j.a.d(targetGoods, this.f476e.d()) || e.c.a.g.a.d.r.j.a.c(targetGoods)) {
                        q();
                        if (g0.a) {
                            g0.e(u, "handlerMusicJump/send MSG_SHOW_FEES_DIALOG message");
                        }
                    } else {
                        runOnUIThread(new RunnableC0071c());
                    }
                }
            }
        }
    }

    public final void x() {
        e.c.a.g.a.d.r.j.c.e eVarB = e.c.a.g.a.d.r.j.a.b(e.c.a.g.a.d.r.n.h.c().b());
        this.b = eVarB;
        if (eVarB == null) {
            finish();
            return;
        }
        if (g0.a) {
            g0.e(u, "task SimpleName/" + this.b.getClass().getSimpleName());
        }
        this.b.setControlFeesAction(this);
        this.b.attachActivity(this.a);
        this.k = this.b.getFeeResourceCount();
        e.c.a.g.a.d.r.n.f taskInfo = this.b.getTaskInfo();
        this.f476e = taskInfo;
        Objects.requireNonNull(taskInfo, "TaskInfo must not be null");
    }

    public final void y() {
        this.j = true;
        p1.h(this.a, "网络繁忙,请稍后重试");
        finish();
        u0.A(27, "onUIProcessCheckPrivilegeFail", "网络繁忙,请稍后重试");
    }

    public final void z() {
        this.j = true;
        p1.h(this.a, "数据获取失败,请稍后重试");
        finish();
    }
}
