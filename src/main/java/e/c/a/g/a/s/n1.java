package e.c.a.g.a.s;

/* JADX INFO: loaded from: classes2.dex */
public class n1 {
    public static n1 c;
    public long a;
    public long b;

    public static n1 a() {
        if (c == null) {
            c = new n1();
        }
        return c;
    }

    public void b(String str) {
        if (g0.a) {
            g0.c("timeLogUtils", "record --" + str + "-- time :" + (System.currentTimeMillis() - this.b));
        }
        this.b = System.currentTimeMillis();
    }

    public void c(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.a = jCurrentTimeMillis;
        this.b = jCurrentTimeMillis;
        if (g0.a) {
            g0.c("timeLogUtils", "****************************开始分割线*******************************");
            g0.c("timeLogUtils", "start--" + str);
        }
    }
}
