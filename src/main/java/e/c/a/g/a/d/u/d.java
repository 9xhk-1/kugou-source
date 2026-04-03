package e.c.a.g.a.d.u;

import android.app.Service;
import android.content.Context;
import e.c.a.g.a.s.l1;

/* JADX INFO: loaded from: classes.dex */
public class d implements c {
    public static volatile d b;
    public final c a = a();

    public static d b() {
        if (b == null) {
            synchronized (d.class) {
                if (b == null) {
                    b = new d();
                }
            }
        }
        return b;
    }

    public final c a() {
        return l1.m0() ? new g() : l1.V() ? new b() : l1.g0() ? new e.c.a.g.a.d.u.h.a() : l1.f0() ? new f() : l1.U() ? new b() : l1.n0() ? new a() : (l1.X() || l1.b0()) ? new a() : l1.N() ? e.b() ? new b() : new a() : new a();
    }

    @Override // e.c.a.g.a.d.u.c
    public void cancel(Context context) {
        this.a.cancel(context);
    }

    @Override // e.c.a.g.a.d.u.c
    public void init() {
        this.a.init();
    }

    @Override // e.c.a.g.a.d.u.c
    public void showNotification(Context context) {
        this.a.showNotification(context);
    }

    @Override // e.c.a.g.a.d.u.c
    public void startNotification(Service service) {
        this.a.startNotification(service);
    }
}
