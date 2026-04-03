package e.c.e.b.b;

import android.content.Context;
import e.c.e.a.a.a;
import e.c.e.a.a.c;

/* JADX INFO: loaded from: classes2.dex */
public class b extends e.c.e.a.a.a {
    public static final a a = new a();

    public static class a extends a.C0212a<a> {
        @Override // e.c.e.a.a.a.C0212a
        public void a() {
            super.a();
            if (d("AUDIO_FOCUS_MANAGER")) {
                h(new e.c.e.b.b.c.a());
            }
        }

        public a h(e.c.e.b.b.a aVar) {
            this.f1290d.put("AUDIO_FOCUS_MANAGER", aVar);
            return this;
        }
    }

    public static e.c.e.b.b.a b() {
        c();
        return (e.c.e.b.b.a) a.f1290d.get("AUDIO_FOCUS_MANAGER");
    }

    public static void c() {
        if (!a.a) {
            throw new IllegalStateException("you must use initiator() to init first!");
        }
    }

    public static Context d() {
        c();
        return (Context) a.f1290d.get("CONTEXT");
    }

    public static a e() {
        return a;
    }

    public static e.c.e.a.a.b f() {
        c();
        return (e.c.e.a.a.b) a.f1290d.get("LOG");
    }

    public static c g() {
        c();
        return (c) a.f1290d.get("THREAD_POOL");
    }
}
