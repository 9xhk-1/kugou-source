package f.z.d;

import f.u.c0;
import f.u.d0;
import f.z.c.w;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements f.c0.b<Object>, d {
    public static final Map<Class<? extends f.b<?>>, Integer> b;
    public static final HashMap<String, String> c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final HashMap<String, String> f1555d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final HashMap<String, String> f1556e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Map<String, String> f1557f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f1558g = new a(null);
    public final Class<?> a;

    public static final class a {
        public a() {
        }

        public final String a(Class<?> cls) {
            String str;
            j.e(cls, "jClass");
            String str2 = null;
            if (cls.isAnonymousClass() || cls.isLocalClass()) {
                return null;
            }
            if (!cls.isArray()) {
                String str3 = (String) e.f1556e.get(cls.getName());
                return str3 != null ? str3 : cls.getCanonicalName();
            }
            Class<?> componentType = cls.getComponentType();
            j.d(componentType, "componentType");
            if (componentType.isPrimitive() && (str = (String) e.f1556e.get(componentType.getName())) != null) {
                str2 = str + "Array";
            }
            return str2 != null ? str2 : "kotlin.Array";
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0043  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.String b(java.lang.Class<?> r8) {
            /*
                r7 = this;
                java.lang.String r0 = "jClass"
                f.z.d.j.e(r8, r0)
                boolean r0 = r8.isAnonymousClass()
                java.lang.String r1 = "Array"
                r2 = 0
                if (r0 == 0) goto L11
            Le:
                r1 = r2
                goto Lc1
            L11:
                boolean r0 = r8.isLocalClass()
                if (r0 == 0) goto L73
                java.lang.String r0 = r8.getSimpleName()
                java.lang.reflect.Method r1 = r8.getEnclosingMethod()
                java.lang.String r3 = "$"
                r4 = 2
                java.lang.String r5 = "name"
                if (r1 == 0) goto L43
                f.z.d.j.d(r0, r5)
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r1 = r1.getName()
                r6.append(r1)
                r6.append(r3)
                java.lang.String r1 = r6.toString()
                java.lang.String r1 = f.e0.o.Z(r0, r1, r2, r4, r2)
                if (r1 == 0) goto L43
                goto L66
            L43:
                java.lang.reflect.Constructor r8 = r8.getEnclosingConstructor()
                if (r8 == 0) goto L65
                f.z.d.j.d(r0, r5)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r8 = r8.getName()
                r1.append(r8)
                r1.append(r3)
                java.lang.String r8 = r1.toString()
                java.lang.String r8 = f.e0.o.Z(r0, r8, r2, r4, r2)
                r1 = r8
                goto L66
            L65:
                r1 = r2
            L66:
                if (r1 == 0) goto L69
                goto Lc1
            L69:
                f.z.d.j.d(r0, r5)
                r8 = 36
                java.lang.String r1 = f.e0.o.Y(r0, r8, r2, r4, r2)
                goto Lc1
            L73:
                boolean r0 = r8.isArray()
                if (r0 == 0) goto Lab
                java.lang.Class r8 = r8.getComponentType()
                java.lang.String r0 = "componentType"
                f.z.d.j.d(r8, r0)
                boolean r0 = r8.isPrimitive()
                if (r0 == 0) goto La7
                java.util.Map r0 = f.z.d.e.c()
                java.lang.String r8 = r8.getName()
                java.lang.Object r8 = r0.get(r8)
                java.lang.String r8 = (java.lang.String) r8
                if (r8 == 0) goto La7
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                r0.append(r8)
                r0.append(r1)
                java.lang.String r2 = r0.toString()
            La7:
                if (r2 == 0) goto Lc1
                goto Le
            Lab:
                java.util.Map r0 = f.z.d.e.c()
                java.lang.String r1 = r8.getName()
                java.lang.Object r0 = r0.get(r1)
                r1 = r0
                java.lang.String r1 = (java.lang.String) r1
                if (r1 == 0) goto Lbd
                goto Lc1
            Lbd:
                java.lang.String r1 = r8.getSimpleName()
            Lc1:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: f.z.d.e.a.b(java.lang.Class):java.lang.String");
        }

        public final boolean c(Object obj, Class<?> cls) {
            j.e(cls, "jClass");
            Map map = e.b;
            Objects.requireNonNull(map, "null cannot be cast to non-null type kotlin.collections.Map<K, V>");
            Integer num = (Integer) map.get(cls);
            if (num != null) {
                return v.c(obj, num.intValue());
            }
            if (cls.isPrimitive()) {
                cls = f.z.a.a(f.z.a.b(cls));
            }
            return cls.isInstance(obj);
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        int i2 = 0;
        List listF = f.u.m.f(f.z.c.a.class, f.z.c.l.class, f.z.c.p.class, f.z.c.q.class, f.z.c.r.class, f.z.c.s.class, f.z.c.t.class, f.z.c.u.class, f.z.c.v.class, w.class, f.z.c.b.class, f.z.c.c.class, f.z.c.d.class, f.z.c.e.class, f.z.c.f.class, f.z.c.g.class, f.z.c.h.class, f.z.c.i.class, f.z.c.j.class, f.z.c.k.class, f.z.c.m.class, f.z.c.n.class, f.z.c.o.class);
        ArrayList arrayList = new ArrayList(f.u.n.j(listF, 10));
        for (Object obj : listF) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                f.u.m.i();
                throw null;
            }
            arrayList.add(f.o.a((Class) obj, Integer.valueOf(i2)));
            i2 = i3;
        }
        b = d0.g(arrayList);
        HashMap<String, String> map = new HashMap<>();
        map.put("boolean", "kotlin.Boolean");
        map.put("char", "kotlin.Char");
        map.put("byte", "kotlin.Byte");
        map.put("short", "kotlin.Short");
        map.put("int", "kotlin.Int");
        map.put("float", "kotlin.Float");
        map.put("long", "kotlin.Long");
        map.put("double", "kotlin.Double");
        c = map;
        HashMap<String, String> map2 = new HashMap<>();
        map2.put("java.lang.Boolean", "kotlin.Boolean");
        map2.put("java.lang.Character", "kotlin.Char");
        map2.put("java.lang.Byte", "kotlin.Byte");
        map2.put("java.lang.Short", "kotlin.Short");
        map2.put("java.lang.Integer", "kotlin.Int");
        map2.put("java.lang.Float", "kotlin.Float");
        map2.put("java.lang.Long", "kotlin.Long");
        map2.put("java.lang.Double", "kotlin.Double");
        f1555d = map2;
        HashMap<String, String> map3 = new HashMap<>();
        map3.put("java.lang.Object", "kotlin.Any");
        map3.put("java.lang.String", "kotlin.String");
        map3.put("java.lang.CharSequence", "kotlin.CharSequence");
        map3.put("java.lang.Throwable", "kotlin.Throwable");
        map3.put("java.lang.Cloneable", "kotlin.Cloneable");
        map3.put("java.lang.Number", "kotlin.Number");
        map3.put("java.lang.Comparable", "kotlin.Comparable");
        map3.put("java.lang.Enum", "kotlin.Enum");
        map3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        map3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        map3.put("java.util.Iterator", "kotlin.collections.Iterator");
        map3.put("java.util.Collection", "kotlin.collections.Collection");
        map3.put("java.util.List", "kotlin.collections.List");
        map3.put("java.util.Set", "kotlin.collections.Set");
        map3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        map3.put("java.util.Map", "kotlin.collections.Map");
        map3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        map3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        map3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        map3.putAll(map);
        map3.putAll(map2);
        Collection<String> collectionValues = map.values();
        j.d(collectionValues, "primitiveFqNames.values");
        for (String str : collectionValues) {
            StringBuilder sb = new StringBuilder();
            sb.append("kotlin.jvm.internal.");
            j.d(str, "kotlinName");
            sb.append(f.e0.o.b0(str, '.', null, 2, null));
            sb.append("CompanionObject");
            f.i iVarA = f.o.a(sb.toString(), str + ".Companion");
            map3.put(iVarA.c(), iVarA.d());
        }
        for (Map.Entry<Class<? extends f.b<?>>, Integer> entry : b.entrySet()) {
            map3.put(entry.getKey().getName(), "kotlin.Function" + entry.getValue().intValue());
        }
        f1556e = map3;
        LinkedHashMap linkedHashMap = new LinkedHashMap(c0.a(map3.size()));
        for (Map.Entry entry2 : map3.entrySet()) {
            linkedHashMap.put(entry2.getKey(), f.e0.o.b0((String) entry2.getValue(), '.', null, 2, null));
        }
        f1557f = linkedHashMap;
    }

    public e(Class<?> cls) {
        j.e(cls, "jClass");
        this.a = cls;
    }

    public final Void d() {
        throw new f.z.b();
    }

    @Override // f.c0.b
    public boolean equals(Object obj) {
        return (obj instanceof e) && j.a(f.z.a.a(this), f.z.a.a((f.c0.b) obj));
    }

    @Override // f.c0.b
    public List<Annotation> getAnnotations() {
        d();
        throw null;
    }

    @Override // f.c0.b
    public Collection<Object<Object>> getConstructors() {
        d();
        throw null;
    }

    @Override // f.z.d.d
    public Class<?> getJClass() {
        return this.a;
    }

    @Override // f.c0.b, f.c0.d
    public Collection<f.c0.a<?>> getMembers() {
        d();
        throw null;
    }

    @Override // f.c0.b
    public Collection<f.c0.b<?>> getNestedClasses() {
        d();
        throw null;
    }

    @Override // f.c0.b
    public Object getObjectInstance() {
        d();
        throw null;
    }

    @Override // f.c0.b
    public String getQualifiedName() {
        return f1558g.a(getJClass());
    }

    @Override // f.c0.b
    public List<f.c0.b<? extends Object>> getSealedSubclasses() {
        d();
        throw null;
    }

    @Override // f.c0.b
    public String getSimpleName() {
        return f1558g.b(getJClass());
    }

    @Override // f.c0.b
    public List<f.c0.g> getSupertypes() {
        d();
        throw null;
    }

    @Override // f.c0.b
    public List<Object> getTypeParameters() {
        d();
        throw null;
    }

    @Override // f.c0.b
    public f.c0.h getVisibility() {
        d();
        throw null;
    }

    @Override // f.c0.b
    public int hashCode() {
        return f.z.a.a(this).hashCode();
    }

    @Override // f.c0.b
    public boolean isAbstract() {
        d();
        throw null;
    }

    @Override // f.c0.b
    public boolean isCompanion() {
        d();
        throw null;
    }

    @Override // f.c0.b
    public boolean isData() {
        d();
        throw null;
    }

    @Override // f.c0.b
    public boolean isFinal() {
        d();
        throw null;
    }

    @Override // f.c0.b
    public boolean isFun() {
        d();
        throw null;
    }

    @Override // f.c0.b
    public boolean isInner() {
        d();
        throw null;
    }

    @Override // f.c0.b
    public boolean isInstance(Object obj) {
        return f1558g.c(obj, getJClass());
    }

    @Override // f.c0.b
    public boolean isOpen() {
        d();
        throw null;
    }

    @Override // f.c0.b
    public boolean isSealed() {
        d();
        throw null;
    }

    @Override // f.c0.b
    public boolean isValue() {
        d();
        throw null;
    }

    public String toString() {
        return getJClass().toString() + " (Kotlin reflection is not available)";
    }
}
