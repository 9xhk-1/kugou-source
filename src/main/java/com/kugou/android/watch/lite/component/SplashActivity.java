package com.kugou.android.watch.lite.component;

import android.os.Bundle;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.activity.StateFragmentActivity;
import com.kugou.android.watch.lite.component.privacy.PrivacyAgreementActivity;
import com.kugou.common.startAppAPM.task.ApmReportHelper;
import e.c.a.g.a.f.a;
import e.c.a.g.a.f.m.c;

/* JADX INFO: loaded from: classes.dex */
public final class SplashActivity extends StateFragmentActivity {
    @Override // com.kugou.android.watch.lite.base.activity.StateFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        a.a(this);
        super.onCreate(bundle);
        setContentView(R.layout.activity_splash);
        boolean zE = c.a.e("sp_key_show_privacy", true);
        if (zE) {
            PrivacyAgreementActivity.h(this);
        } else {
            MainActivity.q.a(this, getIntent());
        }
        if (!zE) {
            ApmReportHelper.INSTANCE.startPlayApm();
        }
        finish();
    }
}
