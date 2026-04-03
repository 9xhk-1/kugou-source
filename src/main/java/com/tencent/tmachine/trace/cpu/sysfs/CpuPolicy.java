package com.tencent.tmachine.trace.cpu.sysfs;

import com.tencent.tmachine.trace.cpu.CpuKtExtensions;
import com.tencent.tmachine.trace.cpu.util.CpuPseudoUtil;
import com.tencent.tmachine.trace.cpu.util.StringUtil;
import f.d;
import f.e0.o;
import f.f;
import f.u.m;
import f.u.n;
import f.u.u;
import f.y.c;
import f.z.d.j;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class CpuPolicy {
    private List<Cpu> _affectedCpus;
    private final d maxFreq$delegate;
    private final d maxFreqFile$delegate;
    private final d minFreq$delegate;
    private final d minFreqFile$delegate;
    private final File policyFile;
    private final d scalingCurFreqFile$delegate;
    private final d scalingMaxFreqFile$delegate;
    private final d scalingMinFreqFile$delegate;
    private final d timeInStateFile$delegate;

    public CpuPolicy(File file) {
        j.f(file, "policyFile");
        this.policyFile = file;
        this.timeInStateFile$delegate = f.b(new CpuPolicy$timeInStateFile$2(this));
        this.maxFreqFile$delegate = f.b(new CpuPolicy$maxFreqFile$2(this));
        this.minFreqFile$delegate = f.b(new CpuPolicy$minFreqFile$2(this));
        this.scalingMinFreqFile$delegate = f.b(new CpuPolicy$scalingMinFreqFile$2(this));
        this.scalingMaxFreqFile$delegate = f.b(new CpuPolicy$scalingMaxFreqFile$2(this));
        this.scalingCurFreqFile$delegate = f.b(new CpuPolicy$scalingCurFreqFile$2(this));
        this.maxFreq$delegate = f.b(new CpuPolicy$maxFreq$2(this));
        this.minFreq$delegate = f.b(new CpuPolicy$minFreq$2(this));
        this._affectedCpus = m.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File getMaxFreqFile() {
        return (File) this.maxFreqFile$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File getMinFreqFile() {
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

    private final File getTimeInStateFile() {
        return (File) this.timeInStateFile$delegate.getValue();
    }

    public final int affectedCpuCount() {
        return affectedCpus().size();
    }

    public final int[] affectedCpuIndex() {
        List<Cpu> listAffectedCpus = affectedCpus();
        ArrayList arrayList = new ArrayList(n.j(listAffectedCpus, 10));
        Iterator<T> it = listAffectedCpus.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((Cpu) it.next()).getCpuIndex()));
        }
        return u.L(arrayList);
    }

    public final List<Cpu> affectedCpus() {
        if (this._affectedCpus.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (String str : c.c(new File(this.policyFile.getAbsolutePath() + "/affected_cpus"), null, 1, null)) {
                if (str.length() > 0) {
                    String[] strArrSplitWorker = StringUtil.splitWorker(str, ' ');
                    j.b(strArrSplitWorker, "StringUtil.splitWorker(lineText, ' ')");
                    ArrayList arrayList2 = new ArrayList(strArrSplitWorker.length);
                    for (String str2 : strArrSplitWorker) {
                        arrayList2.add(Integer.valueOf(Integer.parseInt(str2)));
                    }
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new Cpu(((Number) it.next()).intValue()));
                    }
                }
            }
            this._affectedCpus = arrayList;
        }
        return this._affectedCpus;
    }

    public final long getMaxFreq() {
        return ((Number) this.maxFreq$delegate.getValue()).longValue();
    }

    public final long getMinFreq() {
        return ((Number) this.minFreq$delegate.getValue()).longValue();
    }

    public final long readCpuTime() {
        return CpuPseudoUtil.Companion.readCpuTimeFromTimeInstateFile(getTimeInStateFile()) * ((long) 10);
    }

    public final List<Long> scalingAvailableFrequencies() {
        List<String> listC = c.c(new File(this.policyFile.getAbsolutePath() + "/scaling_available_frequencies"), null, 1, null);
        ArrayList arrayList = new ArrayList();
        for (String str : listC) {
            if (!(str.length() == 0)) {
                for (String str2 : o.S(str, new String[]{" "}, false, 0, 6, null)) {
                    if (str2.length() > 0) {
                        arrayList.add(Long.valueOf(Long.parseLong(str2)));
                    }
                }
            }
        }
        return arrayList;
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
