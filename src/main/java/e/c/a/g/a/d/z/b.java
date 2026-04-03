package e.c.a.g.a.d.z;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public Integer a;
    public final ArrayList<InterfaceC0100b> b = new ArrayList<>();

    public class a implements Application.ActivityLifecycleCallbacks {
        public int a = 0;

        public a() {
        }

        public final void a() {
            b.this.i();
        }

        public final void b() {
            b.this.j();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            int i2 = this.a + 1;
            this.a = i2;
            if (i2 == 1) {
                a();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            int i2 = this.a - 1;
            this.a = i2;
            if (i2 == 0) {
                b();
            }
        }
    }

    /* JADX INFO: renamed from: e.c.a.g.a.d.z.b$b, reason: collision with other inner class name */
    public interface InterfaceC0100b {
        void onAppBringToFront(boolean z);

        void onAppThrowToBehind(boolean z);
    }

    public void c(@NonNull Application application) {
        application.registerActivityLifecycleCallbacks(e());
    }

    public final Object[] d() {
        Object[] array;
        synchronized (this.b) {
            array = this.b.size() > 0 ? this.b.toArray() : null;
        }
        return array;
    }

    public final Application.ActivityLifecycleCallbacks e() {
        return new a();
    }

    public final void f() {
        Object[] objArrD = d();
        if (objArrD != null) {
            for (Object obj : objArrD) {
                ((InterfaceC0100b) obj).onAppBringToFront(true);
            }
        }
    }

    public final void g() {
        Object[] objArrD = d();
        if (objArrD != null) {
            for (Object obj : objArrD) {
                ((InterfaceC0100b) obj).onAppThrowToBehind(true);
            }
        }
    }

    public boolean h() {
        Integer num = this.a;
        return num != null && num.intValue() == 0;
    }

    public final void i() {
        Log.e("burone-service", "notifyAppBringToFront");
        this.a = 0;
        f();
    }

    public final void j() {
        Log.e("burone-service", "notifyAppThrowToBehind");
        this.a = 8;
        g();
    }

    public void k(InterfaceC0100b interfaceC0100b) {
        synchronized (this.b) {
            if (!this.b.contains(interfaceC0100b)) {
                this.b.add(interfaceC0100b);
            }
        }
        if (this.a != null) {
            if (h()) {
                interfaceC0100b.onAppBringToFront(false);
            } else {
                interfaceC0100b.onAppThrowToBehind(false);
            }
        }
    }
}
