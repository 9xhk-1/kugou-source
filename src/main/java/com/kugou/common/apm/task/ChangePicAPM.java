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
public final class ChangePicAPM {
    private String apmSession;
    private int choosePicType;

    public static /* synthetic */ void fail$default(ChangePicAPM changePicAPM, Integer num, String str, Integer num2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            num2 = null;
        }
        changePicAPM.fail(num, str, num2);
    }

    private final YoungApmSessionModelImpl getMode() {
        return YoungApmSessionModelImpl.with(ApmDataTypeID.CHANGE_USER_HEAD_ICON);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0052 A[Catch: Exception -> 0x00b8, TryCatch #0 {Exception -> 0x00b8, blocks: (B:3:0x0002, B:6:0x0008, B:37:0x004c, B:43:0x0060, B:46:0x0081, B:48:0x009a, B:47:0x008d, B:42:0x005c, B:34:0x0045, B:38:0x0052, B:29:0x003b, B:24:0x0031, B:19:0x0027, B:14:0x001d, B:9:0x0012), top: B:53:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void fail(java.lang.Integer r7, java.lang.String r8, java.lang.Integer r9) {
        /*
            r6 = this;
            java.lang.String r0 = ""
            java.lang.String r1 = r6.apmSession     // Catch: java.lang.Exception -> Lb8
            if (r1 != 0) goto L8
            goto Lbc
        L8:
            e.c.a.g.a.d.b.a r2 = new e.c.a.g.a.d.b.a     // Catch: java.lang.Exception -> Lb8
            r2.<init>()     // Catch: java.lang.Exception -> Lb8
            r3 = 21
            if (r7 != 0) goto L12
            goto L18
        L12:
            int r4 = r7.intValue()     // Catch: java.lang.Exception -> Lb8
            if (r4 == r3) goto L52
        L18:
            r3 = 22
            if (r7 != 0) goto L1d
            goto L23
        L1d:
            int r4 = r7.intValue()     // Catch: java.lang.Exception -> Lb8
            if (r4 == r3) goto L52
        L23:
            r3 = 1
            if (r7 != 0) goto L27
            goto L2d
        L27:
            int r4 = r7.intValue()     // Catch: java.lang.Exception -> Lb8
            if (r4 == r3) goto L52
        L2d:
            r3 = 2
            if (r7 != 0) goto L31
            goto L37
        L31:
            int r4 = r7.intValue()     // Catch: java.lang.Exception -> Lb8
            if (r4 == r3) goto L52
        L37:
            r3 = 3
            if (r7 != 0) goto L3b
            goto L41
        L3b:
            int r4 = r7.intValue()     // Catch: java.lang.Exception -> Lb8
            if (r4 == r3) goto L52
        L41:
            r3 = 4
            if (r7 != 0) goto L45
            goto L4c
        L45:
            int r4 = r7.intValue()     // Catch: java.lang.Exception -> Lb8
            if (r4 != r3) goto L4c
            goto L52
        L4c:
            java.lang.String r3 = "E5"
            r2.k(r3)     // Catch: java.lang.Exception -> Lb8
            goto L57
        L52:
            java.lang.String r3 = "E4"
            r2.k(r3)     // Catch: java.lang.Exception -> Lb8
        L57:
            r3 = 0
            if (r7 != 0) goto L5c
            r4 = r3
            goto L60
        L5c:
            java.lang.String r4 = r7.toString()     // Catch: java.lang.Exception -> Lb8
        L60:
            r2.g(r4)     // Catch: java.lang.Exception -> Lb8
            com.kugou.common.apm.auto.YoungApmSessionModelImpl r4 = r6.getMode()     // Catch: java.lang.Exception -> Lb8
            java.lang.String r5 = "te"
            java.lang.String r2 = r2.c()     // Catch: java.lang.Exception -> Lb8
            r4.add(r1, r5, r2)     // Catch: java.lang.Exception -> Lb8
            com.kugou.common.apm.auto.YoungApmSessionModelImpl r2 = r6.getMode()     // Catch: java.lang.Exception -> Lb8
            java.lang.String r4 = "position"
            java.lang.String r5 = f.z.d.j.l(r0, r7)     // Catch: java.lang.Exception -> Lb8
            r2.add(r1, r4, r5)     // Catch: java.lang.Exception -> Lb8
            java.lang.String r2 = "fs"
            if (r9 == 0) goto L8d
            com.kugou.common.apm.auto.YoungApmSessionModelImpl r7 = r6.getMode()     // Catch: java.lang.Exception -> Lb8
            java.lang.String r9 = f.z.d.j.l(r0, r9)     // Catch: java.lang.Exception -> Lb8
            r7.add(r1, r2, r9)     // Catch: java.lang.Exception -> Lb8
            goto L9a
        L8d:
            com.kugou.common.apm.auto.YoungApmSessionModelImpl r9 = r6.getMode()     // Catch: java.lang.Exception -> Lb8
            java.lang.String r0 = "60"
            java.lang.String r7 = f.z.d.j.l(r0, r7)     // Catch: java.lang.Exception -> Lb8
            r9.add(r1, r2, r7)     // Catch: java.lang.Exception -> Lb8
        L9a:
            com.kugou.common.apm.auto.YoungApmSessionModelImpl r7 = r6.getMode()     // Catch: java.lang.Exception -> Lb8
            java.lang.String r9 = "para"
            r7.add(r1, r9, r8)     // Catch: java.lang.Exception -> Lb8
            com.kugou.common.apm.auto.YoungApmSessionModelImpl r7 = r6.getMode()     // Catch: java.lang.Exception -> Lb8
            java.lang.String r8 = "state"
            java.lang.String r9 = "0"
            r7.add(r1, r8, r9)     // Catch: java.lang.Exception -> Lb8
            com.kugou.common.apm.auto.YoungApmSessionModelImpl r7 = r6.getMode()     // Catch: java.lang.Exception -> Lb8
            r7.end(r1)     // Catch: java.lang.Exception -> Lb8
            r6.apmSession = r3     // Catch: java.lang.Exception -> Lb8
            goto Lbc
        Lb8:
            r7 = move-exception
            r7.printStackTrace()
        Lbc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kugou.common.apm.task.ChangePicAPM.fail(java.lang.Integer, java.lang.String, java.lang.Integer):void");
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
        this.apmSession = getMode().start(ApmDataTypeID.CHANGE_USER_HEAD_ICON);
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

    public final void fail(Throwable th, Integer num, String str) {
        j.e(str, "errorMsg");
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
            getMode().add(str2, ApmDataKey.STATE, "0");
            getMode().add(str2, ApmDataKey.PARA, str);
            getMode().end(str2);
            this.apmSession = null;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
