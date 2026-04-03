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
public class XTCMultiLivePhotoObject implements IShareObject {
    private static final String TAG = "Share_XTCMultiLivePhotoObject";
    private ArrayList<XTCLivePhotoObject> photoObjectList;

    public XTCMultiLivePhotoObject() {
    }

    @Override // com.xtc.shareapi.share.interfaces.IBundleSerialize
    public BaseResponse checkArgs() {
        ShowMessageFromXTC.Response response = new ShowMessageFromXTC.Response();
        ArrayList<XTCLivePhotoObject> arrayList = this.photoObjectList;
        if (arrayList == null || arrayList.size() == 0) {
            Log.e(TAG, "checkArgs fail, photoObjectList are empty");
            response.setCode(6);
            response.setErrorDesc("share_argument_errorphotoObjectList are empty");
            return response;
        }
        if (this.photoObjectList.size() > 9) {
            Log.e(TAG, "checkArgs fail, photoObjectList size big than 9");
            response.setCode(15);
            response.setErrorDesc("share_count_too_many_error, photoObjectList size big than 9");
            return response;
        }
        Iterator<XTCLivePhotoObject> it = this.photoObjectList.iterator();
        while (it.hasNext()) {
            XTCLivePhotoObject next = it.next();
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

    public ArrayList<XTCLivePhotoObject> getPhotoObjectList() {
        return this.photoObjectList;
    }

    public void setPhotoObjectList(ArrayList<XTCLivePhotoObject> arrayList) {
        this.photoObjectList = arrayList;
    }

    @Override // com.xtc.shareapi.share.interfaces.IBundleSerialize
    public void toBundle(Bundle bundle) {
        bundle.putParcelableArrayList(OpenApiConstant.XTCMultiLivePhotoConstant.BUNDLE_LIVE_PHOTO_LIST, this.photoObjectList);
    }

    public String toString() {
        return "XTCMultiLivePhotoObject{photoObjectList=" + this.photoObjectList + '}';
    }

    @Override // com.xtc.shareapi.share.interfaces.IShareObject
    public int type() {
        return 10;
    }

    public XTCMultiLivePhotoObject(ArrayList<XTCLivePhotoObject> arrayList) {
        this.photoObjectList = arrayList;
    }

    @Override // com.xtc.shareapi.share.interfaces.IBundleSerialize
    public XTCMultiLivePhotoObject fromBundle(Bundle bundle) {
        XTCMultiLivePhotoObject xTCMultiLivePhotoObject = new XTCMultiLivePhotoObject();
        xTCMultiLivePhotoObject.photoObjectList = bundle.getParcelableArrayList(OpenApiConstant.XTCMultiLivePhotoConstant.BUNDLE_LIVE_PHOTO_LIST);
        return xTCMultiLivePhotoObject;
    }
}
