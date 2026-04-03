package com.kugou.android.watch.lite.base.uiframe;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewPropertyAnimator;
import androidx.annotation.NonNull;
import com.kugou.android.watch.lite.base.uiframe.FragmentViewBase;
import e.c.a.g.a.d.b0.b;

/* JADX INFO: loaded from: classes.dex */
public class FragmentViewNormal extends FragmentViewSwipeBase {
    public FragmentViewNormal(@NonNull Context context) {
        super(context);
    }

    @Override // com.kugou.android.watch.lite.base.uiframe.FragmentViewBase
    public void f(int i2) {
        ViewPropertyAnimator viewPropertyAnimatorA = b.b().a(this);
        viewPropertyAnimatorA.translationX(0.0f);
        viewPropertyAnimatorA.alpha(1.0f);
        viewPropertyAnimatorA.setDuration(FragmentViewBase.s);
        viewPropertyAnimatorA.setListener(new FragmentViewBase.b());
        e.c.a.g.a.d.y.b.a(this, viewPropertyAnimatorA);
        p(2, false);
    }

    @Override // com.kugou.android.watch.lite.base.uiframe.FragmentViewBase
    public boolean i() {
        return false;
    }

    @Override // com.kugou.android.watch.lite.base.uiframe.FragmentViewBase
    public void j(FragmentViewBase fragmentViewBase) {
        e.c.a.g.a.d.y.b.a(this, b.b().a(this).setDuration(FragmentViewBase.s).translationX(getMeasuredWidth()).setListener(new FragmentViewBase.e(this, fragmentViewBase)));
    }

    @Override // com.kugou.android.watch.lite.base.uiframe.FragmentViewBase
    public void m(int i2, int i3, Bundle bundle) {
        setTranslationX(i2);
        setAlpha(0.0f);
    }
}
