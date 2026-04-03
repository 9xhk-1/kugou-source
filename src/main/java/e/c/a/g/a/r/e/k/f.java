package e.c.a.g.a.r.e.k;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.fragment.DelegateFragment;
import com.kugou.android.watch.lite.bi.YoungBITask;
import com.kugou.android.watch.lite.user.AccountSelectFragment;
import com.kugou.android.watch.lite.user.login.AccountSimpleEntity;
import com.kugou.android.watch.lite.user.login.LoginExtraEntity;
import com.kugou.android.watch.lite.user.login.LoginRiskActivity;
import com.kugou.android.watch.lite.user.login.UserData;
import com.kugou.common.apm.sdk.ApmDataTypeID;
import com.kugou.common.startAppAPM.task.ApmReportHelper;
import e.c.a.g.a.r.e.h;
import e.c.a.g.a.s.d0;
import e.c.a.g.a.s.h1;
import e.c.a.g.a.s.i1;
import e.c.a.g.a.s.l0;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.p1;
import e.c.a.g.a.s.s0;
import e.c.a.g.a.s.u0;
import e.c.a.g.a.s.u1;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/* JADX INFO: loaded from: classes.dex */
public final class f extends e.c.a.g.a.r.e.k.a implements View.OnClickListener {
    public static final a F = new a(null);
    public static int G = 61;
    public Subscription A;
    public final f.d B;
    public final f.d<l.a> C;
    public final f.d D;
    public final e.c.a.g.a.k.d.a E;
    public final EditText u;
    public final EditText v;
    public final TextView w;
    public final TextView x;
    public Timer y;
    public Subscription z;

    /* JADX INFO: loaded from: classes2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f.z.d.g gVar) {
            this();
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static final class b extends f.z.d.k implements f.z.c.a<a> {
        public final /* synthetic */ DelegateFragment b;

        public static final class a implements h.d {
            public final /* synthetic */ f a;
            public final /* synthetic */ DelegateFragment b;

            /* JADX INFO: renamed from: e.c.a.g.a.r.e.k.f$b$a$a, reason: collision with other inner class name */
            public static final class C0188a<T> implements Action1 {
                public final /* synthetic */ f a;
                public final /* synthetic */ UserData b;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                public final /* synthetic */ int f1194d;

                public C0188a(f fVar, UserData userData, int i2) {
                    this.a = fVar;
                    this.b = userData;
                    this.f1194d = i2;
                }

                @Override // rx.functions.Action1
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final void call(String str) {
                    String string;
                    this.a.W();
                    int error_code = this.b.getError_code();
                    if (error_code == 34175 && !l0.g(this.b.getAccounts())) {
                        f fVar = this.a;
                        ArrayList<AccountSimpleEntity> accounts = this.b.getAccounts();
                        f.z.d.j.d(accounts, "loginResult.accounts");
                        fVar.T(accounts);
                        return;
                    }
                    if (error_code > 0) {
                        StringBuilder sb = new StringBuilder();
                        sb.append('(');
                        sb.append(error_code);
                        sb.append(')');
                        string = sb.toString();
                    } else {
                        string = "";
                    }
                    String strL = f.z.d.j.l("登录失败", string);
                    p1.h(this.a.j(), e.c.a.g.a.r.a.c(error_code, strL));
                    u0.A(22, "onLoginFailed", "errorStr-" + strL + "-errCode = " + error_code);
                    this.a.s(2, this.b, Integer.valueOf(this.f1194d));
                }
            }

            /* JADX INFO: renamed from: e.c.a.g.a.r.e.k.f$b$a$b, reason: collision with other inner class name */
            public static final class C0189b<T> implements Action1 {
                public final /* synthetic */ f a;
                public final /* synthetic */ DelegateFragment b;

                public C0189b(f fVar, DelegateFragment delegateFragment) {
                    this.a = fVar;
                    this.b = delegateFragment;
                }

                @Override // rx.functions.Action1
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final void call(String str) {
                    this.a.W();
                    this.b.startActivity(s0.a.a(this.b.getActivity(), LoginRiskActivity.class));
                }
            }

            public static final class c<T> implements Action1 {
                public final /* synthetic */ f a;
                public final /* synthetic */ DelegateFragment b;

