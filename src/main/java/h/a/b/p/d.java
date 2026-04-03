package h.a.b.p;

import android.annotation.SuppressLint;
import android.util.Pair;
import h.a.b.k;
import h.a.b.m;
import h.a.b.n;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes2.dex */
public class d extends HttpURLConnection {
    public static final String n = d.class.getSimpleName();
    public final h.a.b.c a;
    public final i b;
    public m c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<Pair<String, String>> f1681d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public f f1682e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public g f1683f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public k f1684g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public n f1685h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public IOException f1686i;
    public boolean j;
    public boolean k;
    public List<Map.Entry<String, String>> l;
    public Map<String, List<String>> m;

    public class a extends m.b {
        public a() {
        }

        public final void a(IOException iOException) {
            d.this.f1686i = iOException;
            if (d.this.f1682e != null) {
                d.this.f1682e.c(iOException);
            }
            if (d.this.f1683f != null) {
                d.this.f1683f.f(iOException);
            }
            d.this.k = true;
            d.this.b.c();
        }

        @Override // h.a.b.m.b
        public void onCanceled(m mVar, n nVar) {
            d.this.f1685h = nVar;
            a(new IOException("disconnect() called"));
        }

        @Override // h.a.b.m.b
        public void onFailed(m mVar, n nVar, h.a.b.d dVar) {
            if (dVar == null) {
                throw new IllegalStateException("Exception cannot be null in onFailed.");
            }
            d.this.f1685h = nVar;
            a(dVar);
        }

        @Override // h.a.b.m.b
        public void onReadCompleted(m mVar, n nVar, ByteBuffer byteBuffer) {
            d.this.f1685h = nVar;
            d.this.b.c();
        }

        @Override // h.a.b.m.b
        public void onRedirectReceived(m mVar, n nVar, String str) {
            d.this.j = true;
            try {
                URL url = new URL(str);
                boolean zEquals = url.getProtocol().equals(((HttpURLConnection) d.this).url.getProtocol());
                if (((HttpURLConnection) d.this).instanceFollowRedirects) {
                    ((HttpURLConnection) d.this).url = url;
                }
                if (((HttpURLConnection) d.this).instanceFollowRedirects && zEquals) {
                    d.this.c.b();
                    return;
                }
            } catch (MalformedURLException unused) {
            }
            d.this.f1685h = nVar;
            d.this.c.a();
            a(null);
        }

        @Override // h.a.b.m.b
        public void onResponseStarted(m mVar, n nVar) {
            d.this.f1685h = nVar;
            d.this.k = true;
            d.this.b.c();
        }

        @Override // h.a.b.m.b
        public void onSucceeded(m mVar, n nVar) {
            d.this.f1685h = nVar;
            a(null);
        }
    }

    public d(URL url, h.a.b.c cVar) {
        super(url);
        this.a = cVar;
        this.b = new i();
        this.f1682e = new f(this);
        this.f1681d = new ArrayList();
    }

