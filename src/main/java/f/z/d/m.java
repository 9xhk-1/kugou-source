package f.z.d;

import f.c0.f;

/* JADX INFO: loaded from: classes2.dex */
public abstract class m extends o implements f.c0.f {
    public m(Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, i2);
    }

    @Override // f.z.d.c
    public f.c0.a b() {
        s.c(this);
        return this;
    }

    @Override // f.c0.f
    public Object getDelegate(Object obj) {
        return ((f.c0.f) e()).getDelegate(obj);
    }

    @Override // f.c0.f, f.z.c.l
    public Object invoke(Object obj) {
        return get(obj);
    }

    @Override // f.c0.e
    public f.a getGetter() {
        return ((f.c0.f) e()).getGetter();
    }
}
