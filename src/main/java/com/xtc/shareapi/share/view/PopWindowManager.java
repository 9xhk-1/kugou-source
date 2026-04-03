package com.xtc.shareapi.share.view;

import android.content.Context;
import android.util.Log;
import android.view.WindowManager;
import com.google.android.material.badge.BadgeDrawable;
import com.xtc.shareapi.share.communication.BaseResponse;
import com.xtc.shareapi.share.communication.SendMessageToXTC;
import com.xtc.shareapi.share.constant.OpenApiConstant;
import com.xtc.shareapi.share.interfaces.IChooseSceneCallback;
import com.xtc.shareapi.share.interfaces.Scene;
import com.xtc.shareapi.share.manager.ShareStrategy;
import com.xtc.shareapi.share.sharescene.Chat;
import com.xtc.shareapi.share.sharescene.Moment;
import com.xtc.shareapi.share.utils.BitmapUtil;
import com.xtc.shareapi.share.utils.ShareUtil;

/* JADX INFO: loaded from: classes2.dex */
public class PopWindowManager {
    private static final String TAG = OpenApiConstant.TAG + PopWindowManager.class.getSimpleName();
    private ChooseSceneView chooseSceneView;
    private Context context;
    private SendMessageToXTC.Request objectScene;
    private SendMessageToXTC.Request objectScene2;
    private WindowManager.LayoutParams windowLayoutParams;
    private WindowManager windowManager;

    private PopWindowManager(Context context) {
        this.context = context;
        this.windowManager = (WindowManager) context.getSystemService("window");
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.windowLayoutParams = layoutParams;
        layoutParams.type = 2;
        layoutParams.format = 1;
        layoutParams.gravity = BadgeDrawable.TOP_START;
        layoutParams.width = BitmapUtil.getScreenWidth(context);
        this.windowLayoutParams.height = BitmapUtil.getScreenHeight(context);
        WindowManager.LayoutParams layoutParams2 = this.windowLayoutParams;
        layoutParams2.x = 0;
        layoutParams2.y = 0;
        layoutParams2.softInputMode = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dealSceneType(int i2, String str, ShareStrategy shareStrategy) {
        if (i2 == 0) {
            Log.d(TAG, "cancel choose scene");
            ShareUtil.startTargetActivity(this.context, 2, BaseResponse.Desc.CANCEL);
        } else if (i2 == 1) {
            shareStrategy.share(getChatScene(), str);
        } else {
            if (i2 != 2) {
                return;
            }
            shareStrategy.share(getMomentScene(), str);
        }
    }

    private SendMessageToXTC.Request getChatScene() {
        Scene scene = this.objectScene.getScene();
        SendMessageToXTC.Request request = this.objectScene2;
        Scene scene2 = request != null ? request.getScene() : null;
        Log.d(TAG, "scene chat = " + scene + " " + scene2);
        if (scene != null && scene.getType() == 1) {
            return this.objectScene;
        }
        if (scene2 != null && scene2.getType() == 1) {
            return this.objectScene2;
        }
        Chat chat = new Chat();
        chat.setFriendType(17);
        chat.setSelectActionMode(2);
        this.objectScene.setScene(chat);
        return this.objectScene;
    }

    public static PopWindowManager getInstance(Context context) {
        return new PopWindowManager(context);
    }

    private SendMessageToXTC.Request getMomentScene() {
        Scene scene = this.objectScene.getScene();
        SendMessageToXTC.Request request = this.objectScene2;
        Scene scene2 = request != null ? request.getScene() : null;
        Log.d(TAG, "scene moment = " + scene + " " + scene2);
        if (scene != null && scene.getType() == 2) {
            return this.objectScene;
        }
        if (scene2 != null && scene2.getType() == 2) {
            return this.objectScene2;
        }
        this.objectScene.setScene(new Moment());
        return this.objectScene;
    }

    public void hideChooseSceneWindow() {
        ChooseSceneView chooseSceneView = this.chooseSceneView;
        if (chooseSceneView != null) {
            if (chooseSceneView.getParent() != null) {
                Log.d(TAG, "hideChooseSceneWindow");
                this.windowManager.removeViewImmediate(this.chooseSceneView);
            }
            this.chooseSceneView = null;
        }
    }

    public void showChooseSceneWindow(String str, SendMessageToXTC.Request request, ShareStrategy shareStrategy) {
        this.objectScene = request;
        showChooseSceneWindow(str, shareStrategy);
    }

    public void showChooseSceneWindow(String str, SendMessageToXTC.Request request, SendMessageToXTC.Request request2, ShareStrategy shareStrategy) {
        this.objectScene = request;
        this.objectScene2 = request2;
        showChooseSceneWindow(str, shareStrategy);
    }

    private void showChooseSceneWindow(final String str, final ShareStrategy shareStrategy) {
        if (this.chooseSceneView == null) {
            this.chooseSceneView = new ChooseSceneView(this.context);
        }
        this.chooseSceneView.setCallback(new IChooseSceneCallback() { // from class: com.xtc.shareapi.share.view.PopWindowManager.1
            @Override // com.xtc.shareapi.share.interfaces.IChooseSceneCallback
            public void setOnClickCallback(int i2) {
                PopWindowManager.this.dealSceneType(i2, str, shareStrategy);
            }
        });
        if (this.chooseSceneView.getParent() == null) {
            this.windowManager.addView(this.chooseSceneView, this.windowLayoutParams);
            this.chooseSceneView.setPopWindow(this);
            Log.d(TAG, "come to showChooseSceneWindow !");
            return;
        }
        Log.d(TAG, "come to add window activity !");
    }
}
