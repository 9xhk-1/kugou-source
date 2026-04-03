package com.xtc.shareapi.share.manager;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.xtc.shareapi.share.bean.AppInfo;
import com.xtc.shareapi.share.bean.ModuleSwitch;
import com.xtc.shareapi.share.communication.SendMessageToXTC;
import com.xtc.shareapi.share.constant.OpenApiConstant;
import com.xtc.shareapi.share.interfaces.Scene;
import com.xtc.shareapi.share.utils.BitmapUtil;
import com.xtc.shareapi.share.utils.ShareUtil;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ShareStrategy {
    public final String TAG = OpenApiConstant.TAG + getClass().getSimpleName();
    public byte[] appIcon;
    public String appName;
    public Context context;

    public ShareStrategy(Context context, String str, byte[] bArr) {
        this.context = context;
        this.appName = str;
        this.appIcon = bArr;
    }

    public abstract boolean checkBaseVersion(int i2);

    public abstract ModuleSwitch getModuleSwitch(Context context, int i2);

    public Intent getShareIntentFromRequest(String str, SendMessageToXTC.Request request) {
        String appName = this.appName;
        if (TextUtils.isEmpty(appName)) {
            appName = ShareUtil.getAppName(this.context);
        }
        byte[] bArrBitmapToByteArray = this.appIcon;
        if (bArrBitmapToByteArray == null || bArrBitmapToByteArray.length <= 0) {
            bArrBitmapToByteArray = BitmapUtil.bitmapToByteArray(ShareUtil.getBitmap(this.context));
        }
        if (bArrBitmapToByteArray == null) {
            Log.e(this.TAG, "app icon is null!");
            return null;
        }
        Log.d(this.TAG, "app icon size is = " + bArrBitmapToByteArray.length);
        if (bArrBitmapToByteArray.length > 350) {
            Log.e(this.TAG, "app icon data too large!");
            return null;
        }
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        request.toBundle(bundle);
        Scene scene = request.getScene();
        if (scene != null && !setClassName(intent, scene)) {
            Log.e(this.TAG, "set class name error!");
            return null;
        }
        intent.putExtras(bundle);
        intent.putExtra(OpenApiConstant.IntentConstant.INTENT_VERSION, "1");
        intent.putExtra(OpenApiConstant.IntentConstant.INTENT_PACKAGE, this.context.getPackageName());
        intent.putExtra(OpenApiConstant.IntentConstant.INTENT_CLASSNAME, this.context.getClass().getName());
        intent.putExtra(OpenApiConstant.IntentConstant.INTENT_APP_NAME, appName);
        intent.putExtra(OpenApiConstant.IntentConstant.INTENT_APP_ICON, bArrBitmapToByteArray);
        intent.putExtra(OpenApiConstant.IntentConstant.INTENT_APP_KEY, str);
        intent.putExtra(OpenApiConstant.IntentConstant.INTENT_APP_JUMP_FLAG, request.getFlag());
        return intent;
    }

    public abstract String getTargetClassName(int i2);

    public abstract AppInfo getTokenFromXTC(Context context, Scene scene);

    public void setAppInfo(AppInfo appInfo, Cursor cursor) {
        int columnIndex = cursor.getColumnIndex(OpenApiConstant.TokenConstant.SHARE_APP_PACKAGE);
        int columnIndex2 = cursor.getColumnIndex(OpenApiConstant.TokenConstant.SHARE_APP_ALLOW);
        int columnIndex3 = cursor.getColumnIndex(OpenApiConstant.TokenConstant.SHARE_APP_TOKEN);
        appInfo.setPackageName(cursor.getString(columnIndex));
        appInfo.setAllow(cursor.getInt(columnIndex2));
        appInfo.setToken(cursor.getString(columnIndex3));
    }

    public abstract boolean setClassName(Intent intent, Scene scene);

    public abstract void share(SendMessageToXTC.Request request, String str);
}
