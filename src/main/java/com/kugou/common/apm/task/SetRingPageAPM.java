package com.kugou.common.apm.task;

import com.kugou.common.apm.ResponseHandlerForApm;
import com.kugou.common.apm.auto.YoungApmSessionModelImpl;
import com.kugou.common.apm.sdk.ApmDataKey;
import com.kugou.common.apm.sdk.ApmDataTypeID;
import com.kugou.common.apm.sdk.ApmFs;
import e.c.a.g.a.d.b.a;
import e.c.a.g.a.f.k.g.b;
import e.c.a.g.a.f.k.k.f;
import f.z.d.j;

/* JADX INFO: loaded from: classes2.dex */
public final class SetRingPageAPM {
    private String apmSession;
    private boolean hasReport;

    public static /* synthetic */ void fail$default(SetRingPageAPM setRingPageAPM, Integer num, String str, Integer num2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            num2 = null;
        }
        setRingPageAPM.fail(num, str, num2);
    }

    private final YoungApmSessionModelImpl getMode() {
        return YoungApmSessionModelImpl.with(ApmDataTypeID.SET_RING_PAGE);
    }

    public final void fail(Integer num, String str, Integer num2) {
        if (this.hasReport) {
            return;
        }
        try {
            String str2 = this.apmSession;
            if (str2 == null) {
                return;
            }
            a aVar = new a();
            if (num != null && num.intValue() == 1) {
                aVar.k(ResponseHandlerForApm.E1);
            } else {
                if (num != null && num.intValue() == 2) {
                    aVar.k(ResponseHandlerForApm.E1);
                }
                aVar.k(ResponseHandlerForApm.E5);
            }
            aVar.g(num == null ? null : num.toString());
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
            release();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void netFinish() {
        String str;
        if (this.hasReport || (str = this.apmSession) == null) {
            return;
        }
        getMode().add(str, ApmDataKey.NET_DELAY);
    }

    public final void release() {
        this.apmSession = null;
        this.hasReport = true;
    }

    public final void start() {
        if (this.hasReport) {
            return;
        }
        this.apmSession = getMode().start(ApmDataTypeID.SET_RING_PAGE);
    }

    public final void success(String str) {
        String str2;
        if (this.hasReport || (str2 = this.apmSession) == null) {
            return;
        }
        getMode().add(str2, ApmDataKey.PARA, str);
        getMode().add(str2, ApmDataKey.STATE, "1");
        getMode().end(str2);
        release();
    }

    public final void uiLoadFinish() {
        String str;
        if (this.hasReport || (str = this.apmSession) == null) {
            return;
        }
        getMode().add(str, ApmDataKey.UI_LOAD_TIME);
    }

    public final void fail(Throwable th, Integer num, String str) {
        if (this.hasReport) {
            return;
        }
        try {
            String str2 = this.apmSession;
            if (str2 == null) {
                return;
            }
            a netApmDataWhenSuccess = ResponseHandlerForApm.getNetApmDataWhenSuccess(f.d(th), "");
            if (th instanceof b) {
                netApmDataWhenSuccess.k(ResponseHandlerForApm.E4);
                netApmDataWhenSuccess.g(((b) th).a > 0 ? String.valueOf(((b) th).a) : ApmFs.PARSE_EXCEPTION);
            } else if (th instanceof e.c.a.b.a.a.a.a) {
                netApmDataWhenSuccess.k(ResponseHandlerForApm.E2);
                netApmDataWhenSuccess.g(String.valueOf(((e.c.a.b.a.a.a.a) th).a));
            }
            getMode().add(str2, ApmDataKey.POSITION, num == null ? null : num.toString());
            getMode().add(str2, ApmDataKey.TE, netApmDataWhenSuccess.c());
            getMode().add(str2, ApmDataKey.FS, netApmDataWhenSuccess.a());
            getMode().add(str2, ApmDataKey.STATE, "0");
            getMode().add(str2, ApmDataKey.PARA, str);
            getMode().end(str2);
            release();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
