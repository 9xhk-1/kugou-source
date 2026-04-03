package com.kugou.framework.musichunter.v2;

import androidx.annotation.IntRange;

/* JADX INFO: loaded from: classes2.dex */
public class PcmData extends Signal {
    public byte[] pcmBuffer;
    public boolean pcmEnd;
    public int timeLength;

    public PcmData(@IntRange(from = 0) int i2, byte[] bArr, boolean z, @IntRange(from = 0) int i3) {
        this.index = i2;
        this.pcmBuffer = bArr;
        this.pcmEnd = z;
        this.timeLength = i3;
    }
}
