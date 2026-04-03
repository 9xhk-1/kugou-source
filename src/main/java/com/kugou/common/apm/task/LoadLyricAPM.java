package com.kugou.common.apm.task;

import com.kugou.common.apm.ResponseHandlerForApm;
import com.kugou.common.apm.auto.YoungApmSessionModelImpl;
import com.kugou.common.apm.sdk.ApmDataKey;
import com.kugou.common.apm.sdk.ApmDataTypeID;
import e.c.a.g.a.d.b.a;
import f.z.d.g;
import f.z.d.j;

/* JADX INFO: loaded from: classes2.dex */
public final class LoadLyricAPM {
    public static final int SEARCH_ERROR_STEP_NULL = 4;
    public static final int TYPE_DOWNLOAD = 2;
    public static final int TYPE_PARSE = 3;
    public static final int TYPE_TRACKER = 1;
    public static final Type Type = new Type(null);
    private String apmSession;

    public static final class Type {
        private Type() {
        }

        public /* synthetic */ Type(g gVar) {
            this();
        }
    }

    private final YoungApmSessionModelImpl getMode() {
        return YoungApmSessionModelImpl.with(ApmDataTypeID.LYRIC_LOAD);
    }

    public final void addPara(String str) {
        j.e(str, ApmDataKey.PARA);
        String str2 = this.apmSession;
        if (str2 == null) {
            return;
        }
        getMode().add(str2, ApmDataKey.PARA, str);
    }

    public final void addState2(String str) {
        j.e(str, "state2");
        String str2 = this.apmSession;
        if (str2 == null) {
            return;
        }
        getMode().add(str2, ApmDataKey.STATE_2, str);
    }

    public final void cancel() {
        String str = this.apmSession;
        if (str == null) {
            return;
        }
        getMode().add(str, ApmDataKey.UI_LOAD_TIME);
        getMode().add(str, ApmDataKey.STATE, "0");
        getMode().add(str, ApmDataKey.TE, ResponseHandlerForApm.E6);
        getMode().end(str);
        this.apmSession = null;
    }

    public final void fail(int i2, String str, String str2, String str3) {
        j.e(str, "errCode");
        String str4 = this.apmSession;
        if (str4 == null) {
            return;
        }
        a aVar = new a();
        aVar.i(i2);
        aVar.k(ResponseHandlerForApm.E4);
        if (str2 != null) {
            aVar.k(str2);
        }
        aVar.g(str);
        if (str3 != null) {
            getMode().add(str4, ApmDataKey.STATE_1, str3);
        }
        getMode().add(str4, ApmDataKey.TE, aVar.c());
        getMode().add(str4, ApmDataKey.POSITION, String.valueOf(aVar.b()));
        getMode().add(str4, ApmDataKey.FS, aVar.a());
        getMode().add(str4, ApmDataKey.STATE, "0");
        getMode().end(str4);
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
        this.apmSession = getMode().start(ApmDataTypeID.LYRIC_LOAD);
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
}
