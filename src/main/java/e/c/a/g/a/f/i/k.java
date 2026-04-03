package e.c.a.g.a.f.i;

import android.content.ContentResolver;
import android.net.Uri;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class k implements f {
    public e a;
    public Uri b;

    public k(ContentResolver contentResolver, Uri uri) {
        this.b = uri;
        this.a = new l(this, contentResolver, uri);
    }

    @Override // e.c.a.g.a.f.i.f
    public void close() {
        this.a = null;
        this.b = null;
    }

    @Override // e.c.a.g.a.f.i.f
    public HashMap<String, String> getBucketIds() {
        throw new UnsupportedOperationException();
    }

    @Override // e.c.a.g.a.f.i.f
    public int getCount() {
        return 1;
    }

    @Override // e.c.a.g.a.f.i.f
    public e getImageAt(int i2) {
        if (i2 == 0) {
            return this.a;
        }
        return null;
    }

    @Override // e.c.a.g.a.f.i.f
    public e getImageForUri(Uri uri) {
        if (uri.equals(this.b)) {
            return this.a;
        }
        return null;
    }

    @Override // e.c.a.g.a.f.i.f
    public int getImageIndex(e eVar) {
        return eVar == this.a ? 0 : -1;
    }

    @Override // e.c.a.g.a.f.i.f
    public boolean isEmpty() {
        return false;
    }

    @Override // e.c.a.g.a.f.i.f
    public boolean removeImage(e eVar) {
        return false;
    }

    @Override // e.c.a.g.a.f.i.f
    public boolean removeImageAt(int i2) {
        return false;
    }
}
