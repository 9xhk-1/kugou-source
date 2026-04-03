package com.kugou.android.watch.lite.component.vip;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.activity.StateFragmentActivity;
import com.kugou.android.watch.lite.common.widget.loading.CommonLoadingView;
import com.kugou.android.watch.lite.user.entity.BusiVip;
import com.kugou.android.watch.lite.user.login.UserData;
import com.kugou.common.startAppAPM.task.RingBiReportHelper;
import com.kugou.common.useraccount.utils.SVIPExtInfoUtil;
import com.kugou.common.userinfo.protocol.GetVIPInfoProtocol;
import com.tme.fireeye.crash.crashmodule.jni.NativeCrashHandler;
import com.xtc.shareapi.share.shareobject.ShareCloudFileResource;
import e.c.a.g.a.s.c0;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.g1;
import e.c.a.g.a.s.i1;
import e.c.a.g.a.s.j0;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.p1;
import e.c.a.g.a.s.s0;
import e.c.a.g.a.s.u0;
import e.c.a.g.a.s.u1;
import e.c.a.g.a.s.z0;
import f.z.d.j;
import f.z.d.p;
import f.z.d.r;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes2.dex */
public final class CommonPayActivity extends StateFragmentActivity {
    public static final b l = new b(null);
    public View a;
    public ImageView b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f190d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CommonLoadingView f191f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f192h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f193i;
    public String j;
    public g1<a> k;

    public abstract class a extends g1.b {
        public a(CommonPayActivity commonPayActivity) {
            j.e(commonPayActivity, "this$0");
        }

        public void g() {
        }

        public void h() {
        }
    }

    public static final class b {
        public b() {
        }

        public /* synthetic */ b(f.z.d.g gVar) {
            this();
        }

        public final void a(Context context, String str, String str2, String str3, String str4, String str5) {
            if (context == null) {
                return;
            }
            Intent intentA = s0.a.a(context, CommonPayActivity.class);
            intentA.putExtra("key_wx_pay_code", str);
            intentA.putExtra("key_order_id_for_kg", str2);
            intentA.putExtra("key_product_id", str3);
            intentA.putExtra("key_product_name", str4);
            intentA.putExtra("key_product_price", str5);
            context.startActivity(intentA);
        }
    }

    public final class c extends a {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Subscription f194h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public long f195i;
        public final Runnable j;
        public final /* synthetic */ CommonPayActivity k;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: com.kugou.android.watch.lite.component.vip.CommonPayActivity$c$a$a, reason: collision with other inner class name */
            public static final class RunnableC0016a implements Runnable {
                public final /* synthetic */ c a;

                public RunnableC0016a(c cVar) {
                    this.a = cVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.a.m();
                }
            }

