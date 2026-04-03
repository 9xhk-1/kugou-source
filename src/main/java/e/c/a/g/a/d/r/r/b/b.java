package e.c.a.g.a.d.r.r.b;

import android.content.Context;
import e.c.a.g.a.d.r.f;
import e.c.a.g.a.f.k.k.e;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.q0;
import e.c.c.o.n;
import java.io.UnsupportedEncodingException;
import java.util.Hashtable;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.entity.StringEntity;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public String a = "musicfees";

    public class a extends e.c.a.g.a.d.r.r.b.a {
        public int k;

        /* JADX INFO: renamed from: e.c.a.g.a.d.r.r.b.b$a$a, reason: collision with other inner class name */
        public class C0077a implements Header {
            public C0077a(a aVar) {
            }

            @Override // org.apache.http.Header
            public HeaderElement[] getElements() throws ParseException {
                return null;
            }

            @Override // org.apache.http.Header
            public String getName() {
                return "Content-Type";
            }

            @Override // org.apache.http.Header
            public String getValue() {
                return "application/x-www-form-urlencoded; charset=UTF-8";
            }
        }

        public a(b bVar, Hashtable<String, Object> hashtable, int i2) {
            this.mParams.putAll(hashtable);
            this.k = i2;
        }

        @Override // com.kugou.common.network.protocol.AbstractRequestPackage, com.kugou.common.network.protocol.RequestPackage
        public Header[] getHttpHeaders() {
            return new Header[]{new C0077a(this)};
        }

        @Override // com.kugou.common.network.protocol.RequestPackage
        public HttpEntity getPostRequestEntity() {
            try {
                String strA = e.c.a.g.a.d.r.r.b.a.a(this.mParams);
                String config = e.c.a.g.a.f.e.c.c().getConfig(e.c.a.g.a.f.e.b.f642d);
                StringBuilder sb = new StringBuilder();
                sb.append(strA);
                sb.append("&sign=");
                sb.append(new q0().f(n.a(strA) + config, "utf-8").toLowerCase());
                String string = sb.toString();
                if (g0.a) {
                    g0.e("musicfees", "postParams: " + string);
                }
                StringEntity stringEntity = new StringEntity(string, "utf-8");
                stringEntity.setContentType("application/json; charset=UTF-8");
                return stringEntity;
            } catch (UnsupportedEncodingException e2) {
                g0.k(e2);
                return null;
            }
        }

        @Override // com.kugou.common.network.protocol.RequestPackage
        public String getRequestModuleName() {
            return "Wallet";
        }

        @Override // com.kugou.common.network.protocol.RequestPackage
        public String getUrl() {
            String config = e.c.a.g.a.f.e.c.c().getConfig(e.c.a.g.a.f.e.b.A0);
            int i2 = this.k;
            if (i2 == e.c.a.g.a.d.r.r.b.a.f533d) {
                return config + "userbalance";
            }
            if (i2 == e.c.a.g.a.d.r.r.b.a.f536g) {
                return config + "consumption";
            }
            if (i2 == e.c.a.g.a.d.r.r.b.a.f535f) {
                return config + "recharge";
            }
            if (i2 == e.c.a.g.a.d.r.r.b.a.f534e) {
                return config + "userrecord";
            }
            if (i2 == e.c.a.g.a.d.r.r.b.a.f537h) {
                return config + "paypasswd";
            }
            if (i2 == e.c.a.g.a.d.r.r.b.a.f538i) {
                return config + "setpaypasswd";
            }
            if (i2 != e.c.a.g.a.d.r.r.b.a.j) {
                return "";
            }
            return config + "redpacket/userbalance";
        }
    }

    public e.c.a.g.a.d.r.r.a.a a(Context context) {
        return b(context, 0);
    }

    public e.c.a.g.a.d.r.r.a.a b(Context context, int i2) {
        Hashtable hashtable = new Hashtable();
        hashtable.put("token", e.c.a.g.a.r.b.n());
        hashtable.put("userid", Long.valueOf(e.c.a.g.a.r.b.o()));
        e.c.a.g.a.d.r.r.a.a aVar = new e.c.a.g.a.d.r.r.a.a();
        a aVar2 = new a(this, hashtable, e.c.a.g.a.d.r.r.b.a.f533d);
        if (g0.a) {
            g0.e(this.a, aVar2.getUrl());
        }
        d dVar = new d();
        try {
            e eVarA = e.a();
            if (i2 != 0) {
                eVarA.setMaxWaitDuration(i2);
            }
            eVarA.request(aVar2, dVar);
            dVar.getResponseData(aVar);
        } catch (Exception e2) {
            g0.k(e2);
            aVar = null;
        }
        if (aVar == null || aVar.b() != 1) {
            e.c.a.g.a.r.b.e0(e.c.a.g.a.f.m.c.a.d("wallet_user_last_balance_num", "0"));
        } else {
            double dDoubleValue = 0.0d;
            try {
                dDoubleValue = Double.valueOf(aVar.a()).doubleValue() / 100.0d;
            } catch (NumberFormatException e3) {
                g0.k(e3);
            }
            String strB = f.b(dDoubleValue);
            aVar.c(strB);
            e.c.a.g.a.r.b.e0(strB);
            e.c.a.g.a.f.m.c.a.i("wallet_user_last_balance_num", strB);
        }
        return aVar;
    }
}
