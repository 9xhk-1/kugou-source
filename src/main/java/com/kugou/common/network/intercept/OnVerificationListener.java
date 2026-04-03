package com.kugou.common.network.intercept;

import okhttp3.Headers;

/* JADX INFO: loaded from: classes2.dex */
public interface OnVerificationListener {
    Headers getHeaders();

    boolean onIntercept(String str, String str2);
}
