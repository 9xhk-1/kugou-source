package com.kugou.android.watch.lite.user.login;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.fragment.DelegateFragment;
import com.kugou.common.startAppAPM.task.ApmReportHelper;
import e.c.a.g.a.r.e.k.b;
import e.c.a.g.a.s.c0;
import e.c.a.g.a.s.d0;
import e.c.a.g.a.s.g1;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.t1;
import e.c.a.g.a.s.u1;
import f.z.d.j;
import f.z.d.k;

/* JADX INFO: loaded from: classes2.dex */
@e.c.c.l.f.b(id = -1)
@SuppressLint({"ClickableViewAccessibility"})
public final class UserLoginIntegrationFragment extends DelegateFragment {
    public g1<e.c.a.g.a.r.e.k.a> r;
    public View s;
    public View t;
    public View u;
    public ScrollView v;
    public final f.d w = f.f.b(h.a);
    public boolean x;

    public static final class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            g1 g1Var;
            if (u1.i(view) || (g1Var = UserLoginIntegrationFragment.this.r) == null) {
                return;
            }
        }
    }

    public static final class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            g1 g1Var;
            if (u1.i(view) || (g1Var = UserLoginIntegrationFragment.this.r) == null) {
                return;
            }
        }
    }

    public static final class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            g1 g1Var;
            if (u1.i(view) || (g1Var = UserLoginIntegrationFragment.this.r) == null) {
                return;
            }
        }
    }

    public static final class d<T> implements c0.a {
        public final /* synthetic */ View b;

        public d(View view) {
            this.b = view;
        }

        @Override // e.c.a.g.a.s.c0.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final e.c.a.g.a.r.e.k.a create(Class<? extends e.c.a.g.a.r.e.k.a> cls) {
            if (j.a(cls, e.c.a.g.a.r.e.k.f.class)) {
                UserLoginIntegrationFragment userLoginIntegrationFragment = UserLoginIntegrationFragment.this;
                return new e.c.a.g.a.r.e.k.f(userLoginIntegrationFragment, this.b, userLoginIntegrationFragment.v0(), UserLoginIntegrationFragment.this.w0());
            }
            if (j.a(cls, e.c.a.g.a.r.e.k.d.class)) {
                UserLoginIntegrationFragment userLoginIntegrationFragment2 = UserLoginIntegrationFragment.this;
                return new e.c.a.g.a.r.e.k.d(userLoginIntegrationFragment2, this.b, userLoginIntegrationFragment2.v0(), UserLoginIntegrationFragment.this.w0());
            }
            if (!j.a(cls, e.c.a.g.a.r.e.k.g.class)) {
                throw new IllegalArgumentException(j.l("invalid state : ", cls));
            }
            UserLoginIntegrationFragment userLoginIntegrationFragment3 = UserLoginIntegrationFragment.this;
            return new e.c.a.g.a.r.e.k.g(userLoginIntegrationFragment3, this.b, userLoginIntegrationFragment3.v0(), UserLoginIntegrationFragment.this.w0());
        }
    }

    public static final class e<T> implements g1.c {
        public e() {
        }

        @Override // e.c.a.g.a.s.g1.c
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onStateChanged(e.c.a.g.a.r.e.k.a aVar, e.c.a.g.a.r.e.k.a aVar2) {
            UserLoginIntegrationFragment.this.z0(aVar2);
        }
    }

    public static final class f extends t1 {
        public f() {
        }

        @Override // e.c.a.g.a.s.t1
        public void a(View view) {
            e.c.a.g.a.r.e.k.a aVar;
            j.e(view, "v");
            g1 g1Var = UserLoginIntegrationFragment.this.r;
            if (g1Var == null || (aVar = (e.c.a.g.a.r.e.k.a) g1Var.a()) == null) {
                return;
            }
            aVar.u();
        }
    }

    public static final class g implements b.a {
        public g() {
        }

        @Override // e.c.a.g.a.r.e.k.b.a
        public void onFail(Throwable th) {
            Log.d("mhs_watch", j.l("onFail t =", th));
        }

        @Override // e.c.a.g.a.r.e.k.b.a
        public void onStart() {
            Log.d("mhs_watch", "onStart");
        }

        @Override // e.c.a.g.a.r.e.k.b.a
        public void onSuccess(e.c.a.g.a.n.b.a aVar, e.c.a.g.a.n.b.d dVar) {
            j.e(aVar, "kgCode");
            j.e(dVar, "wxCode");
            UserLoginIntegrationFragment userLoginIntegrationFragment = UserLoginIntegrationFragment.this;
            g1 g1Var = userLoginIntegrationFragment.r;
            userLoginIntegrationFragment.z0(g1Var == null ? null : (e.c.a.g.a.r.e.k.a) g1Var.a());
            Log.d("mhs_watch", "onSuccess");
        }
    }

    public static final class h extends k implements f.z.c.a<e.c.a.g.a.r.e.k.b> {
        public static final h a = new h();

        public h() {
            super(0);
        }

        @Override // f.z.c.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final e.c.a.g.a.r.e.k.b invoke() {
            return new e.c.a.g.a.r.e.k.b();
        }
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment
    public void G() {
        e.c.a.g.a.r.e.k.a aVar;
        super.G();
        g1<e.c.a.g.a.r.e.k.a> g1Var = this.r;
        if (g1Var == null || (aVar = (e.c.a.g.a.r.e.k.a) g1Var.a()) == null) {
            return;
        }
        aVar.w();
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment
    public void J() {
        e.c.a.g.a.r.e.k.a aVar;
        super.J();
        g1<e.c.a.g.a.r.e.k.a> g1Var = this.r;
        if (g1Var == null || (aVar = (e.c.a.g.a.r.e.k.a) g1Var.a()) == null) {
            return;
        }
        aVar.x();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        j.e(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_user_login_integration, viewGroup, false);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        e.c.a.g.a.r.e.k.a aVar;
        super.onDestroy();
        g1<e.c.a.g.a.r.e.k.a> g1Var = this.r;
        if (g1Var != null && (aVar = (e.c.a.g.a.r.e.k.a) g1Var.a()) != null) {
            aVar.v();
        }
        v0().n();
        ApmReportHelper.INSTANCE.clearLoginRcmAPMAPM();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        e.c.a.g.a.r.e.k.a aVar;
        super.onPause();
        g1<e.c.a.g.a.r.e.k.a> g1Var = this.r;
        if (g1Var == null || (aVar = (e.c.a.g.a.r.e.k.a) g1Var.a()) == null) {
            return;
        }
        aVar.w();
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment, androidx.fragment.app.Fragment
    public void onResume() {
        e.c.a.g.a.r.e.k.a aVar;
        super.onResume();
        g1<e.c.a.g.a.r.e.k.a> g1Var = this.r;
        if (g1Var == null || (aVar = (e.c.a.g.a.r.e.k.a) g1Var.a()) == null) {
            return;
        }
        aVar.x();
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsBaseFragment, com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        ScrollView scrollView;
        j.e(view, "view");
        super.onViewCreated(view, bundle);
        if (l1.X()) {
            u1.l(view.findViewById(R.id.content_view), 17);
        }
        this.v = (ScrollView) j0(R.id.scroll_view);
        x0();
        y0(view);
        g1<e.c.a.g.a.r.e.k.a> g1Var = new g1<>(new d(view));
        this.r = g1Var;
        if (g1Var != null) {
            g1Var.f(e.c.a.g.a.r.e.k.g.class);
        }
        g1<e.c.a.g.a.r.e.k.a> g1Var2 = this.r;
        if (g1Var2 != null) {
            g1Var2.e(new e());
        }
        if (l1.X() && (scrollView = this.v) != null) {
            scrollView.setOnTouchListener(new f());
        }
        v0().e(new g());
        g1<e.c.a.g.a.r.e.k.a> g1Var3 = this.r;
        z0(g1Var3 == null ? null : (e.c.a.g.a.r.e.k.a) g1Var3.a());
    }

    public final e.c.a.g.a.r.e.k.b v0() {
        return (e.c.a.g.a.r.e.k.b) this.w.getValue();
    }

    public final ScrollView w0() {
        return this.v;
    }

    public final void x0() {
        this.x = d0.a(getArguments(), "key_hide_phone_login", false);
    }

    public final void y0(View view) {
        this.s = view.findViewById(R.id.qr_code_login);
        this.t = view.findViewById(R.id.wx_qr_code_login);
        this.u = view.findViewById(R.id.phone_login);
        View view2 = this.s;
        if (view2 != null) {
            view2.setOnClickListener(new a());
        }
        View view3 = this.t;
        if (view3 != null) {
            view3.setOnClickListener(new b());
        }
        View view4 = this.u;
        if (view4 == null) {
            return;
        }
        view4.setOnClickListener(new c());
    }

    public final void z0(e.c.a.g.a.r.e.k.a aVar) {
        boolean zI = v0().i();
        if (aVar instanceof e.c.a.g.a.r.e.k.d) {
            View view = this.t;
            if (view != null) {
                view.setVisibility(zI ? 8 : 0);
            }
            View view2 = this.u;
            if (view2 != null) {
                view2.setVisibility(this.x ? 8 : 0);
            }
            u1.e(this.s);
            return;
        }
        if (aVar instanceof e.c.a.g.a.r.e.k.g) {
            View view3 = this.s;
            if (view3 != null) {
                view3.setVisibility(0);
            }
            View view4 = this.u;
            if (view4 != null) {
                view4.setVisibility(this.x ? 8 : 0);
            }
            u1.e(this.t);
            return;
        }
        if (aVar instanceof e.c.a.g.a.r.e.k.f) {
            View view5 = this.t;
            if (view5 != null) {
                view5.setVisibility(zI ? 8 : 0);
            }
            u1.p(this.s);
            u1.e(this.u);
        }
    }
}
