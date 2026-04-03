package e.c.a.g.a.d.r.r.b;

import android.content.Context;
import com.kugou.common.network.protocol.AbstractRequestPackage;
import com.kugou.framework.libcommon.netcore.BaseConnection;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.l1;
import e.c.c.o.f;
import java.util.Arrays;
import java.util.Hashtable;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends AbstractRequestPackage {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f533d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f534e = 2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f535f = 3;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int f536g = 4;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f537h = 5;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static int f538i = 5;
    public static int j = 6;
    public int a;
    public Context b = f.a();
    public String c;

    public a() {
        this.mParams = new Hashtable<>();
        try {
            long configAsLong = e.c.a.g.a.f.e.c.c().getConfigAsLong(e.c.a.g.a.f.e.b.c, 3337L);
            int iC = e.c.a.g.a.r.e.b.c(this.b);
            this.c = l1.n(this.b);
            this.a = (int) (System.currentTimeMillis() / 1000);
            this.mParams.put("appid", Long.valueOf(configAsLong));
            this.mParams.put("clientver", Integer.valueOf(iC));
            this.mParams.put("mid", this.c);
            this.mParams.put("clienttime", Integer.valueOf(this.a));
        } catch (Exception e2) {
            g0.k(e2);
        }
    }

    public static String a(Hashtable<String, Object> hashtable) {
        Object[] array = hashtable.keySet().toArray();
        Arrays.sort(array);
        if (hashtable == null || hashtable.size() < 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Object obj : array) {
            sb.append(obj);
            sb.append(BaseConnection.HTTP_REQ_ENTITY_MERGE);
            sb.append(hashtable.get(obj));
            sb.append(BaseConnection.HTTP_REQ_ENTITY_JOIN);
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    @Override // com.kugou.common.network.protocol.AbstractRequestPackage, com.kugou.common.network.protocol.RequestPackage
    public String getGetRequestParams() {
        return "";
    }

    @Override // com.kugou.common.network.protocol.RequestPackage
    public String getRequestType() {
        return "POST";
    }
}
