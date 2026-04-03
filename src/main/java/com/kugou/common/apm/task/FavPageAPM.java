package com.kugou.common.apm.task;

import com.kugou.common.apm.ResponseHandlerForApm;
import com.kugou.common.apm.auto.YoungApmSessionModelImpl;
import com.kugou.common.apm.sdk.ApmDataKey;
import com.kugou.common.apm.sdk.ApmDataTypeID;
import e.c.a.g.a.d.b.a;
import e.c.a.g.a.f.m.b;
import f.z.d.j;

/* JADX INFO: loaded from: classes2.dex */
public final class FavPageAPM {
    private String apmSession;

    private final YoungApmSessionModelImpl getMode() {
        return YoungApmSessionModelImpl.with(ApmDataTypeID.FAV_PAGE_LOAD);
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
        aVar.g(num == null ? null : num.toString());
        aVar.k(ResponseHandlerForApm.E4);
        int iK = b.m().k();
        if (iK > 0) {
            if (iK == 4) {
                aVar.k(ResponseHandlerForApm.E5);
            } else {
                aVar.k(ResponseHandlerForApm.E2);
            }
        }
        getMode().add(str2, ApmDataKey.TE, aVar.c());
        getMode().add(str2, ApmDataKey.FS, aVar.a());
        getMode().add(str2, ApmDataKey.POSITION, j.l("", Integer.valueOf(iK)));
        getMode().add(str2, ApmDataKey.PARA, str);
        getMode().add(str2, ApmDataKey.STATE, "0");
        getMode().add(str2, ApmDataKey.STATE_1, j.l("", Integer.valueOf(b.m().e())));
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
        this.apmSession = getMode().start(ApmDataTypeID.FAV_PAGE_LOAD);
    }

    public final void success(String str) {
        int iE = b.m().e();
        int iK = b.m().k();
        if (iE > 0 && iK > 0) {
            str = j.l(str, ",有数据，但是接口失败了");
        }
        String str2 = this.apmSession;
        if (str2 == null) {
            return;
        }
        getMode().add(str2, ApmDataKey.PARA, str);
        getMode().add(str2, ApmDataKey.STATE, "1");
        getMode().add(str2, ApmDataKey.STATE_1, j.l("", Integer.valueOf(b.m().e())));
        getMode().add(str2, ApmDataKey.STATE_2, j.l("", Integer.valueOf(b.m().k())));
        getMode().end(str2);
        this.apmSession = null;
    }

    public final void uiLoadTime() {
        String str = this.apmSession;
        if (str == null) {
            return;
        }
        getMode().add(str, ApmDataKey.UI_LOAD_TIME);
    }
}
