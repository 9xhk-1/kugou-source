package com.xtc.shareapi.share.jumpmoment;

import android.os.Bundle;
import android.util.Log;
import com.xtc.shareapi.share.communication.BaseResponse;
import com.xtc.shareapi.share.communication.ShowMessageFromXTC;
import com.xtc.shareapi.share.constant.OpenApiConstant;
import com.xtc.shareapi.share.interfaces.IJumpToMomentObject;

/* JADX INFO: loaded from: classes2.dex */
public class JumpToMomentFromAlbum implements IJumpToMomentObject {
    private static final String TAG = "JumpToMomentFromAlbum";
    private Bundle albumBundle;
    private boolean isFromAlbum;
    private JumpToMomentBase jumpToMomentBase;

    @Override // com.xtc.shareapi.share.interfaces.IJumpToMomentObject
    public BaseResponse checkArgs() {
        ShowMessageFromXTC.Response response = new ShowMessageFromXTC.Response();
        if (!this.isFromAlbum) {
            Log.e(TAG, "check fail , isFromAlbum is need to is set true");
            response.setCode(6);
            response.setErrorDesc("check fail , isFromAlbum is need to is set true");
            return response;
        }
        Bundle bundle = this.albumBundle;
        if (bundle == null) {
            Log.e(TAG, "check fail , camaraBundle null");
            response.setCode(6);
            response.setErrorDesc("check fail , camaraBundle null");
            return response;
        }
        if (bundle.getInt(OpenApiConstant.BundleExtra.PHOTO_TYPE) == 2) {
            Log.e(TAG, "check fail , is not support  live photo");
            response.setCode(6);
            response.setErrorDesc("check fail , is not support  live photo");
            return response;
        }
        JumpToMomentBase jumpToMomentBase = this.jumpToMomentBase;
        if (jumpToMomentBase != null) {
            return jumpToMomentBase.checkArgs();
        }
        response.setCode(1);
        return response;
    }

    public Bundle getAlbumBundle() {
        return this.albumBundle;
    }

    public JumpToMomentBase getJumpToMomentBase() {
        return this.jumpToMomentBase;
    }

    public boolean isFromAlbum() {
        return this.isFromAlbum;
    }

    public void setAlbumBundle(Bundle bundle) {
        this.albumBundle = bundle;
    }

    public void setFromAlbum(boolean z) {
        this.isFromAlbum = z;
    }

    public void setJumpToMomentBase(JumpToMomentBase jumpToMomentBase) {
        this.jumpToMomentBase = jumpToMomentBase;
    }

    @Override // com.xtc.shareapi.share.interfaces.IJumpToMomentObject
    public int type() {
        return 1;
    }
}
