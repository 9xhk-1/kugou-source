package e.c.a.g.a.f.i;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.util.LruCache;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public abstract class b implements f {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Pattern f661h = Pattern.compile("(.*)/\\d+");
    public final LruCache<Integer, a> a;
    public ContentResolver b;
    public int c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Uri f662d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Cursor f663e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f664f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f665g;

    public b(ContentResolver contentResolver, Uri uri, int i2, String str) {
        LruCache<Integer, a> lruCache = new LruCache<>(512L);
        this.a = lruCache;
        this.f665g = false;
        this.c = i2;
        this.f662d = uri;
        this.f664f = str;
        this.b = contentResolver;
        Cursor cursorB = b();
        this.f663e = cursorB;
        if (cursorB == null) {
            Log.w("BaseImageList", "createCursor returns null.");
        }
        lruCache.clearMemory();
    }

    public static boolean c(String str, String str2) {
        return str == str2 || str.equals(str2);
    }

    public static String f(Uri uri) {
        String path = uri.getPath();
        Matcher matcher = f661h.matcher(path);
        return matcher.matches() ? matcher.group(1) : path;
    }

    public Uri a(long j) {
        try {
            if (ContentUris.parseId(this.f662d) != j) {
                Log.e("BaseImageList", "id mismatch");
            }
            return this.f662d;
        } catch (NumberFormatException unused) {
            return ContentUris.withAppendedId(this.f662d, j);
        }
    }

    public abstract Cursor b();

    @Override // e.c.a.g.a.f.i.f
    public void close() {
        try {
            h();
        } catch (IllegalStateException e2) {
            Log.e("BaseImageList", "Caught exception while deactivating cursor.", e2);
        }
        this.b = null;
        Cursor cursor = this.f663e;
        if (cursor != null) {
            cursor.close();
            this.f663e = null;
        }
    }

    public final Cursor d() {
        synchronized (this) {
            Cursor cursor = this.f663e;
            if (cursor == null) {
                return null;
            }
            if (this.f665g) {
                cursor.requery();
                this.f665g = false;
            }
            return this.f663e;
        }
    }

    public abstract long e(Cursor cursor);

    public void g() {
        this.a.clearMemory();
    }

    @Override // e.c.a.g.a.f.i.f
    public int getCount() {
        int count;
        Cursor cursorD = d();
        if (cursorD == null) {
            return 0;
        }
        synchronized (this) {
            count = cursorD.getCount();
        }
        return count;
    }

    @Override // e.c.a.g.a.f.i.f
    public e getImageAt(int i2) {
        a aVarJ = this.a.get(Integer.valueOf(i2));
        if (aVarJ == null) {
            Cursor cursorD = d();
            if (cursorD == null) {
                return null;
            }
            synchronized (this) {
                aVarJ = cursorD.moveToPosition(i2) ? j(cursorD) : null;
                this.a.put(Integer.valueOf(i2), aVarJ);
            }
        }
        return aVarJ;
    }

    @Override // e.c.a.g.a.f.i.f
    public e getImageForUri(Uri uri) {
        if (!i(uri)) {
            return null;
        }
        try {
            long id = ContentUris.parseId(uri);
            Cursor cursorD = d();
            if (cursorD == null) {
                return null;
            }
            synchronized (this) {
                cursorD.moveToPosition(-1);
                int i2 = 0;
                while (cursorD.moveToNext()) {
                    if (e(cursorD) == id) {
                        a aVarJ = this.a.get(Integer.valueOf(i2));
                        if (aVarJ == null) {
                            aVarJ = j(cursorD);
                            this.a.put(Integer.valueOf(i2), aVarJ);
                        }
                        return aVarJ;
                    }
                    i2++;
                }
                return null;
            }
        } catch (NumberFormatException e2) {
            Log.i("BaseImageList", "fail to get id in: " + uri, e2);
            return null;
        }
    }

    @Override // e.c.a.g.a.f.i.f
    public int getImageIndex(e eVar) {
        return ((a) eVar).f656e;
    }

    public void h() {
        Cursor cursor = this.f663e;
        if (cursor == null) {
            return;
        }
        cursor.deactivate();
        this.f665g = true;
    }

    public final boolean i(Uri uri) {
        Uri uri2 = this.f662d;
        return c(uri2.getScheme(), uri.getScheme()) && c(uri2.getHost(), uri.getHost()) && c(uri2.getAuthority(), uri.getAuthority()) && c(uri2.getPath(), f(uri));
    }

    @Override // e.c.a.g.a.f.i.f
    public boolean isEmpty() {
        return getCount() == 0;
    }

    public abstract a j(Cursor cursor);

    public String k() {
        String str = this.c == 1 ? " ASC" : " DESC";
        return "case ifnull(datetaken,0) when 0 then date_modified*1000 else datetaken end" + str + ", _id" + str;
    }

    @Override // e.c.a.g.a.f.i.f
    public boolean removeImage(e eVar) {
        if (eVar == null || this.b.delete(eVar.fullSizeImageUri(), null, null) <= 0) {
            return false;
        }
        ((a) eVar).a();
        h();
        g();
        return true;
    }

    @Override // e.c.a.g.a.f.i.f
    public boolean removeImageAt(int i2) {
        return removeImage(getImageAt(i2));
    }
}
