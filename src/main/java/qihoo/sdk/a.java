package qihoo.sdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: qihoo.sdk.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0280a extends Binder implements a {

        /* JADX INFO: renamed from: qihoo.sdk.a$a$a, reason: collision with other inner class name */
        public static class C0281a implements a {
            private IBinder a;

            public C0281a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // qihoo.sdk.a
            public final void a() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("qihoo.sdk.IOnPlayWidgetEventListener");
                    this.a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // qihoo.sdk.a
            public final void a(int i2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("qihoo.sdk.IOnPlayWidgetEventListener");
                    parcelObtain.writeInt(i2);
                    this.a.transact(6, parcelObtain, parcelObtain2, 0);
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

            @Override // qihoo.sdk.a
            public final void b() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("qihoo.sdk.IOnPlayWidgetEventListener");
                    this.a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // qihoo.sdk.a
            public final void c() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("qihoo.sdk.IOnPlayWidgetEventListener");
                    this.a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // qihoo.sdk.a
            public final void d() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("qihoo.sdk.IOnPlayWidgetEventListener");
                    this.a.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // qihoo.sdk.a
            public final void e() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("qihoo.sdk.IOnPlayWidgetEventListener");
                    this.a.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // qihoo.sdk.a
            public final void f() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("qihoo.sdk.IOnPlayWidgetEventListener");
                    this.a.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public AbstractBinderC0280a() {
            attachInterface(this, "qihoo.sdk.IOnPlayWidgetEventListener");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            if (i2 == 1598968902) {
                parcel2.writeString("qihoo.sdk.IOnPlayWidgetEventListener");
                return true;
            }
            switch (i2) {
                case 1:
                    parcel.enforceInterface("qihoo.sdk.IOnPlayWidgetEventListener");
                    a();
                    break;
                case 2:
                    parcel.enforceInterface("qihoo.sdk.IOnPlayWidgetEventListener");
                    b();
                    break;
                case 3:
                    parcel.enforceInterface("qihoo.sdk.IOnPlayWidgetEventListener");
                    c();
                    break;
                case 4:
                    parcel.enforceInterface("qihoo.sdk.IOnPlayWidgetEventListener");
                    d();
                    break;
                case 5:
                    parcel.enforceInterface("qihoo.sdk.IOnPlayWidgetEventListener");
                    e();
                    break;
                case 6:
                    parcel.enforceInterface("qihoo.sdk.IOnPlayWidgetEventListener");
                    a(parcel.readInt());
                    break;
                case 7:
                    parcel.enforceInterface("qihoo.sdk.IOnPlayWidgetEventListener");
                    f();
                    break;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void a();

    void a(int i2);

    void b();

    void c();

    void d();

    void e();

    void f();
}
