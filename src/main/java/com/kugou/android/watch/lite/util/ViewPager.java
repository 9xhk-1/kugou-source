package com.kugou.android.watch.lite.util;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
import android.widget.Scroller;
import androidx.core.os.ParcelableCompat;
import androidx.core.os.ParcelableCompatCreatorCallbacks;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.VelocityTrackerCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.viewpager.widget.PagerAdapter;
import com.kugou.android.watch.lite.base.application.KGApplication;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.h1;
import e.c.a.g.a.s.l1;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import org.apache.http.HttpStatus;

/* JADX INFO: loaded from: classes2.dex */
public class ViewPager extends ViewGroup {
    public static float D0 = 0.95f;
    public static float E0 = 0.5f;
    public static boolean F0 = true;
    public boolean A;
    public boolean B;
    public int C;
    public boolean D;
    public boolean E;
    public int F;
    public int G;
    public int H;
    public float I;
    public float J;
    public float K;
    public float L;
    public int M;
    public VelocityTracker N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public boolean S;
    public boolean T;
    public boolean U;
    public int V;
    public g W;
    public int a;
    public g a0;
    public Boolean b;
    public e b0;
    public f c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f236d;
    public h d0;
    public Method e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f237f;
    public int f0;
    public ArrayList<View> g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList<d> f238h;
    public final Runnable h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final d f239i;
    public int i0;
    public final Rect j;
    public boolean j0;
    public PagerAdapter k;
    public boolean k0;
    public int l;
    public ArrayList<View> l0;
    public int m;
    public Drawable m0;
    public Parcelable n;
    public Drawable n0;
    public ClassLoader o;
    public int o0;
    public Scroller p;
    public int p0;
    public i q;
    public int q0;
    public int r;
    public Matrix r0;
    public Drawable s;
    public Matrix s0;
    public int t;
    public RectF t0;
    public int u;
    public RectF u0;
    public float v;
    public float v0;
    public float w;
    public float w0;
    public int x;
    public int x0;
    public boolean y;
    public int y0;
    public boolean z;
    public static final int[] z0 = {R.attr.layout_gravity};
    public static final Comparator<d> A0 = new a();
    public static final Interpolator B0 = new b();
    public static final k C0 = new k();

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = ParcelableCompat.newCreator(new a());
        public int a;
        public Parcelable b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ClassLoader f243d;

