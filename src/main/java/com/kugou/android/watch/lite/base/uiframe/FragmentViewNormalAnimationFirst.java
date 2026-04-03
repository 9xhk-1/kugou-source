package com.kugou.android.watch.lite.base.uiframe;

import android.content.Context;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment;
import e.c.a.g.a.d.b0.a;

/* JADX INFO: loaded from: classes.dex */
public class FragmentViewNormalAnimationFirst extends FragmentViewNormal {
    public boolean N;
    public final boolean O;
    public final boolean P;

    public FragmentViewNormalAnimationFirst(@NonNull Context context, @NonNull a aVar) {
        super(context);
        this.N = false;
        if (aVar.hasFakeContent()) {
            View view = new View(context);
            float dimension = getResources().getDimension(aVar.fakeContentHeight());
            int color = getResources().getColor(aVar.fakeContentColor());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) dimension);
            view.setBackgroundColor(color);
            view.setLayoutParams(layoutParams);
            addView(view);
        }
        boolean zSkinEnable = aVar.skinEnable();
        this.O = zSkinEnable;
        if (!zSkinEnable) {
            setBackgroundColor(getResources().getColor(aVar.backgroundColor()));
        }
        this.P = aVar.animationFirstForbiddenEnable();
        aVar.hasPlayingBar();
    }

    public final boolean F() {
        return Build.VERSION.SDK_INT < 23;
    }

    public final void G() {
        if (!this.O || this.N) {
            return;
        }
        getLocationInWindow(new int[2]);
    }

    @Override // com.kugou.android.watch.lite.base.uiframe.FragmentViewBase
    public void e(AbsFrameworkFragment absFrameworkFragment, boolean z) {
        super.e(absFrameworkFragment, z);
        if (this.N && (absFrameworkFragment instanceof e.c.a.g.a.d.p.a)) {
            return;
        }
        this.N = true;
        removeAllViews();
        setBackground(null);
    }

    @Override // com.kugou.android.watch.lite.base.uiframe.FragmentViewNormal, com.kugou.android.watch.lite.base.uiframe.FragmentViewBase
    public boolean i() {
        return (this.P && F()) ? false : true;
    }

    @Override // com.kugou.android.watch.lite.base.uiframe.FragmentViewSwipeBase, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.N) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // com.kugou.android.watch.lite.base.swipeback.CircleFrameLayout, android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        G();
    }

    @Override // com.kugou.android.watch.lite.base.uiframe.FragmentViewSwipeBase, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.N) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }
}
