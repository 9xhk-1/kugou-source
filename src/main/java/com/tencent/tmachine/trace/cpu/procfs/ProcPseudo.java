package com.tencent.tmachine.trace.cpu.procfs;

import com.tencent.tmachine.trace.cpu.Pseudo;
import com.tencent.tmachine.trace.cpu.data.ProcStatSummary;
import com.tencent.tmachine.trace.cpu.util.ProcPseudoUtil;
import f.d;
import f.f;
import f.z.d.g;
import f.z.d.j;
import java.io.File;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: loaded from: classes2.dex */
public final class ProcPseudo implements Pseudo {
    private final File procPseudoDir;
    private final d statFile$delegate;
    public static final Companion Companion = new Companion(null);
    private static final d myProcPseudo$delegate = f.b(ProcPseudo$Companion$myProcPseudo$2.INSTANCE);
    private static final d myMainThreadProcPseudo$delegate = f.b(ProcPseudo$Companion$myMainThreadProcPseudo$2.INSTANCE);

    public static final class Companion {
        private Companion() {
        }

        private final ProcPseudo getMyMainThreadProcPseudo() {
            d dVar = ProcPseudo.myMainThreadProcPseudo$delegate;
            Companion companion = ProcPseudo.Companion;
            return (ProcPseudo) dVar.getValue();
        }

        private final ProcPseudo getMyProcPseudo() {
            d dVar = ProcPseudo.myProcPseudo$delegate;
            Companion companion = ProcPseudo.Companion;
            return (ProcPseudo) dVar.getValue();
        }

        public final ProcPseudo create(File file) {
            j.f(file, ClientCookie.PATH_ATTR);
            return new ProcPseudo(file);
        }

        public final ProcPseudo myMainThreadTaskPseudo() {
            return getMyMainThreadProcPseudo();
        }

        public final ProcPseudo myProcPseudo() {
            return getMyProcPseudo();
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    public ProcPseudo(File file) {
        j.f(file, "procPseudoDir");
        this.procPseudoDir = file;
        this.statFile$delegate = f.b(new ProcPseudo$statFile$2(this));
    }

    public static final ProcPseudo create(File file) {
        return Companion.create(file);
    }

    private final File getStatFile() {
        return (File) this.statFile$delegate.getValue();
    }

    public static final ProcPseudo myMainThreadTaskPseudo() {
        return Companion.myMainThreadTaskPseudo();
    }

    public static final ProcPseudo myProcPseudo() {
        return Companion.myProcPseudo();
    }

    public final ProcStatSummary readProcStatSummary() {
        return ProcPseudoUtil.Companion.readProcStatSummary(getStatFile());
    }
}
