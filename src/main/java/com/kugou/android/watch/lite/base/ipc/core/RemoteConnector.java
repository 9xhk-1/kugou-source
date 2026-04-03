package com.kugou.android.watch.lite.base.ipc.core;

import android.app.ActivityManager;
import android.app.Service;
import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.appcompat.widget.ActivityChooserView;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.base.ipc.peripheral.BinderCarrier;
import e.c.a.g.a.d.o.c.h;
import e.c.a.g.a.d.z.b;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.j0;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.t.e;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class RemoteConnector {
    public static boolean a;
    public static Handler b;
    public static boolean c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f36d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f37e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f38f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int f39g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Runnable f40h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static Runnable f41i;

    public static abstract class AdhesiveProvider extends ContentProvider {
        @Override // android.content.ContentProvider
        public Bundle call(@NonNull String str, String str2, Bundle bundle) {
            if (!"method_request_connect".equals(str) || bundle == null) {
                return null;
            }
            if (g0.a) {
                e.c.a.g.a.d.o.e.a.e("receive connect by content provider");
            }
            bundle.setClassLoader(AdhesiveProvider.class.getClassLoader());
            Intent intent = new Intent();
            intent.putExtras(bundle);
            new RemoteConnector().j(intent);
            return null;
        }

        @Override // android.content.ContentProvider
        public boolean onCreate() {
            return true;
        }
    }

    public static class AdhesiveService extends Service {
        @Override // android.app.Service
        public IBinder onBind(Intent intent) {
            return null;
        }

        @Override // android.app.Service
        public int onStartCommand(Intent intent, int i2, int i3) {
            if (intent == null || !"action_request_connect".equals(intent.getAction())) {
                return 2;
            }
            if (g0.a) {
                e.c.a.g.a.d.o.e.a.e("receive connect by service");
            }
            new RemoteConnector().j(intent);
            return 2;
        }
    }

    public class a implements Runnable {
        public final /* synthetic */ Context a;
        public final /* synthetic */ Bundle b;

        public a(RemoteConnector remoteConnector, Context context, Bundle bundle) {
            this.a = context;
            this.b = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.a.getContentResolver().call(e.c.a.g.a.d.o.e.a.d(), "method_request_connect", (String) null, this.b);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public class b implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            RemoteConnector.m(RemoteConnector.f37e);
        }
    }

    public class c implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            RemoteConnector.f39g++;
            RemoteConnector.m(RemoteConnector.f38f);
        }
    }

    public static class d {
        public static final d a = new d();

        public class a implements b.InterfaceC0100b {
            public a() {
            }

            @Override // e.c.a.g.a.d.z.b.InterfaceC0100b
            public void onAppBringToFront(boolean z) {
                d.this.c();
            }

            @Override // e.c.a.g.a.d.z.b.InterfaceC0100b
            public void onAppThrowToBehind(boolean z) {
            }
        }

        public final void b() {
            new RemoteConnector().k();
            h();
        }

        public void c() {
            if (g0.a) {
                e.c.a.g.a.d.o.e.a.e("onAppBringToFront");
            }
            b();
        }

        public void d(boolean z) {
            b();
            if (z) {
                e.c.a.g.a.d.z.a.a().k(new a());
            }
        }

        public void e() {
        }

        public void f() {
            b();
        }

        public void g() {
            if (e.c.a.g.a.d.o.e.a.f()) {
                b();
            }
        }

        public void h() {
            if (!l1.m0()) {
                Log.d("mhs_watch_crash", "startNextServicerSync 非小天才不主动拉起 ");
                return;
            }
            if (Build.VERSION.SDK_INT < 26) {
                Log.d("mhs_watch_crash", "startNextServicerSync 低版本没有语音权限 ");
                return;
            }
            if (!e.a.x()) {
                Log.e("mhs_watch_crash", "开关关闭, name = com.kugou.android.watch.lite.service.MediaService");
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("startNextServicerSync hasStart = ");
            sb.append(RemoteConnector.f36d);
            sb.append("\n, 主线程 = ");
            sb.append(Looper.getMainLooper() == Looper.myLooper());
            Log.e("mhs_watch_crash", sb.toString());
            if (RemoteConnector.f36d) {
                RemoteConnector.b.postDelayed(RemoteConnector.f40h, 3000L);
                return;
            }
            boolean unused = RemoteConnector.f36d = true;
            RemoteConnector.b.removeCallbacks(RemoteConnector.f40h);
            RemoteConnector.b.post(RemoteConnector.f40h);
        }
    }

    static {
        a = e.c.a.g.a.f.e.c.c().getConfigAsInt(e.c.a.g.a.f.e.b.L3, 1) == 1;
        b = new Handler(Looper.getMainLooper());
        c = false;
        f36d = false;
        f37e = 1;
        f38f = 2;
        f39g = 0;
        f40h = new b();
        f41i = new c();
    }

    public static void f() {
        b.removeCallbacks(f41i);
        b.postDelayed(f41i, 5000L);
    }

    public static d h() {
        return d.a;
    }

    public static boolean i() {
        Iterator<ActivityManager.RunningServiceInfo> it = ((ActivityManager) KGApplication.getApplication().getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY)).getRunningServices(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED).iterator();
        while (it.hasNext()) {
            if ("com.kugou.android.watch.lite.service.MediaService".equals(it.next().service.getClassName())) {
                return true;
            }
        }
        return false;
    }

    public static void l() {
        Log.e("mhs_watch_crash", "resetStatue  isEnableAdapterServiceCrash = " + a);
        if (a && e.a.x()) {
            boolean zI = i();
            Log.e("mhs_watch_crash", "resetStatue  isRun = " + zI);
            f39g = 0;
            f36d = false;
            c = false;
            if (zI) {
                b.removeCallbacksAndMessages(null);
            } else {
                b.removeCallbacks(f41i);
            }
        }
    }

    public static void m(int i2) {
        if (!l1.m0()) {
            Log.d("mhs_watch", " 非小天才不主动拉起 ");
            return;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                if (!e.a.x()) {
                    Log.e("mhs_watch", "开关关闭, name = com.kugou.android.watch.lite.service.MediaService");
                    return;
                }
                boolean zI = i();
                Log.e("mhs_watch_crash", "startNextServicer isEnableAdapterServiceCrash = " + a + ", hasAskService = " + c + ", hasStart = " + f36d + ", tryCount = " + f39g + ", source = " + i2 + ", isServiceRunning = " + zI);
                if (zI) {
                    l();
                    Log.e("mhs_watch", "has started retutn serviceInfo.isServiceRunning = true, name = com.kugou.android.watch.lite.service.MediaService");
                    return;
                }
                if (a && c && f39g < 5) {
                    f();
                    Log.e("mhs_watch_crash", "checkRemote.");
                    return;
                }
                PackageManager packageManager = KGApplication.getApplication().getPackageManager();
                ComponentName componentName = new ComponentName(KGApplication.FORE_PROCESS_NAME, "com.kugou.android.watch.lite.service.MediaService");
                try {
                    packageManager.getServiceInfo(componentName, 0);
                    Log.d("mhs_watch", "serviceInfo.packageName = " + componentName);
                    Intent intent = new Intent();
                    intent.setComponent(componentName);
                    if (a) {
                        c = true;
                    }
                    Log.e("mhs_watch_crash", "1 auto start servicer , name = com.kugou.android.watch.lite.service.MediaService, isServiceRunning = " + i());
                    KGApplication.getContext().startForegroundService(intent);
                    Log.e("mhs_watch_crash", "2 auto start servicer , name = com.kugou.android.watch.lite.service.MediaService, isServiceRunning = " + i());
                } catch (PackageManager.NameNotFoundException e2) {
                    Log.e("mhs_watch", "service name not found = " + e2);
                }
            } catch (Exception e3) {
                Log.e("mhs_watch", "startNextServicer e = " + e3);
                e3.printStackTrace();
            }
        }
    }

    public final e.c.a.g.a.d.o.c.b g() {
        return h.h();
    }

    public void j(Intent intent) {
        Bundle extras;
        if (intent == null || (extras = intent.getExtras()) == null) {
            return;
        }
        try {
            g().attachRemote(((BinderCarrier) extras.getParcelable("key_binder_carrier")).a(), true);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    public void k() {
        Context contextB = e.c.a.g.a.d.o.e.a.b();
        Intent intent = new Intent(contextB, e.c.a.g.a.d.o.e.a.c());
        intent.setAction("action_request_connect");
        Bundle bundle = new Bundle();
        bundle.putParcelable("key_binder_carrier", new BinderCarrier(g()));
        intent.putExtras(bundle);
        try {
            contextB.startService(intent);
            if (g0.a) {
                e.c.a.g.a.d.o.e.a.e("startService.");
            }
        } catch (Exception e2) {
            if (g0.a) {
                e.c.a.g.a.d.o.e.a.e("connect by service fail, try content provider");
            }
            e2.printStackTrace();
            j0.b().a(new a(this, contextB, bundle));
        }
    }
}
