package com.qihoo.kidwatch.logger;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.qihoo.kidwatch.logger.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0025a extends Binder implements a {

        /* JADX INFO: renamed from: com.qihoo.kidwatch.logger.a$a$a, reason: collision with other inner class name */
        public static class C0026a implements a {
            private IBinder a;

            public C0026a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // com.qihoo.kidwatch.logger.a
            public final int a(int i2, int i3) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.qihoo.kidwatch.logger.IQihooLoggerService");
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    this.a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.qihoo.kidwatch.logger.a
            public final int a(String str, String str2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.qihoo.kidwatch.logger.IQihooLoggerService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
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

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.qihoo.kidwatch.logger.IQihooLoggerService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0026a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            int iA;
            if (i2 == 1) {
                parcel.enforceInterface("com.qihoo.kidwatch.logger.IQihooLoggerService");
                iA = a(parcel.readString(), parcel.readString());
            } else {
                if (i2 != 2) {
                    if (i2 != 1598968902) {
                        return super.onTransact(i2, parcel, parcel2, i3);
                    }
                    parcel2.writeString("com.qihoo.kidwatch.logger.IQihooLoggerService");
                    return true;
                }
                parcel.enforceInterface("com.qihoo.kidwatch.logger.IQihooLoggerService");
                iA = a(parcel.readInt(), parcel.readInt());
            }
            parcel2.writeNoException();
            parcel2.writeInt(iA);
            return true;
        }
    }

    int a(int i2, int i3);

    int a(String str, String str2);
}
