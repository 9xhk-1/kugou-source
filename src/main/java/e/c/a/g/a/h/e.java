package e.c.a.g.a.h;

import java.util.HashSet;

/* JADX INFO: loaded from: classes2.dex */
public class e {
    public static volatile e b;
    public HashSet<String> a = new HashSet<>();

    public static e b() {
        if (b == null) {
            synchronized (e.class) {
                if (b == null) {
                    b = new e();
                }
            }
        }
        return b;
    }

    public synchronized void a() {
        this.a.clear();
    }

    public void c(boolean z) {
    }
}
