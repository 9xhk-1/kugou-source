package f.y;

import f.s;
import f.z.c.l;
import f.z.d.j;
import f.z.d.k;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class c extends b {

    public static final class a extends k implements l<String, s> {
        public final /* synthetic */ ArrayList a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ArrayList arrayList) {
            super(1);
            this.a = arrayList;
        }

        public final void a(String str) {
            j.e(str, "it");
            this.a.add(str);
        }

        @Override // f.z.c.l
        public /* bridge */ /* synthetic */ s invoke(String str) {
            a(str);
            return s.a;
        }
    }

    public static final void a(File file, Charset charset, l<? super String, s> lVar) {
        j.e(file, "$this$forEachLine");
        j.e(charset, "charset");
        j.e(lVar, "action");
        e.c(new BufferedReader(new InputStreamReader(new FileInputStream(file), charset)), lVar);
    }

    public static final List<String> b(File file, Charset charset) {
        j.e(file, "$this$readLines");
        j.e(charset, "charset");
        ArrayList arrayList = new ArrayList();
        a(file, charset, new a(arrayList));
        return arrayList;
    }

    public static /* synthetic */ List c(File file, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = f.e0.c.a;
        }
        return b(file, charset);
    }

    public static final String d(File file, Charset charset) throws IllegalAccessException, IOException, InvocationTargetException {
        j.e(file, "$this$readText");
        j.e(charset, "charset");
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
        try {
            String strE = e.e(inputStreamReader);
            f.y.a.a(inputStreamReader, null);
            return strE;
        } finally {
        }
    }

    public static /* synthetic */ String e(File file, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = f.e0.c.a;
        }
        return d(file, charset);
    }
}
