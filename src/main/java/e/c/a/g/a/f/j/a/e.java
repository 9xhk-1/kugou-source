package e.c.a.g.a.f.j.a;

import android.text.TextUtils;
import f.z.d.j;

/* JADX INFO: loaded from: classes.dex */
public final class e {
    public String a;
    public String b;

    public final String a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public final void c(String str) {
        j.e(str, "mDisplayName");
        if (TextUtils.isEmpty(str)) {
            this.a = "";
            return;
        }
        int length = str.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            boolean z2 = j.g(str.charAt(!z ? i2 : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                } else {
                    length--;
                }
            } else if (z2) {
                i2++;
            } else {
                z = true;
            }
        }
        this.a = str.subSequence(i2, length + 1).toString();
    }

    public final void d(String str) {
        this.b = str;
    }
}
