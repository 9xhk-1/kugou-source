package e.c.a.g.a.g.p;

import android.util.Log;
import com.kugou.android.watch.lite.base.application.KGApplication;
import e.c.a.g.a.g.p.d.h;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.t;
import e.c.a.g.a.s.u0;
import f.f;
import f.g;
import f.z.d.j;
import f.z.d.k;
import f.z.d.n;
import f.z.d.s;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C0154b f1018d = new C0154b(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final f.d<b> f1019e = f.a(g.SYNCHRONIZED, a.a);
    public e.c.a.g.a.g.p.d.e a;
    public boolean b;
    public final int c = e.c.a.g.a.f.e.c.a.a().getConfigAsInt(e.c.a.g.a.f.e.b.b3, 3) * 3600000;

    public static final class a extends k implements f.z.c.a<b> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // f.z.c.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final b invoke() {
            return new b();
        }
    }

    /* JADX INFO: renamed from: e.c.a.g.a.g.p.b$b, reason: collision with other inner class name */
    public static final class C0154b {
        public static final /* synthetic */ f.c0.e<Object>[] a;

        static {
            n nVar = new n(s.a(C0154b.class), "instance", "getInstance()Lcom/kugou/android/watch/lite/component/vip/VipPromoteManager;");
            s.c(nVar);
            a = new f.c0.e[]{nVar};
        }

        public C0154b() {
        }

        public /* synthetic */ C0154b(f.z.d.g gVar) {
            this();
        }

        public final b a() {
            return (b) b.f1019e.getValue();
        }
    }

    public static final class c<T, R> implements Func1 {

        public static final class a<T, R> implements Func1 {
            public static final a<T, R> a = new a<>();

            public final e.c.a.g.a.f.k.c<e.c.a.g.a.g.p.d.e> a(e.c.a.g.a.f.k.c<e.c.a.g.a.g.p.d.e> cVar) {
                e.c.a.g.a.g.p.d.e eVarA = cVar.a();
                if (cVar.f() && eVarA != null) {
                    e.c.a.g.a.f.m.b.m().h0(System.currentTimeMillis());
                    e.c.a.g.a.f.m.b.m().g0(t.c(eVarA));
                }
                return cVar;
            }

            @Override // rx.functions.Func1
            public /* bridge */ /* synthetic */ Object call(Object obj) {
                e.c.a.g.a.f.k.c<e.c.a.g.a.g.p.d.e> cVar = (e.c.a.g.a.f.k.c) obj;
                a(cVar);
                return cVar;
            }
        }

        public c() {
        }

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Observable<? extends e.c.a.g.a.f.k.c<e.c.a.g.a.g.p.d.e>> call(String str) {
            e.c.a.g.a.g.p.d.e eVar;
            if (System.currentTimeMillis() - e.c.a.g.a.f.m.b.m().w() >= b.this.c || g0.a || (eVar = (e.c.a.g.a.g.p.d.e) t.a(e.c.a.g.a.f.m.b.m().v(), e.c.a.g.a.g.p.d.e.class)) == null) {
                return new e.c.a.g.a.g.p.f.a().a().map(a.a);
            }
            e.c.a.g.a.f.k.c<T> cVarA = e.c.a.g.a.f.k.c.f687f.a();
            cVarA.g(eVar);
            if (g0.a) {
                g0.b("VipPromoteManager", "request: use cache data");
            }
            return Observable.just(cVarA);
        }
    }

    public static final class d<T> implements Action1 {
        public d() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(e.c.a.g.a.f.k.c<e.c.a.g.a.g.p.d.e> cVar) {
            b.this.b = false;
            if (g0.a) {
                g0.b("VipPromoteManager", j.l("request: data=", t.c(cVar.a())));
            }
            if (cVar.f()) {
                b bVar = b.this;
                e.c.a.g.a.g.p.d.e eVarA = cVar.a();
                if (eVarA == null) {
                    eVarA = new e.c.a.g.a.g.p.d.e();
                }
                bVar.a = eVarA;
            }
            EventBus.getDefault().post(new e.c.a.g.a.g.p.a(b.this.a));
        }
    }

    public static final class e<T> implements Action1 {
        public e() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(Throwable th) {
            b.this.b = false;
            EventBus.getDefault().post(new e.c.a.g.a.g.p.a(b.this.a));
        }
    }

    public final int f() {
        e.c.a.g.a.g.p.d.e eVar = this.a;
        Integer numValueOf = eVar == null ? null : Integer.valueOf(eVar.d());
        if (numValueOf == null || numValueOf.intValue() < 0) {
            return 7;
        }
        return numValueOf.intValue();
    }

    public final String g() {
        e.c.a.g.a.g.p.d.e eVar = this.a;
        if (eVar == null) {
            return null;
        }
        return eVar.c();
    }

    public final int h() {
        e.c.a.g.a.g.p.d.e eVar = this.a;
        if (eVar == null) {
            return 0;
        }
        return eVar.g();
    }

    public final e.c.a.g.a.g.p.d.f i() {
        e.c.a.g.a.g.p.d.e eVar = this.a;
        if (eVar == null) {
            return null;
        }
        return eVar.a();
    }

    public final e.c.a.g.a.g.p.d.g j() {
        e.c.a.g.a.g.p.d.e eVar = this.a;
        if (eVar == null) {
            return null;
        }
        return eVar.b();
    }

    public final String k() {
        e.c.a.g.a.g.p.d.e eVar = this.a;
        if (eVar == null) {
            return null;
        }
        return eVar.h();
    }

    public final String l() {
        e.c.a.g.a.g.p.d.e eVar = this.a;
        if (eVar == null) {
            return null;
        }
        return eVar.e();
    }

    public final List<h> m() {
        e.c.a.g.a.g.p.d.e eVar = this.a;
        if (eVar == null) {
            return null;
        }
        return eVar.f();
    }

    public final void n() {
        if (!this.b && this.a == null) {
            boolean zP = e.c.a.g.a.f.a.p();
            if (u0.n(KGApplication.getContext(), zP)) {
                this.b = true;
                Observable.just("").flatMap(new c()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(), new e());
                return;
            }
            Log.e("mhs_watch", "isGlobalNetAvailable = " + u0.r(KGApplication.getContext()) + ", isShowNetWotkToastFeedbackEntry = " + zP);
        }
    }
}
