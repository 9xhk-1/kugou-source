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
import e.c.a.g.a.r.e.k.b;
import e.c.a.g.a.r.e.k.f;
import e.c.a.g.a.r.e.k.g;
import e.c.a.g.a.s.c0;
import e.c.a.g.a.s.g1;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.t1;
import e.c.a.g.a.s.u1;
import f.z.d.j;
import f.z.d.k;

/* JADX INFO: loaded from: classes2.dex */
@e.c.c.l.f.b(id = -1)
@SuppressLint({"ClickableViewAccessibility"})
public final class UserLoginItemFragment extends DelegateFragment {
    public Class<? extends e.c.a.g.a.r.e.k.a> r;
    public g1<e.c.a.g.a.r.e.k.a> s;
    public ScrollView t;
    public final f.d u;

    public static final class a<T> implements c0.a {
        public final /* synthetic */ View b;

        public a(View view) {
            this.b = view;
        }

        @Override // e.c.a.g.a.s.c0.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final e.c.a.g.a.r.e.k.a create(Class<? extends e.c.a.g.a.r.e.k.a> cls) {
            if (j.a(cls, f.class)) {
                UserLoginItemFragment userLoginItemFragment = UserLoginItemFragment.this;
                return new f(userLoginItemFragment, this.b, userLoginItemFragment.v0(), UserLoginItemFragment.this.w0());
            }
            if (j.a(cls, e.c.a.g.a.r.e.k.d.class)) {
                UserLoginItemFragment userLoginItemFragment2 = UserLoginItemFragment.this;
                return new e.c.a.g.a.r.e.k.d(userLoginItemFragment2, this.b, userLoginItemFragment2.v0(), UserLoginItemFragment.this.w0());
            }
            if (j.a(cls, g.class)) {
                UserLoginItemFragment userLoginItemFragment3 = UserLoginItemFragment.this;
                return new g(userLoginItemFragment3, this.b, userLoginItemFragment3.v0(), UserLoginItemFragment.this.w0());
            }
            if (!j.a(cls, e.c.a.g.a.r.e.k.c.class)) {
                throw new IllegalArgumentException(j.l("invalid state : ", cls));
            }
            UserLoginItemFragment userLoginItemFragment4 = UserLoginItemFragment.this;
            return new e.c.a.g.a.r.e.k.c(userLoginItemFragment4, this.b, userLoginItemFragment4.v0(), UserLoginItemFragment.this.w0());
        }
    }

    public static final class b<T> implements g1.c {
        public b() {
        }

        @Override // e.c.a.g.a.s.g1.c
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onStateChanged(e.c.a.g.a.r.e.k.a aVar, e.c.a.g.a.r.e.k.a aVar2) {
            UserLoginItemFragment.this.y0(aVar2);
        }
    }

    public static final class c extends t1 {
        public c() {
        }

        @Override // e.c.a.g.a.s.t1
        public void a(View view) {
            e.c.a.g.a.r.e.k.a aVar;
            j.e(view, "v");
            g1 g1Var = UserLoginItemFragment.this.s;
            if (g1Var == null || (aVar = (e.c.a.g.a.r.e.k.a) g1Var.a()) == null) {
                return;
            }
            aVar.u();
        }
    }

    public static final class d implements b.a {
        public d() {
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
            UserLoginItemFragment userLoginItemFragment = UserLoginItemFragment.this;
            g1 g1Var = userLoginItemFragment.s;
            userLoginItemFragment.y0(g1Var == null ? null : (e.c.a.g.a.r.e.k.a) g1Var.a());
            Log.d("mhs_watch", "onSuccess");
        }
    }

    public static final class e extends k implements f.z.c.a<e.c.a.g.a.r.e.k.b> {
        public static final e a = new e();

        public e() {
            super(0);
        }

        @Override // f.z.c.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final e.c.a.g.a.r.e.k.b invoke() {
            return new e.c.a.g.a.r.e.k.b();
        }
    }

    public UserLoginItemFragment(Class<? extends e.c.a.g.a.r.e.k.a> cls) {
        j.e(cls, "className");
        this.r = cls;
        this.u = f.f.b(e.a);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment
    public void G() {
        e.c.a.g.a.r.e.k.a aVar;
        super.G();
        g1<e.c.a.g.a.r.e.k.a> g1Var = this.s;
        if (g1Var == null || (aVar = (e.c.a.g.a.r.e.k.a) g1Var.a()) == null) {
            return;
        }
        aVar.w();
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment
    public void J() {
        e.c.a.g.a.r.e.k.a aVar;
        super.J();
        g1<e.c.a.g.a.r.e.k.a> g1Var = this.s;
        if (g1Var == null || (aVar = (e.c.a.g.a.r.e.k.a) g1Var.a()) == null) {
            return;
        }
        aVar.x();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        j.e(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_user_login_item, viewGroup, false);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        e.c.a.g.a.r.e.k.a aVar;
        super.onDestroy();
        g1<e.c.a.g.a.r.e.k.a> g1Var = this.s;
        if (g1Var != null && (aVar = (e.c.a.g.a.r.e.k.a) g1Var.a()) != null) {
            aVar.v();
        }
        v0().n();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        e.c.a.g.a.r.e.k.a aVar;
        super.onPause();
        g1<e.c.a.g.a.r.e.k.a> g1Var = this.s;
        if (g1Var == null || (aVar = (e.c.a.g.a.r.e.k.a) g1Var.a()) == null) {
            return;
        }
        aVar.w();
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment, androidx.fragment.app.Fragment
    public void onResume() {
        e.c.a.g.a.r.e.k.a aVar;
        super.onResume();
        l1.I(getActivity());
        g1<e.c.a.g.a.r.e.k.a> g1Var = this.s;
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
        this.t = (ScrollView) j0(R.id.scroll_view);
        x0(view);
        g1<e.c.a.g.a.r.e.k.a> g1Var = new g1<>(new a(view));
        this.s = g1Var;
        if (g1Var != null) {
            g1Var.f(this.r);
        }
        g1<e.c.a.g.a.r.e.k.a> g1Var2 = this.s;
        if (g1Var2 != null) {
            g1Var2.e(new b());
        }
        if (l1.X() && (scrollView = this.t) != null) {
            scrollView.setOnTouchListener(new c());
        }
        v0().e(new d());
        g1<e.c.a.g.a.r.e.k.a> g1Var3 = this.s;
        y0(g1Var3 == null ? null : (e.c.a.g.a.r.e.k.a) g1Var3.a());
    }

    public e.c.a.g.a.r.e.k.b v0() {
        return (e.c.a.g.a.r.e.k.b) this.u.getValue();
    }

    public final ScrollView w0() {
        return this.t;
    }

    public final void x0(View view) {
    }

    public final void y0(e.c.a.g.a.r.e.k.a aVar) {
        v0().i();
    }
}
