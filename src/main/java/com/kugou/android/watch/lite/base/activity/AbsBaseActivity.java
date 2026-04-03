package com.kugou.android.watch.lite.base.activity;

import e.c.a.g.a.d.r.c;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbsBaseActivity extends AbsFrameworkActivity {
    @Override // com.kugou.android.watch.lite.base.activity.StateFragmentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        c.v().onDestroy();
    }
}
