package g.a;

import g.a.m1;

/* JADX INFO: loaded from: classes2.dex */
public abstract class s1<J extends m1> extends x implements t0, h1 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final J f1650f;

    public s1(J j) {
        f.z.d.j.f(j, "job");
        this.f1650f = j;
    }

    @Override // g.a.t0
    public void dispose() {
        J j = this.f1650f;
        if (j == null) {
            throw new f.p("null cannot be cast to non-null type kotlinx.coroutines.JobSupport");
        }
        ((t1) j).O(this);
    }

    @Override // g.a.h1
    public v1 getList() {
        return null;
    }

    @Override // g.a.h1
    public boolean isActive() {
        return true;
    }
}
