package com.tencent.tmachine.trace.cpu.sysfs;

import com.tencent.tmachine.trace.cpu.PseudoException;
import f.d;
import f.f;
import f.p;
import f.u.q;
import f.z.c.a;
import f.z.d.j;
import f.z.d.k;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class SysCpu {
    public static final SysCpu INSTANCE = new SysCpu();
    private static final Pattern policyPattern = Pattern.compile("policy[0-9]");
    private static final Pattern cpuPattern = Pattern.compile("cpu[0-9]");
    private static final d cpus$delegate = f.b(AnonymousClass2.INSTANCE);
    private static final d maxFrequency$delegate = f.b(SysCpu$maxFrequency$2.INSTANCE);

    /* JADX INFO: renamed from: com.tencent.tmachine.trace.cpu.sysfs.SysCpu$cpus$2, reason: invalid class name */
    public static final class AnonymousClass2 extends k implements a<List<Cpu>> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(0);
        }

        @Override // f.z.c.a
        public final List<Cpu> invoke() throws PseudoException {
            ArrayList arrayList = new ArrayList();
            File[] fileArrListFiles = new File("/sys/devices/system/cpu/").listFiles(new FilenameFilter() { // from class: com.tencent.tmachine.trace.cpu.sysfs.SysCpu$cpus$2$cpuFilter$1
                @Override // java.io.FilenameFilter
                public final boolean accept(File file, String str) {
                    SysCpu sysCpu = SysCpu.INSTANCE;
                    return SysCpu.cpuPattern.matcher(str).matches();
                }
            });
            if (fileArrListFiles == null) {
                throw new PseudoException("couldn't find cpu pseudo file in '/sys/devices/system/cpu/' dir", null);
            }
            for (File file : fileArrListFiles) {
                j.b(file, "cpuFile");
                String name = file.getName();
                j.b(name, "cpuFile.name");
                int length = file.getName().length();
                if (name == null) {
                    throw new p("null cannot be cast to non-null type java.lang.String");
                }
                String strSubstring = name.substring(3, length);
                j.b(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                arrayList.add(new Cpu(Integer.parseInt(strSubstring)));
            }
            q.k(arrayList, new Comparator<Cpu>() { // from class: com.tencent.tmachine.trace.cpu.sysfs.SysCpu.cpus.2.1
                @Override // java.util.Comparator
                public final int compare(Cpu cpu, Cpu cpu2) {
                    return cpu.getCpuIndex() - cpu2.getCpuIndex();
                }
            });
            return arrayList;
        }
    }

    private SysCpu() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<Cpu> getCpus() {
        return (List) cpus$delegate.getValue();
    }

    public final List<CpuPolicy> cpuClusters() {
        ArrayList arrayList = new ArrayList();
        File[] fileArrListFiles = new File("/sys/devices/system/cpu/cpufreq").listFiles(new FilenameFilter() { // from class: com.tencent.tmachine.trace.cpu.sysfs.SysCpu$cpuClusters$policyFilter$1
            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str) {
                SysCpu sysCpu = SysCpu.INSTANCE;
                return SysCpu.policyPattern.matcher(str).matches();
            }
        });
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                arrayList.add(new CpuPolicy(file));
            }
        }
        return arrayList;
    }

    public final int cpuCount() {
        return getCpus().size();
    }

    public final List<Cpu> cpus() {
        return getCpus();
    }

    public final long getMaxFrequency() {
        return ((Number) maxFrequency$delegate.getValue()).longValue();
    }
}
