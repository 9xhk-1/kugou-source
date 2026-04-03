package h.a.b.o;

import h.a.b.h;
import h.a.b.m;
import java.util.Collection;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b extends h.a.b.g {
    public abstract e d(String str, m.b bVar, Executor executor, int i2, Collection<Object> collection, boolean z, boolean z2, boolean z3, boolean z4, int i3, boolean z5, int i4);

    @Override // h.a.b.c
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public h.a a(String str, m.b bVar, Executor executor) {
        return new f(str, bVar, executor, this);
    }
}
