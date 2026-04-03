package com.kugou.common.apm.task;

import com.kugou.common.apm.ResponseHandlerForApm;
import com.kugou.common.apm.auto.YoungApmSessionModelImpl;
import com.kugou.common.apm.sdk.ApmDataKey;
import com.kugou.common.apm.sdk.ApmDataTypeID;
import com.kugou.common.apm.sdk.ApmFs;
import f.z.d.j;

/* JADX INFO: loaded from: classes2.dex */
public final class AudioIdentifyAPM {
    private String apmSession;
    private String tab = "0";

    private final YoungApmSessionModelImpl getMode() {
        return YoungApmSessionModelImpl.with(ApmDataTypeID.AUDIO_IDENTIFY);
    }

    public final void failByFilter() {
        String str = this.apmSession;
        if (str == null) {
            return;
        }
        getMode().add(str, ApmDataKey.STATE, "0");
        getMode().add(str, ApmDataKey.TE, ResponseHandlerForApm.E4);
        getMode().add(str, ApmDataKey.POSITION, "04");
        getMode().add(str, ApmDataKey.STATE_1, this.tab);
        getMode().add(str, ApmDataKey.FS, ApmFs.EMPTY_CONTENT);
        getMode().end(str);
        this.apmSession = null;
    }

    public final void failByUserCancel(String str) {
        j.e(str, ApmDataKey.POSITION);
        String str2 = this.apmSession;
        if (str2 == null) {
            return;
        }
        getMode().add(str2, ApmDataKey.STATE, "0");
        getMode().add(str2, ApmDataKey.TE, ResponseHandlerForApm.E6);
        getMode().add(str2, ApmDataKey.STATE_1, this.tab);
        getMode().add(str2, ApmDataKey.POSITION, str);
        getMode().add(str2, ApmDataKey.FS, ApmFs.USER_CANCEL);
        getMode().end(str2);
        this.apmSession = null;
    }

    public final void failedByEmpty() {
        String str = this.apmSession;
        if (str == null) {
            return;
        }
        getMode().add(str, ApmDataKey.STATE, "0");
        getMode().add(str, ApmDataKey.TE, ResponseHandlerForApm.E5);
        getMode().add(str, ApmDataKey.POSITION, "02");
        getMode().add(str, ApmDataKey.STATE_1, this.tab);
        getMode().add(str, ApmDataKey.FS, ApmFs.EMPTY_CONTENT);
        getMode().end(str);
        this.apmSession = null;
    }

    public final void failedBySdk(int i2) {
        String str = this.apmSession;
        if (str == null) {
            return;
        }
        getMode().add(str, ApmDataKey.STATE, "0");
        getMode().add(str, ApmDataKey.TE, ResponseHandlerForApm.E1);
        getMode().add(str, ApmDataKey.POSITION, j.l("", Integer.valueOf(i2)));
        getMode().add(str, ApmDataKey.STATE_1, this.tab);
        getMode().add(str, ApmDataKey.FS, ApmFs.USER_CANCEL);
        getMode().end(str);
        this.apmSession = null;
    }

    public final void failedByTimeOut() {
        String str = this.apmSession;
        if (str == null) {
            return;
        }
        getMode().add(str, ApmDataKey.STATE, "0");
        getMode().add(str, ApmDataKey.TE, ResponseHandlerForApm.E3);
        getMode().add(str, ApmDataKey.POSITION, "03");
        getMode().add(str, ApmDataKey.FS, ApmFs.USER_CANCEL);
        getMode().end(str);
        this.apmSession = null;
    }

    public final void start(String str) {
        this.apmSession = getMode().start(ApmDataTypeID.AUDIO_IDENTIFY);
        this.tab = str;
    }

    public final void success() {
        String str = this.apmSession;
        if (str == null) {
            return;
        }
        getMode().add(str, ApmDataKey.STATE_1, this.tab);
        getMode().add(str, ApmDataKey.STATE, "1");
        getMode().end(str);
        this.apmSession = null;
    }
}
