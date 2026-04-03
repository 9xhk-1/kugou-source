package e.g.c;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public interface b extends IInterface {

    public static abstract class a extends Binder implements b {
        public a() {
            attachInterface(this, "com.xtc.opendataapi.IOpenDataCallback");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 != 1) {
                if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel2.writeString("com.xtc.opendataapi.IOpenDataCallback");
                return true;
            }
            parcel.enforceInterface("com.xtc.opendataapi.IOpenDataCallback");
            onResult(parcel.readString(), parcel.readString(), parcel.readString());
            parcel2.writeNoException();
            return true;
        }
    }

    void onResult(String str, String str2, String str3) throws RemoteException;
}
