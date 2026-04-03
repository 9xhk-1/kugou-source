package e.c.a.g.a.d.o.d.c;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface c extends IInterface {

    public static abstract class a extends Binder implements c {

        /* JADX INFO: renamed from: e.c.a.g.a.d.o.d.c.c$a$a, reason: collision with other inner class name */
        public static class C0063a implements c {
            public static c b;
            public IBinder a;

            public C0063a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // e.c.a.g.a.d.o.d.c.c
            public void send(int i2, Intent intent) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.kugou.android.watch.lite.base.ipc.iservice.broadcast.IBroadcastSender");
                    parcelObtain.writeInt(i2);
                    if (intent != null) {
                        parcelObtain.writeInt(1);
                        intent.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.a.transact(1, parcelObtain, parcelObtain2, 0) || a.g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.g().send(i2, intent);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.kugou.android.watch.lite.base.ipc.iservice.broadcast.IBroadcastSender");
        }

        public static c a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.kugou.android.watch.lite.base.ipc.iservice.broadcast.IBroadcastSender");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof c)) ? new C0063a(iBinder) : (c) iInterfaceQueryLocalInterface;
        }

        public static c g() {
            return C0063a.b;
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
                parcel2.writeString("com.kugou.android.watch.lite.base.ipc.iservice.broadcast.IBroadcastSender");
                return true;
            }
            parcel.enforceInterface("com.kugou.android.watch.lite.base.ipc.iservice.broadcast.IBroadcastSender");
            send(parcel.readInt(), parcel.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            return true;
        }
    }

    void send(int i2, Intent intent) throws RemoteException;
}
