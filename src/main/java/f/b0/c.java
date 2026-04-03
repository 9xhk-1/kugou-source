package f.b0;

import f.u.z;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends z {
    public final int a;
    public boolean b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f1510d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f1511f;

    public c(int i2, int i3, int i4) {
        this.f1511f = i4;
        this.a = i3;
        boolean z = true;
        if (i4 <= 0 ? i2 < i3 : i2 > i3) {
            z = false;
        }
        this.b = z;
        this.f1510d = z ? i2 : i3;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.b;
    }

    @Override // f.u.z
    public int nextInt() {
        int i2 = this.f1510d;
        if (i2 != this.a) {
            this.f1510d = this.f1511f + i2;
        } else {
            if (!this.b) {
                throw new NoSuchElementException();
            }
            this.b = false;
        }
        return i2;
    }
}
