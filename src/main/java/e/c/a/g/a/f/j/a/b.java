package e.c.a.g.a.f.j.a;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static boolean a(int i2) {
        if (i2 != 300) {
            if (i2 % 100 == 0 || i2 == 1 || i2 == 0) {
                return false;
            }
            int i3 = (i2 + 1000) % 100;
            if (i3 != 2 && i3 != 5) {
                return false;
            }
        }
        return true;
    }

    public static int b(int i2) {
        return !a(i2) ? i2 + 2 : i2;
    }
}
