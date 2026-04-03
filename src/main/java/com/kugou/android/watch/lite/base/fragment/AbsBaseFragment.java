package com.kugou.android.watch.lite.base.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kugou.android.watch.lite.base.activity.AbsBaseActivity;
import e.c.a.g.a.d.n.a.a.a;

/* JADX INFO: loaded from: classes.dex */
public class AbsBaseFragment extends AbsFrameworkFragment {
    public AbsBaseActivity o;
    public View p;
    public a q = new a();

    public void h0() {
        this.q.a();
    }

    public void i0() {
        this.q.b();
    }

    public View j0(int i2) {
        if (getView() != null) {
            return getView().findViewById(i2);
        }
        return null;
    }

    public Context k0() {
        return this.o.getBaseContext();
    }

    public View l0() {
        return this.p;
    }

    public boolean m0() {
        return this.q.c();
    }

    public void n0(Runnable runnable) {
        AbsBaseActivity absBaseActivity = this.o;
        if (absBaseActivity != null) {
            absBaseActivity.runOnUiThread(runnable);
        }
    }

    public void o0(int i2) {
        this.q.e(i2);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment, androidx.fragment.app.Fragment
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        AbsBaseActivity absBaseActivity = (AbsBaseActivity) context;
        this.o = absBaseActivity;
        this.q.d(absBaseActivity);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.p = view;
    }

    public void p0() {
        this.q.f(e.c.a.g.a.d.w.a.g(this), 4);
    }

    public void q0(boolean z) {
        this.q.g(e.c.a.g.a.d.w.a.g(this), 4, z);
    }

    public void r0(boolean z, String str) {
        this.q.h(e.c.a.g.a.d.w.a.g(this), 4, z, str);
    }
}
