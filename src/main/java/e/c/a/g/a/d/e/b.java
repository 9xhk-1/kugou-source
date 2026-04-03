package e.c.a.g.a.d.e;

import android.os.Looper;
import e.c.a.g.a.s.j0;
import java.util.Arrays;
import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static final String a = "b";

    public static Collection<Thread> a() {
        try {
            ThreadGroup parent = Looper.getMainLooper().getThread().getThreadGroup().getParent();
            int iActiveCount = parent.activeCount();
            Thread[] threadArr = new Thread[iActiveCount];
            int iEnumerate = parent.enumerate(threadArr);
            if (iEnumerate == iActiveCount) {
                return Arrays.asList(threadArr);
            }
            Thread[] threadArr2 = new Thread[iEnumerate];
            System.arraycopy(threadArr, 0, threadArr2, 0, iEnumerate);
            return Arrays.asList(threadArr2);
        } catch (Throwable unused) {
            return Thread.getAllStackTraces().keySet();
        }
    }

    public static boolean b() {
        try {
            for (Thread thread : a()) {
                if (thread != null && "FinalizerWatchdogDaemon".equals(thread.getName())) {
                    return true;
                }
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void c() {
        j0.b().a(new Runnable() { // from class: e.c.a.g.a.d.e.a
            @Override // java.lang.Runnable
            public final void run() {
                b.d();
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ void d() {
        /*
            java.lang.String r0 = e.c.a.g.a.d.e.b.a
            java.lang.String r1 = "kill start"
            e.c.a.g.a.s.g0.c(r0, r1)
            r0 = 0
            r1 = 0
        L9:
            boolean r2 = b()
            java.lang.String r3 = "Killing thread `FinalizerWatchdogDaemon` failed"
            if (r2 == 0) goto La7
            r2 = 10
            if (r1 >= r2) goto La7
            java.lang.String r2 = "java.lang.Daemons$FinalizerWatchdogDaemon"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch: java.lang.Throwable -> L8e
            java.lang.String r4 = "INSTANCE"
            java.lang.reflect.Field r4 = r2.getDeclaredField(r4)     // Catch: java.lang.Throwable -> L8e
            r5 = 1
            r4.setAccessible(r5)     // Catch: java.lang.Throwable -> L8e
            r6 = 0
            java.lang.Object r4 = r4.get(r6)     // Catch: java.lang.Throwable -> L8e
            java.lang.Class r7 = r2.getSuperclass()     // Catch: java.lang.Throwable -> L3b
            java.lang.String r8 = "thread"
            java.lang.reflect.Field r7 = r7.getDeclaredField(r8)     // Catch: java.lang.Throwable -> L3b
            r7.setAccessible(r5)     // Catch: java.lang.Throwable -> L3b
            r7.set(r4, r6)     // Catch: java.lang.Throwable -> L3b
            goto L6a
        L3b:
            r6 = move-exception
            java.lang.String r7 = e.c.a.g.a.d.e.b.a     // Catch: java.lang.Throwable -> L8e
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8e
            r8.<init>()     // Catch: java.lang.Throwable -> L8e
            java.lang.String r9 = "Clearing reference of thread `FinalizerWatchdogDaemon` failed"
            r8.append(r9)     // Catch: java.lang.Throwable -> L8e
            java.lang.String r6 = android.util.Log.getStackTraceString(r6)     // Catch: java.lang.Throwable -> L8e
            r8.append(r6)     // Catch: java.lang.Throwable -> L8e
            java.lang.String r6 = r8.toString()     // Catch: java.lang.Throwable -> L8e
            e.c.a.g.a.s.g0.c(r7, r6)     // Catch: java.lang.Throwable -> L8e
            java.lang.Class r2 = r2.getSuperclass()     // Catch: java.lang.Throwable -> L72
            java.lang.String r6 = "stop"
            java.lang.Class[] r7 = new java.lang.Class[r0]     // Catch: java.lang.Throwable -> L72
            java.lang.reflect.Method r2 = r2.getDeclaredMethod(r6, r7)     // Catch: java.lang.Throwable -> L72
            r2.setAccessible(r5)     // Catch: java.lang.Throwable -> L72
            java.lang.Object[] r5 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L72
            r2.invoke(r4, r5)     // Catch: java.lang.Throwable -> L72
        L6a:
            r4 = 5000(0x1388, double:2.4703E-320)
            java.lang.Thread.sleep(r4)     // Catch: java.lang.InterruptedException -> L6f java.lang.Throwable -> L8e
        L6f:
            int r1 = r1 + 1
            goto L9
        L72:
            r0 = move-exception
            java.lang.String r1 = e.c.a.g.a.d.e.b.a     // Catch: java.lang.Throwable -> L8e
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8e
            r2.<init>()     // Catch: java.lang.Throwable -> L8e
            java.lang.String r4 = "Interrupting thread `FinalizerWatchdogDaemon` failed"
            r2.append(r4)     // Catch: java.lang.Throwable -> L8e
            java.lang.String r0 = android.util.Log.getStackTraceString(r0)     // Catch: java.lang.Throwable -> L8e
            r2.append(r0)     // Catch: java.lang.Throwable -> L8e
            java.lang.String r0 = r2.toString()     // Catch: java.lang.Throwable -> L8e
            e.c.a.g.a.s.g0.c(r1, r0)     // Catch: java.lang.Throwable -> L8e
            goto La7
        L8e:
            r0 = move-exception
            java.lang.String r1 = e.c.a.g.a.d.e.b.a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r3)
            java.lang.String r0 = android.util.Log.getStackTraceString(r0)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            e.c.a.g.a.s.g0.c(r1, r0)
        La7:
            boolean r0 = b()
            if (r0 == 0) goto Lb3
            java.lang.String r0 = e.c.a.g.a.d.e.b.a
            e.c.a.g.a.s.g0.c(r0, r3)
            goto Lba
        Lb3:
            java.lang.String r0 = e.c.a.g.a.d.e.b.a
            java.lang.String r1 = "Thread `FinalizerWatchdogDaemon` does not exist"
            e.c.a.g.a.s.g0.e(r0, r1)
        Lba:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.a.g.a.d.e.b.d():void");
    }
}
