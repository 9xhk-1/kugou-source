package e.c.a.g.a.r.e;

import android.content.Context;
import com.kugou.common.network.protocol.AbstractRequestPackage;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.m;
import java.util.HashMap;
import org.apache.http.HttpEntity;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f extends AbstractRequestPackage {
    public HashMap<String, Object> a;
    public int b;
    public String c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f1168d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f1169e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f1170f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f1171g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f1172h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Context f1173i = e.c.c.o.f.a();

    public f(boolean z, boolean z2) {
        Object obj = new Object();
        this.a = new HashMap<>();
        try {
            this.f1168d = 3337L;
            this.f1169e = e.c.a.g.a.f.e.c.c().getConfig(e.c.a.g.a.f.e.b.f642d);
            this.f1171g = b.c(this.f1173i);
            this.f1170f = l1.n(e.c.c.o.f.a());
            this.f1172h = m.h();
            if (z) {
                String strE = e.e(obj);
                String strC = e.c(obj);
                this.a.put("t1", strE == null ? "" : strE);
                this.a.put("t2", strC == null ? "" : strC);
                String strD = e.d(obj);
                this.c = strD;
                try {
                    this.b = (int) (Long.parseLong(strD) / 1000);
                    this.a.put("clienttime_ms", this.c);
                } catch (Exception unused) {
                    int iCurrentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                    this.b = iCurrentTimeMillis;
                    this.a.put("clienttime", Integer.valueOf(iCurrentTimeMillis));
                }
            } else {
                int iCurrentTimeMillis2 = (int) (System.currentTimeMillis() / 1000);
                this.b = iCurrentTimeMillis2;
                this.a.put("clienttime", Integer.valueOf(iCurrentTimeMillis2));
            }
            if (z2) {
                return;
            }
            String strB = b.b(this.f1168d, this.f1169e, this.f1171g, String.valueOf(this.b));
            this.a.put("appid", Long.valueOf(this.f1168d));
            this.a.put("clientver", Integer.valueOf(this.f1171g));
            this.a.put("mid", this.f1170f);
            this.a.put("key", strB);
            this.a.put("uuid", this.f1172h);
        } catch (Exception e2) {
            g0.k(e2);
        }
    }

    @Override // com.kugou.common.network.protocol.RequestPackage
    public HttpEntity getPostRequestEntity() {
        return null;
    }

    @Override // com.kugou.common.network.protocol.RequestPackage
    public String getRequestModuleName() {
        return "User";
    }

    @Override // com.kugou.common.network.protocol.RequestPackage
    public String getRequestType() {
        return "POST";
    }
}
