package com.kugou.android.watch.lite.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewConfiguration;
import androidx.core.view.ViewConfigurationCompat;
import com.kugou.android.watch.lite.util.ViewPager;

/* JADX INFO: loaded from: classes.dex */
public class SwipeViewPager extends ViewPager {
    public float G0;
    public float H0;
    public b I0;
    public a J0;
    public int K0;
    public boolean L0;

    public interface a {
        void requestDisallowInterceptTouchEvent();
    }

    public interface b {
        boolean canLeftSwipe();

        boolean canRightSwipe();
    }

    public SwipeViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.L0 = false;
        this.j0 = true;
        this.K0 = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(context));
    }

    public void T(b bVar) {
        this.I0 = bVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00c0  */
    @Override // com.kugou.android.watch.lite.util.ViewPager, android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r9) {
        /*
            Method dump skipped, instruction units count: 301
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kugou.android.watch.lite.common.widget.SwipeViewPager.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }
}
