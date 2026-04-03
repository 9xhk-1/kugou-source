package com.kugou.android.watch.lite.component.vip;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.google.gson.Gson;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.activity.StateFragmentActivity;
import com.kugou.android.watch.lite.bi.YoungBITask;
import com.kugou.android.watch.lite.common.widget.loading.CommonLoadingView;
import com.kugou.android.watch.lite.component.vip.payment.VipPaymentFragment;
import com.kugou.android.watch.lite.user.login.UserData;
import com.kugou.common.startAppAPM.task.RingBiReportHelper;
import com.kugou.common.useraccount.utils.SVIPExtInfoUtil;
import com.kugou.common.userinfo.protocol.GetVIPInfoProtocol;
import com.xtc.payapi.contact.BaseRequest;
import com.xtc.payapi.contact.BaseResponse;
import com.xtc.payapi.contact.IPayResponseCallback;
import com.xtc.payapi.contact.ProductInfo;
import com.xtc.payapi.contact.SendPayMesToXTC;
import com.xtc.payapi.paymanager.PayApiManager;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.h1;
import e.c.a.g.a.s.i1;
import e.c.a.g.a.s.j0;
import e.c.a.g.a.s.p1;
import e.c.a.g.a.s.s0;
import java.math.BigDecimal;
import java.util.ArrayList;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes2.dex */
public class XTCPayActivity extends StateFragmentActivity implements IPayResponseCallback, View.OnClickListener {
    public static int p;
    public String b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f204d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f205f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f206h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public CommonLoadingView f207i;
    public TextView j;
    public PayApiManager k;
    public Subscription l;
    public Subscription m;
    public int a = 1;
    public boolean n = false;
    public boolean o = false;

    public class a implements Action1<e.c.a.g.a.f.k.c<e.c.a.g.a.g.p.d.c>> {
        public a() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(e.c.a.g.a.f.k.c<e.c.a.g.a.g.p.d.c> cVar) {
            e.c.a.g.a.g.p.d.c cVarA = cVar.a();
            if (!cVar.f() || cVarA == null) {
                XTCPayActivity.this.l();
            } else if (cVarA.a() != 1) {
                XTCPayActivity.this.l();
            } else {
                XTCPayActivity.this.i();
            }
        }
    }

    public class b implements Action1<Throwable> {
        public b() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(Throwable th) {
            XTCPayActivity.this.l();
        }
    }

    public class c implements Action1<UserData> {
        public c() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(UserData userData) {
            if (userData == null || userData.getStatus() != 1) {
                XTCPayActivity.this.l();
                return;
            }
            e.c.a.g.a.r.b.a(userData);
            SVIPExtInfoUtil.saveSVIPExtInfo(userData);
            e.c.a.g.a.f.d.a.d(new Intent("com.kugou.android.action.VIP_PAY_SUCCESS"));
            if (g0.a) {
                g0.b("XTCPayActivity", "refreshVipInfo: vip信息更新成功");
            }
            XTCPayActivity.this.finish();
        }
    }

    public class d implements Action1<Throwable> {
        public d() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(Throwable th) {
            XTCPayActivity.this.l();
        }
    }

    public class e implements Func1<String, UserData> {
        public e(XTCPayActivity xTCPayActivity) {
        }

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public UserData call(String str) {
            UserData vIPInfo = new GetVIPInfoProtocol().getVIPInfo(e.c.a.g.a.r.b.o(), e.c.a.g.a.r.b.n());
            if (vIPInfo != null && vIPInfo.getStatus() == 1) {
                e.c.a.g.a.f.k.c<UserData> cVarA = e.c.a.g.a.r.d.d.b.a.a();
                if (cVarA.a() != null && cVarA.f()) {
                    vIPInfo.setBusiVip(cVarA.a().getBusiVip());
                }
            }
            return vIPInfo;
        }
    }

    public class f implements Runnable {
        public final /* synthetic */ String a;

        public f(XTCPayActivity xTCPayActivity, String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                RingBiReportHelper.INSTANCE.reportPayPage("小天才支付页", "开始支付payData:" + this.a);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            XTCPayActivity.this.h();
        }
    }

