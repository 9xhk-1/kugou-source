package e.c.a.g.a.d.x.s;

import android.content.Intent;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import com.kugou.android.watch.lite.common.music.entity.KGSong;
import com.kugou.common.apm.ResponseHandlerForApm;
import com.kugou.common.apm.task.LoadLyricAPM;
import com.kugou.framework.lyric.LyricData;
import com.kugou.framework.lyric.LyricInfo;
import com.kugou.framework.lyric.LyricManager;
import e.c.a.g.a.d.x.f;
import e.c.a.g.a.d.x.s.b.b;
import e.c.a.g.a.d.x.s.c.a;
import e.c.a.g.a.d.x.s.c.h;
import f.u.u;
import f.z.d.j;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import rx.Observable;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static LyricData f579d;
    public static final a a = new a();
    public static e.c.a.g.a.d.x.s.c.a b = new e.c.a.g.a.d.x.s.c.a();
    public static final Map<String, LoadLyricAPM> c = new ConcurrentHashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f580e = "";

    /* JADX INFO: renamed from: e.c.a.g.a.d.x.s.a$a, reason: collision with other inner class name */
    public static final class C0090a implements a.b {
        public final /* synthetic */ KGMusicWrapper a;
        public final /* synthetic */ String b;

        /* JADX INFO: renamed from: e.c.a.g.a.d.x.s.a$a$a, reason: collision with other inner class name */
        public static final class C0091a<T> implements Action1 {
            public final /* synthetic */ KGMusicWrapper a;
            public final /* synthetic */ LyricInfo b;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ KGMusicWrapper f581d;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final /* synthetic */ String f582f;

            public C0091a(KGMusicWrapper kGMusicWrapper, LyricInfo lyricInfo, KGMusicWrapper kGMusicWrapper2, String str) {
                this.a = kGMusicWrapper;
                this.b = lyricInfo;
                this.f581d = kGMusicWrapper2;
                this.f582f = str;
            }

            @Override // rx.functions.Action1
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final void call(LyricInfo lyricInfo) {
                e.c.a.g.a.d.f.d.a.a aVar = e.c.a.g.a.d.f.d.a.a.a;
                long mixId = this.a.getMixId();
                String hashValue = this.a.getHashValue();
                String displayName = this.a.getDisplayName();
                long duration = this.a.getDuration();
                LyricInfo lyricInfo2 = this.b;
                aVar.e(mixId, hashValue, displayName, duration, lyricInfo2 == null ? null : lyricInfo2.lyricPath);
                long mixId2 = this.a.getMixId();
                KGMusicWrapper kGMusicWrapper = this.f581d;
                boolean z = false;
                if (kGMusicWrapper != null && mixId2 == kGMusicWrapper.getMixId()) {
                    z = true;
                }
                if (z) {
                    a aVar2 = a.a;
                    aVar2.l(this.f582f, "2");
                    String hashValue2 = this.a.getHashValue();
                    j.d(hashValue2, "song.hashValue");
                    LyricInfo lyricInfo3 = this.b;
                    aVar2.j(hashValue2, lyricInfo3 != null ? lyricInfo3.lyricData : null);
                }
            }
        }

        /* JADX INFO: renamed from: e.c.a.g.a.d.x.s.a$a$b */
        public static final class b<T> implements Action1 {
            public final /* synthetic */ KGMusicWrapper a;
            public final /* synthetic */ KGMusicWrapper b;

            public b(KGMusicWrapper kGMusicWrapper, KGMusicWrapper kGMusicWrapper2) {
                this.a = kGMusicWrapper;
                this.b = kGMusicWrapper2;
            }

            @Override // rx.functions.Action1
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final void call(Throwable th) {
                long mixId = this.a.getMixId();
                KGMusicWrapper kGMusicWrapper = this.b;
                boolean z = false;
                if (kGMusicWrapper != null && mixId == kGMusicWrapper.getMixId()) {
                    z = true;
                }
                if (z) {
                    a.i(a.a, "com.kugou.young.watch.lyrloadfail", null, null, 6, null);
                }
            }
        }

        /* JADX INFO: renamed from: e.c.a.g.a.d.x.s.a$a$c */
        public static final class c implements Action0 {
            public final /* synthetic */ String a;

            public c(String str) {
                this.a = str;
            }

            @Override // rx.functions.Action0
            public final void call() {
                a.c.remove(this.a);
            }
        }

        public C0090a(KGMusicWrapper kGMusicWrapper, String str) {
            this.a = kGMusicWrapper;
            this.b = str;
        }

        @Override // e.c.a.g.a.d.x.s.c.a.b
        public void onDownloadSucceed(LyricInfo lyricInfo) {
        }

        @Override // e.c.a.g.a.d.x.s.c.a.b
        public void onError(String str, Exception exc, e.c.a.g.a.d.b.a aVar) {
            String strC;
            String strA;
            j.e(str, "errorcode");
            a aVar2 = a.a;
            aVar2.c(this.b, aVar == null ? 2 : aVar.b(), (aVar == null || (strA = aVar.a()) == null) ? str : strA, (aVar == null || (strC = aVar.c()) == null) ? ResponseHandlerForApm.E3 : strC, "");
            a.i(aVar2, "com.kugou.young.watch.lyrloadfail", null, null, 6, null);
        }

        @Override // e.c.a.g.a.d.x.s.c.a.b
        public void onLoaded(LyricInfo lyricInfo) {
            KGMusicWrapper kGMusicWrapperE = f.e();
            Observable observableSubscribeOn = Observable.just(lyricInfo).subscribeOn(Schedulers.io());
            KGMusicWrapper kGMusicWrapper = this.a;
            String str = this.b;
            observableSubscribeOn.subscribe(new C0091a(kGMusicWrapper, lyricInfo, kGMusicWrapperE, str), new b(kGMusicWrapper, kGMusicWrapperE), new c(str));
        }

        @Override // e.c.a.g.a.d.x.s.c.a.b
        public void onParseError() {
            a aVar = a.a;
            aVar.c(this.b, 3, "2", "", "");
            a.i(aVar, "com.kugou.young.watch.lyrloadfail", null, null, 6, null);
        }
    }

    public static /* synthetic */ void i(a aVar, String str, String str2, Parcelable parcelable, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        if ((i2 & 4) != 0) {
            parcelable = null;
        }
        aVar.h(str, str2, parcelable);
    }

    public final void c(String str, int i2, String str2, String str3, String str4) {
        j.e(str, "uniqueKey");
        j.e(str2, "errCode");
        LoadLyricAPM loadLyricAPMRemove = c.remove(str);
        if (loadLyricAPMRemove == null) {
            return;
        }
        loadLyricAPMRemove.fail(i2, str2, str3, str4);
    }

    public final LyricData d() {
        return f579d;
    }

    public final String e() {
        return f580e;
    }

    @WorkerThread
    public final void f(KGMusicWrapper kGMusicWrapper) {
        String strC;
        e.c.a.g.a.d.b.a aVarV;
        j.e(kGMusicWrapper, "song");
        String strG = g(kGMusicWrapper);
        k(strG, kGMusicWrapper);
        i(this, "com.kugou.young.watch.lyrstartload", null, null, 6, null);
        if (TextUtils.isEmpty(kGMusicWrapper.getHashValue())) {
            c(strG, 4, "1", null, null);
            i(this, "com.kugou.young.watch.lyrloadfail", null, null, 6, null);
            return;
        }
        e.c.a.g.a.d.f.d.a.a aVar = e.c.a.g.a.d.f.d.a.a.a;
        e.c.a.g.a.d.f.d.b.a aVarD = aVar.d(kGMusicWrapper.getMixId(), kGMusicWrapper.getHashValue(), kGMusicWrapper.getDisplayName(), kGMusicWrapper.getDuration());
        if (aVarD != null && !TextUtils.isEmpty(aVarD.c())) {
            LyricInfo lyricInfoLoadLyric = LyricManager.newInstance().loadLyric(aVarD.c());
            if ((lyricInfoLoadLyric == null ? null : lyricInfoLoadLyric.lyricData) != null) {
                l(strG, "1");
                String hashValue = kGMusicWrapper.getHashValue();
                j.d(hashValue, "song.hashValue");
                j(hashValue, lyricInfoLoadLyric.lyricData);
                return;
            }
            aVar.c(kGMusicWrapper.getMixId(), kGMusicWrapper.getHashValue(), kGMusicWrapper.getDisplayName(), kGMusicWrapper.getDuration());
        }
        h hVar = new h(kGMusicWrapper.getDisplayName(), kGMusicWrapper.getDuration(), kGMusicWrapper.getHashValue(), kGMusicWrapper.getMixId());
        ArrayList<b> arrayListR = hVar.r(false);
        j.d(arrayListR, "moreOptions.downloadMoreLyric(false)");
        if (!(!arrayListR.isEmpty())) {
            String strS = hVar.s();
            String str = (strS == null && ((aVarV = hVar.v()) == null || (strS = aVarV.a()) == null)) ? "1" : strS;
            e.c.a.g.a.d.b.a aVarV2 = hVar.v();
            c(strG, 1, str, (aVarV2 == null || (strC = aVarV2.c()) == null) ? ResponseHandlerForApm.E3 : strC, "1");
            i(this, "com.kugou.young.watch.lyrloadfail", null, null, 6, null);
            return;
        }
        b bVar = (b) u.u(arrayListR);
        KGSong kGSong = new KGSong("");
        kGSong.p3((int) kGMusicWrapper.getAudioId());
        kGSong.e3(kGMusicWrapper.getDisplayName());
        kGSong.B3(kGMusicWrapper.getHashValue());
        kGSong.g3(kGMusicWrapper.getDuration());
        kGSong.Q3(kGMusicWrapper.getMixId());
        b.b(bVar.b(), bVar.f(), String.valueOf(bVar.d()), bVar.a(), bVar.c(), bVar.e(), kGSong, false, new C0090a(kGMusicWrapper, strG));
    }

    public final String g(KGMusicWrapper kGMusicWrapper) {
        j.e(kGMusicWrapper, "song");
        StringBuilder sb = new StringBuilder();
        sb.append((Object) kGMusicWrapper.getHashValueV2());
        sb.append('-');
        sb.append(kGMusicWrapper.getMixId());
        String string = sb.toString();
        Locale locale = Locale.getDefault();
        j.d(locale, "getDefault()");
        Objects.requireNonNull(string, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = string.toLowerCase(locale);
        j.d(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }

    public final void h(String str, String str2, Parcelable parcelable) {
        Intent intent = new Intent(str);
        if (!(str2 == null || str2.length() == 0) && parcelable != null) {
            intent.putExtra("arg_lyric_hash_data", str2);
            intent.putExtra("arg_lyric_data", parcelable);
        }
        e.c.a.g.a.f.d.a.d(intent);
    }

    public final void j(String str, LyricData lyricData) {
        f579d = lyricData;
        f580e = str;
        h("com.kugou.young.watch.lyrloadsuccess", str, lyricData);
    }

    public final void k(String str, KGMusicWrapper kGMusicWrapper) {
        j.e(str, "uniqueKey");
        j.e(kGMusicWrapper, "song");
        Map<String, LoadLyricAPM> map = c;
        LoadLyricAPM loadLyricAPMRemove = map.remove(str);
        if (loadLyricAPMRemove != null) {
            loadLyricAPMRemove.release();
        }
        LoadLyricAPM loadLyricAPM = new LoadLyricAPM();
        loadLyricAPM.start();
        String string = kGMusicWrapper.getInnerKGfile(false) != null ? kGMusicWrapper.getInnerKGfile(false).toString() : kGMusicWrapper.toString();
        j.d(string, "if (song.getInnerKGfile(false) != null) song.getInnerKGfile(false).toString() else song.toString()");
        loadLyricAPM.addPara(string);
        map.put(str, loadLyricAPM);
    }

    public final void l(String str, String str2) {
        j.e(str, "uniqueKey");
        LoadLyricAPM loadLyricAPMRemove = c.remove(str);
        if (loadLyricAPMRemove != null) {
            loadLyricAPMRemove.netFinish();
            if (str2 != null) {
                loadLyricAPMRemove.addState2(str2);
            }
            loadLyricAPMRemove.success();
        }
    }
}
