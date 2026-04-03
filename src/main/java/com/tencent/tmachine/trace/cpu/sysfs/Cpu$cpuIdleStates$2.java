package com.tencent.tmachine.trace.cpu.sysfs;

import com.kugou.common.apm.sdk.ApmDataKey;
import f.e0.n;
import f.u.m;
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
public final class Cpu$cpuIdleStates$2 extends k implements a<List<? extends CpuIdleState>> {
    public final /* synthetic */ Cpu this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Cpu$cpuIdleStates$2(Cpu cpu) {
        super(0);
        this.this$0 = cpu;
    }

    @Override // f.z.c.a
    public final List<? extends CpuIdleState> invoke() {
        ArrayList arrayList = new ArrayList();
        File[] fileArrListFiles = new File(this.this$0.basePath + "/cpuidle").listFiles(new FilenameFilter() { // from class: com.tencent.tmachine.trace.cpu.sysfs.Cpu$cpuIdleStates$2$stateFiles$1
            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str) {
                return Pattern.matches("state[0-9]", str);
            }
        });
        if (fileArrListFiles != null) {
            if (!(fileArrListFiles.length == 0)) {
                for (File file : fileArrListFiles) {
                    j.b(file, "cpuIdleFile");
                    String name = file.getName();
                    j.b(name, "cpuIdleFile.name");
                    arrayList.add(new CpuIdleState(this.this$0.getCpuIndex(), Integer.parseInt(n.q(name, ApmDataKey.STATE, "", false, 4, null))));
                }
                if (arrayList.size() > 1) {
                    q.k(arrayList, new Comparator<T>() { // from class: com.tencent.tmachine.trace.cpu.sysfs.Cpu$cpuIdleStates$2$$special$$inlined$sortBy$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            return f.v.a.a(Integer.valueOf(((CpuIdleState) t).getState()), Integer.valueOf(((CpuIdleState) t2).getState()));
                        }
                    });
                }
                return arrayList;
            }
        }
        this.this$0.setIdleStateReadError(true);
        return m.d();
    }
}
