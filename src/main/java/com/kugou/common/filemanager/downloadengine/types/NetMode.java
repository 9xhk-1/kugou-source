package com.kugou.common.filemanager.downloadengine.types;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
@Retention(RetentionPolicy.RUNTIME)
public @interface NetMode {
    public static final int NET_MODE_NONE = 0;
    public static final int NET_MODE_WIFI = 1;
    public static final int NET_MODE_WWAN = 2;
}
