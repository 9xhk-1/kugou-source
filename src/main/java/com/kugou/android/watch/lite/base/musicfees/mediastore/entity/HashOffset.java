package com.kugou.android.watch.lite.base.musicfees.mediastore.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.kugou.android.watch.lite.common.INoGuard;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class HashOffset implements Parcelable, INoGuard {
    public static final Parcelable.Creator<HashOffset> CREATOR = new a();
    public long end_byte;
    public long end_ms;
    public String offset_hash;
    public long start_byte;
    public long start_ms;

    public class a implements Parcelable.Creator<HashOffset> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public HashOffset createFromParcel(Parcel parcel) {
            HashOffset hashOffset = new HashOffset();
            hashOffset.start_ms = parcel.readLong();
            hashOffset.end_ms = parcel.readLong();
            hashOffset.start_byte = parcel.readLong();
            hashOffset.end_byte = parcel.readLong();
            hashOffset.offset_hash = parcel.readString();
            return hashOffset;
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public HashOffset[] newArray(int i2) {
            return new HashOffset[i2];
        }
    }

    public static int getListenSeconds(HashOffset hashOffset) {
        int i2;
        if (hashOffset != null && (i2 = ((int) (hashOffset.end_ms - hashOffset.start_ms)) / 1000) > 0) {
            return i2;
        }
        return 30;
    }

    public static HashOffset jsonToHashOffset(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            HashOffset hashOffset = new HashOffset();
            hashOffset.start_ms = jSONObject.getLong("start_ms");
            hashOffset.end_ms = jSONObject.getLong("end_ms");
            hashOffset.start_byte = jSONObject.getLong("start_byte");
            hashOffset.end_byte = jSONObject.getLong("end_byte");
            hashOffset.offset_hash = jSONObject.getString("offset_hash");
            return hashOffset;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getEnd_byte() {
        return this.end_byte;
    }

    public long getEnd_ms() {
        return this.end_ms;
    }

    public String getOffset_hash() {
        return this.offset_hash;
    }

    public long getStart_byte() {
        return this.start_byte;
    }

    public long getStart_ms() {
        return this.start_ms;
    }

    public void setEnd_byte(long j) {
        this.end_byte = j;
    }

    public void setEnd_ms(long j) {
        this.end_ms = j;
    }

    public void setOffset_hash(String str) {
        this.offset_hash = str;
    }

    public void setStart_byte(long j) {
        this.start_byte = j;
    }

    public void setStart_ms(long j) {
        this.start_ms = j;
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("start_ms", this.start_ms);
            jSONObject.put("end_ms", this.end_ms);
            jSONObject.put("start_byte", this.start_byte);
            jSONObject.put("end_byte", this.end_byte);
            jSONObject.put("offset_hash", this.offset_hash);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.start_ms);
        parcel.writeLong(this.end_ms);
        parcel.writeLong(this.start_byte);
        parcel.writeLong(this.end_byte);
        parcel.writeString(this.offset_hash);
    }
}
