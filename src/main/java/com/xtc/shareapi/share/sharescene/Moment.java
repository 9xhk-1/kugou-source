package com.xtc.shareapi.share.sharescene;

import android.os.Bundle;
import com.xtc.shareapi.share.communication.BaseResponse;
import com.xtc.shareapi.share.communication.SendMessageToXTC;
import com.xtc.shareapi.share.constant.OpenApiConstant;
import com.xtc.shareapi.share.interfaces.IBundleSerialize;
import com.xtc.shareapi.share.interfaces.Scene;

/* JADX INFO: loaded from: classes2.dex */
public class Moment implements Scene {
    @Override // com.xtc.shareapi.share.interfaces.IBundleSerialize
    public BaseResponse checkArgs() {
        SendMessageToXTC.Response response = new SendMessageToXTC.Response();
        response.setCode(1);
        return response;
    }

    @Override // com.xtc.shareapi.share.interfaces.IBundleSerialize
    public IBundleSerialize fromBundle(Bundle bundle) {
        return this;
    }

    @Override // com.xtc.shareapi.share.interfaces.Scene
    public String getAppName() {
        return OpenApiConstant.XTCShareAppName.XTC_MOMENT_APP_NAME;
    }

    @Override // com.xtc.shareapi.share.interfaces.Scene
    public String getPackageName() {
        return OpenApiConstant.App.MOMENT_PACKAGE_NAME;
    }

    @Override // com.xtc.shareapi.share.interfaces.Scene
    public String getTargetClassName() {
        return OpenApiConstant.App.LAUNCHER_MOMENT_ACTIVITY;
    }

    @Override // com.xtc.shareapi.share.interfaces.Scene
    public int getType() {
        return 2;
    }

    @Override // com.xtc.shareapi.share.interfaces.IBundleSerialize
    public void toBundle(Bundle bundle) {
        bundle.putInt(OpenApiConstant.SceneConstant.BUNDLE_SCENE_SHARE_TYPE, getType());
    }
}
