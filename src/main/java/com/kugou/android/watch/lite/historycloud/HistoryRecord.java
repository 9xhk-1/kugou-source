package com.kugou.android.watch.lite.historycloud;

import com.kugou.android.watch.lite.common.INoGuard;
import f.z.d.g;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class HistoryRecord implements INoGuard {
    public static final a Companion = new a(null);
    public static final int TYPE_ADD = 1;
    private int action;
    private long mixId;
    private long opTime;
    private long playCount;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    public HistoryRecord() {
        this(0L, 0L, 0L, 0, 15, null);
    }

    public HistoryRecord(long j) {
        this(j, 0L, 0L, 0, 14, null);
    }

    public HistoryRecord(long j, long j2) {
        this(j, j2, 0L, 0, 12, null);
    }

    public HistoryRecord(long j, long j2, long j3) {
        this(j, j2, j3, 0, 8, null);
    }

    public HistoryRecord(long j, long j2, long j3, int i2) {
        this.mixId = j;
        this.opTime = j2;
        this.playCount = j3;
        this.action = i2;
    }

    public final long component1() {
        return this.mixId;
    }

    public final long component2() {
        return this.opTime;
    }

    public final long component3() {
        return this.playCount;
    }

    public final int component4() {
        return this.action;
    }

    public final HistoryRecord copy(long j, long j2, long j3, int i2) {
        return new HistoryRecord(j, j2, j3, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HistoryRecord)) {
            return false;
        }
        HistoryRecord historyRecord = (HistoryRecord) obj;
        return this.mixId == historyRecord.mixId && this.opTime == historyRecord.opTime && this.playCount == historyRecord.playCount && this.action == historyRecord.action;
    }

    public final int getAction() {
        return this.action;
    }

    public final long getMixId() {
        return this.mixId;
    }

    public final long getOpTime() {
        return this.opTime;
    }

    public final long getPlayCount() {
        return this.playCount;
    }

    public int hashCode() {
        long j = this.mixId;
        long j2 = this.opTime;
        int i2 = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        long j3 = this.playCount;
        return ((i2 + ((int) (j3 ^ (j3 >>> 32)))) * 31) + this.action;
    }

    public final JSONObject mapUploadSong() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("mxid", this.mixId);
        jSONObject.put("ot", this.opTime);
        jSONObject.put("pc", this.playCount);
        jSONObject.put("op", this.action);
        return jSONObject;
    }

    public final void setAction(int i2) {
        this.action = i2;
    }

    public final void setMixId(long j) {
        this.mixId = j;
    }

    public final void setOpTime(long j) {
        this.opTime = j;
    }

    public final void setPlayCount(long j) {
        this.playCount = j;
    }

    public String toString() {
        return "HistoryRecord(mixId=" + this.mixId + ", opTime=" + this.opTime + ", playCount=" + this.playCount + ", action=" + this.action + ')';
    }

    public /* synthetic */ HistoryRecord(long j, long j2, long j3, int i2, int i3, g gVar) {
        this((i3 & 1) != 0 ? 0L : j, (i3 & 2) != 0 ? 0L : j2, (i3 & 4) == 0 ? j3 : 0L, (i3 & 8) != 0 ? -1 : i2);
    }
}
