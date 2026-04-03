package com.kugou.uilib.widget.recyclerview.pulltorefresh;

/* JADX INFO: loaded from: classes2.dex */
public enum Mode {
    DISABLED(0),
    PULL_FROM_START(1),
    PULL_FROM_END(2),
    BOTH(3),
    MANUAL_REFRESH_ONLY(4);

    public static Mode PULL_DOWN_TO_REFRESH;
    public static Mode PULL_UP_TO_REFRESH;
    private int mIntValue;

    static {
        Mode mode = PULL_FROM_START;
        Mode mode2 = PULL_FROM_END;
        PULL_DOWN_TO_REFRESH = mode;
        PULL_UP_TO_REFRESH = mode2;
    }

    Mode(int i2) {
        this.mIntValue = i2;
    }

    public static Mode getDefault() {
        return BOTH;
    }

    public static Mode mapIntToValue(int i2) {
        for (Mode mode : values()) {
            if (i2 == mode.getIntValue()) {
                return mode;
            }
        }
        return getDefault();
    }

    public int getIntValue() {
        return this.mIntValue;
    }

    public boolean permitsPullToRefresh() {
        return (this == DISABLED || this == MANUAL_REFRESH_ONLY) ? false : true;
    }

    public boolean showFooterLoadingLayout() {
        return this == PULL_FROM_END || this == BOTH || this == MANUAL_REFRESH_ONLY;
    }

    public boolean showHeaderLoadingLayout() {
        return this == PULL_FROM_START || this == BOTH;
    }
}
