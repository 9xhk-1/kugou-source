package e.c.a.g.a.g.j.d;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.bi.YoungBITask;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import com.kugou.android.watch.lite.component.player.lyric.WatchLyricView;
import com.kugou.framework.lyric.LyricData;
import com.kugou.framework.lyric.LyricManager;
import com.kugou.framework.lyric.loader.language.Language;
import com.kugou.framework.lyric4.BaseLyricView;
import com.kugou.framework.lyric4.FixMultipleLineLyricView;
import e.c.a.g.a.s.i1;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.p0;
import f.s;
import f.z.c.p;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public final WatchLyricView a;
    public final LyricManager b;
    public Subscription c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e.c.a.g.a.g.j.d.b f929d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f930e;

    /* JADX INFO: renamed from: e.c.a.g.a.g.j.d.a$a, reason: collision with other inner class name */
    public class C0139a implements FixMultipleLineLyricView.OnLyricSlideListener {
        public C0139a(a aVar) {
        }

        @Override // com.kugou.framework.lyric4.FixMultipleLineLyricView.OnLyricSlideListener
        public void onSlideTimeOut() {
        }

        @Override // com.kugou.framework.lyric4.FixMultipleLineLyricView.OnLyricSlideListener
        public void onSlidingMove(long j) {
        }

        @Override // com.kugou.framework.lyric4.FixMultipleLineLyricView.OnLyricSlideListener
        public void onSlidingStart() {
            KGMusicWrapper kGMusicWrapperE = e.c.a.g.a.d.x.f.e();
            e.c.a.g.a.e.b.b(new YoungBITask(20585, "click").setMixsongid(kGMusicWrapperE != null ? String.valueOf(kGMusicWrapperE.getMixId()) : ""));
        }
    }

    public class b implements BaseLyricView.OnLyricDataLoadListener {
        public b() {
        }

        @Override // com.kugou.framework.lyric4.BaseLyricView.OnLyricDataLoadListener
        public void onLyricDataLoaded(LyricData lyricData) {
            if (lyricData != null) {
                List<Language> languageList = lyricData.getLanguageList();
                if (languageList.size() != 2) {
                    if (languageList.size() == 3) {
                        a.this.a.setLanguage(a.this.f930e ? Language.Translation : Language.Origin);
                        return;
                    } else {
                        a.this.a.setLanguage(Language.Origin);
                        return;
                    }
                }
                Language language = Language.Translation;
                if (!p0.b(languageList, language)) {
                    a.this.a.setLanguage(Language.Origin);
                    return;
                }
                WatchLyricView watchLyricView = a.this.a;
                if (!a.this.f930e) {
                    language = Language.Origin;
                }
                watchLyricView.setLanguage(language);
            }
        }
    }

    public class c implements p<Float, Float, s> {
        public c() {
        }

        @Override // f.z.c.p
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public s invoke(Float f2, Float f3) {
            int iRound;
            LyricData lyricData = a.this.b.getLyricData();
            if ((lyricData != null ? lyricData.getWords() : null) != null && (iRound = Math.round(r2.length * f2.floatValue())) != a.this.a.getAttachInfo().getCurrentHighLightLine()) {
                a.this.a.scrollToPosition(iRound);
            }
            return s.a;
        }
    }

    public class d implements f.z.c.a<s> {
        public d() {
        }

        @Override // f.z.c.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public s invoke() {
            a.this.a.reScrollToCenter();
            return s.a;
        }
    }

    public class e implements Action1<Integer> {
        public e() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(Integer num) {
            if (num.intValue() >= 0) {
                a.this.b.syncLyric(num.intValue());
                if (a.this.f929d != null) {
                    a.this.f929d.j((num.intValue() * 1.0f) / e.c.a.g.a.d.x.f.g());
                }
            }
        }
    }

    public class f implements Action1<Throwable> {
        public f() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(Throwable th) {
            i1.a(a.this.c);
        }
    }

    public class g implements Func1<Long, Integer> {
        public g() {
        }

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer call(Long l) {
            if (a.this.f929d == null || !a.this.f929d.h()) {
                return Integer.valueOf(e.c.a.g.a.d.x.f.d());
            }
            return -1;
        }
    }

    public a(@NonNull WatchLyricView watchLyricView) {
        this.f930e = true;
        this.a = watchLyricView;
        watchLyricView.setTextSize(l1.c(16.0f));
        watchLyricView.setCellRowMargin(l1.c(8.0f));
        watchLyricView.setTextHighLightColor(watchLyricView.getResources().getColor(R.color.auto_ht));
        watchLyricView.setCanSlide(true);
        watchLyricView.setCellClickEnable(false);
        watchLyricView.setCellLongClickEnable(false);
        watchLyricView.setCellAlignMode(0);
        watchLyricView.setFadeMode(true);
        watchLyricView.setDefaultMsg(KGApplication.getContext().getString(R.string.kugou_short_slogan));
        watchLyricView.setMaxRows(3);
        watchLyricView.setStroke(false);
        watchLyricView.setIsBoldText(true);
        watchLyricView.setOnLyricSlideListener(new C0139a(this));
        this.f930e = g();
        watchLyricView.setOnLyricDataLoadListener(new b());
        LyricManager lyricManager = LyricManager.getInstance();
        this.b = lyricManager;
        lyricManager.addLyricView(watchLyricView);
    }

    public void f(View view) {
        e.c.a.g.a.g.j.d.b bVar = new e.c.a.g.a.g.j.d.b(view);
        this.f929d = bVar;
        bVar.n(0.003f);
        this.f929d.l(RecyclerView.MAX_SCROLL_DURATION);
        this.f929d.m(new c());
        this.f929d.k(new d());
    }

    public final boolean g() {
        return e.c.a.g.a.f.e.c.c().getConfigAsInt(e.c.a.g.a.f.e.b.F1, 1) == 1;
    }

    public void h() {
        i();
        e.c.a.g.a.g.j.d.b bVar = this.f929d;
        if (bVar != null) {
            bVar.i();
        }
        this.b.removeLyricView(this.a);
    }

    public void i() {
        i1.a(this.c);
        this.c = null;
        this.a.release();
        this.a.updateView();
    }

    public void j(LyricData lyricData, boolean z) {
        if (e.c.a.g.a.d.x.f.r()) {
            i();
            return;
        }
        this.b.setLyricData(lyricData);
        if (lyricData != null) {
            k(z);
        }
    }

    public void k(boolean z) {
        if (!z) {
            i1.a(this.c);
            this.c = null;
        } else if (this.c == null) {
            this.c = Observable.interval(200L, TimeUnit.MILLISECONDS).map(new g()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(), new f());
        }
    }
}
