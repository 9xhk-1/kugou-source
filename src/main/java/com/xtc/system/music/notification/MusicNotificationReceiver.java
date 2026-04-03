package com.xtc.system.music.notification;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import e.g.e.a.a.a;

/* JADX INFO: loaded from: classes2.dex */
public class MusicNotificationReceiver extends BroadcastReceiver {
    public static a a;

    @Override // android.content.BroadcastReceiver
    @SuppressLint({"LongLogTag"})
    public void onReceive(Context context, Intent intent) {
        Log.d("MusicNotificationReceiver", "onReceive:playingMusicNotification=" + a);
        a aVar = a;
        if (aVar == null) {
            return;
        }
        aVar.a();
    }
}
