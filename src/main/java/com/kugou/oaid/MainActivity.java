package com.kugou.oaid;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

/* JADX INFO: loaded from: classes2.dex */
public class MainActivity extends Activity {
    static {
        System.loadLibrary("oaid");
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView) findViewById(R.id.sample_text);
        try {
            Class.forName("com.android.id.impl.IdProviderImpl");
            XiaoMiOaid xiaoMiOaid = new XiaoMiOaid();
            Log.d("result:", xiaoMiOaid.getXiaoMiOaid());
            textView.setText(xiaoMiOaid.getXiaoMiOaid());
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
        }
    }
}
