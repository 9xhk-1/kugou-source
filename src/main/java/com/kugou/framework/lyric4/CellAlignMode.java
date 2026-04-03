package com.kugou.framework.lyric4;

import android.support.annotation.IntDef;
import android.support.v4.media.MediaDescriptionCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public class CellAlignMode {
    public static final int ALIGN_CENTER = 0;
    public static final int ALIGN_LEFT = 1;
    public static final int ALIGN_LEFT_RIGHT = 3;
    public static final int ALIGN_RIGHT = 2;

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    @IntDef({0, 1, 2, MediaDescriptionCompat.BT_FOLDER_TYPE_ARTISTS})
    public @interface Mode {
    }
}
