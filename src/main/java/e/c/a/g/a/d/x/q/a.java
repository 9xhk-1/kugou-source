package e.c.a.g.a.d.x.q;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public String a;
    public boolean b;
    public String c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f578d = 0;

    static {
        a("play", false, "", 0L, 0L);
    }

    public static a a(String str, boolean z, String str2, long j, long j2) {
        a aVar = new a();
        aVar.a = str;
        aVar.b = z;
        aVar.c = str2;
        aVar.f578d = j;
        return aVar;
    }

    public String toString() {
        return "FeeOption{behavior='" + this.a + "', isCharge=" + this.b + ", mixId=" + this.f578d + '}';
    }
}
