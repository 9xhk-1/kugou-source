package com.tencent.tmachine.trace.cpu.sysfs;

import f.z.c.a;
import f.z.d.k;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public final class CpuFreq$scalingMinFreqFile$2 extends k implements a<File> {
    public final /* synthetic */ CpuFreq this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CpuFreq$scalingMinFreqFile$2(CpuFreq cpuFreq) {
        super(0);
        this.this$0 = cpuFreq;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // f.z.c.a
    public final File invoke() {
        return new File(this.this$0.pseudoFile, "scaling_min_freq");
    }
}
