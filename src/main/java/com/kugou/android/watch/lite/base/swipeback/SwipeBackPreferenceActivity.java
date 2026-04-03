package com.kugou.android.watch.lite.base.swipeback;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.view.View;
import e.c.a.g.a.d.a0.a;

/* JADX INFO: loaded from: classes.dex */
public class SwipeBackPreferenceActivity extends PreferenceActivity {
    public a a;

    @Override // android.app.Activity
    public View findViewById(int i2) {
        a aVar;
        View viewFindViewById = super.findViewById(i2);
        return (viewFindViewById != null || (aVar = this.a) == null) ? viewFindViewById : aVar.a(i2);
    }

    @Override // android.preference.PreferenceActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a aVar = new a(this);
        this.a = aVar;
        aVar.c();
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        this.a.d();
    }
}
