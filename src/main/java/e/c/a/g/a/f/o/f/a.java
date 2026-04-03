package e.c.a.g.a.f.o.f;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static Bitmap l;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f705d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Paint f706e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Paint f707f;
    public float j;
    public float k;
    public boolean a = true;
    public boolean b = false;
    public boolean c = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RectF f708g = new RectF();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Rect f709h = new Rect();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Rect f710i = new Rect();

    public void a(Context context, int i2, boolean z, int i3) {
        this.f705d = i2;
        this.c = z;
        this.f706e = new Paint();
        this.f707f = new Paint();
        if (l == null) {
            l = BitmapFactory.decodeResource(context.getResources(), i3);
        }
        this.f709h.set(0, 0, l.getWidth(), l.getHeight());
    }

    public void b(Canvas canvas) {
        if (this.a) {
            this.f706e.setColor(this.f705d);
            canvas.drawRoundRect(this.f708g, this.j, this.k, this.f706e);
            if (this.b) {
                return;
            }
            canvas.drawBitmap(l, this.f709h, this.f710i, this.f707f);
        }
    }

    public void c(int i2, int i3, float f2, float f3) {
        if (i2 <= 0 || i3 <= 0) {
            return;
        }
        this.j = f2;
        this.k = f3;
        this.f706e.setColor(this.f705d);
        if (this.c) {
            int i4 = i2 > i3 ? i3 : i2;
            this.f708g.set((i2 - i4) / 2.0f, (i3 - i4) / 2.0f, (i2 + i4) / 2.0f, (i4 + i3) / 2.0f);
        } else {
            this.f708g.set(0.0f, 0.0f, i2, i3);
        }
        int i5 = (int) ((i2 < i3 ? i2 : i3) * 0.42f);
        this.f710i.set((i2 - i5) / 2, (i3 - i5) / 2, (i2 + i5) / 2, (i3 + i5) / 2);
    }

    public void d(int i2) {
        this.f705d = i2;
    }

    public void e(boolean z) {
        this.a = z;
    }

    public void f(boolean z) {
        this.b = z;
    }

    public void g(int i2) {
        this.f707f.setColorFilter(new PorterDuffColorFilter(i2, PorterDuff.Mode.SRC_IN));
    }

    public void h(boolean z) {
        this.c = z;
    }
}
