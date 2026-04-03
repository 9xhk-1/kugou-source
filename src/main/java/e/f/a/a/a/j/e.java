package e.f.a.a.a.j;

import android.content.Context;
import android.os.Process;
import androidx.core.app.NotificationCompat;
import com.kugou.common.config.BaseConfigManager;
import com.tme.fireeye.crash.comm.strategy.StrategyBean;
import e.f.a.a.a.k.f;
import e.f.a.a.d.a.g;
import e.f.a.a.d.a.i;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public class e implements Runnable {
    public int a;
    public int b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f1362d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f1363f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final byte[] f1364h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final e.f.a.a.a.h.b f1365i;
    public final e.f.a.a.a.i.a j;
    public final b k;
    public final d l;
    public final int m;
    public final c n;
    public final c o;
    public String p;
    public final String q;
    public final Map<String, String> r;
    public int s;
    public long t;
    public long u;
    public boolean v;

    public e(Context context, int i2, int i3, byte[] bArr, String str, String str2, c cVar, boolean z, boolean z2) {
        this(context, i2, i3, bArr, str, str2, cVar, z, 2, 30000, z2, null);
    }

    public static String a(String str) {
        if (f.q(str)) {
            return str;
        }
        try {
            return String.format("%s?aid=%s", str, UUID.randomUUID().toString());
        } catch (Throwable th) {
            e.f.a.a.a.k.c.k(th);
            return str;
        }
    }

    public static boolean h(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            e.f.a.a.a.k.c.j("[Upload] Headers is empty.", new Object[0]);
            return false;
        }
        if (!map.containsKey(NotificationCompat.CATEGORY_STATUS) && !map.containsKey("Status")) {
            e.f.a.a.a.k.c.j("[Upload] Headers does not contain %s", NotificationCompat.CATEGORY_STATUS);
            return false;
        }
        if (!map.containsKey("FireEye-Version") && !map.containsKey("Fireeye-Version")) {
            e.f.a.a.a.k.c.j("[Upload] Headers does not contain %s", "FireEye-Version");
            return false;
        }
        String str = map.containsKey("FireEye-Version") ? map.get("FireEye-Version") : map.get("Fireeye-Version");
        if (str.toLowerCase().contains("fireeye")) {
            e.f.a.a.a.k.c.b("[Upload] FireEye version from headers is: %s", str);
            return true;
        }
        e.f.a.a.a.k.c.j("[Upload] FireEye version is not valid: %s", str);
        return false;
    }

    public void b(long j) {
        this.u += j;
    }

    public void c(String str, long j, String str2) {
        this.s++;
        this.t += j;
    }

    public void d(int i2, String str) {
        e.f.a.a.a.k.c.c("[Upload] Failed to upload(%d): %s", Integer.valueOf(i2), str);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0018  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void e(e.f.a.a.d.a.g r14, boolean r15, int r16, java.lang.String r17, int r18) {
        /*
            r13 = this;
            r0 = r13
            int r1 = r0.f1363f
            r2 = 630(0x276, float:8.83E-43)
            if (r1 == r2) goto L1b
            r2 = 640(0x280, float:8.97E-43)
            if (r1 == r2) goto L18
            r2 = 830(0x33e, float:1.163E-42)
            if (r1 == r2) goto L1b
            r2 = 840(0x348, float:1.177E-42)
            if (r1 == r2) goto L18
            java.lang.String r1 = java.lang.String.valueOf(r1)
            goto L1d
        L18:
            java.lang.String r1 = "userinfo"
            goto L1d
        L1b:
            java.lang.String r1 = "crash"
        L1d:
            r2 = 1
            r3 = 0
            if (r15 == 0) goto L2b
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r3] = r1
            java.lang.String r1 = "[Upload] Success: %s"
            e.f.a.a.a.k.c.f(r1, r2)
            goto L3e
        L2b:
            r4 = 3
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.Integer r5 = java.lang.Integer.valueOf(r16)
            r4[r3] = r5
            r4[r2] = r1
            r1 = 2
            r4[r1] = r17
            java.lang.String r1 = "[Upload] Failed to upload(%d) %s: %s"
            e.f.a.a.a.k.c.c(r1, r4)
        L3e:
            long r1 = r0.t
            long r3 = r0.u
            long r1 = r1 + r3
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L5e
            e.f.a.a.a.j.d r1 = r0.l
            boolean r2 = r0.v
            long r1 = r1.k(r2)
            long r3 = r0.t
            long r1 = r1 + r3
            long r3 = r0.u
            long r1 = r1 + r3
            e.f.a.a.a.j.d r3 = r0.l
            boolean r4 = r0.v
            r3.p(r1, r4)
        L5e:
            e.f.a.a.a.j.c r4 = r0.n
            if (r4 == 0) goto L6f
            int r5 = r0.f1363f
            long r7 = r0.t
            long r9 = r0.u
            r6 = r14
            r11 = r15
            r12 = r17
            r4.onUploadEnd(r5, r6, r7, r9, r11, r12)
        L6f:
            e.f.a.a.a.j.c r4 = r0.o
            if (r4 == 0) goto L80
            int r5 = r0.f1363f
            long r7 = r0.t
            long r9 = r0.u
            r6 = r14
            r11 = r15
            r12 = r17
            r4.onUploadEnd(r5, r6, r7, r9, r11, r12)
        L80:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e.f.a.a.a.j.e.e(e.f.a.a.d.a.g, boolean, int, java.lang.String, int):void");
    }

    public void f() {
        this.l.q(this.m, System.currentTimeMillis());
        c cVar = this.n;
        if (cVar != null) {
            cVar.onUploadStart(this.f1363f);
        }
        c cVar2 = this.o;
        if (cVar2 != null) {
            cVar2.onUploadStart(this.f1363f);
        }
    }

    public boolean g(g gVar, e.f.a.a.a.h.b bVar, e.f.a.a.a.i.a aVar) {
        byte[] bArr;
        if (gVar == null) {
            e.f.a.a.a.k.c.j("resp == null!", new Object[0]);
            return false;
        }
        byte b = gVar.a;
        if (b != 0) {
            e.f.a.a.a.k.c.c("resp result error %d", Byte.valueOf(b));
            return false;
        }
        try {
            if (!f.q(gVar.j) && !e.f.a.a.a.h.b.m().q().equals(gVar.j)) {
                e.f.a.a.a.g.b.r().D(e.f.a.a.a.i.a.f1350f, "device", gVar.j.getBytes("UTF-8"), null, true);
                bVar.O(gVar.j);
            }
        } catch (Throwable th) {
            e.f.a.a.a.k.c.k(th);
        }
        bVar.q = gVar.f1446h;
        int i2 = gVar.b;
        if (i2 == 510) {
            byte[] bArr2 = gVar.f1444d;
            if (bArr2 == null) {
                e.f.a.a.a.k.c.c("[Upload] Strategy data is null. Response cmd: %d", Integer.valueOf(i2));
                return false;
            }
            i iVar = (i) a.a(bArr2, i.class);
            if (iVar == null) {
                e.f.a.a.a.k.c.c("[Upload] Failed to decode strategy from server. Response cmd: %d", Integer.valueOf(gVar.b));
                return false;
            }
            aVar.n(iVar);
        }
        e.f.a.b.a.a aVar2 = e.f.a.b.a.a.f1462f;
        if (aVar2.g() && gVar.b == 511 && (bArr = gVar.f1444d) != null) {
            e.f.a.b.a.k.b.b bVar2 = (e.f.a.b.a.k.b.b) e.f.a.b.a.k.a.a(bArr, e.f.a.b.a.k.b.b.class);
            e.f.a.b.a.c.c(BaseConfigManager.TAG, "[UploadTask] cfg=" + bVar2);
            if (bVar2 != null) {
                aVar2.i(bVar2);
            }
        }
        return true;
    }

    @Override // java.lang.Runnable
    public void run() {
        e.f.a.a.a.i.a aVar;
        int length = 0;
        try {
            this.s = 0;
            this.t = 0L;
            this.u = 0L;
            byte[] bArr = this.f1364h;
            if (e.f.a.a.a.h.c.j(this.f1362d) == null) {
                e(null, false, 0, "network is not available", 0);
                return;
            }
            if (bArr != null && bArr.length != 0) {
                e.f.a.a.a.k.c.b("[Upload] Run upload task with cmd: %d", Integer.valueOf(this.f1363f));
                if (this.f1362d != null && this.f1365i != null && (aVar = this.j) != null && this.k != null) {
                    StrategyBean strategyBeanH = aVar.h();
                    if (strategyBeanH == null) {
                        e(null, false, 0, "illegal local strategy", 0);
                        return;
                    }
                    HashMap map = new HashMap();
                    map.put("tls", "1");
                    map.put("prodId", this.f1365i.c());
                    map.put("bundleId", this.f1365i.f1345e);
                    map.put("appVer", this.f1365i.d());
                    Map<String, String> map2 = this.r;
                    if (map2 != null) {
                        map.putAll(map2);
                    }
                    map.put("cmd", Integer.toString(this.f1363f));
                    map.put("platformId", Byte.toString((byte) 1));
                    map.put("sdkVer", this.f1365i.f1349i);
                    map.put("strategylastUpdateTime", Long.toString(strategyBeanH.o));
                    byte[] bArrM = f.M(bArr, 2);
                    if (bArrM == null) {
                        e(null, false, 0, "failed to zip request body", 0);
                        return;
                    }
                    if (bArrM == null) {
                        e(null, false, 0, "failed to encrypt request body", 0);
                        return;
                    }
                    f();
                    String strA = this.p;
                    int i2 = 0;
                    int i3 = -1;
                    int i4 = 0;
                    while (true) {
                        int i5 = i4 + 1;
                        if (i4 >= this.a) {
                            e(null, false, i2, "failed after many attempts", 0);
                            return;
                        }
                        if (i5 > 1) {
                            e.f.a.a.a.k.c.j("[Upload] Failed to upload last time, wait and try(%d) again.", Integer.valueOf(i5));
                            f.C(this.b);
                            if (i5 == this.a) {
                                e.f.a.a.a.k.c.j("[Upload] Use the back-up url at the last time: %s", this.q);
                                strA = this.q;
                            }
                        }
                        e.f.a.a.a.k.c.b("[Upload] Send %d bytes", Integer.valueOf(bArrM.length));
                        strA = a(strA);
                        e.f.a.a.a.k.c.b("[Upload] Upload to %s with cmd %d (pid=%d | tid=%d).", strA, Integer.valueOf(this.f1363f), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                        byte[] bArrG = this.k.g(strA, bArrM, this, map);
                        if (bArrG == null) {
                            d(1, "Failed to upload for no response!");
                        } else {
                            Map<String, String> map3 = this.k.b;
                            if (h(map3)) {
                                try {
                                    i3 = map3.containsKey(NotificationCompat.CATEGORY_STATUS) ? Integer.parseInt(map3.get(NotificationCompat.CATEGORY_STATUS)) : Integer.parseInt(map3.get("Status"));
                                    e.f.a.a.a.k.c.b("[Upload] Status from server is %d (pid=%d | tid=%d).", Integer.valueOf(i3), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                                    if (i3 != 0) {
                                        e(null, false, 1, "status of server is " + i3, i3);
                                        return;
                                    }
                                    e.f.a.a.a.k.c.b("[Upload] Received %d bytes", Integer.valueOf(bArrG.length));
                                    if (bArrG.length == 0) {
                                        for (Map.Entry<String, String> entry : map3.entrySet()) {
                                            e.f.a.a.a.k.c.b("[Upload] HTTP headers from server: key = %s, value = %s", entry.getKey(), entry.getValue());
                                        }
                                        e(null, false, 1, "response data from server is empty", 0);
                                        return;
                                    }
                                    if (bArrG == null) {
                                        e(null, false, 1, "failed to decrypt response from server", 0);
                                        return;
                                    }
                                    byte[] bArrI = f.I(bArrG, 2);
                                    if (bArrI != null) {
                                        bArrG = bArrI;
                                    }
                                    g gVar = (g) a.a(bArrG, g.class);
                                    if (gVar == null) {
                                        e(null, false, 1, "failed to decode response package", 0);
                                        return;
                                    }
                                    Object[] objArr = new Object[2];
                                    objArr[0] = Integer.valueOf(gVar.b);
                                    byte[] bArr2 = gVar.f1444d;
                                    if (bArr2 != null) {
                                        length = bArr2.length;
                                    }
                                    objArr[1] = Integer.valueOf(length);
                                    e.f.a.a.a.k.c.b("[Upload] Response cmd is: %d, length of sBuffer is: %d", objArr);
                                    if (g(gVar, this.f1365i, this.j)) {
                                        e(gVar, true, 2, "successfully uploaded", 0);
                                        return;
                                    } else {
                                        e(gVar, false, 2, "failed to process response package", 0);
                                        return;
                                    }
                                } catch (Throwable unused) {
                                    d(1, "[Upload] Failed to upload for format of status header is invalid: " + Integer.toString(i3));
                                    i4 = i5;
                                    i2 = 1;
                                }
                            } else {
                                e.f.a.a.a.k.c.b("[Upload] Headers from server is not valid, just try again (pid=%d | tid=%d).", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                                d(1, "[Upload] Failed to upload for no status header.");
                                if (map3 != null) {
                                    for (Map.Entry<String, String> entry2 : map3.entrySet()) {
                                        e.f.a.a.a.k.c.b(String.format("[key]: %s, [value]: %s", entry2.getKey(), entry2.getValue()), new Object[0]);
                                    }
                                }
                                e.f.a.a.a.k.c.b("[Upload] Failed to upload for no status header.", new Object[0]);
                            }
                        }
                        i4 = i5;
                        i2 = 1;
                    }
                }
                e(null, false, 0, "illegal access error", 0);
                return;
            }
            e(null, false, 0, "request package is empty!", 0);
        } catch (Throwable th) {
            if (e.f.a.a.a.k.c.k(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public e(Context context, int i2, int i3, byte[] bArr, String str, String str2, c cVar, boolean z, int i4, int i5, boolean z2, Map<String, String> map) {
        this.a = 2;
        this.b = 30000;
        this.p = null;
        this.s = 0;
        this.t = 0L;
        this.u = 0L;
        this.v = false;
        this.f1362d = context;
        this.f1365i = e.f.a.a.a.h.b.e(context);
        this.f1364h = bArr;
        this.j = e.f.a.a.a.i.a.g();
        this.k = b.c(context);
        d dVarH = d.h();
        this.l = dVarH;
        this.m = i2;
        this.p = str;
        this.q = str2;
        this.n = cVar;
        this.o = dVarH.c;
        this.f1363f = i3;
        if (i4 > 0) {
            this.a = i4;
        }
        if (i5 > 0) {
            this.b = i5;
        }
        this.v = z2;
        this.r = map;
    }
}
