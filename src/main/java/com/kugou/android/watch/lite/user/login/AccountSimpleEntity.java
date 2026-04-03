package com.kugou.android.watch.lite.user.login;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class AccountSimpleEntity implements Parcelable {
    public static final Parcelable.Creator<AccountSimpleEntity> CREATOR = new a();
    public String a;
    public String b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f228d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f229f;

    public class a implements Parcelable.Creator<AccountSimpleEntity> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AccountSimpleEntity createFromParcel(Parcel parcel) {
            return new AccountSimpleEntity(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public AccountSimpleEntity[] newArray(int i2) {
            return new AccountSimpleEntity[i2];
        }
    }

    public AccountSimpleEntity() {
    }

    public String a() {
        return this.f228d;
    }

    public String b() {
        return this.a;
    }

    public String c() {
        return this.b;
    }

    public void d(String str) {
        this.f228d = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void e(String str) {
        this.a = str;
    }

    public void f(String str) {
        this.b = str;
    }

    public void g(String str) {
        this.f229f = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.f228d);
        parcel.writeString(this.f229f);
    }

    public AccountSimpleEntity(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.f228d = parcel.readString();
        this.f229f = parcel.readString();
    }
}
