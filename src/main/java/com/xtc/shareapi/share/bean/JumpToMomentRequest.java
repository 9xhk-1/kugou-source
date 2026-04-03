package com.xtc.shareapi.share.bean;

import android.util.Log;
import com.xtc.shareapi.share.communication.BaseResponse;
import com.xtc.shareapi.share.communication.ShowMessageFromXTC;
import com.xtc.shareapi.share.interfaces.IJumpToMomentObject;

/* JADX INFO: loaded from: classes2.dex */
public class JumpToMomentRequest {
    private static final String TAG = "JumpToMomentRequest";
    private IJumpToMomentObject jumpToMomentObject;

    public BaseResponse checkArgs() {
        IJumpToMomentObject iJumpToMomentObject = this.jumpToMomentObject;
        if (iJumpToMomentObject != null) {
            return iJumpToMomentObject.checkArgs();
        }
        Log.d(TAG, "checkArgs fail ,shareMomentObject is null");
        ShowMessageFromXTC.Response response = new ShowMessageFromXTC.Response();
        response.setCode(6);
        response.setErrorDesc("shareMomentObject is null");
        return response;
    }

    public IJumpToMomentObject getJumpToMomentObject() {
        return this.jumpToMomentObject;
    }

    public void setJumpToMomentObject(IJumpToMomentObject iJumpToMomentObject) {
        this.jumpToMomentObject = iJumpToMomentObject;
    }

    public String toString() {
        return "ShareToPictureInfo{jumpToMomentObject=" + this.jumpToMomentObject + '}';
    }
}
