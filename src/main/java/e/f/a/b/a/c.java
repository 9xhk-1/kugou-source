package e.f.a.b.a;

import androidx.core.app.NotificationCompat;
import f.z.d.g;
import f.z.d.j;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public static final a b = new a(null);
    public static e.f.a.b.a.e.a a = new e.f.a.b.a.h.a();

    public static final class a {
        public a() {
        }

        public final void a(String str, String str2) {
            j.f(str, "tag");
            j.f(str2, NotificationCompat.CATEGORY_MESSAGE);
            c.a.d("FireEyeLog#" + str, str2);
        }

        public final void b(String str, String str2) {
            j.f(str, "tag");
            j.f(str2, NotificationCompat.CATEGORY_MESSAGE);
            c.a.e("FireEyeLog#" + str, str2);
        }

        public final void c(String str, String str2, Throwable th) {
            j.f(str, "tag");
            j.f(str2, NotificationCompat.CATEGORY_MESSAGE);
            j.f(th, "tr");
            c.a.e("FireEyeLog#" + str, str2, th);
        }

        public final void d(String str, String str2) {
            j.f(str, "tag");
            j.f(str2, NotificationCompat.CATEGORY_MESSAGE);
            c.a.i("FireEyeLog#" + str, str2);
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    public static final void b(String str, String str2, Throwable th) {
        b.c(str, str2, th);
    }

    public static final void c(String str, String str2) {
        b.d(str, str2);
    }
}
