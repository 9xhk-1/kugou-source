package com.kugou.android.watch.lite.base.activity;

import android.os.Bundle;
import android.view.View;
import com.kugou.android.watch.lite.base.swipeback.SwipeBackLayout;
import e.c.a.g.a.d.a0.a;

/* JADX INFO: loaded from: classes.dex */
public class SwipeBackActivity extends DelegateActivity {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f15d;

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public View findViewById(int i2) {
        a aVar;
        View viewFindViewById = super.findViewById(i2);
        return (viewFindViewById != null || (aVar = this.f15d) == null) ? viewFindViewById : aVar.a(i2);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
    }

    @Override // com.kugou.android.watch.lite.base.activity.StateFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a aVar = new a(this);
        this.f15d = aVar;
        aVar.c();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        this.f15d.d();
    }

    public SwipeBackLayout r() {
        return this.f15d.b();
    }

    public void s(boolean z) {
        r().setEnableGesture(z);
    }
}
