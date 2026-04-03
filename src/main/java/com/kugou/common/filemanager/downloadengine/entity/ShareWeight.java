package com.kugou.common.filemanager.downloadengine.entity;

import android.support.annotation.IntRange;

/* JADX INFO: loaded from: classes2.dex */
public class ShareWeight {
    private int flowWeight;
    private int natWeight;

    public int getFlowWeight() {
        return this.flowWeight;
    }

    public int getNatWeight() {
        return this.natWeight;
    }

    public void setFlowWeight(@IntRange(from = 0, to = 255) int i2) {
        this.flowWeight = i2;
    }

    public void setNatWeight(@IntRange(from = 0, to = 255) int i2) {
        this.natWeight = i2;
    }
}
