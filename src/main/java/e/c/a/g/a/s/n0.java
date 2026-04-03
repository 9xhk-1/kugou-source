package e.c.a.g.a.s;

import android.text.TextUtils;
import e.c.a.g.a.g.i.b;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class n0 {
    public static boolean a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        String[] strArrSplit = str2.toLowerCase().split("、");
        HashSet hashSet = new HashSet();
        if (strArrSplit != null && strArrSplit.length > 0) {
            for (String str3 : strArrSplit) {
                hashSet.add(str3);
            }
        }
        String[] strArrSplit2 = lowerCase.split("、");
        if (strArrSplit2 == null || strArrSplit2.length <= 0) {
            return false;
        }
        for (String str4 : strArrSplit2) {
            if (hashSet.contains(str4)) {
                return true;
            }
        }
        return false;
    }

    public static boolean b(String str, String str2) {
        boolean z;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        String[] strArrSplit = str2.toLowerCase().split("、");
        HashSet hashSet = new HashSet();
        if (strArrSplit == null || strArrSplit.length <= 0) {
            z = false;
        } else {
            for (String str3 : strArrSplit) {
                hashSet.add(str3);
            }
            z = true;
        }
        String[] strArrSplit2 = lowerCase.split("、");
        if (strArrSplit2 == null || strArrSplit2.length <= 0) {
            return false;
        }
        for (String str4 : strArrSplit2) {
            if (!hashSet.contains(str4)) {
                return false;
            }
        }
        return z;
    }

    public static String c(List<b.c> list) {
        if (list == null || list.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            b.c cVar = list.get(i2);
            if (cVar != null && !TextUtils.isEmpty(cVar.b())) {
                sb.append(cVar.b());
                if (i2 != size - 1) {
                    sb.append(",");
                }
            }
        }
        return sb.toString();
    }
}
