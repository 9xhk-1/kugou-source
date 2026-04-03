package e.c.a.g.a.s;

/* JADX INFO: loaded from: classes2.dex */
public class m0 {
    public static int a() {
        return 15000;
    }

    public static int b(int i2) {
        int iA = a();
        int iMin = Math.min(Math.max(((i2 / 20) + 1) * iA, iA * 2), 180000);
        if (g0.a) {
            g0.e("zzm-loading", "songNum:" + i2 + "getMaxDurationTime:" + iMin);
        }
        return iMin;
    }
}
