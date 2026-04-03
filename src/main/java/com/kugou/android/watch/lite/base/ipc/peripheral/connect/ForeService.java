package com.kugou.android.watch.lite.base.ipc.peripheral.connect;

import android.content.Intent;
import com.kugou.android.watch.lite.base.ipc.core.RemoteConnector;
import e.c.a.g.a.d.u.d;

/* JADX INFO: loaded from: classes.dex */
public class ForeService extends RemoteConnector.AdhesiveService {
    @Override // com.kugou.android.watch.lite.base.ipc.core.RemoteConnector.AdhesiveService, android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        d.b().startNotification(this);
        return 2;
    }
}
