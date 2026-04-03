package org.chromium.base;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: loaded from: classes2.dex */
public class SystemMessageHandler extends Handler {
    public long a;

    private native void nativeDoIdleWork(long j);

    private native void nativeDoRunLoopOnce(long j, boolean z);

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        long j = this.a;
        if (j == 0) {
            return;
        }
        nativeDoRunLoopOnce(j, message.what == 2);
    }
}
