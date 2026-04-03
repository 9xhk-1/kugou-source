package e.f.a.a.d.a;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends e.f.a.a.d.b.f implements Cloneable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static ArrayList<String> f1433d;
    public String a = "";
    public ArrayList<String> b = null;

    @Override // e.f.a.a.d.b.f
    public void a(StringBuilder sb, int i2) {
    }

    @Override // e.f.a.a.d.b.f
    public void b(e.f.a.a.d.b.d dVar) {
        this.a = dVar.y(0, true);
        if (f1433d == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            f1433d = arrayList;
            arrayList.add("");
        }
        this.b = (ArrayList) dVar.h(f1433d, 1, false);
    }

    @Override // e.f.a.a.d.b.f
    public void c(e.f.a.a.d.b.e eVar) {
        eVar.r(this.a, 0);
        ArrayList<String> arrayList = this.b;
        if (arrayList != null) {
            eVar.s(arrayList, 1);
        }
    }
}
