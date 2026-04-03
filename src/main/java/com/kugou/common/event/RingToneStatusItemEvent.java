package com.kugou.common.event;

/* JADX INFO: loaded from: classes2.dex */
public class RingToneStatusItemEvent {
    public boolean isSuccess;
    public String result;

    public RingToneStatusItemEvent(boolean z, String str) {
        this.isSuccess = false;
        this.result = "";
        this.isSuccess = z;
        this.result = str;
    }
}
