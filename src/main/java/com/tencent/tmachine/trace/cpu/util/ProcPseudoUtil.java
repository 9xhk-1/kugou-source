package com.tencent.tmachine.trace.cpu.util;

import android.os.Process;
import com.tencent.tmachine.trace.cpu.data.ProcStatSummary;
import f.e0.n;
import f.p;
import f.y.c;
import f.z.d.g;
import f.z.d.j;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public final class ProcPseudoUtil {
    public static final Companion Companion = new Companion(null);
    private static int myPid;

    public static final class Companion {
        private Companion() {
        }

        public final int mainThreadTid() {
            return myPid();
        }

        public final int myPid() {
            if (ProcPseudoUtil.myPid != 0) {
                return ProcPseudoUtil.myPid;
            }
            ProcPseudoUtil.myPid = Process.myPid();
            return ProcPseudoUtil.myPid;
        }

        public final ProcStatSummary readProcStatSummary(File file) {
            j.f(file, "statFile");
            ProcStatSummary procStatSummary = new ProcStatSummary();
            String[] strArrSplitWorker = StringUtil.splitWorker(c.e(file, null, 1, null), ' ', false);
            String str = strArrSplitWorker[0];
            j.b(str, "segments[0]");
            procStatSummary.setPid(str);
            String str2 = strArrSplitWorker[1];
            j.b(str2, "segments[1]");
            if (n.k(str2, ")", false, 2, null)) {
                String str3 = strArrSplitWorker[1];
                j.b(str3, "segments[1]");
                int length = strArrSplitWorker[1].length() - 1;
                if (str3 == null) {
                    throw new p("null cannot be cast to non-null type java.lang.String");
                }
                String strSubstring = str3.substring(1, length);
                j.b(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                procStatSummary.setName(strSubstring);
            }
            String str4 = strArrSplitWorker[2];
            j.b(str4, "segments[2]");
            procStatSummary.setState(str4);
            String str5 = strArrSplitWorker[13];
            j.b(str5, "segments[13]");
            procStatSummary.setUtime(Long.parseLong(str5));
            String str6 = strArrSplitWorker[14];
            j.b(str6, "segments[14]");
            procStatSummary.setStime(Long.parseLong(str6));
            String str7 = strArrSplitWorker[15];
            j.b(str7, "segments[15]");
            procStatSummary.setCutime(Long.parseLong(str7));
            String str8 = strArrSplitWorker[16];
            j.b(str8, "segments[16]");
            procStatSummary.setCstime(Long.parseLong(str8));
            String str9 = strArrSplitWorker[18];
            j.b(str9, "segments[18]");
            procStatSummary.setNice(str9);
            String str10 = strArrSplitWorker[19];
            j.b(str10, "segments[19]");
            procStatSummary.setNumThreads(Integer.parseInt(str10));
            String str11 = strArrSplitWorker[22];
            j.b(str11, "segments[22]");
            procStatSummary.setVsize(Long.parseLong(str11));
            return procStatSummary;
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    public static final int myPid() {
        return Companion.myPid();
    }

    public static final ProcStatSummary readProcStatSummary(File file) {
        return Companion.readProcStatSummary(file);
    }
}
