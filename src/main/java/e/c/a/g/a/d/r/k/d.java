package e.c.a.g.a.d.r.k;

import android.content.res.Resources;
import com.kugou.android.watch.lite.R;
import e.c.a.g.a.s.c1;
import e.c.c.o.f;

/* JADX INFO: loaded from: classes.dex */
public class d {

    public static class a {
        public String a;
        public boolean b;

        public a(String str, boolean z) {
            this.a = str;
            this.b = z;
        }

        public static a a(Resources resources, int i2, int i3) {
            return c1.a() ? new a(resources.getString(i2), true) : new a(resources.getString(i3), false);
        }
    }

    public static a a() {
        return a.a(f.a().getResources(), R.string.fees_dialog_message_copyright_download_forbidden_multiple, R.string.fees_dialog_message_copyright_download_forbidden_multiple2);
    }

    public static a b() {
        return a.a(f.a().getResources(), R.string.fees_dialog_message_copyright_download_forbidden, R.string.fees_dialog_message_copyright_download_forbidden2);
    }
}
