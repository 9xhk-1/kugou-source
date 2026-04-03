package com.kugou.common.filemanager.downloadengine.share;

/* JADX INFO: loaded from: classes2.dex */
public interface ShareResourceCallback {
    void callbackOnlineStateChanged(boolean z, boolean z2);

    void callbackResourceInfo(String[] strArr, int[] iArr, boolean z);

    LocateInfo locateHash(String str, boolean z);

    void onRefreshOver(boolean z);

    void onUploadSessionChanged(boolean z, int i2);
}
