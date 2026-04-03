package f.z.d;

/* JADX INFO: loaded from: classes2.dex */
public abstract class o extends c implements f.c0.e {
    public o() {
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof o) {
            o oVar = (o) obj;
            return d().equals(oVar.d()) && getName().equals(oVar.getName()) && f().equals(oVar.f()) && j.a(c(), oVar.c());
        }
        if (obj instanceof f.c0.e) {
            return obj.equals(a());
        }
        return false;
    }

    @Override // f.z.d.c
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public f.c0.e e() {
        return (f.c0.e) super.e();
    }

    public int hashCode() {
        return (((d().hashCode() * 31) + getName().hashCode()) * 31) + f().hashCode();
    }

    @Override // f.c0.e
    public boolean isConst() {
        return e().isConst();
    }

    @Override // f.c0.e
    public boolean isLateinit() {
        return e().isLateinit();
    }

    public String toString() {
        f.c0.a aVarA = a();
        if (aVarA != this) {
            return aVarA.toString();
        }
        return "property " + getName() + " (Kotlin reflection is not available)";
    }

    public o(Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, (i2 & 1) == 1);
    }
}
