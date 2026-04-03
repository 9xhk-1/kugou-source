package f.e0;

/* JADX INFO: loaded from: classes2.dex */
public class q extends p {
    public static final String d0(String str, int i2) {
        f.z.d.j.e(str, "$this$drop");
        if (i2 >= 0) {
            String strSubstring = str.substring(f.b0.f.e(i2, str.length()));
            f.z.d.j.d(strSubstring, "(this as java.lang.String).substring(startIndex)");
            return strSubstring;
        }
        throw new IllegalArgumentException(("Requested character count " + i2 + " is less than zero.").toString());
    }
}
