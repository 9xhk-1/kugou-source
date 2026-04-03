package e.c.a.g.a.d.o.c;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public class i {

    public static abstract class a extends Binder implements e.c.a.g.a.d.o.c.b {
        public a() {
            attachInterface(this, "com.kugou.framework.service.ipc.core.IServiceManagerService");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1598968902) {
                parcel2.writeString("com.kugou.framework.service.ipc.core.IServiceManagerService");
                return true;
            }
            switch (i2) {
                case 1:
                    parcel.enforceInterface("com.kugou.framework.service.ipc.core.IServiceManagerService");
                    attachRemote(parcel.readStrongBinder(), parcel.readInt() == 1);
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.kugou.framework.service.ipc.core.IServiceManagerService");
                    addService(parcel.readString(), parcel.readStrongBinder(), parcel.readInt() == 1);
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.kugou.framework.service.ipc.core.IServiceManagerService");
                    IBinder iBinderPickService = pickService(parcel.readString(), parcel.readInt() == 1);
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(iBinderPickService);
                    return true;
                case 4:
                    parcel.enforceInterface("com.kugou.framework.service.ipc.core.IServiceManagerService");
                    IBinder service = getService(parcel.readString(), parcel.readInt() == 1);
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(service);
                    return true;
                case 5:
                    parcel.enforceInterface("com.kugou.framework.service.ipc.core.IServiceManagerService");
                    IBinder twin = getTwin(parcel.readString(), parcel.readInt() == 1);
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(twin);
                    return true;
                case 6:
                    parcel.enforceInterface("com.kugou.framework.service.ipc.core.IServiceManagerService");
                    notifyServiceManuallyAdded(parcel.createStringArray(), parcel.readInt() == 1);
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }
    }

    public static class b implements e.c.a.g.a.d.o.c.b {
        public IBinder a;

        public b(IBinder iBinder) {
            this.a = iBinder;
        }

        @Override // e.c.a.g.a.d.o.c.b
        public void addService(String str, IBinder iBinder, boolean z) throws RemoteException {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.kugou.framework.service.ipc.core.IServiceManagerService");
                parcelObtain.writeString(str);
                parcelObtain.writeStrongBinder(iBinder);
                parcelObtain.writeInt(z ? 1 : 0);
                this.a.transact(2, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.a;
        }

        @Override // e.c.a.g.a.d.o.c.b
        public void attachRemote(IBinder iBinder, boolean z) throws RemoteException {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.kugou.framework.service.ipc.core.IServiceManagerService");
                parcelObtain.writeStrongBinder(iBinder);
                parcelObtain.writeInt(z ? 1 : 0);
                this.a.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }

        @Override // e.c.a.g.a.d.o.c.b
        public IBinder getService(String str, boolean z) throws RemoteException {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.kugou.framework.service.ipc.core.IServiceManagerService");
                parcelObtain.writeString(str);
                parcelObtain.writeInt(z ? 1 : 0);
                this.a.transact(4, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readStrongBinder();
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }

        @Override // e.c.a.g.a.d.o.c.b
        public IBinder getTwin(String str, boolean z) throws RemoteException {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.kugou.framework.service.ipc.core.IServiceManagerService");
                parcelObtain.writeString(str);
                parcelObtain.writeInt(z ? 1 : 0);
                this.a.transact(5, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readStrongBinder();
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }

        @Override // e.c.a.g.a.d.o.c.b
        public boolean isRemoteValidate() throws IllegalAccessException {
            throw new IllegalAccessException("Can not call this on a proxy object");
        }

        @Override // e.c.a.g.a.d.o.c.b
        public void notifyServiceManuallyAdded(String[] strArr, boolean z) throws RemoteException {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.kugou.framework.service.ipc.core.IServiceManagerService");
                parcelObtain.writeStringArray(strArr);
                parcelObtain.writeInt(z ? 1 : 0);
                this.a.transact(6, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }

        @Override // e.c.a.g.a.d.o.c.b
        public IBinder pickService(String str, boolean z) throws RemoteException {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.kugou.framework.service.ipc.core.IServiceManagerService");
                parcelObtain.writeString(str);
                parcelObtain.writeInt(z ? 1 : 0);
                this.a.transact(3, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readStrongBinder();
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }

        @Override // e.c.a.g.a.d.o.c.b
        public void setManuallyAddCallback(d dVar) throws IllegalAccessException {
            throw new IllegalAccessException("Can not call this on a proxy object");
        }

        @Override // e.c.a.g.a.d.o.c.b
        public void setRemoteAttachStateCallback(e eVar) throws IllegalAccessException {
            throw new IllegalAccessException("Can not call this on a proxy object");
        }
    }

    public static e.c.a.g.a.d.o.c.b a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.kugou.framework.service.ipc.core.IServiceManagerService");
        return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof e.c.a.g.a.d.o.c.b)) ? new b(iBinder) : (e.c.a.g.a.d.o.c.b) iInterfaceQueryLocalInterface;
    }
}
