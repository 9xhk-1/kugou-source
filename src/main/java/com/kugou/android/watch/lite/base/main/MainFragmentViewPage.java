package com.kugou.android.watch.lite.base.main;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.core.view.ViewConfigurationCompat;
import com.kugou.android.watch.lite.util.ViewPager;

/* JADX INFO: loaded from: classes.dex */
public class MainFragmentViewPage extends ViewPager {
    public a G0;

    public interface a {
        boolean disallowIntercept();
    }

    public MainFragmentViewPage(Context context) {
        super(context, null);
        T(context);
    }

    public final void T(Context context) {
        this.j0 = true;
        ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(context));
        setChildrenDrawingOrderEnabled(true);
    }

    @Override // com.kugou.android.watch.lite.util.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        a aVar = this.G0;
        if (aVar == null || !aVar.disallowIntercept()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    public MainFragmentViewPage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        T(context);
    }
}
