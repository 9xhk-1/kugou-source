package e.c.a.g.a.f.f;

import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.kugou.android.watch.lite.base.application.KGApplication;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.l0;
import e.c.c.o.f;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static boolean a;
    public static String b;
    public static String c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f648d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final File f649e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f650f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f651g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f652h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static String f653i;
    public static String j;
    public static String k;
    public static String l;
    public static String m;
    public static final File n;
    public static final String o;
    public static final String p;
    public static final String q;
    public static final String r;
    public static final String s;

    static {
        f();
        a = false;
        f648d = a();
        File filesDir = KGApplication.getContext().getFilesDir();
        f649e = filesDir;
        f650f = filesDir.toString();
        f651g = f648d + "/.compress/";
        f652h = f648d + "/kugou/web_img/";
        f653i = ".kgtmp";
        j = ".kgm";
        k = ".kgma";
        StringBuilder sb = new StringBuilder();
        sb.append(f648d);
        sb.append("/kuou/lyrics");
        String str = File.separator;
        sb.append(str);
        l = sb.toString();
        m = e(f648d + "/kugou/temp_lyrics") + str;
        String str2 = f648d + "/kugou_auto/.httpclient/";
        n = f.a().getExternalFilesDir(null);
        String str3 = f648d + "/kugou/";
        o = str3;
        String str4 = f648d + "/kugou/config/";
        p = f648d + "/kugou/.fp/";
        String str5 = str3 + ".feedback/.attachment/";
        q = str5;
        r = str5 + "log/";
        s = str3 + ".feedback/attachment.zip";
    }

    public static String a() {
        File externalCacheDir = f.a().getExternalCacheDir();
        return (externalCacheDir == null || !externalCacheDir.canWrite()) ? f.a().getCacheDir().getAbsolutePath() : externalCacheDir.getAbsolutePath();
    }

    @Deprecated
    public static String b() {
        return KGApplication.getContext().getExternalFilesDir(null) + "/ringtone/";
    }

    public static String c() {
        File file;
        if (Build.VERSION.SDK_INT < 21 || (file = (File) l0.d(KGApplication.getContext().getExternalMediaDirs(), 0, null)) == null) {
            return KGApplication.getContext().getExternalFilesDir(null) + "/ringtone/";
        }
        return file.getAbsolutePath() + "/ringtone/";
    }

    public static String d() {
        return new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES), "YouthRingtone").getAbsolutePath().replace("/storage/emulated/0/", "") + File.separator;
    }

    public static String e(String str) {
        File file;
        if (!a && TextUtils.isEmpty(b) && ((file = n) != null || (file = f649e) != null)) {
            if (!file.exists() || !file.isDirectory()) {
                if (file.mkdir()) {
                    b = file.getAbsolutePath();
                }
                if (TextUtils.isEmpty(b)) {
                    if (g0.a) {
                        g0.b("GlobalEnv", "GlobalEnv--getValidPath222: ");
                    }
                    return str;
                }
            }
            if (!TextUtils.isEmpty(str) && str.length() > f648d.length()) {
                str = new File(file, str.substring(f648d.length())).getAbsolutePath();
                if (g0.a) {
                    g0.b("GlobalEnv", "GlobalEnv--getValidPath333: absolutePath=" + str);
                }
            }
        }
        return str;
    }

    public static void f() {
        f648d = a();
        StringBuilder sb = new StringBuilder();
        sb.append(e(f648d + "/kugou/.images/.other"));
        String str = File.separator;
        sb.append(str);
        c = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(e(f648d + "/kugou/lyrics"));
        sb2.append(str);
        l = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(e(f648d + "/kugou/temp_lyrics"));
        sb3.append(str);
        m = sb3.toString();
    }
}
