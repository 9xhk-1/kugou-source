package com.kugou.android.watch.lite.common.music.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.kugou.android.watch.lite.common.INoGuard;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class CExtraInfo implements Parcelable, Serializable, INoGuard {
    public static final Parcelable.Creator<CExtraInfo> CREATOR = new a();
    private String source;

    public class a implements Parcelable.Creator<CExtraInfo> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public CExtraInfo createFromParcel(Parcel parcel) {
            return new CExtraInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public CExtraInfo[] newArray(int i2) {
            return new CExtraInfo[i2];
        }
    }

    private CExtraInfo() {
        this.source = "";
    }

    public static ExtraInfo addSource(String str) {
        ExtraInfo extraInfo = new ExtraInfo();
        CExtraInfo cExtraInfo = new CExtraInfo();
        cExtraInfo.setSource(str);
        extraInfo.cExtraInfo = cExtraInfo;
        return extraInfo;
    }

    public static CExtraInfo fromJsonObj(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        CExtraInfo cExtraInfo = new CExtraInfo();
        cExtraInfo.setSource(jSONObject.optString("source"));
        return cExtraInfo;
    }

    private void setSource(String str) {
        this.source = str;
    }

    public void apply(CExtraInfo cExtraInfo) {
        if (TextUtils.isEmpty(cExtraInfo.source)) {
            return;
        }
        this.source = cExtraInfo.source;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getSource() {
        return this.source;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("source", this.source);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.source);
    }

    public CExtraInfo(Parcel parcel) {
        this.source = "";
        this.source = parcel.readString();
    }
}
