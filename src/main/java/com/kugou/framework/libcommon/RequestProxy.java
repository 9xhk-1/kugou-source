package com.kugou.framework.libcommon;

import com.kugou.framework.libcommon.netcore.HttpBasicRequest;

/* JADX INFO: loaded from: classes2.dex */
public interface RequestProxy extends INoProguard {
    CustomResponse doRequest(String str, HttpBasicRequest httpBasicRequest);
}
