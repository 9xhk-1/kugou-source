package com.kugou.android.watch.lite.component.family;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.app.NotificationCompat;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.activity.DelegateActivity;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.common.startAppAPM.task.RingBiReportHelper;
import e.c.a.g.a.g.e.e;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.i1;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.m1;
import e.c.a.g.a.s.p1;
import e.c.a.g.a.s.u;
import e.c.a.g.a.s.z0;
import f.s;
import f.z.d.j;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
@e.c.c.l.f.b(id = -1)
public final class FamilyControlCodeActivity extends DelegateActivity {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ImageView f143d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Subscription f144f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Subscription f145h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public a f146i;
    public boolean j;
    public boolean k;

    public static final class a extends u<FamilyControlCodeActivity> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final C0012a f147d = new C0012a(null);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final long f148e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final long f149f;
        public final FamilyControlCodeActivity b;
        public long c;

        /* JADX INFO: renamed from: com.kugou.android.watch.lite.component.family.FamilyControlCodeActivity$a$a, reason: collision with other inner class name */
        public static final class C0012a {
            public C0012a() {
            }

            public /* synthetic */ C0012a(f.z.d.g gVar) {
                this();
            }

            public final long a() {
                return a.f149f;
            }

            public final long b() {
                return a.f148e;
            }
        }

        static {
            e.c.a.g.a.g.e.d dVar = e.c.a.g.a.g.e.d.a;
            f148e = ((long) dVar.c()) * 1000;
            f149f = ((long) dVar.h()) * 1000;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(FamilyControlCodeActivity familyControlCodeActivity) {
            super(familyControlCodeActivity);
            j.e(familyControlCodeActivity, "host");
            this.b = familyControlCodeActivity;
        }

        @Override // e.c.a.g.a.s.u
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(FamilyControlCodeActivity familyControlCodeActivity, Message message) {
            j.e(familyControlCodeActivity, "fragment");
            j.e(message, NotificationCompat.CATEGORY_MESSAGE);
            boolean zX = this.b.x();
            int i2 = message.what;
            if (i2 != 0) {
                if (i2 == 1 && !this.b.z()) {
                    long jElapsedRealtime = SystemClock.elapsedRealtime() - this.c;
                    Message messageObtainMessage = obtainMessage(1);
                    long j = (jElapsedRealtime >= 60000 || zX) ? f149f : f148e;
                    sendMessageDelayed(messageObtainMessage, j);
                    return;
                }
                return;
            }
            this.c = SystemClock.elapsedRealtime();
            if (this.b.z()) {
                return;
            }
            long jElapsedRealtime2 = SystemClock.elapsedRealtime() - this.c;
            Message messageObtainMessage2 = obtainMessage(1);
            long j2 = (jElapsedRealtime2 >= 60000 || zX) ? f149f : f148e;
            sendMessageDelayed(messageObtainMessage2, j2);
        }
    }

    public static final class b<T, R> implements Func1 {
        public b() {
        }

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Bitmap call(String str) {
            j.d(str, "it");
            return z0.a(str, FamilyControlCodeActivity.this.t());
        }
    }

    public static final class c<T> implements Action1 {
        public final /* synthetic */ ImageView a;

        public c(ImageView imageView) {
            this.a = imageView;
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(Bitmap bitmap) {
            if (bitmap != null) {
                this.a.setImageBitmap(bitmap);
            }
        }
    }

    public static final class d<T, R> implements Func1 {
        public static final d<T, R> a = new d<>();

        public final void a(String str) {
            e.c.a.g.a.g.e.d.a.j();
        }

        @Override // rx.functions.Func1
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            a((String) obj);
            return s.a;
        }
    }

    public static final class e<T> implements Action1 {
        public e() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(s sVar) {
            FamilyControlCodeActivity.this.v();
        }
    }

    public static final class f<T> implements Action1 {
        public f() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(Throwable th) {
            FamilyControlCodeActivity.this.v();
        }
    }

