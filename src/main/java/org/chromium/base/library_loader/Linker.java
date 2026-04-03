package org.chromium.base.library_loader;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import h.a.a.b;
import java.io.IOException;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Linker {
    private static native long nativeGetRandomBaseLoadAddress();

    public static class LibInfo implements Parcelable {
        public static final Parcelable.Creator<LibInfo> CREATOR = new a();
        public long a;
        public long b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f1698d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f1699f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f1700h;

        public static class a implements Parcelable.Creator<LibInfo> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public LibInfo createFromParcel(Parcel parcel) {
                return new LibInfo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public LibInfo[] newArray(int i2) {
                return new LibInfo[i2];
            }
        }

        public LibInfo() {
            this.a = 0L;
            this.b = 0L;
            this.f1698d = 0L;
            this.f1699f = 0L;
            this.f1700h = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 1;
        }

        public String toString() {
            return String.format(Locale.US, "[load=0x%x-0x%x relro=0x%x-0x%x fd=%d]", Long.valueOf(this.a), Long.valueOf(this.a + this.b), Long.valueOf(this.f1698d), Long.valueOf(this.f1698d + this.f1699f), Integer.valueOf(this.f1700h));
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            if (this.f1700h >= 0) {
                parcel.writeLong(this.a);
                parcel.writeLong(this.b);
                parcel.writeLong(this.f1698d);
                parcel.writeLong(this.f1699f);
                try {
                    ParcelFileDescriptor parcelFileDescriptorFromFd = ParcelFileDescriptor.fromFd(this.f1700h);
                    parcelFileDescriptorFromFd.writeToParcel(parcel, 0);
                    parcelFileDescriptorFromFd.close();
                } catch (IOException e2) {
                    b.c("LibraryLoader", "Can't write LibInfo file descriptor to parcel", e2);
                }
            }
        }

        public LibInfo(Parcel parcel) {
            this.a = parcel.readLong();
            this.b = parcel.readLong();
            this.f1698d = parcel.readLong();
            this.f1699f = parcel.readLong();
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(parcel);
            this.f1700h = parcelFileDescriptor == null ? -1 : parcelFileDescriptor.detachFd();
        }
    }
}
