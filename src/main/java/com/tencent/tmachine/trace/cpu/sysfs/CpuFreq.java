package com.tencent.tmachine.trace.cpu.sysfs;

import com.tencent.tmachine.trace.cpu.CpuKtExtensions;
import f.d;
import f.f;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public final class CpuFreq {
    private final File pseudoFile;
    private final d scalingMaxFreqFile$delegate = f.b(new CpuFreq$scalingMaxFreqFile$2(this));
    private final d scalingMinFreqFile$delegate = f.b(new CpuFreq$scalingMinFreqFile$2(this));
    private final d scalingCurFreqFile$delegate = f.b(new CpuFreq$scalingCurFreqFile$2(this));
    private final d maxFreqFile$delegate = f.b(new CpuFreq$maxFreqFile$2(this));
    private final d minFreqFile$delegate = f.b(new CpuFreq$minFreqFile$2(this));

    public CpuFreq(int i2) {
        this.pseudoFile = new File("/sys/devices/system/cpu/cpu" + i2 + "/cpufreq");
    }

    private final File getMaxFreqFile() {
        return (File) this.maxFreqFile$delegate.getValue();
    }

    private final File getMinFreqFile() {
        return (File) this.minFreqFile$delegate.getValue();
    }

    private final File getScalingCurFreqFile() {
        return (File) this.scalingCurFreqFile$delegate.getValue();
    }

    private final File getScalingMaxFreqFile() {
        return (File) this.scalingMaxFreqFile$delegate.getValue();
    }

    private final File getScalingMinFreqFile() {
        return (File) this.scalingMinFreqFile$delegate.getValue();
    }

    public final long maxFreq() {
        return CpuKtExtensions.INSTANCE.readLong(getMaxFreqFile());
    }

    public final long minFreq() {
        return CpuKtExtensions.INSTANCE.readLong(getMinFreqFile());
    }

    public final long scalingCurFreq() {
        return CpuKtExtensions.INSTANCE.readLong(getScalingCurFreqFile());
    }

    public final long scalingMaxFreq() {
        return CpuKtExtensions.INSTANCE.readLong(getScalingMaxFreqFile());
    }

    public final long scalingMinFreq() {
        return CpuKtExtensions.INSTANCE.readLong(getScalingMinFreqFile());
    }
}
