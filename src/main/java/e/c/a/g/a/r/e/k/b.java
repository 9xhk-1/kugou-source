package e.c.a.g.a.r.e.k;

import android.util.Log;
import e.c.a.g.a.f.e.c;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.i1;
import e.c.a.g.a.s.j0;
import f.i;
import f.z.d.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public final boolean a;
    public volatile e.c.a.g.a.n.b.a b;
    public volatile e.c.a.g.a.n.b.d c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Subscription f1185d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList<a> f1186e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f1187f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f1188g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Subscription f1189h;

    public interface a {
        void onFail(Throwable th);

        void onStart();

        void onSuccess(e.c.a.g.a.n.b.a aVar, e.c.a.g.a.n.b.d dVar);
    }

    /* JADX INFO: renamed from: e.c.a.g.a.r.e.k.b$b, reason: collision with other inner class name */
    public static final class RunnableC0181b implements Runnable {
        public RunnableC0181b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            b.this.k();
        }
    }

    public static final class c<T, R> implements Func1 {
        public c() {
        }

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Observable<? extends i<e.c.a.g.a.n.b.a, e.c.a.g.a.n.b.d>> call(String str) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            b.this.q();
            if (g0.a) {
                g0.e("CodeProvider", "refreshQrcode 1");
            }
            e.c.a.g.a.n.b.a aVarA = e.c.a.g.a.n.b.b.a();
            String strA = aVarA == null ? null : aVarA.a();
            b.this.r();
            Log.e("mhs_watch", "2 refreshQrcode: " + aVarA + " 接口花费多久时间 = " + (System.currentTimeMillis() - jCurrentTimeMillis));
            if (b.this.h()) {
                try {
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    Log.e("mhs_watch", j.l("refreshQrcode: ", strA));
                    String strC = e.c.a.g.a.r.e.i.d.c(strA);
                    Log.i("CodeProvider", "refreshQrcode: kgCodeUrlShort=" + ((Object) strC) + " ， kgCodeUrl=" + ((Object) strA) + "， cost time = " + (System.currentTimeMillis() - jCurrentTimeMillis2));
                    if (aVarA != null) {
                        aVarA.f1116d = strC;
                    }
                } catch (Exception e2) {
                    Log.e("mhs_watch", j.l("refreshQrcode = e ", e2));
                    e2.printStackTrace();
                }
            }
            if (aVarA != null) {
                if (!(strA == null || strA.length() == 0)) {
                    e.c.a.g.a.n.b.d dVarC = e.c.a.g.a.n.b.b.c(aVarA.c());
                    String str2 = dVarC != null ? dVarC.c : null;
                    if (b.this.h()) {
                        try {
                            Log.i("CodeProvider", "refreshQrcode: kgCodeUrlShort=" + ((Object) str2) + " ， wxCodeUrl=" + ((Object) str2));
                        } catch (Exception e3) {
                            Log.e("mhs_watch", j.l("refreshQrcode = e ", e3));
                            e3.printStackTrace();
                        }
                    }
                    if (dVarC == null) {
                        return Observable.error(new Exception(j.l("wx code err:", dVarC)));
                    }
                    if (dVarC.a == 2) {
                        if (str2 == null || str2.length() == 0) {
                            return Observable.error(new Exception("wx code url is null"));
                        }
                    }
                    return Observable.just(new i(aVarA, dVarC));
                }
            }
            return Observable.error(new Exception(j.l("kg code err:", aVarA)));
        }
    }

    public static final class d<T> implements Action1 {
        public d() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(i<? extends e.c.a.g.a.n.b.a, ? extends e.c.a.g.a.n.b.d> iVar) {
            e.c.a.g.a.n.b.a aVarC = iVar.c();
            e.c.a.g.a.n.b.d dVarD = iVar.d();
            b.this.o(aVarC);
            b.this.p(dVarD);
            b.this.l(aVarC, dVarD);
            Log.e("mhs_watch", "接口成功结果");
        }
    }

    public static final class e<T> implements Action1 {

        public static final class a implements Runnable {
            public final /* synthetic */ b a;
            public final /* synthetic */ Throwable b;

            public a(b bVar, Throwable th) {
                this.a = bVar;
                this.b = th;
            }

            @Override // java.lang.Runnable
            public final void run() {
                b bVar = this.a;
                Throwable th = this.b;
                j.d(th, "it");
                bVar.j(th);
                Log.e("mhs_watch", j.l("接口失败 it", this.b));
            }
        }

        public e() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(Throwable th) {
            j0.g(new a(b.this, th));
        }
    }

    public static final class f<T> implements Action1 {

        public static final class a implements Runnable {
            public final /* synthetic */ b a;

            public a(b bVar) {
                this.a = bVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.j(new Exception(j.l("timeout kg code err:", this.a.f())));
            }
        }

        public f() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(String str) {
            if (b.this.f1185d != null) {
                i1.a(b.this.f1185d);
            }
            j0.g(new a(b.this));
        }
    }

    public b() {
        c.b bVar = e.c.a.g.a.f.e.c.a;
        this.a = bVar.a().getConfigAsInt(e.c.a.g.a.f.e.b.G0, 1) == 1;
        this.f1186e = new ArrayList<>();
        this.f1187f = bVar.a().getConfigAsInt(e.c.a.g.a.f.e.b.V, 1) == 1;
        this.f1188g = bVar.a().getConfigAsInt(e.c.a.g.a.f.e.b.R, 15000);
    }

    public final void e(a aVar) {
        j.e(aVar, "l");
        this.f1186e.add(aVar);
    }

    public final e.c.a.g.a.n.b.a f() {
        return this.b;
    }

    public final e.c.a.g.a.n.b.d g() {
        return this.c;
    }

    public final boolean h() {
        return this.a;
    }

    public final boolean i() {
        if (this.c != null) {
            e.c.a.g.a.n.b.d dVar = this.c;
            j.c(dVar);
            if (dVar.a == 2) {
                return false;
            }
        }
        return true;
    }

    public final void j(Throwable th) {
        Iterator<T> it = this.f1186e.iterator();
        while (it.hasNext()) {
            ((a) it.next()).onFail(th);
        }
    }

    public final void k() {
        Iterator<T> it = this.f1186e.iterator();
        while (it.hasNext()) {
            ((a) it.next()).onStart();
        }
    }

    public final void l(e.c.a.g.a.n.b.a aVar, e.c.a.g.a.n.b.d dVar) {
        Iterator<T> it = this.f1186e.iterator();
        while (it.hasNext()) {
            ((a) it.next()).onSuccess(aVar, dVar);
        }
    }

    public final void m() {
        j0.g(new RunnableC0181b());
        i1.a(this.f1185d);
        this.f1185d = Observable.just("").subscribeOn(Schedulers.io()).flatMap(new c()).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(), new e());
    }

    public final void n() {
        i1.a(this.f1185d);
        this.f1186e.clear();
    }

    public final void o(e.c.a.g.a.n.b.a aVar) {
        this.b = aVar;
    }

    public final void p(e.c.a.g.a.n.b.d dVar) {
        this.c = dVar;
    }

    public final void q() {
        if (this.f1187f) {
            Subscription subscription = this.f1189h;
            if (subscription != null) {
                i1.a(subscription);
            }
            this.f1189h = Observable.just("").delay(this.f1188g, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new f(), i1.b);
        }
    }

    public final void r() {
        if (this.f1187f) {
            i1.a(this.f1189h);
            this.f1189h = null;
        }
    }
}
