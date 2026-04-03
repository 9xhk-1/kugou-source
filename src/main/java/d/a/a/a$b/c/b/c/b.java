package d.a.a.a$b.c.b.c;

import com.kugou.common.apm.sdk.ApmDataKey;
import f.z.d.j;

/* JADX INFO: loaded from: classes.dex */
public final class b extends a {
    public final String a;
    public final String b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(String str, String str2) {
        super(0L, 0L, 0L, null, 15);
        j.e(str, "widgetCode");
        j.e(str2, ApmDataKey.STATE);
        this.a = str;
        this.b = str2;
        System.currentTimeMillis();
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
        return "CardStateEvent(widgetCode=" + this.a + ", state=" + this.b + ')';
    }
}
