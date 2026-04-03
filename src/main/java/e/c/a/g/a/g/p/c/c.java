package e.c.a.g.a.g.p.c;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.common.useraccount.entity.SVIPExtInfo;
import com.kugou.common.useraccount.utils.SVIPExtInfoUtil;
import com.kugou.common.utils.YGlide;
import e.c.a.g.a.g.p.d.g;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.k;
import e.c.a.g.a.s.v0;
import f.n;
import f.z.d.j;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public int a = 1;

    public static final class a<T, R> implements Func1 {
        public static final a<T, R> a = new a<>();

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final n<Drawable, Drawable, Drawable> call(g gVar) {
            Context context = KGApplication.getContext();
            return new n<>(YGlide.with(context).load(gVar.c()).preloadSync(), YGlide.with(context).load(gVar.a()).preloadSync(), YGlide.with(context).load(gVar.b()).preloadSync());
        }
    }

    public static final class b<T> implements Action1 {
        public final /* synthetic */ Context b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ g f1024d;

        public static final class a implements e.c.a.g.a.d.h.b.d {
            public final /* synthetic */ c a;

            public a(c cVar) {
                this.a = cVar;
            }

            @Override // e.c.a.g.a.d.h.b.d
            public final void onHook() {
                this.a.a = 1;
            }
        }

        /* JADX INFO: renamed from: e.c.a.g.a.g.p.c.c$b$b, reason: collision with other inner class name */
        public static final class DialogInterfaceOnShowListenerC0155b implements DialogInterface.OnShowListener {
            public final /* synthetic */ c a;

            public DialogInterfaceOnShowListenerC0155b(c cVar) {
                this.a = cVar;
            }

            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                this.a.a = 3;
            }
        }

        /* JADX INFO: renamed from: e.c.a.g.a.g.p.c.c$b$c, reason: collision with other inner class name */
        public static final class DialogInterfaceOnDismissListenerC0156c implements DialogInterface.OnDismissListener {
            public final /* synthetic */ c a;

            public DialogInterfaceOnDismissListenerC0156c(c cVar) {
                this.a = cVar;
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                this.a.a = 1;
            }
        }

        public b(Context context, g gVar) {
            this.b = context;
            this.f1024d = gVar;
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(n<? extends Drawable, ? extends Drawable, ? extends Drawable> nVar) {
            Drawable drawableA = nVar.a();
            Drawable drawableB = nVar.b();
            Drawable drawableC = nVar.c();
            if (drawableA == null || drawableB == null || drawableC == null) {
                if (g0.a) {
                    g0.b("VipExpireManager", "tryShow: 图片加载失败");
                }
                c.this.a = 1;
            } else {
                e.c.a.g.a.g.p.c.a aVar = new e.c.a.g.a.g.p.c.a(this.b, this.f1024d, drawableA, drawableB, drawableC);
                c cVar = c.this;
                aVar.setShowHookerListener(new a(cVar));
                aVar.setOnShowListener(new DialogInterfaceOnShowListenerC0155b(cVar));
                aVar.setOnDismissListener(new DialogInterfaceOnDismissListenerC0156c(cVar));
                aVar.askShow();
            }
        }
    }

    /* JADX INFO: renamed from: e.c.a.g.a.g.p.c.c$c, reason: collision with other inner class name */
    public static final class C0157c<T> implements Action1 {
        public C0157c() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(Throwable th) {
            if (g0.a) {
                g0.b("VipExpireManager", "tryShow: 网络异常");
            }
            c.this.a = 1;
        }
    }

    public final void b(Context context) {
        j.e(context, "context");
        if (this.a != 1) {
            return;
        }
        g gVarJ = e.c.a.g.a.g.p.b.f1018d.a().j();
        if (gVarJ == null || !gVarJ.e()) {
            if (g0.a) {
                g0.b("VipExpireManager", "tryShow: data valid");
                return;
            }
            return;
        }
        if (e.c.a.g.a.r.b.O()) {
            return;
        }
        if (!e.c.a.g.a.d.h.b.c.a.b()) {
            if (g0.a) {
                g0.b("VipExpireManager", "tryShow: 弹窗展示间隔内，不展示");
                return;
            }
            return;
        }
        SVIPExtInfo mineSVIPExtInfo = SVIPExtInfoUtil.getMineSVIPExtInfo();
        long jE = k.e(mineSVIPExtInfo.getSu_vip_end_time());
        long jE2 = k.e(e.c.a.g.a.r.b.A());
        long jE3 = k.e(e.c.a.g.a.r.b.f());
        if (g0.a) {
            g0.b("VipExpireManager", "tryShow: svipExpireTime=" + ((Object) mineSVIPExtInfo.getSu_vip_end_time()) + "   youngExpireTime=" + ((Object) e.c.a.g.a.r.b.A()) + "  superExpireTime=" + ((Object) e.c.a.g.a.r.b.f()));
        }
        long jB = v0.b(jE, jE2, jE3);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jB <= 0 || jCurrentTimeMillis - jB > 2592000000L) {
            return;
        }
        this.a = 2;
        Observable.just(gVarJ).map(a.a).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(context, gVarJ), new C0157c());
    }
}
