package e.c.a.g.a.f.e;

import android.os.Build;
import android.util.Log;
import com.kugou.common.config.v2.GetConfigUpdateProtocolBase;
import com.kugou.common.config.v2.KGConfigUpdateEntity;
import com.kugou.common.player.kugouplayer.j;
import e.c.a.g.a.f.k.e;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.r1;
import java.io.IOException;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/* JADX INFO: loaded from: classes.dex */
public class a extends GetConfigUpdateProtocolBase {
    public int a = 0;

    @Override // com.kugou.common.config.v2.GetConfigUpdateProtocolBase
    public KGConfigUpdateEntity request(int i2, boolean z, int i3) {
        if (g0.a) {
            g0.b("GetConfigUpdateProtocol", "request at " + Thread.currentThread().getName());
        }
        String strT = j.t(("kguid=" + e.c.a.g.a.r.b.o() + "&token=" + e.c.a.g.a.r.b.n() + "&appid=" + c.c().getConfig(b.c)).getBytes());
        e.c.a.g.a.r.g.c cVarZ = e.c.a.g.a.r.g.c.z();
        cVarZ.f(new String[0]);
        cVarZ.c("clientver", String.valueOf(10503));
        cVarZ.c("clienttime", String.valueOf(System.currentTimeMillis() / 1000));
        cVarZ.o(new String[0]);
        cVarZ.r(new String[0]);
        cVarZ.n(new String[0]);
        cVarZ.g("channel");
        cVarZ.c("gitversion", "2.4.5.1");
        cVarZ.c("model", Build.MODEL);
        cVarZ.c("os_ver", String.valueOf(Build.VERSION.SDK_INT));
        cVarZ.c("gt", "0");
        cVarZ.c("user", strT);
        cVarZ.c("cursor_id", String.valueOf(i2));
        cVarZ.c("encrypt", "1");
        int i4 = this.a + 1;
        this.a = i4;
        cVarZ.c("times", String.valueOf(i4));
        try {
            return ((e) new Retrofit.Builder().setModuleName("config").addConverterFactory(GsonConverterFactory.create()).setMultiUrl(r1.c(b.t, "http://config.mobile.kugou.com/v2/appconfig/index")).setExcludeEndChar().build().create(e.class)).call(cVarZ.F("")).execute().body();
        } catch (IOException e2) {
            if (!g0.a) {
                return null;
            }
            g0.b("GetConfigUpdateProtocol", "配置更新请求失败,原因: " + Log.getStackTraceString(e2));
            return null;
        }
    }
}
