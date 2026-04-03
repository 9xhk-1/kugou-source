package com.kugou.uilib.widget.recyclerview.pulltorefresh;

/* JADX INFO: loaded from: classes2.dex */
public enum State {
    RESET(0),
    PULL_TO_REFRESH(1),
    RELEASE_TO_REFRESH(2),
    REFRESHING(8),
    MANUAL_REFRESHING(9),
    OVERSCROLLING(16),
    RELEASE_TO_SHOW_PINNED_HEADER(17),
    SHOW_PINNED_HEADER(18);

    private int mIntValue;

    State(int i2) {
        this.mIntValue = i2;
    }

    public static State mapIntToValue(int i2) {
        for (State state : values()) {
            if (i2 == state.getIntValue()) {
                return state;
            }
        }
        return RESET;
    }

    public int getIntValue() {
        return this.mIntValue;
    }
}
