package e.c.a.g.a.f.i;

import android.graphics.Bitmap;
import android.graphics.Matrix;

/* JADX INFO: loaded from: classes.dex */
public class j {
    public Bitmap a;
    public int b = 0;

    public j(Bitmap bitmap) {
        this.a = bitmap;
    }

    public Bitmap a() {
        return this.a;
    }

    public int b() {
        return f() ? this.a.getWidth() : this.a.getHeight();
    }

    public Matrix c() {
        Matrix matrix = new Matrix();
        if (this.b != 0) {
            matrix.preTranslate(-(this.a.getWidth() / 2), -(this.a.getHeight() / 2));
            matrix.postRotate(this.b);
            matrix.postTranslate(e() / 2, b() / 2);
        }
        return matrix;
    }

    public int d() {
        return this.b;
    }

    public int e() {
        return f() ? this.a.getHeight() : this.a.getWidth();
    }

    public boolean f() {
        return (this.b / 90) % 2 != 0;
    }

    public void g(Bitmap bitmap) {
        this.a = bitmap;
    }

    public void h(int i2) {
        this.b = i2;
    }
}
