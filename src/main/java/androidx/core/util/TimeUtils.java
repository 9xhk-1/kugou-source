package androidx.core.util;

import androidx.annotation.RestrictTo;
import com.kugou.framework.libcommon.netcore.BaseConnection;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class TimeUtils {

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int HUNDRED_DAY_FIELD_LEN = 19;
    private static final int SECONDS_PER_DAY = 86400;
    private static final int SECONDS_PER_HOUR = 3600;
    private static final int SECONDS_PER_MINUTE = 60;
    private static final Object sFormatSync = new Object();
    private static char[] sFormatStr = new char[24];

    private TimeUtils() {
    }

    private static int accumField(int i2, int i3, boolean z, int i4) {
        if (i2 > 99 || (z && i4 >= 3)) {
            return i3 + 3;
        }
        if (i2 > 9 || (z && i4 >= 2)) {
            return i3 + 2;
        }
        if (z || i2 > 0) {
            return i3 + 1;
        }
        return 0;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long j, StringBuilder sb) {
        synchronized (sFormatSync) {
            sb.append(sFormatStr, 0, formatDurationLocked(j, 0));
        }
    }

    private static int formatDurationLocked(long j, int i2) {
        char c;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        long j2 = j;
        if (sFormatStr.length < i2) {
            sFormatStr = new char[i2];
        }
        char[] cArr = sFormatStr;
        if (j2 == 0) {
            int i8 = i2 - 1;
            while (i8 > 0) {
                cArr[0] = ' ';
            }
            cArr[0] = '0';
            return 1;
        }
        if (j2 > 0) {
            c = '+';
        } else {
            c = '-';
            j2 = -j2;
        }
        int i9 = (int) (j2 % 1000);
        int iFloor = (int) Math.floor(j2 / 1000);
        if (iFloor > SECONDS_PER_DAY) {
            i3 = iFloor / SECONDS_PER_DAY;
            iFloor -= SECONDS_PER_DAY * i3;
        } else {
            i3 = 0;
        }
        if (iFloor > SECONDS_PER_HOUR) {
            i4 = iFloor / SECONDS_PER_HOUR;
            iFloor -= i4 * SECONDS_PER_HOUR;
        } else {
            i4 = 0;
        }
        if (iFloor > 60) {
            int i10 = iFloor / 60;
            i5 = iFloor - (i10 * 60);
            i6 = i10;
        } else {
            i5 = iFloor;
            i6 = 0;
        }
        if (i2 != 0) {
            int iAccumField = accumField(i3, 1, false, 0);
            int iAccumField2 = iAccumField + accumField(i4, 1, iAccumField > 0, 2);
            int iAccumField3 = iAccumField2 + accumField(i6, 1, iAccumField2 > 0, 2);
            int iAccumField4 = iAccumField3 + accumField(i5, 1, iAccumField3 > 0, 2);
            i7 = 0;
            for (int iAccumField5 = iAccumField4 + accumField(i9, 2, true, iAccumField4 > 0 ? 3 : 0) + 1; iAccumField5 < i2; iAccumField5++) {
                cArr[i7] = ' ';
                i7++;
            }
        } else {
            i7 = 0;
        }
        cArr[i7] = c;
        int i11 = i7 + 1;
        boolean z = i2 != 0;
        int iPrintField = printField(cArr, i3, 'd', i11, false, 0);
        int iPrintField2 = printField(cArr, i4, 'h', iPrintField, iPrintField != i11, z ? 2 : 0);
        int iPrintField3 = printField(cArr, i6, 'm', iPrintField2, iPrintField2 != i11, z ? 2 : 0);
        int iPrintField4 = printField(cArr, i5, 's', iPrintField3, iPrintField3 != i11, z ? 2 : 0);
        int iPrintField5 = printField(cArr, i9, 'm', iPrintField4, true, (!z || iPrintField4 == i11) ? 0 : 3);
        cArr[iPrintField5] = 's';
        return iPrintField5 + 1;
    }

    private static int printField(char[] cArr, int i2, char c, int i3, boolean z, int i4) {
        int i5;
        if (!z && i2 <= 0) {
            return i3;
        }
        if ((!z || i4 < 3) && i2 <= 99) {
            i5 = i3;
        } else {
            int i6 = i2 / 100;
            cArr[i3] = (char) (i6 + 48);
            i5 = i3 + 1;
            i2 -= i6 * 100;
        }
        if ((z && i4 >= 2) || i2 > 9 || i3 != i5) {
            int i7 = i2 / 10;
            cArr[i5] = (char) (i7 + 48);
            i5++;
            i2 -= i7 * 10;
        }
        cArr[i5] = (char) (i2 + 48);
        int i8 = i5 + 1;
        cArr[i8] = c;
        return i8 + 1;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long j, PrintWriter printWriter, int i2) {
        synchronized (sFormatSync) {
            printWriter.print(new String(sFormatStr, 0, formatDurationLocked(j, i2)));
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long j, PrintWriter printWriter) {
        formatDuration(j, printWriter, 0);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long j, long j2, PrintWriter printWriter) {
        if (j == 0) {
            printWriter.print(BaseConnection.HTTP_REQ_ENTITY_PREFIX);
        } else {
            formatDuration(j - j2, printWriter, 0);
        }
    }
}
