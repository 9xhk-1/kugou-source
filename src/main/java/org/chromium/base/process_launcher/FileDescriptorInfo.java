package org.chromium.base.process_launcher;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public final class FileDescriptorInfo implements Parcelable {
    public static final Parcelable.Creator<FileDescriptorInfo> CREATOR = new a();
    public final int a;
    public final ParcelFileDescriptor b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f1705d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f1706f;

    public static class a implements Parcelable.Creator<FileDescriptorInfo> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public FileDescriptorInfo createFromParcel(Parcel parcel) {
            return new FileDescriptorInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public FileDescriptorInfo[] newArray(int i2) {
            return new FileDescriptorInfo[i2];
        }
    }

    public FileDescriptorInfo(Parcel parcel) {
        this.a = parcel.readInt();
        this.b = (ParcelFileDescriptor) parcel.readParcelable(ParcelFileDescriptor.class.getClassLoader());
        this.f1705d = parcel.readLong();
        this.f1706f = parcel.readLong();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.a);
        parcel.writeParcelable(this.b, 1);
        parcel.writeLong(this.f1705d);
        parcel.writeLong(this.f1706f);
    }
}
