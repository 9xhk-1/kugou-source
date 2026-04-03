package d.a.a.a$b.e;

import com.kugou.framework.libcommon.netcore.BaseConnection;
import e.g.b.b;
import f.e0.o;
import f.j;
import f.k;
import f.u.u;
import f.z.d.j;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static final a a = new a();

    public final int a(String str) {
        Object objA;
        j.e(str, "<this>");
        try {
            j.a aVar = f.j.a;
            String str2 = (String) u.w(o.S(str, new String[]{BaseConnection.HTTP_REQ_ENTITY_JOIN}, false, 0, 6, null), 1);
            if (str2 == null) {
                str2 = "0";
            }
            objA = Integer.valueOf(Integer.parseInt(str2));
            f.j.a(objA);
        } catch (Throwable th) {
            j.a aVar2 = f.j.a;
            objA = k.a(th);
            f.j.a(objA);
        }
        Throwable thB = f.j.b(objA);
        if (thB != null) {
            b.a.b("CardDataTranslator", f.z.d.j.l("get card id has error ", thB.getMessage()));
        }
        if (f.j.c(objA)) {
            objA = 0;
        }
        return ((Number) objA).intValue();
    }

    public final int b(String str) {
        Object objA;
        f.z.d.j.e(str, "<this>");
        try {
            j.a aVar = f.j.a;
            String str2 = (String) u.w(o.S(str, new String[]{BaseConnection.HTTP_REQ_ENTITY_JOIN}, false, 0, 6, null), 0);
            if (str2 == null) {
                str2 = "0";
            }
            objA = Integer.valueOf(Integer.parseInt(str2));
            f.j.a(objA);
        } catch (Throwable th) {
            j.a aVar2 = f.j.a;
            objA = k.a(th);
            f.j.a(objA);
        }
        Throwable thB = f.j.b(objA);
        if (thB != null) {
            b.a.b("CardDataTranslator", f.z.d.j.l("get card type has error ", thB.getMessage()));
        }
        if (f.j.c(objA)) {
            objA = 0;
        }
        return ((Number) objA).intValue();
    }

    public final int c(String str) {
        Object objA;
        f.z.d.j.e(str, "<this>");
        try {
            j.a aVar = f.j.a;
            String str2 = (String) u.w(o.S(str, new String[]{BaseConnection.HTTP_REQ_ENTITY_JOIN}, false, 0, 6, null), 2);
            if (str2 == null) {
                str2 = "0";
            }
            objA = Integer.valueOf(Integer.parseInt(str2));
            f.j.a(objA);
        } catch (Throwable th) {
            j.a aVar2 = f.j.a;
            objA = k.a(th);
            f.j.a(objA);
        }
        Throwable thB = f.j.b(objA);
        if (thB != null) {
            b.a.b("CardDataTranslator", f.z.d.j.l("get card hostId has error ", thB.getMessage()));
        }
        if (f.j.c(objA)) {
            objA = 0;
        }
        return ((Number) objA).intValue();
    }
}
