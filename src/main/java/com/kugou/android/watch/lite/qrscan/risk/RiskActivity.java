package com.kugou.android.watch.lite.qrscan.risk;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.appcompat.widget.ActivityChooserModel;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.activity.DelegateActivity;
import e.c.a.g.a.s.a0;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.u;
import f.z.d.j;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes2.dex */
@e.c.c.l.f.b(id = -1)
public final class RiskActivity extends DelegateActivity {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ImageView f215d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f216f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f217h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f218i;
    public TextView j;
    public String k;
    public String l;
    public e.c.a.g.a.n.c.a n;
    public long o;
    public boolean p;
    public long m = 120;
    public final a q = new a(this);

    public static final class a extends u<RiskActivity> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(RiskActivity riskActivity) {
            super(riskActivity);
            j.e(riskActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        }

        @Override // e.c.a.g.a.s.u
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(RiskActivity riskActivity, Message message) {
            Integer numValueOf = message == null ? null : Integer.valueOf(message.what);
            if (numValueOf != null && numValueOf.intValue() == 2) {
                removeCallbacksAndMessages(null);
                if (riskActivity == null) {
                    return;
                }
                riskActivity.E();
                return;
            }
            if (numValueOf != null && numValueOf.intValue() == 0) {
                c(riskActivity);
            } else if (numValueOf != null && numValueOf.intValue() == 1) {
                c(riskActivity);
            }
        }

        public final void c(RiskActivity riskActivity) {
            if (riskActivity == null) {
                return;
            }
            riskActivity.D();
        }
    }

