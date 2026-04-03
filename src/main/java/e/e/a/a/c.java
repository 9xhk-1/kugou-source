package e.e.a.a;

import android.net.Uri;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public static final Uri a = Uri.parse("content://com.qihoo360.kidwatch.binder.BinderProvider");

    public static class a {
        public static final Uri a = c.a.buildUpon().appendPath("binder_pipe").build();
    }
}
