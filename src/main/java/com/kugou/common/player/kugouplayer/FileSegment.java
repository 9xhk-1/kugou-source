package com.kugou.common.player.kugouplayer;

/* JADX INFO: loaded from: classes2.dex */
public class FileSegment {
    public boolean accompany;
    public long endms;
    public String path;
    public long startms;
    public long startrecordms;

    public FileSegment(String str) {
        this.path = str;
        this.accompany = false;
        this.startms = 0L;
        this.endms = 0L;
        this.startrecordms = 0L;
    }

    public FileSegment(String str, boolean z, long j, long j2) {
        this.path = str;
        this.accompany = z;
        this.startms = j;
        this.endms = j2;
    }

    public FileSegment(String str, boolean z, long j, long j2, long j3) {
        this.path = str;
        this.accompany = z;
        this.startms = j;
        this.endms = j2;
        this.startrecordms = j3;
    }
}
