package com.tencent.tmachine.trace.cpu.procfs;

import com.tencent.tmachine.trace.cpu.util.ProcPseudoUtil;
import f.z.c.a;
import f.z.d.k;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public final class ProcPseudo$Companion$myMainThreadProcPseudo$2 extends k implements a<ProcPseudo> {
    public static final ProcPseudo$Companion$myMainThreadProcPseudo$2 INSTANCE = new ProcPseudo$Companion$myMainThreadProcPseudo$2();

    public ProcPseudo$Companion$myMainThreadProcPseudo$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // f.z.c.a
    public final ProcPseudo invoke() {
        StringBuilder sb = new StringBuilder();
        sb.append("/proc/");
        ProcPseudoUtil.Companion companion = ProcPseudoUtil.Companion;
        sb.append(companion.myPid());
        sb.append("/task/");
        sb.append(companion.myPid());
        return new ProcPseudo(new File(sb.toString()));
    }
}
