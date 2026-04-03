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
public final class VipPayCodeLoadAPM {
    private String apmSession;
    private int choosePicType;
    private String productName = "";

    public static /* synthetic */ void fail$default(VipPayCodeLoadAPM vipPayCodeLoadAPM, Integer num, String str, Integer num2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            num2 = null;
        }
        vipPayCodeLoadAPM.fail(num, str, num2);
    }

    private final YoungApmSessionModelImpl getMode() {
        return YoungApmSessionModelImpl.with(ApmDataTypeID.VIP_CODE_SHOW);
    }

    public final void fail(Integer num, String str, Integer num2) {
        String str2 = this.apmSession;
        if (str2 == null) {
            return;
        }
        a aVar = new a();
        if ((num != null && num.intValue() == 1) || ((num != null && num.intValue() == 2) || (num != null && num.intValue() == 20))) {
            aVar.k(ResponseHandlerForApm.E4);
        } else if ((num != null && num.intValue() == 31) || (num != null && num.intValue() == 3)) {
            aVar.k(ResponseHandlerForApm.E6);
        } else if ((num != null && num.intValue() == 37) || ((num != null && num.intValue() == 38) || ((num != null && num.intValue() == 39) || ((num != null && num.intValue() == 40) || (num != null && num.intValue() == 41))))) {
            aVar.k(ResponseHandlerForApm.E5);
        } else {
            aVar.k(ResponseHandlerForApm.E2);
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
        getMode().add(str2, ApmDataKey.STATE_1, j.l("", Integer.valueOf(this.choosePicType)));
        getMode().add(str2, ApmDataKey.STATE_2, j.l("", this.productName));
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

    public final void start(int i2, String str) {
        j.e(str, "name");
        this.choosePicType = i2;
        this.productName = str;
        this.apmSession = getMode().start(ApmDataTypeID.VIP_CODE_SHOW);
    }

    public final void success(String str) {
        String str2 = this.apmSession;
        if (str2 == null) {
            return;
        }
        getMode().add(str2, ApmDataKey.UI_LOAD_TIME);
        getMode().add(str2, ApmDataKey.PARA, str);
        getMode().add(str2, ApmDataKey.STATE_1, j.l("", Integer.valueOf(this.choosePicType)));
        getMode().add(str2, ApmDataKey.STATE_2, j.l("", this.productName));
        getMode().add(str2, ApmDataKey.STATE, "1");
        getMode().end(str2);
        this.apmSession = null;
    }

    public final void fail(Throwable th, Integer num, String str) {
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
            getMode().add(str2, ApmDataKey.STATE_1, j.l("", Integer.valueOf(this.choosePicType)));
            getMode().add(str2, ApmDataKey.STATE_2, j.l("", this.productName));
            getMode().add(str2, ApmDataKey.STATE, "0");
            getMode().add(str2, ApmDataKey.PARA, str);
            getMode().end(str2);
            this.apmSession = null;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
