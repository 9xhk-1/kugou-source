package e.f.a.a.b;

/* JADX INFO: loaded from: classes2.dex */
public class a implements Comparable<a> {
    public long a = -1;
    public long b = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f1372d = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f1373f = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f1374h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f1375i = 0;

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(a aVar) {
        if (aVar == null) {
            return 1;
        }
        long j = this.b - aVar.b;
        if (j > 0) {
            return 1;
        }
        return j < 0 ? -1 : 0;
    }
}
