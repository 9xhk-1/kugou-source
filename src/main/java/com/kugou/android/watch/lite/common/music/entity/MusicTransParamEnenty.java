package com.kugou.android.watch.lite.common.music.entity;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.room.Entity;
import com.kugou.android.watch.lite.common.INoGuard;
import e.c.a.g.a.d.f.c.a.i;
import e.c.a.g.a.s.r0;
import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Entity(tableName = "music_trans_param")
@i(tableName = "music_trans_param")
public class MusicTransParamEnenty implements Parcelable, Serializable, INoGuard {
    public static final int ALBUM_LISTEN_PART = 1;
    public static final int ALL_QUALITY_FREE = 1;
    public static final Parcelable.Creator<MusicTransParamEnenty> CREATOR = new a();
    public static final int LIMITED_FREE = 1;
    public static final int NOT_LISTEN = 0;
    public static final int SONG_LISTEN_PART = 2;
    public static final int STUDY_ROOM_CAN_NOT_LISTEN = 99;
    private int allQualityFree;
    private int display;
    private int fromCache;
    private int limitedFree;
    private int musicpackAdvance;
    private int have_listen_part = 0;
    private int displayRate = -1;
    private int pay_block_tpl = -1;

    public class a implements Parcelable.Creator<MusicTransParamEnenty> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MusicTransParamEnenty createFromParcel(Parcel parcel) {
            MusicTransParamEnenty musicTransParamEnenty = new MusicTransParamEnenty();
            musicTransParamEnenty.musicpackAdvance = parcel.readInt();
            musicTransParamEnenty.have_listen_part = parcel.readInt();
            musicTransParamEnenty.allQualityFree = parcel.readInt();
            musicTransParamEnenty.limitedFree = parcel.readInt();
            musicTransParamEnenty.fromCache = parcel.readInt();
            musicTransParamEnenty.display = parcel.readInt();
            musicTransParamEnenty.displayRate = parcel.readInt();
            musicTransParamEnenty.pay_block_tpl = parcel.readInt();
            return musicTransParamEnenty;
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public MusicTransParamEnenty[] newArray(int i2) {
            return new MusicTransParamEnenty[i2];
        }
    }

    public static void jsonToEnenty(JSONObject jSONObject, r0.a aVar) {
        if (jSONObject == null || aVar == null) {
            return;
        }
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("musicTransParamEnenty");
            if (jSONObjectOptJSONObject != null) {
                MusicTransParamEnenty musicTransParamEnenty = new MusicTransParamEnenty();
                musicTransParamEnenty.musicpackAdvance = jSONObjectOptJSONObject.getInt("musicpackAdvance");
                musicTransParamEnenty.have_listen_part = jSONObjectOptJSONObject.getInt("have_listen_part");
                musicTransParamEnenty.allQualityFree = jSONObjectOptJSONObject.optInt("all_quality_free");
                musicTransParamEnenty.limitedFree = jSONObjectOptJSONObject.optInt("limited_free");
                musicTransParamEnenty.fromCache = jSONObjectOptJSONObject.optInt("fromCache");
                musicTransParamEnenty.display = jSONObjectOptJSONObject.optInt("display");
                musicTransParamEnenty.displayRate = jSONObjectOptJSONObject.optInt("display_rate");
                musicTransParamEnenty.pay_block_tpl = jSONObjectOptJSONObject.optInt("pay_block_tpl");
                aVar.setMusicTransParamEnenty(musicTransParamEnenty);
            }
        } catch (Exception unused) {
        }
    }

    public static void toEntity(Parcel parcel, r0.a aVar) {
        if (parcel == null || aVar == null || parcel.readInt() != 1) {
            return;
        }
        aVar.setMusicTransParamEnenty((MusicTransParamEnenty) parcel.readParcelable(MusicTransParamEnenty.class.getClassLoader()));
    }

    public static void toJSONObject(JSONObject jSONObject, r0.a aVar) {
        if (aVar != null) {
            try {
                if (aVar.getMusicTransParamEnenty() == null || jSONObject == null) {
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("musicpackAdvance", aVar.getMusicTransParamEnenty().musicpackAdvance);
                jSONObject2.put("have_listen_part", aVar.getMusicTransParamEnenty().have_listen_part);
                jSONObject2.put("all_quality_free", aVar.getMusicTransParamEnenty().allQualityFree);
                jSONObject2.put("limited_free", aVar.getMusicTransParamEnenty().limitedFree);
                jSONObject2.put("fromCache", aVar.getMusicTransParamEnenty().fromCache);
                jSONObject2.put("display", aVar.getMusicTransParamEnenty().display);
                jSONObject2.put("display_rate", aVar.getMusicTransParamEnenty().displayRate);
                jSONObject2.put("pay_block_tpl", aVar.getMusicTransParamEnenty().pay_block_tpl);
                jSONObject.put("musicTransParamEnenty", jSONObject2);
            } catch (Exception unused) {
            }
        }
    }

    public static void toParcel(Parcel parcel, int i2, r0.a aVar) {
        if (parcel == null || aVar == null) {
            return;
        }
        if (aVar.getMusicTransParamEnenty() == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeParcelable(aVar.getMusicTransParamEnenty(), i2);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAllQualityFree() {
        return this.allQualityFree;
    }

    public int getDisplay() {
        return this.display;
    }

    public int getDisplayRate() {
        return this.displayRate;
    }

    public int getHave_listen_part() {
        return this.have_listen_part;
    }

    public int getLimitedFree() {
        return this.limitedFree;
    }

    public int getMusicpackAdvance() {
        return this.musicpackAdvance;
    }

    public int getPay_block_tpl() {
        return this.pay_block_tpl;
    }

    public boolean isFromCache() {
        return this.fromCache == 1;
    }

    public void setAllQualityFree(int i2) {
        this.allQualityFree = i2;
    }

    public void setDisplay(int i2) {
        this.display = i2;
    }

    public void setDisplayRate(int i2) {
        this.displayRate = i2;
    }

    public void setFromCache(boolean z) {
        this.fromCache = z ? 1 : 0;
    }

    public void setHave_listen_part(int i2) {
        this.have_listen_part = i2;
    }

    public void setLimitedFree(int i2) {
        this.limitedFree = i2;
    }

    public void setMusicpackAdvance(int i2) {
        this.musicpackAdvance = i2;
    }

    public void setPay_block_tpl(int i2) {
        this.pay_block_tpl = i2;
    }

    public String toString() {
        return "MusicTransParamEnenty{allQualityFree=" + this.allQualityFree + ", limitedFree=" + this.limitedFree + ", musicpackAdvance=" + this.musicpackAdvance + ", have_listen_part=" + this.have_listen_part + ", fromCache=" + this.fromCache + ", display=" + this.display + ", displayRate=" + this.displayRate + ", pay_block_tpl=" + this.pay_block_tpl + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.musicpackAdvance);
        parcel.writeInt(this.have_listen_part);
        parcel.writeInt(this.allQualityFree);
        parcel.writeInt(this.limitedFree);
        parcel.writeInt(this.fromCache);
        parcel.writeInt(this.display);
        parcel.writeInt(this.displayRate);
        parcel.writeInt(this.pay_block_tpl);
    }
}
