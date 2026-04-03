package com.xtc.shareapi.share.sharescene;

import android.os.Bundle;
import android.util.Log;
import com.xtc.shareapi.share.communication.BaseResponse;
import com.xtc.shareapi.share.communication.SendMessageToXTC;
import com.xtc.shareapi.share.constant.OpenApiConstant;
import com.xtc.shareapi.share.interfaces.IBundleSerialize;
import com.xtc.shareapi.share.interfaces.Scene;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class Chat implements Scene {
    public static final int CLASS_GROUP = 16777216;
    public static final int FAMILY_GROUP = 4096;
    public static final int FRIEND = 1;
    public static final int FRIEND_GROUP = 16;
    public static final int MANAGER = 256;
    public static final int MULTIPLE = 3;
    public static final int NONE = 1;
    public static final int SINGLE = 2;
    public static final int TEACHER = 65536;
    public static final int TEACHER_GROUP = 1048576;
    private List<String> filterConversationList;
    private List<String> filterModeList;
    private String filterTip;
    private int friendType;
    private List<String> openIdList;
    private int selectActionMode;

    public Chat() {
        setSelectActionMode(2);
        setFriendType(17);
    }

    @Override // com.xtc.shareapi.share.interfaces.IBundleSerialize
    public BaseResponse checkArgs() {
        SendMessageToXTC.Response response = new SendMessageToXTC.Response();
        response.setCode(1);
        return response;
    }

    @Override // com.xtc.shareapi.share.interfaces.IBundleSerialize
    public IBundleSerialize fromBundle(Bundle bundle) {
        setSelectActionMode(bundle.getInt(OpenApiConstant.SceneConstant.BUNDLE_CHAT_SELECTION_MODE));
        setOpenIdList(bundle.getStringArrayList(OpenApiConstant.SceneConstant.BUNDLE_CHAT_OPENID_LIST));
        setFriendType(bundle.getInt(OpenApiConstant.SceneConstant.BUNDLE_CHAT_FRIEND_TYPE));
        setFilterConversationList(bundle.getStringArrayList(OpenApiConstant.SceneConstant.BUNDLE_CHAT_CONVERSATION_LIST));
        setFilterModeList(bundle.getStringArrayList(OpenApiConstant.SceneConstant.BUNDLE_CHAT_MODE_LIST));
        setFilterTip(bundle.getString(OpenApiConstant.SceneConstant.BUNDLE_CHAT_FILTER_TIP));
        Log.d(OpenApiConstant.TAG, "come to chat fromBundle");
        return this;
    }

    @Override // com.xtc.shareapi.share.interfaces.Scene
    public String getAppName() {
        return OpenApiConstant.XTCShareAppName.XTC_CHAT_APP_NAME;
    }

    public List<String> getFilterConversationList() {
        return this.filterConversationList;
    }

    public List<String> getFilterModeList() {
        return this.filterModeList;
    }

    public String getFilterTip() {
        return this.filterTip;
    }

    public int getFriendType() {
        return this.friendType;
    }

    public List<String> getOpenIdList() {
        return this.openIdList;
    }

    @Override // com.xtc.shareapi.share.interfaces.Scene
    public String getPackageName() {
        return OpenApiConstant.App.CHAT_PACKAGE_NAME;
    }

    public int getSelectActionMode() {
        return this.selectActionMode;
    }

    @Override // com.xtc.shareapi.share.interfaces.Scene
    public String getTargetClassName() {
        return OpenApiConstant.App.LAUNCHER_CHAT_ACTIVITY;
    }

    @Override // com.xtc.shareapi.share.interfaces.Scene
    public int getType() {
        return 1;
    }

    public void setFilterConversationList(List<String> list) {
        this.filterConversationList = list;
    }

    public void setFilterModeList(List<String> list) {
        this.filterModeList = list;
    }

    public void setFilterTip(String str) {
        this.filterTip = str;
    }

    public void setFriendType(int i2) {
        this.friendType = i2;
    }

    public void setOpenIdList(List<String> list) {
        this.openIdList = list;
    }

    public void setSelectActionMode(int i2) {
        this.selectActionMode = i2;
    }

    @Override // com.xtc.shareapi.share.interfaces.IBundleSerialize
    public void toBundle(Bundle bundle) {
        bundle.putInt(OpenApiConstant.SceneConstant.BUNDLE_CHAT_SELECTION_MODE, this.selectActionMode);
        bundle.putStringArrayList(OpenApiConstant.SceneConstant.BUNDLE_CHAT_OPENID_LIST, (ArrayList) this.openIdList);
        bundle.putInt(OpenApiConstant.SceneConstant.BUNDLE_CHAT_FRIEND_TYPE, this.friendType);
        bundle.putStringArrayList(OpenApiConstant.SceneConstant.BUNDLE_CHAT_CONVERSATION_LIST, (ArrayList) this.filterConversationList);
        bundle.putStringArrayList(OpenApiConstant.SceneConstant.BUNDLE_CHAT_MODE_LIST, (ArrayList) this.filterModeList);
        bundle.putString(OpenApiConstant.SceneConstant.BUNDLE_CHAT_FILTER_TIP, this.filterTip);
        bundle.putInt(OpenApiConstant.SceneConstant.BUNDLE_SCENE_SHARE_TYPE, getType());
        Log.d(OpenApiConstant.TAG, "come to chat toBundle");
    }

    public String toString() {
        return "Chat{selectActionMode=" + this.selectActionMode + ", openIdList=" + this.openIdList + '}';
    }
}
