package com.xtc.shareapi.share.jumpmoment;

import android.text.TextUtils;
import android.util.Log;
import com.xtc.shareapi.share.communication.BaseResponse;
import com.xtc.shareapi.share.communication.ShowMessageFromXTC;
import com.xtc.shareapi.share.interfaces.IJumpToMomentObject;

/* JADX INFO: loaded from: classes2.dex */
public class JumpToMomentFromAddress implements IJumpToMomentObject {
    private static final String TAG = "JumpToMomentFromAddress";
    private String addressId;
    private JumpToMomentBase base;

    @Override // com.xtc.shareapi.share.interfaces.IJumpToMomentObject
    public BaseResponse checkArgs() {
        ShowMessageFromXTC.Response response = new ShowMessageFromXTC.Response();
        if (TextUtils.isEmpty(this.addressId)) {
            Log.e(TAG, "checkArgs fail ,addressId is null or empty");
            response.setCode(6);
            response.setErrorDesc("addressId is null or empty");
            return response;
        }
        JumpToMomentBase jumpToMomentBase = this.base;
        if (jumpToMomentBase != null) {
            return jumpToMomentBase.checkArgs();
        }
        Log.e(TAG, "checkArgs fail ,poiInfo is null");
        response.setCode(6);
        response.setErrorDesc("checkArgs fail ,poiInfo is null");
        return response;
    }

    public String getAddressId() {
        return this.addressId;
    }

    public JumpToMomentBase getBase() {
        return this.base;
    }

    public void setAddressId(String str) {
        this.addressId = str;
    }

    public void setBase(JumpToMomentBase jumpToMomentBase) {
        this.base = jumpToMomentBase;
    }

    @Override // com.xtc.shareapi.share.interfaces.IJumpToMomentObject
    public int type() {
        return 2;
    }
}
