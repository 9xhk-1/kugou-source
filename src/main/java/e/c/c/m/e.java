package e.c.c.m;

import android.os.Build;
import android.text.TextUtils;
import com.kugou.common.network.protocol.RequestPackage;
import com.kugou.datacollect.crash.bean.CrashBean;
import e.c.c.o.m;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.cookie.ClientCookie;
import org.apache.http.message.BasicNameValuePair;

/* JADX INFO: loaded from: classes2.dex */
public class e implements RequestPackage {
    public CrashBean a;

    public e(CrashBean crashBean) {
        this.a = crashBean;
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
        try {
            String str = e.c.c.e.a;
            ArrayList arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair("mid", m.l(e.c.c.o.f.a())));
            arrayList.add(new BasicNameValuePair("count", String.valueOf(1)));
            arrayList.add(new BasicNameValuePair(ClientCookie.VERSION_ATTR, String.valueOf(m.x(e.c.c.o.f.a()))));
            arrayList.add(new BasicNameValuePair("device", Build.MODEL));
            arrayList.add(new BasicNameValuePair("channel", str));
            arrayList.add(new BasicNameValuePair("plat", e.c.c.b.b));
            arrayList.add(new BasicNameValuePair("sdk", m.t()));
            arrayList.add(new BasicNameValuePair("networktype", m.o(e.c.c.o.f.a())));
            arrayList.add(new BasicNameValuePair("crashclass1", this.a.className));
            arrayList.add(new BasicNameValuePair("content1", m.A(this.a.getParamContent())));
            arrayList.add(new BasicNameValuePair("feature1", m.A(this.a.getFeature())));
            arrayList.add(new BasicNameValuePair("value1_1", this.a.getParamValue1()));
            arrayList.add(new BasicNameValuePair("value2_1", this.a.getParamValue2()));
            arrayList.add(new BasicNameValuePair("value3_1", this.a.getParamValue3()));
            arrayList.add(new BasicNameValuePair("createtime1", this.a.getParamCrashTime()));
            arrayList.add(new BasicNameValuePair("patchid", "0"));
            arrayList.add(new BasicNameValuePair("gitversion", e.c.c.b.f1245e));
            arrayList.add(new BasicNameValuePair("ori_gitversion", this.a.crashOriginGitVersion));
            arrayList.add(new BasicNameValuePair("pre_version", String.valueOf(this.a.preVersion)));
            arrayList.add(new BasicNameValuePair("cpu_abi", Build.CPU_ABI));
            arrayList.add(new BasicNameValuePair("manufacturer", Build.MANUFACTURER));
            if (!TextUtils.isEmpty(this.a.getParamNdkName())) {
                arrayList.add(new BasicNameValuePair("ndkname", this.a.getParamNdkName()));
            }
            return new UrlEncodedFormEntity(arrayList, "UTF-8");
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
        return "http://exceptionlog.kugou.com/new/app/i/tool.php?cmd=502";
    }
}
