package e.c.c.o;

import java.io.Closeable;

/* JADX INFO: loaded from: classes2.dex */
public class e {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }
}
