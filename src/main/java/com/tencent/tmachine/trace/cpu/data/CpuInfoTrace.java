package com.tencent.tmachine.trace.cpu.data;

import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes2.dex */
public final class CpuInfoTrace {
    private final ConcurrentLinkedQueue<CpuInfo> cpuInfoList = new ConcurrentLinkedQueue<>();

    public final ConcurrentLinkedQueue<CpuInfo> getCpuInfoList() {
        return this.cpuInfoList;
    }
}
