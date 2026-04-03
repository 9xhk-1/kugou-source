package e.c.a.g.a.f.k.k;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kugou.common.network.protocol.RequestPackage;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class c {
    @NonNull
    public static String a(@NonNull String str) {
        int iIndexOf = str.indexOf(63);
        return iIndexOf >= 0 ? str.substring(0, iIndexOf) : str;
    }

    @NonNull
    public static String b(RequestPackage requestPackage) {
        String[] allValuesOfConfig;
        try {
            if (requestPackage instanceof e.c.a.g.a.f.k.a) {
                allValuesOfConfig = e.c.a.g.a.f.e.c.c().getAllValuesOfConfig(((e.c.a.g.a.f.k.a) requestPackage).getUrlConfigKey());
                if (allValuesOfConfig != null) {
                    ArrayList arrayList = new ArrayList();
                    for (String str : allValuesOfConfig) {
                        if (!TextUtils.isEmpty(str) && !arrayList.contains(str)) {
                            arrayList.add(str);
                        }
                    }
                    if (arrayList.size() > 0) {
                        allValuesOfConfig = new String[arrayList.size()];
                        for (int i2 = 0; i2 < arrayList.size(); i2++) {
                            allValuesOfConfig[i2] = (String) arrayList.get(i2);
                        }
                    }
                }
            } else {
                allValuesOfConfig = new String[]{requestPackage.getUrl()};
            }
            return (allValuesOfConfig == null || allValuesOfConfig.length <= 0) ? "KNOWN" : allValuesOfConfig[0];
        } catch (Throwable th) {
            th.printStackTrace();
            return "KNOWN";
        }
    }
}
