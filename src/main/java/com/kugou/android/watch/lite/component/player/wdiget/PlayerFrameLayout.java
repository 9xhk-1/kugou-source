package com.kugou.android.watch.lite.component.player.wdiget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public class PlayerFrameLayout extends FrameLayout {
    public boolean a;
    public int b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f170d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f171f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public VelocityTracker f172h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f173i;
    public OverScroller j;
    public int k;
    public int l;
    public int m;
    public int n;
    public final int[] o;
    public final int[] p;
    public int q;
    public EdgeEffect r;
    public EdgeEffect s;
    public int t;
    public int u;

    public PlayerFrameLayout(@NonNull Context context) {
        this(context, null);
    }

    private int getScrollRange() {
        if (getChildCount() > 0) {
            return Math.max(0, getChildAt(0).getHeight() - ((getHeight() - this.m) - this.n));
        }
        return 0;
    }

    public final void a() {
        this.a = false;
        i();
        if (j()) {
            this.r.onRelease();
            this.s.onRelease();
        }
    }

    public void b(int i2) {
        if (getChildCount() > 0) {
            int height = (getHeight() - this.m) - this.n;
            this.j.fling(this.k, this.l, 0, i2, 0, 0, 0, Math.max(0, getChildAt(0).getHeight() - height), 0, height / 2);
            postInvalidateOnAnimation();
        }
    }

    public final void c(int i2) {
        int i3 = this.l;
        boolean z = (i3 > 0 || i2 > 0) && (i3 < getScrollRange() || i2 < 0);
        if (Build.VERSION.SDK_INT >= 21) {
            float f2 = i2;
            if (dispatchNestedPreFling(0.0f, f2)) {
                return;
            }
            dispatchNestedFling(0.0f, f2, z);
            if (z) {
                b(i2);
            }
        }
    }

    public final boolean d(int i2, int i3) {
        if (getChildCount() <= 0) {
            return false;
        }
        int i4 = this.l;
        View childAt = getChildAt(0);
        return i3 >= childAt.getTop() - i4 && i3 < childAt.getBottom() - i4 && i2 >= childAt.getLeft() && i2 < childAt.getRight();
    }

    public final void e() {
        VelocityTracker velocityTracker = this.f172h;
        if (velocityTracker == null) {
            this.f172h = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    public final void f() {
        if (this.f172h == null) {
            this.f172h = VelocityTracker.obtain();
        }
    }

    public final void g() {
        setFocusable(true);
        this.j = new OverScroller(getContext());
    }

    public final void h(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & 65280) >> 8;
        if (motionEvent.getPointerId(action) == this.b) {
            int i2 = action == 0 ? 1 : 0;
            this.f170d = (int) motionEvent.getY(i2);
            this.b = motionEvent.getPointerId(i2);
            VelocityTracker velocityTracker = this.f172h;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    public final void i() {
        VelocityTracker velocityTracker = this.f172h;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f172h = null;
        }
    }

    public final boolean j() {
        return getOverScrollMode() != 2;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0090  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r12) {
        /*
            Method dump skipped, instruction units count: 243
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kugou.android.watch.lite.component.player.wdiget.PlayerFrameLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        f();
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f173i = 0;
        }
        motionEventObtain.offsetLocation(0.0f, this.f173i);
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int iFindPointerIndex = motionEvent.findPointerIndex(this.b);
                    if (iFindPointerIndex == -1) {
                        Log.e("PlayerFrameLayout", "Invalid pointerId=" + this.b + " in onTouchEvent");
                    } else {
                        int y = (int) motionEvent.getY(iFindPointerIndex);
                        int i7 = this.f170d - y;
                        int i8 = Build.VERSION.SDK_INT;
                        if (i8 >= 21 && dispatchNestedPreScroll(0, i7, this.p, this.o)) {
                            i7 -= this.p[1];
                            motionEventObtain.offsetLocation(0.0f, this.o[1]);
                            this.f173i += this.o[1];
                        }
                        if (!this.a && Math.abs(i7) > this.f171f) {
                            ViewParent parent2 = getParent();
                            if (parent2 != null) {
                                parent2.requestDisallowInterceptTouchEvent(true);
                            }
                            this.a = true;
                            i7 = i7 > 0 ? i7 - this.f171f : i7 + this.f171f;
                        }
                        int i9 = i7;
                        if (this.a) {
                            this.f170d = y - this.o[1];
                            int i10 = this.l;
                            int scrollRange = getScrollRange();
                            int overScrollMode = getOverScrollMode();
                            boolean z = overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0);
                            if (i8 >= 21) {
                                i2 = scrollRange;
                                i3 = i10;
                                i4 = i9;
                                i5 = i8;
                                i6 = iFindPointerIndex;
                                if (overScrollBy(0, i9, 0, this.l, 0, i2, 0, this.q, true) && !hasNestedScrollingParent()) {
                                    this.f172h.clear();
                                }
                            } else {
                                i2 = scrollRange;
                                i3 = i10;
                                i4 = i9;
                                i5 = i8;
                                i6 = iFindPointerIndex;
                            }
                            int i11 = this.l - i3;
                            int i12 = i4 - i11;
                            if (i5 >= 21) {
                                if (dispatchNestedScroll(0, i11, 0, i12, this.o)) {
                                    this.f170d = this.f170d - this.o[1];
                                    motionEventObtain.offsetLocation(0.0f, r1[1]);
                                    this.f173i += this.o[1];
                                } else if (z) {
                                    int i13 = i3 + i4;
                                    if (i13 < 0) {
                                        this.r.onPull(i4 / getHeight(), motionEvent.getX(i6) / getWidth());
                                        if (!this.s.isFinished()) {
                                            this.s.onRelease();
                                        }
                                    } else {
                                        int i14 = i6;
                                        if (i13 > i2) {
                                            this.s.onPull(i4 / getHeight(), 1.0f - (motionEvent.getX(i14) / getWidth()));
                                            if (!this.r.isFinished()) {
                                                this.r.onRelease();
                                            }
                                        }
                                    }
                                    if (j() && (!this.r.isFinished() || !this.s.isFinished())) {
                                        postInvalidateOnAnimation();
                                    }
                                }
                            }
                        }
                    }
                } else if (actionMasked != 3) {
                    if (actionMasked == 5) {
                        int actionIndex = motionEvent.getActionIndex();
                        this.f170d = (int) motionEvent.getY(actionIndex);
                        this.b = motionEvent.getPointerId(actionIndex);
                    } else if (actionMasked == 6) {
                        h(motionEvent);
                        this.f170d = (int) motionEvent.getY(motionEvent.findPointerIndex(this.b));
                    }
                } else if (this.a && getChildCount() > 0) {
                    if (this.j.springBack(this.k, this.l, 0, 0, 0, getScrollRange())) {
                        postInvalidateOnAnimation();
                    }
                    this.b = -1;
                    a();
                }
            } else if (this.a) {
                VelocityTracker velocityTracker = this.f172h;
                velocityTracker.computeCurrentVelocity(1000, this.u);
                int yVelocity = (int) velocityTracker.getYVelocity(this.b);
                if (Math.abs(yVelocity) > this.t) {
                    c(-yVelocity);
                } else if (this.j.springBack(this.k, this.l, 0, 0, 0, getScrollRange())) {
                    postInvalidateOnAnimation();
                }
                this.b = -1;
                a();
            }
        } else {
            if (getChildCount() == 0) {
                return false;
            }
            boolean z2 = !this.j.isFinished();
            this.a = z2;
            if (z2 && (parent = getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            if (!this.j.isFinished()) {
                this.j.abortAnimation();
            }
            this.f170d = (int) motionEvent.getY();
            this.b = motionEvent.getPointerId(0);
            if (Build.VERSION.SDK_INT >= 21) {
                startNestedScroll(2);
            }
        }
        VelocityTracker velocityTracker2 = this.f172h;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(motionEventObtain);
        }
        motionEventObtain.recycle();
        return true;
    }

    public PlayerFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PlayerFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = false;
        this.b = -1;
        this.o = new int[2];
        this.p = new int[2];
        this.r = new EdgeEffect(getContext());
        this.s = new EdgeEffect(getContext());
        g();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f171f = viewConfiguration.getScaledTouchSlop();
        this.t = viewConfiguration.getScaledMinimumFlingVelocity();
        this.u = viewConfiguration.getScaledMaximumFlingVelocity();
        this.q = viewConfiguration.getScaledOverscrollDistance();
    }
}
