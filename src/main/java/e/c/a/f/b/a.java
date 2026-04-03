package e.c.a.f.b;

import android.support.annotation.IntRange;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static boolean a(@IntRange(from = -1) int i2) {
        return i2 >= 0;
    }

    public static boolean b(@IntRange(from = -1) int i2) {
        return a(i2) && (i2 & 16) > 0;
    }

    public static boolean c(@IntRange(from = -1) int i2) {
        return a(i2) && (i2 & 16) > 0;
    }
}
