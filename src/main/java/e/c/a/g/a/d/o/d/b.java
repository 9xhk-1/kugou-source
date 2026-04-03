package e.c.a.g.a.d.o.d;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public abstract class b extends Binder implements IInterface {
    public b() {
        attachInterface(this, "com.kugou.android.watch.lite.base.ipc.iservice.IAckService");
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 != 1598968902) {
            return super.onTransact(i2, parcel, parcel2, i3);
        }
        parcel2.writeString("com.kugou.android.watch.lite.base.ipc.iservice.IAckService");
        return true;
    }
}
