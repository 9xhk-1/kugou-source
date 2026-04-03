package com.kugou.android.watch.lite.about;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.Nullable;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.activity.StateFragmentActivity;

/* JADX INFO: loaded from: classes.dex */
public class TestInputActivity extends StateFragmentActivity {

    public class a implements View.OnClickListener {
        public final /* synthetic */ EditText a;

        public a(EditText editText) {
            this.a = editText;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("voice_value", this.a.getText().toString());
            intent.putExtras(bundle);
            TestInputActivity.this.setResult(10000, intent);
            TestInputActivity.this.finish();
        }
    }

    @Override // com.kugou.android.watch.lite.base.activity.StateFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_test_input);
        findViewById(R.id.button).setOnClickListener(new a((EditText) findViewById(R.id.input)));
    }
}
