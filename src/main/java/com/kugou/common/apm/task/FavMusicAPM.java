package com.kugou.common.apm.task;

import com.kugou.common.apm.ResponseHandlerForApm;
import com.kugou.common.apm.auto.YoungApmSessionModelImpl;
import com.kugou.common.apm.sdk.ApmDataKey;
import com.kugou.common.apm.sdk.ApmDataTypeID;
import e.c.a.g.a.d.b.a;
import f.z.d.j;

/* JADX INFO: loaded from: classes2.dex */
public final class FavMusicAPM {
    private String apmSession;

    private final YoungApmSessionModelImpl getMode() {
        return YoungApmSessionModelImpl.with(ApmDataTypeID.SONG_FAV);
    }

    public final void cancel() {
        String str = this.apmSession;
        if (str == null) {
            return;
        }
        getMode().add(str, ApmDataKey.UI_LOAD_TIME);
        getMode().add(str, ApmDataKey.STATE, "0");
        getMode().add(str, ApmDataKey.TE, ResponseHandlerForApm.E1);
        getMode().end(str);
        this.apmSession = null;
    }

    public final void fail(Integer num, String str) {
        String str2 = this.apmSession;
        if (str2 == null) {
            return;
        }
        a aVar = new a();
        if ((num != null && 112 == num.intValue()) || ((num != null && 102 == num.intValue()) || ((num != null && 203 == num.intValue()) || (num != null && 104 == num.intValue())))) {
            aVar.k(ResponseHandlerForApm.E4);
        } else if ((num != null && 103 == num.intValue()) || (num != null && 202 == num.intValue())) {
            aVar.k(ResponseHandlerForApm.E2);
        } else if ((num != null && 106 == num.intValue()) || ((num != null && 107 == num.intValue()) || (num != null && 108 == num.intValue()))) {
            aVar.k(ResponseHandlerForApm.E1);
        } else if (num != null && 109 == num.intValue()) {
            aVar.k(ResponseHandlerForApm.E5);
        } else {
            aVar.k(ResponseHandlerForApm.E3);
        }
        getMode().add(str2, ApmDataKey.TE, aVar.c());
        getMode().add(str2, ApmDataKey.FS, j.l("", num));
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

    public final void start() {
        this.apmSession = getMode().start(ApmDataTypeID.SONG_FAV);
    }

    public final void success(Boolean bool) {
        String str = this.apmSession;
        if (str == null) {
            return;
        }
        getMode().add(str, ApmDataKey.UI_LOAD_TIME);
        getMode().add(str, ApmDataKey.STATE_1, j.a(bool, Boolean.TRUE) ? "1" : "2");
        getMode().add(str, ApmDataKey.STATE, "1");
        getMode().end(str);
        this.apmSession = null;
    }
}
