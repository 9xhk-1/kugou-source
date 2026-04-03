package e.c.a.g.a.d.i;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface e extends IInterface {

    public static abstract class a extends Binder implements e {

        /* JADX INFO: renamed from: e.c.a.g.a.d.i.e$a$a, reason: collision with other inner class name */
        public static class C0055a implements e {
            public static e b;
            public IBinder a;

            public C0055a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // e.c.a.g.a.d.i.e
            public void deleteDownloadFile(int[] iArr) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.kugou.android.watch.lite.base.download.IFileManagerService");
                    parcelObtain.writeIntArray(iArr);
                    if (this.a.transact(2, parcelObtain, parcelObtain2, 0) || a.g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.g().deleteDownloadFile(iArr);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // e.c.a.g.a.d.i.e
            public void startDownload(List<KGMusicWrapper> list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.kugou.android.watch.lite.base.download.IFileManagerService");
                    parcelObtain.writeTypedList(list);
                    if (this.a.transact(1, parcelObtain, parcelObtain2, 0) || a.g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.g().startDownload(list);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.kugou.android.watch.lite.base.download.IFileManagerService");
        }

        public static e a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.kugou.android.watch.lite.base.download.IFileManagerService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof e)) ? new C0055a(iBinder) : (e) iInterfaceQueryLocalInterface;
        }

        public static e g() {
            return C0055a.b;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1) {
                parcel.enforceInterface("com.kugou.android.watch.lite.base.download.IFileManagerService");
                startDownload(parcel.createTypedArrayList(KGMusicWrapper.CREATOR));
                parcel2.writeNoException();
                return true;
            }
            if (i2 != 2) {
                if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel2.writeString("com.kugou.android.watch.lite.base.download.IFileManagerService");
                return true;
            }
            parcel.enforceInterface("com.kugou.android.watch.lite.base.download.IFileManagerService");
            deleteDownloadFile(parcel.createIntArray());
            parcel2.writeNoException();
            return true;
        }
    }

    void deleteDownloadFile(int[] iArr) throws RemoteException;

    void startDownload(List<KGMusicWrapper> list) throws RemoteException;
}
