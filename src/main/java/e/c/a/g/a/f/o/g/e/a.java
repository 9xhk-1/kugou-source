package e.c.a.g.a.f.o.g.e;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Object f726h = new Object();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static a f727i;
    public static int j;
    public int a;
    public Object b;
    public int c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f728d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public d f729e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Runnable f730f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public a f731g;

    public static a c() {
        synchronized (f726h) {
            a aVar = f727i;
            if (aVar == null) {
                return new a();
            }
            f727i = aVar.f731g;
            aVar.f731g = null;
            aVar.c = 0;
            j--;
            return aVar;
        }
    }

    public static a d(d dVar, int i2, Object obj) {
        a aVarC = c();
        aVarC.f729e = dVar;
        aVarC.a = i2;
        aVarC.b = obj;
        return aVarC;
    }

    public boolean a() {
        return (this.c & 1) == 1;
    }

    public void b() {
        this.c |= 1;
    }

    public void e() {
        this.c = 1;
        this.a = 0;
        this.b = null;
        this.f728d = 0L;
        this.f729e = null;
        this.f730f = null;
        synchronized (f726h) {
            int i2 = j;
            if (i2 < 50) {
                this.f731g = f727i;
                f727i = this;
                j = i2 + 1;
            }
        }
    }

    public void f() {
        this.f729e.h(this);
    }
}
