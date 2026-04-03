package com.kugou.common.filemanager.downloadengine;

/* JADX INFO: loaded from: classes2.dex */
public interface IFileTransform {
    boolean onStartTransform(long j, String str, String str2);

    void onStopTransform(String str, String str2);
}
