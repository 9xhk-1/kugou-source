package com.xtc.shareapi.share.interfaces;

import com.xtc.shareapi.share.communication.BaseResponse;

/* JADX INFO: loaded from: classes2.dex */
public interface IJumpToMomentObject {
    public static final int FROM_ALBUM = 1;
    public static final int FROM_CAMARA = 0;
    public static final int FROM_OUTSIDE = 2;

    BaseResponse checkArgs();

    int type();
}
