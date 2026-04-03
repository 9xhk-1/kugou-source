package com.kugou.android.watch.lite.base.uiframe;

import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import androidx.annotation.NonNull;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import com.kugou.android.watch.lite.base.uiframe.FragmentViewBase;

/* JADX INFO: loaded from: classes.dex */
public abstract class FragmentViewSwipeBase extends FragmentViewBase {
    public static int F = 0;
    public static int G = 0;
    public static int H = 0;
    public static int I = 0;
    public static int J = 0;
    public static int K = -1;
    public static boolean L = false;
    public static final Interpolator M = new a();
    public boolean A;
    public boolean B;
    public int C;
    public c D;
    public Runnable E;
    public float t;
    public float u;
    public float v;
    public float w;
    public int x;
    public VelocityTracker y;
    public Scroller z;

    public class a implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FragmentViewSwipeBase fragmentViewSwipeBase = FragmentViewSwipeBase.this;
            fragmentViewSwipeBase.k.onScrollRightFinished(fragmentViewSwipeBase, null);
            FragmentViewSwipeBase.this.p(0, false);
            FragmentViewSwipeBase.this.x = 0;
        }
    }

    public interface c {
        boolean disallowSwipe(float f2, float f3);
    }

    public FragmentViewSwipeBase(@NonNull Context context) {
        super(context);
        this.t = -1.0f;
        this.u = -1.0f;
        this.v = -1.0f;
        this.w = -1.0f;
        this.x = 0;
        this.A = false;
        this.B = false;
        this.C = -1;
        this.E = new b();
        this.y = VelocityTracker.obtain();
        this.z = new Scroller(context, M);
        if (L) {
            return;
        }
        y(context);
        L = true;
    }

    public final boolean A(int i2, int i3) {
        if (this.n == null) {
            return false;
        }
        Rect rect = new Rect();
        for (View view : this.n) {
            view.getVisibility();
            x(rect, view);
            if (rect.contains(i2, i3)) {
                return true;
            }
        }
        return false;
    }

    public final void B(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        this.t = x;
        this.v = x;
        float y = motionEvent.getY();
        this.u = y;
        this.w = y;
        this.C = MotionEventCompat.getPointerId(motionEvent, 0);
        this.B = false;
    }

    public final void C(MotionEvent motionEvent) {
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == this.C) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.v = MotionEventCompat.getX(motionEvent, i2);
            this.C = MotionEventCompat.getPointerId(motionEvent, i2);
            VelocityTracker velocityTracker = this.y;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    public final boolean D(float f2) {
        float scrollX = getScrollX() + (this.v - f2);
        this.v = f2;
        this.v = f2 + (scrollX - ((int) scrollX));
        if (scrollX > 0.0f) {
            scrollX = 0.0f;
        }
        int width = getWidth();
        if (Math.abs(scrollX) >= width) {
            scrollX = -width;
        }
        scrollTo((int) scrollX, getScrollY());
        return false;
    }

    public final void E(float f2) {
        this.y.computeCurrentVelocity(1000, G);
        float xVelocity = this.y.getXVelocity();
        int scrollX = getScrollX();
        int measuredWidth = getMeasuredWidth();
        if (f2 - this.t <= I || Math.abs(xVelocity) <= H) {
            this.x = ((float) Math.abs(scrollX)) / ((float) measuredWidth) > 0.4f ? 1 : 2;
        } else {
            this.x = xVelocity > 0.0f ? 1 : 2;
        }
        int i2 = this.x == 1 ? (-scrollX) - measuredWidth : -scrollX;
        p(2, true);
        if (i2 == 0 && this.x == 2) {
            q(0);
            return;
        }
        FragmentViewBase.d dVar = this.k;
        if (dVar != null && this.x == 1) {
            dVar.onScrollRightStart(this);
        }
        this.z.startScroll(scrollX, 0, i2, 0);
        ViewCompat.postInvalidateOnAnimation(this);
    }

    @Override // android.view.View
    public void computeScroll() {
        if (!this.z.isFinished() && this.z.computeScrollOffset()) {
            scrollTo(this.z.getCurrX(), 0);
            ViewCompat.postInvalidateOnAnimation(this);
            return;
        }
        FragmentViewBase.d dVar = this.k;
        if (dVar != null) {
            int i2 = this.x;
            if (i2 == 2) {
                dVar.onScrollLeftFinished(this);
                p(0, true);
                this.x = 0;
            } else if (i2 == 1) {
                removeCallbacks(this.E);
                post(this.E);
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.f89i || !this.o) {
            return false;
        }
        if (this.m == 2) {
            return true;
        }
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked == 3 || actionMasked == 1) {
            this.A = false;
            this.B = false;
            this.C = -1;
            VelocityTracker velocityTracker = this.y;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.y = null;
            }
            return false;
        }
        if (actionMasked != 0) {
            if (this.A) {
                return true;
            }
            if (this.B) {
                return false;
            }
        }
        if (actionMasked == 0) {
            B(motionEvent);
        } else if (actionMasked == 2) {
            int i2 = this.C;
            if (i2 != -1) {
                int iW = w(motionEvent, i2);
                float x = MotionEventCompat.getX(motionEvent, iW);
                float f2 = x - this.v;
                float fAbs = Math.abs(f2);
                float y = MotionEventCompat.getY(motionEvent, iW);
                float fAbs2 = Math.abs(y - this.u);
                if ((f2 != 0.0f && !z(this.v, f2) && t((int) x, (int) y)) || u(f2, y - this.w)) {
                    this.v = x;
                    this.w = y;
                    this.B = true;
                    return false;
                }
                int i3 = F;
                if (fAbs > i3 && fAbs > fAbs2) {
                    this.A = true;
                    p(1, true);
                    this.v = f2 > 0.0f ? this.t + F : this.t - F;
                    this.w = y;
                } else if (fAbs2 > i3) {
                    this.B = true;
                }
                if (this.A && D(x)) {
                    ViewCompat.postInvalidateOnAnimation(this);
                }
            }
        } else if (actionMasked == 6) {
            C(motionEvent);
        }
        if (this.y == null) {
            this.y = VelocityTracker.obtain();
        }
        this.y.addMovement(motionEvent);
        return this.A;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (K == -1) {
            K = Math.min(getMeasuredWidth() / 10, J);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00c9  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r8) {
        /*
            Method dump skipped, instruction units count: 220
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kugou.android.watch.lite.base.uiframe.FragmentViewSwipeBase.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setRequestSwipe(c cVar) {
        this.D = cVar;
    }

    public final boolean t(int i2, int i3) {
        return A(i2, i3);
    }

    public final boolean u(float f2, float f3) {
        c cVar = this.D;
        return cVar != null && cVar.disallowSwipe(f2, f3);
    }

    public final void v() {
        this.t = -1.0f;
        this.v = -1.0f;
        this.A = false;
        this.B = false;
        this.C = -1;
    }

    public int w(MotionEvent motionEvent, int i2) {
        int iFindPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i2);
        if (iFindPointerIndex == -1) {
            return 0;
        }
        return iFindPointerIndex;
    }

    public final Rect x(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.top = view.getTop();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft() - viewGroup.getScrollX();
            rect.top += viewGroup.getTop() - viewGroup.getScrollY();
            parent = viewGroup.getParent();
        }
        rect.left -= getScrollX();
        rect.top -= getScrollY();
        rect.right = rect.left + view.getWidth();
        rect.bottom = rect.top + view.getHeight();
        return rect;
    }

    public final void y(@NonNull Context context) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f2 = context.getResources().getDisplayMetrics().density;
        F = ViewConfigurationCompat.getScaledPagingTouchSlop(viewConfiguration);
        G = viewConfiguration.getScaledMaximumFlingVelocity();
        H = viewConfiguration.getScaledMinimumFlingVelocity();
        I = (int) (25.0f * f2);
        J = (int) (f2 * 16.0f);
    }

    public final boolean z(float f2, float f3) {
        return (f2 < ((float) K) && f3 > 0.0f) || (f2 > ((float) (getWidth() - K)) && f3 < 0.0f);
    }
}
