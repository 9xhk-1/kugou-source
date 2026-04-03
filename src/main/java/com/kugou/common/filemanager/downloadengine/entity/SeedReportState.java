package com.kugou.common.filemanager.downloadengine.entity;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
@Retention(RetentionPolicy.RUNTIME)
public @interface SeedReportState {
    public static final int STATE_CANT_START = 3;
    public static final int STATE_DOWN_FAIL = 4;
    public static final int STATE_EXIST = 1;
    public static final int STATE_NO_REPORT = 5;
    public static final int STATE_NO_SPACE = 2;
    public static final int STATE_OK = 0;
}
