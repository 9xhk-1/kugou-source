package e.c.c.j.d;

import android.os.SystemClock;
import e.c.c.o.g;

/* JADX INFO: loaded from: classes2.dex */
public class b extends e.c.c.j.d.a {
    public static volatile b b;
    public e.c.c.j.d.e.a a = new e.c.c.j.d.e.a();

    public class a implements Runnable {
        public final /* synthetic */ String a;

        public a(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.c.c.j.d.e.d.a aVarD = b.this.a.d(this.a);
            if (aVarD == null || aVarD.b() == null || aVarD.b().get("start") == null) {
                return;
            }
            e.c.c.j.d.d.b.a().b(aVarD.c(), aVarD);
            if (aVarD.a() != null) {
                g.a("autoapm--size=", aVarD.a().size() + "tbussData" + aVarD.a().toString());
            }
        }
    }

    public static b a() {
        if (b == null) {
            synchronized (b.class) {
                if (b == null) {
                    b = new b();
                }
            }
        }
        return b;
    }

    @Override // e.c.c.j.d.a
    public void add(String str, String str2) {
        this.a.b(str, str2, getCurTime());
    }

    @Override // e.c.c.j.d.a
    public void end(String str) {
        end(str, getCurTime());
    }

    public final long getCurTime() {
        return SystemClock.elapsedRealtime();
    }

    @Override // e.c.c.j.d.a
    public String start(String str) {
        return start(str, getCurTime());
    }

    @Override // e.c.c.j.d.a
    public void add(String str, String str2, String str3) {
        this.a.a(str, str2, str3);
    }

    @Override // e.c.c.j.d.a
    public void end(String str, long j) {
        this.a.b(str, this.END_IDENTIFY_VALUE, j);
        c.a(new a(str));
    }

    @Override // e.c.c.j.d.a
    public String start(String str, long j) {
        String strC = e.c.c.j.d.e.b.b().c(str);
        this.a.b(strC, this.START_IDENTIFY_VALUE, j);
        return strC;
    }

    @Override // e.c.c.j.d.a
    public void end(String str, String str2) {
        e.c.c.j.d.e.c.e().a(str, str2);
        if (e.c.c.j.d.e.c.e().f(str)) {
            add(str, str2);
        } else {
            end(str);
        }
    }

    @Override // e.c.c.j.d.a
    public String start(String str, int i2) {
        String strStart = start(str);
        e.c.c.j.d.e.c.e().g(strStart, i2);
        return strStart;
    }
}
