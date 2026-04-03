package e.c.a.g.a.f.o;

import android.support.annotation.Nullable;
import android.view.View;
import com.kugou.android.watch.lite.base.application.KGApplication;
import e.c.a.g.a.s.f1;
import e.c.a.g.a.s.l1;

/* JADX INFO: loaded from: classes.dex */
public class e {
    public static final e[] c = {new e(2.0f, 0.55f), new e(1.5f, 0.3f)};
    public final float a;
    public final float b;

    public e(float f2, float f3) {
        this.a = f2;
        this.b = f3;
    }

    public static void a(@Nullable View view) {
        int iB;
        if (view == null || (iB = b()) <= 0) {
            return;
        }
        view.setPadding(view.getPaddingLeft(), iB, view.getPaddingRight(), iB);
    }

    public static int b() {
        if (!l1.X()) {
            return -1;
        }
        f1 f1VarY = l1.y(KGApplication.getContext());
        float f2 = (f1VarY.b * 1.0f) / f1VarY.a;
        for (e eVar : c) {
            if (f2 >= eVar.a) {
                return (int) (eVar.b * ((f1VarY.b - f1VarY.a) / 2.0f));
            }
        }
        return -1;
    }
}
