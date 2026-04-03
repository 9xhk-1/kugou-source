package com.kugou.common.filemanager.downloadengine;

import android.support.annotation.IntRange;

/* JADX INFO: loaded from: classes2.dex */
public class PartlyP2PInfo {
    private long byteEnd;
    private long byteStart;
    private long entireFileSize;
    private String entireHash;

    public PartlyP2PInfo(String str, @IntRange(from = 0) long j, @IntRange(from = 0) long j2, @IntRange(from = 0) long j3) {
        this.entireHash = str;
        this.entireFileSize = j;
        this.byteStart = j2;
        this.byteEnd = j3;
    }

    public long getByteEnd() {
        return this.byteEnd;
    }

    public long getByteStart() {
        return this.byteStart;
    }

    public long getEntireFileSize() {
        return this.entireFileSize;
    }

    public String getEntireHash() {
        return this.entireHash;
    }

    public boolean valid() {
        String str = this.entireHash;
        if (str != null && str.length() == 32) {
            long j = this.byteStart;
            if (j >= 0 && this.byteEnd > j) {
                return true;
            }
        }
        return false;
    }
}
