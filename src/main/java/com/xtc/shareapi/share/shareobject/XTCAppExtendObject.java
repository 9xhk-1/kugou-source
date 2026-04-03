package com.xtc.shareapi.share.shareobject;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.xtc.shareapi.share.communication.BaseResponse;
import com.xtc.shareapi.share.communication.ShowMessageFromXTC;
import com.xtc.shareapi.share.constant.OpenApiConstant;
import com.xtc.shareapi.share.interfaces.IShareObject;

/* JADX INFO: loaded from: classes2.dex */
public class XTCAppExtendObject implements IShareObject {
    private static final int LENGTH_LIMIT = 1024;
    private static final String TAG = OpenApiConstant.TAG + XTCAppExtendObject.class.getSimpleName();
    private String extInfo;
    private String startActivity;

    @Override // com.xtc.shareapi.share.interfaces.IBundleSerialize
    public BaseResponse checkArgs() {
        ShowMessageFromXTC.Response response = new ShowMessageFromXTC.Response();
        String str = this.extInfo;
        if (str != null && str.length() > 1024) {
            Log.e(TAG, "checkArgs fail, the program extInfo is too long");
            response.setCode(6);
            response.setErrorDesc("share_argument_error,the program extInfo is too long");
            return response;
        }
        if (!TextUtils.isEmpty(this.startActivity) && this.startActivity.length() <= 1024) {
            response.setCode(1);
            return response;
        }
        Log.e(TAG, "checkArgs fail, the program startActivity name is empty or the program name is too long");
        response.setCode(6);
        response.setErrorDesc("share_argument_error,the program startActivity name is empty or the program name is too long");
        return response;
    }

    public String getExtInfo() {
        return this.extInfo;
    }

    public String getStartActivity() {
        return this.startActivity;
    }

    public void setExtInfo(String str) {
        this.extInfo = str;
    }

    public void setStartActivity(String str) {
        this.startActivity = str;
    }

    @Override // com.xtc.shareapi.share.interfaces.IBundleSerialize
    public void toBundle(Bundle bundle) {
        bundle.putString(OpenApiConstant.XTCAppExtendConstant.BUNDLE_EXTEND_INFO, this.extInfo);
        bundle.putString(OpenApiConstant.XTCAppExtendConstant.BUNDLE_START_ACTIVITY, this.startActivity);
    }

    public String toString() {
        return "XTCAppExtendObject{extInfo='" + this.extInfo + "', startActivity='" + this.startActivity + "'}";
    }

    @Override // com.xtc.shareapi.share.interfaces.IShareObject
    public int type() {
        return 3;
    }

    @Override // com.xtc.shareapi.share.interfaces.IBundleSerialize
    public XTCAppExtendObject fromBundle(Bundle bundle) {
        XTCAppExtendObject xTCAppExtendObject = new XTCAppExtendObject();
        xTCAppExtendObject.extInfo = bundle.getString(OpenApiConstant.XTCAppExtendConstant.BUNDLE_EXTEND_INFO);
        xTCAppExtendObject.startActivity = bundle.getString(OpenApiConstant.XTCAppExtendConstant.BUNDLE_START_ACTIVITY);
        return xTCAppExtendObject;
    }
}
