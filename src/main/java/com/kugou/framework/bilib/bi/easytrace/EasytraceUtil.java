package com.kugou.framework.bilib.bi.easytrace;

import com.kugou.framework.bilib.LibLog;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* JADX INFO: loaded from: classes2.dex */
public class EasytraceUtil {
    private static Calendar calendar;
    private static int gmtOffset;

    static {
        Calendar calendar2 = Calendar.getInstance();
        calendar = calendar2;
        gmtOffset = calendar2.get(15) + calendar.get(16);
    }

    public static Date DTime2JTime(double d2) {
        return new Date((((long) (d2 * 8.64E7d)) - 2209161600000L) - ((long) gmtOffset));
    }

    public static double JTime2DTime(long j) {
        long j2 = j + ((long) gmtOffset);
        double d2 = (j2 / 86400000) + 25569;
        double d3 = j2 % 86400000;
        Double.isNaN(d3);
        Double.isNaN(d2);
        return d2 + (d3 / 8.64E7d);
    }

    public static String format(KeyValueList keyValueList) {
        if (keyValueList != null) {
            try {
                keyValueList.add("ivar11", 16);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        String string = keyValueList.toString();
        if (LibLog.DEBUG) {
            LibLog.d("PanBC-trace", "key value line : " + string);
        }
        return string;
    }

    public static String formatTime(long j, String str) {
        return new SimpleDateFormat(str).format(new Date(j));
    }
}
