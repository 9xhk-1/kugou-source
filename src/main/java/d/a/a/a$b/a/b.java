package d.a.a.a$b.a;

import android.content.Context;
import d.a.a.a$b.d.g;
import f.d;
import f.f;
import f.i;
import f.j;
import f.y.e;
import f.z.d.j;
import f.z.d.k;
import f.z.d.s;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static final b a = new b();
    public static final d b;
    public static final d c;

    public static final class a extends k implements f.z.c.a<d.a.a.a$b.a.c.a> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // f.z.c.a
        public d.a.a.a$b.a.c.a invoke() {
            e.g.a.b.b.a.g.a aVar = e.g.a.b.b.a.g.a.a;
            ConcurrentHashMap<f.c0.b<?>, d<?>> concurrentHashMapA = aVar.a();
            f.c0.b bVarA = s.a(d.a.a.a$b.a.c.a.class);
            Objects.requireNonNull(concurrentHashMapA, "null cannot be cast to non-null type kotlin.collections.Map<K, V>");
            d<?> orDefault = concurrentHashMapA.getOrDefault(bVarA, null);
            Object value = orDefault == null ? null : orDefault.getValue();
            d.a.a.a$b.a.c.a aVar2 = value instanceof d.a.a.a$b.a.c.a ? (d.a.a.a$b.a.c.a) value : null;
            if (aVar2 != null) {
                return aVar2;
            }
            b bVar = b.a;
            aVar.b(s.a(d.a.a.a$b.a.c.a.class));
            return null;
        }
    }

    /* JADX INFO: renamed from: d.a.a.a$b.a.b$b, reason: collision with other inner class name */
    public static final class C0031b extends k implements f.z.c.a<ConcurrentHashMap<String, e.g.a.b.a.a.a.a>> {
        public static final C0031b a = new C0031b();

        public C0031b() {
            super(0);
        }

        @Override // f.z.c.a
        public ConcurrentHashMap<String, e.g.a.b.a.a.a.a> invoke() {
            return new ConcurrentHashMap<>();
        }
    }

    public static final class c extends k implements f.z.c.a<d.a.a.a$b.a.c.b> {
        public static final c a = new c();

        public c() {
            super(0);
        }

        @Override // f.z.c.a
        public d.a.a.a$b.a.c.b invoke() {
            e.g.a.b.b.a.g.a aVar = e.g.a.b.b.a.g.a.a;
            ConcurrentHashMap<f.c0.b<?>, d<?>> concurrentHashMapA = aVar.a();
            f.c0.b bVarA = s.a(d.a.a.a$b.a.c.b.class);
            Objects.requireNonNull(concurrentHashMapA, "null cannot be cast to non-null type kotlin.collections.Map<K, V>");
            d<?> orDefault = concurrentHashMapA.getOrDefault(bVarA, null);
            Object value = orDefault == null ? null : orDefault.getValue();
            d.a.a.a$b.a.c.b bVar = value instanceof d.a.a.a$b.a.c.b ? (d.a.a.a$b.a.c.b) value : null;
            if (bVar != null) {
                return bVar;
            }
            b bVar2 = b.a;
            aVar.b(s.a(d.a.a.a$b.a.c.b.class));
            return null;
        }
    }

    static {
        f.b(a.a);
        b = f.b(c.a);
        c = f.b(C0031b.a);
    }

    public final d.a.a.a$b.a.c.a a() {
        e.g.a.b.b.a.g.a aVar = e.g.a.b.b.a.g.a.a;
        ConcurrentHashMap<f.c0.b<?>, d<?>> concurrentHashMapA = aVar.a();
        f.c0.b bVarA = s.a(d.a.a.a$b.a.c.a.class);
        Objects.requireNonNull(concurrentHashMapA, "null cannot be cast to non-null type kotlin.collections.Map<K, V>");
        d<?> orDefault = concurrentHashMapA.getOrDefault(bVarA, null);
        Object value = orDefault == null ? null : orDefault.getValue();
        d.a.a.a$b.a.c.a aVar2 = value instanceof d.a.a.a$b.a.c.a ? (d.a.a.a$b.a.c.a) value : null;
        if (aVar2 != null) {
            return aVar2;
        }
        aVar.b(s.a(d.a.a.a$b.a.c.a.class));
        return null;
    }

    public final String b(String str) {
        String strA;
        j.e(str, "widgetCode");
        d.a.a.a$b.a.c.b bVarI = i();
        String str2 = null;
        if (bVarI == null || (strA = bVarI.a(j.l("layoutName:", str))) == null || !g.a.a(strA)) {
            strA = null;
        }
        if (strA == null) {
            e.g.b.b.a.a("CardDataRepository", "[DEBUG_" + str + "] getLayoutName: return null");
        } else {
            str2 = strA;
        }
        e.g.b.b.a.a("CardDataRepository", "getLayoutName key:" + str + ", layoutName: " + ((Object) str2));
        return str2;
    }

    public final i<byte[], Boolean> c(String str, String str2) {
        e.g.b.b.a.b("CardDataRepository", "card layout is invalid widgetCode: " + str + ", layoutName: " + ((Object) str2));
        return new i<>(null, Boolean.FALSE);
    }

    public final void d(String str, e.g.a.b.a.a.a.a aVar) {
        j.e(str, "widgetCode");
        j.e(aVar, "holder");
        e.g.b.b.a.a("CardDataRepository", "registerLayoutHolder key:" + str + ", holder: " + aVar);
        f().put(str, aVar);
    }

    public final void e(String str, byte[] bArr) {
        j.e(str, "widgetCode");
        e.g.b.b bVar = e.g.b.b.a;
        StringBuilder sb = new StringBuilder();
        sb.append("updateLayoutData key:");
        sb.append(str);
        sb.append(", data is null:");
        sb.append(bArr == null);
        bVar.a("CardDataRepository", sb.toString());
        d.a.a.a$b.a.c.a aVarA = a();
        if (aVarA == null) {
            return;
        }
        aVarA.a(j.l("layoutData:", str), bArr);
    }

    public final ConcurrentHashMap<String, e.g.a.b.a.a.a.a> f() {
        return (ConcurrentHashMap) c.getValue();
    }

    public final i<byte[], Boolean> g(String str) {
        Object objA;
        Object objA2;
        byte[] bytes;
        Object objA3;
        j.e(str, "widgetCode");
        e.g.b.b.a.a("CardDataRepository", j.l("getLayoutData key: ", str));
        d.a.a.a$b.a.c.a aVarA = a();
        byte[] bArrB = aVarA == null ? null : aVarA.b(j.l("layoutData:", str));
        if (bArrB == null) {
            bArrB = null;
        } else {
            j.e(bArrB, "<this>");
            String str2 = new String(bArrB, f.e0.c.a);
            j.e(str2, "<this>");
            try {
                j.a aVar = f.j.a;
                new JSONObject(str2);
                objA = Boolean.TRUE;
                f.j.a(objA);
            } catch (Throwable th) {
                j.a aVar2 = f.j.a;
                objA = f.k.a(th);
                f.j.a(objA);
            }
            Throwable thB = f.j.b(objA);
            if (thB != null) {
                e.g.b.b.a.b("DataConvertHelper", f.z.d.j.l("checkIsEffectJsonData has error e: ", thB.getMessage()));
            }
            Boolean bool = Boolean.FALSE;
            if (f.j.c(objA)) {
                objA = bool;
            }
            if (!((Boolean) objA).booleanValue()) {
                str2 = null;
            }
            if (str2 != null) {
                e.g.b.b.a.a("CardDataRepository", "[DEBUG_" + str + "] getWidgetCardLayoutData data size: " + str2.length() + ", without forceUpdate");
                return new i<>(bArrB, bool);
            }
            e.g.b.b.a.a("CardDataRepository", f.z.d.j.l("current layout data is invalid: ", bArrB));
        }
        if (bArrB == null) {
            e.g.b.b.a.a("CardDataRepository", "get local layoutData is null");
        }
        String strB = b(str);
        if (strB == null) {
            e.g.b.b.a.a("CardDataRepository", f.z.d.j.l("get layout name active widgetCode: ", str));
            e.g.a.b.a.a.a.a aVar3 = f().get(str);
            strB = aVar3 == null ? null : aVar3.getCardLayoutName(str);
            if (strB == null) {
                return c(str, null);
            }
        }
        e.g.a.b.b.a.g.a aVar4 = e.g.a.b.b.a.g.a.a;
        ConcurrentHashMap<f.c0.b<?>, d<?>> concurrentHashMapA = aVar4.a();
        f.c0.b bVarA = s.a(Context.class);
        Objects.requireNonNull(concurrentHashMapA, "null cannot be cast to non-null type kotlin.collections.Map<K, V>");
        d<?> orDefault = concurrentHashMapA.getOrDefault(bVarA, null);
        Object value = orDefault == null ? null : orDefault.getValue();
        Context context = value instanceof Context ? (Context) value : null;
        if (context == null) {
            aVar4.b(s.a(Context.class));
            return c(str, strB);
        }
        f.z.d.j.e(strB, "<this>");
        f.z.d.j.e(context, "context");
        try {
            j.a aVar5 = f.j.a;
            InputStreamReader inputStreamReader = new InputStreamReader(context.getAssets().open(strB), f.e0.c.a);
            objA2 = e.e(inputStreamReader);
            inputStreamReader.close();
            f.j.a(objA2);
        } catch (Throwable th2) {
            j.a aVar6 = f.j.a;
            objA2 = f.k.a(th2);
            f.j.a(objA2);
        }
        Throwable thB2 = f.j.b(objA2);
        if (thB2 != null) {
            e.g.b.b.a.b("FileSourceHelper", f.z.d.j.l("loadFromAssert error: ", thB2.getMessage()));
        }
        if (f.j.c(objA2)) {
            objA2 = null;
        }
        String str3 = (String) objA2;
        if (str3 == null) {
            e.g.b.b.a.b("FileSourceHelper", "null cannot be cast to non-null type java.lang.String");
            bytes = null;
        } else {
            bytes = str3.getBytes(f.e0.c.a);
            f.z.d.j.d(bytes, "(this as java.lang.String).getBytes(charset)");
        }
        if (bytes == null) {
            return c(str, strB);
        }
        f.z.d.j.e(bytes, "<this>");
        String str4 = new String(bytes, f.e0.c.a);
        f.z.d.j.e(str4, "<this>");
        try {
            j.a aVar7 = f.j.a;
            new JSONObject(str4);
            objA3 = Boolean.TRUE;
            f.j.a(objA3);
        } catch (Throwable th3) {
            j.a aVar8 = f.j.a;
            objA3 = f.k.a(th3);
            f.j.a(objA3);
        }
        Throwable thB3 = f.j.b(objA3);
        if (thB3 != null) {
            e.g.b.b.a.b("DataConvertHelper", f.z.d.j.l("checkIsEffectJsonData has error e: ", thB3.getMessage()));
        }
        Boolean bool2 = Boolean.FALSE;
        if (f.j.c(objA3)) {
            objA3 = bool2;
        }
        if (!((Boolean) objA3).booleanValue()) {
            str4 = null;
        }
        if (str4 == null) {
            return c(str, strB);
        }
        e.g.b.b bVar = e.g.b.b.a;
        bVar.a("CardDataRepository", "[DEBUG_" + str + "] getCardLayoutInfo: create data size is: " + str4 + ", layoutName is: " + strB);
        bVar.a("CardDataRepository", f.z.d.j.l("getLayoutUpdateTime key:", str));
        d.a.a.a$b.a.c.b bVarI = i();
        boolean z = (bVarI != null ? bVarI.a(f.z.d.j.l("updateTime:", str)) : null) == null;
        h(str, String.valueOf(System.currentTimeMillis()));
        k(str, strB);
        e(str, bytes);
        return new i<>(bytes, Boolean.valueOf(z));
    }

    public final void h(String str, String str2) {
        f.z.d.j.e(str, "widgetCode");
        e.g.b.b.a.a("CardDataRepository", "setLayoutUpdateTime key:" + str + ", time:" + ((Object) str2));
        d.a.a.a$b.a.c.b bVarI = i();
        if (bVarI == null) {
            return;
        }
        bVarI.b(f.z.d.j.l("updateTime:", str), str2);
    }

    public final d.a.a.a$b.a.c.b i() {
        return (d.a.a.a$b.a.c.b) b.getValue();
    }

    public final void j(String str) {
        f.z.d.j.e(str, "widgetCode");
        e.g.b.b.a.a("CardDataRepository", f.z.d.j.l("registerLayoutHolder key:", str));
        f().remove(str);
    }

    public final void k(String str, String str2) {
        f.z.d.j.e(str, "widgetCode");
        f.z.d.j.e(str2, "name");
        e.g.b.b.a.a("CardDataRepository", "updateLayoutName key:" + str + ", name:" + str2);
        d.a.a.a$b.a.c.b bVarI = i();
        if (bVarI == null) {
            return;
        }
        bVarI.b(f.z.d.j.l("layoutName:", str), str2);
    }
}
