package com.kugou.uilib.widget.recyclerview.pulltorefresh;

import android.content.Context;
import android.content.res.TypedArray;

/* JADX INFO: loaded from: classes2.dex */
public class DefaultLoadingLayoutFactory extends PtrLoadingLayoutFactory {

    /* JADX INFO: renamed from: com.kugou.uilib.widget.recyclerview.pulltorefresh.DefaultLoadingLayoutFactory$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$kugou$uilib$widget$recyclerview$pulltorefresh$AnimationStyle;

        static {
            int[] iArr = new int[AnimationStyle.values().length];
            $SwitchMap$com$kugou$uilib$widget$recyclerview$pulltorefresh$AnimationStyle = iArr;
            try {
                iArr[AnimationStyle.FLIP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$kugou$uilib$widget$recyclerview$pulltorefresh$AnimationStyle[AnimationStyle.ROTATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // com.kugou.uilib.widget.recyclerview.pulltorefresh.PtrLoadingLayoutFactory
    public LoadingLayout createLoadingLayout(Context context, Mode mode, Orientation orientation, TypedArray typedArray, AnimationStyle animationStyle) {
        return AnonymousClass1.$SwitchMap$com$kugou$uilib$widget$recyclerview$pulltorefresh$AnimationStyle[animationStyle.ordinal()] != 1 ? new RotateLoadingLayout(context, mode, orientation, typedArray) : new FlipLoadingLayout(context, mode, orientation, typedArray);
    }
}
