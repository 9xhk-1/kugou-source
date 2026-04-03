package com.kugou.android.watch.lite.base.uiframe;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kugou.android.watch.lite.base.uiframe.FragmentViewBase;

/* JADX INFO: loaded from: classes.dex */
public class FragmentStackView extends FrameLayout {
    public boolean a;
    public int b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FragmentViewBase f85d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public FragmentViewBase f86f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public c f87h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Handler f88i;
    public Runnable j;
    public FragmentViewBase.d k;

    public class a implements Runnable {
        public a(FragmentStackView fragmentStackView) {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.c.a.g.a.d.b0.b.b().f(false);
        }
    }

    public class b implements FragmentViewBase.d {
        public b() {
        }

        @Override // com.kugou.android.watch.lite.base.uiframe.FragmentViewBase.d
        public void draggingStateCompact(FragmentViewBase fragmentViewBase, int i2) {
            if (FragmentStackView.this.f87h != null) {
                FragmentStackView.this.f87h.onDraggingCompactStateChanged(fragmentViewBase, i2);
            }
        }

        @Override // com.kugou.android.watch.lite.base.uiframe.FragmentViewBase.d
        public void onEnterFinished(FragmentViewBase.c cVar) {
            if (FragmentStackView.this.f87h != null) {
                FragmentStackView.this.f87h.onContainerEnterFinished(cVar);
            }
            FragmentStackView.this.n();
        }

        @Override // com.kugou.android.watch.lite.base.uiframe.FragmentViewBase.d
        public void onScrollLeftFinished(FragmentViewBase fragmentViewBase) {
            FragmentStackView.this.n();
        }

        @Override // com.kugou.android.watch.lite.base.uiframe.FragmentViewBase.d
        public void onScrollRightFinished(FragmentViewBase fragmentViewBase, FragmentViewBase fragmentViewBase2) {
            if (FragmentStackView.this.f87h != null) {
                if (fragmentViewBase2 == null) {
                    fragmentViewBase2 = FragmentStackView.this.getTop2ndContainerView();
                }
                FragmentStackView.this.f87h.onContainerScrolledOut(fragmentViewBase2);
            }
        }

        @Override // com.kugou.android.watch.lite.base.uiframe.FragmentViewBase.d
        public void onScrollRightStart(FragmentViewBase fragmentViewBase) {
            if (FragmentStackView.this.f87h != null) {
                FragmentStackView.this.f87h.onContainerScrollStart(FragmentStackView.this.f86f, fragmentViewBase);
            }
        }

        @Override // com.kugou.android.watch.lite.base.uiframe.FragmentViewBase.d
        public void onScrollStateChanged(int i2) {
            FragmentStackView.this.b = i2;
            if (FragmentStackView.this.f87h != null) {
                FragmentStackView.this.f87h.onScrollStateChanged(i2);
            }
            int childCount = FragmentStackView.this.getChildCount();
            while (true) {
                int i3 = childCount - 1;
                if (childCount <= 0) {
                    return;
                }
                FragmentViewBase fragmentViewBaseI = FragmentStackView.this.i(i3);
                if (fragmentViewBaseI != null) {
                    fragmentViewBaseI.q(i2);
                }
                childCount = i3;
            }
        }

        @Override // com.kugou.android.watch.lite.base.uiframe.FragmentViewBase.d
        public void onScrollStatusChange(float f2) {
            if (FragmentStackView.this.f86f != null) {
                FragmentStackView.this.f86f.setVisibility(0);
                FragmentStackView.this.f86f.l(f2);
            }
        }
    }

    public interface c {
        void onContainerEnterFinished(FragmentViewBase.c cVar);

        void onContainerScrollStart(FragmentViewBase fragmentViewBase, FragmentViewBase fragmentViewBase2);

        void onContainerScrolledOut(FragmentViewBase fragmentViewBase);

        void onDraggingCompactStateChanged(FragmentViewBase fragmentViewBase, int i2);

        void onScrollStateChanged(int i2);
    }

    public FragmentStackView(@NonNull Context context) {
        super(context);
        this.a = true;
        this.b = 0;
        this.f85d = null;
        this.f86f = null;
        this.f88i = new Handler(Looper.getMainLooper());
        this.j = new a(this);
        this.k = new b();
        j(context, null, -1);
    }