    public static void m(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        if (context == null) {
            return;
        }
        Intent intentA = s0.a.a(context, XTCPayActivity.class);
        intentA.putExtra("key_order_id", str);
        intentA.putExtra("key_order_id_for_kg", str2);
        intentA.putExtra("key_product_id", str3);
        intentA.putExtra("key_product_name", str4);
        intentA.putExtra("key_product_price", str5);
        intentA.putExtra("key_check_code", str6);
        context.startActivity(intentA);
    }

    public final PayApiManager f() {
        if (this.k == null) {
            this.k = new PayApiManager(this);
        }
        return this.k;
    }

    public final String g(BaseResponse baseResponse) {
        String str = baseResponse.errorCode;
        str.hashCode();
        switch (str) {
            case "-1":
                return "网络异常";
            case "1003":
                return "支付频繁,请稍后再使用";
            case "12001":
                return "参数无效";
            case "12005":
                return "支付数额不相同";
            case "12006":
                return "订单创建错误";
            case "12008":
                return "支付中心获取支付凭证失败";
            case "12009":
                return "订单号不存在";
            case "12010":
                return "传参用户和实际用户信息不符，无法获取订单详情";
            case "12012":
                return "第三方订单id没变，但是商品内容有修改";
            case "12013":
                return "订单已支付";
            case "12014":
                return "订单查询失败";
            case "12015":
                return "订单状态未更新";
            case "12016":
                return "签名校验错误";
            case "12020":
                return "校验码过期";
            case "12099":
                return "其它错误";
            case "12201":
                return "请求参数有问题";
            case "12207":
                return "订单异常";
            case "12208":
                return "预下单失败";
            case "12209":
                return "无效的openId";
            case "12215":
                return "支付渠道与支付类型不匹配";
            default:
                return String.format("未知支付错误(%s)", baseResponse.errorCode);
        }
    }

