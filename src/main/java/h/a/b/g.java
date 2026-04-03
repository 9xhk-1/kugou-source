package h.a.b;

import java.io.IOException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g extends c {
    public URLConnection c(URL url, Proxy proxy) throws IOException {
        return url.openConnection(proxy);
    }
}
