package e.f.a.a.a.j;

import android.content.Context;
import android.os.Process;
import com.tencent.tmachine.trace.provider.stacktrace.StackTraceConfig;
import e.f.a.a.a.k.f;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    public static d k;
    public final Context b;
    public c c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f1357e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f1358f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<Integer, Long> f1356d = new HashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LinkedBlockingQueue<Runnable> f1359g = new LinkedBlockingQueue<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public LinkedBlockingQueue<Runnable> f1360h = new LinkedBlockingQueue<>();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Object f1361i = new Object();
    public int j = 0;
    public final e.f.a.a.a.g.b a = e.f.a.a.a.g.b.r();

    public class a implements Runnable {
        public final /* synthetic */ Runnable a;

        public a(Runnable runnable) {
            this.a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.run();
            synchronized (d.this.f1361i) {
                d.b(d.this);
            }
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ LinkedBlockingQueue b;

        public b(d dVar, int i2, LinkedBlockingQueue linkedBlockingQueue) {
            this.a = i2;
            this.b = linkedBlockingQueue;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable;
            for (int i2 = 0; i2 < this.a && (runnable = (Runnable) this.b.poll()) != null; i2++) {
                runnable.run();
            }
        }
    }

    public d(Context context) {
        this.b = context;
    }

    public static /* synthetic */ int b(d dVar) {
        int i2 = dVar.j - 1;
        dVar.j = i2;
        return i2;
    }

    public static synchronized d h() {
        return k;
    }

    public static synchronized d j(Context context) {
        if (k == null) {
            k = new d(context);
        }
        return k;
    }

    public final void c(Runnable runnable, boolean z, boolean z2, long j) {
        if (runnable == null) {
            e.f.a.a.a.k.c.j("[UploadManager] Upload task should not be null", new Object[0]);
        }
        e.f.a.a.a.k.c.b("[UploadManager] Add upload task (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        if (z2) {
            f(runnable, j);
        } else {
            d(runnable, z);
            g(0);
        }
    }

    public final boolean d(Runnable runnable, boolean z) {
        if (runnable == null) {
            e.f.a.a.a.k.c.f("[UploadManager] Upload task should not be null", new Object[0]);
            return false;
        }
        try {
            e.f.a.a.a.k.c.b("[UploadManager] Add upload task to queue (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            synchronized (this.f1361i) {
                if (z) {
                    this.f1359g.put(runnable);
                } else {
                    this.f1360h.put(runnable);
                }
            }
            return true;
        } catch (Throwable th) {
            e.f.a.a.a.k.c.c("[UploadManager] Failed to add upload task to queue: %s", th.getMessage());
            return false;
        }
    }

    public boolean e(int i2) {
        if (e.f.a.a.a.c.b) {
            e.f.a.a.a.k.c.b("Uploading frequency will not be checked if SDK is in debug mode.", new Object[0]);
            return true;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - i(i2);
        e.f.a.a.a.k.c.b("[UploadManager] Time interval is %d seconds since last uploading(ID: %d).", Long.valueOf(jCurrentTimeMillis / 1000), Integer.valueOf(i2));
        if (jCurrentTimeMillis >= StackTraceConfig.DEFAULT_TRACE_DURATION) {
            return true;
        }
        e.f.a.a.a.k.c.f("[UploadManager] Data only be uploaded once in %d seconds.", 30L);
        return false;
    }

    public final void f(Runnable runnable, long j) {
        if (runnable == null) {
            e.f.a.a.a.k.c.j("[UploadManager] Upload task should not be null", new Object[0]);
            return;
        }
        e.f.a.a.a.k.c.b("[UploadManager] Execute synchronized upload task (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        Thread threadD = f.D(runnable, "FIREEYE_SYNC_UPLOAD");
        if (threadD == null) {
            e.f.a.a.a.k.c.c("[UploadManager] Failed to start a thread to execute synchronized upload task, add it to queue.", new Object[0]);
            d(runnable, true);
            return;
        }
        try {
            threadD.join(j);
        } catch (Throwable th) {
            e.f.a.a.a.k.c.c("[UploadManager] Failed to join upload synchronized task with message: %s. Add it to queue.", th.getMessage());
            d(runnable, true);
            g(0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:111:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006c A[Catch: all -> 0x015c, TRY_LEAVE, TryCatch #4 {, blocks: (B:8:0x001c, B:11:0x0049, B:12:0x0050, B:23:0x0062, B:28:0x006c, B:35:0x008e, B:34:0x0081, B:38:0x0094, B:45:0x00b6, B:44:0x00a9, B:46:0x00b9, B:18:0x0059, B:20:0x005d, B:31:0x0077, B:41:0x009f), top: B:97:0x001c, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0094 A[Catch: all -> 0x015c, TRY_LEAVE, TryCatch #4 {, blocks: (B:8:0x001c, B:11:0x0049, B:12:0x0050, B:23:0x0062, B:28:0x006c, B:35:0x008e, B:34:0x0081, B:38:0x0094, B:45:0x00b6, B:44:0x00a9, B:46:0x00b9, B:18:0x0059, B:20:0x005d, B:31:0x0077, B:41:0x009f), top: B:97:0x001c, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0153  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void g(int r14) {
        /*
            Method dump skipped, instruction units count: 353
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.f.a.a.a.j.d.g(int):void");
    }

    public synchronized long i(int i2) {
        if (i2 >= 0) {
            Long l = this.f1356d.get(Integer.valueOf(i2));
            if (l != null) {
                return l.longValue();
            }
        } else {
            e.f.a.a.a.k.c.c("[UploadManager] Unknown upload ID: %d", Integer.valueOf(i2));
        }
        return 0L;
    }

    public long k(boolean z) {
        long jB;
        long jO = f.o();
        int i2 = z ? 5 : 3;
        List<e.f.a.a.a.g.c> listT = this.a.t(i2);
        if (listT == null || listT.size() <= 0) {
            jB = z ? this.f1358f : this.f1357e;
        } else {
            jB = 0;
            try {
                e.f.a.a.a.g.c cVar = listT.get(0);
                if (cVar.f1341e >= jO) {
                    jB = f.b(cVar.f1343g);
                    if (i2 == 3) {
                        this.f1357e = jB;
                    } else {
                        this.f1358f = jB;
                    }
                    listT.remove(cVar);
                }
            } catch (Throwable th) {
                e.f.a.a.a.k.c.k(th);
            }
            if (listT.size() > 0) {
                this.a.z(listT);
            }
        }
        e.f.a.a.a.k.c.b("[UploadManager] Local network consume: %d KB", Long.valueOf(jB / 1024));
        return jB;
    }

    public void l(int i2, int i3, byte[] bArr, String str, String str2, c cVar, int i4, int i5, boolean z, Map<String, String> map) {
        try {
            try {
                c(new e(this.b, i2, i3, bArr, str, str2, cVar, true, i4, i5, false, map), z, false, 0L);
            } catch (Throwable th) {
                th = th;
                if (e.f.a.a.a.k.c.k(th)) {
                    return;
                }
                th.printStackTrace();
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public void m(int i2, e.f.a.a.d.a.f fVar, String str, String str2, c cVar, boolean z) {
        l(i2, fVar.j, e.f.a.a.a.j.a.c(fVar), str, str2, cVar, 0, 0, z, null);
    }

    public void n(int i2, int i3, byte[] bArr, String str, String str2, c cVar, long j, boolean z) {
        try {
        } catch (Throwable th) {
            th = th;
        }
        try {
            c(new e(this.b, i2, i3, bArr, str, str2, cVar, true, z), true, true, j);
        } catch (Throwable th2) {
            th = th2;
            if (e.f.a.a.a.k.c.k(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public void o(int i2, e.f.a.a.d.a.f fVar, String str, String str2, c cVar, long j, boolean z) {
        n(i2, fVar.j, e.f.a.a.a.j.a.c(fVar), str, str2, cVar, j, z);
    }

    public synchronized void p(long j, boolean z) {
        int i2 = z ? 5 : 3;
        e.f.a.a.a.g.c cVar = new e.f.a.a.a.g.c();
        cVar.b = i2;
        cVar.f1341e = f.o();
        cVar.c = "";
        cVar.f1340d = "";
        cVar.f1343g = f.s(j);
        this.a.y(i2);
        this.a.C(cVar);
        if (z) {
            this.f1358f = j;
        } else {
            this.f1357e = j;
        }
        e.f.a.a.a.k.c.b("[UploadManager] Network total consume: %d KB", Long.valueOf(j / 1024));
    }

    public synchronized void q(int i2, long j) {
        if (i2 >= 0) {
            this.f1356d.put(Integer.valueOf(i2), Long.valueOf(j));
            e.f.a.a.a.g.c cVar = new e.f.a.a.a.g.c();
            cVar.b = i2;
            cVar.f1341e = j;
            cVar.c = "";
            cVar.f1340d = "";
            cVar.f1343g = new byte[0];
            this.a.y(i2);
            this.a.C(cVar);
            e.f.a.a.a.k.c.b("[UploadManager] Uploading(ID:%d) time: %s", Integer.valueOf(i2), f.n(j));
        } else {
            e.f.a.a.a.k.c.c("[UploadManager] Unknown uploading ID: %d", Integer.valueOf(i2));
        }
    }
}
