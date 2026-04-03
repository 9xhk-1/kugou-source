package f.y;

import f.d0.g;
import f.s;
import f.z.c.l;
import f.z.d.j;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class e {
    public static final long a(Reader reader, Writer writer, int i2) throws IOException {
        j.e(reader, "$this$copyTo");
        j.e(writer, "out");
        char[] cArr = new char[i2];
        int i3 = reader.read(cArr);
        long j = 0;
        while (i3 >= 0) {
            writer.write(cArr, 0, i3);
            j += (long) i3;
            i3 = reader.read(cArr);
        }
        return j;
    }

    public static /* synthetic */ long b(Reader reader, Writer writer, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 8192;
        }
        return a(reader, writer, i2);
    }

    public static final void c(Reader reader, l<? super String, s> lVar) {
        j.e(reader, "$this$forEachLine");
        j.e(lVar, "action");
        BufferedReader bufferedReader = reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, 8192);
        try {
            Iterator<String> it = d(bufferedReader).iterator();
            while (it.hasNext()) {
                lVar.invoke(it.next());
            }
            s sVar = s.a;
            a.a(bufferedReader, null);
        } finally {
        }
    }

    public static final f.d0.b<String> d(BufferedReader bufferedReader) {
        j.e(bufferedReader, "$this$lineSequence");
        return g.d(new d(bufferedReader));
    }

    public static final String e(Reader reader) {
        j.e(reader, "$this$readText");
        StringWriter stringWriter = new StringWriter();
        b(reader, stringWriter, 0, 2, null);
        String string = stringWriter.toString();
        j.d(string, "buffer.toString()");
        return string;
    }
}
