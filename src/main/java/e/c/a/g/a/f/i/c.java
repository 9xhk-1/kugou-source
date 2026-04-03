package e.c.a.g.a.f.i;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import e.c.a.g.a.s.g0;
import java.io.FileDescriptor;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class c {
    public static c b;
    public final WeakHashMap<Thread, b> a = new WeakHashMap<>();

    public static class b {
        public int a;
        public BitmapFactory.Options b;

        public b() {
            this.a = 2;
        }

        public String toString() {
            int i2 = this.a;
            return "thread state = " + (i2 == 1 ? "Cancel" : i2 == 2 ? "Allow" : "?") + ", options = " + this.b;
        }
    }

    public static synchronized c d() {
        if (b == null) {
            b = new c();
        }
        return b;
    }

    public synchronized boolean a(Thread thread) {
        b bVar = this.a.get(thread);
        if (bVar == null) {
            return true;
        }
        return bVar.a != 1;
    }

    public Bitmap b(FileDescriptor fileDescriptor, BitmapFactory.Options options) {
        if (options.mCancel) {
            return null;
        }
        Thread threadCurrentThread = Thread.currentThread();
        if (a(threadCurrentThread)) {
            f(threadCurrentThread, options);
            Bitmap bitmapDecodeFileDescriptor = BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
            e(threadCurrentThread);
            return bitmapDecodeFileDescriptor;
        }
        if (g0.a) {
            g0.b("BitmapManager", "Thread " + threadCurrentThread + " is not allowed to decode.");
        }
        return null;
    }

    public final synchronized b c(Thread thread) {
        b bVar;
        bVar = this.a.get(thread);
        if (bVar == null) {
            bVar = new b();
            this.a.put(thread, bVar);
        }
        return bVar;
    }

    public synchronized void e(Thread thread) {
        this.a.get(thread).b = null;
    }

    public final synchronized void f(Thread thread, BitmapFactory.Options options) {
        c(thread).b = options;
    }
}
