package e.c.a.g.a.f.i;

import android.net.Uri;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public interface f {
    void close();

    HashMap<String, String> getBucketIds();

    int getCount();

    e getImageAt(int i2);

    e getImageForUri(Uri uri);

    int getImageIndex(e eVar);

    boolean isEmpty();

    boolean removeImage(e eVar);

    boolean removeImageAt(int i2);
}
