package h.a.b.p;

import java.io.IOException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

/* JADX INFO: loaded from: classes2.dex */
public class e extends URLStreamHandler {
    public final h.a.b.o.b a;

    public e(h.a.b.o.b bVar) {
        this.a = bVar;
    }

    @Override // java.net.URLStreamHandler
    public URLConnection openConnection(URL url) throws IOException {
        return this.a.b(url);
    }

    @Override // java.net.URLStreamHandler
    public URLConnection openConnection(URL url, Proxy proxy) throws IOException {
        return this.a.c(url, proxy);
    }
}
