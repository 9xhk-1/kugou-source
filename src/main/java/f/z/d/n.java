package f.z.d;

/* JADX INFO: loaded from: classes2.dex */
public class n extends m {
    public n(f.c0.d dVar, String str, String str2) {
        super(c.j, ((d) dVar).getJClass(), str, str2, !(dVar instanceof f.c0.b) ? 1 : 0);
    }

    @Override // f.c0.f
    public Object get(Object obj) {
        return getGetter().call(obj);
    }
}
