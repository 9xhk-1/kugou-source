package e.c.a.g.a.r.d.d;

import android.content.Context;
import com.kugou.common.network.protocol.AbstractRequestPackage;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.m;
import java.util.HashMap;
import org.apache.http.HttpEntity;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g extends AbstractRequestPackage {
    public long appId;
    public String appKey;
    public int clientTime;
    public String clientTimeMs;
    public int clientVer;
    public Context context;
    public HashMap<String, Object> map;
    public String mid;
    public String uuid;

    public g() {
        this(false, false);
    }

    @Override // com.kugou.common.network.protocol.AbstractRequestPackage, com.kugou.common.network.protocol.RequestPackage
    public abstract String getGetRequestParams();

    @Override // com.kugou.common.network.protocol.RequestPackage
    public abstract HttpEntity getPostRequestEntity();

    @Override // com.kugou.common.network.protocol.RequestPackage
    public abstract String getRequestModuleName();

    @Override // com.kugou.common.network.protocol.RequestPackage
    public abstract String getRequestType();

    public g(boolean z, boolean z2) {
        e.c.a.g.a.f.m.c cVar = e.c.a.g.a.f.m.c.a;
        this.context = e.c.c.o.f.a();
        this.map = new HashMap<>();
        try {
            this.appId = 3337L;
            this.appKey = e.c.a.g.a.f.e.c.c().getConfig(e.c.a.g.a.f.e.b.f642d);
            this.clientVer = e.c.a.g.a.r.e.b.c(this.context);
            this.mid = l1.n(this.context);
            this.uuid = m.h();
            if (z) {
                String strE = e.c.a.g.a.r.e.e.e(cVar);
                String strC = e.c.a.g.a.r.e.e.c(cVar);
                this.map.put("t1", strE == null ? "" : strE);
                this.map.put("t2", strC == null ? "" : strC);
                String strD = e.c.a.g.a.r.e.e.d(cVar);
                this.clientTimeMs = strD;
                try {
                    this.clientTime = (int) (Long.parseLong(strD) / 1000);
                    this.map.put("clienttime_ms", this.clientTimeMs);
                } catch (Exception unused) {
                    int iCurrentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                    this.clientTime = iCurrentTimeMillis;
                    this.map.put("clienttime", Integer.valueOf(iCurrentTimeMillis));
                }
            } else {
                int iCurrentTimeMillis2 = (int) (System.currentTimeMillis() / 1000);
                this.clientTime = iCurrentTimeMillis2;
                this.map.put("clienttime", Integer.valueOf(iCurrentTimeMillis2));
            }
            if (z2) {
                return;
            }
            String strB = e.c.a.g.a.r.e.b.b(this.appId, this.appKey, this.clientVer, String.valueOf(this.clientTime));
            this.map.put("appid", Long.valueOf(this.appId));
            this.map.put("clientver", Integer.valueOf(this.clientVer));
            this.map.put("mid", this.mid);
            this.map.put("key", strB);
            this.map.put("uuid", this.uuid);
        } catch (Exception e2) {
            g0.k(e2);
        }
    }
}
