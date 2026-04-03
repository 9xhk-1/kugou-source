package com.kugou.android.watch.lite.base.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ViewGroup;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment;
import com.kugou.android.watch.lite.base.main.FrameworkContentView;
import com.kugou.android.watch.lite.base.main.MainFragmentContainer;
import com.kugou.android.watch.lite.base.other.ViewPagerFrameworkDelegate;
import com.kugou.android.watch.lite.base.uiframe.FragmentViewBase;
import com.kugou.android.watch.lite.component.MainFragment;
import com.kugou.android.watch.lite.component.player.MainPlayerFragment;
import com.kugou.android.watch.lite.component.player.lyric.MainLyricFragment;
import e.c.a.g.a.s.f1;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.l1;

/* JADX INFO: loaded from: classes.dex */
public abstract class FrameworkActivity extends SwipeBackActivity implements ViewPagerFrameworkDelegate.i, FrameworkContentView.b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public FrameworkContentView f12f = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Handler f13h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ViewPagerFrameworkDelegate f14i = new ViewPagerFrameworkDelegate(this, this);

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FrameworkActivity.this.B();
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FrameworkActivity.this.x();
            FrameworkActivity.this.z();
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FrameworkActivity.this.E();
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FrameworkActivity.this.F();
        }
    }

    public class e implements Runnable {
        public final /* synthetic */ Bundle a;

        public e(Bundle bundle) {
            this.a = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            FrameworkActivity.this.A(this.a);
        }
    }

    public void A(Bundle bundle) {
    }

    public void B() {
        I();
    }

    public void C() {
    }

    public void D() {
    }

    public void E() {
        w().post(new d());
    }

    public void F() {
    }

    public void G() {
    }

    public void H() {
    }

    public void I() {
    }

    public void J() {
    }

    public void K(boolean z) {
        this.f14i.F0(z);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        e.c.a.g.a.d.v.e.b().a(this);
    }

    @Override // com.kugou.android.watch.lite.base.activity.AbsFrameworkActivity
    public ViewPagerFrameworkDelegate f() {
        return this.f14i;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        FragmentViewBase fragmentViewBaseX;
        if (l1.U()) {
            AbsFrameworkFragment absFrameworkFragmentV = v();
            if ((absFrameworkFragmentV instanceof MainFragmentContainer) && absFrameworkFragmentV.r() == 0) {
                super.onBackPressed();
                return;
            } else if (absFrameworkFragmentV != null && (fragmentViewBaseX = absFrameworkFragmentV.g().X(absFrameworkFragmentV)) != null) {
                f1 f1VarY = l1.y(this);
                fragmentViewBaseX.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 1, f1VarY.a, f1VarY.b, 0));
                return;
            }
        }
        super.onBackPressed();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // com.kugou.android.watch.lite.base.activity.SwipeBackActivity, com.kugou.android.watch.lite.base.activity.StateFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setTheme(R.style.Theme_YouthWatch_no_swipe_back);
        super.onCreate(bundle);
        w().post(new e(bundle));
        setContentView(u());
        this.f14i.l0(u(), bundle);
    }

    @Override // com.kugou.android.watch.lite.base.other.ViewPagerFrameworkDelegate.i
    public AbsFrameworkFragment onCreateLyricFragment() {
        MainLyricFragment mainLyricFragment = new MainLyricFragment();
        mainLyricFragment.U(this);
        return mainLyricFragment;
    }

    @Override // com.kugou.android.watch.lite.base.other.ViewPagerFrameworkDelegate.i
    public AbsFrameworkFragment onCreateMainFragment() {
        MainFragment mainFragment = new MainFragment();
        mainFragment.U(this);
        return mainFragment;
    }

    @Override // com.kugou.android.watch.lite.base.other.ViewPagerFrameworkDelegate.i
    public AbsFrameworkFragment onCreatePlayerFragment() {
        MainPlayerFragment mainPlayerFragment = new MainPlayerFragment();
        mainPlayerFragment.U(this);
        return mainPlayerFragment;
    }

    @Override // com.kugou.android.watch.lite.base.activity.AbsBaseActivity, com.kugou.android.watch.lite.base.activity.StateFragmentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.kugou.android.watch.lite.base.other.ViewPagerFrameworkDelegate.i
    public void onFinishFragment(int i2) {
        if (g0.a) {
            g0.b("FrameworkActivity", "currentIndex:" + i2);
        }
    }

    @Override // com.kugou.android.watch.lite.base.main.FrameworkContentView.b
    public void onFirstFace() {
        if (g0.a) {
            g0.e("burone-", "onFirstFace ------> yeah !!!");
        }
        w().post(new a());
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new b());
        handler.postDelayed(new c(), 4000L);
    }

    @Override // com.kugou.android.watch.lite.base.other.ViewPagerFrameworkDelegate.i
    public void onFragmentFirstStart() {
    }

    @Override // com.kugou.android.watch.lite.base.other.ViewPagerFrameworkDelegate.i
    public void onKeyBackSlideCallback() {
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (this.f14i.f0() && this.f14i.n0(i2, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyLongPress(int i2, KeyEvent keyEvent) {
        if (this.f14i.o0(i2, keyEvent)) {
            return true;
        }
        return super.onKeyLongPress(i2, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyMultiple(int i2, int i3, KeyEvent keyEvent) {
        if (this.f14i.p0(i2, i3, keyEvent)) {
            return true;
        }
        return super.onKeyMultiple(i2, i3, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (this.f14i.q0(i2, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i2, keyEvent);
    }

    @Override // com.kugou.android.watch.lite.base.other.ViewPagerFrameworkDelegate.i
    public void onNewBundle(Bundle bundle) {
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f14i.r0(intent);
    }

    @Override // com.kugou.android.watch.lite.base.activity.AbsFrameworkActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // com.kugou.android.watch.lite.base.other.ViewPagerFrameworkDelegate.i
    public void onPlayerSlideCallback(boolean z, boolean z2) {
    }

    @Override // com.kugou.android.watch.lite.base.activity.AbsFrameworkActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        if (e.c.a.g.a.d.v.e.b().d()) {
            G();
        } else {
            C();
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        try {
            super.onSaveInstanceState(bundle);
            bundle.clear();
            this.f14i.s0(bundle);
        } catch (Exception e2) {
            g0.k(e2);
        }
    }

    @Override // com.kugou.android.watch.lite.base.other.ViewPagerFrameworkDelegate.i
    public void onSlideToLeftCallback() {
    }

    @Override // com.kugou.android.watch.lite.base.other.ViewPagerFrameworkDelegate.i
    public void onSlideToRightCallback() {
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (e.c.a.g.a.d.v.e.b().d()) {
            H();
        } else {
            D();
        }
    }

    @Override // com.kugou.android.watch.lite.base.activity.AbsFrameworkActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    public ViewGroup t() {
        return u().getAdditionalContainer();
    }

    public FrameworkContentView u() {
        if (this.f12f == null) {
            FrameworkContentView frameworkContentView = new FrameworkContentView(this);
            this.f12f = frameworkContentView;
            frameworkContentView.a(this);
            this.f12f.a(e.c.a.g.a.d.v.e.b());
        }
        return this.f12f;
    }

    public AbsFrameworkFragment v() {
        return this.f14i.V();
    }

    public final Handler w() {
        if (this.f13h == null) {
            this.f13h = new Handler(e.c.a.g.a.d.v.d.a());
        }
        return this.f13h;
    }

    @CallSuper
    public void x() {
        if (t().getChildCount() > 0) {
            t().removeAllViews();
        }
    }

    public void y(@Nullable Bundle bundle) {
        this.f14i.G0(bundle);
        J();
    }

    public void z() {
    }
}
