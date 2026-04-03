package com.xtc.shareapi.share.manager;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.xtc.shareapi.share.communication.SendMessageToXTC;
import com.xtc.shareapi.share.communication.ShowMessageFromXTC;
import com.xtc.shareapi.share.constant.OpenApiConstant;
import com.xtc.shareapi.share.interfaces.IResponseCallback;
import com.xtc.shareapi.share.interfaces.IXTCCallback;

/* JADX INFO: loaded from: classes2.dex */
public class XTCCallbackImpl implements IXTCCallback {
    private String TAG = OpenApiConstant.TAG + XTCCallbackImpl.class.getSimpleName();
    private Context context;

    public XTCCallbackImpl() {
    }

    @Override // com.xtc.shareapi.share.interfaces.IXTCCallback
    public boolean handleIntent(Intent intent, IResponseCallback iResponseCallback) {
        if (intent == null || iResponseCallback == null) {
            Log.d(OpenApiConstant.TAG, "current intent or callback is null");
            return false;
        }
        int intExtra = intent.getIntExtra(OpenApiConstant.ResponseConstant.BUNDLE_ERROR_CODE, -1);
        if (intExtra == -1) {
            Log.d(this.TAG, "current result is  no share event");
            return false;
        }
        if (intExtra == 1000) {
            iResponseCallback.onReq(new ShowMessageFromXTC.Request().fromBundle(intent.getExtras()));
            return true;
        }
        iResponseCallback.onResp(intExtra == 1, new SendMessageToXTC.Response().fromBundle(intent.getExtras()));
        return true;
    }

    public XTCCallbackImpl(Context context) {
        this.context = context;
    }
}
