package e.c.a.g.a.d.x;

import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment;
import com.kugou.android.watch.lite.bi.YoungBITask;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.j0;
import e.c.a.g.a.s.l0;
import e.c.a.g.a.s.m1;
import e.c.a.g.a.s.r;
import e.c.e.c.a.c;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import rx.functions.Action1;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f554g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f555h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f556i;
    public static volatile g j;
    public c.InterfaceC0238c<KGMusicWrapper> b;
    public final HashMap<String, KGMusicWrapper> c = new HashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e.c.a.g.a.d.x.t.c f557d = new e.c.a.g.a.d.x.t.c();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Runnable f558e = new a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Runnable f559f = new b();
    public final Handler a = new Handler(j0.b().d());

    public class a implements Runnable {

        /* JADX INFO: renamed from: e.c.a.g.a.d.x.g$a$a, reason: collision with other inner class name */
        public class C0084a implements r<KGMusicWrapper> {
            public C0084a(a aVar) {
            }

            @Override // e.c.a.g.a.s.r
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean isFilter(KGMusicWrapper kGMusicWrapper) {
                return kGMusicWrapper.getMixId() <= 0 || TextUtils.isEmpty(kGMusicWrapper.getHashValue());
            }
        }

        public class b implements Action1<String> {
            public final /* synthetic */ List a;
            public final /* synthetic */ int b;

            public b(a aVar, List list, int i2) {
                this.a = list;
                this.b = i2;
            }

            @Override // rx.functions.Action1
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void call(String str) {
                AbsFrameworkFragment absFrameworkFragmentB = e.c.a.g.a.d.v.c.b();
                g0.b("young-hqd", "PlayerQueueCache getCurrentFragment");
                if (absFrameworkFragmentB != null) {
                    g0.b("young-hqd", "PlayerQueueCache playAll");
                    f.y(false, this.a, this.b, false, absFrameworkFragmentB.l());
                }
            }
        }

        public class c implements Action1<String> {
            public c(a aVar) {
            }

            @Override // rx.functions.Action1
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void call(String str) {
                if (e.c.a.g.a.r.b.F()) {
                    h.y().refreshPlayQueue("startapp-getCacheTask");
                }
            }
        }

        public a() {
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            BufferedReader bufferedReader;
            int length;
            List<KGMusicWrapper> listA;
            boolean z;
            FileInputStream fileInputStream = null;
            try {
                g0.b("young-hqd", "PlayerQueueCache getCacheTask");
                if (new File(g.f555h).exists()) {
                    File file = new File(g.f556i);
                    if (file.exists()) {
                        StringBuilder sb = new StringBuilder();
                        FileInputStream fileInputStream2 = new FileInputStream(file);
                        try {
                            bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream2, "UTF-8"));
                            while (true) {
                                try {
                                    try {
                                        String line = bufferedReader.readLine();
                                        if (line == null) {
                                            break;
                                        } else {
                                            sb.append(line);
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        fileInputStream = fileInputStream2;
                                        g.this.e(fileInputStream, bufferedReader);
                                        throw th;
                                    }
                                } catch (Exception e2) {
                                    e = e2;
                                    fileInputStream = fileInputStream2;
                                    try {
                                        e.printStackTrace();
                                        g.this.e(fileInputStream, bufferedReader);
                                        return;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        g.this.e(fileInputStream, bufferedReader);
                                        throw th;
                                    }
                                }
                            }
                            g.this.e(fileInputStream2, bufferedReader);
                            String string = sb.toString();
                            if (e.c.a.g.a.f.m.b.m().y()) {
                                listA = g.this.f557d.b(string);
                                if (g0.a) {
                                    g0.e("young-hqd", "PlayerQueueCache get list:" + listA.size() + "   json=" + string);
                                }
                                z = false;
                            } else {
                                try {
                                    length = new JSONArray(string).length();
                                } catch (Exception e3) {
                                    g0.b("young-hqd", "Exception:" + e3.getMessage());
                                    length = 20;
                                }
                                if (length > 100) {
                                    length = 100;
                                }
                                file.delete();
                                g.this.k(0);
                                listA = new i().a(length);
                                g0.e("young-hqd", "PlayerQueueCache get list fixed");
                                e.c.a.g.a.e.b.b(new YoungBITask(22020024, "statistics").setSource("PlayerQueueCache_FIX").setSvar2(length + ""));
                                z = true;
                            }
                            e.c.a.g.a.f.m.b.m().R(true);
                            l0.a(listA, new C0084a(this));
                            if (!l0.g(listA)) {
                                int iMin = Math.min(listA.size() - 1, g.this.g());
                                if (z) {
                                    if (g0.a) {
                                        g0.b("young-hqd", "needOpenvipstatate:" + e.c.a.g.a.r.b.O());
                                    }
                                    m1.d(500, new b(this, listA, iMin));
                                } else {
                                    f.A(false, listA, iMin, false);
                                    if (e.c.a.g.a.f.e.c.c().getConfigAsBoolean(e.c.a.g.a.f.e.b.k4, true)) {
                                        m1.d(500, new c(this));
                                    }
                                }
                            }
                            e.c.a.g.a.f.d.a.d(new Intent("com.kugou.young.watch.resumedsuccess"));
                            g.this.e(fileInputStream2, bufferedReader);
                            return;
                        } catch (Exception e4) {
                            e = e4;
                            bufferedReader = null;
                        } catch (Throwable th3) {
                            th = th3;
                            bufferedReader = null;
                        }
                    } else {
                        e.c.a.g.a.f.m.b.m().R(true);
                    }
                } else {
                    e.c.a.g.a.f.m.b.m().R(true);
                }
                g.this.e(null, null);
            } catch (Exception e5) {
                e = e5;
                bufferedReader = null;
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0 */
        /* JADX WARN: Type inference failed for: r0v1, types: [java.io.IOException] */
        /* JADX WARN: Type inference failed for: r0v11 */
        /* JADX WARN: Type inference failed for: r0v13 */
        /* JADX WARN: Type inference failed for: r0v14 */
        /* JADX WARN: Type inference failed for: r0v15 */
        /* JADX WARN: Type inference failed for: r0v16 */
        /* JADX WARN: Type inference failed for: r0v17 */
        /* JADX WARN: Type inference failed for: r0v18 */
        /* JADX WARN: Type inference failed for: r0v19 */
        /* JADX WARN: Type inference failed for: r0v2 */
        /* JADX WARN: Type inference failed for: r0v3, types: [java.io.BufferedWriter] */
        /* JADX WARN: Type inference failed for: r0v5 */
        /* JADX WARN: Type inference failed for: r0v6, types: [java.io.BufferedWriter] */
        /* JADX WARN: Type inference failed for: r0v7, types: [java.io.BufferedWriter] */
        /* JADX WARN: Type inference failed for: r0v9 */
        @Override // java.lang.Runnable
        public void run() throws Throwable {
            FileOutputStream fileOutputStream;
            ?? e2 = 0;
            e2 = 0;
            e2 = 0;
            e2 = 0;
            e2 = 0;
            e2 = 0;
            e2 = 0;
            try {
            } catch (IOException e3) {
                e2 = e3;
                e2.printStackTrace();
            }
            try {
                try {
                    File file = new File(g.f555h);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    File file2 = new File(g.f556i);
                    if (!file2.exists()) {
                        file2.createNewFile();
                    }
                    List<KGMusicWrapper> queue = g.this.b.getQueue();
                    String strC = g.this.f557d.c(queue);
                    if (g0.a) {
                        g0.e("young-hqd", "PlayerQueueCache save list:" + queue.size() + "   json=" + strC);
                    }
                    fileOutputStream = new FileOutputStream(file2);
                    try {
                        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8));
                        try {
                            bufferedWriter.write(strC);
                            bufferedWriter.close();
                            fileOutputStream.close();
                        } catch (Exception e4) {
                            e = e4;
                            e2 = bufferedWriter;
                            e.printStackTrace();
                            if (e2 != 0) {
                                e2.close();
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                        } catch (OutOfMemoryError e5) {
                            e = e5;
                            e2 = bufferedWriter;
                            System.gc();
                            e.printStackTrace();
                            if (e2 != 0) {
                                e2.close();
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                        } catch (Throwable th) {
                            th = th;
                            e2 = bufferedWriter;
                            if (e2 != 0) {
                                try {
                                    e2.close();
                                } catch (IOException e6) {
                                    e6.printStackTrace();
                                    throw th;
                                }
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            throw th;
                        }
                    } catch (Exception e7) {
                        e = e7;
                    } catch (OutOfMemoryError e8) {
                        e = e8;
                    }
                } catch (Exception e9) {
                    e = e9;
                    fileOutputStream = null;
                } catch (OutOfMemoryError e10) {
                    e = e10;
                    fileOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = null;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    static {
        String str = e.c.a.g.a.f.f.a.f650f;
        f554g = str;
        String str2 = str + "/player/queue";
        f555h = str2;
        f556i = str2 + "/player_list.cache";
    }

    public static g h() {
        if (j == null) {
            synchronized (g.class) {
                if (j == null) {
                    j = new g();
                }
            }
        }
        return j;
    }

    public void e(InputStream inputStream, BufferedReader bufferedReader) {
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (IOException e2) {
                e2.printStackTrace();
                return;
            }
        }
        if (inputStream != null) {
            inputStream.close();
        }
    }

    public HashMap<String, KGMusicWrapper> f() {
        return this.c;
    }

    public int g() {
        return e.c.a.g.a.f.m.c.a.b("player_cache_list_index", 0);
    }

    public void i() {
        g0.b("young-hqd", "PlayerQueueCache restoreQueue");
        this.a.removeCallbacks(this.f558e);
        this.a.post(this.f558e);
    }

    public void j(c.InterfaceC0238c<KGMusicWrapper> interfaceC0238c) {
        KGMusicWrapper kGMusicWrapper;
        this.b = interfaceC0238c;
        this.c.clear();
        List<KGMusicWrapper> queue = interfaceC0238c.getQueue();
        int iE = l0.e(queue);
        for (int i2 = 0; i2 < iE; i2++) {
            if (i2 < queue.size() && (kGMusicWrapper = queue.get(i2)) != null) {
                this.c.put(kGMusicWrapper.getHashValue(), kGMusicWrapper);
            }
        }
        this.a.removeCallbacks(this.f558e);
        this.a.removeCallbacks(this.f559f);
        this.a.post(this.f559f);
    }

    public void k(int i2) {
        e.c.a.g.a.f.m.c.a.g("player_cache_list_index", i2);
    }
}
