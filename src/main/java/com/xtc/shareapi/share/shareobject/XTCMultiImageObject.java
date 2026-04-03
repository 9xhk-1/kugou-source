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
public class XTCMultiImageObject implements IShareObject {
    private static final String TAG = "Share_XTCMultiImageObject";
    private ArrayList<XTCImageObject> imagePathList;

    public XTCMultiImageObject() {
    }

    @Override // com.xtc.shareapi.share.interfaces.IBundleSerialize
    public BaseResponse checkArgs() {
        ShowMessageFromXTC.Response response = new ShowMessageFromXTC.Response();
        ArrayList<XTCImageObject> arrayList = this.imagePathList;
        if (arrayList == null || arrayList.size() == 0) {
            Log.e(TAG, "checkArgs fail, imagePathList are empty");
            response.setCode(6);
            response.setErrorDesc("share_argument_errorimagePathList are empty");
            return response;
        }
        if (this.imagePathList.size() > 9) {
            Log.e(TAG, "checkArgs fail, imagePathList size big than 9");
            response.setCode(6);
            response.setErrorDesc("share_argument_errorimagePathList size big than 9");
            return response;
        }
        Iterator<XTCImageObject> it = this.imagePathList.iterator();
        while (it.hasNext()) {
            XTCImageObject next = it.next();
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

    public ArrayList<XTCImageObject> getImagePathList() {
        return this.imagePathList;
    }

    public void setImagePathList(ArrayList<XTCImageObject> arrayList) {
        this.imagePathList = arrayList;
    }

    @Override // com.xtc.shareapi.share.interfaces.IBundleSerialize
    public void toBundle(Bundle bundle) {
        bundle.putParcelableArrayList(OpenApiConstant.XTCMultiImageConstant.BUNDLE_IMAGE_PATH_LIST, this.imagePathList);
    }

    public String toString() {
        return "XTCMultiImageObject{imagePathList=" + this.imagePathList + '}';
    }

    @Override // com.xtc.shareapi.share.interfaces.IShareObject
    public int type() {
        return 9;
    }

    public XTCMultiImageObject(ArrayList<String> arrayList) {
        this.imagePathList = this.imagePathList;
    }

    @Override // com.xtc.shareapi.share.interfaces.IBundleSerialize
    public XTCMultiImageObject fromBundle(Bundle bundle) {
        XTCMultiImageObject xTCMultiImageObject = new XTCMultiImageObject();
        xTCMultiImageObject.imagePathList = bundle.getParcelableArrayList(OpenApiConstant.XTCMultiImageConstant.BUNDLE_IMAGE_PATH_LIST);
        return xTCMultiImageObject;
    }
}
