package com.kugou.android.watch.lite.component.player;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.fragment.DelegateFragment;
import com.kugou.android.watch.lite.component.player.wdiget.PlayerFrameLayout;
import e.c.a.g.a.g.j.a;
import e.c.c.l.f.b;
import f.z.d.j;

/* JADX INFO: loaded from: classes2.dex */
@b(id = -1)
public final class NormalPlayerFragment extends DelegateFragment {
    public final a r;

    public NormalPlayerFragment() {
        a aVar = new a();
        this.r = aVar;
        aVar.b(u0(), this);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment
    public void G() {
        super.G();
        this.r.g(u0());
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment
    public void J() {
        super.J();
        this.r.h(u0());
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment
    public int o() {
        return 2;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.r.b(u0(), this);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        j.e(layoutInflater, "inflater");
        PlayerFrameLayout playerFrameLayout = new PlayerFrameLayout(requireContext());
        playerFrameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        playerFrameLayout.setBackgroundResource(R.color.black);
        this.r.e(u0());
        return playerFrameLayout;
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.r.f(u0());
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.r.g(u0());
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.r.h(u0());
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsBaseFragment, com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        j.e(view, "view");
        super.onViewCreated(view, bundle);
        this.r.i(u0());
        this.r.d();
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateFragment
    public String s0() {
        return "二级播放页";
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.r.j(u0(), z);
    }

    public final int u0() {
        return 2;
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment
    public boolean x() {
        return false;
    }
}
