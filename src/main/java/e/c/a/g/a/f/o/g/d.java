package e.c.a.g.a.f.o.g;

import androidx.annotation.IntRange;

/* JADX INFO: loaded from: classes.dex */
public class d {
    public static int a(int i2) {
        return i2 & 255;
    }

    public static int b(int i2) {
        return (i2 & 65280) >> 8;
    }

    public static int c(int i2) {
        return d(i2, 0);
    }

    public static int d(@IntRange(from = 0, to = 255) int i2, @IntRange(from = 0, to = 255) int i3) {
        return (i2 & 255) + ((i3 << 8) & 65280);
    }
}
