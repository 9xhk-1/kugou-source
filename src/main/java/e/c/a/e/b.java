package e.c.a.e;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    public abstract String getSPKey();

    public abstract String getSource();

    public abstract void handleConfig(String str, String str2);

    public final String readFromLocal() {
        return e.c.a.g.a.f.m.c.a.d(getSPKey(), "");
    }

    public final void save2Local(String str) {
        e.c.a.g.a.f.m.c cVar = e.c.a.g.a.f.m.c.a;
        String sPKey = getSPKey();
        if (str == null) {
            str = "";
        }
        cVar.i(sPKey, str);
    }
}
