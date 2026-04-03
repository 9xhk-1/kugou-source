package e.c.a.g.a.d.o.c;

import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import e.c.a.g.a.s.j0;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class g {

    public static class a implements e {
        public static volatile a b;
        public static int c;
        public final ArrayList<f> a = new ArrayList<>();

        /* JADX INFO: renamed from: e.c.a.g.a.d.o.c.g$a$a, reason: collision with other inner class name */
        public class RunnableC0060a implements Runnable {
            public final /* synthetic */ boolean a;

            public RunnableC0060a(boolean z) {
                this.a = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.c(this.a);
            }
        }

        public a() {
            int i2 = c + 1;
            c = i2;
            if (i2 > 1) {
                throw new RuntimeException("More than one instance");
            }
            try {
                g.d().setRemoteAttachStateCallback(this);
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            }
        }

        public static a d() {
            if (b == null) {
                synchronized (a.class) {
                    if (b == null) {
                        b = new a();
                    }
                }
            }
            return b;
        }

        public void b(f fVar) {
            if (fVar == null) {
                return;
            }
            synchronized (this.a) {
                if (!this.a.contains(fVar)) {
                    this.a.add(fVar);
                }
                if (g.g()) {
                    e(true, fVar);
                }
            }
        }

        public final void c(boolean z) {
            synchronized (this.a) {
                ArrayList<f> arrayList = this.a;
                for (f fVar : (f[]) arrayList.toArray(new f[arrayList.size()])) {
                    e(z, fVar);
                }
            }
        }

        public final void e(boolean z, f fVar) {
            if (fVar == null) {
                return;
            }
            if (!z) {
                fVar.onDetachRemote();
                return;
            }
            fVar.onAttachRemote();
            if ((fVar instanceof b) && ((b) fVar).b) {
                f(fVar);
            }
        }

        public void f(f fVar) {
            if (fVar == null) {
                return;
            }
            synchronized (this.a) {
                this.a.remove(fVar);
            }
        }

        @Override // e.c.a.g.a.d.o.c.e
        public void onAttachStateChanged(boolean z) {
            j0.b().a(new RunnableC0060a(z));
        }
    }

    public static class b implements f {
        public final Runnable a;
        public final boolean b;

        public b(@NonNull Runnable runnable, boolean z) {
            this.a = runnable;
            this.b = z;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof b) {
                return ((b) obj).a.equals(this.a);
            }
            return false;
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        @Override // e.c.a.g.a.d.o.c.f
        public void onAttachRemote() {
            this.a.run();
        }

        @Override // e.c.a.g.a.d.o.c.f
        public void onDetachRemote() {
        }
    }

    public static void b(f fVar) {
        a.d().b(fVar);
    }

    public static void c(String str, Binder binder) {
        try {
            d().addService(str, binder, true);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    public static e.c.a.g.a.d.o.c.b d() {
        return h.h();
    }

    public static IBinder e(String str) {
        try {
            return d().getService(str, true);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static IBinder f(String str) {
        try {
            return d().getTwin(str, true);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static boolean g() {
        try {
            return d().isRemoteValidate();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static void h(@NonNull Runnable runnable) {
        a.d().b(new b(runnable, false));
    }
}
