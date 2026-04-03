package qihoo.sdk.widget;

import android.graphics.Bitmap;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import e.e.a.a.d;
import java.util.Objects;
import qihoo.sdk.e;

/* JADX INFO: loaded from: classes2.dex */
public class WidgetPlayer implements Parcelable {
    public static final Parcelable.Creator<WidgetPlayer> CREATOR = new Parcelable.Creator<WidgetPlayer>() { // from class: qihoo.sdk.widget.WidgetPlayer.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ WidgetPlayer createFromParcel(Parcel parcel) {
            return new WidgetPlayer(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ WidgetPlayer[] newArray(int i2) {
            return new WidgetPlayer[i2];
        }
    };

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static String f1739i;
    public String a;
    public e b;
    private int c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f1740d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Bitmap f1741e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f1742f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f1743g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f1744h;

    public static class a {
        public int a;
        public String b;
        public String c = "";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f1745d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f1746e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Bitmap f1747f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f1748g;
    }

    public WidgetPlayer(Parcel parcel) {
        this.a = parcel.readString();
        this.c = parcel.readInt();
        this.f1740d = parcel.readInt();
        this.f1742f = parcel.readInt();
        if (parcel.readInt() > 0) {
            this.f1741e = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
        }
        this.f1743g = parcel.readString();
        this.f1744h = parcel.readString();
    }

    private WidgetPlayer(a aVar) {
        this.a = aVar.c;
        this.c = aVar.f1745d;
        this.f1741e = aVar.f1747f;
        this.f1742f = aVar.a;
        this.f1740d = aVar.f1746e;
        this.f1743g = aVar.b;
        this.f1744h = aVar.f1748g;
    }

    public /* synthetic */ WidgetPlayer(a aVar, byte b) {
        this(aVar);
    }

    private void a() {
        Objects.requireNonNull(this.b, "The widget player has not the focus,you need call QWatch.requestPlayerFocus()");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof WidgetPlayer)) {
            return super.equals(obj);
        }
        WidgetPlayer widgetPlayer = (WidgetPlayer) obj;
        return this.f1743g.equals(widgetPlayer.f1743g) && this.a.equals(widgetPlayer.a) && this.c == widgetPlayer.c && this.f1742f == widgetPlayer.f1742f;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean releaseFocus() {
        /*
            r8 = this;
            r0 = 0
            qihoo.sdk.e r1 = r8.b     // Catch: android.os.RemoteException -> L4e
            r2 = 0
            r1.f1736e = r2     // Catch: android.os.RemoteException -> L4e
            android.content.Context r3 = r1.b     // Catch: android.os.RemoteException -> L4e
            e.e.a.a.d r3 = e.e.a.a.d.b(r3)     // Catch: android.os.RemoteException -> L4e
            java.lang.String r4 = "qihoo_sdk"
            android.os.IBinder r3 = r3.a(r4)     // Catch: android.os.RemoteException -> L4e
            r1.c = r3     // Catch: android.os.RemoteException -> L4e
            r4 = 1
            if (r3 == 0) goto L48
            android.os.Parcel r3 = android.os.Parcel.obtain()     // Catch: android.os.RemoteException -> L4e
            android.os.Parcel r5 = android.os.Parcel.obtain()     // Catch: android.os.RemoteException -> L4e
            java.lang.String r6 = qihoo.sdk.d.a     // Catch: android.os.RemoteException -> L4e
            r3.writeInterfaceToken(r6)     // Catch: android.os.RemoteException -> L4e
            r6 = 11003(0x2afb, float:1.5418E-41)
            r3.writeInt(r6)     // Catch: android.os.RemoteException -> L4e
            android.content.Context r7 = r1.b     // Catch: android.os.RemoteException -> L4e
            java.lang.String r7 = r7.getPackageName()     // Catch: android.os.RemoteException -> L4e
            r3.writeString(r7)     // Catch: android.os.RemoteException -> L4e
            android.os.IBinder r1 = r1.c     // Catch: android.os.RemoteException -> L4e
            r1.transact(r6, r3, r5, r0)     // Catch: android.os.RemoteException -> L4e
            r5.readException()     // Catch: android.os.RemoteException -> L4e
            int r1 = r5.readInt()     // Catch: android.os.RemoteException -> L4e
            r5.recycle()     // Catch: android.os.RemoteException -> L4e
            r3.recycle()     // Catch: android.os.RemoteException -> L4e
            if (r1 == 0) goto L48
            r1 = 1
            goto L49
        L48:
            r1 = 0
        L49:
            if (r1 == 0) goto L52
            r8.b = r2     // Catch: android.os.RemoteException -> L4e
            return r4
        L4e:
            r1 = move-exception
            r1.printStackTrace()
        L52:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: qihoo.sdk.widget.WidgetPlayer.releaseFocus():boolean");
    }

    public String toString() {
        return "WidgetPlayer{title='" + this.a + "', time=" + this.c + ", currentPosition=" + this.f1740d + ", icon=" + this.f1741e + ", playState=" + this.f1742f + ", packageName='" + this.f1743g + "', watchNative=" + this.b + '}';
    }

    public boolean updateCurrentPosition(int i2) {
        a();
        this.f1740d = i2;
        try {
            e eVar = this.b;
            IBinder iBinderA = d.b(eVar.b).a("qihoo_sdk");
            eVar.c = iBinderA;
            if (iBinderA != null) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                parcelObtain.writeInterfaceToken(qihoo.sdk.d.a);
                parcelObtain.writeInt(i2);
                parcelObtain.writeString(eVar.b.getPackageName());
                eVar.c.transact(11002, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                int i3 = parcelObtain2.readInt();
                parcelObtain2.recycle();
                parcelObtain.recycle();
                if (i3 != 0) {
                    return true;
                }
            }
            return false;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public boolean updateDescribe(String str) {
        a();
        this.f1744h = str;
        try {
            return this.b.a(this);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public boolean updateIcon(Bitmap bitmap) {
        a();
        this.f1741e = bitmap;
        try {
            return this.b.a(this);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public boolean updatePlayInfo(int i2, int i3, String str, Bitmap bitmap) {
        a();
        this.c = i2;
        this.f1740d = i3;
        this.a = str;
        this.f1741e = bitmap;
        try {
            return this.b.a(this);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public boolean updatePlayState(boolean z) {
        a();
        this.f1742f = z ? 1 : 0;
        try {
            e eVar = this.b;
            IBinder iBinderA = d.b(eVar.b).a("qihoo_sdk");
            eVar.c = iBinderA;
            if (iBinderA != null) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                parcelObtain.writeInterfaceToken(qihoo.sdk.d.a);
                parcelObtain.writeInt(z ? 1 : 0);
                parcelObtain.writeString(eVar.b.getPackageName());
                eVar.c.transact(11004, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                int i2 = parcelObtain2.readInt();
                parcelObtain2.recycle();
                parcelObtain.recycle();
                if (i2 != 0) {
                    return true;
                }
            }
            return false;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public boolean updateTitle(String str) {
        a();
        this.a = str;
        try {
            return this.b.a(this);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public boolean updateTotalTime(int i2) {
        a();
        this.c = i2;
        try {
            return this.b.a(this);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        if (TextUtils.isEmpty(this.a)) {
            this.a = f1739i;
        }
        if (TextUtils.isEmpty(this.a)) {
            this.a = this.b.a();
        }
        if (TextUtils.isEmpty(this.a)) {
            this.a = this.f1743g;
        }
        parcel.writeString(this.a);
        parcel.writeInt(this.c);
        parcel.writeInt(this.f1740d);
        parcel.writeInt(this.f1742f);
        if (this.f1741e != null) {
            parcel.writeInt(1);
            parcel.writeParcelable(this.f1741e, i2);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.f1743g);
        parcel.writeString(this.f1744h);
    }
}
