package e.e.a.a;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.qihoo360.kidwatch.binder.BinderParcel;
import e.e.a.a.b;
import e.e.a.a.c;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static d f1315g;
    public Context a;
    public HashMap<String, IBinder> b = new HashMap<>();
    public HashMap<String, Object> c = new HashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Set<String> f1316d = Collections.synchronizedSet(new HashSet());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public IBinder f1317e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Handler f1318f;

    public class a extends ContentObserver {
        public a(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public final void onChange(boolean z, Uri uri) {
            super.onChange(z);
            Log.d("QihooServiceManager", "[mBinderChangeObserver][onChange] uri:" + uri);
            if (uri != null) {
                d.this.f1316d.add(uri.getLastPathSegment());
                if (d.this.f1318f.hasMessages(17)) {
                    return;
                }
                d.this.f1318f.sendEmptyMessage(17);
            }
        }
    }

    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            if (message.what == 17 && d.this.f1316d.size() > 0) {
                String str = (String) d.this.f1316d.iterator().next();
                d.this.c.get(str);
                d.this.f1316d.remove(str);
                if (hasMessages(17)) {
                    removeMessages(17);
                }
                sendEmptyMessage(17);
            }
        }
    }

    public d(Context context) {
        new a(new Handler(Looper.getMainLooper()));
        this.f1318f = new b(Looper.getMainLooper());
        this.a = context;
        d();
    }

    public static d b(Context context) {
        if (f1315g == null) {
            synchronized (d.class) {
                if (f1315g == null) {
                    f1315g = new d(context.getApplicationContext());
                }
            }
        }
        return f1315g;
    }

    public final IBinder a(String str) {
        e.e.a.a.b bVarA;
        String str2;
        IBinder iBinder = this.b.get(str);
        if (iBinder != null && iBinder.isBinderAlive() && iBinder.pingBinder()) {
            return iBinder;
        }
        for (int i2 = 0; i2 < 3; i2++) {
            IBinder iBinder2 = this.f1317e;
            if (iBinder2 != null && iBinder2.pingBinder() && this.f1317e.isBinderAlive() && (bVarA = b.a.a(this.f1317e)) != null) {
                try {
                    BinderParcel binderParcelA = bVarA.a(str);
                    if (binderParcelA == null) {
                        return null;
                    }
                    this.b.put(str, binderParcelA.a);
                    return binderParcelA.a;
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    str2 = "binder pipe died! reget it";
                    Log.e("QihooServiceManager", str2);
                    d();
                } catch (Exception e3) {
                    e3.printStackTrace();
                    str2 = "getService error!" + e3;
                    Log.e("QihooServiceManager", str2);
                    d();
                }
            }
            d();
        }
        return null;
    }

    public final void d() {
        try {
            Log.d("QihooServiceManager", "getBinderPipe.....");
            Cursor cursorQuery = this.a.getContentResolver().query(c.a.a, null, null, null, null);
            this.f1317e = e.e.a.a.a.a(cursorQuery);
            if (cursorQuery != null && !cursorQuery.isClosed()) {
                cursorQuery.close();
            }
            Log.d("QihooServiceManager", "get the binder pipe by provider:" + this.f1317e);
        } catch (Exception e2) {
            Log.e("QihooServiceManager", "get the binder pipe by provider error:" + e2);
        }
    }
}
