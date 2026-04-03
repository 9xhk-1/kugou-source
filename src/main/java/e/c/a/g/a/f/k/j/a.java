package e.c.a.g.a.f.k.j;

import android.util.Log;
import e.c.a.g.a.s.g0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static List<a> f694d;
    public final String a;
    public final String b;
    public final String c;

    static {
        if (g0.a && e.c.a.g.a.c.a.a.c()) {
            a(new a("https://gateway.kugou.com/youth/v1/watch/get_watch_config", "http://10.17.8.15:9980/v1/watch/get_watch_config", "youth.kugou.com"));
            a(new a("https://gateway.kugou.com/youth/v1/watch/create_order", "http://10.17.8.15:9980/v1/watch/create_order", "youth.kugou.com"));
            Log.d("mhsmockurl", "MockUrl: get_watch_config - 10.16.2.146");
        }
    }

    public a(String str, String str2, String str3) {
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    public static void a(a aVar) {
        if (f694d == null) {
            f694d = new ArrayList();
        }
        f694d.add(aVar);
    }
}
