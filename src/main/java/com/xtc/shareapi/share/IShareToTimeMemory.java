package com.xtc.shareapi.share;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.xtc.shareapi.share.ISilentlyShareCallback;

/* JADX INFO: loaded from: classes2.dex */
public interface IShareToTimeMemory extends IInterface {

    public static class Default implements IShareToTimeMemory {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.xtc.shareapi.share.IShareToTimeMemory
        public void sharePicture(String str, ISilentlyShareCallback iSilentlyShareCallback) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IShareToTimeMemory {
        private static final String DESCRIPTOR = "com.xtc.shareapi.share.IShareToTimeMemory";
        public static final int TRANSACTION_sharePicture = 1;

        public static class Proxy implements IShareToTimeMemory {
            public static IShareToTimeMemory sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.xtc.shareapi.share.IShareToTimeMemory
            public void sharePicture(String str, ISilentlyShareCallback iSilentlyShareCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iSilentlyShareCallback != null ? iSilentlyShareCallback.asBinder() : null);
                    if (this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().sharePicture(str, iSilentlyShareCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IShareToTimeMemory asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IShareToTimeMemory)) ? new Proxy(iBinder) : (IShareToTimeMemory) iInterfaceQueryLocalInterface;
        }

        public static IShareToTimeMemory getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IShareToTimeMemory iShareToTimeMemory) {
            if (Proxy.sDefaultImpl != null || iShareToTimeMemory == null) {
                return false;
            }
            Proxy.sDefaultImpl = iShareToTimeMemory;
            return true;
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
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            sharePicture(parcel.readString(), ISilentlyShareCallback.Stub.asInterface(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }
    }

    void sharePicture(String str, ISilentlyShareCallback iSilentlyShareCallback) throws RemoteException;
}
