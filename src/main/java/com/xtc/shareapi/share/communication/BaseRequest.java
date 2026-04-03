package com.xtc.shareapi.share.communication;

import android.os.Bundle;
import com.xtc.shareapi.share.communication.SendMessageToXTC;
import com.xtc.shareapi.share.constant.OpenApiConstant;
import com.xtc.shareapi.share.interfaces.IBundleSerialize;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseRequest implements IBundleSerialize {
    private String transaction;

    @Override // com.xtc.shareapi.share.interfaces.IBundleSerialize
    public BaseResponse checkArgs() {
        SendMessageToXTC.Response response = new SendMessageToXTC.Response();
        response.setCode(1);
        return response;
    }

    @Override // com.xtc.shareapi.share.interfaces.IBundleSerialize
    public IBundleSerialize fromBundle(Bundle bundle) {
        this.transaction = bundle.getString(OpenApiConstant.BaseRequestConstant.BASE_REQUEST_TRANSACTION);
        return this;
    }

    public String getTransaction() {
        return this.transaction;
    }

    public abstract int getType();

    public void setTransaction(String str) {
        this.transaction = str;
    }

    @Override // com.xtc.shareapi.share.interfaces.IBundleSerialize
    public void toBundle(Bundle bundle) {
        bundle.putString(OpenApiConstant.BaseRequestConstant.BASE_REQUEST_TRANSACTION, this.transaction);
    }

    public String toString() {
        return "BaseRequest{transaction='" + this.transaction + "'}";
    }
}
