package com.kugou.android.watch.lite.common.image;

import android.os.Bundle;
import com.kugou.android.watch.lite.base.activity.AbsBaseActivity;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class MonitoredActivity extends AbsBaseActivity {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList<a> f112d = new ArrayList<>();

    public interface a {
        void onActivityCreated(MonitoredActivity monitoredActivity);

        void onActivityDestroyed(MonitoredActivity monitoredActivity);

        void onActivityStarted(MonitoredActivity monitoredActivity);

        void onActivityStopped(MonitoredActivity monitoredActivity);
    }

    @Override // com.kugou.android.watch.lite.base.activity.StateFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Iterator<a> it = this.f112d.iterator();
        while (it.hasNext()) {
            it.next().onActivityCreated(this);
        }
    }

    @Override // com.kugou.android.watch.lite.base.activity.AbsBaseActivity, com.kugou.android.watch.lite.base.activity.StateFragmentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Iterator<a> it = this.f112d.iterator();
        while (it.hasNext()) {
            it.next().onActivityDestroyed(this);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        Iterator<a> it = this.f112d.iterator();
        while (it.hasNext()) {
            it.next().onActivityStarted(this);
        }
    }

    @Override // com.kugou.android.watch.lite.base.activity.AbsFrameworkActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        Iterator<a> it = this.f112d.iterator();
        while (it.hasNext()) {
            it.next().onActivityStopped(this);
        }
    }
}
