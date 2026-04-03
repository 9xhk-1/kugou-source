package qihoo.sdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
public interface f extends IInterface {

    public static abstract class a extends Binder implements f {

        /* JADX INFO: renamed from: qihoo.sdk.f$a$a, reason: collision with other inner class name */
        public static class C0284a implements f {
            private IBinder a;

            public C0284a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // qihoo.sdk.f
            public final void a(int i2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("qihoo.sdk.SystemEventAidl");
                    parcelObtain.writeInt(i2);
                    this.a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.a;
            }
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            if (i2 != 1) {
                if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel2.writeString("qihoo.sdk.SystemEventAidl");
                return true;
            }
            parcel.enforceInterface("qihoo.sdk.SystemEventAidl");
            a(parcel.readInt());
            parcel2.writeNoException();
            return true;
        }
    }

    void a(int i2);
}
