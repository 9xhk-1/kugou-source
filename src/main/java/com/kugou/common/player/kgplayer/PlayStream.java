package com.kugou.common.player.kgplayer;

import e.c.e.b.e.c;

/* JADX INFO: loaded from: classes2.dex */
public class PlayStream {
    public static final int ERROR_CODE_INVALID = 305419896;
    private c.b bufferingUpdateListener;
    private long streamPtr = 0;
    private String fileKey = "";
    private boolean isLocalStream = false;

    public String getFileKey() {
        return this.fileKey;
    }

    public long getStreamPtr() {
        return this.streamPtr;
    }

    public boolean isLocalStream() {
        return this.isLocalStream;
    }

    public void notifyBufferUpdate(int i2) {
        c.b bVar = this.bufferingUpdateListener;
        if (bVar != null) {
            bVar.onBufferingUpdate(null, i2);
        }
    }

    public void setFileKey(String str) {
        this.fileKey = str;
    }

    public void setLocalStream(boolean z) {
        this.isLocalStream = z;
    }

    public void setOnBufferUpdateListener(c.b bVar) {
        this.bufferingUpdateListener = bVar;
    }

    public void setStreamPtr(long j) {
        this.streamPtr = j;
    }
}
