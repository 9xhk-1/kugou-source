package com.tencent.tmachine.trace.cpu.util;

import com.tencent.tmachine.trace.cpu.PseudoException;
import com.tencent.tmachine.trace.cpu.PseudoReadException;
import com.tencent.tmachine.trace.cpu.data.TimeInState;
import f.d;
import f.f;
import f.y.c;
import f.z.d.g;
import f.z.d.j;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class CpuPseudoUtil {
    public static final Companion Companion = new Companion(null);
    private static final d millSecondsPerTicks$delegate = f.b(CpuPseudoUtil$Companion$millSecondsPerTicks$2.INSTANCE);

    public static final class Companion {
        private Companion() {
        }

        public final long getMillSecondsPerTicks() {
            d dVar = CpuPseudoUtil.millSecondsPerTicks$delegate;
            Companion companion = CpuPseudoUtil.Companion;
            return ((Number) dVar.getValue()).longValue();
        }

        public final long readCpuTimeFromTimeInstateFile(File file) throws PseudoException {
            j.f(file, "timeInstateFile");
            List listC = c.c(file, null, 1, null);
            if (listC.isEmpty()) {
                throw new PseudoException("timeInstateFile:" + file.getPath() + " content is empty", null);
            }
            Iterator it = listC.iterator();
            long j = 0;
            while (it.hasNext()) {
                String str = StringUtil.splitWorker((String) it.next(), ' ')[1];
                j.b(str, "timeInstateTuple[1]");
                j += Long.parseLong(str);
            }
            return j;
        }

        public final TimeInState readCpuTimeInState(File file, int i2) throws PseudoReadException, FileNotFoundException {
            j.f(file, "cpuTimeInStateFile");
            if (!file.exists()) {
                throw new FileNotFoundException(file.getAbsolutePath());
            }
            TimeInState timeInState = new TimeInState();
            List listC = c.c(file, null, 1, null);
            if (listC.isEmpty()) {
                String absolutePath = file.getAbsolutePath();
                j.b(absolutePath, "cpuTimeInStateFile.absolutePath");
                throw new PseudoReadException(absolutePath, null);
            }
            Iterator it = listC.iterator();
            while (it.hasNext()) {
                String[] strArrSplitWorker = StringUtil.splitWorker((String) it.next(), ' ', false);
                String str = strArrSplitWorker[0];
                j.b(str, "timeInstatePair[0]");
                long j = Long.parseLong(str);
                String str2 = strArrSplitWorker[1];
                j.b(str2, "timeInstatePair[1]");
                timeInState.setTime(j, Long.parseLong(str2) * ((long) i2));
            }
            return timeInState;
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    public static final TimeInState readCpuTimeInState(File file, int i2) {
        return Companion.readCpuTimeInState(file, i2);
    }
}
