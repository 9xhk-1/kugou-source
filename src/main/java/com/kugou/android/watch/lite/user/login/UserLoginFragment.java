package com.kugou.android.watch.lite.user.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.fragment.DelegateFragment;
import com.kugou.android.watch.lite.bi.YoungBITask;
import com.kugou.android.watch.lite.common.widget.AutoLoadingView;
import com.kugou.android.watch.lite.qrscan.AutoLoginKugouFragment;
import com.kugou.android.watch.lite.user.AccountSelectFragment;
import e.c.a.g.a.r.e.h;
import e.c.a.g.a.s.h1;
import e.c.a.g.a.s.i1;
import e.c.a.g.a.s.l0;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.p1;
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
@e.c.c.l.f.b(id = -1)
@Deprecated
public class UserLoginFragment extends DelegateFragment implements View.OnClickListener {
    public static String F = null;
    public static int G = 61;
    public Subscription C;
    public Subscription D;
    public View r;
    public EditText s;
    public EditText t;
    public TextView u;
    public TextView v;
    public AutoLoadingView w;
    public TextView x;
    public Timer y;
    public int z = G;
    public String A = "0";
    public final Handler B = new h(Looper.getMainLooper());
    public final h.d E = new a();

    /* JADX INFO: loaded from: classes2.dex */
    public class a implements h.d {

        /* JADX INFO: renamed from: com.kugou.android.watch.lite.user.login.UserLoginFragment$a$a, reason: collision with other inner class name */
        public class C0021a implements Action1<String> {
            public C0021a() {
            }

            @Override // rx.functions.Action1
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void call(String str) {
                UserLoginFragment.this.O0();
                e.c.a.g.a.r.e.d.d().g();
                p1.h(UserLoginFragment.this.getContext(), "登录成功");
                UserLoginFragment.this.e();
            }
        }

        public class b implements Action1<String> {
            public final /* synthetic */ UserData a;

            public b(UserData userData) {
                this.a = userData;
            }

            @Override // rx.functions.Action1
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void call(String str) {
                String str2;
                UserLoginFragment.this.O0();
                int error_code = this.a.getError_code();
                if (error_code == 34175 && !l0.g(this.a.getAccounts())) {
                    UserLoginFragment.this.M0(this.a.getAccounts());
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("登录失败");
                if (error_code > 0) {
                    str2 = "(" + error_code + ")";
                } else {
                    str2 = "";
                }
                sb.append(str2);
                p1.h(UserLoginFragment.this.getContext(), e.c.a.g.a.r.a.c(error_code, sb.toString()));
            }
        }

        public class c implements Action1<String> {
            public c() {
            }

            @Override // rx.functions.Action1
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void call(String str) {
                UserLoginFragment.this.O0();
                UserLoginFragment.this.startActivity(new Intent(UserLoginFragment.this.getActivity(), (Class<?>) LoginRiskActivity.class));
            }
        }

        public a() {
        }

        @Override // e.c.a.g.a.r.e.h.d
        public void onLoginFailed(UserData userData, int i2) {
            Log.i("UserLoginFragment", "onLoginFailed: error code=" + userData.getError_code());
            i1.a(UserLoginFragment.this.D);
            UserLoginFragment.this.D = Observable.just("").subscribeOn(AndroidSchedulers.mainThread()).subscribe(new b(userData), i1.b);
        }

        @Override // e.c.a.g.a.r.e.h.d
        public void onLoginRisk() {
            i1.a(UserLoginFragment.this.D);
            UserLoginFragment.this.D = Observable.just("").subscribeOn(AndroidSchedulers.mainThread()).subscribe(new c(), i1.b);
        }

