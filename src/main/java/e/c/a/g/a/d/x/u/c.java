package e.c.a.g.a.d.x.u;

import android.util.Log;
import com.kugou.common.config.ConfigKey;
import com.kugou.common.network.AbsHttpClient;
import e.c.a.g.a.s.g0;
import org.apache.http.HttpEntity;

/* JADX INFO: loaded from: classes.dex */
public class c extends e.c.a.g.a.f.k.a implements AbsHttpClient.INoState, AbsHttpClient.ICheckChinaIP {
    public boolean a;
    public boolean b;
    public boolean c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConfigKey f618d;

    public c(boolean z, boolean z2, boolean z3) {
        this(z, z2, z3, null);
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
        Log.d("mhs_watch_http", "trackerurl - 2");
        if (this.f618d != null) {
            if (g0.a) {
                g0.e("FreeNetSongUrlRequestPackage", "getUrlConfigKey use customConfigKey");
            }
            return this.f618d;
        }
        Log.d("mhs_watch_http", "trackerurl - 2.1, isUGC = " + this.b);
        return this.b ? e.c.a.g.a.f.e.b.X : e.c.a.g.a.f.e.b.Y;
    }

    @Override // com.kugou.common.network.AbsHttpClient.ICheckChinaIP
    public boolean shouldBeSilent() {
        return this.a;
    }

    public c(boolean z, boolean z2, boolean z3, ConfigKey configKey) {
        this.a = z;
        this.b = z2;
        this.c = z3;
        this.f618d = configKey;
    }
}
