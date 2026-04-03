package d.a.a.a$b.c.b.c;

import android.os.Bundle;
import f.z.d.j;

/* JADX INFO: loaded from: classes.dex */
public final class c extends a {
    public final String a;
    public final Bundle b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(String str, Bundle bundle) {
        super(0L, 0L, 0L, null, 15);
        j.e(str, "widgetCode");
        j.e(bundle, "dslData");
        this.a = str;
        this.b = bundle;
        System.currentTimeMillis();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return j.a(this.a, cVar.a) && j.a(this.b, cVar.b);
    }

    public int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public String toString() {
        return "CardUpdateEvent(widgetCode=" + this.a + ", dslData=" + this.b + ')';
    }
}
