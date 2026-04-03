package com.kugou.framework.tmeab;

import android.text.TextUtils;
import e.c.a.e.b;
import e.c.a.g.a.s.g0;
import f.z.d.g;
import f.z.d.j;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class VipPriABConfigHandler extends b {
    public static final Companion Companion = new Companion(null);

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final int getBell() {
            String fromLocal = new VipPriABConfigHandler().readFromLocal();
            if (TextUtils.isEmpty(fromLocal)) {
                return 0;
            }
            try {
                JSONObject jSONObjectOptJSONObject = new JSONObject(fromLocal).optJSONObject("mapParams");
                Integer numValueOf = jSONObjectOptJSONObject == null ? null : Integer.valueOf(jSONObjectOptJSONObject.optInt("bell"));
                if (numValueOf == null) {
                    return 0;
                }
                return numValueOf.intValue();
            } catch (Exception unused) {
                return 0;
            }
        }

        public final int getDownload() {
            String fromLocal = new VipPriABConfigHandler().readFromLocal();
            if (TextUtils.isEmpty(fromLocal)) {
                return 0;
            }
            try {
                JSONObject jSONObjectOptJSONObject = new JSONObject(fromLocal).optJSONObject("mapParams");
                Integer numValueOf = jSONObjectOptJSONObject == null ? null : Integer.valueOf(jSONObjectOptJSONObject.optInt("download"));
                if (numValueOf == null) {
                    return 0;
                }
                return numValueOf.intValue();
            } catch (Exception unused) {
                return 0;
            }
        }
    }

    @Override // e.c.a.e.b
    public String getSPKey() {
        return "KEY_SIGN_GET_VIP";
    }

    @Override // e.c.a.e.b
    public String getSource() {
        return "TMEAB0WatchVipIntercept0type";
    }

    @Override // e.c.a.e.b
    public void handleConfig(String str, String str2) {
        j.e(str, "dataType");
        if (g0.a) {
            g0.e("VipPriABConfigHandler", j.l("handleConfig:", str2));
        }
    }
}
