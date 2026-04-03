package com.kugou.android.watch.lite.common.music.entity;

import android.os.Parcel;
import android.os.Parcelable;
import e.c.a.g.a.s.g0;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class SingerInfo implements Parcelable, Serializable {
    public static final Parcelable.Creator<SingerInfo> CREATOR = new a();
    public int a;
    public String b;

    public class a implements Parcelable.Creator<SingerInfo> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public SingerInfo createFromParcel(Parcel parcel) {
            return new SingerInfo(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public SingerInfo[] newArray(int i2) {
            return new SingerInfo[i2];
        }
    }

    public /* synthetic */ SingerInfo(Parcel parcel, a aVar) {
        this(parcel);
    }

    public static SingerInfo a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        SingerInfo singerInfo = new SingerInfo();
        singerInfo.a = jSONObject.optInt("singerId");
        singerInfo.b = jSONObject.optString("singerName");
        return singerInfo;
    }

    public int b() {
        return this.a;
    }

    public String c() {
        return this.b;
    }

    public void d(int i2) {
        this.a = i2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void e(String str) {
        this.b = str;
    }

    public JSONObject f() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("singerId", this.a);
            jSONObject.put("singerName", this.b);
        } catch (JSONException e2) {
            g0.k(e2);
        }
        return jSONObject;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.a);
        parcel.writeString(this.b);
    }

    public SingerInfo(Parcel parcel) {
        this.a = parcel.readInt();
        this.b = parcel.readString();
    }

    public SingerInfo() {
    }
}
