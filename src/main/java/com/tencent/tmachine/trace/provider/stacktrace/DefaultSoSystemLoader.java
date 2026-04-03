package com.tencent.tmachine.trace.provider.stacktrace;

import f.z.d.j;

/* JADX INFO: loaded from: classes2.dex */
public final class DefaultSoSystemLoader implements ISoLoader {
    @Override // com.tencent.tmachine.trace.provider.stacktrace.ISoLoader
    public void loadLibrary(String str) {
        j.f(str, "soName");
        System.loadLibrary(str);
    }
}
