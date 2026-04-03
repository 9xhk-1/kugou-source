package com.xtc.shareapi.share.shareobject;

import android.os.Bundle;
import android.util.Log;
import com.xtc.shareapi.share.bean.SerializableMap;
import com.xtc.shareapi.share.communication.BaseResponse;
import com.xtc.shareapi.share.communication.ShowMessageFromXTC;
import com.xtc.shareapi.share.constant.OpenApiConstant;
import com.xtc.shareapi.share.interfaces.IShareObject;

/* JADX INFO: loaded from: classes2.dex */
public class XTCWebObject implements IShareObject {
    private static final int LENGTH_LIMIT = 1024;
    private static final String TAG = OpenApiConstant.TAG + XTCWebObject.class.getSimpleName();
    private String extInfo;
    private SerializableMap extMap;
    private int rtosSupport;
    private String url;

    @Override // com.xtc.shareapi.share.interfaces.IBundleSerialize
    public BaseResponse checkArgs() {
        ShowMessageFromXTC.Response response = new ShowMessageFromXTC.Response();
        String str = TAG;
        Log.d(str, "start checkArgs");
        String str2 = this.extInfo;
        if (str2 != null && str2.length() > 1024) {
            Log.e(str, "checkArgs fail, the program extInfo is too null or too long");
            response.setCode(6);
            response.setErrorDesc("share_argument_error,the program extInfo is null or too long");
            return response;
        }
        String str3 = this.url;
        if (str3 != null && str3.length() <= 1024) {
            response.setCode(1);
            return response;
        }
        Log.e(str, "checkArgs fail, the  url is empty or the url is too long");
        response.setCode(6);
        response.setErrorDesc("share_argument_error, the  url is empty or the url is too long");
        return response;
    }

    public String getExtInfo() {
        return this.extInfo;
    }

    public SerializableMap getExtMap() {
        return this.extMap;
    }

    public int getRtosSupport() {
        return this.rtosSupport;
    }

    public String getUrl() {
        return this.url;
    }

    public void setExtInfo(String str) {
        this.extInfo = str;
    }

    public void setExtMap(SerializableMap serializableMap) {
        this.extMap = serializableMap;
    }

    public void setRtosSupport(int i2) {
        this.rtosSupport = i2;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    @Override // com.xtc.shareapi.share.interfaces.IBundleSerialize
    public void toBundle(Bundle bundle) {
        bundle.putString(OpenApiConstant.XTCWebConstant.BUNDLE_WEB_EXTEND_INFO, this.extInfo);
        bundle.putString(OpenApiConstant.XTCWebConstant.BUNDLE_WEB_URL, this.url);
        bundle.putParcelable(OpenApiConstant.XTCWebConstant.BUILDER_WEB_MAP, getExtMap());
        bundle.putInt(OpenApiConstant.XTCWebConstant.BUILDER_WEB_RTOS_SUPPORT, getRtosSupport());
    }

    public String toString() {
        return "XTCWebObject{url='" + this.url + "', extInfo='" + this.extInfo + "', extMap=" + this.extMap + ", rtosSupport=" + this.rtosSupport + '}';
    }

    @Override // com.xtc.shareapi.share.interfaces.IShareObject
    public int type() {
        return 6;
    }

    @Override // com.xtc.shareapi.share.interfaces.IBundleSerialize
    public XTCWebObject fromBundle(Bundle bundle) {
        XTCWebObject xTCWebObject = new XTCWebObject();
        xTCWebObject.extInfo = bundle.getString(OpenApiConstant.XTCWebConstant.BUNDLE_WEB_EXTEND_INFO);
        xTCWebObject.url = bundle.getString(OpenApiConstant.XTCWebConstant.BUNDLE_WEB_URL);
        bundle.getString(OpenApiConstant.BuilderConstant.BUILDER_WEB_BUNDLE_MAP);
        xTCWebObject.extMap = (SerializableMap) bundle.getParcelable(OpenApiConstant.XTCWebConstant.BUILDER_WEB_MAP);
        xTCWebObject.rtosSupport = bundle.getInt(OpenApiConstant.XTCWebConstant.BUILDER_WEB_RTOS_SUPPORT);
        return xTCWebObject;
    }
}
