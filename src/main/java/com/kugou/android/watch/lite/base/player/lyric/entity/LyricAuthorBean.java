package com.kugou.android.watch.lite.base.player.lyric.entity;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class LyricAuthorBean implements Parcelable {
    public static final Parcelable.Creator<LyricAuthorBean> CREATOR = new a();
    public String a;
    public String b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f79d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f80f;

    public class a implements Parcelable.Creator<LyricAuthorBean> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public LyricAuthorBean createFromParcel(Parcel parcel) {
            LyricAuthorBean lyricAuthorBean = new LyricAuthorBean();
            lyricAuthorBean.a(parcel.readString());
            lyricAuthorBean.d(parcel.readString());
            lyricAuthorBean.c(parcel.readString());
            lyricAuthorBean.b(parcel.readString());
            return lyricAuthorBean;
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public LyricAuthorBean[] newArray(int i2) {
            return new LyricAuthorBean[i2];
        }
    }

    public void a(String str) {
        this.b = str;
    }

    public void b(String str) {
        this.f80f = str;
    }

    public void c(String str) {
        this.f79d = str;
    }

    public void d(String str) {
        this.a = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.b);
        parcel.writeString(this.a);
        parcel.writeString(this.f79d);
        parcel.writeString(this.f80f);
    }
}
