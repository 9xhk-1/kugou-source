package com.qihoo.kidwatch.logger;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.util.Log;
import com.kugou.common.network.retrystatics.RetryStaticsLOG;
import com.kugou.framework.libcommon.netcore.BaseConnection;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    public static String a = "content://com.qihoo.kidwatch.qihoolog";
    public static String b = "com.qihoo.kidwatch";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static com.qihoo.kidwatch.logger.a f258d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile c f259e;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private HandlerThread f263i;
    private Handler j;
    private final int k = 200;
    public Context c = null;
    private IBinder l = null;
    private long m = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private com.qihoo.kidwatch.logger.b<a> f261g = new com.qihoo.kidwatch.logger.b<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private com.qihoo.kidwatch.logger.b<String> f262h = new com.qihoo.kidwatch.logger.b<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private StringBuffer f260f = new StringBuffer();

    public final class a {
        public String a;
        public String b;
    }

    public class b<T> implements Runnable {
        private com.qihoo.kidwatch.logger.b<T> b;
        private int c;

        public b(int i2, com.qihoo.kidwatch.logger.b<T> bVar) {
            this.c = 0;
            this.c = i2;
            this.b = bVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int i2 = this.c;
            if (i2 == 1) {
                while (!this.b.a()) {
                    try {
                        a aVar = (a) this.b.a.poll();
                        if (c.f258d != null) {
                            Log.d("QihooLoggerManager", "TaskRunnable general:" + aVar.a + RetryStaticsLOG.MARK_SEPERATE + aVar.b);
                            c.f258d.a(aVar.a, aVar.b);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return;
                    }
                }
                return;
            }
            if (i2 != 2) {
                return;
            }
            while (!this.b.a()) {
                try {
                    String[] strArrSplit = ((String) this.b.a.poll()).trim().split(BaseConnection.HTTP_REQ_ENTITY_JOIN);
                    if (c.f258d != null) {
                        Log.d("QihooLoggerManager", "TaskRunnable record: " + strArrSplit[0] + " : " + strArrSplit[1]);
                        c.f258d.a(Integer.valueOf(strArrSplit[0]).intValue(), Integer.valueOf(strArrSplit[1]).intValue());
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
            }
        }
    }

    private c() {
    }

    public static c a() {
        if (f259e == null) {
            synchronized (c.class) {
                if (f259e == null) {
                    f259e = new c();
                }
            }
        }
        return f259e;
    }

    private void d() {
        if (this.j == null) {
            HandlerThread handlerThread = new HandlerThread("QihooLoggerManagerThread");
            this.f263i = handlerThread;
            handlerThread.start();
            this.j = new Handler(this.f263i.getLooper());
        }
    }

    public final synchronized void b() {
        try {
            if (this.c != null) {
                if (!(System.currentTimeMillis() - this.m < 1000)) {
                    this.m = System.currentTimeMillis();
                    Bundle bundleCall = this.c.getContentResolver().call(Uri.parse("content://com.qihoo.kidwatch.qihoolog" + File.separator + "binder"), "getBinder", (String) null, (Bundle) null);
                    bundleCall.setClassLoader(getClass().getClassLoader());
                    BinderParcel binderParcel = (BinderParcel) bundleCall.getParcelable("TAG_PUT_BUNDLE");
                    if (binderParcel != null) {
                        f258d = binderParcel.getService();
                        if (!this.f261g.a()) {
                            d();
                            this.j.post(new b(1, this.f261g));
                        }
                        if (!this.f262h.a()) {
                            d();
                            this.j.post(new b(2, this.f262h));
                        }
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
