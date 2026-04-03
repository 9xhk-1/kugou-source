package e.e.a.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.qihoo360.kidwatch.binder.BinderParcel;

/* JADX INFO: loaded from: classes2.dex */
public interface b extends IInterface {

    public static abstract class a extends Binder implements b {

        /* JADX INFO: renamed from: e.e.a.a.b$a$a, reason: collision with other inner class name */
        public static class C0242a implements b {
            public IBinder a;

            public C0242a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // e.e.a.a.b
            public final BinderParcel a(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.qihoo360.kidwatch.binder.IBinderPipe");
                    parcelObtain.writeString(str);
                    this.a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? BinderParcel.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // e.e.a.a.b
            public final void a(String str, BinderParcel binderParcel) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.qihoo360.kidwatch.binder.IBinderPipe");
                    parcelObtain.writeString(str);
                    if (binderParcel != null) {
                        parcelObtain.writeInt(1);
                        binderParcel.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.a.transact(2, parcelObtain, parcelObtain2, 0);
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

        public static b a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.qihoo360.kidwatch.binder.IBinderPipe");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof b)) ? new C0242a(iBinder) : (b) iInterfaceQueryLocalInterface;
        }
    }

    BinderParcel a(String str);

    void a(String str, BinderParcel binderParcel);
}
