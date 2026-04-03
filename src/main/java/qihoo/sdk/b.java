package qihoo.sdk;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
public interface b extends IInterface {

    public static abstract class a extends Binder implements b {

        /* JADX INFO: renamed from: qihoo.sdk.b$a$a, reason: collision with other inner class name */
        public static class C0282a implements b {
            private IBinder a;

            public C0282a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // qihoo.sdk.b
            public final void a() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("qihoo.sdk.IOnWidgetUpdateAidl");
                    this.a.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // qihoo.sdk.b
            public final void a(int i2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("qihoo.sdk.IOnWidgetUpdateAidl");
                    parcelObtain.writeInt(i2);
                    this.a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // qihoo.sdk.b
            public final void a(String str, String str2, int i2, Bitmap bitmap) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("qihoo.sdk.IOnWidgetUpdateAidl");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeInt(i2);
                    if (bitmap != null) {
                        parcelObtain.writeInt(1);
                        bitmap.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
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

            @Override // qihoo.sdk.b
            public final void b(int i2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("qihoo.sdk.IOnWidgetUpdateAidl");
                    parcelObtain.writeInt(i2);
                    this.a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static b a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("qihoo.sdk.IOnWidgetUpdateAidl");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof b)) ? new C0282a(iBinder) : (b) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            if (i2 == 1) {
                parcel.enforceInterface("qihoo.sdk.IOnWidgetUpdateAidl");
                a(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt() != 0 ? (Bitmap) Bitmap.CREATOR.createFromParcel(parcel) : null);
            } else if (i2 == 2) {
                parcel.enforceInterface("qihoo.sdk.IOnWidgetUpdateAidl");
                a(parcel.readInt());
            } else if (i2 == 3) {
                parcel.enforceInterface("qihoo.sdk.IOnWidgetUpdateAidl");
                b(parcel.readInt());
            } else {
                if (i2 != 4) {
                    if (i2 != 1598968902) {
                        return super.onTransact(i2, parcel, parcel2, i3);
                    }
                    parcel2.writeString("qihoo.sdk.IOnWidgetUpdateAidl");
                    return true;
                }
                parcel.enforceInterface("qihoo.sdk.IOnWidgetUpdateAidl");
                a();
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void a();

    void a(int i2);

    void a(String str, String str2, int i2, Bitmap bitmap);

    void b(int i2);
}
