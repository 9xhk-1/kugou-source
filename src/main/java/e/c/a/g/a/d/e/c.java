package e.c.a.g.a.d.e;

import android.content.Context;
import android.util.Log;
import java.lang.Thread;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
public class c implements Thread.UncaughtExceptionHandler {
    public Thread.UncaughtExceptionHandler a;

    public c(Context context) {
        this.a = Thread.getDefaultUncaughtExceptionHandler();
        this.a = Thread.getDefaultUncaughtExceptionHandler();
        Log.e("Tinker.UncaughtHandler", "KGUncaughtHandler, isEnableCrashCatch = true");
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        Log.e("Tinker.UncaughtHandler", "KGUncaughtHandler catch exception:, isEnableCrashCatch = true");
        if (thread.getName().equals("FinalizerWatchdogDaemon") && (th instanceof TimeoutException)) {
            Log.e("Tinker.UncaughtHandler", "KGUncaughtHandler catch exception: ignore this TimeoutException");
            return;
        }
        Log.e("Tinker.UncaughtHandler", "KGUncaughtHandler default catch. defaultUncaughtExceptionHandler " + this.a);
        if (this.a != null) {
            Log.e("Tinker.UncaughtHandler", "KGUncaughtHandler default uncaughtException ");
            this.a.uncaughtException(thread, th);
        }
    }
}
