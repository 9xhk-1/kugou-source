package com.kugou.common.filemanager.downloadengine;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
@Retention(RetentionPolicy.RUNTIME)
public @interface HashType {
    public static final int HASH_APP = 3;
    public static final int HASH_AUDIO = 1;
    public static final int HASH_IMAGE = 4;
    public static final int HASH_MV = 2;
    public static final int HASH_OTHER = 0;
}
