package com.kugou.uilib.widget.recyclerview.pulltorefresh;

/* JADX INFO: loaded from: classes2.dex */
public enum AnimationStyle {
    ROTATE,
    FLIP,
    FRAME,
    XFRAME,
    XFRAME_DARK_COLOR,
    XFRAME_SMALL;

    public static AnimationStyle getDefault() {
        return FRAME;
    }

    public static AnimationStyle mapIntToValue(int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? ROTATE : XFRAME_SMALL : XFRAME_DARK_COLOR : XFRAME : FRAME : FLIP;
    }
}
