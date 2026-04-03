package com.kugou.common.apm.task;

import com.kugou.common.apm.ResponseHandlerForApm;
import com.kugou.common.apm.auto.YoungApmSessionModelImpl;
import com.kugou.common.apm.sdk.ApmDataKey;
import com.kugou.common.apm.sdk.ApmDataTypeID;
import e.c.a.g.a.d.b.a;
import f.z.d.j;

/* JADX INFO: loaded from: classes2.dex */
public final class LoginRcmAPM {
    private String apmSession;

    public static /* synthetic */ void fail$default(LoginRcmAPM loginRcmAPM, Integer num, Integer num2, String str, Integer num3, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            num3 = 0;
        }
        loginRcmAPM.fail(num, num2, str, num3);
    }

    private final YoungApmSessionModelImpl getMode() {
        return YoungApmSessionModelImpl.with(ApmDataTypeID.LOGIN);
    }

    public static /* synthetic */ void success$default(LoginRcmAPM loginRcmAPM, String str, Integer num, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            num = 0;
        }
        loginRcmAPM.success(str, num);
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

    public final void fail(Integer num, Integer num2, String str, Integer num3) {
        String str2 = this.apmSession;
        if (str2 == null) {
            return;
        }
        a aVar = new a();
        aVar.g(num2 == null ? null : num2.toString());
        if (num2 != null && num2.intValue() == 20020) {
            aVar.k(ResponseHandlerForApm.E1);
        } else if (num2 != null && num2.intValue() == 20021) {
            aVar.k(ResponseHandlerForApm.E2);
        } else if (num2 != null && num2.intValue() == 20017) {
            aVar.k(ResponseHandlerForApm.E3);
        } else {
            aVar.k(ResponseHandlerForApm.E4);
        }
        getMode().add(str2, ApmDataKey.TE, aVar.c());
        getMode().add(str2, ApmDataKey.FS, aVar.a());
        getMode().add(str2, ApmDataKey.POSITION, j.l("", num3));
        getMode().add(str2, ApmDataKey.PARA, str);
        getMode().add(str2, ApmDataKey.STATE_1, j.l("", num));
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
        this.apmSession = getMode().start(ApmDataTypeID.LOGIN);
    }

    public final void success(String str, Integer num) {
        String str2 = this.apmSession;
        if (str2 == null) {
            return;
        }
        getMode().add(str2, ApmDataKey.POSITION, j.l("", num));
        getMode().add(str2, ApmDataKey.PARA, str);
        getMode().add(str2, ApmDataKey.STATE, "1");
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
