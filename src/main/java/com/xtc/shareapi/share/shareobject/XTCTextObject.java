package com.xtc.shareapi.share.shareobject;

import android.os.Bundle;
import android.util.Log;
import com.xtc.shareapi.share.communication.BaseResponse;
import com.xtc.shareapi.share.communication.ShowMessageFromXTC;
import com.xtc.shareapi.share.constant.OpenApiConstant;
import com.xtc.shareapi.share.interfaces.IShareObject;

/* JADX INFO: loaded from: classes2.dex */
public class XTCTextObject implements IShareObject {
    private static final int LENGTH_LIMIT = 1024;
    private static final String TAG = OpenApiConstant.TAG + XTCTextObject.class.getSimpleName();
    private String text;

    public XTCTextObject() {
    }

    @Override // com.xtc.shareapi.share.interfaces.IBundleSerialize
    public BaseResponse checkArgs() {
        ShowMessageFromXTC.Response response = new ShowMessageFromXTC.Response();
        String str = this.text;
        if (str != null && str.length() != 0 && this.text.length() <= 1024) {
            response.setCode(1);
            return response;
        }
        Log.e(TAG, "checkArgs fail, text is invalid");
        response.setCode(6);
        response.setErrorDesc("share_argument_error, text is invalid");
        return response;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String str) {
        this.text = str;
    }

    @Override // com.xtc.shareapi.share.interfaces.IBundleSerialize
    public void toBundle(Bundle bundle) {
        bundle.putString(OpenApiConstant.XTCTextConstant.BUNDLE_TEXT, this.text);
    }

    public String toString() {
        return "XTCTextObject{text='" + this.text + "'}";
    }

    @Override // com.xtc.shareapi.share.interfaces.IShareObject
    public int type() {
        return 1;
    }

    public XTCTextObject(String str) {
        this.text = str;
    }

    @Override // com.xtc.shareapi.share.interfaces.IBundleSerialize
    public XTCTextObject fromBundle(Bundle bundle) {
        XTCTextObject xTCTextObject = new XTCTextObject();
        xTCTextObject.text = bundle.getString(OpenApiConstant.XTCTextConstant.BUNDLE_TEXT);
        return xTCTextObject;
    }
}
