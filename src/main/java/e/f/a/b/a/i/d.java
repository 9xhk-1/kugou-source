package e.f.a.b.a.i;

import f.s;
import f.z.c.l;
import f.z.d.j;
import f.z.d.k;

/* JADX INFO: loaded from: classes2.dex */
public enum d {
    INIT(null),
    ON(a.a),
    OFF(b.a);

    public final l<e.f.a.b.a.i.b, s> a;

    public static final class a extends k implements l<e.f.a.b.a.i.b, s> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        public final void a(e.f.a.b.a.i.b bVar) {
            j.f(bVar, "observer");
            bVar.on();
        }

        @Override // f.z.c.l
        public /* bridge */ /* synthetic */ s invoke(e.f.a.b.a.i.b bVar) {
            a(bVar);
            return s.a;
        }
    }

    public static final class b extends k implements l<e.f.a.b.a.i.b, s> {
        public static final b a = new b();

        public b() {
            super(1);
        }

        public final void a(e.f.a.b.a.i.b bVar) {
            j.f(bVar, "observer");
            bVar.off();
        }

        @Override // f.z.c.l
        public /* bridge */ /* synthetic */ s invoke(e.f.a.b.a.i.b bVar) {
            a(bVar);
            return s.a;
        }
    }

    d(l lVar) {
        this.a = lVar;
    }

    public final l<e.f.a.b.a.i.b, s> a() {
        return this.a;
    }
}
