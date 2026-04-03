package com.kugou.common.apm.task;

import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import com.kugou.common.apm.ResponseHandlerForApm;
import com.kugou.common.apm.auto.YoungApmSessionModelImpl;
import com.kugou.common.apm.sdk.ApmDataKey;
import com.kugou.common.apm.sdk.ApmDataTypeID;
import e.c.a.g.a.d.b.a;
import e.c.a.g.a.f.e.b;
import e.c.a.g.a.f.e.c;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.u0;
import e.c.c.o.f;
import f.z.d.g;
import f.z.d.j;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class MusicRingToneAPM {
    public static final String KEY_DATA_RETYR_RINGTONG = "retry-ringtone";
    public static final int TYPE_DATA_RETYR_RINGTONG = 4;
    public static final int TYPE_DATA_SOURCE = 3;
    public static final int TYPE_NET_ERR = 1;
    public static final int TYPE_TRACKER = 2;
    public static final Type Type = new Type(null);
    private String apmSession;
    private final boolean isEnableConfigDynamics = c.a.a().getConfigAsBoolean(b.A2, true);

    public static final class Type {
        private Type() {
        }

        public /* synthetic */ Type(g gVar) {
            this();
        }
    }

    private final YoungApmSessionModelImpl getMode() {
        return YoungApmSessionModelImpl.with(ApmDataTypeID.MUSIC_RINGTONE);
    }

    public final void fail(int i2, int i3, String str) {
        j.e(str, "extra");
        fail(i2, i3, 0, str);
    }

    public final void netFinish() {
        String str = this.apmSession;
        if (str == null) {
            return;
        }
        getMode().add(str, ApmDataKey.NET_DELAY);
    }

    public final void release() {
        this.apmSession = null;
    }

    public final void start() {
        if (this.isEnableConfigDynamics) {
            this.apmSession = getMode().start(ApmDataTypeID.MUSIC_RINGTONE);
        }
    }

    public final void success() {
        String str = this.apmSession;
        if (str == null) {
            return;
        }
        getMode().add(str, ApmDataKey.UI_LOAD_TIME);
        getMode().add(str, ApmDataKey.STATE, "1");
        getMode().end(str);
        this.apmSession = null;
    }

    public final void fail(int i2, int i3, int i4, String str) {
        String string;
        j.e(str, "extra");
        String str2 = this.apmSession;
        if (str2 == null) {
            return;
        }
        a aVar = new a();
        aVar.i(i2);
        getMode().add(str2, ApmDataKey.STATE_1, String.valueOf(i4));
        getMode().add(str2, ApmDataKey.STATE_2, str);
        if (i2 == 1) {
            aVar.k(ResponseHandlerForApm.E1);
            aVar.g(String.valueOf(i3));
        } else if (i2 == 2) {
            aVar.k(ResponseHandlerForApm.E2);
            aVar.g(String.valueOf(i3));
        } else if (i2 == 3) {
            aVar.k(ResponseHandlerForApm.E4);
            aVar.g(String.valueOf(i3));
        } else if (i2 == 4) {
            aVar.k(ResponseHandlerForApm.E3);
            aVar.g(String.valueOf(i3));
        }
        getMode().add(str2, ApmDataKey.TE, aVar.c());
        getMode().add(str2, ApmDataKey.POSITION, String.valueOf(aVar.b()));
        getMode().add(str2, ApmDataKey.FS, aVar.a());
        getMode().add(str2, ApmDataKey.STATE, "0");
        try {
            KGMusicWrapper currentSong = e.c.a.g.a.d.x.b.b().getCurrentSong();
            String displayName = currentSong == null ? null : currentSong.getDisplayName();
            if (currentSong != null) {
                currentSong.getArtistName();
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("songName", displayName);
            jSONObject.put("fileSize", currentSong == null ? null : Long.valueOf(currentSong.getFileSize()));
            jSONObject.put("artistName", currentSong == null ? null : currentSong.getArtistName());
            jSONObject.put("hashValue", currentSong == null ? null : currentSong.getHashValue());
            jSONObject.put("duration", currentSong == null ? null : Long.valueOf(currentSong.getDuration()));
            jSONObject.put("channel", e.c.c.b.c);
            jSONObject.put("phoneBrand", l1.p());
            jSONObject.put("networkType", u0.j(f.a()));
            string = jSONObject.toString();
            j.d(string, "json.toString()");
        } catch (Exception unused) {
            string = "";
        }
        getMode().add(str2, ApmDataKey.PARA, string);
        getMode().end(str2);
        this.apmSession = null;
    }
}
