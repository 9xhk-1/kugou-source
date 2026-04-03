package e.c.a.g.a.s;

import android.view.View;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class d1 {
    public static ArrayList<View> a() {
        try {
            return new ArrayList<>((ArrayList) a1.c(a1.e(a1.d("android.view.WindowManagerGlobal"), "getInstance", null), "mViews"));
        } catch (Exception e2) {
            g0.k(e2);
            return null;
        }
    }
}
