package e.c.a.g.a.n.b;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    public int a;
    public long b;
    public String c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f1122d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f1123e;

    public String a() {
        return this.f1123e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        String str = this.c;
        if (str == null ? dVar.c != null : !str.equals(dVar.c)) {
            return false;
        }
        String str2 = this.f1123e;
        String str3 = dVar.f1123e;
        return str2 != null ? str2.equals(str3) : str3 == null;
    }

    public int hashCode() {
        String str = this.c;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f1123e;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "WXCode{qrCodeType=" + this.a + ", expireTime=" + this.b + ", codeUrl='" + this.c + "', shortUrl='" + this.f1122d + "', qrcode='" + this.f1123e + "'}";
    }
}
