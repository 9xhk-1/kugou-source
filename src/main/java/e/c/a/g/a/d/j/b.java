package e.c.a.g.a.d.j;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import android.os.SystemClock;
import com.kugou.android.watch.lite.base.application.KGApplication;
import e.c.a.g.a.s.g0;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static volatile boolean a = false;

    public class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            boolean unused = b.a = true;
            try {
                Process.setThreadPriority(-16);
            } catch (Exception unused2) {
            }
            c cVarD = b.d("com.kugou.android.watch.lite.base.exit.ExitGlobalImpl");
            if (cVarD != null) {
                cVarD.handleExit();
            }
            boolean unused3 = b.a = false;
        }
    }

    /* JADX INFO: renamed from: e.c.a.g.a.d.j.b$b, reason: collision with other inner class name */
    public static class C0057b {
        public static SharedPreferences b(Context context) {
            return context.getSharedPreferences("process_rec", 4);
        }

        public static void c(Context context, String str, int i2) {
            try {
                b(context).edit().putInt(str, i2).commit();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public interface c {
        void handleExit();
    }

    public static void c() {
        if (a) {
            return;
        }
        new Thread(new a()).start();
        if (KGApplication.isForeProcess()) {
            SystemClock.sleep(300L);
        }
    }

    public static c d(String str) {
        try {
            return (c) Class.forName(str).newInstance();
        } catch (Exception e2) {
            if (g0.a) {
                g0.c("Exit001", "ExitCommander.getExitGlobal() throw an exception : " + e2);
            }
            return null;
        }
    }

    public static void e(Context context, int i2) {
        C0057b.c(context, "support", i2);
    }
}
