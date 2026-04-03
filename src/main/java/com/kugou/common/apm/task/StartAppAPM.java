package com.kugou.common.apm.task;

import com.kugou.common.apm.auto.YoungApmSessionModelImpl;
import com.kugou.common.apm.sdk.ApmDataKey;
import com.kugou.common.apm.sdk.ApmDataTypeID;
import e.c.a.g.a.f.e.b;
import e.c.a.g.a.f.e.c;
import f.z.d.j;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class StartAppAPM {
    private String apmSession;
    private final boolean isEnableConfigDynamics;
    private JSONObject jsonObject;

    public StartAppAPM() {
        this.isEnableConfigDynamics = c.a.a().getConfigAsInt(b.B2, 1) == 1;
        this.jsonObject = new JSONObject();
    }

    private final YoungApmSessionModelImpl getMode() {
        return YoungApmSessionModelImpl.with(ApmDataTypeID.APP_START);
    }

    public final JSONObject getJsonObject() {
        return this.jsonObject;
    }

    public final void netLoadTime() {
        String str = this.apmSession;
        if (str == null) {
            return;
        }
        getMode().add(str, ApmDataKey.NET_DELAY);
    }

    public final void release() {
        this.apmSession = null;
    }

    public final void setJsonObject(JSONObject jSONObject) {
        j.e(jSONObject, "<set-?>");
        this.jsonObject = jSONObject;
    }

    public final void start() {
        if (this.isEnableConfigDynamics) {
            this.apmSession = getMode().start(ApmDataTypeID.APP_START);
        }
    }

    public final void success() {
        String str = this.apmSession;
        if (str == null) {
            return;
        }
        getMode().add(str, ApmDataKey.STATE, "1");
        getMode().end(str);
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
