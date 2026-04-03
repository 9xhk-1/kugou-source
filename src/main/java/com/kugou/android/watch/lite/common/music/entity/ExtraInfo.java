package com.kugou.android.watch.lite.common.music.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.kugou.android.watch.lite.base.musicfees.mediastore.entity.TrackerInfo;
import com.kugou.android.watch.lite.common.INoGuard;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ExtraInfo implements Parcelable, Serializable, INoGuard {
    public static final Parcelable.Creator<ExtraInfo> CREATOR = new a();
    public static final int DEFAULT_CLIMAX = -1;
    public CExtraInfo cExtraInfo;
    public int personFmClimaxEnd;
    public int personFmClimaxStart;
    public TrackerInfo trackerInfo;

    public class a implements Parcelable.Creator<ExtraInfo> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ExtraInfo createFromParcel(Parcel parcel) {
            return new ExtraInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ExtraInfo[] newArray(int i2) {
            return new ExtraInfo[i2];
        }
    }

    public ExtraInfo() {
        this.personFmClimaxStart = -1;
        this.personFmClimaxEnd = -1;
    }

    public static ExtraInfo fromJsonObj(JSONObject jSONObject) {
        ExtraInfo extraInfo = new ExtraInfo();
        if (jSONObject != null) {
            extraInfo.personFmClimaxStart = jSONObject.optInt("personFmClimaxStart", -1);
            extraInfo.personFmClimaxEnd = jSONObject.optInt("personFmClimaxEnd", -1);
            if (jSONObject.has("trackerInfo")) {
                try {
                    extraInfo.trackerInfo = TrackerInfo.fromJsonObj(jSONObject.getJSONObject("trackerInfo"));
                } catch (JSONException unused) {
                }
            }
            if (jSONObject.has("cExtraInfo")) {
                try {
                    extraInfo.cExtraInfo = CExtraInfo.fromJsonObj(jSONObject.getJSONObject("cExtraInfo"));
                } catch (JSONException unused2) {
                }
            }
        }
        return extraInfo;
    }

    public void apply(ExtraInfo extraInfo) {
        if (extraInfo == null) {
            return;
        }
        int i2 = extraInfo.personFmClimaxStart;
        if (i2 != -1) {
            this.personFmClimaxStart = i2;
        }
        int i3 = extraInfo.personFmClimaxEnd;
        if (i3 != -1) {
            this.personFmClimaxEnd = i3;
        }
        TrackerInfo trackerInfo = extraInfo.trackerInfo;
        if (trackerInfo != null) {
            this.trackerInfo = trackerInfo;
        }
        CExtraInfo cExtraInfo = extraInfo.cExtraInfo;
        if (cExtraInfo != null) {
            CExtraInfo cExtraInfo2 = this.cExtraInfo;
            if (cExtraInfo2 == null) {
                this.cExtraInfo = cExtraInfo;
            } else {
                cExtraInfo2.apply(cExtraInfo);
            }
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void setTrackerInfoNull() {
        this.trackerInfo = null;
    }

    public JSONObject toJsonObj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("personFmClimaxStart", this.personFmClimaxStart);
            jSONObject.put("personFmClimaxEnd", this.personFmClimaxEnd);
            TrackerInfo trackerInfo = this.trackerInfo;
            if (trackerInfo != null) {
                jSONObject.put("trackerInfo", trackerInfo.toJson());
            }
            CExtraInfo cExtraInfo = this.cExtraInfo;
            if (cExtraInfo != null) {
                jSONObject.put("cExtraInfo", cExtraInfo.toJson());
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.personFmClimaxStart);
        parcel.writeInt(this.personFmClimaxEnd);
        parcel.writeParcelable(this.trackerInfo, 0);
        parcel.writeParcelable(this.cExtraInfo, 0);
    }

    public ExtraInfo(Parcel parcel) {
        this.personFmClimaxStart = -1;
        this.personFmClimaxEnd = -1;
        this.personFmClimaxStart = parcel.readInt();
        this.personFmClimaxEnd = parcel.readInt();
        this.trackerInfo = (TrackerInfo) parcel.readParcelable(TrackerInfo.class.getClassLoader());
        this.cExtraInfo = (CExtraInfo) parcel.readParcelable(CExtraInfo.class.getClassLoader());
    }
}
