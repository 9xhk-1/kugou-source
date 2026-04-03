package com.kugou.common.apm.task;

import com.kugou.common.apm.ResponseHandlerForApm;
import com.kugou.common.apm.auto.YoungApmSessionModelImpl;
import com.kugou.common.apm.sdk.ApmDataKey;
import com.kugou.common.apm.sdk.ApmDataTypeID;
import e.c.a.g.a.d.b.a;
import f.z.d.j;

/* JADX INFO: loaded from: classes2.dex */
public final class VipEntryAPM {
    private String apmSession;

    private final YoungApmSessionModelImpl getMode() {
        return YoungApmSessionModelImpl.with(ApmDataTypeID.VIP_ENTRY_SHOW);
    }

    public final void fail(Integer num, String str) {
        String str2 = this.apmSession;
        if (str2 == null) {
            return;
        }
        a aVar = new a();
        if ((num != null && num.intValue() == 3) || ((num != null && num.intValue() == 1) || (num != null && num.intValue() == 6))) {
            aVar.k(ResponseHandlerForApm.E5);
        } else {
            aVar.k(ResponseHandlerForApm.E4);
        }
        aVar.g(num == null ? null : num.toString());
        getMode().add(str2, ApmDataKey.TE, aVar.c());
        getMode().add(str2, ApmDataKey.POSITION, j.l("", num));
        getMode().add(str2, ApmDataKey.FS, j.l("", num));
        getMode().add(str2, ApmDataKey.PARA, str);
        getMode().add(str2, ApmDataKey.STATE, "0");
        getMode().end(str2);
        this.apmSession = null;
    }

    public final void release() {
        this.apmSession = null;
    }

    public final void start() {
        this.apmSession = getMode().start(ApmDataTypeID.VIP_ENTRY_SHOW);
    }

    public final void success(String str) {
        String str2 = this.apmSession;
        if (str2 == null) {
            return;
        }
        getMode().add(str2, ApmDataKey.PARA, str);
        getMode().add(str2, ApmDataKey.STATE, "1");
        getMode().end(str2);
        this.apmSession = null;
    }
}
