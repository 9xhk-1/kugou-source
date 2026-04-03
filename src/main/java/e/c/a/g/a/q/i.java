package e.c.a.g.a.q;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.appcompat.widget.ActivityChooserModel;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import com.kugou.android.watch.lite.component.SplashActivity;
import com.kugou.common.apm.task.ShareSongAPM;
import com.xtc.shareapi.share.communication.SendMessageToXTC;
import com.xtc.shareapi.share.manager.ShareMessageManager;
import com.xtc.shareapi.share.shareobject.XTCAppExtendObject;
import com.xtc.shareapi.share.shareobject.XTCShareMessage;
import com.xtc.shareapi.share.sharescene.Chat;
import e.c.a.g.a.s.a0;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.i1;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.p1;
import e.c.a.g.a.s.t;
import f.z.d.j;
import f.z.d.k;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends e.c.a.g.a.q.c {
    public final f.d b;
    public Subscription c;

    public static final class a<T, R> implements Func1 {
        public a() {
        }

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Bitmap call(String str) {
            Bitmap bitmap = !(str == null || str.length() == 0) ? (Bitmap) Glide.with(i.this.a).asBitmap().load(a0.e(str)).diskCacheStrategy(DiskCacheStrategy.ALL).submit(Integer.MIN_VALUE, Integer.MIN_VALUE).get() : null;
            return bitmap == null ? BitmapFactory.decodeResource(i.this.a.getResources(), R.drawable.icon) : bitmap;
        }
    }

    public static final class b<T> implements Action1 {
        public final /* synthetic */ ShareSongAPM b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ KGMusicWrapper f1157d;

        public b(ShareSongAPM shareSongAPM, KGMusicWrapper kGMusicWrapper) {
            this.b = shareSongAPM;
            this.f1157d = kGMusicWrapper;
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(Bitmap bitmap) {
            if (bitmap != null) {
                i.this.c(this.f1157d, bitmap, this.b);
            } else {
                p1.h(i.this.a, "封面获取失败，请重试");
                ShareSongAPM.fail$default(this.b, 6, "封面获取失败", null, 4, null);
            }
        }
    }

    public static final class c<T> implements Action1 {
        public final /* synthetic */ ShareSongAPM b;

        public c(ShareSongAPM shareSongAPM) {
            this.b = shareSongAPM;
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(Throwable th) {
            p1.h(i.this.a, "网络异常，请稍后重试");
            ShareSongAPM.fail$default(this.b, 7, "网络异常，请稍后重试", null, 4, null);
        }
    }

    public static final class d extends k implements f.z.c.a<ShareMessageManager> {
        public final /* synthetic */ Activity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Activity activity) {
            super(0);
            this.a = activity;
        }

        @Override // f.z.c.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ShareMessageManager invoke() {
            return new ShareMessageManager(this.a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(Activity activity) {
        super(activity);
        j.e(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        this.b = f.f.b(new d(activity));
    }

    public final ShareMessageManager b() {
        return (ShareMessageManager) this.b.getValue();
    }

    public final void c(KGMusicWrapper kGMusicWrapper, Bitmap bitmap, ShareSongAPM shareSongAPM) {
        f fVar = new f();
        fVar.a = kGMusicWrapper.getMixId();
        fVar.b = l1.n(KGApplication.getContext());
        XTCAppExtendObject xTCAppExtendObject = new XTCAppExtendObject();
        xTCAppExtendObject.setStartActivity(SplashActivity.class.getName());
        xTCAppExtendObject.setExtInfo(t.c(fVar));
        XTCShareMessage xTCShareMessage = new XTCShareMessage();
        xTCShareMessage.setShareObject(xTCAppExtendObject);
        xTCShareMessage.setThumbImage(bitmap);
        xTCShareMessage.setDescription(kGMusicWrapper.getTrackName() + " - " + ((Object) kGMusicWrapper.getArtistName()));
        SendMessageToXTC.Request request = new SendMessageToXTC.Request();
        request.setMessage(xTCShareMessage);
        request.setFlag(0);
        Chat chat = new Chat();
        chat.setFriendType(17);
        request.setScene(chat);
        b().sendRequestToXTC(request, "38E4C91D79FDACC3A2DA4693660F06C3");
        g.a = Long.valueOf(fVar.a);
        if (g0.a) {
            g0.b("XtcSongShareImpl", j.l("shareInner: ", xTCShareMessage));
        }
    }

    @Override // e.c.a.g.a.q.d
    public boolean isShareEnable() {
        return l1.m0() && b().checkBaseVersion(1);
    }

    @Override // e.c.a.g.a.q.c, e.c.a.g.a.q.d
    public void onDestroy() {
        super.onDestroy();
        i1.a(this.c);
    }

    @Override // e.c.a.g.a.q.d
    public void share(KGMusicWrapper kGMusicWrapper, ShareSongAPM shareSongAPM) {
        j.e(kGMusicWrapper, "current");
        j.e(shareSongAPM, "shareSongAPM");
        i1.a(this.c);
        this.c = Observable.just(kGMusicWrapper.getImgUrl()).subscribeOn(Schedulers.io()).map(new a()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(shareSongAPM, kGMusicWrapper), new c(shareSongAPM));
    }
}
