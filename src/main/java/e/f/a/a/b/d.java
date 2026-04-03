package e.f.a.a.b;

import android.content.Context;
import e.f.a.a.a.k.f;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    public static d b;
    public e.f.a.a.a.h.b a;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.c();
        }
    }

    public d(Context context) {
        c cVarC = c.c();
        if (cVarC == null) {
            return;
        }
        e.f.a.a.a.i.a.g();
        this.a = e.f.a.a.a.h.b.e(context);
        b bVar = cVarC.b;
        e.f.a.a.a.k.a.b().d(new a());
    }

    public static d b(Context context) {
        if (b == null) {
            b = new d(context);
        }
        return b;
    }

    public final void c() {
        e.f.a.a.a.k.c.b("[ExtraCrashManager] Trying to notify FireEye agents.", new Object[0]);
        try {
            Class<?> cls = Class.forName("com.tencent.fireeye.agent.GameAgent");
            Objects.requireNonNull(this.a);
            f.B(cls, "sdkPackageName", "com.tencent.fireeye", null);
            e.f.a.a.a.k.c.b("[ExtraCrashManager] FireEye game agent has been notified.", new Object[0]);
        } catch (Throwable unused) {
            e.f.a.a.a.k.c.f("[ExtraCrashManager] no game agent", new Object[0]);
        }
    }
}
