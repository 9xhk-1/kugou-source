package h.a.b.p;

import com.kugou.common.network.netgate.AckProtocolTypeUtil;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class h implements URLStreamHandlerFactory {
    public final h.a.b.o.b a;

    public h(h.a.b.o.b bVar) {
        Objects.requireNonNull(bVar, "CronetEngine is null.");
        this.a = bVar;
    }

    @Override // java.net.URLStreamHandlerFactory
    public URLStreamHandler createURLStreamHandler(String str) {
        if ("http".equals(str) || AckProtocolTypeUtil.HTTPS_LABEL.equals(str)) {
            return new e(this.a);
        }
        return null;
    }
}
