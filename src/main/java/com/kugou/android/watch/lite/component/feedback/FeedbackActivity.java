package com.kugou.android.watch.lite.component.feedback;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentTransaction;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.activity.DelegateActivity;
import e.c.a.g.a.j.a;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.o;
import e.c.c.l.f.b;
import f.z.d.j;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes.dex */
@b(id = -1)
public final class FeedbackActivity extends DelegateActivity {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FeedbackFragment f154d;

    @Override // com.kugou.android.watch.lite.base.activity.AbsFrameworkActivity
    public boolean e() {
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 10001 && i3 == 10000) {
            a.c().d(intent);
        }
        r(i2, i3, intent);
    }

    @Override // com.kugou.android.watch.lite.base.activity.StateFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_feedback);
        if (bundle == null) {
            FeedbackFragment feedbackFragment = new FeedbackFragment();
            this.f154d = feedbackFragment;
            j.c(feedbackFragment);
            feedbackFragment.setArguments(getIntent().getExtras());
            FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
            FeedbackFragment feedbackFragment2 = this.f154d;
            j.c(feedbackFragment2);
            fragmentTransactionBeginTransaction.replace(R.id.fragment_container, feedbackFragment2).commit();
        }
        if (EventBus.getDefault().isRegistered(this)) {
            return;
        }
        EventBus.getDefault().register(this);
    }

    @Override // com.kugou.android.watch.lite.base.activity.AbsBaseActivity, com.kugou.android.watch.lite.base.activity.StateFragmentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        o.a(this);
        s();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(e.c.a.g.a.g.g.b.a aVar) {
        j.e(aVar, NotificationCompat.CATEGORY_EVENT);
        Log.e("FeedbackActivity", j.l("onEventMainThread FeedbackFinish. isFinishing = ", Boolean.valueOf(isFinishing())));
        if (!isFinishing()) {
            finish();
        }
        s();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent == null) {
            return;
        }
        boolean booleanExtra = intent.getBooleanExtra("KEY_ACTIVITY_RESULT_BY_NEW_INTENT", false);
        int intExtra = intent.getIntExtra("KEY_ACTIVITY_RESULT_REQUEST_CODE", -1);
        if (!booleanExtra || intExtra <= 0) {
            return;
        }
        onActivityResult(intExtra, -1, intent);
    }

    public final void r(int i2, int i3, Intent intent) {
        if (i2 == 10923) {
            try {
                FeedbackFragment feedbackFragment = this.f154d;
                if (feedbackFragment == null) {
                    return;
                }
                feedbackFragment.P0(i2, i3, intent);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void s() {
        try {
            l1.I(this);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
