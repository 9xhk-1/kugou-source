package e.g.a.b.a.b.b.a;

import f.z.d.j;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends a {
    public final String a;
    public final e.g.a.b.a.b.c.a b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(String str, e.g.a.b.a.b.c.a aVar) {
        super(0L, 0L, null, 7, null);
        j.e(str, "widgetCode");
        j.e(aVar, "data");
        this.a = str;
        this.b = aVar;
        super.b(System.currentTimeMillis());
    }

    public final e.g.a.b.a.b.c.a d() {
        return this.b;
    }

    public final String e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return j.a(this.a, bVar.a) && j.a(this.b, bVar.b);
    }

    public int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public String toString() {
        return "CardUpdateCommand(widgetCode=" + this.a + ", data=" + this.b + ')';
    }
}
