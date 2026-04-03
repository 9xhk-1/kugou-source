package e.d.a.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public final class g {
    @Nullable
    public static String a(@NonNull Context context) {
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo == null) {
                return null;
            }
            return applicationInfo.sourceDir;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Nullable
    public static String b(@NonNull Context context) {
        return c(context, null);
    }

    @Nullable
    public static String c(@NonNull Context context, @NonNull String str) {
        b bVarD = d(context);
        return bVarD == null ? str : bVarD.a();
    }

    @Nullable
    public static b d(@NonNull Context context) {
        String strA = a(context);
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        return c.a(new File(strA));
    }
}
