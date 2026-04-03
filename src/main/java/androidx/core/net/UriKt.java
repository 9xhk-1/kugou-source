package androidx.core.net;

import android.net.Uri;
import f.z.d.j;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public final class UriKt {
    public static final File toFile(Uri uri) {
        j.f(uri, "$this$toFile");
        if (!j.a(uri.getScheme(), "file")) {
            throw new IllegalArgumentException(("Uri lacks 'file' scheme: " + uri).toString());
        }
        String path = uri.getPath();
        if (path != null) {
            return new File(path);
        }
        throw new IllegalArgumentException(("Uri path is null: " + uri).toString());
    }

    public static final Uri toUri(String str) {
        j.f(str, "$this$toUri");
        Uri uri = Uri.parse(str);
        j.b(uri, "Uri.parse(this)");
        return uri;
    }

    public static final Uri toUri(File file) {
        j.f(file, "$this$toUri");
        Uri uriFromFile = Uri.fromFile(file);
        j.b(uriFromFile, "Uri.fromFile(this)");
        return uriFromFile;
    }
}
