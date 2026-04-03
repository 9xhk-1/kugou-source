package com.xtc.shareapi.share.shareobject;

import android.os.Bundle;
import android.util.Log;
import com.xtc.shareapi.share.communication.BaseResponse;
import com.xtc.shareapi.share.communication.ShowMessageFromXTC;
import com.xtc.shareapi.share.constant.OpenApiConstant;
import com.xtc.shareapi.share.interfaces.IShareObject;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class XTCMultiVideoObject implements IShareObject {
    private static final String TAG = "Share_XTCMultiLivePhotoObject";
    private ArrayList<XTCVideoObject> videoObjectList;

    public XTCMultiVideoObject() {
    }

    @Override // com.xtc.shareapi.share.interfaces.IBundleSerialize
    public BaseResponse checkArgs() {
        ShowMessageFromXTC.Response response = new ShowMessageFromXTC.Response();
        ArrayList<XTCVideoObject> arrayList = this.videoObjectList;
        if (arrayList == null || arrayList.size() == 0) {
            Log.e(TAG, "checkArgs fail, videoObjectList are empty");
            response.setCode(6);
            response.setErrorDesc("share_argument_errorvideoObjectList are empty");
            return response;
        }
        if (this.videoObjectList.size() > 9) {
            Log.e(TAG, "checkArgs fail, videoObjectList size big than 9");
            response.setCode(15);
            response.setErrorDesc("share_count_too_many_error, videoObjectList size big than 9");
            return response;
        }
        Iterator<XTCVideoObject> it = this.videoObjectList.iterator();
        while (it.hasNext()) {
            XTCVideoObject next = it.next();
            if (next == null) {
                it.remove();
            } else {
                BaseResponse baseResponseCheckArgs = next.checkArgs();
                if (baseResponseCheckArgs.getCode() != 1) {
                    return baseResponseCheckArgs;
                }
            }
        }
        response.setCode(1);
        return response;
    }

    public ArrayList<XTCVideoObject> getVideoObjectList() {
        return this.videoObjectList;
    }

    public void setVideoObjectList(ArrayList<XTCVideoObject> arrayList) {
        this.videoObjectList = arrayList;
    }

    @Override // com.xtc.shareapi.share.interfaces.IBundleSerialize
    public void toBundle(Bundle bundle) {
        bundle.putParcelableArrayList(OpenApiConstant.XTCMultiVideoConstant.BUNDLE_VIDEO_LIST, this.videoObjectList);
    }

    public String toString() {
        return "XTCMultiVideoObject{xtcVideoObject=" + this.videoObjectList + '}';
    }

    @Override // com.xtc.shareapi.share.interfaces.IShareObject
    public int type() {
        return 11;
    }

    public XTCMultiVideoObject(ArrayList<XTCVideoObject> arrayList) {
        this.videoObjectList = arrayList;
    }

    @Override // com.xtc.shareapi.share.interfaces.IBundleSerialize
    public XTCMultiVideoObject fromBundle(Bundle bundle) {
        XTCMultiVideoObject xTCMultiVideoObject = new XTCMultiVideoObject();
        xTCMultiVideoObject.videoObjectList = bundle.getParcelableArrayList(OpenApiConstant.XTCMultiVideoConstant.BUNDLE_VIDEO_LIST);
        return xTCMultiVideoObject;
    }
}
