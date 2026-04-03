package e.c.a.g.a.g.g.c;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.kugou.common.network.ackutils.StringResponsePackage;
import e.c.a.g.a.s.g0;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class f extends StringResponsePackage<e> {
    @Override // com.kugou.common.network.ackutils.StringResponsePackage, com.kugou.common.network.protocol.ResponsePackage
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void getResponseData(e eVar) {
        if (eVar == null || TextUtils.isEmpty(this.mJsonString)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.mJsonString);
            if ("0".equals(jSONObject.getString(NotificationCompat.CATEGORY_STATUS))) {
                return;
            }
            eVar.b(jSONObject.optJSONObject("data").getInt("fid") + "");
        } catch (JSONException e2) {
            if (g0.a) {
                g0.b("YOUNG", e2.getMessage());
            }
        }
    }
}
