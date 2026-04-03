package e.c.a.g.a.f.k.g;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends Throwable {
    public int a;

    public a(int i2) {
        this.a = i2;
    }

    public abstract String a();

    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append(a());
        if (this.a != 0) {
            sb.append("[errorCode:");
            sb.append(this.a);
            sb.append("]");
        }
        return sb.toString();
    }
}
