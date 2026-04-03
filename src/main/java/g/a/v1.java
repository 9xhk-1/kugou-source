package g.a;

import com.kugou.common.apm.sdk.ApmDataKey;

/* JADX INFO: loaded from: classes2.dex */
public final class v1 extends g.a.n2.g implements h1 {
    @Override // g.a.h1
    public v1 getList() {
        return this;
    }

    @Override // g.a.h1
    public boolean isActive() {
        return true;
    }

    public final String s(String str) {
        f.z.d.j.f(str, ApmDataKey.STATE);
        StringBuilder sb = new StringBuilder();
        sb.append("List{");
        sb.append(str);
        sb.append("}[");
        Object objH = h();
        if (objH == null) {
            throw new f.p("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        }
        boolean z = true;
        for (g.a.n2.i iVarI = (g.a.n2.i) objH; !f.z.d.j.a(iVarI, this); iVarI = iVarI.i()) {
            if (iVarI instanceof s1) {
                s1 s1Var = (s1) iVarI;
                if (z) {
                    z = false;
                } else {
                    sb.append(", ");
                }
                sb.append(s1Var);
            }
        }
        sb.append("]");
        String string = sb.toString();
        f.z.d.j.b(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    @Override // g.a.n2.i
    public String toString() {
        return k0.c() ? s("Active") : super.toString();
    }
}
