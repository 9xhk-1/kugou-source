package androidx.core.os;

import f.z.c.a;
import f.z.d.i;
import f.z.d.j;

/* JADX INFO: loaded from: classes.dex */
public final class TraceKt {
    public static final <T> T trace(String str, a<? extends T> aVar) {
        j.f(str, "sectionName");
        j.f(aVar, "block");
        TraceCompat.beginSection(str);
        try {
            return aVar.invoke();
        } finally {
            i.b(1);
            TraceCompat.endSection();
            i.a(1);
        }
    }
}