                public c(f fVar, DelegateFragment delegateFragment) {
                    this.a = fVar;
                    this.b = delegateFragment;
                }

                @Override // rx.functions.Action1
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final void call(String str) {
                    this.a.W();
                    e.c.a.g.a.r.e.d.d().g();
                    p1.h(this.a.j(), "登录成功");
                    this.b.e();
                }
            }

            public a(f fVar, DelegateFragment delegateFragment) {
                this.a = fVar;
                this.b = delegateFragment;
            }

            @Override // e.c.a.g.a.r.e.h.d
            public void onLoginFailed(UserData userData, int i2) {
                f.z.d.j.e(userData, "loginResult");
                Log.i("PhoneLoginStyle", f.z.d.j.l("onLoginFailed: error code=", Integer.valueOf(userData.getError_code())));
                i1.a(this.a.A);
                this.a.A = Observable.just("").subscribeOn(AndroidSchedulers.mainThread()).subscribe(new C0188a(this.a, userData, i2), i1.b);
            }

            @Override // e.c.a.g.a.r.e.h.d
            public void onLoginRisk() {
                i1.a(this.a.A);
                this.a.A = Observable.just("").subscribeOn(AndroidSchedulers.mainThread()).subscribe(new C0189b(this.a, this.b), i1.b);
                e.c.a.g.a.r.e.k.a.t(this.a, 3, null, null, 6, null);
            }

            @Override // e.c.a.g.a.r.e.h.d
            public void onLoginSucceed(UserData userData, int i2) {
                f.z.d.j.e(userData, "userData");
                i1.a(this.a.z);
                this.a.z = Observable.just("").subscribeOn(AndroidSchedulers.mainThread()).subscribe(new c(this.a, this.b), i1.b);
                this.a.s(1, userData, Integer.valueOf(i2));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(DelegateFragment delegateFragment) {
            super(0);
            this.b = delegateFragment;
        }

        @Override // f.z.c.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final a invoke() {
            return new a(f.this, this.b);
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static final class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            e.c.a.g.a.j.a.c().f("login_phone", f.this.l().getActivity());
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static final class d<T> implements e.c.a.g.a.s.y1.a {
        public d() {
        }

        @Override // e.c.a.g.a.s.y1.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onCall(String str) {
            f.this.u.setText(str);
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static final class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            e.c.a.g.a.j.a.c().f("login_verify_code", f.this.l().getActivity());
        }
    }

    /* JADX INFO: renamed from: e.c.a.g.a.r.e.k.f$f, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes2.dex */
    public static final class C0190f<T> implements e.c.a.g.a.s.y1.a {
        public C0190f() {
        }

