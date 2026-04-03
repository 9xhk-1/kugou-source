package com.kugou.common.apm.task;

import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import com.kugou.common.apm.ResponseHandlerForApm;
import com.kugou.common.apm.auto.YoungApmSessionModelImpl;
import com.kugou.common.apm.sdk.ApmDataKey;
import com.kugou.common.apm.sdk.ApmDataTypeID;
import com.kugou.common.player.kgplayer.ErrorCodeConvert;
import e.c.a.g.a.d.b.a;
import e.c.a.g.a.d.x.b;
import f.e0.n;
import f.z.d.g;

/* JADX INFO: loaded from: classes2.dex */
public final class MusicPlayAPM {
    public static final int TYPE_DATA_SOURCE = 3;
    public static final int TYPE_NET_ERR = 1;
    public static final int TYPE_OTHER = 4;
    public static final int TYPE_TRACKER = 2;
    public static final Type Type = new Type(null);
    private String apmSession;

    public static final class Type {
        private Type() {
        }

        public /* synthetic */ Type(g gVar) {
            this();
        }
    }

    private final void addTEFSPO(a aVar, int i2) {
        ErrorCodeConvert.ErrorCode errorCodeEnum = ErrorCodeConvert.getErrorCodeEnum(i2);
        if (errorCodeEnum != null) {
            aVar.k(errorCodeEnum.getEMode().getMode());
            aVar.g(String.valueOf(errorCodeEnum.getErrorcode()));
        } else {
            aVar.k(ResponseHandlerForApm.E4);
            aVar.g(String.valueOf(i2));
        }
    }

    private final YoungApmSessionModelImpl getMode() {
        return YoungApmSessionModelImpl.with(ApmDataTypeID.MUSIC_PLAY);
    }

    public final void cancel() {
        String str = this.apmSession;
        if (str == null) {
            return;
        }
        getMode().add(str, ApmDataKey.UI_LOAD_TIME);
        getMode().add(str, ApmDataKey.STATE, "0");
        getMode().add(str, ApmDataKey.TE, ResponseHandlerForApm.E6);
        getMode().add(str, ApmDataKey.PARA, getCurrentSongStr());
        getMode().end(str);
        this.apmSession = null;
    }

    public final void fail(int i2, int i3, int i4) {
        fail(i2, i3, i4, 0);
    }

    public final String getCurrentSongDetailStr() {
        try {
            KGMusicWrapper currentSong = b.b().getCurrentSong();
            if (currentSong == null) {
                return "";
            }
            String string = currentSong.toString();
            return string == null ? "" : string;
        } catch (Exception unused) {
            return "";
        }
    }

    public final String getCurrentSongStr() {
        String displayName;
        try {
            KGMusicWrapper currentSong = b.b().getCurrentSong();
            StringBuilder sb = new StringBuilder();
            sb.append("mixId=");
            Boolean boolValueOf = null;
            sb.append(currentSong == null ? null : Long.valueOf(currentSong.getMixId()));
            sb.append("_hashValue=");
            sb.append((Object) (currentSong == null ? null : currentSong.getHashValue()));
            sb.append("_displayName=");
            sb.append((Object) ((currentSong == null || (displayName = currentSong.getDisplayName()) == null) ? null : n.q(displayName, " ", "", false, 4, null)));
            sb.append("_isListenPart=");
            sb.append(currentSong == null ? null : Boolean.valueOf(currentSong.isListenPart()));
            sb.append("_isNeedListenPart=");
            if (currentSong != null) {
                boolValueOf = Boolean.valueOf(currentSong.isNeedListenPart());
            }
            sb.append(boolValueOf);
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
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
        this.apmSession = getMode().start(ApmDataTypeID.MUSIC_PLAY);
    }

    public final void success() {
        String str = this.apmSession;
        if (str == null) {
            return;
        }
        getMode().add(str, ApmDataKey.UI_LOAD_TIME);
        getMode().add(str, ApmDataKey.STATE, "1");
        getMode().add(str, ApmDataKey.PARA, getCurrentSongStr());
        getMode().end(str);
        this.apmSession = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void fail(int r4, int r5, int r6, int r7) {
        /*
            r3 = this;
            java.lang.String r0 = r3.apmSession
            if (r0 != 0) goto L6
            goto Lc3
        L6:
            e.c.a.g.a.d.b.a r1 = new e.c.a.g.a.d.b.a
            r1.<init>()
            r1.i(r4)
            r2 = 1
            if (r4 == r2) goto L32
            r2 = 2
            if (r4 == r2) goto L1f
            r2 = 3
            if (r4 == r2) goto L1b
            r2 = 4
            if (r4 == r2) goto L1f
            goto L3e
        L1b:
            r3.addTEFSPO(r1, r5)
            goto L3e
        L1f:
            java.lang.String r4 = "E2"
            r1.k(r4)
            if (r5 <= 0) goto L2e
            java.lang.String r4 = java.lang.String.valueOf(r5)
            r1.g(r4)
            goto L3e
        L2e:
            r3.addTEFSPO(r1, r5)
            goto L3e
        L32:
            java.lang.String r4 = "E1"
            r1.k(r4)
            java.lang.String r4 = java.lang.String.valueOf(r5)
            r1.g(r4)
        L3e:
            com.kugou.common.apm.auto.YoungApmSessionModelImpl r4 = r3.getMode()
            java.lang.String r5 = r1.c()
            java.lang.String r2 = "te"
            r4.add(r0, r2, r5)
            com.kugou.common.apm.auto.YoungApmSessionModelImpl r4 = r3.getMode()
            int r5 = r1.b()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.lang.String r2 = "position"
            r4.add(r0, r2, r5)
            com.kugou.common.apm.auto.YoungApmSessionModelImpl r4 = r3.getMode()
            java.lang.String r5 = r1.a()
            java.lang.String r1 = "fs"
            r4.add(r0, r1, r5)
            com.kugou.common.apm.auto.YoungApmSessionModelImpl r4 = r3.getMode()
            java.lang.String r5 = "state"
            java.lang.String r1 = "0"
            r4.add(r0, r5, r1)
            com.kugou.common.apm.auto.YoungApmSessionModelImpl r4 = r3.getMode()
            java.lang.String r5 = r3.getCurrentSongDetailStr()
            java.lang.String r1 = "para"
            r4.add(r0, r1, r5)
            com.kugou.common.apm.auto.YoungApmSessionModelImpl r4 = r3.getMode()
            java.lang.String r5 = java.lang.String.valueOf(r6)
            java.lang.String r6 = "state_1"
            r4.add(r0, r6, r5)
            com.kugou.common.apm.auto.YoungApmSessionModelImpl r4 = r3.getMode()
            java.lang.String r5 = java.lang.String.valueOf(r7)
            java.lang.String r6 = "state_2"
            r4.add(r0, r6, r5)
            com.kugou.common.apm.auto.YoungApmSessionModelImpl r4 = r3.getMode()
            boolean r5 = e.c.a.g.a.r.b.O()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.lang.String r6 = "offline1"
            r4.add(r0, r6, r5)
            com.kugou.common.apm.auto.YoungApmSessionModelImpl r4 = r3.getMode()
            java.lang.String r5 = r3.getCurrentSongStr()
            java.lang.String r6 = "offline2"
            r4.add(r0, r6, r5)
            com.kugou.common.apm.auto.YoungApmSessionModelImpl r4 = r3.getMode()
            r4.end(r0)
            r4 = 0
            r3.apmSession = r4
        Lc3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kugou.common.apm.task.MusicPlayAPM.fail(int, int, int, int):void");
    }
}
