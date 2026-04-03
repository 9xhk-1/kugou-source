package e.f.a.a.d.a;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends e.f.a.a.d.b.f implements Cloneable {
    public static ArrayList<d> b;
    public ArrayList<d> a = null;

    @Override // e.f.a.a.d.b.f
    public void a(StringBuilder sb, int i2) {
    }

    @Override // e.f.a.a.d.b.f
    public void b(e.f.a.a.d.b.d dVar) {
        if (b == null) {
            b = new ArrayList<>();
            b.add(new d());
        }
        this.a = (ArrayList) dVar.h(b, 0, true);
    }

    @Override // e.f.a.a.d.b.f
    public void c(e.f.a.a.d.b.e eVar) {
        eVar.s(this.a, 0);
    }
}
