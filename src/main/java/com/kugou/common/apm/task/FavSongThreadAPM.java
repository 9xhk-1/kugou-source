package com.kugou.common.apm.task;

import com.kugou.common.apm.ResponseHandlerForApm;
import com.kugou.common.apm.auto.YoungApmSessionModelImpl;
import com.kugou.common.apm.sdk.ApmDataKey;
import com.kugou.common.apm.sdk.ApmDataTypeID;
import e.c.a.g.a.d.b.a;
import f.z.d.j;

/* JADX INFO: loaded from: classes2.dex */
public final class FavSongThreadAPM {
    private String apmSession;
    private int choosePicType;

    public static /* synthetic */ void fail$default(FavSongThreadAPM favSongThreadAPM, Integer num, String str, Integer num2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            num2 = null;
        }
        favSongThreadAPM.fail(num, str, num2);
    }

    private final YoungApmSessionModelImpl getMode() {
        return YoungApmSessionModelImpl.with(ApmDataTypeID.FAV_SONG_LOAD);
    }

    public final void fail(Integer num, String str, Integer num2) {
        String str2 = this.apmSession;
        if (str2 == null) {
            return;
        }
        a aVar = new a();
        if ((num != null && num.intValue() == 21) || ((num != null && num.intValue() == 22) || ((num != null && num.intValue() == 1) || ((num != null && num.intValue() == 2) || ((num != null && num.intValue() == 3) || (num != null && num.intValue() == 4)))))) {
            aVar.k(ResponseHandlerForApm.E4);
        } else {
            aVar.k(ResponseHandlerForApm.E5);
        }
        getMode().add(str2, ApmDataKey.TE, aVar.c());
        getMode().add(str2, ApmDataKey.POSITION, j.l("", num));
        if (num2 != null) {
            getMode().add(str2, ApmDataKey.FS, j.l("", num2));
        } else {
            getMode().add(str2, ApmDataKey.FS, j.l("60", num));
        }
        getMode().add(str2, ApmDataKey.PARA, str);
        getMode().add(str2, ApmDataKey.STATE, "0");
        getMode().end(str2);
        this.apmSession = null;
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

    public final void start(int i2) {
        this.choosePicType = i2;
        this.apmSession = getMode().start(ApmDataTypeID.FAV_SONG_LOAD);
    }

    public final void success(String str) {
        String str2 = this.apmSession;
        if (str2 == null) {
            return;
        }
        getMode().add(str2, ApmDataKey.UI_LOAD_TIME);
        getMode().add(str2, ApmDataKey.PARA, str);
        getMode().add(str2, ApmDataKey.STATE_1, j.l("", Integer.valueOf(this.choosePicType)));
        getMode().add(str2, ApmDataKey.STATE, "1");
        getMode().end(str2);
        this.apmSession = null;
    }
}
