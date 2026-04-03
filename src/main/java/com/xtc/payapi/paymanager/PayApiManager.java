package com.xtc.payapi.paymanager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.xtc.payapi.a.b;
import com.xtc.payapi.constants.PayConstant;
import com.xtc.payapi.contact.BaseRequest;
import com.xtc.payapi.contact.BaseResponse;
import com.xtc.payapi.contact.IPayResponseCallback;
import com.xtc.payapi.contact.SendPayMesToXTC;
import com.xtc.payapi.paymanager.a;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public class PayApiManager {
    private static final String a = PayConstant.TAG + PayApiManager.class.getSimpleName();
    private Context b;

    public PayApiManager(Context context) {
        this.b = context;
    }

    public void handleIntent(Intent intent, IPayResponseCallback iPayResponseCallback) {
        if (intent == null || intent.getExtras() == null || iPayResponseCallback == null) {
            Log.d(a, "current intent or callback is null");
            return;
        }
        SendPayMesToXTC.Response response = new SendPayMesToXTC.Response();
        response.fromBundle(intent.getExtras());
        response.checkArgs();
        if (TextUtils.isEmpty(response.errorCode)) {
            return;
        }
        iPayResponseCallback.onResponse(response);
    }

    public boolean isSupportPay() {
        int iA = b.a(this.b, PayConstant.HostAppInfo.HOST_PACKAGE_NAME, PayConstant.HostAppInfo.META_DATA_VERSION_KEY);
        String str = a;
        Log.d(str, "hostSdkVersion: " + iA);
        if (iA >= 1) {
            return true;
        }
        Log.d(str, "check sdk version fail");
        return false;
    }

    public boolean sendRequestToXTC(BaseRequest baseRequest) {
        Context context = this.b;
        if (context == null) {
            Log.e(a, "sendRequestToXTC but the context is null!");
            return false;
        }
        if (baseRequest == null) {
            Log.d(a, "sendRequestToXTC but baseRequest is null!");
            return false;
        }
        if (!(context instanceof Activity) || TextUtils.isEmpty(context.getPackageName()) || TextUtils.isEmpty(this.b.getClass().getName())) {
            Log.e(a, "you should use an activity context here!");
            return false;
        }
        if (!b.a(this.b)) {
            Log.e(a, "network is not connected");
            b.c(this.b, BaseResponse.Code.ERROR_NETWORK, "net work error");
            return false;
        }
        if (!baseRequest.checkArgs()) {
            Log.e(a, "sendReq checkArgs fail");
            return false;
        }
        if (!isSupportPay()) {
            Log.d(a, "check sdk version fail");
            b.c(this.b, BaseResponse.Code.ERROR_VERSION_NOT_SUPPORT, "version not support");
            return false;
        }
        baseRequest.transaction = String.valueOf(System.currentTimeMillis()) + UUID.randomUUID();
        Bundle bundle = new Bundle();
        baseRequest.toBundle(bundle);
        if (baseRequest.getType() == 2) {
            a.C0028a c0028a = new a.C0028a();
            c0028a.f288d = bundle;
            c0028a.a = PayConstant.HostAppInfo.HOST_PACKAGE_NAME;
            c0028a.b = b.b(this.b, PayConstant.HostAppInfo.HOST_PACKAGE_NAME, PayConstant.HostAppInfo.META_DATA_HOST_CLASS_NAME_KEY);
            return a.a(this.b, c0028a);
        }
        Log.e(a, "don't know baseReq type : " + baseRequest.getType());
        return false;
    }
}
