package e.c.a.g.a.k.d;

import com.kugou.common.apm.ResponseHandlerForApm;
import com.kugou.common.apm.auto.YoungApmSessionModelImpl;
import com.kugou.common.apm.sdk.ApmDataKey;
import com.kugou.common.apm.sdk.ApmFs;
import e.c.a.g.a.f.k.g.b;
import e.c.a.g.a.f.k.k.f;
import f.z.d.j;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public final String a;
    public String b;
    public boolean c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f1092d;

    public a(String str) {
        j.e(str, "typeId");
        this.a = str;
    }

    public static /* synthetic */ void c(a aVar, Throwable th, int i2, String str, Integer num, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            num = 1;
        }
        aVar.b(th, i2, str, num);
    }

    public final void a(Integer num, String str, Integer num2) {
        String str2 = this.b;
        if (str2 == null) {
            return;
        }
        e.c.a.g.a.d.b.a aVar = new e.c.a.g.a.d.b.a();
        if ((num != null && num.intValue() == 1) || ((num != null && num.intValue() == 2) || (num != null && num.intValue() == 3))) {
            aVar.k(ResponseHandlerForApm.E5);
        } else {
            aVar.k(ResponseHandlerForApm.E3);
        }
        aVar.g(num == null ? null : num.toString());
        d().add(str2, ApmDataKey.TE, aVar.c());
        d().add(str2, ApmDataKey.POSITION, j.l("", num));
        d().add(str2, ApmDataKey.FS, j.l("", num2));
        d().add(str2, ApmDataKey.PARA, str);
        d().add(str2, ApmDataKey.STATE, "0");
        d().end(str2);
        this.b = null;
    }

    public final void b(Throwable th, int i2, String str, Integer num) {
        String str2;
        j.e(str, "rankName");
        if (this.c || (str2 = this.b) == null) {
            return;
        }
        try {
            e.c.a.g.a.d.b.a netApmDataWhenSuccess = ResponseHandlerForApm.getNetApmDataWhenSuccess(f.d(th), "");
            if (th instanceof b) {
                netApmDataWhenSuccess.k(ResponseHandlerForApm.E4);
                netApmDataWhenSuccess.g(((b) th).a > 0 ? String.valueOf(((b) th).a) : ApmFs.PARSE_EXCEPTION);
            } else if (th instanceof e.c.a.b.a.a.a.a) {
                netApmDataWhenSuccess.k(ResponseHandlerForApm.E2);
                netApmDataWhenSuccess.g(String.valueOf(((e.c.a.b.a.a.a.a) th).a));
            }
            d().add(str2, ApmDataKey.POSITION, j.l("", num));
            d().add(str2, ApmDataKey.TE, netApmDataWhenSuccess.c());
            d().add(str2, ApmDataKey.FS, netApmDataWhenSuccess.a());
            d().add(str2, ApmDataKey.STATE, "0");
            d().add(str2, ApmDataKey.STATE_1, String.valueOf(i2));
            d().add(str2, ApmDataKey.STATE_2, str);
            d().end(str2);
            f();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final YoungApmSessionModelImpl d() {
        return YoungApmSessionModelImpl.with(this.a);
    }

    public final void e() {
        String str;
        if (this.c || (str = this.b) == null) {
            return;
        }
        d().add(str, ApmDataKey.NET_DELAY);
    }

    public final void f() {
        this.b = null;
        if (this.f1092d) {
            return;
        }
        this.c = true;
    }

    public final void g() {
        if (this.c) {
            return;
        }
        this.b = d().start(this.a);
    }

    public final void h(boolean z) {
        this.f1092d = z;
        if (this.c) {
            return;
        }
        this.b = d().start(this.a);
    }

    public final void i(boolean z) {
        String str;
        if (this.c || (str = this.b) == null) {
            return;
        }
        d().add(str, ApmDataKey.STATE, "1");
        d().add(str, ApmDataKey.PARA, z ? "1" : "0");
        d().end(str);
        f();
    }

    public final void j() {
        String str;
        if (this.c || (str = this.b) == null) {
            return;
        }
        d().add(str, ApmDataKey.UI_LOAD_TIME);
    }
}
