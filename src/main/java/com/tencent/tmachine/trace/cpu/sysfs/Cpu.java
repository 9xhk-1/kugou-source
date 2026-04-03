package com.tencent.tmachine.trace.cpu.sysfs;

import com.tencent.tmachine.trace.cpu.PseudoReadException;
import f.d;
import f.f;
import f.y.c;
import f.z.d.j;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class Cpu {
    private final String basePath;
    private final int cpuIndex;
    private boolean idleStateReadError;
    private final d timeInStateFile$delegate = f.b(new Cpu$timeInStateFile$2(this));
    private final d cpuCapacity$delegate = f.b(new Cpu$cpuCapacity$2(this));
    private final d cpuFreq$delegate = f.b(new Cpu$cpuFreq$2(this));
    private final d cpuIdleStates$delegate = f.b(new Cpu$cpuIdleStates$2(this));

    public Cpu(int i2) {
        this.cpuIndex = i2;
        this.basePath = "/sys/devices/system/cpu/cpu" + i2 + '/';
    }

    private final List<CpuIdleState> getCpuIdleStates() {
        return (List) this.cpuIdleStates$delegate.getValue();
    }

    private final File getTimeInStateFile() {
        return (File) this.timeInStateFile$delegate.getValue();
    }

    public final long getCpuCapacity() {
        return ((Number) this.cpuCapacity$delegate.getValue()).longValue();
    }

    public final CpuFreq getCpuFreq() {
        return (CpuFreq) this.cpuFreq$delegate.getValue();
    }

    public final int getCpuIndex() {
        return this.cpuIndex;
    }

    public final boolean getIdleStateReadError() {
        return this.idleStateReadError;
    }

    public final long idleTime() throws PseudoReadException {
        if (this.idleStateReadError) {
            throw new PseudoReadException(this.basePath + "/cpuidle", "cpuIdle state is Empty", null);
        }
        long jTime = 0;
        Iterator<CpuIdleState> it = getCpuIdleStates().iterator();
        while (it.hasNext()) {
            jTime += it.next().time();
        }
        return jTime;
    }

    public final boolean online() {
        return j.a(c.e(new File(this.basePath, "online"), null, 1, null), "1");
    }

    public final void setIdleStateReadError(boolean z) {
        this.idleStateReadError = z;
    }
}
