package com.xtc.shareapi.share.manager;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.xtc.shareapi.share.bean.AppInfo;
import com.xtc.shareapi.share.bean.ModuleSwitch;
import com.xtc.shareapi.share.communication.SendMessageToXTC;
import com.xtc.shareapi.share.constant.OpenApiConstant;
import com.xtc.shareapi.share.interfaces.Scene;
import com.xtc.shareapi.share.utils.ShareUtil;
import com.xtc.shareapi.share.view.PopWindowManager;

/* JADX INFO: loaded from: classes2.dex */
public class StrategyVersionOne extends ShareStrategy {
    public StrategyVersionOne(Context context, String str, byte[] bArr) {
        super(context, str, bArr);
    }

    @Override // com.xtc.shareapi.share.manager.ShareStrategy
    public boolean checkBaseVersion(int i2) {
        return !TextUtils.isEmpty(getTargetClassName(i2));
    }

    @Override // com.xtc.shareapi.share.manager.ShareStrategy
    public ModuleSwitch getModuleSwitch(Context context, int i2) {
        ModuleSwitch moduleSwitch = new ModuleSwitch();
        Bundle bundle = new Bundle();
        bundle.putInt("scene", i2);
        Bundle bundleCall = context.getContentResolver().call(Uri.parse(OpenApiConstant.ModuleSwitch.SHARE_APP_MODULE), OpenApiConstant.ModuleSwitch.XTC_MODULE_SWITCH_OPEN, (String) null, bundle);
        if (bundleCall != null) {
            boolean z = bundleCall.getBoolean(OpenApiConstant.ModuleSwitch.XTC_MODULE_SWITCH_OPEN);
            String string = bundleCall.getString(OpenApiConstant.ModuleSwitch.XTC_MODULE_SWITCH_TIP);
            moduleSwitch.setModule(z);
            moduleSwitch.setTip(string);
            Log.d(this.TAG, "query module result = " + z);
        }
        return moduleSwitch;
    }

    @Override // com.xtc.shareapi.share.manager.ShareStrategy
    public String getTargetClassName(int i2) {
        if (i2 == 1) {
            return ShareUtil.getTargetClassName(this.context, OpenApiConstant.App.LAUNCHER, OpenApiConstant.App.LAUNCHER_CHAT_ACTIVITY);
        }
        if (i2 == 2) {
            return ShareUtil.getTargetClassName(this.context, OpenApiConstant.App.LAUNCHER, OpenApiConstant.App.LAUNCHER_MOMENT_ACTIVITY);
        }
        return null;
    }

    @Override // com.xtc.shareapi.share.manager.ShareStrategy
    public AppInfo getTokenFromXTC(Context context, Scene scene) {
        AppInfo appInfo = new AppInfo();
        Cursor cursor = null;
        try {
            try {
                Cursor cursorQuery = context.getContentResolver().query(Uri.parse(OpenApiConstant.TokenConstant.SHARE_APP_URI), null, OpenApiConstant.TokenConstant.QUERY_SELECTION, new String[]{context.getPackageName()}, null);
                if (cursorQuery == null) {
                    Log.d(this.TAG, "cursor is null!");
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return appInfo;
                }
                if (cursorQuery.moveToNext()) {
                    setAppInfo(appInfo, cursorQuery);
                }
                Log.d(this.TAG, "get app info is " + appInfo);
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return appInfo;
            } catch (Exception e2) {
                Log.e(this.TAG, "query app info error = " + e2);
                if (0 != 0) {
                    cursor.close();
                }
                return appInfo;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    @Override // com.xtc.shareapi.share.manager.ShareStrategy
    public boolean setClassName(Intent intent, Scene scene) {
        String targetClassName = getTargetClassName(scene.getType());
        if (TextUtils.isEmpty(targetClassName)) {
            Log.e(this.TAG, "get target class name error!");
            return false;
        }
        intent.setClassName(OpenApiConstant.App.LAUNCHER, targetClassName);
        return true;
    }

    @Override // com.xtc.shareapi.share.manager.ShareStrategy
    public void share(SendMessageToXTC.Request request, String str) {
        Scene scene = request.getScene();
        if (scene == null) {
            Log.e(this.TAG, "scene is null!");
            PopWindowManager.getInstance(this.context).showChooseSceneWindow(str, request, this);
            return;
        }
        Intent shareIntentFromRequest = getShareIntentFromRequest(str, request);
        if (shareIntentFromRequest == null) {
            Log.e(this.TAG, "get share intent error!");
            ShareUtil.startTargetActivity(this.context, 6, "get share intent error!");
            return;
        }
        ModuleSwitch moduleSwitch = getModuleSwitch(this.context, scene.getType());
        if (moduleSwitch == null || moduleSwitch.isModule()) {
            shareIntentFromRequest.putExtra(OpenApiConstant.IntentConstant.INTENT_APP_TOKEN, getTokenFromXTC(this.context, null).getToken());
            this.context.startActivity(shareIntentFromRequest);
        } else {
            Log.e(this.TAG, "current moduleSwitch is not open !");
            ShareUtil.startTargetActivity(this.context, 10, "current moduleSwitch is not open!");
        }
    }
}
