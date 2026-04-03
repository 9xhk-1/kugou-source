package com.tencent.tmachine.trace.cpu.sysfs;

import f.y.c;
import f.z.c.a;
import f.z.d.k;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public final class CpuIdleState$name$2 extends k implements a<String> {
    public final /* synthetic */ CpuIdleState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CpuIdleState$name$2(CpuIdleState cpuIdleState) {
        super(0);
        this.this$0 = cpuIdleState;
    }

    @Override // f.z.c.a
    public final String invoke() {
        return c.e(new File(this.this$0.pseudoPath, "name"), null, 1, null);
    }
}
