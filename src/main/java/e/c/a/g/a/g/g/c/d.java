package e.c.a.g.a.g.g.c;

import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.common.network.networkutils.MD5Util;
import com.kugou.common.network.protocol.RequestPackage;
import com.kugou.framework.libcommon.netcore.BaseConnection;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.m;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d implements RequestPackage {
    public Map<String, String> a;

    public d(Map<String, String> map) {
        this.a = map;
    }

    @Override // com.kugou.common.network.protocol.RequestPackage
    public String getGetRequestParams() {
        try {
            JSONObject jSONObject = new JSONObject();
            StringBuilder sb = new StringBuilder();
            long configAsLong = e.c.a.g.a.f.e.c.c().getConfigAsLong(e.c.a.g.a.f.e.b.c);
            int iC = e.c.a.g.a.r.e.b.c(KGApplication.getContext());
            String config = e.c.a.g.a.f.e.c.c().getConfig(e.c.a.g.a.f.e.b.f642d);
            sb.append("?");
            for (String str : this.a.keySet()) {
                jSONObject.put(str, this.a.get(str));
            }
            sb.append("appid");
            sb.append(BaseConnection.HTTP_REQ_ENTITY_MERGE);
            sb.append(configAsLong);
            sb.append(BaseConnection.HTTP_REQ_ENTITY_JOIN);
            sb.append("clienttime");
            sb.append(BaseConnection.HTTP_REQ_ENTITY_MERGE);
            sb.append(System.currentTimeMillis() / 1000);
            sb.append(BaseConnection.HTTP_REQ_ENTITY_JOIN);
            sb.append("clientver");
            sb.append(BaseConnection.HTTP_REQ_ENTITY_MERGE);
            sb.append(iC);
            sb.append(BaseConnection.HTTP_REQ_ENTITY_JOIN);
            sb.append("dfid");
            sb.append(BaseConnection.HTTP_REQ_ENTITY_MERGE);
            sb.append(m.e());
            sb.append(BaseConnection.HTTP_REQ_ENTITY_JOIN);
            sb.append("mid");
            sb.append(BaseConnection.HTTP_REQ_ENTITY_MERGE);
            sb.append(e.c.c.o.m.l(KGApplication.getContext()));
            sb.append(BaseConnection.HTTP_REQ_ENTITY_JOIN);
            String lowerCase = new MD5Util().getMD5ofStr(config + new String(sb.toString()).replace(BaseConnection.HTTP_REQ_ENTITY_JOIN, "").replace("?", "") + jSONObject.toString() + config, "UTF-8").toLowerCase(Locale.US);
            sb.append("signature");
            sb.append(BaseConnection.HTTP_REQ_ENTITY_MERGE);
            sb.append(lowerCase);
            return sb.toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    @Override // com.kugou.common.network.protocol.RequestPackage
    public Header[] getHttpHeaders() {
        return null;
    }

    @Override // com.kugou.common.network.protocol.RequestPackage
    public HttpEntity getPostRequestEntity() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (String str : this.a.keySet()) {
                jSONObject.put(str, this.a.get(str));
            }
        } catch (JSONException e2) {
            g0.k(e2);
        }
        StringEntity stringEntity = null;
        try {
            stringEntity = new StringEntity(jSONObject.toString(), "UTF-8");
        } catch (UnsupportedEncodingException e3) {
            g0.k(e3);
        }
        stringEntity.setContentType("application/json; charset=UTF-8");
        return stringEntity;
    }

    @Override // com.kugou.common.network.protocol.RequestPackage
    public String getRequestModuleName() {
        return "Feedback";
    }

    @Override // com.kugou.common.network.protocol.RequestPackage
    public String getRequestType() {
        return "POST";
    }

    @Override // com.kugou.common.network.protocol.RequestPackage
    public String getUrl() {
        return e.c.a.g.a.f.e.c.c().getConfig(e.c.a.g.a.f.e.b.i1);
    }
}
