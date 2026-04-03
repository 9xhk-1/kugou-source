package com.kugou.common.filemanager.downloadengine.entity;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
@Retention(RetentionPolicy.RUNTIME)
public @interface SeedError {
    public static final int SEED_ERR_CLIENT_LIMIT = 6;
    public static final int SEED_ERR_FLOW_LIMIT = 4;
    public static final int SEED_ERR_NO_TASK = 3;
    public static final int SEED_ERR_QPS_LIMIT = 5;
    public static final int SEED_ERR_TIMEOUT = 1;
    public static final int SEED_ERR_TRACKER_FAIL = 2;
    public static final int SEED_OK = 0;
}
