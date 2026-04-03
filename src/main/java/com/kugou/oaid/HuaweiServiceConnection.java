package com.kugou.oaid;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.kugou.oaid.HuaWeiOaidManager;

/* JADX INFO: loaded from: classes2.dex */
public class HuaweiServiceConnection implements ServiceConnection {
    @Override // android.content.ServiceConnection
    public void onBindingDied(ComponentName componentName) {
    }

    @Override // android.content.ServiceConnection
    public void onNullBinding(ComponentName componentName) {
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        String strOnCallBack = HuaWeiOaidManager.onCallBack(componentName, iBinder);
        HuaWeiOaidManager.OnOaidCallBack onOaidCallBack = HuaWeiOaidManager.onOaidCallBack;
        if (onOaidCallBack != null) {
            onOaidCallBack.onCallBack(strOnCallBack);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
    }
}