    public final void h() {
        this.a = 1;
        k();
        i1.a(this.m);
        this.m = e.c.a.g.a.g.p.f.b.a.d(this.f204d).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(), new b());
    }

    public final void i() {
        this.a = 2;
        k();
        i1.a(this.l);
        this.l = Observable.just("").subscribeOn(Schedulers.io()).map(new e(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(), new d());
    }

    public final void j(String str) {
        try {
            Log.e("xtc", str);
            j0.b().a(new f(this, str));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void k() {
        CommonLoadingView commonLoadingView = this.f207i;
        if (commonLoadingView != null) {
            commonLoadingView.setVisibility(0);
        }
        TextView textView = this.j;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    public final void l() {
        CommonLoadingView commonLoadingView = this.f207i;
        if (commonLoadingView != null) {
            commonLoadingView.setVisibility(8);
        }
        TextView textView = this.j;
        if (textView != null) {
            textView.setVisibility(0);
            if (this.a == 1) {
                this.j.setText("订单查询失败\n轻触屏幕重试");
            } else {
                this.j.setText("VIP信息更新失败\n轻触屏幕重试");
            }
        }
    }

    public final void n(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        PayApiManager payApiManagerF = f();
        SendPayMesToXTC.Request request = new SendPayMesToXTC.Request();
        request.appId = str;
        request.orderId = str2;
        request.isUseSdkOpenid = true;
        request.checkCode = str6;
        request.payType = 3;
        request.setThumbImage(BitmapFactory.decodeResource(getResources(), R.drawable.icon));
        request.totalPrice = new BigDecimal(str5);
        request.describeTitle = str7;
        ArrayList arrayList = new ArrayList();
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId(str3);
        productInfo.setProductName(str4);
        productInfo.setPrice(new BigDecimal(str5));
        productInfo.setNumber(1);
        arrayList.add(productInfo);
        request.productInfos = new Gson().toJson(arrayList);
        if (g0.a) {
            g0.b("XTCPayActivity", "req = " + request);
        }
        boolean zSendRequestToXTC = payApiManagerF.sendRequestToXTC(request);
        j("startPay, result = " + zSendRequestToXTC + "," + str + "," + str2 + "," + str3 + "," + str4 + "," + str5 + "," + str7);
        if (zSendRequestToXTC) {
            e.c.a.g.a.g.p.g.a.a.e("小天才二维码展示成功");
        } else {
            e.c.a.g.a.g.p.g.a.a.d(41, "小天才二维码展示失败");
        }
    }

    public final void o(String str, String str2, String str3) {
        String str4 = "CONCEPT_1M_XTC".equals(this.f205f) ? "1" : "CONCEPT_3M_XTC".equals(this.f205f) ? "2" : "CONCEPT_12M_XTC".equals(this.f205f) ? "3" : null;
        if (g0.f()) {
            g0.b("12820971report", "tracePayResult, before svar4 = " + str4);
        }
        if (TextUtils.isEmpty(str4) && VipPaymentFragment.L != null && !TextUtils.isEmpty(this.f205f)) {
            str4 = VipPaymentFragment.L.get(this.f205f);
        }
        if (g0.f()) {
            g0.b("12820971report", "tracePayResult, after svar4 = " + str4);
        }
        e.c.a.g.a.e.b.b(new YoungBITask(12820971, "statistics").setState(str).setSvar1(str2).setSvar2(this.b).setSvar3(str3).setSvar4(str4).setSvar5(this.f206h));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.common_refresh) {
            if (this.a != 1) {
                i();
            } else {
                h();
            }
        }
    }

    @Override // com.kugou.android.watch.lite.base.activity.StateFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_xtc_pay);
        this.f207i = (CommonLoadingView) findViewById(R.id.common_loading);
        TextView textView = (TextView) findViewById(R.id.common_refresh);
        this.j = textView;
        textView.setOnClickListener(this);
        if (getIntent() == null) {
            finish();
            return;
        }
        this.b = getIntent().getStringExtra("key_order_id");
        this.f206h = getIntent().getStringExtra("key_product_price");
        String stringExtra = getIntent().getStringExtra("key_check_code");
        if (TextUtils.isEmpty(this.b)) {
            p1.h(this, "订单id传递异常");
            e.c.a.g.a.g.p.g.a.a.d(37, "订单id传递异常");
            finish();
            return;
        }
        if (TextUtils.isEmpty(stringExtra)) {
            p1.h(this, "code id传递异常");
            finish();
            e.c.a.g.a.g.p.g.a.a.d(38, "code id传递异常");
            return;
        }
        if (TextUtils.isEmpty(this.f206h)) {
            p1.h(this, "订单价格异常");
            e.c.a.g.a.g.p.g.a.a.d(39, "订单价格异常");
            finish();
            return;
        }
        String stringExtra2 = getIntent().getStringExtra("key_order_id_for_kg");
        this.f204d = stringExtra2;
        if (TextUtils.isEmpty(stringExtra2)) {
            p1.h(this, "订单number异常");
            e.c.a.g.a.g.p.g.a.a.d(40, "订单number异常");
            finish();
        } else {
            this.f205f = getIntent().getStringExtra("key_product_id");
            String strQ = h1.q(getIntent().getStringExtra("key_product_name"), "概念版会员套餐");
            n(String.valueOf(100098), this.b, this.f205f, strQ, this.f206h, stringExtra, strQ);
            p = hashCode();
        }
    }

    @Override // com.kugou.android.watch.lite.base.activity.StateFragmentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (g0.a) {
            g0.b("XTCPayActivity", "onDestroy: ");
        }
        i1.a(this.m, this.l);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (g0.a) {
            g0.b("XTCPayActivity", "onNewIntent: " + intent);
        }
        setIntent(intent);
        if (p == hashCode()) {
            this.n = true;
            f().handleIntent(intent, this);
        }
    }

    @Override // com.xtc.payapi.contact.IPayResponseCallback
    public void onRequest(BaseRequest baseRequest) {
        if (g0.a) {
            g0.b("XTCPayActivity", "onRequest: " + baseRequest);
        }
    }

    @Override // com.xtc.payapi.contact.IPayResponseCallback
    public void onResponse(BaseResponse baseResponse) {
        SendPayMesToXTC.Response response = (SendPayMesToXTC.Response) baseResponse;
        if (g0.a) {
            g0.b("XTCPayActivity", "onResponse: response=" + response);
        }
        if (!"1".equals(baseResponse.errorCode)) {
            p1.h(this, g(baseResponse));
            o("0", response.openid, baseResponse.errorCode);
        } else {
            p1.h(this, "支付成功");
            j0.h(new g(), 1000L);
            o("1", response.openid, "");
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (g0.a) {
            g0.b("XTCPayActivity", "onResume: ");
        }
        if (this.o && !this.n) {
            finish();
        }
        this.o = true;
    }
}
