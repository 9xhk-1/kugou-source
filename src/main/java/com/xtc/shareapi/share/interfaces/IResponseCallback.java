package com.xtc.shareapi.share.interfaces;

import com.xtc.shareapi.share.communication.BaseResponse;
import com.xtc.shareapi.share.communication.ShowMessageFromXTC;

/* JADX INFO: loaded from: classes2.dex */
public interface IResponseCallback {
    void onReq(ShowMessageFromXTC.Request request);

    void onResp(boolean z, BaseResponse baseResponse);
}
