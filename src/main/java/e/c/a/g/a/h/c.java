package e.c.a.g.a.h;

import e.c.a.g.a.s.g0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c implements Runnable {
    public boolean a = false;
    public int b;

    public abstract void a();

    public abstract void b();

    public void c() {
        this.a = true;
    }

    public abstract int d();

    public abstract int e();

    public boolean f() {
        return true;
    }

    public abstract void g();

    public abstract boolean h();

    @Override // java.lang.Runnable
    public void run() {
        while (!this.a) {
            if (h()) {
                b();
                if (f()) {
                    this.b = 0;
                }
            } else {
                a();
                int i2 = this.b + 1;
                this.b = i2;
                if (i2 > d()) {
                    this.a = true;
                } else {
                    try {
                        Thread.sleep(e());
                    } catch (InterruptedException e2) {
                        g0.k(e2);
                    }
                }
            }
        }
        g();
    }
}
