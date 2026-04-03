package com.kugou.android.watch.lite.component;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.activity.StateFragmentActivity;
import com.kugou.android.watch.lite.base.application.KGApplication;
import e.c.a.g.a.d.x.f;
import e.c.a.g.a.d.x.v.e;
import e.c.a.g.a.s.s0;
import f.z.d.g;
import f.z.d.j;

/* JADX INFO: loaded from: classes.dex */
@e.c.c.l.f.b(id = -1)
public final class LimitUseActivity extends StateFragmentActivity {
    public static final a b = new a(null);
    public boolean a;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final void a(Context context) {
            j.e(context, "context");
            context.startActivity(s0.a.a(context, LimitUseActivity.class));
        }
    }

    public static final class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            f.x();
            LimitUseActivity.this.finish();
        }
    }

    public static final class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            LimitUseActivity.this.finish();
            KGApplication.exit();
        }
    }

    @Override // com.kugou.android.watch.lite.base.activity.StateFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        String string;
        super.onCreate(bundle);
        setContentView(R.layout.activity_limit_use);
        int iB = e.f628d.a().b();
        if (iB < 60) {
            StringBuilder sb = new StringBuilder();
            sb.append(iB);
            sb.append((char) 31186);
            string = sb.toString();
        } else {
            string = (iB / 60) + "分钟";
        }
        ((TextView) findViewById(R.id.hint)).setText("您已经听了" + string + "歌了\n休息10分钟吧");
        findViewById(R.id.confirm).setOnClickListener(new b());
        findViewById(R.id.cancel).setOnClickListener(new c());
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.a) {
            return;
        }
        this.a = true;
        f.t();
    }
}
