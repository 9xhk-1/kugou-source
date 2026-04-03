package com.kugou.uilib.widget.recyclerview.pulltorefresh;

import android.annotation.TargetApi;
import android.util.Log;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(9)
public final class OverscrollHelper {
    public static final float DEFAULT_OVERSCROLL_SCALE = 1.0f;
    public static final String LOG_TAG = "OverscrollHelper";

    /* JADX INFO: renamed from: com.kugou.uilib.widget.recyclerview.pulltorefresh.OverscrollHelper$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$kugou$uilib$widget$recyclerview$pulltorefresh$Orientation;

        static {
            int[] iArr = new int[Orientation.values().length];
            $SwitchMap$com$kugou$uilib$widget$recyclerview$pulltorefresh$Orientation = iArr;
            try {
                iArr[Orientation.HORIZONTAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$kugou$uilib$widget$recyclerview$pulltorefresh$Orientation[Orientation.VERTICAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static boolean isAndroidOverScrollEnabled(View view) {
        return view.getOverScrollMode() != 2;
    }

    public static void overScrollBy(KGUIPullToRefreshBase<?> kGUIPullToRefreshBase, int i2, int i3, int i4, int i5, boolean z) {
        overScrollBy(kGUIPullToRefreshBase, i2, i3, i4, i5, 0, z);
    }

    public static void overScrollBy(KGUIPullToRefreshBase<?> kGUIPullToRefreshBase, int i2, int i3, int i4, int i5, int i6, boolean z) {
        overScrollBy(kGUIPullToRefreshBase, i2, i3, i4, i5, i6, 0, 1.0f, z);
    }

    public static void overScrollBy(KGUIPullToRefreshBase<?> kGUIPullToRefreshBase, int i2, int i3, int i4, int i5, int i6, int i7, float f2, boolean z) {
        int scrollX;
        int i8;
        int i9;
        if (AnonymousClass1.$SwitchMap$com$kugou$uilib$widget$recyclerview$pulltorefresh$Orientation[kGUIPullToRefreshBase.getPullToRefreshScrollDirection().ordinal()] != 1) {
            scrollX = kGUIPullToRefreshBase.getScrollY();
            i8 = i4;
            i9 = i5;
        } else {
            scrollX = kGUIPullToRefreshBase.getScrollX();
            i8 = i2;
            i9 = i3;
        }
        if (!kGUIPullToRefreshBase.isPullToRefreshOverScrollEnabled() || kGUIPullToRefreshBase.isRefreshing()) {
            return;
        }
        Mode mode = kGUIPullToRefreshBase.getMode();
        if (mode.permitsPullToRefresh() && !z && i8 != 0) {
            int i10 = i8 + i9;
            Log.d(LOG_TAG, "OverScroll. DeltaX: " + i2 + ", ScrollX: " + i3 + ", DeltaY: " + i4 + ", ScrollY: " + i5 + ", NewY: " + i10 + ", ScrollRange: " + i6 + ", CurrentScroll: " + scrollX);
            if (i10 < 0 - i7) {
                if (mode.showHeaderLoadingLayout()) {
                    if (scrollX == 0) {
                        kGUIPullToRefreshBase.setState(State.OVERSCROLLING);
                    }
                    kGUIPullToRefreshBase.setHeaderScroll((int) (f2 * (scrollX + i10)));
                    return;
                }
                return;
            }
            if (i10 > i6 + i7) {
                if (mode.showFooterLoadingLayout()) {
                    if (scrollX == 0) {
                        kGUIPullToRefreshBase.setState(State.OVERSCROLLING);
                    }
                    kGUIPullToRefreshBase.setHeaderScroll((int) (f2 * ((scrollX + i10) - i6)));
                    return;
                }
                return;
            }
            if (Math.abs(i10) <= i7 || Math.abs(i10 - i6) <= i7) {
                kGUIPullToRefreshBase.setState(State.RESET);
                return;
            }
            return;
        }
        if (z && State.OVERSCROLLING == kGUIPullToRefreshBase.getState()) {
            kGUIPullToRefreshBase.setState(State.RESET);
        }
    }
}
