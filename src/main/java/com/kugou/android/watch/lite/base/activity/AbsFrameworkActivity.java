package com.kugou.android.watch.lite.base.activity;

import android.content.DialogInterface;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.other.ViewPagerFrameworkDelegate;

/* JADX INFO: loaded from: classes.dex */
public class AbsFrameworkActivity extends StateFragmentActivity {
    public e.c.a.g.a.f.o.b a;
    public HandlerThread b;

    public class a implements Runnable {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ boolean b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f8d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ DialogInterface.OnKeyListener f9f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ DialogInterface.OnDismissListener f10h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ int f11i;
        public final /* synthetic */ int j;

        public a(boolean z, boolean z2, String str, DialogInterface.OnKeyListener onKeyListener, DialogInterface.OnDismissListener onDismissListener, int i2, int i3) {
            this.a = z;
            this.b = z2;
            this.f8d = str;
            this.f9f = onKeyListener;
            this.f10h = onDismissListener;
            this.f11i = i2;
            this.j = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            AbsFrameworkActivity absFrameworkActivity = AbsFrameworkActivity.this;
            if (absFrameworkActivity.a == null) {
                absFrameworkActivity.a = new e.c.a.g.a.f.o.b(AbsFrameworkActivity.this);
            }
            AbsFrameworkActivity.this.a.setCancelable(this.a);
            AbsFrameworkActivity.this.a.setCanceledOnTouchOutside(this.b);
            AbsFrameworkActivity.this.a.c(this.f8d);
            AbsFrameworkActivity.this.a.setOnKeyListener(this.f9f);
            AbsFrameworkActivity.this.a.setOnDismissListener(this.f10h);
            AbsFrameworkActivity.this.a.e(this.f11i);
            AbsFrameworkActivity.this.a.f(this.j);
            if (!AbsFrameworkActivity.this.isFinishing() && !AbsFrameworkActivity.this.a.isShowing()) {
                AbsFrameworkActivity.this.a.show();
            }
            AbsFrameworkActivity.this.k(AbsFrameworkActivity.this.a.getWindow().getDecorView());
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.c.a.g.a.f.o.b bVar = AbsFrameworkActivity.this.a;
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.c.a.g.a.f.o.b bVar = AbsFrameworkActivity.this.a;
            if (bVar == null || !bVar.isShowing()) {
                return;
            }
            try {
                AbsFrameworkActivity.this.a.dismiss();
            } catch (Exception unused) {
            }
        }
    }

    public void c() {
        runOnUiThread(new b());
    }

    public void d() {
        runOnUiThread(new c());
    }

    public boolean e() {
        return false;
    }

    public ViewPagerFrameworkDelegate f() {
        return null;
    }

    public Looper g() {
        if (this.b == null) {
            HandlerThread handlerThread = new HandlerThread(getClass().getName(), h());
            this.b = handlerThread;
            handlerThread.start();
        }
        return this.b.getLooper();
    }

    public int h() {
        return 10;
    }

    public final void i() {
        View decorView;
        Window window = getWindow();
        if (window == null || (decorView = window.getDecorView()) == null) {
            return;
        }
        e.c.a.g.a.d.w.a.a(getClass(), decorView);
    }

    public boolean j() {
        e.c.a.g.a.f.o.b bVar = this.a;
        return bVar != null && bVar.isShowing();
    }

    public void k(View view) {
        if (!(view instanceof ViewGroup)) {
            if (view instanceof TextView) {
                ((TextView) view).setTextSize(2, 16.0f);
            }
        } else {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                k(viewGroup.getChildAt(i2));
            }
        }
    }

    public void l(int i2) {
        if (e() && this.a != null) {
            Log.d("mhs_watch_img", "setLoadingTimeOut, 重新设置超时逻辑");
            this.a.d(i2);
        }
    }

    public void m(int i2, DialogInterface.OnKeyListener onKeyListener) {
        q(false, true, getString(i2), -1, 41, onKeyListener, null);
        c();
    }

    public void n(int i2, int i3) {
        q(true, false, getString(R.string.waiting), i2, i3, null, null);
    }

    public void o(int i2, int i3, boolean z) {
        q(true, z, getString(R.string.waiting), i2, i3, null, null);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    public void p(int i2, int i3, boolean z, String str) {
        q(true, z, str, i2, i3, null, null);
    }

    public final void q(boolean z, boolean z2, String str, int i2, int i3, DialogInterface.OnKeyListener onKeyListener, DialogInterface.OnDismissListener onDismissListener) {
        runOnUiThread(new a(z, z2, str, onKeyListener, onDismissListener, i3, i2));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i2) {
        super.setContentView(i2);
        i();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view) {
        super.setContentView(view);
        i();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        i();
    }
}
