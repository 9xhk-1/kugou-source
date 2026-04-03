package com.kugou.common.filemanager.downloadengine;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class HugeFileInfo implements Parcelable {
    public static final Parcelable.Creator<HugeFileInfo> CREATOR = new Parcelable.Creator<HugeFileInfo>() { // from class: com.kugou.common.filemanager.downloadengine.HugeFileInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HugeFileInfo createFromParcel(Parcel parcel) {
            return new HugeFileInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HugeFileInfo[] newArray(int i2) {
            return new HugeFileInfo[i2];
        }
    };
    private long fileSize;
    private List<HugeFileSliceInfo> slices;

    public HugeFileInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public Object[] getSlices() {
        List<HugeFileSliceInfo> list = this.slices;
        if (list == null || list.isEmpty()) {
            return null;
        }
        int size = this.slices.size();
        Object[] objArr = new Object[size];
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i2] = this.slices.get(i2);
        }
        return objArr;
    }

    public List<HugeFileSliceInfo> getSlicesList() {
        return this.slices;
    }

    public boolean isValid() {
        List<HugeFileSliceInfo> list;
        String[] sliceUrls;
        if (this.fileSize <= 0 || (list = this.slices) == null || list.isEmpty()) {
            return false;
        }
        long size = 0;
        for (int i2 = 0; i2 < this.slices.size(); i2++) {
            HugeFileSliceInfo hugeFileSliceInfo = this.slices.get(i2);
            if (hugeFileSliceInfo.getIndex() != i2 || hugeFileSliceInfo.getOffset() != size || hugeFileSliceInfo.getSize() <= 0 || TextUtils.isEmpty(hugeFileSliceInfo.getHash()) || hugeFileSliceInfo.getHash().length() != 32 || (sliceUrls = hugeFileSliceInfo.getSliceUrls()) == null || sliceUrls.length <= 0 || TextUtils.isEmpty(sliceUrls[0])) {
                return false;
            }
            size += hugeFileSliceInfo.getSize();
        }
        return size == this.fileSize;
    }

    public void makeFileNames(boolean z) {
        List<HugeFileSliceInfo> list = this.slices;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < this.slices.size(); i2++) {
            HugeFileSliceInfo hugeFileSliceInfo = this.slices.get(i2);
            if (!TextUtils.isEmpty(hugeFileSliceInfo.getHash())) {
                String hash = hugeFileSliceInfo.getHash();
                if (z) {
                    hash = hugeFileSliceInfo.getHash().substring(0, 7) + "h";
                }
                hugeFileSliceInfo.setFileName(hash + "." + String.format("%03x", Integer.valueOf(hugeFileSliceInfo.getIndex())));
            }
        }
    }

    public void setFileSize(long j) {
        this.fileSize = j;
    }

    public void setSlices(List<HugeFileSliceInfo> list) {
        this.slices = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        HugeFileSliceInfo[] hugeFileSliceInfoArr;
        parcel.writeLong(this.fileSize);
        List<HugeFileSliceInfo> list = this.slices;
        if (list == null || list.isEmpty()) {
            hugeFileSliceInfoArr = new HugeFileSliceInfo[0];
        } else {
            hugeFileSliceInfoArr = new HugeFileSliceInfo[this.slices.size()];
            this.slices.toArray(hugeFileSliceInfoArr);
        }
        parcel.writeParcelableArray(hugeFileSliceInfoArr, i2);
    }

    public HugeFileInfo(Parcel parcel) {
        this.fileSize = parcel.readLong();
        Parcelable[] parcelableArray = parcel.readParcelableArray(HugeFileSliceInfo.class.getClassLoader());
        if (parcelableArray == null || parcelableArray.length <= 0) {
            return;
        }
        this.slices = Arrays.asList(Arrays.copyOf(parcelableArray, parcelableArray.length, HugeFileSliceInfo[].class));
    }
}
