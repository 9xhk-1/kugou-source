package com.kugou.android.watch.lite.provider;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import com.kugou.common.permission.FileProvider;
import com.xtc.cardwidget.external.card.serviceLayer.AppCardWidgetProvider;
import com.xtc.shareapi.share.constant.OpenApiConstant;
import e.c.a.g.a.d.x.f;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.h1;
import e.c.a.g.a.s.j0;
import e.c.a.g.a.s.p1;
import f.s;
import f.z.d.j;
import f.z.d.k;
import f.z.d.r;
import java.io.File;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;

/* JADX INFO: loaded from: classes2.dex */
public final class XtcDesktopCardWidgetProvider extends AppCardWidgetProvider implements e.g.a.a.a.b {
    public static Handler q = new Handler(Looper.getMainLooper());
    public static Handler r = new Handler(Looper.getMainLooper());
    public static Handler s = new Handler(Looper.getMainLooper());
    public BroadcastReceiver l;
    public Timer n;
    public f.z.c.a<s> m = new b();
    public String o = "";
    public HashMap<String, Integer> p = new HashMap<>();

    public static final class a extends TimerTask {

        /* JADX INFO: renamed from: com.kugou.android.watch.lite.provider.XtcDesktopCardWidgetProvider$a$a, reason: collision with other inner class name */
        public static final class RunnableC0019a implements Runnable {
            public final /* synthetic */ XtcDesktopCardWidgetProvider a;

            public RunnableC0019a(XtcDesktopCardWidgetProvider xtcDesktopCardWidgetProvider) {
                this.a = xtcDesktopCardWidgetProvider;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.M();
            }
        }

