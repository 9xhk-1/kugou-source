package e.f.a.a.a.f;

import android.content.Context;
import android.content.SharedPreferences;
import e.f.a.a.a.k.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static b f1335d;
    public Context a;
    public String b;
    public SharedPreferences c;

    public class a implements Runnable {
        public final /* synthetic */ int a;

        public a(int i2) {
            this.a = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean zF = b.this.f(this.a);
            b.this.c.edit().putBoolean(this.a + "_" + b.this.b, !zF).commit();
        }
    }

    static {
        System.currentTimeMillis();
    }

    public b(Context context) {
        this.a = context;
        new HashMap();
        this.b = e.f.a.a.a.h.b.m().f1346f;
        this.c = context.getSharedPreferences("fireeye_crashrecord", 0);
    }

    public static synchronized b e(Context context) {
        if (f1335d == null) {
            f1335d = new b(context);
        }
        return f1335d;
    }

    public boolean d(int i2) {
        boolean z = true;
        try {
            z = this.c.getBoolean(i2 + "_" + this.b, true);
            e.f.a.a.a.k.a.b().d(new a(i2));
            return z;
        } catch (Exception unused) {
            c.c("canInit error", new Object[0]);
            return z;
        }
    }

    public final synchronized boolean f(int i2) {
        try {
            List<e.f.a.a.a.f.a> listG = g(i2);
            if (listG == null) {
                return false;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (e.f.a.a.a.f.a aVar : listG) {
                String str = aVar.a;
                if (str != null && str.equalsIgnoreCase(this.b) && aVar.f1334d > 0) {
                    arrayList.add(aVar);
                }
                if (aVar.b + 86400000 < jCurrentTimeMillis) {
                    arrayList2.add(aVar);
                }
            }
            Collections.sort(arrayList);
            if (arrayList.size() < 2) {
                listG.removeAll(arrayList2);
                h(i2, listG);
                return false;
            }
            if (arrayList.size() <= 0 || ((e.f.a.a.a.f.a) arrayList.get(arrayList.size() - 1)).b + 86400000 >= jCurrentTimeMillis) {
                return true;
            }
            listG.clear();
            h(i2, listG);
            return false;
        } catch (Exception unused) {
            c.c("isFrequentCrash failed", new Object[0]);
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004b A[Catch: all -> 0x0061, Exception -> 0x0063, PHI: r6
  0x004b: PHI (r6v11 java.io.ObjectInputStream) = (r6v10 java.io.ObjectInputStream), (r6v12 java.io.ObjectInputStream) binds: [B:17:0x0049, B:22:0x0057] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #6 {Exception -> 0x0063, blocks: (B:4:0x0003, B:10:0x0039, B:18:0x004b, B:26:0x005d, B:27:0x0060), top: B:39:0x0003, outer: #0 }] */
    /* JADX WARN: Type inference failed for: r6v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.io.ObjectInputStream] */
    /* JADX WARN: Type inference failed for: r6v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized <T extends java.util.List<?>> T g(int r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            r0 = 0
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            android.content.Context r3 = r5.a     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            java.lang.String r4 = "fireeye_crashrecord"
            java.io.File r3 = r3.getDir(r4, r1)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            r4.<init>()     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            r4.append(r6)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            java.lang.String r6 = ""
            r4.append(r6)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            java.lang.String r6 = r4.toString()     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            r2.<init>(r3, r6)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            boolean r6 = r2.exists()     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            if (r6 != 0) goto L29
            monitor-exit(r5)
            return r0
        L29:
            java.io.ObjectInputStream r6 = new java.io.ObjectInputStream     // Catch: java.lang.Throwable -> L3e java.lang.ClassNotFoundException -> L41 java.io.IOException -> L4f
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L3e java.lang.ClassNotFoundException -> L41 java.io.IOException -> L4f
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L3e java.lang.ClassNotFoundException -> L41 java.io.IOException -> L4f
            r6.<init>(r3)     // Catch: java.lang.Throwable -> L3e java.lang.ClassNotFoundException -> L41 java.io.IOException -> L4f
            java.lang.Object r2 = r6.readObject()     // Catch: java.lang.ClassNotFoundException -> L42 java.io.IOException -> L50 java.lang.Throwable -> L5a
            java.util.List r2 = (java.util.List) r2     // Catch: java.lang.ClassNotFoundException -> L42 java.io.IOException -> L50 java.lang.Throwable -> L5a
            r6.close()     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            monitor-exit(r5)
            return r2
        L3e:
            r2 = move-exception
            r6 = r0
            goto L5b
        L41:
            r6 = r0
        L42:
            java.lang.String r2 = "get object error"
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L5a
            e.f.a.a.a.k.c.f(r2, r3)     // Catch: java.lang.Throwable -> L5a
            if (r6 == 0) goto L6a
        L4b:
            r6.close()     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            goto L6a
        L4f:
            r6 = r0
        L50:
            java.lang.String r2 = "open record file error"
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L5a
            e.f.a.a.a.k.c.f(r2, r3)     // Catch: java.lang.Throwable -> L5a
            if (r6 == 0) goto L6a
            goto L4b
        L5a:
            r2 = move-exception
        L5b:
            if (r6 == 0) goto L60
            r6.close()     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
        L60:
            throw r2     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
        L61:
            r6 = move-exception
            goto L6c
        L63:
            java.lang.String r6 = "readCrashRecord error"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L61
            e.f.a.a.a.k.c.c(r6, r1)     // Catch: java.lang.Throwable -> L61
        L6a:
            monitor-exit(r5)
            return r0
        L6c:
            monitor-exit(r5)
            goto L6f
        L6e:
            throw r6
        L6f:
            goto L6e
        */
        throw new UnsupportedOperationException("Method not decompiled: e.f.a.a.a.f.b.g(int):java.util.List");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x004f A[Catch: all -> 0x0053, Exception -> 0x0055, TRY_ENTER, TryCatch #3 {Exception -> 0x0055, blocks: (B:7:0x0006, B:11:0x0032, B:24:0x004f, B:25:0x0052), top: B:35:0x0006, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized <T extends java.util.List<?>> void h(int r5, T r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            if (r6 != 0) goto L5
            monitor-exit(r4)
            return
        L5:
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            android.content.Context r2 = r4.a     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            java.lang.String r3 = "fireeye_crashrecord"
            java.io.File r2 = r2.getDir(r3, r0)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            r3.<init>()     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            r3.append(r5)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            java.lang.String r5 = ""
            r3.append(r5)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            java.lang.String r5 = r3.toString()     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            r1.<init>(r2, r5)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            r5 = 0
            java.io.ObjectOutputStream r2 = new java.io.ObjectOutputStream     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3c
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3c
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3c
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3c
            r2.writeObject(r6)     // Catch: java.io.IOException -> L36 java.lang.Throwable -> L4c
        L32:
            r2.close()     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            goto L5c
        L36:
            r5 = move-exception
            goto L3f
        L38:
            r6 = move-exception
            r2 = r5
            r5 = r6
            goto L4d
        L3c:
            r6 = move-exception
            r2 = r5
            r5 = r6
        L3f:
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L4c
            java.lang.String r5 = "open record file error"
            java.lang.Object[] r6 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L4c
            e.f.a.a.a.k.c.f(r5, r6)     // Catch: java.lang.Throwable -> L4c
            if (r2 == 0) goto L5c
            goto L32
        L4c:
            r5 = move-exception
        L4d:
            if (r2 == 0) goto L52
            r2.close()     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
        L52:
            throw r5     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
        L53:
            r5 = move-exception
            goto L5e
        L55:
            java.lang.String r5 = "writeCrashRecord error"
            java.lang.Object[] r6 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L53
            e.f.a.a.a.k.c.c(r5, r6)     // Catch: java.lang.Throwable -> L53
        L5c:
            monitor-exit(r4)
            return
        L5e:
            monitor-exit(r4)
            goto L61
        L60:
            throw r5
        L61:
            goto L60
        */
        throw new UnsupportedOperationException("Method not decompiled: e.f.a.a.a.f.b.h(int, java.util.List):void");
    }
}
