package f.e0;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements Serializable {
    public final Pattern a;

    public e(Pattern pattern) {
        f.z.d.j.e(pattern, "nativePattern");
        this.a = pattern;
    }

    public final boolean a(CharSequence charSequence) {
        f.z.d.j.e(charSequence, "input");
        return this.a.matcher(charSequence).matches();
    }

    public final List<String> b(CharSequence charSequence, int i2) {
        f.z.d.j.e(charSequence, "input");
        int iEnd = 0;
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Limit must be non-negative, but was " + i2 + '.').toString());
        }
        Matcher matcher = this.a.matcher(charSequence);
        if (!matcher.find() || i2 == 1) {
            return f.u.l.b(charSequence.toString());
        }
        ArrayList arrayList = new ArrayList(i2 > 0 ? f.b0.f.e(i2, 10) : 10);
        int i3 = i2 - 1;
        do {
            arrayList.add(charSequence.subSequence(iEnd, matcher.start()).toString());
            iEnd = matcher.end();
            if (i3 >= 0 && arrayList.size() == i3) {
                break;
            }
        } while (matcher.find());
        arrayList.add(charSequence.subSequence(iEnd, charSequence.length()).toString());
        return arrayList;
    }

    public String toString() {
        String string = this.a.toString();
        f.z.d.j.d(string, "nativePattern.toString()");
        return string;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public e(String str) {
        f.z.d.j.e(str, "pattern");
        Pattern patternCompile = Pattern.compile(str);
        f.z.d.j.d(patternCompile, "Pattern.compile(pattern)");
        this(patternCompile);
    }
}
