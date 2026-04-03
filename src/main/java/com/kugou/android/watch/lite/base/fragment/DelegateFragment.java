package com.kugou.android.watch.lite.base.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.kugou.android.watch.lite.base.uistructure.PageKey;
import e.c.a.g.a.d.v.f;
import e.c.a.g.a.f.n.a;
import e.c.a.g.a.g.o.b;
import e.c.a.g.a.s.g0;

/* JADX INFO: loaded from: classes.dex */
public class DelegateFragment extends AbsBaseFragment {
    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment
    public void f0(Class<? extends Fragment> cls, Bundle bundle, boolean z, boolean z2, boolean z3) {
        Bundle bundle2 = bundle == null ? new Bundle() : new Bundle(bundle);
        Bundle arguments = getArguments();
        if (arguments == null) {
            arguments = new Bundle();
        }
        String string = arguments.getString("key_identifier");
        if (string == null) {
            string = "";
        }
        String string2 = arguments.getString("key_custom_identifier");
        String str = string2 != null ? string2 : "";
        String strS0 = s0();
        if (g0.a) {
            g0.e("DelegateFragment", "previousKeyIdentifier " + string + " customKeyIdentifier " + str + " title " + strS0);
        }
        boolean z4 = arguments.getBoolean("key_identifier_append_title", true);
        arguments.remove("key_identifier_append_title");
        StringBuilder sb = new StringBuilder();
        sb.append(string);
        if (z4 && !TextUtils.isEmpty(strS0)) {
            sb.append("/");
            sb.append(strS0);
        }
        if (!TextUtils.isEmpty(str)) {
            sb.append("/");
            sb.append(str);
            arguments.remove("key_custom_identifier");
        }
        if (g0.a) {
            g0.e("DelegateFragment", "KEY_IDENTIFIER " + sb.toString());
        }
        if (bundle2.getBoolean("key_use_identifier_source", true)) {
            bundle2.putString("key_identifier", sb.toString());
        }
        super.f0(cls, bundle2, z, z2, z3);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment
    @NonNull
    public PageKey m() {
        return PageKey.make(super.m(), p());
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        b.w();
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment
    public String p() {
        String string = getArguments() != null ? getArguments().getString("key_identifier", "") : "";
        String strS0 = s0();
        f.a aVarA = f.a();
        aVarA.a(string);
        aVarA.a(strS0);
        return aVarA.b();
    }

    public String s0() {
        return (getArguments() == null || getArguments().getBoolean("key_resume_page_identifier_append_title", true)) ? "" : getArguments().getString("key_resume_page_custom_identifier");
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z && t0()) {
            if (g0.a) {
                g0.b("DelegateFragment", "source: " + p());
            }
            a.b().i(10112, p());
        }
    }

    public boolean t0() {
        return true;
    }
}
