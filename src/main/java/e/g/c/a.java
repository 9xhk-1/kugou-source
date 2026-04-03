package e.g.c;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: e.g.c.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0261a extends Binder implements a {

        /* JADX INFO: renamed from: e.g.c.a$a$a, reason: collision with other inner class name */
        public static class C0262a implements a {
            public static a b;
            public IBinder a;

            public C0262a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // e.g.c.a
            public void getAgeRange(b bVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.xtc.opendataapi.IOpenData");
                    parcelObtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    if (this.a.transact(1, parcelObtain, parcelObtain2, 0) || AbstractBinderC0261a.g() == null) {
                        parcelObtain2.readException();
                    } else {
                        AbstractBinderC0261a.g().getAgeRange(bVar);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.xtc.opendataapi.IOpenData");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0262a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        public static a g() {
            return C0262a.b;
        }
    }

    void getAgeRange(b bVar) throws RemoteException;
}
