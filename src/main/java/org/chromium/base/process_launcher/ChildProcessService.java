package org.chromium.base.process_launcher;

import android.app.Service;
import android.content.Intent;
import android.os.Debug;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Process;
import android.util.SparseArray;
import java.util.concurrent.Semaphore;
import org.chromium.base.CommandLine;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ChildProcessService extends Service {
    public static boolean m;
    public final h.a.a.e.a a;
    public final Object b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Thread f1701d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String[] f1702f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public FileDescriptorInfo[] f1703h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f1704i;
    public boolean j;
    public final Semaphore k;
    public final h.a.a.e.b l;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean zLoadNativeLibrary;
            try {
                synchronized (ChildProcessService.this.f1701d) {
                    while (ChildProcessService.this.f1702f == null) {
                        ChildProcessService.this.f1701d.wait();
                    }
                }
                CommandLine.d(ChildProcessService.this.f1702f);
                if (CommandLine.b().c("renderer-wait-for-java-debugger")) {
                    Debug.waitForDebugger();
                }
                try {
                    zLoadNativeLibrary = ChildProcessService.this.a.loadNativeLibrary(ChildProcessService.this.getApplicationContext());
                } catch (Exception e2) {
                    h.a.a.b.c("ChildProcessService", "Failed to load native library.", e2);
                    zLoadNativeLibrary = false;
                }
                if (!zLoadNativeLibrary) {
                    System.exit(-1);
                }
                synchronized (ChildProcessService.this.b) {
                    ChildProcessService.this.f1704i = true;
                    ChildProcessService.this.b.notifyAll();
                }
                synchronized (ChildProcessService.this.f1701d) {
                    ChildProcessService.this.f1701d.notifyAll();
                    while (ChildProcessService.this.f1703h == null) {
                        ChildProcessService.this.f1701d.wait();
                    }
                }
                SparseArray<String> fileDescriptorsIdsToKeys = ChildProcessService.this.a.getFileDescriptorsIdsToKeys();
                int[] iArr = new int[ChildProcessService.this.f1703h.length];
                String[] strArr = new String[ChildProcessService.this.f1703h.length];
                int[] iArr2 = new int[ChildProcessService.this.f1703h.length];
                long[] jArr = new long[ChildProcessService.this.f1703h.length];
                long[] jArr2 = new long[ChildProcessService.this.f1703h.length];
                for (int i2 = 0; i2 < ChildProcessService.this.f1703h.length; i2++) {
                    FileDescriptorInfo fileDescriptorInfo = ChildProcessService.this.f1703h[i2];
                    String str = fileDescriptorsIdsToKeys != null ? fileDescriptorsIdsToKeys.get(fileDescriptorInfo.a) : null;
                    if (str != null) {
                        strArr[i2] = str;
                    } else {
                        iArr[i2] = fileDescriptorInfo.a;
                    }
                    iArr2[i2] = fileDescriptorInfo.b.detachFd();
                    jArr[i2] = fileDescriptorInfo.f1705d;
                    jArr2[i2] = fileDescriptorInfo.f1706f;
                }
                ChildProcessService.nativeRegisterFileDescriptors(strArr, iArr, iArr2, jArr, jArr2);
                ChildProcessService.this.a.onBeforeMain();
                if (ChildProcessService.this.k.tryAcquire()) {
                    ChildProcessService.this.a.runMain();
                    ChildProcessService.nativeExitChildProcess();
                }
            } catch (InterruptedException e3) {
                h.a.a.b.j("ChildProcessService", "%s startup failed: %s", "ChildProcessMain", e3);
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ChildProcessService.this.a.preloadNativeLibrary(ChildProcessService.this.getApplicationContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeExitChildProcess();

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeRegisterFileDescriptors(String[] strArr, int[] iArr, int[] iArr2, long[] jArr, long[] jArr2);

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        stopSelf();
        intent.getBooleanExtra("org.chromium.base.process_launcher.extra.bind_to_caller", false);
        this.j = true;
        this.a.onServiceBound(intent);
        new Handler(Looper.getMainLooper()).post(new b());
        return this.l;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        h.a.a.b.h("ChildProcessService", "Creating new ChildProcessService pid=%d", Integer.valueOf(Process.myPid()));
        if (m) {
            throw new RuntimeException("Illegal child process reuse.");
        }
        m = true;
        h.a.a.a.b(getApplicationContext());
        this.a.onServiceCreated();
        Thread thread = new Thread(new a(), "ChildProcessMain");
        this.f1701d = thread;
        thread.start();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        h.a.a.b.h("ChildProcessService", "Destroying ChildProcessService pid=%d", Integer.valueOf(Process.myPid()));
        if (this.k.tryAcquire()) {
            System.exit(0);
            return;
        }
        synchronized (this.b) {
            while (!this.f1704i) {
                try {
                    this.b.wait();
                } catch (InterruptedException unused) {
                }
            }
        }
        this.a.onDestroy();
    }
}
