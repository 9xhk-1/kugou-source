package com.kugou.android.watch.lite.component.vip.payment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.base.fragment.DelegateFragment;
import com.kugou.android.watch.lite.bi.YoungBITask;
import com.kugou.common.utils.YGlide;
import com.kugou.datacollect.bi.use.TraceFullTask;
import e.c.a.g.a.g.p.d.h;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.i1;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.p1;
import e.c.a.g.a.s.s1;
import e.c.a.g.a.s.u0;
import e.c.a.g.a.s.u1;
import e.c.a.g.a.s.v0;
import e.c.a.g.a.s.z;
import f.e0.n;
import f.e0.o;
import f.u.i;
import f.z.d.j;
import f.z.d.k;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import me.jessyan.autosize.AutoSizeConfig;
import me.jessyan.autosize.internal.CustomAdapt;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes2.dex */
@e.c.c.l.f.b(id = -1)
public final class VipPaymentFragment extends DelegateFragment implements View.OnClickListener, e.c.a.g.a.g.p.e.d, CustomAdapt {
    public static final a I = new a(null);
    public static long J;
    public static long K;
    public static HashMap<String, String> L;
    public TextView A;
    public TextView B;
    public Subscription D;
    public BroadcastReceiver H;
    public ImageView s;
    public ImageView t;
    public TextView u;
    public TextView v;
    public ImageView w;
    public TextView x;
    public TextView y;
    public ImageView z;
    public String r = "";
    public final z C = new s1();
    public final Map<Integer, e.c.a.g.a.g.p.d.d> E = new LinkedHashMap();
    public final boolean F = e.c.a.g.a.f.e.c.a.a().getConfigAsBoolean(e.c.a.g.a.f.e.b.X2, true);
    public final f.d G = f.f.b(new g());

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f.z.d.g gVar) {
            this();
        }
    }

    public static class b {
        public String a;
        public String b;
        public String c;

        public String a() {
            return this.a;
        }

        public String b() {
            return this.b;
        }

        public String c() {
            return this.c;
        }

        public void d(String str) {
            this.a = str;
        }

        public void e(String str) {
            this.b = str;
        }

        public void f(String str) {
            this.c = str;
        }

        public String toString() {
            return "PramesResult(productId 1M = " + ((Object) a()) + ", productId 3M = " + ((Object) b()) + ", productId 1Y = " + ((Object) c()) + ')';
        }
    }

    public static final class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            VipPaymentFragment.this.K0();
        }
    }

    public static final class d<T, R> implements Func1 {
        public d() {
        }

        public final e.c.a.g.a.f.k.c<List<e.c.a.g.a.g.p.d.d>> a(e.c.a.g.a.f.k.c<List<e.c.a.g.a.g.p.d.d>> cVar) {
            List<h> listM = e.c.a.g.a.g.p.b.f1018d.a().m();
            if (cVar.f()) {
                if (!(listM == null || listM.isEmpty())) {
                    VipPaymentFragment vipPaymentFragment = VipPaymentFragment.this;
                    for (h hVar : listM) {
                        if (i.f(vipPaymentFragment.F0().b(), hVar.c())) {
                            String strA = hVar.a();
                            if (!(strA == null || strA.length() == 0)) {
                                YGlide.with(vipPaymentFragment).load(hVar.a()).preloadSync();
                            }
                        }
                    }
                }
            }
            return cVar;
        }

        @Override // rx.functions.Func1
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            e.c.a.g.a.f.k.c<List<e.c.a.g.a.g.p.d.d>> cVar = (e.c.a.g.a.f.k.c) obj;
            a(cVar);
            return cVar;
        }
    }

    public static final class e<T> implements Action1 {
        public e() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(e.c.a.g.a.f.k.c<List<e.c.a.g.a.g.p.d.d>> cVar) {
            List<e.c.a.g.a.g.p.d.d> listA = cVar.a();
            if (cVar.f()) {
                int i2 = 0;
                if (!(listA == null || listA.isEmpty())) {
                    VipPaymentFragment vipPaymentFragment = VipPaymentFragment.this;
                    Iterator<T> it = listA.iterator();
                    while (it.hasNext()) {
                        if (i.f(vipPaymentFragment.F0().b(), ((e.c.a.g.a.g.p.d.d) it.next()).c())) {
                            i2++;
                        }
                    }
                    if (i2 < VipPaymentFragment.this.F0().b().length) {
                        VipPaymentFragment.this.C.showFailView();
                        p1.h(VipPaymentFragment.this.getContext(), "VIP套餐异常");
                        return;
                    } else {
                        VipPaymentFragment.this.C.showContentView();
                        VipPaymentFragment.this.P0(listA);
                        return;
                    }
                }
            }
            VipPaymentFragment.this.C.showFailView();
        }
    }

    public static final class f<T> implements Action1 {
        public f() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(Throwable th) {
            VipPaymentFragment.this.C.showFailView();
        }
    }

    public static final class g extends k implements f.z.c.a<e.c.a.g.a.g.p.e.a> {
        public g() {
            super(0);
        }

        @Override // f.z.c.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final e.c.a.g.a.g.p.e.a invoke() {
            return VipPaymentFragment.this.A0();
        }
    }

    static {
        J = l1.m0() ? 8000L : 3000L;
        L = new HashMap<>();
    }

    public final e.c.a.g.a.g.p.e.a A0() {
        b bVarE0;
        if (!this.F || (bVarE0 = E0()) == null) {
            return B0();
        }
        if (g0.f()) {
            g0.b("VipPaymentFragment", j.l("createTargetPresenter use online, result = ", bVarE0));
        }
        return C0(bVarE0);
    }

    public final e.c.a.g.a.g.p.e.a B0() {
        if (g0.f()) {
            g0.b("VipPaymentFragment", "createTargetPresenter use local");
        }
        return l1.m0() ? new e.c.a.g.a.g.p.e.f(this, new e.c.a.g.a.g.p.e.e("CONCEPT_1M_XTC", "CONCEPT_3M_XTC", "CONCEPT_12M_XTC")) : l1.g0() ? new e.c.a.g.a.g.p.e.b(this, D0(), new e.c.a.g.a.g.p.e.e("CONCEPT_1M_360WATCH", "CONCEPT_3M_360WATCH", "CONCEPT_12M_360WATCH")) : l1.V() ? new e.c.a.g.a.g.p.e.b(this, D0(), new e.c.a.g.a.g.p.e.e("CONCEPT_1M_HWWATCH", "CONCEPT_3M_HWWATCH", "CONCEPT_12M_HWWATCH")) : new e.c.a.g.a.g.p.e.b(this, D0(), new e.c.a.g.a.g.p.e.e("VIPAM", "VIPAS", "VIPAY"));
    }

    public final e.c.a.g.a.g.p.e.a C0(b bVar) {
        if (!l1.m0()) {
            return l1.g0() ? new e.c.a.g.a.g.p.e.b(this, D0(), new e.c.a.g.a.g.p.e.e(bVar.a(), bVar.b(), bVar.c())) : l1.V() ? new e.c.a.g.a.g.p.e.b(this, D0(), new e.c.a.g.a.g.p.e.e(bVar.a(), bVar.b(), bVar.c())) : new e.c.a.g.a.g.p.e.b(this, D0(), new e.c.a.g.a.g.p.e.e(bVar.a(), bVar.b(), bVar.c()));
        }
        L.clear();
        L.put(j.l("", bVar.a()), "1");
        L.put(j.l("", bVar.b()), "2");
        L.put(j.l("", bVar.c()), "3");
        return new e.c.a.g.a.g.p.e.f(this, new e.c.a.g.a.g.p.e.e(bVar.a(), bVar.b(), bVar.c()));
    }

    public final String D0() {
        return !TextUtils.isEmpty(this.r) ? this.r : l1.g0() ? "90408" : l1.V() ? "90409" : "90401";
    }

    public final b E0() {
        b bVar = new b();
        List<h> listM = e.c.a.g.a.g.p.b.f1018d.a().m();
        if (listM != null && listM.size() >= 3 && listM.get(0) != null && !TextUtils.isEmpty(listM.get(0).c()) && listM.get(1) != null && !TextUtils.isEmpty(listM.get(1).c()) && listM.get(2) != null && !TextUtils.isEmpty(listM.get(2).c())) {
            String strC = null;
            String strC2 = null;
            String strC3 = null;
            for (h hVar : listM) {
                if ("1".equals(hVar.b())) {
                    strC = hVar.c();
                } else if ("2".equals(hVar.b())) {
                    strC2 = hVar.c();
                } else if ("3".equals(hVar.b())) {
                    strC3 = hVar.c();
                }
            }
            if (!TextUtils.isEmpty(strC) && !TextUtils.isEmpty(strC2) && !TextUtils.isEmpty(strC3)) {
                bVar.d(strC);
                bVar.e(strC2);
                bVar.f(strC3);
                return bVar;
            }
        }
        return null;
    }

    public final e.c.a.g.a.g.p.e.a F0() {
        return (e.c.a.g.a.g.p.e.a) this.G.getValue();
    }

    public final void G0() {
        if (this.H == null) {
            this.H = new BroadcastReceiver() { // from class: com.kugou.android.watch.lite.component.vip.payment.VipPaymentFragment$initBroadcast$1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    j.e(context, "context");
                    j.e(intent, "intent");
                    String action = intent.getAction();
                    if (!TextUtils.isEmpty(action) && j.a(action, "com.kugou.android.action.VIP_PAY_SUCCESS")) {
                        this.a.e();
                    }
                }
            };
        }
        e.c.a.g.a.f.d.a.b(this.H, new IntentFilter("com.kugou.android.action.VIP_PAY_SUCCESS"));
    }

    public final void H0() {
        if (getArguments() != null) {
            Bundle arguments = getArguments();
            j.c(arguments);
            String string = arguments.getString("vip_source", "");
            j.d(string, "arguments!!.getString(VipJumpHelper.VIP_SOURCE, \"\")");
            this.r = string;
        }
    }

    public final void I0(View view) {
        TextView textView = (TextView) view.findViewById(R.id.vip_payment_help_desc);
        f.i iVar = new f.i("《会员服务协议》", "https://activity.kugou.com/privacy/v-4c566940/index.html");
        f.i iVar2 = new f.i("《隐私协议》", "https://activity.kugou.com/terms/v-9d1de340/index.html#/privacy");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("若开通或使用中遇到问题，客服微信：" + ((Object) e.c.a.g.a.f.e.c.a.a().b(e.c.a.g.a.f.e.b.j2, "GnainKG")) + "\n查看" + ((String) iVar.c()) + ' ' + ((String) iVar2.c()));
        f.i[] iVarArr = {iVar, iVar2};
        for (int i2 = 0; i2 < 2; i2++) {
            f.i iVar3 = iVarArr[i2];
            String str = (String) iVar3.c();
            String str2 = (String) iVar3.d();
            int iE = o.E(spannableStringBuilder, str, 0, false, 6, null);
            spannableStringBuilder.setSpan(new e.c.a.g.a.g.l.a(str2, L0(str), ContextCompat.getColor(requireContext(), R.color.auto_ht_v2)), iE, str.length() + iE, 33);
        }
        textView.setText(spannableStringBuilder);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public final void J0(View view) {
        View viewFindViewById = view.findViewById(R.id.vip_payment_title);
        j.d(viewFindViewById, "view.findViewById(R.id.vip_payment_title)");
        this.s = (ImageView) viewFindViewById;
        View viewFindViewById2 = view.findViewById(R.id.vip_payment_package_year);
        j.d(viewFindViewById2, "view.findViewById(R.id.vip_payment_package_year)");
        this.t = (ImageView) viewFindViewById2;
        View viewFindViewById3 = view.findViewById(R.id.vip_package_year_price);
        j.d(viewFindViewById3, "view.findViewById(R.id.vip_package_year_price)");
        this.u = (TextView) viewFindViewById3;
        View viewFindViewById4 = view.findViewById(R.id.vip_package_year_price_sec);
        j.d(viewFindViewById4, "view.findViewById(R.id.vip_package_year_price_sec)");
        this.v = (TextView) viewFindViewById4;
        View viewFindViewById5 = view.findViewById(R.id.vip_payment_package_quarter);
        j.d(viewFindViewById5, "view.findViewById(R.id.vip_payment_package_quarter)");
        this.w = (ImageView) viewFindViewById5;
        View viewFindViewById6 = view.findViewById(R.id.vip_package_quarter_price);
        j.d(viewFindViewById6, "view.findViewById(R.id.vip_package_quarter_price)");
        this.x = (TextView) viewFindViewById6;
        View viewFindViewById7 = view.findViewById(R.id.vip_package_quarter_price_sec);
        j.d(viewFindViewById7, "view.findViewById(R.id.vip_package_quarter_price_sec)");
        this.y = (TextView) viewFindViewById7;
        View viewFindViewById8 = view.findViewById(R.id.vip_payment_package_month);
        j.d(viewFindViewById8, "view.findViewById(R.id.vip_payment_package_month)");
        this.z = (ImageView) viewFindViewById8;
        View viewFindViewById9 = view.findViewById(R.id.vip_package_month_price);
        j.d(viewFindViewById9, "view.findViewById(R.id.vip_package_month_price)");
        this.A = (TextView) viewFindViewById9;
        View viewFindViewById10 = view.findViewById(R.id.vip_package_month_price_sec);
        j.d(viewFindViewById10, "view.findViewById(R.id.vip_package_month_price_sec)");
        this.B = (TextView) viewFindViewById10;
        View[] viewArr = new View[3];
        ImageView imageView = this.t;
        if (imageView == null) {
            j.t("yearBgView");
            throw null;
        }
        viewArr[0] = imageView;
        ImageView imageView2 = this.w;
        if (imageView2 == null) {
            j.t("quarterBgView");
            throw null;
        }
        viewArr[1] = imageView2;
        ImageView imageView3 = this.z;
        if (imageView3 == null) {
            j.t("monthBgView");
            throw null;
        }
        viewArr[2] = imageView3;
        u1.b(this, viewArr);
        this.C.bindView(view, new int[]{R.id.vip_payment_content, R.id.common_loading, R.id.common_refresh, -1, -1, -1, -1});
        view.findViewById(R.id.common_refresh).setOnClickListener(new c());
    }

    public final void K0() {
        this.C.showLoadingView();
        i1.a(this.D);
        this.D = e.c.a.g.a.g.p.f.b.a.e(F0().b()).subscribeOn(Schedulers.io()).map(new d()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(), new f());
    }

    public final String L0(String str) {
        return n.q(n.q(str, "《", "", false, 4, null), "》", "", false, 4, null);
    }

    public final void M0(TextView textView, String str) {
        SpannableString spannableString = new SpannableString(j.l(str, "元"));
        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(20, true);
        AbsoluteSizeSpan absoluteSizeSpan2 = new AbsoluteSizeSpan(10, true);
        int iE = o.E(spannableString, str, 0, false, 6, null);
        int length = str.length() + iE;
        spannableString.setSpan(absoluteSizeSpan, iE, length, 33);
        spannableString.setSpan(absoluteSizeSpan2, length, spannableString.length(), 33);
        textView.setText(spannableString);
    }

    public final void N0(ImageView imageView, String str, int i2) {
        imageView.setImageResource(i2);
        if (str == null || str.length() == 0) {
            return;
        }
        YGlide.with(this).load(str).error(i2).into(imageView);
    }

    public final void O0(TextView textView, String str) {
        SpannableString spannableString = new SpannableString(j.l(str, "元"));
        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(9, true);
        AbsoluteSizeSpan absoluteSizeSpan2 = new AbsoluteSizeSpan(6, true);
        int iE = o.E(spannableString, str, 0, false, 6, null);
        int length = str.length() + iE;
        spannableString.setSpan(absoluteSizeSpan, iE, length, 33);
        spannableString.setSpan(absoluteSizeSpan2, length, spannableString.length(), 33);
        textView.setVisibility(0);
        textView.setText(spannableString);
        textView.getPaint().setFlags(16);
    }

    public final void P0(List<e.c.a.g.a.g.p.d.d> list) {
        ImageView imageView = this.s;
        if (imageView == null) {
            j.t("headerIc");
            throw null;
        }
        N0(imageView, e.c.a.g.a.g.p.b.f1018d.a().l(), R.drawable.ic_vip_price_package);
        for (e.c.a.g.a.g.p.d.d dVar : list) {
            int iB = dVar.b();
            String strC = dVar.c();
            if (j.a(strC, F0().c().c)) {
                this.E.put(1, dVar);
                String strValueOf = String.valueOf(dVar.a() / 100);
                TextView textView = this.u;
                if (textView == null) {
                    j.t("yearPriceTv");
                    throw null;
                }
                String strA = v0.a(iB);
                j.d(strA, "getSafePrice(price)");
                M0(textView, strA);
                TextView textView2 = this.v;
                if (textView2 == null) {
                    j.t("yearSecPriceTv");
                    throw null;
                }
                O0(textView2, strValueOf);
            } else if (j.a(strC, F0().c().b)) {
                this.E.put(2, dVar);
                String strValueOf2 = String.valueOf(dVar.a() / 100);
                TextView textView3 = this.x;
                if (textView3 == null) {
                    j.t("quarterPriceTv");
                    throw null;
                }
                String strA2 = v0.a(iB);
                j.d(strA2, "getSafePrice(price)");
                M0(textView3, strA2);
                TextView textView4 = this.y;
                if (textView4 == null) {
                    j.t("quarterSecPriceTv");
                    throw null;
                }
                O0(textView4, strValueOf2);
            } else if (j.a(strC, F0().c().a)) {
                this.E.put(3, dVar);
                String strValueOf3 = String.valueOf(dVar.a() / 100);
                TextView textView5 = this.A;
                if (textView5 == null) {
                    j.t("monthPriceTv");
                    throw null;
                }
                String strA3 = v0.a(iB);
                j.d(strA3, "getSafePrice(price)");
                M0(textView5, strA3);
                TextView textView6 = this.B;
                if (textView6 == null) {
                    j.t("monthSecPriceTv");
                    throw null;
                }
                O0(textView6, strValueOf3);
            } else {
                continue;
            }
        }
        List<h> listM = e.c.a.g.a.g.p.b.f1018d.a().m();
        if (listM == null) {
            return;
        }
        for (h hVar : listM) {
            String strC2 = hVar.c();
            if (j.a(strC2, F0().c().c)) {
                ImageView imageView2 = this.t;
                if (imageView2 == null) {
                    j.t("yearBgView");
                    throw null;
                }
                N0(imageView2, hVar.a(), R.drawable.ic_vip_package_year);
            } else if (j.a(strC2, F0().c().b)) {
                ImageView imageView3 = this.w;
                if (imageView3 == null) {
                    j.t("quarterBgView");
                    throw null;
                }
                N0(imageView3, hVar.a(), R.drawable.ic_vip_package_quarter);
            } else if (j.a(strC2, F0().c().a)) {
                ImageView imageView4 = this.z;
                if (imageView4 == null) {
                    j.t("monthBgView");
                    throw null;
                }
                N0(imageView4, hVar.a(), R.drawable.ic_vip_package_month);
            } else {
                continue;
            }
        }
    }

    public final void Q0(int i2) {
        e.c.a.g.a.g.p.d.d dVar = this.E.get(Integer.valueOf(i2));
        if (dVar == null) {
            return;
        }
        String str = "1";
        TraceFullTask type = new YoungBITask(12820970, "click").setType(e.c.a.g.a.r.b.O() ? "1" : "0");
        if (i2 == 1) {
            str = "3";
        } else if (i2 == 2) {
            str = "2";
        } else if (i2 != 3) {
            str = "";
        }
        e.c.a.g.a.e.b.b(type.setSvar1(str).setSvar2(v0.a(dVar.b())));
    }

    @Override // e.c.a.g.a.g.p.e.d
    public DelegateFragment geFragment() {
        return this;
    }

    @Override // me.jessyan.autosize.internal.CustomAdapt
    public float getSizeInDp() {
        if (l1.X()) {
            return 170.0f;
        }
        return AutoSizeConfig.getInstance().getDesignWidthInDp();
    }

    @Override // me.jessyan.autosize.internal.CustomAdapt
    public boolean isBaseOnWidth() {
        return AutoSizeConfig.getInstance().isBaseOnWidth();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        j.e(view, "view");
        if (u1.i(view)) {
        }
        switch (view.getId()) {
            case R.id.vip_payment_package_month /* 2131231561 */:
                z0(3, "概念版1个月会员");
                Q0(3);
                break;
            case R.id.vip_payment_package_quarter /* 2131231562 */:
                z0(2, "概念版3个月会员");
                Q0(2);
                break;
            case R.id.vip_payment_package_year /* 2131231563 */:
                z0(1, "概念版12个月会员");
                Q0(1);
                break;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        j.e(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_vip_payment, viewGroup, false);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        BroadcastReceiver broadcastReceiver = this.H;
        if (broadcastReceiver != null) {
            e.c.a.g.a.f.d.a.g(broadcastReceiver);
        }
        i1.a(this.D);
        F0().release();
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsBaseFragment, com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        j.e(view, "view");
        super.onViewCreated(view, bundle);
        H0();
        J0(view);
        I0(view);
        G0();
        K0();
        e.c.a.g.a.e.b.b(new YoungBITask(12820969, "exposure").setType(e.c.a.g.a.r.b.O() ? "1" : "0"));
    }

    @Override // e.c.a.g.a.g.p.e.d
    public void showLoading(boolean z) {
        if (z) {
            q0(false);
        } else {
            i0();
        }
    }

    public final void z0(int i2, String str) {
        e.c.a.g.a.g.p.g.a aVar = e.c.a.g.a.g.p.g.a.a;
        aVar.f(i2, str);
        if (!u0.n(KGApplication.getApplication(), true)) {
            aVar.d(1, "网络异常");
            return;
        }
        if (K <= 0 || SystemClock.elapsedRealtime() - K >= J) {
            K = SystemClock.elapsedRealtime();
            F0().createOrder(i2, str);
        } else {
            p1.h(getContext(), "操作频繁，请稍后再使用");
            aVar.d(2, "操作频繁，请稍后再使用");
        }
    }
}