        public a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            XtcDesktopCardWidgetProvider.r.post(new RunnableC0019a(XtcDesktopCardWidgetProvider.this));
        }
    }

    public static final class b extends k implements f.z.c.a<s> {
        public b() {
            super(0);
        }

        public final void a() {
            XtcDesktopCardWidgetProvider.this.K();
        }

        @Override // f.z.c.a
        public /* bridge */ /* synthetic */ s invoke() {
            a();
            return s.a;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ f.z.c.a a;

        public c(f.z.c.a aVar) {
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public final /* synthetic */ void run() {
            this.a.invoke();
        }
    }

    public static final class d extends e.g.a.b.a.b.c.a {
        public d() {
        }

        @Override // e.g.a.b.a.b.c.a
        public boolean b(e.g.a.c.a.a aVar) throws JSONException {
            String string;
            j.e(aVar, "dslCoder");
            boolean zE = e.c.a.g.a.f.m.c.a.e("sp_key_show_privacy", true);
            g0.c("xtckgCardWidgetProvider", j.l("updateAllViewState(), show = ", Boolean.valueOf(zE)));
            if (zE) {
                XtcDesktopCardWidgetProvider.this.E(aVar);
                return true;
            }
            String string2 = null;
            if (!e.c.a.g.a.d.x.f.o()) {
                Log.d("xtckgCardWidgetProvider", "updateAllViewState() -> 播放器未初始化, 直接重置");
                XtcDesktopCardWidgetProvider.H(XtcDesktopCardWidgetProvider.this, 0L, 1, null);
                XtcDesktopCardWidgetProvider.this.E(aVar);
                return true;
            }
            KGMusicWrapper kGMusicWrapperE = e.c.a.g.a.d.x.f.e();
            if (XtcDesktopCardWidgetProvider.this.getContext() == null) {
                string = "酷狗概念版";
            } else {
                Context context = XtcDesktopCardWidgetProvider.this.getContext();
                string = context == null ? null : context.getString(R.string.app_name);
            }
            if (kGMusicWrapperE != null) {
                string = kGMusicWrapperE.getTrackName();
            }
            if (string != null) {
                aVar.f("song_title", string);
            }
            if (XtcDesktopCardWidgetProvider.this.getContext() == null) {
                string2 = "因乐相遇";
            } else {
                Context context2 = XtcDesktopCardWidgetProvider.this.getContext();
                if (context2 != null) {
                    string2 = context2.getString(R.string.kugou_short_slogan2);
                }
            }
            if (kGMusicWrapperE != null) {
                string2 = kGMusicWrapperE.getArtistName();
            }
            if (string2 != null) {
                aVar.f("singer_title", string2);
            }
            aVar.b("pause_button", e.c.a.g.a.m.a.a.d() ? R.drawable.young_ic_widget_pause_song : R.drawable.young_ic_widget_play_song);
            aVar.e("progress_music", XtcDesktopCardWidgetProvider.this.A());
            XtcDesktopCardWidgetProvider.this.J(aVar);
            return true;
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ r<KGMusicWrapper> a;
        public final /* synthetic */ XtcDesktopCardWidgetProvider b;

        public e(r<KGMusicWrapper> rVar, XtcDesktopCardWidgetProvider xtcDesktopCardWidgetProvider) {
            this.a = rVar;
            this.b = xtcDesktopCardWidgetProvider;
        }

        @Override // java.lang.Runnable
        public final void run() {
            e.c.a.g.a.m.a aVar = e.c.a.g.a.m.a.a;
            Context context = KGApplication.getContext();
            j.d(context, "getContext()");
            KGMusicWrapper kGMusicWrapper = this.a.a;
            if (aVar.h(context, kGMusicWrapper == null ? null : kGMusicWrapper.getImgUrl())) {
                Log.d("xtckgCardWidgetProvider", "onReceive() -> widgetCode is " + this.b.B() + " 图片更新");
                XtcDesktopCardWidgetProvider.H(this.b, 0L, 1, null);
            }
        }
    }

    public static final class f extends e.g.a.b.a.b.c.a {
        @Override // e.g.a.b.a.b.c.a
        public boolean b(e.g.a.c.a.a aVar) {
            j.e(aVar, "dslCoder");
            try {
                int[] iArrJ = e.c.a.g.a.d.x.f.j();
                if (iArrJ != null && iArrJ.length == 2) {
                    int i2 = iArrJ[0];
                    int i3 = iArrJ[1];
                    int i4 = i3 / 1000;
                    if (i2 > 1000 && i3 > 1000) {
                        e.c.a.g.a.g.j.g.b.d().g(i2, i3);
                    }
                    int i5 = i3 > 0 ? (i2 * 100) / i3 : 0;
                    aVar.e("progress_music", i5);
                    String strF = h1.f(i2 / 1000);
                    j.d(strF, "formatSeconds2(curSec)");
                    aVar.f("song_time_current", strF);
                    String strF2 = h1.f(i4);
                    if (strF2 != null) {
                        aVar.f("song_time_total", strF2);
                    }
                    aVar.b("pause_button", e.c.a.g.a.m.a.a.d() ? R.drawable.young_ic_widget_pause_song : R.drawable.young_ic_widget_play_song);
                    Log.e("xtckgCardWidgetProvider", j.l("轮训更新 updatePlayerViewState() -> seekBarPos = ", Integer.valueOf(i5)));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                Log.e("xtckgCardWidgetProvider", j.l("updateProgressView() -> Exception = ", e2));
            }
            return true;
        }
    }

    public static /* synthetic */ void H(XtcDesktopCardWidgetProvider xtcDesktopCardWidgetProvider, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = 1000;
        }
        xtcDesktopCardWidgetProvider.G(j);
    }

    public final int A() {
        int[] iArrJ = e.c.a.g.a.d.x.f.j();
        if (iArrJ != null && iArrJ.length == 2) {
            int i2 = iArrJ[0];
            int i3 = iArrJ[1];
            if (i2 > 1000 && i3 > 1000) {
                e.c.a.g.a.g.j.g.b.d().g(i2, i3);
            }
            if (i3 > 0) {
                return (i2 * 100) / i3;
            }
        }
        return 0;
    }

    public final String B() {
        return this.o;
    }

    public final void C() {
        if (this.l == null) {
            this.l = new BroadcastReceiver() { // from class: com.kugou.android.watch.lite.provider.XtcDesktopCardWidgetProvider$registReceiver$1

                public static final class a implements Runnable {
                    public final /* synthetic */ XtcDesktopCardWidgetProvider a;

                    public a(XtcDesktopCardWidgetProvider xtcDesktopCardWidgetProvider) {
                        this.a = xtcDesktopCardWidgetProvider;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.L();
                        this.a.G(100L);
                    }
                }

                public static final class b implements Runnable {
                    public static final b a = new b();

                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            e.c.a.g.a.m.a.a.e();
                        } catch (Exception unused) {
                        }
                    }
                }

                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    Handler handler;
                    j.e(context, "context");
                    j.e(intent, "intent");
                    String action = intent.getAction();
                    if (j.a("com.kugou.young.watch.metachanged", action) || j.a("com.kugou.young.watch.playstatechanged", action)) {
                        if (!f.o()) {
                            Log.d("xtckgCardWidgetProvider", "onReceive() -> 播放器未初始化");
                            return;
                        }
                        XtcDesktopCardWidgetProvider.q.post(new a(this.a));
                    }
                    if (j.a("com.kugou.young.watch.xtc.toast.sys", action)) {
                        String stringExtra = intent.getStringExtra(p1.f1218d);
                        boolean booleanExtra = intent.getBooleanExtra(p1.f1219e, false);
                        Log.d("xtckgCardWidgetProvider", "onReceive() -> PLAYER_XTC_TOAST_SYS tip = " + ((Object) stringExtra) + " needJumpApp = " + booleanExtra);
                        if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(this.a.B())) {
                            XtcDesktopCardWidgetProvider xtcDesktopCardWidgetProvider = this.a;
                            String strB = xtcDesktopCardWidgetProvider.B();
                            j.c(stringExtra);
                            xtcDesktopCardWidgetProvider.I(context, strB, stringExtra);
                        }
                        if (!booleanExtra || (handler = XtcDesktopCardWidgetProvider.q) == null) {
                            return;
                        }
                        handler.postDelayed(b.a, 1000L);
                    }
                }
            };
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.kugou.young.watch.playstatechanged");
            intentFilter.addAction("com.kugou.young.watch.metachanged");
            intentFilter.addAction("com.kugou.young.watch.xtc.toast.sys");
            e.c.a.g.a.f.d.a.b(this.l, intentFilter);
        }
    }

    public final void D() {
        s.removeCallbacks(new c(this.m));
    }

    public final void E(e.g.a.c.a.a aVar) {
        String string;
        try {
            String string2 = null;
            if (getContext() == null) {
                string = "酷狗概念版";
            } else {
                Context context = getContext();
                string = context == null ? null : context.getString(R.string.app_name);
            }
            if (string != null) {
                aVar.f("song_title", string);
            }
            if (getContext() == null) {
                string2 = "因乐相遇";
            } else {
                Context context2 = getContext();
                if (context2 != null) {
                    string2 = context2.getString(R.string.kugou_short_slogan2);
                }
            }
            if (string2 != null) {
                aVar.f("singer_title", string2);
            }
            aVar.b("pause_button", R.drawable.young_ic_widget_play_song);
            aVar.e("progress_music", 0);
            aVar.b("player_image", R.drawable.album_img_default);
        } catch (Exception e2) {
            e2.printStackTrace();
            Log.d("xtckgCardWidgetProvider", j.l("更新播放状态 重置 updatePlayerViewState() -> Exception = ", e2));
        }
    }

    public final void F() {
        Log.d("xtckgCardWidgetProvider", "resetTimer() 时间重置. start");
        Timer timer = this.n;
        if (timer != null) {
            j.c(timer);
            timer.cancel();
        }
        try {
            this.n = null;
            Timer timer2 = new Timer();
            this.n = timer2;
            j.c(timer2);
            timer2.schedule(new a(), 0L, 1000L);
        } catch (Exception e2) {
            e2.printStackTrace();
            Log.e("xtckgCardWidgetProvider", j.l("resetTimer() 时间重置 e = ", e2));
        }
        Log.d("xtckgCardWidgetProvider", "resetTimer() 时间重置 end.");
    }

    public final void G(long j) {
        s.removeCallbacks(new c(this.m));
        s.postDelayed(new c(this.m), j);
    }

    public final void I(Context context, String str, String str2) {
        e.g.a.b.a.b.a.a.a.b(str2, str);
    }

    public final void J(e.g.a.c.a.a aVar) {
        Log.e("xtckgCardWidgetProvider", "updatAvatareImage() -> 更新头像");
        try {
            KGMusicWrapper kGMusicWrapperE = e.c.a.g.a.d.x.f.e();
            String imgUrl = null;
            Long lValueOf = kGMusicWrapperE == null ? null : Long.valueOf(kGMusicWrapperE.getMixId());
            String str = "xtc_widget_cover_" + lValueOf + ".png";
            if (lValueOf != null && lValueOf.longValue() == 0) {
                str = "xtc_widget_cover_default.png";
                Log.e("xtckgCardWidgetProvider", "updatAvatareImage() -> 用兜底图");
            }
            String strZ = z(str);
            if (!TextUtils.isEmpty(strZ)) {
                Log.e("xtckgCardWidgetProvider", "updatAvatareImage() -> uri = " + ((Object) strZ) + " 设置成新图片 ");
                aVar.g("player_image", false);
                if (strZ != null) {
                    aVar.c("player_image", strZ);
                    return;
                }
                return;
            }
            aVar.b("player_image", R.drawable.album_img_default);
            if (lValueOf == null || !j.a(y(str), Boolean.TRUE) || lValueOf.longValue() <= 0) {
                return;
            }
            if (TextUtils.isEmpty(kGMusicWrapperE == null ? null : kGMusicWrapperE.getImgUrl())) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("updatAvatareImage() -> path = ");
            sb.append((Object) strZ);
            sb.append(" 设置成新图片 currentSong?.imgUrl = ");
            sb.append((Object) (kGMusicWrapperE == null ? null : kGMusicWrapperE.getImgUrl()));
            sb.append("  mix = ");
            sb.append(lValueOf);
            Log.e("xtckgCardWidgetProvider", sb.toString());
            Integer num = this.p.get(kGMusicWrapperE == null ? null : kGMusicWrapperE.getImgUrl());
            if (num == null) {
                HashMap<String, Integer> map = this.p;
                if (kGMusicWrapperE != null) {
                    imgUrl = kGMusicWrapperE.getImgUrl();
                }
                j.c(imgUrl);
                map.put(imgUrl, 1);
            } else {
                HashMap<String, Integer> map2 = this.p;
                if (kGMusicWrapperE != null) {
                    imgUrl = kGMusicWrapperE.getImgUrl();
                }
                j.c(imgUrl);
                map2.put(imgUrl, Integer.valueOf(num.intValue() + 1));
            }
            if (num == null || num.intValue() >= 3) {
                return;
            }
            L();
        } catch (Exception e2) {
            Log.e("xtckgCardWidgetProvider", "更新头像 -> setSvgaImageSource error", e2);
            e2.printStackTrace();
        }
    }

    public final void K() {
        g0.c("xtckgCardWidgetProvider", "更新全部的view.");
        e.g.a.b.a.b.a.a.a.c(new d(), this.o, true);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [T, com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper] */
    public final void L() {
        if (!e.c.a.g.a.d.x.f.o()) {
            Log.d("xtckgCardWidgetProvider", "updateAvatorImg() -> 播放器未初始化");
            return;
        }
        r rVar = new r();
        ?? E = e.c.a.g.a.d.x.f.e();
        rVar.a = E;
        KGMusicWrapper kGMusicWrapper = (KGMusicWrapper) E;
        if (TextUtils.isEmpty(kGMusicWrapper == null ? null : kGMusicWrapper.getImgUrl())) {
            return;
        }
        j0.b().a(new e(rVar, this));
    }

    public final void M() {
        boolean zE = e.c.a.g.a.f.m.c.a.e("sp_key_show_privacy", true);
        if (zE) {
            g0.c("xtckgCardWidgetProvider", j.l("updateProgressView, show = ", Boolean.valueOf(zE)));
        } else if (e.c.a.g.a.d.x.f.o()) {
            e.g.a.b.a.b.a.a.a.c(new f(), this.o, true);
        } else {
            Log.d("xtckgCardWidgetProvider", "updateProgressView() -> 播放器未初始化");
        }
    }

    @Override // e.g.a.b.a.a.a.a
    public String getCardLayoutName(String str) {
        j.e(str, "widgetCode");
        if (getContext() != null) {
            e.g.a.c.a.b bVar = e.g.a.c.a.b.a;
            Context context = getContext();
            j.c(context);
            j.d(context, "context!!");
            if (bVar.b(context) >= 126201) {
                StringBuilder sb = new StringBuilder();
                sb.append("getCardLayoutName() -> widgetCode is ");
                sb.append(str);
                sb.append(", context = ");
                sb.append(getContext());
                sb.append(", getEngineVersionCode = ");
                Context context2 = getContext();
                j.c(context2);
                j.d(context2, "context!!");
                sb.append(bVar.b(context2));
                Log.e("mhs_watch_widget", sb.toString());
                return "app_xtc_widget.json";
            }
        }
        Log.e("mhs_watch_widget", "getCardLayoutName() -> widgetCode is " + str + ", context = " + getContext());
        return "app_xtc_widget_old.json";
    }

    @Override // e.g.a.a.a.b
    public void onContentChange(String str) {
        j.e(str, "content");
        Log.d("xtckgCardWidgetProvider", "onContentChange() -> content = " + str + " mWidgetCode = " + this.o);
    }

    @Override // com.xtc.cardwidget.external.card.serviceLayer.AppCardWidgetProvider, com.xtc.cardwidget.external.card.serviceLayer.BaseCardStrategyProvider, com.xtc.cardwidget.external.channel.client.provider.ChannelClientProvider, android.content.ContentProvider
    public boolean onCreate() {
        e.g.a.a.a.a.a.a(this);
        Log.d("xtckgCardWidgetProvider", "onCreate()");
        return super.onCreate();
    }

    @Override // com.xtc.cardwidget.external.card.serviceLayer.AppCardWidgetProvider, e.g.a.b.a.b.d.a
    public void onDestroy(Context context, String str) {
        j.e(context, "context");
        j.e(str, "widgetCode");
        super.onDestroy(context, str);
        Log.d("xtckgCardWidgetProvider", j.l("onDestroy() -> widgetCode = ", str));
        BroadcastReceiver broadcastReceiver = this.l;
        if (broadcastReceiver != null) {
            e.c.a.g.a.f.d.a.g(broadcastReceiver);
            this.l = null;
        }
        Timer timer = this.n;
        if (timer != null) {
            if (timer != null) {
                try {
                    timer.cancel();
                } catch (Exception e2) {
                    Log.d("xtckgCardWidgetProvider", j.l("onDestroy() -> e = ", e2));
                    e2.printStackTrace();
                }
            }
            this.n = null;
        }
        Handler handler = r;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        Handler handler2 = s;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
        }
        Handler handler3 = q;
        if (handler3 != null) {
            handler3.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.xtc.cardwidget.external.card.serviceLayer.AppCardWidgetProvider, e.g.a.b.a.b.d.a
    public void onPause(Context context, String str) {
        j.e(context, "context");
        j.e(str, "widgetCode");
        super.onPause(context, str);
        Timer timer = this.n;
        if (timer != null) {
            j.c(timer);
            timer.cancel();
        }
        D();
        try {
            e.c.a.g.a.m.a.a.b(context, "image", "xtc_widget_cover_", 5);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // e.g.a.b.a.b.d.a
    @SuppressLint({"LongLogTag"})
    public void onResume(Context context, String str) {
        j.e(context, "context");
        j.e(str, "widgetCode");
        Log.d("xtckgCardWidgetProvider", j.l("onResume() -> widgetCode is ", str));
        this.o = str;
        C();
        F();
        G(100L);
    }

    @Override // e.g.a.a.a.b
    public void onSongChange(int i2) {
        Log.d("xtckgCardWidgetProvider", "onSongChange() -> mode = " + i2 + " mWidgetCode = " + this.o);
    }

    @Override // com.xtc.cardwidget.external.card.serviceLayer.AppCardWidgetProvider, e.g.a.b.a.b.d.a
    public void subscribed(Context context, String str) {
        j.e(context, "context");
        j.e(str, "widgetCode");
        super.subscribed(context, str);
        e.c.a.g.a.f.m.c.a.j("key_xtc_widget_add", true);
    }

    @Override // com.xtc.cardwidget.external.card.serviceLayer.AppCardWidgetProvider, e.g.a.b.a.b.d.a
    public void unSubscribed(Context context, String str) {
        j.e(context, "context");
        j.e(str, "widgetCode");
        super.unSubscribed(context, str);
        e.c.a.g.a.f.m.c.a.j("key_xtc_widget_add", false);
    }

    public final Boolean y(String str) {
        Context context = KGApplication.getContext();
        if (context == null) {
            Log.e("xtckgCardWidgetProvider", "generateUri() -> context 为空，请检查");
            return Boolean.FALSE;
        }
        File file = new File(context.getFilesDir(), "image");
        return !file.exists() ? Boolean.TRUE : !new File(file, str).exists() ? Boolean.TRUE : Boolean.FALSE;
    }

    public final String z(String str) {
        Context context = KGApplication.getContext();
        if (context == null) {
            Log.e("xtckgCardWidgetProvider", "generateUri() -> context 为空，请检查");
            return null;
        }
        File file = new File(context.getFilesDir(), "image");
        if (!file.exists()) {
            return null;
        }
        File file2 = new File(file, str);
        if (!file2.exists()) {
            return null;
        }
        Uri uriForFile = FileProvider.getUriForFile(context, context.getString(R.string.file_provider_authority), file2);
        context.grantUriPermission(OpenApiConstant.App.LAUNCHER, uriForFile, 1);
        context.grantUriPermission("com.xtc.cardwidget.server.demo", uriForFile, 1);
        j.d(uriForFile, "svgaFileUri");
        Log.d("xtckgCardWidgetProvider", j.l("generateUri() -> svgaFileUri: ", uriForFile));
        return uriForFile.toString();
    }
}
