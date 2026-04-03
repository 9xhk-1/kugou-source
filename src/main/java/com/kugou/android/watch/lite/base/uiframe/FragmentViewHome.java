package com.kugou.android.watch.lite.base.uiframe;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class FragmentViewHome extends FragmentViewBase {
    public FragmentViewHome(@NonNull Context context) {
        super(context);
    }

    @Override // com.kugou.android.watch.lite.base.uiframe.FragmentViewBase
    public void f(int i2) {
        throw new IllegalStateException("MainContainer doesn't have a enter animation");
    }

    @Override // com.kugou.android.watch.lite.base.uiframe.FragmentViewBase
    public boolean i() {
        return false;
    }

    @Override // com.kugou.android.watch.lite.base.uiframe.FragmentViewBase
    public void j(FragmentViewBase fragmentViewBase) {
        throw new IllegalStateException("MainContainer doesn't have a leave animation.");
    }

    @Override // com.kugou.android.watch.lite.base.uiframe.FragmentViewBase
    public void m(int i2, int i3, Bundle bundle) {
    }
}
