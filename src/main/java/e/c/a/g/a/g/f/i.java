package e.c.a.g.a.g.f;

import android.text.TextUtils;
import android.util.Log;
import f.e0.n;
import f.z.d.j;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class i {
    public static final i a = new i();
    public static int b = e.c.a.g.a.f.e.c.a.a().getConfigAsInt(e.c.a.g.a.f.e.b.X1, 5);
    public static final String c = "refresh_count_limitcount";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f781d = "last_refresh_date_limitcount";

    public final void a() {
        e.c.a.g.a.f.m.c cVar = e.c.a.g.a.f.m.c.a;
        int iB = cVar.b(d(), 0) + 1;
        cVar.g(d(), iB);
        Log.e("RefreshLimiterCount", "addApiUpdateCount refreshCount: " + iB + " SettingPrefs.get(KEY_REFRESH_COUNT, 0) = " + cVar.b(d(), 0));
    }

    public final boolean b() {
        boolean z;
        String strC = c();
        e.c.a.g.a.f.m.c cVar = e.c.a.g.a.f.m.c.a;
        String str = f781d;
        String strD = cVar.d(str, "");
        int iB = cVar.b(d(), 0);
        if (TextUtils.isEmpty(strD) || !n.m(strD, strC, false, 2, null)) {
            cVar.i(str, strC);
            cVar.g(d(), 0);
            z = true;
            iB = 0;
        } else {
            z = false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("refreshCount: ");
        sb.append(iB);
        sb.append(" , currentDate: ");
        sb.append(strC);
        sb.append(", lastRefreshDate: ");
        sb.append((Object) strD);
        sb.append(" ,reset: ");
        sb.append(z);
        sb.append(", forceStopAppTime: ");
        sb.append(b);
        sb.append("， 需要刷新: ");
        sb.append(iB < b);
        Log.e("RefreshLimiterCount", sb.toString());
        return iB < b;
    }

    public final String c() {
        String str = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        j.d(str, "dateFormat.format(Date())");
        return str;
    }

    public String d() {
        return c;
    }

    public final void e() {
        e.c.a.g.a.f.m.c cVar = e.c.a.g.a.f.m.c.a;
        cVar.i(f781d, c());
        cVar.g(d(), 0);
    }
}
