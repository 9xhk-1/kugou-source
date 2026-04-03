package e.c.a.g.a.d.r.r.b;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.kugou.common.network.AbsHttpClient;
import e.c.a.g.a.s.g0;
import org.apache.http.Header;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d extends e.c.a.g.a.f.k.k.a<e.c.a.g.a.d.r.r.a.a> implements AbsHttpClient.IHttpProperty {
    public int a;

    @Override // e.c.a.g.a.f.k.k.a, com.kugou.common.network.protocol.ResponsePackage
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void getResponseData(e.c.a.g.a.d.r.r.a.a aVar) {
        if (g0.a) {
            g0.e("gehu.wallet", "data:" + getJsonStr());
        }
        if (aVar == null || TextUtils.isEmpty(getJsonStr())) {
            throw new NullPointerException("Login resp is Empty");
        }
        try {
            JSONObject jSONObject = new JSONObject(getJsonStr());
            if (jSONObject.optString(NotificationCompat.CATEGORY_STATUS) == null) {
                aVar.c(jSONObject.getString("data"));
                throw new NullPointerException("Login status is Null");
            }
            aVar.e(jSONObject.getInt(NotificationCompat.CATEGORY_STATUS));
            aVar.c(jSONObject.getString("data"));
            if (jSONObject.has("error_code")) {
                aVar.d(jSONObject.getInt("error_code"));
            }
            if (jSONObject.has("total")) {
                aVar.f(jSONObject.getInt("total"));
            }
        } catch (Exception e2) {
            throw new NullPointerException("Login resp json format Incorrect:" + e2.getMessage());
        }
    }

    @Override // e.c.a.g.a.f.k.k.a
    public int getStatusCode() {
        return this.a;
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
        this.a = i2;
    }
}
