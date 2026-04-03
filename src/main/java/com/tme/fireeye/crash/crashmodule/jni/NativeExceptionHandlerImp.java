package com.tme.fireeye.crash.crashmodule.jni;

import android.content.Context;
import android.text.TextUtils;
import com.kugou.framework.libcommon.netcore.BaseConnection;
import com.tme.fireeye.crash.crashmodule.CrashDetailBean;
import e.f.a.a.a.h.b;
import e.f.a.a.a.i.a;
import e.f.a.a.a.k.c;
import e.f.a.a.a.k.e;
import e.f.a.a.a.k.f;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class NativeExceptionHandlerImp implements NativeExceptionHandler {
    private final b comInfo;
    private final Context context;
    private final e.f.a.a.b.b crashHandler;
    private final a strategyManager;

    public NativeExceptionHandlerImp(Context context, b bVar, e.f.a.a.b.b bVar2, a aVar) {
        this.context = context;
        this.crashHandler = bVar2;
        this.comInfo = bVar;
        this.strategyManager = aVar;
    }

    @Override // com.tme.fireeye.crash.crashmodule.jni.NativeExceptionHandler
    public void handleNativeException(int i2, int i3, long j, long j2, String str, String str2, String str3, String str4, int i4, String str5, int i5, int i6, int i7, String str6, String str7) {
        c.f("Native Crash Happen v1", new Object[0]);
        handleNativeException2(i2, i3, j, j2, str, str2, str3, str4, i4, str5, i5, i6, i7, str6, str7, null);
    }

    @Override // com.tme.fireeye.crash.crashmodule.jni.NativeExceptionHandler
    public void handleNativeException2(int i2, int i3, long j, long j2, String str, String str2, String str3, String str4, int i4, String str5, int i5, int i6, int i7, String str6, String str7, String[] strArr) {
        String str8;
        String str9;
        String str10;
        boolean z;
        boolean z2;
        c.f("Native Crash Happen v2", new Object[0]);
        try {
            String strA = e.f.a.a.b.g.a.a(str3);
            if (i4 > 0) {
                str9 = str + "(" + str5 + ")";
                str8 = "UNKNOWN";
                str10 = "KERNEL";
            } else {
                String strE = i5 > 0 ? e.f.a.a.a.h.a.e(this.context, i5) : "UNKNOWN";
                str8 = strE.equals(String.valueOf(i5)) ? strE : strE + "(" + i5 + ")";
                str9 = str;
                str10 = str5;
            }
            HashMap map = new HashMap();
            if (strArr != null) {
                for (int i8 = 0; i8 < strArr.length; i8++) {
                    String str11 = strArr[i8];
                    if (str11 != null) {
                        c.f("Extra message[%d]: %s", Integer.valueOf(i8), str11);
                        String[] strArrSplit = str11.split(BaseConnection.HTTP_REQ_ENTITY_MERGE);
                        if (strArrSplit.length == 2) {
                            map.put(strArrSplit[0], strArrSplit[1]);
                        } else {
                            c.j("bad extraMsg %s", str11);
                        }
                    }
                }
            } else {
                c.b("not found extraMsg", new Object[0]);
            }
            String str12 = (String) map.get("HasPendingException");
            if (str12 == null || !str12.equals("true")) {
                z = false;
            } else {
                c.f("Native crash happened with a Java pending exception.", new Object[0]);
                z = true;
            }
            String str13 = (String) map.get("ExceptionProcessName");
            if (str13 == null || str13.length() == 0) {
                str13 = this.comInfo.f1346f;
            } else {
                c.b("Name of crash process: %s", str13);
            }
            String str14 = str13;
            String str15 = (String) map.get("ExceptionThreadName");
            if (str15 == null || str15.length() == 0) {
                Thread threadCurrentThread = Thread.currentThread();
                str15 = threadCurrentThread.getName() + "(" + threadCurrentThread.getId() + ")";
            } else {
                c.b("Name of crash thread: %s", str15);
                Iterator<Thread> it = Thread.getAllStackTraces().keySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z2 = false;
                        break;
                    }
                    Thread next = it.next();
                    if (next.getName().equals(str15)) {
                        str15 = str15 + "(" + next.getId() + ")";
                        z2 = true;
                        break;
                    }
                }
                if (!z2) {
                    str15 = str15 + "(" + i3 + ")";
                }
            }
            String str16 = str15;
            long j3 = (j * 1000) + (j2 / 1000);
            String str17 = (String) map.get("SysLogPath");
            String str18 = (String) map.get("JniLogPath");
            if (!this.strategyManager.i()) {
                c.j("no remote but still store!", new Object[0]);
            }
            if (!this.strategyManager.h().f269d && this.strategyManager.i()) {
                c.c("crash report was closed by remote , will not upload to FireEye , print local for helpful!", new Object[0]);
                e.f.a.a.b.b.t("NATIVE_CRASH", f.m(), str14, str16, str9 + "\n" + str2 + "\n" + strA, null);
                f.c(str4);
                return;
            }
            String str19 = str9;
            try {
                CrashDetailBean crashDetailBeanPackageCrashDatas = packageCrashDatas(str14, str16, j3, str9, str2, strA, str10, str8, str4, str17, str18, str7, null, null, true, z);
                if (crashDetailBeanPackageCrashDatas == null) {
                    c.c("pkg crash datas fail!", new Object[0]);
                    return;
                }
                e.f.a.a.b.b.t("NATIVE_CRASH", f.m(), str14, str16, str19 + "\n" + str2 + "\n" + strA, crashDetailBeanPackageCrashDatas);
                try {
                    boolean z3 = !this.crashHandler.k(crashDetailBeanPackageCrashDatas, i4);
                    if (!TextUtils.isEmpty(str18) && !TextUtils.isEmpty(crashDetailBeanPackageCrashDatas.E)) {
                        f.c(str18);
                    }
                    NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
                    e.f.a.a.b.g.a.c(true, nativeCrashHandler != null ? nativeCrashHandler.getDumpFilePath() : null);
                    if (z3) {
                        this.crashHandler.A(crashDetailBeanPackageCrashDatas, 3000L, true);
                    }
                    this.crashHandler.r(crashDetailBeanPackageCrashDatas);
                    if (NativeCrashHandler.isProtectionModeEnabled) {
                        return;
                    }
                    e.f.a.a.b.c.c().b();
                    return;
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
        if (c.k(th)) {
            return;
        }
        th.printStackTrace();
    }

    @Override // com.tme.fireeye.crash.crashmodule.jni.NativeExceptionHandler
    public CrashDetailBean packageCrashDatas(String str, String str2, long j, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, byte[] bArr, Map<String, String> map, boolean z, boolean z2) {
        int i2;
        String str12;
        int iIndexOf;
        boolean zF = e.f.a.a.b.c.c().f();
        if (zF) {
            c.c("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
        }
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        crashDetailBean.b = 1;
        crashDetailBean.f275h = this.comInfo.l();
        crashDetailBean.f276i = this.comInfo.d();
        crashDetailBean.j = this.comInfo.i();
        crashDetailBean.q = this.comInfo.x();
        crashDetailBean.r = str3;
        crashDetailBean.s = zF ? " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![FireEye]" : "";
        crashDetailBean.t = str4;
        String str13 = str5 != null ? str5 : "";
        crashDetailBean.u = str13;
        crashDetailBean.v = j;
        crashDetailBean.y = f.p(str13.getBytes());
        crashDetailBean.H = str;
        crashDetailBean.I = str2;
        crashDetailBean.P = this.comInfo.r();
        crashDetailBean.k = this.comInfo.p();
        crashDetailBean.l = this.comInfo.o();
        crashDetailBean.z = str8;
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
        String dumpFilePath = nativeCrashHandler != null ? nativeCrashHandler.getDumpFilePath() : null;
        String strF = e.f.a.a.b.g.a.f(dumpFilePath, str8);
        if (!f.q(strF)) {
            crashDetailBean.d0 = strF;
        }
        crashDetailBean.e0 = e.f.a.a.b.g.a.d(dumpFilePath);
        crashDetailBean.D = e.f.a.a.b.g.a.g(str9, e.f.a.a.b.c.l, e.f.a.a.b.c.o, e.f.a.a.b.c.t);
        crashDetailBean.E = e.f.a.a.b.g.a.g(str10, e.f.a.a.b.c.l, null, true);
        crashDetailBean.R = str7;
        crashDetailBean.S = str6;
        crashDetailBean.T = str11;
        crashDetailBean.M = this.comInfo.u();
        crashDetailBean.N = this.comInfo.v();
        crashDetailBean.O = this.comInfo.w();
        if (z) {
            crashDetailBean.J = e.f.a.a.a.h.c.k();
            crashDetailBean.K = e.f.a.a.a.h.c.m();
            crashDetailBean.L = e.f.a.a.a.h.c.i();
            if (crashDetailBean.D == null) {
                crashDetailBean.D = f.x(this.context, e.f.a.a.b.c.l, e.f.a.a.b.c.o);
            }
            crashDetailBean.F = e.b();
            b bVar = this.comInfo;
            crashDetailBean.U = bVar.c;
            crashDetailBean.V = bVar.B();
            crashDetailBean.G = f.i(e.f.a.a.b.c.m, false);
            int iIndexOf2 = crashDetailBean.u.indexOf("java:\n");
            if (iIndexOf2 > 0 && (i2 = iIndexOf2 + 6) < crashDetailBean.u.length()) {
                String str14 = crashDetailBean.u;
                String strSubstring = str14.substring(i2, str14.length() - 1);
                if (strSubstring.length() > 0 && crashDetailBean.G.containsKey(crashDetailBean.I) && (iIndexOf = (str12 = crashDetailBean.G.get(crashDetailBean.I)).indexOf(strSubstring)) > 0) {
                    String strSubstring2 = str12.substring(iIndexOf);
                    crashDetailBean.G.put(crashDetailBean.I, strSubstring2);
                    crashDetailBean.u = crashDetailBean.u.substring(0, i2);
                    crashDetailBean.u += strSubstring2;
                }
            }
            if (str == null) {
                crashDetailBean.H = this.comInfo.f1346f;
            }
            this.crashHandler.l(crashDetailBean);
            crashDetailBean.Y = this.comInfo.z();
            crashDetailBean.Z = this.comInfo.s();
            crashDetailBean.a0 = this.comInfo.h();
            crashDetailBean.b0 = this.comInfo.g();
        } else {
            crashDetailBean.J = -1L;
            crashDetailBean.K = -1L;
            crashDetailBean.L = -1L;
            if (crashDetailBean.D == null) {
                crashDetailBean.D = "this crash is occurred at last process! Log is miss, when get an terrible ABRT Native Exception etc.";
            }
            crashDetailBean.U = -1L;
            crashDetailBean.Y = -1;
            crashDetailBean.Z = -1;
            crashDetailBean.a0 = map;
            crashDetailBean.b0 = this.comInfo.g();
            crashDetailBean.G = null;
            if (str == null) {
                crashDetailBean.H = "unknown(record)";
            }
            if (bArr != null) {
                crashDetailBean.F = bArr;
            }
        }
        return crashDetailBean;
    }
}
