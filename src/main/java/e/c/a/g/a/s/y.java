package e.c.a.g.a.s;

import java.io.Closeable;

/* JADX INFO: loaded from: classes2.dex */
public class y {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }
}
