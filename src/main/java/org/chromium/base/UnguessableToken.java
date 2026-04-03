package org.chromium.base;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class UnguessableToken implements Parcelable {
    public static final Parcelable.Creator<UnguessableToken> CREATOR = new a();
    public final long a;
    public final long b;

    public static class a implements Parcelable.Creator<UnguessableToken> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public UnguessableToken createFromParcel(Parcel parcel) {
            long j = parcel.readLong();
            long j2 = parcel.readLong();
            if (j == 0 || j2 == 0) {
                return null;
            }
            return new UnguessableToken(j, j2, null);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public UnguessableToken[] newArray(int i2) {
            return new UnguessableToken[i2];
        }
    }

    public /* synthetic */ UnguessableToken(long j, long j2, a aVar) {
        this(j, j2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.a);
        parcel.writeLong(this.b);
    }

    public UnguessableToken(long j, long j2) {
        this.a = j;
        this.b = j2;
    }
}
