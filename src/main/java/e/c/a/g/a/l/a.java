package e.c.a.g.a.l;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.ActivityChooserView;
import e.c.a.g.a.s.g0;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a<T> {
    public e.c.a.g.a.s.a a;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f1095f;
    public int b = -1;
    public int c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f1093d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1094e = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f1096g = new Object();

    public a(File file, long j, int i2) {
        this.a = e.c.a.g.a.s.a.a(file, j, i2);
        if (g0.a) {
            g0.b("lzm", "CacheHelper-dir: " + file);
        }
    }

    public void a(T t) {
        String strB = b(t);
        if (TextUtils.isEmpty(strB)) {
            if (g0.a) {
                g0.c("lzm", "CacheHelper-cache str empty, delete");
                return;
            }
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (this.f1096g) {
            k(strB);
        }
        if (g0.a) {
            g0.b("lzm", "CacheHelper-cache cost: " + (System.currentTimeMillis() - jCurrentTimeMillis));
        }
    }

    public abstract String b(T t);

    public String c(int i2) throws Throwable {
        String strB = this.a.b(String.valueOf(i2));
        if (g0.a) {
            g0.b("lzm", "CacheHelper-get-" + i2 + ": " + strB);
        }
        return strB;
    }

    public final int d() throws Throwable {
        if (this.c == -1) {
            String strB = this.a.b("newest_record");
            try {
                if (TextUtils.isEmpty(strB) || strB.toLowerCase().equals("null")) {
                    this.c = 1;
                } else {
                    this.c = Integer.parseInt(strB);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                this.c = 1;
            }
            if (g0.a) {
                g0.b("lzm", "CacheHelper-NewestPage: " + this.c);
            }
        }
        return this.c;
    }

    public final int e() {
        if (this.f1093d == -1) {
            try {
                this.f1093d = Integer.parseInt(this.a.b("oldest_record"));
            } catch (Exception e2) {
                e2.printStackTrace();
                this.f1093d = 1;
            }
            if (g0.a) {
                g0.b("lzm", "CacheHelper-OldestPage: " + this.f1093d);
            }
        }
        return this.f1093d;
    }

    public final boolean f(int i2, int i3) throws Throwable {
        if (i2 == i3) {
            return true;
        }
        int iD = d();
        int iE = e();
        return iD >= iE ? i2 > i3 : ((1 > i2 || i2 > iD || 1 > i3 || i3 > iD) && (iE > i2 || iE > i3)) ? i3 > i2 : i2 > i3;
    }

    public T g() {
        synchronized (this.f1096g) {
            String strH = h();
            if (strH == null) {
                return null;
            }
            return o(strH);
        }
    }

    public final String h() throws Throwable {
        String strC;
        if (this.b == -1) {
            this.b = d();
        }
        int iE = e();
        do {
            int i2 = this.b;
            if (i2 <= 0 || !f(i2, iE)) {
                m(this.f1094e);
                return null;
            }
            strC = c(this.b);
            if (strC != null) {
                this.f1094e = this.b;
            }
            int i3 = this.b;
            if (i3 == iE) {
                this.b = -2;
            } else {
                this.b = j(i3);
            }
        } while (strC == null);
        return strC;
    }

    public int i(int i2) {
        if (i2 >= Integer.MAX_VALUE) {
            return 1;
        }
        return i2 + 1;
    }

    public int j(int i2) {
        return i2 <= 1 ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : i2 - 1;
    }

    public void k(String str) throws Throwable {
        int iD = d();
        String strC = c(iD);
        if (this.f1095f && n(strC, str)) {
            if (g0.a) {
                g0.b("lzm", "CacheHelper-put-str same, pass");
                return;
            }
            return;
        }
        if (strC != null) {
            iD = i(iD);
        }
        this.a.e(String.valueOf(iD), str);
        l(iD);
        if (g0.a) {
            g0.b("lzm", "CacheHelper-put-" + iD + ": " + str);
        }
    }

    public final void l(int i2) throws Throwable {
        if (i2 == -1) {
            return;
        }
        this.c = i2;
        this.a.e("newest_record", String.valueOf(i2));
        if (g0.a) {
            g0.b("lzm", "CacheHelper-update NewestPage: " + this.c);
        }
    }

    public final void m(int i2) throws Throwable {
        if (i2 == -1 || i2 == this.f1093d) {
            return;
        }
        this.f1093d = i2;
        this.a.e("oldest_record", String.valueOf(i2));
        if (g0.a) {
            g0.b("lzm", "CacheHelper-update OldestPage: " + this.f1093d);
        }
    }

    public abstract boolean n(String str, String str2);

    @NonNull
    public abstract T o(@NonNull String str);
}
