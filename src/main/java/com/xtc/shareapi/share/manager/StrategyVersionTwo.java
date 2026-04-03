package com.xtc.shareapi.share.manager;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.database.Cursor;
import android.net.Uri;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.xtc.shareapi.R;
import com.xtc.shareapi.share.bean.AppInfo;
import com.xtc.shareapi.share.bean.ModuleSwitch;
import com.xtc.shareapi.share.communication.SendMessageToXTC;
import com.xtc.shareapi.share.constant.OpenApiConstant;
import com.xtc.shareapi.share.interfaces.IShareObject;
import com.xtc.shareapi.share.interfaces.Scene;
import com.xtc.shareapi.share.manager.IShareToChat;
import com.xtc.shareapi.share.manager.IShareToTimeMemory;
import com.xtc.shareapi.share.shareobject.XTCImageObject;
import com.xtc.shareapi.share.shareobject.XTCVideoObject;
import com.xtc.shareapi.share.shareobject.XTCWebObject;
import com.xtc.shareapi.share.sharescene.Chat;
import com.xtc.shareapi.share.utils.ShareUtil;
import com.xtc.shareapi.share.view.PopWindowManager;
import com.xtc.system.account.WatchAccountBase;
import com.xtc.utils.system.WatchModelUtil;

/* JADX INFO: loaded from: classes2.dex */
public class StrategyVersionTwo extends ShareStrategy {
    public StrategyVersionTwo(Context context, String str, byte[] bArr) {
        super(context, str, bArr);
    }

    private void bindServiceAndShare(final int i2, final String str, final Intent intent, final IShareCallback iShareCallback) {
        Intent intent2 = new Intent(OpenApiConstant.IntentConstant.INTENT_CHAT_SERVICE);
        intent2.setPackage(OpenApiConstant.App.CHAT_PACKAGE_NAME);
        this.context.bindService(intent2, new ServiceConnection() { // from class: com.xtc.shareapi.share.manager.StrategyVersionTwo.3
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                try {
                    Log.d(StrategyVersionTwo.this.TAG, "share to service connect!");
                    IShareToChat.Stub.asInterface(iBinder).shareToChat(intent, i2, str, iShareCallback);
                } catch (RemoteException e2) {
                    try {
                        e2.printStackTrace();
                        Log.d(StrategyVersionTwo.this.TAG, "share to chat error = " + e2);
                        iShareCallback.onResult(100, "share to chat remote exception!");
                    } catch (RemoteException e3) {
                        e3.printStackTrace();
                        Log.d(StrategyVersionTwo.this.TAG, "response result exception = " + e2);
                    }
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                Log.i(StrategyVersionTwo.this.TAG, "bindServiceAndShare onServiceDisconnected ");
                StrategyVersionTwo.this.context.unbindService(this);
            }
        }, 1);
    }

    @Override // com.xtc.shareapi.share.manager.ShareStrategy
    public boolean checkBaseVersion(int i2) {
        return !TextUtils.isEmpty(getTargetClassName(i2));
    }

    public int checkSceneInstall(int i2) {
        return i2 == 1 ? !ShareUtil.isInstallScene(this.context, OpenApiConstant.App.CHAT_PACKAGE_NAME) ? 1 : 0 : (i2 != 2 || ShareUtil.isInstallScene(this.context, OpenApiConstant.App.MOMENT_PACKAGE_NAME)) ? 0 : 2;
    }

    public boolean checkShareVersion(IShareObject iShareObject, int i2) {
        int hostSdkVersion;
        if (i2 == 1) {
            hostSdkVersion = ShareUtil.getHostSdkVersion(this.context, OpenApiConstant.App.CHAT_PACKAGE_NAME);
            Log.d(this.TAG, "THE CHAT IS" + hostSdkVersion);
        } else {
            if (i2 != 2) {
                return false;
            }
            hostSdkVersion = ShareUtil.getHostSdkVersion(this.context, OpenApiConstant.App.MOMENT_PACKAGE_NAME);
            Log.d(this.TAG, "THE TYPE_MOMENT IS" + hostSdkVersion);
        }
        if (iShareObject instanceof XTCVideoObject) {
            Log.d(this.TAG, "XTCVideoObject sdkVersion" + hostSdkVersion);
            return hostSdkVersion > 2;
        }
        if (!(iShareObject instanceof XTCWebObject)) {
            return true;
        }
        Log.d(this.TAG, "XTCWebObject sdkVersion" + hostSdkVersion);
        return hostSdkVersion > 2;
    }

