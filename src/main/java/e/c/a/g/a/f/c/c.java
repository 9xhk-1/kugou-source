package e.c.a.g.a.f.c;

import android.graphics.drawable.Drawable;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment;
import com.kugou.common.apm.sdk.ApmDataTypeID;
import com.kugou.common.utils.YGlide;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.i1;
import e.c.a.g.a.s.l0;
import e.c.a.g.a.s.m1;
import e.c.a.g.a.s.u0;
import f.i;
import f.u.m;
import f.z.d.j;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    public boolean a;
    public List<e.c.a.g.a.f.c.b> b;
    public final String c = "运营弹窗";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f640d = 101;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e.c.a.g.a.k.d.a f641e = new e.c.a.g.a.k.d.a(ApmDataTypeID.COMMON_AD_DIALOG);

    public static final class a<T> implements Action1 {

        /* JADX INFO: renamed from: e.c.a.g.a.f.c.c$a$a, reason: collision with other inner class name */
        public static final class C0101a<T> implements Action1 {
            public final /* synthetic */ c a;
            public final /* synthetic */ e.c.a.g.a.f.k.c<List<e.c.a.g.a.f.c.b>> b;

            public C0101a(c cVar, e.c.a.g.a.f.k.c<List<e.c.a.g.a.f.c.b>> cVar2) {
                this.a = cVar;
                this.b = cVar2;
            }

            @Override // rx.functions.Action1
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final void call(String str) {
                try {
                    c cVar = this.a;
                    e.c.a.g.a.f.k.c<List<e.c.a.g.a.f.c.b>> cVar2 = this.b;
                    j.d(cVar2, "resp");
                    cVar.l(cVar2);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }

        public a() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(e.c.a.g.a.f.k.c<List<e.c.a.g.a.f.c.b>> cVar) {
            c.this.a = false;
            if (cVar.f()) {
                c cVar2 = c.this;
                List<e.c.a.g.a.f.c.b> listA = cVar.a();
                if (listA == null) {
                    listA = m.d();
                }
                cVar2.b = listA;
            }
            m1.f(new C0101a(c.this, cVar));
            c cVar3 = c.this;
            e.c.a.g.a.f.c.b bVarH = cVar3.h(cVar3.b);
            if (bVarH == null) {
                c.this.m();
            } else {
                c.this.n(bVarH);
            }
        }
    }

    public static final class b<T> implements Action1 {
        public b() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(Throwable th) {
            c.this.a = false;
            c.this.j(th);
        }
    }

    /* JADX INFO: renamed from: e.c.a.g.a.f.c.c$c, reason: collision with other inner class name */
    public static final class C0102c<T, R> implements Func1 {
        public static final C0102c<T, R> a = new C0102c<>();

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final i<Drawable, Drawable> call(e.c.a.g.a.f.c.b bVar) {
            return new i<>(YGlide.with(KGApplication.getContext()).load(bVar.b()).preloadSync(), YGlide.with(KGApplication.getContext()).load(bVar.a()).preloadSync());
        }
    }

    public static final class d<T> implements Action1 {
        public final /* synthetic */ AbsFrameworkFragment a;
        public final /* synthetic */ e.c.a.g.a.f.c.b b;

        public d(AbsFrameworkFragment absFrameworkFragment, e.c.a.g.a.f.c.b bVar) {
            this.a = absFrameworkFragment;
            this.b = bVar;
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(i<? extends Drawable, ? extends Drawable> iVar) {
            Drawable drawableC = iVar.c();
            Drawable drawableD = iVar.d();
            if (drawableC == null || drawableD == null) {
                return;
            }
            new e.c.a.g.a.f.c.a(this.a, drawableC, drawableD, this.b).askShow();
        }
    }

    public final void g() {
        if (!i()) {
            m();
            return;
        }
        k();
        this.a = true;
        new e.c.a.g.a.f.c.d().a().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(), new b());
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x008d A[EDGE_INSN: B:60:0x008d->B:52:0x008d BREAK  A[LOOP:0: B:22:0x003b->B:64:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:? A[LOOP:0: B:22:0x003b->B:64:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final e.c.a.g.a.f.c.b h(java.util.List<e.c.a.g.a.f.c.b> r12) {
        /*
            r11 = this;
            r0 = 0
            r1 = 1
            if (r12 == 0) goto Ld
            boolean r2 = r12.isEmpty()
            if (r2 == 0) goto Lb
            goto Ld
        Lb:
            r2 = 0
            goto Le
        Ld:
            r2 = 1
        Le:
            java.lang.String r3 = "ComActivityManager"
            r4 = 0
            if (r2 == 0) goto L1d
            boolean r12 = e.c.a.g.a.s.g0.a
            if (r12 == 0) goto L1c
            java.lang.String r12 = "findComActivityEntity: empty list"
            e.c.a.g.a.s.g0.b(r3, r12)
        L1c:
            return r4
        L1d:
            e.c.a.g.a.d.h.b.c r2 = e.c.a.g.a.d.h.b.c.a
            boolean r2 = r2.b()
            if (r2 != 0) goto L2f
            boolean r12 = e.c.a.g.a.s.g0.a
            if (r12 == 0) goto L2e
            java.lang.String r12 = "findComActivityEntity: dialog interval"
            e.c.a.g.a.s.g0.b(r3, r12)
        L2e:
            return r4
        L2f:
            long r5 = e.c.a.g.a.s.l1.b()
            r2 = 1000(0x3e8, float:1.401E-42)
            long r7 = (long) r2
            long r5 = r5 / r7
            java.util.Iterator r12 = r12.iterator()
        L3b:
            boolean r2 = r12.hasNext()
            if (r2 == 0) goto L8c
            java.lang.Object r2 = r12.next()
            r7 = r2
            e.c.a.g.a.f.c.b r7 = (e.c.a.g.a.f.c.b) r7
            long r8 = r7.g()
            int r10 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r10 > 0) goto L88
            long r8 = r7.c()
            int r10 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r10 > 0) goto L88
            boolean r8 = r7.h()
            if (r8 == 0) goto L88
            int r7 = r7.f()
            if (r7 == 0) goto L81
            if (r7 == r1) goto L74
            r8 = 2
            if (r7 == r8) goto L6f
            r8 = 3
            if (r7 == r8) goto L6d
            goto L88
        L6d:
            r7 = 1
            goto L89
        L6f:
            boolean r7 = e.c.a.g.a.r.b.K()
            goto L89
        L74:
            boolean r7 = e.c.a.g.a.r.b.O()
            if (r7 == 0) goto L88
            boolean r7 = e.c.a.g.a.r.b.K()
            if (r7 != 0) goto L88
            goto L6d
        L81:
            boolean r7 = e.c.a.g.a.r.b.O()
            if (r7 != 0) goto L88
            goto L6d
        L88:
            r7 = 0
        L89:
            if (r7 == 0) goto L3b
            goto L8d
        L8c:
            r2 = r4
        L8d:
            e.c.a.g.a.f.c.b r2 = (e.c.a.g.a.f.c.b) r2
            if (r2 != 0) goto L9b
            boolean r12 = e.c.a.g.a.s.g0.a
            if (r12 == 0) goto L9a
            java.lang.String r12 = "findComActivityEntity: not hit"
            e.c.a.g.a.s.g0.b(r3, r12)
        L9a:
            return r4
        L9b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.a.g.a.f.c.c.h(java.util.List):e.c.a.g.a.f.c.b");
    }

    public final boolean i() {
        return !this.a && this.b == null && u0.m(KGApplication.getContext());
    }

    public final void j(Throwable th) {
        e.c.a.g.a.k.d.a.c(this.f641e, th, this.f640d, this.c, null, 8, null);
    }

    public final void k() {
        this.f641e.g();
    }

    public final void l(e.c.a.g.a.f.k.c<List<e.c.a.g.a.f.c.b>> cVar) {
        j.e(cVar, "songResp");
        if (!cVar.f()) {
            j(new e.c.a.b.a.a.a.a(cVar.b()));
        } else {
            this.f641e.e();
            this.f641e.i(!l0.g(cVar.a()));
        }
    }

    public final void m() {
        if (g0.a) {
            g0.b("ComActivityManager", "onSkipShowComActivity: ");
        }
        EventBus.getDefault().post(new e.c.a.g.a.g.p.c.b());
    }

    public final void n(e.c.a.g.a.f.c.b bVar) {
        AbsFrameworkFragment absFrameworkFragmentB = e.c.a.g.a.d.v.c.b();
        if (absFrameworkFragmentB == null) {
            return;
        }
        Observable.just(bVar).map(C0102c.a).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(absFrameworkFragmentB, bVar), i1.b);
    }
}
