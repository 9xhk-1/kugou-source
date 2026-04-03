package e.c.a.g.a.d.o.c;

import android.os.IBinder;
import android.os.IInterface;
import androidx.annotation.NonNull;
import e.c.a.g.a.s.g0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class j<T extends IInterface> {
    public final String a;
    public volatile T b;

    public static class a implements f {
        public static a b = new a();
        public final List<j> a = new ArrayList();

        public a() {
            g.b(this);
        }

        public static a b() {
            return b;
        }

        public final void c() {
            Object[] array;
            synchronized (this.a) {
                array = this.a.toArray();
            }
            if (array.length > 0) {
                for (Object obj : array) {
                    ((j) obj).d();
                }
            }
        }

        public void d(j jVar) {
            if (jVar == null) {
                return;
            }
            synchronized (this.a) {
                if (!this.a.contains(jVar)) {
                    this.a.add(jVar);
                }
            }
        }

        @Override // e.c.a.g.a.d.o.c.f
        public void onAttachRemote() {
            c();
            if (g0.a) {
                e.c.a.g.a.d.o.e.a.e("ReferenceManager#onAttachRemote() !!!");
            }
        }

        @Override // e.c.a.g.a.d.o.c.f
        public void onDetachRemote() {
            c();
            if (g0.a) {
                e.c.a.g.a.d.o.e.a.e("ReferenceManager#onDetachRemote() !!!");
            }
        }
    }

    public j(@NonNull String str) {
        this.a = str;
        a.b().d(this);
    }

    public abstract T b(IBinder iBinder);

    public final T c() throws e.c.a.g.a.d.o.e.b {
        T t = this.b;
        if (t == null) {
            t = (T) b(g.e(this.a));
            this.b = t;
        }
        if (t != null) {
            return t;
        }
        throw new e.c.a.g.a.d.o.e.b(this.a);
    }

    public final void d() {
        this.b = null;
    }
}