    public static final class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            RiskActivity.this.finish();
        }
    }

    public static final class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            RiskActivity.this.n(0, 0);
            RiskActivity.this.q.obtainMessage(2).sendToTarget();
        }
    }

    public static final class d<T> implements Action1 {
        public d() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(e.c.a.g.a.f.k.c<Integer> cVar) {
            if (!cVar.f()) {
                RiskActivity.this.B();
                return;
            }
            Integer numA = cVar.a();
            if (numA != null && numA.intValue() == 100) {
                RiskActivity.this.F(1, null);
                return;
            }
            if (numA != null && numA.intValue() == 404) {
                RiskActivity.this.F(0, null);
            } else if (numA != null && numA.intValue() == 200) {
                RiskActivity.this.F(4, null);
            } else {
                RiskActivity.this.B();
            }
        }
    }

    public static final class e<T> implements Action1 {
        public e() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(Throwable th) {
            RiskActivity.this.B();
        }
    }

    public static final class f<T, R> implements Func1 {
        public f() {
        }

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Bitmap call(e.c.a.g.a.f.k.c<e.c.a.g.a.n.c.a> cVar) {
            RiskActivity.this.n = cVar.a();
            if (!cVar.f()) {
                return null;
            }
            RiskActivity riskActivity = RiskActivity.this;
            e.c.a.g.a.n.c.a aVar = riskActivity.n;
            riskActivity.m = aVar == null ? 120L : aVar.b();
            int iD = l1.d(e.c.c.o.f.a(), 160.0f);
            e.c.a.g.a.n.c.a aVarA = cVar.a();
            Bitmap bitmapB = a0.b(aVarA == null ? null : aVarA.c(), iD, iD, -16777216, -1);
            if (bitmapB == null || bitmapB.isRecycled()) {
                return null;
            }
            return bitmapB;
        }
    }

    public static final class g<T> implements Action1 {
        public g() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(Bitmap bitmap) {
            if (bitmap == null) {
                RiskActivity.this.F(5, null);
                return;
            }
            ImageView imageView = RiskActivity.this.f215d;
            if (imageView == null) {
                j.t("ivCode");
                throw null;
            }
            imageView.setImageBitmap(bitmap);
            RiskActivity.this.o = System.currentTimeMillis();
            RiskActivity.this.q.obtainMessage(0).sendToTarget();
        }
    }

    public static final class h<T> implements Action1 {
        public h() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(Throwable th) {
            RiskActivity.this.F(5, null);
        }
    }

    public final void B() {
        if (System.currentTimeMillis() - this.o >= this.m * ((long) 1000)) {
            Message messageObtainMessage = this.q.obtainMessage(2);
            j.d(messageObtainMessage, "workHandler.obtainMessage(WorkHandler.MSG_REFRESH_QRCODE)");
            this.q.sendMessage(messageObtainMessage);
        } else {
            Message messageObtainMessage2 = this.q.obtainMessage(1);
            j.d(messageObtainMessage2, "workHandler.obtainMessage(WorkHandler.MSG_LOOP_QUERY)");
            this.q.sendMessageDelayed(messageObtainMessage2, System.currentTimeMillis() - this.o < 60000 ? 1000L : 5000L);
        }
    }

    public final void C() {
        View viewFindViewById = findViewById(R.id.code_img);
        j.d(viewFindViewById, "findViewById(R.id.code_img)");
        this.f215d = (ImageView) viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.tip);
        j.d(viewFindViewById2, "findViewById(R.id.tip)");
        TextView textView = (TextView) viewFindViewById2;
        this.f216f = textView;
        if (textView == null) {
            j.t("tvTip");
            throw null;
        }
        textView.setText("请在酷狗概念版手机端“我的-右上角-\n扫一扫”扫码登录");
        View viewFindViewById3 = findViewById(R.id.invalid_container);
        j.d(viewFindViewById3, "findViewById(R.id.invalid_container)");
        this.f217h = viewFindViewById3;
        View viewFindViewById4 = findViewById(R.id.tv_invalidate);
        j.d(viewFindViewById4, "findViewById(R.id.tv_invalidate)");
        this.j = (TextView) viewFindViewById4;
        View viewFindViewById5 = findViewById(R.id.invalid_refresh);
        j.d(viewFindViewById5, "findViewById(R.id.invalid_refresh)");
        TextView textView2 = (TextView) viewFindViewById5;
        this.f218i = textView2;
        c cVar = new c();
        if (textView2 == null) {
            j.t("invalidRefreshBtn");
            throw null;
        }
        textView2.setOnClickListener(cVar);
        this.q.obtainMessage(2).sendToTarget();
        F(1, null);
        findViewById(R.id.iv_back).setOnClickListener(new b());
    }

    public final void D() {
        e.c.a.g.a.n.c.a aVar = this.n;
        if (aVar == null) {
            return;
        }
        e.c.a.g.a.n.c.b.b bVar = e.c.a.g.a.n.c.b.b.a;
        String str = this.k;
        if (str != null) {
            bVar.b(str, aVar.a()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(), new e());
        } else {
            j.t("eventId");
            throw null;
        }
    }

    public final void E() {
        d();
        e.c.a.g.a.n.c.b.a aVar = e.c.a.g.a.n.c.b.a.a;
        String str = this.k;
        if (str == null) {
            j.t("eventId");
            throw null;
        }
        String str2 = this.l;
        if (str2 != null) {
            aVar.b(str, str2).map(new f()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new g(), new h());
        } else {
            j.t("busId");
            throw null;
        }
    }

    @MainThread
    public final void F(int i2, e.c.a.g.a.n.b.c cVar) {
        if (i2 == 0) {
            View view = this.f217h;
            if (view == null) {
                j.t("invalidContainer");
                throw null;
            }
            view.setVisibility(0);
            ImageView imageView = this.f215d;
            if (imageView == null) {
                j.t("ivCode");
                throw null;
            }
            imageView.setVisibility(0);
            TextView textView = this.f216f;
            if (textView == null) {
                j.t("tvTip");
                throw null;
            }
            textView.setVisibility(0);
            TextView textView2 = this.j;
            if (textView2 == null) {
                j.t("tvInvalidate");
                throw null;
            }
            textView2.setText("二维码已失效");
            TextView textView3 = this.f218i;
            if (textView3 == null) {
                j.t("invalidRefreshBtn");
                throw null;
            }
            textView3.setText("刷新");
            TextView textView4 = this.f218i;
            if (textView4 != null) {
                textView4.requestFocus();
                return;
            } else {
                j.t("invalidRefreshBtn");
                throw null;
            }
        }
        if (i2 == 1) {
            View view2 = this.f217h;
            if (view2 == null) {
                j.t("invalidContainer");
                throw null;
            }
            view2.setVisibility(8);
            ImageView imageView2 = this.f215d;
            if (imageView2 == null) {
                j.t("ivCode");
                throw null;
            }
            imageView2.setVisibility(0);
            TextView textView5 = this.f216f;
            if (textView5 == null) {
                j.t("tvTip");
                throw null;
            }
            textView5.setVisibility(0);
            B();
            return;
        }
        if (i2 == 2) {
            View view3 = this.f217h;
            if (view3 == null) {
                j.t("invalidContainer");
                throw null;
            }
            view3.setVisibility(8);
            ImageView imageView3 = this.f215d;
            if (imageView3 == null) {
                j.t("ivCode");
                throw null;
            }
            imageView3.setVisibility(8);
            TextView textView6 = this.f216f;
            if (textView6 == null) {
                j.t("tvTip");
                throw null;
            }
            textView6.setVisibility(8);
            B();
            return;
        }
        if (i2 == 4) {
            View view4 = this.f217h;
            if (view4 == null) {
                j.t("invalidContainer");
                throw null;
            }
            view4.setVisibility(8);
            ImageView imageView4 = this.f215d;
            if (imageView4 == null) {
                j.t("ivCode");
                throw null;
            }
            imageView4.setVisibility(8);
            TextView textView7 = this.f216f;
            if (textView7 == null) {
                j.t("tvTip");
                throw null;
            }
            textView7.setVisibility(8);
            this.p = true;
            finish();
            return;
        }
        if (i2 != 5) {
            return;
        }
        View view5 = this.f217h;
        if (view5 == null) {
            j.t("invalidContainer");
            throw null;
        }
        view5.setVisibility(0);
        ImageView imageView5 = this.f215d;
        if (imageView5 == null) {
            j.t("ivCode");
            throw null;
        }
        imageView5.setVisibility(0);
        ImageView imageView6 = this.f215d;
        if (imageView6 == null) {
            j.t("ivCode");
            throw null;
        }
        imageView6.setImageBitmap(null);
        TextView textView8 = this.f216f;
        if (textView8 == null) {
            j.t("tvTip");
            throw null;
        }
        textView8.setVisibility(0);
        TextView textView9 = this.j;
        if (textView9 == null) {
            j.t("tvInvalidate");
            throw null;
        }
        textView9.setText("网络异常");
        TextView textView10 = this.f218i;
        if (textView10 == null) {
            j.t("invalidRefreshBtn");
            throw null;
        }
        textView10.setText("刷新重试");
        TextView textView11 = this.f218i;
        if (textView11 != null) {
            textView11.requestFocus();
        } else {
            j.t("invalidRefreshBtn");
            throw null;
        }
    }

    @Override // com.kugou.android.watch.lite.base.activity.StateFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        String stringExtra;
        String stringExtra2;
        super.onCreate(bundle);
        Intent intent = getIntent();
        String str = "";
        if (intent == null || (stringExtra = intent.getStringExtra("arg_event_id")) == null) {
            stringExtra = "";
        }
        this.k = stringExtra;
        Intent intent2 = getIntent();
        if (intent2 != null && (stringExtra2 = intent2.getStringExtra("arg_bus_id")) != null) {
            str = stringExtra2;
        }
        this.l = str;
        setContentView(R.layout.fragment_risk);
        C();
    }

    @Override // com.kugou.android.watch.lite.base.activity.AbsBaseActivity, com.kugou.android.watch.lite.base.activity.StateFragmentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.q.removeCallbacksAndMessages(null);
        Intent intent = new Intent("com.kugou.android.check_iot");
        String str = this.k;
        if (str == null) {
            j.t("eventId");
            throw null;
        }
        intent.putExtra("arg_event_id", str);
        intent.putExtra("arg_result", this.p);
        e.c.a.g.a.f.d.a.d(intent);
    }
}
