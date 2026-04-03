package com.kugou.common.filemanager.downloadengine.entity;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class AppStateChange implements Parcelable {
    public static final int APP_STATE_IN_BACKGROUND = 1;
    public static final Parcelable.Creator<AppStateChange> CREATOR = new Parcelable.Creator<AppStateChange>() { // from class: com.kugou.common.filemanager.downloadengine.entity.AppStateChange.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AppStateChange createFromParcel(Parcel parcel) {
            return new AppStateChange(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AppStateChange[] newArray(int i2) {
            return new AppStateChange[i2];
        }
    };
    private boolean inBackground;
    private int type;

    public AppStateChange() {
        this.type = 0;
        this.inBackground = false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean getInBackground() {
        return this.inBackground;
    }

    public int getType() {
        return this.type;
    }

    public void setInBackground(boolean z) {
        this.inBackground = z;
    }

    public void setType(int i2) {
        this.type = i2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.type);
        parcel.writeByte(this.inBackground ? (byte) 1 : (byte) 0);
    }

    public AppStateChange(Parcel parcel) {
        this.type = 0;
        this.inBackground = false;
        this.type = parcel.readInt();
        this.inBackground = parcel.readByte() == 1;
    }
}
