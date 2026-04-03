package e.c.a.g.a.d.o.f;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: e.c.a.g.a.d.o.f.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0065a extends Binder implements a {

        /* JADX INFO: renamed from: e.c.a.g.a.d.o.f.a$a$a, reason: collision with other inner class name */
        public static class C0066a implements a {
            public static a b;
            public IBinder a;

            public C0066a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // e.c.a.g.a.d.o.f.a
            public void call(int i2, String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.kugou.android.watch.lite.base.ipc.piercecaller.IPierceCaller");
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (this.a.transact(1, parcelObtain, parcelObtain2, 0) || AbstractBinderC0065a.g() == null) {
                        parcelObtain2.readException();
                    } else {
                        AbstractBinderC0065a.g().call(i2, str, str2);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // e.c.a.g.a.d.o.f.a
            public void call2(int i2, String str, String str2, int i3) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.kugou.android.watch.lite.base.ipc.piercecaller.IPierceCaller");
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeInt(i3);
                    if (this.a.transact(2, parcelObtain, parcelObtain2, 0) || AbstractBinderC0065a.g() == null) {
                        parcelObtain2.readException();
                    } else {
                        AbstractBinderC0065a.g().call2(i2, str, str2, i3);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // e.c.a.g.a.d.o.f.a
            public void call3(int i2, String str, String str2, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.kugou.android.watch.lite.base.ipc.piercecaller.IPierceCaller");
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.a.transact(3, parcelObtain, parcelObtain2, 0) && AbstractBinderC0065a.g() != null) {
                        AbstractBinderC0065a.g().call3(i2, str, str2, bundle);
                        return;
                    }
                    parcelObtain2.readException();
                    if (parcelObtain2.readInt() != 0) {
                        bundle.readFromParcel(parcelObtain2);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // e.c.a.g.a.d.o.f.a
            public void call4(int i2, String str, String str2, int i3, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.kugou.android.watch.lite.base.ipc.piercecaller.IPierceCaller");
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeInt(i3);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.a.transact(4, parcelObtain, parcelObtain2, 0) && AbstractBinderC0065a.g() != null) {
                        AbstractBinderC0065a.g().call4(i2, str, str2, i3, bundle);
                        return;
                    }
                    parcelObtain2.readException();
                    if (parcelObtain2.readInt() != 0) {
                        bundle.readFromParcel(parcelObtain2);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public AbstractBinderC0065a() {
            attachInterface(this, "com.kugou.android.watch.lite.base.ipc.piercecaller.IPierceCaller");
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.kugou.android.watch.lite.base.ipc.piercecaller.IPierceCaller");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0066a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        public static a g() {
            return C0066a.b;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1) {
                parcel.enforceInterface("com.kugou.android.watch.lite.base.ipc.piercecaller.IPierceCaller");
                call(parcel.readInt(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            if (i2 == 2) {
                parcel.enforceInterface("com.kugou.android.watch.lite.base.ipc.piercecaller.IPierceCaller");
                call2(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                return true;
            }
            if (i2 == 3) {
                parcel.enforceInterface("com.kugou.android.watch.lite.base.ipc.piercecaller.IPierceCaller");
                int i4 = parcel.readInt();
                String string = parcel.readString();
                String string2 = parcel.readString();
                Bundle bundle = parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null;
                call3(i4, string, string2, bundle);
                parcel2.writeNoException();
                if (bundle != null) {
                    parcel2.writeInt(1);
                    bundle.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            }
            if (i2 != 4) {
                if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel2.writeString("com.kugou.android.watch.lite.base.ipc.piercecaller.IPierceCaller");
                return true;
            }
            parcel.enforceInterface("com.kugou.android.watch.lite.base.ipc.piercecaller.IPierceCaller");
            int i5 = parcel.readInt();
            String string3 = parcel.readString();
            String string4 = parcel.readString();
            int i6 = parcel.readInt();
            Bundle bundle2 = parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null;
            call4(i5, string3, string4, i6, bundle2);
            parcel2.writeNoException();
            if (bundle2 != null) {
                parcel2.writeInt(1);
                bundle2.writeToParcel(parcel2, 1);
            } else {
                parcel2.writeInt(0);
            }
            return true;
        }
    }

    void call(int i2, String str, String str2) throws RemoteException;

    void call2(int i2, String str, String str2, int i3) throws RemoteException;

    void call3(int i2, String str, String str2, Bundle bundle) throws RemoteException;

    void call4(int i2, String str, String str2, int i3, Bundle bundle) throws RemoteException;
}
