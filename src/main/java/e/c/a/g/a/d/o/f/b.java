package e.c.a.g.a.d.o.f;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import e.c.a.g.a.d.o.e.a;
import e.c.a.g.a.d.o.f.a;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* JADX INFO: loaded from: classes.dex */
public class b extends a.AbstractBinderC0065a implements e.c.a.g.a.d.o.c.c {
    public a a = new a(this);
    public e.c.a.g.a.d.o.f.a b;

    public class a {
        public a(b bVar) {
        }

        public void a(String str, String str2) throws RemoteException {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            try {
                Class<?> cls = Class.forName(str);
                Method declaredMethod = cls.getDeclaredMethod(str2, new Class[0]);
                declaredMethod.invoke(e(cls, declaredMethod), new Object[0]);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        public void b(String str, String str2, int i2) throws RemoteException {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            try {
                Class<?> cls = Class.forName(str);
                Method declaredMethod = cls.getDeclaredMethod(str2, Integer.TYPE);
                declaredMethod.invoke(e(cls, declaredMethod), Integer.valueOf(i2));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        public void c(String str, String str2, int i2, Bundle bundle) throws RemoteException {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            try {
                Class<?> cls = Class.forName(str);
                Method declaredMethod = cls.getDeclaredMethod(str2, Integer.TYPE, Bundle.class);
                declaredMethod.invoke(e(cls, declaredMethod), Integer.valueOf(i2), bundle);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        public void d(String str, String str2, Bundle bundle) throws RemoteException {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            try {
                Class<?> cls = Class.forName(str);
                Method declaredMethod = cls.getDeclaredMethod(str2, Bundle.class);
                declaredMethod.invoke(e(cls, declaredMethod), bundle);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        public final Object e(Class cls, Method method) throws Exception {
            if (Modifier.isStatic(method.getModifiers())) {
                return null;
            }
            return cls.newInstance();
        }
    }

    @Override // e.c.a.g.a.d.o.c.c
    public void attachRemoteTwin(IBinder iBinder) {
        if (iBinder != null) {
            this.b = a.AbstractBinderC0065a.a(iBinder);
        }
    }

    @Override // e.c.a.g.a.d.o.f.a
    public void call(int i2, String str, String str2) throws RemoteException {
        if (a.C0064a.a(i2)) {
            this.a.a(str, str2);
        }
        if (a.C0064a.b(i2) && isRemoteAttached()) {
            try {
                this.b.call(1, str, str2);
            } catch (NullPointerException unused) {
            }
        }
    }

    @Override // e.c.a.g.a.d.o.f.a
    public void call2(int i2, String str, String str2, int i3) throws RemoteException {
        if (a.C0064a.a(i2)) {
            this.a.b(str, str2, i3);
        }
        if (a.C0064a.b(i2) && isRemoteAttached()) {
            try {
                this.b.call2(1, str, str2, i3);
            } catch (NullPointerException unused) {
            }
        }
    }

    @Override // e.c.a.g.a.d.o.f.a
    public void call3(int i2, String str, String str2, Bundle bundle) throws RemoteException {
        if (bundle != null) {
            bundle.setClassLoader(b.class.getClassLoader());
        }
        if (a.C0064a.a(i2)) {
            this.a.d(str, str2, bundle);
        }
        if (a.C0064a.b(i2) && isRemoteAttached()) {
            try {
                this.b.call3(1, str, str2, bundle);
            } catch (NullPointerException unused) {
            }
        }
    }

    @Override // e.c.a.g.a.d.o.f.a
    public void call4(int i2, String str, String str2, int i3, Bundle bundle) throws RemoteException {
        if (bundle != null) {
            bundle.setClassLoader(b.class.getClassLoader());
        }
        if (a.C0064a.a(i2)) {
            this.a.c(str, str2, i3, bundle);
        }
        if (a.C0064a.b(i2) && isRemoteAttached()) {
            try {
                this.b.call4(1, str, str2, i3, bundle);
            } catch (NullPointerException unused) {
            }
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
}
