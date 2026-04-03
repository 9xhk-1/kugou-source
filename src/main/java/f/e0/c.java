package f.e0;

import java.nio.charset.Charset;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public static final Charset a;

    static {
        Charset charsetForName = Charset.forName("UTF-8");
        f.z.d.j.d(charsetForName, "Charset.forName(\"UTF-8\")");
        a = charsetForName;
        f.z.d.j.d(Charset.forName(HTTP.UTF_16), "Charset.forName(\"UTF-16\")");
        f.z.d.j.d(Charset.forName("UTF-16BE"), "Charset.forName(\"UTF-16BE\")");
        f.z.d.j.d(Charset.forName("UTF-16LE"), "Charset.forName(\"UTF-16LE\")");
        f.z.d.j.d(Charset.forName("US-ASCII"), "Charset.forName(\"US-ASCII\")");
        f.z.d.j.d(Charset.forName("ISO-8859-1"), "Charset.forName(\"ISO-8859-1\")");
    }
}
