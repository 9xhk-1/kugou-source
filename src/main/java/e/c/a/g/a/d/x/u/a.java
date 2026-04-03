package e.c.a.g.a.d.x.u;

import android.util.Log;
import com.kugou.common.config.ConfigKey;
import com.kugou.common.network.AbsHttpClient;
import org.apache.http.HttpEntity;

/* JADX INFO: loaded from: classes.dex */
public class a extends e.c.a.g.a.f.k.a implements AbsHttpClient.INoState, AbsHttpClient.ICheckChinaIP {
    public boolean a;
    public boolean b;
    public boolean c;

    public a(boolean z, boolean z2, boolean z3) {
        this.a = z;
        this.b = z2;
        this.c = z3;
    }

    @Override // com.kugou.common.network.AbsHttpClient.ICheckChinaIP
    public void checkIp() throws Exception {
        if (this.c) {
        }
    }

    @Override // com.kugou.common.network.protocol.RequestPackage
    public HttpEntity getPostRequestEntity() {
        return null;
    }

    @Override // com.kugou.common.network.protocol.RequestPackage
    public String getRequestModuleName() {
        return "NetMusic";
    }

    @Override // com.kugou.common.network.protocol.RequestPackage
    public String getRequestType() {
        return "GET";
    }

    @Override // e.c.a.g.a.f.k.a
    public ConfigKey getUrlConfigKey() {
        Log.d("mhs_watch_http", "trackerurl - 3., isUGC = " + this.b);
        return this.b ? e.c.a.g.a.f.e.b.X : e.c.a.g.a.f.e.b.Z;
    }

    @Override // com.kugou.common.network.AbsHttpClient.ICheckChinaIP
    public boolean shouldBeSilent() {
        return this.a;
    }
}
