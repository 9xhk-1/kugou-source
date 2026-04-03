package e.f.a.b.a.f;

import f.z.d.j;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public final String a;
    public final String b;
    public final String c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f1464d;

    public a(String str, String str2, String str3, String str4) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.f1464d = str4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return j.a(this.a, aVar.a) && j.a(this.b, aVar.b) && j.a(this.c, aVar.c) && j.a(this.f1464d, aVar.f1464d);
    }

    public int hashCode() {
        String str = this.a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.c;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f1464d;
        return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "CrashDesc(exceptionUuid=" + this.a + ", exceptionType=" + this.b + ", exceptionMsg=" + this.c + ", exceptionStack=" + this.f1464d + ")";
    }
}
