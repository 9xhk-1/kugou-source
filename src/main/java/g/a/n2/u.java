package g.a.n2;

import com.kugou.common.apm.sdk.ApmDataKey;
import f.w.g;
import g.a.d2;

/* JADX INFO: loaded from: classes2.dex */
public final class u {
    public static final q a = new q("ZERO");
    public static final f.z.c.p<Object, g.b, Object> b = a.a;
    public static final f.z.c.p<d2<?>, g.b, d2<?>> c = b.a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final f.z.c.p<z, g.b, z> f1618d = d.a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final f.z.c.p<z, g.b, z> f1619e = c.a;

    public static final class a extends f.z.d.k implements f.z.c.p<Object, g.b, Object> {
        public static final a a = new a();

        public a() {
            super(2);
        }

        @Override // f.z.c.p
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Object obj, g.b bVar) {
            f.z.d.j.f(bVar, "element");
            if (!(bVar instanceof d2)) {
                return obj;
            }
            if (!(obj instanceof Integer)) {
                obj = null;
            }
            Integer num = (Integer) obj;
            int iIntValue = num != null ? num.intValue() : 1;
            return iIntValue == 0 ? bVar : Integer.valueOf(iIntValue + 1);
        }
    }

    public static final class b extends f.z.d.k implements f.z.c.p<d2<?>, g.b, d2<?>> {
        public static final b a = new b();

        public b() {
            super(2);
        }

        @Override // f.z.c.p
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final d2<?> invoke(d2<?> d2Var, g.b bVar) {
            f.z.d.j.f(bVar, "element");
            if (d2Var != null) {
                return d2Var;
            }
            if (!(bVar instanceof d2)) {
                bVar = null;
            }
            return (d2) bVar;
        }
    }

    public static final class c extends f.z.d.k implements f.z.c.p<z, g.b, z> {
        public static final c a = new c();

        public c() {
            super(2);
        }

        public final z a(z zVar, g.b bVar) {
            f.z.d.j.f(zVar, ApmDataKey.STATE);
            f.z.d.j.f(bVar, "element");
            if (bVar instanceof d2) {
                ((d2) bVar).restoreThreadContext(zVar.b(), zVar.d());
            }
            return zVar;
        }

        @Override // f.z.c.p
        public /* bridge */ /* synthetic */ z invoke(z zVar, g.b bVar) {
            z zVar2 = zVar;
            a(zVar2, bVar);
            return zVar2;
        }
    }

    public static final class d extends f.z.d.k implements f.z.c.p<z, g.b, z> {
        public static final d a = new d();

        public d() {
            super(2);
        }

        public final z a(z zVar, g.b bVar) {
            f.z.d.j.f(zVar, ApmDataKey.STATE);
            f.z.d.j.f(bVar, "element");
            if (bVar instanceof d2) {
                zVar.a(((d2) bVar).updateThreadContext(zVar.b()));
            }
            return zVar;
        }

        @Override // f.z.c.p
        public /* bridge */ /* synthetic */ z invoke(z zVar, g.b bVar) {
            z zVar2 = zVar;
            a(zVar2, bVar);
            return zVar2;
        }
    }

    public static final void a(f.w.g gVar, Object obj) {
        f.z.d.j.f(gVar, "context");
        if (obj == a) {
            return;
        }
        if (obj instanceof z) {
            ((z) obj).c();
            gVar.fold(obj, f1619e);
        } else {
            Object objFold = gVar.fold(null, c);
            if (objFold == null) {
                throw new f.p("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
            }
            ((d2) objFold).restoreThreadContext(gVar, obj);
        }
    }

    public static final Object b(f.w.g gVar) {
        f.z.d.j.f(gVar, "context");
        Object objFold = gVar.fold(0, b);
        if (objFold != null) {
            return objFold;
        }
        f.z.d.j.n();
        throw null;
    }

    public static final Object c(f.w.g gVar, Object obj) {
        f.z.d.j.f(gVar, "context");
        if (obj == null) {
            obj = b(gVar);
        }
        if (obj == 0) {
            return a;
        }
        if (obj instanceof Integer) {
            return gVar.fold(new z(gVar, ((Number) obj).intValue()), f1618d);
        }
        if (obj != null) {
            return ((d2) obj).updateThreadContext(gVar);
        }
        throw new f.p("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
    }
}
