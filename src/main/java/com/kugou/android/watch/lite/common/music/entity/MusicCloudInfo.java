package com.kugou.android.watch.lite.common.music.entity;

import android.os.Parcel;
import android.os.Parcelable;
import e.c.a.g.a.s.g0;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class MusicCloudInfo implements Parcelable {
    public static final Parcelable.Creator<MusicCloudInfo> CREATOR = new a();
    public String a;
    public long b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f117d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f118f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f119h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f120i;
    public long j;

    public class a implements Parcelable.Creator<MusicCloudInfo> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MusicCloudInfo createFromParcel(Parcel parcel) {
            return new MusicCloudInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public MusicCloudInfo[] newArray(int i2) {
            return new MusicCloudInfo[i2];
        }
    }

    public MusicCloudInfo() {
    }

    public static MusicCloudInfo a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        MusicCloudInfo musicCloudInfo = new MusicCloudInfo();
        musicCloudInfo.b = jSONObject.optLong("mixId");
        musicCloudInfo.f117d = jSONObject.optString("fileHash");
        musicCloudInfo.f118f = jSONObject.optLong("fileLength");
        musicCloudInfo.f119h = jSONObject.optInt("qualityType");
        musicCloudInfo.f120i = jSONObject.optString("cloudExtName");
        musicCloudInfo.j = jSONObject.optLong("audioId");
        musicCloudInfo.a = jSONObject.optString("fileName");
        return musicCloudInfo;
    }

    public String b() {
        return this.f120i;
    }

    public String c() {
        return this.f117d;
    }

    public long d() {
        return this.f118f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.a;
    }

    public long f() {
        return this.b;
    }

    public int g() {
        return this.f119h;
    }

    public void h(String str) {
        this.f120i = str;
    }

    public void i(String str) {
        this.f117d = str;
    }

    public void j(long j) {
        this.f118f = j;
    }

    public void k(String str) {
        this.a = str;
    }

    public void l(long j) {
        this.b = j;
    }

    public void m(int i2) {
        this.f119h = i2;
    }

    public JSONObject n() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mixId", this.b);
            jSONObject.put("fileHash", this.f117d);
            jSONObject.put("fileLength", this.f118f);
            jSONObject.put("qualityType", this.f119h);
            jSONObject.put("cloudExtName", this.f120i);
            jSONObject.put("audioId", this.j);
            jSONObject.put("fileName", this.a);
        } catch (JSONException e2) {
            g0.k(e2);
        }
        return jSONObject;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.b);
        parcel.writeString(this.f117d);
        parcel.writeLong(this.f118f);
        parcel.writeInt(this.f119h);
        parcel.writeString(this.f120i);
        parcel.writeLong(this.j);
        parcel.writeString(this.a);
    }

    public MusicCloudInfo(Parcel parcel) {
        this.b = parcel.readLong();
        this.f117d = parcel.readString();
        this.f118f = parcel.readLong();
        this.f119h = parcel.readInt();
        this.f120i = parcel.readString();
        this.j = parcel.readLong();
        this.a = parcel.readString();
    }
}