        public class a implements ParcelableCompatCreatorCallbacks<SavedState> {
            @Override // androidx.core.os.ParcelableCompatCreatorCallbacks
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // androidx.core.os.ParcelableCompatCreatorCallbacks
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.a + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.a);
            parcel.writeParcelable(this.b, i2);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.a = parcel.readInt();
            this.b = parcel.readParcelable(classLoader);
            this.f243d = classLoader;
        }
    }

    public class a implements Comparator<d> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(d dVar, d dVar2) {
            return dVar.b - dVar2.b;
        }
    }

    public class b implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewPager.this.setScrollState(0);
            ViewPager.this.H();
        }
    }

    public static class d {
        public Object a;
        public int b;
        public boolean c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f244d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f245e;
    }

    public interface e {
        void onAdapterChanged(PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2);
    }

    public interface f {
        boolean onLayerChange(int i2);
    }

    public interface g {
        void onPageScrollStateChanged(int i2);

        void onPageScrolled(int i2, float f2, int i3);

        void onPageSelected(int i2, boolean z);

        void onPageSelectedAfterAnimation(int i2);
    }

    public interface h {
        void transformPage(View view, float f2);
    }

    public class i extends DataSetObserver {
        public i() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            ViewPager.this.k();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ViewPager.this.k();
        }

        public /* synthetic */ i(ViewPager viewPager, a aVar) {
            this();
        }
    }

    public static class j implements g {
        @Override // com.kugou.android.watch.lite.util.ViewPager.g
        public void onPageScrollStateChanged(int i2) {
        }

        @Override // com.kugou.android.watch.lite.util.ViewPager.g
        public void onPageScrolled(int i2, float f2, int i3) {
        }

        @Override // com.kugou.android.watch.lite.util.ViewPager.g
        public void onPageSelected(int i2, boolean z) {
        }

        @Override // com.kugou.android.watch.lite.util.ViewPager.g
        public void onPageSelectedAfterAnimation(int i2) {
        }
    }

    public static class k implements Comparator<View> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
            boolean z = layoutParams.a;
            return z != layoutParams2.a ? z ? 1 : -1 : layoutParams.f241e - layoutParams2.f241e;
        }
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = null;
        this.f236d = true;
        this.f237f = true;
        this.f238h = new ArrayList<>();
        this.f239i = new d();
        this.j = new Rect();
        this.m = -1;
        this.n = null;
        this.o = null;
        this.v = -3.4028235E38f;
        this.w = Float.MAX_VALUE;
        this.C = 1;
        this.M = -1;
        this.T = true;
        this.h0 = new c();
        this.i0 = 0;
        this.j0 = false;
        this.k0 = true;
        this.v0 = 0.0f;
        this.w0 = 1.0f;
        this.x0 = 255;
        this.y0 = 2;
        x();
    }

    private RectF getBackgroundClipRect() {
        int i2 = this.y0;
        if (i2 == 1 || i2 == 2 || i2 == 3) {
            return this.t0;
        }
        if (i2 == 4 || i2 == 5) {
            return this.u0;
        }
        return null;
    }

    private Matrix getBackgroundMatrix() {
        int i2 = this.y0;
        if (i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4) {
            return this.r0;
        }
        if (i2 != 5) {
            return null;
        }
        return this.s0;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private void setBackgroundState(int i2) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScrollState(int i2) {
        Drawable drawable;
        if (this.i0 == i2) {
            return;
        }
        this.i0 = i2;
        if (this.d0 != null) {
            n(i2 != 0);
        }
        g gVar = this.W;
        if (gVar != null) {
            gVar.onPageScrollStateChanged(i2);
        }
        g gVar2 = this.W;
        if (gVar2 != null && this.i0 == 0) {
            gVar2.onPageSelectedAfterAnimation(this.l);
        }
        if (this.i0 == 0) {
            if (getBackground() != null) {
                super.setBackgroundDrawable(null);
            }
        } else {
            if (getBackground() != null || (drawable = this.m0) == null) {
                return;
            }
            super.setBackgroundDrawable(drawable);
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.z != z) {
            this.z = z;
        }
    }

    public final boolean A(int i2, int i3) {
        if (this.l0 != null) {
            int top = i3 + getTop();
            Rect rect = new Rect();
            int[] iArr = new int[2];
            for (View view : this.l0) {
                Object tag = view.getTag(com.kugou.android.watch.lite.R.id.tag_ignore_view_enable);
                boolean z = view.getVisibility() != 0;
                boolean z2 = (tag instanceof Boolean) && !((Boolean) tag).booleanValue();
                if (!z && !z2) {
                    view.getLocationInWindow(iArr);
                    rect.set(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
                    if (g0.a) {
                        g0.e("ViewPager", String.format("by getLocationInWindow rect:%s x:%s y:%s", rect, Integer.valueOf(i2), Integer.valueOf(top)));
                    }
                    if (rect.contains(i2, top)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void B(int r19, float r20, int r21) {
        /*
            Method dump skipped, instruction units count: 390
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kugou.android.watch.lite.util.ViewPager.B(int, float, int):void");
    }

    public final void C(MotionEvent motionEvent) {
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == this.M) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.I = MotionEventCompat.getX(motionEvent, i2);
            this.M = MotionEventCompat.getPointerId(motionEvent, i2);
            VelocityTracker velocityTracker = this.N;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    public boolean D() {
        int i2 = this.l;
        if (i2 <= 0) {
            return false;
        }
        M(i2 - 1, true);
        return true;
    }

    public boolean E() {
        PagerAdapter pagerAdapter = this.k;
        if (pagerAdapter == null || this.l >= pagerAdapter.getCount() - 1) {
            return false;
        }
        M(this.l + 1, true);
        return true;
    }

    public final boolean F(int i2) {
        if (this.f238h.size() == 0) {
            this.U = false;
            B(0, 0.0f, 0);
            if (this.U) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        d dVarV = v();
        int clientWidth = getClientWidth();
        int i3 = this.r;
        int i4 = clientWidth + i3;
        float f2 = clientWidth;
        int i5 = dVarV.b;
        float f3 = ((i2 / f2) - dVarV.f245e) / (dVarV.f244d + (i3 / f2));
        this.U = false;
        B(i5, f3, (int) (i4 * f3));
        if (this.U) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    public final boolean G(float f2) {
        float f3 = this.I - f2;
        this.I = f2;
        float scrollX = getScrollX();
        float fMin = scrollX + f3;
        float clientWidth = getClientWidth();
        float f4 = this.v * clientWidth;
        float f5 = this.w * clientWidth;
        if (this.f238h.size() == 0) {
            return false;
        }
        d dVar = this.f238h.get(0);
        d dVar2 = this.f238h.get(r7.size() - 1);
        if (dVar.b != 0) {
            f4 = dVar.f245e * clientWidth;
        }
        if (dVar2.b != this.k.getCount() - 1) {
            f5 = dVar2.f245e * clientWidth;
        }
        if (fMin < f4) {
            fMin = this.j0 ? f4 : Math.max(f4 - (clientWidth * 0.3f), scrollX + (f3 * 0.3f));
        } else if (fMin > f5) {
            fMin = this.k0 ? f5 : Math.min(f5 + (clientWidth * 0.3f), scrollX + (f3 * 0.3f));
        }
        int i2 = (int) fMin;
        this.I += fMin - i2;
        scrollTo(i2, getScrollY());
        F(i2);
        return false;
    }

    public void H() {
        I(this.l);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x006e, code lost:
    
        r9 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00d2 A[PHI: r6 r8 r10
  0x00d2: PHI (r6v41 float) = (r6v39 float), (r6v40 float), (r6v8 float) binds: [B:65:0x00f5, B:62:0x00df, B:55:0x00c7] A[DONT_GENERATE, DONT_INLINE]
  0x00d2: PHI (r8v6 int) = (r8v5 int), (r8v4 int), (r8v8 int) binds: [B:65:0x00f5, B:62:0x00df, B:55:0x00c7] A[DONT_GENERATE, DONT_INLINE]
  0x00d2: PHI (r10v9 int) = (r10v1 int), (r10v8 int), (r10v11 int) binds: [B:65:0x00f5, B:62:0x00df, B:55:0x00c7] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void I(int r18) {
        /*
            Method dump skipped, instruction units count: 619
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kugou.android.watch.lite.util.ViewPager.I(int):void");
    }

    public final void J(int i2, int i3, int i4, int i5) {
        if (i3 <= 0 || this.f238h.isEmpty()) {
            d dVarW = w(this.l);
            int iMin = (int) ((dVarW != null ? Math.min(dVarW.f245e, this.w) : 0.0f) * ((i2 - getPaddingLeft()) - getPaddingRight()));
            if (iMin != getScrollX()) {
                i(false);
                scrollTo(iMin, getScrollY());
                return;
            }
            return;
        }
        int scrollX = (int) ((getScrollX() / (((i3 - getPaddingLeft()) - getPaddingRight()) + i5)) * (((i2 - getPaddingLeft()) - getPaddingRight()) + i4));
        scrollTo(scrollX, getScrollY());
        if (this.p.isFinished()) {
            return;
        }
        this.p.startScroll(scrollX, 0, (int) (w(this.l).f245e * i2), 0, this.p.getDuration() - this.p.timePassed());
    }

    public final void K() {
        int i2 = 0;
        while (i2 < getChildCount()) {
            if (!((LayoutParams) getChildAt(i2).getLayoutParams()).a) {
                removeViewAt(i2);
                i2--;
            }
            i2++;
        }
    }

    public final void L(int i2, boolean z, int i3, boolean z2) {
        g gVar;
        g gVar2;
        g gVar3;
        g gVar4;
        d dVarW = w(i2);
        int clientWidth = dVarW != null ? (int) (getClientWidth() * Math.max(this.v, Math.min(dVarW.f245e, this.w))) : 0;
        if (z) {
            R(clientWidth, 0, i3);
            if (z2 && (gVar4 = this.W) != null) {
                gVar4.onPageSelected(i2, z);
            }
            if (!z2 || (gVar3 = this.a0) == null) {
                return;
            }
            gVar3.onPageSelected(i2, z);
            return;
        }
        if (z2 && (gVar2 = this.W) != null) {
            gVar2.onPageSelected(i2, z);
        }
        if (z2 && (gVar = this.a0) != null) {
            gVar.onPageSelected(i2, z);
        }
        i(false);
        scrollTo(clientWidth, 0);
        F(clientWidth);
    }

    public void M(int i2, boolean z) {
        N(i2, z, false);
    }

    public void N(int i2, boolean z, boolean z2) {
        this.A = false;
        this.B = z2;
        O(i2, z, false);
    }

    public void O(int i2, boolean z, boolean z2) {
        P(i2, z, z2, 0);
    }

    public void P(int i2, boolean z, boolean z2, int i3) {
        g gVar;
        g gVar2;
        PagerAdapter pagerAdapter = this.k;
        if (pagerAdapter == null || pagerAdapter.getCount() <= 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (!z2 && this.l == i2 && this.f238h.size() != 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (i2 < 0) {
            i2 = 0;
        } else if (i2 >= this.k.getCount()) {
            i2 = this.k.getCount() - 1;
        }
        int i4 = this.C;
        int i5 = this.l;
        if (i2 > i5 + i4 || i2 < i5 - i4) {
            for (int i6 = 0; i6 < this.f238h.size(); i6++) {
                this.f238h.get(i6).c = true;
            }
        }
        boolean z3 = this.l != i2;
        if (!this.T) {
            I(i2);
            L(i2, z, i3, z3);
            return;
        }
        this.l = i2;
        if (z3 && (gVar2 = this.W) != null) {
            gVar2.onPageSelected(i2, z);
        }
        if (z3 && (gVar = this.a0) != null) {
            gVar.onPageSelected(i2, z);
        }
        requestLayout();
    }

    public void Q(boolean z, h hVar) {
        if (Build.VERSION.SDK_INT >= 11) {
            boolean z2 = hVar != null;
            boolean z3 = z2 != (this.d0 != null);
            this.d0 = hVar;
            setChildrenDrawingOrderEnabledCompat(z2);
            if (z2) {
                this.f0 = z ? 2 : 1;
            } else {
                this.f0 = 0;
            }
            if (z3) {
                H();
            }
        }
    }

    public void R(int i2, int i3, int i4) {
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int i5 = i2 - scrollX;
        int i6 = i3 - scrollY;
        if (i5 == 0 && i6 == 0) {
            i(false);
            H();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        float f2 = clientWidth / 2;
        float fM = f2 + (m(Math.min(1.0f, (Math.abs(i5) * 1.0f) / clientWidth)) * f2);
        int iAbs = Math.abs(i4);
        int iMin = Math.min(iAbs > 0 ? Math.round(Math.abs(fM / iAbs) * 1000.0f) * 4 : HttpStatus.SC_BAD_REQUEST, HttpStatus.SC_BAD_REQUEST);
        if (this.b == null) {
            this.b = Boolean.valueOf(y());
        }
        if (this.B && this.b.booleanValue()) {
            iMin /= 2;
        }
        this.p.startScroll(scrollX, scrollY, i5, i6, iMin);
        ViewCompat.postInvalidateOnAnimation(this);
    }

    public final void S() {
        if (this.f0 != 0) {
            ArrayList<View> arrayList = this.g0;
            if (arrayList == null) {
                this.g0 = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                this.g0.add(getChildAt(i2));
            }
            Collections.sort(this.g0, C0);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        d dVarU;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                View childAt = getChildAt(i4);
                if (childAt.getVisibility() == 0 && (dVarU = u(childAt)) != null && dVarU.b == this.l) {
                    childAt.addFocusables(arrayList, i2, i3);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if (((i3 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) || arrayList == null) {
                return;
            }
            arrayList.add(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        d dVarU;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (dVarU = u(childAt)) != null && dVarU.b == this.l) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        boolean z = layoutParams2.a;
        layoutParams2.a = z;
        if (!this.y) {
            super.addView(view, i2, layoutParams);
        } else {
            if (layoutParams2 != null && z) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            layoutParams2.f240d = true;
            addViewInLayout(view, i2, layoutParams);
        }
    }

    public void c(View view) {
        getIgnoredViews().add(view);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.p.isFinished() || !this.p.computeScrollOffset()) {
            i(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.p.getCurrX();
        int currY = this.p.getCurrY();
        if (scrollX != currX || scrollY != currY) {
            scrollTo(currX, currY);
            if (!F(currX)) {
                this.p.abortAnimation();
                scrollTo(0, currY);
            }
        }
        ViewCompat.postInvalidateOnAnimation(this);
    }

    public d d(int i2, int i3) {
        d dVar = new d();
        dVar.b = i2;
        dVar.a = this.k.instantiateItem((ViewGroup) this, i2);
        dVar.f244d = this.k.getPageWidth(i2);
        if (i3 < 0 || i3 >= this.f238h.size()) {
            this.f238h.add(dVar);
        } else {
            this.f238h.add(i3, dVar);
        }
        return dVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        try {
            super.dispatchDraw(canvas);
        } catch (Exception e2) {
            g0.k(e2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || p(keyEvent);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.s;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    public boolean e(int i2) {
        boolean z;
        boolean zRequestFocus;
        View viewFindFocus = findFocus();
        boolean zD = false;
        if (viewFindFocus == this) {
            viewFindFocus = null;
        } else if (viewFindFocus != null) {
            ViewParent parent = viewFindFocus.getParent();
            while (true) {
                if (!(parent instanceof ViewGroup)) {
                    z = false;
                    break;
                }
                if (parent == this) {
                    z = true;
                    break;
                }
                parent = parent.getParent();
            }
            if (!z) {
                StringBuilder sb = new StringBuilder();
                sb.append(viewFindFocus.getClass().getSimpleName());
                for (ViewParent parent2 = viewFindFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                    sb.append(" => ");
                    sb.append(parent2.getClass().getSimpleName());
                }
                Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + sb.toString());
                viewFindFocus = null;
            }
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, i2);
        if (viewFindNextFocus != null && viewFindNextFocus != viewFindFocus) {
            if (i2 == 17) {
                zRequestFocus = (viewFindFocus == null || r(this.j, viewFindNextFocus).left < r(this.j, viewFindFocus).left) ? viewFindNextFocus.requestFocus() : D();
            } else if (i2 == 66) {
                zRequestFocus = (viewFindFocus == null || r(this.j, viewFindNextFocus).left > r(this.j, viewFindFocus).left) ? viewFindNextFocus.requestFocus() : E();
            }
            zD = zRequestFocus;
        } else if (i2 == 17 || i2 == 1) {
            zD = D();
        } else if (i2 == 66 || i2 == 2) {
            zD = E();
        }
        if (zD) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i2));
        }
        return zD;
    }

    public final void f(d dVar, int i2, d dVar2) {
        int i3;
        int i4;
        d dVar3;
        d dVar4;
        int count = this.k.getCount();
        int clientWidth = getClientWidth();
        float f2 = clientWidth > 0 ? this.r / clientWidth : 0.0f;
        if (dVar2 != null) {
            int i5 = dVar2.b;
            int i6 = dVar.b;
            if (i5 < i6) {
                int i7 = 0;
                float pageWidth = dVar2.f245e + dVar2.f244d + f2;
                while (true) {
                    i5++;
                    if (i5 > dVar.b || i7 >= this.f238h.size()) {
                        break;
                    }
                    d dVar5 = this.f238h.get(i7);
                    while (true) {
                        dVar4 = dVar5;
                        if (i5 <= dVar4.b || i7 >= this.f238h.size() - 1) {
                            break;
                        }
                        i7++;
                        dVar5 = this.f238h.get(i7);
                    }
                    while (i5 < dVar4.b) {
                        pageWidth += this.k.getPageWidth(i5) + f2;
                        i5++;
                    }
                    dVar4.f245e = pageWidth;
                    pageWidth += dVar4.f244d + f2;
                }
            } else if (i5 > i6) {
                int size = this.f238h.size() - 1;
                float pageWidth2 = dVar2.f245e;
                while (true) {
                    i5--;
                    if (i5 < dVar.b || size < 0) {
                        break;
                    }
                    d dVar6 = this.f238h.get(size);
                    while (true) {
                        dVar3 = dVar6;
                        if (i5 >= dVar3.b || size <= 0) {
                            break;
                        }
                        size--;
                        dVar6 = this.f238h.get(size);
                    }
                    while (i5 > dVar3.b) {
                        pageWidth2 -= this.k.getPageWidth(i5) + f2;
                        i5--;
                    }
                    pageWidth2 -= dVar3.f244d + f2;
                    dVar3.f245e = pageWidth2;
                }
            }
        }
        int size2 = this.f238h.size();
        float pageWidth3 = dVar.f245e;
        int i8 = dVar.b;
        int i9 = i8 - 1;
        this.v = i8 == 0 ? pageWidth3 : -3.4028235E38f;
        int i10 = count - 1;
        this.w = i8 == i10 ? (dVar.f244d + pageWidth3) - 1.0f : Float.MAX_VALUE;
        int i11 = i2 - 1;
        while (i11 >= 0) {
            d dVar7 = this.f238h.get(i11);
            while (true) {
                i4 = dVar7.b;
                if (i9 <= i4) {
                    break;
                }
                pageWidth3 -= this.k.getPageWidth(i9) + f2;
                i9--;
            }
            pageWidth3 -= dVar7.f244d + f2;
            dVar7.f245e = pageWidth3;
            if (i4 == 0) {
                this.v = pageWidth3;
            }
            i11--;
            i9--;
        }
        float pageWidth4 = dVar.f245e + dVar.f244d + f2;
        int i12 = dVar.b + 1;
        int i13 = i2 + 1;
        while (i13 < size2) {
            d dVar8 = this.f238h.get(i13);
            while (true) {
                i3 = dVar8.b;
                if (i12 >= i3) {
                    break;
                }
                pageWidth4 += this.k.getPageWidth(i12) + f2;
                i12++;
            }
            if (i3 == i10) {
                this.w = (dVar8.f244d + pageWidth4) - 1.0f;
            }
            dVar8.f245e = pageWidth4;
            pageWidth4 += dVar8.f244d + f2;
            i13++;
            i12++;
        }
    }

    public boolean g(View view, boolean z, int i2, int i3, int i4) {
        return A(i3, i4);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public PagerAdapter getAdapter() {
        return this.k;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i2, int i3) {
        if (this.f0 == 2) {
            i3 = (i2 - 1) - i3;
        }
        return ((LayoutParams) this.g0.get(i3).getLayoutParams()).f242f;
    }

    @Override // android.view.ViewGroup
    public boolean getChildStaticTransformation(View view, Transformation transformation) {
        float clientWidth = getClientWidth();
        float left = (view.getLeft() - getScrollX()) / clientWidth;
        transformation.setTransformationType(3);
        if (left < -1.0f) {
            transformation.setAlpha(0.0f);
            transformation.getMatrix().setTranslate(clientWidth * (-left), 0.0f);
            return true;
        }
        if (left > 1.0f) {
            transformation.setAlpha(0.0f);
            return true;
        }
        if (left > 0.0f) {
            return true;
        }
        if (!F0) {
            float f2 = E0;
            transformation.setAlpha(Math.max(f2, 1.0f - Math.abs((1.0f - f2) * left)));
            float f3 = D0;
            float fMax = Math.max(f3, 1.0f - Math.abs((1.0f - f3) * left));
            transformation.getMatrix().setScale(fMax, fMax);
            float width = getWidth() / 2;
            float height = getHeight() / 2;
            transformation.getMatrix().preTranslate(-width, -height);
            transformation.getMatrix().postTranslate(width, height);
        }
        transformation.getMatrix().postTranslate(clientWidth * (-left), 0.0f);
        return true;
    }

    public int getCurrentItem() {
        return this.l;
    }

    public ArrayList<View> getIgnoredViews() {
        if (this.l0 == null) {
            this.l0 = new ArrayList<>();
        }
        return this.l0;
    }

    public int getOffscreenPageLimit() {
        return this.C;
    }

    public int getPageMargin() {
        return this.r;
    }

    public int getScrollState() {
        return this.i0;
    }

    public final boolean h() {
        Bitmap bitmap;
        Drawable drawable = this.n0;
        if (drawable != null) {
            return (BitmapDrawable.class.isInstance(drawable) && ((bitmap = ((BitmapDrawable) this.n0).getBitmap()) == null || bitmap.isRecycled())) ? false : true;
        }
        return false;
    }

    public final void i(boolean z) {
        boolean z2 = this.i0 == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            this.p.abortAnimation();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.p.getCurrX();
            int currY = this.p.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
            }
        }
        this.A = false;
        for (int i2 = 0; i2 < this.f238h.size(); i2++) {
            d dVar = this.f238h.get(i2);
            if (dVar.c) {
                dVar.c = false;
                z2 = true;
            }
        }
        if (z2) {
            if (z) {
                ViewCompat.postOnAnimation(this, this.h0);
            } else {
                this.h0.run();
            }
        }
    }

    public final void j() {
        float f2;
        float f3;
        float f4;
        Drawable drawable = this.n0;
        if (drawable == null) {
            return;
        }
        this.o0 = drawable.getIntrinsicWidth();
        int intrinsicHeight = this.n0.getIntrinsicHeight();
        this.p0 = intrinsicHeight;
        this.n0.setBounds(0, 0, this.o0, intrinsicHeight);
        if (this.r0 == null) {
            this.r0 = new Matrix();
        }
        if (this.s0 == null) {
            this.s0 = new Matrix();
        }
        int i2 = this.o0;
        int i3 = this.p0;
        this.q0 = (int) ((getWidth() / 10.0f) + 0.5f);
        int width = ((getWidth() - getPaddingLeft()) - getPaddingRight()) + this.q0;
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        if (i2 * height > width * i3) {
            f2 = height / i3;
            f4 = (width - (i2 * f2)) * 0.5f;
            f3 = 0.0f;
        } else {
            f2 = width / i2;
            f3 = (height - (i3 * f2)) * 0.5f;
            f4 = 0.0f;
        }
        this.r0.setScale(f2, f2);
        float f5 = (int) (f3 + 0.5f);
        this.r0.postTranslate((int) (f4 + 0.5f), f5);
        this.s0.setScale(f2, f2);
        this.s0.postTranslate((int) ((f4 - this.q0) + 0.5f), f5);
        if (this.t0 == null) {
            this.t0 = new RectF();
        }
        RectF rectF = this.t0;
        rectF.left = 0.0f;
        rectF.top = 0.0f;
        rectF.right = width;
        float f6 = height;
        rectF.bottom = f6;
        if (this.u0 == null) {
            this.u0 = new RectF();
        }
        RectF rectF2 = this.u0;
        rectF2.left = 0.0f;
        rectF2.top = 0.0f;
        rectF2.right = width - this.q0;
        rectF2.bottom = f6;
    }

    public void k() {
        int count = this.k.getCount();
        this.a = count;
        boolean z = this.f238h.size() < (this.C * 2) + 1 && this.f238h.size() < count;
        int iMax = this.l;
        int i2 = 0;
        boolean z2 = false;
        while (i2 < this.f238h.size()) {
            d dVar = this.f238h.get(i2);
            int itemPosition = this.k.getItemPosition(dVar.a);
            if (itemPosition != -1) {
                if (itemPosition == -2) {
                    this.f238h.remove(i2);
                    i2--;
                    if (!z2) {
                        this.k.startUpdate((ViewGroup) this);
                        z2 = true;
                    }
                    this.k.destroyItem((ViewGroup) this, dVar.b, dVar.a);
                    int i3 = this.l;
                    if (i3 == dVar.b) {
                        iMax = Math.max(0, Math.min(i3, count - 1));
                    }
                } else {
                    int i4 = dVar.b;
                    if (i4 != itemPosition) {
                        if (i4 == this.l) {
                            iMax = itemPosition;
                        }
                        dVar.b = itemPosition;
                    }
                }
                z = true;
            }
            i2++;
        }
        if (z2) {
            this.k.finishUpdate((ViewGroup) this);
        }
        Collections.sort(this.f238h, A0);
        if (z) {
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i5).getLayoutParams();
                if (!layoutParams.a) {
                    layoutParams.c = 0.0f;
                }
            }
            O(iMax, false, true);
            requestLayout();
        }
    }

    public final int l(int i2, float f2, int i3, int i4) {
        if (Math.abs(i4) <= this.Q || Math.abs(i3) <= this.O) {
            i2 = (int) (i2 + f2 + (i2 >= this.l ? 0.4f : 0.6f));
        } else if (i3 <= 0) {
            i2++;
        }
        if (this.f238h.size() <= 0) {
            return i2;
        }
        return Math.max(this.f238h.get(0).b, Math.min(i2, this.f238h.get(r4.size() - 1).b));
    }

    public float m(float f2) {
        Double.isNaN(f2 - 0.5f);
        return (float) Math.sin((float) (r0 * 0.4712389167638204d));
    }

    public final void n(boolean z) {
        boolean z2 = z && l1.S();
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            f fVar = this.c0;
            if (fVar != null ? fVar.onLayerChange(childAt.getId()) : true) {
                ViewCompat.setLayerType(childAt, z2 ? 2 : 0, null);
            }
        }
    }

    public final void o() {
        this.D = false;
        this.E = false;
        VelocityTracker velocityTracker = this.N;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.N = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.T = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.h0);
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i2;
        float f2;
        float f3;
        float f4;
        super.onDraw(canvas);
        if (h()) {
            int saveCount = canvas.getSaveCount();
            canvas.save();
            canvas.translate(getScrollX() + getPaddingLeft() + this.v0, getScrollY() + getPaddingTop());
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            float f5 = this.w0;
            canvas.scale(f5, f5, width * 0.5f, height * 0.5f);
            RectF backgroundClipRect = getBackgroundClipRect();
            if (backgroundClipRect != null) {
                canvas.clipRect(backgroundClipRect);
            }
            Matrix backgroundMatrix = getBackgroundMatrix();
            if (backgroundMatrix != null) {
                canvas.concat(backgroundMatrix);
            }
            this.n0.setAlpha(this.x0);
            this.n0.draw(canvas);
            canvas.restoreToCount(saveCount);
        }
        if (this.r <= 0 || this.s == null || this.f238h.size() <= 0 || this.k == null) {
            return;
        }
        int scrollX = getScrollX();
        float width2 = getWidth();
        float f6 = this.r / width2;
        int i3 = 0;
        d dVar = this.f238h.get(0);
        float f7 = dVar.f245e;
        int size = this.f238h.size();
        int i4 = dVar.b;
        int i5 = this.f238h.get(size - 1).b;
        while (i4 < i5) {
            while (true) {
                i2 = dVar.b;
                if (i4 <= i2 || i3 >= size) {
                    break;
                }
                i3++;
                dVar = this.f238h.get(i3);
            }
            if (i4 == i2) {
                float f8 = dVar.f245e;
                float f9 = dVar.f244d;
                f2 = (f8 + f9) * width2;
                f7 = f8 + f9 + f6;
            } else {
                float pageWidth = this.k.getPageWidth(i4);
                f2 = (f7 + pageWidth) * width2;
                f7 += pageWidth + f6;
            }
            int i6 = this.r;
            if (i6 + f2 > scrollX) {
                f3 = f6;
                f4 = width2;
                this.s.setBounds((int) f2, this.t, (int) (i6 + f2 + 0.5f), this.u);
                this.s.draw(canvas);
            } else {
                f3 = f6;
                f4 = width2;
            }
            if (f2 > scrollX + r4) {
                return;
            }
            i4++;
            f6 = f3;
            width2 = f4;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.f236d) {
            return true;
        }
        if (!this.f237f) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            this.D = false;
            this.E = false;
            this.M = -1;
            VelocityTracker velocityTracker = this.N;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.N = null;
            }
            return false;
        }
        if (action != 0) {
            if (this.D) {
                return true;
            }
            if (this.E) {
                return false;
            }
        }
        if (action == 0) {
            float x = motionEvent.getX();
            this.K = x;
            this.I = x;
            float y = motionEvent.getY();
            this.L = y;
            this.J = y;
            this.M = MotionEventCompat.getPointerId(motionEvent, 0);
            this.E = false;
            this.p.computeScrollOffset();
            if (this.i0 != 2 || Math.abs(this.p.getFinalX() - this.p.getCurrX()) <= this.R) {
                i(false);
                this.D = false;
            } else {
                this.p.abortAnimation();
                this.A = false;
                H();
                this.D = true;
                setScrollState(1);
            }
        } else if (action == 2) {
            int i2 = this.M;
            if (i2 != -1) {
                int iQ = q(motionEvent, i2);
                float x2 = MotionEventCompat.getX(motionEvent, iQ);
                float f2 = x2 - this.I;
                float fAbs = Math.abs(f2);
                float y2 = MotionEventCompat.getY(motionEvent, iQ);
                float fAbs2 = Math.abs(y2 - this.L);
                if (f2 != 0.0f && !z(this.I, f2) && g(this, false, (int) f2, (int) x2, (int) y2)) {
                    this.I = x2;
                    this.J = y2;
                    this.E = true;
                    return false;
                }
                int i3 = this.H;
                if (fAbs > i3 && fAbs > fAbs2) {
                    this.D = true;
                    setScrollState(1);
                    this.I = f2 > 0.0f ? this.K + this.H : this.K - this.H;
                    this.J = y2;
                    setScrollingCacheEnabled(true);
                } else if (fAbs2 > i3) {
                    this.E = true;
                }
                if (this.D && G(x2)) {
                    ViewCompat.postInvalidateOnAnimation(this);
                }
            }
        } else if (action == 6) {
            C(motionEvent);
        }
        if (this.N == null) {
            this.N = VelocityTracker.obtain();
        }
        this.N.addMovement(motionEvent);
        return this.D;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0091  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onLayout(boolean r19, int r20, int r21, int r22, int r23) {
        /*
            Method dump skipped, instruction units count: 289
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kugou.android.watch.lite.util.ViewPager.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a8  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(int r14, int r15) {
        /*
            Method dump skipped, instruction units count: 241
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kugou.android.watch.lite.util.ViewPager.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i2, Rect rect) {
        int i3;
        int i4;
        d dVarU;
        int childCount = getChildCount();
        int i5 = -1;
        if ((i2 & 2) != 0) {
            i5 = childCount;
            i3 = 0;
            i4 = 1;
        } else {
            i3 = childCount - 1;
            i4 = -1;
        }
        while (i3 != i5) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() == 0 && (dVarU = u(childAt)) != null && dVarU.b == this.l && childAt.requestFocus(i2, rect)) {
                return true;
            }
            i3 += i4;
        }
        return false;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        PagerAdapter pagerAdapter = this.k;
        if (pagerAdapter != null) {
            pagerAdapter.restoreState(savedState.b, savedState.f243d);
            O(savedState.a, false, true);
        } else {
            this.m = savedState.a;
            this.n = savedState.b;
            this.o = savedState.f243d;
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = this.l;
        PagerAdapter pagerAdapter = this.k;
        if (pagerAdapter != null) {
            savedState.b = pagerAdapter.saveState();
        }
        return savedState;
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 != i4) {
            int i6 = this.r;
            J(i2, i4, i6, i6);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        PagerAdapter pagerAdapter;
        if (!this.f236d) {
            return true;
        }
        boolean zG = false;
        if (!this.f237f) {
            return false;
        }
        if (this.S) {
            return true;
        }
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (pagerAdapter = this.k) == null || pagerAdapter.getCount() == 0) {
            return false;
        }
        if (this.N == null) {
            this.N = VelocityTracker.obtain();
        }
        this.N.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.p.abortAnimation();
            this.A = false;
            H();
            this.D = s();
            setScrollState(1);
            float x = motionEvent.getX();
            this.K = x;
            this.I = x;
            float y = motionEvent.getY();
            this.L = y;
            this.J = y;
            this.M = MotionEventCompat.getPointerId(motionEvent, 0);
        } else if (action != 1) {
            if (action == 2) {
                if (!this.D) {
                    int iQ = q(motionEvent, this.M);
                    float x2 = MotionEventCompat.getX(motionEvent, iQ);
                    float fAbs = Math.abs(x2 - this.I);
                    float y2 = MotionEventCompat.getY(motionEvent, iQ);
                    float fAbs2 = Math.abs(y2 - this.J);
                    int i2 = this.H;
                    if (fAbs > i2 && fAbs > fAbs2) {
                        this.D = true;
                        float f2 = this.K;
                        this.I = x2 - f2 > 0.0f ? f2 + i2 : f2 - i2;
                        this.J = y2;
                        setScrollState(1);
                        setScrollingCacheEnabled(true);
                    }
                }
                if (this.D) {
                    zG = false | G(MotionEventCompat.getX(motionEvent, q(motionEvent, this.M)));
                }
            } else if (action != 3) {
                if (action == 5) {
                    int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                    this.I = MotionEventCompat.getX(motionEvent, actionIndex);
                    this.M = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                } else if (action == 6) {
                    C(motionEvent);
                    this.I = MotionEventCompat.getX(motionEvent, q(motionEvent, this.M));
                }
            } else if (this.D) {
                L(this.l, true, 0, false);
                this.M = -1;
                o();
            }
        } else if (this.D) {
            VelocityTracker velocityTracker = this.N;
            velocityTracker.computeCurrentVelocity(1000, this.P);
            int xVelocity = (int) VelocityTrackerCompat.getXVelocity(velocityTracker, this.M);
            this.A = true;
            int clientWidth = getClientWidth();
            int scrollX = getScrollX();
            d dVarV = v();
            P(l(dVarV.b, ((scrollX / clientWidth) - dVarV.f245e) / dVarV.f244d, xVelocity, (int) (MotionEventCompat.getX(motionEvent, q(motionEvent, this.M)) - this.K)), true, true, xVelocity);
            this.M = -1;
            o();
        }
        if (zG) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
        return true;
    }

    public boolean p(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 21) {
                return e(17);
            }
            if (keyCode == 22) {
                return e(66);
            }
            if (keyCode == 61) {
                if (keyEvent.hasNoModifiers()) {
                    return e(2);
                }
                if (keyEvent.hasModifiers(1)) {
                    return e(1);
                }
            }
        }
        return false;
    }

    public int q(MotionEvent motionEvent, int i2) {
        int iFindPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i2);
        if (iFindPointerIndex == -1) {
            return 0;
        }
        return iFindPointerIndex;
    }

    public final Rect r(Rect rect, View view) {
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
            rect.left += viewGroup.getLeft();
            rect.top += viewGroup.getTop();
            parent = viewGroup.getParent();
        }
        rect.left -= getScrollX();
        rect.top -= getScrollY();
        rect.right = rect.left + view.getWidth();
        rect.bottom = rect.top + view.getHeight();
        return rect;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.y) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public boolean s() {
        return true;
    }

    public void setAdapter(PagerAdapter pagerAdapter) {
        PagerAdapter pagerAdapter2 = this.k;
        if (pagerAdapter2 != null) {
            pagerAdapter2.unregisterDataSetObserver(this.q);
            this.k.startUpdate((ViewGroup) this);
            for (int i2 = 0; i2 < this.f238h.size(); i2++) {
                d dVar = this.f238h.get(i2);
                this.k.destroyItem((ViewGroup) this, dVar.b, dVar.a);
            }
            this.k.finishUpdate((ViewGroup) this);
            this.f238h.clear();
            K();
            this.l = 0;
            scrollTo(0, 0);
        }
        PagerAdapter pagerAdapter3 = this.k;
        this.k = pagerAdapter;
        this.a = 0;
        if (pagerAdapter != null) {
            a aVar = null;
            if (this.q == null) {
                this.q = new i(this, aVar);
            }
            this.k.registerDataSetObserver(this.q);
            this.A = false;
            boolean z = this.T;
            this.T = true;
            this.a = this.k.getCount();
            if (this.m >= 0) {
                this.k.restoreState(this.n, this.o);
                O(this.m, false, true);
                this.m = -1;
                this.n = null;
                this.o = null;
            } else if (z) {
                requestLayout();
            } else {
                H();
            }
        }
        e eVar = this.b0;
        if (eVar == null || pagerAdapter3 == pagerAdapter) {
            return;
        }
        eVar.onAdapterChanged(pagerAdapter3, pagerAdapter);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        this.m0 = drawable;
        super.setBackgroundDrawable(drawable);
    }

    public void setChildrenDrawingOrderEnabledCompat(boolean z) {
        if (Build.VERSION.SDK_INT >= 7) {
            if (this.e0 == null) {
                try {
                    this.e0 = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", Boolean.TYPE);
                } catch (NoSuchMethodException e2) {
                    Log.e("ViewPager", "Can't find setChildrenDrawingOrderEnabled", e2);
                }
            }
            try {
                this.e0.invoke(this, Boolean.valueOf(z));
            } catch (Exception e3) {
                Log.e("ViewPager", "Error changing children drawing order", e3);
            }
        }
    }

    public void setCurrentItem(int i2) {
        this.A = false;
        O(i2, !this.T, false);
    }

    public void setIgnoredViews(ArrayList<View> arrayList) {
        this.l0 = arrayList;
    }

    public void setOffscreenPageLimit(int i2) {
        if (i2 < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i2 + " too small; defaulting to 1");
            i2 = 1;
        }
        if (i2 != this.C) {
            this.C = i2;
            H();
        }
    }

    public void setOnAdapterChangeListener(e eVar) {
        this.b0 = eVar;
    }

    public void setOnLayerChangeListener(f fVar) {
        this.c0 = fVar;
    }

    public void setOnPageChangeListener(g gVar) {
        this.W = gVar;
    }

    public void setPageMargin(int i2) {
        int i3 = this.r;
        this.r = i2;
        int width = getWidth();
        J(width, width, i2, i3);
        requestLayout();
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.s = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setScroller(Scroller scroller) {
        this.p = scroller;
    }

    public void setSlidingEnabled(boolean z) {
        if (this.f237f != z) {
            this.f237f = z;
        }
    }

    public void setTouchEnabled(boolean z) {
        if (this.f236d != z) {
            this.f236d = z;
        }
    }

    public d t(View view) {
        while (true) {
            Object parent = view.getParent();
            if (parent == this) {
                return u(view);
            }
            if (parent == null || !(parent instanceof View)) {
                return null;
            }
            view = (View) parent;
        }
    }

    public d u(View view) {
        for (int i2 = 0; i2 < this.f238h.size(); i2++) {
            d dVar = this.f238h.get(i2);
            if (this.k.isViewFromObject(view, dVar.a)) {
                return dVar;
            }
        }
        return null;
    }

    public final d v() {
        int i2;
        int clientWidth = getClientWidth();
        float f2 = 0.0f;
        float scrollX = clientWidth > 0 ? getScrollX() / clientWidth : 0.0f;
        float f3 = clientWidth > 0 ? this.r / clientWidth : 0.0f;
        d dVar = null;
        float f4 = 0.0f;
        int i3 = -1;
        int i4 = 0;
        boolean z = true;
        while (i4 < this.f238h.size()) {
            d dVar2 = this.f238h.get(i4);
            if (!z && dVar2.b != (i2 = i3 + 1)) {
                dVar2 = this.f239i;
                dVar2.f245e = f2 + f4 + f3;
                dVar2.b = i2;
                dVar2.f244d = this.k.getPageWidth(i2);
                i4--;
            }
            f2 = dVar2.f245e;
            float f5 = dVar2.f244d + f2 + f3;
            if (!z && scrollX < f2) {
                return dVar;
            }
            if (scrollX < f5 || i4 == this.f238h.size() - 1) {
                return dVar2;
            }
            i3 = dVar2.b;
            f4 = dVar2.f244d;
            i4++;
            dVar = dVar2;
            z = false;
        }
        return dVar;
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.s;
    }

    public d w(int i2) {
        for (int i3 = 0; i3 < this.f238h.size(); i3++) {
            d dVar = this.f238h.get(i3);
            if (dVar.b == i2) {
                return dVar;
            }
        }
        return null;
    }

    public void x() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.p = new Scroller(context, B0);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.H = ViewConfigurationCompat.getScaledPagingTouchSlop(viewConfiguration);
        this.O = (int) (400.0f * f2);
        this.P = viewConfiguration.getScaledMaximumFlingVelocity();
        this.Q = (int) (25.0f * f2);
        this.R = (int) (2.0f * f2);
        this.F = (int) (f2 * 16.0f);
        if (ViewCompat.getImportantForAccessibility(this) == 0) {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
        if (Build.VERSION.SDK_INT >= 11) {
            setStaticTransformationsEnabled(false);
        } else {
            setStaticTransformationsEnabled(true);
            this.f0 = 1;
            setChildrenDrawingOrderEnabledCompat(true);
        }
        ViewCompat.setOverScrollMode(this, 2);
    }

    public final boolean y() {
        return (h1.u(l1.D(KGApplication.getContext()), 0) >= 1900) && (Build.VERSION.SDK_INT >= 20);
    }

    public final boolean z(float f2, float f3) {
        return (f2 < ((float) this.G) && f3 > 0.0f) || (f2 > ((float) (getWidth() - this.G)) && f3 < 0.0f);
    }

    public static class LayoutParams extends ViewGroup.LayoutParams {
        public boolean a;
        public int b;
        public float c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f240d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f241e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f242f;

        public LayoutParams() {
            super(-1, -1);
            this.c = 0.0f;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.c = 0.0f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.z0);
            this.b = typedArrayObtainStyledAttributes.getInteger(0, 48);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public void setPageMarginDrawable(int i2) {
        setPageMarginDrawable(getContext().getResources().getDrawable(i2));
    }
}
