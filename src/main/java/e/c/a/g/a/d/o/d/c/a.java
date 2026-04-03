package e.c.a.g.a.d.o.d.c;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import e.c.a.g.a.d.o.c.g;
import e.c.a.g.a.d.o.d.c.c;
import e.c.a.g.a.d.o.e.a;
import e.c.a.g.a.s.g0;
import e.c.c.o.f;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a extends c.a implements e.c.a.g.a.d.o.c.c {
    public final C0061a a = new C0061a(this);
    public c b;

    /* JADX INFO: renamed from: e.c.a.g.a.d.o.d.c.a$a, reason: collision with other inner class name */
    public class C0061a {
        public List<Intent> a;
        public Runnable b;

        /* JADX INFO: renamed from: e.c.a.g.a.d.o.d.c.a$a$a, reason: collision with other inner class name */
        public class RunnableC0062a implements Runnable {
            public RunnableC0062a(C0061a c0061a) {
            }

            @Override // java.lang.Runnable
            public void run() {
                g.f("@twin:Broadcast");
                if (g0.a) {
                    e.c.a.g.a.d.o.e.a.e("explicitly get broadcast twin end");
                }
            }
        }

        public C0061a(a aVar) {
        }

        public void a(Intent intent) {
            synchronized (this) {
                if (this.a == null) {
                    this.a = new ArrayList();
                }
                this.a.add(intent);
                if (g0.a) {
                    e.c.a.g.a.d.o.e.a.e("cache broadcast: action = " + intent.getAction());
                }
                if (this.b == null) {
                    RunnableC0062a runnableC0062a = new RunnableC0062a(this);
                    this.b = runnableC0062a;
                    g.h(runnableC0062a);
                }
            }
        }

        public void b(Intent intent) {
            Context contextA = f.a();
            intent.setExtrasClassLoader(contextA.getClassLoader());
            LocalBroadcastManager.getInstance(contextA).sendBroadcast(intent);
            if (g0.a) {
                e.c.a.g.a.d.o.e.a.e("send local broadcast: action = " + intent.getAction());
            }
        }

        public void c(c cVar) {
            synchronized (this) {
                List<Intent> list = this.a;
                if (list != null) {
                    for (Intent intent : list) {
                        try {
                            cVar.send(1, intent);
                            if (g0.a) {
                                e.c.a.g.a.d.o.e.a.e("send pending: action = " + intent.getAction());
                            }
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                        }
                    }
                    this.a.clear();
                }
            }
        }
    }

    @Override // e.c.a.g.a.d.o.c.c
    public void attachRemoteTwin(IBinder iBinder) {
        if (iBinder != null) {
            c cVarA = c.a.a(iBinder);
            this.b = cVarA;
            this.a.c(cVarA);
        }
    }

    @Override // e.c.a.g.a.d.o.c.c
    public void detachRemoteTwin() {
        this.b = null;
    }

    @Override // e.c.a.g.a.d.o.c.c
    public boolean isRemoteAttached() {
        return this.b != null;
    }

    @Override // e.c.a.g.a.d.o.d.c.c
    public void send(int i2, Intent intent) throws RemoteException {
        if (a.C0064a.a(i2)) {
            this.a.b(intent);
        }
        if (a.C0064a.b(i2)) {
            if (!isRemoteAttached()) {
                this.a.a(intent);
            } else {
                try {
                    this.b.send(1, intent);
                } catch (NullPointerException unused) {
                }
            }
        }
    }
}
