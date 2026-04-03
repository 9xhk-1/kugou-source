package e.c.d.f;

import android.content.Context;
import android.support.annotation.NonNull;
import e.c.e.a.a.a;
import e.c.e.a.a.b;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class a extends e.c.e.a.a.a {
    public static final C0211a a = new C0211a();

    /* JADX INFO: renamed from: e.c.d.f.a$a, reason: collision with other inner class name */
    public static class C0211a extends a.C0212a<C0211a> {
        @Override // e.c.e.a.a.a.C0212a
        public void a() {
        }

        @NonNull
        public Map<String, Object> h() {
            return this.f1290d;
        }
    }

    public static void b() {
        e.c.e.a.a.a.a(a);
    }

    public static Context c() {
        b();
        return (Context) a.h().get("CONTEXT");
    }

    public static C0211a d() {
        return a;
    }

    public static b e() {
        b();
        return (b) a.h().get("LOG");
    }
}
