package e.c.a.g.a.f.o.i;

import android.os.Build;
import com.kugou.android.watch.lite.base.application.KGApplication;
import e.c.a.g.a.s.f1;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.t;
import e.c.a.g.a.s.x1;
import f.z.d.j;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static final b a = new b(null);

    /* JADX INFO: renamed from: e.c.a.g.a.f.o.i.a$a, reason: collision with other inner class name */
    public static final class C0109a extends a {
        public final e.c.a.g.a.f.o.i.b b;

        public C0109a() {
            e.c.a.g.a.f.o.i.b bVarI = i();
            this.b = bVarI;
            if (g0.a) {
                g0.b("young-hqd", j.l("ChangHongCorner: ", bVarI));
            }
        }

        @Override // e.c.a.g.a.f.o.i.a
        public int b() {
            return (int) this.b.b();
        }

        @Override // e.c.a.g.a.f.o.i.a
        public int c() {
            return (int) this.b.c();
        }

        @Override // e.c.a.g.a.f.o.i.a
        public boolean h() {
            return this.b.d();
        }

        public final e.c.a.g.a.f.o.i.b i() {
            e.c.a.g.a.f.o.i.b bVar;
            e.c.a.g.a.f.o.i.b bVar2;
            Object obj;
            String strQ = l1.q();
            int i2 = 0;
            e.c.a.g.a.f.o.i.b[] bVarArr = {new e.c.a.g.a.f.o.i.b("D1", 6.0f, 6.0f), new e.c.a.g.a.f.o.i.b("X800", true), new e.c.a.g.a.f.o.i.b("A9", true)};
            while (true) {
                bVar = null;
                obj = null;
                if (i2 >= 3) {
                    bVar2 = null;
                    break;
                }
                bVar2 = bVarArr[i2];
                if (j.a(strQ, bVar2.a)) {
                    break;
                }
                i2++;
            }
            if (bVar2 != null) {
                return bVar2;
            }
            List listB = t.b(e.c.a.g.a.f.e.c.a.a().getConfig(e.c.a.g.a.f.e.b.O2), e.c.a.g.a.f.o.i.b.class);
            if (listB != null) {
                Iterator it = listB.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (j.a(strQ, ((e.c.a.g.a.f.o.i.b) next).a)) {
                        obj = next;
                        break;
                    }
                }
                bVar = (e.c.a.g.a.f.o.i.b) obj;
            }
            return bVar != null ? bVar : new e.c.a.g.a.f.o.i.b("unknown", 6.0f, 8.0f);
        }
    }

    public static final class b {
        public b() {
        }

        public /* synthetic */ b(f.z.d.g gVar) {
            this();
        }

        public final a a() {
            return l1.f0() ? new g() : l1.e0() ? new h() : l1.N() ? new C0109a() : l1.X() ? new d() : l1.b0() ? l1.a0() ? new e() : new f() : new c();
        }
    }

    public static final class c extends a {
        @Override // e.c.a.g.a.f.o.i.a
        public int b() {
            return -1;
        }

        @Override // e.c.a.g.a.f.o.i.a
        public int c() {
            return -1;
        }

        @Override // e.c.a.g.a.f.o.i.a
        public boolean h() {
            return false;
        }
    }

    public static final class d extends a {
        public final e.c.a.g.a.f.o.i.b b;

        public d() {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(new f1(202, 960), Float.valueOf(61.0f));
            Float f2 = (Float) linkedHashMap.get(KGApplication.getDefaultSize());
            this.b = new e.c.a.g.a.f.o.i.b("unknown", 0.0f, f2 == null ? 0.0f : f2.floatValue());
        }

        @Override // e.c.a.g.a.f.o.i.a
        public int b() {
            return (int) this.b.b();
        }

        @Override // e.c.a.g.a.f.o.i.a
        public int c() {
            return (int) this.b.c();
        }

        @Override // e.c.a.g.a.f.o.i.a
        public boolean h() {
            return this.b.d();
        }
    }

    public static final class e extends a {
        public final e.c.a.g.a.f.o.i.b b = new e.c.a.g.a.f.o.i.b("unknown", true);

        @Override // e.c.a.g.a.f.o.i.a
        public int b() {
            return -1;
        }

        @Override // e.c.a.g.a.f.o.i.a
        public int c() {
            return -1;
        }

        @Override // e.c.a.g.a.f.o.i.a
        public int d() {
            return (int) this.b.b();
        }

        @Override // e.c.a.g.a.f.o.i.a
        public int e() {
            return (int) this.b.c();
        }

        @Override // e.c.a.g.a.f.o.i.a
        public boolean h() {
            return this.b.d();
        }
    }

    public static final class f extends a {
        public final e.c.a.g.a.f.o.i.b b = new e.c.a.g.a.f.o.i.b("unknown", x1.a(3), x1.a(4));

        @Override // e.c.a.g.a.f.o.i.a
        public int b() {
            return (int) this.b.b();
        }

        @Override // e.c.a.g.a.f.o.i.a
        public int c() {
            return (int) this.b.c();
        }

        @Override // e.c.a.g.a.f.o.i.a
        public boolean h() {
            return this.b.d();
        }
    }

    public static final class g extends a {
        public final e.c.a.g.a.f.o.i.b b;

        public g() {
            e.c.a.g.a.f.o.i.b bVarI = i();
            this.b = bVarI;
            if (g0.a) {
                g0.b("young-hqd", j.l("OppoCorner: ", bVarI));
            }
        }

        @Override // e.c.a.g.a.f.o.i.a
        public int b() {
            return (int) this.b.b();
        }

        @Override // e.c.a.g.a.f.o.i.a
        public int c() {
            return (int) this.b.c();
        }

        @Override // e.c.a.g.a.f.o.i.a
        public boolean h() {
            return this.b.d();
        }

        public final e.c.a.g.a.f.o.i.b i() {
            e.c.a.g.a.f.o.i.b bVar;
            e.c.a.g.a.f.o.i.b bVar2;
            Object obj;
            int i2 = 0;
            if (Build.VERSION.SDK_INT >= 23 && KGApplication.getContext().getResources().getConfiguration().isScreenRound()) {
                return new e.c.a.g.a.f.o.i.b("unknown", true);
            }
            String strQ = l1.q();
            e.c.a.g.a.f.o.i.b[] bVarArr = {new e.c.a.g.a.f.o.i.b("OWW231", true)};
            while (true) {
                bVar = null;
                obj = null;
                if (i2 >= 1) {
                    bVar2 = null;
                    break;
                }
                bVar2 = bVarArr[i2];
                if (j.a(strQ, bVar2.a)) {
                    break;
                }
                i2++;
            }
            if (bVar2 != null) {
                return bVar2;
            }
            List listB = t.b(e.c.a.g.a.f.e.c.a.a().getConfig(e.c.a.g.a.f.e.b.O2), e.c.a.g.a.f.o.i.b.class);
            if (listB != null) {
                Iterator it = listB.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (j.a(strQ, ((e.c.a.g.a.f.o.i.b) next).a)) {
                        obj = next;
                        break;
                    }
                }
                bVar = (e.c.a.g.a.f.o.i.b) obj;
            }
            return bVar != null ? bVar : new e.c.a.g.a.f.o.i.b("unknown", 3.0f, 3.0f);
        }
    }

    public static final class h extends a {
        public final int b = l1.c(8.0f);

        @Override // e.c.a.g.a.f.o.i.a
        public int b() {
            return -1;
        }

        @Override // e.c.a.g.a.f.o.i.a
        public int c() {
            return this.b;
        }

        @Override // e.c.a.g.a.f.o.i.a
        public boolean h() {
            return false;
        }
    }

    public static final a a() {
        return a.a();
    }

    public abstract int b();

    public abstract int c();

    public int d() {
        return b();
    }

    public int e() {
        return c();
    }

    public final int f(int i2) {
        return i2 == 3 ? d() : b();
    }

    public final int g(int i2) {
        return i2 == 3 ? e() : c();
    }

    public abstract boolean h();
}