    @Override // java.net.URLConnection
    public final void addRequestProperty(String str, String str2) {
        w(str, str2, false);
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        getOutputStream();
        x();
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        if (((HttpURLConnection) this).connected) {
            this.c.a();
        }
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        try {
            s();
            if (this.f1685h.b() >= 400) {
                return this.f1682e;
            }
            return null;
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String str) {
        try {
            s();
            Map<String, List<String>> mapO = o();
            if (!mapO.containsKey(str)) {
                return null;
            }
            return mapO.get(str).get(r4.size() - 1);
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderFieldKey(int i2) {
        Map.Entry<String, String> entryQ = q(i2);
        if (entryQ == null) {
            return null;
        }
        return entryQ.getKey();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        try {
            s();
            return o();
        } catch (IOException unused) {
            return Collections.emptyMap();
        }
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        s();
        if (!((HttpURLConnection) this).instanceFollowRedirects && this.j) {
            throw new IOException("Cannot read response body of a redirect.");
        }
        if (this.f1685h.b() < 400) {
            return this.f1682e;
        }
        throw new FileNotFoundException(((HttpURLConnection) this).url.toString());
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        if (this.f1683f == null && ((HttpURLConnection) this).doOutput) {
            if (((HttpURLConnection) this).connected) {
                throw new ProtocolException("Cannot write to OutputStream after receiving response.");
            }
            if (u()) {
                this.f1683f = new b(this, ((HttpURLConnection) this).chunkLength, this.b);
                x();
            } else {
                long jT = t();
                if (jT != -1) {
                    this.f1683f = new c(this, jT, this.b);
                    x();
                } else {
                    h.a.a.b.a(n, "Outputstream is being buffered in memory.");
                    String requestProperty = getRequestProperty("Content-Length");
                    if (requestProperty == null) {
                        this.f1683f = new h.a.b.p.a(this);
                    } else {
                        this.f1683f = new h.a.b.p.a(this, Long.parseLong(requestProperty));
                    }
                }
            }
        }
        return this.f1683f;
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getRequestProperties() {
        if (((HttpURLConnection) this).connected) {
            throw new IllegalStateException("Cannot access request headers after connection is set.");
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (Pair<String, String> pair : this.f1681d) {
            if (treeMap.containsKey(pair.first)) {
                throw new IllegalStateException("Should not have multiple values.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(pair.second);
            treeMap.put(pair.first, Collections.unmodifiableList(arrayList));
        }
        return Collections.unmodifiableMap(treeMap);
    }

    @Override // java.net.URLConnection
    public String getRequestProperty(String str) {
        int iN = n(str);
        if (iN >= 0) {
            return (String) this.f1681d.get(iN).second;
        }
        return null;
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        s();
        return this.f1685h.b();
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        s();
        return this.f1685h.c();
    }

    public final void m() throws IOException {
        if (!this.k) {
            throw new IllegalStateException("No response.");
        }
        IOException iOException = this.f1686i;
        if (iOException != null) {
            throw iOException;
        }
        Objects.requireNonNull(this.f1685h, "Response info is null when there is no exception.");
    }

    public final int n(String str) {
        for (int i2 = 0; i2 < this.f1681d.size(); i2++) {
            if (((String) this.f1681d.get(i2).first).equalsIgnoreCase(str)) {
                return i2;
            }
        }
        return -1;
    }

    public final Map<String, List<String>> o() {
        Map<String, List<String>> map = this.m;
        if (map != null) {
            return map;
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (Map.Entry<String, String> entry : p()) {
            ArrayList arrayList = new ArrayList();
            if (treeMap.containsKey(entry.getKey())) {
                arrayList.addAll((Collection) treeMap.get(entry.getKey()));
            }
            arrayList.add(entry.getValue());
            treeMap.put(entry.getKey(), Collections.unmodifiableList(arrayList));
        }
        Map<String, List<String>> mapUnmodifiableMap = Collections.unmodifiableMap(treeMap);
        this.m = mapUnmodifiableMap;
        return mapUnmodifiableMap;
    }

    public final List<Map.Entry<String, String>> p() {
        List<Map.Entry<String, String>> list = this.l;
        if (list != null) {
            return list;
        }
        this.l = new ArrayList();
        for (Map.Entry<String, String> entry : this.f1685h.a()) {
            if (!entry.getKey().equalsIgnoreCase(HTTP.CONTENT_ENCODING)) {
                this.l.add(new AbstractMap.SimpleImmutableEntry(entry));
            }
        }
        List<Map.Entry<String, String>> listUnmodifiableList = Collections.unmodifiableList(this.l);
        this.l = listUnmodifiableList;
        return listUnmodifiableList;
    }

    public final Map.Entry<String, String> q(int i2) {
        try {
            s();
            List<Map.Entry<String, String>> listP = p();
            if (i2 >= listP.size()) {
                return null;
            }
            return listP.get(i2);
        } catch (IOException unused) {
            return null;
        }
    }

    public void r(ByteBuffer byteBuffer) throws IOException {
        this.c.d(byteBuffer);
        this.b.b(getReadTimeout());
    }

    public final void s() throws IOException {
        g gVar = this.f1683f;
        if (gVar != null) {
            gVar.c();
            if (u()) {
                this.f1683f.close();
            }
        }
        if (!this.k) {
            x();
            this.b.a();
        }
        m();
    }

    @Override // java.net.URLConnection
    public void setConnectTimeout(int i2) {
        h.a.a.b.a(n, "setConnectTimeout is not supported by CronetHttpURLConnection");
    }

    @Override // java.net.URLConnection
    public final void setRequestProperty(String str, String str2) {
        w(str, str2, true);
    }

    @SuppressLint({"NewApi"})
    public final long t() {
        long j = ((HttpURLConnection) this).fixedContentLength;
        try {
            long j2 = getClass().getField("fixedContentLengthLong").getLong(this);
            return j2 != -1 ? j2 : j;
        } catch (IllegalAccessException | NoSuchFieldException unused) {
            return j;
        }
    }

    public final boolean u() {
        return ((HttpURLConnection) this).chunkLength > 0;
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return false;
    }

    public void v(k kVar) {
        this.f1684g = kVar;
    }

    public final void w(String str, String str2, boolean z) {
        if (((HttpURLConnection) this).connected) {
            throw new IllegalStateException("Cannot modify request property after connection is made.");
        }
        int iN = n(str);
        if (iN >= 0) {
            if (!z) {
                throw new UnsupportedOperationException("Cannot add multiple headers of the same key, " + str + ". crbug.com/432719.");
            }
            this.f1681d.remove(iN);
        }
        this.f1681d.add(Pair.create(str, str2));
    }

    public final void x() throws IOException {
        if (((HttpURLConnection) this).connected) {
            return;
        }
        m.a aVarA = this.a.a(getURL().toString(), new a(), this.b);
        if (((HttpURLConnection) this).doOutput || this.f1684g != null) {
            if (((HttpURLConnection) this).method.equals("GET")) {
                ((HttpURLConnection) this).method = "POST";
            }
            k kVar = this.f1684g;
            if (kVar != null) {
                aVarA.e(kVar, this.b);
                if (getRequestProperty("Content-Length") == null && !u()) {
                    addRequestProperty("Content-Length", Long.toString(this.f1684g.getLength()));
                }
            } else {
                g gVar = this.f1683f;
                if (gVar != null) {
                    aVarA.e(gVar.d(), this.b);
                    if (getRequestProperty("Content-Length") == null && !u()) {
                        addRequestProperty("Content-Length", Long.toString(this.f1683f.d().getLength()));
                    }
                    this.f1683f.e();
                } else if (getRequestProperty("Content-Length") == null) {
                    addRequestProperty("Content-Length", "0");
                }
            }
            if (getRequestProperty("Content-Type") == null) {
                addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            }
        }
        for (Pair<String, String> pair : this.f1681d) {
            aVarA.a((String) pair.first, (String) pair.second);
        }
        if (!getUseCaches()) {
            aVarA.c();
        }
        aVarA.d(((HttpURLConnection) this).method);
        ((HttpURLConnection) this).connected = true;
        m mVarB = aVarA.b();
        this.c = mVarB;
        mVarB.e();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderField(int i2) {
        Map.Entry<String, String> entryQ = q(i2);
        if (entryQ == null) {
            return null;
        }
        return entryQ.getValue();
    }
}
