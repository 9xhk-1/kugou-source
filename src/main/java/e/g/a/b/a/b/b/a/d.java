package e.g.a.b.a.b.b.a;

import f.z.d.j;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends a {
    public final String a;
    public final String b;
    public final byte[] c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(String str, String str2, byte[] bArr) {
        super(0L, 0L, null, 7, null);
        j.e(str, "widgetCode");
        j.e(str2, "layoutName");
        this.a = str;
        this.b = str2;
        this.c = bArr;
        super.b(System.currentTimeMillis());
    }

    public final byte[] d() {
        return this.c;
    }

    public final String e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!j.a(d.class, obj == null ? null : obj.getClass())) {
            return false;
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.xtc.cardwidget.external.card.domain.command.data.UpdateLayoutCommand");
        d dVar = (d) obj;
        if (!j.a(this.a, dVar.a) || !j.a(this.b, dVar.b)) {
            return false;
        }
        byte[] bArr = this.c;
        byte[] bArr2 = dVar.c;
        if (bArr != null) {
            if (bArr2 == null || !Arrays.equals(bArr, bArr2)) {
                return false;
            }
        } else if (bArr2 != null) {
            return false;
        }
        return true;
    }

    public final String f() {
        return this.a;
    }

    public int hashCode() {
        int iHashCode = (this.b.hashCode() + (this.a.hashCode() * 31)) * 31;
        byte[] bArr = this.c;
        return iHashCode + (bArr == null ? 0 : Arrays.hashCode(bArr));
    }

    public String toString() {
        String string;
        StringBuilder sb = new StringBuilder();
        sb.append("UpdateLayoutCommand(widgetCode=");
        sb.append(this.a);
        sb.append(", layoutName=");
        sb.append(this.b);
        sb.append(", layoutData=");
        byte[] bArr = this.c;
        if (bArr == null) {
            string = null;
        } else {
            string = Arrays.toString(bArr);
            j.d(string, "java.util.Arrays.toString(this)");
        }
        sb.append((Object) string);
        return sb.toString();
    }
}
