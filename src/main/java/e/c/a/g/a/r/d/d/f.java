package e.c.a.g.a.r.d.d;

import android.text.TextUtils;
import com.kugou.common.filemanager.downloadengine.utils.FileUtil;
import e.c.a.g.a.r.d.d.a;
import e.c.a.g.a.r.d.d.c;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    public static class a {
        public boolean a;
        public String b;

        public String a() {
            return this.b;
        }

        public boolean b() {
            return this.a;
        }

        public void c(String str) {
            this.b = str;
        }

        public void d(String str) {
        }

        public void e(e.c.a.g.a.d.b.a aVar) {
        }

        public void f(boolean z) {
            this.a = z;
        }
    }

    public static class b {
        public boolean a;
        public String b;
        public int c;

        public b(boolean z, String str, int i2) {
            this.a = z;
            this.b = str;
            this.c = i2;
        }
    }

    public String a(String str) {
        return TextUtils.isEmpty(str) ? str : "http://c1.kgimg.com/v2/kugouicon/".concat(str);
    }

    public b b() {
        return c("");
    }

    public b c(String str) {
        return d(str, false);
    }

    public b d(String str, boolean z) {
        return f(e(str), z);
    }

    public a e(String str) {
        if (TextUtils.isEmpty(str)) {
            str = e.c.a.g.a.r.g.e.f();
        }
        a.C0178a c0178aC = e.c.a.g.a.r.d.d.a.c("kugouicon", "", "POST");
        if (c0178aC == null || TextUtils.isEmpty(c0178aC.b)) {
            return null;
        }
        return new e(c0178aC.b).g(str);
    }

    public b f(a aVar, boolean z) throws Throwable {
        if (aVar == null || !aVar.b() || TextUtils.isEmpty(aVar.a())) {
            return new b(false, "", 6123);
        }
        c cVar = new c();
        String strA = a(aVar.a());
        c.b bVarH = cVar.h(aVar.a());
        if (!bVarH.a()) {
            return new b(false, e.c.a.g.a.r.a.e(bVarH.b, bVarH.c), bVarH.b);
        }
        FileUtil.moveFile(e.c.a.g.a.r.g.e.f(), e.c.a.g.a.r.b.p(strA));
        e.c.a.g.a.r.b.c0(strA);
        return new b(true, null, bVarH.b);
    }
}
