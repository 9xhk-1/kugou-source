package e.c.a.g.a.f.k.k;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import e.c.a.g.a.s.g0;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class d {
    public static final Set<String> a = new a();

    public class a extends HashSet<String> {
        public a() {
            add("nbcollect.kugou.com");
            add("log.web.kugou.com");
            add("kgmobilestat.kugou.com");
            add("rt-m.kugou.com");
            add("d.kugou.com");
            add("log.stat.kugou.com");
            add("mobilelog.kugou.com");
            add("exceptionlog.kugou.com");
            add("emcollect.kugou.com");
        }
    }

    public static String a(String str) {
        try {
            return new URI(str).getHost();
        } catch (URISyntaxException e2) {
            g0.k(e2);
            return null;
        }
    }

    public static boolean b(@NonNull String str) {
        if ("KNOWN".equals(str)) {
            if (!g0.a) {
                return true;
            }
            g0.e("InterfaceMonitor", "异常接口：KNOWN");
            return true;
        }
        if (c(str)) {
            if (!g0.a) {
                return true;
            }
            g0.e("InterfaceMonitor", "图片请求不发送接口到接口监控, url: " + str);
            return true;
        }
        if (!d(a(str))) {
            return false;
        }
        if (!g0.a) {
            return true;
        }
        g0.e("InterfaceMonitor", "APM，无埋点，统计类域名不是网络监控关注的接口，不上发, url: " + str);
        return true;
    }

    public static boolean c(@NonNull String str) {
        String lowerCase = str.substring(Math.max(0, str.length() - 4)).toLowerCase();
        return lowerCase.endsWith("jpg") || lowerCase.endsWith("png") || lowerCase.endsWith("jpeg");
    }

    public static boolean d(@Nullable String str) {
        return a.contains(str);
    }

    public static boolean e(String str) {
        return d(a(str));
    }
}
