package com.kugou.uilib.widget.recyclerview.pulltorefresh;

import android.content.Context;
import android.content.res.TypedArray;

/* JADX INFO: loaded from: classes2.dex */
public abstract class PtrLoadingLayoutFactory {
    public static PtrLoadingLayoutFactory getDefault() {
        return new DefaultLoadingLayoutFactory();
    }

    public abstract ILoadingLayout createLoadingLayout(Context context, Mode mode, Orientation orientation, TypedArray typedArray, AnimationStyle animationStyle);
}
