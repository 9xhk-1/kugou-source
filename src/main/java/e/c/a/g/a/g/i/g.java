package e.c.a.g.a.g.i;

import com.kugou.common.config.ConfigKey;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    public static Boolean a = Boolean.TRUE;

    public static ConfigKey[] a() {
        synchronized (a) {
            if (a.booleanValue()) {
                return new ConfigKey[]{e.c.a.g.a.f.e.b.b1, e.c.a.g.a.f.e.b.c1};
            }
            return new ConfigKey[]{e.c.a.g.a.f.e.b.c1, e.c.a.g.a.f.e.b.b1};
        }
    }

    public static void b(ConfigKey configKey) {
        synchronized (a) {
            if (a.booleanValue() && configKey == e.c.a.g.a.f.e.b.b1) {
                a = Boolean.FALSE;
            } else if (!a.booleanValue() && configKey == e.c.a.g.a.f.e.b.c1) {
                a = Boolean.TRUE;
            }
        }
    }
}
