package e.c.a.g.a.r.e.k;

import android.graphics.Bitmap;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
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
import org.greenrobot.eventbus.EventBus;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends e.c.a.g.a.r.e.k.a {
    public final TextView A;
    public final View B;
    public final TextView C;
    public final TextView D;
    public a E;
    public e.c.a.g.a.n.b.a F;
    public boolean G;
    public Subscription H;
    public int I;
    public final f.d J;
    public final ImageView u;
    public final TextView v;
    public final LinearLayout w;
    public final ImageView x;
    public final TextView y;
    public final TextView z;

    public static final class a extends v<DelegateFragment> {
        public final c b;
        public long c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c cVar) {
            super(cVar.l());
            j.e(cVar, "host");
            this.b = cVar;
        }

        @Override // e.c.a.g.a.s.v
        public void a(DelegateFragment delegateFragment, Message message) {
            j.e(delegateFragment, "fragment");
            j.e(message, NotificationCompat.CATEGORY_MESSAGE);
            if (this.b.a()) {
                int i2 = message.what;
                if (i2 == 0) {
                    this.c = SystemClock.elapsedRealtime();
                    if (this.b.R()) {
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
                    this.b.S();
                    return;
                }
                if (this.b.R()) {
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
        public final /* synthetic */ c b;

        public static final class a implements h.d {
            public final /* synthetic */ DelegateFragment a;
            public final /* synthetic */ c b;

            /* JADX INFO: renamed from: e.c.a.g.a.r.e.k.c$b$a$a, reason: collision with other inner class name */
            public static final class C0182a implements h.c {
                public final /* synthetic */ c a;
                public final /* synthetic */ UserData b;

                public C0182a(c cVar, UserData userData) {
                    this.a = cVar;
                    this.b = userData;
                }

                @Override // e.c.a.g.a.r.e.h.c
                public final void onLoginRefrash(int i2) {
                    if (i2 == 1) {
                        this.a.V(5, null);
                    } else if (i2 == 2) {
                        this.a.V(0, null);
                    }
                    Log.e("mhs_watch", "onLoginFailed, 网络加载失败");
                    try {
                        e.c.a.g.a.r.e.k.a.A(this.a, j.l("onQrCodeRefresh onFail, error = ", this.b), null, 2, null);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }

            /* JADX INFO: renamed from: e.c.a.g.a.r.e.k.c$b$a$b, reason: collision with other inner class name */
            public static final class C0183b<T> implements Action1 {
                public final /* synthetic */ DelegateFragment a;
                public final /* synthetic */ c b;

                public C0183b(DelegateFragment delegateFragment, c cVar) {
                    this.a = delegateFragment;
                    this.b = cVar;
                }

                @Override // rx.functions.Action1
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final void call(String str) {
                    this.a.i0();
                    this.a.startActivity(s0.a.a(this.b.j(), LoginRiskActivity.class));
                }
            }

            public a(DelegateFragment delegateFragment, c cVar) {
                this.a = delegateFragment;
                this.b = cVar;
            }

            @Override // e.c.a.g.a.r.e.h.d
            public void onLoginFailed(UserData userData, int i2) {
                j.e(userData, "loginResult");
                DelegateFragment delegateFragment = this.a;
                if (delegateFragment != null) {
                    delegateFragment.i0();
                }
                this.b.s(2, userData, Integer.valueOf(i2));
                e.c.a.g.a.r.e.k.e.a.a(userData, new C0182a(this.b, userData));
            }

            @Override // e.c.a.g.a.r.e.h.d
            public void onLoginRisk() {
                i1.a(this.b.H);
                this.b.H = Observable.just("").subscribeOn(AndroidSchedulers.mainThread()).subscribe(new C0183b(this.a, this.b), i1.b);
                e.c.a.g.a.r.e.k.a.t(this.b, 3, null, null, 6, null);
            }

            @Override // e.c.a.g.a.r.e.h.d
            public void onLoginSucceed(UserData userData, int i2) {
                j.e(userData, "userData");
                e.c.a.g.a.r.b.Y(true);
                this.a.i0();
                p1.h(KGApplication.getApplication(), "扫码登录成功~");
                EventBus.getDefault().post(new e.c.a.g.a.n.a());
                this.a.e();
                e.c.a.g.a.e.b.b(new YoungBITask(12821194, "statistics").setSvar1("3").setSvar2(String.valueOf(userData.getUserid())));
                this.b.s(1, userData, Integer.valueOf(i2));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(DelegateFragment delegateFragment, c cVar) {
            super(0);
            this.a = delegateFragment;
            this.b = cVar;
        }

        @Override // f.z.c.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final a invoke() {
            return new a(this.a, this.b);
        }
    }

    /* JADX INFO: renamed from: e.c.a.g.a.r.e.k.c$c, reason: collision with other inner class name */
    public static final class C0184c implements b.a {
        public C0184c() {
        }

        @Override // e.c.a.g.a.r.e.k.b.a
        public void onFail(Throwable th) {
            DelegateFragment delegateFragmentL = c.this.l();
            if (delegateFragmentL != null) {
                delegateFragmentL.i0();
            }
            c.this.T(th);
        }

        @Override // e.c.a.g.a.r.e.k.b.a
        public void onStart() {
            c.this.l().q0(false);
        }

        @Override // e.c.a.g.a.r.e.k.b.a
        public void onSuccess(e.c.a.g.a.n.b.a aVar, e.c.a.g.a.n.b.d dVar) {
            j.e(aVar, "kgCode");
            j.e(dVar, "wxCode");
            c.this.l().i0();
            c.this.Q(aVar);
            e.c.a.g.a.r.e.k.a.A(c.this, "二维码展示", null, 2, null);
        }
    }

    public static final class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            a aVar = c.this.E;
            if (aVar != null) {
                aVar.obtainMessage(2).sendToTarget();
            }
            e.c.a.g.a.e.b.b(new YoungBITask(20498, "click").setType("5"));
        }
    }

    public static final class e<T, R> implements Func1 {
        public final /* synthetic */ e.c.a.g.a.n.b.a a;

        public e(e.c.a.g.a.n.b.a aVar) {
            this.a = aVar;
        }

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Bitmap call(String str) {
            if (g0.a) {
                g0.b("QRCodeLoginStyle", "onQrCodeRefresh: url=" + ((Object) str) + ", kgCode = " + this.a);
            }
            return a0.a(str);
        }
    }

    public static final class f<T> implements Action1 {
        public final /* synthetic */ e.c.a.g.a.n.b.a b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ r<String> f1190d;

        public f(e.c.a.g.a.n.b.a aVar, r<String> rVar) {
            this.b = aVar;
            this.f1190d = rVar;
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(Bitmap bitmap) {
            if (bitmap == null || bitmap.isRecycled()) {
                if (g0.a) {
                    g0.b("QRCodeLoginStyle", "onQrCodeRefresh: bitmap fail");
                }
                c.this.T(new Throwable("refreshQrcode: bitmap fail"));
            }
            c.this.G = true;
            c.this.F = this.b;
            c.this.u.setImageBitmap(bitmap);
            a aVar = c.this.E;
            if (aVar != null) {
                aVar.obtainMessage(0).sendToTarget();
            }
            c cVar = c.this;
            StringBuilder sb = new StringBuilder();
            sb.append("二码合一 二维码 加载成功 kgCodeUrl = ");
            sb.append((Object) this.f1190d.a);
            sb.append(", kgCode.shortUrl = ");
            e.c.a.g.a.n.b.a aVar2 = this.b;
            sb.append((Object) (aVar2 == null ? null : aVar2.f1116d));
            e.c.a.g.a.r.e.k.a.A(cVar, sb.toString(), null, 2, null);
        }
    }

    public static final class g<T> implements Action1 {
        public final /* synthetic */ int b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ e.c.a.g.a.n.b.c f1191d;

        public g(int i2, e.c.a.g.a.n.b.c cVar) {
            this.b = i2;
            this.f1191d = cVar;
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(String str) {
            c.this.V(this.b, this.f1191d);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(DelegateFragment delegateFragment, View view, e.c.a.g.a.r.e.k.b bVar, ScrollView scrollView) {
        super(delegateFragment, view, R.layout.layout_login_kg_wx_qr_code_style, bVar, scrollView);
        j.e(delegateFragment, "fragment");
        j.e(view, "view");
        this.u = (ImageView) i().findViewById(R.id.code_img);
        this.v = (TextView) i().findViewById(R.id.tip);
        this.w = (LinearLayout) i().findViewById(R.id.info_container);
        this.x = (ImageView) i().findViewById(R.id.info_img);
        this.y = (TextView) i().findViewById(R.id.info_name);
        this.z = (TextView) i().findViewById(R.id.info_tip);
        this.A = (TextView) i().findViewById(R.id.info_back);
        this.B = i().findViewById(R.id.invalid_container);
        this.C = (TextView) i().findViewById(R.id.tv_invalidate);
        this.D = (TextView) i().findViewById(R.id.invalid_refresh);
        this.I = -1;
        this.J = f.f.b(new b(delegateFragment, this));
    }

    public final void N() {
        e.c.a.g.a.e.b.b(new YoungBITask(20478, "exposure").setType("1").setTab(d0.b(l().getArguments(), "source", "0")));
    }

    public final b.a O() {
        return (b.a) this.J.getValue();
    }

    public final boolean P() {
        return this.G && this.u.getDrawable() != null;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [T, java.lang.String] */
    public final void Q(e.c.a.g.a.n.b.a aVar) {
        if (g0.a) {
            g0.e("QRCodeLoginStyle", "refreshQrcode");
        }
        r rVar = new r();
        rVar.a = q(aVar);
        String strC = aVar.c();
        CharSequence charSequence = (CharSequence) rVar.a;
        if (!(charSequence == null || charSequence.length() == 0)) {
            if (!(strC == null || strC.length() == 0)) {
                Log.e("mhs_watch", "kgCodeUrl = " + rVar.a + ", kgCode.shortUrl = " + ((Object) aVar.f1116d));
                Observable.just(rVar.a).subscribeOn(Schedulers.io()).map(new e(aVar)).observeOn(AndroidSchedulers.mainThread()).subscribe(new f(aVar, rVar), i1.b);
                return;
            }
        }
        T(new Throwable("refreshQrcode: wxCodeUrl isNullOrEmpty "));
    }

    public final boolean R() {
        if (g0.a) {
            g0.e("QRCodeLoginStyle", "queryQRCodeStatus");
        }
        e.c.a.g.a.n.b.a aVar = this.F;
        String strC = aVar == null ? null : aVar.c();
        if (strC == null || strC.length() == 0) {
            return false;
        }
        e.c.a.g.a.n.b.c cVarE = e.c.a.g.a.n.b.b.e(strC);
        Log.e("mhs_watch_login", j.l("扫描状态 qrCodeStatus = ", cVarE));
        if (cVarE != null && cVarE.b) {
            int i2 = cVarE.c;
            if (i2 == 0) {
                U(0, cVarE);
                return true;
            }
            if (i2 == 1) {
                U(1, cVarE);
            } else if (i2 == 2) {
                U(2, cVarE);
            } else if (i2 == 4) {
                U(4, cVarE);
                l().q0(false);
                if (g0.a) {
                    g0.e("QRCodeLoginStyle", "loginStatus: nickName->" + ((Object) cVarE.f1119e) + " pic->" + ((Object) cVarE.f1120f) + " userId->" + cVarE.f1118d + " token->" + ((Object) cVarE.f1121g));
                }
                h hVar = new h();
                hVar.t(O());
                hVar.u(4);
                hVar.l(false, 5, cVarE.f1119e, cVarE.f1118d + "", cVarE.f1121g);
                return true;
            }
        }
        return false;
    }

    @WorkerThread
    public final void S() {
        e.c.a.g.a.r.e.k.b bVarN = n();
        if (bVarN == null) {
            return;
        }
        bVarN.m();
    }

    public final void T(Throwable th) {
        V(5, null);
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
    public final void U(int i2, e.c.a.g.a.n.b.c cVar) {
        Observable.just("").observeOn(AndroidSchedulers.mainThread()).subscribe(new g(i2, cVar), i1.b);
    }

    @MainThread
    public final void V(int i2, e.c.a.g.a.n.b.c cVar) {
        if (g0.a) {
            g0.b("QRCodeLoginStyle", j.l("switchViewVisibility: codeStatus=", Integer.valueOf(i2)));
        }
        if (i2 == 0) {
            this.w.setVisibility(8);
            u1.e(this.w);
            u1.p(this.u, this.v, this.B);
            this.C.setText("二维码已失效");
            this.D.setText("刷新");
            this.D.requestFocus();
            B(true);
        } else if (i2 != 1) {
            if (i2 == 2) {
                u1.e(this.u, this.v, this.B);
                u1.p(this.w);
                if (cVar != null) {
                    Glide.with(l()).load(cVar.f1120f).placeholder(R.drawable.auto_default_avatar).into(this.x);
                    this.y.setText(cVar.f1119e);
                    this.z.setText("请在手机上确认登录");
                }
                B(false);
                if (this.I != i2) {
                    e.c.a.g.a.e.b.b(new YoungBITask(12821193, "statistics").setSvar1("3").setSvar2(cVar != null ? Long.valueOf(cVar.f1118d).toString() : null));
                }
            } else if (i2 == 4) {
                ApmReportHelper.INSTANCE.startLoginRcmAPM();
                u1.e(this.u, this.v, this.B);
                u1.p(this.w);
                if (cVar != null) {
                    Glide.with(l()).load(cVar.f1120f).placeholder(R.drawable.auto_default_avatar).into(this.x);
                    this.y.setText(cVar.f1119e);
                    this.z.setText("正在登录...");
                }
                B(false);
            } else if (i2 == 5) {
                u1.e(this.w);
                u1.p(this.u, this.v, this.B);
                this.u.setImageBitmap(null);
                this.C.setText("网络异常");
                this.D.setText("刷新重试");
                this.D.requestFocus();
                B(true);
                u0.A(21, "switchViewVisibilityMain2", "errorStr-网络异常");
            }
        } else {
            u1.e(this.w, this.B);
            u1.p(this.u, this.v);
            B(true);
        }
        this.I = i2;
        y(i2, cVar);
    }

    @Override // e.c.a.g.a.s.g1.b
    public void c() {
        super.c();
        d dVar = new d();
        this.A.setOnClickListener(dVar);
        this.D.setOnClickListener(dVar);
        if (this.E == null) {
            this.E = new a(this);
        }
        e.c.a.g.a.r.e.k.b bVarN = n();
        if (bVarN != null) {
            bVarN.e(new C0184c());
        }
        U(1, null);
        N();
    }

    @Override // e.c.a.g.a.r.e.k.a, e.c.a.g.a.s.g1.b
    public void d(Object obj) {
        a aVar;
        super.d(obj);
        e.c.a.g.a.e.b.b(new YoungBITask(12821192, "exposure").setSvar1("3"));
        l1.I(l().getActivity());
        e.c.a.g.a.r.e.k.b bVarN = n();
        e.c.a.g.a.n.b.a aVarF = bVarN == null ? null : bVarN.f();
        if (aVarF == null) {
            S();
            return;
        }
        if (this.u.getDrawable() == null) {
            Q(aVarF);
            return;
        }
        String strC = aVarF.c();
        if ((strC == null || strC.length() == 0) || (aVar = this.E) == null) {
            return;
        }
        aVar.obtainMessage(0).sendToTarget();
    }

    @Override // e.c.a.g.a.r.e.k.a, e.c.a.g.a.s.g1.b
    public void e() {
        super.e();
        a aVar = this.E;
        if (aVar == null) {
            return;
        }
        aVar.removeCallbacksAndMessages(null);
    }

    @Override // e.c.a.g.a.r.e.k.a
    public String h() {
        return "KGAndWxQRCodeLoginStyle";
    }

    @Override // e.c.a.g.a.r.e.k.a
    public void v() {
        super.v();
        a aVar = this.E;
        if (aVar == null) {
            return;
        }
        aVar.removeCallbacksAndMessages(null);
    }

    @Override // e.c.a.g.a.r.e.k.a
    public void w() {
        super.w();
        a aVar = this.E;
        if (aVar == null) {
            return;
        }
        aVar.removeCallbacksAndMessages(null);
    }

    @Override // e.c.a.g.a.r.e.k.a
    public void x() {
        a aVar;
        super.x();
        if (!P() || (aVar = this.E) == null) {
            return;
        }
        aVar.obtainMessage(0).sendToTarget();
    }
}
