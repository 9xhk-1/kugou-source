package h.a.a;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static Context a;

    public static Context a() {
        return a;
    }

    public static void b(Context context) {
        Context context2 = a;
        if (context2 != null && context2 != context) {
            throw new RuntimeException("Attempting to set multiple global application contexts.");
        }
        c(context);
    }

    public static void c(Context context) {
        if (context == null) {
            throw new RuntimeException("Global application context cannot be set to null.");
        }
        a = context;
    }
}
