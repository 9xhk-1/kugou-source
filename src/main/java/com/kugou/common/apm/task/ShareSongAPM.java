package com.kugou.common.apm.task;

import com.kugou.common.apm.auto.YoungApmSessionModelImpl;
import com.kugou.common.apm.sdk.ApmDataKey;
import com.kugou.common.apm.sdk.ApmDataTypeID;

/* JADX INFO: loaded from: classes2.dex */
public final class ShareSongAPM {
    private String apmSession;

    public static /* synthetic */ void fail$default(ShareSongAPM shareSongAPM, Integer num, String str, Integer num2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            num2 = null;
        }
        shareSongAPM.fail(num, str, num2);
    }

    private final YoungApmSessionModelImpl getMode() {
        return YoungApmSessionModelImpl.with(ApmDataTypeID.SONG_SHARE_LOAD);
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x0072 A[Catch: Exception -> 0x00d4, TryCatch #0 {Exception -> 0x00d4, blocks: (B:3:0x0002, B:6:0x0008, B:10:0x0013, B:52:0x0072, B:57:0x007e, B:60:0x009f, B:62:0x00b6, B:61:0x00ab, B:56:0x007a, B:50:0x0068, B:47:0x005c, B:49:0x0062, B:41:0x0050, B:51:0x006c, B:36:0x0046, B:30:0x003b, B:25:0x0031, B:20:0x0027, B:15:0x001d), top: B:67:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void fail(java.lang.Integer r7, java.lang.String r8, java.lang.Integer r9) {
        /*
            Method dump skipped, instruction units count: 217
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kugou.common.apm.task.ShareSongAPM.fail(java.lang.Integer, java.lang.String, java.lang.Integer):void");
    }

    public final void release() {
        this.apmSession = null;
    }

    public final void start() {
        this.apmSession = getMode().start(ApmDataTypeID.SONG_SHARE_LOAD);
    }

    public final void success(String str) {
        String str2 = this.apmSession;
        if (str2 == null) {
            return;
        }
        getMode().add(str2, ApmDataKey.UI_LOAD_TIME);
        getMode().add(str2, ApmDataKey.PARA, str);
        getMode().add(str2, ApmDataKey.STATE, "1");
        getMode().end(str2);
        this.apmSession = null;
    }
}
