package e.c.c;

import android.os.Build;
import com.kugou.oaid.HuaWeiOaidManager;
import com.kugou.oaid.OppoOaid;
import com.kugou.oaid.VivoOaid;
import com.kugou.oaid.XiaoMiOaid;
import e.c.c.o.l;

/* JADX INFO: loaded from: classes.dex */
public class g {
    public static g a = null;
    public static boolean b = true;
    public static boolean c = false;

    /* JADX INFO: loaded from: classes2.dex */
    public class a implements Runnable {
        public final /* synthetic */ OppoOaid a;

        public a(g gVar, OppoOaid oppoOaid) {
            this.a = oppoOaid;
        }

        @Override // java.lang.Runnable
        public void run() {
            String oaid = this.a.getOaid(e.c.c.o.f.a());
            l.e(e.c.c.o.f.a()).g("OAIDSDKMODEL_OAID_KEY", oaid);
            e.c.c.o.g.a("oaid", "oaid sdk model:" + oaid);
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public class b implements HuaWeiOaidManager.OnOaidCallBack {
        public b(g gVar) {
        }

        @Override // com.kugou.oaid.HuaWeiOaidManager.OnOaidCallBack
        public void onCallBack(String str) {
            e.c.c.o.g.a("oaid", "oaid sdk model huawei:" + str);
            l.e(e.c.c.o.f.a()).g("OAIDSDKMODEL_OAID_KEY", str);
        }
    }

    public g() {
        d();
    }

    public static g b() {
        if (a == null) {
            synchronized (g.class) {
                if (a == null) {
                    a = new g();
                }
            }
        }
        return a;
    }

    public static void d() {
        if (!b || c) {
            return;
        }
        c = true;
        try {
            System.loadLibrary("oaid");
        } catch (Throwable unused) {
        }
    }

    public String a() {
        return l.e(e.c.c.o.f.a()).d("OAIDSDKMODEL_OAID_KEY", "");
    }

    public void c() {
        if (b) {
            if (29 > Build.VERSION.SDK_INT) {
                e.c.c.o.g.a("oaid-huawei", "sdk return：");
                return;
            }
            String strA = a();
            if (strA != null && strA.length() > 0) {
                e.c.c.o.g.a("oaid-huawei", "exit return：" + strA);
                return;
            }
            String lowerCase = Build.BRAND.toLowerCase();
            e.c.c.o.g.a("oaid-huawei", "brand：" + lowerCase);
            if (lowerCase.contains("xiaomi")) {
                try {
                    Class.forName("com.android.id.impl.IdProviderImpl");
                    strA = new XiaoMiOaid().getXiaoMiOaid();
                } catch (Exception e2) {
                    e.c.c.o.g.a("oaid-huawei", "e" + e2.toString());
                    e2.printStackTrace();
                }
            } else if (lowerCase.contains("oppo")) {
                OppoOaid oppoOaid = new OppoOaid();
                oppoOaid.init(e.c.c.o.f.a());
                e.c.c.k.g.a.e().g(new a(this, oppoOaid));
            } else if (!lowerCase.contains("meizu")) {
                if (lowerCase.contains("vivo")) {
                    strA = new VivoOaid().getOaid();
                } else if (lowerCase.contains("huawei") || lowerCase.contains("honor")) {
                    HuaWeiOaidManager.getOaid(new b(this));
                }
            }
            l.e(e.c.c.o.f.a()).g("OAIDSDKMODEL_OAID_KEY", strA);
            e.c.c.o.g.a("oaid", "oaid sdk model:" + strA);
        }
    }
}