    public static final class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            FamilyControlCodeActivity familyControlCodeActivity = FamilyControlCodeActivity.this;
            familyControlCodeActivity.y(familyControlCodeActivity);
        }
    }

    public static final class h implements e.a {
        public h() {
        }

        @Override // e.c.a.g.a.g.e.e.a
        public void dismiss() {
            Log.e("mhs_watch", "dismiss");
            FamilyControlCodeActivity.this.B(3000);
        }

        @Override // e.c.a.g.a.g.e.e.a
        public void onNo() {
            Log.e("mhs_watch", "onNo");
        }

        @Override // e.c.a.g.a.g.e.e.a
        public void onYes() {
            Log.e("mhs_watch", "onYes");
        }
    }

    public static final class i<T> implements Action1 {
        public i() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(String str) {
            FamilyControlCodeActivity.this.A();
        }
    }

    public final void A() {
        if (this.j) {
            return;
        }
        u();
        a aVar = this.f146i;
        if (aVar == null) {
            return;
        }
        aVar.obtainMessage(0).sendToTarget();
    }

    public final void B(int i2) {
        m1.e(i2, new i());
    }

    @Override // com.kugou.android.watch.lite.base.activity.StateFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_family_controller);
        View viewFindViewById = findViewById(R.id.content_view);
        e.c.a.g.a.f.o.d.a(viewFindViewById);
        e.c.a.g.a.f.o.i.c.a().d(1, viewFindViewById);
        this.f143d = (ImageView) findViewById(R.id.privacy_code);
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        ((LinearLayout) findViewById(R.id.refresh_layout)).setOnClickListener(new g());
        if (this.f146i == null) {
            this.f146i = new a(this);
        }
        w();
        StringBuilder sb = new StringBuilder();
        sb.append("LONG_INTERVAL = ");
        a.C0012a c0012a = a.f147d;
        sb.append(c0012a.a());
        sb.append(", SHORT_INTERVAL = ");
        sb.append(c0012a.b());
        Log.e("WorkHandler", sb.toString());
    }

    @Override // com.kugou.android.watch.lite.base.activity.AbsBaseActivity, com.kugou.android.watch.lite.base.activity.StateFragmentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        u();
        i1.a(this.f145h);
        i1.a(this.f144f);
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
        e.c.a.g.a.g.e.e.a.g();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(e.c.a.g.a.g.e.g.a aVar) {
        j.e(aVar, NotificationCompat.CATEGORY_EVENT);
        if (aVar.a == 1) {
            p1.h(KGApplication.getContext(), "绑定成功");
            finish();
        }
    }

    @Override // com.kugou.android.watch.lite.base.activity.AbsFrameworkActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        u();
    }

    @Override // com.kugou.android.watch.lite.base.activity.AbsFrameworkActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        B(1000);
    }

    @Override // com.kugou.android.watch.lite.base.activity.AbsFrameworkActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        u();
    }

    public final float t() {
        return 58.0f;
    }

    public final void u() {
        a aVar = this.f146i;
        if (aVar == null) {
            return;
        }
        aVar.removeCallbacksAndMessages(null);
    }

    public final void v() {
        ImageView imageView = this.f143d;
        String str = e.c.a.g.a.g.e.d.a.b() + "?device_id=" + ((Object) l1.n(KGApplication.getContext())) + "&channel_id=" + ((Object) l1.j());
        Log.e("mhs_watch_grade", "FamilyControlCodeActivity url = " + str + ", ivCode = " + imageView);
        if (imageView == null) {
            return;
        }
        if (str == null || str.length() == 0) {
            str = "https://activity.kugou.com/level/v-e518262d/index.html?device_id=" + ((Object) l1.n(KGApplication.getContext())) + "&channel_id=" + ((Object) l1.j());
        }
        this.f144f = Observable.just(str).map(new b()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(imageView), i1.b);
    }

    public final void w() {
        this.f145h = Observable.just("").map(d.a).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(), new f());
    }

    public final boolean x() {
        return this.k;
    }

    public final void y(Context context) {
        if (context instanceof Activity) {
            ((Activity) context).startActivity(new Intent(context, (Class<?>) FamilyControlInfoActivity.class));
        }
    }

    public final boolean z() {
        e.c.a.g.a.g.e.c cVarA = e.c.a.g.a.g.e.b.a.a();
        if (g0.a) {
            g0.e("FamilyControlCodeActivity", j.l("queryQRCodeStatus, status = ", cVarA));
        }
        if (cVarA != null && cVarA.b) {
            int i2 = cVarA.c;
            if (i2 == 0) {
                if (g0.f()) {
                    Log.e("mhs_watch", "二维码失效");
                }
                RingBiReportHelper.reportHeadGrade$default(RingBiReportHelper.INSTANCE, "二维码失效", null, 2, null);
            } else {
                if (i2 == 1) {
                    if (g0.f()) {
                        Log.e("mhs_watch", "已绑定");
                    }
                    RingBiReportHelper.reportHeadGrade$default(RingBiReportHelper.INSTANCE, "已绑定", null, 2, null);
                    this.k = true;
                    return false;
                }
                if (i2 == 2) {
                    if (g0.f()) {
                        Log.e("mhs_watch", "未绑定");
                    }
                    this.k = false;
                    return false;
                }
                if (i2 == 3) {
                    if (g0.f()) {
                        Log.e("mhs_watch", "绑定中");
                    }
                    e.c.a.g.a.g.e.e eVar = e.c.a.g.a.g.e.e.a;
                    if (eVar.f()) {
                        u();
                        if (!this.j) {
                            this.j = true;
                            p1.f(KGApplication.getContext(), "网络异常，请退出页面重试");
                        }
                        return true;
                    }
                    boolean zE = eVar.e();
                    if (!zE) {
                        u();
                        eVar.j(this, new h());
                    }
                    RingBiReportHelper.reportHeadGrade$default(RingBiReportHelper.INSTANCE, j.l("绑定中 isShowDialog = ", Boolean.valueOf(zE)), null, 2, null);
                    return true;
                }
                Log.e("mhs_watch_grade", "queryLoginStatus else");
            }
        }
        return false;
    }
}
