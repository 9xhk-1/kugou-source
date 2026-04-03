package e.c.a.g.a.s;

import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes2.dex */
public class k {
    public static int a(long j, long j2) {
        if (g0.a) {
            g0.b("DateUtil", "daysBetween smallTime=" + b(j));
        }
        if (g0.a) {
            g0.b("DateUtil", "daysBetween bigTime=" + b(j2));
        }
        if (j > j2) {
            long j3 = j + j2;
            j2 = j3 - j2;
            j = j3 - j2;
        }
        long rawOffset = j + ((long) TimeZone.getDefault().getRawOffset());
        int rawOffset2 = (int) ((j2 + ((long) TimeZone.getDefault().getRawOffset())) / 86400000);
        int i2 = (int) (rawOffset / 86400000);
        if (g0.a) {
            g0.b("KtvTimeUtil", "daysBetween d1-d2=" + (rawOffset2 - i2));
        }
        return rawOffset2 - i2;
    }

    public static String b(long j) {
        if (j <= 0) {
            return "";
        }
        return new SimpleDateFormat("MM-dd HH:mm").format(new Date(j));
    }

    public static String c(long j, String str) {
        if (j <= 0) {
            return "";
        }
        return new SimpleDateFormat(str).format(new Date(j));
    }

    public static long d(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    public static long e(String str) {
        return f(str, "yyyy-MM-dd HH:mm:ss");
    }

    public static long f(String str, String str2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2);
        try {
            if (TextUtils.isEmpty(str) || "0".equals(str)) {
                return -1L;
            }
            return simpleDateFormat.parse(str).getTime();
        } catch (Exception e2) {
            g0.i(e2);
            return -1L;
        }
    }
}
