package e.c.a.g.a.g.o.i;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import androidx.annotation.RawRes;
import androidx.annotation.WorkerThread;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.common.config.ConfigKey;
import e.c.a.g.a.f.e.b;
import e.c.a.g.a.f.e.c;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.h1;
import e.c.a.g.a.s.l0;
import e.c.a.g.a.s.y;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile a f1014g;
    public Set<String> a = null;
    public final Set<String> b = new HashSet(300);
    public final Set<String> c = new HashSet(200);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f1015d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f1016e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1017f = 0;

    public static a b() {
        if (f1014g == null) {
            synchronized (a.class) {
                if (f1014g == null) {
                    f1014g = new a();
                }
            }
        }
        return f1014g;
    }

    public final void a(String str) {
        if ((this.f1017f & 1) == 0 && h1.o(str, "郎", "田", "男")) {
            if (g0.a) {
                g0.b("keyword_matcher", "isHit:load by " + str + "  raw:1");
            }
            this.f1017f |= 1;
            d(R.raw.accurate_word_1);
        }
        if ((this.f1017f & 16) == 0 && h1.o(str, "夫", "村", "本", "三", "木", "藤")) {
            if (g0.a) {
                g0.b("keyword_matcher", "isHit:load by " + str + "  raw:16");
            }
            this.f1017f |= 16;
            d(R.raw.accurate_word_2);
        }
    }

    @WorkerThread
    public boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        e();
        a(str);
        if (!l0.g(this.a)) {
            Iterator<String> it = this.a.iterator();
            while (it.hasNext()) {
                if (str.contains(it.next())) {
                    return false;
                }
            }
        }
        if (!TextUtils.isEmpty(str)) {
            String lowerCase = str.trim().toLowerCase();
            if (this.b.contains(lowerCase)) {
                return true;
            }
            for (String str2 : this.c) {
                if (lowerCase.contains(str2)) {
                    return true;
                }
                if (lowerCase.matches(str2)) {
                    if (g0.a) {
                        g0.b("keyword_matcher", "isHit: keyword=" + lowerCase + "   word=" + str2);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public final void d(@RawRes int i2) {
        try {
            g(KGApplication.getContext().getResources().openRawResource(i2), this.b);
        } catch (Exception e2) {
            g0.k(e2);
        }
    }

    public void e() {
        if (!this.f1015d) {
            try {
                f(b.R1, this.b);
                g(KGApplication.getContext().getResources().openRawResource(R.raw.accurate_word), this.b);
                this.f1015d = true;
            } catch (Exception e2) {
                g0.k(e2);
            }
        }
        if (!this.f1016e) {
            try {
                f(b.Q1, this.c);
                g(KGApplication.getContext().getResources().openRawResource(R.raw.fuzzy_word), this.c);
                this.f1016e = true;
            } catch (Exception e3) {
                g0.k(e3);
            }
        }
        if (this.a == null) {
            String[] strArrS = h1.s(c.c().getConfig(b.P1));
            if (l0.h(strArrS)) {
                this.a = Collections.emptySet();
                return;
            }
            this.a = new HashSet(strArrS.length);
            for (String str : strArrS) {
                if (!TextUtils.isEmpty(str)) {
                    this.a.add(str.trim().toLowerCase());
                    if (g0.a) {
                        g0.b("keyword_matcher", "add ignore word: " + str);
                    }
                }
            }
        }
    }

    public final void f(ConfigKey configKey, @NonNull Set<String> set) {
        String[] strArrS = h1.s(c.c().getConfig(configKey));
        if (strArrS == null || strArrS.length <= 0) {
            return;
        }
        for (String str : strArrS) {
            String lowerCase = TextUtils.isEmpty(str) ? null : str.trim().toLowerCase();
            if (!TextUtils.isEmpty(lowerCase)) {
                set.add(lowerCase);
            }
        }
    }

    public final void g(InputStream inputStream, @NonNull Set<String> set) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        int i2 = 0;
        while (true) {
            try {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    String lowerCase = line.trim().toLowerCase();
                    if (lowerCase.length() > 0) {
                        set.add(lowerCase);
                    }
                    i2++;
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            } finally {
                y.a(bufferedReader);
                y.a(inputStream);
            }
        }
        if (g0.a) {
            g0.b("keyword_matcher", "count:" + i2 + " map_size:" + set.size());
        }
    }
}
