package e.c.a.g.a.s;

import android.support.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class k0<T> {
    public T a;
    public boolean b;

    public abstract T a();

    @Nullable
    public T b() {
        if (!this.b) {
            this.b = true;
            this.a = a();
        }
        return this.a;
    }
}
