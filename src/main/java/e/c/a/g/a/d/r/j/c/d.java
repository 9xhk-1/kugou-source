package e.c.a.g.a.d.r.j.c;

import android.content.DialogInterface;
import android.view.KeyEvent;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.activity.AbsFrameworkActivity;
import com.kugou.android.watch.lite.common.music.entity.KGMusic;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import e.c.a.g.a.s.p1;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class d extends e.c.a.g.a.d.r.j.c.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public DialogInterface.OnKeyListener f489h;

    public class a implements Runnable {
        public final /* synthetic */ boolean a;

        public a(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.k(this.a);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.k(true);
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.hideLoadingView();
        }
    }

    /* JADX INFO: renamed from: e.c.a.g.a.d.r.j.c.d$d, reason: collision with other inner class name */
    public class DialogInterfaceOnKeyListenerC0073d implements DialogInterface.OnKeyListener {
        public DialogInterfaceOnKeyListenerC0073d() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
            if (i2 != 4 || keyEvent.getAction() != 0) {
                return false;
            }
            d.this.hideLoadingView();
            d.this.b.callFinish();
            return false;
        }
    }

    public d(e.c.a.g.a.d.r.n.d dVar) {
        super(dVar);
        this.f489h = new DialogInterfaceOnKeyListenerC0073d();
        dVar.M(this);
    }

    @Override // e.c.a.g.a.d.r.j.d.d, e.c.a.g.a.d.r.n.g
    public List<e.c.a.g.a.d.r.n.a<?>> doCalaulatePrice(int i2) {
        List<e.c.a.g.a.d.r.n.a<?>> multipleTypeResourceDatas = this.b.getMultipleTypeResourceDatas(8);
        if (multipleTypeResourceDatas == null || multipleTypeResourceDatas.size() <= 0 || this.f490e) {
            return null;
        }
        return this.b.doCalaulatePrice(multipleTypeResourceDatas, i2);
    }

    public void g() {
        e.c.a.g.a.d.r.j.d.a aVar = this.b;
        if (aVar != null) {
            aVar.runOnUIThread(new c());
        }
    }

    @Override // e.c.a.g.a.d.r.j.d.d, e.c.a.g.a.d.r.n.g
    public AbsFrameworkActivity getActivity() {
        return this.c;
    }

    public void h(String str) {
    }

    @Override // e.c.a.g.a.d.r.j.d.c, e.c.a.g.a.d.r.j.d.d, e.c.a.g.a.d.r.n.g
    public void hideLoadingView() {
        AbsFrameworkActivity absFrameworkActivity = this.c;
        if (absFrameworkActivity != null) {
            absFrameworkActivity.d();
        }
    }

    public void i() {
        e.c.a.g.a.d.r.j.d.a aVar = this.b;
        if (aVar != null) {
            aVar.runOnUIThread(new b());
        }
    }

    public void j(boolean z) {
        this.b.runOnUIThread(new a(z));
    }

    public final void k(boolean z) {
        AbsFrameworkActivity absFrameworkActivity = this.c;
        if (absFrameworkActivity != null) {
            absFrameworkActivity.m(R.string.waiting, this.f489h);
        }
    }

    @Override // e.c.a.g.a.d.r.j.c.g, e.c.a.g.a.d.r.j.c.e, e.c.a.g.a.d.r.j.d.c
    public void onCreate() {
        super.onCreate();
        if (isStartWithoutLoading()) {
            return;
        }
        showLoadingView();
    }

    @Override // e.c.a.g.a.d.r.j.d.d, e.c.a.g.a.d.r.n.g
    public void runOnUIThread(Runnable runnable) {
        this.b.runOnUIThread(runnable);
    }

    @Override // e.c.a.g.a.d.r.j.d.d, e.c.a.g.a.d.r.n.g
    public void showAlbumDialog() {
        p1.h(this.c, "本歌曲为付费歌曲，请登录手机端购买歌曲后下载~");
    }

    @Override // e.c.a.g.a.d.r.j.d.d, e.c.a.g.a.d.r.n.g
    public void showDownChangSongDialog() {
    }

    @Override // e.c.a.g.a.d.r.j.d.d, e.c.a.g.a.d.r.n.g
    public void showListenDialog(int i2, e.c.a.g.a.d.r.p.a.c cVar) {
    }

    @Override // e.c.a.g.a.d.r.j.d.d, e.c.a.g.a.d.r.n.g
    public void showListenForrbiddonDialog(KGMusic kGMusic) {
        g();
    }

    @Override // e.c.a.g.a.d.r.j.d.d, e.c.a.g.a.d.r.n.g
    public void showListenLocalEncrypt(int i2, long j, int i3) {
    }

    @Override // e.c.a.g.a.d.r.j.d.d, e.c.a.g.a.d.r.n.g
    public void showListenPartStrengthenDialog(int i2, e.c.a.g.a.d.r.p.a.c cVar, KGMusicWrapper kGMusicWrapper) {
        if (cVar == null) {
            finish();
        }
    }

    @Override // e.c.a.g.a.d.r.j.d.d, e.c.a.g.a.d.r.n.g
    public void showLoadingView() {
        k(true);
    }

    @Override // e.c.a.g.a.d.r.j.d.d, e.c.a.g.a.d.r.n.g
    public void showNoSupportSingleBuy(String str) {
        finish();
    }

    @Override // e.c.a.g.a.d.r.j.d.d, e.c.a.g.a.d.r.n.g
    public void showQualityFeeDialog(int i2, int i3, int i4, String str) {
    }
}
