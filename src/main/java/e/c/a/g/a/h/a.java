package e.c.a.g.a.h;

import android.content.Context;
import e.c.a.g.a.h.b;
import e.c.a.g.a.s.j0;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile a f1054f;
    public Context a;
    public b b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<j> f1055d;
    public boolean c = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f1056e = "";

    /* JADX INFO: renamed from: e.c.a.g.a.h.a$a, reason: collision with other inner class name */
    public class C0162a implements b.a {
        public C0162a() {
        }

        @Override // e.c.a.g.a.h.b.a
        public void onFail() {
        }

        @Override // e.c.a.g.a.h.b.a
        public void onFinish(boolean z, e.c.a.g.a.d.b.a aVar) {
            if (z) {
                e.b().c(false);
                e.b().a();
                a.this.e();
            }
            a.this.f(false);
        }

        @Override // e.c.a.g.a.h.b.a
        public void onSucceed() {
        }
    }

    public a(Context context) {
        this.a = context;
    }

    public static a c(Context context) {
        if (f1054f == null) {
            synchronized (a.class) {
                if (f1054f == null) {
                    f1054f = new a(context);
                }
            }
        }
        return f1054f;
    }

    public void b() {
        if (d()) {
            return;
        }
        List<j> list = this.f1055d;
        if (list == null || list.size() == 0) {
            e();
            e.b().c(false);
            e.b().a();
        } else {
            System.currentTimeMillis();
            f(true);
            b bVar = new b(this.a, this.f1055d, 0, this.f1056e);
            this.b = bVar;
            bVar.l(new C0162a());
            j0.b().a(this.b);
        }
    }

    public synchronized boolean d() {
        return this.c;
    }

    public final void e() {
    }

    public boolean f(boolean z) {
        synchronized (a.class) {
            if (this.c != (!z)) {
                return false;
            }
            this.c = z;
            if (!z) {
                this.f1055d.clear();
            }
            return true;
        }
    }
}
