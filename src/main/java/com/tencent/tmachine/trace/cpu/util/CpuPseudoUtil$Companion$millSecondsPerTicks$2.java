package com.tencent.tmachine.trace.cpu.util;

import android.os.Build;
import android.system.Os;
import android.system.OsConstants;
import f.z.c.a;
import f.z.d.k;

/* JADX INFO: loaded from: classes2.dex */
public final class CpuPseudoUtil$Companion$millSecondsPerTicks$2 extends k implements a<Long> {
    public static final CpuPseudoUtil$Companion$millSecondsPerTicks$2 INSTANCE = new CpuPseudoUtil$Companion$millSecondsPerTicks$2();

    public CpuPseudoUtil$Companion$millSecondsPerTicks$2() {
        super(0);
    }

    @Override // f.z.c.a
    public /* bridge */ /* synthetic */ Long invoke() {
        return Long.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2() {
        return ((long) 1000) / (Build.VERSION.SDK_INT >= 21 ? Os.sysconf(OsConstants._SC_CLK_TCK) : 100L);
    }
}
