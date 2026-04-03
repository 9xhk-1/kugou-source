package com.kugou.android.watch.lite.user.login;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.activity.StateFragmentActivity;

/* JADX INFO: loaded from: classes2.dex */
public class LoginRiskActivity extends StateFragmentActivity {

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LoginRiskActivity.this.finish();
        }
    }

    @Override // com.kugou.android.watch.lite.base.activity.StateFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_login_risk);
        findViewById(R.id.login_risk_root).setOnClickListener(new a());
    }
}
