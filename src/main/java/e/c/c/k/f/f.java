package e.c.c.k.f;

import android.net.Uri;
import android.provider.BaseColumns;

/* JADX INFO: loaded from: classes2.dex */
public class f extends c implements BaseColumns {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f1255d = d.class.getName();

    public static Uri d() {
        return Uri.withAppendedPath(e(), f1255d);
    }

    public static Uri e() {
        return Uri.parse("content://" + c.a() + "/data_collect_info");
    }

    public static Uri f() {
        return Uri.withAppendedPath(c.c(), f1255d);
    }
}
