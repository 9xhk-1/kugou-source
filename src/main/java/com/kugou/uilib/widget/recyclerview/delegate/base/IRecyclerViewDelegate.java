package com.kugou.uilib.widget.recyclerview.delegate.base;

import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.kugou.uilib.widget.baseDelegate.IViewDelegate;

/* JADX INFO: loaded from: classes2.dex */
public interface IRecyclerViewDelegate extends IViewDelegate<RecyclerView> {
    boolean dispatchTouchEvent(MotionEvent motionEvent);

    boolean onInterceptTouchEvent(MotionEvent motionEvent);

    boolean onTouchEvent(MotionEvent motionEvent);
}
