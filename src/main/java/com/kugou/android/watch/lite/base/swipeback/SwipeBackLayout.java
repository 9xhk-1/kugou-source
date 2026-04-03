package com.kugou.android.watch.lite.base.swipeback;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.ViewCompat;
import com.kugou.android.watch.lite.R;
import e.c.a.g.a.d.a0.d;
import e.c.a.g.a.s.g0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SwipeBackLayout extends CircleFrameLayout {
    public static final int[] y = {1, 2, 8, 11};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f84i;
    public float j;
    public Activity k;
    public boolean l;
    public View m;
    public d n;
    public float o;
    public int p;
    public int q;
    public List<b> r;
    public float s;
    public int t;
    public boolean u;
    public int v;
    public List<View> w;
    public List<Rect> x;

    public interface b {
        void onEdgeTouch(int i2);

        void onScroll(float f2);

        void onScrollOverThreshold();

        void onScrollStateChange(int i2, float f2);
    }

    public class c extends d.c {
        public boolean a;

        public c() {
        }

        @Override // e.c.a.g.a.d.a0.d.c
        public int a(View view, int i2, int i3) {
            int i4 = SwipeBackLayout.this.v;
            if ((i4 & 1) != 0) {
                return Math.min(view.getWidth(), Math.max(i2, 0));
            }
            if ((i4 & 2) != 0) {
                return Math.min(0, Math.max(i2, -view.getWidth()));
            }
            return 0;
        }

        @Override // e.c.a.g.a.d.a0.d.c
        public int b(View view, int i2, int i3) {
            if ((SwipeBackLayout.this.v & 8) != 0) {
                return Math.min(0, Math.max(i2, -view.getHeight()));
            }
            return 0;
        }

        @Override // e.c.a.g.a.d.a0.d.c
        public int d(View view) {
            return SwipeBackLayout.this.f84i & 3;
        }

        @Override // e.c.a.g.a.d.a0.d.c
        public int e(View view) {
            return SwipeBackLayout.this.f84i & 8;
        }

        @Override // e.c.a.g.a.d.a0.d.c
        public void j(int i2) {
            super.j(i2);
            List<b> list = SwipeBackLayout.this.r;
            if (list == null || list.isEmpty()) {
                return;
            }
            Iterator<b> it = SwipeBackLayout.this.r.iterator();
            while (it.hasNext()) {
                it.next().onScrollStateChange(i2, SwipeBackLayout.this.o);
            }
        }

        @Override // e.c.a.g.a.d.a0.d.c
        public void k(View view, int i2, int i3, int i4, int i5) {
            super.k(view, i2, i3, i4, i5);
            SwipeBackLayout swipeBackLayout = SwipeBackLayout.this;
            int i6 = swipeBackLayout.v;
            if ((i6 & 3) != 0) {
                swipeBackLayout.o = Math.abs(i2 / swipeBackLayout.m.getWidth());
            } else if ((i6 & 8) != 0) {
                swipeBackLayout.o = Math.abs(i3 / swipeBackLayout.m.getHeight());
            }
            SwipeBackLayout swipeBackLayout2 = SwipeBackLayout.this;
            swipeBackLayout2.p = i2;
            swipeBackLayout2.q = i3;
            swipeBackLayout2.invalidate();
            SwipeBackLayout swipeBackLayout3 = SwipeBackLayout.this;
            if (swipeBackLayout3.o < swipeBackLayout3.j && !this.a) {
                this.a = true;
            }
            List<b> list = swipeBackLayout3.r;
            if (list != null && !list.isEmpty()) {
                Iterator<b> it = SwipeBackLayout.this.r.iterator();
                while (it.hasNext()) {
                    it.next().onScroll(SwipeBackLayout.this.o);
                }
            }
            List<b> list2 = SwipeBackLayout.this.r;
            if (list2 != null && !list2.isEmpty() && SwipeBackLayout.this.n.u() == 1) {
                SwipeBackLayout swipeBackLayout4 = SwipeBackLayout.this;
                if (swipeBackLayout4.o >= swipeBackLayout4.j && this.a) {
                    this.a = false;
                    Iterator<b> it2 = swipeBackLayout4.r.iterator();
                    while (it2.hasNext()) {
                        it2.next().onScrollOverThreshold();
                    }
                }
            }
            SwipeBackLayout swipeBackLayout5 = SwipeBackLayout.this;
            if (swipeBackLayout5.o < 1.0f || swipeBackLayout5.k.isFinishing()) {
                return;
            }
            SwipeBackLayout.this.k.finish();
        }

        @Override // e.c.a.g.a.d.a0.d.c
        public void l(View view, float f2, float f3) {
            int i2;
            int width = view.getWidth();
            int height = view.getHeight();
            SwipeBackLayout swipeBackLayout = SwipeBackLayout.this;
            int i3 = swipeBackLayout.v;
            int i4 = 0;
            if ((i3 & 1) != 0) {
                i4 = (f2 > 0.0f || (f2 == 0.0f && swipeBackLayout.o > swipeBackLayout.j)) ? width + 10 : 0;
            } else {
                if ((i3 & 2) == 0) {
                    if ((i3 & 8) != 0 && (f3 < 0.0f || (f3 == 0.0f && swipeBackLayout.o > swipeBackLayout.j))) {
                        i2 = -(height + 10);
                    }
                    swipeBackLayout.n.L(i4, i2);
                    SwipeBackLayout.this.invalidate();
                }
                i4 = (f2 < 0.0f || (f2 == 0.0f && swipeBackLayout.o > swipeBackLayout.j)) ? -(width + 10) : 0;
            }
            i2 = 0;
            swipeBackLayout.n.L(i4, i2);
            SwipeBackLayout.this.invalidate();
        }

        @Override // e.c.a.g.a.d.a0.d.c
        public boolean m(View view, int i2) {
            SwipeBackLayout swipeBackLayout = SwipeBackLayout.this;
            boolean zW = swipeBackLayout.n.w(swipeBackLayout.f84i, i2);
            if (zW) {
                if (SwipeBackLayout.this.n.w(1, i2)) {
                    SwipeBackLayout.this.v = 1;
                } else if (SwipeBackLayout.this.n.w(2, i2)) {
                    SwipeBackLayout.this.v = 2;
                } else if (SwipeBackLayout.this.n.w(8, i2)) {
                    SwipeBackLayout.this.v = 8;
                }
                List<b> list = SwipeBackLayout.this.r;
                if (list != null && !list.isEmpty()) {
                    Iterator<b> it = SwipeBackLayout.this.r.iterator();
                    while (it.hasNext()) {
                        it.next().onEdgeTouch(SwipeBackLayout.this.v);
                    }
                }
                this.a = true;
            }
            return zW;
        }
    }

    public SwipeBackLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.SwipeBackLayoutStyle);
    }

    private void setContentView(View view) {
        this.m = view;
    }

    public void b(b bVar) {
        if (this.r == null) {
            this.r = new ArrayList();
        }
        this.r.add(bVar);
    }

    public void c(Activity activity) {
        this.k = activity;
        TypedArray typedArrayObtainStyledAttributes = activity.getTheme().obtainStyledAttributes(new int[]{android.R.attr.windowBackground});
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.getChildAt(0);
        viewGroup2.setBackgroundResource(resourceId);
        b(new e.c.a.g.a.d.a0.b(activity));
        viewGroup.removeView(viewGroup2);
        addView(viewGroup2);
        setContentView(viewGroup2);
        viewGroup.addView(this);
        e.c.a.g.a.d.g.b.b().c(viewGroup2);
    }

    @Override // android.view.View
    public void computeScroll() {
        this.s = 1.0f - this.o;
        if (this.n.l(true)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void d(Canvas canvas, View view) {
        int i2 = (this.t & ViewCompat.MEASURED_SIZE_MASK) | (((int) ((((-16777216) & r0) >>> 24) * this.s)) << 24);
        int i3 = this.v;
        if ((i3 & 1) != 0) {
            canvas.clipRect(0, 0, view.getLeft(), getHeight());
        } else if ((i3 & 2) != 0) {
            canvas.clipRect(view.getRight(), 0, getRight(), getHeight());
        } else if ((i3 & 8) != 0) {
            canvas.clipRect(view.getLeft(), view.getBottom(), getRight(), getHeight());
        }
        canvas.drawColor(i2);
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        boolean z = view == this.m;
        boolean zDrawChild = super.drawChild(canvas, view, j);
        if (this.s > 0.0f && z && this.n.u() != 0) {
            d(canvas, view);
        }
        return zDrawChild;
    }

    public final Rect e(Rect rect, View view) {
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

    public final boolean f(int i2, int i3) {
        if (this.w != null) {
            Rect rect = new Rect();
            Iterator<View> it = this.w.iterator();
            while (it.hasNext()) {
                e(rect, it.next());
                if (rect.contains(i2, i3)) {
                    return true;
                }
            }
        }
        List<Rect> list = this.x;
        if (list == null) {
            return false;
        }
        Iterator<Rect> it2 = list.iterator();
        while (it2.hasNext()) {
            if (it2.next().contains(i2, i3)) {
                return true;
            }
        }
        return false;
    }

    public View getContentView() {
        return this.m;
    }

    public List<Rect> getIgnoredRect() {
        return this.x;
    }

    public List<View> getIgnoredViews() {
        return this.w;
    }

    public d getmDragHelper() {
        return this.n;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.l) {
            return false;
        }
        if (this.n.u() == 0 && f((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return false;
        }
        try {
            return this.n.M(motionEvent);
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        this.u = true;
        View view = this.m;
        if (view != null) {
            try {
                int i6 = this.p;
                view.layout(i6, this.q, view.getMeasuredWidth() + i6, this.q + this.m.getMeasuredHeight());
            } catch (OutOfMemoryError e2) {
                g0.j(e2);
            }
        }
        this.u = false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.l) {
            return false;
        }
        if (this.n.u() == 0 && f((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return false;
        }
        try {
            this.n.z(motionEvent);
            return true;
        } catch (Exception e2) {
            g0.k(e2);
            return true;
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.u) {
            return;
        }
        super.requestLayout();
    }

    public void setAllAreaCanScroll(boolean z) {
        this.n.E(z);
    }

    public void setDragHorizontalAngle(double d2) {
        this.n.F(d2);
    }

    public void setDragVerticalAngle(double d2) {
        this.n.H(d2);
    }

    public void setEdgeSize(int i2) {
        this.n.I(i2);
    }

    public void setEdgeTrackingEnabled(int i2) {
        this.f84i = i2;
        this.n.J(i2);
    }

    public void setEnableGesture(boolean z) {
        this.l = z;
    }

    public void setScrimColor(int i2) {
        this.t = i2;
        invalidate();
    }

    public void setScrollThresHold(float f2) {
        if (f2 >= 1.0f || f2 <= 0.0f) {
            throw new IllegalArgumentException("Threshold value should be greater than 0 and less than 1.0");
        }
        this.j = f2;
    }

    public void setSwipeListener(b bVar) {
        b(bVar);
    }

    public void setmDragHelper(d dVar) {
        this.n = dVar;
    }

    public SwipeBackLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        this.j = 0.3f;
        this.l = true;
        this.t = -1728053248;
        this.w = new ArrayList();
        this.x = new ArrayList();
        this.n = d.m(this, new c());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.c.a.g.a.b.SwipeBackLayout, i2, R.style.SwipeBackLayout);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, -1);
        if (dimensionPixelSize > 0) {
            setEdgeSize(dimensionPixelSize);
        }
        setAllAreaCanScroll(false);
        setEdgeTrackingEnabled(y[typedArrayObtainStyledAttributes.getInt(0, 0)]);
        typedArrayObtainStyledAttributes.recycle();
        float f2 = getResources().getDisplayMetrics().density * 400.0f;
        this.n.a();
        this.n.K(f2);
    }
}
