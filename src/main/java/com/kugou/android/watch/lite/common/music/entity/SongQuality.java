package com.kugou.android.watch.lite.common.music.entity;

/* JADX INFO: loaded from: classes.dex */
public enum SongQuality {
    QUALITY_NONE(-1),
    QUALITY_LOW(0),
    QUALITY_HIGH(1),
    QUALITY_HIGHEST(2),
    QUALITY_SUPER(3);

    private int mType;

    SongQuality(int i2) {
        this.mType = i2;
    }

    public static int compareQualityType(int i2, int i3) {
        return i2 - i3;
    }

    public static SongQuality intToSongQuality(int i2) {
        return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? QUALITY_NONE : QUALITY_SUPER : QUALITY_HIGHEST : QUALITY_HIGH : QUALITY_LOW;
    }

    public static int qualityRefactorValue(int i2) {
        if (i2 == 0) {
            return QUALITY_LOW.getType();
        }
        if (i2 != 1) {
            if (i2 == 2) {
                return QUALITY_HIGHEST.getType();
            }
            if (i2 == 3) {
                return QUALITY_SUPER.getType();
            }
            if (i2 != 4) {
                return QUALITY_NONE.getType();
            }
        }
        return QUALITY_HIGH.getType();
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i2) {
        this.mType = i2;
    }
}
