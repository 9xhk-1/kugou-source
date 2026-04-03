package me.jessyan.autosize;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class DisplayMetricsInfo implements Parcelable {
    public static final Parcelable.Creator<DisplayMetricsInfo> CREATOR = new Parcelable.Creator<DisplayMetricsInfo>() { // from class: me.jessyan.autosize.DisplayMetricsInfo.1
        @Override // android.os.Parcelable.Creator
        public DisplayMetricsInfo createFromParcel(Parcel parcel) {
            return new DisplayMetricsInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public DisplayMetricsInfo[] newArray(int i2) {
            return new DisplayMetricsInfo[i2];
        }
    };
    private float density;
    private int densityDpi;
    private float scaledDensity;
    private int screenHeightDp;
    private int screenWidthDp;
    private float xdpi;

    public DisplayMetricsInfo(float f2, int i2, float f3, float f4) {
        this.density = f2;
        this.densityDpi = i2;
        this.scaledDensity = f3;
        this.xdpi = f4;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getDensity() {
        return this.density;
    }

    public int getDensityDpi() {
        return this.densityDpi;
    }

    public float getScaledDensity() {
        return this.scaledDensity;
    }

    public int getScreenHeightDp() {
        return this.screenHeightDp;
    }

    public int getScreenWidthDp() {
        return this.screenWidthDp;
    }

    public float getXdpi() {
        return this.xdpi;
    }

    public void setDensity(float f2) {
        this.density = f2;
    }

    public void setDensityDpi(int i2) {
        this.densityDpi = i2;
    }

    public void setScaledDensity(float f2) {
        this.scaledDensity = f2;
    }

    public void setScreenHeightDp(int i2) {
        this.screenHeightDp = i2;
    }

    public void setScreenWidthDp(int i2) {
        this.screenWidthDp = i2;
    }

    public void setXdpi(float f2) {
        this.xdpi = f2;
    }

    public String toString() {
        return "DisplayMetricsInfo{density=" + this.density + ", densityDpi=" + this.densityDpi + ", scaledDensity=" + this.scaledDensity + ", xdpi=" + this.xdpi + ", screenWidthDp=" + this.screenWidthDp + ", screenHeightDp=" + this.screenHeightDp + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeFloat(this.density);
        parcel.writeInt(this.densityDpi);
        parcel.writeFloat(this.scaledDensity);
        parcel.writeFloat(this.xdpi);
        parcel.writeInt(this.screenWidthDp);
        parcel.writeInt(this.screenHeightDp);
    }

    public DisplayMetricsInfo(float f2, int i2, float f3, float f4, int i3, int i4) {
        this.density = f2;
        this.densityDpi = i2;
        this.scaledDensity = f3;
        this.xdpi = f4;
        this.screenWidthDp = i3;
        this.screenHeightDp = i4;
    }

    public DisplayMetricsInfo(Parcel parcel) {
        this.density = parcel.readFloat();
        this.densityDpi = parcel.readInt();
        this.scaledDensity = parcel.readFloat();
        this.xdpi = parcel.readFloat();
        this.screenWidthDp = parcel.readInt();
        this.screenHeightDp = parcel.readInt();
    }
}
