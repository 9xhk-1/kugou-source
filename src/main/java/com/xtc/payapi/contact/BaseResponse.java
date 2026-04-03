package com.xtc.payapi.contact;

import android.os.Bundle;
import com.xtc.payapi.a.a;
import com.xtc.payapi.constants.PayConstant;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseResponse {
    public String errorCode;
    public String errorDesc;
    public String transaction;

    public interface Code {
        public static final String ERROR_NETWORK = "-1";
        public static final String ERROR_OTHER = "-3";
        public static final String ERROR_VERSION_NOT_SUPPORT = "-2";
        public static final String PAY_SUCCESS = "1";
    }

    public interface Desc {
        public static final String DESC_OTHER = "other_error";
    }

    public abstract boolean checkArgs();

    public void fromBundle(Bundle bundle) {
        this.errorCode = a.b(bundle, PayConstant.BaseResponseConstant.BASE_RESPONSE_ERROR_CODE);
        this.errorDesc = a.b(bundle, PayConstant.BaseResponseConstant.BASE_RESPONSE_ERROR_DESC);
        this.transaction = a.b(bundle, PayConstant.BaseResponseConstant.BASE_RESPONSE_TRANSACTION);
    }

    public abstract int getType();

    public void toBundle(Bundle bundle) {
        bundle.putInt(PayConstant.BaseResponseConstant.BASE_RESPONSE_TYPE, getType());
        bundle.putString(PayConstant.BaseResponseConstant.BASE_RESPONSE_ERROR_CODE, this.errorCode);
        bundle.putString(PayConstant.BaseResponseConstant.BASE_RESPONSE_ERROR_DESC, this.errorDesc);
        bundle.putString(PayConstant.BaseResponseConstant.BASE_RESPONSE_TRANSACTION, this.transaction);
    }
}
