package e.c.a.g.a.d.x.s.c;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.bi.YoungBITask;
import com.kugou.android.watch.lite.common.music.entity.KGSong;
import com.kugou.common.apm.ResponseHandlerForApm;
import com.kugou.framework.lyric.LyricInfo;
import com.kugou.framework.lyric.LyricManager;
import e.c.a.g.a.s.g0;
import java.lang.ref.WeakReference;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public ThreadPoolExecutor a;
    public Handler b;

    /* JADX INFO: renamed from: e.c.a.g.a.d.x.s.c.a$a, reason: collision with other inner class name */
    public static final class RunnableC0092a implements Runnable {
        public f a;
        public WeakReference<Handler> b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public WeakReference<a> f590d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public b f591f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public e.c.a.g.a.d.x.s.c.c f592h;

        /* JADX INFO: renamed from: e.c.a.g.a.d.x.s.c.a$a$a, reason: collision with other inner class name */
        public class RunnableC0093a implements Runnable {
            public final /* synthetic */ LyricInfo a;

            public RunnableC0093a(LyricInfo lyricInfo) {
                this.a = lyricInfo;
            }

            @Override // java.lang.Runnable
            public void run() {
                RunnableC0092a.this.f591f.onLoaded(this.a);
            }
        }

        /* JADX INFO: renamed from: e.c.a.g.a.d.x.s.c.a$a$b */
        public class b implements Runnable {
            public final /* synthetic */ LyricInfo a;

            public b(LyricInfo lyricInfo) {
                this.a = lyricInfo;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (RunnableC0092a.this.f591f != null) {
                    RunnableC0092a.this.f591f.onDownloadSucceed(this.a);
                }
            }
        }

        /* JADX INFO: renamed from: e.c.a.g.a.d.x.s.c.a$a$c */
        public class c implements Runnable {
            public c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (RunnableC0092a.this.f591f != null) {
                    RunnableC0092a.this.f591f.onParseError();
                }
            }
        }

        /* JADX INFO: renamed from: e.c.a.g.a.d.x.s.c.a$a$d */
        public class d implements Runnable {
            public final /* synthetic */ String a;
            public final /* synthetic */ Exception b;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ e.c.a.g.a.d.b.a f593d;

            public d(String str, Exception exc, e.c.a.g.a.d.b.a aVar) {
                this.a = str;
                this.b = exc;
                this.f593d = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (RunnableC0092a.this.f591f != null) {
                    RunnableC0092a.this.f591f.onError(this.a, this.b, this.f593d);
                }
            }
        }

        public RunnableC0092a(e.c.a.g.a.d.x.s.b.a aVar, a aVar2, Handler handler, b bVar, boolean z) {
            this.a = new f(aVar, z);
            this.b = new WeakReference<>(handler);
            this.f590d = new WeakReference<>(aVar2);
            this.f591f = bVar;
        }

        public final boolean b() {
            return this.a.b() != null && this.a.b().length > 10;
        }

        public final void c(Handler handler, LyricInfo lyricInfo) {
            if (handler != null) {
                handler.post(new b(lyricInfo));
            }
        }

        public final void d(Handler handler, Exception exc, String str, e.c.a.g.a.d.b.a aVar) {
            if (handler != null) {
                handler.post(new d(str, exc, aVar));
            }
        }

        public final void e(Handler handler) {
            if (handler != null) {
                handler.post(new c());
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Handler handler = this.b.get();
            this.f590d.get();
            try {
                this.a.h();
                String strC = this.a.c();
                e.c.a.g.a.d.b.a aVarA = this.a.a();
                if (TextUtils.isEmpty(strC) && !b()) {
                    d(handler, new NullPointerException("lyric download fail"), "3", aVarA);
                    return;
                }
                e.c.a.g.a.d.x.s.b.a aVarD = this.a.d();
                String strH = aVarD.h();
                LyricManager lyricManagerNewInstance = LyricManager.newInstance();
                LyricInfo lyricInfoLoadLyric = lyricManagerNewInstance.loadLyric(strC);
                if ((lyricInfoLoadLyric == null || lyricInfoLoadLyric.hasError) && b()) {
                    if (g0.f()) {
                        g0.b("AsyncLyricLoader", "路径加载异常但歌词内容不为空，尝试直接解析歌词。" + aVarD.e() + ":" + aVarD.j() + ":" + strH);
                    }
                    e.c.a.g.a.e.b.b(new YoungBITask(22020029, "statistics").setType("16").setFo("/歌词内存解析").setSvar1(aVarD.e()).setIvar1(aVarD.j() + "").setIvar2(strH));
                    lyricInfoLoadLyric = lyricManagerNewInstance.loadLyric(this.a.b(), this.a.e(), true);
                }
                if (lyricInfoLoadLyric == null || lyricInfoLoadLyric.lyricData == null) {
                    if (this.f592h == null) {
                        this.f592h = new e.c.a.g.a.d.x.s.c.d(KGApplication.getContext());
                    }
                    d(handler, new NullPointerException("Lyr is not found"), "4", aVarA);
                    return;
                }
                c(handler, lyricInfoLoadLyric);
                if (this.f592h == null) {
                    this.f592h = new e.c.a.g.a.d.x.s.c.d(KGApplication.getContext());
                }
                if (g0.a) {
                    g0.b("AsyncLyricLoader", "歌词下载成功");
                }
                if (lyricInfoLoadLyric.hasError || handler == null) {
                    e(handler);
                } else {
                    handler.post(new RunnableC0093a(lyricInfoLoadLyric));
                }
            } catch (Exception e2) {
                d(handler, e2, "5", new e.c.a.g.a.d.b.a(ResponseHandlerForApm.E4, "5"));
            }
        }
    }

    public interface b {
        void onDownloadSucceed(LyricInfo lyricInfo);

        void onError(String str, Exception exc, e.c.a.g.a.d.b.a aVar);

        void onLoaded(LyricInfo lyricInfo);

        void onParseError();
    }

    public a() {
        this(3, 9);
    }

    public final e.c.a.g.a.d.x.s.b.a a(String str, String str2, String str3, String str4, int i2, int i3, KGSong kGSong, boolean z) {
        e.c.a.g.a.d.x.s.b.a aVar = new e.c.a.g.a.d.x.s.b.a();
        aVar.p(str);
        aVar.A(str2);
        aVar.u(str3);
        aVar.o(str4);
        aVar.y(i3);
        aVar.v(i2);
        aVar.q(kGSong.z1());
        aVar.s(kGSong.s1());
        aVar.t(kGSong.J1());
        aVar.w(kGSong.S1());
        aVar.r(kGSong.t1());
        aVar.B(true);
        aVar.x(kGSong.T1());
        if (z) {
            aVar.z(kGSong.J1());
        } else if (e.c.a.g.a.d.x.f.e() != null) {
            aVar.z(e.c.a.g.a.d.x.f.e().getHashValue());
        }
        return aVar;
    }

    public void b(String str, String str2, String str3, String str4, int i2, int i3, KGSong kGSong, boolean z, b bVar) {
        c(str, str2, str3, str4, i2, i3, kGSong, z, bVar, true);
    }

    public void c(String str, String str2, String str3, String str4, int i2, int i3, KGSong kGSong, boolean z, b bVar, boolean z2) {
        this.a.execute(new RunnableC0092a(a(str, str2, str3, str4, i2, i3, kGSong, z), this, this.b, bVar, z2));
    }

    public a(int i2, int i3) {
        this(2, i2, 3L, TimeUnit.SECONDS, new LinkedBlockingQueue(i3), new ThreadPoolExecutor.DiscardOldestPolicy());
    }

    public a(int i2, int i3, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, RejectedExecutionHandler rejectedExecutionHandler) {
        new ConcurrentHashMap();
        new ConcurrentHashMap();
        this.a = new ThreadPoolExecutor(i2, i3, j, timeUnit, blockingQueue, rejectedExecutionHandler);
        this.b = new Handler(Looper.getMainLooper());
    }
}
