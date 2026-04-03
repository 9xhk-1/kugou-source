package com.kugou.common.filemanager.downloadengine.entity;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
@Retention(RetentionPolicy.RUNTIME)
public @interface ProxyType {
    public static final int PT_HTTP = 2;
    public static final int PT_NONE = 0;
    public static final int PT_UDP_SOCKS = 1;
}
