package e.c.a.g.a.l;

import android.util.Log;
import androidx.annotation.NonNull;
import com.kugou.android.watch.lite.common.music.entity.KGSong;
import com.kugou.common.network.retrystatics.RetryStaticsLOG;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.l0;
import e.c.a.g.a.s.q;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes2.dex */
public class c extends a<ArrayList<KGSong>> {
    public static final String k;
    public static final String l;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f1100h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Object f1101i;
    public long j;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(e.c.c.o.f.a().getCacheDir());
        String str = File.separator;
        sb.append(str);
        sb.append("new_song_publish");
        k = sb.toString();
        l = e.c.c.o.f.a().getFilesDir() + str + "new_song_publish";
    }

    public c(long j, int i2) {
        super(q(j, i2), 50000000L, 1000);
        this.f1101i = new Object();
        this.j = 0L;
        this.j = j;
        this.f1095f = true;
    }

    public static File q(long j, int i2) {
        return new File(new File(l, String.valueOf(j)), String.valueOf(i2));
    }

    public static String r(CharSequence charSequence, Object[] objArr) {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Object obj : objArr) {
            if (z) {
                z = false;
            } else {
                sb.append(charSequence);
            }
            sb.append(obj);
        }
        return sb.toString();
    }

    @Override // e.c.a.g.a.l.a
    public String c(int i2) {
        t();
        return super.c(i2);
    }

    @Override // e.c.a.g.a.l.a
    public void k(String str) throws Throwable {
        t();
        super.k(str);
    }

    @Override // e.c.a.g.a.l.a
    public boolean n(String str, String str2) {
        if (str == null || str2 == null) {
            return str == str2;
        }
        if (str.equals(str2)) {
            return true;
        }
        String str3 = String.format("(?:%s)", r(RetryStaticsLOG.MARK_SEPERATE, new String[]{"\"updateFeeStatusTime\":\\d+", "\"requestTime\":\\d+"}));
        return str.replaceAll(str3, "").equals(str2.replaceAll(str3, ""));
    }

    @Override // e.c.a.g.a.l.a
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public String b(ArrayList<KGSong> arrayList) {
        if (l0.g(arrayList)) {
            return null;
        }
        return v(arrayList);
    }

    public final ArrayList<KGSong> s(String str) {
        ArrayList<KGSong> arrayList = new ArrayList<>();
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                KGSong kGSongD1 = KGSong.d1(jSONArray.optJSONObject(i2));
                if (kGSongD1 != null) {
                    arrayList.add(kGSongD1);
                }
            }
        } catch (JSONException e2) {
            g0.k(e2);
        }
        return arrayList;
    }

    public final void t() {
        boolean z;
        if (this.f1100h) {
            return;
        }
        synchronized (this.f1101i) {
            File file = new File(k);
            if (this.f1100h || !file.exists()) {
                this.f1100h = true;
                if (g0.a && !file.exists()) {
                    g0.b("lzm-ns-cache", "no old cache");
                }
                return;
            }
            try {
                q.d(file, new File(l));
                z = true;
            } catch (Exception e2) {
                z = false;
                if (g0.a) {
                    g0.b("lzm-ns-cache", "moveCacheDir fail: " + Log.getStackTraceString(e2));
                }
                e2.printStackTrace();
            }
            if (z) {
                boolean zJ = q.j(k, null);
                if (g0.a) {
                    g0.b("lzm-ns-cache", "moveCacheDir delete old: " + zJ);
                }
            }
            this.f1100h = true;
        }
    }

    public ArrayList<KGSong> u() {
        t();
        return (ArrayList) super.g();
    }

    public final String v(ArrayList<KGSong> arrayList) {
        if (arrayList == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<KGSong> it = arrayList.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().R4());
        }
        try {
            return jSONArray.toString();
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    @Override // e.c.a.g.a.l.a
    @NonNull
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public ArrayList<KGSong> o(@NonNull String str) {
        return s(str);
    }

    public boolean x(long j) {
        return this.j != j;
    }
}
