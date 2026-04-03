package com.kugou.common.filemanager.downloadengine.types;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
@Retention(RetentionPolicy.RUNTIME)
public @interface TargetCryptType {
    public static final int DECRYPT = 1;
    public static final int ENCRYPT = 2;
    public static final int KEEP = 0;
}
