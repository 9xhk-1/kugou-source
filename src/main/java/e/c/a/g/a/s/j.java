package e.c.a.g.a.s;

import android.os.Build;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class j {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static j f1210d;
    public boolean a;
    public boolean b;
    public boolean c;

    public j() {
        this.a = false;
        this.b = false;
        this.c = true;
        try {
            this.a = d();
            boolean zE = e();
            this.b = zE;
            this.a = this.a && zE;
            String config = e.c.a.g.a.f.e.c.c().getConfig(e.c.a.g.a.f.e.b.I);
            int i2 = TextUtils.isEmpty(config) ? 0 : Integer.parseInt(config);
            if (g0.a) {
                g0.b("siganid", "从网络拿到的web开关值：" + i2);
            }
            if (i2 == 0) {
                if (g0.a) {
                    g0.b("siganid", "web开关值2：关闭");
                }
            } else if (i2 == 1 && g0.a) {
                g0.b("siganid", "web开关值：打开");
            }
            c();
            int configAsInt = e.c.a.g.a.f.e.c.c().getConfigAsInt(e.c.a.g.a.f.e.b.J, 1);
            if (g0.a) {
                g0.b("siganid", "从网络拿到的仅wifi是否发送的值：" + configAsInt);
            }
            if (configAsInt == 0) {
                if (g0.a) {
                    g0.b("siganid", "仅wifi是否发送：否");
                }
            } else if (configAsInt == 1 && g0.a) {
                g0.b("siganid", "仅wifi是否发送：是");
            }
            h();
            this.c = g();
        } catch (Exception e2) {
            g0.k(e2);
        }
    }

    public static j b() {
        if (f1210d == null) {
            f1210d = new j();
        }
        return f1210d;
    }

    public float a() {
        return Math.abs(m.i(false).hashCode()) % 100;
    }

    public String[] c() {
        try {
            String config = e.c.a.g.a.f.e.c.c().getConfig(e.c.a.g.a.f.e.b.G);
            String[] strArrSplit = config.split(",");
            if (g0.a) {
                g0.b("siganid", "initBlackUrlForWebHook:" + config);
            }
            return strArrSplit;
        } catch (Exception e2) {
            g0.k(e2);
            return null;
        }
    }

    public boolean d() {
        float configAsFloat = e.c.a.g.a.f.e.c.c().getConfigAsFloat(e.c.a.g.a.f.e.b.A);
        if (g0.a) {
            g0.b("SystemUtils", "isPicked percent= " + configAsFloat);
        }
        if (configAsFloat <= 0.0f) {
            return false;
        }
        if (configAsFloat >= 100.0f) {
            return true;
        }
        String strI = m.i(false);
        int iHashCode = strI.hashCode();
        float fAbs = Math.abs(iHashCode) % 100;
        if (g0.a) {
            g0.b("siganid", "uuid:" + strI + " hashCode: " + iHashCode + " precentInUuid :" + fAbs);
            StringBuilder sb = new StringBuilder();
            sb.append("网络分发量为:");
            sb.append(configAsFloat);
            g0.b("siganid", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("当前无埋点抽样结果：");
            sb2.append(fAbs < configAsFloat);
            sb2.append(",,灰度版本忽略这一结果");
            g0.b("siganid", sb2.toString());
        }
        return fAbs < configAsFloat;
    }

    public boolean e() {
        if (Build.VERSION.SDK_INT > 20) {
            return true;
        }
        int configAsInt = e.c.a.g.a.f.e.c.c().getConfigAsInt(e.c.a.g.a.f.e.b.F, 0);
        if (g0.a) {
            g0.b("siganid", "isPickedUpInKikat:" + configAsInt);
        }
        return configAsInt != 0;
    }

    public boolean f() {
        return this.c;
    }

    public boolean g() {
        float configAsInt = e.c.a.g.a.f.e.c.c().getConfigAsInt(e.c.a.g.a.f.e.b.D, 100);
        if (g0.a) {
            g0.b("SystemUtils", "setTrackPageidCanWrite " + configAsInt);
        }
        if (configAsInt == 0.0f || configAsInt == -1.0f) {
            return false;
        }
        if (configAsInt >= 100.0f) {
            return true;
        }
        float fA = a();
        if (g0.a) {
            StringBuilder sb = new StringBuilder();
            sb.append("setTrackPageidCanWrite ");
            sb.append(configAsInt);
            sb.append(" result:");
            sb.append(fA < configAsInt);
            g0.b("SystemUtils", sb.toString());
            g0.b("siganid", "Ipv6MsgCollectModel setTrackPageidCanWrite open success");
        }
        return fA < configAsInt;
    }

    public void h() {
        int configAsInt = e.c.a.g.a.f.e.c.c().getConfigAsInt(e.c.a.g.a.f.e.b.H, 0);
        if (g0.a) {
            g0.b("siganid", "从网络拿到的行为流水发送通道值：" + configAsInt);
        }
    }
}
