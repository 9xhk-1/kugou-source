package qihoo.sdk;

import android.content.Context;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemProperties;
import android.text.TextUtils;
import android.util.Log;
import androidx.appcompat.widget.ActivityChooserView;
import qihoo.platform.PlatformManager;
import qihoo.sdk.c;
import qihoo.sdk.e;
import qihoo.sdk.event.OnSystemEventListener;
import qihoo.sdk.widget.WidgetPlayer;
import qihoo.sdk.widget.i.OnPlayWidgetEventListener;

/* JADX INFO: loaded from: classes2.dex */
public class QWatch {
    private static final String a = "QWatch";
    private static QWatch b;
    private static e c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Context f1733d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f1734e;

    private QWatch(Context context) {
        this.f1733d = context.getApplicationContext();
        this.f1734e = context.getPackageName();
        if (e.a == null) {
            e.a = new e(context);
        }
        c = e.a;
    }

    private static void a() {
        if (b == null || c == null) {
            throw new NullPointerException("QWatch instance not init at application onCreate...");
        }
    }

    public static void destroy() {
        if (b != null) {
            b = null;
        }
        if (c != null) {
            c = null;
        }
    }

    public static String getDeviceID(Context context) {
        try {
            String str = SystemProperties.get("persist.qihoo.deviceid");
            return !TextUtils.isEmpty(str) ? str : PlatformManager.getInstance().getDeviceId();
        } catch (NoSuchMethodError e2) {
            e2.printStackTrace();
            Log.e(a, "Has no method PlatformManager.getInstance() " + e2);
            return ((PlatformManager) context.getSystemService("qihoo_platform")).getDeviceId();
        }
    }

    public static synchronized void init(Context context) {
        if (context == null) {
            throw new NullPointerException("init context is null");
        }
        if (b == null) {
            b = new QWatch(context);
        }
    }

    public static void removeOnSystemEventListener(OnSystemEventListener onSystemEventListener) {
        a();
        c.b(onSystemEventListener);
    }

    public static WidgetPlayer requestPlayerFocus(OnPlayWidgetEventListener onPlayWidgetEventListener) {
        a();
        try {
            e eVar = c;
            WidgetPlayer widgetPlayer = eVar.f1736e;
            if (widgetPlayer != null) {
                e.a aVar = eVar.f1735d;
                if (aVar != null) {
                    aVar.a = onPlayWidgetEventListener;
                }
                return widgetPlayer;
            }
            IBinder iBinderA = e.e.a.a.d.b(eVar.b).a("qihoo_sdk");
            eVar.c = iBinderA;
            if (iBinderA != null) {
                c cVarA = c.a.a(iBinderA);
                if (eVar.f1735d == null) {
                    eVar.f1735d = new e.a(eVar, (byte) 0);
                }
                e.a aVar2 = eVar.f1735d;
                aVar2.a = onPlayWidgetEventListener;
                if (cVarA.a(aVar2, eVar.b.getPackageName(), eVar.b.getApplicationInfo().uid, Process.myPid()) == 0) {
                    Context context = eVar.b;
                    WidgetPlayer.a aVar3 = new WidgetPlayer.a();
                    aVar3.a = 0;
                    aVar3.f1745d = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                    aVar3.f1746e = 0;
                    String str = context.getApplicationInfo().name;
                    aVar3.c = str;
                    String unused = WidgetPlayer.f1739i = str;
                    aVar3.b = context.getPackageName();
                    WidgetPlayer widgetPlayer2 = new WidgetPlayer(aVar3, (byte) 0);
                    eVar.f1736e = widgetPlayer2;
                    widgetPlayer2.b = eVar;
                }
            }
            return eVar.f1736e;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static void setOnSystemEventListener(OnSystemEventListener onSystemEventListener) {
        a();
        c.a(onSystemEventListener);
    }
}
