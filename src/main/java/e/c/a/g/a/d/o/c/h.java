package e.c.a.g.a.d.o.c;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.Nullable;
import com.kugou.android.watch.lite.base.ipc.core.RemoteConnector;
import e.c.a.g.a.d.o.c.i;
import e.c.a.g.a.s.f0;
import e.c.a.g.a.s.g0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class h extends i.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile h f461g;
    public e.c.a.g.a.d.o.c.b b;
    public final c c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b f464f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<String, IBinder> f462d = new ConcurrentHashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<String> f463e = new ArrayList();
    public e.c.a.g.a.d.o.c.a a = e.c.a.g.a.d.o.e.a.a();

    public class a implements IBinder.DeathRecipient {
        public final /* synthetic */ IBinder a;

        public a(IBinder iBinder) {
            this.a = iBinder;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            h.this.o(this.a);
        }
    }

    public class b {
        public e a;
        public d b;

        public b() {
        }

        public void a(e.c.a.g.a.d.o.c.b bVar, List<String> list) throws RemoteException {
            e eVar = this.a;
            if (eVar != null) {
                eVar.onAttachStateChanged(true);
            }
            String[] strArr = (String[]) list.toArray(new String[list.size()]);
            if (strArr.length > 0) {
                if (g0.a) {
                    e.c.a.g.a.d.o.e.a.e("send pending manually Services : " + Arrays.deepToString(strArr));
                }
                bVar.notifyServiceManuallyAdded(strArr, false);
            }
        }

        public void b() {
            e eVar = this.a;
            if (eVar != null) {
                eVar.onAttachStateChanged(false);
            }
        }

        public void c(String[] strArr, boolean z) {
            if (this.b != null) {
                for (String str : strArr) {
                    this.b.onManuallyAdd(str);
                }
            }
            if (z) {
                h hVar = h.this;
                if (hVar.l(hVar.b)) {
                    try {
                        h.this.b.notifyServiceManuallyAdded(strArr, false);
                    } catch (RemoteException | NullPointerException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }

        public void d(d dVar) {
            this.b = dVar;
        }

        public void e(e eVar) {
            this.a = eVar;
        }

        public /* synthetic */ b(h hVar, a aVar) {
            this();
        }
    }

    public h() {
        a aVar = null;
        this.c = new c(this, aVar);
        this.f464f = new b(this, aVar);
    }

    public static h h() {
        if (f461g == null) {
            synchronized (h.class) {
                if (f461g == null) {
                    f461g = new h();
                }
            }
        }
        return f461g;
    }

    public static void m(String str) {
        Log.d("burone-service", str);
    }

    @Override // e.c.a.g.a.d.o.c.b
    public void addService(String str, IBinder iBinder, boolean z) {
        f0.b(k(str));
        this.f462d.put(str, iBinder);
        if (z) {
            if (l(this.b)) {
                try {
                    this.b.addService(str, iBinder, false);
                } catch (RemoteException | NullPointerException e2) {
                    e2.printStackTrace();
                }
            }
            n(str);
        }
    }

    @Override // e.c.a.g.a.d.o.c.b
    public void attachRemote(IBinder iBinder, boolean z) throws RemoteException {
        synchronized (this.c.c()) {
            if (l(this.b) && this.b.asBinder() == iBinder) {
                m("Duplicate attach, ignore ... ");
                return;
            }
            iBinder.linkToDeath(new a(iBinder), 0);
            g();
            this.b = i.a(iBinder);
            m("I got the remoteManager !! ");
            e.c.a.g.a.d.o.c.b bVar = this.b;
            if (bVar == null) {
                return;
            }
            if (z) {
                bVar.attachRemote(this, false);
            }
            this.f464f.a(bVar, this.f463e);
        }
    }

    public final void g() {
        Iterator<IBinder> it = this.f462d.values().iterator();
        while (it.hasNext()) {
            IBinder next = it.next();
            if (i(next)) {
                it.remove();
            } else if (j(next)) {
                ((e.c.a.g.a.d.o.c.c) next).detachRemoteTwin();
            }
        }
    }

    @Override // e.c.a.g.a.d.o.c.b
    public IBinder getService(String str, boolean z) {
        f0.b(k(str));
        if (str == null) {
            return null;
        }
        IBinder service = this.f462d.get(str);
        if (service == null) {
            synchronized (this.c.b(str)) {
                service = this.f462d.get(str);
                if (service == null) {
                    e.c.a.g.a.d.o.c.a aVar = this.a;
                    if (aVar != null) {
                        service = aVar.createService(str);
                    }
                    if (service != null) {
                        this.f462d.put(str, service);
                    }
                }
            }
            if (service == null && z && l(this.b)) {
                synchronized (this.c.d(str)) {
                    service = this.f462d.get(str);
                    if (service == null) {
                        m("remote is validate, call it");
                        try {
                            service = this.b.getService(str, false);
                            if (service != null) {
                                this.f462d.put(str, service);
                            }
                        } catch (RemoteException | NullPointerException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        }
        return service;
    }

    @Override // e.c.a.g.a.d.o.c.b
    public IBinder getTwin(String str, boolean z) {
        f0.g(k(str));
        IBinder iBinderCreateTwin = this.f462d.get(str);
        if (iBinderCreateTwin == null) {
            synchronized (this.c.b(str)) {
                iBinderCreateTwin = this.f462d.get(str);
                if (iBinderCreateTwin == null && (iBinderCreateTwin = this.a.createTwin(str)) != null) {
                    this.f462d.put(str, iBinderCreateTwin);
                }
            }
        }
        e.c.a.g.a.d.o.c.c cVar = (e.c.a.g.a.d.o.c.c) iBinderCreateTwin;
        if (z && cVar != null && !cVar.isRemoteAttached() && l(this.b)) {
            synchronized (this.c.d(str)) {
                if (!cVar.isRemoteAttached()) {
                    try {
                        IBinder twin = this.b.getTwin(str, false);
                        if (twin != null) {
                            cVar.attachRemoteTwin(twin);
                        }
                    } catch (RemoteException | NullPointerException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
        return iBinderCreateTwin;
    }

    public final boolean i(@Nullable IBinder iBinder) {
        return !(iBinder instanceof Binder);
    }

    @Override // e.c.a.g.a.d.o.c.b
    public boolean isRemoteValidate() {
        return l(this.b);
    }

    public final boolean j(IBinder iBinder) {
        return iBinder instanceof e.c.a.g.a.d.o.c.c;
    }

    public final boolean k(String str) {
        return e.c.a.g.a.d.o.a.a(str);
    }

    public final boolean l(@Nullable IInterface iInterface) {
        return iInterface != null && iInterface.asBinder().isBinderAlive();
    }

    public final void n(String str) {
        this.f463e.add(str);
        notifyServiceManuallyAdded(new String[]{str}, true);
    }

    @Override // e.c.a.g.a.d.o.c.b
    public void notifyServiceManuallyAdded(String[] strArr, boolean z) {
        this.f464f.c(strArr, z);
    }

    public final void o(IBinder iBinder) {
        synchronized (this.c.c()) {
            m("remote died");
            e.c.a.g.a.d.o.c.b bVar = this.b;
            if (bVar != null && bVar.asBinder() != iBinder) {
                m("current remoteMgr is not the dead, ignore");
                return;
            }
            this.b = null;
            g();
            this.f464f.b();
            RemoteConnector.h().g();
        }
    }

    @Override // e.c.a.g.a.d.o.c.b
    public IBinder pickService(String str, boolean z) throws RemoteException {
        f0.b(k(str));
        IBinder iBinder = this.f462d.get(str);
        return (iBinder == null && z && l(this.b)) ? this.b.pickService(str, false) : iBinder;
    }

    @Override // e.c.a.g.a.d.o.c.b
    public void setManuallyAddCallback(d dVar) {
        this.f464f.d(dVar);
    }

    @Override // e.c.a.g.a.d.o.c.b
    public void setRemoteAttachStateCallback(e eVar) {
        this.f464f.e(eVar);
    }

    public class c {
        public final Object a;
        public Map<String, Object> b;

        public c(h hVar) {
            this.a = new Object();
            this.b = new ConcurrentHashMap();
        }

        public final Object a(String str) {
            Object obj = this.b.get(str);
            if (obj == null) {
                synchronized (this) {
                    obj = this.b.get(str);
                    if (obj == null) {
                        obj = new Object();
                        this.b.put(str, obj);
                    }
                }
            }
            return obj;
        }

        public Object b(String str) {
            return a("LL:" + str);
        }

        public Object c() {
            return this.a;
        }

        public Object d(String str) {
            return a("RL:" + str);
        }

        public /* synthetic */ c(h hVar, a aVar) {
            this(hVar);
        }
    }
}
