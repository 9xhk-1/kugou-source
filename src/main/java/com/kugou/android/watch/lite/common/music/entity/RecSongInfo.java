package com.kugou.android.watch.lite.common.music.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.kugou.android.watch.lite.common.INoGuard;
import e.c.a.g.a.s.g0;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class RecSongInfo implements Parcelable, Serializable, INoGuard {
    public static final Parcelable.Creator<RecSongInfo> CREATOR = new a();
    public String alg_path;
    public String fileName;
    public String hash;
    public double predict_v;
    public int reason;
    public String rec_desc;
    public String rec_desc2;
    public String similar_desc;
    public double similarity;
    public String songId;

    public class a implements Parcelable.Creator<RecSongInfo> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public RecSongInfo createFromParcel(Parcel parcel) {
            return new RecSongInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public RecSongInfo[] newArray(int i2) {
            return new RecSongInfo[i2];
        }
    }

    public RecSongInfo() {
    }

    public static RecSongInfo parseRecSongInfo(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        RecSongInfo recSongInfo = new RecSongInfo();
        recSongInfo.setHash(jSONObject.optString("hash", ""));
        recSongInfo.setSongId(jSONObject.optString("songid", ""));
        recSongInfo.setFileName(jSONObject.optString("filename", ""));
        recSongInfo.setSimilarity(jSONObject.optDouble("similarity", 0.0d));
        recSongInfo.setSimilar_desc(jSONObject.optString("similar_desc", ""));
        recSongInfo.setPredict_v(jSONObject.optDouble("predict_v", 0.0d));
        recSongInfo.setAlg_path(jSONObject.optString("alg_path", ""));
        recSongInfo.setReason(jSONObject.optInt("reason", 0));
        recSongInfo.setRec_desc(jSONObject.optString("rec_desc", ""));
        recSongInfo.setRec_desc2(jSONObject.optString("rec_desc2", ""));
        return recSongInfo;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAlg_path() {
        return this.alg_path;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getHash() {
        return this.hash;
    }

    public double getPredict_v() {
        return this.predict_v;
    }

    public int getReason() {
        return this.reason;
    }

    public String getRec_desc() {
        return this.rec_desc;
    }

    public String getRec_desc2() {
        return this.rec_desc2;
    }

    public String getSimilar_desc() {
        return this.similar_desc;
    }

    public double getSimilarity() {
        return this.similarity;
    }

    public String getSongId() {
        return this.songId;
    }

    public int getTopReason() {
        return Integer.highestOneBit(this.reason);
    }

    public void setAlg_path(String str) {
        this.alg_path = str;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setHash(String str) {
        this.hash = str;
    }

    public void setPredict_v(double d2) {
        this.predict_v = d2;
    }

    public void setReason(int i2) {
        this.reason = i2;
    }

    public void setRec_desc(String str) {
        this.rec_desc = str;
    }

    public void setRec_desc2(String str) {
        this.rec_desc2 = str;
    }

    public void setSimilar_desc(String str) {
        this.similar_desc = str;
    }

    public void setSimilarity(double d2) {
        this.similarity = d2;
    }

    public void setSongId(String str) {
        this.songId = str;
    }

    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("hash", getHash());
            jSONObject.put("songid", getSongId());
            jSONObject.put("filename", getFileName());
            jSONObject.put("similarity", getSimilarity());
            jSONObject.put("similar_desc", getSimilar_desc());
            jSONObject.put("predict_v", getPredict_v());
            jSONObject.put("alg_path", getAlg_path());
            jSONObject.put("reason", getReason());
            jSONObject.put("rec_desc", getRec_desc());
            jSONObject.put("rec_desc2", getRec_desc2());
        } catch (JSONException e2) {
            g0.k(e2);
        }
        return jSONObject;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.hash);
        parcel.writeString(this.songId);
        parcel.writeString(this.fileName);
        parcel.writeDouble(this.similarity);
        parcel.writeString(this.similar_desc);
        parcel.writeDouble(this.predict_v);
        parcel.writeString(this.alg_path);
        parcel.writeInt(this.reason);
        parcel.writeString(this.rec_desc);
        parcel.writeString(this.rec_desc2);
    }

    public RecSongInfo(Parcel parcel) {
        this.hash = parcel.readString();
        this.songId = parcel.readString();
        this.fileName = parcel.readString();
        this.similarity = parcel.readDouble();
        this.similar_desc = parcel.readString();
        this.predict_v = parcel.readDouble();
        this.alg_path = parcel.readString();
        this.reason = parcel.readInt();
        this.rec_desc = parcel.readString();
        this.rec_desc2 = parcel.readString();
    }
}
