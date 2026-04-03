package com.kugou.datacollect.bi.senter;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class CsccEntity implements Parcelable {
    public static final Parcelable.Creator<CsccEntity> CREATOR = new a();
    public int a;
    public byte[] b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f251d;

    public class a implements Parcelable.Creator<CsccEntity> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public CsccEntity createFromParcel(Parcel parcel) {
            CsccEntity csccEntity = new CsccEntity(null);
            csccEntity.a = parcel.readInt();
            parcel.readByteArray(csccEntity.b);
            return csccEntity;
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public CsccEntity[] newArray(int i2) {
            return new CsccEntity[i2];
        }
    }

    public /* synthetic */ CsccEntity(a aVar) {
        this();
    }

    public final byte[] b(int i2) {
        return e.c.c.o.a.b(e.c.c.o.a.b(new byte[0], i2), this.a);
    }

    public byte[] c() {
        return d();
    }

    public final byte[] d() {
        byte[] bArr = this.b;
        byte[] bArrB = b(bArr.length);
        byte[] bArr2 = new byte[bArr.length + bArrB.length];
        System.arraycopy(bArrB, 0, bArr2, 0, bArrB.length);
        System.arraycopy(bArr, 0, bArr2, bArrB.length, bArr.length);
        return bArr2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.a);
        parcel.writeByteArray(this.b);
    }

    public CsccEntity(int i2, byte[] bArr, int i3) {
        this.f251d = 0;
        this.a = i2;
        this.b = bArr;
        this.f251d = i3;
    }

    public CsccEntity() {
        this.f251d = 0;
    }
}
