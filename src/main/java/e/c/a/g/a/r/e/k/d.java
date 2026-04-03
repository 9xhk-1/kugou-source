package e.c.a.g.a.r.e.k;

import android.graphics.Bitmap;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.annotation.WorkerThread;
import androidx.core.app.NotificationCompat;
import com.bumptech.glide.Glide;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.base.fragment.DelegateFragment;
import com.kugou.android.watch.lite.bi.YoungBITask;
import com.kugou.android.watch.lite.user.login.LoginRiskActivity;
import com.kugou.android.watch.lite.user.login.UserData;
import com.kugou.android.watch.lite.user.login.UserLoginIntegrationFragment;
import com.kugou.android.watch.lite.user.login.UserLoginItemFragment;
import com.kugou.common.startAppAPM.task.ApmReportHelper;
import e.c.a.g.a.r.e.h;
import e.c.a.g.a.r.e.k.b;
import e.c.a.g.a.s.a0;
import e.c.a.g.a.s.d0;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.i1;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.p1;
import e.c.a.g.a.s.s0;
import e.c.a.g.a.s.u0;
import e.c.a.g.a.s.u1;
import e.c.a.g.a.s.v;
import f.z.d.j;
import f.z.d.k;
import f.z.d.r;
import java.util.Objects;
import org.greenrobot.eventbus.EventBus;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends e.c.a.g.a.r.e.k.a {
    public final TextView A;
    public final TextView B;
    public final TextView C;
    public final View D;
    public final TextView E;
    public final TextView F;
    public a G;
    public e.c.a.g.a.n.b.a H;
    public boolean I;
    public Subscription J;
    public int K;
    public boolean L;
    public final f.d M;
    public final ImageView u;
    public final ViewGroup v;
    public final ImageView w;
    public final TextView x;
    public final LinearLayout y;
    public final ImageView z;

    public static final class a extends v<DelegateFragment> {
        public final d b;
        public long c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d dVar) {
            super(dVar.l());
            j.e(dVar, "host");
            this.b = dVar;
        }

        @Override // e.c.a.g.a.s.v
        public void a(DelegateFragment delegateFragment, Message message) {
            j.e(delegateFragment, "fragment");
            j.e(message, NotificationCompat.CATEGORY_MESSAGE);
            if (this.b.a()) {
                int i2 = message.what;
                if (i2 == 0) {
                    this.c = SystemClock.elapsedRealtime();
                    if (this.b.U()) {
                        return;
                    }
                    long jElapsedRealtime = SystemClock.elapsedRealtime() - this.c;
                    if (jElapsedRealtime >= 120000) {
                        sendMessage(obtainMessage(2));
                        return;
                    } else {
                        sendMessageDelayed(obtainMessage(1), jElapsedRealtime >= 60000 ? 5000L : 1000L);
                        return;
                    }
                }
                if (i2 != 1) {
                    if (i2 != 2) {
                        return;
                    }
                    removeCallbacksAndMessages(null);
                    this.b.V();
                    return;
                }
                if (this.b.U()) {
                    return;
                }
                long jElapsedRealtime2 = SystemClock.elapsedRealtime() - this.c;
                if (jElapsedRealtime2 >= 120000) {
                    sendMessage(obtainMessage(2));
                } else {
                    sendMessageDelayed(obtainMessage(1), jElapsedRealtime2 >= 60000 ? 5000L : 1000L);
                }
            }
        }
    }

    public static final class b extends k implements f.z.c.a<a> {
        public final /* synthetic */ DelegateFragment a;
        public final /* synthetic */ d b;

        public static final class a implements h.d {
            public final /* synthetic */ DelegateFragment a;
            public final /* synthetic */ d b;

            /* JADX INFO: renamed from: e.c.a.g.a.r.e.k.d$b$a$a, reason: collision with other inner class name */
            public static final class C0185a implements h.c {
                public final /* synthetic */ d a;
                public final /* synthetic */ UserData b;

                public C0185a(d dVar, UserData userData) {
                    this.a = dVar;
                    this.b = userData;
                }

                @Override // e.c.a.g.a.r.e.h.c
                public final void onLoginRefrash(int i2) {
                    if (i2 == 1) {
                        this.a.Y(5, null);
                    } else if (i2 == 2) {
                        this.a.Y(0, null);
                    }
                    Log.e("mhs_watch", "onLoginFailed, 网络加载失败");
                    try {
                        e.c.a.g.a.r.e.k.a.A(this.a, j.l("onQrCodeRefresh onFail, error = ", this.b), null, 2, null);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }

            /* JADX INFO: renamed from: e.c.a.g.a.r.e.k.d$b$a$b, reason: collision with other inner class name */
            public static final class C0186b<T> implements Action1 {
                public final /* synthetic */ DelegateFragment a;
                public final /* synthetic */ d b;

                public C0186b(DelegateFragment delegateFragment, d dVar) {
                    this.a = delegateFragment;
                    this.b = dVar;
                }

                @Override // rx.functions.Action1
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final void call(String str) {
                    this.a.i0();
                    this.a.startActivity(s0.a.a(this.b.j(), LoginRiskActivity.class));
                }
            }

            public a(DelegateFragment delegateFragment, d dVar) {
                this.a = delegateFragment;
                this.b = dVar;
            }

            @Override // e.c.a.g.a.r.e.h.d
            public void onLoginFailed(UserData userData, int i2) {
                j.e(userData, "loginResult");
                this.a.i0();
                this.b.s(2, userData, Integer.valueOf(i2));
                e.c.a.g.a.r.e.k.e.a.a(userData, new C0185a(this.b, userData));
            }

            @Override // e.c.a.g.a.r.e.h.d
            public void onLoginRisk() {
                i1.a(this.b.J);
                this.b.J = Observable.just("").subscribeOn(AndroidSchedulers.mainThread()).subscribe(new C0186b(this.a, this.b), i1.b);
                e.c.a.g.a.r.e.k.a.t(this.b, 3, null, null, 6, null);
            }

            @Override // e.c.a.g.a.r.e.h.d
            public void onLoginSucceed(UserData userData, int i2) {
                j.e(userData, "userData");
                e.c.a.g.a.r.b.Y(true);
                this.a.i0();
                if (!this.b.L) {
                    this.b.L = true;
                    p1.h(KGApplication.getApplication(), "扫码登录成功~");
                }
                Log.e("mhs_watch_login", "onLoginSucceed 扫码登录成功 ");
                EventBus.getDefault().post(new e.c.a.g.a.n.a());
                this.a.e();
                e.c.a.g.a.e.b.b(new YoungBITask(12821194, "statistics").setSvar1("2").setSvar2(String.valueOf(userData.getUserid())));
                this.b.s(1, userData, Integer.valueOf(i2));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(DelegateFragment delegateFragment, d dVar) {
            super(0);
            this.a = delegateFragment;
            this.b = dVar;
        }

        @Override // f.z.c.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final a invoke() {
            return new a(this.a, this.b);
        }
    }

    public static final class c implements b.a {
        public c() {
        }

        @Override // e.c.a.g.a.r.e.k.b.a
        public void onFail(Throwable th) {
            d.this.l().i0();
            d.this.W(th);
        }

        @Override // e.c.a.g.a.r.e.k.b.a
        public void onStart() {
            d.this.l().q0(false);
        }

        @Override // e.c.a.g.a.r.e.k.b.a
        public void onSuccess(e.c.a.g.a.n.b.a aVar, e.c.a.g.a.n.b.d dVar) {
            j.e(aVar, "kgCode");
            j.e(dVar, "wxCode");
            d.this.l().i0();
            d.this.T(aVar, dVar);
            e.c.a.g.a.r.e.k.a.A(d.this, "二维码展示", null, 2, null);
        }
    }

    /* JADX INFO: renamed from: e.c.a.g.a.r.e.k.d$d, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC0187d implements View.OnClickListener {
        public ViewOnClickListenerC0187d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            a aVar = d.this.G;
            if (aVar != null) {
                aVar.obtainMessage(2).sendToTarget();
            }
            e.c.a.g.a.e.b.b(new YoungBITask(20498, "click").setType("5"));
        }
    }

    public static final class e<T, R> implements Func1 {
        public static final e<T, R> a = new e<>();

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Bitmap call(String str) {
            if (g0.a) {
                g0.b("QRCodeLoginStyle", j.l("onQrCodeRefresh: url=", str));
            }
            return a0.a(str);
        }
    }

    public static final class f<T> implements Action1 {
        public final /* synthetic */ e.c.a.g.a.n.b.a b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ r<String> f1192d;

        public f(e.c.a.g.a.n.b.a aVar, r<String> rVar) {
            this.b = aVar;
            this.f1192d = rVar;
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(Bitmap bitmap) {
            if (bitmap == null || bitmap.isRecycled()) {
                if (g0.a) {
                    g0.b("QRCodeLoginStyle", "onQrCodeRefresh: bitmap fail");
                }
                d.this.W(new Throwable("refreshQrcode: bitmap fail"));
            }
            d.this.I = true;
            d.this.H = this.b;
            d.this.u.setImageBitmap(bitmap);
            if (d.this.k() && d.this.r()) {
                ImageView imageView = d.this.w;
                if (imageView != null) {
                    imageView.setVisibility(8);
                }
            } else {
                ImageView imageView2 = d.this.w;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                }
            }
            a aVar = d.this.G;
            if (aVar != null) {
                aVar.obtainMessage(0).sendToTarget();
            }
            d dVar = d.this;
            StringBuilder sb = new StringBuilder();
            sb.append("酷狗二维码 加载成功 kgCodeUrl = ");
            sb.append((Object) this.f1192d.a);
            sb.append(", kgCode.shortUrl = ");
            e.c.a.g.a.n.b.a aVar2 = this.b;
            sb.append((Object) (aVar2 == null ? null : aVar2.f1116d));
            e.c.a.g.a.r.e.k.a.A(dVar, sb.toString(), null, 2, null);
        }
    }

    public static final class g<T> implements Action1 {
        public final /* synthetic */ int b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ e.c.a.g.a.n.b.c f1193d;

        public g(int i2, e.c.a.g.a.n.b.c cVar) {
            this.b = i2;
            this.f1193d = cVar;
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(String str) {
            d.this.Y(this.b, this.f1193d);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(DelegateFragment delegateFragment, View view, e.c.a.g.a.r.e.k.b bVar, ScrollView scrollView) {
        super(delegateFragment, view, R.layout.layout_login_kg_qr_code_style, bVar, scrollView);
        j.e(delegateFragment, "fragment");
        j.e(view, "view");
        this.u = (ImageView) i().findViewById(R.id.code_img);
        this.v = (ViewGroup) i().findViewById(R.id.code_img_container);
        this.w = (ImageView) i().findViewById(R.id.code_img_app_icon);
        this.x = (TextView) i().findViewById(R.id.tip);
        this.y = (LinearLayout) i().findViewById(R.id.info_container);
        this.z = (ImageView) i().findViewById(R.id.info_img);
        this.A = (TextView) i().findViewById(R.id.info_name);
        this.B = (TextView) i().findViewById(R.id.info_tip);
        this.C = (TextView) i().findViewById(R.id.info_back);
        this.D = i().findViewById(R.id.invalid_container);
        this.E = (TextView) i().findViewById(R.id.tv_invalidate);
        this.F = (TextView) i().findViewById(R.id.invalid_refresh);
        this.K = -1;
        this.M = f.f.b(new b(delegateFragment, this));
    }

    public final void Q() {
        e.c.a.g.a.e.b.b(new YoungBITask(20478, "exposure").setType("1").setTab(d0.b(l().getArguments(), "source", "0")));
    }

    public final b.a R() {
        return (b.a) this.M.getValue();
    }

    public final boolean S() {
        return this.I && this.u.getDrawable() != null;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, java.lang.String] */
    public final void T(e.c.a.g.a.n.b.a aVar, e.c.a.g.a.n.b.d dVar) {
        if (g0.a) {
            g0.e("QRCodeLoginStyle", "refreshQrcode");
        }
        r rVar = new r();
        rVar.a = q(aVar);
        String strC = aVar.c();
        CharSequence charSequence = (CharSequence) rVar.a;
        if (!(charSequence == null || charSequence.length() == 0)) {
            if (!(strC == null || strC.length() == 0)) {
                Observable.just(rVar.a).subscribeOn(Schedulers.io()).map(e.a).observeOn(AndroidSchedulers.mainThread()).subscribe(new f(aVar, rVar), i1.b);
                return;
            }
        }
        W(new Throwable("refreshQrcode: wxCodeUrl isNullOrEmpty "));
    }

    public final boolean U() {
        if (g0.a) {
            g0.e("QRCodeLoginStyle", "queryQRCodeStatus");
        }
        e.c.a.g.a.n.b.a aVar = this.H;
        String strC = aVar == null ? null : aVar.c();
        if (strC == null || strC.length() == 0) {
            return false;
        }
        e.c.a.g.a.n.b.c cVarE = e.c.a.g.a.n.b.b.e(strC);
        g(cVarE);
        if (cVarE != null && cVarE.b) {
            int i2 = cVarE.c;
            if (i2 == 0) {
                X(0, cVarE);
                return true;
            }
            if (i2 == 1) {
                X(1, cVarE);
            } else if (i2 == 2) {
                X(2, cVarE);
            } else if (i2 == 4) {
                X(4, cVarE);
                l().q0(false);
                if (g0.a) {
                    g0.e("QRCodeLoginStyle", "loginStatus: nickName->" + ((Object) cVarE.f1119e) + " pic->" + ((Object) cVarE.f1120f) + " userId->" + cVarE.f1118d + " token->" + ((Object) cVarE.f1121g));
                }
                h hVar = new h();
                hVar.t(R());
                hVar.u(2);
                hVar.l(false, 5, cVarE.f1119e, cVarE.f1118d + "", cVarE.f1121g);
                e.c.a.g.a.r.e.k.a.A(this, m(cVarE), null, 2, null);
                return true;
            }
        }
        return false;
    }

    @WorkerThread
    public final void V() {
        e.c.a.g.a.r.e.k.b bVarN = n();
        if (bVarN == null) {
            return;
        }
        bVarN.m();
    }

    public final void W(Throwable th) {
        Y(5, null);
        Log.e("mhs_watch", "onLoginFailed, 网络加载失败");
        if (th == null) {
            try {
                th = new Throwable();
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        e.c.a.g.a.r.e.k.a.A(this, j.l("onQrCodeRefresh onFail, stack = ", Log.getStackTraceString(th)), null, 2, null);
    }

    @WorkerThread
    public final void X(int i2, e.c.a.g.a.n.b.c cVar) {
        Observable.just("").observeOn(AndroidSchedulers.mainThread()).subscribe(new g(i2, cVar), i1.b);
    }

    @MainThread
    public final void Y(int i2, e.c.a.g.a.n.b.c cVar) {
        if (g0.a) {
            g0.b("QRCodeLoginStyle", j.l("switchViewVisibility: codeStatus=", Integer.valueOf(i2)));
        }
        if (i2 == 0) {
            this.y.setVisibility(8);
            u1.e(this.y);
            u1.p(this.u, this.x, this.D, this.v);
            this.E.setText("二维码已失效");
            this.F.setText("刷新");
            this.F.requestFocus();
            B(true);
        } else if (i2 != 1) {
            if (i2 == 2) {
                u1.e(this.u, this.x, this.D, this.v);
                u1.p(this.y);
                if (cVar != null) {
                    Glide.with(l()).load(cVar.f1120f).placeholder(R.drawable.auto_default_avatar).into(this.z);
                    this.A.setText(cVar.f1119e);
                    this.B.setText("请在手机上确认登录");
                }
                B(false);
                if (this.K != i2) {
                    e.c.a.g.a.e.b.b(new YoungBITask(12821193, "statistics").setSvar1("2").setSvar2(cVar != null ? Long.valueOf(cVar.f1118d).toString() : null));
                }
            } else if (i2 == 4) {
                ApmReportHelper.INSTANCE.startLoginRcmAPM();
                u1.e(this.u, this.x, this.D, this.v);
                u1.p(this.y);
                if (cVar != null) {
                    Glide.with(l()).load(cVar.f1120f).placeholder(R.drawable.auto_default_avatar).into(this.z);
                    this.A.setText(cVar.f1119e);
                    this.B.setText("正在登录...");
                }
                B(false);
            } else if (i2 == 5) {
                u1.e(this.y);
                u1.p(this.u, this.x, this.D, this.v);
                this.u.setImageBitmap(null);
                ImageView imageView = this.w;
                if (imageView != null) {
                    imageView.setVisibility(8);
                }
                this.E.setText("网络异常");
                this.F.setText("刷新重试");
                this.F.requestFocus();
                B(true);
                u0.A(21, "switchViewVisibilityMain2", "errorStr-网络异常");
            }
        } else {
            u1.e(this.y, this.D);
            u1.p(this.u, this.x, this.v);
            B(true);
        }
        this.K = i2;
        y(i2, cVar);
    }

    @Override // e.c.a.g.a.s.g1.b
    public void c() {
        super.c();
        ViewOnClickListenerC0187d viewOnClickListenerC0187d = new ViewOnClickListenerC0187d();
        this.C.setOnClickListener(viewOnClickListenerC0187d);
        this.F.setOnClickListener(viewOnClickListenerC0187d);
        if (this.G == null) {
            this.G = new a(this);
        }
        e.c.a.g.a.r.e.k.b bVarN = n();
        if (bVarN != null) {
            bVarN.e(new c());
        }
        X(1, null);
        Q();
        this.v.setVisibility(8);
        ImageView imageView = this.w;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        if (l() instanceof UserLoginIntegrationFragment) {
            TextView textView = this.x;
            if ((textView == null ? null : textView.getLayoutParams()) != null) {
                TextView textView2 = this.x;
                if ((textView2 == null ? null : textView2.getLayoutParams()) instanceof ViewGroup.MarginLayoutParams) {
                    TextView textView3 = this.x;
                    ViewGroup.LayoutParams layoutParams = textView3 != null ? textView3.getLayoutParams() : null;
                    Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                    ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = l1.c(10.0f);
                }
            }
        }
    }

    @Override // e.c.a.g.a.r.e.k.a, e.c.a.g.a.s.g1.b
    public void d(Object obj) {
        a aVar;
        super.d(obj);
        if (l() != null && (l() instanceof UserLoginIntegrationFragment)) {
            e.c.a.g.a.e.b.b(new YoungBITask(12821192, "exposure").setSvar1("2"));
        }
        l1.I(l().getActivity());
        e.c.a.g.a.r.e.k.b bVarN = n();
        e.c.a.g.a.n.b.a aVarF = bVarN == null ? null : bVarN.f();
        e.c.a.g.a.r.e.k.b bVarN2 = n();
        e.c.a.g.a.n.b.d dVarG = bVarN2 != null ? bVarN2.g() : null;
        if (aVarF == null || dVarG == null) {
            V();
            return;
        }
        if (this.u.getDrawable() == null) {
            T(aVarF, dVarG);
            return;
        }
        String strC = aVarF.c();
        if ((strC == null || strC.length() == 0) || (aVar = this.G) == null) {
            return;
        }
        aVar.obtainMessage(0).sendToTarget();
    }

    @Override // e.c.a.g.a.r.e.k.a, e.c.a.g.a.s.g1.b
    public void e() {
        super.e();
        a aVar = this.G;
        if (aVar == null) {
            return;
        }
        aVar.removeCallbacksAndMessages(null);
    }

    @Override // e.c.a.g.a.r.e.k.a
    public String h() {
        return "KGQRCodeLoginStyle";
    }

    @Override // e.c.a.g.a.r.e.k.a
    public void v() {
        super.v();
        a aVar = this.G;
        if (aVar == null) {
            return;
        }
        aVar.removeCallbacksAndMessages(null);
    }

    @Override // e.c.a.g.a.r.e.k.a
    public void w() {
        super.w();
        a aVar = this.G;
        if (aVar == null) {
            return;
        }
        aVar.removeCallbacksAndMessages(null);
    }

    @Override // e.c.a.g.a.r.e.k.a
    public void x() {
        a aVar;
        super.x();
        if (S() && (aVar = this.G) != null) {
            aVar.obtainMessage(0).sendToTarget();
        }
        if (l() == null || !(l() instanceof UserLoginItemFragment)) {
            return;
        }
        e.c.a.g.a.e.b.b(new YoungBITask(12821192, "exposure").setSvar1("2"));
    }
}
