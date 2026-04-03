package e.c.a.g.a.g.p.g;

import com.kugou.common.apm.task.VipPayCodeLoadAPM;
import e.c.a.g.a.f.k.c;
import e.c.a.g.a.g.p.d.b;
import e.c.a.g.a.g.p.d.i;
import f.z.d.j;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static final a a = new a();
    public static final VipPayCodeLoadAPM b = new VipPayCodeLoadAPM();
    public static int c;

    public final void a(c<b> cVar) {
        j.e(cVar, "songResp");
        c = 6;
        b.fail(new e.c.a.b.a.a.a.a(cVar.b()), Integer.valueOf(c), cVar.d("接口异常"));
    }

    public final void b(c<i> cVar) {
        j.e(cVar, "songResp");
        c = 6;
        b.fail(new e.c.a.b.a.a.a.a(cVar.b()), Integer.valueOf(c), cVar.d("接口异常"));
    }

    public final void c(Throwable th) {
        c = 9;
        b.fail(th, (Integer) 9, "接口异常");
    }

    public final void d(int i2, String str) {
        j.e(str, "errorMsg");
        try {
            c = i2;
            VipPayCodeLoadAPM.fail$default(b, Integer.valueOf(i2), str, null, 4, null);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void e(String str) {
        j.e(str, "reportTrace");
        VipPayCodeLoadAPM vipPayCodeLoadAPM = b;
        vipPayCodeLoadAPM.netFinish();
        vipPayCodeLoadAPM.success(j.l("二维码展示: ", str));
    }

    public final void f(int i2, String str) {
        j.e(str, "productName");
        c = 0;
        b.start(i2, str);
    }
}
