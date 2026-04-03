package qihoo.sdk;

import android.content.Context;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import java.util.concurrent.ConcurrentLinkedQueue;
import qihoo.sdk.a;
import qihoo.sdk.event.OnSystemEventListener;
import qihoo.sdk.widget.WidgetPlayer;
import qihoo.sdk.widget.i.OnPlayWidgetEventListener;

/* JADX INFO: loaded from: classes2.dex */
public final class e {
    public static e a;
    public final Context b;
    public IBinder c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f1735d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public WidgetPlayer f1736e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.qihoo.kidwatch.logger.c f1737f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ConcurrentLinkedQueue<OnSystemEventListener> f1738g = new ConcurrentLinkedQueue<>();

    public class a extends a.AbstractBinderC0280a {
        public OnPlayWidgetEventListener a;

        private a() {
        }

        public /* synthetic */ a(e eVar, byte b) {
            this();
        }

        @Override // qihoo.sdk.a
        public final void a() {
            OnPlayWidgetEventListener onPlayWidgetEventListener = this.a;
            if (onPlayWidgetEventListener != null) {
                onPlayWidgetEventListener.onPre();
            }
        }

        @Override // qihoo.sdk.a
        public final void a(int i2) {
            OnPlayWidgetEventListener onPlayWidgetEventListener = this.a;
            if (onPlayWidgetEventListener != null) {
                onPlayWidgetEventListener.onProgressUpdate(i2);
            }
        }

        @Override // qihoo.sdk.a
        public final void b() {
            OnPlayWidgetEventListener onPlayWidgetEventListener = this.a;
            if (onPlayWidgetEventListener != null) {
                onPlayWidgetEventListener.onNext();
            }
        }

        @Override // qihoo.sdk.a
        public final void c() {
            OnPlayWidgetEventListener onPlayWidgetEventListener = this.a;
            if (onPlayWidgetEventListener != null) {
                onPlayWidgetEventListener.onPause();
            }
        }

        @Override // qihoo.sdk.a
        public final void d() {
            OnPlayWidgetEventListener onPlayWidgetEventListener = this.a;
            if (onPlayWidgetEventListener != null) {
                onPlayWidgetEventListener.onPlay();
            }
        }

        @Override // qihoo.sdk.a
        public final void e() {
            OnPlayWidgetEventListener onPlayWidgetEventListener = this.a;
            if (onPlayWidgetEventListener != null) {
                onPlayWidgetEventListener.onExit();
                e.this.f1736e = null;
            }
        }

        @Override // qihoo.sdk.a
        public final void f() {
            OnPlayWidgetEventListener onPlayWidgetEventListener = this.a;
            if (onPlayWidgetEventListener != null) {
                onPlayWidgetEventListener.onWigetClick();
            }
        }
    }

    public e(Context context) {
        this.b = context.getApplicationContext();
        com.qihoo.kidwatch.logger.c cVarA = com.qihoo.kidwatch.logger.c.a();
        this.f1737f = cVarA;
        cVarA.c = context.getApplicationContext();
        cVarA.b();
    }

    public final String a() {
        return this.b.getResources().getString(this.b.getApplicationInfo().labelRes);
    }

    public final synchronized void a(OnSystemEventListener onSystemEventListener) {
        if (onSystemEventListener != null) {
            if (!this.f1738g.contains(onSystemEventListener)) {
                this.f1738g.add(onSystemEventListener);
            }
        }
    }

    public final boolean a(WidgetPlayer widgetPlayer) throws RemoteException {
        IBinder iBinderA = e.e.a.a.d.b(this.b).a("qihoo_sdk");
        this.c = iBinderA;
        if (iBinderA != null) {
            if (TextUtils.isEmpty(widgetPlayer.a)) {
                widgetPlayer.a = a();
            }
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            parcelObtain.writeInterfaceToken(d.a);
            parcelObtain.writeParcelable(widgetPlayer, 0);
            this.c.transact(11001, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            int i2 = parcelObtain2.readInt();
            parcelObtain2.recycle();
            parcelObtain.recycle();
            if (i2 != 0) {
                return true;
            }
        }
        return false;
    }

    public final synchronized void b(OnSystemEventListener onSystemEventListener) {
        if (onSystemEventListener != null) {
            this.f1738g.remove(onSystemEventListener);
        }
    }
}
