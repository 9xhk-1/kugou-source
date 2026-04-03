package com.kugou.common.apm.task;

import com.kugou.common.apm.ResponseHandlerForApm;
import com.kugou.common.apm.auto.YoungApmSessionModelImpl;
import com.kugou.common.apm.sdk.ApmDataKey;
import com.kugou.common.apm.sdk.ApmDataTypeID;
import com.kugou.common.apm.sdk.ApmFs;
import e.c.a.g.a.d.b.a;
import e.c.a.g.a.f.k.g.b;
import e.c.a.g.a.f.k.k.f;

/* JADX INFO: loaded from: classes2.dex */
public final class SetRingClickBtnAPM {
    private String apmSession;

    public static /* synthetic */ void fail$default(SetRingClickBtnAPM setRingClickBtnAPM, Integer num, String str, Integer num2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            num2 = null;
        }
        setRingClickBtnAPM.fail(num, str, num2);
    }

    private final YoungApmSessionModelImpl getMode() {
        return YoungApmSessionModelImpl.with(ApmDataTypeID.SET_RING_CLICK);
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x005c A[Catch: Exception -> 0x00c8, TryCatch #0 {Exception -> 0x00c8, blocks: (B:3:0x0002, B:6:0x0008, B:43:0x0056, B:49:0x006f, B:52:0x0090, B:54:0x00a9, B:53:0x009c, B:48:0x006b, B:40:0x004f, B:44:0x005c, B:35:0x0045, B:30:0x003b, B:25:0x0031, B:19:0x0026, B:45:0x0062, B:14:0x001b, B:9:0x0011), top: B:59:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0062 A[Catch: Exception -> 0x00c8, TryCatch #0 {Exception -> 0x00c8, blocks: (B:3:0x0002, B:6:0x0008, B:43:0x0056, B:49:0x006f, B:52:0x0090, B:54:0x00a9, B:53:0x009c, B:48:0x006b, B:40:0x004f, B:44:0x005c, B:35:0x0045, B:30:0x003b, B:25:0x0031, B:19:0x0026, B:45:0x0062, B:14:0x001b, B:9:0x0011), top: B:59:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void fail(java.lang.Integer r6, java.lang.String r7, java.lang.Integer r8) {
        /*
            Method dump skipped, instruction units count: 205
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kugou.common.apm.task.SetRingClickBtnAPM.fail(java.lang.Integer, java.lang.String, java.lang.Integer):void");
    }

    public final void release() {
        this.apmSession = null;
    }

    public final void start() {
        this.apmSession = getMode().start(ApmDataTypeID.SET_RING_CLICK);
    }

    public final void success(String str) {
        String str2 = this.apmSession;
        if (str2 == null) {
            return;
        }
        getMode().add(str2, ApmDataKey.PARA, str);
        getMode().add(str2, ApmDataKey.STATE, "1");
        getMode().end(str2);
        release();
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
            getMode().add(str2, ApmDataKey.STATE, "0");
            getMode().add(str2, ApmDataKey.PARA, str);
            getMode().end(str2);
            release();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
