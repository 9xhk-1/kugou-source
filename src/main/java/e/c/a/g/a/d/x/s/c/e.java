package e.c.a.g.a.d.x.s.c;

import android.content.Context;
import android.text.TextUtils;
import com.kugou.common.apm.ResponseHandlerForApm;
import com.kugou.common.config.ConfigKey;
import com.kugou.common.config.util.Base64Util;
import com.kugou.common.network.AbsHttpClient;
import com.kugou.common.network.INetworkState;
import com.kugou.common.network.RequestDelay;
import com.kugou.common.network.ResponseTypeChecker;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.h1;
import e.c.a.g.a.s.q;
import e.c.a.g.a.s.q0;
import java.util.ArrayList;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e {
    public String a;
    public long b;
    public String c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f595d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public e.c.a.g.a.f.k.k.e f596e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f597f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f598g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f599h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f600i;
    public long j;
    public RequestDelay k;
    public c l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public int q;
    public boolean r;
    public int s;
    public e.c.a.g.a.d.b.a t;
    public byte[] u;

    public class a extends e.c.a.g.a.f.k.a {
        public a() {
        }

        @Override // com.kugou.common.network.protocol.AbstractRequestPackage, com.kugou.common.network.protocol.RequestPackage
        public String getGetRequestParams() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("?ver=1");
            stringBuffer.append("&client=mobi");
            stringBuffer.append("&fmt=krc");
            stringBuffer.append("&charset=utf8");
            stringBuffer.append("&id=");
            stringBuffer.append(e.this.f598g);
            stringBuffer.append("&accesskey=");
            stringBuffer.append(e.this.f599h);
            return stringBuffer.toString();
        }

        @Override // com.kugou.common.network.protocol.RequestPackage
        public HttpEntity getPostRequestEntity() {
            return null;
        }

        @Override // com.kugou.common.network.protocol.RequestPackage
        public String getRequestModuleName() {
            return "Lyric";
        }

        @Override // com.kugou.common.network.protocol.RequestPackage
        public String getRequestType() {
            return "GET";
        }

        @Override // e.c.a.g.a.f.k.a
        public ConfigKey getUrlConfigKey() {
            return e.c.a.g.a.f.e.b.W0;
        }
    }

    public class b extends e.c.a.g.a.f.k.k.a<Object> implements INetworkState, AbsHttpClient.IHttpException {
        public long a;
        public long b;
        public e.c.a.g.a.d.b.a c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f601d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f602e;

        public b(int i2) {
            this.f602e = i2;
        }

        public e.c.a.g.a.d.b.a b() {
            return this.c;
        }

        public final void c() {
            if (e.this.r) {
                int i2 = this.f602e;
                if (i2 == 0) {
                    e.this.f595d = e.c.a.g.a.f.f.a.m + e.this.f597f + "-" + e.this.f598g + ".krc";
                    return;
                }
                if (i2 == 1) {
                    e.this.f595d = e.c.a.g.a.f.f.a.m + e.this.f597f + "-" + e.this.f598g + ".lrc";
                    return;
                }
                if (i2 == 2) {
                    e.this.f595d = e.c.a.g.a.f.f.a.m + e.this.f597f + "-" + e.this.f598g + ".txt";
                    return;
                }
                e.this.f595d = e.c.a.g.a.f.f.a.m + e.this.f597f + "-" + e.this.f598g + ".krc";
                return;
            }
            int i3 = this.f602e;
            if (i3 == 0) {
                e.this.f595d = e.c.a.g.a.f.f.a.l + e.this.f597f + "-" + e.this.c + ".krc";
                return;
            }
            if (i3 == 1) {
                e.this.f595d = e.c.a.g.a.f.f.a.l + e.this.f597f + "-" + e.this.c + ".lrc";
                return;
            }
            if (i3 == 2) {
                e.this.f595d = e.c.a.g.a.f.f.a.l + e.this.f597f + "-" + e.this.c + ".txt";
                return;
            }
            e.this.f595d = e.c.a.g.a.f.f.a.l + e.this.f597f + "-" + e.this.c + ".krc";
        }

        @Override // e.c.a.g.a.f.k.k.a, com.kugou.common.network.protocol.ResponsePackage
        public void getResponseData(Object obj) {
        }

        @Override // e.c.a.g.a.f.k.k.a, com.kugou.common.network.protocol.ResponsePackage
        public ResponseTypeChecker.ResponseType getResponseType() {
            return new ResponseTypeChecker.ResponseType(new e.c.a.g.a.d.x.s.c.b());
        }

        @Override // e.c.a.g.a.f.k.k.a, com.kugou.common.network.AbsHttpClient.IHttpException
        public void onContentException(int i2, String str, int i3, byte[] bArr) {
            if (e.this.l == null) {
                e.this.l = new d(e.c.c.o.f.a());
            }
            e.this.l.onLyricDownFailed();
        }

        @Override // e.c.a.g.a.f.k.k.a
        public void onHandleApmData(e.c.a.g.a.d.b.a aVar) {
            this.c = aVar;
        }

        @Override // e.c.a.g.a.f.k.k.a, com.kugou.common.network.AbsHttpClient.IHttpException
        public void onHeaderException(int i2, String str, int i3, Header[] headerArr) {
        }

        @Override // com.kugou.common.network.INetworkState
        public void onReadEnd() {
            System.currentTimeMillis();
        }

        @Override // com.kugou.common.network.INetworkState
        public void onReadStart() {
            System.currentTimeMillis();
        }

        @Override // com.kugou.common.network.INetworkState
        public void onRequest() {
        }

        @Override // com.kugou.common.network.INetworkState
        public void onResponse(int i2) {
            if (i2 == 200 || i2 == 206) {
                this.b = System.currentTimeMillis();
            }
        }

        @Override // com.kugou.common.network.INetworkState
        public void onStop() {
            long j = this.b;
            long j2 = this.a;
            if (j - j2 <= 0 || j2 <= 0) {
                return;
            }
            this.b = 0L;
            this.a = 0L;
        }

        @Override // e.c.a.g.a.f.k.k.a, com.kugou.common.network.protocol.ResponsePackage
        public void setContext(byte[] bArr) throws Throwable {
            String str;
            boolean z;
            String string = null;
            if (bArr == null || bArr.length <= 0) {
                str = null;
                z = false;
            } else {
                str = new String(bArr);
                z = true;
            }
            try {
                string = new JSONObject(str).getString("content");
            } catch (Exception unused) {
                this.f601d = true;
            }
            if (!(TextUtils.isEmpty(string) ? false : z)) {
                if (g0.a) {
                    g0.c("hch", "download failed");
                }
                if (e.this.l == null) {
                    e.this.l = new d(e.c.c.o.f.a());
                }
                e.this.l.onLyricDownFailed();
                this.f601d = true;
                return;
            }
            c();
            if (e.this.l == null) {
                e.this.l = new d(e.c.c.o.f.a());
            }
            e.this.l.onLyricDownSuccess();
            e.this.u = Base64Util.decode(string);
            try {
                e.c.a.g.a.f.g.a aVar = new e.c.a.g.a.f.g.a(e.c.a.g.a.f.f.a.l);
                if (!aVar.exists()) {
                    aVar.mkdirs();
                }
                e.c.a.g.a.f.g.a aVar2 = new e.c.a.g.a.f.g.a(e.c.a.g.a.f.f.a.m);
                if (!aVar2.exists()) {
                    aVar2.mkdirs();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            String str2 = e.this.f595d + "-" + System.currentTimeMillis();
            boolean zG = q.g(str2, 1);
            boolean zA = q.a(str2, e.this.u);
            boolean zO = q.O(str2, e.this.f595d);
            if (!zG || !zA || !zO) {
                e.this.t = new e.c.a.g.a.d.b.a();
                e.this.t.k(ResponseHandlerForApm.E5);
                e.this.t.g("25");
                e.this.t.i(17);
                e.this.f595d = "";
            }
            if (g0.a) {
                g0.c("hch", "download success msavepath= " + e.this.f595d + " --- offset = " + e.this.s);
            }
        }
    }

    public e(Context context, String str, long j, String str2, String str3, String str4, String str5, int i2, int i3, long j2, boolean z, boolean z2) {
        this(context, str, j, str2, str3, str4, str5, i3, j2, z);
        this.r = z2;
        this.f600i = i2;
    }

    public void A(String str) {
    }

    public String m() {
        if (TextUtils.isEmpty(this.f599h) || TextUtils.isEmpty(this.f598g)) {
            h hVar = new h(this.a, this.b, this.c, this.j);
            ArrayList<e.c.a.g.a.d.x.s.b.b> arrayListR = hVar.r(true);
            this.m = hVar.y();
            this.o = hVar.z();
            this.p = hVar.x();
            this.q = hVar.w();
            hVar.t();
            hVar.u();
            if (arrayListR != null && arrayListR.size() > 0) {
                this.f598g = String.valueOf(arrayListR.get(0).d());
                this.f599h = arrayListR.get(0).a();
                this.s = arrayListR.get(0).e();
                this.f600i = arrayListR.get(0).c();
            }
            if (this.m) {
                e.c.a.g.a.d.b.a aVar = new e.c.a.g.a.d.b.a();
                this.t = aVar;
                aVar.k(hVar.v().c());
                this.t.g(hVar.v().a());
                this.t.i(11);
            }
            if (this.o) {
                e.c.a.g.a.d.b.a aVar2 = new e.c.a.g.a.d.b.a();
                this.t = aVar2;
                aVar2.k(ResponseHandlerForApm.E5);
                this.t.g("24");
                this.t.i(16);
            }
            if (!this.o && !this.m && !TextUtils.isEmpty(this.f599h)) {
                w(this.f598g);
            }
        }
        if (!this.o && !this.m && (TextUtils.isEmpty(this.f599h) || w(this.f598g))) {
            e.c.a.g.a.d.b.a aVar3 = new e.c.a.g.a.d.b.a();
            this.t = aVar3;
            aVar3.k(ResponseHandlerForApm.E2);
            if (w(this.f598g)) {
                this.t.g("15");
                this.t.i(13);
            } else {
                this.t.g("17");
                this.t.i(12);
            }
        }
        if (TextUtils.isEmpty(this.f599h) || TextUtils.isEmpty(this.f598g)) {
            return "";
        }
        a aVar4 = new a();
        b bVar = new b(this.f600i);
        String str = aVar4.getUrl() + aVar4.getGetRequestParams();
        this.f596e.setNetworkStateListener(bVar);
        try {
            this.f596e.request(aVar4, bVar);
            if (g0.a) {
                g0.b("zkzhou", "手机酷狗歌词下载");
            }
            this.k = this.f596e.getRequestDelay();
            if (bVar.f601d) {
                this.n = true;
                e.c.a.g.a.d.b.a aVar5 = new e.c.a.g.a.d.b.a();
                this.t = aVar5;
                aVar5.k(ResponseHandlerForApm.E2);
                this.t.g("19");
                this.t.i(15);
            }
        } catch (Exception e2) {
            this.n = true;
            if (g0.a) {
                g0.b("zkzhou", "手机酷狗歌词下载失败，msg = " + e2.getMessage());
            }
            e.c.a.g.a.d.b.a aVar6 = new e.c.a.g.a.d.b.a();
            this.t = aVar6;
            aVar6.k(bVar.b().c());
            this.t.g(bVar.b().a());
            this.t.i(15);
        }
        return this.f595d;
    }

    public String n(e.c.a.g.a.d.x.s.b.a aVar) {
        return g.c(aVar);
    }

    public String o(e.c.a.g.a.d.x.s.b.a aVar) {
        return g.d(aVar);
    }

    public int p() {
        return this.f600i;
    }

    public RequestDelay q() {
        return this.k;
    }

    public byte[] r() {
        return this.u;
    }

    public e.c.a.g.a.d.b.a s() {
        return this.t;
    }

    public int t() {
        return this.q;
    }

    public boolean u() {
        return this.n;
    }

    public boolean v() {
        return this.p;
    }

    public final boolean w(String str) {
        return TextUtils.isEmpty(str) || String.valueOf(Integer.MIN_VALUE).equals(this.f598g);
    }

    public boolean x() {
        return this.o;
    }

    public boolean y() {
        return this.m;
    }

    public void z(boolean z) {
    }

    public e(Context context, String str, long j, String str2, String str3, String str4, int i2, long j2) {
        this.r = false;
        this.t = null;
        this.a = str != null ? str.trim() : str;
        this.b = j;
        this.c = str2;
        this.f599h = str4;
        this.s = i2;
        this.j = j2;
        this.u = null;
        String strA = h1.a(str3);
        this.f597f = strA;
        if (q.H(strA)) {
            this.f597f = q0.g(this.f597f);
        }
        if (g0.a) {
            g0.c("lyric mix song id", "lyric mix song id lyric download " + this.j);
        }
        this.f596e = e.c.a.g.a.f.k.k.e.a();
    }

    public e(Context context, String str, long j, String str2, String str3, String str4, String str5, int i2, long j2, boolean z) {
        this(context, str, j, str2, str3, str5, i2, j2);
        this.f598g = str4;
    }
}
