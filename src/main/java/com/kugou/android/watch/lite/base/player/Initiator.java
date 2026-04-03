package com.kugou.android.watch.lite.base.player;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.kugou.android.watch.lite.base.uistructure.PageKey;
import com.kugou.android.watch.lite.common.INoGuard;
import e.c.a.g.a.s.g0;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class Initiator implements Parcelable, INoGuard {
    public static final Parcelable.Creator<Initiator> CREATOR = new a();
    public static final long ESP_ENSHRINE_SYNC = 1073741824;
    public static final long ESP_FX_MUSIC_SV = 16777216;
    public static final long ESP_IDENTIFY_APP = 8388608;
    public static final long ESP_KUQUN_MANAGER_PLAY = 67108864;
    public static final long ESP_NULL_FEATURE = 1048576;
    public static final long ESP_OPEN_FILE = 536870912;
    public static final long ESP_OUTSIDE_APP = 4194304;
    public static final long ESP_PERSONAL_FM = 134217728;
    public static final long ESP_REC_PANEL = 2147483648L;
    public static final long ESP_RUN_CHANNEL = 268435456;
    public static final long ESP_SPLASH_PUSH = 33554432;
    public static final long ESP_UNKNOWN = 1024;
    public static final long ESP_UNKNOWN_RESTORE_CHANNEL = 8192;
    public static final long ESP_UNKNOWN_RESTORE_MUSIC = 2048;
    public static final long ESP_UNKNOWN_SCAN_QUEUE = 32768;
    public static final long ESP_UNKNOWN_STORE_CHANNEL = 16384;
    public static final long ESP_UNKNOWN_STORE_MUSIC = 4096;
    public static final long ESP_WECHAT_SHARE = 2097152;
    public static final long EXC_GET_NULL_CURR = 2;
    public static final long EXC_PUT_NULL_CURR = 1;
    public static final long EXC_UI_LOST = 4;
    private Object[] carries;
    public String fo;
    public long pageCode;
    public String stack;
    public String url;

    public class a implements Parcelable.Creator<Initiator> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Initiator createFromParcel(Parcel parcel) {
            return new Initiator(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Initiator[] newArray(int i2) {
            return new Initiator[i2];
        }
    }

    public /* synthetic */ Initiator(Parcel parcel, a aVar) {
        this(parcel);
    }

    public static Initiator create(@NonNull PageKey pageKey) {
        return create(pageKey.getPageId(), pageKey.getPageStack(), pageKey.getFo()).carryPagePath(pageKey.getPagePath());
    }

    public static Initiator espCreate(long j) {
        return create(j, null);
    }

    public static Initiator fromJson(JSONObject jSONObject, Initiator initiator) {
        Initiator initiator2 = new Initiator();
        if (jSONObject != null) {
            initiator2.pageCode = jSONObject.optLong("a");
            initiator2.stack = jSONObject.optString("d");
            initiator2.url = jSONObject.optString("c");
        }
        if (jSONObject == null || initiator2.isInvalidate()) {
            initiator2.update(initiator);
        }
        return initiator2;
    }

    public static JSONObject toJson(Initiator initiator, Initiator initiator2) {
        JSONObject jSONObject = new JSONObject();
        if (initiator != null) {
            try {
                if (initiator.isInvalidate()) {
                    jSONObject.put("a", initiator2.pageCode);
                    jSONObject.put("d", initiator2.stack);
                    jSONObject.put("c", initiator2.url);
                } else {
                    jSONObject.put("a", initiator.pageCode);
                    jSONObject.put("d", initiator.stack);
                    jSONObject.put("c", initiator.url);
                }
            } catch (JSONException e2) {
                g0.k(e2);
            }
        } else {
            jSONObject.put("a", initiator2.pageCode);
            jSONObject.put("d", initiator2.stack);
            jSONObject.put("c", initiator2.url);
        }
        return jSONObject;
    }

    public Initiator carryPagePath(String str) {
        this.carries[0] = str;
        return this;
    }

    public Initiator copy() {
        Initiator initiatorCreate = create(this.pageCode, this.stack);
        initiatorCreate.url = this.url;
        return initiatorCreate;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean isDefault() {
        return this.pageCode == 1024;
    }

    public boolean isInvalidate() {
        return this.pageCode == 0;
    }

    public String peekPagePath() {
        return (String) this.carries[0];
    }

    public String toString() {
        return "[" + this.pageCode + "; " + this.stack + "; " + this.url + "]";
    }

    public void update(Initiator initiator) {
        if (initiator != null) {
            this.pageCode = initiator.pageCode;
            this.stack = initiator.stack;
            this.url = initiator.url;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.pageCode);
        parcel.writeString(this.stack);
        parcel.writeString(this.url);
    }

    private Initiator() {
        this.carries = new Object[1];
    }

    public static Initiator create(@NonNull e.c.a.g.a.d.c0.a aVar) {
        return create(aVar.a(), aVar.c()).carryPagePath(aVar.b());
    }

    private Initiator(Parcel parcel) {
        this.carries = new Object[1];
        this.pageCode = parcel.readLong();
        this.stack = parcel.readString();
        this.url = parcel.readString();
    }

    public static Initiator create(long j, String str) {
        Initiator initiator = new Initiator();
        initiator.pageCode = j;
        initiator.stack = str;
        return initiator;
    }

    public static Initiator create(long j, String str, String str2) {
        Initiator initiator = new Initiator();
        initiator.pageCode = j;
        initiator.stack = str;
        initiator.fo = str2;
        return initiator;
    }
}
