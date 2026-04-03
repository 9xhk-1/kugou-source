package e.c.e.a.a;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: e.c.e.a.a.a$a, reason: collision with other inner class name */
    public static class C0212a<T extends C0212a<?>> {
        public volatile boolean a;
        public volatile boolean b;
        public volatile Runnable c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Map<String, Object> f1290d = new HashMap();

        public void a() {
            if (d("CONTEXT")) {
                throw new NullPointerException("did you forgot to call setContext");
            }
            if (d("LOG")) {
                f(new e.c.e.a.a.d.a());
            }
            if (d("THREAD_POOL")) {
                g(new e.c.e.a.a.d.b());
            }
        }

        public void b() {
            if (this.b) {
                this.b = false;
                if (this.c != null) {
                    this.c.run();
                }
            }
        }

        public void c() {
            if (this.a) {
                throw new IllegalStateException("could not init twice!");
            }
            a();
            this.a = true;
        }

        public boolean d(String str) {
            return !this.f1290d.containsKey(str);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public T e(Context context) {
            this.f1290d.put("CONTEXT", context);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public T f(b bVar) {
            this.f1290d.put("LOG", bVar);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public T g(c cVar) {
            this.f1290d.put("THREAD_POOL", cVar);
            return this;
        }
    }

    public static void a(C0212a<?> c0212a) {
        if (c0212a.a) {
            return;
        }
        c0212a.b();
        if (!c0212a.a) {
            throw new IllegalStateException("you must use initiator() to init first!");
        }
    }
}
