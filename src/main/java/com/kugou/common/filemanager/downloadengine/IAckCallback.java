package com.kugou.common.filemanager.downloadengine;

/* JADX INFO: loaded from: classes2.dex */
public interface IAckCallback {
    void markUrlResult(String str, boolean z);

    void markUrlSpeedTestResult(String str, String str2, boolean z, int i2);

    boolean setAckDnsAddressAvailable(String str, String str2, boolean z);
}