        @Override // e.c.a.g.a.r.e.h.d
        public void onLoginSucceed(UserData userData, int i2) {
            i1.a(UserLoginFragment.this.C);
            UserLoginFragment.this.C = Observable.just("").subscribeOn(AndroidSchedulers.mainThread()).subscribe(new C0021a(), i1.b);
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public class b implements TextView.OnEditorActionListener {
        public b(UserLoginFragment userLoginFragment) {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            l1.J(textView.getContext(), textView);
            return true;
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.c.a.g.a.j.a.c().f("login_phone", UserLoginFragment.this.getActivity());
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public class d implements e.c.a.g.a.s.y1.a<String> {
        public d() {
        }

        @Override // e.c.a.g.a.s.y1.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onCall(String str) {
            UserLoginFragment.this.s.setText(str);
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.c.a.g.a.j.a.c().f("login_verify_code", UserLoginFragment.this.getActivity());
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public class f implements e.c.a.g.a.s.y1.a<String> {
        public f() {
        }

        @Override // e.c.a.g.a.s.y1.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onCall(String str) {
            UserLoginFragment.this.t.setText(str);
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public class g extends TimerTask {
        public g() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            UserLoginFragment.this.B.removeMessages(1);
            UserLoginFragment.this.B.sendEmptyMessage(1);
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public class h extends Handler {
        public h(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (UserLoginFragment.this.z > 1) {
                UserLoginFragment.E0(UserLoginFragment.this);
                UserLoginFragment.this.u.setEnabled(false);
                UserLoginFragment.this.u.setAlpha(0.4f);
                UserLoginFragment.this.u.setText(UserLoginFragment.this.z + "秒");
                return;
            }
            if (UserLoginFragment.this.z == 1) {
                UserLoginFragment.this.z = UserLoginFragment.G;
                UserLoginFragment.this.u.setEnabled(true);
                UserLoginFragment.this.u.setAlpha(1.0f);
                UserLoginFragment.this.u.setText("发送");
                UserLoginFragment.this.y.cancel();
            }
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public class i implements Action1<e.c.a.g.a.r.e.i.b> {
        public final /* synthetic */ String a;

        public i(String str) {
            this.a = str;
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(e.c.a.g.a.r.e.i.b bVar) {
            UserLoginFragment.this.O0();
            e.c.a.g.a.r.e.i.g gVar = bVar.a;
            if (gVar != null && gVar.e()) {
                String unused = UserLoginFragment.F = this.a;
                p1.h(UserLoginFragment.this.getContext(), "验证码已发送");
                UserLoginFragment.this.V0();
            } else if (gVar == null || gVar.e()) {
                p1.h(UserLoginFragment.this.getContext(), "发送验证码失败，请稍后再试");
            } else {
                p1.h(UserLoginFragment.this.getContext(), e.c.a.g.a.r.e.i.g.d(e.c.c.o.f.a(), gVar.c(), gVar.b()));
            }
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public class j implements Action1<Throwable> {
        public j() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(Throwable th) {
            UserLoginFragment.this.O0();
            p1.h(UserLoginFragment.this.getContext(), "发送验证码失败，请稍后再试");
        }
    }

    public static /* synthetic */ int E0(UserLoginFragment userLoginFragment) {
        int i2 = userLoginFragment.z;
        userLoginFragment.z = i2 - 1;
        return i2;
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment
    public void G() {
        super.G();
        N0();
    }

    public void L0() {
        if (getArguments() != null) {
            this.A = getArguments().getString("source", "0");
        }
        e.c.a.g.a.e.b.b(new YoungBITask(20478, "exposure").setType("2").setTab(this.A));
    }

    public final void M0(ArrayList<AccountSimpleEntity> arrayList) {
        AccountSelectFragment.u0(arrayList);
    }

    public final void N0() {
        l1.J(getContext(), this.s);
        l1.J(getContext(), this.t);
    }

    public final void O0() {
        this.w.setVisibility(8);
        this.w.a();
    }

    public final void P0(@NonNull View view) {
        this.r = view.findViewById(R.id.content_view);
        if (l1.Z()) {
            u1.l(this.r, 17);
        }
        this.s = (EditText) view.findViewById(R.id.user_login_phone);
        this.t = (EditText) view.findViewById(R.id.user_login_verify_code);
        this.u = (TextView) view.findViewById(R.id.user_login_send);
        this.v = (TextView) view.findViewById(R.id.user_login_confirm);
        this.w = (AutoLoadingView) view.findViewById(R.id.user_login_loading);
        this.x = (TextView) view.findViewById(R.id.login_by_qr_code);
        this.s.setOnClickListener(this);
        this.t.setOnClickListener(this);
        this.v.setOnClickListener(this);
        this.u.setOnClickListener(this);
        this.x.setOnClickListener(this);
        view.findViewById(R.id.iv_login_by_qr_code).setOnClickListener(this);
        b bVar = new b(this);
        this.s.setOnEditorActionListener(bVar);
        this.t.setOnEditorActionListener(bVar);
        if (!TextUtils.isEmpty(F)) {
            this.s.setText(F);
        }
        if (e.c.a.g.a.j.a.c().b()) {
            this.s.setFocusable(false);
            this.s.setFocusableInTouchMode(false);
            this.s.setOnClickListener(new c());
            e.c.a.g.a.j.a.c().a("login_phone", new d());
            this.t.setFocusable(false);
            this.t.setFocusableInTouchMode(false);
            this.t.setOnClickListener(new e());
            e.c.a.g.a.j.a.c().a("login_verify_code", new f());
        }
    }

    public final boolean Q0() {
        String string = this.s.getText().toString();
        if (!TextUtils.isEmpty(string) && h1.n(string)) {
            return true;
        }
        p1.h(getContext(), "请输入有效手机号码");
        return false;
    }

    public final boolean R0() {
        String string = this.t.getText().toString();
        if (TextUtils.isEmpty(string)) {
            p1.h(getContext(), "验证码不能为空");
            return false;
        }
        if (h1.l(string)) {
            return true;
        }
        p1.h(getContext(), "验证码格式错误");
        return false;
    }

    public final void S0() {
        if (this.w.getVisibility() != 0 && Q0() && R0() && u0.m(getContext())) {
            U0();
            e.c.a.g.a.r.e.h hVar = new e.c.a.g.a.r.e.h();
            hVar.t(this.E);
            hVar.o(this.s.getText().toString(), this.t.getText().toString(), "");
        }
    }

    public final void T0() {
        if (this.w.getVisibility() != 0 && Q0() && u0.m(getContext())) {
            U0();
            String string = this.s.getText().toString();
            e.c.a.g.a.r.e.i.h.a(string).subscribe(new i(string), new j());
        }
    }

    public final void U0() {
        this.w.setVisibility(0);
        this.w.g();
    }

    public final void V0() {
        Timer timer = new Timer();
        this.y = timer;
        timer.schedule(new g(), 0L, 1000L);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (u1.g()) {
        }
        switch (view.getId()) {
            case R.id.iv_login_by_qr_code /* 2131231078 */:
            case R.id.login_by_qr_code /* 2131231114 */:
                Bundle bundle = new Bundle();
                bundle.putString("source", this.A);
                e.c.a.g.a.d.v.c.e(AutoLoginKugouFragment.class, bundle);
                break;
            case R.id.user_login_confirm /* 2131231517 */:
                N0();
                S0();
                break;
            case R.id.user_login_send /* 2131231521 */:
                N0();
                T0();
                break;
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_user_login, viewGroup, false);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
        i1.a(this.C, this.D);
        Handler handler = this.B;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        Timer timer = this.y;
        if (timer != null) {
            timer.cancel();
        }
        e.c.a.g.a.j.a.c().e("login_phone");
        e.c.a.g.a.j.a.c().e("login_verify_code");
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(e.c.a.g.a.r.e.j.a aVar) {
        AccountSimpleEntity accountSimpleEntityA;
        if (aVar.a() == null || (accountSimpleEntityA = aVar.a()) == null) {
            return;
        }
        U0();
        e.c.a.g.a.r.e.h hVar = new e.c.a.g.a.r.e.h();
        LoginExtraEntity loginExtraEntity = new LoginExtraEntity();
        loginExtraEntity.setSelectedUserID(accountSimpleEntityA.c());
        hVar.s(loginExtraEntity);
        hVar.t(this.E);
        hVar.n(this.s.getText().toString(), this.t.getText().toString());
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        N0();
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsBaseFragment, com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        P0(view);
        EventBus.getDefault().register(this);
        L0();
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateFragment
    public String s0() {
        return "手机登录页";
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(e.c.a.g.a.n.a aVar) {
        e();
    }
}
