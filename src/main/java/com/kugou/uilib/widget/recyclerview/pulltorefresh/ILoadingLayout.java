package com.kugou.uilib.widget.recyclerview.pulltorefresh;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public interface ILoadingLayout {
    int getContentSize();

    View getContentView();

    void onPull(float f2);

    void onScrollOffset(int i2);

    void pullToRefresh();

    void refreshing();

    void releaseToRefresh();

    void reset();

    void setLastUpdatedLabel(CharSequence charSequence);

    void setLoadingDrawable(Drawable drawable);

    void setPaddingTop(int i2);

    void setPullLabel(CharSequence charSequence);

    void setRefreshingLabel(CharSequence charSequence);

    void setReleaseLabel(CharSequence charSequence);

    void setTextTypeface(Typeface typeface);

    void setVisibility(int i2);
}