    @Override // com.xtc.shareapi.share.manager.ShareStrategy
    public ModuleSwitch getModuleSwitch(Context context, int i2) {
        ModuleSwitch moduleSwitch = new ModuleSwitch();
        if (i2 == 2) {
            moduleSwitch.setModule(WatchAccountBase.queryModuleSwitchByBoolean(context, 47, !WatchModelUtil.isInternationalWatch()));
        } else if (i2 != 3) {
            moduleSwitch.setModule(true);
        } else {
            moduleSwitch.setModule(WatchAccountBase.queryModuleSwitchByBoolean(context, OpenApiConstant.ModuleSwitch.MODULE_TIME_MEMORY, !WatchModelUtil.isInternationalWatch()));
        }
        return moduleSwitch;
    }

    @Override // com.xtc.shareapi.share.manager.ShareStrategy
    public String getTargetClassName(int i2) {
        if (i2 == 1) {
            return ShareUtil.getTargetClassName(this.context, OpenApiConstant.App.CHAT_PACKAGE_NAME, OpenApiConstant.App.LAUNCHER_CHAT_ACTIVITY);
        }
        if (i2 == 2) {
            return ShareUtil.getTargetClassName(this.context, OpenApiConstant.App.MOMENT_PACKAGE_NAME, OpenApiConstant.App.LAUNCHER_MOMENT_ACTIVITY);
        }
        if (i2 == 4) {
            return ShareUtil.getTargetClassName(this.context, OpenApiConstant.App.CHAT_PACKAGE_NAME, OpenApiConstant.App.LAUNCHER_CHAT_ACTIVITY);
        }
        return null;
    }

