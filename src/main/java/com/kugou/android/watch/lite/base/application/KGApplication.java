package com.kugou.android.watch.lite.base.application;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import androidx.multidex.MultiDex;
import e.c.a.g.a.d.c.b;
import e.c.a.g.a.d.d0.c;
import e.c.a.g.a.s.d;
import e.c.a.g.a.s.f1;

/* JADX INFO: loaded from: classes.dex */
public class KGApplication extends Application {
    private static final int BACK_SUPPORT_PROCESS = 0;
    private static final int FORE_PROCESS = 1;
    public static final String FORE_PROCESS_NAME = "com.kugou.android.watch.lite";
    private static b mKGAppImpl;
    public static final String TAG = KGApplication.class.getName();
    private static int processType = -1;
    public static int sOrientation = 2;
    public static f1 sScreenSize = new f1(0, 0);
    public static Boolean isFirstStartAfterInstall = null;
    public static Boolean isCoverInstall = null;

    public static void destroyServer() {
        mKGAppImpl.i();
    }

    public static void exit() {
        mKGAppImpl.j();
    }

    public static Application getApplication() {
        return mKGAppImpl.k();
    }

    public static Context getContext() {
        return mKGAppImpl.l();
    }

    public static int getDefaultOrientation() {
        return sOrientation;
    }

    public static f1 getDefaultSize() {
        return sScreenSize;
    }

    private void initProcessType() {
        String strC = d.c(this);
        if (FORE_PROCESS_NAME.equals(strC)) {
            processType = 1;
        } else {
            processType = -1;
        }
        Log.i(TAG, "initProcessType " + strC + ", " + processType);
    }

    public static boolean isForeProcess() {
        return processType == 1;
    }

    public static void onPermissionGranted() {
        mKGAppImpl.f();
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        MultiDex.install(this);
        initProcessType();
        b bVar = new b();
        mKGAppImpl = bVar;
        bVar.g(this);
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        mKGAppImpl.r();
    }

    @Override // android.app.Application
    public void onTerminate() {
        super.onTerminate();
        c.a.s();
    }
}
