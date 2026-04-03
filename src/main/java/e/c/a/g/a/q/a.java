package e.c.a.g.a.q;

import android.R;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.appcompat.widget.ActivityChooserModel;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.base.main.MainFragmentContainer;
import com.kugou.android.watch.lite.base.player.Initiator;
import com.kugou.android.watch.lite.bi.YoungBITask;
import com.kugou.android.watch.lite.common.music.entity.KGMusic;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import com.kugou.android.watch.lite.component.MainActivity;
import com.kugou.common.apm.sdk.ApmDataKey;
import com.kugou.common.event.ShareSongStatusItemEvent;
import com.kugou.datacollect.bi.use.TraceFullTask;
import com.xtc.shareapi.share.communication.BaseResponse;
import com.xtc.shareapi.share.communication.ShowMessageFromXTC;
import com.xtc.shareapi.share.interfaces.IResponseCallback;
import com.xtc.shareapi.share.manager.XTCCallbackImpl;
import e.c.a.g.a.g.i.b;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.i1;
import e.c.a.g.a.s.j0;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.p1;
import e.c.a.g.a.s.t;
import e.c.a.g.a.s.u0;
import f.u.m;
import f.u.u;
import f.z.d.j;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements IResponseCallback {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C0174a f1156d = new C0174a(null);
    public final MainActivity a;
    public Subscription b;
    public long c;

    /* JADX INFO: renamed from: e.c.a.g.a.q.a$a, reason: collision with other inner class name */
    public static final class C0174a {
        public C0174a() {
        }

        public /* synthetic */ C0174a(f.z.d.g gVar) {
            this();
        }

        public final String a(BaseResponse baseResponse) {
            j.e(baseResponse, "response");
            int code = baseResponse.getCode();
            String str = null;
            if (code == 5) {
                str = "暂不支持的操作";
            } else if (code == 11) {
                str = "暂无可分享好友";
            } else if (code == 15) {
                str = "分享太频繁了，稍后再试试吧";
            } else if (code == 18) {
                str = "暂无分享权限";
            } else if (code != 100) {
                if (code == 7) {
                    str = "转换异常，请稍后重试";
                } else if (code == 8) {
                    str = "网络异常，请稍后重试";
                } else if (code == 9) {
                    str = "token异常";
                }
            } else if (!u0.m(KGApplication.getContext())) {
                str = "网络异常，分享失败";
            }
            if (!(str == null || str.length() == 0)) {
                return str;
            }
            return "分享错误码(" + baseResponse.getCode() + ')';
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ f b;

        public b(f fVar) {
            this.b = fVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a.this.f(this.b);
        }
    }

    public static final class c<T, R> implements Func1 {
        public final /* synthetic */ MainFragmentContainer b;

        public c(MainFragmentContainer mainFragmentContainer) {
            this.b = mainFragmentContainer;
        }

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object call(Long l) {
            List<e.c.a.g.a.d.r.p.a.c> listD;
            List<KGMusicWrapper> listK = e.c.a.g.a.d.x.f.k();
            if (!(listK == null || listK.isEmpty())) {
                Iterator<KGMusicWrapper> it = listK.iterator();
                int i2 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i2 = -1;
                        break;
                    }
                    if (l != null && it.next().getMixId() == l.longValue()) {
                        break;
                    }
                    i2++;
                }
                if (i2 >= 0) {
                    return Integer.valueOf(i2);
                }
            }
            j.d(l, "mixId");
            e.c.a.g.a.g.i.b bVarH = e.c.a.g.a.g.i.c.h(l.longValue());
            e.c.a.g.a.d.r.p.a.c cVar = null;
            b.C0138b c0138bC = bVarH == null ? null : bVarH.c();
            b.a aVarB = bVarH == null ? null : bVarH.b();
            if (bVarH == null || c0138bC == null || aVarB == null) {
                return null;
            }
            KGMusic kGMusicD = a.this.d(bVarH, aVarB, c0138bC);
            if (e.c.a.g.a.g.o.b.f(kGMusicD)) {
                return Boolean.TRUE;
            }
            KGMusicWrapper kGMusicWrapperD = e.c.a.g.a.f.j.a.c.d(kGMusicD, Initiator.create(this.b.m()).carryPagePath(this.b.n()));
            e.c.a.g.a.d.r.p.a.g gVarJ = e.c.a.g.a.d.r.g.J(kGMusicWrapperD);
            e.c.a.g.a.d.r.p.a.h hVar = new e.c.a.g.a.d.r.p.a.h();
            hVar.b = "audio";
            e.c.a.g.a.d.r.p.a.a aVarF = new e.c.a.g.a.d.r.p.b.e().f(hVar, "play", 0, m.c(gVarJ), 0);
            if (aVarF != null && (listD = aVarF.d()) != null) {
                cVar = (e.c.a.g.a.d.r.p.a.c) u.v(listD);
            }
            if (cVar != null) {
                Log.e("试听片段兼容", j.l("goods=", cVar));
                KGMusic kgmusic = kGMusicWrapperD.getKgmusic();
                if (kgmusic != null) {
                    kgmusic.setMusicTransParamEnenty(cVar.r());
                }
                if (cVar.F()) {
                    kGMusicWrapperD.setHashOffset(cVar.l());
                }
            }
            return kGMusicWrapperD;
        }
    }

    public static final class d<T> implements Action1 {
        public final /* synthetic */ MainFragmentContainer b;

        /* JADX INFO: renamed from: e.c.a.g.a.q.a$d$a, reason: collision with other inner class name */
        public static final class RunnableC0175a implements Runnable {
            public final /* synthetic */ Object a;

            public RunnableC0175a(Object obj) {
                this.a = obj;
            }

            @Override // java.lang.Runnable
            public final void run() {
                e.c.a.g.a.d.x.f.z(((Number) this.a).intValue(), true);
            }
        }

        public d(MainFragmentContainer mainFragmentContainer) {
            this.b = mainFragmentContainer;
        }

        @Override // rx.functions.Action1
        public final void call(Object obj) {
            if (g0.a) {
                g0.b("AppShareHandler", j.l("playSong: data=", obj));
            }
            if (a.this.a.isFinishing() || a.this.a.isDestroyed() || !a.this.a.j()) {
                return;
            }
            a.this.a.d();
            if (obj instanceof Integer) {
                j0.b().a(new RunnableC0175a(obj));
                a.this.a.f().F0(true);
                return;
            }
            if (obj instanceof KGMusicWrapper) {
                LinkedList linkedList = new LinkedList();
                linkedList.add(obj);
                if (e.c.a.g.a.d.x.f.r()) {
                    e.c.a.g.a.d.x.f.y(true, linkedList, 0, true, this.b.l());
                    return;
                } else {
                    e.c.a.g.a.d.x.f.l(true, linkedList, true, this.b.l());
                    return;
                }
            }
            if ((obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
                String config = e.c.a.g.a.f.e.c.a.a().getConfig(e.c.a.g.a.f.e.b.d3);
                if (config.length() == 0) {
                    config = "该歌曲已下架";
                }
                p1.f(KGApplication.getContext(), config);
            }
        }
    }

    public static final class e<T> implements Action1 {
        public e() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(Throwable th) {
            if (a.this.a.j()) {
                a.this.a.d();
                p1.h(KGApplication.getContext(), "网络异常，歌曲插播失败");
            }
        }
    }

    public a(MainActivity mainActivity) {
        j.e(mainActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        this.a = mainActivity;
    }

    public final KGMusic d(e.c.a.g.a.g.i.b bVar, b.a aVar, b.C0138b c0138b) {
        KGMusic kGMusic = new KGMusic();
        kGMusic.setHashType(300);
        if (TextUtils.isEmpty(c0138b.h())) {
            kGMusic.setHashValue(c0138b.g());
            kGMusic.setSize(c0138b.a());
        } else {
            kGMusic.setHashValue(c0138b.h());
            kGMusic.setSize(c0138b.b());
        }
        kGMusic.setHash320(c0138b.i());
        kGMusic.setSize320(c0138b.c());
        if (!TextUtils.isEmpty(c0138b.k())) {
            kGMusic.setSqHash(c0138b.k());
            kGMusic.setSqSize(c0138b.e());
        } else if (!TextUtils.isEmpty(c0138b.j())) {
            kGMusic.setSqHash(c0138b.j());
            kGMusic.setSqSize(c0138b.d());
        }
        kGMusic.setImgUrl(aVar.c());
        kGMusic.setAlbumID(aVar.a());
        kGMusic.setFeeAlbumId(String.valueOf(aVar.a()));
        kGMusic.setAlbumName(aVar.b());
        kGMusic.setTrackName(bVar.d());
        kGMusic.setArtistName(bVar.h());
        kGMusic.setMixId(bVar.a());
        kGMusic.setDisplayName(bVar.d() + " - " + ((Object) bVar.h()));
        return kGMusic;
    }

    public final void e(Intent intent) {
        if (g0.a) {
            g0.b("AppShareHandler", "handleIntent: ");
        }
        if (l1.m0()) {
            new XTCCallbackImpl().handleIntent(intent, this);
        }
    }

    public final void f(f fVar) {
        MainFragmentContainer mainFragmentContainerA0 = this.a.f().a0();
        if (mainFragmentContainerA0 == null) {
            if (g0.a) {
                g0.b("AppShareHandler", "onReq: invalid fragment");
            }
        } else {
            this.a.n(e.c.a.g.a.d.w.a.g(mainFragmentContainerA0), 4);
            i1.a(this.b);
            this.b = Observable.just(Long.valueOf(fVar.a)).subscribeOn(Schedulers.io()).map(new c(mainFragmentContainerA0)).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(mainFragmentContainerA0), new e());
        }
    }

    public final void g(int i2, Integer num) {
        TraceFullTask svar1 = new YoungBITask(22020012, "statistics").append(ApmDataKey.STATE, String.valueOf(i2)).setSvar1(num == null ? null : num.toString());
        Long l = g.a;
        e.c.a.g.a.e.b.b(svar1.setMixsongid(l != null ? String.valueOf(l) : null));
    }

    @Override // com.xtc.shareapi.share.interfaces.IResponseCallback
    public void onReq(ShowMessageFromXTC.Request request) {
        if (g0.a) {
            g0.b("AppShareHandler", j.l("onReq: ext:", request == null ? null : request.getExtInfo()));
        }
        String extInfo = request != null ? request.getExtInfo() : null;
        if (extInfo == null) {
            return;
        }
        f fVar = (f) t.a(extInfo, f.class);
        if (fVar != null && fVar.a > 0) {
            e.c.a.g.a.e.b.b(new YoungBITask(22020013, "statistics").setMixsongid(String.valueOf(fVar.a)).setSvar1(fVar.b));
            this.a.findViewById(R.id.content).post(new b(fVar));
        } else if (g0.a) {
            g0.b("AppShareHandler", "onReq: invalid data");
        }
    }

    @Override // com.xtc.shareapi.share.interfaces.IResponseCallback
    public void onResp(boolean z, BaseResponse baseResponse) {
        j.e(baseResponse, "response");
        if (g0.a) {
            g0.b("AppShareHandler", "onResp: error(" + baseResponse.getCode() + ", " + ((Object) baseResponse.getErrorDesc()) + ')');
        }
        if (z) {
            g(1, null);
            EventBus.getDefault().post(new ShareSongStatusItemEvent(1, baseResponse));
            return;
        }
        g(0, Integer.valueOf(baseResponse.getCode()));
        if (baseResponse.getCode() == 2) {
            EventBus.getDefault().post(new ShareSongStatusItemEvent(2, baseResponse));
            return;
        }
        EventBus.getDefault().post(new ShareSongStatusItemEvent(0, baseResponse));
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (jElapsedRealtime - this.c > 1000) {
            this.c = jElapsedRealtime;
            new e.c.a.g.a.q.e(this.a, f1156d.a(baseResponse)).show();
        } else if (g0.a) {
            g0.b("AppShareHandler", "onResp: ignore frequent resp");
        }
    }
}
