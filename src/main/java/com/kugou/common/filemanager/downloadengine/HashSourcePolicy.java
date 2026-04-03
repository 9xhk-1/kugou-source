package com.kugou.common.filemanager.downloadengine;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
@Retention(RetentionPolicy.RUNTIME)
public @interface HashSourcePolicy {
    public static final int COMBINE_SOURCE_BY_PERCENT = 2;
    public static final int MAIN_SOURCE_ONLY = 0;
    public static final int OTHER_SOURCE_AFTER_MAIN = 1;
}
