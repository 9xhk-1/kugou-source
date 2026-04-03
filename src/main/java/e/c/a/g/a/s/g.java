package e.c.a.g.a.s;

import android.graphics.Color;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    public static int a(int i2, float f2) {
        return Color.argb(((int) (f2 * 255.0f)) % 256, Color.red(i2), Color.green(i2), Color.blue(i2));
    }

    public static int b(String str, int i2) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Color.parseColor(str);
            } catch (Exception unused) {
            }
        }
        return i2;
    }
}
