package e.g.c.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.xtc.payapi.constants.PayConstant;
import com.xtc.payapi.contact.BaseResponse;
import e.g.c.a;
import e.g.c.b;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static final String b = "openData_sdk" + a.class.getSimpleName();
    public Context a;

    /* JADX INFO: renamed from: e.g.c.c.a$a, reason: collision with other inner class name */
    public class ServiceConnectionC0263a implements ServiceConnection {
        public final /* synthetic */ b a;

        public ServiceConnectionC0263a(b bVar) {
            this.a = bVar;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.d(a.b, "getAgeRange onServiceConnected : " + componentName);
            try {
                try {
                    a.AbstractBinderC0261a.a(iBinder).getAgeRange(this.a);
                } catch (RemoteException e2) {
                    Log.d(a.b, "getAgeRange error  ", e2);
                    a.this.e(this.a, "get age range remote exception!", BaseResponse.Code.ERROR_OTHER);
                }
            } finally {
                a.this.a.unbindService(this);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Log.d(a.b, "onServiceDisconnected : " + componentName);
        }
    }

    public a(Context context) {
        this.a = context;
    }

    public void d(b bVar) {
        if (!e.g.c.d.a.a(this.a, PayConstant.HostAppInfo.HOST_PACKAGE_NAME)) {
            e(bVar, "Please update the watch settings to the latest version", "-4");
            return;
        }
        Intent intent = new Intent("com.xtc.opendata.openid.service");
        intent.putExtra("openDataType", "ageRange");
        intent.setPackage(PayConstant.HostAppInfo.HOST_PACKAGE_NAME);
        this.a.bindService(intent, new ServiceConnectionC0263a(bVar), 1);
    }

    public final void e(b bVar, String str, String str2) {
        try {
            bVar.onResult(str2, str, null);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            Log.e(b, "callback result exception:", e2);
        }
    }
}
