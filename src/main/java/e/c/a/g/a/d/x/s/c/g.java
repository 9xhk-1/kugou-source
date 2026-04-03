package e.c.a.g.a.d.x.s.c;

import android.text.TextUtils;
import com.kugou.common.filemanager.downloadengine.utils.FileUtil;
import e.c.a.g.a.s.h1;
import e.c.a.g.a.s.i0;
import e.c.a.g.a.s.q;
import e.c.a.g.a.s.q0;

/* JADX INFO: loaded from: classes.dex */
public class g {
    public static String a(String str, String str2, String str3, boolean z) {
        return b(e.c.a.g.a.f.f.a.l, str, str2, str3, z);
    }

    public static String b(String str, String str2, String str3, String str4, boolean z) {
        if (z) {
            String strG = g(str, str3, ".krc");
            if (q.F(strG)) {
                return strG;
            }
        }
        String strG2 = g(str, str3, ".lrc");
        if (q.F(strG2)) {
            return strG2;
        }
        String strG3 = g(str, str3, ".txt");
        if (q.F(strG3)) {
            return strG3;
        }
        if (z) {
            String strG4 = g(str, str4, ".krc");
            if (q.F(strG4)) {
                return strG4;
            }
        }
        String strG5 = g(str, str4, ".lrc");
        if (q.F(strG5)) {
            return strG5;
        }
        String strG6 = g(str, str4, ".txt");
        if (q.F(strG6)) {
            return strG6;
        }
        if (z) {
            String strG7 = g(str, str2, ".krc");
            if (q.F(strG7)) {
                return strG7;
            }
        }
        String strG8 = g(str, str2, ".lrc");
        if (q.F(strG8)) {
            return strG8;
        }
        String strG9 = g(str, str2, ".txt");
        return q.F(strG9) ? strG9 : "";
    }

    public static String c(e.c.a.g.a.d.x.s.b.a aVar) {
        return e((e.c.a.g.a.d.x.s.b.a) aVar.clone(), false);
    }

    public static String d(e.c.a.g.a.d.x.s.b.a aVar) {
        e.c.a.g.a.d.x.s.b.a aVar2 = (e.c.a.g.a.d.x.s.b.a) aVar.clone();
        aVar2.z(aVar2.g());
        return e(aVar2, true);
    }

    public static String e(e.c.a.g.a.d.x.s.b.a aVar, boolean z) {
        String strA = h1.a(aVar.c());
        String strA2 = h1.a(aVar.m());
        String strA3 = h1.a(aVar.e());
        String strA4 = h1.a(aVar.f());
        String strA5 = h1.a(aVar.g());
        String strA6 = h1.a(aVar.l());
        boolean zIsEmpty = TextUtils.isEmpty(strA6);
        String str = strA6;
        if (zIsEmpty) {
            str = strA5;
        }
        String strA7 = a(f(h(strA, strA2), str), f(strA3, str), f(strA4, str), z);
        if (!TextUtils.isEmpty(strA7) || !strA5.equals(str)) {
            return strA7;
        }
        String strA8 = a(h(strA, strA2), strA3, strA4, z);
        if (TextUtils.isEmpty(strA8)) {
            return strA8;
        }
        String str2 = q.B(strA8) + f(q.x(strA8), str) + "." + FileUtil.getExtName(strA8);
        return FileUtil.rename(strA8, str2) ? str2 : strA8;
    }

    public static String f(String str, String str2) {
        if (q.H(str)) {
            str = q0.g(str);
        }
        return str + "-" + str2;
    }

    public static String g(String str, String str2, String str3) {
        return str + i0.b(str2) + str3;
    }

    public static String h(String str, String str2) {
        return str + "-" + str2;
    }
}
