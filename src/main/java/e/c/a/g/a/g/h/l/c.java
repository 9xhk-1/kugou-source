package e.c.a.g.a.g.h.l;

import android.content.Context;
import com.kugou.android.watch.lite.bi.YoungBITask;
import e.c.a.g.a.s.i1;
import f.z.d.j;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public static final c a = new c();
    public static Subscription b;
    public static boolean c;

    public static final class a<T> implements Action1 {
        public final /* synthetic */ Context a;
        public final /* synthetic */ boolean b;

        public a(Context context, boolean z) {
            this.a = context;
            this.b = z;
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(e.c.a.g.a.f.k.c<e.c.a.g.a.g.h.l.a> cVar) {
            e.c.a.g.a.g.h.l.a aVarA = cVar.a();
            if (!cVar.f() || aVarA == null) {
                return;
            }
            if (aVarA.d()) {
                new d(this.a, aVarA).askShow();
            } else if (this.b) {
                e.c.a.g.a.e.b.b(new YoungBITask(20403, "exposure").setType(e.c.a.g.a.g.h.l.b.a.c(Integer.valueOf(aVarA.b()))));
            }
            if (aVarA.c()) {
                c.a.g();
            }
        }
    }

    public static final class b<T> implements Action1 {
        public final /* synthetic */ Context a;

        public b(Context context) {
            this.a = context;
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(Boolean bool) {
            if (e.c.a.g.a.r.b.F()) {
                j.d(bool, "it");
                if (bool.booleanValue()) {
                    c.a.c(this.a, true);
                    return;
                }
            }
            j.d(bool, "it");
            if (bool.booleanValue()) {
                new e(this.a).askShow();
            }
        }
    }

    /* JADX INFO: renamed from: e.c.a.g.a.g.h.l.c$c, reason: collision with other inner class name */
    public static final class C0131c<T> implements Action1 {
        public static final C0131c<T> a = new C0131c<>();

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(e.c.a.g.a.f.k.c<Object> cVar) {
        }
    }

    public final void c(Context context, boolean z) {
        e.c.a.g.a.g.h.l.b.a.b().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(context, z), i1.b);
    }

    public final void d(Context context) {
        j.e(context, "context");
        boolean z = false;
        if (c) {
            c = false;
            z = true;
        }
        c(context, z);
    }

    public final void e(Context context, boolean z) {
        j.e(context, "context");
        if (z) {
            e.c.a.g.a.f.m.c cVar = e.c.a.g.a.f.m.c.a;
            boolean zE = cVar.e("newer_show_tip", true);
            if (zE) {
                cVar.j("newer_show_tip", false);
            }
            boolean z2 = zE && e.c.a.g.a.f.e.c.a.a().getConfigAsBoolean(e.c.a.g.a.f.e.b.Z0, true);
            if (z2) {
                i1.a(b);
                b = Observable.just(Boolean.valueOf(z2)).delay(3L, TimeUnit.SECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(context), i1.b);
            }
        }
    }

    public final void f() {
        i1.a(b);
        b = null;
    }

    public final void g() {
        f.a.c().subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).subscribe(C0131c.a, i1.b);
    }

    public final void h(boolean z) {
        c = z;
    }
}
