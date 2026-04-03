package e.c.a.g.a.d.a0;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.VelocityTrackerCompat;
import androidx.core.widget.ScrollerCompat;
import com.kugou.common.network.AbsHttpClient;
import e.c.a.g.a.s.g0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class d {
    public static final Interpolator y = new a();
    public int a;
    public int b;
    public double c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float[] f364e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float[] f365f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float[] f366g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float[] f367h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int[] f368i;
    public int[] j;
    public int[] k;
    public int l;
    public VelocityTracker m;
    public float n;
    public float o;
    public int p;
    public int q;
    public ScrollerCompat r;
    public final c s;
    public View t;
    public boolean u;
    public final ViewGroup v;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f363d = -1;
    public boolean w = false;
    public final Runnable x = new b();

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
            d.this.G(0);
        }
    }

    public static abstract class c {
        public abstract int a(View view, int i2, int i3);

        public abstract int b(View view, int i2, int i3);

        public int c(int i2) {
            return i2;
        }

        public abstract int d(View view);

        public abstract int e(View view);

        public void f(int i2, int i3) {
        }

        public boolean g(int i2) {
            return false;
        }

        public void h(int i2, int i3) {
        }

        public void i(View view, int i2) {
        }

        public void j(int i2) {
        }

        public void k(View view, int i2, int i3, int i4, int i5) {
        }

        public abstract void l(View view, float f2, float f3);

        public abstract boolean m(View view, int i2);
    }

    public d(Context context, ViewGroup viewGroup, c cVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (cVar == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.v = viewGroup;
        this.s = cVar;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.p = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.b = viewConfiguration.getScaledTouchSlop();
        this.n = viewConfiguration.getScaledMaximumFlingVelocity();
        this.o = viewConfiguration.getScaledMinimumFlingVelocity();
        this.r = ScrollerCompat.create(context, y);
    }

    public static d m(ViewGroup viewGroup, c cVar) {
        return new d(viewGroup.getContext(), viewGroup, cVar);
    }

    public final void A() {
        this.m.computeCurrentVelocity(1000, this.n);
        float f2 = f(VelocityTrackerCompat.getXVelocity(this.m, this.f363d), this.o, this.n);
        float f3 = f(VelocityTrackerCompat.getYVelocity(this.m, this.f363d), this.o, this.n);
        if (f2 < Math.abs(f3)) {
            f2 = 0.0f;
        }
        n(f2, f3);
    }

    public final void B(float f2, float f3, int i2) {
        int i3 = d(f2, f3, i2, 1) ? 1 : 0;
        if (d(f3, f2, i2, 4)) {
            i3 |= 4;
        }
        if (d(f2, f3, i2, 2)) {
            i3 |= 2;
        }
        if (d(f3, f2, i2, 8)) {
            i3 |= 8;
        }
        if (i3 != 0) {
            int[] iArr = this.j;
            iArr[i2] = iArr[i2] | i3;
            this.s.f(i3, i2);
        }
    }

    public final void C(float f2, float f3, int i2) {
        q(i2);
        float[] fArr = this.f364e;
        this.f366g[i2] = f2;
        fArr[i2] = f2;
        float[] fArr2 = this.f365f;
        this.f367h[i2] = f3;
        fArr2[i2] = f3;
        this.f368i[i2] = t((int) f2, (int) f3);
        this.l |= 1 << i2;
    }

    public final void D(MotionEvent motionEvent) {
        int pointerCount = MotionEventCompat.getPointerCount(motionEvent);
        if (O() && (this.f366g == null || this.f367h == null)) {
            return;
        }
        for (int i2 = 0; i2 < pointerCount; i2++) {
            int pointerId = MotionEventCompat.getPointerId(motionEvent, i2);
            float x = MotionEventCompat.getX(motionEvent, i2);
            float y2 = MotionEventCompat.getY(motionEvent, i2);
            this.f366g[pointerId] = x;
            this.f367h[pointerId] = y2;
        }
    }

    public void E(boolean z) {
        this.w = z;
    }

    public void F(double d2) {
    }

    public void G(int i2) {
        if (this.a != i2) {
            this.a = i2;
            this.s.j(i2);
            if (i2 == 0) {
                this.t = null;
            }
        }
    }

    public void H(double d2) {
        this.c = d2;
    }

    public void I(int i2) {
        this.p = i2;
    }

    public void J(int i2) {
        this.q = i2;
    }

    public void K(float f2) {
        this.o = f2;
    }

    public boolean L(int i2, int i3) {
        if (this.u) {
            return s(i2, i3, (int) VelocityTrackerCompat.getXVelocity(this.m, this.f363d), (int) VelocityTrackerCompat.getYVelocity(this.m, this.f363d));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00c1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean M(android.view.MotionEvent r11) {
        /*
            Method dump skipped, instruction units count: 251
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.a.g.a.d.a0.d.M(android.view.MotionEvent):boolean");
    }

    public boolean N(View view, int i2) {
        if (view == this.t && this.f363d == i2) {
            return true;
        }
        if (view == null || !this.s.m(view, i2)) {
            return false;
        }
        this.f363d = i2;
        c(view, i2);
        return true;
    }

    public boolean O() {
        return false;
    }

    public void a() {
        b();
        if (this.a == 2) {
            int currX = this.r.getCurrX();
            int currY = this.r.getCurrY();
            this.r.abortAnimation();
            int currX2 = this.r.getCurrX();
            int currY2 = this.r.getCurrY();
            this.s.k(this.t, currX2, currY2, currX2 - currX, currY2 - currY);
        }
        G(0);
    }

    public void b() {
        this.f363d = -1;
        h();
        VelocityTracker velocityTracker = this.m;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.m = null;
        }
    }

    public void c(View view, int i2) {
        if (view.getParent() == this.v) {
            this.t = view;
            this.f363d = i2;
            this.s.i(view, i2);
            G(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.v + ")");
    }

    public final boolean d(float f2, float f3, int i2, int i3) {
        float fAbs = Math.abs(f2);
        float fAbs2 = Math.abs(f3);
        if ((this.f368i[i2] & i3) != i3 || (this.q & i3) == 0 || (this.k[i2] & i3) == i3 || (this.j[i2] & i3) == i3) {
            return false;
        }
        int i4 = this.b;
        if (fAbs <= i4 && fAbs2 <= i4) {
            return false;
        }
        if (fAbs >= fAbs2 * 0.5f || !this.s.g(i3)) {
            return (this.j[i2] & i3) == 0 && fAbs > ((float) this.b);
        }
        int[] iArr = this.k;
        iArr[i2] = iArr[i2] | i3;
        return false;
    }

    public final boolean e(View view, float f2, float f3) {
        if (view == null) {
            return false;
        }
        boolean z = this.s.d(view) > 0;
        boolean z2 = this.s.e(view) > 0;
        float fAbs = Math.abs(f3);
        float fAbs2 = Math.abs(f2);
        int i2 = this.b;
        return (fAbs2 > ((float) i2) || fAbs > ((float) i2)) ? fAbs2 > fAbs * 2.0f : (z && z2) ? (f2 * f2) + (f3 * f3) > ((float) (i2 * i2)) : z ? Math.abs(f2) > ((float) this.b) : z2 && Math.abs(f3) > ((float) this.b);
    }

    public final float f(float f2, float f3, float f4) {
        float fAbs = Math.abs(f2);
        if (fAbs < f3) {
            return 0.0f;
        }
        return fAbs > f4 ? f2 > 0.0f ? f4 : -f4 : f2;
    }

    public final int g(int i2, int i3, int i4) {
        int iAbs = Math.abs(i2);
        if (iAbs < i3) {
            return 0;
        }
        return iAbs > i4 ? i2 > 0 ? i4 : -i4 : i2;
    }

    public final void h() {
        float[] fArr = this.f364e;
        if (fArr == null) {
            return;
        }
        Arrays.fill(fArr, 0.0f);
        Arrays.fill(this.f365f, 0.0f);
        Arrays.fill(this.f366g, 0.0f);
        Arrays.fill(this.f367h, 0.0f);
        Arrays.fill(this.f368i, 0);
        Arrays.fill(this.j, 0);
        Arrays.fill(this.k, 0);
        this.l = 0;
    }

    public final void i(int i2) {
        try {
            float[] fArr = this.f364e;
            if (fArr == null) {
                return;
            }
            fArr[i2] = 0.0f;
            this.f365f[i2] = 0.0f;
            this.f366g[i2] = 0.0f;
            this.f367h[i2] = 0.0f;
            this.f368i[i2] = 0;
            this.j[i2] = 0;
            this.k[i2] = 0;
            this.l = ((1 << i2) ^ (-1)) & this.l;
        } catch (Exception e2) {
            g0.k(e2);
        }
    }

    public final int j(int i2, int i3, int i4) {
        if (i2 == 0 || i4 == 0) {
            return 0;
        }
        int width = this.v.getWidth();
        float f2 = width / 2;
        float fO = f2 + (o(Math.min(1.0f, Math.abs(i2) / width)) * f2);
        int iAbs = Math.abs(i3);
        return Math.min(iAbs > 0 ? Math.round(Math.abs(fO / iAbs) * 1000.0f) * 4 : (int) (((Math.abs(i2) / i4) + 1.0f) * 256.0f), AbsHttpClient.SC_PRIVATE);
    }

    public final int k(View view, int i2, int i3, int i4, int i5) {
        float f2;
        float f3;
        float f4;
        float f5;
        int iG = g(i4, (int) this.o, (int) this.n);
        int iG2 = g(i5, (int) this.o, (int) this.n);
        int iAbs = Math.abs(i2);
        int iAbs2 = Math.abs(i3);
        int iAbs3 = Math.abs(iG);
        int iAbs4 = Math.abs(iG2);
        int i6 = iAbs3 + iAbs4;
        int i7 = iAbs + iAbs2;
        if (iG != 0) {
            f2 = iAbs3;
            f3 = i6;
        } else {
            f2 = iAbs;
            f3 = i7;
        }
        float f6 = f2 / f3;
        if (iG2 != 0) {
            f4 = iAbs4;
            f5 = i6;
        } else {
            f4 = iAbs2;
            f5 = i7;
        }
        return (int) ((j(i2, iG, this.s.d(view)) * f6) + (j(i3, iG2, this.s.e(view)) * (f4 / f5)));
    }

    public boolean l(boolean z) {
        if (this.a == 2) {
            boolean zComputeScrollOffset = this.r.computeScrollOffset();
            int currX = this.r.getCurrX();
            int currY = this.r.getCurrY();
            int left = currX - this.t.getLeft();
            int top = currY - this.t.getTop();
            if (left != 0) {
                this.t.offsetLeftAndRight(left);
            }
            if (top != 0) {
                this.t.offsetTopAndBottom(top);
            }
            if (left != 0 || top != 0) {
                this.s.k(this.t, currX, currY, left, top);
            }
            if (zComputeScrollOffset && currX == this.r.getFinalX() && currY == this.r.getFinalY()) {
                this.r.abortAnimation();
                zComputeScrollOffset = this.r.isFinished();
            }
            if (!zComputeScrollOffset) {
                if (z) {
                    this.v.post(this.x);
                } else {
                    G(0);
                }
            }
        }
        return this.a == 2;
    }

    public final void n(float f2, float f3) {
        this.u = true;
        this.s.l(this.t, f2, f3);
        this.u = false;
        if (this.a == 1) {
            G(0);
        }
    }

    public final float o(float f2) {
        Double.isNaN(f2 - 0.5f);
        return (float) Math.sin((float) (r0 * 0.4712389167638204d));
    }

    public final void p(int i2, int i3, int i4, int i5) {
        int left = this.t.getLeft();
        int top = this.t.getTop();
        if (i4 != 0) {
            i2 = this.s.a(this.t, i2, i4);
            this.t.offsetLeftAndRight(i2 - left);
        }
        int i6 = i2;
        if (i5 != 0) {
            i3 = this.s.b(this.t, i3, i5);
            this.t.offsetTopAndBottom(i3 - top);
        }
        int i7 = i3;
        if (i4 == 0 && i5 == 0) {
            return;
        }
        int i8 = i6 - left;
        int i9 = i7 - top;
        if (i9 == 0) {
            this.s.k(this.t, i6, i7, i8, i9);
        } else {
            if (i8 == 0 || Math.abs(i9) / Math.abs(i8) >= this.c) {
                return;
            }
            this.s.k(this.t, i6, i7, i8, i9);
        }
    }

    public final void q(int i2) {
        float[] fArr = this.f364e;
        if (fArr == null || fArr.length <= i2) {
            int i3 = i2 + 1;
            float[] fArr2 = new float[i3];
            float[] fArr3 = new float[i3];
            float[] fArr4 = new float[i3];
            float[] fArr5 = new float[i3];
            int[] iArr = new int[i3];
            int[] iArr2 = new int[i3];
            int[] iArr3 = new int[i3];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.f365f;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f366g;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.f367h;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.f368i;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.j;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.k;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f364e = fArr2;
            this.f365f = fArr3;
            this.f366g = fArr4;
            this.f367h = fArr5;
            this.f368i = iArr;
            this.j = iArr2;
            this.k = iArr3;
        }
    }

    public View r(int i2, int i3) {
        for (int childCount = this.v.getChildCount() - 1; childCount >= 0; childCount--) {
            ViewGroup viewGroup = this.v;
            this.s.c(childCount);
            View childAt = viewGroup.getChildAt(childCount);
            if (i2 >= childAt.getLeft() && i2 < childAt.getRight() && i3 >= childAt.getTop() && i3 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public final boolean s(int i2, int i3, int i4, int i5) {
        int left = this.t.getLeft();
        int top = this.t.getTop();
        int i6 = i2 - left;
        int i7 = i3 - top;
        if (i6 == 0 && i7 == 0) {
            this.r.abortAnimation();
            G(0);
            return false;
        }
        this.r.startScroll(left, top, i6, i7, k(this.t, i6, i7, i4, i5));
        G(2);
        return true;
    }

    public final int t(int i2, int i3) {
        int i4 = (this.w || i2 < this.v.getLeft() + this.p) ? 1 : 0;
        if (this.w || i3 < this.v.getTop() + this.p) {
            i4 |= 4;
        }
        if (this.w || i2 > this.v.getRight() - this.p) {
            i4 |= 2;
        }
        return (this.w || i3 > this.v.getBottom() - this.p) ? i4 | 8 : i4;
    }

    public int u() {
        return this.a;
    }

    public boolean v(int i2, int i3) {
        return y(this.t, i2, i3);
    }

    public boolean w(int i2, int i3) {
        return x(i3) && (i2 & this.f368i[i3]) != 0;
    }

    public boolean x(int i2) {
        return ((1 << i2) & this.l) != 0;
    }

    public boolean y(View view, int i2, int i3) {
        return view != null && i2 >= view.getLeft() && i2 < view.getRight() && i3 >= view.getTop() && i3 < view.getBottom();
    }

    public void z(MotionEvent motionEvent) {
        int i2;
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (actionMasked == 0) {
            b();
        }
        if (this.m == null) {
            this.m = VelocityTracker.obtain();
        }
        this.m.addMovement(motionEvent);
        int i3 = 0;
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y2 = motionEvent.getY();
            int pointerId = MotionEventCompat.getPointerId(motionEvent, 0);
            View viewR = r((int) x, (int) y2);
            C(x, y2, pointerId);
            N(viewR, pointerId);
            int i4 = this.f368i[pointerId];
            int i5 = this.q;
            if ((i4 & i5) != 0) {
                this.s.h(i4 & i5, pointerId);
                return;
            }
            return;
        }
        if (actionMasked == 1) {
            if (this.a == 1) {
                A();
            }
            b();
            return;
        }
        if (actionMasked == 2) {
            if (this.a == 1) {
                int iFindPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, this.f363d);
                float x2 = MotionEventCompat.getX(motionEvent, iFindPointerIndex);
                float y3 = MotionEventCompat.getY(motionEvent, iFindPointerIndex);
                if (O() && (this.f366g == null || this.f367h == null)) {
                    return;
                }
                float[] fArr = this.f366g;
                int i6 = this.f363d;
                int i7 = (int) (x2 - fArr[i6]);
                int i8 = (int) (y3 - this.f367h[i6]);
                if (Math.abs(i7) > Math.abs(i8 * 2)) {
                    p(this.t.getLeft() + i7, this.t.getTop() + i8, i7, i8);
                }
                D(motionEvent);
                return;
            }
            int pointerCount = MotionEventCompat.getPointerCount(motionEvent);
            while (i3 < pointerCount) {
                int pointerId2 = MotionEventCompat.getPointerId(motionEvent, i3);
                float x3 = MotionEventCompat.getX(motionEvent, i3);
                float y4 = MotionEventCompat.getY(motionEvent, i3);
                float f2 = x3 - this.f364e[pointerId2];
                float f3 = y4 - this.f365f[pointerId2];
                B(f2, f3, pointerId2);
                if (this.a != 1) {
                    View viewR2 = r((int) x3, (int) y4);
                    if (e(viewR2, f2, f3) && N(viewR2, pointerId2)) {
                        break;
                    } else {
                        i3++;
                    }
                } else {
                    break;
                }
            }
            D(motionEvent);
            return;
        }
        if (actionMasked == 3) {
            if (this.a == 1) {
                n(0.0f, 0.0f);
            }
            b();
            return;
        }
        if (actionMasked == 5) {
            int pointerId3 = MotionEventCompat.getPointerId(motionEvent, actionIndex);
            float x4 = MotionEventCompat.getX(motionEvent, actionIndex);
            float y5 = MotionEventCompat.getY(motionEvent, actionIndex);
            C(x4, y5, pointerId3);
            if (this.a != 0) {
                if (v((int) x4, (int) y5)) {
                    N(this.t, pointerId3);
                    return;
                }
                return;
            } else {
                N(r((int) x4, (int) y5), pointerId3);
                int i9 = this.f368i[pointerId3];
                int i10 = this.q;
                if ((i9 & i10) != 0) {
                    this.s.h(i9 & i10, pointerId3);
                    return;
                }
                return;
            }
        }
        if (actionMasked != 6) {
            return;
        }
        int pointerId4 = MotionEventCompat.getPointerId(motionEvent, actionIndex);
        if (this.a == 1 && pointerId4 == this.f363d) {
            int pointerCount2 = MotionEventCompat.getPointerCount(motionEvent);
            while (true) {
                if (i3 >= pointerCount2) {
                    i2 = -1;
                    break;
                }
                int pointerId5 = MotionEventCompat.getPointerId(motionEvent, i3);
                if (pointerId5 != this.f363d) {
                    View viewR3 = r((int) MotionEventCompat.getX(motionEvent, i3), (int) MotionEventCompat.getY(motionEvent, i3));
                    View view = this.t;
                    if (viewR3 == view && N(view, pointerId5)) {
                        i2 = this.f363d;
                        break;
                    }
                }
                i3++;
            }
            if (i2 == -1) {
                A();
            }
        }
        i(pointerId4);
    }
}
