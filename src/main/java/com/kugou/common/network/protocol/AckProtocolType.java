package com.kugou.common.network.protocol;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface AckProtocolType {
    public static final int HTTP = 3;
    public static final int HTTPS = 1;
    public static final int OLD = 0;
    public static final int QUIC = 2;
}
