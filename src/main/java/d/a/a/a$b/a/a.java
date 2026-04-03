package d.a.a.a$b.a;

import f.z.d.j;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public final String a;
    public final int b;
    public final Map<String, String> c;

    public a(String str, int i2, Map<String, String> map) {
        j.e(str, "widgetCode");
        this.a = str;
        this.b = i2;
        this.c = map;
    }

    public final Map<String, String> a() {
        return this.c;
    }

    public final String b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return j.a(this.a, aVar.a) && this.b == aVar.b && j.a(this.c, aVar.c);
    }

    public int hashCode() {
        int iHashCode = (this.b + (this.a.hashCode() * 31)) * 31;
        Map<String, String> map = this.c;
        return iHashCode + (map == null ? 0 : map.hashCode());
    }

    public String toString() {
        return "CardAction(widgetCode=" + this.a + ", action=" + this.b + ", params=" + this.c + ')';
    }
}
