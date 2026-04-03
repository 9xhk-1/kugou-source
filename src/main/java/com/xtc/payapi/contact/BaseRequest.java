package com.xtc.payapi.contact;

import android.os.Bundle;
import com.xtc.payapi.a.a;
import com.xtc.payapi.constants.PayConstant;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseRequest {
    public String transaction;

    public abstract boolean checkArgs();

    public void fromBundle(Bundle bundle) {
        this.transaction = a.b(bundle, PayConstant.BaseRequestConstant.BASE_REQUEST_TRANSACTION);
    }

    public abstract int getType();

    public void toBundle(Bundle bundle) {
        bundle.putInt(PayConstant.BaseRequestConstant.BASE_REQUEST_TYPE, getType());
        bundle.putString(PayConstant.BaseRequestConstant.BASE_REQUEST_TRANSACTION, this.transaction);
    }
}
