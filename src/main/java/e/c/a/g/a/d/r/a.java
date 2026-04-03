package e.c.a.g.a.d.r;

import android.util.Log;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.k;
import e.c.c.o.m;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static volatile a a;

    /* JADX INFO: renamed from: e.c.a.g.a.d.r.a$a, reason: collision with other inner class name */
    public class C0070a implements Action1<e.c.a.g.a.d.r.p.b.b> {
        public final /* synthetic */ long a;

        public C0070a(long j) {
            this.a = j;
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(e.c.a.g.a.d.r.p.b.b bVar) {
            if (bVar != null && bVar.e()) {
                if (g0.a) {
                    g0.e("MediaStorePaidRecordManager", "update success userid:" + this.a + ", k_paid:" + bVar.b());
                }
                a.this.h(bVar.d(), System.currentTimeMillis());
                a.this.g(bVar.d(), bVar.b());
                return;
            }
            if (g0.a) {
                if (bVar == null) {
                    g0.e("MediaStorePaidRecordManager", "update fail entity null userid:" + this.a);
                    return;
                }
                g0.e("MediaStorePaidRecordManager", "update fail userid:" + this.a + ", error_code:" + bVar.a() + ",message:" + bVar.c());
            }
        }
    }

    public class b implements Action1<Throwable> {
        public final /* synthetic */ long a;

        public b(a aVar, long j) {
            this.a = j;
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(Throwable th) {
            if (g0.a) {
                g0.e("MediaStorePaidRecordManager", "update userid:" + this.a + " fail throwable:" + Log.getStackTraceString(th));
            }
        }
    }

    public class c implements Func1<String, e.c.a.g.a.d.r.p.b.b> {
        public c(a aVar) {
        }

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e.c.a.g.a.d.r.p.b.b call(String str) {
            return new e.c.a.g.a.d.r.p.b.e().c();
        }
    }

    public static a c() {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a();
                }
            }
        }
        return a;
    }

    public static boolean e(int i2) {
        return i2 >= 500 && i2 <= 599;
    }

    public int d(long j) {
        return e.c.a.g.a.f.m.b.m().q(j);
    }

    public final boolean f(long j) {
        return k.a(e.c.a.g.a.f.m.b.m().r(j), System.currentTimeMillis()) > 0;
    }

    public final void g(long j, int i2) {
        if (g0.a) {
            g0.e("MediaStorePaidRecordManager", "setMediastorePaidRecord userId:" + j + ", k_paid:" + i2);
        }
        e.c.a.g.a.f.m.b.m().a0(j, i2);
    }

    public final void h(long j, long j2) {
        e.c.a.g.a.f.m.b.m().b0(j, j2);
    }

    public void i() {
        if (!e.c.a.g.a.r.b.F()) {
            if (g0.a) {
                g0.e("MediaStorePaidRecordManager", "not login");
                return;
            }
            return;
        }
        long jO = e.c.a.g.a.r.b.o();
        if (d(jO) == 1) {
            if (g0.a) {
                g0.e("MediaStorePaidRecordManager", "already have paid record userid:" + jO);
                return;
            }
            return;
        }
        if (!m.z(e.c.c.o.f.a())) {
            if (g0.a) {
                g0.e("MediaStorePaidRecordManager", "not avalidNetSetting userid:" + jO);
                return;
            }
            return;
        }
        if (f(jO)) {
            if (g0.a) {
                g0.e("MediaStorePaidRecordManager", "start update userid:" + jO);
            }
            Observable.just("").subscribeOn(Schedulers.io()).map(new c(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(new C0070a(jO), new b(this, jO));
            return;
        }
        if (g0.a) {
            g0.e("MediaStorePaidRecordManager", "Today already update userid:" + jO);
        }
    }
}
