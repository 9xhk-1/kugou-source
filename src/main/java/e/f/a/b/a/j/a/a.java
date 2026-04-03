package e.f.a.b.a.j.a;

import defpackage.b;
import f.z.d.j;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public String a;
    public String b;
    public String c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f1477d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f1478e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f1479f;

    public a(String str, String str2, String str3, String str4, String str5, long j) {
        j.f(str, "pluginId");
        j.f(str2, "process");
        j.f(str3, "userId");
        j.f(str4, "sdkVersion");
        j.f(str5, "appVersion");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.f1477d = str4;
        this.f1478e = str5;
        this.f1479f = j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return j.a(this.a, aVar.a) && j.a(this.b, aVar.b) && j.a(this.c, aVar.c) && j.a(this.f1477d, aVar.f1477d) && j.a(this.f1478e, aVar.f1478e) && this.f1479f == aVar.f1479f;
    }

    public int hashCode() {
        String str = this.a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.c;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f1477d;
        int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f1478e;
        return ((iHashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31) + b.a(this.f1479f);
    }

    public String toString() {
        return "PluginSafeModeRecord(pluginId=" + this.a + ", process=" + this.b + ", userId=" + this.c + ", sdkVersion=" + this.f1477d + ", appVersion=" + this.f1478e + ", timeStamp=" + this.f1479f + ")";
    }
}
