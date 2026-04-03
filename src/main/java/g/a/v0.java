package g.a;

/* JADX INFO: loaded from: classes2.dex */
public final class v0 implements h1 {
    public final boolean a;

    public v0(boolean z) {
        this.a = z;
    }

    @Override // g.a.h1
    public v1 getList() {
        return null;
    }

    @Override // g.a.h1
    public boolean isActive() {
        return this.a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empty{");
        sb.append(isActive() ? "Active" : "New");
        sb.append('}');
        return sb.toString();
    }
}
