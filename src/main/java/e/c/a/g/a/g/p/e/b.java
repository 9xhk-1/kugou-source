package e.c.a.g.a.g.p.e;

import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.component.vip.CommonPayActivity;
import e.c.a.g.a.g.p.d.b;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.h1;
import e.c.a.g.a.s.i1;
import e.c.a.g.a.s.p1;
import e.c.a.g.a.s.v0;
import f.z.d.j;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends e.c.a.g.a.g.p.e.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f1051d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Subscription f1052e;

    public static final class a<T> implements Action1 {
        public final /* synthetic */ String b;

        public a(String str) {
            this.b = str;
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(e.c.a.g.a.f.k.c<e.c.a.g.a.g.p.d.b> cVar) {
            b.this.a().showLoading(false);
            e.c.a.g.a.g.p.d.b bVarA = cVar.a();
            if (cVar.f()) {
                if (bVarA == null) {
                    p1.h(KGApplication.getContext(), "订单接口数据异常");
                    e.c.a.g.a.g.p.g.a.a.d(5, "订单接口数据异常");
                    return;
                }
                b.a aVarD = bVarA.d();
                String strA = aVarD == null ? null : aVarD.a();
                if (!(strA == null || strA.length() == 0)) {
                    CommonPayActivity.l.a(b.this.a().geFragment().getActivity(), strA, bVarA.b(), bVarA.c(), this.b, v0.a(bVarA.a()));
                    return;
                } else {
                    p1.h(KGApplication.getContext(), "订单数据缺失");
                    e.c.a.g.a.g.p.g.a.a.d(6, "订单数据缺失");
                    return;
                }
            }
            if (cVar.b() == 20028 || cVar.b() == 20029) {
                p1.h(KGApplication.getContext(), e.c.a.g.a.f.e.c.a.a().b(e.c.a.g.a.f.e.b.s2, "消费金额到达未成年人充值额度~"));
                e.c.a.g.a.g.p.g.a.a.d(3, "消费金额到达未成年人充值额度");
                return;
            }
            p1.h(KGApplication.getContext(), h1.q(cVar.c(), "请求失败，请稍后重试~"));
            if (g0.a) {
                p1.h(KGApplication.getContext(), "err:" + cVar.b() + ",msg:" + ((Object) cVar.c()));
            }
            e.c.a.g.a.g.p.g.a aVar = e.c.a.g.a.g.p.g.a.a;
            j.d(cVar, "resp");
            aVar.a(cVar);
        }
    }

    /* JADX INFO: renamed from: e.c.a.g.a.g.p.e.b$b, reason: collision with other inner class name */
    public static final class C0159b<T> implements Action1 {
        public C0159b() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(Throwable th) {
            b.this.a().showLoading(false);
            p1.h(KGApplication.getContext(), "网络异常，请稍后重试");
            e.c.a.g.a.g.p.g.a.a.c(th);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(d dVar, String str, e eVar) {
        super(dVar, eVar);
        j.e(dVar, "view");
        j.e(str, "sourceId");
        j.e(eVar, "vipProduct");
        this.f1051d = str;
    }

    @Override // e.c.a.g.a.g.p.e.c
    public void createOrder(int i2, String str) {
        j.e(str, "productName");
        String strD = d(i2);
        a().showLoading(true);
        i1.a(this.f1052e);
        this.f1052e = e.c.a.g.a.g.p.f.b.a.a("wx_qrcode", "watch", strD, this.f1051d).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(str), new C0159b());
    }

    public final String d(int i2) {
        if (i2 == 1) {
            String str = c().c;
            j.d(str, "vipProduct.year");
            return str;
        }
        if (i2 == 2) {
            String str2 = c().b;
            j.d(str2, "vipProduct.quarter");
            return str2;
        }
        if (i2 != 3) {
            String str3 = c().c;
            j.d(str3, "vipProduct.year");
            return str3;
        }
        String str4 = c().a;
        j.d(str4, "vipProduct.month");
        return str4;
    }

    @Override // e.c.a.g.a.g.p.e.c
    public void release() {
        i1.a(this.f1052e);
    }
}
