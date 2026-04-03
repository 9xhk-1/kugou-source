package com.tencent.tmachine.trace.looper.listeners;

/* JADX INFO: loaded from: classes2.dex */
public interface ILooperListener {
    boolean isValid();

    void onDispatchBegin(String str);

    void onDispatchEnd(String str, long j, long j2);
}
