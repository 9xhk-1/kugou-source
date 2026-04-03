package com.kugou.common.filemanager.downloadengine;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class HugeFileSliceInfo implements Parcelable {
    public static final Parcelable.Creator<HugeFileSliceInfo> CREATOR = new Parcelable.Creator<HugeFileSliceInfo>() { // from class: com.kugou.common.filemanager.downloadengine.HugeFileSliceInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HugeFileSliceInfo createFromParcel(Parcel parcel) {
            return new HugeFileSliceInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HugeFileSliceInfo[] newArray(int i2) {
            return new HugeFileSliceInfo[i2];
        }
    };
    private String fileName;
    private String hash;
    private int index;
    private long offset;
    private long size;
    private String[] sliceUrls;

    public HugeFileSliceInfo() {
        this.index = -1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getHash() {
        return this.hash;
    }

    public int getIndex() {
        return this.index;
    }

    public long getOffset() {
        return this.offset;
    }

    public long getSize() {
        return this.size;
    }

    public String[] getSliceUrls() {
        return this.sliceUrls;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setHash(String str) {
        this.hash = str;
    }

    public void setIndex(int i2) {
        this.index = i2;
    }

    public void setOffset(long j) {
        this.offset = j;
    }

    public void setSize(long j) {
        this.size = j;
    }

    public void setSliceUrls(String[] strArr) {
        this.sliceUrls = strArr;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.index);
        parcel.writeLong(this.offset);
        parcel.writeLong(this.size);
        parcel.writeString(this.hash);
        parcel.writeStringArray(this.sliceUrls);
        parcel.writeString(this.fileName);
    }

    public HugeFileSliceInfo(Parcel parcel) {
        this.index = -1;
        this.index = parcel.readInt();
        this.offset = parcel.readLong();
        this.size = parcel.readLong();
        this.hash = parcel.readString();
        this.sliceUrls = parcel.createStringArray();
        this.fileName = parcel.readString();
    }
}
