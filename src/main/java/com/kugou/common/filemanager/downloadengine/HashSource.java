package com.kugou.common.filemanager.downloadengine;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
@Retention(RetentionPolicy.RUNTIME)
public @interface HashSource {
    public static final int MOBILE_SOURCE = 2;
    public static final int NONE_SOURCE = 0;
    public static final int PC_SOURCE = 1;
}
