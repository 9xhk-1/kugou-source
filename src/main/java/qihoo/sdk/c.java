package qihoo.sdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import qihoo.sdk.a;
import qihoo.sdk.b;
import qihoo.sdk.f;

/* JADX INFO: loaded from: classes2.dex */
public interface c extends IInterface {

    public static abstract class a extends Binder implements c {

        /* JADX INFO: renamed from: qihoo.sdk.c$a$a, reason: collision with other inner class name */
        public static class C0283a implements c {
            private IBinder a;

            public C0283a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // qihoo.sdk.c
            public final int a() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("qihoo.sdk.IWatchSDK");
                    this.a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // qihoo.sdk.c
            public final int a(qihoo.sdk.a aVar, String str, int i2, int i3) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("qihoo.sdk.IWatchSDK");
                    parcelObtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    this.a.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // qihoo.sdk.c
            public final int a(b bVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("qihoo.sdk.IWatchSDK");
                    parcelObtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    this.a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // qihoo.sdk.c
            public final int a(f fVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("qihoo.sdk.IWatchSDK");
                    parcelObtain.writeStrongBinder(fVar != null ? fVar.asBinder() : null);
                    this.a.transact(6, parcelObtain, parcelObtain2, 0);
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

            @Override // qihoo.sdk.c
            public final int b() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("qihoo.sdk.IWatchSDK");
                    this.a.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // qihoo.sdk.c
            public final int b(b bVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("qihoo.sdk.IWatchSDK");
                    parcelObtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    this.a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static c a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("qihoo.sdk.IWatchSDK");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof c)) ? new C0283a(iBinder) : (c) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            int iA;
            if (i2 == 1598968902) {
                parcel2.writeString("qihoo.sdk.IWatchSDK");
                return true;
            }
            qihoo.sdk.a c0281a = null;
            f c0284a = null;
            switch (i2) {
                case 1:
                    parcel.enforceInterface("qihoo.sdk.IWatchSDK");
                    iA = a();
                    break;
                case 2:
                    parcel.enforceInterface("qihoo.sdk.IWatchSDK");
                    iA = a(b.a.a(parcel.readStrongBinder()));
                    break;
                case 3:
                    parcel.enforceInterface("qihoo.sdk.IWatchSDK");
                    iA = b(b.a.a(parcel.readStrongBinder()));
                    break;
                case 4:
                    parcel.enforceInterface("qihoo.sdk.IWatchSDK");
                    IBinder strongBinder = parcel.readStrongBinder();
                    if (strongBinder != null) {
                        IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("qihoo.sdk.IOnPlayWidgetEventListener");
                        c0281a = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof qihoo.sdk.a)) ? new a.AbstractBinderC0280a.C0281a(strongBinder) : (qihoo.sdk.a) iInterfaceQueryLocalInterface;
                    }
                    iA = a(c0281a, parcel.readString(), parcel.readInt(), parcel.readInt());
                    break;
                case 5:
                    parcel.enforceInterface("qihoo.sdk.IWatchSDK");
                    iA = b();
                    break;
                case 6:
                    parcel.enforceInterface("qihoo.sdk.IWatchSDK");
                    IBinder strongBinder2 = parcel.readStrongBinder();
                    if (strongBinder2 != null) {
                        IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("qihoo.sdk.SystemEventAidl");
                        c0284a = (iInterfaceQueryLocalInterface2 == null || !(iInterfaceQueryLocalInterface2 instanceof f)) ? new f.a.C0284a(strongBinder2) : (f) iInterfaceQueryLocalInterface2;
                    }
                    iA = a(c0284a);
                    break;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
            parcel2.writeNoException();
            parcel2.writeInt(iA);
            return true;
        }
    }

    int a();

    int a(qihoo.sdk.a aVar, String str, int i2, int i3);

    int a(b bVar);

    int a(f fVar);

    int b();

    int b(b bVar);
}
