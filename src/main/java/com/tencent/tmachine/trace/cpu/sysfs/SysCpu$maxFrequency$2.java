package com.tencent.tmachine.trace.cpu.sysfs;

import f.z.c.a;
import f.z.d.k;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class SysCpu$maxFrequency$2 extends k implements a<Long> {
    public static final SysCpu$maxFrequency$2 INSTANCE = new SysCpu$maxFrequency$2();

    public SysCpu$maxFrequency$2() {
        super(0);
    }

    @Override // f.z.c.a
    public /* bridge */ /* synthetic */ Long invoke() {
        return Long.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2() {
        Iterator it = SysCpu.INSTANCE.getCpus().iterator();
        long jMaxFreq = 0;
        while (it.hasNext()) {
            jMaxFreq += ((Cpu) it.next()).getCpuFreq().maxFreq();
        }
        return jMaxFreq;
    }
}
