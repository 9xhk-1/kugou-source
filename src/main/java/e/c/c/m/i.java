package e.c.c.m;

import android.os.Build;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.kugou.common.network.networkutils.UrlEncoderUtil;
import com.kugou.common.network.protocol.RequestPackage;
import com.kugou.framework.libcommon.netcore.BaseConnection;
import e.c.c.o.m;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;

/* JADX INFO: loaded from: classes2.dex */
public class i implements RequestPackage {
    public Hashtable<String, String> a = new Hashtable<>();

    public i() {
        String string = m.y(m.j(e.c.c.o.f.a())).toString();
        String str = e.c.c.e.a;
        String str2 = m.x(e.c.c.o.f.a()) + "";
        String str3 = e.c.c.b.b;
        m.n(e.c.c.o.f.a());
        String strEncode = UrlEncoderUtil.encode("0");
        String strEncode2 = UrlEncoderUtil.encode(Build.MODEL);
        String strValueOf = String.valueOf(1);
        String strValueOf2 = String.valueOf(Build.VERSION.SDK_INT);
        String strE = new e.c.c.o.i().e(string + str2 + "kugou2011");
        String strR = m.r(e.c.c.o.f.a());
        strR = TextUtils.isEmpty(strR) ? "00000" : strR;
        this.a.put("uid", e.c.c.b.f1244d + "");
        this.a.put("mid", m.l(e.c.c.o.f.a()));
        this.a.put("uuid", m.w(true));
        this.a.put("chl", str);
        this.a.put("ver", str2);
        this.a.put("plat", str3);
        this.a.put("nettype", m.n(e.c.c.o.f.a()));
        this.a.put("wh", strEncode);
        Hashtable<String, String> hashtable = this.a;
        TextUtils.isEmpty("");
        hashtable.put("locid", "");
        this.a.put("cellid", "");
        this.a.put("active_type", strValueOf);
        this.a.put("apiver", strValueOf2);
        this.a.put("m", strE);
        this.a.put("mnc", strR);
        this.a.put("user_att", "0");
        this.a.put("ring_tone", "0");
        this.a.put("huidu", "0");
        this.a.put(NotificationCompat.CATEGORY_STATUS, "1");
        this.a.put("themeid", "0");
        this.a.put("patchid", "0");
        this.a.put("gitversion", e.c.c.b.f1245e);
        this.a.put("model", strEncode2);
        this.a.put("androidid", m.w(true));
        this.a.put("oaid2", e.c.c.g.b().a());
        e.c.c.o.g.a("siganid", this.a.toString());
    }

    @Override // com.kugou.common.network.protocol.RequestPackage
    public String getGetRequestParams() {
        Hashtable<String, String> hashtable;
        if ("POST".equals(getRequestType()) || (hashtable = this.a) == null || hashtable.size() < 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("?");
        for (String str : this.a.keySet()) {
            sb.append(str);
            sb.append(BaseConnection.HTTP_REQ_ENTITY_MERGE);
            sb.append(this.a.get(str));
            sb.append(BaseConnection.HTTP_REQ_ENTITY_JOIN);
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    @Override // com.kugou.common.network.protocol.RequestPackage
    public Header[] getHttpHeaders() {
        return new Header[0];
    }

    @Override // com.kugou.common.network.protocol.RequestPackage
    public HttpEntity getPostRequestEntity() {
        Hashtable<String, String> hashtable = this.a;
        if (hashtable == null || hashtable.size() <= 0) {
            return null;
        }
        Set<String> setKeySet = this.a.keySet();
        ArrayList arrayList = new ArrayList();
        for (String str : setKeySet) {
            if (this.a.get(str) != null) {
                arrayList.add(new BasicNameValuePair(str, this.a.get(str)));
            }
        }
        try {
            return new UrlEncodedFormEntity(arrayList);
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    @Override // com.kugou.common.network.protocol.RequestPackage
    public String getRequestModuleName() {
        return "Statistics";
    }

    @Override // com.kugou.common.network.protocol.RequestPackage
    public String getRequestType() {
        return "POST";
    }

    @Override // com.kugou.common.network.protocol.RequestPackage
    public String getUrl() {
        return "http://mobilelog.kugou.com/use.php";
    }
}
