package e.c.a.g.a.d.v;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class f {

    public static class a {
        public StringBuilder a = new StringBuilder();

        public a a(String str) {
            StringBuilder sb;
            if (!TextUtils.isEmpty(str) && (sb = this.a) != null) {
                if (sb.length() <= 0) {
                    this.a.append(str);
                } else {
                    StringBuilder sb2 = this.a;
                    sb2.append("/");
                    sb2.append(str);
                }
            }
            return this;
        }

        public String b() {
            StringBuilder sb = this.a;
            if (sb == null) {
                return "/";
            }
            String string = sb.toString();
            if (string.indexOf("/") == 0) {
                return string;
            }
            return "/" + string;
        }

        public String toString() {
            StringBuilder sb = this.a;
            return sb != null ? sb.toString() : "";
        }
    }

    public static a a() {
        return new a();
    }
}
