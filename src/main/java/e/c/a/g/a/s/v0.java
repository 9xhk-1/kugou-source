package e.c.a.g.a.s;

/* JADX INFO: loaded from: classes2.dex */
public class v0 {
    public static String a(int i2) {
        return i2 % 10 <= 0 ? i2 % 100 <= 0 ? String.valueOf(i2 / 100) : h1.c("#.#", i2 / 100.0f) : h1.c("#.##", i2 / 100.0f);
    }

    public static long b(long j, long j2, long j3) {
        return Math.max(Math.max(j, j2), j3);
    }
}
