package com.xtc.shareapi.share.manager;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.xtc.shareapi.R;
import com.xtc.shareapi.share.bean.JumpToMomentRequest;
import com.xtc.shareapi.share.communication.BaseRequest;
import com.xtc.shareapi.share.communication.BaseResponse;
import com.xtc.shareapi.share.communication.SendMessageToXTC;
import com.xtc.shareapi.share.constant.OpenApiConstant;
import com.xtc.shareapi.share.utils.BitmapUtil;
import com.xtc.shareapi.share.utils.ShareUtil;
import com.xtc.shareapi.share.view.PopWindowManager;
import com.xtc.system.account.WatchAccountBase;
import com.xtc.utils.system.WatchModelUtil;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public class ShareMessageManager {
    private static final String TAG = OpenApiConstant.TAG + ShareMessageManager.class.getSimpleName();
    private byte[] appIcon;
    private String appName;
    private Context context;

    public ShareMessageManager(Context context) {
        this.context = context;
    }

    public boolean checkBaseVersion(int i2) {
        int hostSdkVersion = ShareUtil.getHostSdkVersion(this.context, OpenApiConstant.App.LAUNCHER);
        if (i2 == 2 && !WatchAccountBase.queryModuleSwitchByBoolean(this.context, 47, !WatchModelUtil.isInternationalWatch())) {
            return false;
        }
        if (hostSdkVersion != 0) {
            return hostSdkVersion == 1 ? new StrategyVersionOne(this.context, this.appName, this.appIcon).checkBaseVersion(i2) : new StrategyVersionTwo(this.context, this.appName, this.appIcon).checkBaseVersion(i2);
        }
        Log.d(TAG, "check sdk version fail");
        return false;
    }

    public void sendRequestToXTC(BaseRequest baseRequest, String str) {
        Context context = this.context;
        if (context == null) {
            Log.e(TAG, "share to xtc the context is null!");
            return;
        }
        if (baseRequest == null) {
            Log.d(TAG, "baseRequest must not null!");
            return;
        }
        if (!(baseRequest instanceof SendMessageToXTC.Request)) {
            Log.d(TAG, "baseRequest must instanceof SendMessageToXTC.Request!");
            return;
        }
        if (!(context instanceof Activity) || TextUtils.isEmpty(context.getPackageName()) || TextUtils.isEmpty(this.context.getClass().getName())) {
            Log.e(TAG, "you should use an activity context here!");
            return;
        }
        if (!ShareUtil.isConnected(this.context)) {
            Log.d(TAG, "network is not connected");
            ShareUtil.startTargetActivity(this.context, 8, BaseResponse.Desc.NETWORK_ERROR);
            return;
        }
        BaseResponse baseResponseCheckArgs = baseRequest.checkArgs();
        if (baseResponseCheckArgs == null || baseResponseCheckArgs.getCode() != 1) {
            Log.d(TAG, "the argument request check fail");
            ShareUtil.startTargetActivity(this.context, 6, "the argument request check fail");
            return;
        }
        baseRequest.setTransaction(String.valueOf(System.currentTimeMillis()) + UUID.randomUUID());
        int hostSdkVersion = ShareUtil.getHostSdkVersion(this.context, OpenApiConstant.App.LAUNCHER);
        if (hostSdkVersion == 0) {
            Log.d(TAG, "check sdk version fail");
            ShareUtil.startTargetActivity(this.context, 5, "current host not support share!");
            return;
        }
        SendMessageToXTC.Request request = (SendMessageToXTC.Request) baseRequest;
        request.getMessage().getShareObject();
        if (hostSdkVersion == 1) {
            new StrategyVersionOne(this.context, this.appName, this.appIcon).share(request, str);
        } else {
            new StrategyVersionTwo(this.context, this.appName, this.appIcon).share(request, str);
        }
    }

    public void setAppIcon(Bitmap bitmap) {
        this.appIcon = BitmapUtil.bitmapToByteArray(BitmapUtil.scaleIcon(this.context, bitmap));
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public void shareToMomentPicture(JumpToMomentRequest jumpToMomentRequest) {
        Context context = this.context;
        if (context == null) {
            Log.d(TAG, "share to xtc the context is null!");
            return;
        }
        if (jumpToMomentRequest == null) {
            Log.d(TAG, "shareToPictureInfo must not null!");
            return;
        }
        if (!(context instanceof Activity) || TextUtils.isEmpty(context.getPackageName()) || TextUtils.isEmpty(this.context.getClass().getName())) {
            Log.d(TAG, "you should use an activity context here!");
            return;
        }
        if (!ShareUtil.isConnected(this.context)) {
            Log.d(TAG, "network is not connected");
            Context context2 = this.context;
            Toast.makeText(context2, context2.getString(R.string.net_work_not_connect), 0).show();
        } else {
            BaseResponse baseResponseCheckArgs = jumpToMomentRequest.checkArgs();
            if (baseResponseCheckArgs == null || baseResponseCheckArgs.getCode() != 1) {
                Log.d(TAG, "the argument request check fail");
            } else {
                new JumpToMomentStrategy(this.context).share(jumpToMomentRequest);
            }
        }
    }

    public void sendRequestToXTC(BaseRequest baseRequest, BaseRequest baseRequest2, String str) {
        Context context = this.context;
        if (context == null) {
            Log.e(TAG, "share to xtc the context is null!");
            return;
        }
        if (baseRequest != null && baseRequest2 != null) {
            if ((baseRequest instanceof SendMessageToXTC.Request) && (baseRequest2 instanceof SendMessageToXTC.Request)) {
                if ((context instanceof Activity) && !TextUtils.isEmpty(context.getPackageName()) && !TextUtils.isEmpty(this.context.getClass().getName())) {
                    if (!ShareUtil.isConnected(this.context)) {
                        Log.d(TAG, "network is not connected");
                        ShareUtil.startTargetActivity(this.context, 8, BaseResponse.Desc.NETWORK_ERROR);
                        return;
                    }
                    BaseResponse baseResponseCheckArgs = baseRequest.checkArgs();
                    BaseResponse baseResponseCheckArgs2 = baseRequest2.checkArgs();
                    if (baseResponseCheckArgs != null && baseResponseCheckArgs.getCode() == 1 && baseResponseCheckArgs2 != null && baseResponseCheckArgs2.getCode() == 1) {
                        baseRequest.setTransaction(String.valueOf(System.currentTimeMillis()) + UUID.randomUUID());
                        baseRequest2.setTransaction(String.valueOf(System.currentTimeMillis()) + UUID.randomUUID());
                        int hostSdkVersion = ShareUtil.getHostSdkVersion(this.context, OpenApiConstant.App.LAUNCHER);
                        SendMessageToXTC.Request request = (SendMessageToXTC.Request) baseRequest2;
                        request.getMessage().getShareObject();
                        if (hostSdkVersion == 0) {
                            Log.d(TAG, "check sdk version fail");
                            ShareUtil.startTargetActivity(this.context, 5, "current host not support share!");
                            return;
                        } else if (hostSdkVersion == 1) {
                            PopWindowManager.getInstance(this.context).showChooseSceneWindow(str, (SendMessageToXTC.Request) baseRequest, request, new StrategyVersionOne(this.context, this.appName, this.appIcon));
                            return;
                        } else {
                            PopWindowManager.getInstance(this.context).showChooseSceneWindow(str, (SendMessageToXTC.Request) baseRequest, request, new StrategyVersionTwo(this.context, this.appName, this.appIcon));
                            return;
                        }
                    }
                    Log.d(TAG, "the argument request check fail");
                    ShareUtil.startTargetActivity(this.context, 6, "the argument request check fail");
                    return;
                }
                Log.e(TAG, "you should use an activity context here!");
                return;
            }
            Log.d(TAG, "baseRequest must instanceof SendMessageToXTC.Request!");
            return;
        }
        Log.d(TAG, "baseRequest must not null!");
    }

    public void sendRequestToXTC(BaseRequest baseRequest, String str, int i2, String str2, IShareCallback iShareCallback) throws RemoteException {
        if (this.context != null && baseRequest != null && !TextUtils.isEmpty(str)) {
            if (!(baseRequest instanceof SendMessageToXTC.Request)) {
                iShareCallback.onResult(6, "baseRequest argument must instanceof SendMessageToXTC.Request!");
                return;
            }
            if (!ShareUtil.isConnected(this.context)) {
                iShareCallback.onResult(8, "network not connect!");
                return;
            }
            if (!ShareUtil.isAppInWhiteList(this.context, OpenApiConstant.App.CHAT_PACKAGE_NAME)) {
                iShareCallback.onResult(18, "app not permission!");
                return;
            }
            if (!ShareUtil.isAllowContactPermission(this.context)) {
                iShareCallback.onResult(19, "app not contact permission!");
                return;
            }
            BaseResponse baseResponseCheckArgs = baseRequest.checkArgs();
            if (baseResponseCheckArgs != null && baseResponseCheckArgs.getCode() == 1) {
                int hostSdkVersion = ShareUtil.getHostSdkVersion(this.context, OpenApiConstant.App.LAUNCHER);
                ShareUtil.getHostSdkVersion(this.context, OpenApiConstant.App.CHAT_PACKAGE_NAME);
                if (hostSdkVersion <= 1) {
                    Log.d(TAG, "check sdk version fail");
                    iShareCallback.onResult(5, "current host not support!");
                    return;
                }
                SendMessageToXTC.Request request = (SendMessageToXTC.Request) baseRequest;
                request.getMessage().getShareObject();
                baseRequest.setTransaction(String.valueOf(System.currentTimeMillis()) + UUID.randomUUID());
                new StrategyVersionTwo(this.context, this.appName, this.appIcon).silentlyShare(request, i2, str2, iShareCallback, str);
                return;
            }
            iShareCallback.onResult(6, "argument check error!");
            return;
        }
        iShareCallback.onResult(6, "context and baseRequest and appKey add accountId must not null!");
    }

    public void sendRequestToXTC(BaseRequest baseRequest, String str, ISilentlyShareCallback iSilentlyShareCallback) throws RemoteException {
        Context context = this.context;
        if (context != null && baseRequest != null) {
            if (!(baseRequest instanceof SendMessageToXTC.Request)) {
                iSilentlyShareCallback.onResult(6, "baseRequest argument must instanceof SendMessageToXTC.Request!");
                return;
            }
            if (!ShareUtil.isConnected(context)) {
                iSilentlyShareCallback.onResult(8, "network not connect!");
                return;
            }
            if (!ShareUtil.isAppInWhiteList(this.context, OpenApiConstant.App.PACKAGE_TIME_MEMORY)) {
                iSilentlyShareCallback.onResult(18, "app not permission!");
                return;
            }
            BaseResponse baseResponseCheckArgs = baseRequest.checkArgs();
            if (baseResponseCheckArgs != null && baseResponseCheckArgs.getCode() == 1) {
                if (ShareUtil.getHostSdkVersion(this.context, OpenApiConstant.App.LAUNCHER) <= 1) {
                    Log.d(TAG, "check sdk version fail");
                    iSilentlyShareCallback.onResult(5, "current host not support!");
                    return;
                }
                SendMessageToXTC.Request request = (SendMessageToXTC.Request) baseRequest;
                request.getMessage().getShareObject();
                baseRequest.setTransaction(String.valueOf(System.currentTimeMillis()) + UUID.randomUUID());
                new StrategyVersionTwo(this.context, this.appName, this.appIcon).silentlyShareByTimeMemory(request, str, iSilentlyShareCallback);
                return;
            }
            iSilentlyShareCallback.onResult(6, "argument check error!");
            return;
        }
        iSilentlyShareCallback.onResult(6, "context or baseRequest must not null!");
    }
}
