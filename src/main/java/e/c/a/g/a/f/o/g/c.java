package e.c.a.g.a.f.o.g;

import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.common.widget.loading.CommonLoadingView;
import e.c.a.g.a.s.g0;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class c implements e.c.a.g.a.f.o.g.a {
    public CommonLoadingView a;
    public e c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f720d;
    public int b = e.c.a.g.a.f.o.g.b.b().a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int[] f721e = new int[2];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Runnable f722f = new b();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Runnable f723g = new RunnableC0107c();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public f f724h = new d();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public WeakReference<f> f725i = new WeakReference<>(this.f724h);

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.i();
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.c != null) {
                c.this.c.onSecondaryTrigger();
            }
        }
    }

    /* JADX INFO: renamed from: e.c.a.g.a.f.o.g.c$c, reason: collision with other inner class name */
    public class RunnableC0107c implements Runnable {
        public RunnableC0107c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.c != null) {
                c.this.c.onPrimaryTrigger();
            }
            if (c.this.a == null) {
                return;
            }
            if (c.this.k()) {
                c cVar = c.this;
                cVar.p(cVar.a.getSecondaryText());
            }
            c.this.a.setText(c.this.a.getSecondaryText());
        }
    }

    public class d implements f {
        public d() {
        }

        @Override // e.c.a.g.a.f.o.g.c.f
        public void onPrimaryTrigger() {
            if (g0.f()) {
                g0.e("LoadingPresenter", "onPrimaryTrigger");
            }
            if (c.this.a != null) {
                e.c.a.g.a.f.o.g.b.b().d(c.this.f723g);
            }
        }

        @Override // e.c.a.g.a.f.o.g.c.f
        public void onSecondaryTrigger() {
            if (g0.f()) {
                g0.e("LoadingPresenter", "onSecondaryTrigger");
            }
            if (c.this.a != null) {
                e.c.a.g.a.f.o.g.b.b().d(c.this.f722f);
            }
        }

        @Override // e.c.a.g.a.f.o.g.c.f
        public void onStartTrigger() {
            if (g0.f()) {
                g0.e("LoadingPresenter", "onStartTrigger");
            }
        }
    }

    public interface e extends f {
        @Override // e.c.a.g.a.f.o.g.c.f
        /* synthetic */ void onPrimaryTrigger();

        @Override // e.c.a.g.a.f.o.g.c.f
        /* synthetic */ void onSecondaryTrigger();

        void onStart();

        @Override // e.c.a.g.a.f.o.g.c.f
        /* synthetic */ void onStartTrigger();
    }

    public interface f {
        void onPrimaryTrigger();

        void onSecondaryTrigger();

        void onStartTrigger();
    }

    @Override // e.c.a.g.a.f.o.g.a
    public void attachView(CommonLoadingView commonLoadingView) {
        this.a = commonLoadingView;
    }

    @Override // e.c.a.g.a.f.o.g.a
    public void cancelTimer() {
        q();
    }

    @Override // e.c.a.g.a.f.o.g.a
    public boolean checkLocation() {
        try {
            this.a.getLocationOnScreen(this.f721e);
            h();
            return o();
        } catch (NullPointerException e2) {
            if (!g0.f()) {
                return true;
            }
            g0.k(e2);
            return true;
        }
    }

    public final void h() {
        if (this.f720d) {
            return;
        }
        if ((k() || l() || m()) && n()) {
            i();
        }
    }

    public final void i() {
        this.f720d = true;
        if (g0.f()) {
            g0.e("LoadingPresenter", "enableTimer post a timer!");
        }
        CommonLoadingView commonLoadingView = this.a;
        if (commonLoadingView != null) {
            commonLoadingView.setIconColor(commonLoadingView.getPrimaryColor());
        }
        e.c.a.g.a.f.o.g.b.b().c(this.f725i, this.b);
    }

    public final Rect j(View view) {
        Rect rect = new Rect();
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        view.getDrawingRect(rect);
        rect.offset(-view.getScrollX(), -view.getScrollY());
        rect.offset((int) view.getTranslationX(), (int) view.getTranslationY());
        rect.offset(iArr[0], iArr[1]);
        return rect;
    }

    public final boolean k() {
        return (this.a.getParent() instanceof ViewGroup) && R.id.progress_footer == ((View) this.a.getParent()).getId();
    }

    public final boolean l() {
        return (this.a.getParent() instanceof ViewGroup) && R.id.pull_to_refresh_progress == ((View) this.a.getParent()).getId();
    }

    public final boolean m() {
        int i2 = e.c.a.g.a.f.o.g.b.f717d;
        return Math.abs((i2 - (this.f721e[0] * 2)) - this.a.getWidth()) < (i2 >> 5);
    }

    public final boolean n() {
        CommonLoadingView commonLoadingView = this.a;
        if (commonLoadingView == null) {
            return false;
        }
        Rect rectJ = j(commonLoadingView);
        for (ViewParent parent = this.a.getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof ViewGroup) {
                Rect rectJ2 = j((ViewGroup) parent);
                if (!rectJ2.contains(rectJ) && !rectJ2.intersect(rectJ)) {
                    return false;
                }
            }
        }
        return true;
    }

    public final boolean o() {
        return this.f721e[0] > e.c.a.g.a.f.o.g.b.f717d || this.a.getWidth() + this.f721e[0] < 0;
    }

    public final void p(String str) {
        ViewGroup viewGroup = (ViewGroup) this.a.getParent();
        if (viewGroup != null) {
            ((TextView) viewGroup.findViewById(R.id.progress_info)).setText(str);
        }
    }

    public final void q() {
        this.f720d = false;
        e.c.a.g.a.f.o.g.b.b().f(this.f725i);
        this.a.removeCallbacks(this.f723g);
        this.a.removeCallbacks(this.f722f);
        CommonLoadingView commonLoadingView = this.a;
        commonLoadingView.setText(commonLoadingView.getPrimaryText());
        CommonLoadingView commonLoadingView2 = this.a;
        commonLoadingView2.setIconColor(commonLoadingView2.getPrimaryColor());
        if (k()) {
            p(this.a.getPrimaryText());
        }
    }

    @Override // e.c.a.g.a.f.o.g.a
    public void setTimeSpec(int i2) {
        Log.e("mhs_watch_img", "setTimeSpec: " + i2 + ", mTimeSpec = " + this.b);
        this.b = i2;
    }

    @Override // e.c.a.g.a.f.o.g.a
    public void setTimerCallback(e eVar) {
        this.c = eVar;
    }

    @Override // e.c.a.g.a.f.o.g.a
    public void startAnim() {
        AnimationDrawable anim = this.a.getAnim();
        if (anim != null) {
            q();
            anim.start();
            e eVar = this.c;
            if (eVar != null) {
                eVar.onStart();
            }
        }
    }

    @Override // e.c.a.g.a.f.o.g.a
    public void startAnimWithTimer() {
        startAnim();
        i();
    }

    @Override // e.c.a.g.a.f.o.g.a
    public void startTimer() {
        e.c.a.g.a.f.o.g.b.b().d(new a());
    }

    @Override // e.c.a.g.a.f.o.g.a
    public void stopAnim() {
        q();
        AnimationDrawable anim = this.a.getAnim();
        if (anim != null) {
            if (g0.f()) {
                Log.d("mhs_huawei_rong", "stop, anim.");
            }
            anim.stop();
        }
    }
}
