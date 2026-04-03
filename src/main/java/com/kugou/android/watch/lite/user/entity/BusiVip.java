package com.kugou.android.watch.lite.user.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.kugou.android.watch.lite.common.INoGuard;

/* JADX INFO: loaded from: classes2.dex */
public class BusiVip implements Parcelable, INoGuard {
    public static final String CODE = "concept";
    public static final Parcelable.Creator<BusiVip> CREATOR = new a();
    public static final int VIP_YEAR = 1;

    @SerializedName("busi_type")
    private String busiType;

    @SerializedName("is_paid_vip")
    private int isPaidVip;

    @SerializedName("is_vip")
    private int isVip;

    @SerializedName("paid_vip_expire_time")
    private String paidVipExpireTime;

    @SerializedName("product_type")
    private String productType;

    @SerializedName("purchased_type")
    private int purchasedType;

    @SerializedName("userid")
    private Long userId;

    @SerializedName("vip_begin_time")
    private String vipBeginTime;

    @SerializedName("vip_clearday")
    private String vipClearDay;

    @SerializedName("vip_end_time")
    private String vipEndTime;

    @SerializedName("y_type")
    private int yType;

    public class a implements Parcelable.Creator<BusiVip> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public BusiVip createFromParcel(Parcel parcel) {
            return new BusiVip(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public BusiVip[] newArray(int i2) {
            return new BusiVip[i2];
        }
    }

    public BusiVip(Parcel parcel) {
        this.isVip = parcel.readInt();
        this.productType = parcel.readString();
        this.busiType = parcel.readString();
        this.vipBeginTime = parcel.readString();
        this.vipEndTime = parcel.readString();
        this.vipClearDay = parcel.readString();
        this.yType = parcel.readInt();
        this.purchasedType = parcel.readInt();
        this.userId = Long.valueOf(parcel.readLong());
        this.isPaidVip = parcel.readInt();
        this.paidVipExpireTime = parcel.readString();
    }

    public static boolean isYearVip(BusiVip busiVip) {
        return busiVip != null && busiVip.isVip == 1 && busiVip.yType == 1;
    }

    public static boolean isYearVip(boolean z, int i2) {
        return z && i2 == 1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getBusiType() {
        return this.busiType;
    }

    public int getIsPaidVip() {
        return this.isPaidVip;
    }

    public int getIsVip() {
        return this.isVip;
    }

    public String getPaidVipExpireTime() {
        return this.paidVipExpireTime;
    }

    public String getProductType() {
        return this.productType;
    }

    public Long getUserId() {
        return this.userId;
    }

    public String getVipBeginTime() {
        return this.vipBeginTime;
    }

    public String getVipClearDay() {
        return this.vipClearDay;
    }

    public String getVipEndTime() {
        return this.vipEndTime;
    }

    public int getYType() {
        return this.yType;
    }

    public boolean isVip() {
        return this.isVip == 1;
    }

    public void setBusiType(String str) {
        this.busiType = str;
    }

    public void setIsPaidVip(int i2) {
        this.isPaidVip = i2;
    }

    public void setIsVip(int i2) {
        this.isVip = i2;
    }

    public void setProductType(String str) {
        this.productType = str;
    }

    public void setUserId(Long l) {
        this.userId = l;
    }

    public void setVipBeginTime(String str) {
        this.vipBeginTime = str;
    }

    public void setVipClearDay(String str) {
        this.vipClearDay = str;
    }

    public void setVipEndTime(String str) {
        this.vipEndTime = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.isVip);
        parcel.writeString(this.productType);
        parcel.writeString(this.busiType);
        parcel.writeString(this.vipBeginTime);
        parcel.writeString(this.vipEndTime);
        parcel.writeString(this.vipClearDay);
        parcel.writeInt(this.yType);
        parcel.writeInt(this.purchasedType);
        parcel.writeLong(this.userId.longValue());
        parcel.writeInt(this.isPaidVip);
        parcel.writeString(this.paidVipExpireTime);
    }
}
