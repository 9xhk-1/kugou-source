package e.c.c.m;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.kugou.common.network.protocol.RequestPackage;
import com.kugou.datacollect.crash.bean.CrashBean;
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
public class a implements RequestPackage {
    public CrashBean a;
    public Context b;

    public a(Context context, CrashBean crashBean) {
        this.a = crashBean;
        this.b = context;
    }

    @Override // com.kugou.common.network.protocol.RequestPackage
    public String getGetRequestParams() {
        return "";
    }

    @Override // com.kugou.common.network.protocol.RequestPackage
    public Header[] getHttpHeaders() {
        return null;
    }

    @Override // com.kugou.common.network.protocol.RequestPackage
    public HttpEntity getPostRequestEntity() {
        String strY = m.y(m.j(e.c.c.o.f.a()));
        String str = m.x(e.c.c.o.f.a()) + "";
        String str2 = e.c.c.b.b;
        String strValueOf = String.valueOf(this.a.crashType);
        String strD = m.d(this.a.getParamCrashTime());
        String str3 = Build.VERSION.RELEASE;
        String.valueOf(Build.VERSION.SDK_INT);
        String strE = new e.c.c.o.i().e(strY + str + "kugou2011");
        m.d(Build.MODEL);
        String str4 = e.c.c.b.c;
        Hashtable hashtable = new Hashtable();
        hashtable.put("mid", m.l(this.b));
        hashtable.put("crash_type", "c");
        hashtable.put("ver", str);
        hashtable.put("platid", str2);
        hashtable.put("type", strValueOf);
        hashtable.put("posttime", strD);
        hashtable.put("m", strE);
        hashtable.put("isfirst", this.a.isAppUpgradeFirstStart ? "1" : "0");
        hashtable.put("uuid", m.v());
        hashtable.put("cso_type", "1005");
        if (TextUtils.isEmpty(str4)) {
            str4 = "";
        }
        hashtable.put("chl", str4);
        hashtable.put("kanUser", this.a.kanUser + "");
        hashtable.put("kgliveUser", this.a.kgliveUser + "");
        hashtable.put("gitversion", e.c.c.b.f1245e);
        hashtable.put("pre_version", String.valueOf(this.a.preVersion));
        hashtable.put("cpu_abi", Build.CPU_ABI);
        hashtable.put("manufacturer", Build.MANUFACTURER);
        Set<String> setKeySet = hashtable.keySet();
        ArrayList arrayList = new ArrayList();
        for (String str5 : setKeySet) {
            arrayList.add(new BasicNameValuePair(str5, (String) hashtable.get(str5)));
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
        return "http://mobilelog.kugou.com/kgm.php";
    }
}
