package com.kugou.android.watch.lite.component.family;

import android.os.Bundle;
import android.view.View;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.activity.DelegateActivity;
import e.c.a.g.a.f.o.d;
import e.c.a.g.a.f.o.i.c;
import e.c.a.g.a.s.i1;
import e.c.c.l.f.b;
import rx.Subscription;

/* JADX INFO: loaded from: classes.dex */
@b(id = -1)
public final class FamilyControlInfoActivity extends DelegateActivity {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Subscription f150d;

    @Override // com.kugou.android.watch.lite.base.activity.StateFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_family_info);
        View viewFindViewById = findViewById(R.id.content_view);
        d.a(viewFindViewById);
        c.a().d(1, viewFindViewById);
    }

    @Override // com.kugou.android.watch.lite.base.activity.AbsBaseActivity, com.kugou.android.watch.lite.base.activity.StateFragmentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        i1.a(this.f150d);
    }

    @Override // com.kugou.android.watch.lite.base.activity.AbsFrameworkActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }
}