        @Override // e.c.a.g.a.s.y1.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onCall(String str) {
            f.this.v.setText(str);
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static final class g implements TextView.OnEditorActionListener {
        public static final g a = new g();

        @Override // android.widget.TextView.OnEditorActionListener
        public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            l1.J(textView.getContext(), textView);
            return true;
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static final class h<T> implements Action1 {
        public final /* synthetic */ String b;

        public h(String str) {
            this.b = str;
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(e.c.a.g.a.r.e.i.b bVar) {
            f.this.W();
            e.c.a.g.a.r.e.i.g gVar = bVar.a;
            f.this.E.j();
            f.this.E.e();
            int i2 = 1;
            if (gVar != null && gVar.e()) {
                a aVar = f.F;
                f.N(this.b);
                p1.h(f.this.j(), "验证码已发送");
                f.this.d0();
                f.this.E.i(true);
            } else if (gVar == null || gVar.e()) {
                p1.h(f.this.j(), "发送验证码失败，请稍后再试");
                i2 = 3;
                f.this.E.a(5, "发送验证码失败，请稍后再试", 11005);
            } else {
                p1.h(f.this.j(), e.c.a.g.a.r.e.i.g.d(e.c.c.o.f.a(), gVar.c(), gVar.b()));
                e.c.a.g.a.k.d.a aVar2 = f.this.E;
                e.c.a.b.a.a.a.a aVar3 = new e.c.a.b.a.a.a.a(gVar.c(), gVar.b());
                String strB = gVar.b();
                f.z.d.j.d(strB, "result.error");
                aVar2.b(aVar3, 1, strB, 4);
                i2 = 2;
            }
            e.c.a.g.a.r.e.k.a.A(f.this, "codeInfo = " + gVar + ", step = " + i2, null, 2, null);
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static final class i<T> implements Action1 {
        public i() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(Throwable th) {
            f.this.W();
            p1.h(f.this.j(), "发送验证码失败，请稍后再试");
            e.c.a.g.a.r.e.k.a.A(f.this, "stack = " + Log.getStackTraceString(th) + ", step = 4", null, 2, null);
            f.this.E.b(th, 6, "发送验证码失败，请稍后再试", 6);
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static final class j implements Runnable {
        public final /* synthetic */ ScrollView a;

        public j(ScrollView scrollView) {
            this.a = scrollView;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.scrollTo(0, 0);
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static final class k extends TimerTask {
        public k() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            f.this.V().removeMessages(1);
            f.this.V().sendEmptyMessage(1);
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static final class l extends f.z.d.k implements f.z.c.a<a> {

        public static final class a extends Handler {
            public final /* synthetic */ f a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(f fVar, Looper looper) {
                super(looper);
                this.a = fVar;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                f.z.d.j.e(message, NotificationCompat.CATEGORY_MESSAGE);
                super.handleMessage(message);
                if (f.G > 1) {
                    a aVar = f.F;
                    f.G--;
                    this.a.w.setEnabled(false);
                    this.a.w.setAlpha(0.4f);
                    TextView textView = this.a.w;
                    StringBuilder sb = new StringBuilder();
                    sb.append(f.G);
                    sb.append((char) 31186);
                    textView.setText(sb.toString());
                    return;
                }
                if (f.G == 1) {
                    a aVar2 = f.F;
                    f.G = 61;
                    this.a.w.setEnabled(true);
                    this.a.w.setAlpha(1.0f);
                    this.a.w.setText("发送");
                    Timer timer = this.a.y;
                    f.z.d.j.c(timer);
                    timer.cancel();
                }
            }
        }

        public l() {
            super(0);
        }

        @Override // f.z.c.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final a invoke() {
            return new a(f.this, Looper.getMainLooper());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(DelegateFragment delegateFragment, View view, e.c.a.g.a.r.e.k.b bVar, ScrollView scrollView) {
        super(delegateFragment, view, R.layout.layout_login_phone_style, bVar, scrollView);
        f.z.d.j.e(delegateFragment, "fragment");
        f.z.d.j.e(view, "view");
        this.u = (EditText) i().findViewById(R.id.user_login_phone);
        this.v = (EditText) i().findViewById(R.id.user_login_verify_code);
        this.w = (TextView) i().findViewById(R.id.user_login_send);
        this.x = (TextView) i().findViewById(R.id.user_login_confirm);
        this.B = f.f.b(new b(delegateFragment));
        f.d<l.a> dVarB = f.f.b(new l());
        this.C = dVarB;
        this.D = dVarB;
        this.E = new e.c.a.g.a.k.d.a(ApmDataTypeID.LOGIN_QCODE_SIGN);
    }

    public static final /* synthetic */ void N(String str) {
    }

    public final void S() {
        e.c.a.g.a.e.b.b(new YoungBITask(20478, "exposure").setType("2").setTab(d0.b(l().getArguments(), "source", "0")));
    }

    public final void T(ArrayList<AccountSimpleEntity> arrayList) {
        AccountSelectFragment.u0(arrayList);
    }

    public final b.a U() {
        return (b.a) this.B.getValue();
    }

    public final l.a V() {
        return (l.a) this.D.getValue();
    }

    public final void W() {
        l().i0();
    }

    public final void X() {
        l1.J(j(), this.u);
        l1.J(j(), this.v);
    }

    public final boolean Y() {
        String string = this.u.getText().toString();
        if (!TextUtils.isEmpty(string) && h1.n(string)) {
            return true;
        }
        p1.h(j(), "请输入有效手机号码");
        return false;
    }

    public final boolean Z() {
        if (!TextUtils.isEmpty(this.v.getText().toString())) {
            return true;
        }
        p1.h(j(), "验证码不能为空");
        return false;
    }

    public final void a0() {
        if (!l().m0() && Y() && Z() && u0.m(j())) {
            ApmReportHelper.INSTANCE.startLoginRcmAPM();
            c0();
            e.c.a.g.a.r.e.h hVar = new e.c.a.g.a.r.e.h();
            hVar.t(U());
            hVar.u(3);
            hVar.o(this.u.getText().toString(), this.v.getText().toString(), "");
        }
    }

    public final void b0() {
        this.E.h(true);
        if (l().m0()) {
            this.E.a(1, "正在发送验证码中", 11003);
            return;
        }
        if (!Y()) {
            this.E.a(2, "手机号无效", 11002);
        } else {
            if (!u0.m(j())) {
                this.E.a(3, "网络异常", 11004);
                return;
            }
            c0();
            String string = this.u.getText().toString();
            e.c.a.g.a.r.e.i.h.a(string).subscribe(new h(string), new i());
        }
    }

    @Override // e.c.a.g.a.s.g1.b
    public void c() {
        super.c();
        EventBus.getDefault().register(this);
        this.u.setOnClickListener(this);
        this.v.setOnClickListener(this);
        this.x.setOnClickListener(this);
        this.w.setOnClickListener(this);
        g gVar = g.a;
        this.u.setOnEditorActionListener(gVar);
        this.v.setOnEditorActionListener(gVar);
        if (e.c.a.g.a.j.a.c().b()) {
            this.u.setFocusable(false);
            this.u.setFocusableInTouchMode(false);
            this.u.setOnClickListener(new c());
            e.c.a.g.a.j.a.c().a("login_phone", new d());
            this.v.setFocusable(false);
            this.v.setFocusableInTouchMode(false);
            this.v.setOnClickListener(new e());
            e.c.a.g.a.j.a.c().a("login_verify_code", new C0190f());
        }
        u1.b(this, this.x, this.w);
        S();
    }

    public final void c0() {
        l().q0(false);
    }

    @Override // e.c.a.g.a.r.e.k.a, e.c.a.g.a.s.g1.b
    public void d(Object obj) {
        super.d(obj);
        ScrollView scrollViewO = o();
        if (scrollViewO == null) {
            return;
        }
        scrollViewO.post(new j(scrollViewO));
    }

    public final void d0() {
        Timer timer = new Timer();
        this.y = timer;
        if (timer == null) {
            return;
        }
        timer.schedule(new k(), 0L, 1000L);
    }

    @Override // e.c.a.g.a.r.e.k.a, e.c.a.g.a.s.g1.b
    public void e() {
        super.e();
        X();
    }

    @Override // e.c.a.g.a.r.e.k.a
    public String h() {
        return "PhoneLoginStyle";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        f.z.d.j.e(view, "view");
        if (u1.g()) {
            return;
        }
        int id = view.getId();
        if (id == R.id.user_login_confirm) {
            a0();
        } else {
            if (id != R.id.user_login_send) {
                return;
            }
            b0();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(e.c.a.g.a.r.e.j.a aVar) {
        f.z.d.j.e(aVar, NotificationCompat.CATEGORY_EVENT);
        AccountSimpleEntity accountSimpleEntityA = aVar.a();
        if (accountSimpleEntityA != null) {
            c0();
            e.c.a.g.a.r.e.h hVar = new e.c.a.g.a.r.e.h();
            LoginExtraEntity loginExtraEntity = new LoginExtraEntity();
            loginExtraEntity.setSelectedUserID(accountSimpleEntityA.c());
            hVar.s(loginExtraEntity);
            hVar.t(U());
            hVar.n(this.u.getText().toString(), this.v.getText().toString());
        }
    }

    @Override // e.c.a.g.a.r.e.k.a
    public void u() {
        super.u();
        X();
    }

    @Override // e.c.a.g.a.r.e.k.a
    public void v() {
        super.v();
        EventBus.getDefault().unregister(this);
        i1.a(this.z, this.A);
        if (this.C.isInitialized()) {
            V().removeCallbacksAndMessages(null);
        }
        Timer timer = this.y;
        if (timer != null) {
            timer.cancel();
        }
        if (l1.V()) {
            e.c.a.g.a.j.a.c().e("login_phone");
            e.c.a.g.a.j.a.c().e("login_verify_code");
        }
    }

    @Override // e.c.a.g.a.r.e.k.a
    public void w() {
        super.w();
        X();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(e.c.a.g.a.n.a aVar) {
        l().e();
    }
}
