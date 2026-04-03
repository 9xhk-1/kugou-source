package e.c.a.g.a.d.o.d.c;

import android.content.Intent;
import android.os.RemoteException;
import e.c.a.g.a.d.o.c.g;
import e.c.a.g.a.d.o.d.c.c;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static c a() {
        return c.a.a(g.f("@twin:Broadcast"));
    }

    public static void b(Intent intent) {
        try {
            a().send(3, intent);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    public static void c(Intent intent) {
        try {
            a().send(1, intent);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }
}
