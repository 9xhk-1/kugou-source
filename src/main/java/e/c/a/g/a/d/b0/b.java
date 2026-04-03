package e.c.a.g.a.d.b0;

import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import e.c.a.g.a.s.b1;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile b f371d;
    public Field a = null;
    public boolean b = true;
    public boolean c = false;

    public b() {
        g();
    }

    public static b b() {
        if (f371d == null) {
            synchronized (b.class) {
                if (f371d == null) {
                    f371d = new b();
                }
            }
        }
        return f371d;
    }

    @MainThread
    public ViewPropertyAnimator a(@NonNull View view) {
        e(view);
        return view.animate();
    }

    public boolean c() {
        return d() && this.c;
    }

    public boolean d() {
        return this.b && b1.a();
    }

    public final void e(@NonNull View view) {
        try {
            if (this.a == null) {
                Field declaredField = View.class.getDeclaredField("mAnimator");
                this.a = declaredField;
                declaredField.setAccessible(true);
            }
            Field field = this.a;
            if (field == null || field.get(view) == null) {
                return;
            }
            this.a.set(view, null);
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (NoSuchFieldException e3) {
            e3.printStackTrace();
        }
    }

    public void f(boolean z) {
        this.c = z;
    }

    public void g() {
        this.b = e.c.a.g.a.f.e.c.c().getConfigAsBoolean(e.c.a.g.a.f.e.b.s);
    }
}
