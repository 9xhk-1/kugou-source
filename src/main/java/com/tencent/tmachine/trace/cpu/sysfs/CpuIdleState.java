package com.tencent.tmachine.trace.cpu.sysfs;

import com.tencent.tmachine.trace.cpu.CpuKtExtensions;
import f.d;
import f.f;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public final class CpuIdleState {
    private final String pseudoPath;
    private final int state;
    private final d name$delegate = f.b(new CpuIdleState$name$2(this));
    private final d timeFile$delegate = f.b(new CpuIdleState$timeFile$2(this));
    private final d usageFile$delegate = f.b(new CpuIdleState$usageFile$2(this));

    public CpuIdleState(int i2, int i3) {
        this.state = i3;
        this.pseudoPath = "/sys/devices/system/cpu/cpu" + i2 + "/cpuidle/state" + i3;
    }

    private final File getTimeFile() {
        return (File) this.timeFile$delegate.getValue();
    }

    private final File getUsageFile() {
        return (File) this.usageFile$delegate.getValue();
    }

    public final String getName() {
        return (String) this.name$delegate.getValue();
    }

    public final int getState() {
        return this.state;
    }

    public final long time() {
        return CpuKtExtensions.INSTANCE.readLong(getTimeFile());
    }

    public final long usage() {
        return CpuKtExtensions.INSTANCE.readLong(getUsageFile());
    }
}
