package com.kugou.android.watch.lite.base.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.activity.AbsFrameworkActivity;
import com.kugou.android.watch.lite.base.main.MainFragmentContainer;
import com.kugou.android.watch.lite.base.other.ViewPagerFrameworkDelegate;
import com.kugou.android.watch.lite.base.uistructure.PageKey;
import com.kugou.framework.libcommon.netcore.BaseConnection;
import e.c.a.g.a.d.r.e;
import e.c.a.g.a.f.o.i.c;
import e.c.a.g.a.s.g0;
import java.lang.reflect.Field;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class AbsFrameworkFragment extends Fragment implements KeyEvent.Callback {
    public AbsFrameworkActivity a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f31d;
    public HandlerThread n;
    public boolean b = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f32f = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f33h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f34i = false;
    public ArrayList<View> j = new ArrayList<>();
    public final byte[] k = new byte[0];
    public boolean l = false;
    public boolean m = false;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewPagerFrameworkDelegate viewPagerFrameworkDelegateF = AbsFrameworkFragment.this.a.f();
            if (viewPagerFrameworkDelegateF != null) {
                viewPagerFrameworkDelegateF.N(AbsFrameworkFragment.this.t(), true);
            }
        }
    }

    public synchronized boolean A() {
        return this.m;
    }

    public boolean B() {
        return this.l;
    }

    public boolean C() {
        return this.f32f;
    }

    public void D() {
        if (this.f34i) {
            return;
        }
        this.f34i = true;
        F();
    }

    public void E() {
        W();
        synchronized (this.k) {
            this.k.notifyAll();
        }
    }

    public void F() {
    }

    public void G() {
    }

    public void H() {
    }

    public void I() {
    }

    public void J() {
        AbsFrameworkActivity absFrameworkActivity = this.a;
        if (absFrameworkActivity != null && absFrameworkActivity.getClass().getSimpleName().equals("MainActivity")) {
            M();
        }
        try {
            if (getView() != null) {
                Log.d("AbsFrameworkFragment", "onFragmentResume: ");
            }
        } catch (Exception e2) {
            g0.k(e2);
        }
    }

    public void K() {
    }

    public void L() {
    }

    public void M() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.getWindow().setSoftInputMode(34);
        }
    }

    public void N(Bundle bundle) {
        if (g0.a) {
            g0.b("AbsFrameworkFragment", "arguments:" + bundle);
        }
    }

    public void O() {
        g0();
    }

    public final void P() {
        if (getArguments() == null) {
            return;
        }
        Bundle bundle = null;
        try {
            bundle = getArguments().getBundle(ViewPagerFrameworkDelegate.y);
        } catch (NullPointerException e2) {
            g0.k(e2);
        }
        if (bundle != null) {
            int i2 = bundle.getInt("SkinTab_Indicator");
            if (g0.a) {
                g0.b("ocean", getClass().getSimpleName() + ".setTab -- " + ViewPagerFrameworkDelegate.y + BaseConnection.HTTP_REQ_ENTITY_PREFIX + i2);
            }
            if (i2 > 0) {
                bundle.putInt("SkinTab_Indicator", 0);
                a0(i2);
            }
        }
    }

    public final void Q(Bundle bundle) {
        int iR;
        try {
            iR = r();
        } catch (NullPointerException e2) {
            g0.k(e2);
            iR = 0;
        }
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        bundle2.putInt("SkinTab_Indicator", iR);
        MainFragmentContainer mainFragmentContainerK = k();
        if (mainFragmentContainerK == null || mainFragmentContainerK.g() == null) {
            return;
        }
        k().g().u0(bundle2, getId());
    }

    public void R(boolean z) {
    }

    public void S(boolean z) {
    }

    public final void T() {
        Bundle bundleW;
        if (g() == null || (bundleW = g().W(getClass().getName())) == null) {
            return;
        }
        if (g0.a) {
            g0.b("AbsFrameworkFragment", "restoreSavedFragmentState:mSavedInstanceState=" + bundleW);
        }
        try {
            Field declaredField = Fragment.class.getDeclaredField("mSavedFragmentState");
            declaredField.setAccessible(true);
            if (g0.a) {
                g0.b("AbsFrameworkFragment", "restoreSavedFragmentState:before set" + declaredField.get(this));
            }
            declaredField.set(this, bundleW);
            if (g0.a) {
                g0.b("AbsFrameworkFragment", "restoreSavedFragmentState:after set " + declaredField.get(this));
            }
        } catch (Exception e2) {
            g0.k(e2);
            if (g0.a) {
                g0.b("AbsFrameworkFragment", "restoreSavedFragmentState relate fail");
            }
        }
    }

    public void U(AbsFrameworkActivity absFrameworkActivity) {
        this.a = absFrameworkActivity;
    }

    public final synchronized void V(boolean z) {
        this.b = z;
    }

    public synchronized void W() {
        this.m = true;
    }

    public void X(boolean z) {
        this.f33h = z;
    }

    public void Y() {
        this.l = true;
    }

    public void Z(boolean z) {
        this.f32f = z;
    }

    public void a0(int i2) {
    }

    public void b(View view) {
        AbsFrameworkFragment absFrameworkFragmentT = t();
        if (absFrameworkFragmentT != null) {
            ArrayList<View> arrayList = absFrameworkFragmentT.j;
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(view);
        }
    }

    public void b0(Class<? extends Fragment> cls, Bundle bundle) {
        f0(cls, bundle, true, false, false);
    }

    public final void c(View view) {
        int iO;
        if (view == null || (iO = o()) == 1) {
            return;
        }
        if (iO == 2) {
            c.a().c(2, view);
        } else if (iO != 4) {
            c.a().d(2, view);
        } else {
            c.a().f(2, view.findViewById(R.id.screen_corner_space_top_hold));
            c.a().e(2, view);
        }
    }

    public void c0(AbsFrameworkFragment absFrameworkFragment, Class<? extends Fragment> cls, Bundle bundle, boolean z, boolean z2, boolean z3) {
        d0(absFrameworkFragment, cls, bundle, z, z2, z3, bundle != null && bundle.getBoolean("iscontious"));
    }

    public boolean d() {
        return true;
    }

    public void d0(AbsFrameworkFragment absFrameworkFragment, Class<? extends Fragment> cls, Bundle bundle, boolean z, boolean z2, boolean z3, boolean z4) {
        e0(absFrameworkFragment, cls, bundle, z, z2, z3, z4, false);
    }

    public void e() {
        f(false);
    }

    public void e0(AbsFrameworkFragment absFrameworkFragment, Class<? extends Fragment> cls, Bundle bundle, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        ViewPagerFrameworkDelegate viewPagerFrameworkDelegateF = this.a.f();
        if (viewPagerFrameworkDelegateF != null) {
            Bundle bundle2 = bundle == null ? new Bundle() : bundle;
            String str = this.f31d;
            int iQ = q();
            if (iQ >= 0) {
                if (TextUtils.isEmpty(str)) {
                    str = "0:" + iQ;
                } else {
                    str = str + ":" + iQ;
                }
            }
            bundle2.putString("KEY_SOURCE_PATH", str);
            viewPagerFrameworkDelegateF.L0(absFrameworkFragment != null ? absFrameworkFragment : t(), cls, bundle2, z, z2, z3, z4, z5);
        }
    }

    public void f(boolean z) {
        this.a.runOnUiThread(new a());
    }

    public void f0(Class<? extends Fragment> cls, Bundle bundle, boolean z, boolean z2, boolean z3) {
        c0(null, cls, bundle, z, z2, z3);
    }

    public ViewPagerFrameworkDelegate g() {
        AbsFrameworkActivity absFrameworkActivity = this.a;
        if (absFrameworkActivity == null) {
            return null;
        }
        return absFrameworkActivity.f();
    }

    public void g0() {
        View view = getView();
        if (view != null) {
            view.setTag(805306116, e.c.a.g.a.d.w.a.b(getClass(), view));
        }
    }

    public int h() {
        return 1;
    }

    public AbsFrameworkFragment i() {
        Fragment fragment = this;
        while (true) {
            Fragment parentFragment = fragment.getParentFragment();
            if (parentFragment == null) {
                break;
            }
            fragment = parentFragment;
        }
        if (fragment instanceof AbsFrameworkFragment) {
            return (AbsFrameworkFragment) fragment;
        }
        return null;
    }

    public ArrayList<View> j() {
        AbsFrameworkFragment absFrameworkFragmentT = t();
        if (absFrameworkFragmentT == null) {
            return null;
        }
        return absFrameworkFragmentT.j;
    }

    public MainFragmentContainer k() {
        ViewPagerFrameworkDelegate viewPagerFrameworkDelegateF;
        if (this.a == null) {
            this.a = (AbsFrameworkActivity) getActivity();
        }
        AbsFrameworkActivity absFrameworkActivity = this.a;
        if (absFrameworkActivity == null || (viewPagerFrameworkDelegateF = absFrameworkActivity.f()) == null) {
            return null;
        }
        return viewPagerFrameworkDelegateF.a0();
    }

    public e l() {
        e.c.a.g.a.d.r.c cVarV = e.c.a.g.a.d.r.c.v();
        cVarV.attachActivity(g().R());
        return cVarV;
    }

    public PageKey m() {
        String strJ;
        String strN = n();
        View view = getView();
        int iG = 528178838;
        if (view != null) {
            int iF = e.c.a.g.a.d.w.a.f(view);
            iG = iF == 528178838 ? e.c.a.g.a.d.w.a.g(this) : iF;
            strJ = e.c.a.g.a.d.w.a.j(view);
        } else {
            strJ = null;
        }
        return PageKey.make(strN, iG, strJ);
    }

    public String n() {
        String str = this.f31d;
        if (q() < 0) {
            return str;
        }
        return str + ":" + q();
    }

    public int o() {
        return 3;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            this.a = (AbsFrameworkActivity) context;
            D();
            AbsFrameworkFragment absFrameworkFragmentI = i();
            if (this.f33h || (absFrameworkFragmentI != null && absFrameworkFragmentI.f33h)) {
                T();
            }
        } catch (ClassCastException unused) {
            throw new ClassCastException(context.toString() + " must be AbsFrameworkActivity");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        V(false);
        super.onDestroyView();
    }

    @Override // android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        return false;
    }

    @Override // android.view.KeyEvent.Callback
    public boolean onKeyLongPress(int i2, KeyEvent keyEvent) {
        return false;
    }

    @Override // android.view.KeyEvent.Callback
    public boolean onKeyMultiple(int i2, int i3, KeyEvent keyEvent) {
        return false;
    }

    @Override // android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.l) {
            this.l = false;
            E();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (g() != null) {
            Q(bundle);
            g().v0(bundle, getId(), getClass().getName());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (g() != null) {
            P();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        c(view);
        V(true);
        y(view);
        Bundle arguments = getArguments();
        if (arguments == null) {
            this.f31d = "" + s();
            return;
        }
        String string = null;
        try {
            string = arguments.getString("KEY_SOURCE_PATH");
        } catch (OutOfMemoryError e2) {
            g0.j(e2);
            if (g0.a) {
                g0.b("AbsFrameworkFragment", "onViewCreated Bundle getString oom");
            }
        }
        if (string == null || string.equals("0")) {
            this.f31d = "" + s();
            return;
        }
        this.f31d = string + "," + s();
    }

    public String p() {
        return "";
    }

    public int q() {
        return -1;
    }

    public int r() {
        return 0;
    }

    public int s() {
        return 0;
    }

    public AbsFrameworkFragment t() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment == null) {
            return this;
        }
        while (true) {
            Fragment fragment = parentFragment;
            while (parentFragment != null) {
                parentFragment = parentFragment.getParentFragment();
                if (parentFragment != null) {
                    break;
                }
            }
            return (AbsFrameworkFragment) fragment;
        }
    }

    public Looper u() {
        if (this.n == null) {
            HandlerThread handlerThread = new HandlerThread(AbsFrameworkActivity.class.getName(), v());
            this.n = handlerThread;
            handlerThread.start();
        }
        return this.n.getLooper();
    }

    public int v() {
        return 10;
    }

    public boolean w() {
        return true;
    }

    public boolean x() {
        return true;
    }

    public final void y(View view) {
        if (view != null) {
            e.c.a.g.a.d.w.a.a(getClass(), view);
        }
    }

    public synchronized boolean z() {
        return this.b;
    }
}
