package e.c.a.g.a.d.v;

import android.os.HandlerThread;
import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
public class d {
    public static volatile Looper a;

    public static Looper a() {
        return b();
    }

    public static Looper b() {
        if (a == null) {
            synchronized (d.class) {
                if (a == null) {
                    HandlerThread handlerThread = new HandlerThread("Minor");
                    handlerThread.setPriority(10);
                    handlerThread.start();
                    a = handlerThread.getLooper();
                }
            }
        }
        return a;
    }
}
