package e.c.b.a;

import android.text.TextUtils;
import android.util.Log;
import com.kugou.common.utils.PrivacyUtil;
import com.xtc.payapi.contact.BaseResponse;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.m;
import f.e0.o;
import f.z.d.j;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public boolean a;
    public boolean b;
    public boolean c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f1241d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f1242e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f1243f;

    public c() {
        boolean zI;
        boolean zI2;
        boolean zI3;
        boolean zI4;
        String[] allValuesOfConfig = e.c.a.g.a.f.e.c.a.a().getAllValuesOfConfig(e.c.a.g.a.f.e.b.W1);
        boolean zHasAgreed = PrivacyUtil.hasAgreed();
        h();
        if (allValuesOfConfig != null && allValuesOfConfig.length == 4 && zHasAgreed) {
            String str = allValuesOfConfig[0];
            j.d(str, "entrySamples[0]");
            zI = i(b(str));
            String str2 = allValuesOfConfig[1];
            j.d(str2, "entrySamples[1]");
            zI2 = i(b(str2));
            String str3 = allValuesOfConfig[2];
            j.d(str3, "entrySamples[2]");
            zI3 = i(b(str3));
            String str4 = allValuesOfConfig[3];
            j.d(str4, "entrySamples[3]");
            zI4 = i(b(str4));
        } else {
            zI = false;
            zI2 = false;
            zI3 = false;
            zI4 = false;
        }
        this.a = zI;
        this.b = zI2;
        this.c = zI3;
        this.f1241d = zI4;
        boolean z = g0.a || this.f1243f;
        Log.i("FireEyeCrash", "config: hasAgreed:" + zHasAgreed + ", debugMode:" + z + ", entrySamples:" + d(allValuesOfConfig) + ", uuidLastNumStr:" + this.f1242e + ", javaCrashEnable:" + this.a + ", nativeCrashEnable:" + this.b + ", anrEnable:" + this.c + ", performanceEnable:" + this.f1241d);
        if (z) {
            this.a = true;
            this.b = true;
            this.c = true;
            this.f1241d = true;
        }
    }

    public final boolean a() {
        return (e() || f() || c() || g()) ? false : true;
    }

    public final String b(String str) {
        if (TextUtils.isEmpty(str) || j.a(BaseResponse.Code.ERROR_NETWORK, str)) {
            return "";
        }
        int length = str.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            boolean z2 = j.g(str.charAt(!z ? i2 : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i2++;
            } else {
                z = true;
            }
        }
        return str.subSequence(i2, length + 1).toString();
    }

    public final boolean c() {
        return this.c;
    }

    public final String d(String[] strArr) {
        String strL = "";
        if (strArr == null) {
            return "";
        }
        for (String str : strArr) {
            Object[] array = o.S(str, new String[]{","}, false, 0, 6, null).toArray(new String[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            for (Object obj : array) {
                strL = j.l(j.l(strL, (String) obj), "、");
            }
            strL = j.l(strL, "｜");
        }
        return strL;
    }

    public final boolean e() {
        return this.a;
    }

    public final boolean f() {
        return this.b;
    }

    public final boolean g() {
        return this.f1241d;
    }

    public final String h() {
        String strSubstring;
        if (TextUtils.isEmpty(this.f1242e)) {
            String strI = m.i(false);
            if (TextUtils.isEmpty(strI)) {
                strSubstring = "";
            } else {
                j.d(strI, "uuid");
                strSubstring = strI.substring(strI.length() - 1);
                j.d(strSubstring, "(this as java.lang.String).substring(startIndex)");
            }
            Locale locale = Locale.ROOT;
            j.d(locale, "ROOT");
            Objects.requireNonNull(strSubstring, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = strSubstring.toLowerCase(locale);
            j.d(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            this.f1242e = lowerCase;
        }
        return this.f1242e;
    }

    public final boolean i(String str) {
        Object[] array = o.S(str, new String[]{","}, false, 0, 6, null).toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        String[] strArr = (String[]) array;
        int length = strArr.length;
        int i2 = 0;
        while (i2 < length) {
            String str2 = strArr[i2];
            i2++;
            if (TextUtils.equals(str2, h())) {
                return true;
            }
        }
        return false;
    }
}
