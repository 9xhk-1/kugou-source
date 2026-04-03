package e.c.a.g.a.f.j.c;

import android.text.TextUtils;
import e.c.a.g.a.s.g0;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static final Set<String> a = new HashSet();

    public static String[] a(String str) {
        return b(str, "");
    }

    public static String[] b(String str, String str2) {
        boolean zC;
        int iLastIndexOf;
        String[] strArr = new String[2];
        if (TextUtils.isEmpty(str)) {
            strArr[0] = "未知歌手";
            strArr[1] = "";
            return strArr;
        }
        int iIndexOf = str.indexOf(" - ");
        if (iIndexOf > 0) {
            zC = c(strArr, str.substring(0, iIndexOf), str.substring(iIndexOf + 3));
        } else {
            int iIndexOf2 = str.indexOf("-");
            zC = iIndexOf2 > 0 ? c(strArr, str.substring(0, iIndexOf2), str.substring(iIndexOf2 + 1)) : false;
        }
        if (!zC && (iLastIndexOf = str.lastIndexOf("_")) > 0) {
            zC = c(strArr, str.substring(0, iLastIndexOf), str.substring(iLastIndexOf + 1));
        }
        if (!zC) {
            int iIndexOf3 = str.indexOf(" - ");
            if (iIndexOf3 > 0) {
                strArr[0] = str.substring(0, iIndexOf3);
                strArr[1] = str.substring(iIndexOf3 + 3);
            } else {
                int iIndexOf4 = str.indexOf("-");
                if (iIndexOf4 > 0) {
                    strArr[0] = str.substring(0, iIndexOf4);
                    strArr[1] = str.substring(iIndexOf4 + 1);
                } else {
                    int iLastIndexOf2 = str.lastIndexOf("_");
                    if (iLastIndexOf2 > 0) {
                        strArr[1] = str.substring(0, iLastIndexOf2);
                        strArr[0] = str.substring(iLastIndexOf2 + 1);
                    } else {
                        strArr[0] = "未知歌手";
                        strArr[1] = str;
                    }
                }
            }
        }
        return strArr;
    }

    public static boolean c(String[] strArr, String str, String str2) {
        String[] strArrSplit;
        try {
        } catch (ArrayIndexOutOfBoundsException e2) {
            g0.k(e2);
        }
        if (a.contains(str.toLowerCase())) {
            strArr[0] = str;
            strArr[1] = str2;
            return true;
        }
        if (str.indexOf("、") > 0 && (strArrSplit = str.split("、")) != null && strArrSplit.length > 1) {
            for (String str3 : strArrSplit) {
                if (!TextUtils.isEmpty(str3)) {
                    strArr[0] = str;
                    strArr[1] = str2;
                    return true;
                }
            }
        }
        if (a.contains(str2.toLowerCase())) {
            strArr[0] = str2;
            strArr[1] = str;
            return true;
        }
        return false;
    }
}
