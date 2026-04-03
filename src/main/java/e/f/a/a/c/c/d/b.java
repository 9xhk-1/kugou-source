package e.f.a.a.c.c.d;

import android.content.Context;
import e.f.a.a.b.c;

/* JADX INFO: loaded from: classes2.dex */
public class b implements a {
    public static b a;

    public b(Context context) {
    }

    public static synchronized b a(Context context) {
        if (a == null) {
            a = new b(context);
        }
        return a;
    }

    public synchronized void b(String str) {
    }

    @Override // e.f.a.a.c.c.d.a
    public void handleNativeException(int i2, int i3, long j, long j2, String str, String str2, String str3, String str4) {
        handleNativeException(i2, i3, j, j2, str, str2, str3, str4, -1234567890, "", -1, -1, -1, "", "unknown");
    }

    @Override // e.f.a.a.c.c.d.a
    public void handleNativeException(int i2, int i3, long j, long j2, String str, String str2, String str3, String str4, int i4, String str5, int i5, int i6, int i7, String str6, String str7) {
        handleNativeException(i2, i3, j, j2, str, str2, str3, str4, i4, str5, i5, i6, i7, str6, str7, null);
    }

    @Override // e.f.a.a.c.c.d.a
    public void handleNativeException(int i2, int i3, long j, long j2, String str, String str2, String str3, String str4, int i4, String str5, int i5, int i6, int i7, String str6, String str7, String[] strArr) {
        c.c().d().handleNativeException2(i2, i3, j, j2, str, str2, str3, str4, i4, str5, i5, i6, i7, str6, str7, strArr);
    }
}
