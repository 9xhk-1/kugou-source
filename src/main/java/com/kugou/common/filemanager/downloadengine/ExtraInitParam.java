package com.kugou.common.filemanager.downloadengine;

import android.support.annotation.IntRange;

/* JADX INFO: loaded from: classes2.dex */
public class ExtraInitParam {
    private String kgrfMid;
    private String lastFlowInfo;
    private long peerID6;
    private boolean returnFailStream;

    public String getKgrfMid() {
        return this.kgrfMid;
    }

    public String getLastFlowInfo() {
        return this.lastFlowInfo;
    }

    public long getPeerID6() {
        return this.peerID6;
    }

    public boolean getReturnFailStream() {
        return this.returnFailStream;
    }

    public void setKgrfMid(String str) {
        this.kgrfMid = str;
    }

    public void setLastFlowInfo(String str) {
        this.lastFlowInfo = str;
    }

    public void setPeerID6(@IntRange(from = 0) long j) {
        this.peerID6 = j;
    }

    public void setReturnFailStream(boolean z) {
        this.returnFailStream = z;
    }
}
