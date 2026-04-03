package e.c.a.g.a.d.y;

import android.animation.Animator;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static c a;

    public static class a implements Runnable {
        public final List<Animator> a = new ArrayList();

        @Override // java.lang.Runnable
        public void run() {
            Iterator<Animator> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().start();
            }
        }
    }

    /* JADX INFO: renamed from: e.c.a.g.a.d.y.b$b, reason: collision with other inner class name */
    public static class C0098b {
        public static final SparseIntArray a = new a(15);

        /* JADX INFO: renamed from: e.c.a.g.a.d.y.b$b$a */
        public class a extends SparseIntArray {
            public a(int i2) {
                super(i2);
                put(1, 0);
                put(2, 1);
                put(4, 2);
                put(8, 3);
                put(16, 4);
                put(32, 5);
                put(64, 6);
                put(128, 7);
                put(256, 8);
                put(512, 9);
                put(1024, 10);
                put(2048, 11);
            }
        }

        public static int a(int i2) {
            return a.get(i2);
        }
    }

    static {
        d(false);
    }

    @NonNull
    public static a a(@NonNull View view, @NonNull ViewPropertyAnimator viewPropertyAnimator) {
        a aVar = new a();
        if (e()) {
            try {
                return a.a(view, viewPropertyAnimator);
            } catch (Exception e2) {
                e2.printStackTrace();
                viewPropertyAnimator.start();
            }
        }
        return aVar;
    }

    @NonNull
    public static Animator b(@NonNull View view, int i2, float f2) {
        return a.b(view, c(view, i2, true), f2);
    }

    @NonNull
    public static g<Integer> c(@NonNull View view, int i2, boolean z) {
        return a.g(view, i2, z);
    }

    public static void d(boolean z) {
        c cVar = a;
        if (cVar == null || !cVar.h()) {
            e eVarB = e.b(z);
            h hVarA = h.a();
            if (eVarB == null || hVarA == null) {
                a = new c();
            } else {
                a = new d(eVarB, hVarA);
            }
        }
    }

    public static boolean e() {
        return a.h();
    }
}