    public void e(@Nullable FragmentViewBase fragmentViewBase, @Nullable FragmentViewBase fragmentViewBase2) {
        int childCount = getChildCount();
        while (true) {
            int i2 = childCount - 1;
            if (childCount <= 0) {
                break;
            }
            FragmentViewBase fragmentViewBaseI = i(i2);
            if (fragmentViewBaseI == fragmentViewBase || fragmentViewBaseI == fragmentViewBase2) {
                fragmentViewBaseI.setVisibility(0);
            } else {
                fragmentViewBaseI.setVisibility(8);
            }
            childCount = i2;
        }
        h();
        if (fragmentViewBase != null) {
            fragmentViewBase.f(getWidth());
        }
        if (fragmentViewBase2 != null) {
            fragmentViewBase2.h();
        }
    }

    public void f() {
        FragmentViewBase.d dVar = this.k;
        if (dVar != null) {
            dVar.onScrollStateChanged(0);
        }
        n();
    }

    public void g(FragmentViewBase fragmentViewBase) {
        super.addView(fragmentViewBase);
        k();
    }

    public int getScrollState() {
        return this.b;
    }

    public FragmentViewBase getTop1stContainerView() {
        return this.f85d;
    }

    public FragmentViewBase getTop2ndContainerView() {
        return this.f86f;
    }

    public final void h() {
        e.c.a.g.a.d.b0.b.b().f(true);
        this.f88i.removeCallbacks(this.j);
        this.f88i.postDelayed(this.j, FragmentViewBase.s * 2);
    }

    @Nullable
    public FragmentViewBase i(int i2) {
        if (i2 < 0 || i2 >= getChildCount()) {
            return null;
        }
        return (FragmentViewBase) getChildAt(i2);
    }

    public final void j(Context context, AttributeSet attributeSet, int i2) {
        setWillNotDraw(true);
    }

    public final void k() {
        int childCount = getChildCount();
        int i2 = childCount - 1;
        int i3 = childCount - 2;
        for (int i4 = 0; i4 < childCount; i4++) {
            FragmentViewBase fragmentViewBaseI = i(i4);
            if (fragmentViewBaseI != null) {
                if (i4 < i3) {
                    fragmentViewBaseI.setScrollListener(null);
                    fragmentViewBaseI.setTop(false);
                } else if (i4 == i3) {
                    fragmentViewBaseI.setScrollListener(null);
                    this.f86f = fragmentViewBaseI;
                    fragmentViewBaseI.setTop(false);
                } else if (i4 == i2) {
                    fragmentViewBaseI.setScrollListener(this.k);
                    if (fragmentViewBaseI != this.f85d) {
                        this.f85d = fragmentViewBaseI;
                    }
                    fragmentViewBaseI.setTop(true);
                }
            }
        }
        if (i3 < 0) {
            this.f86f = null;
        }
    }

    public void l(@NonNull FragmentViewBase fragmentViewBase, @NonNull FragmentViewBase fragmentViewBase2) {
        int iIndexOfChild = indexOfChild(fragmentViewBase2);
        int iIndexOfChild2 = indexOfChild(fragmentViewBase);
        while (true) {
            iIndexOfChild++;
            if (iIndexOfChild >= iIndexOfChild2) {
                fragmentViewBase2.setVisibility(0);
                fragmentViewBase.n();
                fragmentViewBase.j(fragmentViewBase2);
                fragmentViewBase2.r();
                return;
            }
            View childAt = getChildAt(iIndexOfChild);
            if (childAt != null) {
                childAt.setVisibility(8);
            }
        }
    }

    public void m(FragmentViewBase fragmentViewBase) {
        super.removeView(fragmentViewBase);
        k();
        n();
    }

    public final void n() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (i2 == childCount - 1) {
                childAt.setVisibility(0);
            } else {
                childAt.setVisibility(8);
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.a) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.a) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public void setContainerStateListener(c cVar) {
        this.f87h = cVar;
    }

    public void setTouchEnabled(boolean z) {
        this.a = z;
    }
}
