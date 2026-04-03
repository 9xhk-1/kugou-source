package com.kugou.android.watch.lite.base.uiframe;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.annotation.NonNull;
import com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment;
import com.kugou.android.watch.lite.base.swipeback.CircleFrameLayout;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class FragmentViewBase extends CircleFrameLayout {
    public static int s = 300;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f89i;
    public boolean j;
    public d k;
    public c l;
    public int m;
    public List<View> n;
    public boolean o;
    public boolean p;
    public boolean q;
    public Runnable r;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FragmentViewBase.super.setVisibility(8);
        }
    }

    public class b implements Animator.AnimatorListener {
        public b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            FragmentViewBase.this.p(0, false);
            FragmentViewBase fragmentViewBase = FragmentViewBase.this;
            d dVar = fragmentViewBase.k;
            if (dVar != null) {
                dVar.onEnterFinished(fragmentViewBase.l);
                FragmentViewBase.this.l = null;
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public static class c {
        public AbsFrameworkFragment a;
        public FragmentViewBase b;
        public FragmentViewBase c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public FragmentViewBase f90d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f91e;

        public c(AbsFrameworkFragment absFrameworkFragment, FragmentViewBase fragmentViewBase, FragmentViewBase fragmentViewBase2, FragmentViewBase fragmentViewBase3, boolean z) {
            this.a = absFrameworkFragment;
            this.b = fragmentViewBase;
            this.c = fragmentViewBase2;
            this.f90d = fragmentViewBase3;
            this.f91e = z;
        }
    }

    public interface d {
        void draggingStateCompact(FragmentViewBase fragmentViewBase, int i2);

        void onEnterFinished(c cVar);

        void onScrollLeftFinished(FragmentViewBase fragmentViewBase);

        void onScrollRightFinished(FragmentViewBase fragmentViewBase, FragmentViewBase fragmentViewBase2);

        void onScrollRightStart(FragmentViewBase fragmentViewBase);

        void onScrollStateChanged(int i2);

        void onScrollStatusChange(float f2);
    }

    public static class e implements Animator.AnimatorListener {
        public final FragmentViewBase a;
        public final FragmentViewBase b;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (e.this.a.k != null) {
                    e.this.a.k.onScrollRightFinished(e.this.a, e.this.b);
                    e.this.a.p(0, false);
                }
            }
        }

        public e(FragmentViewBase fragmentViewBase, FragmentViewBase fragmentViewBase2) {
            this.a = fragmentViewBase;
            this.b = fragmentViewBase2;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            FragmentViewBase fragmentViewBase = this.a;
            if (fragmentViewBase != null) {
                fragmentViewBase.post(new a());
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            FragmentViewBase fragmentViewBase = this.a;
            if (fragmentViewBase != null) {
                fragmentViewBase.p(2, false);
                FragmentViewBase fragmentViewBase2 = this.b;
                fragmentViewBase2.k(fragmentViewBase2);
            }
        }
    }

    public FragmentViewBase(@NonNull Context context) {
        super(context);
        this.f89i = false;
        this.j = false;
        this.l = null;
        this.m = 0;
        this.n = null;
        this.o = true;
        this.p = false;
        this.q = true;
        this.r = new a();
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setWillNotDraw(false);
    }

    public void e(AbsFrameworkFragment absFrameworkFragment, boolean z) {
    }

    public abstract void f(int i2);

    public int g(int i2, int i3, int i4, int i5) {
        return i2;
    }

    public int getScrollTotal() {
        return getWidth();
    }

    public void h() {
        if (this.q) {
            setAlpha(1.0f);
        }
        setScaleX(1.0f);
        setScaleY(1.0f);
        setTranslationX(0.0f);
        ViewPropertyAnimator viewPropertyAnimatorScaleY = e.c.a.g.a.d.b0.b.b().a(this).setDuration(s).scaleX(0.95f).scaleY(0.98f);
        if (this.q) {
            viewPropertyAnimatorScaleY.alpha(0.5f);
        }
        e.c.a.g.a.d.y.b.a(this, viewPropertyAnimatorScaleY);
    }

    public abstract boolean i();

    public abstract void j(FragmentViewBase fragmentViewBase);

    public void k(FragmentViewBase fragmentViewBase) {
    }

    public void l(float f2) {
        if (this.q) {
            setAlpha((f2 * 0.5f) + 0.5f);
        }
        float f3 = (f2 * 0.050000012f) + 0.95f;
        setScaleX(f3);
        setScaleY(f3);
    }

    public abstract void m(int i2, int i3, Bundle bundle);

    @Override // android.view.ViewGroup
    public void measureChildWithMargins(View view, int i2, int i3, int i4, int i5) {
        super.measureChildWithMargins(view, i2, i3, i4, i5);
    }

    public void n() {
        p(2, false);
    }

    public void o() {
        setVisibility(0);
        setScaleX(1.0f);
        setScaleY(1.0f);
        setAlpha(1.0f);
        setTranslationX(0.0f);
        setScrollX(0);
        setRotation(0.0f);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
    }

    @Override // android.view.View
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        super.onScrollChanged(i2, i3, i4, i5);
        if (this.k != null) {
            g(i2, i3, i4, i5);
            this.k.onScrollStatusChange(Math.abs(i2) / getScrollTotal());
        }
    }

    public void p(int i2, boolean z) {
        d dVar;
        if (q(i2) && z && (dVar = this.k) != null) {
            dVar.draggingStateCompact(this, i2);
        }
    }

    public boolean q(int i2) {
        if (this.m == i2) {
            return false;
        }
        this.m = i2;
        d dVar = this.k;
        if (dVar != null) {
            dVar.onScrollStateChanged(i2);
        }
        s(i2 != 0);
        return true;
    }

    public void r() {
        if (this.q) {
            setAlpha(0.5f);
        }
        setScaleX(0.95f);
        setScaleY(0.95f);
        setTranslationX(0.0f);
        ViewPropertyAnimator viewPropertyAnimatorScaleY = e.c.a.g.a.d.b0.b.b().a(this).setDuration(s).scaleX(1.0f).scaleY(1.0f);
        if (this.q) {
            viewPropertyAnimatorScaleY.alpha(1.0f);
        }
        e.c.a.g.a.d.y.b.a(this, viewPropertyAnimatorScaleY);
    }

    public final void s(boolean z) {
        if (!this.j) {
            return;
        }
        int childCount = getChildCount();
        while (true) {
            int i2 = childCount - 1;
            if (childCount <= 0) {
                return;
            }
            getChildAt(i2);
            childCount = i2;
        }
    }

    public void setEnableAlphaAnim(boolean z) {
        this.q = z;
    }

    public void setEnterInfo(c cVar) {
        this.l = cVar;
    }

    public void setIgnoredViews(List<View> list) {
        this.n = list;
    }

    public void setScrollListener(d dVar) {
        this.k = dVar;
    }

    public void setSlidingEnabled(boolean z) {
        this.o = z;
    }

    public void setTop(boolean z) {
        this.f89i = z;
    }

    public void setVerticalSlidingEnabled(boolean z) {
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        removeCallbacks(this.r);
    }
}