            public a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                c cVar = c.this;
                cVar.l(new RunnableC0016a(cVar));
            }
        }

        public static final class b<T> implements Action1 {
            public final /* synthetic */ Runnable a;
            public final /* synthetic */ c b;

            public b(Runnable runnable, c cVar) {
                this.a = runnable;
                this.b = cVar;
            }

            @Override // rx.functions.Action1
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final void call(e.c.a.g.a.f.k.c<e.c.a.g.a.g.p.d.c> cVar) {
                e.c.a.g.a.g.p.d.c cVarA = cVar.a();
                if (g0.f()) {
                    Log.d("mhs_watch_pay", j.l("queryOrderStatus: ", cVarA));
                }
                if (!cVar.f() || cVarA == null) {
                    this.a.run();
                } else if (cVarA.a() != 1) {
                    this.a.run();
                } else {
                    this.b.b(e.class);
                }
            }
        }

        /* JADX INFO: renamed from: com.kugou.android.watch.lite.component.vip.CommonPayActivity$c$c, reason: collision with other inner class name */
        public static final class C0017c<T> implements Action1 {
            public final /* synthetic */ Runnable a;

            public C0017c(Runnable runnable) {
                this.a = runnable;
            }

            @Override // rx.functions.Action1
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final void call(Throwable th) {
                g0.i(th);
                this.a.run();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(CommonPayActivity commonPayActivity) {
            super(commonPayActivity);
            j.e(commonPayActivity, "this$0");
            this.k = commonPayActivity;
            this.j = new a();
        }

        @Override // e.c.a.g.a.s.g1.b
        public void d(Object obj) {
            super.d(obj);
            m();
        }

        @Override // e.c.a.g.a.s.g1.b
        public void e() {
            super.e();
            n();
        }

        @Override // com.kugou.android.watch.lite.component.vip.CommonPayActivity.a
        public void g() {
            super.g();
            n();
        }

        @Override // com.kugou.android.watch.lite.component.vip.CommonPayActivity.a
        public void h() {
            super.h();
            m();
        }

        public final long k(long j) {
            long jElapsedRealtime = SystemClock.elapsedRealtime() - j;
            if (jElapsedRealtime < 50000) {
                return 2000L;
            }
            if (jElapsedRealtime < 120000) {
                return 5000L;
            }
            return NativeCrashHandler.NATIVE_RECORD_FILE_LOCK_EXPIRED_TIME;
        }

        public final void l(Runnable runnable) {
            if (!u0.n(this.k, false)) {
                runnable.run();
                return;
            }
            i1.a(this.f194h);
            e.c.a.g.a.g.p.f.b bVar = e.c.a.g.a.g.p.f.b.a;
            String str = this.k.j;
            j.c(str);
            this.f194h = bVar.d(str).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(runnable, this), new C0017c(runnable));
        }

        public final void m() {
            if (this.f195i <= 0) {
                this.f195i = SystemClock.elapsedRealtime();
            }
            if ((SystemClock.elapsedRealtime() - this.f195i) / 1000 < e.c.a.g.a.g.p.f.b.a.c()) {
                j0.h(this.j, k(this.f195i));
            } else {
                if (g0.a) {
                    g0.b("CommonPayActivity", "startQueryTask: 二维码过期");
                }
                this.k.n();
            }
        }

        public final void n() {
            i1.a(this.f194h);
            j0.i(this.j);
        }
    }

    public final class d extends a {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Subscription f196h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ CommonPayActivity f197i;

        public static final class a<T, R> implements Func1 {
            public final /* synthetic */ CommonPayActivity a;
            public final /* synthetic */ p b;

            public a(CommonPayActivity commonPayActivity, p pVar) {
                this.a = commonPayActivity;
                this.b = pVar;
            }

            @Override // rx.functions.Func1
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Bitmap call(String str) {
                j.d(str, "it");
                Bitmap bitmapA = z0.a(str, this.a.k());
                if (bitmapA != null) {
                    return bitmapA;
                }
                Bitmap bitmapA2 = z0.a(str, 58.0f);
                this.b.a = false;
                return bitmapA2;
            }
        }

        public static final class b<T> implements Action1 {
            public final /* synthetic */ ImageView a;
            public final /* synthetic */ CommonPayActivity b;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ d f198d;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final /* synthetic */ r<String> f199f;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public final /* synthetic */ p f200h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public final /* synthetic */ String f201i;

            public b(ImageView imageView, CommonPayActivity commonPayActivity, d dVar, r<String> rVar, p pVar, String str) {
                this.a = imageView;
                this.b = commonPayActivity;
                this.f198d = dVar;
                this.f199f = rVar;
                this.f200h = pVar;
                this.f201i = str;
            }

            @Override // rx.functions.Action1
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final void call(Bitmap bitmap) {
                if (bitmap != null) {
                    this.a.setImageBitmap(bitmap);
                }
                this.b.o();
                this.f198d.b(c.class);
                try {
                    this.f199f.a = (T) j.l("firstBuildOk = ", Boolean.valueOf(this.f200h.a));
                    if (bitmap != null) {
                        r<String> rVar = this.f199f;
                        rVar.a = (T) j.l(rVar.a, ",展示成功");
                        e.c.a.g.a.g.p.g.a.a.e(this.f199f.a);
                    } else {
                        r<String> rVar2 = this.f199f;
                        rVar2.a = (T) j.l(rVar2.a, ",展示失败");
                        e.c.a.g.a.g.p.g.a.a.d(20, j.l(this.f199f.a, ", 二维码展示失败"));
                    }
                    this.f199f.a = (T) (this.f199f.a + ",url=" + ((Object) this.f201i));
                    Log.e("mhs_watch_report_pay", "reportTrace: " + this.f199f.a + "， firstBuildOk: " + this.f200h.a);
                    RingBiReportHelper.INSTANCE.reportPayPage("支付二维码展示", this.f199f.a);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(CommonPayActivity commonPayActivity) {
            super(commonPayActivity);
            j.e(commonPayActivity, "this$0");
            this.f197i = commonPayActivity;
        }

        @Override // e.c.a.g.a.s.g1.b
        public void d(Object obj) {
            super.d(obj);
            if (g0.a) {
                g0.b("CommonPayActivity", j.l("onStart: wxPayCode:", obj));
            }
            this.f197i.p("正在生成二维码");
            if (obj instanceof String) {
                if (((CharSequence) obj).length() > 0) {
                    i((String) obj);
                }
            }
        }

        @Override // e.c.a.g.a.s.g1.b
        public void e() {
            super.e();
            i1.a(this.f196h);
        }

        public final void i(String str) {
            ImageView imageView = this.f197i.b;
            if (imageView == null) {
                j.t("payQRCodeIv");
                throw null;
            }
            if (str == null || str.length() == 0) {
                return;
            }
            r rVar = new r();
            rVar.a = "";
            p pVar = new p();
            pVar.a = true;
            this.f196h = Observable.just(str).map(new a(this.f197i, pVar)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(imageView, this.f197i, this, rVar, pVar, str), i1.b);
        }
    }

    public final class e extends a {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Subscription f202h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ CommonPayActivity f203i;

        public static final class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.this.j();
            }
        }

        public static final class b<T, R> implements Func1 {
            public static final b<T, R> a = new b<>();

            @Override // rx.functions.Func1
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final UserData call(String str) {
                UserData vIPInfo = new GetVIPInfoProtocol().getVIPInfo(e.c.a.g.a.r.b.o(), e.c.a.g.a.r.b.n());
                if (vIPInfo != null) {
                    boolean z = true;
                    if (vIPInfo.getStatus() == 1) {
                        e.c.a.g.a.f.k.c<UserData> cVarA = e.c.a.g.a.r.d.d.b.a.a();
                        if (!cVarA.f()) {
                            return null;
                        }
                        UserData userDataA = cVarA.a();
                        BusiVip[] busiVip = userDataA != null ? userDataA.getBusiVip() : null;
                        if (busiVip != null) {
                            if (!(busiVip.length == 0)) {
                                z = false;
                            }
                        }
                        if (!z) {
                            vIPInfo.setBusiVip(busiVip);
                        }
                    }
                }
                return vIPInfo;
            }
        }

        public static final class c<T> implements Action1 {
            public final /* synthetic */ CommonPayActivity a;

            public static final class a implements Runnable {
                public final /* synthetic */ CommonPayActivity a;

                public a(CommonPayActivity commonPayActivity) {
                    this.a = commonPayActivity;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.a.finish();
                }
            }

            public c(CommonPayActivity commonPayActivity) {
                this.a = commonPayActivity;
            }

            @Override // rx.functions.Action1
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final void call(UserData userData) {
                if (userData == null || userData.getStatus() != 1) {
                    this.a.q();
                    return;
                }
                e.c.a.g.a.r.b.a(userData);
                SVIPExtInfoUtil.saveSVIPExtInfo(userData);
                e.c.a.g.a.f.d.a.d(new Intent("com.kugou.android.action.VIP_PAY_SUCCESS"));
                if (g0.a) {
                    g0.b("CommonPayActivity", "refreshVipInfo: vip信息更新成功");
                }
                j0.h(new a(this.a), 1000L);
            }
        }

        public static final class d<T> implements Action1 {
            public final /* synthetic */ CommonPayActivity a;

            public d(CommonPayActivity commonPayActivity) {
                this.a = commonPayActivity;
            }

            @Override // rx.functions.Action1
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final void call(Throwable th) {
                this.a.q();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(CommonPayActivity commonPayActivity) {
            super(commonPayActivity);
            j.e(commonPayActivity, "this$0");
            this.f203i = commonPayActivity;
        }

        @Override // e.c.a.g.a.s.g1.b
        public void d(Object obj) {
            super.d(obj);
            TextView textView = this.f203i.f192h;
            if (textView == null) {
                j.t("refreshView");
                throw null;
            }
            textView.setOnClickListener(new a());
            j();
        }

        @Override // e.c.a.g.a.s.g1.b
        public void e() {
            super.e();
            TextView textView = this.f203i.f192h;
            if (textView == null) {
                j.t("refreshView");
                throw null;
            }
            textView.setOnClickListener(null);
            i1.a(this.f202h);
        }

        public final void j() {
            this.f203i.p("正在校验订单");
            i1.a(this.f202h);
            Observable observableObserveOn = Observable.just("").subscribeOn(Schedulers.io()).map(b.a).observeOn(AndroidSchedulers.mainThread());
            CommonPayActivity commonPayActivity = this.f203i;
            this.f202h = observableObserveOn.subscribe(new c(commonPayActivity), new d(commonPayActivity));
        }
    }

    public static final class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            CommonPayActivity.this.finish();
        }
    }

    public static final class g<T> implements c0.a {
        public g() {
        }

        @Override // e.c.a.g.a.s.c0.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final a create(Class<? extends a> cls) {
            if (j.a(cls, d.class)) {
                return new d(CommonPayActivity.this);
            }
            if (j.a(cls, c.class)) {
                return new c(CommonPayActivity.this);
            }
            if (j.a(cls, e.class)) {
                return new e(CommonPayActivity.this);
            }
            throw new IllegalArgumentException(j.l("invalid state : ", cls));
        }
    }

    public CommonPayActivity() {
        f.b0.f.b(e.c.a.g.a.f.e.c.a.a().getConfigAsInt(e.c.a.g.a.f.e.b.r2, ShareCloudFileResource.HEIGHT), 60);
    }

    public final float k() {
        if (l1.X()) {
            return f.b0.f.g(l1.q0(this, l1.z(this)) - 40.0f, 58.0f, 120.0f);
        }
        return 58.0f;
    }

    public final void l() {
        e.c.a.g.a.f.o.i.c.a().f(1, findViewById(R.id.root_view));
        View viewFindViewById = findViewById(R.id.content_view);
        j.d(viewFindViewById, "findViewById(R.id.content_view)");
        this.a = viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.pay_qr_code);
        j.d(viewFindViewById2, "findViewById(R.id.pay_qr_code)");
        this.b = (ImageView) viewFindViewById2;
        View viewFindViewById3 = findViewById(R.id.pay_qr_code_expire);
        j.d(viewFindViewById3, "findViewById(R.id.pay_qr_code_expire)");
        this.f190d = (TextView) viewFindViewById3;
        View viewFindViewById4 = findViewById(R.id.common_loading);
        j.d(viewFindViewById4, "findViewById(R.id.common_loading)");
        this.f191f = (CommonLoadingView) viewFindViewById4;
        View viewFindViewById5 = findViewById(R.id.common_refresh);
        j.d(viewFindViewById5, "findViewById(R.id.common_refresh)");
        this.f192h = (TextView) viewFindViewById5;
        findViewById(R.id.iv_back).setOnClickListener(new f());
        if (l1.X()) {
            View view = this.a;
            if (view != null) {
                u1.l(view, 17);
            } else {
                j.t("contentGroup");
                throw null;
            }
        }
    }

    public final void m() {
        Intent intent = getIntent();
        this.f193i = intent.getStringExtra("key_wx_pay_code");
        this.j = intent.getStringExtra("key_order_id_for_kg");
    }

    public final void n() {
        View view = this.a;
        if (view == null) {
            j.t("contentGroup");
            throw null;
        }
        view.setVisibility(0);
        TextView textView = this.f190d;
        if (textView == null) {
            j.t("payExpireTv");
            throw null;
        }
        textView.setVisibility(0);
        CommonLoadingView commonLoadingView = this.f191f;
        if (commonLoadingView == null) {
            j.t("loadingView");
            throw null;
        }
        commonLoadingView.setVisibility(8);
        TextView textView2 = this.f192h;
        if (textView2 != null) {
            textView2.setVisibility(8);
        } else {
            j.t("refreshView");
            throw null;
        }
    }

    public final void o() {
        View view = this.a;
        if (view == null) {
            j.t("contentGroup");
            throw null;
        }
        view.setVisibility(0);
        TextView textView = this.f190d;
        if (textView == null) {
            j.t("payExpireTv");
            throw null;
        }
        textView.setVisibility(8);
        CommonLoadingView commonLoadingView = this.f191f;
        if (commonLoadingView == null) {
            j.t("loadingView");
            throw null;
        }
        commonLoadingView.setVisibility(8);
        TextView textView2 = this.f192h;
        if (textView2 != null) {
            textView2.setVisibility(8);
        } else {
            j.t("refreshView");
            throw null;
        }
    }

    @Override // com.kugou.android.watch.lite.base.activity.StateFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_common_pay);
        l();
        m();
        if (TextUtils.isEmpty(this.f193i)) {
            p1.h(this, "支付二维码传递异常");
            finish();
        } else {
            if (TextUtils.isEmpty(this.j)) {
                p1.h(this, "订单number异常");
                finish();
                return;
            }
            g1<a> g1Var = new g1<>(new g());
            this.k = g1Var;
            if (g1Var != null) {
                g1Var.g(d.class, this.f193i);
            } else {
                j.t("stateCtrl");
                throw null;
            }
        }
    }

    @Override // com.kugou.android.watch.lite.base.activity.StateFragmentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (g0.a) {
            g0.b("CommonPayActivity", "onDestroy: ");
        }
        g1<a> g1Var = this.k;
        if (g1Var != null) {
            g1Var.d();
        } else {
            j.t("stateCtrl");
            throw null;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (g0.a) {
            g0.b("CommonPayActivity", "onPause: ");
        }
        g1<a> g1Var = this.k;
        if (g1Var == null) {
            j.t("stateCtrl");
            throw null;
        }
        a aVar = (a) g1Var.a();
        if (aVar == null) {
            return;
        }
        aVar.g();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        g1<a> g1Var = this.k;
        if (g1Var == null) {
            j.t("stateCtrl");
            throw null;
        }
        a aVar = (a) g1Var.a();
        if (aVar != null) {
            aVar.h();
        }
        if (g0.a) {
            g0.b("CommonPayActivity", "onResume: ");
        }
    }

    public final void p(String str) {
        CommonLoadingView commonLoadingView = this.f191f;
        if (commonLoadingView == null) {
            j.t("loadingView");
            throw null;
        }
        commonLoadingView.setVisibility(0);
        CommonLoadingView commonLoadingView2 = this.f191f;
        if (commonLoadingView2 == null) {
            j.t("loadingView");
            throw null;
        }
        commonLoadingView2.setText(str);
        TextView textView = this.f192h;
        if (textView == null) {
            j.t("refreshView");
            throw null;
        }
        textView.setVisibility(8);
        View view = this.a;
        if (view != null) {
            view.setVisibility(8);
        } else {
            j.t("contentGroup");
            throw null;
        }
    }

    public final void q() {
        TextView textView = this.f192h;
        if (textView == null) {
            j.t("refreshView");
            throw null;
        }
        textView.setVisibility(0);
        TextView textView2 = this.f192h;
        if (textView2 == null) {
            j.t("refreshView");
            throw null;
        }
        textView2.setText("VIP信息更新失败\n轻触屏幕重试");
        CommonLoadingView commonLoadingView = this.f191f;
        if (commonLoadingView == null) {
            j.t("loadingView");
            throw null;
        }
        commonLoadingView.setVisibility(8);
        View view = this.a;
        if (view != null) {
            view.setVisibility(8);
        } else {
            j.t("contentGroup");
            throw null;
        }
    }
}
