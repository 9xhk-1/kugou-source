package com.kugou.oaid;

import android.content.ComponentName;
import android.os.IBinder;

/* JADX INFO: loaded from: classes2.dex */
public class HuaWeiOaidManager {
    public static OnOaidCallBack onOaidCallBack;

    public interface OnOaidCallBack {
        void onCallBack(String str);
    }

    public static native void getOaid();

    public static void getOaid(OnOaidCallBack onOaidCallBack2) {
        getOaid();
        onOaidCallBack = onOaidCallBack2;
    }

    public static OnOaidCallBack getOnOaidCallBack() {
        return onOaidCallBack;
    }

    public static native String onCallBack(ComponentName componentName, IBinder iBinder);
}