    @Override // com.xtc.shareapi.share.manager.ShareStrategy
    public AppInfo getTokenFromXTC(Context context, Scene scene) {
        AppInfo appInfo = new AppInfo();
        Cursor cursor = null;
        try {
            try {
                Cursor cursorQuery = context.getContentResolver().query(scene.getType() == 1 ? Uri.parse(OpenApiConstant.TokenConstant.SHARE_CHAT_URI) : Uri.parse(OpenApiConstant.TokenConstant.SHARE_MOMENT_URI), null, OpenApiConstant.TokenConstant.QUERY_SELECTION, new String[]{context.getPackageName()}, null);
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
            Log.d(this.TAG, "get target class name error!");
            return false;
        }
        intent.setClassName(scene.getPackageName(), targetClassName);
        return true;
    }

    @Override // com.xtc.shareapi.share.manager.ShareStrategy
    public void share(SendMessageToXTC.Request request, String str) {
        Scene scene = request.getScene();
        if (scene == null) {
            Log.d(this.TAG, "scene is null !");
            PopWindowManager.getInstance(this.context).showChooseSceneWindow(str, request, this);
            return;
        }
        final int iCheckSceneInstall = checkSceneInstall(scene.getType());
        if (iCheckSceneInstall != 0) {
            ShareHandlerUtil.runOnUIThread(new Runnable() { // from class: com.xtc.shareapi.share.manager.StrategyVersionTwo.1
                @Override // java.lang.Runnable
                public void run() {
                    if (iCheckSceneInstall == 1) {
                        Context context = StrategyVersionTwo.this.context;
                        Toast.makeText(context, context.getString(R.string.please_install_weichat), 0).show();
                        ShareUtil.startTargetActivity(StrategyVersionTwo.this.context, 13, "not install weichat!");
                    } else {
                        Context context2 = StrategyVersionTwo.this.context;
                        Toast.makeText(context2, context2.getString(R.string.please_install_moment), 0).show();
                        ShareUtil.startTargetActivity(StrategyVersionTwo.this.context, 14, "not install moment!");
                    }
                }
            });
            return;
        }
        if (!checkShareVersion(request.getMessage().getShareObject(), scene.getType())) {
            Log.d(this.TAG, "check sdk version fail");
            ShareUtil.startTargetActivity(this.context, 5, "current host not support share!");
            return;
        }
        Intent shareIntentFromRequest = getShareIntentFromRequest(str, request);
        if (shareIntentFromRequest == null) {
            Log.e(this.TAG, "get share intent error!");
            ShareUtil.startTargetActivity(this.context, 6, "get share intent error!");
            return;
        }
        ModuleSwitch moduleSwitch = getModuleSwitch(this.context, scene.getType());
        if (moduleSwitch != null && !moduleSwitch.isModule()) {
            Log.e(this.TAG, "current moduleSwitch is not open !");
            ShareUtil.startTargetActivity(this.context, 10, "current moduleSwitch is not open!");
            return;
        }
        Log.d(this.TAG, "the scene is " + scene.getType());
        shareIntentFromRequest.putExtra(OpenApiConstant.IntentConstant.INTENT_APP_TOKEN, getTokenFromXTC(this.context, scene).getToken());
        this.context.startActivity(shareIntentFromRequest);
    }

    public void silentlyShare(SendMessageToXTC.Request request, int i2, String str, IShareCallback iShareCallback, String str2) throws RemoteException {
        Chat chat = new Chat();
        request.setScene(chat);
        Intent shareIntentFromRequest = getShareIntentFromRequest(str2, request);
        if (shareIntentFromRequest == null) {
            Log.e(this.TAG, "get share intent error!");
            iShareCallback.onResult(6, "get share intent error!");
            return;
        }
        ModuleSwitch moduleSwitch = getModuleSwitch(this.context, chat.getType());
        if (moduleSwitch != null && !moduleSwitch.isModule()) {
            Log.d(this.TAG, "current moduleSwitch is open  = " + moduleSwitch.isModule());
            iShareCallback.onResult(10, "this scene has bean forbid!");
            return;
        }
        AppInfo appInfo = new AppInfo();
        Log.d(this.TAG, "get app info = " + appInfo);
        shareIntentFromRequest.putExtra(OpenApiConstant.IntentConstant.INTENT_APP_TOKEN, appInfo.getToken());
        bindServiceAndShare(i2, str, shareIntentFromRequest, iShareCallback);
    }

    public void silentlyShareByTimeMemory(final SendMessageToXTC.Request request, String str, final ISilentlyShareCallback iSilentlyShareCallback) throws RemoteException {
        ModuleSwitch moduleSwitch = getModuleSwitch(this.context, request.getScene().getType());
        if (moduleSwitch == null || moduleSwitch.isModule()) {
            Intent intent = new Intent(OpenApiConstant.IntentConstant.SERVICE_TIME_MEMORY);
            intent.setPackage(OpenApiConstant.App.PACKAGE_TIME_MEMORY);
            this.context.bindService(intent, new ServiceConnection() { // from class: com.xtc.shareapi.share.manager.StrategyVersionTwo.2
                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    Log.d(StrategyVersionTwo.this.TAG, "onServiceConnected : " + componentName);
                    try {
                        try {
                            IShareToTimeMemory.Stub.asInterface(iBinder).sharePicture(((XTCImageObject) request.getMessage().getShareObject()).getImagePath(), iSilentlyShareCallback);
                        } catch (RemoteException e2) {
                            try {
                                e2.printStackTrace();
                                Log.d(StrategyVersionTwo.this.TAG, "share to chat error = " + e2);
                                iSilentlyShareCallback.onResult(100, "share to chat remote exception!");
                            } catch (RemoteException e3) {
                                e3.printStackTrace();
                                Log.d(StrategyVersionTwo.this.TAG, "response result exception = " + e2);
                            }
                        }
                    } finally {
                        StrategyVersionTwo.this.context.unbindService(this);
                    }
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                    Log.d(StrategyVersionTwo.this.TAG, "onServiceDisconnected : " + componentName);
                }
            }, 1);
        } else {
            Log.d(this.TAG, "current moduleSwitch is open  = " + moduleSwitch.isModule());
            iSilentlyShareCallback.onResult(10, "this scene has bean forbid!");
        }
    }
}
