package e.c.a.g.a.d.r.p.b;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.kugou.common.network.AbsHttpClient;
import e.c.a.g.a.s.g0;
import org.apache.http.Header;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c extends h<b> implements AbsHttpClient.IHttpProperty {
    public int b;

    @Override // e.c.a.g.a.f.k.k.a, com.kugou.common.network.protocol.ResponsePackage
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void getResponseData(b bVar) {
        if (g0.a) {
            g0.c("MediaStorePaidRecordResponsePackage", "getResponseData:" + this.a);
        }
        if (bVar == null || TextUtils.isEmpty(this.a)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.a);
            bVar.i(jSONObject.getInt(NotificationCompat.CATEGORY_STATUS));
            bVar.f(jSONObject.optInt("error_code"));
            bVar.h(jSONObject.optString("message"));
            if (jSONObject.has("data")) {
                bVar.g(jSONObject.getJSONObject("data").getInt("k_paid"));
            }
        } catch (Exception e2) {
            throw new NullPointerException("resp json format Incorrect:" + e2.getMessage());
        }
    }

    @Override // e.c.a.g.a.f.k.k.a
    public int getStatusCode() {
        return this.b;
    }

    @Override // com.kugou.common.network.AbsHttpClient.IHttpProperty
    public boolean onContentType(String str) {
        return true;
    }

    @Override // e.c.a.g.a.f.k.k.a
    public void onHandleApmData(e.c.a.g.a.d.b.a aVar) {
    }

    @Override // com.kugou.common.network.AbsHttpClient.IHttpProperty
    public boolean onHeaders(Header[] headerArr) {
        return true;
    }

    @Override // com.kugou.common.network.AbsHttpClient.IHttpProperty
    public boolean onResponseCode(int i2) {
        setStatusCode(i2);
        return true;
    }

    public void setStatusCode(int i2) {
        this.b = i2;
    }
}
