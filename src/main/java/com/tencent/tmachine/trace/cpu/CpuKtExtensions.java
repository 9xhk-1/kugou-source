package com.tencent.tmachine.trace.cpu;

import f.e0.o;
import f.p;
import f.y.c;
import f.z.d.j;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public final class CpuKtExtensions {
    public static final CpuKtExtensions INSTANCE = new CpuKtExtensions();

    private CpuKtExtensions() {
    }

    public final long readLong(File file) {
        j.f(file, "$this$readLong");
        String strE = c.e(file, null, 1, null);
        if (strE != null) {
            return Long.parseLong(o.c0(strE).toString());
        }
        throw new p("null cannot be cast to non-null type kotlin.CharSequence");
    }
}
