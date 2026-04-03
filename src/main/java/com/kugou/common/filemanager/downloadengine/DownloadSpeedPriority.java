package com.kugou.common.filemanager.downloadengine;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
@Retention(RetentionPolicy.RUNTIME)
public @interface DownloadSpeedPriority {
    public static final int DOWN_SPEED_PRIORITY_FAST = 1;
    public static final int DOWN_SPEED_PRIORITY_NORMAL = 2;
    public static final int DOWN_SPEED_PRIORITY_SLOW = 3;
    public static final int DOWN_SPEED_PRIORITY_ULTIMATE = 0;
}
