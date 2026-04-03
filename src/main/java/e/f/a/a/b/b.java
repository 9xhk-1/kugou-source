package e.f.a.a.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Process;
import android.text.TextUtils;
import com.kugou.common.network.ExceptionParse;
import com.kugou.framework.libcommon.netcore.BaseConnection;
import com.tme.fireeye.crash.comm.db.DbOpenHelper;
import com.tme.fireeye.crash.comm.info.PlugInBean;
import com.tme.fireeye.crash.comm.strategy.StrategyBean;
import com.tme.fireeye.crash.crashmodule.CrashDetailBean;
import e.f.a.a.a.b;
import e.f.a.a.a.k.f;
import e.f.a.a.d.a.g;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int f1376g;
    public final Context a;
    public final e.f.a.a.a.j.d b;
    public final e.f.a.a.a.g.b c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e.f.a.a.a.i.a f1377d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public e f1378e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b.a f1379f;

    public class a implements e.f.a.a.a.j.c {
        public final /* synthetic */ List a;

        public a(List list) {
            this.a = list;
        }

        @Override // e.f.a.a.a.j.c
        public void onUploadEnd(int i2, g gVar, long j, long j2, boolean z, String str) {
            b.this.B(z, this.a);
        }

        @Override // e.f.a.a.a.j.c
        public void onUploadStart(int i2) {
        }
    }

    public b(int i2, Context context, e.f.a.a.a.j.d dVar, e.f.a.a.a.g.b bVar, e.f.a.a.a.i.a aVar, b.a aVar2, e eVar) {
        f1376g = i2;
        this.a = context;
        this.b = dVar;
        this.c = bVar;
        this.f1377d = aVar;
        this.f1378e = eVar;
    }

    public static e.f.a.a.d.a.d g(Context context, CrashDetailBean crashDetailBean, e.f.a.a.a.h.b bVar) {
        e.f.a.a.d.a.c cVarI;
        e.f.a.a.d.a.c cVarI2;
        e.f.a.a.d.a.c cVarI3;
        e.f.a.a.d.a.c cVarI4;
        e.f.a.a.d.a.c cVarI5;
        e.f.a.a.d.a.c cVar;
        if (context == null || crashDetailBean == null || bVar == null) {
            e.f.a.a.a.k.c.j("enExp args == null", new Object[0]);
            return null;
        }
        e.f.a.a.d.a.d dVar = new e.f.a.a.d.a.d();
        int i2 = crashDetailBean.b;
        switch (i2) {
            case 0:
                dVar.a = crashDetailBean.m ? "200" : ExceptionParse.NET_URL_PROTOCOL_ERROR;
                break;
            case 1:
                dVar.a = crashDetailBean.m ? "201" : ExceptionParse.NET_DNS_FAIL;
                break;
            case 2:
                dVar.a = crashDetailBean.m ? "202" : ExceptionParse.NET_PING_FAIL;
                break;
            case 3:
            case 9:
                dVar.a = crashDetailBean.m ? "203" : "103";
                break;
            case 4:
                dVar.a = crashDetailBean.m ? "204" : "104";
                break;
            case 5:
                dVar.a = crashDetailBean.m ? "207" : "107";
                break;
            case 6:
                dVar.a = crashDetailBean.m ? "206" : ExceptionParse.NET_TCP_TRANSFER_TIMEOUT;
                break;
            case 7:
                dVar.a = crashDetailBean.m ? "208" : "108";
                break;
            case 8:
            default:
                e.f.a.a.a.k.c.c("crash type error! %d", Integer.valueOf(i2));
                break;
        }
        dVar.b = crashDetailBean.v;
        dVar.f1436d = crashDetailBean.r;
        dVar.f1437f = crashDetailBean.s;
        dVar.f1438h = crashDetailBean.t;
        dVar.j = crashDetailBean.u;
        dVar.k = crashDetailBean.G;
        dVar.l = crashDetailBean.f273d;
        dVar.m = null;
        dVar.o = crashDetailBean.q;
        dVar.p = crashDetailBean.f275h;
        dVar.f1439i = crashDetailBean.I;
        dVar.q = null;
        e.f.a.a.a.k.c.b("libInfo %s", dVar.r);
        Map<String, PlugInBean> map = crashDetailBean.k;
        if (map != null && map.size() > 0) {
            dVar.s = new ArrayList<>();
            for (Map.Entry<String, PlugInBean> entry : crashDetailBean.k.entrySet()) {
                e.f.a.a.d.a.a aVar = new e.f.a.a.d.a.a();
                aVar.a = entry.getValue().a;
                aVar.f1430d = entry.getValue().f268d;
                aVar.f1432h = entry.getValue().b;
                dVar.s.add(aVar);
            }
        }
        dVar.n = crashDetailBean.x + 1;
        if (crashDetailBean.m) {
            String str = crashDetailBean.w;
            if (str != null && str.length() > 0) {
                if (dVar.t == null) {
                    dVar.t = new ArrayList<>();
                }
                try {
                    dVar.t.add(new e.f.a.a.d.a.c((byte) 1, "alltimes.txt", crashDetailBean.w.getBytes("utf-8")));
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                    dVar.t = null;
                }
            }
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(dVar.n);
            ArrayList<e.f.a.a.d.a.c> arrayList = dVar.t;
            objArr[1] = Integer.valueOf(arrayList != null ? arrayList.size() : 0);
            e.f.a.a.a.k.c.b("crashcount:%d sz:%d", objArr);
        }
        if (crashDetailBean.D != null) {
            if (dVar.t == null) {
                dVar.t = new ArrayList<>();
            }
            try {
                dVar.t.add(new e.f.a.a.d.a.c((byte) 1, "log.txt", crashDetailBean.D.getBytes("utf-8")));
            } catch (UnsupportedEncodingException e3) {
                e3.printStackTrace();
                dVar.t = null;
            }
        }
        if (crashDetailBean.E != null) {
            if (dVar.t == null) {
                dVar.t = new ArrayList<>();
            }
            try {
                dVar.t.add(new e.f.a.a.d.a.c((byte) 1, "jniLog.txt", crashDetailBean.E.getBytes("utf-8")));
            } catch (UnsupportedEncodingException e4) {
                e4.printStackTrace();
                dVar.t = null;
            }
        }
        if (!f.q(crashDetailBean.d0)) {
            if (dVar.t == null) {
                dVar.t = new ArrayList<>();
            }
            try {
                cVar = new e.f.a.a.d.a.c((byte) 1, "crashInfos.txt", crashDetailBean.d0.getBytes("utf-8"));
            } catch (UnsupportedEncodingException e5) {
                e5.printStackTrace();
                cVar = null;
            }
            if (cVar != null) {
                e.f.a.a.a.k.c.b("attach crash infos", new Object[0]);
                dVar.t.add(cVar);
            }
        }
        if (crashDetailBean.e0 != null) {
            if (dVar.t == null) {
                dVar.t = new ArrayList<>();
            }
            e.f.a.a.d.a.c cVarI6 = i("backupRecord.zip", context, crashDetailBean.e0);
            if (cVarI6 != null) {
                e.f.a.a.a.k.c.b("attach backup record", new Object[0]);
                dVar.t.add(cVarI6);
            }
        }
        byte[] bArr = crashDetailBean.F;
        if (bArr != null && bArr.length > 0) {
            e.f.a.a.d.a.c cVar2 = new e.f.a.a.d.a.c((byte) 2, "fireeyelog.zip", bArr);
            e.f.a.a.a.k.c.b("attach user log", new Object[0]);
            if (dVar.t == null) {
                dVar.t = new ArrayList<>();
            }
            dVar.t.add(cVar2);
        }
        int i3 = crashDetailBean.b;
        if (i3 == 3 || i3 == 9) {
            if (dVar.t == null) {
                dVar.t = new ArrayList<>();
            }
            e.f.a.a.a.k.c.b("crashBean.anrMessages:%s", crashDetailBean.X);
            Map<String, String> map2 = crashDetailBean.X;
            if (map2 != null && map2.containsKey("FIREEYE_CR_01")) {
                try {
                    if (!TextUtils.isEmpty(crashDetailBean.X.get("FIREEYE_CR_01"))) {
                        dVar.t.add(new e.f.a.a.d.a.c((byte) 1, "anrMessage.txt", crashDetailBean.X.get("FIREEYE_CR_01").getBytes("utf-8")));
                        e.f.a.a.a.k.c.b("attach anr message", new Object[0]);
                    }
                } catch (UnsupportedEncodingException e6) {
                    e6.printStackTrace();
                    dVar.t = null;
                }
                crashDetailBean.X.remove("FIREEYE_CR_01");
            }
            String str2 = crashDetailBean.z;
            if (str2 != null && (cVarI4 = i("trace.zip", context, str2)) != null) {
                e.f.a.a.a.k.c.b("attach traces", new Object[0]);
                dVar.t.add(cVarI4);
            }
            if (!TextUtils.isEmpty(crashDetailBean.A) && (cVarI3 = i("method_trace.zip", context, crashDetailBean.A)) != null) {
                e.f.a.a.a.k.c.f("attach method trace", new Object[0]);
                dVar.t.add(cVarI3);
            }
            if (!TextUtils.isEmpty(crashDetailBean.B) && (cVarI2 = i("cpu_trace.zip", context, crashDetailBean.B)) != null) {
                e.f.a.a.a.k.c.f("attach cpu trace", new Object[0]);
                dVar.t.add(cVarI2);
            }
            if (!TextUtils.isEmpty(crashDetailBean.C) && (cVarI = i("looper_trace.zip", context, crashDetailBean.C)) != null) {
                e.f.a.a.a.k.c.f("attach looper msg trace", new Object[0]);
                dVar.t.add(cVarI);
            }
        }
        if (crashDetailBean.b == 1) {
            if (dVar.t == null) {
                dVar.t = new ArrayList<>();
            }
            String str3 = crashDetailBean.z;
            if (str3 != null && (cVarI5 = i("tomb.zip", context, str3)) != null) {
                e.f.a.a.a.k.c.b("attach tombs", new Object[0]);
                dVar.t.add(cVarI5);
            }
        }
        List<String> list = bVar.f0;
        if (list != null && !list.isEmpty()) {
            if (dVar.t == null) {
                dVar.t = new ArrayList<>();
            }
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = bVar.f0.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
            }
            try {
                dVar.t.add(new e.f.a.a.d.a.c((byte) 1, "martianlog.txt", sb.toString().getBytes("utf-8")));
                e.f.a.a.a.k.c.b("attach pageTracingList", new Object[0]);
            } catch (UnsupportedEncodingException e7) {
                e7.printStackTrace();
            }
        }
        byte[] bArr2 = crashDetailBean.c0;
        if (bArr2 != null && bArr2.length > 0) {
            if (dVar.t == null) {
                dVar.t = new ArrayList<>();
            }
            dVar.t.add(new e.f.a.a.d.a.c((byte) 1, "userExtraByteData", crashDetailBean.c0));
            e.f.a.a.a.k.c.b("attach extraData", new Object[0]);
        }
        HashMap map3 = new HashMap();
        dVar.u = map3;
        map3.put("A9", "" + crashDetailBean.J);
        dVar.u.put("A11", "" + crashDetailBean.K);
        dVar.u.put("A10", "" + crashDetailBean.L);
        dVar.u.put("A23", "" + crashDetailBean.f276i);
        dVar.u.put("A7", "" + bVar.j);
        dVar.u.put("A6", "" + bVar.j());
        dVar.u.put("A5", "" + bVar.k());
        dVar.u.put("A22", "" + bVar.l());
        dVar.u.put("A2", "" + crashDetailBean.N);
        dVar.u.put("A1", "" + crashDetailBean.M);
        dVar.u.put("A24", "" + bVar.l);
        dVar.u.put("A17", "" + crashDetailBean.O);
        dVar.u.put("A25", "" + bVar.l());
        dVar.u.put("A15", "" + bVar.i());
        dVar.u.put("A13", "" + bVar.n());
        dVar.u.put("A34", "" + crashDetailBean.H);
        if (bVar.Y != null) {
            dVar.u.put("productIdentify", "" + bVar.Y);
        }
        try {
            dVar.u.put("A26", "" + URLEncoder.encode(crashDetailBean.P, "utf-8"));
        } catch (UnsupportedEncodingException e8) {
            e8.printStackTrace();
        }
        if (crashDetailBean.b == 1) {
            dVar.u.put("A27", "" + crashDetailBean.S);
            dVar.u.put("A28", "" + crashDetailBean.R);
            dVar.u.put("A29", "" + crashDetailBean.o);
        }
        dVar.u.put("A30", "" + crashDetailBean.T);
        dVar.u.put("A18", "" + crashDetailBean.U);
        Map<String, String> map4 = dVar.u;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("");
        sb2.append(!crashDetailBean.V);
        map4.put("A36", sb2.toString());
        dVar.u.put("F02", "" + bVar.S);
        dVar.u.put("F03", "" + bVar.T);
        dVar.u.put("F04", "" + bVar.t());
        dVar.u.put("F05", "" + bVar.U);
        dVar.u.put("F06", "" + bVar.R);
        dVar.u.put("F08", "" + bVar.W);
        dVar.u.put("F09", "" + bVar.X);
        dVar.u.put("F10", "" + bVar.V);
        if (crashDetailBean.Y >= 0) {
            dVar.u.put("C01", "" + crashDetailBean.Y);
        }
        if (crashDetailBean.Z >= 0) {
            dVar.u.put("C02", "" + crashDetailBean.Z);
        }
        Map<String, String> map5 = crashDetailBean.a0;
        if (map5 != null && map5.size() > 0) {
            for (Map.Entry<String, String> entry2 : crashDetailBean.a0.entrySet()) {
                dVar.u.put("C03_" + entry2.getKey(), entry2.getValue());
            }
        }
        Map<String, String> map6 = crashDetailBean.b0;
        if (map6 != null && map6.size() > 0) {
            for (Map.Entry<String, String> entry3 : crashDetailBean.b0.entrySet()) {
                dVar.u.put("C04_" + entry3.getKey(), entry3.getValue());
            }
        }
        dVar.v = null;
        Map<String, String> map7 = crashDetailBean.W;
        if (map7 != null && map7.size() > 0) {
            Map<String, String> map8 = crashDetailBean.W;
            dVar.v = map8;
            e.f.a.a.a.k.c.f("setted message size %d", Integer.valueOf(map8.size()));
        }
        Object[] objArr2 = new Object[12];
        objArr2[0] = crashDetailBean.r;
        objArr2[1] = crashDetailBean.f273d;
        objArr2[2] = bVar.t();
        objArr2[3] = Long.valueOf((crashDetailBean.v - crashDetailBean.U) / 1000);
        objArr2[4] = Boolean.valueOf(crashDetailBean.o);
        objArr2[5] = Boolean.valueOf(crashDetailBean.V);
        objArr2[6] = Boolean.valueOf(crashDetailBean.m);
        objArr2[7] = Boolean.valueOf(crashDetailBean.b == 1);
        objArr2[8] = Integer.valueOf(crashDetailBean.x);
        objArr2[9] = crashDetailBean.w;
        objArr2[10] = Boolean.valueOf(crashDetailBean.f274f);
        objArr2[11] = Integer.valueOf(dVar.u.size());
        e.f.a.a.a.k.c.b("%s rid:%s sess:%s ls:%ds isR:%b isF:%b isM:%b isN:%b mc:%d ,%s ,isUp:%b ,vm:%d", objArr2);
        return dVar;
    }

    public static e.f.a.a.d.a.e h(Context context, List<CrashDetailBean> list, e.f.a.a.a.h.b bVar) {
        if (context == null || list == null || list.size() == 0 || bVar == null) {
            e.f.a.a.a.k.c.j("enEXPPkg args == null!", new Object[0]);
            return null;
        }
        e.f.a.a.d.a.e eVar = new e.f.a.a.d.a.e();
        eVar.a = new ArrayList<>();
        Iterator<CrashDetailBean> it = list.iterator();
        while (it.hasNext()) {
            eVar.a.add(g(context, it.next(), bVar));
        }
        return eVar;
    }

    public static e.f.a.a.d.a.c i(String str, Context context, String str2) {
        FileInputStream fileInputStream;
        if (str2 == null || context == null) {
            e.f.a.a.a.k.c.j("rqdp{  createZipAttachment sourcePath == null || context == null ,pls check}", new Object[0]);
            return null;
        }
        e.f.a.a.a.k.c.b("zip %s", str2);
        File file = new File(str2);
        File file2 = new File(context.getCacheDir(), str);
        if (!f.N(file, file2, BaseConnection.CONNECT_TIMEOUT)) {
            e.f.a.a.a.k.c.j("zip fail!", new Object[0]);
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            fileInputStream = new FileInputStream(file2);
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
        }
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int i2 = fileInputStream.read(bArr);
                if (i2 <= 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, i2);
                byteArrayOutputStream.flush();
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            e.f.a.a.a.k.c.b("read bytes :%d", Integer.valueOf(byteArray.length));
            e.f.a.a.d.a.c cVar = new e.f.a.a.d.a.c((byte) 2, file2.getName(), byteArray);
            try {
                fileInputStream.close();
            } catch (IOException e2) {
                if (!e.f.a.a.a.k.c.k(e2)) {
                    e2.printStackTrace();
                }
            }
            if (file2.exists()) {
                e.f.a.a.a.k.c.b("del tmp", new Object[0]);
                file2.delete();
            }
            return cVar;
        } catch (Throwable th2) {
            th = th2;
            try {
                if (!e.f.a.a.a.k.c.k(th)) {
                    th.printStackTrace();
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e3) {
                        if (!e.f.a.a.a.k.c.k(e3)) {
                            e3.printStackTrace();
                        }
                    }
                }
                if (file2.exists()) {
                    e.f.a.a.a.k.c.b("del tmp", new Object[0]);
                    file2.delete();
                }
                return null;
            } catch (Throwable th3) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e4) {
                        if (!e.f.a.a.a.k.c.k(e4)) {
                            e4.printStackTrace();
                        }
                    }
                }
                if (file2.exists()) {
                    e.f.a.a.a.k.c.b("del tmp", new Object[0]);
                    file2.delete();
                }
                throw th3;
            }
        }
    }

    public static void t(String str, String str2, String str3, String str4, String str5, CrashDetailBean crashDetailBean) {
        String str6;
        e.f.a.a.a.h.b bVarM = e.f.a.a.a.h.b.m();
        if (bVarM == null) {
            return;
        }
        e.f.a.a.a.k.c.c("#++++++++++Record By FireEye++++++++++#", new Object[0]);
        e.f.a.a.a.k.c.c("# You can use FireEye(http:\\\\fireeye.qq.com) to get more Crash Detail!", new Object[0]);
        e.f.a.a.a.k.c.c("# PKG NAME: %s", bVarM.f1345e);
        e.f.a.a.a.k.c.c("# APP VER: %s", bVarM.d());
        e.f.a.a.a.k.c.c("# SDK VER: %s", bVarM.f1349i);
        e.f.a.a.a.k.c.c("# LAUNCH TIME: %s", f.u(new Date(e.f.a.a.a.h.b.m().c)));
        e.f.a.a.a.k.c.c("# CRASH TYPE: %s", str);
        e.f.a.a.a.k.c.c("# CRASH TIME: %s", str2);
        e.f.a.a.a.k.c.c("# CRASH PROCESS: %s", str3);
        e.f.a.a.a.k.c.c("# CRASH THREAD: %s", str4);
        if (crashDetailBean != null) {
            e.f.a.a.a.k.c.c("# REPORT ID: %s", crashDetailBean.f273d);
            Object[] objArr = new Object[2];
            objArr[0] = bVarM.k;
            objArr[1] = bVarM.n().booleanValue() ? "ROOTED" : "UNROOT";
            e.f.a.a.a.k.c.c("# CRASH DEVICE: %s %s", objArr);
            e.f.a.a.a.k.c.c("# RUNTIME AVAIL RAM:%d ROM:%d SD:%d", Long.valueOf(crashDetailBean.J), Long.valueOf(crashDetailBean.K), Long.valueOf(crashDetailBean.L));
            e.f.a.a.a.k.c.c("# RUNTIME TOTAL RAM:%d ROM:%d SD:%d", Long.valueOf(crashDetailBean.M), Long.valueOf(crashDetailBean.N), Long.valueOf(crashDetailBean.O));
            if (f.q(crashDetailBean.S)) {
                int i2 = crashDetailBean.b;
                if (i2 == 3 || i2 == 9) {
                    Object[] objArr2 = new Object[1];
                    if (crashDetailBean.X == null) {
                        str6 = "null";
                    } else {
                        str6 = "" + crashDetailBean.X.get("FIREEYE_CR_01");
                    }
                    objArr2[0] = str6;
                    e.f.a.a.a.k.c.c("# EXCEPTION ANR MESSAGE:\n %s", objArr2);
                }
            } else {
                e.f.a.a.a.k.c.c("# EXCEPTION FIRED BY %s %s", crashDetailBean.S, crashDetailBean.R);
            }
        }
        if (!f.q(str5)) {
            e.f.a.a.a.k.c.c("# CRASH STACK: ", new Object[0]);
            e.f.a.a.a.k.c.c(str5, new Object[0]);
        }
        e.f.a.a.a.k.c.c("#++++++++++++++++++++++++++++++++++++++++++#", new Object[0]);
    }

    public void A(CrashDetailBean crashDetailBean, long j, boolean z) {
        if (c.s) {
            e.f.a.a.a.k.c.f("try to upload right now", new Object[0]);
            ArrayList arrayList = new ArrayList();
            arrayList.add(crashDetailBean);
            e(arrayList, j, z, crashDetailBean.b == 7, z);
        }
    }

    public void B(boolean z, List<CrashDetailBean> list) {
        if (list != null && list.size() > 0) {
            e.f.a.a.a.k.c.b("up finish update state %b", Boolean.valueOf(z));
            for (CrashDetailBean crashDetailBean : list) {
                e.f.a.a.a.k.c.b("pre uid:%s uc:%d re:%b me:%b", crashDetailBean.f273d, Integer.valueOf(crashDetailBean.p), Boolean.valueOf(crashDetailBean.f274f), Boolean.valueOf(crashDetailBean.m));
                int i2 = crashDetailBean.p + 1;
                crashDetailBean.p = i2;
                crashDetailBean.f274f = z;
                e.f.a.a.a.k.c.b("set uid:%s uc:%d re:%b me:%b", crashDetailBean.f273d, Integer.valueOf(i2), Boolean.valueOf(crashDetailBean.f274f), Boolean.valueOf(crashDetailBean.m));
            }
            Iterator<CrashDetailBean> it = list.iterator();
            while (it.hasNext()) {
                c.c().h(it.next());
            }
            e.f.a.a.a.k.c.b("update state size %d", Integer.valueOf(list.size()));
        }
        if (z) {
            return;
        }
        e.f.a.a.a.k.c.i("[crash] upload fail.", new Object[0]);
    }

    public boolean a(CrashDetailBean crashDetailBean) {
        if (!m(crashDetailBean)) {
            return false;
        }
        int i2 = crashDetailBean.b;
        return !e.f.a.a.a.c.b && (!((i2 == 3) || (i2 == 0 || i2 == 1)) || c.k);
    }

    public final boolean b(CrashDetailBean crashDetailBean, List<e.f.a.a.b.a> list, List<CrashDetailBean> list2) {
        List<CrashDetailBean> listO;
        boolean z = false;
        for (e.f.a.a.b.a aVar : list) {
            if (aVar.a != crashDetailBean.a && !aVar.f1373f && crashDetailBean.y.equals(aVar.f1372d) && (listO = o(Collections.singletonList(aVar))) != null && listO.size() > 0) {
                for (CrashDetailBean crashDetailBean2 : listO) {
                    if (m(crashDetailBean2)) {
                        if (crashDetailBean2.m) {
                            z = true;
                        }
                        list2.add(crashDetailBean2);
                    }
                }
            }
        }
        return z;
    }

    public e.f.a.a.b.a c(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            e.f.a.a.b.a aVar = new e.f.a.a.b.a();
            aVar.a = cursor.getLong(cursor.getColumnIndex(DbOpenHelper.ID));
            aVar.b = cursor.getLong(cursor.getColumnIndex(DbOpenHelper.TIME));
            aVar.f1372d = cursor.getString(cursor.getColumnIndex(DbOpenHelper.SHA1));
            aVar.f1373f = cursor.getInt(cursor.getColumnIndex(DbOpenHelper.ISUPLOAD)) == 1;
            aVar.f1374h = cursor.getInt(cursor.getColumnIndex(DbOpenHelper.ISMERGE)) == 1;
            aVar.f1375i = cursor.getInt(cursor.getColumnIndex(DbOpenHelper.UPLOAD_COUNT));
            return aVar;
        } catch (Throwable th) {
            if (!e.f.a.a.a.k.c.k(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public CrashDetailBean d(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex(DbOpenHelper.DATAS));
            if (blob == null) {
                return null;
            }
            long j = cursor.getLong(cursor.getColumnIndex(DbOpenHelper.ID));
            CrashDetailBean crashDetailBean = (CrashDetailBean) f.H(blob, CrashDetailBean.CREATOR);
            if (crashDetailBean != null) {
                crashDetailBean.a = j;
            }
            return crashDetailBean;
        } catch (Throwable th) {
            if (!e.f.a.a.a.k.c.k(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public void e(List<CrashDetailBean> list, long j, boolean z, boolean z2, boolean z3) {
        e.f.a.a.a.j.d dVar;
        if (e.f.a.a.a.h.b.e(this.a).f1348h && (dVar = this.b) != null) {
            if (z3 || dVar.e(c.f1380i)) {
                StrategyBean strategyBeanH = this.f1377d.h();
                if (!strategyBeanH.f269d) {
                    e.f.a.a.a.k.c.j("remote report is disable!", new Object[0]);
                    e.f.a.a.a.k.c.i("[crash] server closed fireeye in this app. please check your appid if is correct, and re-install it", new Object[0]);
                    return;
                }
                if (list == null || list.size() == 0) {
                    return;
                }
                try {
                    String str = strategyBeanH.r;
                    String str2 = StrategyBean.A;
                    e.f.a.a.d.a.e eVarH = h(this.a, list, e.f.a.a.a.h.b.m());
                    if (eVarH == null) {
                        e.f.a.a.a.k.c.j("create eupPkg fail!", new Object[0]);
                        return;
                    }
                    byte[] bArrC = e.f.a.a.a.j.a.c(eVarH);
                    if (bArrC == null) {
                        e.f.a.a.a.k.c.j("send encode fail!", new Object[0]);
                        return;
                    }
                    e.f.a.a.d.a.f fVarB = e.f.a.a.a.j.a.b(this.a, 830, bArrC);
                    if (fVarB == null) {
                        e.f.a.a.a.k.c.j("request package is null.", new Object[0]);
                        return;
                    }
                    a aVar = new a(list);
                    if (z) {
                        this.b.o(f1376g, fVarB, str, str2, aVar, j, z2);
                    } else {
                        this.b.m(f1376g, fVarB, str, str2, aVar, false);
                    }
                } catch (Throwable th) {
                    e.f.a.a.a.k.c.c("req cr error %s", th.toString());
                    if (e.f.a.a.a.k.c.d(th)) {
                        return;
                    }
                    th.printStackTrace();
                }
            }
        }
    }

    public ContentValues f(CrashDetailBean crashDetailBean) {
        if (crashDetailBean == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            long j = crashDetailBean.a;
            if (j > 0) {
                contentValues.put(DbOpenHelper.ID, Long.valueOf(j));
            }
            contentValues.put(DbOpenHelper.TIME, Long.valueOf(crashDetailBean.v));
            contentValues.put(DbOpenHelper.SHA1, crashDetailBean.y);
            int i2 = 1;
            contentValues.put(DbOpenHelper.ISUPLOAD, Integer.valueOf(crashDetailBean.f274f ? 1 : 0));
            if (!crashDetailBean.m) {
                i2 = 0;
            }
            contentValues.put(DbOpenHelper.ISMERGE, Integer.valueOf(i2));
            contentValues.put(DbOpenHelper.UPLOAD_COUNT, Integer.valueOf(crashDetailBean.p));
            contentValues.put(DbOpenHelper.DATAS, f.t(crashDetailBean));
            return contentValues;
        } catch (Throwable th) {
            if (!e.f.a.a.a.k.c.k(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public boolean j(CrashDetailBean crashDetailBean) {
        return k(crashDetailBean, -123456789);
    }

    public boolean k(CrashDetailBean crashDetailBean, int i2) {
        if (crashDetailBean == null) {
            return true;
        }
        String str = c.u;
        if (str != null && !str.isEmpty()) {
            e.f.a.a.a.k.c.b("Crash filter for crash stack is: %s", c.u);
            if (crashDetailBean.u.contains(c.u)) {
                e.f.a.a.a.k.c.j("This crash contains the filter string set. It will not be record and upload.", new Object[0]);
                return true;
            }
        }
        String str2 = c.v;
        if (str2 != null && !str2.isEmpty()) {
            e.f.a.a.a.k.c.b("Crash regular filter for crash stack is: %s", c.v);
            if (Pattern.compile(c.v).matcher(crashDetailBean.u).find()) {
                e.f.a.a.a.k.c.j("This crash matches the regular filter string set. It will not be record and upload.", new Object[0]);
                return true;
            }
        }
        if (crashDetailBean.a0 == null) {
            crashDetailBean.a0 = new HashMap(1);
        }
        String str3 = e.f.a.a.c.c.b.n + "_" + Process.myPid();
        crashDetailBean.a0.put("fire_eye_info", str3);
        e.f.a.a.a.k.c.f("fireEyeInfo = %s", str3);
        if (crashDetailBean.b != 2) {
            e.f.a.a.a.g.c cVar = new e.f.a.a.a.g.c();
            cVar.b = 1;
            cVar.c = crashDetailBean.H;
            cVar.f1340d = crashDetailBean.I;
            cVar.f1341e = crashDetailBean.v;
            this.c.y(1);
            this.c.C(cVar);
            e.f.a.a.a.k.c.i("[crash] a crash occur, handling...", new Object[0]);
        } else {
            e.f.a.a.a.k.c.i("[crash] a caught exception occur, handling...", new Object[0]);
        }
        List<e.f.a.a.b.a> listN = n();
        ArrayList arrayList = null;
        if (listN != null && listN.size() > 0) {
            arrayList = new ArrayList(10);
            arrayList.addAll(s(listN));
            listN.removeAll(arrayList);
            if (listN.size() > 20) {
                w(5);
            }
            if (z(crashDetailBean, listN, arrayList)) {
                return true;
            }
        }
        x(crashDetailBean);
        if (arrayList != null && !arrayList.isEmpty()) {
            u(arrayList);
        }
        e.f.a.a.a.k.c.i("[crash] save crash success", new Object[0]);
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x023b A[Catch: all -> 0x02d6, TryCatch #2 {all -> 0x02d6, blocks: (B:11:0x0012, B:12:0x0015, B:40:0x00a7, B:44:0x00ae, B:46:0x00bf, B:53:0x00d6, B:67:0x0115, B:73:0x0132, B:75:0x0138, B:76:0x014b, B:78:0x0151, B:81:0x0164, B:83:0x0172, B:84:0x0185, B:86:0x0191, B:88:0x019d, B:90:0x01d9, B:89:0x01c2, B:91:0x01f3, B:93:0x01fe, B:108:0x0243, B:110:0x0247, B:112:0x024a, B:113:0x0264, B:114:0x0272, B:116:0x0276, B:118:0x02a8, B:102:0x0223, B:104:0x0237, B:105:0x023b, B:119:0x02b0, B:62:0x0101, B:64:0x010f, B:50:0x00cd, B:52:0x00d3, B:68:0x0120, B:121:0x02c3, B:15:0x001d, B:19:0x002c, B:23:0x003a, B:27:0x0048, B:30:0x0054, B:32:0x006a, B:35:0x0075, B:36:0x0089, B:39:0x0094, B:47:0x00c6), top: B:132:0x0012, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0247 A[Catch: all -> 0x02d6, TryCatch #2 {all -> 0x02d6, blocks: (B:11:0x0012, B:12:0x0015, B:40:0x00a7, B:44:0x00ae, B:46:0x00bf, B:53:0x00d6, B:67:0x0115, B:73:0x0132, B:75:0x0138, B:76:0x014b, B:78:0x0151, B:81:0x0164, B:83:0x0172, B:84:0x0185, B:86:0x0191, B:88:0x019d, B:90:0x01d9, B:89:0x01c2, B:91:0x01f3, B:93:0x01fe, B:108:0x0243, B:110:0x0247, B:112:0x024a, B:113:0x0264, B:114:0x0272, B:116:0x0276, B:118:0x02a8, B:102:0x0223, B:104:0x0237, B:105:0x023b, B:119:0x02b0, B:62:0x0101, B:64:0x010f, B:50:0x00cd, B:52:0x00d3, B:68:0x0120, B:121:0x02c3, B:15:0x001d, B:19:0x002c, B:23:0x003a, B:27:0x0048, B:30:0x0054, B:32:0x006a, B:35:0x0075, B:36:0x0089, B:39:0x0094, B:47:0x00c6), top: B:132:0x0012, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0276 A[Catch: all -> 0x02d6, TryCatch #2 {all -> 0x02d6, blocks: (B:11:0x0012, B:12:0x0015, B:40:0x00a7, B:44:0x00ae, B:46:0x00bf, B:53:0x00d6, B:67:0x0115, B:73:0x0132, B:75:0x0138, B:76:0x014b, B:78:0x0151, B:81:0x0164, B:83:0x0172, B:84:0x0185, B:86:0x0191, B:88:0x019d, B:90:0x01d9, B:89:0x01c2, B:91:0x01f3, B:93:0x01fe, B:108:0x0243, B:110:0x0247, B:112:0x024a, B:113:0x0264, B:114:0x0272, B:116:0x0276, B:118:0x02a8, B:102:0x0223, B:104:0x0237, B:105:0x023b, B:119:0x02b0, B:62:0x0101, B:64:0x010f, B:50:0x00cd, B:52:0x00d3, B:68:0x0120, B:121:0x02c3, B:15:0x001d, B:19:0x002c, B:23:0x003a, B:27:0x0048, B:30:0x0054, B:32:0x006a, B:35:0x0075, B:36:0x0089, B:39:0x0094, B:47:0x00c6), top: B:132:0x0012, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:145:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0151 A[Catch: all -> 0x02d6, TryCatch #2 {all -> 0x02d6, blocks: (B:11:0x0012, B:12:0x0015, B:40:0x00a7, B:44:0x00ae, B:46:0x00bf, B:53:0x00d6, B:67:0x0115, B:73:0x0132, B:75:0x0138, B:76:0x014b, B:78:0x0151, B:81:0x0164, B:83:0x0172, B:84:0x0185, B:86:0x0191, B:88:0x019d, B:90:0x01d9, B:89:0x01c2, B:91:0x01f3, B:93:0x01fe, B:108:0x0243, B:110:0x0247, B:112:0x024a, B:113:0x0264, B:114:0x0272, B:116:0x0276, B:118:0x02a8, B:102:0x0223, B:104:0x0237, B:105:0x023b, B:119:0x02b0, B:62:0x0101, B:64:0x010f, B:50:0x00cd, B:52:0x00d3, B:68:0x0120, B:121:0x02c3, B:15:0x001d, B:19:0x002c, B:23:0x003a, B:27:0x0048, B:30:0x0054, B:32:0x006a, B:35:0x0075, B:36:0x0089, B:39:0x0094, B:47:0x00c6), top: B:132:0x0012, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01fe A[Catch: all -> 0x02d6, TRY_LEAVE, TryCatch #2 {all -> 0x02d6, blocks: (B:11:0x0012, B:12:0x0015, B:40:0x00a7, B:44:0x00ae, B:46:0x00bf, B:53:0x00d6, B:67:0x0115, B:73:0x0132, B:75:0x0138, B:76:0x014b, B:78:0x0151, B:81:0x0164, B:83:0x0172, B:84:0x0185, B:86:0x0191, B:88:0x019d, B:90:0x01d9, B:89:0x01c2, B:91:0x01f3, B:93:0x01fe, B:108:0x0243, B:110:0x0247, B:112:0x024a, B:113:0x0264, B:114:0x0272, B:116:0x0276, B:118:0x02a8, B:102:0x0223, B:104:0x0237, B:105:0x023b, B:119:0x02b0, B:62:0x0101, B:64:0x010f, B:50:0x00cd, B:52:0x00d3, B:68:0x0120, B:121:0x02c3, B:15:0x001d, B:19:0x002c, B:23:0x003a, B:27:0x0048, B:30:0x0054, B:32:0x006a, B:35:0x0075, B:36:0x0089, B:39:0x0094, B:47:0x00c6), top: B:132:0x0012, inners: #4 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void l(com.tme.fireeye.crash.crashmodule.CrashDetailBean r24) {
        /*
            Method dump skipped, instruction units count: 778
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.f.a.a.b.b.l(com.tme.fireeye.crash.crashmodule.CrashDetailBean):void");
    }

    public final boolean m(CrashDetailBean crashDetailBean) {
        return (crashDetailBean == null || crashDetailBean.b == 9) ? false : true;
    }

    public List<e.f.a.a.b.a> n() {
        Cursor cursorW;
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursorW = e.f.a.a.a.g.b.r().w(DbOpenHelper.TABLE_CRASH, new String[]{DbOpenHelper.ID, DbOpenHelper.TIME, DbOpenHelper.SHA1, DbOpenHelper.ISUPLOAD, DbOpenHelper.ISMERGE, DbOpenHelper.UPLOAD_COUNT}, null, null, null, true);
        } catch (Throwable th) {
            th = th;
        }
        if (cursorW == null) {
            if (cursorW != null) {
                cursorW.close();
            }
            return null;
        }
        try {
            if (cursorW.getCount() < 1) {
                if (cursorW != null) {
                    cursorW.close();
                }
                return arrayList;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(DbOpenHelper.ID);
            sb.append(" in ");
            sb.append("(");
            int i2 = 0;
            while (cursorW.moveToNext()) {
                try {
                    e.f.a.a.b.a aVarC = c(cursorW);
                    if (aVarC != null) {
                        arrayList.add(aVarC);
                    } else {
                        try {
                            sb.append(cursorW.getLong(cursorW.getColumnIndex(DbOpenHelper.ID)));
                            sb.append(",");
                            i2++;
                        } catch (Throwable unused) {
                            e.f.a.a.a.k.c.j("unknown id!", new Object[0]);
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if (sb.toString().contains(",")) {
                sb = new StringBuilder(sb.substring(0, sb.lastIndexOf(",")));
            }
            sb.append(")");
            String string = sb.toString();
            sb.setLength(0);
            if (i2 > 0) {
                e.f.a.a.a.k.c.j("deleted %s illegal data %d", DbOpenHelper.TABLE_CRASH, Integer.valueOf(e.f.a.a.a.g.b.r().i(DbOpenHelper.TABLE_CRASH, string, null, null, true)));
            }
            if (cursorW != null) {
                cursorW.close();
            }
            return arrayList;
        } catch (Throwable th3) {
            th = th3;
        }
        cursor = cursorW;
        try {
            if (!e.f.a.a.a.k.c.k(th)) {
                th.printStackTrace();
            }
            return arrayList;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public List<CrashDetailBean> o(List<e.f.a.a.b.a> list) {
        Cursor cursorW;
        if (list == null || list.size() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(DbOpenHelper.ID);
        sb.append(" in ");
        sb.append("(");
        Iterator<e.f.a.a.b.a> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next().a);
            sb.append(",");
        }
        if (sb.toString().contains(",")) {
            sb = new StringBuilder(sb.substring(0, sb.lastIndexOf(",")));
        }
        sb.append(")");
        String string = sb.toString();
        sb.setLength(0);
        try {
            cursorW = e.f.a.a.a.g.b.r().w(DbOpenHelper.TABLE_CRASH, null, string, null, null, true);
            if (cursorW == null) {
                return null;
            }
            try {
                ArrayList arrayList = new ArrayList();
                sb.append(DbOpenHelper.ID);
                sb.append(" in ");
                sb.append("(");
                int i2 = 0;
                while (cursorW.moveToNext()) {
                    try {
                        CrashDetailBean crashDetailBeanD = d(cursorW);
                        if (crashDetailBeanD != null) {
                            arrayList.add(crashDetailBeanD);
                        } else {
                            try {
                                sb.append(cursorW.getLong(cursorW.getColumnIndex(DbOpenHelper.ID)));
                                sb.append(",");
                                i2++;
                            } catch (Throwable unused) {
                                e.f.a.a.a.k.c.j("unknown id!", new Object[0]);
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        try {
                            if (!e.f.a.a.a.k.c.k(th)) {
                                th.printStackTrace();
                            }
                            if (cursorW != null) {
                                cursorW.close();
                            }
                            return null;
                        } finally {
                            if (cursorW != null) {
                                cursorW.close();
                            }
                        }
                    }
                }
                if (sb.toString().contains(",")) {
                    sb = new StringBuilder(sb.substring(0, sb.lastIndexOf(",")));
                }
                sb.append(")");
                String string2 = sb.toString();
                if (i2 > 0) {
                    e.f.a.a.a.k.c.j("deleted %s illegal data %d", DbOpenHelper.TABLE_CRASH, Integer.valueOf(e.f.a.a.a.g.b.r().i(DbOpenHelper.TABLE_CRASH, string2, null, null, true)));
                }
                if (cursorW != null) {
                    cursorW.close();
                }
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            cursorW = null;
        }
    }

    public List<CrashDetailBean> p() {
        StrategyBean strategyBeanH = e.f.a.a.a.i.a.g().h();
        if (strategyBeanH == null) {
            e.f.a.a.a.k.c.j("have not synced remote!", new Object[0]);
            return null;
        }
        if (!strategyBeanH.f269d) {
            e.f.a.a.a.k.c.j("Crashreport remote closed, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
            e.f.a.a.a.k.c.i("[init] WARNING! Crashreport closed by server, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jO = f.o();
        List<e.f.a.a.b.a> listN = n();
        if (listN != null) {
            e.f.a.a.a.k.c.b("Size of crash list loaded from DB: %s", Integer.valueOf(listN.size()));
        } else {
            e.f.a.a.a.k.c.b("crashUploadList is null", new Object[0]);
        }
        if (listN == null || listN.size() <= 0) {
            return null;
        }
        List<e.f.a.a.b.a> arrayList = new ArrayList<>();
        arrayList.addAll(s(listN));
        listN.removeAll(arrayList);
        Iterator<e.f.a.a.b.a> it = listN.iterator();
        while (it.hasNext()) {
            e.f.a.a.b.a next = it.next();
            long j = next.b;
            if (j < jO - c.n) {
                it.remove();
                arrayList.add(next);
            } else if (next.f1373f) {
                if (j >= jCurrentTimeMillis - 86400000) {
                    it.remove();
                } else if (!next.f1374h) {
                    it.remove();
                    arrayList.add(next);
                }
            } else if (next.f1375i >= 3 && j < jCurrentTimeMillis - 86400000) {
                it.remove();
                arrayList.add(next);
            }
        }
        if (arrayList.size() > 0) {
            u(arrayList);
        }
        List<CrashDetailBean> arrayList2 = new ArrayList<>();
        List<CrashDetailBean> listO = o(listN);
        if (listO != null && listO.size() > 0) {
            String strD = e.f.a.a.a.h.b.m().d();
            Iterator<CrashDetailBean> it2 = listO.iterator();
            while (it2.hasNext()) {
                CrashDetailBean next2 = it2.next();
                if (!strD.equals(next2.f276i)) {
                    it2.remove();
                    arrayList2.add(next2);
                }
            }
        }
        if (arrayList2.size() > 0) {
            v(arrayList2);
        }
        return listO;
    }

    public CrashDetailBean q(List<CrashDetailBean> list, CrashDetailBean crashDetailBean) {
        String[] strArrSplit;
        if (list == null || list.size() == 0) {
            return crashDetailBean;
        }
        CrashDetailBean crashDetailBean2 = null;
        ArrayList arrayList = new ArrayList(10);
        for (CrashDetailBean crashDetailBean3 : list) {
            if (crashDetailBean3.m) {
                arrayList.add(crashDetailBean3);
            }
        }
        if (arrayList.size() > 0) {
            Collections.sort(arrayList);
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                CrashDetailBean crashDetailBean4 = (CrashDetailBean) arrayList.get(i2);
                if (i2 == 0) {
                    crashDetailBean2 = crashDetailBean4;
                } else {
                    String str = crashDetailBean4.w;
                    if (str != null && (strArrSplit = str.split("\n")) != null) {
                        for (String str2 : strArrSplit) {
                            if (!crashDetailBean2.w.contains("" + str2)) {
                                crashDetailBean2.x++;
                                crashDetailBean2.w += str2 + "\n";
                            }
                        }
                    }
                }
            }
        }
        if (crashDetailBean2 == null) {
            crashDetailBean.m = true;
            crashDetailBean.x = 0;
            crashDetailBean.w = "";
            crashDetailBean2 = crashDetailBean;
        }
        for (CrashDetailBean crashDetailBean5 : list) {
            if (!crashDetailBean5.m && !crashDetailBean5.f274f) {
                if (!crashDetailBean2.w.contains("" + crashDetailBean5.v)) {
                    crashDetailBean2.x++;
                    crashDetailBean2.w += crashDetailBean5.v + "\n";
                }
            }
        }
        if (crashDetailBean2.v != crashDetailBean.v) {
            if (!crashDetailBean2.w.contains("" + crashDetailBean.v)) {
                crashDetailBean2.x++;
                crashDetailBean2.w += crashDetailBean.v + "\n";
            }
        }
        return crashDetailBean2;
    }

    public void r(CrashDetailBean crashDetailBean) {
        int i2 = crashDetailBean.b;
        if (i2 == 0 || i2 == 1) {
            if (!c.c().m()) {
                return;
            }
        } else if ((i2 == 3 || i2 == 9) && !c.c().l()) {
            return;
        }
        if (this.f1378e != null) {
            e.f.a.a.a.k.c.b("Calling 'onCrashHandleEnd' of RQD crash listener.", new Object[0]);
            this.f1378e.onCrashHandleEnd(crashDetailBean.b == 1);
        }
    }

    public List<e.f.a.a.b.a> s(List<e.f.a.a.b.a> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (e.f.a.a.b.a aVar : list) {
            if (aVar.f1373f && aVar.b <= jCurrentTimeMillis - 86400000) {
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    public void u(List<e.f.a.a.b.a> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(DbOpenHelper.ID);
        sb.append(" in ");
        sb.append("(");
        Iterator<e.f.a.a.b.a> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next().a);
            sb.append(",");
        }
        StringBuilder sb2 = new StringBuilder(sb.substring(0, sb.lastIndexOf(",")));
        sb2.append(")");
        String string = sb2.toString();
        sb2.setLength(0);
        try {
            e.f.a.a.a.k.c.b("deleted %s data %d", DbOpenHelper.TABLE_CRASH, Integer.valueOf(e.f.a.a.a.g.b.r().i(DbOpenHelper.TABLE_CRASH, string, null, null, true)));
        } catch (Throwable th) {
            if (e.f.a.a.a.k.c.k(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public void v(List<CrashDetailBean> list) {
        if (list != null) {
            try {
                if (list.size() == 0) {
                    return;
                }
                StringBuilder sb = new StringBuilder();
                for (CrashDetailBean crashDetailBean : list) {
                    sb.append(" or ");
                    sb.append(DbOpenHelper.ID);
                    sb.append(" = ");
                    sb.append(crashDetailBean.a);
                }
                String string = sb.toString();
                if (string.length() > 0) {
                    string = string.substring(4);
                }
                sb.setLength(0);
                e.f.a.a.a.k.c.b("deleted %s data %d", DbOpenHelper.TABLE_CRASH, Integer.valueOf(e.f.a.a.a.g.b.r().i(DbOpenHelper.TABLE_CRASH, string, null, null, true)));
            } catch (Throwable th) {
                if (e.f.a.a.a.k.c.k(th)) {
                    return;
                }
                th.printStackTrace();
            }
        }
    }

    public void w(int i2) {
        if (i2 <= 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(DbOpenHelper.ID);
        sb.append(" in ");
        sb.append("(");
        sb.append("SELECT ");
        sb.append(DbOpenHelper.ID);
        sb.append(" FROM ");
        sb.append(DbOpenHelper.TABLE_CRASH);
        sb.append(" order by ");
        sb.append(DbOpenHelper.ID);
        sb.append(" limit ");
        sb.append(i2);
        sb.append(")");
        String string = sb.toString();
        sb.setLength(0);
        try {
            e.f.a.a.a.k.c.b("deleted first record %s data %d", DbOpenHelper.TABLE_CRASH, Integer.valueOf(e.f.a.a.a.g.b.r().i(DbOpenHelper.TABLE_CRASH, string, null, null, true)));
        } catch (Throwable th) {
            if (e.f.a.a.a.k.c.k(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public void x(CrashDetailBean crashDetailBean) {
        if (crashDetailBean == null) {
            return;
        }
        ContentValues contentValuesF = f(crashDetailBean);
        if (contentValuesF != null) {
            long jA = e.f.a.a.a.g.b.r().A(DbOpenHelper.TABLE_CRASH, contentValuesF, null, true);
            if (jA >= 0) {
                e.f.a.a.a.k.c.b("insert %s success!", DbOpenHelper.TABLE_CRASH);
                crashDetailBean.a = jA;
            }
        }
        if (c.p) {
            y(crashDetailBean);
        }
    }

    public final boolean y(CrashDetailBean crashDetailBean) {
        try {
            e.f.a.a.a.k.c.b("save eup logs", new Object[0]);
            e.f.a.a.a.h.b bVarM = e.f.a.a.a.h.b.m();
            String str = String.format(Locale.US, "#--------\npackage:%s\nversion:%s\nsdk:%s\nprocess:%s\ndate:%s\ntype:%s\nmessage:%s\nstack:\n%s\neupID:%s\n", bVarM.c(), bVarM.d(), bVarM.f1349i, crashDetailBean.H, f.u(new Date(crashDetailBean.v)), crashDetailBean.r, crashDetailBean.s, crashDetailBean.u, crashDetailBean.f273d);
            if (c.q == null) {
                throw new IllegalArgumentException("the 'CRASH_STORE_PATH' was not set correctly");
            }
            File file = new File(c.q);
            if (file.isFile()) {
                file = file.getParentFile();
            }
            f.A(file.getAbsolutePath() + "/fireeye_euplog.txt", str, c.r);
            return true;
        } catch (Throwable th) {
            e.f.a.a.a.k.c.j("rqdp{  save error} %s", th.toString());
            if (!e.f.a.a.a.k.c.k(th)) {
                th.printStackTrace();
            }
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001b, code lost:
    
        if (r0.size() >= e.f.a.a.b.c.j) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean z(com.tme.fireeye.crash.crashmodule.CrashDetailBean r8, java.util.List<e.f.a.a.b.a> r9, java.util.List<e.f.a.a.b.a> r10) {
        /*
            r7 = this;
            boolean r0 = r7.a(r8)
            r1 = 0
            if (r0 != 0) goto L8
            return r1
        L8:
            java.util.ArrayList r0 = new java.util.ArrayList
            r2 = 10
            r0.<init>(r2)
            boolean r9 = r7.b(r8, r9, r0)
            if (r9 != 0) goto L1d
            int r9 = r0.size()     // Catch: java.lang.Throwable -> L76
            int r2 = e.f.a.a.b.c.j     // Catch: java.lang.Throwable -> L76
            if (r9 < r2) goto L81
        L1d:
            java.lang.String r9 = "same crash occur too much do merged!"
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L76
            e.f.a.a.a.k.c.f(r9, r2)     // Catch: java.lang.Throwable -> L76
            com.tme.fireeye.crash.crashmodule.CrashDetailBean r9 = r7.q(r0, r8)     // Catch: java.lang.Throwable -> L76
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L76
        L2c:
            boolean r2 = r0.hasNext()     // Catch: java.lang.Throwable -> L76
            if (r2 == 0) goto L4b
            java.lang.Object r2 = r0.next()     // Catch: java.lang.Throwable -> L76
            com.tme.fireeye.crash.crashmodule.CrashDetailBean r2 = (com.tme.fireeye.crash.crashmodule.CrashDetailBean) r2     // Catch: java.lang.Throwable -> L76
            long r2 = r2.a     // Catch: java.lang.Throwable -> L76
            long r4 = r9.a     // Catch: java.lang.Throwable -> L76
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L2c
            e.f.a.a.b.a r4 = new e.f.a.a.b.a     // Catch: java.lang.Throwable -> L76
            r4.<init>()     // Catch: java.lang.Throwable -> L76
            r4.a = r2     // Catch: java.lang.Throwable -> L76
            r10.add(r4)     // Catch: java.lang.Throwable -> L76
            goto L2c
        L4b:
            long r2 = r8.a     // Catch: java.lang.Throwable -> L76
            r4 = -1
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L63
            long r4 = r9.a     // Catch: java.lang.Throwable -> L76
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L63
            e.f.a.a.b.a r0 = new e.f.a.a.b.a     // Catch: java.lang.Throwable -> L76
            r0.<init>()     // Catch: java.lang.Throwable -> L76
            r0.a = r2     // Catch: java.lang.Throwable -> L76
            r10.add(r0)     // Catch: java.lang.Throwable -> L76
        L63:
            r0 = 1
            if (r8 == r9) goto L68
            r8.n = r0     // Catch: java.lang.Throwable -> L76
        L68:
            r7.x(r9)     // Catch: java.lang.Throwable -> L76
            r7.u(r10)     // Catch: java.lang.Throwable -> L76
            java.lang.String r8 = "[crash] save crash success. For this device crash many times, it will not upload crashes immediately"
            java.lang.Object[] r9 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L76
            e.f.a.a.a.k.c.i(r8, r9)     // Catch: java.lang.Throwable -> L76
            return r0
        L76:
            r8 = move-exception
            java.lang.Object[] r9 = new java.lang.Object[r1]
            java.lang.String r10 = "Failed to merge crash."
            e.f.a.a.a.k.c.c(r10, r9)
            e.f.a.a.a.k.c.d(r8)
        L81:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: e.f.a.a.b.b.z(com.tme.fireeye.crash.crashmodule.CrashDetailBean, java.util.List, java.util.List):boolean");
    }
}
