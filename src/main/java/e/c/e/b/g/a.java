package e.c.e.b.g;

import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a<O> {
    public final List<O> a = new ArrayList();

    /* JADX INFO: renamed from: e.c.e.b.g.a$a, reason: collision with other inner class name */
    public class RunnableC0235a implements Runnable {
        public final /* synthetic */ b a;
        public final /* synthetic */ Runnable b;

        public RunnableC0235a(b bVar, Runnable runnable) {
            this.a = bVar;
            this.b = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a.this.b(this.a);
            } finally {
                Runnable runnable = this.b;
                if (runnable != null) {
                    runnable.run();
                }
            }
        }
    }

    public interface b<O> {
        void notify(@NonNull O o);
    }

    public boolean a(O o) {
        boolean zContains;
        synchronized (this.a) {
            zContains = this.a.contains(o);
        }
        return zContains;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void b(b<O> bVar) {
        ArrayList arrayList;
        synchronized (this.a) {
            arrayList = new ArrayList(this.a);
        }
        for (Object obj : arrayList) {
            if (obj != null) {
                bVar.notify(obj);
            }
        }
    }

    public void c(b<O> bVar) {
        d(bVar, null);
    }

    public void d(b<O> bVar, Runnable runnable) {
        e.c.e.b.b.b.g().execute(new RunnableC0235a(bVar, runnable));
    }

    public boolean e(O o) {
        if (o == null) {
            return false;
        }
        synchronized (this.a) {
            if (this.a.contains(o)) {
                return false;
            }
            this.a.add(o);
            return true;
        }
    }

    public boolean f(O o) {
        boolean zRemove;
        synchronized (this.a) {
            zRemove = this.a.remove(o);
        }
        return zRemove;
    }
}
