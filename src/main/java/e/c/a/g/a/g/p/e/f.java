package e.c.a.g.a.g.p.e;

import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.component.vip.XTCPayActivity;
import e.c.a.g.a.g.p.d.i;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.h1;
import e.c.a.g.a.s.i1;
import e.c.a.g.a.s.k;
import e.c.a.g.a.s.p1;
import e.c.a.g.a.s.v0;
import e.c.a.g.a.s.v1;
import f.z.d.j;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends e.c.a.g.a.g.p.e.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Subscription f1053d;

    public static final class a<T> implements Action1 {
        public final /* synthetic */ String b;

        public a(String str) {
            this.b = str;
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(e.c.a.g.a.f.k.c<i> cVar) {
            f.this.a().showLoading(false);
            i iVarA = cVar.a();
            if (cVar.f()) {
                if (iVarA == null) {
                    p1.h(KGApplication.getContext(), "订单接口数据异常");
                    e.c.a.g.a.g.p.g.a.a.d(35, "订单接口数据异常");
                    return;
                }
                i.a aVarD = iVarA.d();
                i.a.C0158a c0158aA = aVarD == null ? null : aVarD.a();
                String strB = c0158aA == null ? null : c0158aA.b();
                String strA = c0158aA != null ? c0158aA.a() : null;
                if (!(strB == null || strB.length() == 0)) {
                    if (!(strA == null || strA.length() == 0)) {
                        XTCPayActivity.m(f.this.a().geFragment().getActivity(), strB, iVarA.b(), iVarA.c(), this.b, v0.a(iVarA.a()), strA);
                        return;
                    }
                }
                p1.h(KGApplication.getContext(), "小天才订单数据缺失");
                e.c.a.g.a.g.p.g.a.a.d(36, "小天才订单数据缺失");
                return;
            }
            if (cVar.b() == 20028 || cVar.b() == 20029) {
                p1.h(KGApplication.getContext(), e.c.a.g.a.f.e.c.a.a().b(e.c.a.g.a.f.e.b.s2, "消费金额到达未成年人充值额度~"));
                e.c.a.g.a.g.p.g.a.a.d(33, "消费金额到达未成年人充值额度");
                return;
            }
            p1.h(KGApplication.getContext(), h1.q(cVar.c(), "请求失败，请稍后重试~"));
            if (g0.a) {
                p1.h(KGApplication.getContext(), "err:" + cVar.b() + ",msg:" + ((Object) cVar.c()));
            }
            e.c.a.g.a.g.p.g.a aVar = e.c.a.g.a.g.p.g.a.a;
            j.d(cVar, "resp");
            aVar.b(cVar);
        }
    }

    public static final class b<T> implements Action1 {
        public b() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(Throwable th) {
            f.this.a().showLoading(false);
            p1.h(KGApplication.getContext(), "网络异常，请稍后重试");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(d dVar, e eVar) {
        super(dVar, eVar);
        j.e(dVar, "view");
        j.e(eVar, "vipProduct");
    }

    @Override // e.c.a.g.a.g.p.e.c
    public void createOrder(int i2, String str) {
        j.e(str, "productName");
        String strE = e(i2);
        if (e.c.a.g.a.r.b.O() && !d(strE)) {
            p1.h(KGApplication.getContext(), "您已超出最大购买套餐，请理性消费");
            e.c.a.g.a.g.p.g.a.a.d(31, "您已超出最大购买套餐，请理性消费");
        } else {
            a().showLoading(true);
            i1.a(this.f1053d);
            this.f1053d = e.c.a.g.a.g.p.f.b.a.b("xtc", "xtc", strE).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(str), new b());
        }
    }

    public final boolean d(String str) {
        long jA = v1.a();
        long jD = v1.d();
        long jB = v1.b();
        if (g0.a) {
            g0.b("XTCVipPaymentPresenter", "isCanBuyVIP: 超级会员:" + ((Object) k.c(jA, "yyyy-MM-dd")) + ",  概念会员:" + ((Object) k.c(jD, "yyyy-MM-dd")) + ",  豪华会员:" + ((Object) k.c(jB, "yyyy-MM-dd")) + ' ');
        }
        int configAsInt = e.c.a.g.a.f.e.c.a.a().getConfigAsInt(e.c.a.g.a.f.e.b.p2, 1);
        if (configAsInt == 1) {
            jD = v0.b(jA, jD, jB);
        } else if (configAsInt != 2) {
            jD = configAsInt != 3 ? v0.b(jA, jD, jB) : -1L;
        }
        if (jD <= 0) {
            return true;
        }
        long jCurrentTimeMillis = jD - System.currentTimeMillis();
        if (g0.a) {
            double d2 = jCurrentTimeMillis;
            Double.isNaN(d2);
            double d3 = 2678400000L;
            Double.isNaN(d3);
            g0.b("XTCVipPaymentPresenter", j.l("isCanBuyVIP: VIP剩余月数：", Double.valueOf((d2 * 1.0d) / d3)));
        }
        if (jCurrentTimeMillis <= 0) {
            return true;
        }
        if (jCurrentTimeMillis <= 8035200000L) {
            return j.a(str, c().a) || j.a(str, c().b) || j.a(str, c().c);
        }
        if (jCurrentTimeMillis <= 32140800000L) {
            return j.a(str, c().a) || j.a(str, c().b);
        }
        if (jCurrentTimeMillis <= 37497600000L) {
            return j.a(str, c().a);
        }
        return false;
    }

    public final String e(int i2) {
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
        i1.a(this.f1053d);
        this.f1053d = null;
    }
}
