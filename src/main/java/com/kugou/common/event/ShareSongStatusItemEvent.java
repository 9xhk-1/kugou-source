package com.kugou.common.event;

import com.xtc.shareapi.share.communication.BaseResponse;

/* JADX INFO: loaded from: classes2.dex */
public class ShareSongStatusItemEvent {
    public BaseResponse extJson;
    public int state;

    public ShareSongStatusItemEvent(int i2, BaseResponse baseResponse) {
        this.state = 0;
        this.state = i2;
        this.extJson = baseResponse;
    }

    public String toString() {
        return "FavSongStatusItemEvent{state=" + this.state + ", extJson='" + this.extJson + "'}";
    }
}
